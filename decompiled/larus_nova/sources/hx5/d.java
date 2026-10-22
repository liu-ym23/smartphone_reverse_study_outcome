package hx5;

import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements ThreadFactory {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f487506b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f487507a;

    static {
        f487506b = d.class.getSimpleName();
    }

    public d(String r100) {
        this.f487507a = "ttnet-" + r100;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(final Runnable r100) {
        return new PthreadThreadV2(new c(this, r100), this.f487507a);
    }
}
