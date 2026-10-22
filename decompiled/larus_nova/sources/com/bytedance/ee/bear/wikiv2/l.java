package com.bytedance.ee.bear.wikiv2;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.wikiv2.home.api.GetSpacePuller;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class l implements com.bytedance.ee.bear.contract.route.parcelable.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f240977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f240978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<? extends SpaceBean> f240979c;

    @Override // com.bytedance.ee.bear.contract.route.parcelable.h
    public final Flowable a() {
        return b(false, false);
    }

    @Override // com.bytedance.ee.bear.contract.route.parcelable.h
    public final Flowable load() {
        this.f240978b = "";
        if (com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a() == false) goto L7;
        return b(true, true);
    L7:
        if (hu5.a.d(this.f240979c) == false) goto L11;
        int r100 = zp5.f.f573192a;
        return zp5.f.a(-1, new ce5.a()).observeOn(fo5.d.d()).map(new j(this));
    L11:
        return Flowable.just(CollectionsKt.emptyList());
    }

    public l() {
        this.f240977a = true;
        this.f240978b = "";
        this.f240979c = new ArrayList();
    }

    @Override // com.bytedance.ee.bear.contract.route.parcelable.h
    public final boolean hasMore() {
        return this.f240977a;
    }

    public final Flowable b(boolean r100, boolean r101) {
        GetSpacePuller.Params r102 = new GetSpacePuller.Params();
        r102.type = null;
        r102.size = 40;
        r102.last_label = this.f240978b;
        return new GetSpacePuller((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).c(r102).map(new k(this, r100, r101));
    }
}
