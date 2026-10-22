package com.ss.android.lark.widget.utils;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Pattern;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Pattern f449074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Pattern f449075b;

    static {
    }

    @JvmStatic
    public static final Pattern a(boolean r100) {
        if (r100 == false) goto L7;
        Pattern r101 = f449075b;
        if (r101 != null) goto L6;
        r101 = PatternProtector.compile("(?<![\\d.])((?:(?:\\+86|86)[- ]?)?1[3-9]\\d{9}|(?:\\(0\\d{2,3}\\)|0\\d{2,3})[- ]?\\d{7,8}|(?:400|800)[- ]?\\d{3}[- ]?\\d{4}|1(?:10|19|20|22|2306)|\\+\\d{1,3}[- ]?(?:\\(\\d{1,5}\\)|\\d{1,5})[- ]?\\d{1,4}[- ]?\\d{3,5})(?![\\d.])");
        f449075b = r101;
    L6:
        Intrinsics.checkNotNull(r101);
    L11:
        return r101;
    L7:
        r101 = f449074a;
        if (r101 != null) goto L10;
        r101 = PatternProtector.compile("([\\d|(][(\\d{3})|.|\\-|\\d]{4,}\\d{4,})");
        f449074a = r101;
    L10:
        Intrinsics.checkNotNull(r101);
        goto L11
    }
}
