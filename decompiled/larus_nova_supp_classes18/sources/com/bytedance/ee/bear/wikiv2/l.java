package com.bytedance.ee.bear.wikiv2;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.wikiv2.home.api.GetSpacePuller;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l implements com.bytedance.ee.bear.contract.route.parcelable.h {
    public boolean a;
    public String b;
    public List<? extends SpaceBean> c;

    public final Flowable a() {
        return b(false, false);
    }

    public final Flowable load() {
        this.b = "";
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == false) goto L7;
        return b(true, true);
    L7:
        if (hu5.a.d(this.c) == false) goto L11;
        int r0 = zp5.f.a;
        return zp5.f.a(-1, new ce5.a()).observeOn(fo5.d.d()).map(new j(this));
    L11:
        return Flowable.just(CollectionsKt.emptyList());
    }

    public l() {
        this.a = true;
        this.b = "";
        this.c = new ArrayList();
    }

    public final boolean hasMore() {
        return this.a;
    }

    public final Flowable b(boolean r6, boolean r7) {
        GetSpacePuller.Params r0 = new GetSpacePuller.Params();
        r0.type = null;
        r0.size = 40;
        r0.last_label = this.b;
        return new GetSpacePuller((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).c(r0).map(new k(this, r6, r7));
    }
}
