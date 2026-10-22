package com.bytedance.ee.bear.utils;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes18.dex */
public final class LinkUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f239809a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f239810b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f239811c = null;

    static {
        f239809a = LazyKt.lazy(LinkUtils$charPattern$2.INSTANCE);
        f239810b = LazyKt.lazy(LinkUtils$urlSubStringPattern$2.INSTANCE);
        f239811c = LazyKt.lazy(LinkUtils$urlPattern$2.INSTANCE);
    }

    @JvmStatic
    public static final String a(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L10;
        if (r100 == null) goto L6;
        boolean r101 = PatternProtector.compile("(https?|ftp)://|(data|mailto):").matcher(r100).find();
    L7:
        if (r101 == false) goto L9;
        return r100;
    L9:
        return "http://" + r100;
    L6:
        r101 = false;
        goto L7
    L10:
        return r100;
    }
}
