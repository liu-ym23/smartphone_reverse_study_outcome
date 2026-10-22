package lfa;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.obric.aiagent.platform.depend.ILogDepend;

/* JADX INFO: loaded from: classes33.dex */
public final class a extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f509097a;

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        int r101 = r100.what;
        boolean r102 = false;
        if (r101 == 1) goto L14;
        if (r101 != 2) goto L19;
        c r103 = this.f509097a;
        int r104 = r103.f509104e + 1;
        r103.f509104e = r104;
        if (r104 > 3) goto L13;
        ILogDepend.f384986a.i("CaeMultipathClient", "Reconnecting, attempt: " + this.f509097a.f509104e);
        c r105 = this.f509097a;
        if (r105.f509100a == null) goto L11;
        r102 = true;
    L11:
        if (r102 == true) goto L16;
        c.b(r105);
        return;
    L16:
        return;
    L13:
        ILogDepend.f384986a.e("CaeMultipathClient", "Max reconnect times (3) reached, stop.");
        return;
    L19:
        return;
    L14:
        this.f509097a.f509104e = 0;
        removeMessages(2);
        c.b(this.f509097a);
    }

    public a(c r100, Looper r101) {
        this.f509097a = r100;
        super(r101);
    }
}
