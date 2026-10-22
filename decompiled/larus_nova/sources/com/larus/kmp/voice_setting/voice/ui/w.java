package com.larus.kmp.voice_setting.voice.ui;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f355062a = 0;

    static {
    }

    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "voiceName");
        if (StringsKt.isBlank(r100) == false) goto L6;
        return "试听声音";
    L6:
        return r100 + "，试听声音";
    }

    public static String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "voiceName");
        if ((!StringsKt.isBlank(r100)) == true) goto L6;
        r100 = null;
    L6:
        if (r100 != null) goto L9;
        r100 = "当前声音";
    L9:
        return r100.concat("，移除声音");
    }
}
