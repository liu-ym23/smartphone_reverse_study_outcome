package com.ss.android.lark.chameleon.util;

import android.content.Context;
import android.text.TextUtils;
import com.samskivert.mustache.e;
import com.samskivert.mustache.h;
import com.ss.android.lark.chameleon.idependency.Log;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public class UIHelper {
    private static final String TAG = "UIHelper";
    private static Map<String, h> mTmplCache;

    public UIHelper() {
    }

    static {
        mTmplCache = new HashMap();
    }

    private static h getTmpl(String r100) {
        h r101 = mTmplCache.get(r100);
        if (r101 != null) goto L6;
        h r102 = e.a().b().a(r100);
        mTmplCache.put(r100, r102);
        return r102;
    L6:
        return r101;
    }

    public static String mustacheFormat(Context r100, int r101, Map<String, String> r102) {
        String r103 = r100.getString(r101);
        if (TextUtils.isEmpty(r103) == true) goto L12;
        if (r102 == null) goto L12;
        if (r102.isEmpty() == true) goto L12;
        return getTmpl(r103).b(r102);
    L10:
        e = move-exception;
        Log.e(TAG, e.getMessage());
    L12:
        return r103;
    }

    public static String mustacheFormatEscapeHtml(Context r100, int r101, Map<String, String> r102) {
        String r103 = r100.getString(r101);
        if (TextUtils.isEmpty(r103) == true) goto L10;
        if (r102 != null) goto L6;
        return r103;
    L6:
        if (r102.isEmpty() == false) goto L9;
        return r103;
    L9:
        return e.a().a(r103).b(r102);
    L10:
        return r103;
    }

    public static String mustacheFormat(Context r100, int r101, String r102, String r103) {
        String r104 = r100.getString(r101);
        if (r102 == null) goto L11;
        if (r103 == null) goto L11;
        HashMap r105 = new HashMap(1);
        r105.put(r102, r103);
        return getTmpl(r104).b(r105);
    L9:
        e = move-exception;
        Log.e(TAG, e.getMessage());
    L11:
        return r104;
    }

    public static String mustacheFormatEscapeHtml(Context r100, int r101, String r102, String r103) {
        String r104 = r100.getString(r101);
        if (r102 == null) goto L8;
        if (r103 == null) goto L9;
        HashMap r105 = new HashMap(1);
        r105.put(r102, r103);
        return e.a().a(r104).b(r105);
    L9:
        return r104;
    L8:
        return r104;
    }
}
