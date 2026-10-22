package com.larus.dora.impl.file;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile com.larus.dora.impl.file.a f335741a;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f335742a = null;

        static {
            int[] r100 = new int[DoraFileStreamingSinkReason.values().length];
            r100[DoraFileStreamingSinkReason.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[DoraFileStreamingSinkReason.ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r100[DoraFileStreamingSinkReason.INCOMPLETED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[DoraFileStreamingSinkReason.PAUSED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r100[DoraFileStreamingSinkReason.FIRST_FRAME_TIMEOUT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r100[DoraFileStreamingSinkReason.DONE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r100[DoraFileStreamingSinkReason.NO_ENOUGH_SPACE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[DoraFileStreamingSinkReason.MD5_CHECK_FAILED.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            f335742a = r100;
        }
    }

    static {
        f335741a = com.larus.dora.impl.file.a.f335732a;
    }

    public static void b(String r100, Map r101) {
        f335741a.a(r100, r101);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        g49.d.c("DoraMetrics", "report failed for event=" + r100 + ", params=" + r101, th);
    }

    public static void a(DoraFileFetchTask r100, DoraFileStreamingSinkReason r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Intrinsics.checkNotNullParameter(r101, "sinkReason");
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("transport_type", r100.getTransportType());
        r103.put("fetch_from", r100.getFetchFrom());
        r103.put("file_type", r100.getFileType());
        r103.put("file_name", r100.getFileName());
        Long r104 = r100.getFileTotalSize();
        if (r104 == null) goto L5;
        long r105 = r104.longValue();
    L6:
        r103.put("file_size", Long.valueOf(r105 / ((long) 1024)));
        r103.put("duration", Long.valueOf(r102));
        if (r101 != DoraFileStreamingSinkReason.DONE) goto L9;
        int r106 = 1;
    L10:
        r103.put("result", Integer.valueOf(r106));
        switch(a.f335742a[r101.ordinal()]) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L18;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            default: goto L13;
        };
    L14:
        String r107 = "md5CheckFailed";
    L21:
        r103.put("reason", r107);
        b("d_file_fetch", r103);
        return;
    L15:
        r107 = "notEnoughSpace";
        goto L21
    L16:
        r107 = "success";
        goto L21
    L17:
        r107 = "fetchInterrupted";
        goto L21
    L18:
        r107 = "fetchOverRetries";
        goto L21
    L19:
        r107 = "file_write_failed";
        goto L21
    L20:
        r107 = "start";
        goto L21
    L13:
        throw new NoWhenBranchMatchedException();
    L9:
        r106 = 2;
        goto L10
    L5:
        r105 = 0;
        goto L6
    }
}
