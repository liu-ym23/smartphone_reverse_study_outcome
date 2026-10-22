package com.bytedance.ee.bear.list.ainote;

import android.content.Context;
import android.text.TextUtils;
import androidx.arch.core.util.Function;
import androidx.lifecycle.MediatorLiveData;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.list.a;
import com.bytedance.ee.bear.list.sort.FilterType;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.list.u;
import fo5.d;
import gc5.c;
import gc5.e;
import gc5.t;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import mc5.u1;
import uc5.g2;
import uc5.k2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class AINoteListModel extends a<c> implements g2 {
    public List<u1> l;
    public final MediatorLiveData<List<u1>> m;

    public class TransformFun implements Function<List<u1>, ArrayList<Document>> {
        public final /* synthetic */ AINoteListModel a;

        public TransformFun(AINoteListModel r1) {
            this.a = r1;
        }

        public final ArrayList<Document> a(List<u1> r4) {
            tt5.a.h(this.a.P(), "TransformFun()...input = " + hu5.a.c(r4));
            ArrayList<Document> r0 = new ArrayList();
            if (hu5.a.d(r4) == false) goto L6;
            tt5.a.h("AINoteListModel", "TransformFun#apply()...input is empty");
            return r0;
        L6:
            this.a.l = r4;
            Iterator<u1> r5 = r4.iterator();
        L8:
            if (r5.hasNext() == false) goto L10;
            r0.add(u1.a(r5.next()));
            goto L8
        L10:
            this.a.getClass();
            return r0;
        }

        public final /* bridge */ /* synthetic */ Object apply(Object r1) {
            return a((List) r1);
        }
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public String L() {
        throw null;
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public String P() {
        throw null;
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final boolean a0() {
        return false;
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final u o() {
        return new k2();
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final NetService.f h() {
        NetService.f r0 = super.h();
        r0.b("rank", "3");
        r0.b("asc", "0");
        FolderSortStrategy r1 = this.c;
        if (r1 == null) goto L15;
        int r2 = t.a;
        Intrinsics.checkNotNullParameter(r1, "sortStrategy");
        FilterType.a r3 = FilterType.Companion;
        int r4 = r1.getType();
        String r5 = r1.c;
        String r6 = r1.d;
        r3.getClass();
        FilterType r7 = FilterType.a.a(r4, r5, r6);
        int r8 = t.a.a[r7.ordinal()];
        int r9 = 1;
        if (r8 == 1) goto L14;
        r9 = 2;
        if (r8 == 2) goto L14;
        r9 = 3;
        if (r8 == 3) goto L14;
        if (r8 == 4) goto L13;
        r9 = 0;
        goto L14
    L13:
        r9 = 5;
    L14:
        r0.b("note_type", String.valueOf(r9));
    L15:
        r0.a("shortcut_filter", t0.l());
        return r0;
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final Flowable<DocumentListInfo> s() {
        return super.s();
    }

    @Override // com.bytedance.ee.bear.list.list.a, com.bytedance.ee.bear.list.list.e
    public final void r2() {
        super.r2();
    }

    @Override // uc5.g2
    public final void c(final String r4) {
        tt5.a.h(P(), "removeItem()...");
        this.f.add(Flowable.just(Boolean.TRUE).observeOn(d.b()).subscribe(new gc5.d(this, r4), new e(this)));
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final void j0(FolderSortStrategy r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (TextUtils.equals(r3.a, L()) == true) goto L6;
        return;
    L6:
        if (r3.equals(this.c) == true) goto L12;
        this.c = r3;
        super.r2();
        return;
    }

    public AINoteListModel(LifeCycleFragment r1, Context r2, ce5.a r3) {
        super(r1, r2, r3);
        new ArrayList();
        new ArrayList();
        this.m = new MediatorLiveData();
    }
}
