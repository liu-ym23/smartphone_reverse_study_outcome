package qr3;

import android.os.CountDownTimer;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e extends CountDownTimer {
    public final /* synthetic */ d.e a;

    @Override // android.os.CountDownTimer
    public final void onTick(long r1) {
    }

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        Logger.i("ByteLocationManagerImpl: LocationGpsStatusListener countdown times finish.");
        String r0 = "locate timeout because of receive valid satellite count is " + this.a.c;
        d.e r1 = this.a;
        if (r1.a == null) goto L5;
        Logger.i("ByteLocationManagerImpl: LocationGpsStatusListener stopCountDownTimer() is executed.");
        r1.a.cancel();
    L5:
        Logger.i("ByteLocationManagerImpl: LocationGpsStatusListener notifyLocationFailed() and the message is " + r0);
        r1.e.getClass();
        r1.e.b.d(new BDLocationException(r0, "ByteLocation", "0"));
        if (r1.d == false) goto L9;
        r1.e.d();
        return;
    }

    public e(d.e r3, long r4) {
        this.a = r3;
        super(r4, 1000);
    }
}
