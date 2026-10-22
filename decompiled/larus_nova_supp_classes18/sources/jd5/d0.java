package jd5;

import android.content.Context;
import android.text.TextUtils;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.dto.Document;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mc5.u1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d0 extends com.bytedance.ee.bear.list.list.a<t> implements j {

    public class a implements Function<List<u1>, ArrayList<Document>> {
        public final /* synthetic */ d0 a;

        public a(d0 r1) {
            this.a = r1;
        }

        public final ArrayList<Document> a(List<u1> r6) {
            if (this.a.Y(r6) == true) goto L5;
            ArrayList<Document> r7 = zd5.c.a(this.a.c, u1.b(r6));
            ArrayList r0 = new ArrayList();
            ArrayList r1 = new ArrayList();
            Iterator<Document> r2 = r7.iterator();
        L8:
            if (r2.hasNext() == false) goto L13;
            Document r3 = r2.next();
            if (r3.y2 == true) goto L11;
            r1.add(r3);
            goto L8
        L11:
            r0.add(r3);
            goto L8
        L13:
            ArrayList<Document> r4 = new ArrayList();
            Collections.sort(r0, new c0());     // Catch: Exception -> L16
            r4.addAll(r0);     // Catch: Exception -> L16
            r4.addAll(r1);     // Catch: Exception -> L16
            return r4;
        L16:
            e = move-exception;
            this.a.getClass();
            tt5.a.f("MyDocumentModel", e, false);
            return r7;
        L5:
            return u1.b(r6);
        }

        public final /* bridge */ /* synthetic */ Object apply(Object r1) {
            return a((List) r1);
        }
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final String L() {
        return "mine";
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final String P() {
        return "MyDocumentModel";
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final Flowable<DocumentListInfo> C() {
        return Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).map(new y(this)).map(new z(this)).flatMap(new a0(this));
    }

    @Override // com.bytedance.ee.bear.list.list.e
    public final LiveData<ArrayList<Document>> X() {
        LiveData<List<u1>> r0 = ((mc5.j) this.k.a(mc5.j.class)).I6();
        final MediatorLiveData r1 = new MediatorLiveData();
        final a r2 = new a(this);
        r1.addSource(r0, new x(r1, r2));
        return r1;
    }

    @Override // jd5.j
    public final Flowable<ArrayList<Document>> g() {
        final t r0 = (t) this.g;
        r0.getClass();
        return Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).map(new r(r0)).map(new s());
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final String k() {
        if (((ww4.a) org.koin.java.a.a(ww4.a.class)).a().c().a == false) goto L5;
        return "/api/explorer/my/object/list/";
    L5:
        return "space/api/explorer/lean/my/object/list/";
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final com.bytedance.ee.bear.list.u o() {
        return new com.bytedance.ee.bear.list.u();
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final mc5.k p() {
        return new t(this.k);
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final void j0(FolderSortStrategy r3) {
        super.j0(r3);
        if (r3 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals("mine", r3.a) == false) goto L9;
        ((t) this.g).b = r3;
        return;
    }

    public d0(LifeCycleFragment r1, Context r2, ce5.a r3) {
        super(r1, r2, r3);
    }
}
