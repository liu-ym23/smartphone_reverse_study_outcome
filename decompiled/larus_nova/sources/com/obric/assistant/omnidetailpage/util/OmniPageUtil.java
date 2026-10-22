package com.obric.assistant.omnidetailpage.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.larus.nova.R;
import com.larus.utils.j0;
import com.obric.assistant.obric_action.IObricActionService;
import com.obric.assistant.obric_action.c;
import com.ss.android.lark.utils.statistics.PerfLog;
import ifa.f;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class OmniPageUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Pair<Drawable, String>> f390862a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, List<f>> f390863b = null;

    static {
        f390862a = new ConcurrentHashMap();
        f390863b = Collections.synchronizedMap(new OmniPageUtil$detailContentCache$1());
    }

    public static void a(Context r100, String r101, String r102, Map r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "fullUrl");
        Intrinsics.checkNotNullParameter(r103, "params");
        IObricActionService r104 = c.a();
        com.obric.assistant.card.utils.f.f386553a.getClass();
        r104.d(r100, com.obric.assistant.card.utils.f.b(r101, r103), c.a().c("omni_detail", r102));
    }

    public static Pair b(String r100, PackageManager r101, Context r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "packageName");
        Intrinsics.checkNotNullParameter(r101, "pm");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r103 == false) goto L5;
        String r104 = r100.concat("_blue");
    L6:
        Pair<Drawable, String> r105 = f390862a.get(r104);
        if (r105 == null) goto L10;
        return r105;
    L10:
        switch(r100.hashCode()) {
            case -599445191: goto L37;
            case -266166185: goto L29;
            case -172590263: goto L21;
            case 1909301541: goto L13;
            default: goto L41;
        };
    L13:
        if (r100.equals("askUserBegin") == false) goto L41;
        if (r103 == false) goto L18;
        int r106 = R.drawable.obric_omni_ic_ask_blue;
    L19:
        Drawable r107 = ContextCompat.getDrawable(r102, r106);
        int r108 = j0.f375426a;
        Pair<Drawable, String> r109 = new Pair(r107, j0.d(R.string.obric_omni_detail_gui_ask_user));
    L51:
        if (r109.getFirst() == null) goto L53;
        f390862a.put(r104, r109);
    L53:
        return r109;
    L18:
        r106 = R.drawable.obric_omni_ic_ask;
        goto L19
    L21:
        if (r100.equals("callUser") == false) goto L41;
        if (r103 == false) goto L26;
        int r110 = R.drawable.obric_omni_ic_call_user_blue;
    L27:
        Drawable r111 = ContextCompat.getDrawable(r102, r110);
        int r112 = j0.f375426a;
        r109 = new Pair(r111, j0.d(R.string.obric_omni_detail_gui_call_user));
        goto L51
    L26:
        r110 = R.drawable.obric_omni_ic_call_user;
        goto L27
    L29:
        if (r100.equals("askUserEnd") == false) goto L41;
        if (r103 == false) goto L34;
        int r113 = R.drawable.obric_omni_ic_ask_end_blue;
    L35:
        Drawable r114 = ContextCompat.getDrawable(r102, r113);
        int r115 = j0.f375426a;
        r109 = new Pair(r114, j0.d(R.string.obric_omni_detail_gui_ask_user));
        goto L51
    L34:
        r113 = R.drawable.obric_omni_ic_ask_end;
        goto L35
    L37:
        if (r100.equals(BitableAnalytic.SelectSceneClickType.COMPLETE) == false) goto L41;
        Drawable r116 = ContextCompat.getDrawable(r102, R.drawable.obric_omni_ic_gui_complete);
        int r117 = j0.f375426a;
        r109 = new Pair(r116, j0.d(R.string.obric_omni_detail_gui_complete));
    L41:
        if (r100.length() != 0) goto L43;
        boolean r118 = true;
    L44:
        if (r118 == false) goto L54;
        Pair<Drawable, String> r119 = new Pair(null, r100);
    L46:
        r109 = r119;
        goto L51
    L54:
        String r120 = r101.getApplicationLabel(r101.getApplicationInfo(r100, 0)).toString();     // Catch: Exception -> L49
        r119 = new Pair(r101.getApplicationIcon(r100), r120);     // Catch: Exception -> L49
    L49:
        Drawable r121 = ContextCompat.getDrawable(r102, R.drawable.obric_omni_ic_no_app);
        int r122 = j0.f375426a;
        r109 = new Pair(r121, j0.d(R.string.obric_omni_detail_app_deleted));
        goto L51
    L43:
        r118 = false;
        goto L44
    L5:
        r104 = r100;
        goto L6
    }
}
