package com.bytedance.android.livesdk.log.filter;

import android.app.Activity;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class PadFoldDeviceSendFilter implements v, z81.a {
    public static final Lazy a = null;
    public static final PadFoldDeviceSendFilter b = null;

    public PadFoldDeviceSendFilter() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void Rd() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void onRemove() {
    }

    static {
        b = new PadFoldDeviceSendFilter();
        a = LazyKt.lazy(PadFoldDeviceSendFilter$enable$2.INSTANCE);
    }

    public static String b() {
        Activity r0 = com.bytedance.android.live.core.utils.a.d();
        if (r0 != null) goto L6;
        return "";
    L6:
        if (FoldScreenUtils.a != null) goto L8;
        FoldScreenUtils.a = jc1.k.f(IMiddleWareHostContext.class);
    L8:
        IMiddleWareHostContext r2 = FoldScreenUtils.a;
        if (r2 == null) goto L11;
        int r1 = r2.getFoldStatusV3(r0);
    L12:
        if (r1 != (-1)) goto L15;
        return "";
    L15:
        return String.valueOf(r1);
    L11:
        r1 = -1;
        goto L12
    }

    public static boolean c(String r2) {
        if (((Boolean) a.getValue()).booleanValue() == true) goto L6;
        return false;
    L6:
        switch(r2.hashCode()) {
            case -1122536402: goto L54;
            case -1115849514: goto L51;
            case -1103263308: goto L48;
            case -804282046: goto L45;
            case -597919004: goto L42;
            case -546689387: goto L39;
            case -505186085: goto L36;
            case 479193863: goto L33;
            case 516631638: goto L30;
            case 963627730: goto L27;
            case 1059589542: goto L24;
            case 1499179894: goto L21;
            case 1499265855: goto L18;
            case 1763681274: goto L15;
            case 2022034541: goto L12;
            case 2041791848: goto L9;
            default: goto L57;
        };
    L57:
        return false;
    L9:
        if (r2.equals("livesdk_like") == false) goto L57;
        return true;
    L12:
        if (r2.equals("livesdk_watch_onemin") == false) goto L57;
        return true;
    L15:
        if (r2.equals("livesdk_live_window_duration_v2") == false) goto L57;
        return true;
    L18:
        if (r2.equals("livesdk_live_show") == false) goto L57;
        return true;
    L21:
        if (r2.equals("livesdk_live_play") == false) goto L57;
        return true;
    L24:
        if (r2.equals("livesdk_live_user_report") == false) goto L57;
        return true;
    L27:
        if (r2.equals("livesdk_report_submit") == false) goto L57;
        return true;
    L30:
        if (r2.equals("livesdk_send_gift") == false) goto L57;
        return true;
    L33:
        if (r2.equals("livesdk_rec_live_play") == false) goto L57;
        return true;
    L36:
        if (r2.equals("livesdk_unfollow") == false) goto L57;
        return true;
    L39:
        if (r2.equals("livesdk_live_user_report_submit_success") == false) goto L57;
        return true;
    L42:
        if (r2.equals("livesdk_live_click_user") == false) goto L57;
        return true;
    L45:
        if (r2.equals("livesdk_follow") == false) goto L57;
        return true;
    L48:
        if (r2.equals("livesdk_dislike") == false) goto L57;
        return true;
    L51:
        if (r2.equals("livesdk_live_duration") == false) goto L57;
        return true;
    L54:
        if (r2.equals("livesdk_share") == false) goto L57;
        return true;
    }

    public static String a(int r4, int r5) {
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;     // Catch: Exception -> L4
        return String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Float.valueOf(r4 / r5)}, 1));
    L4:
        return "";
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void L9(String r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r4, "eventName");
        Intrinsics.checkNotNullParameter(r5, "params");
        if (c(r4) == false) goto L12;
        ce1.d r6 = ce1.e.a;
        if (r6 != null) goto L7;
    L9:
        String r7 = BDLocationException.ERROR_TIMEOUT;
    L10:
        r5.put("is_pad_landscape", r7);
        r5.put("fold_position", b());
        int r8 = s1.y();
        int r0 = s1.w();
        StringBuilder r1 = new StringBuilder();
        r1.append(r8);
        r1.append('x');
        r1.append(r0);
        r5.put("app_available_size", r1.toString());
        r5.put("app_aspect_ratio", a(r8, r0));
        return;
    L7:
        if (r6.e() != true) goto L9;
        r7 = "1";
        goto L10
    }
}
