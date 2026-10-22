package kw1;

import am2.j;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livesdk.chatroom.m0;
import com.bytedance.android.livesdk.feed.context.LiveFeedContext;
import com.bytedance.android.livesdk.log.filter.g;
import com.bytedance.android.livesdk.log.filter.j0;
import com.bytedance.android.livesdkapi.app.AppConstants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f506382a = 0;

    static {
    }

    public static String a(Intent r100) {
        Bundle r101 = r100.getExtras();
        if (r101 == null) goto L10;
        Bundle r102 = r101.getBundle("live_play_params");
        if (r102 == null) goto L10;
        Bundle r103 = m0.a(r102);
        if (r103 == null) goto L10;
        return r103.getString(AppConstants.BUNDLE_GD_LABEL, "");
    L10:
        return "";
    }

    public static void b(Context r100, Bundle r101) {
        if ((r100 instanceof Activity) == false) goto L15;
        if (r101 == null) goto L16;
        Intent r102 = ((Activity) r100).getIntent();
        if (r102 != null) goto L8;
        return;
    L8:
        String r103 = r102.getStringExtra(AppConstants.BUNDLE_GD_LABEL);
        if (TextUtils.isEmpty(r103) == false) goto L12;
        r103 = a(r102);
    L12:
        if (TextUtils.isEmpty(r103) == true) goto L17;
        r101.putString(AppConstants.BUNDLE_GD_LABEL, r103);
        return;
    L17:
        return;
    L16:
        return;
    }

    public static void c(Map r100, Context r101) {
        if ((r101 instanceof Activity) == false) goto L14;
        Intent r102 = ((Activity) r101).getIntent();
        if (r102 != null) goto L7;
        return;
    L7:
        String r103 = r102.getStringExtra(AppConstants.BUNDLE_GD_LABEL);
        if (TextUtils.isEmpty(r103) == false) goto L11;
        r103 = a(r102);
    L11:
        if (TextUtils.isEmpty(r103) == true) goto L15;
        ((HashMap) r100).put(AppConstants.BUNDLE_GD_LABEL, r103);
        return;
    L15:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void d(String r100, Map r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L9:
        if (r101 != null) goto L11;
        r101 = new HashMap();
    L11:
        r101.put("sdk_version", String.valueOf(com.bytedance.android.livesdk.paas.c.b()));
        r101.put(com.bytedance.android.ec.core.event.a.KEY_PARAM_LIVE_PLATFROM, "live");
        j.a().getClass();
        String r102 = "1";
        if (j.f4288d == false) goto L14;
        Object r103 = "1";
    L15:
        r101.put("is_first_start", r103);
        j.a r104 = j.a().f4290a;
        if (r104 != null) goto L18;
        String r105 = "";
    L19:
        r101.put("definition", r105);
        j.b r106 = j.a().f4292c;
        int r107 = -1;
        if (r106 != null) goto L22;
        int r108 = -1;
    L23:
        r101.put("downstream_throughput_kbps", String.valueOf(r108));
        j.c r109 = j.a().f4291b;
        if (r109 == null) goto L27;
        r107 = r109.getNetQuality();
    L27:
        r101.put("net_quality", String.valueOf(r107));
        r101.put("fold_state", FoldScreenUtils.a() + "");
        if (FoldScreenUtils.f() == true) goto L31;
        r102 = "0";
    L31:
        r101.put("is_fold", r102);
        g.f153296b.L9(r100, r101);
        j0.f153300a.L9(r100, r101);
        LiveFeedContext.hostService().log().logV3(r100, r101);
        return;
    L22:
        r108 = r106.a();
        goto L23
    L18:
        r105 = r104.getDefinition();
        goto L19
    L14:
        r103 = "0";
        goto L15
    L5:
        if (r100.startsWith("livesdk_") == true) goto L9;
        if ("live_enter".equals(r100) == true) goto L9;
        r100 = "livesdk_".concat(r100);
        goto L9
    }
}
