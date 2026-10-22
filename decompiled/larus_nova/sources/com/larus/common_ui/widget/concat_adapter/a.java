package com.larus.common_ui.widget.concat_adapter;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes27.dex */
public final class a implements b.InterfaceC4191b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcatAdapter f328563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a29.a f328564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<WeakReference<RecyclerView>> f328565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IdentityHashMap<RecyclerView.ViewHolder, b> f328566d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<b> f328567e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public C4190a f328568f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConcatAdapter.Config.StableIdMode f328569g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f328570h;

    /* JADX INFO: renamed from: com.larus.common_ui.widget.concat_adapter.a$a, reason: collision with other inner class name */
    public static class C4190a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f328571a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f328572b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f328573c;

        public C4190a() {
        }
    }

    public final RecyclerView d() {
        if (((ArrayList) this.f328565c).size() > 0) goto L5;
        return null;
    L5:
        return (RecyclerView) ((WeakReference) ListProtector.get(this.f328565c, 0)).get();
    }

    public final int b(b r100) {
        Iterator r101 = ((ArrayList) this.f328567e).iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L8;
        b r103 = (b) r101.next();
        if (r103 == r100) goto L8;
        r102 = r102 + r103.f328578e;
    L8:
        return r102;
    }

    public final C4190a c(int r100) {
        C4190a r101 = this.f328568f;
        if (r101.f328573c == false) goto L5;
        r101 = new C4190a();
    L6:
        Iterator r102 = ((ArrayList) this.f328567e).iterator();
        int r103 = r100;
    L8:
        if (r102.hasNext() == false) goto L14;
        b r104 = (b) r102.next();
        int r105 = r104.f328578e;
        if (r105 > r103) goto L11;
        r103 = r103 - r105;
        goto L8
    L11:
        r101.f328571a = r104;
        r101.f328572b = r103;
    L14:
        if (r101.f328571a == null) goto L17;
        return r101;
    L17:
        throw new IllegalArgumentException("Cannot find wrapper for " + r100);
    L5:
        r101.f328573c = true;
        goto L6
    }

    public final b e(RecyclerView.ViewHolder r100) {
        b r101 = this.f328566d.get(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new IllegalStateException("Cannot find wrapper for " + r100 + ", seems like it is not bound by this adapter: " + this);
    }

    public final int f(RecyclerView.Adapter<RecyclerView.ViewHolder> r100) {
        int r101 = ((ArrayList) this.f328567e).size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        if (((b) ListProtector.get(this.f328567e, r102)).f328576c == r100) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        return r102;
    L8:
        return -1;
    }

    public a(ConcatAdapter r100, ConcatAdapter.Config r101) {
        this.f328565c = new ArrayList();
        this.f328566d = new IdentityHashMap();
        this.f328567e = new ArrayList();
        this.f328568f = new C4190a();
        this.f328563a = r100;
        r101.getClass();
        this.f328564b = new a29.a();
        ConcatAdapter.Config.StableIdMode r102 = r101.f328558a;
        this.f328569g = r102;
        if (r102 != ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS) goto L6;
        this.f328570h = new c.b();
        return;
    L6:
        if (r102 != ConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS) goto L9;
        this.f328570h = new c.a();
        return;
    L9:
        if (r102 != ConcatAdapter.Config.StableIdMode.SHARED_STABLE_IDS) goto L13;
        this.f328570h = new c.C4193c();
        return;
    L13:
        throw new IllegalArgumentException("unknown stable id mode");
    }

    public final boolean a(int r100, RecyclerView.Adapter<RecyclerView.ViewHolder> r101) {
        if (r100 < 0) goto L29;
        if (r100 > ((ArrayList) this.f328567e).size()) goto L29;
        if (this.f328569g == ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        r101.hasStableIds();
    L12:
        int r103 = f(r101);
        if (r103 != (-1)) goto L15;
        b r104 = null;
    L16:
        if (r104 == null) goto L18;
        return false;
    L18:
        b r105 = new b(r101, this, this.f328564b, this.f328570h.createStableIdLookup());
        ListProtector.add(this.f328567e, r100, r105);
        Iterator r106 = ((ArrayList) this.f328565c).iterator();
    L20:
        if (r106.hasNext() == false) goto L25;
        RecyclerView r107 = (RecyclerView) ((WeakReference) r106.next()).get();
        if (r107 == null) goto L20;
        r101.onAttachedToRecyclerView(r107);
        goto L20
    L25:
        if (r105.f328578e <= 0) goto L27;
        this.f328563a.notifyItemRangeInserted(b(r105), r105.f328578e);
    L27:
        return true;
    L15:
        r104 = (b) ListProtector.get(this.f328567e, r103);
        goto L16
    L11:
        r101.hasStableIds();
        goto L12
    L8:
        r102 = false;
    L29:
        throw new IndexOutOfBoundsException("Index must be between 0 and " + ((ArrayList) this.f328567e).size() + ". Given:" + r100);
    }

    public final void g(b r100, int r101, int r102, Object r103) {
        int r104 = b(r100);
        RecyclerView r105 = d();
        if (r105 != null) goto L5;
    L9:
        FLogger.f375446a.e("ConcatAdapterController", "onItemRangeChanged return, recyclerView is null or is computing layout");
        return;
    L5:
        if (r105.isComputingLayout() == true) goto L9;
        this.f328563a.notifyItemRangeChanged(r101 + r104, r102, r103);
    }
}
