package qq1;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.view.View;
import android.view.WindowManager;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.VSSettingKeys;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.m;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.q6;
import com.bytedance.android.livesdk.utils.t6;
import com.ss.android.lark.utils.statistics.PerfLog;
import i40.h;
import kotlin.jvm.internal.Intrinsics;
import vr1.e0;

/* JADX INFO: loaded from: classes8.dex */
public final class d extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f534469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f534470d;

    public static final class a {
    }

    static {
    }

    public d() {
    }

    @Override // vr1.e
    public final e0 b(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = View.MeasureSpec.getSize(r101);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r103 = true;
        if (m.a() == false) goto L15;
        Object r104 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        if (r104 == null) goto L56;
        Point r105 = new Point();
        ((WindowManager) r104).getDefaultDisplay().getSize(r105);
        int r106 = r105.y;
        if (r102 > r106) goto L14;
        int r107 = this.f534467a;
        if (r107 != 0) goto L13;
        this.f534467a = r106;
        goto L15
    L13:
        if (r107 == r106) goto L15;
    L14:
        boolean r108 = true;
    L17:
        if (r108 == false) goto L20;
        h.a("on adapter vivo returen");
        return null;
    L20:
        h.a("lastHeight:" + this.f534468b + "  maxHeight:" + this.f534469c + "   height:" + r102);
        if (q6.f156879a.getValue().booleanValue() == false) goto L27;
        if (PadConfigUtils.a() == false) goto L27;
        if (r102 != 0) goto L27;
        return null;
    L27:
        if (this.f534468b != 0) goto L34;
        this.f534468b = r102;
        if (this.f534469c != 0) goto L31;
        d(r102, r100);
    L31:
        h.a("on last height == 0 return");
        return null;
    L34:
        if (r102 <= this.f534469c) goto L37;
        h.a("on height bigger than last screent height return height : " + r102 + " \t lastscreenheight " + this.f534469c);
        d(r102, r100);
    L37:
        if (this.f534468b != r102) goto L40;
        h.a("on last height equals height return height: " + this.f534468b);
        return null;
    L40:
        int r109 = this.f534469c - r102;
        this.f534468b = r102;
        Float r110 = VSSettingKeys.LIVE_KEYBOARD_CHECK_THRESHOLD.getValue();
        h.a("offset:" + r109 + " threshold:" + t6.a(r100, r110.floatValue()));
        float r111 = (float) r109;
        if (r111 <= t6.a(r100, r110.floatValue())) goto L43;
        h.a("软键盘显示 diff:" + r109);
    L53:
        int r112 = Math.abs(r109);
        h.a("datas : lastheight " + this.f534468b + ", offset " + r109 + ", isvisible " + r103);
        return new e0(r103, r112);
    L43:
        Configuration r113 = r100.getResources().getConfiguration();
        if (PadConfigUtils.a() == true) goto L46;
    L52:
        h.a("软键盘隐藏,diff:" + r109);
        r103 = false;
        goto L53
    L46:
        if (VSSettingKeys.JUDGE_KEYBOARD_QWERTY.getValue().booleanValue() == false) goto L52;
        if (r113.keyboard != 2) goto L52;
        if (r111 <= t6.a(r100, 48.0f)) goto L52;
        h.a("软键盘显示，连接外接键盘 diff " + r109);
        goto L53
    L56:
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    L15:
        r108 = false;
        goto L17
    }

    public final void d(int r100, Context r101) {
        if (s1.getContext() != null) goto L5;
    L13:
        int r102 = Math.min(r100, Math.min(s1.w(), s1.y()));
    L14:
        this.f534469c = r102;
        h.a("set max height: " + r100 + ", after set: " + this.f534469c);
        return;
    L5:
        if (s1.getContext().getResources().getConfiguration().orientation != 1) goto L13;
        if (VSSettingKeys.LIVE_KEYBOARD_STATUS_BAR_HEIGHT_ADAPT.getValue().booleanValue() == true) goto L9;
        r102 = Math.max(r100, Math.max(s1.w(), s1.y()));
        goto L14
    L9:
        if (this.f534470d != 0) goto L11;
        this.f534470d = StatusBarUtil.getStatusBarHeight(r101);
    L11:
        r102 = Math.max(r100, Math.max(s1.w() - this.f534470d, s1.y()));
        goto L14
    }
}
