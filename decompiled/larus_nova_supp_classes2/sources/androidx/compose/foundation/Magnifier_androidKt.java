package androidx.compose.foundation;

import android.os.Build;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0091\u0001\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0002\b\u000b2\u001b\b\u0002\u0010\f\u001a\u0015\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\u0002\b\u000b2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019\u001a©\u0001\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0002\b\u000b2\u001b\b\u0002\u0010\f\u001a\u0015\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\u0002\b\u000b2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00172\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u00172\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0012\u0010 \u001a\u00020\u00172\b\b\u0002\u0010!\u001a\u00020\"H\u0001\u001a\u0014\u0010#\u001a\u00020\u0017*\u00020\u00112\u0006\u0010$\u001a\u00020\u0011H\u0000\" \u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006%"}, d2 = {"MagnifierPositionInRoot", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Offset;", "getMagnifierPositionInRoot", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "magnifier", "Landroidx/compose/ui/Modifier;", "sourceCenter", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/ExtensionFunctionType;", "magnifierCenter", "onSizeChanged", "Landroidx/compose/ui/unit/DpSize;", "", "zoom", "", "size", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "elevation", "clip", "", "magnifier-UpNRX3w", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FJFFZ)Landroidx/compose/ui/Modifier;", "useTextDefault", "clippingEnabled", "platformMagnifierFactory", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "magnifier-jPUL71Q", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FZJFFZLandroidx/compose/foundation/PlatformMagnifierFactory;)Landroidx/compose/ui/Modifier;", "isPlatformMagnifierSupported", "sdkVersion", "", "equalsIncludingNaN", "other", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class Magnifier_androidKt {
    private static final SemanticsPropertyKey<Function0<Offset>> MagnifierPositionInRoot = null;

    public static final boolean isPlatformMagnifierSupported(int r1) {
        if (r1 < 28) goto L5;
        return true;
    L5:
        return false;
    }

    static {
        MagnifierPositionInRoot = new SemanticsPropertyKey("MagnifierPositionInRoot", null, 2, null);
    }

    public static final SemanticsPropertyKey<Function0<Offset>> getMagnifierPositionInRoot() {
        return MagnifierPositionInRoot;
    }

    public static final boolean equalsIncludingNaN(float r2, float r3) {
        if (Float.isNaN(r2) == false) goto L8;
        if (Float.isNaN(r3) == false) goto L8;
        return true;
    L8:
        if (r2 == r3) goto L12;
        return false;
    L12:
        return true;
    }

    public static /* synthetic */ boolean isPlatformMagnifierSupported$default(int r0, int r1, Object r2) {
        if ((r1 & 1) == 0) goto L6;
        r0 = Build.VERSION.SDK_INT;
    L6:
        return isPlatformMagnifierSupported(r0);
    }

    /* JADX INFO: renamed from: magnifier-UpNRX3w, reason: not valid java name */
    public static final Modifier m422magnifierUpNRX3w(Modifier r14, Function1<? super Density, Offset> r15, Function1<? super Density, Offset> r16, Function1<? super DpSize, Unit> r17, float r18, long r19, float r21, float r22, boolean r23) {
        return m425magnifierjPUL71Q$default(r14, r15, r16, r17, r18, false, r19, r21, r22, r23, null, 512, null);
    }

    /* JADX INFO: renamed from: magnifier-UpNRX3w$default, reason: not valid java name */
    public static /* synthetic */ Modifier m423magnifierUpNRX3w$default(Modifier r8, Function1 r9, Function1 r10, Function1 r11, float r12, long r13, float r15, float r16, boolean r17, int r18, Object r19) {
        Function1 r2 = null;
        if ((r18 & 2) == 0) goto L5;
        Function1 r1 = null;
    L7:
        if ((r18 & 4) != 0) goto L11;
        r2 = r11;
    L11:
        if ((r18 & 8) == 0) goto L13;
        float r3 = Float.NaN;
    L15:
        if ((r18 & 16) == 0) goto L17;
        long r4 = DpSize.Companion.getUnspecified-MYxV2XQ();
    L19:
        if ((r18 & 32) == 0) goto L21;
        float r6 = Dp.Companion.getUnspecified-D9Ej5fM();
    L23:
        if ((r18 & 64) == 0) goto L25;
        float r7 = Dp.Companion.getUnspecified-D9Ej5fM();
    L27:
        if ((r18 & 128) == 0) goto L29;
        boolean r0 = true;
    L31:
        return m422magnifierUpNRX3w(r8, r9, r1, r2, r3, r4, r6, r7, r0);
    L29:
        r0 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r4 = r13;
        goto L19
    L13:
        r3 = r12;
        goto L15
    L5:
        r1 = r10;
        goto L7
    }

    /* JADX INFO: renamed from: magnifier-jPUL71Q, reason: not valid java name */
    public static final Modifier m424magnifierjPUL71Q(Modifier r14, Function1<? super Density, Offset> r15, Function1<? super Density, Offset> r16, Function1<? super DpSize, Unit> r17, float r18, boolean r19, long r20, float r22, float r23, boolean r24, PlatformMagnifierFactory r25) {
        if (isPlatformMagnifierSupported$default(0, 1, null) == false) goto L9;
        if (r25 != null) goto L6;
        PlatformMagnifierFactory r12 = PlatformMagnifierFactory.Companion.getForCurrentPlatform();
    L10:
        return r14.then(new MagnifierElement(r15, r16, r17, r18, r19, r20, r22, r23, r24, r12, null));
    L6:
        r12 = r25;
        goto L10
    L9:
        return r14;
    }

    /* JADX INFO: renamed from: magnifier-jPUL71Q$default, reason: not valid java name */
    public static /* synthetic */ Modifier m425magnifierjPUL71Q$default(Modifier r11, Function1 r12, Function1 r13, Function1 r14, float r15, boolean r16, long r17, float r19, float r20, boolean r21, PlatformMagnifierFactory r22, int r23, Object r24) {
        PlatformMagnifierFactory r2 = null;
        if ((r23 & 2) == 0) goto L5;
        Function1 r1 = null;
    L7:
        if ((r23 & 4) == 0) goto L9;
        Function1 r3 = null;
    L11:
        if ((r23 & 8) == 0) goto L13;
        float r4 = Float.NaN;
    L15:
        if ((r23 & 16) == 0) goto L17;
        boolean r5 = false;
    L19:
        if ((r23 & 32) == 0) goto L21;
        long r6 = DpSize.Companion.getUnspecified-MYxV2XQ();
    L23:
        if ((r23 & 64) == 0) goto L25;
        float r8 = Dp.Companion.getUnspecified-D9Ej5fM();
    L27:
        if ((r23 & 128) == 0) goto L29;
        float r9 = Dp.Companion.getUnspecified-D9Ej5fM();
    L31:
        if ((r23 & 256) == 0) goto L33;
        boolean r10 = true;
    L35:
        if ((r23 & 512) != 0) goto L39;
        r2 = r22;
    L39:
        return m424magnifierjPUL71Q(r11, r12, r1, r3, r4, r5, r6, r8, r9, r10, r2);
    L33:
        r10 = r21;
        goto L35
    L29:
        r9 = r20;
        goto L31
    L25:
        r8 = r19;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r1 = r13;
        goto L7
    }
}
