package com.bytedance.ee.bear.document.render.node;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface q {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    public static final class b implements q {
        public final int b;
        public final Throwable c;

        public final String toString() {
            return "Error(" + this.b + ", " + this.c + ')';
        }

        public b(int r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r3, "throwable");
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class c implements q {
        public c() {
        }

        public final String toString() {
            return "Success";
        }
    }

    static {
        a = a.a;
    }
}
