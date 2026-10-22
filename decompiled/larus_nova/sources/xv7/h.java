package xv7;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes23.dex */
public final class h extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f565182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f565183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f565184c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f565185d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RecyclerView.ViewHolder f565186e;

    public final String toString() {
        return "MoveAnimationInfo{holder=" + this.f565186e + ", fromX=" + this.f565182a + ", fromY=" + this.f565183b + ", toX=" + this.f565184c + ", toY=" + this.f565185d + '}';
    }

    @Override // xv7.d
    public final RecyclerView.ViewHolder b() {
        return this.f565186e;
    }

    @Override // xv7.d
    public final void a(RecyclerView.ViewHolder r100) {
        if (this.f565186e != r100) goto L6;
        this.f565186e = null;
        return;
    }

    public h(RecyclerView.ViewHolder r100, int r101, int r102, int r103, int r104) {
        this.f565186e = r100;
        this.f565182a = r101;
        this.f565183b = r102;
        this.f565184c = r103;
        this.f565185d = r104;
    }
}
