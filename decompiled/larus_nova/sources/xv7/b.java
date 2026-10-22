package xv7;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes23.dex */
public final class b extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView.ViewHolder f565176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecyclerView.ViewHolder f565177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f565178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f565179d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f565180e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f565181f;

    @Override // xv7.d
    public final RecyclerView.ViewHolder b() {
        RecyclerView.ViewHolder r100 = this.f565177b;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return this.f565176a;
    }

    public final String toString() {
        return "ChangeInfo{, oldHolder=" + this.f565177b + ", newHolder=" + this.f565176a + ", fromX=" + this.f565178c + ", fromY=" + this.f565179d + ", toX=" + this.f565180e + ", toY=" + this.f565181f + '}';
    }

    @Override // xv7.d
    public final void a(RecyclerView.ViewHolder r100) {
        if (this.f565177b != r100) goto L6;
        this.f565177b = null;
    L6:
        if (this.f565176a != r100) goto L9;
        this.f565176a = null;
    L9:
        if (this.f565177b == null) goto L11;
        return;
    L11:
        if (this.f565176a != null) goto L15;
        this.f565178c = 0;
        this.f565179d = 0;
        this.f565180e = 0;
        this.f565181f = 0;
        return;
    }

    public b(RecyclerView.ViewHolder r100, RecyclerView.ViewHolder r101, int r102, int r103, int r104, int r105) {
        this.f565177b = r100;
        this.f565176a = r101;
        this.f565178c = r102;
        this.f565179d = r103;
        this.f565180e = r104;
        this.f565181f = r105;
    }
}
