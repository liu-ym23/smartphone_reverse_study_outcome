package androidx.compose.foundation;

import android.content.Context;
import android.widget.EdgeEffect;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00150\u0017H\u0086\bJ\u0006\u0010\u0018\u001a\u00020\u0015J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010\u001c\u001a\u00020\u001aJ\u0006\u0010\u001d\u001a\u00020\u001aJ\u0006\u0010\u001e\u001a\u00020\u001aJ\u0006\u0010\u001f\u001a\u00020\u001aJ\u0006\u0010 \u001a\u00020\u001aJ\u0006\u0010!\u001a\u00020\u001aJ\u0006\u0010$\u001a\u00020\u001aJ\u0006\u0010%\u001a\u00020\u001aJ\u0006\u0010&\u001a\u00020\u001aJ\u0006\u0010'\u001a\u00020\u001aJ\u0006\u0010)\u001a\u00020\fJ\u0006\u0010*\u001a\u00020\fJ\u0006\u0010+\u001a\u00020\fJ\u0006\u0010,\u001a\u00020\fJ\u0006\u0010-\u001a\u00020\fJ\u0006\u0010.\u001a\u00020\fJ\u0006\u0010/\u001a\u00020\fJ\u0006\u00100\u001a\u00020\fJ\u0010\u00101\u001a\u00020\f2\u0006\u00102\u001a\u000203H\u0002J\u0015\u00104\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b5\u00106R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020\u001a*\u0004\u0018\u00010\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001a\u0010(\u001a\u00020\u001a*\u0004\u0018\u00010\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010#¨\u00067"}, d2 = {"Landroidx/compose/foundation/EdgeEffectWrapper;", "", "context", "Landroid/content/Context;", "glowColor", "", "<init>", "(Landroid/content/Context;I)V", "size", "Landroidx/compose/ui/unit/IntSize;", "J", "topEffect", "Landroid/widget/EdgeEffect;", "bottomEffect", "leftEffect", "rightEffect", "topEffectNegation", "bottomEffectNegation", "leftEffectNegation", "rightEffectNegation", "forEachEffect", "", "action", "Lkotlin/Function1;", "finishAll", "isTopStretched", "", "isBottomStretched", "isLeftStretched", "isRightStretched", "isTopNegationStretched", "isBottomNegationStretched", "isLeftNegationStretched", "isRightNegationStretched", "isStretched", "(Landroid/widget/EdgeEffect;)Z", "isTopAnimating", "isBottomAnimating", "isLeftAnimating", "isRightAnimating", "isAnimating", "getOrCreateTopEffect", "getOrCreateBottomEffect", "getOrCreateLeftEffect", "getOrCreateRightEffect", "getOrCreateTopEffectNegation", "getOrCreateBottomEffectNegation", "getOrCreateLeftEffectNegation", "getOrCreateRightEffectNegation", "createEdgeEffect", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "updateSize", "updateSize-ozmzZPI", "(J)V", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class EdgeEffectWrapper {
    private EdgeEffect bottomEffect;
    private EdgeEffect bottomEffectNegation;
    private final Context context;
    private final int glowColor;
    private EdgeEffect leftEffect;
    private EdgeEffect leftEffectNegation;
    private EdgeEffect rightEffect;
    private EdgeEffect rightEffectNegation;
    private long size;
    private EdgeEffect topEffect;
    private EdgeEffect topEffectNegation;

    public final void finishAll() {
        EdgeEffect r0 = this.topEffect;
        if (r0 == null) goto L5;
        r0.finish();
    L5:
        EdgeEffect r1 = this.bottomEffect;
        if (r1 == null) goto L8;
        r1.finish();
    L8:
        EdgeEffect r2 = this.leftEffect;
        if (r2 == null) goto L11;
        r2.finish();
    L11:
        EdgeEffect r3 = this.rightEffect;
        if (r3 == null) goto L14;
        r3.finish();
    L14:
        EdgeEffect r4 = this.topEffectNegation;
        if (r4 == null) goto L17;
        r4.finish();
    L17:
        EdgeEffect r5 = this.bottomEffectNegation;
        if (r5 == null) goto L20;
        r5.finish();
    L20:
        EdgeEffect r6 = this.leftEffectNegation;
        if (r6 == null) goto L23;
        r6.finish();
    L23:
        EdgeEffect r7 = this.rightEffectNegation;
        if (r7 == null) goto L27;
        r7.finish();
        return;
    }

    public final EdgeEffect getOrCreateBottomEffect() {
        EdgeEffect r0 = this.bottomEffect;
        if (r0 != null) goto L6;
        EdgeEffect r1 = createEdgeEffect(Orientation.Vertical);
        this.bottomEffect = r1;
        return r1;
    L6:
        return r0;
    }

    public final EdgeEffect getOrCreateBottomEffectNegation() {
        EdgeEffect r0 = this.bottomEffectNegation;
        if (r0 != null) goto L6;
        EdgeEffect r1 = createEdgeEffect(Orientation.Vertical);
        this.bottomEffectNegation = r1;
        return r1;
    L6:
        return r0;
    }

    public final EdgeEffect getOrCreateLeftEffect() {
        EdgeEffect r0 = this.leftEffect;
        if (r0 != null) goto L6;
        EdgeEffect r1 = createEdgeEffect(Orientation.Horizontal);
        this.leftEffect = r1;
        return r1;
    L6:
        return r0;
    }

    public final EdgeEffect getOrCreateLeftEffectNegation() {
        EdgeEffect r0 = this.leftEffectNegation;
        if (r0 != null) goto L6;
        EdgeEffect r1 = createEdgeEffect(Orientation.Horizontal);
        this.leftEffectNegation = r1;
        return r1;
    L6:
        return r0;
    }

    public final EdgeEffect getOrCreateRightEffect() {
        EdgeEffect r0 = this.rightEffect;
        if (r0 != null) goto L6;
        EdgeEffect r1 = createEdgeEffect(Orientation.Horizontal);
        this.rightEffect = r1;
        return r1;
    L6:
        return r0;
    }

    public final EdgeEffect getOrCreateRightEffectNegation() {
        EdgeEffect r0 = this.rightEffectNegation;
        if (r0 != null) goto L6;
        EdgeEffect r1 = createEdgeEffect(Orientation.Horizontal);
        this.rightEffectNegation = r1;
        return r1;
    L6:
        return r0;
    }

    public final EdgeEffect getOrCreateTopEffect() {
        EdgeEffect r0 = this.topEffect;
        if (r0 != null) goto L6;
        EdgeEffect r1 = createEdgeEffect(Orientation.Vertical);
        this.topEffect = r1;
        return r1;
    L6:
        return r0;
    }

    public final EdgeEffect getOrCreateTopEffectNegation() {
        EdgeEffect r0 = this.topEffectNegation;
        if (r0 != null) goto L6;
        EdgeEffect r1 = createEdgeEffect(Orientation.Vertical);
        this.topEffectNegation = r1;
        return r1;
    L6:
        return r0;
    }

    public final boolean isBottomAnimating() {
        return isAnimating(this.bottomEffect);
    }

    public final boolean isBottomNegationStretched() {
        return isStretched(this.bottomEffectNegation);
    }

    public final boolean isBottomStretched() {
        return isStretched(this.bottomEffect);
    }

    public final boolean isLeftAnimating() {
        return isAnimating(this.leftEffect);
    }

    public final boolean isLeftNegationStretched() {
        return isStretched(this.leftEffectNegation);
    }

    public final boolean isLeftStretched() {
        return isStretched(this.leftEffect);
    }

    public final boolean isRightAnimating() {
        return isAnimating(this.rightEffect);
    }

    public final boolean isRightNegationStretched() {
        return isStretched(this.rightEffectNegation);
    }

    public final boolean isRightStretched() {
        return isStretched(this.rightEffect);
    }

    public final boolean isTopAnimating() {
        return isAnimating(this.topEffect);
    }

    public final boolean isTopNegationStretched() {
        return isStretched(this.topEffectNegation);
    }

    public final boolean isTopStretched() {
        return isStretched(this.topEffect);
    }

    public static final /* synthetic */ EdgeEffect access$getBottomEffect$p(EdgeEffectWrapper r0) {
        return r0.bottomEffect;
    }

    public static final /* synthetic */ EdgeEffect access$getLeftEffect$p(EdgeEffectWrapper r0) {
        return r0.leftEffect;
    }

    public static final /* synthetic */ EdgeEffect access$getRightEffect$p(EdgeEffectWrapper r0) {
        return r0.rightEffect;
    }

    public static final /* synthetic */ EdgeEffect access$getTopEffect$p(EdgeEffectWrapper r0) {
        return r0.topEffect;
    }

    private final EdgeEffect createEdgeEffect(Orientation r8) {
        EdgeEffect r0 = EdgeEffectCompat.INSTANCE.create(this.context);
        r0.setColor(this.glowColor);
        if (IntSize.equals-impl0(this.size, IntSize.Companion.getZero-YbymL2g()) == false) goto L5;
    L8:
        return r0;
    L5:
        if (r8 != Orientation.Vertical) goto L7;
        long r5 = this.size;
        r0.setSize((int) (r5 >> 32), (int) (r5 & 4294967295L));
        goto L8
    L7:
        long r6 = this.size;
        r0.setSize((int) (4294967295L & r6), (int) (r6 >> 32));
        goto L8
    }

    private final boolean isAnimating(EdgeEffect r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return !r1.isFinished();
    }

    private final boolean isStretched(EdgeEffect r4) {
        boolean r0 = false;
        if (r4 != null) goto L6;
        return false;
    L6:
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(r4) != MenuKt.ClosedAlphaTarget) goto L9;
        r0 = true;
    L9:
        return !r0;
    }

    public final void forEachEffect(Function1<? super EdgeEffect, Unit> r2) {
        EdgeEffect r0 = access$getTopEffect$p(this);
        if (r0 == null) goto L5;
        r2.invoke(r0);
    L5:
        EdgeEffect r1 = access$getBottomEffect$p(this);
        if (r1 == null) goto L8;
        r2.invoke(r1);
    L8:
        EdgeEffect r3 = access$getLeftEffect$p(this);
        if (r3 == null) goto L11;
        r2.invoke(r3);
    L11:
        EdgeEffect r4 = access$getRightEffect$p(this);
        if (r4 == null) goto L15;
        r2.invoke(r4);
        return;
    }

    /* JADX INFO: renamed from: updateSize-ozmzZPI, reason: not valid java name */
    public final void m399updateSizeozmzZPI(long r9) {
        this.size = r9;
        EdgeEffect r0 = this.topEffect;
        if (r0 == null) goto L5;
        r0.setSize((int) (r9 >> 32), (int) (r9 & 4294967295L));
    L5:
        EdgeEffect r1 = this.bottomEffect;
        if (r1 == null) goto L8;
        r1.setSize((int) (r9 >> 32), (int) (r9 & 4294967295L));
    L8:
        EdgeEffect r2 = this.leftEffect;
        if (r2 == null) goto L11;
        r2.setSize((int) (r9 & 4294967295L), (int) (r9 >> 32));
    L11:
        EdgeEffect r3 = this.rightEffect;
        if (r3 == null) goto L14;
        r3.setSize((int) (r9 & 4294967295L), (int) (r9 >> 32));
    L14:
        EdgeEffect r4 = this.topEffectNegation;
        if (r4 == null) goto L17;
        r4.setSize((int) (r9 >> 32), (int) (r9 & 4294967295L));
    L17:
        EdgeEffect r5 = this.bottomEffectNegation;
        if (r5 == null) goto L20;
        r5.setSize((int) (r9 >> 32), (int) (r9 & 4294967295L));
    L20:
        EdgeEffect r6 = this.leftEffectNegation;
        if (r6 == null) goto L23;
        r6.setSize((int) (r9 & 4294967295L), (int) (r9 >> 32));
    L23:
        EdgeEffect r7 = this.rightEffectNegation;
        if (r7 == null) goto L27;
        r7.setSize((int) (4294967295L & r9), (int) (r9 >> 32));
        return;
    }

    public EdgeEffectWrapper(Context r1, int r2) {
        this.context = r1;
        this.glowColor = r2;
        this.size = IntSize.Companion.getZero-YbymL2g();
    }
}
