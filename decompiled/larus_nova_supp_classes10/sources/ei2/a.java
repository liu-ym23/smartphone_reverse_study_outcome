package ei2;

import android.R;
import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class a extends FrameLayout implements Checkable {
    public static final int[] c = null;
    public int a;
    public boolean b;

    static {
        c = new int[]{R.attr.state_checked};
    }

    public View getTagView() {
        return getChildAt(0);
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.b);
    }

    public int getType() {
        return this.a;
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.b;
    }

    public a(Context r1) {
        super(r1);
        this.a = 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int r2) {
        int[] r3 = super.onCreateDrawableState(r2 + 1);
        if (this.b == false) goto L5;
        FrameLayout.mergeDrawableStates(r3, c);
    L5:
        return r3;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r2) {
        if (this.b == r2) goto L6;
        this.b = r2;
        refreshDrawableState();
        return;
    }

    public void setType(int r1) {
        this.a = r1;
    }
}
