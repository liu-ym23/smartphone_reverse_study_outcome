package uc5;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.folder.FolderDetailTransformFun;
import com.bytedance.ee.bear.middleground_permission_export.model.forbidden.GetComplaintResult;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class y extends com.bytedance.ee.bear.list.list.a<g> implements e2 {
    public final String l;
    public final String m;
    public Document n;
    public Disposable o;

    @Override // com.bytedance.ee.bear.list.list.a
    public final String P() {
        return "FolderDetailModel";
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final String k() {
        return "/api/explorer/folder/children/";
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final String L() {
        if (TextUtils.isEmpty(this.l) == false) goto L6;
        return "root";
    L6:
        return this.l;
    }

    @Override // uc5.e2
    public final Flowable<Document> O() {
        return Flowable.just(this.l).filter(new w(this)).observeOn(fo5.d.b()).map(new x(this));
    }

    @Override // com.bytedance.ee.bear.list.list.e
    public final LiveData<ArrayList<Document>> X() {
        final FolderDetailTransformFun r0 = new FolderDetailTransformFun();
        if (TextUtils.isEmpty(this.l) == false) goto L6;
        LiveData<List<mc5.u1>> r1 = ((mc5.j) this.k.a(mc5.j.class)).Rc(this.l);
        final MediatorLiveData r2 = new MediatorLiveData();
        r2.addSource(r1, new r(r2, r0));
        return r2;
    L6:
        LiveData<List<mc5.u1>> r3 = ((mc5.j) this.k.a(mc5.j.class)).J3(this.l);
        final MediatorLiveData r4 = new MediatorLiveData();
        r4.addSource(r3, new s(r4, r0));
        return r4;
    }

    @Override // uc5.e2
    public final void e0() {
        Disposable r0 = this.o;
        if (r0 != null) goto L5;
    L7:
        this.o = Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(new p(this), new q(this));
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        this.o.dispose();
        goto L7
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final com.bytedance.ee.bear.list.u o() {
        return new e1(this.l);
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final mc5.k p() {
        if (TextUtils.isEmpty(this.l) == false) goto L6;
        return new o3(this.k);
    L6:
        return new p3(this.l, this.k);
    }

    @Override // uc5.e2
    public final Flowable<GetComplaintResult> p0() {
        ce5.a r0 = this.k;
        if (r0 == null) goto L5;
        boolean r1 = r0.d.isEnable("ccm.platform.appeal_v2");
    L7:
        return ((com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a) org.koin.java.a.a(com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a.class)).d(sbb.e.f.b, this.l, r1);
    L5:
        r1 = false;
        goto L7
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final Flowable<DocumentListInfo> C() {
        return super.C().flatMap(new t1()).flatMap(new com.bytedance.ee.bear.list.folder.c((NetService) org.koin.java.a.a(NetService.class))).doOnNext(new v(this));
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final void destroy() {
        super.destroy();
        Disposable r0 = this.o;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L9;
        this.o.dispose();
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final NetService.f h() {
        NetService.f r0 = super.h();
        r0.b("need_path", "1");
        r0.b(ResourceData.KEY_TOKEN, this.l);
        if (TextUtils.isEmpty(this.m) == true) goto L5;
        r0.b(ResourceData.KEY_TYPE, this.m);
    L5:
        r0.b("show_no_perm", "1");
        com.bytedance.ee.bear.list.v3.a(r0);
        return r0;
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final Flowable<DocumentListInfo> s() {
        return super.s().flatMap(new t1()).flatMap(new com.bytedance.ee.bear.list.folder.c((NetService) org.koin.java.a.a(NetService.class)));
    }

    @Override // uc5.e2
    public final Document getParent() {
        return this.n;
    }

    @Override // uc5.e2
    public final void c(final String r4) {
        tt5.a.h("FolderDetailModel", "removeItem()...");
        this.f.add(Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(new t(this, r4), new u(this)));
    }

    public y(LifeCycleFragment r1, Context r2, String r3, String r4, ce5.a r5) {
        super(r1, r2, r5);
        this.l = r3;
        this.m = r4;
    }
}
