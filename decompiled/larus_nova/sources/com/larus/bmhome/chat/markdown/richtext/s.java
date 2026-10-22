package com.larus.bmhome.chat.markdown.richtext;

import android.net.Uri;
import com.larus.platform.model.SlashMentionConfig;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<Integer> f307240a = null;

    static {
        f307240a = SetsKt.setOf(new Integer[]{1, 2, 3, 5});
    }

    public static String a(String r100, Integer r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "skillName");
        if (StringsKt.isBlank(r100) == false) goto L6;
        return null;
    L6:
        if (r101 == null) goto L12;
        if (r101.intValue() != 4) goto L12;
        String r104 = "path";
    L15:
        if (r104 != null) goto L18;
        return null;
    L18:
        if (Intrinsics.areEqual(r104, "path") == false) goto L20;
        r102 = r103;
    L20:
        if (r102 != null) goto L22;
    L28:
        return null;
    L22:
        if ((!StringsKt.isBlank(r102)) == true) goto L25;
        r102 = null;
    L25:
        if (r102 == null) goto L28;
        return new Uri.Builder().scheme(SlashMentionConfig.SLASH_CONTENT_SKILL).authority(r100).appendQueryParameter("type", String.valueOf(r101)).appendQueryParameter(r104, r102).build().toString();
    L12:
        if (CollectionsKt.contains(f307240a, r101) == false) goto L14;
        r104 = "id";
        goto L15
    L14:
        r104 = null;
        goto L15
    }
}
