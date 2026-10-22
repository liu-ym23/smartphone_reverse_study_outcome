package xf1;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.core.utils.m2;
import com.bytedance.android.livesdk.chatroom.backroom.LiveBackRoomStackManager;
import com.bytedance.android.livesdk.chatroom.m0;
import com.bytedance.android.livesdkapi.depend.live.StackContext;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class e implements a {
    public e() {
    }

    @Override // xf1.a
    public final boolean a(Bundle r110, Bundle r111, StackContext r112) {
        Intrinsics.checkNotNullParameter(r110, "targetInfo");
        Intrinsics.checkNotNullParameter(r112, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r100 = false;
        boolean r101 = m2.a(Integer.valueOf(r110.getInt(VSConstants.EXTRA_ITEM_TYPE)), new Object[]{Integer.valueOf(VSConstants.VS_EPISODE), Integer.valueOf(VSConstants.VS_FIRST_SHOW), Integer.valueOf(VSConstants.VS_LIVE)});
        String r102 = null;
        if (r111 == null) goto L5;
        Boolean r103 = Boolean.valueOf(m2.a(Integer.valueOf(r111.getInt(VSConstants.EXTRA_ITEM_TYPE)), new Object[]{Integer.valueOf(VSConstants.VS_EPISODE), Integer.valueOf(VSConstants.VS_FIRST_SHOW), Integer.valueOf(VSConstants.VS_LIVE)}));
    L6:
        Bundle r104 = m0.a(r110);
        String r105 = r110.getString("enter_from_merge");
        if (r105 != null) goto L11;
        if (r104 == null) goto L10;
        r105 = r104.getString("enter_from_merge");
        goto L11
    L10:
        r105 = null;
    L11:
        String r113 = r110.getString("enter_method");
        if (r113 != null) goto L16;
        if (r104 == null) goto L15;
        r113 = r104.getString("enter_method");
        goto L16
    L15:
        r113 = null;
    L16:
        if (r111 == null) goto L18;
        Bundle r106 = m0.a(r111);
    L19:
        if (r111 == null) goto L22;
        String r107 = r111.getString("enter_from_merge");
        if (r107 == null) goto L22;
    L25:
        if (r111 == null) goto L30;
        String r114 = r111.getString("enter_method");
        if (r114 == null) goto L30;
        r102 = r114;
    L33:
        if (TextUtils.equals(r107, "vs_player_detail") == true) goto L35;
    L37:
        if (r101 == false) goto L42;
        if (Intrinsics.areEqual(r103, Boolean.TRUE) == false) goto L42;
    L51:
        r100 = true;
    L52:
        if (r100 == false) goto L54;
        Lazy r115 = LiveBackRoomStackManager.f105110a;
        LiveBackRoomStackManager.a(r112.getActivityHashCode()).clear();
    L54:
        return r100;
    L42:
        if (Intrinsics.areEqual(r103, Boolean.TRUE) == true) goto L44;
    L46:
        if (r101 == false) goto L52;
        if (Intrinsics.areEqual(r105, "live_end") == false) goto L52;
        if (Intrinsics.areEqual(r113, "live_cover") == false) goto L52;
    L44:
        if (r112.isPortrait() == true) goto L46;
    L35:
        if (TextUtils.equals(r102, "vs_relevant_live_panel") == false) goto L37;
    L30:
        if (r106 == null) goto L33;
        r102 = r106.getString("enter_method");
    L22:
        if (r106 == null) goto L24;
        r107 = r106.getString("enter_from_merge");
        goto L25
    L24:
        r107 = null;
        goto L25
    L18:
        r106 = null;
        goto L19
    L5:
        r103 = null;
        goto L6
    }
}
