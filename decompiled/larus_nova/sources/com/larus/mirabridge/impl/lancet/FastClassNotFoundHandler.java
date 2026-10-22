package com.larus.mirabridge.impl.lancet;

import java.util.concurrent.ConcurrentHashMap;
import r27.a;

/* JADX INFO: loaded from: classes.dex */
public final class FastClassNotFoundHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Status> f359329a = null;

    public static final enum Status extends Enum<Status> {
        public static final Status STATUS_EXCEPTION = null;
        public static final Status STATUS_NEED_CHECK = null;
        public static final Status STATUS_NOTING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Status[] f359330a = null;

        static {
            Status r100 = new Status("STATUS_NOTING", 0);
            STATUS_NOTING = r100;
            Status r101 = new Status("STATUS_NEED_CHECK", 1);
            STATUS_NEED_CHECK = r101;
            Status r102 = new Status("STATUS_EXCEPTION", 2);
            STATUS_EXCEPTION = r102;
            f359330a = new Status[]{r100, r101, r102};
        }

        public static Status[] values() {
            return (Status[]) f359330a.clone();
        }

        public static Status valueOf(String r100) {
            return (Status) a.a(Status.class, r100);
        }

        public Status(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        f359329a = new ConcurrentHashMap();
    }

    public static void a(String r100) {
        f359329a.put(r100, Status.STATUS_NOTING);
    }

    public static void b(String r100) {
        f359329a.put(r100, Status.STATUS_EXCEPTION);
    }
}
