package com.larus.bot.impl.feature.edit.feature.bgimage.preview;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f319024a = 0;

    static {
    }

    @JvmStatic
    public static final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "stageName");
        com.larus.ugc.perf.impl.c.f375100a.getClass();
        if (com.larus.ugc.perf.impl.c.b("bot_edit_preview_page") != null) goto L5;
        return;
    L5:
        com.larus.ugc.perf.impl.g r101 = com.larus.ugc.perf.impl.c.b("bot_edit_preview_page".concat(r100));
        if (r101 == null) goto L16;
        com.larus.ugc.perf.impl.c.e("bot_edit_preview_page".concat(r100));
        long r102 = r101.a();
        if (0 <= r102) goto L10;
    L12:
        boolean r103 = false;
    L13:
        if (r103 == false) goto L17;
        com.larus.ugc.perf.impl.c.f(r101.f375111a + '_' + r100, r101.c());
        return;
    L17:
        return;
    L10:
        if (r102 >= 120001) goto L12;
        r103 = true;
        goto L13
    }

    @JvmStatic
    public static final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "stageName");
        com.larus.ugc.perf.impl.c.f375100a.getClass();
        if (com.larus.ugc.perf.impl.c.b("bot_edit_preview_page") != null) goto L5;
        return;
    L5:
        com.larus.ugc.perf.impl.g r101 = new com.larus.ugc.perf.impl.g("perf_bot_edit_preview_page_launch");
        com.larus.ugc.perf.impl.c.d("bot_edit_preview_page".concat(r100), r101);
    }

    @JvmStatic
    public static final void b(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "stageName");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        com.larus.ugc.perf.impl.c.f375100a.getClass();
        if (com.larus.ugc.perf.impl.c.b("bot_edit_preview_page") != null) goto L5;
        return;
    L5:
        com.larus.ugc.perf.impl.g r103 = com.larus.ugc.perf.impl.c.b("bot_edit_preview_page".concat(r100));
        if (r103 == null) goto L9;
        r103.d(r101, r102);
        return;
    }
}
