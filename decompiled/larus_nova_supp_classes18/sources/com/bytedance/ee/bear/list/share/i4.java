package com.bytedance.ee.bear.list.share;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Transformations;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.sort.FilterType;
import com.bytedance.ee.util.info.AppInfoUtils;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i4 extends com.bytedance.ee.bear.list.list.a<b4> implements o0 {
    @Override // com.bytedance.ee.bear.list.list.a
    public final String L() {
        return "shared";
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final String P() {
        return "SharedModel";
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final String k() {
        return "/space/api/explorer/v2/share/list/";
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final Flowable<DocumentListInfo> C() {
        return Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).map(new g4(this)).flatMap(new e4(this));
    }

    @Override // com.bytedance.ee.bear.list.share.o0
    public final Flowable<Integer> R() {
        NetService.f r0 = new NetService.f("/api/explorer/share/folder/newlist/");
        r0.b("be_shared", String.valueOf(true));
        return this.k.c.Vc(new s2()).a(r0).map(new f4());
    }

    @Override // com.bytedance.ee.bear.list.list.e
    public final LiveData<ArrayList<Document>> X() {
        final mc5.j r0 = (mc5.j) this.k.a(mc5.j.class);
        if (AppInfoUtils.f().booleanValue() == false) goto L5;
        final LiveData r1 = r0.h4();
        final MediatorLiveData r2 = new MediatorLiveData();
        tt5.a.h("SharedModel", "getListLiveData()...office initial source created, limit = 20, sourceHash = " + System.identityHashCode(r1) + ", modelHash = " + System.identityHashCode(this));
        r2.addSource(r1, new c4(this, r2, r1, r0));
        return r2;
    L5:
        return Transformations.map(r0.c7(10), new od5.c());
    }

    @Override // com.bytedance.ee.bear.list.share.o0
    public final Flowable<ArrayList<Document>> g() {
        final b4 r0 = (b4) this.g;
        r0.getClass();
        return Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).map(new a4(r0)).map(new jd5.s());
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final com.bytedance.ee.bear.list.u o() {
        return new j2();
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final mc5.k p() {
        return new b4(this.k);
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final NetService.f h() {
        NetService.f r0 = super.h();
        if (AppInfoUtils.f().booleanValue() == false) goto L5;
        com.bytedance.ee.bear.list.u3.a(r0);
    L5:
        com.bytedance.ee.bear.list.v3.a(r0);
        return r0;
    }

    public static Flowable t0(final i4 r5) {
        FolderSortStrategy r0 = r5.c;
        if (r0 != null) goto L5;
    L7:
        NetService.d<DocumentListInfo> r1 = r5.w();
        NetService.f r2 = r5.h();
        sbb.e r3 = sbb.e.f;
        r2.b("forbidden_obj_type", String.valueOf(r3.b));
        Flowable r4 = r1.a(r2);
        if (AppInfoUtils.f().booleanValue() == true) goto L14;
        if (qc5.a.d() == true) goto L14;
        NetService.d<DocumentListInfo> r6 = r5.w();
        NetService.f r7 = r5.h();
        r7.b("obj_type", String.valueOf(r3.b));
        r7.b("length", "800");
        return Flowable.zip(r6.a(r7), r4, new h4(r5));
    L14:
        return r4;
    L5:
        if (r0.getType() == FilterType.ALL.getType()) goto L7;
        return super.C();
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final void j0(FolderSortStrategy r3) {
        super.j0(r3);
        if (r3 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals("shared", r3.a) == false) goto L9;
        ((b4) this.g).b = r3;
        return;
    }

    public final ArrayList<Document> u0(List<mc5.u1> r4, String r5) {
        if (r4 != null) goto L4;
        r4 = Collections.emptyList();
    L4:
        ArrayList<Document> r0 = mc5.u1.b(r4);
        tt5.a.h("SharedModel", "getListLiveData()...db callback, sourceType = " + r5 + ", rawSize = " + r4.size() + ", mappedSize = " + r0.size() + ", modelHash = " + System.identityHashCode(this));
        return r0;
    }

    public i4(LifeCycleFragment r1, Context r2, ce5.a r3) {
        super(r1, r2, r3);
    }
}
