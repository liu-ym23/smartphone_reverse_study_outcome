package uc5;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.folder.FolderDetailTransformFun;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.forbidden.GetComplaintResult;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class y3 extends com.bytedance.ee.bear.list.list.a<g> implements h2 {
    public final String l;
    public Document m;
    public ShareFolderUserPermission n;
    public Disposable o;

    @Override // com.bytedance.ee.bear.list.list.a
    public final String P() {
        return "SubFolderModel";
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final String k() {
        return "/space/api/explorer/v3/children/list/";
    }

    @Override // uc5.h2
    public final Flowable<Document> O() {
        return Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).map(new x3(this));
    }

    @Override // com.bytedance.ee.bear.list.list.e
    public final LiveData<ArrayList<Document>> X() {
        LiveData<List<mc5.u1>> r0 = ((mc5.j) this.k.a(mc5.j.class)).J3(this.l);
        final MediatorLiveData r1 = new MediatorLiveData();
        final FolderDetailTransformFun r2 = new FolderDetailTransformFun();
        r1.addSource(r0, new r3(r1, r2));
        return r1;
    }

    @Override // uc5.h2
    public final void e0() {
        Disposable r0 = this.o;
        if (r0 != null) goto L5;
    L7:
        this.o = Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(new s3(this), new t3(this));
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        this.o.dispose();
        goto L7
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final com.bytedance.ee.bear.list.u o() {
        return new f1(this.l);
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final mc5.k p() {
        return new p3(this.l, this.k);
    }

    @Override // uc5.h2
    public final Flowable<GetComplaintResult> p0() {
        boolean r0 = this.k.d.isEnable("ccm.platform.appeal_v2");
        return ((com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a) org.koin.java.a.a(com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a.class)).d(sbb.e.f.b, this.l, r0);
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final Flowable<DocumentListInfo> C() {
        return super.C().flatMap(new w1()).doOnNext(new w3(this));
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
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        jg5.e r1 = jg5.e.a.a;
        int r2 = com.bytedance.ee.bear.middleground.permission.b.a;
        boolean r3 = com.bytedance.ee.bear.appsetting.c.a.a.f("tns.crossborder.ccm");
        tt5.a.h("PermFGUtils", "isTnsBlockEnable()...enable = " + r3);
        if (r3 == false) goto L5;
        r0.b("interflow_filter", "CLIENT_VARS");
    L5:
        r0.b("need_path", "1");
        r0.b(ResourceData.KEY_TOKEN, this.l);
        r0.a("shortcut_filter", com.bytedance.ee.bear.list.t0.l());
        com.bytedance.ee.bear.list.v3.a(r0);
        return r0;
    }

    @Override // uc5.h2
    public final ShareFolderUserPermission H1() {
        return this.n;
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final String L() {
        return this.l;
    }

    @Override // uc5.h2
    public final Document getParent() {
        return this.m;
    }

    @Override // uc5.h2
    public final void c(final String r4) {
        tt5.a.h("SubFolderModel", "removeItem()...");
        this.f.add(Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(new u3(this, r4), new v3(this)));
    }

    public y3(LifeCycleFragment r1, Context r2, String r3, ce5.a r4) {
        super(r1, r2, r4);
        this.l = r3;
    }
}
