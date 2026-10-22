package vqc;

import android.R;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

/* JADX INFO: loaded from: classes41.dex */
public final class h extends StateListDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f556804a;

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] r100) {
        int r101 = r100.length;
        int r102 = 0;
        boolean r103 = false;
    L3:
        if (r102 >= r101) goto L8;
        if (r100[r102] != 16842913) goto L7;
        r103 = true;
    L7:
        r102 = r102 + 1;
        goto L3
    L8:
        if (r103 == false) goto L10;
        setColorFilter(this.f556804a, PorterDuff.Mode.SRC_ATOP);
    L12:
        return super.onStateChange(r100);
    L10:
        clearColorFilter();
        goto L12
    }

    public h(Drawable r100, int r101) {
        this.f556804a = r101;
        addState(new int[]{R.attr.state_selected}, r100);
        addState(new int[0], r100);
    }
}
