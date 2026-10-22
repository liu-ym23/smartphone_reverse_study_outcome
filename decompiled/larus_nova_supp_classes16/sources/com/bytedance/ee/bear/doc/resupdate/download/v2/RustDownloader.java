package com.bytedance.ee.bear.doc.resupdate.download.v2;

import com.bytedance.ee.bear.drive.sdk.service.f;
import com.bytedance.lark.pb.space.drive.v1.PushDownloadCallback;
import cz4.c;
import dz4.b;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class RustDownloader {
    public final Map<String, c> a;

    public static class RustDownloadException extends Exception {
        public int errorCode;

        public RustDownloadException(int r3) {
            super("rust errorCode: " + r3);
            this.errorCode = r3;
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PushDownloadCallback.Status.values().length];
            a = r0;
            r0[PushDownloadCallback.Status.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            a[PushDownloadCallback.Status.FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            a[PushDownloadCallback.Status.CANCEL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [dz4.b] */
    public RustDownloader() {
        this.a = new ConcurrentHashMap();
        tt5.a.h("DriveDownloader", "initPush");
        ((f) org.koin.java.a.a(f.class)).d0().j(new b(this));
    }
}
