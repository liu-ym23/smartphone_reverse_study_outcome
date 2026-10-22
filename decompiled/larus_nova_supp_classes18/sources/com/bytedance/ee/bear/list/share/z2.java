package com.bytedance.ee.bear.list.share;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.dto.Document;
import io.reactivex.Flowable;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class z2 extends com.bytedance.ee.bear.list.list.a<r2> implements m0 {
    @Override // com.bytedance.ee.bear.list.list.a
    public final String L() {
        return "shared_folder";
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final String P() {
        return "ShareFolderModel";
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final boolean a0() {
        return false;
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final Flowable<DocumentListInfo> C() {
        Boolean r0 = Boolean.TRUE;
        return Flowable.zip(Flowable.just(r0).observeOn(fo5.d.b()).map(new y2(this)).flatMap(new v2(this)), Flowable.just(r0).observeOn(fo5.d.b()).map(new y2(this)).flatMap(new w2(this)), new x2());
    }

    @Override // com.bytedance.ee.bear.list.list.e
    public final LiveData<ArrayList<Document>> X() {
        return Transformations.map(((mc5.j) this.k.a(mc5.j.class)).G7(), new od5.c());
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final String k() {
        String[] r0 = com.bytedance.ee.bear.list.t0.a;
        return "/api/explorer/share/folder/newlist/";
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final com.bytedance.ee.bear.list.u o() {
        return new s2();
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final mc5.k p() {
        return new r2(this.k);
    }

    @Override // com.bytedance.ee.bear.list.share.m0
    public final void K1(final String r3) {
        tt5.a.h("ShareFolderModel", "updateItemVisited()...visited = true");
        iu5.f.a(new u2(this, r3));
    }

    @Override // com.bytedance.ee.bear.list.share.m0
    public final void c(String r3) {
        tt5.a.h("ShareFolderModel", "removeItem()...");
        ((r2) this.g).delete(r3);
    }

    public z2(LifeCycleFragment r1, Context r2, ce5.a r3) {
        super(r1, r2, r3);
    }
}
