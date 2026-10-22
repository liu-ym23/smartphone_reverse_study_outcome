package un;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.vlayout.ExposeLinearLayoutManagerEx;

/* JADX INFO: loaded from: classes44.dex */
public final class c extends e {
    @Override // un.e
    public final int f() {
        return this.f550755a.getWidth();
    }

    @Override // un.e
    public final int g() {
        return this.f550755a.getWidth() - this.f550755a.getPaddingRight();
    }

    @Override // un.e
    public final int h() {
        return this.f550755a.getPaddingRight();
    }

    @Override // un.e
    public final int i() {
        return this.f550755a.getPaddingLeft();
    }

    @Override // un.e
    public final int j() {
        return (this.f550755a.getWidth() - this.f550755a.getPaddingLeft()) - this.f550755a.getPaddingRight();
    }

    public c(ExposeLinearLayoutManagerEx r100) {
        super(r100);
    }

    @Override // un.e
    public final int b(View r100) {
        RecyclerView.LayoutParams r101 = (RecyclerView.LayoutParams) r100.getLayoutParams();
        this.f550755a.y();
        return this.f550755a.getDecoratedRight(r100) + ((ViewGroup.MarginLayoutParams) r101).rightMargin;
    }

    @Override // un.e
    public final int c(View r100) {
        RecyclerView.LayoutParams r101 = (RecyclerView.LayoutParams) r100.getLayoutParams();
        this.f550755a.y();
        return (this.f550755a.getDecoratedMeasuredWidth(r100) + ((ViewGroup.MarginLayoutParams) r101).leftMargin) + ((ViewGroup.MarginLayoutParams) r101).rightMargin;
    }

    @Override // un.e
    public final int d(View r100) {
        RecyclerView.LayoutParams r101 = (RecyclerView.LayoutParams) r100.getLayoutParams();
        return (this.f550755a.getDecoratedMeasuredHeight(r100) + ((ViewGroup.MarginLayoutParams) r101).topMargin) + ((ViewGroup.MarginLayoutParams) r101).bottomMargin;
    }

    @Override // un.e
    public final int e(View r100) {
        RecyclerView.LayoutParams r101 = (RecyclerView.LayoutParams) r100.getLayoutParams();
        this.f550755a.y();
        return this.f550755a.getDecoratedLeft(r100) - ((ViewGroup.MarginLayoutParams) r101).leftMargin;
    }

    @Override // un.e
    public final void k(int r100) {
        this.f550755a.offsetChildrenHorizontal(r100);
    }
}
