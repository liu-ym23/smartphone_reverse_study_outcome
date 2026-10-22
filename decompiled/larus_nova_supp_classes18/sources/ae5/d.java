package ae5;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Transformations;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.u3;
import com.bytedance.ee.bear.list.v3;
import com.bytedance.ee.util.info.AppInfoUtils;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import mc5.u1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class d extends com.bytedance.ee.bear.list.list.a<a0> implements m {
    @Override // com.bytedance.ee.bear.list.list.a
    public final String L() {
        return "star";
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final String P() {
        return "FavoriteModel";
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final String k() {
        return "/space/api/explorer/v2/star/list/";
    }

    public int x0() {
        return 6;
    }

    @Override // com.bytedance.ee.bear.list.list.e
    public final LiveData<ArrayList<Document>> X() {
        final mc5.j r0 = (mc5.j) this.k.a(mc5.j.class);
        if (AppInfoUtils.f().booleanValue() == false) goto L5;
        final LiveData r1 = r0.Od();
        final MediatorLiveData r2 = new MediatorLiveData();
        tt5.a.h("FavoriteModel", "getListLiveData()...office initial source created, limit = 20, sourceHash = " + System.identityHashCode(r1) + ", modelHash = " + System.identityHashCode(this));
        r2.addSource(r1, new b(this, r2, r1, r0));
        return r2;
    L5:
        return Transformations.map(r0.c7(x0()), new od5.c());
    }

    @Override // ae5.m
    public final Flowable<ArrayList<Document>> g() {
        final a0 r0 = (a0) this.g;
        r0.getClass();
        return Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).map(new z(r0)).map(new jd5.s());
    }

    public a0 u0() {
        return new a0(this.k);
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final NetService.f h() {
        NetService.f r0 = super.h();
        r0.b("type_opt", String.valueOf(1));
        if (AppInfoUtils.f().booleanValue() == true) goto L5;
    L13:
        v3.a(r0);
        return r0;
    L5:
        if (((HashMap) ((NetService.e) r0).e).containsKey("obj_type") == true) goto L13;
        if (((HashMap) ((NetService.e) r0).f).containsKey("obj_type") == true) goto L13;
        ((HashMap) ((NetService.e) r0).e).remove("obj_type");
        int r6 = 0;
        sbb.e[] r4 = {sbb.e.f, sbb.e.g, sbb.e.o, sbb.e.h, sbb.e.m, sbb.e.i, sbb.e.k, sbb.e.l};
        ArrayList r1 = new ArrayList();
    L10:
        if (r6 >= 8) goto L12;
        r1.add(String.valueOf(r4[r6].b));
        r6 = r6 + 1;
        goto L10
    L12:
        u3.b(r1);
        r0.a("obj_type", r1);
        goto L13
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public /* bridge */ /* synthetic */ mc5.k p() {
        return u0();
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public void j0(FolderSortStrategy r3) {
        super.j0(r3);
        if (r3 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals("star", r3.a) == false) goto L9;
        ((a0) this.g).b = r3;
        return;
    }

    public final ArrayList<Document> t0(List<u1> r4, String r5) {
        if (r4 != null) goto L4;
        r4 = Collections.emptyList();
    L4:
        ArrayList<Document> r0 = u1.b(r4);
        tt5.a.h("FavoriteModel", "getListLiveData()...db callback, sourceType = " + r5 + ", rawSize = " + r4.size() + ", mappedSize = " + r0.size() + ", modelHash = " + System.identityHashCode(this));
        return r0;
    }

    public d(LifeCycleFragment r1, Context r2, ce5.a r3) {
        super(r1, r2, r3);
    }
}
