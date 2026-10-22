package com.ss.android.lark.chat.preview.actions;

import com.ss.android.lark.export.entity.preview.UrlPreviewAction;
import com.ss.android.lark.export.entity.preview.UrlPreviewBody;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import vcb.d;

/* JADX INFO: loaded from: classes35.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final b a(UrlPreviewAction r100, String r101, UrlPreviewBody r102, d r110, Map r111) {
        Intrinsics.checkNotNullParameter(r101, "actionId");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new b(r100, r101, r102, r110, r111);
    }
}
