package com.bytedance.ee.bear.list.share;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.homepage.banner.BaseBannerModel;
import io.reactivex.Flowable;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u1 extends BaseBannerModel<y0> {
    public boolean h;

    @Override // com.bytedance.ee.bear.list.homepage.banner.BaseBannerModel
    public final mc5.k h() {
        return new y0(false, this.a);
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

    @Override // com.bytedance.ee.bear.list.homepage.banner.BaseBannerModel
    public final LiveData<ArrayList<Document>> k() {
        return Transformations.map(((mc5.j) this.a.a(mc5.j.class)).N5(false), new od5.c());
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.BaseBannerModel, com.bytedance.ee.bear.list.homepage.banner.f
    public final void m5() {
        tt5.a.h("NewSharedBannerModel", "getListFromNet. ");
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L6;
        tt5.a.h("NewSharedBannerModel", "getListFromNet(). no net");
        this.h = false;
        return;
    L6:
        this.d = Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).map(new q1(this)).flatMap(new r1(this)).subscribe(new s1(this), new t1(this));
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.BaseBannerModel
    public final com.bytedance.ee.bear.list.u o() {
        return new s2(false);
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.BaseBannerModel
    public final NetService.f p() {
        return new NetService.f("/space/api/explorer/v2/share/folder/list/");
    }

    public u1(ce5.a r1) {
        super(r1);
        this.g = Integer.MAX_VALUE;
    }
}
