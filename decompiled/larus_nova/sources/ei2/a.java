package ei2;

import android.R;
import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes10.dex */
public class a extends FrameLayout implements Checkable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f472762c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f472763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f472764b;

    static {
        f472762c = new int[]{R.attr.state_checked};
    }

    public View getTagView() {
        return getChildAt(0);
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f472764b);
    }

    public int getType() {
        return this.f472763a;
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f472764b;
    }

    public a(Context r100) {
        super(r100);
        this.f472763a = 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int r100) {
        int[] r101 = super.onCreateDrawableState(r100 + 1);
        if (this.f472764b == false) goto L5;
        FrameLayout.mergeDrawableStates(r101, f472762c);
    L5:
        return r101;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r100) {
        if (this.f472764b == r100) goto L6;
        this.f472764b = r100;
        refreshDrawableState();
        return;
    }

    public void setType(int r100) {
        this.f472763a = r100;
    }
}
