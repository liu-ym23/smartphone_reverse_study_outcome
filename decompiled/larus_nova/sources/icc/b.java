package icc;

import android.R;
import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes38.dex */
public final class b extends FrameLayout implements Checkable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f489271b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f489272a;

    static {
        f489271b = new int[]{R.attr.state_checked};
    }

    public View getTagView() {
        return getChildAt(0);
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f489272a);
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f489272a;
    }

    public b(Context r100) {
        super(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int r100) {
        int[] r101 = super.onCreateDrawableState(r100 + 1);
        if (this.f489272a == false) goto L5;
        FrameLayout.mergeDrawableStates(r101, f489271b);
    L5:
        return r101;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r100) {
        if (this.f489272a == r100) goto L6;
        this.f489272a = r100;
        refreshDrawableState();
        return;
    }
}
