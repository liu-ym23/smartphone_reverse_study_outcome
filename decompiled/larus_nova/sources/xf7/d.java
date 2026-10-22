package xf7;

import android.os.Handler;
import android.os.Message;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final yf7.o f563449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Long, o> f563450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o.a f563451c;

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        return false;
    }

    public d(o.a r100, u.b r101) {
        this.f563450b = new ConcurrentHashMap();
        this.f563451c = r100;
        this.f563449a = r101;
    }
}
