package com.bytedance.ee.bear.utils;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class LinkUtils {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;

    static {
        a = LazyKt.lazy(LinkUtils$charPattern$2.INSTANCE);
        b = LazyKt.lazy(LinkUtils$urlSubStringPattern$2.INSTANCE);
        c = LazyKt.lazy(LinkUtils$urlPattern$2.INSTANCE);
    }

    @JvmStatic
    public static final String a(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L10;
        if (r2 == null) goto L6;
        boolean r0 = PatternProtector.compile("(https?|ftp)://|(data|mailto):").matcher(r2).find();
    L7:
        if (r0 == false) goto L9;
        return r2;
    L9:
        return "http://" + r2;
    L6:
        r0 = false;
        goto L7
    L10:
        return r2;
    }
}
