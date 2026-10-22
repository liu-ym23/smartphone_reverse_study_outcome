package com.ss.android.lark.forwardv3.plugins;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.lark.pb.basic.v1.ActionType;
import com.ss.android.lark.base.fragment.BaseForsetiFragment;
import com.ss.android.lark.forwardv3.ForwardModuleV3;
import com.ss.android.lark.forwardv3.configuration.ForwardTemplateNew;
import com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel;
import com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModelFactory;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.picker.Dependency;
import com.ss.android.lark.picker.NavPicker;
import com.ss.android.lark.picker.config.NavPickerConfig;
import com.ss.android.lark.picker.config.Permissions;
import com.ss.android.lark.picker.statistics.PickerStatistics;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0004!$'*\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0014H\u0002J\u0012\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102H\u0016J&\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u0001082\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00109\u001a\u000200H\u0002J\n\u0010:\u001a\u0004\u0018\u000104H\u0002J\u0010\u0010;\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0014H\u0002J\u0010\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0002J\b\u0010@\u001a\u000200H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R*\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"R\u0010\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%R\u0010\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(R\u0010\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0004\n\u0002\u0010+¨\u0006A"}, d2 = {"Lcom/ss/android/lark/forwardv3/plugins/ForwardCreateGroupChatFragment;", "Lcom/ss/android/lark/base/fragment/BaseForsetiFragment;", "forwardTemplate", "Lcom/ss/android/lark/forwardv3/configuration/ForwardTemplateNew;", "callback", "Lcom/ss/android/lark/forwardv3/plugins/ForwardCreateGroupChatPlugin$CreateGroupChatCallBack;", "<init>", "(Lcom/ss/android/lark/forwardv3/configuration/ForwardTemplateNew;Lcom/ss/android/lark/forwardv3/plugins/ForwardCreateGroupChatPlugin$CreateGroupChatCallBack;)V", "getForwardTemplate", "()Lcom/ss/android/lark/forwardv3/configuration/ForwardTemplateNew;", "getCallback", "()Lcom/ss/android/lark/forwardv3/plugins/ForwardCreateGroupChatPlugin$CreateGroupChatCallBack;", "navPicker", "Lcom/ss/android/lark/picker/NavPicker;", "loadingToast", "Lcom/larksuite/component/universe_design/toast/UDToastImpl;", "viewModel", "Lcom/ss/android/lark/forwardv3/viewmodel/ForwardV3ViewModel;", "selectedChat", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "Lkotlin/collections/ArrayList;", "getSelectedChat", "()Ljava/util/ArrayList;", "setSelectedChat", "(Ljava/util/ArrayList;)V", "clickThrottle", "Lcom/ss/android/lark/forwardv3/utils/ForwardClickThrottle;", "getClickThrottle", "()Lcom/ss/android/lark/forwardv3/utils/ForwardClickThrottle;", "clickThrottle$delegate", "Lkotlin/Lazy;", "pickerListener", "com/ss/android/lark/forwardv3/plugins/ForwardCreateGroupChatFragment$pickerListener$1", "Lcom/ss/android/lark/forwardv3/plugins/ForwardCreateGroupChatFragment$pickerListener$1;", "cancelListener", "com/ss/android/lark/forwardv3/plugins/ForwardCreateGroupChatFragment$cancelListener$1", "Lcom/ss/android/lark/forwardv3/plugins/ForwardCreateGroupChatFragment$cancelListener$1;", "confirmListener", "com/ss/android/lark/forwardv3/plugins/ForwardCreateGroupChatFragment$confirmListener$1", "Lcom/ss/android/lark/forwardv3/plugins/ForwardCreateGroupChatFragment$confirmListener$1;", "pickerItemConsumer", "com/ss/android/lark/forwardv3/plugins/ForwardCreateGroupChatFragment$pickerItemConsumer$1", "Lcom/ss/android/lark/forwardv3/plugins/ForwardCreateGroupChatFragment$pickerItemConsumer$1;", "isSelf", "", "data", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "initWindowInsets", "initPicker", "dealBusinessConsumeClick", "getNavPickerConfig", "Lcom/ss/android/lark/picker/config/NavPickerConfig;", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", LiveCommonConstants.REASON_ON_DEDTROY, "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForwardCreateGroupChatFragment extends BaseForsetiFragment {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f425459r = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ForwardTemplateNew f425460g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ForwardCreateGroupChatPlugin.a f425461h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public NavPicker f425462i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.larksuite.component.universe_design.toast.c f425463j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ForwardV3ViewModel f425464k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList<SearchBaseInfo> f425465l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f425466m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final e f425467n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f425468o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ForwardCreateGroupChatFragment$confirmListener$1 f425469p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final d f425470q;

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        com.larksuite.component.universe_design.toast.c r100 = this.f425463j;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f425463j = null;
    }

    public static final /* synthetic */ Context U90(ForwardCreateGroupChatFragment r100) {
        return r100.mContext;
    }

    @Override // com.ss.android.lark.base.fragment.BaseForsetiFragment, com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        ForwardV3ViewModel r101 = (ForwardV3ViewModel) new ViewModelProvider(this, new ForwardV3ViewModelFactory(this.f425460g)).get(ForwardV3ViewModel.class);
        this.f425464k = r101;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r101 = null;
    L5:
        r101.init();
        Intrinsics.checkNotNullParameter(this, "<this>");
        WindowInsetsUtils.b(this).o(true);
        requireActivity().getOnBackPressedDispatcher().addCallback(this, new AnonymousClass1(this));
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [com.ss.android.lark.forwardv3.plugins.ForwardCreateGroupChatFragment$confirmListener$1] */
    public ForwardCreateGroupChatFragment(ForwardTemplateNew r100, ForwardCreateGroupChatPlugin.b.a r101) {
        Intrinsics.checkNotNullParameter(r100, "forwardTemplate");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f425460g = r100;
        this.f425461h = r101;
        this.f425465l = new ArrayList();
        this.f425466m = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, ForwardCreateGroupChatFragment$clickThrottle$2.INSTANCE);
        this.f425467n = new e(this);
        this.f425468o = new c(this);
        this.f425469p = new ForwardCreateGroupChatFragment$confirmListener$1(this);
        this.f425470q = new d(this);
    }

    public static final boolean V90(ForwardCreateGroupChatFragment r100, SearchBaseInfo r101) {
        r100.getClass();
        if ((r101 instanceof SearchChatterInfo) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(ForwardModuleV3.a().getLoginUserId(), ((SearchChatterInfo) r101).getId()) == false) goto L7;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        FragmentActivity r103 = getActivity();
        if (r103 == null) goto L6;
        NavPicker r104 = new NavPicker(r103, null, 2, 0 == true ? 1 : 0);
        r104.scene(PickerStatistics.Scene.ImCreateAndForward);
        NavPickerConfig r105 = new NavPickerConfig(new Dependency(r103, getChildFragmentManager()), new Permissions(CollectionsKt.listOf(new ActionType[]{ActionType.INVITE_SAME_CHAT, ActionType.SHARE_MESSAGE_SELECT_USER})));
        r105.navigation(new ForwardCreateGroupChatFragment$getNavPickerConfig$navPickerConfig$1$1(this));
        r105.extra(new ForwardCreateGroupChatFragment$getNavPickerConfig$navPickerConfig$1$2(this));
        r105.searcher(new ForwardCreateGroupChatFragment$getNavPickerConfig$navPickerConfig$1$3(this));
        r105.addressBook(ForwardCreateGroupChatFragment$getNavPickerConfig$navPickerConfig$1$4.INSTANCE);
        r104.init2(r105);
        this.f425462i = r104;
    L6:
        return this.f425462i;
    }
}
