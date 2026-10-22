package i40;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.livesdk.utils.t6;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class f extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f488137d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f488138e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f488139f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f488140g;

    @Override // i40.a, i40.e
    public final d b(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }

    public f() {
        this.f488137d = -1;
        this.f488139f = Integer.MIN_VALUE;
    }

    public static int[] g(ViewGroup r100) {
        int[] r101 = new int[2];
        r100.getLocationInWindow(r101);
        h.a("data : root loc : " + Arrays.toString(r101) + " , root params: " + r100.getHeight() + "   " + r100.getY());
        r101[1] = r101[1] + r100.getHeight();
        if (r100.getChildCount() <= 1) goto L11;
        View r102 = r100.getChildAt(1);
        if (r102 == null) goto L10;
        View r103 = ((ViewGroup) r102).getChildAt(3);
        if (r103 == null) goto L11;
        int[] r104 = new int[2];
        r103.getLocationInWindow(r104);
        int[] r105 = new int[2];
        r103.getLocationOnScreen(r105);
        h.a("datas: ps " + Arrays.toString(r104) + " pss" + Arrays.toString(r105));
        goto L11
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L11:
        return r101;
    }

    public final float f(Context r100) {
        if (this.f488138e != 0.0f) goto L6;
        this.f488138e = t6.a(r100, 80.0f);
    L6:
        return this.f488138e;
    }

    public final int h(Context r100) {
        if (this.f488137d != (-1)) goto L5;
        this.f488137d = a.e(r100);
    L5:
        h.a("screen height : " + this.f488137d);
        return this.f488137d;
    }

    @Override // i40.a, i40.e
    public final d a(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, RootDescription.ROOT_ELEMENT);
        super.a(r100, r101);
        h.a("after draw ======");
        h.a("on judge screen : sheight: " + h(r101.getContext()) + ", maxY : " + this.f488139f + " , lasty " + this.f488140g + ' ');
        boolean r102 = true;
        int r103 = g(r101)[1];
        StringBuilder r104 = new StringBuilder(" y : ");
        r104.append(r103);
        r104.append(", delta = ");
        r104.append(f(r101.getContext()));
        h.a(r104.toString());
        if (this.f488140g != r103) goto L6;
        h.a("same y return :  " + r103);
        return null;
    L6:
        if (this.f488139f >= r103) goto L8;
        this.f488139f = r103;
    L8:
        int r105 = Math.abs(this.f488139f - r103);
        if (this.f488140g < r103) goto L12;
        r102 = false;
    L12:
        if (r102 == false) goto L18;
        if (r105 >= f(r101.getContext())) goto L16;
        Boolean r106 = Boolean.FALSE;
        h.a("软键盘隐藏 diff " + r105);
    L22:
        h.a("datas : lastheight " + this.f488132c + ", offset " + r105 + ", isvisible " + r106);
        this.f488140g = r103;
        if (r106 != null) goto L25;
        return null;
    L25:
        return new d(r106.booleanValue(), r105);
    L16:
        h.a("软键盘状态错误，正在变大但大于delta值  offset " + r105 + "  ,delta = " + f(r101.getContext()));
    L21:
        r106 = null;
        goto L22
    L18:
        if (r105 <= f(r101.getContext())) goto L20;
        r106 = Boolean.TRUE;
        h.a("软键盘显示 diff " + r105);
        goto L22
    L20:
        h.a("软键盘状态错误，正在变小但依然小于delta值  offset " + r105 + ",delta = " + f(r101.getContext()));
        goto L21
    }

    @Override // i40.a, i40.e
    public final void c(Context r100, ViewGroup r101, int r102, int r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, RootDescription.ROOT_ELEMENT);
        super.c(r100, r101, r102, r103, r104, r105);
        h.a("after layout ====");
        h.a("on judge screen : sheight: " + h(r101.getContext()));
        g(r101);
    }
}
