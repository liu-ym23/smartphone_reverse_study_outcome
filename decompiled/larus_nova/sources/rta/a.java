package rta;

import android.os.CountDownTimer;

/* JADX INFO: loaded from: classes34.dex */
public final class a extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f539199a;

    public a(b r100, long r101) {
        this.f539199a = r100;
        super(r101, 500);
    }

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        this.f539199a.b();
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long r100) {
    }
}
