package com.bytedance.ee.bear.list.list;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.a4;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.share.p;
import com.bytedance.ee.bear.list.sort.FilterType;
import com.bytedance.ee.bear.list.sort.SortAndFilterViewModel;
import com.bytedance.ee.bear.list.t;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.list.u;
import com.bytedance.ee.util.ui.n;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mc5.k;
import mc5.u1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class a<T extends k> implements e {
    public Fragment a;
    public final Context b;
    public FolderSortStrategy c;
    public FolderSortStrategy d;
    public SortAndFilterViewModel e;
    public final CompositeDisposable f;
    public T g;
    public DocumentListInfo h;
    public e.a i;
    public Disposable j;
    public final ce5.a k;

    public String D() {
        return "100";
    }

    public abstract String L();

    public abstract String P();

    public boolean a0() {
        return !(this instanceof p);
    }

    public abstract String k();

    public abstract T p();

    @Override // com.bytedance.ee.bear.list.list.e
    public final void r() {
        this.c = null;
        if (this.e == null) goto L5;
        this.e = null;
    L5:
        h0();
    }

    public Flowable<DocumentListInfo> C() {
        return Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).map(new dd5.g(this)).flatMap(new dd5.h(this));
    }

    public NetService.f h() {
        NetService.f r0 = new NetService.f(k());
        r0.b("need_total", "1");
        if (a0() == false) goto L5;
        r0.b("length", D());
    L5:
        FolderSortStrategy r1 = this.c;
        if (r1 == null) goto L18;
        int r2 = r1.getType();
        sbb.e r3 = sbb.e.g;
        if (r2 != r3.b) goto L11;
        ArrayList r4 = new ArrayList();
        r4.add(String.valueOf(r3.b));
        r4.add(String.valueOf(sbb.e.o.b));
        r0.a("obj_type", r4);
    L15:
        int r5 = this.c.e;
        if (r5 == (-1)) goto L18;
        r0.b("rank", String.valueOf(r5));
        r0.b("asc", String.valueOf(this.c.f));
        goto L18
    L11:
        if (this.c.getType() == sbb.e.e.b) goto L15;
        int r6 = this.c.getType();
        FolderSortStrategy r7 = this.c;
        if (FilterType.isPhotoV2(r6, r7.c, r7.d) == true) goto L15;
        r0.b("obj_type", String.valueOf(this.c.getType()));
    L18:
        Context r8 = this.b;
        String[] r9 = t0.a;
        int r10 = r8.getResources().getDimensionPixelSize(2131167709);
        int r11 = t.a;
        r0.b("thumbnail_width", String.valueOf(n.v() / 2));
        r0.b("thumbnail_height", String.valueOf(r10));
        r0.b("thumbnail_policy", "1");
        return r0;
    }

    public final void h0() {
        Fragment r0 = this.a;
        if (r0 != null) goto L5;
    L12:
        tt5.a.d(P(), "observeSortAndFilter()...fragment or activity is null");
        return;
    L5:
        if (r0.getActivity() == null) goto L12;
        if (this.e != null) goto L10;
        this.e = (SortAndFilterViewModel) ViewModelProviders.of(this.a.getActivity()).get(SortAndFilterViewModel.class);
    L10:
        this.e.getSortStrategyLiveData().observe(this.a, new dd5.b(this));
    }

    @Override // com.bytedance.ee.bear.list.list.e
    public boolean hasMore() {
        DocumentListInfo r0 = this.h;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isHasMore() == false) goto L7;
        return true;
    }

    public u o() {
        return new u();
    }

    public final NetService.d<DocumentListInfo> w() {
        ce5.a r0 = this.k;
        if (r0 == null) goto L7;
        return r0.c.Vc(o());
    L7:
        return ((NetService) org.koin.java.a.a(NetService.class)).Vc(o());
    }

    public void create() {
        tt5.a.h(P(), "create()..." + hashCode());
        this.g = (T) p();
        h0();
    }

    public void destroy() {
        tt5.a.h(P(), "destroy()..." + hashCode());
        this.f.clear();
        Disposable r0 = this.j;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L9;
        tt5.a.h(P(), "refreshFromNet()...dispose mRefreshDisposable.");
        this.j.dispose();
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.e
    public void e3() {
        tt5.a.h(P(), "loadMoreFromNet()...");
        Disposable r0 = s().subscribe(new dd5.c(this), new dd5.d(this));
        this.f.add(r0);
    }

    @Override // com.bytedance.ee.bear.list.list.e
    public void r2() {
        tt5.a.h(P(), "refreshFromNet()...");
        o0(false);
    }

    public Flowable<DocumentListInfo> s() {
        NetService.d<DocumentListInfo> r0 = w();
        NetService.f r1 = h();
        DocumentListInfo r2 = this.h;
        if (r2 == null) goto L15;
        if (TextUtils.isEmpty(r2.getCheckId()) == true) goto L9;
        r1.b("check_id", String.valueOf(this.h.getCheckId()));
    L9:
        if (TextUtils.isEmpty(this.h.getNextId()) == true) goto L12;
        r1.b("next_id", String.valueOf(this.h.getNextId()));
    L12:
        if (TextUtils.isEmpty(this.h.getLastLabel()) == true) goto L15;
        r1.b("last_label", this.h.getLastLabel());
    L15:
        return r0.a(r1);
    }

    public int T(DocumentListInfo r1) {
        return r1.getTotal();
    }

    public final boolean Y(List<u1> r5) {
        if (hu5.a.f(r5) == false) goto L27;
        Iterator<u1> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L10;
        u1 r0 = r6.next();
        if (((a4) org.koin.java.a.a(a4.class)).c(r0.a) == true) goto L6;
    L11:
        if (r0 != null) goto L13;
        return false;
    L13:
        FolderSortStrategy r7 = this.d;
        if (r7 == null) goto L27;
        if (r7.getType() != FilterType.DOC.getType()) goto L23;
        tt5.a.h(P(), "pre filter doc onChanged...");
        if (TextUtils.equals(r0.getType(), String.valueOf(sbb.e.o.b)) == false) goto L20;
    L21:
        return true;
    L20:
        if (TextUtils.equals(r0.getType(), String.valueOf(sbb.e.g.b)) == false) goto L27;
    L23:
        if (this.d.getType() == FilterType.ALL.getType()) goto L27;
        tt5.a.h(P(), "pre filter onChanged...");
        if (TextUtils.equals(r0.getType(), String.valueOf(this.d.getType())) == false) goto L27;
        return true;
    L10:
        r0 = null;
    L27:
        return false;
    }

    @Override // com.bytedance.ee.bear.list.list.e
    public final Flowable b7(final rf5.d r4) {
        tt5.a.h(P(), "insertUploadFile() called with: fileToken = " + du5.b.g(r4.a) + ", nodeToken = " + du5.b.g(r4.b) + ", mountPointToken = " + du5.b.g(r4.d) + ", path = " + du5.b.g(r4.e) + ", mountPoint = " + du5.b.g(r4.c));
        return Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).map(new dd5.i(r4));
    }

    public void j0(FolderSortStrategy r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (TextUtils.equals(r3.a, L()) == true) goto L6;
        return;
    L6:
        if (r3.equals(this.c) == true) goto L12;
        this.d = this.c;
        this.c = r3;
        o0(true);
        return;
    }

    public void o0(final boolean r10) {
        final int r4 = System.identityHashCode(this);
        final long r2 = System.currentTimeMillis();
        tt5.a.h(P(), "refreshFromNet()...needFailToast = " + r10 + ", modelHash = " + r4 + ", callbackHash = " + System.identityHashCode(this.i));
        Disposable r0 = this.j;
        if (r0 != null) goto L5;
    L7:
        tt5.a.h(P(), "office_folder_load_trace network_request_start, apiPath = " + k() + ", needFailToast = " + r10 + ", modelHash = " + r4 + ", callbackHash = " + System.identityHashCode(this.i) + ", thread = " + ThreadMethodProxy.currentThread().getName());
        this.j = C().subscribe(new dd5.e(this, r2, r4), new dd5.f(this, r2, r4, r10));
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        tt5.a.h(P(), "refreshFromNet()...dispose mRefreshDisposable.");
        this.j.dispose();
        goto L7
    }

    @Override // com.bytedance.ee.bear.list.list.e
    public final void x8(e.a r1) {
        this.i = r1;
    }

    public a(Fragment r2, Context r3) {
        this.f = new CompositeDisposable();
        this.a = r2;
        this.b = r3;
        this.k = new ce5.a();
    }

    public a(Fragment r2, Context r3, ce5.a r4) {
        this.f = new CompositeDisposable();
        this.a = r2;
        this.b = r3;
        this.k = r4;
    }
}
