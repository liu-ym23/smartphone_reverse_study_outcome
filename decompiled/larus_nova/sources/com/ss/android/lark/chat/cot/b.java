package com.ss.android.lark.chat.cot;

import java.util.Locale;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f414788a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Regex f414789b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Regex f414790c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Regex f414791d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Regex f414792e = null;

    static {
        f414788a = SetsKt.setOf(new String[]{"search", "bash", "read", "write", "edit", "doc", "calendar", "task", "vc_meeting", "meeting"});
        RegexOption r100 = RegexOption.IGNORE_CASE;
        f414789b = new Regex("^[a-z0-9][a-z0-9_-]*_(?:outlined|filled|colorful)$", r100);
        f414790c = new Regex("^https://", r100);
        f414791d = new Regex("^data:image/", r100);
        f414792e = new Regex("^(?:[a-z]+:)?img_(?:v\\d+_)?[a-z0-9][a-z0-9_-]*$", r100);
    }

    public static c a(String r110, String r111, String r112, boolean r113) {
        boolean r100 = true;
        if (r110 != null) goto L5;
    L50:
        String r114 = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(new String[]{r112, r111}), " ", null, null, 0, null, null, 62, null);
        if (r114.length() == 0) goto L54;
        r100 = false;
    L54:
        String r115 = null;
        if (r100 == true) goto L81;
        String r116 = r114.toLowerCase(Locale.ROOT);
        String r117 = "search";
        if (StringsKt.contains$default(r116, "search", false, 2, null) == false) goto L60;
    L80:
        r115 = r117;
        goto L81
    L60:
        if (StringsKt.contains$default(r116, "web", false, 2, null) == true) goto L80;
        r117 = "read";
        if (StringsKt.contains$default(r116, "read", false, 2, null) == true) goto L80;
        r117 = "write";
        if (StringsKt.contains$default(r116, "write", false, 2, null) == true) goto L80;
        r117 = "edit";
        if (StringsKt.contains$default(r116, "edit", false, 2, null) == true) goto L80;
        if (StringsKt.contains$default(r116, "run", false, 2, null) == false) goto L74;
    L79:
        r115 = "bash";
        goto L81
    L74:
        if (StringsKt.contains$default(r116, "exec", false, 2, null) == true) goto L79;
        if (StringsKt.contains$default(r116, "bash", false, 2, null) == true) goto L79;
        if (StringsKt.contains$default(r116, "shell", false, 2, null) == true) goto L79;
    L81:
        if (r115 == null) goto L85;
        return new c.a(r115);
    L85:
        return c.b.f414794a;
    L5:
        if (r110.length() != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L11;
    L30:
        boolean r102 = false;
    L32:
        if (r102 == false) goto L50;
        if (f414792e.matches(r110) == true) goto L86;
        if (r113 == false) goto L46;
        if (f414790c.containsMatchIn(r110) == false) goto L40;
    L43:
        if (r100 == false) goto L46;
        return new c.d(r110);
    L40:
        if (f414791d.containsMatchIn(r110) == true) goto L43;
        r100 = false;
    L46:
        if (f414788a.contains(r110) == false) goto L49;
        return new c.a(r110);
    L49:
        return new c.f(r110);
    L86:
        return new c.C4849c(r110);
    L11:
        if (f414788a.contains(r110) == false) goto L13;
    L16:
        boolean r103 = true;
    L17:
        if (r103 == false) goto L19;
    L31:
        r102 = true;
        goto L32
    L19:
        if (f414792e.matches(r110) == true) goto L31;
        if (r113 == false) goto L30;
        if (f414790c.containsMatchIn(r110) == false) goto L24;
    L27:
        boolean r104 = true;
    L28:
        if (r104 == false) goto L30;
    L24:
        if (f414791d.containsMatchIn(r110) == true) goto L27;
        r104 = false;
        goto L28
    L13:
        if (f414789b.matches(r110) == true) goto L16;
        r103 = false;
        goto L17
    L7:
        r101 = false;
        goto L8
    }
}
