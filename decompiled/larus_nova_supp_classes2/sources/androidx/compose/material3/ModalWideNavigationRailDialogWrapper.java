package androidx.compose.material3;

import android.R;
import android.os.Build;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentDialog;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherKt;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002Bo\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00050\u0011\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0002J&\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&2\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b(¢\u0006\u0002\u0010)J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020,H\u0002J$\u0010-\u001a\u00020\u00052\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010.\u001a\u00020\u0005J\u0010\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020\u0005H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u0014\u0010\u001f\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u00063"}, d2 = {"Landroidx/compose/material3/ModalWideNavigationRailDialogWrapper;", "Landroidx/activity/ComponentDialog;", "Landroidx/compose/ui/platform/ViewRootForInspector;", "onDismissRequest", "Lkotlin/Function0;", "", "properties", "Landroidx/compose/material3/ModalWideNavigationRailProperties;", "composeView", "Landroid/view/View;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "dialogId", "Ljava/util/UUID;", "onPredictiveBack", "Lkotlin/Function1;", "", "onPredictiveBackCancelled", "predictiveBackState", "Landroidx/compose/material3/RailPredictiveBackState;", "darkThemeEnabled", "", "<init>", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/ModalWideNavigationRailProperties;Landroid/view/View;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Ljava/util/UUID;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/RailPredictiveBackState;Z)V", "dialogLayout", "Landroidx/compose/material3/ModalWideNavigationRailDialogLayout;", "maxSupportedElevation", "Landroidx/compose/ui/unit/Dp;", "F", "subCompositionView", "Landroidx/compose/ui/platform/AbstractComposeView;", "getSubCompositionView", "()Landroidx/compose/ui/platform/AbstractComposeView;", "setLayoutDirection", "setContent", "parentComposition", "Landroidx/compose/runtime/CompositionContext;", "children", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", "setSecurePolicy", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "updateParameters", "disposeComposition", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "cancel", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ModalWideNavigationRailDialogWrapper extends ComponentDialog implements ViewRootForInspector {
    private final View composeView;
    private final ModalWideNavigationRailDialogLayout dialogLayout;
    private final float maxSupportedElevation;
    private Function0<Unit> onDismissRequest;
    private ModalWideNavigationRailProperties properties;

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

    public static /* synthetic */ Unit b(ModalWideNavigationRailDialogWrapper r0, OnBackPressedCallback r1) {
        return _init_$lambda$3(r0, r1);
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

    public static View INVOKEVIRTUAL_androidx_compose_material3_ModalWideNavigationRailDialogWrapper_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
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

    private static final Unit _init_$lambda$3(ModalWideNavigationRailDialogWrapper r0, OnBackPressedCallback r1) {
        if (r0.properties.getShouldDismissOnBackPress() == false) goto L6;
        r0.onDismissRequest.invoke();
    L6:
        return Unit.INSTANCE;
    }

    public final void setContent(CompositionContext r2, Function2<? super Composer, ? super Integer, Unit> r3) {
        this.dialogLayout.setContent(r2, r3);
    }

    public final void updateParameters(Function0<Unit> r1, ModalWideNavigationRailProperties r2, LayoutDirection r3) {
        this.onDismissRequest = r1;
        this.properties = r2;
        setSecurePolicy(r2.getSecurePolicy());
        setLayoutDirection(r3);
        Window r4 = getWindow();
        if (r4 == null) goto L5;
        r4.setLayout(-1, -1);
    L5:
        Window r5 = getWindow();
        if (r5 != null) goto L8;
        return;
    L8:
        if (Build.VERSION.SDK_INT < 30) goto L10;
        int r6 = 48;
    L11:
        r5.setSoftInputMode(r6);
        return;
    L10:
        r6 = 16;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [android.view.View, android.view.ViewGroup, androidx.compose.material3.ModalWideNavigationRailDialogLayout] */
    public ModalWideNavigationRailDialogWrapper(Function0<Unit> r17, ModalWideNavigationRailProperties r18, View r19, LayoutDirection r20, Density r21, UUID r22, Function1<? super Float, Unit> r23, Function0<Unit> r24, RailPredictiveBackState r25, boolean r26) {
        super(new ContextThemeWrapper(r19.getContext(), 2131952372), 0, 2, null);
        this.onDismissRequest = r17;
        this.properties = r18;
        this.composeView = r19;
        float r2 = Dp.constructor-impl(8);
        this.maxSupportedElevation = r2;
        Window r3 = getWindow();
        if (r3 == null) goto L7;
        r3.requestFeature(1);
        r3.setBackgroundDrawableResource(R.color.transparent);
        WindowCompat.setDecorFitsSystemWindows(r3, false);
        ?? r15 = new ModalWideNavigationRailDialogLayout(getContext(), r3, this.properties.getShouldDismissOnBackPress(), this.onDismissRequest, r23, r24, r25, r20);
        r15.setTag(2131367616, "Dialog:" + r22);
        r15.setClipChildren(false);
        r15.setElevation(r21.toPx-0680j_4(r2));
        r15.setOutlineProvider(new ModalWideNavigationRailDialogWrapper$1$2());
        this.dialogLayout = r15;
        setContentView(r15);
        ViewTreeLifecycleOwner.set(r15, ViewTreeLifecycleOwner.get(r19));
        ViewTreeViewModelStoreOwner.set(r15, ViewTreeViewModelStoreOwner.get(r19));
        ViewTreeSavedStateRegistryOwner.set(r15, ViewTreeSavedStateRegistryOwner.get(r19));
        updateParameters(this.onDismissRequest, this.properties, r20);
        WindowInsetsControllerCompat r1 = WindowCompat.getInsetsController(r3, INVOKEVIRTUAL_androidx_compose_material3_ModalWideNavigationRailDialogWrapper_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r3));
        r1.setAppearanceLightStatusBars(!r26);
        r1.setAppearanceLightNavigationBars(!r26);
        OnBackPressedDispatcherKt.addCallback$default(getOnBackPressedDispatcher(), this, false, new Cif(this), 2, null);
        return;
    L7:
        throw new IllegalStateException("Dialog has no window".toString());
    }
}
