package com.larksuite.framework.utils;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.ss.android.lark.log.Log;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes24.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f285989a = null;

    static {
        f285989a = PatternProtector.compile("((sht|doc|dox|bas|app|sld|bmn|fld|nod|box|jsn|img|isv|wik|wia|wib|wic|wid|wie|whb)(cn|us|lg|jp)[A-Za-z0-9]{22})|[A-Z][a-zA-Z0-9]{3}([sdbafnjiw])[a-zA-Z0-9]{4}([oaplmsih])[a-zA-Z0-9]{4}([txspdngvkabce])[a-zA-Z0-9]{4}([culj])[a-zA-Z0-9]{4}([nsgp])[a-zA-Z0-9]{2}");
    }

    public static String a(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L15;
        if (r100 != null) goto L13;
        return null;
    L13:
        return f285989a.matcher(r100).replaceAll("**token** ");
    L8:
        th = move-exception;
        Log.e("EncryptUtils", "EncryptUtils replaceToken throw " + th);
        return "";
    L15:
        return r100;
    }
}
