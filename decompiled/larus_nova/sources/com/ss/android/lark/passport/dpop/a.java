package com.ss.android.lark.passport.dpop;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public interface a {

    /* JADX INFO: renamed from: com.ss.android.lark.passport.dpop.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC5227a extends b {
        public AbstractC5227a(int r100) {
        }
    }

    public static abstract class b {
        public b() {
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f437723a = null;

        static {
            f437723a = new c();
        }

        public c() {
        }
    }

    public static final class d extends AbstractC5227a {
        public d() {
            super(0);
        }
    }

    public static final class e extends AbstractC5227a {
        public e() {
            super(0);
        }
    }

    public static final class f extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f437724a;

        public f(String r100) {
            Intrinsics.checkNotNullParameter(r100, "dpopToken");
            this.f437724a = r100;
        }
    }

    b a();
}
