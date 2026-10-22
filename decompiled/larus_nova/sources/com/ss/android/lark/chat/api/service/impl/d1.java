package com.ss.android.lark.chat.api.service.impl;

import android.util.ArrayMap;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d1 {
    static {
    }

    @JvmStatic
    public static final UrlCardPreviewEntity a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "previewId");
        Lazy<PreviewCache> r102 = PreviewCache.f411536f;
        Map<String, UrlCardPreviewEntity> r103 = PreviewCache.a.a().c(r100, CollectionsKt.listOf(r101));
        if (r103 != null) goto L7;
        return null;
    L7:
        return (UrlCardPreviewEntity) ((ArrayMap) r103).get(r101);
    }
}
