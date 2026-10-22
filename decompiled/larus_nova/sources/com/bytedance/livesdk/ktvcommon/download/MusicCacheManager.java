package com.bytedance.livesdk.ktvcommon.download;

import com.bytedance.livesdk.ktvcommon.download.model.h;
import com.bytedance.livesdk.ktvcommon.download.model.i;
import com.bytedance.livesdk.ktvcommon.download.model.j;
import com.bytedance.livesdk.ktvcommon.download.model.k;
import com.bytedance.livesdk.ktvcommon.download.model.p;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes20.dex */
public final class MusicCacheManager {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile MusicCacheManager f255911f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f255912g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f255913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f255914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f255915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.livesdk.ktvcommon.download.model.a f255916d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h f255917e;

    public static final class a {
        public final MusicCacheManager a() {
            MusicCacheManager r100 = MusicCacheManager.f255911f;
            if (r100 != null) goto L13;
            monitor-enter(this);
            r100 = MusicCacheManager.f255911f;     // Catch: Throwable -> L10
            if (r100 != null) goto L8;
            r100 = new MusicCacheManager();     // Catch: Throwable -> L10
            MusicCacheManager.f255911f = r100;     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
        L10:
            th = move-exception;
            throw th;
        L13:
            return r100;
        }

        public a() {
        }
    }

    static {
        f255912g = new a();
    }

    public MusicCacheManager() {
        Lazy r100 = LazyKt.lazy(MusicCacheManager$STORAGE_ROOT_DIR$2.INSTANCE);
        this.f255913a = r100;
        p r101 = new p((String) r100.getValue());
        yk6.d r102 = new yk6.d();
        yk6.c r103 = new yk6.c();
        this.f255914b = new i(r101, r102, r103);
        this.f255915c = new k(r101, r102, r103);
        this.f255916d = new com.bytedance.livesdk.ktvcommon.download.model.a(r101, r102, r103);
        this.f255917e = new h(r101, r102, r103);
        new j(r101, r102, r103);
    }
}
