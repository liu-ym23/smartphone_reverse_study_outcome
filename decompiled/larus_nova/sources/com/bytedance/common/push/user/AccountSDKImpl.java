package com.bytedance.common.push.user;

import com.bytedance.common.push.interfaze.IAccountService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import rgc.b;
import rgc.c;
import sgc.a;

/* JADX INFO: loaded from: classes3.dex */
public class AccountSDKImpl implements IAccountService {
    public AccountSDKImpl() {
    }

    @Override // com.bytedance.common.push.interfaze.IAccountService
    public List<String> getLoginHistoryUids() {
        a r100 = (a) b.a(a.class);
        if (r100 != null) goto L6;
        return null;
    L6:
        final CountDownLatch r101 = new CountDownLatch(1);
        final ArrayList r102 = new ArrayList();
        r100.r0(new AnonymousClass1(this, r102, r101));
        r101.await();     // Catch: InterruptedException -> L9
    L11:
        return r102;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    @Override // com.bytedance.common.push.interfaze.IAccountService
    public String getSecUid() {
        a r100 = (a) b.a(a.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSecUid();
    }

    @Override // com.bytedance.common.push.interfaze.IAccountService
    public void registerOnAccountSwitchListener(c.d<tgc.c> r100) {
        c.b(null, r100);
    }

    @Override // com.bytedance.common.push.interfaze.IAccountService
    public void registerOnLoginListener(c.d<tgc.a> r100) {
        c.b(null, r100);
    }

    @Override // com.bytedance.common.push.interfaze.IAccountService
    public void registerOnLogoutListener(c.d<tgc.b> r100) {
        c.b(null, r100);
    }
}
