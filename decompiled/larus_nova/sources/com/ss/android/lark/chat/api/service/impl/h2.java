package com.ss.android.lark.chat.api.service.impl;

import android.util.LruCache;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LruCache<Integer, PreviewHangPoint> f411600a = null;

    static {
        f411600a = new LruCache(100);
    }

    public static int a(PreviewHangPoint r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "point");
        StringBuilder r102 = new StringBuilder();
        r102.append(r100.getPreviewId());
        UrlCardPreviewEntity r103 = r100.getUrlCardPreviewEntity();
        if (r103 == null) goto L7;
        UrlInlinePreviewEntity r104 = r103.getInlineEntity();
        if (r104 == null) goto L7;
        Integer r105 = Integer.valueOf(r104.getVersion());
    L8:
        r102.append(r105);
        r102.append(r101);
        return r102.toString().hashCode();
    L7:
        r105 = null;
        goto L8
    }
}
