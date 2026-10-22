package r17;

import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f535676a;

    public f() {
        this.f535676a = "MemoryWidget_CheckToDump";
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r100) {
        return new PthreadThreadV2(r100, this.f535676a);
    }
}
