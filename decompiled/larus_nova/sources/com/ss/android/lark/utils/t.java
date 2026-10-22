package com.ss.android.lark.utils;

import android.content.Context;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.vivo.libra.CallBack;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes38.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f444778a = null;

    static {
        f444778a = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    }

    public static String a(Context r100, Date r101, Locale r102) {
        if (com.larksuite.framework.utils.e.i(r101) != 0) goto L6;
        String r103 = com.larksuite.framework.utils.f.a(UIUtils.getString(r100, R.string.Lark_Timeformat_24HrTimeFormat), r101.getTime(), null, null);
    L21:
        return r103.replace("AM", UIUtils.getString(r100, R.string.Lark_Timeformat_AM)).replace(CallBack.EVENT_POWER_MODE, UIUtils.getString(r100, R.string.Lark_Timeformat_PM));
    L6:
        if (com.larksuite.framework.utils.e.i(r101) != 1) goto L9;
        r103 = UIUtils.getString(r100, R.string.Lark_Legacy_Yesterday);
        goto L21
    L9:
        if (com.larksuite.framework.utils.e.h(r101) == false) goto L15;
        if (r102 != null) goto L12;
    L14:
        r103 = com.larksuite.framework.utils.e.c(r101, UIUtils.getString(r100, R.string.Lark_Legacy_CommonShortDateFormat));
        goto L21
    L12:
        if (r102.getLanguage().toLowerCase().equals("en") == false) goto L14;
        long r104 = r101.getTime();
        r103 = f444778a[com.larksuite.framework.utils.f.b(r104, 2) - 1] + " " + com.larksuite.framework.utils.f.b(r104, 5);
        goto L21
    L15:
        if (r102 != null) goto L17;
    L19:
        r103 = com.larksuite.framework.utils.e.c(r101, UIUtils.getString(r100, R.string.Lark_Legacy_DateFormatYmdV2));
        goto L21
    L17:
        if (r102.getLanguage().toLowerCase().equals("en") == false) goto L19;
        r103 = com.larksuite.framework.utils.e.c(r101, "yyyy-MM-dd".replace("-", HTTP.URL_DEFAULT));
        goto L21
    }
}
