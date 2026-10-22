package com.obric.assistant.chat;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f386642a = 0;

    static {
    }

    public static void a(Bundle r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.remove("obric_auto_mention");
        r100.remove("obric_skill_slug");
        r100.remove("obric_skill_display_name");
        r100.remove("obric_skill_cover_url");
        r100.remove("obric_auto_mention_content");
    }

    public static boolean b(Bundle r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r100.getString("obric_auto_mention"), "1") == true) goto L8;
        return false;
    L8:
        String r101 = r100.getString("obric_skill_slug");
        if (r101 != null) goto L11;
    L14:
        boolean r102 = true;
    L15:
        if (r102 == true) goto L26;
        String r103 = r100.getString("obric_skill_display_name");
        if (r103 != null) goto L19;
    L22:
        boolean r104 = true;
    L23:
        if (r104 == true) goto L27;
        return true;
    L27:
        return false;
    L19:
        if (StringsKt.isBlank(r103) == true) goto L22;
        r104 = false;
        goto L23
    L26:
        return false;
    L11:
        if (StringsKt.isBlank(r101) == true) goto L14;
        r102 = false;
        goto L15
    }

    public static boolean c(Bundle r100) {
        boolean r101 = false;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (b(r100) == true) goto L8;
        return false;
    L8:
        String r102 = r100.getString("obric_auto_mention_content");
        if (r102 != null) goto L11;
    L12:
        r101 = true;
    L14:
        return !r101;
    L11:
        if (StringsKt.isBlank(r102) == false) goto L14;
        goto L12
    }
}
