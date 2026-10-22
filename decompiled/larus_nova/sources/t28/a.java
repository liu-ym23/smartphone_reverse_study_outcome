package t28;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import u28.b;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s28.a f544233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f544234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f544235c;

    public a(u28.a r100) {
        s28.a r101 = new s28.a();
        this.f544235c = new Rect();
        this.f544234b = r100;
        this.f544233a = r101;
    }

    public final void a(RecyclerView r100, Canvas r101, View r102, Rect r103) {
        r101.save();
        if (r100.getLayoutManager().getClipToPadding() == false) goto L9;
        Rect r104 = this.f544235c;
        this.f544233a.getClass();
        s28.a.a(r104, r102);
        if (((u28.a) this.f544234b).a(r100) != 1) goto L7;
        r104.set(r100.getPaddingLeft(), r100.getPaddingTop(), (r100.getWidth() - r100.getPaddingRight()) - r104.right, r100.getHeight() - r100.getPaddingBottom());
    L8:
        r101.clipRect(this.f544235c);
        goto L9
    L7:
        r104.set(r100.getPaddingLeft(), r100.getPaddingTop(), r100.getWidth() - r100.getPaddingRight(), (r100.getHeight() - r100.getPaddingBottom()) - r104.bottom);
    L9:
        r101.translate(r103.left, r103.top);
        r102.draw(r101);
        r101.restore();
    }
}
