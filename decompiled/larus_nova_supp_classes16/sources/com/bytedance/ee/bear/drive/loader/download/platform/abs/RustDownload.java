package com.bytedance.ee.bear.drive.loader.download.platform.abs;

import android.text.TextUtils;
import com.bytedance.ee.bear.document.comment.bean.ShowCardsJsData;
import io.reactivex.Flowable;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class RustDownload {
    private static final String TAG = "RustDownload";

    public RustDownload() {
    }

    public static /* synthetic */ void a(String r0) {
        lambda$shutdown$1(r0);
    }

    public static /* synthetic */ void b(Throwable r0) {
        lambda$shutdown$2(r0);
    }

    public static /* synthetic */ void c(String[] r0, String r1) {
        lambda$shutdown$0(r0, r1);
    }

    public static boolean downloadSuccess(String r2) {
        if (r2 != null) goto L4;
    L8:
        return false;
    L4:
        if (TextUtils.equals(r2, ShowCardsJsData.ID_GLOBAL) == true) goto L8;
        if (r2.startsWith(ShowCardsJsData.ID_GLOBAL) == true) goto L8;
        return true;
    }

    private static /* synthetic */ void lambda$shutdown$1(String r2) throws Exception {
        tt5.a.h(TAG, "stopDownload, driveCancelDownload result: " + r2);
    }

    private static void lambda$shutdown$2(Throwable r3) throws Exception {
        tt5.a.e(TAG, "stopDownload, driveCancelDownload error: ", r3, false);
    }

    public static void shutdown(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        final String[] r0 = {r2};
        Flowable.just("").subscribeOn(fo5.d.b()).doOnNext(new l(r0)).subscribe(new m(), new n());
    }

    public static void shutdown(Collection<String> r1) {
        Iterator<String> r2 = r1.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        shutdown(r2.next());
        goto L4
    }

    private static /* synthetic */ void lambda$shutdown$0(String[] r0, String r1) throws Exception {
        ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.a(com.bytedance.ee.bear.drive.sdk.service.f.class)).d0().n(r0);
    }
}
