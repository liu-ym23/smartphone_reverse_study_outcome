package com.larus.voicecall.impl.ui;

import android.content.Context;
import com.larus.common.apphost.AppHost;
import com.larus.im.FlowRuntime;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes32.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f379396a = 0;

    static {
    }

    public static Integer b(int r100, boolean r101) {
        int r102 = com.larus.voicecall.impl.notification.a.f378399a;
        boolean r103 = com.larus.voicecall.impl.notification.a.c(AppHost.f326268a.getApplication());
        if (r100 != 1) goto L5;
    L35:
        if (r103 == false) goto L37;
        int r104 = R.drawable.larus_ic_rtc_connecting_dark;
    L39:
        return Integer.valueOf(r104);
    L37:
        r104 = R.drawable.larus_ic_rtc_connecting_light;
        goto L39
    L5:
        if (r100 != 2) goto L7;
    L27:
        if (r101 == false) goto L31;
        if (r103 == false) goto L30;
        int r105 = R.drawable.larus_ic_rtc_mic_muted_dark;
    L43:
        return Integer.valueOf(r105);
    L30:
        r105 = R.drawable.larus_ic_rtc_mic_muted_light;
        goto L43
    L31:
        if (r103 == false) goto L33;
        r105 = R.drawable.larus_ic_rtc_mic_dark;
        goto L43
    L33:
        r105 = R.drawable.larus_ic_rtc_mic_light;
        goto L43
    L7:
        if (r100 == 3) goto L27;
        if (r100 != 4) goto L11;
        if (r103 == false) goto L25;
        int r106 = R.drawable.larus_ic_rtc_thinking_dark;
    L42:
        return Integer.valueOf(r106);
    L25:
        r106 = R.drawable.larus_ic_rtc_thinking_light;
        goto L42
    L11:
        if (r100 != 5) goto L13;
    L19:
        if (r103 == false) goto L21;
        int r107 = R.drawable.larus_ic_rtc_answering_dark;
    L41:
        return Integer.valueOf(r107);
    L21:
        r107 = R.drawable.larus_ic_rtc_answering_light;
        goto L41
    L13:
        if (r100 == 7) goto L35;
        if (r100 == 9) goto L19;
        if (r100 == 18) goto L19;
        return null;
    }

    public static String a(Context r100, int r101, boolean r102) {
        if (r101 == 1) goto L38;
        int r103 = R.string.larus_muted_notif_bar;
        if (r101 != 2) goto L7;
        if (r100 == null) goto L40;
        if (r102 == true) goto L37;
        r103 = R.string.larus_Realtime_call_start_speaking;
    L37:
        String r104 = r100.getString(r103);
    L41:
        if (r104 != null) goto L44;
        return "";
    L44:
        return r104;
    L40:
        r104 = null;
        goto L41
    L7:
        if (r101 != 3) goto L9;
        if (r100 == null) goto L40;
        if (r102 == true) goto L32;
        r103 = R.string.larus_Realtime_call_Listening;
    L32:
        r104 = r100.getString(r103);
        goto L41
    L9:
        if (r101 != 4) goto L11;
        if (r100 == null) goto L40;
        r104 = r100.getString(R.string.larus_thinking_state);
        goto L41
    L11:
        if (r101 != 5) goto L13;
    L24:
        if (r100 == null) goto L40;
        r104 = r100.getString(R.string.larus_responding_state);
        goto L41
    L13:
        if (r101 != 7) goto L15;
        if (r100 == null) goto L40;
        r104 = r100.getString(R.string.larus_call_on_hold);
        goto L41
    L15:
        if (r101 == 9) goto L24;
        if (r101 == 18) goto L19;
        r104 = "";
        goto L41
    L19:
        FlowRuntime.a().isOversea();
        if (r100 == null) goto L40;
        r104 = r100.getString(R.string.larus_call_desc_callEnding_cn);
        goto L41
    L38:
        if (r100 == null) goto L40;
        r104 = r100.getString(R.string.larus_Realtime_call_connnecting);
        goto L41
    }
}
