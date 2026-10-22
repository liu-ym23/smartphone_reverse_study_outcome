package com.bytedance.ee.bear.list.share;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.dto.Document;
import io.reactivex.Flowable;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class x1 extends com.bytedance.ee.bear.list.list.a<i2> implements j0 {
    @Override // com.bytedance.ee.bear.list.list.a
    public final String L() {
        return "shared_file";
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final String P() {
        return "ShareDocumentModel";
    }

    @Override // com.bytedance.ee.bear.list.list.e
    public final LiveData<ArrayList<Document>> X() {
        return Transformations.map(((mc5.j) this.k.a(mc5.j.class)).bc(), new od5.c());
    }

    @Override // com.bytedance.ee.bear.list.share.j0
    public final Flowable<ArrayList<Document>> g() {
        final i2 r0 = (i2) this.g;
        r0.getClass();
        return Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).map(new h2(r0)).map(new jd5.s());
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final String k() {
        if (((ww4.a) org.koin.java.a.a(ww4.a.class)).a().c().a == false) goto L5;
        return "/api/explorer/share/object/list/";
    L5:
        return "space/api/explorer/lean/share/object/list/";
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final com.bytedance.ee.bear.list.u o() {
        return new j2();
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final mc5.k p() {
        return new i2(this.k);
    }

    @Override // com.bytedance.ee.bear.list.share.j0
    public final void c(String r3) {
        tt5.a.h("ShareDocumentModel", "removeItem()...");
        ((i2) this.g).delete(r3);
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final void j0(FolderSortStrategy r3) {
        super.j0(r3);
        if (r3 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals("shared_file", r3.a) == false) goto L9;
        ((i2) this.g).b = r3;
        return;
    }

    public x1(LifeCycleFragment r1, Context r2, ce5.a r3) {
        super(r1, r2, r3);
    }
}
