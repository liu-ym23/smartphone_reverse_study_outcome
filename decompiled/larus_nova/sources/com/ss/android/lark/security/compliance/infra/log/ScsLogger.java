package com.ss.android.lark.security.compliance.infra.log;

import com.ss.android.lark.log.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ncb.f;

/* JADX INFO: loaded from: classes38.dex */
public final class ScsLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f440428a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/security/compliance/infra/log/ScsLogger$LogLevel;", "", "Companion", "security-compliance-infra_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface LogLevel {
        public static final a Companion = null;
        public static final int DEBUG = 1;
        public static final int ERROR = 4;
        public static final int INFO = 2;
        public static final int VERBOSE = 0;
        public static final int WARN = 3;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f440429a = null;

            static {
                f440429a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f440429a;
        }
    }

    static {
        int r100 = f.f518706a;
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        b(1, r100, r101);
    }

    public static void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        b(4, r100, r101);
    }

    public static void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        b(2, r100, r101);
    }

    public static void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        b(3, r100, r101);
    }

    public static void b(@LogLevel int r100, String r101, String r102) {
        String r103 = r101 + ": " + r102;
        if (r100 != 0) goto L5;
        Log.v("scs-module", r103);
        return;
    L5:
        if (r100 != 1) goto L7;
        Log.d("scs-module", r103);
        return;
    L7:
        if (r100 != 2) goto L9;
        Log.i("scs-module", r103);
        return;
    L9:
        if (r100 != 3) goto L11;
        Log.w("scs-module", r103);
        return;
    L11:
        if (r100 != 4) goto L23;
        Log.e("scs-module", r103);
        return;
    }
}
