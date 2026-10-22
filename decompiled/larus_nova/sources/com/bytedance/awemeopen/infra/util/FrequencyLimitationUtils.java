package com.bytedance.awemeopen.infra.util;

import android.content.SharedPreferences;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class FrequencyLimitationUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Long> f198948a = null;

    public static final class InstallationCounter implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f198949a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Lazy f198950b;

        @Override // com.bytedance.awemeopen.infra.util.FrequencyLimitationUtils.b
        public final long getCount() {
            return ((SharedPreferences) this.f198950b.getValue()).getLong(this.f198949a, 0);
        }

        @Override // com.bytedance.awemeopen.infra.util.FrequencyLimitationUtils.b
        public final void a() {
            long r100 = getCount();
            ((SharedPreferences) this.f198950b.getValue()).edit().putLong(this.f198949a, r100 + 1).apply();
        }

        public InstallationCounter(String r100) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            this.f198949a = r100;
            this.f198950b = LazyKt.lazy(FrequencyLimitationUtils$InstallationCounter$sp$2.INSTANCE);
        }
    }

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f198951a;

        @Override // com.bytedance.awemeopen.infra.util.FrequencyLimitationUtils.b
        public final long getCount() {
            Long r100 = FrequencyLimitationUtils.f198948a.get(this.f198951a);
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.longValue();
        }

        @Override // com.bytedance.awemeopen.infra.util.FrequencyLimitationUtils.b
        public final void a() {
            long r100 = getCount();
            FrequencyLimitationUtils.f198948a.put(this.f198951a, Long.valueOf(r100 + 1));
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            this.f198951a = r100;
        }
    }

    public interface b {
        void a();

        long getCount();
    }

    static {
        f198948a = new ConcurrentHashMap();
    }

    public static b a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        if (r101 == 0) goto L10;
        if (r101 != 1) goto L8;
        return new a(r100);
    L8:
        throw new IllegalArgumentException("no scope support for " + r101);
    L10:
        return new InstallationCounter(r100);
    }
}
