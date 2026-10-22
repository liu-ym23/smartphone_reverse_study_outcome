package com.bytedance.ee.bear.list.recent;

import android.text.TextUtils;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.sort.FilterType;
import com.bytedance.ee.util.info.AppInfoUtils;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import mc5.a3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class z0 extends a3 {
    public FolderSortStrategy b;
    public final CompositeDisposable c;
    public final int d;
    public final String e;
    public final FolderSortStrategy f;

    public final Flowable<ArrayList<Document>> c() {
        return Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).map(new y0(this)).map(new jd5.s());
    }

    @Override // mc5.k
    public final FolderSortStrategy getFilter() {
        tt5.a.h("RecentListCache", "getFilter()...");
        FolderSortStrategy r0 = ((mc5.j) this.a.a(mc5.j.class)).m1(this.e);
        if (r0 != null) goto L5;
    L6:
        r0 = this.f;
    L8:
        return e(r0);
    L5:
        if (d(r0) == false) goto L8;
        goto L6
    }

    public z0(ce5.a r9) {
        super(r9);
        this.c = new CompositeDisposable();
        this.d = 1;
        this.e = "recent";
        this.f = new FolderSortStrategy("recent", FilterType.ALL.getType(), "", "", RecentSort.OPENED.getRank(), false);
        this.a = r9;
    }

    @Override // mc5.k
    public final void a(final ArrayList<Document> r5) {
        tt5.a.h("RecentListCache", "clearAndSave()...list size = " + hu5.a.c(r5));
        final FolderSortStrategy r0 = e(this.b);
        this.c.add(Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(new s0(this, r5, r0), new t0()));
    }

    @Override // mc5.k
    public final void b(ArrayList<Document> r4) {
        tt5.a.h("RecentListCache", "save()...");
        this.c.add(Flowable.just(r4).observeOn(fo5.d.b()).subscribe(new w0(this), new x0()));
    }

    public final boolean d(FolderSortStrategy r4) {
        if (TextUtils.equals(r4.a, "recent") == false) goto L10;
        if (r4.getType() != FilterType.WIKI.getType()) goto L10;
        if (r4.e != RecentSort.MODIFIED.getRank()) goto L10;
        return true;
    L10:
        if (r4.getType() != FilterType.WIKI.getType()) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // mc5.a3, mc5.k
    public void delete(String r4) {
        tt5.a.h("RecentListCache", "delete()...");
        this.c.add(Flowable.just(r4).observeOn(fo5.d.b()).subscribe(new u0(this), new v0()));
    }

    public final FolderSortStrategy e(FolderSortStrategy r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (AppInfoUtils.f().booleanValue() == true) goto L8;
    L25:
        return r10;
    L8:
        if (this.d != 1) goto L25;
        if (r10.c != null) goto L13;
    L15:
        String r2 = r10.a;
        int r3 = r10.getType();
        String r1 = r10.c;
        if (r1 != null) goto L18;
        String r5 = "";
    L19:
        String r4 = r10.d;
        if (r4 != null) goto L22;
        String r6 = "";
    L23:
        String r7 = r5;
        String r8 = r6;
        FolderSortStrategy r0 = new FolderSortStrategy(r2, r3, r7, r8, r10.e, r10.f);
        r0.g = r10.g;
        r0.h = r10.h;
        return r0;
    L22:
        r6 = r4;
        goto L23
    L18:
        r5 = r1;
        goto L19
    L13:
        if (r10.d == null) goto L15;
        return r10;
    }

    public z0(FolderSortStrategy r2, ce5.a r3) {
        super(r3);
        this.c = new CompositeDisposable();
        this.d = 13;
        this.e = "bitable_home";
        this.f = r2;
        this.a = r3;
    }
}
