package com.ss.android.lark.coremd.base.parse;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C4939a f419532a = null;

    /* JADX INFO: renamed from: com.ss.android.lark.coremd.base.parse.a$a, reason: collision with other inner class name */
    public static final class C4939a implements a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ C4939a f419533b = null;

        static {
            f419533b = new C4939a();
        }

        public C4939a() {
        }

        @Override // com.ss.android.lark.coremd.base.parse.a
        public final b a(com.ss.android.lark.coremd.impl.parse.i r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new b(r101, r102);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f419534a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f419535b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f419534a == r101.f419534a) goto L12;
            return false;
        L12:
            if (this.f419535b == r101.f419535b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f419534a * 31) + this.f419535b;
        }

        public final String toString() {
            return "ImageSize(width=" + this.f419534a + ", height=" + this.f419535b + ')';
        }

        public b(int r100, int r101) {
            this.f419534a = r100;
            this.f419535b = r101;
        }
    }

    static {
        f419532a = C4939a.f419533b;
    }

    b a(com.ss.android.lark.coremd.impl.parse.i r100, int r101, int r102);
}
