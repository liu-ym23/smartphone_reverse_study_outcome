package qr3;

import android.os.CountDownTimer;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;

/* JADX INFO: loaded from: classes14.dex */
public final class e extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d.e f534614a;

    @Override // android.os.CountDownTimer
    public final void onTick(long r100) {
    }

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        Logger.i("ByteLocationManagerImpl: LocationGpsStatusListener countdown times finish.");
        String r100 = "locate timeout because of receive valid satellite count is " + this.f534614a.f534602c;
        d.e r101 = this.f534614a;
        if (r101.f534600a == null) goto L5;
        Logger.i("ByteLocationManagerImpl: LocationGpsStatusListener stopCountDownTimer() is executed.");
        r101.f534600a.cancel();
    L5:
        Logger.i("ByteLocationManagerImpl: LocationGpsStatusListener notifyLocationFailed() and the message is " + r100);
        r101.f534604e.getClass();
        r101.f534604e.f534587b.d(new BDLocationException(r100, LocationInfoConst.BYTE, "0"));
        if (r101.f534603d == false) goto L9;
        r101.f534604e.d();
        return;
    }

    public e(d.e r100, long r101) {
        this.f534614a = r100;
        super(r101, 1000);
    }
}
