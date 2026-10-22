package x1;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes39.dex */
public final class b extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f562092a;

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        super.handleMessage(r100);
        a r101 = this.f562092a;
        String r102 = r101.f562080a;
        int r103 = r100.what;
        if (r103 != 1025) goto L5;
        a.c(r102, "handleMessage: ------BES_NOTI_MSG_TIMEOUT_TOTA_START");
        a r104 = this.f562092a;
        r104.f562087h = false;
        r104.f562085f = false;
        r104.g(false);
        r104.i();
        return;
    L5:
        if (r103 != 1028) goto L11;
        r101.e(1028);
        return;
    }

    public b(w1.b r100, Looper r101) {
        this.f562092a = r100;
        super(r101);
    }
}
