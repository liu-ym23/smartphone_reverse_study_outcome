package com.bytedance.ee.bear.contract;

import com.bytedance.ee.bear.contract.config.DocDynamicConfig;
import com.bytedance.ee.bear.contract.config.LoginInfo;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: classes16.dex */
public interface h0 {
    Flowable<Boolean> Be(String r100);

    Flowable<Boolean> C1(DocDynamicConfig r100);

    AccountService$Account G2();

    void Pe(b r100);

    Flowable<AccountService$Account> T4();

    AccountService$Account U5();

    Flowable<Boolean> e5();

    boolean hasLogin();

    void j9(LoginInfo r100);

    Flowable<Boolean> n4(LoginInfo r100);

    void qc(b r100);
}
