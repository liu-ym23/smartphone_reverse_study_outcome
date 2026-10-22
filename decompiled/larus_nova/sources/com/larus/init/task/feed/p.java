package com.larus.init.task.feed;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.disk.api.CacheHandlerBiz;
import com.larus.disk.api.CacheHandlerBusiness;
import com.larus.utils.r;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f351258a = null;

    public static final class a implements com.larus.disk.api.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File f351259a;

        @Override // com.larus.disk.api.c
        public final String bizTag() {
            return CacheHandlerBiz.BIZ_MIRA_PLUGIN_PACKAGE;
        }

        @Override // com.larus.disk.api.c
        public final String business() {
            return CacheHandlerBusiness.APP_TECH;
        }

        @Override // com.larus.disk.api.c
        public final void h(boolean r100, boolean r101) {
        }

        @Override // com.larus.disk.api.c
        public final boolean i() {
            return false;
        }

        @Override // com.larus.disk.api.c
        public final String a() {
            return this.f351259a.getAbsolutePath();
        }

        @Override // com.larus.disk.api.c
        public final long getCacheSize() {
            if (this.f351259a.exists() == true) goto L5;
            return 0;
        L5:
            return RangesKt.coerceAtLeast(r.r(this.f351259a), 0);
        }

        public a(PolarisFileWrapper r100) {
            Intrinsics.checkNotNullParameter(r100, "pluginRoot");
            this.f351259a = r100;
        }

        @Override // com.larus.disk.api.c
        public final long b(boolean r100) {
            return getCacheSize();
        }
    }

    static {
        f351258a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new o());
    }
}
