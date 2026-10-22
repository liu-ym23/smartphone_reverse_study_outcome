package i40;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livesdk.b6;
import com.bytedance.android.livesdk.c6;
import com.bytedance.android.livesdk.config.q5;
import com.bytedance.android.livesdk.d6;
import com.bytedance.android.livesdk.k5;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.q6;
import com.bytedance.android.livesdk.utils.t6;
import com.ss.android.lark.utils.statistics.PerfLog;
import j40.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class g extends i40.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f488141d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f488142e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final q5 f488143f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f488144g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Boolean f488145h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f488146i;

    public static final class a {
    }

    static {
    }

    public g(boolean r100) {
        this.f488146i = r100;
        this.f488143f = b6.f104235a.getValue();
        this.f488144g = FoldScreenUtils.f();
        this.f488145h = c6.f104415a.getValue();
    }

    @Override // i40.a, i40.e
    public final d b(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        h.c("--onBeforeMeasure start--", this.f488146i);
        int r102 = View.MeasureSpec.getSize(r101);
        if (d(r100, r102) == false) goto L6;
        h.c("--adapter vivo return null--", this.f488146i);
        return null;
    L6:
        h.c("lastHeight:" + this.f488132c + "  maxHeight:" + this.f488141d + "   currentHeight:" + r102 + ',', this.f488146i);
        if (this.f488145h.booleanValue() == false) goto L12;
        if (r102 != 0) goto L12;
        h.c("【one frame return height = 0, intercept it, return null】", this.f488146i);
        return null;
    L12:
        if (q6.f156879a.getValue().booleanValue() == false) goto L18;
        if (PadConfigUtils.a() == false) goto L18;
        if (r102 != 0) goto L18;
        return null;
    L18:
        if (this.f488132c != 0) goto L25;
        this.f488132c = r102;
        if (this.f488141d != 0) goto L22;
        f(r102, r100);
    L22:
        h.c("--last height == 0,return null--", this.f488146i);
        return null;
    L25:
        if (r102 <= this.f488141d) goto L28;
        h.c("on height bigger than last screent height return height : " + r102 + " \t lastscreenheight " + this.f488141d, this.f488146i);
        f(r102, r100);
    L28:
        if (this.f488132c != r102) goto L31;
        h.c("--last height:" + this.f488132c + " equals height, return null--", this.f488146i);
        return null;
    L31:
        int r103 = this.f488141d - r102;
        this.f488132c = r102;
        Float r104 = d6.f121934a.getValue();
        if (this.f488144g == true) goto L34;
    L39:
        h.c("offset(keyboard height):" + r103 + ", threshold:" + t6.a(r100, r104.floatValue()) + ", lastHeight:" + this.f488132c + ", height:" + r102, this.f488146i);
        float r105 = (float) r103;
        if (r105 <= t6.a(r100, r104.floatValue())) goto L42;
        h.c("软键盘显示,高度是:" + r103, this.f488146i);
    L49:
        boolean r106 = true;
    L51:
        int r107 = Math.abs(r103);
        h.c("软键盘显示结果：" + r106, this.f488146i);
        return new d(r106, r107);
    L42:
        Configuration r108 = r100.getResources().getConfiguration();
        if (PadConfigUtils.a() == true) goto L45;
    L50:
        h.c("软键盘隐藏,高度是:" + r103, this.f488146i);
        r106 = false;
        goto L51
    L45:
        if (r108.keyboard != 2) goto L50;
        if (r105 <= t6.a(r100, 48.0f)) goto L50;
        h.c("软键盘显示，连接外接键盘，高度是" + r103, this.f488146i);
        goto L49
    L34:
        if (this.f488143f.enableFoldScreenKeyboardOpt == false) goto L39;
        if (FoldScreenUtils.a() != 0) goto L38;
        r104 = Float.valueOf(this.f488143f.expandStatusThreshold);
        goto L39
    L38:
        r104 = Float.valueOf(this.f488143f.foldStatusThreshold);
        goto L39
    }

    public final void f(int r100, Context r101) {
        if (s1.getContext() != null) goto L5;
    L17:
        int r102 = Math.min(r100, Math.min(s1.w(), s1.y()));
    L18:
        this.f488141d = r102;
        h.c("set max height: " + r100 + ", after set: " + this.f488141d, this.f488146i);
        return;
    L5:
        if (s1.getContext().getResources().getConfiguration().orientation != 1) goto L17;
        if (this.f488142e != 0) goto L10;
        this.f488142e = StatusBarUtil.getStatusBarHeight(r101);
    L10:
        if (FoldScreenUtils.e() == true) goto L12;
    L16:
        r102 = Math.max(r100, Math.max(s1.w() - this.f488142e, s1.y()));
        goto L18
    L12:
        if (n.f497266a.getValue().getEnableInteractivity() == false) goto L16;
        if (k5.f142266a.getValue().booleanValue() == false) goto L16;
        r102 = Math.max(r100, s1.w() - this.f488142e);
        goto L18
    }
}
