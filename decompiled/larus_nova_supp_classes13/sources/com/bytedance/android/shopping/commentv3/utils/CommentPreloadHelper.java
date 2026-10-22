package com.bytedance.android.shopping.commentv3.utils;

import android.content.Context;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.elements.ElementTypes;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcGeckoTemplateMgr;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CommentPreloadHelper {
    public static final AtomicBoolean a = null;

    static {
        a = new AtomicBoolean(false);
    }

    public static void a() {
        if (a.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        SliceRender r0 = SliceRender.o;
        CommentPreloadHelper$injectCustomWidget$1 r1 = CommentPreloadHelper$injectCustomWidget$1.INSTANCE;
        r0.getClass();
        ElementTypes.b("ECCommentVideo", r1);
    }

    public static void b(Context r4) {
        if (r4 != null) goto L4;
        r4 = ECAppInfoService.e.getApplicationContext();
    L4:
        if (r4 != null) goto L7;
        dm.a.a("CommentPreloadHelper_v3").i("preloadSliceTemplate, ctx is null");
        return;
    L7:
        SlcGeckoTemplateMgr.f(SlcGeckoTemplateMgr.l, "ec_comment", "ecommerce_comment_slice", wh.a.b(r4), CommentPreloadHelper$preloadSliceTemplate$1.INSTANCE);
    }
}
