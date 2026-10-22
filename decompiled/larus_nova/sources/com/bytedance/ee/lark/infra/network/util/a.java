package com.bytedance.ee.lark.infra.network.util;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f242810a = null;

    /* JADX INFO: renamed from: com.bytedance.ee.lark.infra.network.util.a$a, reason: collision with other inner class name */
    public static final class C3479a {
        @JvmStatic
        public static String a(String r100) {
            if (r100 == null) goto L22;
            int r101 = r100.length();
            if (3 <= r101) goto L6;
        L8:
            boolean r102 = false;
        L10:
            if (r102 == true) goto L12;
            if (r101 != 2) goto L16;
            return "**";
        L16:
            if (r101 != 1) goto L19;
            return "*";
        L19:
            if (r101 > 99) goto L21;
            return "";
        L21:
            return "first char is " + StringsKt.first(r100) + ", count is " + r101;
        L12:
            return StringsKt.first(r100) + StringsKt.repeat("*", r101 - 2) + StringsKt.last(r100);
        L6:
            if (r101 >= 100) goto L8;
            r102 = true;
            goto L10
        L22:
            return "";
        }
    }

    static {
        f242810a = SetsKt.setOf(new String[]{"domain", "expires", HTTP.MAX_AGE, "samesite"});
    }
}
