package uc5;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.folder.FolderDetailTransformFun;
import com.bytedance.ee.bear.list.recent.SubordinateRecentDocumentFragment;
import com.bytedance.ee.bear.list.sort.FilterType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class q2 extends com.bytedance.ee.bear.list.list.a<j2> implements g2 {

    public class a extends MediatorLiveData<ArrayList<Document>> {
        public final /* synthetic */ long a;
        public final /* synthetic */ LiveData b;
        public final /* synthetic */ q2 c;

        public final void onActive() {
            super.onActive();
            this.c.getClass();
            tt5.a.h("MyRootFolderModel", "getListLiveData()...mapped active, path = , sinceCreate = " + (System.currentTimeMillis() - this.a) + ", sourceHash = " + System.identityHashCode(this.b) + ", mappedHash = " + System.identityHashCode(this) + ", modelHash = " + System.identityHashCode(this.c) + ", thread = " + ThreadMethodProxy.currentThread().getName());
        }

        public final void onInactive() {
            super.onInactive();
            this.c.getClass();
            tt5.a.h("MyRootFolderModel", "getListLiveData()...mapped inactive, path = , sinceCreate = " + (System.currentTimeMillis() - this.a) + ", sourceHash = " + System.identityHashCode(this.b) + ", mappedHash = " + System.identityHashCode(this) + ", modelHash = " + System.identityHashCode(this.c) + ", thread = " + ThreadMethodProxy.currentThread().getName());
        }

        public a(q2 r1, long r2, LiveData r4) {
            this.c = r1;
            this.a = r2;
            this.b = r4;
        }
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public String L() {
        return "my_root";
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final String P() {
        return "MyRootFolderModel";
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public boolean a0() {
        return this instanceof SubordinateRecentDocumentFragment.SubordinateRecentDocumentViewModel;
    }

    @Override // com.bytedance.ee.bear.list.list.e
    public LiveData<ArrayList<Document>> X() {
        final long r11 = System.currentTimeMillis();
        tt5.a.h("MyRootFolderModel", "getListLiveData()...start, path = , modelHash = " + System.identityHashCode(this) + ", thread = " + ThreadMethodProxy.currentThread().getName());
        final mc5.j r9 = (mc5.j) this.k.a(mc5.j.class);
        boolean r0 = AppInfoUtils.f().booleanValue();
        if (r0 == false) goto L5;
        LiveData<List<mc5.u1>> r2 = r9.Rd();
    L6:
        final LiveData<List<mc5.u1>> r14 = r2;
        final long r6 = System.currentTimeMillis();
        tt5.a.h("MyRootFolderModel", "getListLiveData()...source created, path = , cost = " + (r6 - r11) + ", sourceHash = " + System.identityHashCode(r14) + ", modelHash = " + System.identityHashCode(this) + ", thread = " + ThreadMethodProxy.currentThread().getName());
        final a r4 = new a(this, r11, r14);
        final FolderDetailTransformFun r3 = new FolderDetailTransformFun();
        if (r0 == false) goto L9;
        final a r10 = r4;
        r10.addSource(r14, new n2(this, r4, r3, r11, r6, r14, r9));
    L10:
        tt5.a.h("MyRootFolderModel", "getListLiveData()...mapped ready, path = , totalCost = " + (System.currentTimeMillis() - r11) + ", sourceHash = " + System.identityHashCode(r14) + ", mappedHash = " + System.identityHashCode(r10) + ", modelHash = " + System.identityHashCode(this));
        return r10;
    L9:
        r10 = r4;
        r10.addSource(r14, new o2(this, r10, r3, r11, r6, r14));
        goto L10
    L5:
        r2 = r9.J3("");
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public com.bytedance.ee.bear.list.u o() {
        return new k2();
    }

    public j2 x0() {
        return new j2(this.k);
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public NetService.f h() {
        if (AppInfoUtils.f().booleanValue() == true) goto L5;
        NetService.f r0 = super.h();
        r0.b("need_path", "1");
        r0.a("shortcut_filter", com.bytedance.ee.bear.list.t0.l());
        com.bytedance.ee.bear.list.v3.a(r0);
        return r0;
    L5:
        return t0(false);
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public String k() {
        if (AppInfoUtils.f().booleanValue() == false) goto L6;
        return "/space/api/explorer/v4/children/list/";
    L6:
        return "/space/api/explorer/v3/my_space/list/";
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public /* bridge */ /* synthetic */ mc5.k p() {
        return x0();
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final Flowable<DocumentListInfo> s() {
        if (AppInfoUtils.f().booleanValue() == false) goto L7;
        return w().a(t0(true));
    L7:
        return super.s();
    }

    @Override // uc5.g2
    public final void c(final String r4) {
        tt5.a.h("MyRootFolderModel", "removeItem()...");
        this.f.add(Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(new l2(this, r4), new m2(this)));
    }

    public final NetService.f t0(boolean r6) {
        NetService.f r0 = new NetService.f("/space/api/explorer/v4/children/list/");
        r0.b(ResourceData.KEY_TOKEN, "");
        r0.b("length", D());
        FolderSortStrategy r1 = this.c;
        if (r1 == null) goto L18;
        int r2 = r1.getType();
        sbb.e r3 = sbb.e.g;
        if (r2 != r3.b) goto L9;
        ArrayList r4 = new ArrayList();
        r4.add(String.valueOf(r3.b));
        r4.add(String.valueOf(sbb.e.o.b));
        r0.a("obj_type", r4);
    L13:
        int r5 = this.c.e;
        if (r5 == (-1)) goto L18;
        r0.b("rank", String.valueOf(r5));
        r0.b("asc", String.valueOf(this.c.f));
        goto L18
    L9:
        if (this.c.getType() == sbb.e.e.b) goto L13;
        int r7 = this.c.getType();
        FolderSortStrategy r8 = this.c;
        if (FilterType.isPhotoV2(r7, r8.c, r8.d) == true) goto L13;
        r0.b("obj_type", String.valueOf(this.c.getType()));
    L18:
        if (com.bytedance.ee.bear.list.v3.a(r0) == true) goto L20;
        r0.b("thumbnail_mode", "0");
    L20:
        if (r6 == false) goto L26;
        DocumentListInfo r9 = this.h;
        if (r9 == null) goto L26;
        if (TextUtils.isEmpty(r9.getLastLabel()) == true) goto L26;
        r0.b("last_label", this.h.getLastLabel());
    L26:
        StringBuilder r10 = new StringBuilder("buildDoubaoV4ChildrenRequest()...loadMore = ");
        r10.append(r6);
        r10.append(", hasLastLabel = ");
        DocumentListInfo r11 = this.h;
        if (r11 != null) goto L29;
    L31:
        boolean r12 = false;
    L32:
        r10.append(r12);
        tt5.a.h("MyRootFolderModel", r10.toString());
        return r0;
    L29:
        if (TextUtils.isEmpty(r11.getLastLabel()) == true) goto L31;
        r12 = true;
        goto L32
    }

    public q2(LifeCycleFragment r1, Context r2, ce5.a r3) {
        super(r1, r2, r3);
    }

    public final void u0(MediatorLiveData<ArrayList<Document>> r5, FolderDetailTransformFun r6, List<mc5.u1> r7, long r8, long r10, LiveData<List<mc5.u1>> r12, String r13) {
        long r0 = System.currentTimeMillis();
        if (r7 != null) goto L5;
        r7 = Collections.emptyList();
    L5:
        ArrayList<Document> r9 = r6.a(r7);
        tt5.a.h("MyRootFolderModel", "getListLiveData()...source changed, path = , sourceType = " + r13 + ", rawSize = " + r7.size() + ", mappedSize = " + r9.size() + ", sinceCreate = " + (r0 - r8) + ", sinceSourceCreated = " + (r0 - r10) + ", sourceHash = " + System.identityHashCode(r12) + ", mappedHash = " + System.identityHashCode(r5) + ", modelHash = " + System.identityHashCode(this) + ", thread = " + ThreadMethodProxy.currentThread().getName());
        r5.setValue(r9);
    }
}
