package com.larksuite.component.card.utils;

import android.content.Context;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f283980a = 0;

    static {
    }

    public static int a(String r100, Context r101) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = 0;
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        return 0;
    L12:
        if (StringsKt.endsWith$default(r100, "colorful", false, 2, null) == false) goto L75;
        int r104 = edb.d.f472255a;
        if (r100 != null) goto L16;
    L74:
        String r105 = r100;
        if (r102 == 0) goto L97;
        return r102;
    L97:
        return r101.getResources().getIdentifier("ud_icon_" + StringsKt.replace$default(r105, "-", "_", false, 4, null), "drawable", r101.getPackageName());
    L16:
        switch(r100.hashCode()) {
            case -1866560241: goto L71;
            case -1693849154: goto L67;
            case -1385021371: goto L63;
            case -593312209: goto L59;
            case -532962475: goto L55;
            case -23381368: goto L51;
            case -17791761: goto L47;
            case 33345732: goto L43;
            case 320841946: goto L39;
            case 1073675035: goto L35;
            case 1210408388: goto L31;
            case 1441268064: goto L27;
            case 1585297171: goto L23;
            case 1966089654: goto L19;
            default: goto L74;
        };
    L19:
        if (r100.equals("approval_colorful") == false) goto L74;
        r102 = R.drawable.ud_icon_approval_colorful;
        goto L74
    L23:
        if (r100.equals("todo_colorful") == false) goto L74;
        r102 = R.drawable.ud_icon_todo_colorful;
        goto L74
    L27:
        if (r100.equals("calendar-disable_colorful") == false) goto L74;
        r102 = R.drawable.ud_icon_calendar_disable_colorful;
        goto L74
    L31:
        if (r100.equals("file-form_colorful") == false) goto L74;
        r102 = kac.a.b(R.drawable.ud_icon_file_form_colorful);
        goto L74
    L35:
        if (r100.equals("calendar_colorful") == false) goto L74;
        r102 = R.drawable.ud_icon_calendar_colorful;
        goto L74
    L39:
        if (r100.equals("hirelogo_colorful") == false) goto L74;
        r102 = R.drawable.ud_icon_hirelogo_colorful;
        goto L74
    L43:
        if (r100.equals("meego_colorful") == false) goto L74;
        r102 = R.drawable.ud_icon_meego_colorful;
        goto L74
    L47:
        if (r100.equals("vote_colorful") == false) goto L74;
        r102 = R.drawable.ud_icon_vote_colorful;
        goto L74
    L51:
        if (r100.equals("file-lark-minutes_colorful") == false) goto L74;
        r102 = kac.a.b(R.drawable.ud_icon_file_lark_minutes_colorful);
        goto L74
    L55:
        if (r100.equals("apaas_colorful") == false) goto L74;
        r102 = R.drawable.ud_icon_apaas_colorful;
        goto L74
    L59:
        if (r100.equals("lark-logo_colorful") == false) goto L74;
        r102 = R.drawable.ud_icon_lark_logo_colorful;
        goto L74
    L63:
        if (r100.equals("myai_colorful") == false) goto L74;
        r102 = R.drawable.ud_icon_myai_colorful;
        goto L74
    L67:
        if (r100.equals("larkcommunity_colorful") == false) goto L74;
        r102 = R.drawable.ud_icon_larkcommunity_colorful;
        goto L74
    L71:
        if (r100.equals("wiki-bitable_colorful") == false) goto L74;
        r102 = kac.a.b(R.drawable.ud_icon_wiki_bitable_colorful);
        goto L74
    L75:
        int r106 = r100.hashCode();
        if (r106 == (-1063346260)) goto L91;
        if (r106 == (-804307457)) goto L87;
        if (r106 == 17629049) goto L83;
    L94:
        r102 = edb.a.a(r100);
        goto L74
    L83:
        if (r100.equals("error_filled") == false) goto L94;
        r100 = "close_filled";
        goto L94
    L87:
        if (r100.equals("succeed_filled") == false) goto L94;
        r100 = "yes_filled";
        goto L94
    L91:
        if (r100.equals("icon_video_filled") == false) goto L94;
        r100 = "video_filled";
        goto L94
    L5:
        if (r100.length() == 0) goto L8;
        r103 = false;
        goto L9
    }
}
