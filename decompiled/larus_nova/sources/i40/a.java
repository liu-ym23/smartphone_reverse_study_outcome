package i40;

import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.live.core.utils.f1;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.utils.t6;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f488130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f488131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f488132c;

    public a() {
    }

    public static int e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r101 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        if (r101 == null) goto L7;
        Point r102 = new Point();
        ((WindowManager) r101).getDefaultDisplay().getSize(r102);
        return r102.y;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    @Override // i40.e
    public d a(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, RootDescription.ROOT_ELEMENT);
        return null;
    }

    @Override // i40.e
    public d b(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = View.MeasureSpec.getSize(r101);
        if (d(r100, r102) == false) goto L6;
        h.a("on adapter vivo returen");
        return null;
    L6:
        int r103 = this.f488132c;
        if (r103 != 0) goto L10;
        this.f488132c = r102;
        this.f488130a = r102;
        h.a("on last height == 0 return");
        return null;
    L10:
        int r104 = this.f488130a;
        if (r102 <= r104) goto L14;
        h.a("on height bigger than last screent height return height : " + r102 + " \t lastscreenheight " + this.f488130a);
        this.f488132c = r102;
        this.f488130a = r102;
        return null;
    L14:
        if (r103 != r102) goto L17;
        h.a("on last height equals height return height: " + this.f488132c);
        return null;
    L17:
        int r105 = r104 - r102;
        this.f488132c = r102;
        if (r105 <= t6.a(r100, 80.0f)) goto L20;
        h.a("软键盘显示 diff " + r105);
        boolean r106 = true;
    L21:
        int r107 = Math.abs(r105);
        h.a("datas : lastheight " + this.f488132c + ", offset " + r105 + ", isvisible " + r106);
        return new d(r106, r107);
    L20:
        h.a("软键盘隐藏 diff " + r105);
        r106 = false;
        goto L21
    }

    public final boolean d(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r102 = false;
        if (f1.a().booleanValue() == true) goto L5;
        return false;
    L5:
        int r103 = e(r100);
        if (r101 > r103) goto L15;
        int r104 = this.f488131b;
        if (r104 != 0) goto L11;
        this.f488131b = r103;
    L14:
        return r102;
    L11:
        if (r104 == r103) goto L14;
        r102 = true;
        goto L14
    L15:
        return true;
    }

    @Override // i40.e
    public void c(Context r100, ViewGroup r101, int r102, int r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, RootDescription.ROOT_ELEMENT);
    }
}
