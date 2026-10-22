package io.ktor.http;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes41.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<Character> f491889a = null;

    static {
        f491889a = SetsKt.setOf(new Character[]{'(', ')', Character.valueOf(Typography.less), Character.valueOf(Typography.greater), '@', ',', ';', ':', '\\', Character.valueOf(Typography.quote), '/', '[', ']', '?', Character.valueOf(com.alipay.sdk.m.n.a.f25612h), '{', '}', ' ', '\t', '\n', '\r'});
    }

    public static final boolean a(String r110) {
        if (r110.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L9;
        return true;
    L9:
        if (r110.length() >= 2) goto L12;
    L10:
        boolean r101 = false;
    L30:
        if (r101 == false) goto L32;
        return false;
    L32:
        int r102 = r110.length();
        int r103 = 0;
    L33:
        if (r103 >= r102) goto L38;
        if (f491889a.contains(Character.valueOf(r110.charAt(r103))) == true) goto L36;
        r103 = r103 + 1;
        goto L33
    L36:
        return true;
    L38:
        return false;
    L12:
        if (StringsKt.first(r110) != '\"') goto L10;
        if (StringsKt.last(r110) != '\"') goto L10;
        int r104 = 1;
    L17:
        int r105 = StringsKt.indexOf$default(r110, Typography.quote, r104, false, 4, null);
        if (r105 == StringsKt.getLastIndex(r110)) goto L29;
        int r106 = r105 - 1;
        int r107 = 0;
    L22:
        if (r110.charAt(r106) != '\\') goto L25;
        r107 = r107 + 1;
        r106 = r106 - 1;
        goto L22
    L25:
        if ((r107 % 2) == 0) goto L10;
        r104 = r105 + 1;
        if (r104 < r110.length()) goto L17;
    L29:
        r101 = true;
        goto L30
    L5:
        r100 = false;
        goto L6
    }

    public static final String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        StringBuilder r101 = new StringBuilder("\"");
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L21;
        char r104 = r100.charAt(r103);
        if (r104 != '\\') goto L8;
        r101.append("\\\\");
    L20:
        r103 = r103 + 1;
        goto L3
    L8:
        if (r104 != '\n') goto L11;
        r101.append("\\n");
        goto L20
    L11:
        if (r104 != '\r') goto L14;
        r101.append("\\r");
        goto L20
    L14:
        if (r104 != '\t') goto L17;
        r101.append("\\t");
        goto L20
    L17:
        if (r104 != '\"') goto L19;
        r101.append("\\\"");
        goto L20
    L19:
        r101.append(r104);
        goto L20
    L21:
        r101.append("\"");
        return r101.toString();
    }
}
