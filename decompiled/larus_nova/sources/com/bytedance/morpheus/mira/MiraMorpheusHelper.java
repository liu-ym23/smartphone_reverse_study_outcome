package com.bytedance.morpheus.mira;

import com.bytedance.mira.Mira;
import m27.b;
import m27.c;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public final class MiraMorpheusHelper {

    /* JADX INFO: loaded from: classes.dex */
    public static final enum DownloadType extends Enum<DownloadType> {
        public static final DownloadType CONCURRENCE = null;
        public static final DownloadType QUEUE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DownloadType[] f265654a = null;

        static {
            DownloadType r100 = new DownloadType("QUEUE", 0);
            QUEUE = r100;
            DownloadType r101 = new DownloadType("CONCURRENCE", 1);
            CONCURRENCE = r101;
            f265654a = new DownloadType[]{r100, r101};
        }

        public static DownloadType[] values() {
            return (DownloadType[]) f265654a.clone();
        }

        public static DownloadType valueOf(String r100) {
            return (DownloadType) a.a(DownloadType.class, r100);
        }

        public DownloadType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static void a() {
        c r100 = c.a();
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (r100.f511675b == false) goto L8;
        monitor-exit(r100);
        return;
    L8:
        Mira.registerPluginEventListener(new b(r100));     // Catch: Throwable -> L11
        r100.f511675b = true;     // Catch: Throwable -> L11
        monitor-exit(r100);
    }
}
