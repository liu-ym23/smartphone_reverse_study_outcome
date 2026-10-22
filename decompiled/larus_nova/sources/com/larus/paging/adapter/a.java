package com.larus.paging.adapter;

import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes29.dex */
public final class a implements b.InterfaceC4459b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcatAdapter f363755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zo9.a f363756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<WeakReference<RecyclerView>> f363757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IdentityHashMap<RecyclerView.ViewHolder, b> f363758d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<b> f363759e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public C4458a f363760f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConcatAdapter.Config.StableIdMode f363761g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f363762h;

    /* JADX INFO: renamed from: com.larus.paging.adapter.a$a, reason: collision with other inner class name */
    public static class C4458a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f363763a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f363764b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f363765c;

        public C4458a() {
        }
    }

    public final int a(b r100) {
        Iterator r101 = ((ArrayList) this.f363759e).iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L8;
        b r103 = (b) r101.next();
        if (r103 == r100) goto L8;
        r102 = r102 + r103.f363770e;
    L8:
        return r102;
    }

    public final C4458a b(int r100) {
        C4458a r101 = this.f363760f;
        if (r101.f363765c == false) goto L5;
        r101 = new C4458a();
    L6:
        Iterator r102 = ((ArrayList) this.f363759e).iterator();
        int r103 = r100;
    L8:
        if (r102.hasNext() == false) goto L14;
        b r104 = (b) r102.next();
        int r105 = r104.f363770e;
        if (r105 > r103) goto L11;
        r103 = r103 - r105;
        goto L8
    L11:
        r101.f363763a = r104;
        r101.f363764b = r103;
    L14:
        if (r101.f363763a == null) goto L17;
        return r101;
    L17:
        throw new IllegalArgumentException("Cannot find wrapper for " + r100);
    L5:
        r101.f363765c = true;
        goto L6
    }

    public final b c(RecyclerView.ViewHolder r100) {
        b r101 = this.f363758d.get(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new IllegalStateException("Cannot find wrapper for " + r100 + ", seems like it is not bound by this adapter: " + this);
    }

    public a(ConcatAdapter r100, ConcatAdapter.Config r101) {
        this.f363757c = new ArrayList();
        this.f363758d = new IdentityHashMap();
        this.f363759e = new ArrayList();
        this.f363760f = new C4458a();
        this.f363755a = r100;
        r101.getClass();
        this.f363756b = new zo9.a();
        ConcatAdapter.Config.StableIdMode r102 = r101.f363753a;
        this.f363761g = r102;
        if (r102 != ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS) goto L6;
        this.f363762h = new c.b();
        return;
    L6:
        if (r102 != ConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS) goto L9;
        this.f363762h = new c.a();
        return;
    L9:
        if (r102 != ConcatAdapter.Config.StableIdMode.SHARED_STABLE_IDS) goto L13;
        this.f363762h = new c.C4461c();
        return;
    L13:
        throw new IllegalArgumentException("unknown stable id mode");
    }
}
