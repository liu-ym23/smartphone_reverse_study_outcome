package com.ss.android.lark.keyboard.edittext2.utils;

import android.webkit.URLUtil;
import com.larksuite.framework.utils.n0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f429248a = 0;

    static {
    }

    public static boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "link");
        if (URLUtil.isNetworkUrl(r100) == true) goto L5;
        return false;
    L5:
        String r101 = n0.b(r100);
        if (r101 != null) goto L9;
        return false;
    L9:
        return new Regex("^applink\\..+\\.(com|cn)").matches(r101);
    }
}
