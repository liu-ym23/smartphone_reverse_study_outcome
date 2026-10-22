package qf5;

import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.c;
import com.bytedance.ee.bear.middleground.drive.rustsdk.init.d;

/* JADX INFO: loaded from: classes18.dex */
public final class b extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f532743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Runnable f532744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f532745d;

    @Override // com.bytedance.ee.bear.contract.c
    public final void b(AccountService$Account r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.hasLogin() == false) goto L9;
        tt5.a.k("Middleground_Drive_DriveSDK", "account change callback ");
        this.f532743b.a(this.f532744c, this.f532745d, r100);
        return;
    }

    public b(a r100, d r101, String r102) {
        this.f532743b = r100;
        this.f532744c = r101;
        this.f532745d = r102;
    }
}
