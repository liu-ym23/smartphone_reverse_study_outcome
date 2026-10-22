package r86;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.lynx.tasm.behavior.LynxContext;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f536516a;

    private Rect getBoundRectForOverflow() {
        if (this.f536516a != 3) goto L6;
        return null;
    L6:
        if ((getContext() instanceof LynxContext) == false) goto L16;
        LynxContext r100 = (LynxContext) getContext();
        int r101 = getWidth();
        int r102 = getHeight();
        DisplayMetrics r103 = r100.getScreenMetrics();
        int r104 = 0;
        if ((getOverflow() & 1) == 0) goto L10;
        int r105 = r103.widthPixels;
        int r106 = 0 - r105;
        r101 = r101 + (r105 * 2);
    L12:
        if ((getOverflow() & 2) == 0) goto L15;
        int r107 = r103.heightPixels;
        r104 = 0 - r107;
        r102 = r102 + (r107 * 2);
    L15:
        return new Rect(r106, r104, r101 + r106, r102 + r104);
    L10:
        r106 = 0;
        goto L12
    L16:
        return null;
    }

    public int getOverflow() {
        return this.f536516a;
    }

    public a(Context r100) {
        super(r100);
        this.f536516a = 0;
    }

    public void setOverflow(int r100) {
        this.f536516a = r100;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        int r105 = this.f536516a;
        if (r105 != 0) goto L5;
        return;
    L5:
        if (r105 != 0) goto L7;
    L10:
        ViewCompat.setClipBounds(this, getBoundRectForOverflow());
        if (getChildAt(0) == null) goto L15;
        ViewCompat.setClipBounds(getChildAt(0), getBoundRectForOverflow());
        return;
    L15:
        return;
    L7:
        if ((getParent() instanceof ViewGroup) == false) goto L9;
        ((ViewGroup) getParent()).setClipChildren(false);
    L9:
        setClipChildren(false);
        goto L10
    }
}
