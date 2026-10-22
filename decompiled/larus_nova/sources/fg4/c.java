package fg4;

import android.R;
import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes15.dex */
public final class c extends FrameLayout implements Checkable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f476833b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f476834a;

    public static final class a {
    }

    public final View getTagView() {
        return getChildAt(0);
    }

    static {
        f476833b = new int[]{R.attr.state_checked};
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f476834a);
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f476834a;
    }

    public c(Context r100) {
        super(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int r100) {
        int[] r101 = super.onCreateDrawableState(r100 + 1);
        if (this.f476834a == false) goto L5;
        View.mergeDrawableStates(r101, f476833b);
    L5:
        return r101;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r100) {
        if (this.f476834a == r100) goto L6;
        this.f476834a = r100;
        refreshDrawableState();
        return;
    }
}
