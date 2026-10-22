package com.ss.android.agilelogger.utils;

import android.content.Intent;
import android.os.Bundle;
import java.util.concurrent.ConcurrentHashMap;
import ora.a;
import sra.b;

/* JADX INFO: loaded from: classes6.dex */
public final class FormatUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<TYPE, a> f406453a = null;

    public static final enum TYPE extends Enum<TYPE> {
        public static final TYPE BORDER = null;
        public static final TYPE BUNDLE = null;
        public static final TYPE INTENT = null;
        public static final TYPE JSON = null;
        public static final TYPE MSG = null;
        public static final TYPE STACKTRACE = null;
        public static final TYPE STACKTRACE_STR = null;
        public static final TYPE THREAD = null;
        public static final TYPE THROWABLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TYPE[] f406454a = null;

        static {
            TYPE r100 = new TYPE("MSG", 0);
            MSG = r100;
            TYPE r101 = new TYPE("JSON", 1);
            JSON = r101;
            TYPE r102 = new TYPE("BUNDLE", 2);
            BUNDLE = r102;
            TYPE r103 = new TYPE("INTENT", 3);
            INTENT = r103;
            TYPE r104 = new TYPE("THROWABLE", 4);
            THROWABLE = r104;
            TYPE r105 = new TYPE("BORDER", 5);
            BORDER = r105;
            TYPE r110 = new TYPE("STACKTRACE", 6);
            STACKTRACE = r110;
            TYPE r111 = new TYPE("THREAD", 7);
            THREAD = r111;
            TYPE r112 = new TYPE("STACKTRACE_STR", 8);
            STACKTRACE_STR = r112;
            f406454a = new TYPE[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
        }

        public static TYPE[] values() {
            return (TYPE[]) f406454a.clone();
        }

        public static TYPE valueOf(String r100) {
            return (TYPE) r27.a.a(TYPE.class, r100);
        }

        public TYPE(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        ConcurrentHashMap<TYPE, a> r100 = new ConcurrentHashMap();
        f406453a = r100;
        r100.put(TYPE.MSG, new qra.a());
        r100.put(TYPE.JSON, new rra.a());
        r100.put(TYPE.BUNDLE, new sra.a());
        r100.put(TYPE.INTENT, new b());
        r100.put(TYPE.BORDER, new pra.a());
        r100.put(TYPE.STACKTRACE, new ura.a());
        r100.put(TYPE.THREAD, new vra.a());
        r100.put(TYPE.THROWABLE, new tra.a());
    }

    public static String a(TYPE r100, Intent r101) {
        ((b) f406453a.get(r100)).getClass();
        return b.b(r101);
    }

    public static String b(TYPE r100, Bundle r101) {
        ((sra.a) f406453a.get(r100)).getClass();
        return wra.b.b(r101);
    }

    public static String c(TYPE r100, String r101) {
        a r102 = f406453a.get(r100);
        if (r102 != null) goto L5;
        return r101;
    L5:
        if (r100 != TYPE.BORDER) goto L9;
        return r102.a(new String[]{r101});
    L9:
        return r102.a(r101);
    }

    public static String d(TYPE r100, Thread r101) {
        return f406453a.get(r100).a(r101);
    }

    public static String e(TYPE r100, Throwable r101) {
        return f406453a.get(r100).a(r101);
    }

    public static String f(TYPE r100, StackTraceElement[] r101) {
        return f406453a.get(r100).a(r101);
    }
}
