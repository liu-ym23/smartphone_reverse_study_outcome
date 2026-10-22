package com.larus.business.markdown.impl.markwon;

import android.content.Context;
import com.larus.business.markdown.impl.common.MarkdownConfigManager;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import lsc.q;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q<Integer> f320693a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q<CharSequence> f320694b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q<Map<?, ?>> f320695c = null;

    static {
        f320693a = new q("max_content_width");
        f320694b = new q("md-reuse-char-sequence");
        f320695c = new q("md-payload");
    }

    public static final MarkwonStruct a(Context r100, MarkdownConfigManager r101, Integer r110, lw8.d r111, Map<String, ? extends Object> r112) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "markdownConfigManager");
        Intrinsics.checkNotNullParameter(r111, "customMarkDownInfo");
        return new MarkwonStruct(r100, r101, false, r111, r110, r112);
    }

    public static final MarkwonStruct b(Context r100, MarkdownConfigManager r101, Integer r110, lw8.d r111, Map<String, ? extends Object> r112) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "markdownConfigManager");
        Intrinsics.checkNotNullParameter(r111, "customMarkDownInfo");
        return new MarkwonStruct(r100, r101, true, r111, r110, r112);
    }
}
