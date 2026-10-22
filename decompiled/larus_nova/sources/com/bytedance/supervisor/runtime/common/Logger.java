package com.bytedance.supervisor.runtime.common;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kf7.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lf7.d;

/* JADX INFO: loaded from: classes22.dex */
public final class Logger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f270338a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/supervisor/runtime/common/Logger$LogLevel;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "runtime_release"}, k = 1, mv = {1, 5, 1})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface LogLevel {
        public static final a Companion = null;
        public static final int DEBUG = 1;
        public static final int ERROR = 4;
        public static final int INFO = 2;
        public static final int WARN = 3;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f270339a = null;

            static {
                f270339a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f270339a;
        }
    }

    static {
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        a(4, r100, r101);
    }

    public static void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        a(2, r100, r101);
    }

    public static void a(@LogLevel int r100, String r101, String r102) {
        String r103 = r101 + ": " + r102;
        b r104 = null;
        if (r100 != 1) goto L5;
        lf7.b r105 = d.f509087a;
        if (r105 == null) goto L36;
        r104 = r105.f509067a;
    L36:
        if (r104 == null) goto L47;
        r104.d(r103);
        return;
    L47:
        return;
    L5:
        if (r100 != 2) goto L7;
        lf7.b r106 = d.f509087a;
        if (r106 == null) goto L29;
        r104 = r106.f509067a;
    L29:
        if (r104 == null) goto L46;
        r104.i(r103);
        return;
    L46:
        return;
    L7:
        if (r100 != 3) goto L9;
        lf7.b r107 = d.f509087a;
        if (r107 == null) goto L22;
        r104 = r107.f509067a;
    L22:
        if (r104 == null) goto L45;
        r104.w(r103);
        return;
    L45:
        return;
    L9:
        if (r100 != 4) goto L43;
        lf7.b r108 = d.f509087a;
        if (r108 == null) goto L15;
        r104 = r108.f509067a;
    L15:
        if (r104 == null) goto L44;
        r104.e(r103);
        return;
    L44:
        return;
    }
}
