package kd5;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.AccountService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g2 extends com.bytedance.ee.bear.contract.c {
    public final /* synthetic */ c2 b;

    public g2(c2 r1) {
        this.b = r1;
    }

    public final void b(AccountService.Account r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.hasLogin() == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(this.b.g) == false) goto L9;
    L12:
        c2 r0 = this.b;
        r0.g = r4.uid;
        c2.a(r0);
        this.b.g();
        tt5.a.h("OfflineCacheManager", "registerAccountCallback()...onChanged, account = " + r4);
        return;
    L9:
        if (TextUtils.equals(r4.uid, this.b.g) == false) goto L12;
        tt5.a.h("OfflineCacheManager", "registerAccountCallback()...onChanged, account is same");
    }
}
