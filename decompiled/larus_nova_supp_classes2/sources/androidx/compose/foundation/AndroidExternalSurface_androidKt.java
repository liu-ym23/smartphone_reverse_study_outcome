package androidx.compose.foundation;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001aZ\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\b2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a\r\u0010\u0014\u001a\u00020\u0015H\u0003¢\u0006\u0002\u0010\u0016\u001aR\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"rememberAndroidExternalSurfaceState", "Landroidx/compose/foundation/AndroidExternalSurfaceState;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/AndroidExternalSurfaceState;", "AndroidExternalSurface", "", "modifier", "Landroidx/compose/ui/Modifier;", "isOpaque", "", "surfaceSize", "Landroidx/compose/ui/unit/IntSize;", "zOrder", "Landroidx/compose/foundation/AndroidExternalSurfaceZOrder;", "isSecure", "onInit", "Lkotlin/Function1;", "Landroidx/compose/foundation/AndroidExternalSurfaceScope;", "Lkotlin/ExtensionFunctionType;", "AndroidExternalSurface-58FFMhA", "(Landroidx/compose/ui/Modifier;ZJIZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberAndroidEmbeddedExternalSurfaceState", "Landroidx/compose/foundation/AndroidEmbeddedExternalSurfaceState;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/AndroidEmbeddedExternalSurfaceState;", "AndroidEmbeddedExternalSurface", "transform", "Landroidx/compose/ui/graphics/Matrix;", "AndroidEmbeddedExternalSurface-sv6N_fY", "(Landroidx/compose/ui/Modifier;ZJ[FLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidExternalSurface_androidKt {
    private static final Unit AndroidEmbeddedExternalSurface_sv6N_fY$lambda$18(Modifier r10, boolean r11, long r12, float[] r14, Function1 r15, int r16, int r17, Composer r18, int r19) {
        m335AndroidEmbeddedExternalSurfacesv6N_fY(r10, r11, r12, r14, r15, r18, RecomposeScopeImplKt.updateChangedFlags(r16 | 1), r17);
        return Unit.INSTANCE;
    }

    private static final Unit AndroidExternalSurface_58FFMhA$lambda$8(Modifier r11, boolean r12, long r13, int r15, boolean r16, Function1 r17, int r18, int r19, Composer r20, int r21) {
        m336AndroidExternalSurface58FFMhA(r11, r12, r13, r15, r16, r17, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Modifier r0, boolean r1, long r2, float[] r4, Function1 r5, int r6, int r7, Composer r8, int r9) {
        return AndroidEmbeddedExternalSurface_sv6N_fY$lambda$18(r0, r1, r2, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ SurfaceView b(Function1 r0, AndroidExternalSurfaceState r1, Context r2) {
        return AndroidExternalSurface_58FFMhA$lambda$3$lambda$2(r0, r1, r2);
    }

    public static /* synthetic */ Unit c(long r0, boolean r2, int r3, boolean r4, SurfaceView r5) {
        return AndroidExternalSurface_58FFMhA$lambda$7$lambda$6(r0, r2, r3, r4, r5);
    }

    public static /* synthetic */ TextureView d(Context r0) {
        return AndroidEmbeddedExternalSurface_sv6N_fY$lambda$11$lambda$10(r0);
    }

    public static /* synthetic */ Unit e(TextureView r0) {
        return AndroidEmbeddedExternalSurface_sv6N_fY$lambda$13$lambda$12(r0);
    }

    public static /* synthetic */ Unit f(SurfaceView r0) {
        return AndroidExternalSurface_58FFMhA$lambda$5$lambda$4(r0);
    }

    public static /* synthetic */ Unit g(long r0, AndroidEmbeddedExternalSurfaceState r2, Function1 r3, boolean r4, float[] r5, TextureView r6) {
        return AndroidEmbeddedExternalSurface_sv6N_fY$lambda$17$lambda$16(r0, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Unit h(Modifier r0, boolean r1, long r2, int r4, boolean r5, Function1 r6, int r7, int r8, Composer r9, int r10) {
        return AndroidExternalSurface_58FFMhA$lambda$8(r0, r1, r2, r4, r5, r6, r7, r8, r9, r10);
    }

    private static final TextureView AndroidEmbeddedExternalSurface_sv6N_fY$lambda$11$lambda$10(Context r1) {
        return new TextureView(r1);
    }

    private static final Unit AndroidEmbeddedExternalSurface_sv6N_fY$lambda$13$lambda$12(TextureView r0) {
        return Unit.INSTANCE;
    }

    private static final Unit AndroidExternalSurface_58FFMhA$lambda$5$lambda$4(SurfaceView r0) {
        return Unit.INSTANCE;
    }

    private static final AndroidEmbeddedExternalSurfaceState rememberAndroidEmbeddedExternalSurfaceState(Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1057437053, r4, -1, "androidx.compose.foundation.rememberAndroidEmbeddedExternalSurfaceState (AndroidExternalSurface.android.kt:370)");
    L5:
        Object r5 = r3.rememberedValue();
        Composer.Companion r0 = Composer.Companion;
        if (r5 != r0.getEmpty()) goto L8;
        r5 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r3);
        r3.updateRememberedValue(r5);
    L8:
        CoroutineScope r6 = (CoroutineScope) r5;
        Object r1 = r3.rememberedValue();
        if (r1 != r0.getEmpty()) goto L11;
        r1 = new AndroidEmbeddedExternalSurfaceState(r6);
        r3.updateRememberedValue(r1);
    L11:
        AndroidEmbeddedExternalSurfaceState r2 = (AndroidEmbeddedExternalSurfaceState) r1;
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventEnd();
    L14:
        return r2;
    }

    private static final AndroidExternalSurfaceState rememberAndroidExternalSurfaceState(Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-873615933, r4, -1, "androidx.compose.foundation.rememberAndroidExternalSurfaceState (AndroidExternalSurface.android.kt:187)");
    L5:
        Object r5 = r3.rememberedValue();
        Composer.Companion r0 = Composer.Companion;
        if (r5 != r0.getEmpty()) goto L8;
        r5 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r3);
        r3.updateRememberedValue(r5);
    L8:
        CoroutineScope r6 = (CoroutineScope) r5;
        Object r1 = r3.rememberedValue();
        if (r1 != r0.getEmpty()) goto L11;
        r1 = new AndroidExternalSurfaceState(r6);
        r3.updateRememberedValue(r1);
    L11:
        AndroidExternalSurfaceState r2 = (AndroidExternalSurfaceState) r1;
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventEnd();
    L14:
        return r2;
    }

    private static final SurfaceView AndroidExternalSurface_58FFMhA$lambda$3$lambda$2(Function1 r1, AndroidExternalSurfaceState r2, Context r3) {
        SurfaceView r0 = new SurfaceView(r3);
        r1.invoke(r2);
        r0.getHolder().addCallback(r2);
        return r0;
    }

    private static final Unit AndroidExternalSurface_58FFMhA$lambda$7$lambda$6(long r5, boolean r7, int r8, boolean r9, SurfaceView r10) {
        if (IntSize.equals-impl0(r5, IntSize.Companion.getZero-YbymL2g()) == true) goto L5;
        r10.getHolder().setFixedSize((int) (r5 >> 32), (int) (r5 & 4294967295L));
    L6:
        SurfaceHolder r6 = r10.getHolder();
        if (r7 == false) goto L9;
        int r11 = -1;
    L10:
        r6.setFormat(r11);
        AndroidExternalSurfaceZOrder.Companion r12 = AndroidExternalSurfaceZOrder.Companion;
        if (AndroidExternalSurfaceZOrder.m328equalsimpl0(r8, r12.m332getBehindB_4ceCc()) == false) goto L14;
        r10.setZOrderOnTop(false);
    L19:
        r10.setSecure(r9);
        return Unit.INSTANCE;
    L14:
        if (AndroidExternalSurfaceZOrder.m328equalsimpl0(r8, r12.m333getMediaOverlayB_4ceCc()) == false) goto L17;
        r10.setZOrderMediaOverlay(true);
        goto L19
    L17:
        if (AndroidExternalSurfaceZOrder.m328equalsimpl0(r8, r12.m334getOnTopB_4ceCc()) == false) goto L19;
        r10.setZOrderOnTop(true);
        goto L19
    L9:
        r11 = -3;
        goto L10
    L5:
        r10.getHolder().setSizeFromLayout();
        goto L6
    }

    private static final Unit AndroidEmbeddedExternalSurface_sv6N_fY$lambda$17$lambda$16(long r5, AndroidEmbeddedExternalSurfaceState r7, Function1 r8, boolean r9, float[] r10, TextureView r11) {
        if (IntSize.equals-impl0(r5, IntSize.Companion.getZero-YbymL2g()) == true) goto L7;
        SurfaceTexture r0 = r11.getSurfaceTexture();
        if (r0 == null) goto L7;
        r0.setDefaultBufferSize((int) (r5 >> 32), (int) (4294967295L & r5));
    L7:
        r7.m324setSurfaceSizeozmzZPI(r5);
        if (r11.getSurfaceTextureListener() == r7) goto L10;
        r8.invoke(r7);
        r11.setSurfaceTextureListener(r7);
    L10:
        r11.setOpaque(r9);
        if (r10 == null) goto L13;
        Matrix r6 = r7.getMatrix();
        AndroidMatrixConversions_androidKt.setFrom-EL8BTi8(r6, r10);
    L14:
        r11.setTransform(r6);
        return Unit.INSTANCE;
    L13:
        r6 = null;
        goto L14
    }

    /* JADX INFO: renamed from: AndroidEmbeddedExternalSurface-sv6N_fY, reason: not valid java name */
    public static final void m335AndroidEmbeddedExternalSurfacesv6N_fY(Modifier r23, boolean r24, long r25, float[] r27, final Function1<? super AndroidExternalSurfaceScope, Unit> r28, Composer r29, final int r30, final int r31) {
        Composer r1 = r29.startRestartGroup(217541314);
        int r2 = r31 & 1;
        if (r2 == 0) goto L6;
        int r4 = r30 | 6;
        Modifier r3 = r23;
    L13:
        int r5 = r31 & 2;
        if (r5 == 0) goto L17;
        r4 = r4 | 48;
    L23:
        boolean r8 = r24;
    L25:
        if ((r30 & 384) != 0) goto L33;
        long r11 = r25;
        if ((r31 & 4) == 0) goto L29;
    L31:
        int r9 = 128;
    L32:
        r4 = r4 | r9;
    L34:
        int r10 = r31 & 8;
        if (r10 == 0) goto L38;
        r4 = r4 | 3072;
    L48:
        if ((r31 & 16) == 0) goto L51;
        r4 = r4 | 24576;
    L59:
        if ((r4 & 9363) == 9362) goto L61;
        boolean r6 = true;
    L63:
        if (r1.shouldExecute(r6, r4 & 1) == false) goto L124;
        r1.startDefaults();
        if ((r30 & 1) != 0) goto L67;
    L75:
        if (r2 == 0) goto L77;
        Modifier r7 = Modifier.Companion;
    L78:
        if (r5 == 0) goto L81;
        r8 = true;
    L81:
        if ((r31 & 4) == 0) goto L83;
        r4 = r4 & (-897);
        r11 = IntSize.Companion.getZero-YbymL2g();
    L83:
        if (r10 == 0) goto L73;
        boolean r12 = r8;
        r27 = null;
    L74:
        int r13 = r4;
        final long r14 = r11;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L89;
        ComposerKt.traceEventStart(217541314, r13, -1, "androidx.compose.foundation.AndroidEmbeddedExternalSurface (AndroidExternalSurface.android.kt:432)");
    L89:
        final AndroidEmbeddedExternalSurfaceState r0 = rememberAndroidEmbeddedExternalSurfaceState(r1, 0);
        Object r15 = r1.rememberedValue();
        Composer.Companion r16 = Composer.Companion;
        if (r15 != r16.getEmpty()) goto L92;
        r15 = new g();
        r1.updateRememberedValue(r15);
    L92:
        Function1 r17 = (Function1) r15;
        Object r18 = r1.rememberedValue();
        if (r18 != r16.getEmpty()) goto L95;
        r18 = new h();
        r1.updateRememberedValue(r18);
    L95:
        Function1 r19 = (Function1) r18;
        if (((r13 & 896) ^ 384) <= 256) goto L100;
        if (r1.changed(r14) == false) goto L100;
    L101:
        boolean r110 = true;
    L103:
        boolean r111 = r110 | r1.changedInstance(r0);
        if ((57344 & r13) != 16384) goto L106;
        boolean r112 = true;
    L107:
        boolean r113 = r111 | r112;
        if ((r13 & 112) != 32) goto L110;
        boolean r114 = true;
    L111:
        boolean r115 = r113 | r114;
        if (r27 == null) goto L114;
        androidx.compose.ui.graphics.Matrix r116 = androidx.compose.ui.graphics.Matrix.box-impl(r27);
    L115:
        boolean r117 = r115 | r1.changedInstance(r116);
        Object r118 = r1.rememberedValue();
        if (r117 == false) goto L118;
    L119:
        final boolean r21 = r12;
        final float[] r22 = r27;
        r118 = new i(r14, r0, r28, r21, r22);
        r1.updateRememberedValue(r118);
    L120:
        Modifier r20 = r7;
        AndroidView_androidKt.AndroidView(r17, r20, r19, null, (Function1) r118, r1, ((r13 << 3) & 112) | 390, 8);
        if (ComposerKt.isTraceInProgress() == false) goto L123;
        ComposerKt.traceEventEnd();
    L123:
        r8 = r12;
        final long r26 = r14;
        final float[] r32 = r27;
    L125:
        ScopeUpdateScope r33 = r1.endRestartGroup();
        if (r33 == null) goto L129;
        final Modifier r34 = r7;
        final boolean r35 = r8;
        r33.updateScope(new j(r34, r35, r26, r32, r28, r30, r31));
        return;
    L129:
        return;
    L118:
        if (r118 != r16.getEmpty()) goto L120;
    L114:
        r116 = null;
        goto L115
    L110:
        r114 = false;
        goto L111
    L106:
        r112 = false;
    L100:
        if ((r13 & 384) == 256) goto L101;
        r110 = false;
    L73:
        r12 = r8;
        goto L74
    L77:
        r7 = r3;
        goto L78
    L67:
        if (r1.getDefaultsInvalid() == true) goto L75;
        r1.skipToGroupEnd();
        if ((r31 & 4) == 0) goto L72;
        r4 = r4 & (-897);
    L72:
        r7 = r3;
        goto L73
    L124:
        r1.skipToGroupEnd();
        r32 = r27;
        r7 = r3;
        r26 = r11;
        goto L125
    L61:
        r6 = false;
        goto L63
    L51:
        if ((r30 & 24576) != 0) goto L59;
        if (r1.changedInstance(r28) == false) goto L55;
        int r119 = 16384;
    L56:
        r4 = r4 | r119;
        goto L59
    L55:
        r119 = 8192;
        goto L56
    L38:
        if ((r30 & 3072) != 0) goto L48;
        if (r27 == null) goto L41;
        androidx.compose.ui.graphics.Matrix r120 = androidx.compose.ui.graphics.Matrix.box-impl(r27);
    L43:
        if (r1.changedInstance(r120) == false) goto L45;
        int r121 = 2048;
    L46:
        r4 = r4 | r121;
        goto L48
    L45:
        r121 = 1024;
        goto L46
    L41:
        r120 = null;
        goto L43
    L29:
        if (r1.changed(r11) == false) goto L31;
        r9 = 256;
        goto L32
    L33:
        r11 = r25;
        goto L34
    L17:
        if ((r30 & 48) != 0) goto L23;
        r8 = r24;
        if (r1.changed(r8) == false) goto L21;
        int r36 = 32;
    L22:
        r4 = r4 | r36;
        goto L25
    L21:
        r36 = 16;
        goto L22
    L6:
        if ((r30 & 6) != 0) goto L12;
        r3 = r23;
        if (r1.changed(r3) == false) goto L10;
        int r37 = 4;
    L11:
        r4 = r37 | r30;
        goto L13
    L10:
        r37 = 2;
        goto L11
    L12:
        r3 = r23;
        r4 = r30;
        goto L13
    }

    /* JADX INFO: renamed from: AndroidExternalSurface-58FFMhA, reason: not valid java name */
    public static final void m336AndroidExternalSurface58FFMhA(Modifier r21, boolean r22, long r23, int r25, boolean r26, final Function1<? super AndroidExternalSurfaceScope, Unit> r27, Composer r28, final int r29, final int r30) {
        Composer r1 = r28.startRestartGroup(640888974);
        int r2 = r30 & 1;
        if (r2 == 0) goto L6;
        int r4 = r29 | 6;
        Modifier r3 = r21;
    L13:
        int r5 = r30 & 2;
        if (r5 == 0) goto L17;
        r4 = r4 | 48;
    L23:
        boolean r9 = r22;
    L25:
        if ((r29 & 384) != 0) goto L33;
        long r12 = r23;
        if ((r30 & 4) == 0) goto L29;
    L31:
        int r10 = 128;
    L32:
        r4 = r4 | r10;
    L34:
        int r11 = r30 & 8;
        if (r11 == 0) goto L38;
        r4 = r4 | 3072;
    L44:
        int r15 = r25;
    L45:
        int r16 = r30 & 16;
        if (r16 == 0) goto L49;
        r4 = r4 | 24576;
    L55:
        boolean r14 = r26;
    L57:
        if ((r30 & 32) == 0) goto L60;
        r4 = r4 | 196608;
    L66:
        boolean r19 = true;
        if ((r4 & 74899) == 74898) goto L69;
        boolean r6 = true;
    L71:
        if (r1.shouldExecute(r6, r4 & 1) == false) goto L140;
        r1.startDefaults();
        if ((r29 & 1) != 0) goto L75;
    L83:
        if (r2 == 0) goto L85;
        Modifier r7 = Modifier.Companion;
    L86:
        if (r5 == 0) goto L89;
        r9 = true;
    L89:
        if ((r30 & 4) == 0) goto L91;
        r4 = r4 & (-897);
        r12 = IntSize.Companion.getZero-YbymL2g();
    L91:
        if (r11 == 0) goto L93;
        r15 = AndroidExternalSurfaceZOrder.Companion.m332getBehindB_4ceCc();
    L93:
        boolean r8 = r9;
        if (r16 != 0) goto L95;
    L81:
        boolean r20 = r14;
        int r13 = r15;
    L82:
        int r17 = r4;
        final long r18 = r12;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L99;
        ComposerKt.traceEventStart(640888974, r17, -1, "androidx.compose.foundation.AndroidExternalSurface (AndroidExternalSurface.android.kt:274)");
    L99:
        final AndroidExternalSurfaceState r110 = rememberAndroidExternalSurfaceState(r1, 0);
        if ((458752 & r17) != 131072) goto L102;
        boolean r111 = true;
    L103:
        boolean r112 = r111 | r1.changedInstance(r110);
        Object r113 = r1.rememberedValue();
        if (r112 == false) goto L106;
    L107:
        r113 = new c(r27, r110);
        r1.updateRememberedValue(r113);
    L108:
        Function1 r114 = (Function1) r113;
        Object r115 = r1.rememberedValue();
        Composer.Companion r116 = Composer.Companion;
        if (r115 != r116.getEmpty()) goto L111;
        r115 = new d();
        r1.updateRememberedValue(r115);
    L111:
        Function1 r117 = (Function1) r115;
        if (((r17 & 896) ^ 384) <= 256) goto L116;
        if (r1.changed(r18) == false) goto L116;
    L117:
        boolean r118 = true;
    L120:
        if ((r17 & 112) != 32) goto L122;
        boolean r0 = true;
    L123:
        boolean r24 = r0 | r118;
        if ((r17 & 7168) != 2048) goto L126;
        boolean r119 = true;
    L127:
        boolean r31 = r24 | r119;
        if ((57344 & r17) == 16384) goto L131;
        r19 = false;
    L131:
        boolean r32 = r31 | r19;
        Object r120 = r1.rememberedValue();
        if (r32 == false) goto L134;
    L135:
        final boolean r210 = r8;
        final int r211 = r13;
        final boolean r212 = r20;
        r120 = new e(r18, r210, r211, r212);
        r1.updateRememberedValue(r120);
    L136:
        Modifier r121 = r7;
        AndroidView_androidKt.AndroidView(r114, r121, r117, null, (Function1) r120, r1, ((r17 << 3) & 112) | 384, 8);
        if (ComposerKt.isTraceInProgress() == false) goto L139;
        ComposerKt.traceEventEnd();
    L139:
        r9 = r8;
        final long r33 = r18;
        final int r34 = r13;
        final boolean r35 = r20;
    L141:
        ScopeUpdateScope r122 = r1.endRestartGroup();
        if (r122 == null) goto L145;
        final Modifier r36 = r7;
        final boolean r37 = r9;
        r122.updateScope(new f(r36, r37, r33, r34, r35, r27, r29, r30));
        return;
    L145:
        return;
    L134:
        if (r120 != r116.getEmpty()) goto L136;
    L126:
        r119 = false;
        goto L127
    L122:
        r0 = false;
    L116:
        if ((r17 & 384) == 256) goto L117;
        r118 = false;
        goto L120
    L106:
        if (r113 != Composer.Companion.getEmpty()) goto L108;
    L102:
        r111 = false;
        goto L103
    L95:
        r13 = r15;
        r20 = false;
        goto L82
    L85:
        r7 = r3;
        goto L86
    L75:
        if (r1.getDefaultsInvalid() == true) goto L83;
        r1.skipToGroupEnd();
        if ((r30 & 4) == 0) goto L80;
        r4 = r4 & (-897);
    L80:
        r7 = r3;
        r8 = r9;
        goto L81
    L140:
        r1.skipToGroupEnd();
        r7 = r3;
        r33 = r12;
        r35 = r14;
        r34 = r15;
        goto L141
    L69:
        r6 = false;
        goto L71
    L60:
        if ((r29 & 196608) != 0) goto L66;
        if (r1.changedInstance(r27) == false) goto L64;
        int r123 = 131072;
    L65:
        r4 = r4 | r123;
        goto L66
    L64:
        r123 = 65536;
        goto L65
    L49:
        if ((r29 & 24576) != 0) goto L55;
        r14 = r26;
        if (r1.changed(r14) == false) goto L53;
        int r124 = 16384;
    L54:
        r4 = r4 | r124;
        goto L57
    L53:
        r124 = 8192;
        goto L54
    L38:
        if ((r29 & 3072) != 0) goto L44;
        r15 = r25;
        if (r1.changed(r15) == false) goto L42;
        int r125 = 2048;
    L43:
        r4 = r4 | r125;
        goto L45
    L42:
        r125 = 1024;
        goto L43
    L29:
        if (r1.changed(r12) == false) goto L31;
        r10 = 256;
        goto L32
    L33:
        r12 = r23;
        goto L34
    L17:
        if ((r29 & 48) != 0) goto L23;
        r9 = r22;
        if (r1.changed(r9) == false) goto L21;
        int r126 = 32;
    L22:
        r4 = r4 | r126;
        goto L25
    L21:
        r126 = 16;
        goto L22
    L6:
        if ((r29 & 6) != 0) goto L12;
        r3 = r21;
        if (r1.changed(r3) == false) goto L10;
        int r38 = 4;
    L11:
        r4 = r38 | r29;
        goto L13
    L10:
        r38 = 2;
        goto L11
    L12:
        r3 = r21;
        r4 = r29;
        goto L13
    }
}
