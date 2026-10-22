package lmc;

import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.ugc.live.sdk.msg.utils.i;

/* JADX INFO: loaded from: classes36.dex */
public final class c extends PthreadHandlerThreadV2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f509934c;

    @Override // android.os.HandlerThread
    public final void onLooperPrepared() {
        super.onLooperPrepared();
        a r100 = this.f509934c;
        r100.f509912c = new i(getLooper(), this.f509934c);
        a r101 = this.f509934c;
        r101.f509913d = new i(getLooper(), this.f509934c);
        a r102 = this.f509934c;
        r102.f509914e = new i(getLooper(), this.f509934c);
    }

    public c(a r100) {
        this.f509934c = r100;
        super("UplinkClient");
    }
}
