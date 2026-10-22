package com.bytedance.ies.bullet.preloadv2.cache;

import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.bytedance.ies.bullet.preloadv2.PreloadV2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class h extends f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f247713d = null;

    public static final class a extends g {
        public a(int r100) {
            super("子资源缓存池", r100);
        }

        @Override // android.util.LruCache
        public final int sizeOf(String r100, PreloadItem r101) {
            PreloadItem r102 = r101;
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.bytedance.ies.bullet.preloadv2.cache.PreloadItem");
            return r102.e();
        }
    }

    static {
        f247713d = new h();
    }

    public h() {
        boolean r100 = PreloadV2.f247628a;
        super(PreloadV2.f247630c);
    }

    @Override // com.bytedance.ies.bullet.preloadv2.cache.f
    public final g b(int r100) {
        if (r100 > 0) goto L6;
        r100 = BmLocated.ALIGN_RIGHT_BOTTOM;
    L6:
        return new a(r100);
    }
}
