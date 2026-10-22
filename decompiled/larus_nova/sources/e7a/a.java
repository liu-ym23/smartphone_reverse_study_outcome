package e7a;

import androidx.recyclerview.widget.RecyclerView;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.ui.list.ListViewHolder;

/* JADX INFO: loaded from: classes32.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EventEmitter f471206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f471207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f471208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f471209d;

    @Override // e7a.d
    public final void b() {
        this.f471208c.b();
    }

    @Override // e7a.d
    public final void dispose() {
        d r100 = this.f471208c;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    @Override // e7a.d
    public final void a(ListViewHolder r100) {
        this.f471208c.a(r100);
    }

    @Override // e7a.d
    public final void c(ListViewHolder r100) {
        this.f471208c.c(r100);
    }

    @Override // e7a.d
    public final void d(ListViewHolder r100) {
        this.f471208c.d(r100);
    }

    public a(EventEmitter r100, RecyclerView r101) {
        this.f471206a = r100;
        this.f471207b = r101;
        this.f471209d = false;
        this.f471208c = new b(r100);
    }
}
