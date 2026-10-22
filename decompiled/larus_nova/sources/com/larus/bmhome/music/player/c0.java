package com.larus.bmhome.music.player;

import android.text.TextUtils;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class c0 {
    public static final boolean a(String r100, String r101, Boolean r110) {
        if (Intrinsics.areEqual(r110, Boolean.TRUE) == true) goto L5;
        String r102 = null;
        if (r100 == null) goto L13;
        List r103 = StringsKt.split$default(r100, new String[]{"?"}, false, 0, 6, null);
        if (r103 == null) goto L13;
        String r104 = (String) CollectionsKt.firstOrNull(r103);
        if (r104 == null) goto L13;
        String r105 = StringsKt.removePrefix(r104, "\"");
    L14:
        if (r101 == null) goto L21;
        List r106 = StringsKt.split$default(r101, new String[]{"?"}, false, 0, 6, null);
        if (r106 == null) goto L21;
        String r107 = (String) CollectionsKt.firstOrNull(r106);
        if (r107 == null) goto L21;
        r102 = StringsKt.removePrefix(r107, "\"");
    L21:
        return TextUtils.equals(r105, r102);
    L13:
        r105 = null;
        goto L14
    L5:
        return Intrinsics.areEqual(r100, r101);
    }
}
