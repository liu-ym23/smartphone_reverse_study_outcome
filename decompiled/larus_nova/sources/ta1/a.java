package ta1;

import android.os.Looper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.bpea.cert.token.TokenCert;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes47.dex */
public abstract class a<T> implements o<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f545152b;

    public a() {
        this.f545152b = Collections.synchronizedMap(new HashMap());
    }

    public final boolean H() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdk.log.filter.o
    public final Map<String, String> getMap() {
        return this.f545152b;
    }

    @Override // com.bytedance.android.livesdk.log.filter.o
    public final void putAll(Map<String, String> r100) {
        TokenCert r101 = j0.f153361c;
        if (H() == true) goto L5;
        ALogger.w("ttlive_log", "thread exception, current thread: " + ThreadMethodProxy.currentThread().toString() + ", id: " + ThreadMethodProxy.currentThread().getId());
    L5:
        this.f545152b.putAll(r100);
    }

    @Override // com.bytedance.android.livesdk.log.filter.o
    public final void remove(String r100) {
        this.f545152b.remove(r100);
    }

    @Override // com.bytedance.android.livesdk.log.filter.o
    public final void c(String r100, String r101) {
        TokenCert r102 = j0.f153361c;
        if (H() == true) goto L5;
        ALogger.w("ttlive_log", "thread exception, current thread: " + ThreadMethodProxy.currentThread().toString() + ", id: " + ThreadMethodProxy.currentThread().getId());
    L5:
        this.f545152b.put(r100, r101);
    }
}
