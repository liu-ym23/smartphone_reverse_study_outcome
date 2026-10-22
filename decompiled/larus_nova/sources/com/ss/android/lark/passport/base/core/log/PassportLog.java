package com.ss.android.lark.passport.base.core.log;

import com.ss.android.lark.log.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class PassportLog {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/passport/base/core/log/PassportLog$LogLevel;", "", "Companion", "passport-base-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface LogLevel {
        public static final a Companion = null;
        public static final int DEBUG = 1;
        public static final int ERROR = 4;
        public static final int FATAL = 5;
        public static final int INFO = 2;
        public static final int VERBOSE = 0;
        public static final int WARN = 3;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f437715a = null;

            static {
                f437715a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f437715a;
        }
    }

    static {
    }

    @JvmStatic
    public static final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        a(r100, r101, 4);
    }

    @JvmStatic
    public static final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        a(r100, r101, 2);
    }

    @JvmStatic
    public static final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        a(r100, r101, 3);
    }

    public static void a(String r100, String r101, @LogLevel int r102) {
        String r103 = "Passport_".concat(r100);
        String r104 = String.valueOf(r101);
        if (r102 != 0) goto L5;
        Log.v(r103, r104);
        return;
    L5:
        if (r102 != 1) goto L7;
        Log.d(r103, r104);
        return;
    L7:
        if (r102 != 2) goto L9;
        Log.i(r103, r104);
        return;
    L9:
        if (r102 != 3) goto L11;
        Log.w(r103, r104);
        return;
    L11:
        if (r102 == 4) goto L13;
        Log.i(r103, r104);
        return;
    L13:
        Log.e(r103, r104);
    }

    @JvmStatic
    public static final void c(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Log.e("Passport_".concat(r100), r101, r102);
    }
}
