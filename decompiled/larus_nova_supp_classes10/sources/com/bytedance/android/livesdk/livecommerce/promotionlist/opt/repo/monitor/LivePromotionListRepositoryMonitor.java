package com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor;

import android.util.LruCache;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import java.util.Map;
import java.util.Stack;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LivePromotionListRepositoryMonitor implements b {
    public static final /* synthetic */ int c = 0;
    public final Lazy a;
    public final LruCache<String, Stack<pj2.a>> b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.b
    public final void clear() {
        new AnonymousClass1(this).invoke();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    public LivePromotionListRepositoryMonitor() {
        this.a = LazyKt.lazy(LivePromotionListRepositoryMonitor$liveRoomParams$2.INSTANCE);
        this.b = new LruCache(10);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.b
    public final void b(final pj2.a r2) {
        Intrinsics.checkNotNullParameter(r2, "node");
        new LivePromotionListRepositoryMonitor$monitorDuration$1(this, r2).invoke();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.b
    public final void a(final c r2, final Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        new LivePromotionListRepositoryMonitor$report$1(this, r2, r3).invoke();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }
}
