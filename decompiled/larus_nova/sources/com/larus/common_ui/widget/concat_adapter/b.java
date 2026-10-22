package com.larus.common_ui.widget.concat_adapter;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a29.a.C0007a f328574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.d f328575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView.Adapter<RecyclerView.ViewHolder> f328576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC4191b f328577d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f328578e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f328579f;

    public class a extends RecyclerView.AdapterDataObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f328580a;

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onChanged() {
            b r100 = this.f328580a;
            r100.f328578e = r100.f328576c.getItemCount();
            com.larus.common_ui.widget.concat_adapter.a r101 = (com.larus.common_ui.widget.concat_adapter.a) this.f328580a.f328577d;
            RecyclerView r102 = r101.d();
            if (r102 != null) goto L5;
        L8:
            FLogger.f375446a.e("ConcatAdapterController", "onChanged return, recyclerView is null or is computing layout");
            return;
        L5:
            if (r102.isComputingLayout() == true) goto L8;
            r101.f328563a.notifyDataSetChanged();
        }

        public a(b r100) {
            this.f328580a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int r100, int r101) {
            b r102 = this.f328580a;
            ((com.larus.common_ui.widget.concat_adapter.a) r102.f328577d).g(r102, r100, r101, null);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int r100, int r101) {
            b r102 = this.f328580a;
            r102.f328578e += r101;
            com.larus.common_ui.widget.concat_adapter.a r103 = (com.larus.common_ui.widget.concat_adapter.a) r102.f328577d;
            RecyclerView r104 = r103.d();
            if (r104 != null) goto L5;
        L8:
            FLogger.f375446a.e("ConcatAdapterController", "onItemRangeInserted return, recyclerView is null or is computing layout");
            return;
        L5:
            if (r104.isComputingLayout() == true) goto L8;
            r103.f328563a.notifyItemRangeInserted(r100 + r103.b(r102), r101);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int r100, int r101) {
            b r102 = this.f328580a;
            r102.f328578e -= r101;
            com.larus.common_ui.widget.concat_adapter.a r103 = (com.larus.common_ui.widget.concat_adapter.a) r102.f328577d;
            RecyclerView r104 = r103.d();
            if (r104 != null) goto L5;
        L8:
            FLogger.f375446a.e("ConcatAdapterController", "onItemRangeRemoved return, recyclerView is null or is computing layout");
            return;
        L5:
            if (r104.isComputingLayout() == true) goto L8;
            r103.f328563a.notifyItemRangeRemoved(r100 + r103.b(r102), r101);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int r100, int r101, Object r102) {
            b r103 = this.f328580a;
            ((com.larus.common_ui.widget.concat_adapter.a) r103.f328577d).g(r103, r100, r101, r102);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int r100, int r101, int r102) {
            b r103 = this.f328580a;
            com.larus.common_ui.widget.concat_adapter.a r104 = (com.larus.common_ui.widget.concat_adapter.a) r103.f328577d;
            int r105 = r104.b(r103);
            RecyclerView r106 = r104.d();
            if (r106 != null) goto L5;
        L8:
            FLogger.f375446a.e("ConcatAdapterController", "onItemRangeMoved return, recyclerView is null or is computing layout");
            return;
        L5:
            if (r106.isComputingLayout() == true) goto L8;
            r104.f328563a.notifyItemMoved(r100 + r105, r101 + r105);
        }
    }

    /* JADX INFO: renamed from: com.larus.common_ui.widget.concat_adapter.b$b, reason: collision with other inner class name */
    public interface InterfaceC4191b {
    }

    public b(RecyclerView.Adapter r100, InterfaceC4191b r101, a29.a r102, c.d r103) {
        a r104 = new a(this);
        this.f328579f = r104;
        this.f328576c = r100;
        this.f328577d = r101;
        r102.getClass();
        this.f328574a = new a29.a.C0007a(r102, this);
        this.f328575b = r103;
        this.f328578e = r100.getItemCount();
        r100.registerAdapterDataObserver(r104);
    }
}
