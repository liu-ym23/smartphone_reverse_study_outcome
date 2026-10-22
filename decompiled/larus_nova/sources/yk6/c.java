package yk6;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class c implements com.bytedance.livesdk.ktvcommon.download.api.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f568225a;

    public static final class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f568226a = null;

        static {
            f568226a = new a();
        }

        public a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            PthreadThreadV2 r101 = new PthreadThreadV2(r100, "FileOperationThread");
            r101.setDaemon(true);
            return r101;
        }
    }

    public c() {
        this.f568225a = PThreadExecutorsUtils.newSingleThreadExecutor(a.f568226a);
    }

    @Override // com.bytedance.livesdk.ktvcommon.download.api.c
    public final void a(final Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        this.f568225a.execute(new b(r100));
    }
}
