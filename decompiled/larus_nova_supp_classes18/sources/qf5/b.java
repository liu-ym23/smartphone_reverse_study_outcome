package qf5;

import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.c;
import com.bytedance.ee.bear.middleground.drive.rustsdk.init.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends c {
    public final /* synthetic */ a b;
    public final /* synthetic */ Runnable c;
    public final /* synthetic */ String d;

    public final void b(AccountService.Account r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.hasLogin() == false) goto L9;
        tt5.a.k("Middleground_Drive_DriveSDK", "account change callback ");
        this.b.a(this.c, this.d, r4);
        return;
    }

    public b(a r1, d r2, String r3) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
    }
}
