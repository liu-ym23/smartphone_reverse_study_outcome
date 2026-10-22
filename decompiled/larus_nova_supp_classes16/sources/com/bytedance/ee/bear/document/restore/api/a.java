package com.bytedance.ee.bear.document.restore.api;

import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface a {
    public static final C0101a a = null;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.restore.api.a$a, reason: collision with other inner class name */
    public static final class C0101a {
        public static final /* synthetic */ C0101a a = null;

        static {
            a = new C0101a();
        }

        public C0101a() {
        }
    }

    static {
        a = C0101a.a;
    }

    Flowable<Boolean> a();

    Flowable<RestoreFileResult> b();
}
