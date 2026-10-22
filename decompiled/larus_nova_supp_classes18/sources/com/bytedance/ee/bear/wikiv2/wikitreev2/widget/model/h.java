package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class h {
    public static final /* synthetic */ int c = 0;
    public final WikiAction a;
    public String b;

    public static final class a {
        @JvmStatic
        public static d b(WikiAction r1) {
            Intrinsics.checkNotNullParameter(r1, "action");
            return new d(r1);
        }

        @JvmStatic
        public static com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.a a(WikiAction r1, Throwable r2) {
            Intrinsics.checkNotNullParameter(r1, "action");
            Intrinsics.checkNotNullParameter(r2, "err");
            return new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.a(r1, r2);
        }

        @JvmStatic
        public static g c(WikiAction r1, d3 r2) {
            Intrinsics.checkNotNullParameter(r1, "action");
            return new g(r1, r2);
        }
    }

    static {
    }

    @JvmStatic
    public static final com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.a a(WikiAction r0, Throwable r1) {
        return a.a(r0, r1);
    }

    @JvmStatic
    public static final d b(WikiAction r0) {
        return a.b(r0);
    }

    @JvmStatic
    public static final g c(WikiAction r0, d3 r1) {
        return a.c(r0, r1);
    }

    public final String toString() {
        return getClass().getSimpleName() + "(action=" + this.a + ')';
    }

    public h(WikiAction r1) {
        this.a = r1;
        this.b = "";
    }
}
