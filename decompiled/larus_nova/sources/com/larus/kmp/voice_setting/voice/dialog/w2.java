package com.larus.kmp.voice_setting.voice.dialog;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class w2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f353217a = 0;

    static {
    }

    public w2() {
    }

    public static String d(String r100) {
        if (r100 != null) goto L4;
        return "empty";
    L4:
        if ((!StringsKt.isBlank(r100)) == true) goto L7;
        r100 = null;
    L7:
        if (r100 != null) goto L10;
        return "empty";
    L10:
        return StringsKt.substringAfterLast$default(r100, '/', null, 2, null);
    }

    public static Map e(Map r100) {
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

    public static void a(String r100, String r101, Map r102) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "legacyWhere");
        Intrinsics.checkNotNullParameter("", "logTraceId");
        Intrinsics.checkNotNullParameter("", "enterMethod");
        Intrinsics.checkNotNullParameter(r102, "params");
        com.larus.kmp.voice_setting.voice.utils.k r103 = com.larus.kmp.voice_setting.voice.utils.m.f355113a.a(r100);
        r103.f355108e = r101;
        r103.f355110g.putAll(e(r102));
        if (StringsKt.isBlank("") == false) goto L5;
        List<String> r104 = CollectionsKt.listOf("VoiceCreate");
    L6:
        r103.f355107d = r104;
        r103.f355109f = "";
        com.larus.kmp.voice_setting.voice.utils.k.a(r103);
        return;
    L5:
        r104 = CollectionsKt.listOf(new String[]{"", "VoiceCreate"});
        goto L6
    }

    public static /* synthetic */ void c(String r100, String r101, Map r102, int r103) {
        String r104 = null;
        if ((r103 & 4) == 0) goto L5;
        String r105 = "";
    L7:
        if ((r103 & 8) == 0) goto L10;
        r104 = "";
    L10:
        if ((r103 & 16) == 0) goto L12;
        r102 = MapsKt.emptyMap();
    L12:
        b(r100, r101, r105, r104, r102);
        return;
    L5:
        r105 = null;
        goto L7
    }

    public static void b(String r100, String r101, String r102, String r103, Map r104) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "legacyWhere");
        Intrinsics.checkNotNullParameter(r102, "logTraceId");
        Intrinsics.checkNotNullParameter(r103, "enterMethod");
        Intrinsics.checkNotNullParameter(r104, "params");
        com.larus.kmp.voice_setting.voice.utils.k r105 = com.larus.kmp.voice_setting.voice.utils.m.f355113a.b(r100);
        r105.f355108e = r101;
        r105.f355110g.putAll(e(r104));
        if (StringsKt.isBlank(r102) == false) goto L5;
        List<String> r106 = CollectionsKt.listOf("VoiceCreate");
    L6:
        r105.f355107d = r106;
        r105.f355109f = r103;
        com.larus.kmp.voice_setting.voice.utils.k.a(r105);
        return;
    L5:
        r106 = CollectionsKt.listOf(new String[]{r102, "VoiceCreate"});
        goto L6
    }
}
