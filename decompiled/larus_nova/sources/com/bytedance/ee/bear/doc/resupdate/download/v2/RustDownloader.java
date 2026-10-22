package com.bytedance.ee.bear.doc.resupdate.download.v2;

import com.bytedance.ee.bear.drive.sdk.service.f;
import com.bytedance.lark.pb.space.drive.v1.PushDownloadCallback;
import cz4.c;
import dz4.b;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes16.dex */
public final class RustDownloader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, c> f218005a;

    public static class RustDownloadException extends Exception {
        public int errorCode;

        public RustDownloadException(int r100) {
            super("rust errorCode: " + r100);
            this.errorCode = r100;
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f218006a = null;

        static {
            int[] r100 = new int[PushDownloadCallback.Status.values().length];
            f218006a = r100;
            r100[PushDownloadCallback.Status.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f218006a[PushDownloadCallback.Status.FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f218006a[PushDownloadCallback.Status.CANCEL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [dz4.b] */
    public RustDownloader() {
        this.f218005a = new ConcurrentHashMap();
        tt5.a.h("DriveDownloader", "initPush");
        ((f) org.koin.java.a.a(f.class)).d0().j(new b(this));
    }
}
