package com.larus.kmp.voice_setting.voice.bridge;

import com.larus.im.FlowRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import ouc.d0;

/* JADX INFO: loaded from: classes30.dex */
public final class v {
    static {
    }

    public static gd9.y a() {
        return FlowRuntime.b().b();
    }

    public static boolean b() {
        FlowRuntime.b().a().isOversea();
        return false;
    }

    public static s d() {
        d0 r100 = a().e("voice_lazy_list_cache_window_config", new d0(MapsKt.emptyMap()), false);
        return new s(w.a(r100, "enabled", true), w.b(r100, "ahead_fraction", 1.0f), w.b(r100, "behind_fraction", 0.5f));
    }

    public static x e() {
        b();
        b();
        b();
        d0 r100 = a().e("flow_voice_setting_convenience_config", new d0(MapsKt.emptyMap()), false);
        return new x(w.a(r100, "flow_voice_setting_expend_by_default", true), w.a(r100, "flow_voice_setting_sample_auto_play", true), w.a(r100, "flow_voice_setting_remember_single_sample", true));
    }

    public static u c(String r110) {
        b();
        b();
        List r100 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r100, "supportMixLanguage");
        d0 r101 = a().e("speaker_voice_edit_config", new d0(MapsKt.emptyMap()), false);
        boolean r102 = w.a(r101, "voice_new_style_enable", true);
        ouc.i r103 = (ouc.i) r101.get("edit_voice_mode");
        if (r103 == null) goto L7;
        Integer r104 = ouc.k.l(ouc.k.o(r103));
        if (r104 == null) goto L7;
        int r105 = r104.intValue();
    L8:
        ouc.i r106 = (ouc.i) r101.get("support_mix_language");
        List r107 = r100;
        if (r106 != null) goto L68;
    L32:
        Intrinsics.checkNotNullParameter(r107, "supportMixLanguage");
        if (r107.isEmpty() == true) goto L46;
        if (r110 != null) goto L36;
    L39:
        boolean r108 = true;
    L40:
        if (r108 == true) goto L46;
        if (r107.contains(r110) == true) goto L46;
        if (r105 != 3) goto L46;
        int r111 = 2;
    L47:
        if (r102 == false) goto L51;
        if (r111 == 2) goto L50;
        if (r111 != 3) goto L51;
    L50:
        boolean r109 = true;
    L53:
        if (r102 == false) goto L57;
        if (r111 == 2) goto L56;
        if (r111 != 1) goto L57;
    L56:
        boolean r112 = true;
    L58:
        if (r102 == false) goto L61;
        if (r111 != 3) goto L61;
        boolean r113 = true;
    L62:
        if (r102 == false) goto L65;
        if (r111 == 0) goto L65;
        boolean r114 = true;
    L67:
        return new u(r102, r112, r109, r113, r111, r114);
    L65:
        r114 = false;
    L61:
        r113 = false;
    L57:
        r112 = false;
    L51:
        r109 = false;
        goto L53
    L36:
        if (r110.length() == 0) goto L39;
        r108 = false;
    L46:
        r111 = r105;
        goto L47
    L68:
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L25
        ouc.b r116 = ouc.k.m(r106);     // Catch: Throwable -> L25
        ArrayList r117 = new ArrayList();     // Catch: Throwable -> L25
        Iterator<ouc.i> r118 = r116.iterator();     // Catch: Throwable -> L25
    L13:
        if (r118.hasNext() == false) goto L23;
        String r119 = ouc.k.o(r118.next()).a();     // Catch: Throwable -> L25
        if (r119.length() <= 0) goto L17;
        boolean r120 = true;
    L18:
        if (r120 == true) goto L21;
        r119 = null;
    L21:
        if (r119 == null) goto L13;
        r117.add(r119);     // Catch: Throwable -> L25
        goto L13
    L17:
        r120 = false;
        goto L18
    L23:
        Object r121 = Result.m9449constructorimpl(r117);     // Catch: Throwable -> L25
    L27:
        Object r122 = r100;
        if (Result.m9455isFailureimpl(r121) == true) goto L31;
        r122 = r121;
    L31:
        r107 = (List) r122;
    L25:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r121 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r105 = 2;
        goto L8
    }
}
