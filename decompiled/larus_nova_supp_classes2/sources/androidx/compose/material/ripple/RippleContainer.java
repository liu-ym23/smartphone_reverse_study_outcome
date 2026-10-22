package androidx.compose.material.ripple;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J0\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0014J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007H\u0014J\b\u0010\u001a\u001a\u00020\u0010H\u0016J\n\u0010\u001b\u001a\u00020\n*\u00020\u001cJ\n\u0010\u001d\u001a\u00020\u0010*\u00020\u001cR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/compose/material/ripple/RippleContainer;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "MaxRippleHosts", "", "rippleHosts", "", "Landroidx/compose/material/ripple/RippleHostView;", "unusedRippleHosts", "rippleHostMap", "Landroidx/compose/material/ripple/RippleHostMap;", "nextHostIndex", "onLayout", "", "changed", "", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "requestLayout", "getRippleHostView", "Landroidx/compose/material/ripple/RippleHostKey;", "disposeRippleIfNeeded", "material-ripple"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RippleContainer extends ViewGroup {
    public static final int $stable = 8;
    private final int MaxRippleHosts;
    private int nextHostIndex;
    private final RippleHostMap rippleHostMap;
    private final List<RippleHostView> rippleHosts;
    private final List<RippleHostView> unusedRippleHosts;

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
    }

    public RippleContainer(Context r4) {
        super(r4);
        this.MaxRippleHosts = 5;
        ArrayList r0 = new ArrayList();
        this.rippleHosts = r0;
        ArrayList r1 = new ArrayList();
        this.unusedRippleHosts = r1;
        this.rippleHostMap = new RippleHostMap();
        setClipChildren(false);
        RippleHostView r2 = new RippleHostView(r4);
        addView(r2);
        r0.add(r2);
        r1.add(r2);
        this.nextHostIndex = 1;
        setTag(2131374338, Boolean.TRUE);
    }

    public final void disposeRippleIfNeeded(RippleHostKey r3) {
        r3.onResetRippleHostView();
        RippleHostView r0 = this.rippleHostMap.get(r3);
        if (r0 == null) goto L6;
        r0.disposeRipple();
        this.rippleHostMap.remove(r3);
        this.unusedRippleHosts.add(r0);
        return;
    }

    public final RippleHostView getRippleHostView(RippleHostKey r4) {
        RippleHostView r0 = this.rippleHostMap.get(r4);
        if (r0 == null) goto L5;
        return r0;
    L5:
        RippleHostView r1 = (RippleHostView) CollectionsKt.removeFirstOrNull(this.unusedRippleHosts);
        if (r1 == null) goto L8;
    L17:
        this.rippleHostMap.set(r4, r1);
        return r1;
    L8:
        if (this.nextHostIndex <= CollectionsKt.getLastIndex(this.rippleHosts)) goto L10;
        r1 = new RippleHostView(getContext());
        addView(r1);
        this.rippleHosts.add(r1);
    L13:
        int r2 = this.nextHostIndex;
        if (r2 >= (this.MaxRippleHosts - 1)) goto L16;
        this.nextHostIndex = r2 + 1;
        goto L17
    L16:
        this.nextHostIndex = 0;
        goto L17
    L10:
        r1 = (RippleHostView) ListProtector.get(this.rippleHosts, this.nextHostIndex);
        RippleHostKey r3 = this.rippleHostMap.get(r1);
        if (r3 == null) goto L13;
        r3.onResetRippleHostView();
        this.rippleHostMap.remove(r3);
        r1.disposeRipple();
        goto L13
    }

    @Override // android.view.View
    public void onMeasure(int r1, int r2) {
        setMeasuredDimension(0, 0);
    }
}
