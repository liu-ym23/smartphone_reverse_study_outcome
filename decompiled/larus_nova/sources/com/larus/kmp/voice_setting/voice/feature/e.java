package com.larus.kmp.voice_setting.voice.feature;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f353297a = 0;

    static {
    }

    public static Map c(Map r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Map.Entry r103 = (Map.Entry) r102.next();
        String r104 = (String) r103.getKey();
        Object r105 = r103.getValue();
        if (r105 == null) goto L4;
        r101.put(new com.larus.kmp.voice_setting.voice.utils.n(r104), r105);
        goto L4
    L8:
        return r101;
    }

    public static void a(String r100, String r101, y0 r102, Map r103) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "legacyWhere");
        Intrinsics.checkNotNullParameter(r102, "param");
        Intrinsics.checkNotNullParameter(r103, "params");
        com.larus.kmp.voice_setting.voice.utils.k r104 = com.larus.kmp.voice_setting.voice.utils.m.f355113a.b(r100);
        Map<? extends com.larus.kmp.voice_setting.voice.utils.n, ? extends Object> r105 = c(r103);
        r104.f355110g.putAll(r105);
        r104.f355107d = CollectionsKt.listOf("VoiceCreate");
        r104.f355108e = r101;
        r104.f355109f = r102.f353389i;
        com.larus.kmp.voice_setting.voice.utils.k.a(r104);
    }

    public static void b(y0 r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "param");
        Intrinsics.checkNotNullParameter(r101, "result");
        Intrinsics.checkNotNullParameter(r102, "reason");
        Intrinsics.checkNotNullParameter(r103, "reasonDetail");
        int r104 = mh9.v.f514022a;
        ouc.e0 r105 = new ouc.e0();
        ouc.j.c(r105, "is_scheme", mh9.y.a(r100.f353390j));
        ouc.j.c(r105, "enter_method", mh9.w.a(r100.f353389i));
        ouc.j.c(r105, "result", r101);
        if ((!StringsKt.isBlank(r102)) == false) goto L6;
        ouc.j.c(r105, "reason", r102);
    L6:
        if ((!StringsKt.isBlank(r103)) == false) goto L8;
        ouc.j.c(r105, "reason_detail", r103);
    L8:
        ouc.d0 r106 = r105.a();
        Intrinsics.checkNotNullParameter(r106, "params");
        mh9.v.a("voice_settings_clone_end", r106);
    }
}
