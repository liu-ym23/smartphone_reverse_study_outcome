package ww7;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: classes23.dex */
public final class o implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f561686a;

    public o(r r100) {
        this.f561686a = r100;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (r100.what != 1001) goto L9;
        this.f561686a.a(8002003);
        return true;
    L9:
        return false;
    }
}
