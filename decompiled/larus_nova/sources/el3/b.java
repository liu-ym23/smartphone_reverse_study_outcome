package el3;

import android.R;
import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes14.dex */
public final class b extends FrameLayout implements Checkable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f473008b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f473009a;

    static {
        f473008b = new int[]{R.attr.state_checked};
    }

    public View getTagView() {
        return getChildAt(0);
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f473009a);
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f473009a;
    }

    public b(Context r100) {
        super(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int r100) {
        int[] r101 = super.onCreateDrawableState(r100 + 1);
        if (this.f473009a == false) goto L5;
        FrameLayout.mergeDrawableStates(r101, f473008b);
    L5:
        return r101;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r100) {
        if (this.f473009a == r100) goto L6;
        this.f473009a = r100;
        refreshDrawableState();
        return;
    }
}
