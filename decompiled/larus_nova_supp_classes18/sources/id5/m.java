package id5;

import android.content.Context;
import android.text.TextUtils;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.dto.Document;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kd5.c2;
import mc5.u1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m extends com.bytedance.ee.bear.list.list.a<v> {
    public List<u1> l;
    public List<Document> m;
    public final MediatorLiveData<List<u1>> n;

    public class a implements Function<List<u1>, ArrayList<Document>> {
        public final /* synthetic */ m a;

        public a(m r1) {
            this.a = r1;
        }

        public final ArrayList<Document> a(List<u1> r4) {
            this.a.getClass();
            tt5.a.h("ManualOfflineDocumentModel", "TransformFun()...input = " + hu5.a.c(r4));
            this.a.l = r4;
            ArrayList<Document> r5 = zd5.c.a(this.a.c, u1.b(r4));
            this.a.m = r5;
            if (hu5.a.d(r5) == false) goto L5;
        L11:
            return r5;
        L5:
            if (this.a.c == null) goto L11;
            Collections.sort(r5, new l(this));     // Catch: Exception -> L9
            return r5;
        L9:
            e = move-exception;
            this.a.getClass();
            tt5.a.f("ManualOfflineDocumentModel", e, false);
            goto L11
        }

        public final /* bridge */ /* synthetic */ Object apply(Object r1) {
            return a((List) r1);
        }
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final String L() {
        return "manual_offline";
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final String P() {
        return "ManualOfflineDocumentModel";
    }

    @Override // com.bytedance.ee.bear.list.list.a, com.bytedance.ee.bear.list.list.e
    public final void e3() {
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final String k() {
        return "/space/api/explorer/offline/list/";
    }

    @Override // com.bytedance.ee.bear.list.list.e
    public final LiveData<ArrayList<Document>> X() {
        MediatorLiveData<List<u1>> r0 = this.n;
        LiveData<List<u1>> r1 = ((mc5.j) this.k.a(mc5.j.class)).c7(7);
        MediatorLiveData<List<u1>> r2 = this.n;
        Objects.requireNonNull(r2);
        r0.addSource(r1, new ic5.c(r2));
        final MediatorLiveData r3 = new MediatorLiveData();
        final a r4 = new a(this);
        r3.addSource(this.n, new g(r3, r4));
        return r3;
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final com.bytedance.ee.bear.list.u o() {
        return new kd5.j();
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final mc5.k p() {
        return new v(this.k);
    }

    @Override // com.bytedance.ee.bear.list.list.a, com.bytedance.ee.bear.list.list.e
    public final void r2() {
        if (c2.w == false) goto L5;
        super.r2();
        return;
    L5:
        this.f.add(Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).map(new h(this)).observeOn(fo5.d.d()).subscribe(new i(this), new j(this)));
    }

    public m(Context r2) {
        super(null, r2);
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.n = new MediatorLiveData();
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final void j0(FolderSortStrategy r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (TextUtils.equals(r3.a, "manual_offline") == true) goto L6;
        return;
    L6:
        if (r3.equals(this.c) == true) goto L12;
        this.c = r3;
        this.n.postValue(this.l);
        return;
    }

    public m(LifeCycleFragment r1, Context r2, ce5.a r3) {
        super(r1, r2, r3);
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.n = new MediatorLiveData();
    }
}
