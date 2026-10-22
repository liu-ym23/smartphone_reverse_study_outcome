package com.bytedance.applet.view;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ai.api.model.view.AIFragmentBase;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.PageStatus;
import com.bytedance.ai.model.viewmodel.RenderStateVM;
import com.bytedance.ai.view.input.FloatingSpeakerView;
import com.bytedance.ai.view.popup.AppletPopup;
import com.bytedance.applet.databinding.LarusAppletWebBrowserBinding;
import com.bytedance.applet.event.EventDispatcher;
import com.bytedance.applet.utils.MessageUtils;
import com.bytedance.assem.arch.extensions.AssembleExtKt;
import com.bytedance.assem.arch.extensions.VMExtKt;
import com.bytedance.assem.arch.viewModel.IVMSubscriber;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.x1;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.im.bean.message.Message;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.b2;
import com.larus.platform.api.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.v;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.skydoves.balloon.Balloon;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 x2\u00020\u00012\u00020\u0002:\u0001xB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010=\u001a\u00020!H\u0002J\b\u0010>\u001a\u00020!H\u0002J\b\u0010F\u001a\u00020!H\u0016J\u0014\u0010G\u001a\u0004\u0018\u00010\f2\b\u0010H\u001a\u0004\u0018\u00010IH\u0002J\u0012\u0010J\u001a\u0002042\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\b\u0010M\u001a\u0004\u0018\u00010\fJ\u0010\u0010N\u001a\u0002042\u0006\u0010O\u001a\u00020!H\u0002J&\u0010P\u001a\u0004\u0018\u00010\u001f2\u0006\u0010Q\u001a\u00020R2\b\u0010S\u001a\u0004\u0018\u00010T2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\n\u0010U\u001a\u0004\u0018\u00010VH\u0002J\u0006\u0010W\u001a\u000204J\u001a\u0010X\u001a\u0002042\u0006\u0010Y\u001a\u00020\u001f2\b\u0010K\u001a\u0004\u0018\u00010LH\u0017J\u000e\u0010Z\u001a\u00020#2\u0006\u0010[\u001a\u00020\fJ\b\u0010\\\u001a\u000204H\u0016J\u0006\u0010]\u001a\u000204J\u0010\u0010^\u001a\u0002042\u0006\u0010_\u001a\u00020LH\u0016J\b\u0010`\u001a\u000204H\u0002J\b\u0010a\u001a\u000204H\u0016J\b\u0010b\u001a\u000204H\u0016J\b\u0010c\u001a\u000204H\u0016J\b\u0010d\u001a\u000204H\u0016J\b\u0010e\u001a\u000204H\u0002J\b\u0010f\u001a\u000204H\u0016J\u000e\u0010g\u001a\u000204H\u0082@¢\u0006\u0002\u0010hJ \u0010i\u001a\u0002042\u0006\u0010j\u001a\u00020T2\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020nH\u0003J\b\u0010o\u001a\u000204H\u0002J\u0016\u0010p\u001a\u0002042\u0006\u0010q\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010rR\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000RF\u0010.\u001a:\u0012\u0013\u0012\u00110!¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0013\u0012\u00110#¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(3\u0012\u0004\u0012\u000204\u0018\u00010/j\u0004\u0018\u0001`5X\u0082\u000e¢\u0006\u0002\n\u0000R1\u00106\u001a%\u0012\u0013\u0012\u00110!¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(8\u0012\u0004\u0012\u000204\u0018\u000107j\u0004\u0018\u0001`9X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010@\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020!0/X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010A\u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bB\u0010CR\u000e\u0010s\u001a\u00020tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010u\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010w0vX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006y"}, d2 = {"Lcom/bytedance/applet/view/AppletFragment;", "Lcom/bytedance/ai/api/model/view/AIFragmentBase;", "Lcom/bytedance/assem/arch/viewModel/IVMSubscriber;", "<init>", "()V", "mRenderStateVM", "Lcom/bytedance/ai/model/viewmodel/RenderStateVM;", "getMRenderStateVM", "()Lcom/bytedance/ai/model/viewmodel/RenderStateVM;", "mRenderStateVM$delegate", "Lcom/bytedance/assem/arch/viewModel/AssemVMLazy;", "schema", "", "binding", "Lcom/bytedance/applet/databinding/LarusAppletWebBrowserBinding;", "url", "appletBotId", "fsConversationId", "lastMsgIndex", "", "Ljava/lang/Long;", "appletPage", "Lcom/bytedance/ai/api/model/view/IAIContainerView;", "reader", "Lcom/larus/bmhome/chat/model/repo/ITtsReader;", "morePopup", "Lcom/skydoves/balloon/Balloon;", "trace", "Lcom/larus/platform/api/IPageLoadTrace;", "urlQueryTitle", "webViewClientCustomView", "Landroid/view/View;", "isCurrentFullScreen", "", "originalPaddingTop", "", "originalPaddingBottom", "fullScreen", "closeMethodImpl", "Lcom/bytedance/applet/jsb/AppletFragmentCloseMethodImpl;", "hideTitleBar", "blockBackPress", "backPressedEnabled", "disableBounce", "eventListener", "Lcom/bytedance/ai/event/IEventListener;", "keyboardStatusCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "onShown", "height", "", "Lcom/bytedance/ai/floating/KeyboardStatusCallback;", "speakStatusCallback", "Lkotlin/Function1;", "onSpeak", "Lcom/bytedance/ai/floating/SpeakStatusCallback;", "defaultBackgroundColor", "defaultBackgroundColorFromPageSettings", "speakerStatus", "isSpeakerEnable", "speakerVisibleByDefault", "isRedirectQuery", "redirectQueryCall", "bounceWithKeyboard", "getBounceWithKeyboard", "()Z", "bounceWithKeyboard$delegate", "Lkotlin/Lazy;", "isBackPressedEnabled", "parseBackgroundColorFromPageSettings", "pageSettings", "Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "getAppId", "handleFullScreen", "isFullScreen", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "renderEngine", "Lcom/bytedance/ai/api/model/view/IAIRenderEngineService;", "backPressed", "onViewCreated", "view", "parseColorRRGGBBOrRRGGBBAA", "input", "doRefresh", "close", "onSaveInstanceState", "outState", "backWebPage", "onPause", "onStop", "onResume", "onDestroyView", "releaseMorePopup", "onDestroy", "setupEventListener", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createLocalWebView", "root", "fragment", "Landroidx/fragment/app/Fragment;", "params", "Lcom/bytedance/ai/api/model/view/AIViewRenderData;", "initFloatingSpeaker", "updateFloatingBotId", "botId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "floatingSpeakerController", "Lcom/bytedance/ai/api/model/view/IFloatingSpeakerController;", "window", "Lkotlin/Function0;", "Landroid/view/Window;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletFragment extends AIFragmentBase implements IVMSubscriber {
    public static final /* synthetic */ int J = 0;
    public c A;
    public String B;
    public String C;
    public String D;
    public boolean E;
    public final o F;
    public final Lazy G;
    public final AppletFragment$floatingSpeakerController$1 H;
    public final com.bytedance.applet.view.b I;
    public final com.bytedance.assem.arch.viewModel.b d;
    public final String e;
    public LarusAppletWebBrowserBinding f;
    public String g;
    public String h;
    public String i;
    public Long j;
    public com.bytedance.ai.model.widgets.c k;
    public x1 l;
    public Balloon m;
    public final e1 n;
    public String o;
    public View p;
    public boolean q;
    public int r;
    public int s;
    public boolean t;
    public com.bytedance.applet.jsb.m u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public AppletFragment$setupEventListener$listener$1 z;

    public static final class a {
    }

    public static final class b implements View.OnAttachStateChangeListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ AppletFragment b;
        public final /* synthetic */ LinearLayout c;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r1) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r11) {
            this.a.removeOnAttachStateChangeListener(this);
            if (this.b.t == false) goto L5;
            Intrinsics.checkNotNull(this.c);
            LinearLayout r12 = this.c;
            int r5 = r12.getPaddingStart();
            int r6 = r12.getPaddingEnd();
            FLogger.a.i("updatePaddingRelative", "view:" + r12.getClass().getSimpleName() + ",source:,start:" + r5 + ",top:0,end:" + r6 + ",bottom:0");
            r12.setPaddingRelative(r5, 0, r6, 0);
            return;
        L5:
            Intrinsics.checkNotNull(this.c);
            LinearLayout r13 = this.c;
            int r7 = r13.getPaddingStart();
            int r8 = r13.getPaddingTop();
            int r9 = r13.getPaddingEnd();
            FLogger.a.i("updatePaddingRelative", "view:" + r13.getClass().getSimpleName() + ",source:,start:" + r7 + ",top:" + r8 + ",end:" + r9 + ",bottom:0");
            r13.setPaddingRelative(r7, r8, r9, 0);
        }

        public b(View r1, AppletFragment r2, LinearLayout r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    @Override // com.bytedance.assem.arch.viewModel.e
    public final void F60() {
    }

    @Override // com.bytedance.assem.arch.viewModel.e
    public final com.bytedance.tiktok.proxy.b NY() {
        return this;
    }

    @Override // com.bytedance.assem.arch.viewModel.e
    public final LifecycleOwner Tm() {
        return this;
    }

    public final LifecycleOwner aM() {
        return this;
    }

    @Override // com.bytedance.assem.arch.viewModel.e
    public final com.bytedance.tiktok.proxy.a dh() {
        return null;
    }

    @Override // com.bytedance.assem.arch.viewModel.e
    public final LifecycleOwner fr() {
        return null;
    }

    public final com.bytedance.tiktok.proxy.a oq() {
        return this;
    }

    @Override // com.bytedance.assem.arch.viewModel.e
    public final com.bytedance.tiktok.proxy.c<com.bytedance.tiktok.proxy.a> pF() {
        return this;
    }

    public final void S90() {
        FLogger.a.i("AppletFragment", "click reload");     // Catch: Exception -> L12
        com.bytedance.ai.model.widgets.c r1 = this.k;     // Catch: Exception -> L12
        if (r1 == null) goto L6;
        r1.doRefresh();     // Catch: Exception -> L12
    L6:
        k2.m r2 = com.bytedance.assem.arch.service.e.a(this, Reflection.getOrCreateKotlinClass(k2.m.class));     // Catch: Exception -> L12
        if (r2 == null) goto L17;
        k2.q r3 = r2.h();     // Catch: Exception -> L12
        if (r3 == null) goto L18;
        r3.doRefresh();     // Catch: Exception -> L12
        return;
    L18:
        return;
    L17:
        return;
    L12:
        e = move-exception;
        FLogger.a.i("AppletFragment", "click reload error: " + e);
    }

    public final boolean W90() {
        if (Intrinsics.areEqual(this.D, CommentScene.COMMENTSCENE_NO_AWEME) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(this.D, "2") == true) goto L8;
        return false;
    }

    public final k2.q Y90() {
        k2.m r0 = com.bytedance.assem.arch.service.e.a(this, Reflection.getOrCreateKotlinClass(k2.m.class));
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.h();
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        V90(false);
        com.larus.platform.service.g.a.g("AppletFragment");
        com.bytedance.applet.jsb.m r2 = this.u;
        if (r2 == null) goto L10;
        ArrayList r4 = (ArrayList) com.bytedance.applet.jsb.m.c;
        r4.remove(r2);
        if ((!r4.isEmpty()) == false) goto L7;
        Map r3 = com.ivy.ivykit.api.bridge.b.a;
        com.ivy.ivykit.api.bridge.b.b(hx7.f.class, ListProtector.get(r4, 0));
        goto L10
    L7:
        hx7.f r1 = com.bytedance.applet.jsb.m.b;
        if (r1 == null) goto L10;
        Map r5 = com.ivy.ivykit.api.bridge.b.a;
        com.ivy.ivykit.api.bridge.b.b(hx7.f.class, r1);
    L10:
        Activity r6 = AppHost.a.a().getCurrentActivity();
        if (r6 == null) goto L18;
        Lazy r7 = i2.f.i;
        i2.f r8 = i2.f.a.a();
        if (r8 == null) goto L15;
        r8.p(r6);
    L15:
        i2.f r9 = i2.f.a.a();
        if (r9 == null) goto L18;
        r9.k(r6);
    L18:
        AppletFragment$setupEventListener$listener$1 r10 = this.z;
        if (r10 == null) goto L26;
        EventDispatcher r11 = EventDispatcher.a;
        EventDispatcher.l(this.h, r10);
    L26:
        LinkedHashSet r12 = com.bytedance.ai.utils.c.a;     // Catch: Exception -> L23
        boolean r13 = com.bytedance.ai.utils.c.a(hashCode());     // Catch: Exception -> L23
        FLogger.a.i("AppletFragment", "onDestroy, page removed from stack: " + r13 + ", fragmentHashCode: " + hashCode());     // Catch: Exception -> L23
        return;
    L23:
        e = move-exception;
        FLogger.a.e("AppletFragment", "onDestroy popPage error: " + e.getMessage());
    }

    public final void onDestroyView() {
        Balloon r0 = this.m;
        this.m = null;
        if (r0 != null) goto L36;
    L12:
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        AppletFragment$setupEventListener$listener$1 r1 = this.z;
        if (r1 == null) goto L23;
        String r3 = this.h;
        if (r3 != null) goto L17;
    L20:
        boolean r4 = true;
    L21:
        if (r4 == true) goto L23;
        EventDispatcher r5 = EventDispatcher.a;
        EventDispatcher.l(this.h, r1);
        goto L23
    L17:
        if (r3.length() == 0) goto L20;
        r4 = false;
    L23:
        LarusAppletWebBrowserBinding r2 = this.f;
        if (r2 == null) goto L28;
        ImageView r6 = r2.c;
        if (r6 == null) goto L28;
        int r7 = ys9.b.a;
        Intrinsics.checkNotNullParameter(r6, "host");
        com.larus.utils.l.d(r6, "ext_balloon_pop");
    L28:
        com.bytedance.ai.model.widgets.c r8 = this.k;
        if (r8 == null) goto L31;
        r8.onHostDestroy();
    L31:
        this.f = null;
        Lazy r9 = i2.f.i;
        i2.f r10 = i2.f.a.a();
        if (r10 == null) goto L34;
        r10.m(AppHost.a.a().getCurrentActivity(), false);
    L34:
        FLogger.a.i("AppletFragment", "onDestroyView");
        return;
    L36:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L6
        r0.onDestroy(getViewLifecycleOwner());     // Catch: Throwable -> L6
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L9:
        if (Result.exceptionOrNull-impl(r12) == null) goto L11;
        r0.h();
    L11:
        Result.box-impl(r12);
    L6:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public final void onStop() {
        super/*androidx.fragment.app.Fragment*/.onStop();
        FLogger r1 = FLogger.a;
        r1.i("AppletFragment", "onStop");
        LinkedHashSet r3 = com.bytedance.ai.utils.c.a;     // Catch: Exception -> L5
        com.bytedance.ai.utils.c.c(hashCode(), true);     // Catch: Exception -> L5
        r1.i("AppletFragment", "MiniAppPage paused, fragmentHashCode: " + hashCode());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        FLogger.a.e("AppletFragment", "onPause error: " + e.getMessage());
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.bytedance.applet.view.o] */
    public AppletFragment() {
        com.bytedance.assem.arch.viewModel.g.c r0 = com.bytedance.assem.arch.viewModel.g.c.a;
        final KClass r3 = Reflection.getOrCreateKotlinClass(RenderStateVM.class);
        Function0<String> r4 = new AppletFragment$special$$inlined$assemViewModel$default$1(r3);
        AppletFragment$special$$inlined$assemViewModel$default$2 r9 = AppletFragment$special$$inlined$assemViewModel$default$2.INSTANCE;
        if (Intrinsics.areEqual(r0, com.bytedance.assem.arch.viewModel.g.a.a) == false) goto L5;
        com.bytedance.assem.arch.viewModel.b r1 = new com.bytedance.assem.arch.viewModel.b(r3, r4, VMExtKt.h(), VMExtKt.l(this), VMExtKt.n(this), VMExtKt.b(), r9, VMExtKt.i(this, true), VMExtKt.d(this, true));
    L12:
        this.d = r1;
        this.e = "aweme://webview/?url=";
        this.h = "";
        this.n = com.larus.platform.service.g.a.h("WebFragment");
        this.o = "";
        this.t = true;
        this.x = true;
        this.y = true;
        this.F = new o(this);
        this.G = LazyKt.lazy(new p(this));
        this.H = new AppletFragment$floatingSpeakerController$1(this);
        this.I = new com.bytedance.applet.view.b(this);
        return;
    L5:
        if (r0 != null) goto L7;
    L11:
        r1 = new com.bytedance.assem.arch.viewModel.b(r3, r4, VMExtKt.h(), VMExtKt.m(this), VMExtKt.o(this), VMExtKt.b(), r9, VMExtKt.i(this, false), VMExtKt.d(this, false));
        goto L12
    L7:
        if (Intrinsics.areEqual(r0, r0) == true) goto L11;
        throw new IllegalArgumentException("Do not support this scope here.");
    }

    public final void close() {
        AppletPopup r0 = getParentFragment();
        DialogFragment r2 = null;
        if ((r0 instanceof AppletPopup) == false) goto L5;
        AppletPopup r1 = r0;
    L6:
        if (r1 == null) goto L8;
        r1.da0(true);
        return;
    L8:
        Fragment r3 = getParentFragment();
        if ((r3 instanceof DialogFragment) == false) goto L11;
        r2 = (DialogFragment) r3;
    L11:
        if (r2 != null) goto L22;
        FragmentActivity r4 = getActivity();
        if (r4 == null) goto L27;
        r4.finish();
        return;
    L27:
        return;
    L22:
        r2.dismissAllowingStateLoss();     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L25;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L25:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        FLogger.a.i("AppletFragment", "onPause");
        com.bytedance.ai.model.widgets.c r0 = this.k;
        if (r0 == null) goto L6;
        r0.onHostHide();
        return;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        FLogger.a.i("AppletFragment", "onResume");
        com.bytedance.ai.model.widgets.c r0 = this.k;
        if (r0 == null) goto L5;
        r0.onHostShow();
    L5:
        e1 r1 = this.n;
        if (r1 == null) goto L8;
        r1.b("create");
    L8:
        e1 r2 = this.n;
        if (r2 == null) goto L11;
        r2.c("load");
    L11:
        com.bytedance.ai.model.widgets.c r3 = this.k;
        if (r3 == null) goto L17;
        PageInfo r4 = r3.getPageInfo();
        if (r4 == null) goto L18;
        LinkedHashSet r5 = com.bytedance.ai.utils.c.a;
        com.bytedance.ai.model.widgets.c r6 = this.k;
        Intrinsics.checkNotNull(r6);
        com.bytedance.ai.utils.c.b(r4, r6, hashCode());
        com.bytedance.ai.utils.c.c(hashCode(), false);
        return;
    L18:
        return;
    }

    public final boolean T90() {
        return this.x;
    }

    public static int X90(String r4) {
        Intrinsics.checkNotNullParameter(r4, "input");
        String r5 = StringsKt.removePrefix(r4, "#");
        int r1 = r5.length();
        if (r1 == 6) goto L11;
        if (r1 != 8) goto L9;
        String r2 = StringsKt.take(r5, 6);
        return ColorProtector.parseColor("#" + r5.substring(6, 8) + r2);
    L9:
        throw new IllegalArgumentException("Color must be in #RRGGBB or #RRGGBBAA format");
    L11:
        return ColorProtector.parseColor("#FF".concat(r5));
    }

    public final void V90(boolean r8) {
        if (r8 != this.q) goto L5;
        return;
    L5:
        this.q = r8;
        if (r8 == false) goto L29;
        if (Build.VERSION.SDK_INT < 30) goto L23;
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L16;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L16;
        WindowInsetsController r2 = r1.getInsetsController();
        if (r2 == null) goto L16;
        r2.hide(WindowInsets.Type.statusBars());
    L16:
        FragmentActivity r3 = getActivity();
        if (r3 == null) goto L49;
        Window r4 = r3.getWindow();
        if (r4 == null) goto L49;
        WindowInsetsController r5 = r4.getInsetsController();
        if (r5 == null) goto L49;
        r5.hide(WindowInsets.Type.navigationBars());
    L49:
        LarusAppletWebBrowserBinding r6 = this.f;
        if (r6 == null) goto L69;
        LinearLayout r7 = r6.a;
        if (r7 == null) goto L72;
        if (r8 == false) goto L56;
        this.s = r7.getPaddingBottom();
        this.r = r7.getPaddingTop();
    L56:
        int r9 = 0;
        if (r8 == false) goto L59;
        int r10 = 0;
    L60:
        if (r8 == true) goto L63;
        r9 = this.r;
    L63:
        LarusAppletWebBrowserBinding r11 = this.f;
        if (r11 == null) goto L70;
        LinearLayout r12 = r11.a;
        if (r12 == null) goto L71;
        int r13 = r12.getPaddingStart();
        int r14 = r12.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r12.getClass().getSimpleName() + ",source:,start:" + r13 + ",top:" + r9 + ",end:" + r14 + ",bottom:" + r10);
        r12.setPaddingRelative(r13, r9, r14, r10);
        return;
    L71:
        return;
    L70:
        return;
    L59:
        r10 = this.s;
        goto L60
    L72:
        return;
    L69:
        return;
    L23:
        FragmentActivity r15 = getActivity();
        if (r15 == null) goto L49;
        Window r16 = r15.getWindow();
        if (r16 == null) goto L49;
        r16.addFlags(1024);
        goto L49
    L29:
        if (Build.VERSION.SDK_INT < 30) goto L44;
        FragmentActivity r17 = getActivity();
        if (r17 == null) goto L37;
        Window r18 = r17.getWindow();
        if (r18 == null) goto L37;
        WindowInsetsController r19 = r18.getInsetsController();
        if (r19 == null) goto L37;
        r19.show(WindowInsets.Type.statusBars());
    L37:
        FragmentActivity r20 = getActivity();
        if (r20 == null) goto L49;
        Window r21 = r20.getWindow();
        if (r21 == null) goto L49;
        WindowInsetsController r22 = r21.getInsetsController();
        if (r22 == null) goto L49;
        r22.show(WindowInsets.Type.navigationBars());
        goto L49
    L44:
        FragmentActivity r23 = getActivity();
        if (r23 == null) goto L49;
        Window r24 = r23.getWindow();
        if (r24 == null) goto L49;
        r24.clearFlags(1024);
        goto L49
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10, types: [com.bytedance.applet.view.AppletFragment$setupEventListener$listener$1] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final Object Z90(Continuation<? super Unit> r5) {
        if ((r5 instanceof AppletFragment$setupEventListener$1) == false) goto L7;
        AppletFragment$setupEventListener$1 r0 = (AppletFragment$setupEventListener$1) r5;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        AppletFragment r4 = (AppletFragment) r0.L$0;
        ResultKt.throwOnFailure(r6);
    L20:
        Message r7 = (Message) r6;
        if (r7 == null) goto L23;
        Long r8 = Boxing.boxLong(r7.getLocalIndex());
    L24:
        r4.j = r8;
    L25:
        FLogger.a.i("FloatingSpeaker", "setupEventListener lastMsgIndex = " + this.j);
        if (o0.d(this.h) == false) goto L32;
        AppletFragment$setupEventListener$listener$1 r9 = this.z;
        Object r10 = r9;
        if (r9 != null) goto L30;
        ?? r11 = new AppletFragment$setupEventListener$listener$1(this);
        this.z = r11;
        r10 = r11;
    L30:
        EventDispatcher r12 = EventDispatcher.a;
        String r13 = this.h;
        Intrinsics.checkNotNullParameter(r13, "botId");
        Intrinsics.checkNotNullParameter(r10, "listener");
        EventDispatcher.k(r13).e.add(r10);
    L32:
        return Unit.INSTANCE;
    L23:
        r8 = null;
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        String r14 = this.i;
        if (r14 == null) goto L25;
        IChatRepoService r15 = zh8.a.a;
        r0.L$0 = this;
        r0.label = 1;
        r6 = r15.D1(r14, r0);
        if (r6 != r2) goto L19;
        return r2;
    L19:
        r4 = this;
    L7:
        r0 = new AppletFragment$setupEventListener$1(this, r5);
        goto L8
    }

    public final void onCreate(Bundle r8) {
        super/*androidx.fragment.app.Fragment*/.onCreate(r8);
        if (r8 == null) goto L5;
        Bundle r0 = new Bundle();
        r0.putAll(r8);
        setArguments(r0);
    L5:
        e1 r9 = this.n;
        if (r9 == null) goto L8;
        r9.startTrace();
    L8:
        e1 r10 = this.n;
        if (r10 == null) goto L11;
        r10.c("create");
    L11:
        com.larus.platform.service.g.a.e("AppletFragment");
        Bundle r11 = getArguments();
        String r1 = "";
        String r2 = null;
        if (r11 == null) goto L15;
        String r12 = r11.getString("url");
        if (r12 == null) goto L15;
    L21:
        this.g = r12;
        Bundle r13 = getArguments();
        if (r13 == null) goto L25;
        String r14 = r13.getString("pageId");
        if (r14 == null) goto L25;
    L26:
        AppletRuntimeManager.INSTANCE.getClass();
        com.bytedance.ai.model.widgets.c r3 = AppletRuntimeManager.e(r14);
        this.k = r3;
        if (r3 == null) goto L33;
        PageInfo r4 = r3.getPageInfo();
        if (r4 == null) goto L33;
        ReadableMap r5 = r4.getPageSettings();
        if (r5 == null) goto L33;
        String r6 = r5.getString("speakerStatus");
    L34:
        this.D = r6;
        FLogger r7 = FLogger.a;
        StringBuilder r15 = new StringBuilder("onCreate pageId ");
        r15.append(r14);
        r15.append(" appletPage ");
        com.bytedance.ai.model.widgets.c r16 = this.k;
        if (r16 == null) goto L37;
        String r17 = r16.getAppletId();
    L38:
        r15.append(r17);
        r7.i("AppletFragment", r15.toString());
        com.bytedance.ai.model.widgets.c r18 = this.k;
        if (r18 != null) goto L41;
    L101:
        FragmentActivity r19 = getActivity();
        if (r19 == null) goto L105;
        r19.finish();
        return;
    L105:
        return;
    L41:
        if (r18.getAppletId() == null) goto L101;
        com.bytedance.ai.model.widgets.c r20 = this.k;
        if (r20 == null) goto L46;
        r20.setFloatingSpeakerController(this.H);
    L46:
        com.bytedance.ai.model.widgets.c r21 = this.k;
        if (r21 == null) goto L50;
        String r22 = r21.getBotId();
        if (r22 == null) goto L50;
    L51:
        this.h = r22;
        Bundle r23 = getArguments();
        boolean r24 = true;
        if (r23 == null) goto L54;
        boolean r25 = r23.getBoolean("fullScreen", true);
    L55:
        this.t = r25;
        Uri r26 = UriProtector.parse(this.g);
        String r27 = UriProtector.getQueryParameter(r26, "title");
        if (r27 == null) goto L59;
        r1 = r27;
    L59:
        this.o = r1;
        this.w = r26.getBooleanQueryParameter("blockBackPress", false);
        if (this.t == true) goto L62;
        this.v = r26.getBooleanQueryParameter("hideNavBar", true);
    L63:
        this.y = r26.getBooleanQueryParameter("disableBounce", false);
        String r28 = UriProtector.getQueryParameter(r26, "backgroundColor");
        this.B = r28;
        if (r28 != null) goto L66;
    L69:
        if (r24 == false) goto L99;
        com.bytedance.ai.model.widgets.c r29 = this.k;
        if (r29 == null) goto L75;
        PageInfo r30 = r29.getPageInfo();
        if (r30 == null) goto L75;
        ReadableMap r31 = r30.getPageSettings();
    L76:
        boolean r32 = v19.h.a;
        if (v19.h.a(null) == true) goto L85;
        if (r31 == null) goto L80;
        String r33 = r31.getString("containerLightBgColor");
    L82:
        if (o0.d(r33) == false) goto L85;
    L83:
        r2 = r33;
    L98:
        this.C = r2;
        goto L99
    L80:
        r33 = null;
    L85:
        if (v19.h.a(null) == false) goto L92;
        if (r31 == null) goto L88;
        r33 = r31.getString("containerDarkBgColor");
    L90:
        if (o0.d(r33) == false) goto L92;
    L88:
        r33 = null;
    L92:
        if (r31 == null) goto L94;
        String r34 = r31.getString("containerBgColor");
    L96:
        if (o0.d(r34) == false) goto L98;
        r2 = r34;
        goto L98
    L94:
        r34 = null;
    L75:
        r31 = null;
    L99:
        this.u = new com.bytedance.applet.jsb.m(this);
        r7.i("AppletFragment", "onCreate url:" + this.g);
        return;
    L66:
        if (r28.length() == 0) goto L69;
        r24 = false;
        goto L69
    L62:
        this.v = r26.getBooleanQueryParameter("hideNavBar", false);
        goto L63
    L54:
        r25 = true;
    L50:
        r22 = "";
        goto L51
    L37:
        r17 = null;
    L33:
        r6 = null;
    L25:
        r14 = "2147483647";
    L15:
        Bundle r35 = getArguments();
        if (r35 == null) goto L18;
        r12 = r35.getString("link_url");
    L19:
        if (r12 != null) goto L21;
        r12 = "";
        goto L21
    L18:
        r12 = null;
        goto L19
    }

    public final void onSaveInstanceState(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "outState");
        super/*androidx.fragment.app.Fragment*/.onSaveInstanceState(r2);
        if (getArguments() == null) goto L5;
        r2.putAll(getArguments());
    L5:
        com.bytedance.ai.model.widgets.c r3 = this.k;
        if (r3 == null) goto L9;
        r3.setPageStatus(PageStatus.RE_CREATE);
        return;
    }

    public final void onViewCreated(View r91, Bundle r92) {
        Intrinsics.checkNotNullParameter(r91, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r91, r92);
        final LarusAppletWebBrowserBinding r2 = this.f;
        if (r2 == null) goto L66;
        LinearLayout r4 = r2.a;
        final ts9.a r0 = com.larus.platform.service.q.a.f();
        String r6 = this.e;
        String r7 = this.g;
        boolean r8 = HttpExtKt.e().a;
        boolean r9 = HttpExtKt.e().c;
        String r10 = HttpExtKt.e().b;
        String r11 = HttpExtKt.e().d;
        b2.a r5 = b2.a;
        String r12 = r5.o();
        String r13 = r5.h();
        Callable r14 = new com.bytedance.applet.view.a(r0);
        Callable r15 = new h(r0);
        List r1 = r0.e;
        if (r1 != null) goto L7;
        r1 = CollectionsKt.emptyList();
    L7:
        final k2.b r16 = new k2.b(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r1, this.y);
        String r3 = this.B;
        if (r3 != null) goto L10;
    L25:
        Integer r17 = null;
    L26:
        if (r17 != null) goto L46;
        String r18 = this.C;
        if (r18 != null) goto L30;
    L45:
        r17 = null;
        goto L46
    L30:
        if (r18.length() <= 0) goto L32;
        boolean r19 = true;
    L33:
        if (r19 == true) goto L36;
        r18 = null;
    L36:
        if (r18 == null) goto L45;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L39
        Object r21 = Result.constructor-impl(Integer.valueOf(X90(r18)));     // Catch: Throwable -> L39
    L42:
        if (Result.isFailure-impl(r21) == false) goto L44;
        r21 = null;
    L44:
        r17 = (Integer) r21;
    L39:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r21 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L42
    L32:
        r19 = false;
    L46:
        if (r17 == null) goto L48;
        r2.k.setBackgroundColor(r17.intValue());
    L48:
        com.bytedance.ai.model.widgets.c r23 = this.k;
        if (r23 == null) goto L51;
        r23.createContainer(r2.k, r16, null, this);
    L52:
        Intrinsics.checkNotNull(r4);
        if (r4.isAttachedToWindow() == true) goto L55;
        r4.addOnAttachStateChangeListener(new b(r4, this, r4));
    L60:
        if (this.v == false) goto L62;
        r2.h.setVisibility(8);
        r2.e.setVisibility(8);
        r2.g.setVisibility(8);
    L65:
        r2.b.setOnClickListener(new i(this));
        r2.d.setVisibility(8);
        r2.d.setOnClickListener(new j(this));
        r2.c.setOnClickListener(new k(this, r2));
        ProgressBar r24 = r2.g;
        r24.setMax(100);
        r24.setProgress(10);
        List r25 = CollectionsKt.listOf(new l0[]{new l0(2131911187, 2131911187, null, null, null, null, null, null, null, false, false, null, 2131242350, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4100, 127), new l0(2131911188, 2131911188, null, null, null, null, null, null, null, false, false, null, 2131242354, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4100, 127)});
        CommonMenu r26 = new CommonMenu(requireContext());
        r26.g(r25, new l(this));
        int r27 = ys9.b.a;
        this.m = ys9.b.a(r2.c, r26.i());
        goto L66
    L62:
        r2.h.setVisibility(0);
        r2.e.setVisibility(8);
        r2.g.setVisibility(0);
        if (TextUtils.isEmpty(this.o) == true) goto L65;
        r2.i.setText(this.o);
        goto L65
    L55:
        if (this.t == false) goto L57;
        int r28 = r4.getPaddingStart();
        int r110 = r4.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r4.getClass().getSimpleName() + ",source:,start:" + r28 + ",top:0,end:" + r110 + ",bottom:0");
        r4.setPaddingRelative(r28, 0, r110, 0);
        goto L60
    L57:
        int r29 = r4.getPaddingStart();
        int r111 = r4.getPaddingTop();
        int r112 = r4.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r4.getClass().getSimpleName() + ",source:,start:" + r29 + ",top:" + r111 + ",end:" + r112 + ",bottom:0");
        r4.setPaddingRelative(r29, r111, r112, 0);
        goto L60
    L51:
        final LinearLayout r30 = r2.k;
        FLogger.a.i("AppletFragment", "createLocalWebView fragment " + this);
        AssembleExtKt.a(this, new e(this, r16, r30));
        goto L52
    L10:
        if (r3.length() <= 0) goto L12;
        boolean r31 = true;
    L13:
        if (r31 == true) goto L16;
        r3 = null;
    L16:
        if (r3 == null) goto L25;
        Result.Companion r32 = Result.Companion;     // Catch: Throwable -> L19
        Object r33 = Result.constructor-impl(Integer.valueOf(Color.parseColor(r3)));     // Catch: Throwable -> L19
    L22:
        if (Result.isFailure-impl(r33) == false) goto L24;
        r33 = null;
    L24:
        r17 = (Integer) r33;
    L19:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        r33 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    L12:
        r31 = false;
    L66:
        FLogger.a.i("AppletFragment", "onViewCreated load kitViewDelegate=" + Y90());
    }

    public static final Object U90(AppletFragment r6, String r7, Continuation r8) {
        r6.getClass();
        if ((r8 instanceof AppletFragment$updateFloatingBotId$1) == false) goto L7;
        AppletFragment$updateFloatingBotId$1 r0 = (AppletFragment$updateFloatingBotId$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r9);
    L44:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        AppletFragment r10 = (AppletFragment) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L35:
        r10.i = (String) r9;
        FLogger.a.i("FloatingSpeaker", "updateBotId " + r6.h + ' ' + r6.i);
        LarusAppletWebBrowserBinding r11 = r6.f;
        if (r11 == null) goto L40;
        FloatingSpeakerView r12 = r11.f;
        if (r12 == null) goto L40;
        String r13 = r6.h;
        String r4 = r6.i;
        Intrinsics.checkNotNullParameter(r13, "botId");
        r12.d = r13;
        r12.e = r4;
    L40:
        r0.L$0 = null;
        r0.label = 2;
        if (r6.Z90(r0) != r2) goto L44;
        return r2;
    L16:
        ResultKt.throwOnFailure(r9);
        if (Intrinsics.areEqual(r6.h, r7) == true) goto L44;
        LarusAppletWebBrowserBinding r14 = r6.f;
        if (r14 == null) goto L23;
        FloatingSpeakerView r15 = r14.f;
        if (r15 == null) goto L23;
        r15.setPlaceHolder(null);
    L23:
        LarusAppletWebBrowserBinding r16 = r6.f;
        if (r16 == null) goto L28;
        FloatingSpeakerView r17 = r16.f;
        if (r17 == null) goto L28;
        r17.f = null;
    L28:
        AppletFragment$setupEventListener$listener$1 r18 = r6.z;
        if (r18 == null) goto L31;
        EventDispatcher r5 = EventDispatcher.a;
        EventDispatcher.l(r6.h, r18);
    L31:
        r6.z = null;
        r6.h = r7;
        MessageUtils r19 = MessageUtils.a;
        r0.L$0 = r6;
        r0.label = 1;
        r9 = r19.d(r7, r0);
        if (r9 == r2) goto L45;
        r10 = r6;
        goto L35
    L45:
        return r2;
    L7:
        r0 = new AppletFragment$updateFloatingBotId$1(r6, r8);
        goto L8
    }

    public final View onCreateView(LayoutInflater r18, ViewGroup r19, Bundle r20) {
        Intrinsics.checkNotNullParameter(r18, "inflater");
        if (r19 == null) goto L7;
        boolean r5 = true;
        if (ViewExtKt.h(r19) != true) goto L7;
    L8:
        if (r5 == false) goto L10;
        ViewExtKt.g(r19);
    L10:
        View r0 = r18.inflate(2131561812, r19, false);
        int r2 = 2131364679;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r0, 2131364679);
        if (r7 == null) goto L64;
        r2 = 2131364767;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(r0, 2131364767);
        if (r8 == null) goto L64;
        r2 = 2131364832;
        ImageView r9 = (ImageView) ViewBindings.findChildViewById(r0, 2131364832);
        if (r9 == null) goto L64;
        r2 = 2131369197;
        View r10 = ViewBindings.findChildViewById(r0, 2131369197);
        if (r10 == null) goto L64;
        r2 = 2131373013;
        FloatingSpeakerView r11 = ViewBindings.findChildViewById(r0, 2131373013);
        if (r11 == null) goto L64;
        r2 = 2131383297;
        ProgressBar r12 = (ProgressBar) ViewBindings.findChildViewById(r0, 2131383297);
        if (r12 == null) goto L64;
        r2 = 2131388807;
        ConstraintLayout r13 = ViewBindings.findChildViewById(r0, 2131388807);
        if (r13 == null) goto L64;
        r2 = 2131391606;
        TextView r14 = (TextView) ViewBindings.findChildViewById(r0, 2131391606);
        if (r14 == null) goto L64;
        r2 = 2131393122;
        FrameLayout r15 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131393122);
        if (r15 == null) goto L64;
        r2 = 2131393131;
        LinearLayout r16 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131393131);
        if (r16 == null) goto L64;
        this.f = new LarusAppletWebBrowserBinding((LinearLayout) r0, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
        v.a(this, new m(this));
        Activity r1 = AppHost.a.a().getCurrentActivity();
        if (r1 == null) goto L38;
        Lazy r3 = i2.f.i;
        i2.f r4 = i2.f.a.a();
        if (r4 == null) goto L35;
        r4.p(r1);
    L35:
        i2.f r6 = i2.f.a.a();
        if (r6 == null) goto L38;
        r6.k(r1);
    L38:
        FLogger.a.i("AppletFragment", "onCreateView");
        com.bytedance.assem.arch.viewModel.e.a.b(this, (RenderStateVM) this.d.getValue(), new n(this));
        if (W90() == false) goto L59;
        this.A = new c(this);
        Function1 r17 = new d(this);
        LarusAppletWebBrowserBinding r21 = this.f;
        if (r21 == null) goto L53;
        FloatingSpeakerView r22 = r21.f;
        if (r22 == null) goto L53;
        Set r23 = r22.a;
        monitor-enter(r23);
        r22.a.add(r17);     // Catch: Throwable -> L50
        monitor-exit(r23);
    L50:
        th = move-exception;
        throw th;
    L53:
        LarusAppletWebBrowserBinding r24 = this.f;
        if (r24 == null) goto L58;
        FloatingSpeakerView r25 = r24.f;
        if (r25 == null) goto L58;
        r25.setRedirectQuery(this.F);
    L58:
        this.H.n(Intrinsics.areEqual(this.D, CommentScene.COMMENTSCENE_NO_AWEME), false);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AppletFragment$initFloatingSpeaker$3(this, null), 2, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new AppletFragment$initFloatingSpeaker$4(this, null), 2, null);
    L59:
        LarusAppletWebBrowserBinding r26 = this.f;
        if (r26 != null) goto L62;
        return null;
    L62:
        return r26.a;
    L64:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r2)));
    L7:
        r5 = false;
        goto L8
    }

    @Override // com.bytedance.assem.arch.viewModel.e
    public final void vT(RenderStateVM r1, com.bytedance.assem.arch.viewModel.i r2, Function1 r3, Function2 r4) {
        com.bytedance.assem.arch.viewModel.e.a.a(this, r1, r2, r3, r4);
    }
}
