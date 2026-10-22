package mv2;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes11.dex */
public final class a extends c {
    @Override // mv2.c
    public final int d() {
        return this.f515876a.getWidth();
    }

    @Override // mv2.c
    public final int e() {
        return this.f515876a.getPaddingLeft();
    }

    @Override // mv2.c
    public final int f() {
        return (this.f515876a.getWidth() - this.f515876a.getPaddingLeft()) - this.f515876a.getPaddingRight();
    }

    public a(RecyclerView.LayoutManager r100) {
        super(r100);
    }

    @Override // mv2.c
    public final int a(View r100) {
        RecyclerView.LayoutParams r101 = (RecyclerView.LayoutParams) r100.getLayoutParams();
        return this.f515876a.getDecoratedRight(r100) + ((ViewGroup.MarginLayoutParams) r101).rightMargin;
    }

    @Override // mv2.c
    public final int b(View r100) {
        RecyclerView.LayoutParams r101 = (RecyclerView.LayoutParams) r100.getLayoutParams();
        return (this.f515876a.getDecoratedMeasuredWidth(r100) + ((ViewGroup.MarginLayoutParams) r101).leftMargin) + ((ViewGroup.MarginLayoutParams) r101).rightMargin;
    }

    @Override // mv2.c
    public final int c(View r100) {
        RecyclerView.LayoutParams r101 = (RecyclerView.LayoutParams) r100.getLayoutParams();
        return this.f515876a.getDecoratedLeft(r100) - ((ViewGroup.MarginLayoutParams) r101).leftMargin;
    }
}
