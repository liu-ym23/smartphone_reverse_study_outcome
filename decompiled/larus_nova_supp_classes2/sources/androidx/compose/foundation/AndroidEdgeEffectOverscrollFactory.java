package androidx.compose.foundation;

import android.content.Context;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/AndroidEdgeEffectOverscrollFactory;", "Landroidx/compose/foundation/OverscrollFactory;", "context", "Landroid/content/Context;", "density", "Landroidx/compose/ui/unit/Density;", "glowColor", "Landroidx/compose/ui/graphics/Color;", "glowDrawPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "<init>", "(Landroid/content/Context;Landroidx/compose/ui/unit/Density;JLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "createOverscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "equals", "", "other", "", "hashCode", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AndroidEdgeEffectOverscrollFactory implements OverscrollFactory {
    private final Context context;
    private final Density density;
    private final long glowColor;
    private final PaddingValues glowDrawPadding;

    public /* synthetic */ AndroidEdgeEffectOverscrollFactory(Context r1, Density r2, long r3, PaddingValues r5, DefaultConstructorMarker r6) {
        this(r1, r2, r3, r5);
    }

    @Override // androidx.compose.foundation.OverscrollFactory
    public OverscrollEffect createOverscrollEffect() {
        return new AndroidEdgeEffectOverscrollEffect(this.context, this.density, this.glowColor, this.glowDrawPadding, null);
    }

    @Override // androidx.compose.foundation.OverscrollFactory
    public int hashCode() {
        return (((((this.context.hashCode() * 31) + this.density.hashCode()) * 31) + Color.hashCode-impl(this.glowColor)) * 31) + this.glowDrawPadding.hashCode();
    }

    @Override // androidx.compose.foundation.OverscrollFactory
    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 == null) goto L8;
        Class<?> r2 = r8.getClass();
    L10:
        if (Intrinsics.areEqual(AndroidEdgeEffectOverscrollFactory.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type androidx.compose.foundation.AndroidEdgeEffectOverscrollFactory");
        AndroidEdgeEffectOverscrollFactory r9 = (AndroidEdgeEffectOverscrollFactory) r8;
        if (Intrinsics.areEqual(this.context, r9.context) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.density, r9.density) == true) goto L19;
        return false;
    L19:
        if (Color.equals-impl0(this.glowColor, r9.glowColor) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.glowDrawPadding, r9.glowDrawPadding) == true) goto L24;
        return false;
    L24:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    private AndroidEdgeEffectOverscrollFactory(Context r1, Density r2, long r3, PaddingValues r5) {
        this.context = r1;
        this.density = r2;
        this.glowColor = r3;
        this.glowDrawPadding = r5;
    }

    public /* synthetic */ AndroidEdgeEffectOverscrollFactory(Context r8, Density r9, long r10, PaddingValues r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 4) == 0) goto L5;
        r10 = AndroidOverscroll_androidKt.access$getDefaultGlowColor$p();
    L5:
        long r3 = r10;
        if ((r13 & 8) == 0) goto L8;
        r12 = AndroidOverscroll_androidKt.access$getDefaultGlowPaddingValues$p();
    L8:
        this(r8, r9, r3, r12, null);
    }
}
