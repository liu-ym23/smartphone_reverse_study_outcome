package com.larus.mirabridge.impl.lancet;

import java.util.concurrent.ConcurrentHashMap;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class FastClassNotFoundHandler {
    public static final ConcurrentHashMap<String, Status> a = null;

    public static final enum Status extends Enum<Status> {
        public static final Status STATUS_EXCEPTION = null;
        public static final Status STATUS_NEED_CHECK = null;
        public static final Status STATUS_NOTING = null;
        public static final /* synthetic */ Status[] a = null;

        static {
            Status r0 = new Status("STATUS_NOTING", 0);
            STATUS_NOTING = r0;
            Status r1 = new Status("STATUS_NEED_CHECK", 1);
            STATUS_NEED_CHECK = r1;
            Status r3 = new Status("STATUS_EXCEPTION", 2);
            STATUS_EXCEPTION = r3;
            a = new Status[]{r0, r1, r3};
        }

        public static Status[] values() {
            return (Status[]) a.clone();
        }

        public static Status valueOf(String r1) {
            return (Status) a.a(Status.class, r1);
        }

        public Status(String r1, int r2) {
            super(r1, r2);
        }
    }

    static {
        a = new ConcurrentHashMap();
    }

    public static void a(String r2) {
        a.put(r2, Status.STATUS_NOTING);
    }

    public static void b(String r2) {
        a.put(r2, Status.STATUS_EXCEPTION);
    }
}
