package bt3;

import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class b$c implements ThreadFactory {
    public b$c() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r3) {
        return new PthreadThreadV2(r3, "Apm_Normal");
    }
}
