package io.ktor.client.plugins;

import io.ktor.util.KtorDsl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f491744a = null;

    @KtorDsl
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f491745a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f491746b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f491747c;

        /* JADX INFO: renamed from: io.ktor.client.plugins.s$a$a, reason: collision with other inner class name */
        public static final class C6308a {
        }

        static {
            Intrinsics.checkNotNullParameter("TimeoutConfiguration", "name");
            if ("TimeoutConfiguration".length() != 0) goto L5;
            boolean r100 = true;
        L6:
            if (r100 == true) goto L9;
            return;
        L9:
            throw new IllegalStateException("Name can't be blank");
        L5:
            r100 = false;
            goto L6
        }

        public final int hashCode() {
            Long r100 = this.f491745a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Long r104 = this.f491746b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            Long r107 = this.f491747c;
            if (r107 == null) goto L14;
            r101 = r107.hashCode();
        L14:
            return r106 + r101;
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public a() {
            this.f491745a = 0L;
            this.f491746b = 0L;
            this.f491747c = 0L;
            a(null);
            this.f491745a = null;
            a(null);
            this.f491746b = null;
            a(null);
            this.f491747c = null;
        }

        public static void a(Long r100) {
            if (r100 != null) goto L4;
        L7:
            boolean r101 = true;
        L8:
            if (r101 == false) goto L11;
            return;
        L11:
            throw new IllegalArgumentException("Only positive timeout values are allowed, for infinite timeout use HttpTimeout.INFINITE_TIMEOUT_MS".toString());
        L4:
            if (r100.longValue() > 0) goto L7;
            r101 = false;
            goto L8
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L20:
            return false;
        L8:
            if (a.class != r100.getClass()) goto L20;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f491745a, r101.f491745a) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.f491746b, r101.f491746b) == true) goto L17;
            return false;
        L17:
            if (Intrinsics.areEqual(this.f491747c, r101.f491747c) == true) goto L19;
            return false;
        L19:
            return true;
        }
    }

    public static final class b implements j<a, s>, io.ktor.client.engine.c<a> {
        public b() {
        }
    }

    static {
        f491744a = new b();
        Intrinsics.checkNotNullParameter("TimeoutPlugin", "name");
    }
}
