package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f241901c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WikiAction f241902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f241903b;

    public static final class a {
        @JvmStatic
        public static d b(WikiAction r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            return new d(r100);
        }

        @JvmStatic
        public static com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.a a(WikiAction r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r100, "action");
            Intrinsics.checkNotNullParameter(r101, "err");
            return new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.a(r100, r101);
        }

        @JvmStatic
        public static g c(WikiAction r100, d3 r101) {
            Intrinsics.checkNotNullParameter(r100, "action");
            return new g(r100, r101);
        }
    }

    static {
    }

    @JvmStatic
    public static final com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.a a(WikiAction r100, Throwable r101) {
        return a.a(r100, r101);
    }

    @JvmStatic
    public static final d b(WikiAction r100) {
        return a.b(r100);
    }

    @JvmStatic
    public static final g c(WikiAction r100, d3 r101) {
        return a.c(r100, r101);
    }

    public final String toString() {
        return getClass().getSimpleName() + "(action=" + this.f241902a + ')';
    }

    public h(WikiAction r100) {
        this.f241902a = r100;
        this.f241903b = "";
    }
}
