package androidx.compose.material3;

import android.R;
import android.os.Build;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import androidx.activity.BackEventCompat;
import androidx.activity.ComponentDialog;
import androidx.activity.OnBackPressedCallback;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ViewRootForInspector;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.DialogWindowProvider;
import androidx.compose.ui.window.SecureFlagPolicy;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u00017Ba\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0002J&\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020'2\u0011\u0010(\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b)¢\u0006\u0002\u0010*J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020-H\u0002J3\u0010.\u001a\u00020\u00052\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b/\u00100J\u0006\u00101\u001a\u00020\u0005J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u00020\u0005H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\u0014\u0010 \u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u00068"}, d2 = {"Landroidx/compose/material3/ModalBottomSheetDialogWrapper;", "Landroidx/activity/ComponentDialog;", "Landroidx/compose/ui/platform/ViewRootForInspector;", "onDismissRequest", "Lkotlin/Function0;", "", "properties", "Landroidx/compose/material3/ModalBottomSheetProperties;", "contentColor", "Landroidx/compose/ui/graphics/Color;", "composeView", "Landroid/view/View;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "dialogId", "Ljava/util/UUID;", "predictiveBackProgress", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/ModalBottomSheetProperties;JLandroid/view/View;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Ljava/util/UUID;Landroidx/compose/animation/core/Animatable;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "dialogLayout", "Landroidx/compose/material3/ModalBottomSheetDialogLayout;", "maxSupportedElevation", "Landroidx/compose/ui/unit/Dp;", "F", "subCompositionView", "Landroidx/compose/ui/platform/AbstractComposeView;", "getSubCompositionView", "()Landroidx/compose/ui/platform/AbstractComposeView;", "setLayoutDirection", "setContent", "parentComposition", "Landroidx/compose/runtime/CompositionContext;", "children", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", "setSecurePolicy", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "updateParameters", "updateParameters-9LQNqLg", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/ModalBottomSheetProperties;JLandroidx/compose/ui/unit/LayoutDirection;)V", "disposeComposition", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "cancel", "PredictiveBackOnBackPressedCallback", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ModalBottomSheetDialogWrapper extends ComponentDialog implements ViewRootForInspector {
    private final View composeView;
    private long contentColor;
    private final ModalBottomSheetDialogLayout dialogLayout;
    private final float maxSupportedElevation;
    private Function0<Unit> onDismissRequest;
    private ModalBottomSheetProperties properties;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010\u001c\u001a\u00020\fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Landroidx/compose/material3/ModalBottomSheetDialogWrapper$PredictiveBackOnBackPressedCallback;", "Landroidx/activity/OnBackPressedCallback;", "isEnabled", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "predictiveBackProgress", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "onDismissRequest", "Lkotlin/Function0;", "", "<init>", "(ZLkotlinx/coroutines/CoroutineScope;Landroidx/compose/animation/core/Animatable;Lkotlin/jvm/functions/Function0;)V", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "getPredictiveBackProgress", "()Landroidx/compose/animation/core/Animatable;", "getOnDismissRequest", "()Lkotlin/jvm/functions/Function0;", "setOnDismissRequest", "(Lkotlin/jvm/functions/Function0;)V", "handleOnBackStarted", "backEvent", "Landroidx/activity/BackEventCompat;", "handleOnBackProgressed", "handleOnBackPressed", "handleOnBackCancelled", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class PredictiveBackOnBackPressedCallback extends OnBackPressedCallback {
        private Function0<Unit> onDismissRequest;
        private final Animatable<Float, AnimationVector1D> predictiveBackProgress;
        private final CoroutineScope scope;

        public void handleOnBackCancelled() {
            BuildersKt.launch$default(this.scope, null, null, new ModalBottomSheetDialogWrapper$PredictiveBackOnBackPressedCallback$handleOnBackCancelled$1(this, null), 3, null);
        }

        public void handleOnBackPressed() {
            this.onDismissRequest.invoke();
        }

        public final Function0<Unit> getOnDismissRequest() {
            return this.onDismissRequest;
        }

        public final Animatable<Float, AnimationVector1D> getPredictiveBackProgress() {
            return this.predictiveBackProgress;
        }

        public final CoroutineScope getScope() {
            return this.scope;
        }

        public void handleOnBackProgressed(BackEventCompat r7) {
            BuildersKt.launch$default(this.scope, null, null, new ModalBottomSheetDialogWrapper$PredictiveBackOnBackPressedCallback$handleOnBackProgressed$1(this, r7, null), 3, null);
        }

        public void handleOnBackStarted(BackEventCompat r7) {
            BuildersKt.launch$default(this.scope, null, null, new ModalBottomSheetDialogWrapper$PredictiveBackOnBackPressedCallback$handleOnBackStarted$1(this, r7, null), 3, null);
        }

        public final void setOnDismissRequest(Function0<Unit> r1) {
            this.onDismissRequest = r1;
        }

        public PredictiveBackOnBackPressedCallback(boolean r1, CoroutineScope r2, Animatable<Float, AnimationVector1D> r3, Function0<Unit> r4) {
            super(r1);
            this.scope = r2;
            this.predictiveBackProgress = r3;
            this.onDismissRequest = r4;
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[LayoutDirection.values().length];
            r0[LayoutDirection.Ltr.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[LayoutDirection.Rtl.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public /* synthetic */ ModalBottomSheetDialogWrapper(Function0 r1, ModalBottomSheetProperties r2, long r3, View r5, LayoutDirection r6, Density r7, UUID r8, Animatable r9, CoroutineScope r10, DefaultConstructorMarker r11) {
        this(r1, r2, r3, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit b(ModalBottomSheetDialogWrapper r0) {
        return _init_$lambda$3(r0);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
    }

    public final /* synthetic */ View getViewRoot() {
        return ViewRootForInspector.-CC.$default$getViewRoot(this);
    }

    public final void disposeComposition() {
        this.dialogLayout.disposeComposition();
    }

    public AbstractComposeView getSubCompositionView() {
        return this.dialogLayout;
    }

    public static View INVOKEVIRTUAL_androidx_compose_material3_ModalBottomSheetDialogWrapper_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    private static final Unit _init_$lambda$3(ModalBottomSheetDialogWrapper r0) {
        r0.onDismissRequest.invoke();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void setLayoutDirection(LayoutDirection r4) {
        DialogWindowProvider r0 = this.dialogLayout;
        int r5 = WhenMappings.$EnumSwitchMapping$0[r4.ordinal()];
        int r1 = 1;
        if (r5 != 1) goto L5;
        r1 = 0;
    L10:
        r0.setLayoutDirection(r1);
        return;
    L5:
        if (r5 == 2) goto L10;
        throw new NoWhenBranchMatchedException();
    }

    private final void setSecurePolicy(SecureFlagPolicy r3) {
        boolean r4 = BasicEdgeToEdgeDialog_androidKt.shouldApplySecureFlag(r3, ModalBottomSheet_androidKt.isFlagSecureEnabled(this.composeView));
        Window r0 = getWindow();
        Intrinsics.checkNotNull(r0);
        if (r4 == false) goto L5;
        int r5 = 8192;
    L6:
        r0.setFlags(r5, 8192);
        return;
    L5:
        r5 = -8193;
        goto L6
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent r2) {
        boolean r3 = super.onTouchEvent(r2);
        if (r3 == false) goto L5;
        this.onDismissRequest.invoke();
    L5:
        return r3;
    }

    public final void setContent(CompositionContext r2, Function2<? super Composer, ? super Integer, Unit> r3) {
        this.dialogLayout.setContent(r2, r3);
    }

    /* JADX INFO: renamed from: updateParameters-9LQNqLg, reason: not valid java name */
    public final void m2868updateParameters9LQNqLg(Function0<Unit> r1, ModalBottomSheetProperties r2, long r3, LayoutDirection r5) {
        this.onDismissRequest = r1;
        this.properties = r2;
        this.contentColor = r3;
        setSecurePolicy(r2.getSecurePolicy());
        setLayoutDirection(r5);
        Window r4 = getWindow();
        if (r4 == null) goto L5;
        r4.setLayout(-1, -1);
    L5:
        Window r6 = getWindow();
        if (r6 != null) goto L8;
        return;
    L8:
        if (Build.VERSION.SDK_INT < 30) goto L10;
        int r7 = 48;
    L11:
        r6.setSoftInputMode(r7);
        return;
    L10:
        r7 = 16;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.view.View, android.view.ViewGroup, androidx.compose.material3.ModalBottomSheetDialogLayout] */
    private ModalBottomSheetDialogWrapper(Function0<Unit> r9, ModalBottomSheetProperties r10, long r11, View r13, LayoutDirection r14, Density r15, UUID r16, Animatable<Float, AnimationVector1D> r17, CoroutineScope r18) {
        super(new ContextThemeWrapper(r13.getContext(), 2131952372), 0, 2, null);
        this.onDismissRequest = r9;
        this.properties = r10;
        this.contentColor = r11;
        this.composeView = r13;
        float r1 = Dp.constructor-impl(8);
        this.maxSupportedElevation = r1;
        Window r7 = getWindow();
        if (r7 == null) goto L15;
        r7.requestFeature(1);
        r7.setBackgroundDrawableResource(R.color.transparent);
        WindowCompat.setDecorFitsSystemWindows(r7, false);
        ?? r2 = new ModalBottomSheetDialogLayout(getContext(), r7);
        r2.setTag(2131367616, "Dialog:" + r16);
        r2.setClipChildren(false);
        r2.setElevation(r15.toPx-0680j_4(r1));
        r2.setOutlineProvider(new ModalBottomSheetDialogWrapper$1$2());
        this.dialogLayout = r2;
        setContentView(r2);
        ViewTreeLifecycleOwner.set(r2, ViewTreeLifecycleOwner.get(r13));
        ViewTreeViewModelStoreOwner.set(r2, ViewTreeViewModelStoreOwner.get(r13));
        ViewTreeSavedStateRegistryOwner.set(r2, ViewTreeSavedStateRegistryOwner.get(r13));
        m2868updateParameters9LQNqLg(this.onDismissRequest, this.properties, this.contentColor, r14);
        WindowInsetsControllerCompat r0 = WindowCompat.getInsetsController(r7, INVOKEVIRTUAL_androidx_compose_material3_ModalBottomSheetDialogWrapper_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r7));
        Boolean r3 = this.properties.isAppearanceLightStatusBars$material3();
        if (r3 == null) goto L7;
        boolean r4 = r3.booleanValue();
    L8:
        r0.setAppearanceLightStatusBars(r4);
        Boolean r5 = this.properties.isAppearanceLightNavigationBars$material3();
        if (r5 == null) goto L11;
        boolean r6 = r5.booleanValue();
    L12:
        r0.setAppearanceLightNavigationBars(r6);
        getOnBackPressedDispatcher().addCallback(this, new PredictiveBackOnBackPressedCallback(this.properties.getShouldDismissOnBackPress(), r18, r17, new yd(this)));
        return;
    L11:
        r6 = ModalBottomSheet_androidKt.m2876isDark8_81llA(this.contentColor);
        goto L12
    L7:
        r4 = ModalBottomSheet_androidKt.m2876isDark8_81llA(this.contentColor);
        goto L8
    L15:
        throw new IllegalStateException("Dialog has no window".toString());
    }
}
