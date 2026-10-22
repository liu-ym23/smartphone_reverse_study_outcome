package ovc;

import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import java.util.HashMap;
import java.util.Observable;

/* JADX INFO: loaded from: classes42.dex */
public final class d extends Observable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile d f527020a;

    public static d a() {
        if (f527020a != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f527020a != null) goto L9;
        f527020a = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f527020a;
    }

    public d() {
    }

    public final void b(String r100, long r101, long r102, boolean r103) {
        HashMap r104 = new HashMap();
        r104.put("url", r100);
        r104.put(StreamTrafficObservable.STREAM_SENTBYTES, Long.valueOf(r101));
        r104.put(StreamTrafficObservable.STREAM_RECEIVEDBYTES, Long.valueOf(r102));
        r104.put("is_heartbeat_frame", Boolean.valueOf(r103));
        setChanged();
        notifyObservers(r104);
    }
}
