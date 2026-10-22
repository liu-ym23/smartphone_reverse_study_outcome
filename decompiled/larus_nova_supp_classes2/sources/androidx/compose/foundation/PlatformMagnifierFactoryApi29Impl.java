package androidx.compose.foundation;

import android.view.View;
import android.widget.Magnifier;
import androidx.collection.SieveCacheKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JO\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/PlatformMagnifierFactoryApi29Impl;", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "<init>", "()V", "canUpdateZoom", "", "getCanUpdateZoom", "()Z", "create", "Landroidx/compose/foundation/PlatformMagnifierFactoryApi29Impl$PlatformMagnifierImpl;", "view", "Landroid/view/View;", "useTextDefault", "size", "Landroidx/compose/ui/unit/DpSize;", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "elevation", "clippingEnabled", "density", "Landroidx/compose/ui/unit/Density;", "initialZoom", "", "create-nHHXs2Y", "(Landroid/view/View;ZJFFZLandroidx/compose/ui/unit/Density;F)Landroidx/compose/foundation/PlatformMagnifierFactoryApi29Impl$PlatformMagnifierImpl;", "PlatformMagnifierImpl", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PlatformMagnifierFactoryApi29Impl implements PlatformMagnifierFactory {
    public static final int $stable = 0;
    public static final PlatformMagnifierFactoryApi29Impl INSTANCE = null;
    private static final boolean canUpdateZoom = false;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/PlatformMagnifierFactoryApi29Impl$PlatformMagnifierImpl;", "Landroidx/compose/foundation/PlatformMagnifierFactoryApi28Impl$PlatformMagnifierImpl;", "magnifier", "Landroid/widget/Magnifier;", "<init>", "(Landroid/widget/Magnifier;)V", "update", "", "sourceCenter", "Landroidx/compose/ui/geometry/Offset;", "magnifierCenter", "zoom", "", "update-Wko1d7g", "(JJF)V", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class PlatformMagnifierImpl extends PlatformMagnifierFactoryApi28Impl.PlatformMagnifierImpl {
        public static final int $stable = 8;

        public PlatformMagnifierImpl(Magnifier r1) {
            super(r1);
        }

        @Override // androidx.compose.foundation.PlatformMagnifierFactoryApi28Impl.PlatformMagnifierImpl, androidx.compose.foundation.PlatformMagnifier
        /* JADX INFO: renamed from: update-Wko1d7g */
        public void mo448updateWko1d7g(long r7, long r9, float r11) {
            if (Float.isNaN(r11) == true) goto L6;
            getMagnifier().setZoom(r11);
        L6:
            if ((SieveCacheKt.InvalidMapping & r9) == 9205357640488583168L) goto L8;
            boolean r12 = true;
        L10:
            if (r12 == false) goto L12;
            getMagnifier().show(Float.intBitsToFloat((int) (r7 >> 32)), Float.intBitsToFloat((int) (r7 & 4294967295L)), Float.intBitsToFloat((int) (r9 >> 32)), Float.intBitsToFloat((int) (r9 & 4294967295L)));
            return;
        L12:
            getMagnifier().show(Float.intBitsToFloat((int) (r7 >> 32)), Float.intBitsToFloat((int) (r7 & 4294967295L)));
            return;
        L8:
            r12 = false;
            goto L10
        }
    }

    private PlatformMagnifierFactoryApi29Impl() {
    }

    static {
        INSTANCE = new PlatformMagnifierFactoryApi29Impl();
        canUpdateZoom = true;
    }

    @Override // androidx.compose.foundation.PlatformMagnifierFactory
    public boolean getCanUpdateZoom() {
        return canUpdateZoom;
    }

    @Override // androidx.compose.foundation.PlatformMagnifierFactory
    /* JADX INFO: renamed from: create-nHHXs2Y */
    public PlatformMagnifierImpl mo449createnHHXs2Y(View r3, boolean r4, long r5, float r7, float r8, boolean r9, Density r10, float r11) {
        if (r4 == true) goto L4;
        long r6 = r10.toSize-XkaWNTQ(r5);
        float r12 = r10.toPx-0680j_4(r7);
        float r13 = r10.toPx-0680j_4(r8);
        Magnifier.Builder r14 = new Magnifier.Builder(r3);
        if (r6 == 9205357640488583168L) goto L8;
        boolean r15 = true;
    L9:
        if (r15 == false) goto L12;
        r14.setSize(MathKt.roundToInt(Float.intBitsToFloat((int) (r6 >> 32))), MathKt.roundToInt(Float.intBitsToFloat((int) (r6 & 4294967295L))));
    L12:
        if (Float.isNaN(r12) == true) goto L15;
        r14.setCornerRadius(r12);
    L15:
        if (Float.isNaN(r13) == true) goto L18;
        r14.setElevation(r13);
    L18:
        if (Float.isNaN(r11) == true) goto L20;
        r14.setInitialZoom(r11);
    L20:
        r14.setClippingEnabled(r9);
        return new PlatformMagnifierImpl(r14.build());
    L8:
        r15 = false;
        goto L9
    L4:
        return new PlatformMagnifierImpl(new Magnifier(r3));
    }

    @Override // androidx.compose.foundation.PlatformMagnifierFactory
    /* JADX INFO: renamed from: create-nHHXs2Y */
    public /* bridge */ /* synthetic */ PlatformMagnifier mo449createnHHXs2Y(View r1, boolean r2, long r3, float r5, float r6, boolean r7, Density r8, float r9) {
        return mo449createnHHXs2Y(r1, r2, r3, r5, r6, r7, r8, r9);
    }
}
