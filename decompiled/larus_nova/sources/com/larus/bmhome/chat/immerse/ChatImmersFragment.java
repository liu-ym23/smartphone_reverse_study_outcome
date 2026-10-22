package com.larus.bmhome.chat.immerse;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.adapter.FragmentStateAdapterHelper;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.BaseHomeTabFragment;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.bmhome.chat.f4;
import com.larus.bmhome.chat.j4;
import com.larus.bmhome.chat.m4;
import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.databinding.LarusPageChatImmersiveBinding;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.common_ui.widget.RedDotTextView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.service.z2;
import com.larus.utils.FragmentExtKt$addOnBackPressed$callback$1;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000Û\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\n*\u0001j\u0018\u0000 \u009f\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002\u009f\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010F\u001a\u00020\u00192\b\u0010G\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010H\u001a\u00020\u0019H\u0016J\b\u0010M\u001a\u00020\u0019H\u0002J\b\u0010N\u001a\u0004\u0018\u00010OJ\u0010\u0010P\u001a\u0004\u0018\u00010O2\u0006\u0010Q\u001a\u00020#J\b\u0010R\u001a\u00020\u0019H\u0016J&\u0010S\u001a\u0004\u0018\u00010T2\u0006\u0010U\u001a\u00020V2\b\u0010W\u001a\u0004\u0018\u00010X2\b\u0010Y\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010Z\u001a\u00020\u00192\b\u0010Y\u001a\u0004\u0018\u00010\u001fH\u0016J\"\u0010[\u001a\u00020\u00192\u0006\u0010\\\u001a\u00020#2\u0006\u0010]\u001a\u00020#2\b\u0010^\u001a\u0004\u0018\u00010_H\u0016J\b\u0010`\u001a\u00020)H\u0016J\u001a\u0010a\u001a\u00020\u00192\u0006\u0010b\u001a\u00020T2\b\u0010Y\u001a\u0004\u0018\u00010\u001fH\u0017J\b\u0010c\u001a\u00020\u0019H\u0002J\b\u0010d\u001a\u00020\u0019H\u0002J\b\u0010e\u001a\u00020\u0019H\u0002J\b\u0010f\u001a\u00020\u0019H\u0002J\u0006\u0010g\u001a\u00020\u0019J\b\u0010h\u001a\u00020\u0019H\u0002J\r\u0010i\u001a\u00020jH\u0002¢\u0006\u0002\u0010kJ\b\u0010l\u001a\u00020\u0019H\u0002J\b\u0010m\u001a\u00020\u0019H\u0002J\u0010\u0010n\u001a\u00020K2\u0006\u0010^\u001a\u00020oH\u0002J\u001f\u0010p\u001a\u00020\u00192\u0017\u0010q\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00190\u0017¢\u0006\u0002\brJ\b\u0010s\u001a\u00020\u0019H\u0002J\u0006\u0010t\u001a\u00020\u0019J\u000e\u0010u\u001a\u00020\u00192\u0006\u0010v\u001a\u00020#J\u000e\u0010w\u001a\u00020\u00192\u0006\u0010x\u001a\u00020#J\u0010\u0010y\u001a\u00020#2\u0006\u0010z\u001a\u00020#H\u0002J\b\u0010{\u001a\u00020\u0019H\u0002J\b\u0010|\u001a\u00020\u0019H\u0002J\b\u0010}\u001a\u00020\u0019H\u0002J$\u0010~\u001a\b\u0012\u0004\u0012\u00020\u001f0\u007f2\r\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020o0\u007fH\u0082@¢\u0006\u0003\u0010\u0081\u0001J\u0007\u0010\u0082\u0001\u001a\u00020#J\t\u0010\u0083\u0001\u001a\u00020KH\u0016J\t\u0010\u0084\u0001\u001a\u00020KH\u0002J\t\u0010\u0085\u0001\u001a\u00020\u0019H\u0016J\u0007\u0010\u0086\u0001\u001a\u00020KJ\u0014\u0010\u0087\u0001\u001a\u0004\u0018\u00010o2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010KJ\f\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u0001H\u0002J\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010KJ\t\u0010\u008c\u0001\u001a\u00020#H\u0016J\u0014\u0010\u008d\u0001\u001a\u00020\u00192\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010KH\u0016J\t\u0010\u008f\u0001\u001a\u00020\u0019H\u0016J\"\u0010\u0090\u0001\u001a\u00020\u00192\u0007\u0010\u0091\u0001\u001a\u00020)2\u000e\u00106\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u000107H\u0016J:\u0010\u0092\u0001\u001a\u00020\u00192\u0007\u0010\u0093\u0001\u001a\u00020)2\u0017\u0010\u0094\u0001\u001a\u0012\u0012\u0004\u0012\u00020K\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010\u0095\u00012\r\u0010\u0097\u0001\u001a\b\u0012\u0004\u0012\u00020\u001907H\u0016J\u0012\u0010\u0098\u0001\u001a\u00020\u00192\u0007\u0010\u0099\u0001\u001a\u00020KH\u0016J\u0014\u0010\u009a\u0001\u001a\u00020\u00192\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010KH\u0016J\u0010\u0010\u009c\u0001\u001a\u00020\u00192\u0007\u0010\u009d\u0001\u001a\u00020)J\t\u0010\u009e\u0001\u001a\u00020KH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR&\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00190\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00101\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0016\u00106\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010:\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00103\"\u0004\b<\u00105R\u001a\u0010=\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00103\"\u0004\b>\u00105R\u001a\u0010?\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u00103\"\u0004\bA\u00105R\u001b\u0010B\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\u000f\u001a\u0004\bB\u00103R\u000e\u0010D\u001a\u00020EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 \u0001"}, d2 = {"Lcom/larus/bmhome/chat/immerse/ChatImmersFragment;", "Lcom/larus/bmhome/BaseHomeTabFragment;", "Lcom/larus/common_ui/tab/TabChildFragment;", "Lcom/larus/bmhome/chat/IChatLeave;", "Lcom/larus/bmhome/chat/share/IChatPageShareable;", "Lcom/larus/bmhome/chat/ITraceFragment;", "<init>", "()V", "binding", "Lcom/larus/bmhome/databinding/LarusPageChatImmersiveBinding;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/bmhome/chat/immerse/ChatImmersViewModel;", "getModel", "()Lcom/larus/bmhome/chat/immerse/ChatImmersViewModel;", "model$delegate", "Lkotlin/Lazy;", "adapter", "Lcom/larus/bmhome/chat/immerse/ChatImmersViewPagerAdapter;", "animProcessor", "Lcom/larus/bmhome/chat/immerse/ChatImmersProcessor;", "onBackPressCallBack", "Landroidx/activity/OnBackPressedCallback;", "onBackFromChatTabInterceptor", "Lkotlin/Function1;", "Landroidx/fragment/app/Fragment;", "", "getOnBackFromChatTabInterceptor", "()Lkotlin/jvm/functions/Function1;", "setOnBackFromChatTabInterceptor", "(Lkotlin/jvm/functions/Function1;)V", "onImmerseRecreate", "Landroid/os/Bundle;", "getOnImmerseRecreate", "setOnImmerseRecreate", "bottomTabVIewHeight", "", "getBottomTabVIewHeight", "()I", "setBottomTabVIewHeight", "(I)V", "intercept", "", "curPosition", "maxScrollPosition", "lastOffset", "", "lastY", "lastX", "isLoading", "botDiscoveryNow", "getBotDiscoveryNow", "()Z", "setBotDiscoveryNow", "(Z)V", "callback", "Lkotlin/Function0;", "firstClick", "lastItemCount", "singleMode", "getSingleMode", "setSingleMode", "isShow", "setShow", "disableSetBackgroundColor", "getDisableSetBackgroundColor", "setDisableSetBackgroundColor", "isUnreadDotEnable", "isUnreadDotEnable$delegate", "fpsTracer", "Lcom/bytedance/apm/trace/fps/FpsTracer;", "onNewIntent", "bundle", "onResume", "order", "lastBotId", "", "currentBotId", "handleStatusBarMode", "getCurrentFragment", "Lcom/larus/bmhome/chat/ChatFragment;", "getFragmentByPosition", "position", "onPause", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", WidgetCostModule.TYPE_ON_CREATE, "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "autoLogEnterPage", "onViewCreated", "view", "showRetryView", "hideRetryView", "showLoadingView", "hideLoadingView", "updateBotList", "showLoadingInvisibleAnim", "onPageChangeCallback", "com/larus/bmhome/chat/immerse/ChatImmersFragment$onPageChangeCallback$1", "()Lcom/larus/bmhome/chat/immerse/ChatImmersFragment$onPageChangeCallback$1;", "startScroll", "stopScroll", "getChatType", "Lcom/larus/bmhome/chat/bean/RecommendBot;", "safeNotify", "action", "Lkotlin/ExtensionFunctionType;", "showTitle", "hideTitle", "setRedDotUnreadCount", "count", "setRedDotBGType", "type", "calcuDistance", "delta", "initAnimProcessor", "initViewModel", "slideLoading", "dataProcessor", "", "list", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkLocalNightMode", "getCurrentPageName", "getEnterMethod", LiveCommonConstants.REASON_ON_DEDTROY, "getPreviousPage", "getCurrentRecommendBot", "botId", "originRecommendFrom", "Lcom/larus/platform/model/RecommendFrom;", "recommendFrom", "tabIndex", "onEnterTab", "previousPage", "onLeaveTab", "onTabClick", "doubleClick", "onMessageShareMode", "shareMode", "ext", "", "", "onCloseClick", "leaveChat", "methodName", "reportEnterPage", "pageName", "setUserInputEnabled", "enabled", "scene", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatImmersFragment extends BaseHomeTabFragment implements s19.a, f4, xi8.a, m4 {
    public static final /* synthetic */ int I = 0;
    public int A;
    public boolean B;
    public boolean C;
    public boolean D;
    public final Lazy E;
    public final et3.c F;
    public String G;
    public String H;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LarusPageChatImmersiveBinding f303184j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f303185k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ChatImmersViewPagerAdapter f303186l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public a0 f303187m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public FragmentExtKt$addOnBackPressed$callback$1 f303188n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Function1<? super Fragment, Unit> f303189o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Function1<? super Bundle, Unit> f303190p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f303191q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f303192r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f303193s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f303194t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f303195u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f303196v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f303197w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f303198x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Function0<Unit> f303199y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f303200z;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f303201a;

        public b(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f303201a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f303201a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f303201a.invoke(r100);
        }
    }

    static {
    }

    public ChatImmersFragment() {
        super(true);
        final Function0<Fragment> r100 = new ChatImmersFragment$special$$inlined$viewModels$default$1(this);
        this.f303185k = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ChatImmersViewModel.class), new ChatImmersFragment$special$$inlined$viewModels$default$2(r100), new ChatImmersFragment$special$$inlined$viewModels$default$3(r100, this));
        this.f303190p = new k();
        this.f303200z = true;
        this.E = LazyKt.lazy(new l(this));
        this.F = new et3.c("chat_immersive_feed", false, null);
    }

    @Override // com.larus.bmhome.chat.f4
    public final void Bv(String r100) {
    }

    @Override // com.larus.trace.tracknode.TraceFragment
    public final boolean S90() {
        return false;
    }

    @Override // s19.a
    public final void a2(Bundle r100) {
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "immersive";
    }

    @Override // com.larus.bmhome.chat.m4
    public final String scene() {
        return "CHAT_MESSAGE_LIST_IMMERSE";
    }

    @Override // s19.a
    public final void t1() {
    }

    @Override // s19.a
    public final void y2(String r100) {
    }

    public final ChatFragment Z90() {
        LarusPageChatImmersiveBinding r100 = this.f303184j;     // Catch: Exception -> L16
        if (r100 == null) goto L21;
        ViewPager2 r101 = r100.f311150c;     // Catch: Exception -> L16
        if (r101 == null) goto L22;
        int r102 = r101.getCurrentItem();     // Catch: Exception -> L16
        FragmentManager r103 = getChildFragmentManager();     // Catch: Exception -> L16
        StringBuilder r104 = new StringBuilder("f");     // Catch: Exception -> L16
        ChatImmersViewPagerAdapter r105 = this.f303186l;     // Catch: Exception -> L16
        if (r105 == null) goto L10;
        Long r106 = Long.valueOf(r105.getItemId(r102));     // Catch: Exception -> L16
    L11:
        r104.append(r106);     // Catch: Exception -> L16
        Fragment r107 = r103.findFragmentByTag(r104.toString());     // Catch: Exception -> L16
        if ((r107 instanceof ChatFragment) == false) goto L23;
        return (ChatFragment) r107;
    L23:
        return null;
    L10:
        r106 = null;
        goto L11
    L22:
        return null;
    L21:
        return null;
    L16:
        e = move-exception;
        FLogger.f375446a.e("ChatImmersFragment", "getCurrentFragment error e=" + e.getMessage());
        return null;
    }

    public final ChatImmersViewModel ba0() {
        return (ChatImmersViewModel) this.f303185k.getValue();
    }

    public final String ca0() {
        int r100 = j1.f303285a;
        boolean r101 = this.f303198x;
        String r102 = b();
        Bundle r103 = getArguments();
        if (r103 == null) goto L6;
        String r104 = r103.getString("enter_method", "");
        if (r104 == null) goto L6;
    L7:
        Bundle r105 = getArguments();
        String r106 = null;
        if (r105 == null) goto L10;
        RecommendFrom r107 = (RecommendFrom) r105.getParcelable("argBotRecommendFrom");
    L11:
        Intrinsics.checkNotNullParameter(r102, "previousPage");
        Intrinsics.checkNotNullParameter(r104, "enterMethod");
        if (r107 == null) goto L15;
        return r107.f365482a + "_immersive";
    L15:
        if (r101 == false) goto L18;
        return "bot_list_discover_immersive";
    L18:
        if (Intrinsics.areEqual(r102, "chat_list") == false) goto L23;
        if (Intrinsics.areEqual(r104, "chatlist_board") == false) goto L23;
        r106 = "chatlist_board_immersive";
    L51:
        return r106;
    L23:
        if (Intrinsics.areEqual(r102, "chat_list") == false) goto L28;
        if (Intrinsics.areEqual(r104, "click_chat") == false) goto L28;
        r106 = "chat_list_immersive";
    L28:
        if (Intrinsics.areEqual(r102, "bot_list_discovery") == false) goto L33;
        if (Intrinsics.areEqual(r104, "click_chat") == false) goto L33;
        r106 = "bot_list_discover_immersive";
    L33:
        if (Intrinsics.areEqual(r102, "bot_list_discover_search") == false) goto L38;
        if (Intrinsics.areEqual(r104, "click_chat") == false) goto L38;
        r106 = "bot_list_discover_search_immersive";
    L38:
        if (Intrinsics.areEqual(r102, "bot_list_others") == false) goto L43;
        if (Intrinsics.areEqual(r104, "click_chat") == false) goto L43;
        r106 = "bot_list_others_immersive";
    L43:
        if (Intrinsics.areEqual(r102, "bot_list_profile") == false) goto L48;
        if (Intrinsics.areEqual(r104, "click_chat") == false) goto L48;
        r106 = "bot_list_profile_immersive";
    L48:
        if (Intrinsics.areEqual(r102, "notify") == false) goto L51;
        r106 = "notify_immersive";
        goto L51
    L10:
        r107 = null;
    L6:
        r104 = "unknown";
        goto L7
    }

    public final void da0() {
        i0 r100 = i0.f303282a;
        if (i0.f303283b == true) goto L5;
        return;
    L5:
        LarusPageChatImmersiveBinding r101 = this.f303184j;
        boolean r102 = false;
        if (r101 == null) goto L12;
        ViewPager2 r103 = r101.f311150c;
        if (r103 == null) goto L12;
        if (r103.isFakeDragging() != true) goto L12;
        r102 = true;
    L12:
        if (r102 == false) goto L18;
        LarusPageChatImmersiveBinding r104 = this.f303184j;
        if (r104 == null) goto L18;
        ViewPager2 r105 = r104.f311150c;
        if (r105 == null) goto L18;
        r105.endFakeDrag();
    L18:
        LarusPageChatImmersiveBinding r106 = this.f303184j;
        if (r106 == null) goto L22;
        r106.f311150c.setCurrentItem(this.f303193s - 1);
        return;
    }

    public final void hideLoadingView() {
        AlphaAnimation r100 = new AlphaAnimation(1.0f, 0.0f);
        r100.setDuration(200);
        AnimationSet r101 = new AnimationSet(false);
        r101.addAnimation(r100);
        r101.setAnimationListener(new t(this));
        LarusPageChatImmersiveBinding r102 = this.f303184j;
        if (r102 == null) goto L7;
        ConstraintLayout r103 = r102.f311153f;
        if (r103 == null) goto L7;
        r103.startAnimation(r101);
    L7:
        this.f303197w = false;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        LarusPageChatImmersiveBinding r100 = this.f303184j;
        if (r100 == null) goto L7;
        ViewPager2 r101 = r100.f311150c;
        if (r101 == null) goto L7;
        r101.unregisterOnPageChangeCallback(new ChatImmersFragment$onPageChangeCallback$1(this));
    L7:
        super.onDestroy();
    }

    @Override // s19.a
    public final int sb() {
        return BaseHomeTabFragment.MainTab.DISCOVERY.getIndex();
    }

    public final String b() {
        Bundle r100 = getArguments();
        if (r100 == null) goto L5;
        String r101 = r100.getString("argPreviousPage");
    L6:
        if (r101 != null) goto L8;
    L11:
        boolean r102 = true;
    L13:
        if (r102 == false) goto L19;
        Bundle r103 = getArguments();
        if (r103 == null) goto L26;
        String r104 = r103.getString("previous_page");
        if (r104 != null) goto L25;
        return "";
    L25:
        return r104;
    L26:
        return "";
    L19:
        Bundle r105 = getArguments();
        if (r105 == null) goto L27;
        r104 = r105.getString("argPreviousPage");
        if (r104 != null) goto L25;
        return "";
    L27:
        return "";
    L8:
        if (r101.length() == 0) goto L11;
        r102 = false;
        goto L13
    L5:
        r101 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        this.C = false;
        FragmentExtKt$addOnBackPressed$callback$1 r100 = this.f303188n;
        if (r100 == null) goto L5;
        r100.remove();
    L5:
        int r101 = getResources().getConfiguration().uiMode & 48;
        if (r101 != 16) goto L8;
        FragmentActivity r102 = getActivity();
        if (r102 == null) goto L23;
        com.larus.utils.u.e(r102, true, false);
    L23:
        if ((getActivity() instanceof j4) == true) goto L25;
    L31:
        ChatFragment r103 = Z90();
        if (r103 == null) goto L37;
        com.larus.bmhome.chat.component.trace.z r104 = (com.larus.bmhome.chat.component.trace.z) r103.f296881v.getValue();
        if (r104 == null) goto L38;
        r104.qH();
        return;
    L38:
        return;
    L37:
        return;
    L25:
        if (z2.f365865a.enableChatWithTab() == false) goto L31;
        FragmentActivity r105 = getActivity();
        if (r105 == null) goto L31;
        View r106 = r105.findViewById(R.id.content);
        if (r106 == null) goto L31;
        com.larus.utils.i0.f375410a.getClass();
        int r107 = com.larus.utils.i0.g();
        int r108 = r106.getPaddingStart();
        int r109 = r106.getPaddingEnd();
        int r110 = r106.getPaddingBottom();
        FLogger.f375446a.i("updatePaddingRelative", "view:" + r106.getClass().getSimpleName() + ",source:,start:" + r108 + ",top:" + r107 + ",end:" + r109 + ",bottom:" + r110);
        r106.setPaddingRelative(r108, r107, r109, r110);
        goto L31
    L8:
        if (r101 != 32) goto L31;
        if ((getActivity() instanceof j4) == false) goto L31;
        if (z2.f365865a.enableChatWithTab() == false) goto L31;
        FragmentActivity r111 = getActivity();
        if (r111 == null) goto L31;
        View r112 = r111.findViewById(R.id.content);
        if (r112 == null) goto L31;
        com.larus.utils.i0.f375410a.getClass();
        int r113 = com.larus.utils.i0.g();
        int r114 = r112.getPaddingStart();
        int r115 = r112.getPaddingEnd();
        int r116 = r112.getPaddingBottom();
        FLogger.f375446a.i("updatePaddingRelative", "view:" + r112.getClass().getSimpleName() + ",source:,start:" + r114 + ",top:" + r113 + ",end:" + r115 + ",bottom:" + r116);
        r112.setPaddingRelative(r114, r113, r115, r116);
        goto L31
    }

    @Override // com.larus.bmhome.BaseHomeTabFragment, com.larus.trace.tracknode.TraceFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        ChatFragment r100 = Z90();
        if (r100 == null) goto L9;
        Bundle r101 = r100.Z90();
        if (r101 == null) goto L9;
        r101.putString("argPreviousPage", b());
        if (this.f303198x == false) goto L9;
        r101.putString("argCurrentTab", "bot_list_discover");
        r101.putString("enter_method", "click_tab");
    L9:
        ChatImmersViewModel r102 = ba0();
        if (r102 != null) goto L12;
    L14:
        boolean r103 = false;
    L15:
        if (r103 == false) goto L19;
        ChatImmersViewModel r104 = ba0();
        if (r104 == null) goto L19;
        r104.setEnterTime(AppHost.f326268a.getAppClock().currentTimeMillis());
    L19:
        FragmentActivity r105 = getActivity();
        if (r105 == null) goto L23;
        com.larus.utils.u.e(r105, false, true);
    L23:
        if ((getActivity() instanceof j4) == false) goto L32;
        if (z2.f365865a.enableChatWithTab() == false) goto L32;
        FragmentActivity r106 = getActivity();
        if (r106 == null) goto L32;
        View r107 = r106.findViewById(R.id.content);
        if (r107 == null) goto L32;
        int r108 = r107.getPaddingStart();
        int r109 = r107.getPaddingEnd();
        int r110 = r107.getPaddingBottom();
        FLogger.f375446a.i("updatePaddingRelative", "view:" + r107.getClass().getSimpleName() + ",source:,start:" + r108 + ",top:0,end:" + r109 + ",bottom:" + r110);
        r107.setPaddingRelative(r108, 0, r109, r110);
    L32:
        if (this.D == true) goto L39;
        FragmentActivity r111 = requireActivity();
        if ((r111 instanceof FlowCommonAppCompatActivity) == false) goto L36;
        FlowCommonAppCompatActivity r112 = (FlowCommonAppCompatActivity) r111;
    L37:
        if (r112 == null) goto L39;
        r112.B1(ColorProtector.parseColor("#FF161616"));
        goto L39
    L36:
        r112 = null;
    L39:
        this.f303188n = com.larus.utils.v.a(this, new com.larus.bmhome.chat.immerse.a(this));
        this.C = true;
        return;
    L12:
        if (r102.getEnterTime() != 0) goto L14;
        r103 = true;
        goto L15
    }

    @Override // com.larus.bmhome.chat.f4
    public final void Sk(String r100) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        ChatFragment r101 = Z90();
        if (r101 == null) goto L6;
        r101.aa0(r100);
        return;
    }

    public final ChatFragment aa0(int r100) {
        ChatImmersViewPagerAdapter r101 = this.f303186l;     // Catch: Exception -> L22
        if (r101 == null) goto L8;
        List<Bundle> r102 = r101.z2();     // Catch: Exception -> L22
        if (r102 == null) goto L8;
        int r103 = r102.size();     // Catch: Exception -> L22
    L9:
        if (r100 >= 0) goto L11;
        return null;
    L11:
        if (r100 > (r103 - 1)) goto L28;
        FragmentManager r104 = getChildFragmentManager();     // Catch: Exception -> L22
        StringBuilder r105 = new StringBuilder("f");     // Catch: Exception -> L22
        ChatImmersViewPagerAdapter r106 = this.f303186l;     // Catch: Exception -> L22
        if (r106 == null) goto L16;
        Long r107 = Long.valueOf(r106.getItemId(r100));     // Catch: Exception -> L22
    L17:
        r105.append(r107);     // Catch: Exception -> L22
        Fragment r108 = r104.findFragmentByTag(r105.toString());     // Catch: Exception -> L22
        if ((r108 instanceof ChatFragment) == false) goto L29;
        return (ChatFragment) r108;
    L29:
        return null;
    L16:
        r107 = null;
        goto L17
    L28:
        return null;
    L8:
        r103 = 0;
    L22:
        e = move-exception;
        FLogger.f375446a.e("ChatImmersFragment", "getCurrentFragment error e=" + e.getMessage());
        return null;
    }

    @Override // com.larus.trace.tracknode.TraceFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        FragmentActivity r101 = getActivity();
        if ((r101 instanceof ChatImmersActivity) == false) goto L5;
        ChatImmersActivity r102 = (ChatImmersActivity) r101;
    L6:
        if (r102 == null) goto L8;
        Intrinsics.checkNotNullParameter(this, "chatImmersFragment");
        r102.f303183h = this;
    L8:
        Bundle r103 = getArguments();
        boolean r104 = true;
        if (r103 != null) goto L11;
    L13:
        boolean r105 = false;
    L14:
        this.f303198x = r105;
        Bundle r106 = getArguments();
        if (r106 != null) goto L17;
    L19:
        r104 = false;
    L20:
        this.B = r104;
        return;
    L17:
        if (r106.getBoolean("is_single_mode") != true) goto L19;
    L11:
        if (r103.getBoolean("enter_from_discovery") != true) goto L13;
        r105 = true;
        goto L14
    L5:
        r102 = null;
        goto L6
    }

    @Override // s19.a
    public final void KC(boolean r100, Function0<Unit> r101) {
        this.f303199y = r101;
        ChatImmersViewModel r102 = ba0();     // Catch: Exception -> L7
        if (r102 == null) goto L12;
        r102.refreshFeedData(ca0(), new f());     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        FLogger.f375446a.e("ChatImmersFragment", "There have something wrong e=" + e.getMessage());
    }

    @Override // xi8.a
    public final void NK(boolean r100, com.larus.bmhome.chat.component.share.n0 r101) {
        Intrinsics.checkNotNullParameter(r101, "onCloseClick");
        LarusPageChatImmersiveBinding r102 = this.f303184j;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
        r102.f311150c.setUserInputEnabled(false);
        r102.f311155h.setVisibility(8);
        return;
    L7:
        r102.f311150c.setUserInputEnabled(true);
        r102.f311155h.setVisibility(0);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        z2 r112 = z2.f365865a;
        RecyclerView r100 = null;
        if (r112.a0() == false) goto L5;
        FLogger.f375446a.i("ChatImmersFragment", "view recreate skip");
    L38:
        if (this.f303198x == false) goto L66;
        LarusPageChatImmersiveBinding r113 = this.f303184j;
        if (r113 == null) goto L44;
        AppCompatImageView r114 = r113.f311149b;
        if (r114 == null) goto L44;
        r114.setVisibility(8);
    L44:
        LarusPageChatImmersiveBinding r115 = this.f303184j;
        if (r115 == null) goto L50;
        RedDotTextView r116 = r115.f311151d;
        if (r116 == null) goto L50;
        r116.setVisibility(8);
    L50:
        if (r112.x3().getHideBottomTabDiscovery() == false) goto L56;
        LarusPageChatImmersiveBinding r117 = this.f303184j;
        if (r117 == null) goto L116;
        ImageView r118 = r117.f311152e;
        if (r118 == null) goto L116;
        r118.setVisibility(8);
    L116:
        LarusPageChatImmersiveBinding r119 = this.f303184j;
        if (r119 == null) goto L119;
        this.f303187m = new a0(r119);
    L119:
        ChatImmersViewModel r120 = ba0();
        if (r120 == null) goto L126;
        Bundle r101 = getArguments();
        if (r101 == null) goto L124;
        String r102 = r101.getString("argBotId", null);
    L125:
        r120.setFirstBotId(r102);
        goto L126
    L124:
        r102 = null;
    L126:
        ChatImmersViewModel r121 = ba0();
        if (r121 == null) goto L131;
        MutableLiveData<List<RecommendBot>> r122 = r121.getFeedData();
        if (r122 == null) goto L131;
        r122.observe(getViewLifecycleOwner(), new b(new d(this)));
    L131:
        ChatImmersViewModel r123 = ba0();
        if (r123 == null) goto L138;
        MutableLiveData<Boolean> r124 = r123.getAllowVpOffset();
        if (r124 == null) goto L138;
        LiveData r125 = Transformations.distinctUntilChanged(r124);
        if (r125 == null) goto L138;
        r125.observe(getViewLifecycleOwner(), new b(new e(this)));
    L138:
        final LarusPageChatImmersiveBinding r126 = this.f303184j;
        if (r126 != null) goto L141;
    L178:
        LarusPageChatImmersiveBinding r127 = this.f303184j;
        if (r127 == null) goto L183;
        ConstraintLayout r128 = r127.f311154g;
        if (r128 == null) goto L183;
        com.larus.utils.e1.d(r128, new i(this));
    L183:
        ChatImmersViewModel r129 = ba0();
        if (r129 == null) goto L189;
        MutableLiveData<com.larus.network.http.a<Object>> r130 = r129.getGetData();
        if (r130 == null) goto L189;
        r130.observe(getViewLifecycleOwner(), new b(new j(this)));
    L189:
        if (this.B == true) goto L193;
        ChatImmersViewModel r131 = ba0();
        if (r131 == null) goto L199;
        r131.loadFeedData(ca0(), DowngradeSource.ENTER_CONVERSATION);
    L199:
        if (this.f303198x == false) goto L201;
        return;
    L201:
        if (this.B == true) goto L209;
        ChatImmersViewPagerAdapter r132 = this.f303186l;
        if (r132 != null) goto L205;
        return;
    L205:
        if (r132.f303212b.get() == true) goto L211;
        r132.f303212b.set(true);
        FLogger.f375446a.i("immersAdapter", "showLoading: " + (r132.z2().size() - 1));
        r132.z2().add(com.larus.utils.f.c(new Pair[]{TuplesKt.to("loading", Boolean.TRUE)}));
        r132.f303214d = r132.z2().size() - 1;
        r132.notifyItemInserted(r132.z2().size() - 1);
        return;
    L211:
        return;
    L209:
        return;
    L193:
        LarusPageChatImmersiveBinding r133 = this.f303184j;
        if (r133 == null) goto L199;
        ViewPager2 r134 = r133.f311150c;
        if (r134 == null) goto L199;
        r134.setUserInputEnabled(false);
        goto L199
    L141:
        if ((getActivity() instanceof ChatImmersActivity) == false) goto L143;
    L146:
        ConstraintLayout r135 = r126.f311155h;
        Intrinsics.checkNotNull(r135);
        FragmentActivity r103 = getActivity();
        if (r103 == null) goto L149;
        int r104 = com.larus.utils.u.c(r103);
    L150:
        int r105 = r135.getPaddingStart();
        int r106 = r135.getPaddingEnd();
        int r107 = r135.getPaddingBottom();
        FLogger.f375446a.i("updatePaddingRelative", "view:" + r135.getClass().getSimpleName() + ",source:immers onViewCreated,start:" + r105 + ",top:" + r104 + ",end:" + r106 + ",bottom:" + r107);
        r135.setPaddingRelative(r105, r104, r106, r107);
    L151:
        AppCompatImageView r136 = r126.f311149b;
        if (com.larus.bmhome.b0.b(this) == false) goto L154;
        int r108 = com.larus.nova.R.string.larus_accessibility_icon_backToChatList;
    L155:
        r136.setContentDescription(getString(r108));
        AppCompatImageView r137 = r126.f311149b;
        Context r109 = getContext();
        if (r109 == null) goto L158;
        ColorStateList r138 = ContextCompat.getColorStateList(r109, com.larus.nova.R.color.larus_static_white);
    L159:
        r137.setImageTintList(r138);
        ImageView r139 = r126.f311152e;
        Context r140 = getContext();
        if (r140 == null) goto L162;
        ColorStateList r141 = ContextCompat.getColorStateList(r140, com.larus.nova.R.color.larus_static_white);
    L163:
        r139.setImageTintList(r141);
        ChatImmersViewPagerAdapter r142 = new ChatImmersViewPagerAdapter(this);
        Function1<? super Bundle, Unit> r143 = this.f303190p;
        Intrinsics.checkNotNullParameter(r143, "<set-?>");
        r142.f303216f = r143;
        this.f303186l = r142;
        ViewPager2 r144 = r126.f311150c;
        i0 r145 = i0.f303282a;
        r144.setOrientation(i0.c());
        ChatImmersViewPagerAdapter r146 = this.f303186l;
        if (r146 == null) goto L166;
        ArrayList r147 = new ArrayList();
        Intrinsics.checkNotNullParameter(r147, "<set-?>");
        r146.f303215e = r147;
    L166:
        r126.f311150c.setOffscreenPageLimit(2);
        r126.f311150c.setAdapter(this.f303186l);
        View r148 = r126.f311150c.getChildAt(0);
        if ((r148 instanceof RecyclerView) == false) goto L169;
        RecyclerView r149 = (RecyclerView) r148;
    L170:
        if (r149 == null) goto L172;
        r149.addOnItemTouchListener(new ChatImmersFragment$onViewCreated$1$5(this, r126));
    L172:
        View r150 = r126.f311150c.getChildAt(0);
        if ((r150 instanceof RecyclerView) == false) goto L175;
        r100 = (RecyclerView) r150;
    L175:
        if (r100 == null) goto L177;
        r100.setOnTouchListener(new g(this, r126));
    L177:
        r126.f311150c.post(new h(r126, this));
        goto L178
    L169:
        r149 = null;
        goto L170
    L162:
        r141 = null;
        goto L163
    L158:
        r138 = null;
        goto L159
    L154:
        r108 = com.larus.nova.R.string.larus_accessibility_icon_back;
        goto L155
    L149:
        r104 = 0;
        goto L150
    L143:
        if ((getActivity() instanceof j4) == false) goto L151;
        if (r112.enableChatWithTab() == false) goto L151;
    L56:
        LarusPageChatImmersiveBinding r151 = this.f303184j;
        if (r151 == null) goto L61;
        ImageView r152 = r151.f311152e;
        if (r152 == null) goto L61;
        r152.setVisibility(0);
    L61:
        LarusPageChatImmersiveBinding r153 = this.f303184j;
        if (r153 == null) goto L111;
        ImageView r154 = r153.f311152e;
        if (r154 == null) goto L111;
        com.larus.utils.e1.d(r154, new m(this));
    L111:
        LarusPageChatImmersiveBinding r155 = this.f303184j;
        if (r155 == null) goto L116;
        RedDotTextView r156 = r155.f311151d;
        if (r156 == null) goto L116;
        r156.setDotInvisible(!((Boolean) this.E.getValue()).booleanValue());
        goto L116
    L66:
        LarusPageChatImmersiveBinding r157 = this.f303184j;
        if (r157 == null) goto L72;
        AppCompatImageView r158 = r157.f311149b;
        if (r158 == null) goto L72;
        r158.setVisibility(0);
    L72:
        if (com.larus.bmhome.b0.b(this) == false) goto L92;
        LarusPageChatImmersiveBinding r159 = this.f303184j;
        if (r159 == null) goto L82;
        AppCompatImageView r160 = r159.f311149b;
        if (r160 == null) goto L82;
        ViewGroup.LayoutParams r161 = r160.getLayoutParams();
        if (r161 == null) goto L81;
        ViewGroup.MarginLayoutParams r162 = (ViewGroup.MarginLayoutParams) r161;
        com.larus.utils.i0.f375410a.getClass();
        r162.topMargin = com.larus.utils.i0.g() + i5.r0();
        r160.setLayoutParams(r162);
        goto L82
    L81:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L82:
        LarusPageChatImmersiveBinding r163 = this.f303184j;
        if (r163 == null) goto L87;
        AppCompatImageView r164 = r163.f311149b;
        if (r164 == null) goto L87;
        r164.setImageResource(v19.c.b(com.larus.nova.R.attr.larus_ic_side_bar, r164.getContext(), com.larus.nova.R.drawable.larus_ic_side_bar));
    L87:
        LarusPageChatImmersiveBinding r165 = this.f303184j;
        if (r165 == null) goto L97;
        AppCompatImageView r166 = r165.f311149b;
        if (r166 == null) goto L97;
        com.larus.utils.e1.d(r166, new n(this));
    L97:
        LarusPageChatImmersiveBinding r167 = this.f303184j;
        if (r167 == null) goto L106;
        RedDotTextView r168 = r167.f311151d;
        if (r168 == null) goto L106;
        if (r168.getRedDotCount() <= 0) goto L106;
        if (((Boolean) this.E.getValue()).booleanValue() == false) goto L106;
        r168.setVisibility(0);
    L106:
        LarusPageChatImmersiveBinding r169 = this.f303184j;
        if (r169 == null) goto L111;
        RedDotTextView r170 = r169.f311151d;
        if (r170 == null) goto L111;
        com.larus.utils.e1.d(r170, new com.larus.bmhome.chat.immerse.b(this));
        goto L111
    L92:
        LarusPageChatImmersiveBinding r171 = this.f303184j;
        if (r171 == null) goto L97;
        AppCompatImageView r172 = r171.f311149b;
        if (r172 == null) goto L97;
        com.larus.utils.e1.d(r172, new o(this));
        goto L97
    L5:
        FragmentActivity r173 = requireActivity();
        if ((r173 instanceof AppCompatActivity) == false) goto L8;
        AppCompatActivity r174 = (AppCompatActivity) r173;
    L9:
        if (r174 == null) goto L13;
        AppCompatDelegate r175 = r174.getDelegate();
        if (r175 == null) goto L13;
        int r176 = r175.getLocalNightMode();
    L14:
        if (r176 != 2) goto L16;
    L18:
        if (r111 != null) goto L38;
        i0 r177 = i0.f303282a;
        FragmentActivity r178 = getActivity();
        if (r178 == null) goto L22;
        Context r179 = r178.getApplicationContext();
    L23:
        if (r179 == null) goto L32;
        Lazy r180 = we8.j.f559406a;
        int r181 = we8.j.f559408c;
        if (r181 == (-1)) goto L28;
        if (r181 != 2) goto L32;
    L31:
        boolean r182 = true;
    L33:
        if (r182 == true) goto L38;
        if ((getActivity() instanceof ChatImmersActivity) == false) goto L38;
        return;
    L28:
        if ((r179.getResources().getConfiguration().uiMode & 48) == 32) goto L31;
    L32:
        r182 = false;
        goto L33
    L22:
        r179 = null;
        goto L23
    L16:
        if ((getActivity() instanceof ChatImmersActivity) == false) goto L18;
        return;
    L13:
        r176 = -100;
        goto L14
    L8:
        r174 = null;
        goto L9
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00cb -> B:37:0x00f2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00ee -> B:36:0x00f0). Please report as a decompilation issue!!! */
    public static final Object Y90(ChatImmersFragment r110, List r111, Continuation r112) {
        r110.getClass();
        if ((r112 instanceof ChatImmersFragment$dataProcessor$1) == false) goto L7;
        ChatImmersFragment$dataProcessor$1 r100 = (ChatImmersFragment$dataProcessor$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        Collection r114 = (Collection) r100.L$3;
        RecommendBot r104 = (RecommendBot) r100.L$2;
        Iterator r105 = (Iterator) r100.L$1;
        Collection r106 = (Collection) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L36:
        String r115 = (String) r113;
    L37:
        r114.add(BundleKt.bundleOf(new Pair[]{TuplesKt.to("argBotRecommendFrom", r104.f297431a), TuplesKt.to("argPreviousPage", r110.b()), TuplesKt.to("argConversationId", r115), TuplesKt.to("argCvsBgImgUrl", r104.e()), TuplesKt.to("argCvsBgImgColor", r104.a()), TuplesKt.to("argCvsBgImgOpen", Boxing.boxBoolean(r104.c())), TuplesKt.to("argBotId", r104.o()), TuplesKt.to("argCvsBgVideoModel", r104.g())}));
        Iterator r116 = r105;
        Collection r117 = r106;
    L18:
        if (r116.hasNext() == false) goto L39;
        r104 = (RecommendBot) r116.next();
        Map<String, String> r107 = MapsKt.mapOf(new Pair("is_from_local_discovery", "1"));
        RepoDispatcher.f307729a.getClass();
        ConversationRepo r108 = RepoDispatcher.f307734f;
        String r109 = r104.o();
        if (r109 != null) goto L22;
        r109 = "";
    L22:
        r100.L$0 = r117;
        r100.L$1 = r116;
        r100.L$2 = r104;
        r100.L$3 = r107;
        r100.L$4 = r117;
        r100.label = 1;
        Object r118 = r108.a(r109, r100);
        if (r118 == r102) goto L40;
        Collection r119 = r117;
        r113 = r118;
        Iterator r120 = r116;
        r114 = r119;
    L26:
        wc9.e r121 = (wc9.e) r113;
        if (r104.M() == true) goto L29;
    L32:
        RepoDispatcher.f307729a.getClass();
        ConversationRepo r122 = RepoDispatcher.f307734f;
        r100.L$0 = r119;
        r100.L$1 = r120;
        r100.L$2 = r104;
        r100.L$3 = r114;
        r100.L$4 = null;
        r100.label = 2;
        r113 = r122.u(r104, r107, r100);
        if (r113 == r102) goto L41;
        r105 = r120;
        r106 = r119;
        goto L36
    L41:
        return r102;
    L29:
        if (com.larus.utils.o0.d(r104.E()) == false) goto L32;
        if (r121 == null) goto L32;
        r115 = r104.E();
        r105 = r120;
        r106 = r119;
        goto L37
    L40:
        return r102;
    L39:
        return (List) r117;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r114 = (Collection) r100.L$4;
        Map<String, String> r123 = (Map) r100.L$3;
        RecommendBot r124 = (RecommendBot) r100.L$2;
        r120 = (Iterator) r100.L$1;
        r119 = (Collection) r100.L$0;
        ResultKt.throwOnFailure(r113);
        r107 = r123;
        r104 = r124;
        goto L26
    L16:
        ResultKt.throwOnFailure(r113);
        List r125 = r111;
        r117 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r125, 10));
        r116 = r125.iterator();
    L7:
        r100 = new ChatImmersFragment$dataProcessor$1(r110, r112);
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        ChatImmersViewPagerAdapter r103 = this.f303186l;
        if (r103 == null) goto L14;
        if (r102 == null) goto L15;
        Bundle r104 = r102.getExtras();
        if (r104 == null) goto L16;
        Fragment r105 = FragmentStateAdapterHelper.INSTANCE.getFragmentByIndex(r103, this.f303193s);
        if ((r105 instanceof ChatFragment) == false) goto L10;
        ChatFragment r106 = (ChatFragment) r105;
    L11:
        if (r106 == null) goto L17;
        r106.Lc(r104, r100, r101);
        return;
    L17:
        return;
    L10:
        r106 = null;
        goto L11
    L16:
        return;
    L15:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r113 = r110.inflate(com.larus.nova.R.layout.larus_page_chat_immersive, r111, false);
        int r114 = com.larus.nova.R.id.back_icon;
        AppCompatImageView r100 = (AppCompatImageView) ViewBindings.findChildViewById(r113, com.larus.nova.R.id.back_icon);
        if (r100 == null) goto L25;
        r114 = com.larus.nova.R.id.chat_container;
        ViewPager2 r101 = (ViewPager2) ViewBindings.findChildViewById(r113, com.larus.nova.R.id.chat_container);
        if (r101 == null) goto L25;
        r114 = com.larus.nova.R.id.chat_title_red_dot;
        RedDotTextView r102 = (RedDotTextView) ViewBindings.findChildViewById(r113, com.larus.nova.R.id.chat_title_red_dot);
        if (r102 == null) goto L25;
        r114 = com.larus.nova.R.id.discovery_icon;
        ImageView r103 = (ImageView) ViewBindings.findChildViewById(r113, com.larus.nova.R.id.discovery_icon);
        if (r103 == null) goto L25;
        r114 = com.larus.nova.R.id.loading_container;
        ConstraintLayout r104 = (ConstraintLayout) ViewBindings.findChildViewById(r113, com.larus.nova.R.id.loading_container);
        if (r104 == null) goto L25;
        r114 = com.larus.nova.R.id.progress_bar;
        if (((ProgressBar) ViewBindings.findChildViewById(r113, com.larus.nova.R.id.progress_bar)) == null) goto L25;
        r114 = com.larus.nova.R.id.retry_container;
        ConstraintLayout r105 = (ConstraintLayout) ViewBindings.findChildViewById(r113, com.larus.nova.R.id.retry_container);
        if (r105 == null) goto L25;
        r114 = com.larus.nova.R.id.retry_icon;
        if (((ImageView) ViewBindings.findChildViewById(r113, com.larus.nova.R.id.retry_icon)) == null) goto L25;
        r114 = com.larus.nova.R.id.retry_text;
        if (((TextView) ViewBindings.findChildViewById(r113, com.larus.nova.R.id.retry_text)) == null) goto L25;
        r114 = com.larus.nova.R.id.title_container;
        ConstraintLayout r106 = (ConstraintLayout) ViewBindings.findChildViewById(r113, com.larus.nova.R.id.title_container);
        if (r106 == null) goto L25;
        ChatImmerseConstraintLayout r115 = (ChatImmerseConstraintLayout) r113;
        this.f303184j = new LarusPageChatImmersiveBinding(r115, r100, r101, r102, r103, r104, r105, r106);
        this.f294908e = true;
        return r115;
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r114)));
    }
}
