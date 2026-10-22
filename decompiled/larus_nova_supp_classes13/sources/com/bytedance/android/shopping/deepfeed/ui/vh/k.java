package com.bytedance.android.shopping.deepfeed.ui.vh;

import android.graphics.Bitmap;
import android.util.LruCache;
import com.bytedance.android.ec.model.ECUrlModel;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k implements Runnable {
    public final /* synthetic */ DeepFeedProductBannerImageVH a;
    public final /* synthetic */ ECUrlModel b;
    public final /* synthetic */ int c;

    public k(DeepFeedProductBannerImageVH r1, ECUrlModel r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        LruCache<String, Bitmap> r0 = l.a;
        ECUrlModel r1 = this.b;
        int r2 = this.c;
        Bitmap r3 = this.a.V3();
        if (r2 != 0) goto L25;
        if (r3 == null) goto L26;
        if (r1 == null) goto L10;
        List r4 = r1.getUrlList();
        if (r4 == null) goto L10;
        String r5 = (String) CollectionsKt.firstOrNull(r4);
    L12:
        if (r5 != null) goto L14;
    L17:
        boolean r6 = true;
    L18:
        if (r6 == true) goto L27;
        Bitmap.Config r7 = r3.getConfig();
        if (r7 != null) goto L23;
        r7 = Bitmap.Config.ARGB_8888;
    L23:
        l.c.put(r5, r3.copy(r7, false));
        return;
    L27:
        return;
    L14:
        if (r5.length() == 0) goto L17;
        r6 = false;
    L10:
        r5 = null;
        goto L12
    L26:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
