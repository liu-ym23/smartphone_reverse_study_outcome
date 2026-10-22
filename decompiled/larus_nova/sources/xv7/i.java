package xv7;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes23.dex */
public class i extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView.ViewHolder f565187a;

    public final String toString() {
        return "RemoveAnimationInfo{holder=" + this.f565187a + '}';
    }

    @Override // xv7.d
    public final RecyclerView.ViewHolder b() {
        return this.f565187a;
    }

    public i(RecyclerView.ViewHolder r100) {
        this.f565187a = r100;
    }

    @Override // xv7.d
    public final void a(RecyclerView.ViewHolder r100) {
        if (this.f565187a != r100) goto L6;
        this.f565187a = null;
        return;
    }
}
