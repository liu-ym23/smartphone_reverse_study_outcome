package xv7;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes23.dex */
public final class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView.ViewHolder f565175a;

    public final String toString() {
        return "AddAnimationInfo{holder=" + this.f565175a + '}';
    }

    @Override // xv7.d
    public final RecyclerView.ViewHolder b() {
        return this.f565175a;
    }

    public a(RecyclerView.ViewHolder r100) {
        this.f565175a = r100;
    }

    @Override // xv7.d
    public final void a(RecyclerView.ViewHolder r100) {
        if (this.f565175a != null) goto L6;
        this.f565175a = null;
        return;
    }
}
