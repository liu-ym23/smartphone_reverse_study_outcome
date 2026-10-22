package com.obric.assistant.window.component;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.component.ObricIntercomComponent;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.window.animation.IWindowAnimationProvider;
import com.obric.assistant.interaction.api.window.animation.IWindowAnimator;
import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 32\u00020\u00012\u00020\u00022\u00020\u0003:\u00013B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020(H\u0016J\u001e\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020/H\u0016J\b\u0010%\u001a\u00020&H\u0016J\u0018\u00100\u001a\u00020,2\u0006\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020/H\u0002J\u0018\u00101\u001a\u00020,2\u0006\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020/H\u0002J\b\u00102\u001a\u00020&H\u0002R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b\"\u0010#R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/obric/assistant/window/component/WindowAnimationComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/obric/assistant/interaction/api/window/animation/IWindowAnimationProvider;", "Lcom/obric/assistant/window/ability/IWindowSlideAnimationStateAbility;", "<init>", "()V", "windowBottomBlurAbility", "Lcom/obric/assistant/window/ability/IWindowBottomBlurAbility;", "getWindowBottomBlurAbility", "()Lcom/obric/assistant/window/ability/IWindowBottomBlurAbility;", "windowBottomBlurAbility$delegate", "Lkotlin/Lazy;", "obricChatPageStateAbility", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "getObricChatPageStateAbility", "()Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "obricChatPageStateAbility$delegate", "intercomAbility", "Lcom/obric/assistant/component/ObricIntercomComponent;", "getIntercomAbility", "()Lcom/obric/assistant/component/ObricIntercomComponent;", "intercomAbility$delegate", "chatFragmentAbility", "Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "getChatFragmentAbility", "()Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "chatFragmentAbility$delegate", "binding", "Lcom/larus/bmhome/ability/IChatCoreBinding;", "getBinding", "()Lcom/larus/bmhome/ability/IChatCoreBinding;", "binding$delegate", "chatRoot", "Landroid/view/ViewGroup;", "getChatRoot", "()Landroid/view/ViewGroup;", "chatRoot$delegate", "isSlideAnimationRunning", "", WidgetCostModule.TYPE_ON_CREATE, "", LiveCommonConstants.REASON_ON_DEDTROY, "getWindowAnimators", "", "Lcom/obric/assistant/interaction/api/window/animation/IWindowAnimator;", "isShow", "type", "Lcom/obric/assistant/interaction/api/window/animation/WindowAnimationType;", "getBottomBlurAnimator", "getChatRootAnimator", "shouldSkipChatRootSlideForLandscape", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowAnimationComponent extends ComponentFeature implements IWindowAnimationProvider, xha.g {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f394718o = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f394719h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f394720i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f394721j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f394722k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f394723l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f394724m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f394725n;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f394726a = null;

        static {
            int[] r100 = new int[WindowAnimationType.values().length];
            r100[WindowAnimationType.None.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[WindowAnimationType.Fade.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[WindowAnimationType.AiKeyOverlayFade.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[WindowAnimationType.Slide.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f394726a = r100;
        }
    }

    public static final class c implements Function0<xha.f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f394727a;

        public c(AttachReceiver r100) {
            this.f394727a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [t1a.a, xha.f] */
        @Override // kotlin.jvm.functions.Function0
        public final xha.f invoke() {
            AttachReceiver r100 = this.f394727a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(xha.f.class));
        }
    }

    public static final class d implements Function0<laa.d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f394728a;

        public d(AttachReceiver r100) {
            this.f394728a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [laa.d, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final laa.d invoke() {
            AttachReceiver r100 = this.f394728a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(laa.d.class));
        }
    }

    public static final class e implements Function0<ObricIntercomComponent> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f394729a;

        public e(AttachReceiver r100) {
            this.f394729a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.assistant.component.ObricIntercomComponent, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final ObricIntercomComponent invoke() {
            AttachReceiver r100 = this.f394729a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(ObricIntercomComponent.class));
        }
    }

    public static final class f implements Function0<va8.m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f394730a;

        public f(AttachReceiver r100) {
            this.f394730a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [t1a.a, va8.m] */
        @Override // kotlin.jvm.functions.Function0
        public final va8.m invoke() {
            AttachReceiver r100 = this.f394730a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(va8.m.class));
        }
    }

    static {
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onCreate() {
        IAssistantChatWindow r100 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r100 == null) goto L6;
        r100.addWindowAnimationCreator(this);
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        IAssistantChatWindow r100 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r100 == null) goto L6;
        r100.removeWindowAnimationCreator(this);
        return;
    }

    public WindowAnimationComponent() {
        this.f394719h = LazyKt.lazy(new c(this));
        this.f394720i = LazyKt.lazy(new d(this));
        this.f394721j = LazyKt.lazy(new e(this));
        this.f394722k = LazyKt.lazy(new f(this));
        this.f394723l = LazyKt.lazy(new q(this));
        this.f394724m = LazyKt.lazy(new r(this));
    }

    @Override // xha.g
    public final boolean Kq() {
        return this.f394725n;
    }

    @Override // com.obric.assistant.interaction.api.window.animation.IWindowAnimationProvider
    public final List<IWindowAnimator> getWindowAnimators(boolean r100, WindowAnimationType r101) {
        Intrinsics.checkNotNullParameter(r101, "type");
        FLogger r102 = FLogger.f375446a;
        r102.i("WindowAnimationComponent", "getWindowAnimators, isShow is " + r100 + ", type is " + r101);
        IWindowAnimator[] r103 = new IWindowAnimator[2];
        IWindowAnimator r104 = new d0(this, r101, r100);
        if (NetworkUtils.isNetworkAvailable(getContext()) == true) goto L5;
        r102.i("WindowAnimationComponent", "network not available");
    L18:
        r103[0] = r104;
        if (r100 == false) goto L21;
        WindowAnimationType r105 = WindowAnimationType.Fade;
    L23:
        if (b.f394726a[r105.ordinal()] != 1) goto L25;
        IWindowAnimator r106 = new s(r101, this, r100);
    L26:
        r103[1] = r106;
        return CollectionsKt.listOf(r103);
    L25:
        r106 = new v(r101, this, r100);
        goto L26
    L21:
        r105 = WindowAnimationType.None;
        goto L23
    L5:
        int r107 = b.f394726a[r101.ordinal()];
        if (r107 == 1) goto L17;
        if (r107 != 2) goto L9;
        r104 = new y(r101, this, r100);
        goto L18
    L9:
        if (r107 != 3) goto L11;
        r104 = new a0(r101, this, r100);
        goto L18
    L11:
        if (r107 == 4) goto L18;
        throw new NoWhenBranchMatchedException();
    L17:
        r104 = new w(r101, this, r100);
        goto L18
    }
}
