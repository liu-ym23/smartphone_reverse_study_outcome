package com.bytedance.ee.bear.list.share;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.homepage.banner.BaseBannerModel;
import io.reactivex.Flowable;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n3 extends BaseBannerModel<r2> {
    public boolean h;
    public FolderSortStrategy i;

    @Override // com.bytedance.ee.bear.list.homepage.banner.BaseBannerModel
    public final mc5.k h() {
        return new r2(this.a);
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.BaseBannerModel, com.bytedance.ee.bear.list.homepage.banner.f
    public final boolean hasMore() {
        if (this.f == false) goto L5;
    L8:
        return true;
    L5:
        if (this.h == true) goto L8;
        return false;
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.BaseBannerModel, com.bytedance.ee.bear.list.homepage.banner.f
    public final void m5() {
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L6;
        tt5.a.h("SharedBannerModel", "getListFromNet()...no net");
        this.h = false;
        return;
    L6:
        this.d = w().subscribe(new l3(this), new m3(this));
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.BaseBannerModel
    public final com.bytedance.ee.bear.list.u o() {
        return new s2();
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.BaseBannerModel
    public final NetService.f p() {
        String[] r1 = com.bytedance.ee.bear.list.t0.a;
        NetService.f r0 = new NetService.f("/api/explorer/share/folder/newlist/");
        r0.b("hidden", "0");
        FolderSortStrategy r2 = this.i;
        if (r2 == null) goto L7;
        int r3 = r2.e;
        if (r3 == (-1)) goto L7;
        r0.b("rank", String.valueOf(r3));
        r0.b("asc", String.valueOf(this.i.f));
    L7:
        return r0;
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.BaseBannerModel
    public final Flowable<DocumentListInfo> w() {
        return Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).map(new j3(this)).flatMap(new k3(this));
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.BaseBannerModel
    public final LiveData<ArrayList<Document>> k() {
        r2 r0 = s();
        r0.getClass();
        tt5.a.h("ShareFolderListCache", "getDisplayShareFolderLiveData()...");
        return Transformations.map(((mc5.j) r0.a.a(mc5.j.class)).ae(4), new od5.c());
    }

    public n3(ce5.a r1) {
        super(r1);
        this.g = Integer.MAX_VALUE;
    }

    public static /* synthetic */ Flowable D(n3 r0) {
        return super.w();
    }
}
