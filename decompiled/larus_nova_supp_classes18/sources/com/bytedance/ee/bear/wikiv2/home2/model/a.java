package com.bytedance.ee.bear.wikiv2.home2.model;

import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface a {
    Flowable<WikiSpacesResp> a();

    Flowable<WikiSpacesResp> b();

    Flowable<WikiSpacesResp> c();

    Flowable<Boolean> d(String r1);

    Flowable<WikiSpacesResp> e();

    Flowable<WikiSpacesResp> f();

    Flowable<WikiSpacesResp> g();

    Flowable<Boolean> h(String r1);

    Flowable<Boolean> i(WikiSpaceFilter r1);
}
