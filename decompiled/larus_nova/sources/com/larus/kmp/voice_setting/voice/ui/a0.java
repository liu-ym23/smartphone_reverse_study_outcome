package com.larus.kmp.voice_setting.voice.ui;

import java.util.ArrayList;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f354967a = 0;

    static {
    }

    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "kind");
        return b("voice_setting_dialog_container", r100, null);
    }

    public static String b(String r110, String r111, Integer r112) {
        if (r111 == null) goto L42;
        KProperty<Object>[] r100 = e.f354986a;
        String r113 = r111.toLowerCase(Locale.ROOT);
        ArrayList r101 = new ArrayList(r113.length());
        int r102 = 0;
    L5:
        boolean r114 = true;
        if (r102 >= r113.length()) goto L24;
        char r103 = r113.charAt(r102);
        if ('a' <= r103) goto L10;
    L12:
        boolean r104 = false;
    L13:
        if (r104 == true) goto L23;
        if ('0' <= r103) goto L17;
    L19:
        r114 = false;
    L20:
        if (r114 == true) goto L23;
        r103 = '_';
        goto L23
    L17:
        if (r103 >= ':') goto L19;
    L23:
        r101.add(Character.valueOf(r103));
        r102 = r102 + 1;
        goto L5
    L10:
        if (r103 >= '{') goto L12;
        r104 = true;
        goto L13
    L24:
        String r115 = StringsKt.trim(CollectionsKt.joinToString$default(r101, "", null, null, 0, null, null, 62, null), new char[]{'_'});
        StringBuilder r105 = new StringBuilder(r115.length());
        int r106 = 0;
        boolean r107 = false;
    L26:
        if (r106 >= r115.length()) goto L34;
        char r108 = r115.charAt(r106);
        if (r108 != '_') goto L32;
        if (r107 == true) goto L31;
        r105.append(r108);
    L31:
        r107 = true;
    L33:
        r106 = r106 + 1;
        goto L26
    L32:
        r105.append(r108);
        r107 = false;
        goto L33
    L34:
        String r116 = r105.toString();
        if (r116 == null) goto L42;
        if ((!StringsKt.isBlank(r116)) == true) goto L40;
        r116 = null;
    L40:
        if (r116 == null) goto L42;
    L46:
        return StringsKt.take(r110 + '_' + r116, 96);
    L42:
        if (r112 == null) goto L44;
        r116 = r112.toString();
        goto L46
    L44:
        r116 = "unknown";
        goto L46
    }
}
