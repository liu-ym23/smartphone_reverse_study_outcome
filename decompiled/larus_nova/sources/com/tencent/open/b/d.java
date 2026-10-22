package com.tencent.open.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import java.util.Locale;

/* JADX INFO: loaded from: classes31.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f461722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f461723b;

    public static String a() {
        return Locale.getDefault().getLanguage();
    }

    public static String a(Context r100) {
        if (TextUtils.isEmpty(f461722a) == true) goto L7;
        return f461722a;
    L7:
        if (r100 != null) goto L9;
        return "";
    L9:
        f461722a = "";
        WindowManager r101 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        if (r101 == null) goto L13;
        f461722a = r101.getDefaultDisplay().getWidth() + "x" + r101.getDefaultDisplay().getHeight();
    L13:
        return f461722a;
    }
}
