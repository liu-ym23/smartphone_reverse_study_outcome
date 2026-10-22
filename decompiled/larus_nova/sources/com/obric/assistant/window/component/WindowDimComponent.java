package com.obric.assistant.window.component;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.WindowLayoutInfo;
import com.obric.assistant.interaction.api.window.animation.IWindowAnimationProvider;
import com.obric.assistant.interaction.api.window.animation.IWindowAnimator;
import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import com.obric.assistant.spi.window.WindowOpenSource;
import com.obric.common.oea.foundation.animation.token.Token$Delay;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.common.oea.foundation.animation.token.Token$Easing;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 b2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004bcdeB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u00101\u001a\u00020)H\u0016J\b\u00102\u001a\u00020)H\u0016J\b\u00103\u001a\u00020)H\u0016J\u001e\u00104\u001a\b\u0012\u0004\u0012\u000206052\u0006\u00107\u001a\u00020\"2\u0006\u00108\u001a\u000209H\u0016J\u0010\u0010:\u001a\u00020)2\u0006\u0010;\u001a\u00020<H\u0016J\b\u0010=\u001a\u00020)H\u0016J\b\u0010>\u001a\u00020)H\u0016J\u0010\u0010?\u001a\u00020)2\u0006\u0010@\u001a\u00020\"H\u0016J\u0010\u0010A\u001a\u00020)2\u0006\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u00020)H\u0002J\u0012\u0010E\u001a\u00020\"2\b\u0010B\u001a\u0004\u0018\u00010CH\u0002J\b\u0010F\u001a\u00020)H\u0002J \u0010G\u001a\u0002062\u0006\u00107\u001a\u00020\"2\u0006\u00108\u001a\u0002092\u0006\u0010H\u001a\u00020$H\u0002J0\u0010I\u001a\u00020)2\u0006\u0010J\u001a\u00020\"2\u0006\u0010H\u001a\u00020$2\u0016\b\u0002\u0010K\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020)\u0018\u00010(H\u0002J\u0010\u0010L\u001a\u00020)2\u0006\u0010M\u001a\u00020\"H\u0002J\u0010\u0010N\u001a\u00020)2\u0006\u0010O\u001a\u00020,H\u0002J\b\u0010P\u001a\u00020QH\u0002J\u0010\u0010R\u001a\u00020)2\u0006\u0010O\u001a\u00020,H\u0002J\u0010\u0010S\u001a\u00020)2\u0006\u0010O\u001a\u00020,H\u0002J\n\u0010T\u001a\u0004\u0018\u000100H\u0002J \u0010U\u001a\u00020)2\u0006\u0010V\u001a\u00020\u001d2\u0006\u0010W\u001a\u0002002\u0006\u0010\u001c\u001a\u000200H\u0002J\u0010\u0010X\u001a\u00020Y2\u0006\u0010V\u001a\u00020\u001dH\u0002J\b\u0010Z\u001a\u00020)H\u0002J.\u0010[\u001a\u00020)2\b\u0010\\\u001a\u0004\u0018\u00010.2\b\u0010]\u001a\u0004\u0018\u00010.2\u0006\u0010O\u001a\u00020,2\b\u0010^\u001a\u0004\u0018\u00010QH\u0002J \u0010_\u001a\u00020`2\u0006\u0010V\u001a\u00020\u001d2\u0006\u0010W\u001a\u0002002\u0006\u0010\u001c\u001a\u000200H\u0002J\u0018\u0010a\u001a\u00020,2\u0006\u0010J\u001a\u00020\"2\u0006\u0010H\u001a\u00020$H\u0002R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\f\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020)\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006f"}, d2 = {"Lcom/obric/assistant/window/component/WindowDimComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/obric/assistant/interaction/api/window/animation/IWindowAnimationProvider;", "Lcom/obric/assistant/spi/window/WindowLifecycleListener;", "Lcom/obric/assistant/callback/IChatStyleChangedCallback;", "<init>", "()V", "obricChatPageStateAbility", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "getObricChatPageStateAbility", "()Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "obricChatPageStateAbility$delegate", "Lkotlin/Lazy;", "windowBottomBlurAbility", "Lcom/obric/assistant/window/ability/IWindowBottomBlurAbility;", "getWindowBottomBlurAbility", "()Lcom/obric/assistant/window/ability/IWindowBottomBlurAbility;", "windowBottomBlurAbility$delegate", "chatFragmentAbility", "Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "getChatFragmentAbility", "()Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "chatFragmentAbility$delegate", "binding", "Lcom/larus/bmhome/ability/IChatCoreBinding;", "getBinding", "()Lcom/larus/bmhome/ability/IChatCoreBinding;", "binding$delegate", "chatRoot", "Landroid/view/ViewGroup;", "getChatRoot", "()Landroid/view/ViewGroup;", "chatRoot$delegate", "isWindowVisible", "", "backgroundDimScene", "Lcom/obric/assistant/window/component/WindowDimComponent$BackgroundDimScene;", "backgroundDimAnimationManager", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "activeBackgroundDimAnimationEnd", "Lkotlin/Function1;", "", "isWindowDimAnimatorRunning", "currentBackgroundDimAlpha", "", "lastAppliedDimTarget", "Lcom/obric/assistant/window/component/WindowDimComponent$BackgroundDimTarget;", "backgroundDimView", "Landroid/view/View;", WidgetCostModule.TYPE_ON_CREATE, LiveCommonConstants.REASON_ON_DEDTROY, "onParentViewCreated", "getWindowAnimators", "", "Lcom/obric/assistant/interaction/api/window/animation/IWindowAnimator;", "isShow", "type", "Lcom/obric/assistant/interaction/api/window/animation/WindowAnimationType;", "onWindowOpened", "source", "Lcom/obric/assistant/spi/window/WindowOpenSource;", "onWindowStashed", "onWindowDismissed", "onChatStyleChanged", "isChatWindow", "onPageStateChanged", "pageState", "Lcom/obric/assistant/data/ObricFloatChatPageState;", "syncBackgroundDimState", "updateBackgroundDimSceneIfNeeded", "resetBackgroundDimScene", "getBackgroundDimAnimator", "scene", "startBackgroundDimAnimation", "visible", "onEnd", "cancelBackgroundDimAnimation", "notifyEnd", "applyBackgroundDimAlpha", "alpha", "resolveBackgroundDimTargetInfo", "Lcom/obric/assistant/window/component/WindowDimComponent$BackgroundDimTargetInfo;", "applyWindowBackgroundDimAlpha", "applyViewBackgroundDimAlpha", "ensureBackgroundDimView", "ensureBackgroundDimViewOrder", "parent", "dimView", "createBackgroundDimLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "removeBackgroundDimView", "logDimTargetChanged", "previousTarget", "newTarget", "targetInfo", "getDimViewOrderLog", "", "resolveBackgroundDimAlpha", "Companion", "BackgroundDimScene", "BackgroundDimTarget", "BackgroundDimTargetInfo", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowDimComponent extends ComponentFeature implements IWindowAnimationProvider, wga.b, hca.b {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f394736u = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f394737h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f394738i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f394739j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f394740k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f394741l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f394742m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public BackgroundDimScene f394743n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public fja.d f394744o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f394745p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f394746q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f394747r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public BackgroundDimTarget f394748s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f394749t;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/window/component/WindowDimComponent$BackgroundDimScene;", "", "<init>", "(Ljava/lang/String;I)V", "None", "Window", "HalfScreen", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum BackgroundDimScene extends Enum<BackgroundDimScene> {
        public static final BackgroundDimScene HalfScreen = null;
        public static final BackgroundDimScene None = null;
        public static final BackgroundDimScene Window = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BackgroundDimScene[] f394750a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f394751b = null;

        public static EnumEntries<BackgroundDimScene> getEntries() {
            return f394751b;
        }

        static {
            BackgroundDimScene r100 = new BackgroundDimScene("None", 0);
            None = r100;
            BackgroundDimScene r101 = new BackgroundDimScene("Window", 1);
            Window = r101;
            BackgroundDimScene r102 = new BackgroundDimScene("HalfScreen", 2);
            HalfScreen = r102;
            BackgroundDimScene[] r103 = {r100, r101, r102};
            f394750a = r103;
            f394751b = EnumEntriesKt.enumEntries(r103);
        }

        public static BackgroundDimScene[] values() {
            return (BackgroundDimScene[]) f394750a.clone();
        }

        public static BackgroundDimScene valueOf(String r100) {
            return (BackgroundDimScene) r27.a.a(BackgroundDimScene.class, r100);
        }

        public BackgroundDimScene(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/window/component/WindowDimComponent$BackgroundDimTarget;", "", "<init>", "(Ljava/lang/String;I)V", "ViewLayer", "Window", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum BackgroundDimTarget extends Enum<BackgroundDimTarget> {
        public static final BackgroundDimTarget ViewLayer = null;
        public static final BackgroundDimTarget Window = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BackgroundDimTarget[] f394752a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f394753b = null;

        public static EnumEntries<BackgroundDimTarget> getEntries() {
            return f394753b;
        }

        static {
            BackgroundDimTarget r100 = new BackgroundDimTarget("ViewLayer", 0);
            ViewLayer = r100;
            BackgroundDimTarget r101 = new BackgroundDimTarget("Window", 1);
            Window = r101;
            BackgroundDimTarget[] r102 = {r100, r101};
            f394752a = r102;
            f394753b = EnumEntriesKt.enumEntries(r102);
        }

        public static BackgroundDimTarget[] values() {
            return (BackgroundDimTarget[]) f394752a.clone();
        }

        public static BackgroundDimTarget valueOf(String r100) {
            return (BackgroundDimTarget) r27.a.a(BackgroundDimTarget.class, r100);
        }

        public BackgroundDimTarget(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BackgroundDimTarget f394754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f394755b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f394756c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f394754a == r101.f394754a) goto L12;
            return false;
        L12:
            if (this.f394755b == r101.f394755b) goto L15;
            return false;
        L15:
            if (this.f394756c == r101.f394756c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f394754a.hashCode() * 31;
            int r101 = 1231;
            if (this.f394755b == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f394756c == true) goto L11;
            r101 = 1237;
        L11:
            return r103 + r101;
        L5:
            r102 = 1237;
            goto L6
        }

        public final String toString() {
            return "BackgroundDimTargetInfo(target=" + this.f394754a + ", isLandscapeWindow=" + this.f394755b + ", hasLayoutInfo=" + this.f394756c + ')';
        }

        public a(BackgroundDimTarget r100, boolean r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
            this.f394754a = r100;
            this.f394755b = r101;
            this.f394756c = r102;
        }
    }

    public static final class b {
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f394757a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f394758b = null;

        static {
            int[] r100 = new int[BackgroundDimTarget.values().length];
            r100[BackgroundDimTarget.ViewLayer.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[BackgroundDimTarget.Window.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L6:
            f394757a = r100;
            int[] r101 = new int[BackgroundDimScene.values().length];
            r101[BackgroundDimScene.Window.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r101[BackgroundDimScene.HalfScreen.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L21:
            r101[BackgroundDimScene.None.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L10:
            f394758b = r101;
        }
    }

    public static final class d implements Function0<laa.d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f394759a;

        public d(AttachReceiver r100) {
            this.f394759a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [laa.d, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final laa.d invoke() {
            AttachReceiver r100 = this.f394759a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(laa.d.class));
        }
    }

    public static final class e implements Function0<xha.f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f394760a;

        public e(AttachReceiver r100) {
            this.f394760a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [t1a.a, xha.f] */
        @Override // kotlin.jvm.functions.Function0
        public final xha.f invoke() {
            AttachReceiver r100 = this.f394760a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(xha.f.class));
        }
    }

    public static final class f implements Function0<va8.m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f394761a;

        public f(AttachReceiver r100) {
            this.f394761a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [t1a.a, va8.m] */
        @Override // kotlin.jvm.functions.Function0
        public final va8.m invoke() {
            AttachReceiver r100 = this.f394761a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(va8.m.class));
        }
    }

    static {
    }

    @Override // wga.b
    public final void onScreenRotationChanged(int r100, int r101) {
    }

    @Override // wga.b
    public final void onWindowPreDismissed() {
    }

    @Override // wga.b
    public final void onWindowPreOpenClear() {
    }

    @Override // wga.b
    public final void onWindowPreStashed() {
    }

    public static a p3() {
        IAssistantChatWindow r100 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r100 == null) goto L5;
        WindowLayoutInfo r101 = r100.getWindowLayoutInfo();
    L6:
        boolean r102 = false;
        if (r101 != null) goto L9;
    L11:
        boolean r103 = false;
    L12:
        if (r103 == false) goto L14;
        BackgroundDimTarget r104 = BackgroundDimTarget.Window;
    L16:
        if (r101 == null) goto L19;
        r102 = true;
    L19:
        return new a(r104, r103, r102);
    L14:
        r104 = BackgroundDimTarget.ViewLayer;
        goto L16
    L9:
        if (r101.isLandscapeWindowLayout() != true) goto L11;
        r103 = true;
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void B2() {
        FLogger.f375446a.i("WindowDimComponent", "onParentViewCreated: visible=" + this.f394742m + ", scene=" + this.f394743n + ", currentAlpha=" + this.f394747r);
    }

    public final void B3() {
        laa.d r100 = (laa.d) this.f394737h.getValue();
        if (r100 == null) goto L5;
        ObricFloatChatPageState r101 = r100.getPageState();
    L6:
        FLogger.f375446a.i("WindowDimComponent", "syncBackgroundDimState: pageState=" + r101);
        C3(r101);
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void h3() {
        BackgroundDimScene r100 = this.f394743n;
        BackgroundDimScene r101 = BackgroundDimScene.None;
        if (r100 == r101) goto L5;
        FLogger.f375446a.i("WindowDimComponent", "resetBackgroundDimScene: " + this.f394743n + " -> " + r101);
    L5:
        this.f394743n = r101;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onCreate() {
        FLogger.f375446a.i("WindowDimComponent", "onCreate: register dim animation provider, lifecycle and page state callbacks");
        IAssistantChatWindow r100 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r100 == null) goto L5;
        r100.addWindowAnimationCreator(this);
    L5:
        IAssistantChatWindow r101 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r101 == null) goto L8;
        r101.addWindowLifecycleListener(this);
    L8:
        laa.d r102 = (laa.d) this.f394737h.getValue();
        if (r102 == null) goto L12;
        r102.HU(this);
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("onDestroy: currentAlpha=");
        r101.append(this.f394747r);
        r101.append(", lastTarget=");
        r101.append(this.f394748s);
        r101.append(", hasDimView=");
        if (this.f394749t == null) goto L5;
        boolean r102 = true;
    L6:
        r101.append(r102);
        r100.i("WindowDimComponent", r101.toString());
        IAssistantChatWindow r103 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r103 == null) goto L9;
        r103.removeWindowAnimationCreator(this);
    L9:
        IAssistantChatWindow r104 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r104 == null) goto L12;
        r104.removeWindowLifecycleListener(this);
    L12:
        laa.d r105 = (laa.d) this.f394737h.getValue();
        if (r105 == null) goto L15;
        r105.AN(this);
    L15:
        P2(false);
        F2(0.0f);
        View r106 = this.f394749t;
        if (r106 == null) goto L26;
        r100.i("WindowDimComponent", "removeBackgroundDimView: parent=" + r106.getParent());
        ViewParent r107 = r106.getParent();
        if ((r107 instanceof ViewGroup) == false) goto L21;
        ViewGroup r108 = (ViewGroup) r107;
    L22:
        if (r108 == null) goto L24;
        r108.removeView(r106);
    L24:
        this.f394749t = null;
        return;
    L21:
        r108 = null;
        goto L22
    L26:
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // wga.b
    public final void onWindowDismissed() {
        FLogger.f375446a.i("WindowDimComponent", "onWindowDismissed: clear dim");
        this.f394742m = false;
        h3();
        P2(true);
        this.f394747r = 0.0f;
        F2(0.0f);
    }

    @Override // wga.b
    public final void onWindowStashed() {
        FLogger.f375446a.i("WindowDimComponent", "onWindowStashed: hide dim");
        this.f394742m = false;
        h3();
    }

    public WindowDimComponent() {
        this.f394737h = LazyKt.lazy(new d(this));
        this.f394738i = LazyKt.lazy(new e(this));
        this.f394739j = LazyKt.lazy(new f(this));
        this.f394740k = LazyKt.lazy(new i0(this));
        this.f394741l = LazyKt.lazy(new j0(this));
        this.f394743n = BackgroundDimScene.None;
    }

    public static void N2(float r100) {
        IAssistantChatWindow r101 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r101 == null) goto L6;
        r101.updateBackgroundDimAmount(r100);
        return;
    }

    public final boolean C3(ObricFloatChatPageState r100) {
        ObricFloatChatPageData.a r101 = ObricFloatChatPageData.Companion;
        r101.getClass();
        if ((r100 instanceof vda.a) == false) goto L5;
        BackgroundDimScene r102 = BackgroundDimScene.Window;
    L18:
        if (r102 != null) goto L20;
        return false;
    L20:
        BackgroundDimScene r103 = this.f394743n;
        if (r103 == r102) goto L23;
        FLogger.f375446a.i("WindowDimComponent", "updateBackgroundDimSceneIfNeeded: " + r103 + " -> " + r102 + ", pageState=" + r100);
    L23:
        this.f394743n = r102;
        if (r103 == r102) goto L27;
        return true;
    L27:
        return false;
    L5:
        r101.getClass();
        if ((r100 instanceof vda.e) == true) goto L16;
        r101.getClass();
        if ((r100 instanceof vda.d) == true) goto L16;
        r101.getClass();
        if ((r100 instanceof vda.f) == true) goto L16;
        r101.getClass();
        if ((r100 instanceof vda.b) == false) goto L15;
        r102 = BackgroundDimScene.None;
        goto L18
    L15:
        r102 = null;
    L16:
        r102 = BackgroundDimScene.HalfScreen;
        goto L18
    }

    public final void F2(float r100) {
        if (r100 > 0.001f) goto L5;
        float r101 = 0.0f;
    L6:
        this.f394747r = r101;
        if (r101 != 0.0f) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L16;
        BackgroundDimTarget r103 = this.f394748s;
        if (r103 == null) goto L14;
        this.f394748s = null;
        Y2(r103, null, r101, null);
    L14:
        N2(0.0f);
        L2(0.0f);
        return;
    L16:
        a r104 = p3();
        BackgroundDimTarget r105 = this.f394748s;
        BackgroundDimTarget r106 = r104.f394754a;
        if (r105 == r106) goto L19;
        this.f394748s = r106;
        Y2(r105, r106, r101, r104);
    L19:
        BackgroundDimTarget r107 = r104.f394754a;
        int r108 = c.f394757a[r107.ordinal()];
        if (r108 != 1) goto L22;
        N2(0.0f);
        L2(r101);
        return;
    L22:
        if (r108 != 2) goto L25;
        L2(0.0f);
        N2(r101);
        return;
    L25:
        throw new NoWhenBranchMatchedException();
    L9:
        r102 = false;
        goto L10
    L5:
        r101 = RangesKt.coerceIn(r100, 0.0f, 1.0f);
        goto L6
    }

    public final void L2(float r110) {
        if (r110 > 0.001f) goto L5;
        float r111 = 0.0f;
    L6:
        boolean r100 = true;
        if (r111 <= 0.0f) goto L47;
        ViewGroup r101 = (ViewGroup) this.f394741l.getValue();
        Integer r102 = null;
        View r103 = null;
        r103 = null;
        if (r101 != null) goto L11;
        FLogger.f375446a.w("WindowDimComponent", "ensureBackgroundDimView: chatRoot is null");
    L48:
        if (r103 != null) goto L50;
        return;
    L50:
        if (r111 <= 0.0f) goto L55;
        if (r103.getVisibility() == 0) goto L55;
        FLogger.f375446a.i("WindowDimComponent", "applyViewBackgroundDimAlpha: show dim view, alpha=" + r111);
        r103.setVisibility(0);
    L55:
        if (r111 != 0.0f) goto L57;
        boolean r104 = true;
    L58:
        if (r104 == true) goto L60;
    L71:
        r103.setAlpha(r111);
        return;
    L60:
        if (r103.getVisibility() == 8) goto L62;
    L68:
        if (r100 == false) goto L70;
        FLogger.f375446a.i("WindowDimComponent", "applyViewBackgroundDimAlpha: hide dim view");
    L70:
        r103.setVisibility(8);
        goto L71
    L62:
        if (r103.getAlpha() != 0.0f) goto L64;
        boolean r105 = true;
    L65:
        if (r105 == false) goto L68;
        r100 = false;
        goto L68
    L64:
        r105 = false;
        goto L65
    L57:
        r104 = false;
        goto L58
    L11:
        ViewParent r106 = r101.getParent();
        if ((r106 instanceof ViewGroup) == false) goto L14;
        ViewGroup r107 = (ViewGroup) r106;
    L15:
        if (r107 != null) goto L17;
        FLogger.f375446a.w("WindowDimComponent", "ensureBackgroundDimView: chatRoot parent is null");
        goto L48
    L17:
        View r108 = this.f394749t;
        if (r108 != null) goto L21;
        r108 = new View(getContext());
        r108.setBackgroundColor(-16777216);
        r108.setAlpha(0.0f);
        r108.setVisibility(8);
        r108.setClickable(false);
        r108.setImportantForAccessibility(2);
        FLogger.f375446a.i("WindowDimComponent", "ensureBackgroundDimView: create dim view");
        this.f394749t = r108;
    L21:
        if (Intrinsics.areEqual(r108.getParent(), r107) == false) goto L24;
        U2(r107, r108, r101);
    L23:
        r103 = r108;
        goto L48
    L24:
        ViewParent r112 = r108.getParent();
        if ((r112 instanceof ViewGroup) == false) goto L27;
        ViewGroup r113 = (ViewGroup) r112;
    L28:
        if (r113 == null) goto L30;
        FLogger.f375446a.i("WindowDimComponent", "ensureBackgroundDimView: remove dim view from old parent=" + r113);
        r113.removeView(r108);
    L30:
        Integer r114 = Integer.valueOf(r107.indexOfChild(r101));
        if (r114.intValue() < 0) goto L33;
        boolean r115 = true;
    L34:
        if (r115 == false) goto L36;
        r102 = r114;
    L36:
        if (r102 == null) goto L38;
        int r109 = r102.intValue();
    L40:
        if ((r107 instanceof FrameLayout) == false) goto L43;
        ViewGroup.LayoutParams r116 = new FrameLayout.LayoutParams(-1, -1);
    L46:
        r107.addView(r108, r109, r116);
        U2(r107, r108, r101);
        FLogger.f375446a.i("WindowDimComponent", "ensureBackgroundDimView: add dim view, parent=" + r107 + ", requestIndex=" + r109 + ", " + X2(r107, r108, r101));
        goto L23
    L43:
        if ((r107 instanceof ConstraintLayout) == false) goto L45;
        ConstraintLayout.LayoutParams r117 = new ConstraintLayout.LayoutParams(0, 0);
        r117.startToStart = 0;
        r117.endToEnd = 0;
        r117.topToTop = 0;
        r117.bottomToBottom = 0;
        r116 = r117;
        goto L46
    L45:
        r116 = new ViewGroup.LayoutParams(-1, -1);
        goto L46
    L38:
        r109 = r107.getChildCount();
        goto L40
    L33:
        r115 = false;
        goto L34
    L27:
        r113 = null;
        goto L28
    L14:
        r107 = null;
        goto L15
    L47:
        r103 = this.f394749t;
        goto L48
    L5:
        r111 = RangesKt.coerceIn(r110, 0.0f, 1.0f);
        goto L6
    }

    public final void P2(boolean r100) {
        Function1<? super Boolean, Unit> r101 = this.f394745p;
        this.f394745p = null;
        fja.d r102 = this.f394744o;
        if (r102 == null) goto L5;
        int r103 = fja.d.f477533d;
        r102.a(false);
    L5:
        this.f394744o = null;
        this.f394746q = false;
        if (r100 == false) goto L10;
        if (r101 == null) goto L11;
        r101.invoke(Boolean.FALSE);
        return;
    L11:
        return;
    }

    @Override // wga.b
    public final void onWindowOpened(WindowOpenSource r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        FLogger.f375446a.i("WindowDimComponent", "onWindowOpened: source=" + r100);
        B3();
    }

    @Override // wga.b
    public final void onWindowPreOpened(WindowOpenSource r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
    }

    @Override // hca.b
    public final void r2(boolean r100) {
        FLogger.f375446a.i("WindowDimComponent", "onChatStyleChanged: isChatWindow=" + r100 + ", keep dim scene=" + this.f394743n);
    }

    @Override // hca.b
    public final void x1(ObricFloatChatPageState r100) {
        Intrinsics.checkNotNullParameter(r100, "pageState");
        boolean r101 = C3(r100);
        if (this.f394742m == false) goto L8;
        if (r101 == false) goto L8;
        if (this.f394746q == true) goto L8;
        z3(true, this.f394743n, null);
        return;
    L8:
        F2(this.f394747r);
    }

    @Override // com.obric.assistant.interaction.api.window.animation.IWindowAnimationProvider
    public final List<IWindowAnimator> getWindowAnimators(boolean r100, WindowAnimationType r101) {
        Intrinsics.checkNotNullParameter(r101, "type");
        if (r100 == false) goto L5;
        B3();
    L5:
        FLogger.f375446a.i("WindowDimComponent", "getWindowAnimators: isShow=" + r100 + ", type=" + r101 + ", scene=" + this.f394743n + ", currentAlpha=" + this.f394747r);
        return CollectionsKt.listOf(new l0(r100, r101, this.f394743n, this));
    }

    public final float m3(boolean r100, BackgroundDimScene r101) {
        if (r100 == true) goto L5;
        return 0.0f;
    L5:
        boolean r102 = v19.h.f552477a;
        boolean r103 = v19.h.b(getContext());
        int r104 = c.f394758b[r101.ordinal()];
        if (r104 != 1) goto L8;
        if (r103 == false) goto L19;
        return 0.3f;
    L19:
        return 0.16f;
    L8:
        if (r104 != 2) goto L10;
        if (r103 == false) goto L16;
        return 0.6f;
    L16:
        return 0.32f;
    L10:
        if (r104 != 3) goto L13;
        return 0.0f;
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public final void U2(ViewGroup r110, View r111, View r112) {
        int r100 = r110.indexOfChild(r111);
        if (r100 >= 0) goto L5;
        return;
    L5:
        xha.f r101 = (xha.f) this.f394738i.getValue();
        ViewParent r102 = null;
        if (r101 == null) goto L8;
        com.obric.assistant.view.n r103 = r101.Bu();
    L9:
        if (r103 == null) goto L11;
        ViewParent r104 = r103.getParent();
    L12:
        int r105 = -1;
        if (Intrinsics.areEqual(r104, r110) == false) goto L15;
        int r106 = r110.indexOfChild(r103);
    L16:
        int r107 = r110.indexOfChild(r112);
        if (r106 < 0) goto L21;
        if (r100 > r106) goto L21;
        boolean r108 = false;
    L22:
        if (r107 < 0) goto L26;
        if (r100 < r107) goto L26;
        boolean r109 = false;
    L27:
        if (r108 == false) goto L30;
        if (r109 == false) goto L30;
        return;
    L30:
        ViewGroup.LayoutParams r113 = r111.getLayoutParams();
        r110.removeView(r111);
        int r114 = r110.indexOfChild(r112);
        if (r103 == null) goto L34;
        r102 = r103.getParent();
    L34:
        if (Intrinsics.areEqual(r102, r110) == false) goto L36;
        r105 = r110.indexOfChild(r103);
    L36:
        if (r114 < 0) goto L40;
        if (r105 < 0) goto L45;
        if (r114 <= r105) goto L40;
    L45:
        int r115 = RangesKt.coerceIn(r114, 0, r110.getChildCount());
        r110.addView(r111, r115, r113);
        FLogger.f375446a.i("WindowDimComponent", "ensureBackgroundDimViewOrder: move dim view, dimIndex=" + r100 + ", blurIndex=" + r106 + ", chatRootIndex=" + r107 + ", targetIndex=" + r115 + ", " + X2(r110, r111, r112));
        return;
    L40:
        if (r105 < 0) goto L42;
        r114 = r105 + 1;
        goto L45
    L42:
        if (r114 >= 0) goto L45;
        r114 = r110.getChildCount();
    L26:
        r109 = true;
    L21:
        r108 = true;
        goto L22
    L15:
        r106 = -1;
        goto L16
    L11:
        r104 = null;
        goto L12
    L8:
        r103 = null;
        goto L9
    }

    public final String X2(ViewGroup r100, View r101, View r102) {
        xha.f r103 = (xha.f) this.f394738i.getValue();
        ViewParent r104 = null;
        if (r103 == null) goto L5;
        com.obric.assistant.view.n r105 = r103.Bu();
    L6:
        if (r105 == null) goto L9;
        r104 = r105.getParent();
    L9:
        if (Intrinsics.areEqual(r104, r100) == false) goto L11;
        int r106 = r100.indexOfChild(r105);
    L13:
        return "childCount=" + r100.getChildCount() + ", dimIndex=" + r100.indexOfChild(r101) + ", blurIndex=" + r106 + ", chatRootIndex=" + r100.indexOfChild(r102);
    L11:
        r106 = -1;
        goto L13
    L5:
        r105 = null;
        goto L6
    }

    public final void z3(final boolean r110, final BackgroundDimScene r111, Function1<? super Boolean, Unit> r112) {
        final float r100 = m3(r110, r111);
        final float r101 = this.f394747r;
        if (r100 <= 0.0f) goto L5;
        a r102 = p3();
    L6:
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("startBackgroundDimAnimation, visible=");
        r104.append(r110);
        r104.append(", scene=");
        r104.append(r111);
        r104.append(", startAlpha=");
        r104.append(r101);
        r104.append(", targetAlpha=");
        r104.append(r100);
        r104.append(", currentDimTarget=");
        r104.append(this.f394748s);
        r104.append(", targetDimTarget=");
        if (r102 == null) goto L9;
        BackgroundDimTarget r105 = r102.f394754a;
    L10:
        r104.append(r105);
        r104.append(", isLandscapeWindow=");
        if (r102 == null) goto L13;
        Boolean r106 = Boolean.valueOf(r102.f394755b);
    L14:
        r104.append(r106);
        r104.append(", hasLayoutInfo=");
        if (r102 == null) goto L17;
        Boolean r107 = Boolean.valueOf(r102.f394756c);
    L18:
        r104.append(r107);
        r103.i("WindowDimComponent", r104.toString());
        boolean r108 = true;
        if (r101 != r100) goto L21;
        boolean r109 = true;
    L22:
        if (r109 == false) goto L27;
        r103.i("WindowDimComponent", "startBackgroundDimAnimation: skip, startAlpha == targetAlpha");
        F2(r100);
        this.f394745p = null;
        this.f394746q = false;
        if (r112 == null) goto L33;
        r112.invoke(Boolean.TRUE);
        return;
    L33:
        return;
    L27:
        P2(true);
        this.f394745p = r112;
        if (r112 != null) goto L31;
        r108 = false;
    L31:
        this.f394746q = r108;
        F2(r101);
        com.obric.common.oea.foundation.animation.builder.d.a r113 = new com.obric.common.oea.foundation.animation.builder.d.a();
        r113.b(0.0f, 1.0f, gja.b.d(Token$Duration.OUI_ANIMATION_DURATION_SHORT_4, Token$Delay.OUI_ANIMATION_DELAY_NONE, Token$Easing.OUI_ANIMATION_EASING_EASE_OUT_QUAD), null);
        Function3<? super String, Object, Object, Unit> r114 = new g0(this, r101, r100);
        Intrinsics.checkNotNullParameter(r114, "callback");
        r113.f396382d = r114;
        Function2<? super Boolean, ? super Throwable, Unit> r115 = new h0(r110, r111, this, r100);
        Intrinsics.checkNotNullParameter(r115, "callback");
        r113.f396383e = r115;
        this.f394744o = r113.a().a();
        return;
    L21:
        r109 = false;
        goto L22
    L17:
        r107 = null;
        goto L18
    L13:
        r106 = null;
        goto L14
    L9:
        r105 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public final void Y2(BackgroundDimTarget r100, BackgroundDimTarget r101, float r102, a r103) {
        if (r100 != r101) goto L4;
        return;
    L4:
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("DimTarget changed: ");
        r105.append(r100);
        r105.append(" -> ");
        r105.append(r101);
        r105.append(", alpha=");
        r105.append(r102);
        r105.append(", visible=");
        r105.append(this.f394742m);
        r105.append(", scene=");
        r105.append(this.f394743n);
        r105.append(", isLandscapeWindow=");
        Boolean r106 = null;
        if (r103 == null) goto L7;
        Boolean r107 = Boolean.valueOf(r103.f394755b);
    L8:
        r105.append(r107);
        r105.append(", hasLayoutInfo=");
        if (r103 == null) goto L11;
        r106 = Boolean.valueOf(r103.f394756c);
    L11:
        r105.append(r106);
        r104.i("WindowDimComponent", r105.toString());
        return;
    L7:
        r107 = null;
        goto L8
    }
}
