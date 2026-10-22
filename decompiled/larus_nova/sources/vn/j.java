package vn;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.vlayout.VirtualLayoutManager;

/* JADX INFO: loaded from: classes44.dex */
public final class j extends vn.a {

    public static class a extends k<a> {
        public a() {
            new e();
        }

        public static int b(a r100, boolean r101) {
            r100.getClass();
            r100.getClass();
            throw null;
        }

        public static int c(a r100, boolean r101) {
            r100.getClass();
            r100.getClass();
            throw null;
        }
    }

    static {
        View.MeasureSpec.makeMeasureSpec(0, 0);
    }

    @Override // com.bytedance.android.ec.vlayout.a
    public final void l() {
        throw null;
    }

    @Override // vn.a
    public final boolean y() {
        throw null;
    }

    @Override // vn.a
    public final void A(com.bytedance.android.ec.hybrid.list.ability.l r100) {
        throw null;
    }

    @Override // com.bytedance.android.ec.vlayout.a
    public final void o(int r100) {
        throw null;
    }

    @Override // vn.a
    public final void x(com.bytedance.android.ec.vlayout.b r100) {
        throw null;
    }

    @Override // vn.a
    public final void z(int r100) {
        throw null;
    }

    @Override // vn.a, com.bytedance.android.ec.vlayout.a
    public final void b(RecyclerView.Recycler r100, RecyclerView.State r101, com.bytedance.android.ec.vlayout.b r102) {
        throw null;
    }

    @Override // com.bytedance.android.ec.vlayout.a
    public final void c(RecyclerView.State r100, VirtualLayoutManager.c r101, com.bytedance.android.ec.vlayout.b r102) {
        if (r100.getItemCount() > 0) goto L5;
        return;
    L5:
        int r103 = r101.f49090a;
        throw null;
    }

    @Override // vn.i, com.bytedance.android.ec.vlayout.a
    public final int e(int r100, boolean r101, boolean r102, com.bytedance.android.ec.vlayout.b r103) {
        if (r103.getOrientation() != 1) goto L5;
        boolean r104 = true;
    L7:
        if (r101 == true) goto L9;
        if (r100 == 0) goto L15;
    L14:
        return 0;
    L15:
        a.c(null, r104);
        throw null;
    L9:
        if (r100 != (this.f556365l - 1)) goto L14;
        a.b(null, r104);
        throw null;
    L5:
        r104 = false;
        goto L7
    }

    @Override // vn.a
    public final void w(RecyclerView.Recycler r100, RecyclerView.State r101, VirtualLayoutManager.e r102, g r103, com.bytedance.android.ec.vlayout.b r104) {
        if (j(r102.f49093a.f49067f) == false) goto L5;
        return;
    L5:
        int r105 = r102.f49093a.f49067f;
        throw null;
    }

    @Override // vn.a, com.bytedance.android.ec.vlayout.a
    public final void a(RecyclerView.Recycler r100, RecyclerView.State r101, int r102, int r103, int r104, com.bytedance.android.ec.vlayout.b r105) {
        throw null;
    }
}
