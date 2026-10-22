package com.bytedance.lark.policy.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class Logger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f253883a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/lark/policy/utils/Logger$LogLevel;", "", "Companion", "policy-engine_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface LogLevel {
        public static final a Companion = null;
        public static final int DEBUG = 1;
        public static final int ERROR = 4;
        public static final int INFO = 2;
        public static final int WARN = 3;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f253884a = null;

            static {
                f253884a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f253884a;
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
        if (r100 != 1) goto L5;
        ke6.d.f503032a.getClass();
        ne6.a r104 = ke6.d.a();
        if (r104 == null) goto L30;
        r104.d(r103);
        return;
    L30:
        return;
    L5:
        if (r100 != 2) goto L7;
        ke6.d.f503032a.getClass();
        ne6.a r105 = ke6.d.a();
        if (r105 == null) goto L28;
        r105.i("PolicyEngine", r103);
        return;
    L28:
        return;
    L7:
        if (r100 != 3) goto L9;
        ke6.d.f503032a.getClass();
        ne6.a r106 = ke6.d.a();
        if (r106 == null) goto L26;
        r106.w(r103);
        return;
    L26:
        return;
    L9:
        if (r100 != 4) goto L31;
        ke6.d.f503032a.getClass();
        ne6.a r107 = ke6.d.a();
        if (r107 == null) goto L24;
        r107.e("PolicyEngine", r103);
        return;
    L24:
        return;
    }
}
