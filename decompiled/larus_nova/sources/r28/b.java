package r28;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.LongSparseArray;
import androidx.recyclerview.widget.RecyclerView;
import q28.c;

/* JADX INFO: loaded from: classes24.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f535785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LongSparseArray<View> f535786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u28.b f535787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Point f535788d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f535789e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Point f535790f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Rect f535791g;

    public b(c r100, u28.a r101) {
        this.f535786b = new LongSparseArray();
        this.f535788d = new Point(-1, -1);
        this.f535789e = new Rect(-1, -1, -1, -1);
        this.f535790f = new Point(-1, -1);
        this.f535791g = new Rect(-1, -1, -1, -1);
        this.f535785a = r100;
        this.f535787c = r101;
    }

    public final View a(RecyclerView r100, int r101) {
        long r102 = this.f535785a.getHeaderId(r101);
        View r103 = this.f535786b.get(r102);
        if (r103 != null) goto L12;
        c r104 = this.f535785a;
        if ((r104 instanceof q28.b) == false) goto L7;
        RecyclerView.ViewHolder r105 = ((q28.b) r104).m0();
    L8:
        this.f535785a.onBindHeaderViewHolder(r105, r101);
        r103 = r105.itemView;
        if (r103.getLayoutParams() != null) goto L11;
        r103.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    L11:
        this.f535786b.put(r102, r103);
        goto L12
    L7:
        r105 = r104.onCreateHeaderViewHolder(r100);
    L12:
        this.f535790f.set(r100.getWidth(), r100.getHeight());
        this.f535791g.set(r100.getPaddingLeft(), r100.getPaddingTop(), r100.getPaddingRight(), r100.getPaddingBottom());
        Point r106 = this.f535788d;
        Point r107 = this.f535790f;
        if (r106 == r107) goto L15;
    L16:
        r106.set(r107.x, r107.y);
        this.f535789e.set(this.f535791g);
        if (((u28.a) this.f535787c).a(r100) != 1) goto L19;
        int r108 = View.MeasureSpec.makeMeasureSpec(r100.getWidth(), 1073741824);
        int r109 = View.MeasureSpec.makeMeasureSpec(r100.getHeight(), 0);
    L20:
        r103.measure(ViewGroup.getChildMeasureSpec(r108, r100.getPaddingLeft() + r100.getPaddingRight(), r103.getLayoutParams().width), ViewGroup.getChildMeasureSpec(r109, r100.getPaddingTop() + r100.getPaddingBottom(), r103.getLayoutParams().height));
        r103.layout(0, 0, r103.getMeasuredWidth(), r103.getMeasuredHeight());
    L21:
        return r103;
    L19:
        r108 = View.MeasureSpec.makeMeasureSpec(r100.getWidth(), 0);
        r109 = View.MeasureSpec.makeMeasureSpec(r100.getHeight(), 1073741824);
        goto L20
    L15:
        if (this.f535789e == this.f535791g) goto L21;
        goto L16
    }
}
