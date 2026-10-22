package mv2;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes11.dex */
public final class b extends c {
    @Override // mv2.c
    public final int d() {
        return this.f515876a.getHeight();
    }

    @Override // mv2.c
    public final int e() {
        return this.f515876a.getPaddingTop();
    }

    @Override // mv2.c
    public final int f() {
        return (this.f515876a.getHeight() - this.f515876a.getPaddingTop()) - this.f515876a.getPaddingBottom();
    }

    public b(RecyclerView.LayoutManager r100) {
        super(r100);
    }

    @Override // mv2.c
    public final int a(View r100) {
        RecyclerView.LayoutParams r101 = (RecyclerView.LayoutParams) r100.getLayoutParams();
        return this.f515876a.getDecoratedBottom(r100) + ((ViewGroup.MarginLayoutParams) r101).bottomMargin;
    }

    @Override // mv2.c
    public final int b(View r100) {
        RecyclerView.LayoutParams r101 = (RecyclerView.LayoutParams) r100.getLayoutParams();
        return (this.f515876a.getDecoratedMeasuredHeight(r100) + ((ViewGroup.MarginLayoutParams) r101).topMargin) + ((ViewGroup.MarginLayoutParams) r101).bottomMargin;
    }

    @Override // mv2.c
    public final int c(View r100) {
        RecyclerView.LayoutParams r101 = (RecyclerView.LayoutParams) r100.getLayoutParams();
        return this.f515876a.getDecoratedTop(r100) - ((ViewGroup.MarginLayoutParams) r101).topMargin;
    }
}
