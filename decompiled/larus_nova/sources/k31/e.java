package k31;

import android.content.res.Configuration;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.link.player.DeviceType;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes47.dex */
public final class e implements kc0.p {
    public e() {
    }

    @Override // kc0.p
    public final DeviceType getDeviceType() {
        Configuration r100 = s1.getResources().getConfiguration();
        boolean r101 = s1.F();
        if (PadConfigUtils.c() == false) goto L9;
        if (r101 == false) goto L7;
        return DeviceType.PAD_V;
    L7:
        return DeviceType.PAD_H;
    L9:
        if (FoldScreenUtils.f() == false) goto L21;
        if (FoldScreenUtils.b(s1.getContext(), r100) == 0) goto L13;
        int r102 = RangesKt.coerceAtMost(s1.y(), s1.w());
        int r103 = RangesKt.coerceAtLeast(s1.y(), s1.w());
        if (r103 == 0) goto L21;
        if ((r102 / r103) <= 0.75d) goto L21;
        return DeviceType.FOLD_FULL;
    L13:
        return DeviceType.FOLD_FULL;
    L21:
        return DeviceType.NORMAL_MOBILE;
    }

    @Override // kc0.p
    public final boolean a(boolean r100, boolean r101, boolean r102) {
        if (r102 == false) goto L5;
        int r103 = StatusBarUtil.getDesiredTopSpaceHeight();
    L7:
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == false) goto L23;
        com.bytedance.android.live.revlink.impl.settings.live.a r104 = com.bytedance.android.live.revlink.impl.settings.live.a.f97579j;
        r104.getClass();
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.live.a.f97572c.getValue(r104, com.bytedance.android.live.revlink.impl.settings.live.a.f97570a[1])).booleanValue() == false) goto L15;
        if (r102 == false) goto L15;
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == true) goto L15;
        return false;
    L15:
        if (r101 == false) goto L25;
        if (r100 == false) goto L26;
        if (r103 != 0) goto L22;
        return true;
    L22:
        return false;
    L26:
        return false;
    L25:
        return false;
    L23:
        return false;
    L5:
        r103 = 0;
        goto L7
    }
}
