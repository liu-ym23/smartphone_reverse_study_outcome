package com.bytedance.locallife.poi.newdetail.widget.seekbar;

import android.graphics.Color;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes21.dex */
public final class PoiSeekbarConfigHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f263472a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f263473b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f263474c = 0;

    static {
        f263472a = LazyKt.lazy(PoiSeekbarConfigHolder$defaultInterpolator$2.INSTANCE);
        f263473b = LazyKt.lazy(PoiSeekbarConfigHolder$argbEvaluator$2.INSTANCE);
        f263474c = com.bytedance.locallife.dito.utils.e.b(2);
    }

    public static h b() {
        h r100 = new h();
        b r101 = r100.f263497b;
        if (r101 == null) goto L7;
        r101.f263484a = 51;
    L7:
        if (r101 == null) goto L10;
        r101.f263485b = -1;
    L10:
        i r102 = r100.f263500e;
        if (r102 == null) goto L15;
        r102.f263511e = -1;
    L15:
        if (r102 == null) goto L18;
        r102.f263507a = com.bytedance.locallife.dito.utils.e.b(6);
    L18:
        i r103 = r100.f263500e;
        if (r103 == null) goto L22;
        r103.f263508b = com.bytedance.locallife.dito.utils.e.b(6);
    L22:
        i r104 = r100.f263500e;
        if (r104 == null) goto L26;
        r104.f263509c = com.bytedance.locallife.dito.utils.e.b(3);
    L26:
        f r105 = r100.f263498c;
        if (r105 == null) goto L30;
        r105.f263491b = -1;
    L30:
        r100.f263502g = f263474c + r100.f263496a;
        return r100;
    }

    public static h c() {
        h r100 = new h();
        b r101 = r100.f263497b;
        if (r101 == null) goto L6;
        r101.f263484a = 51;
    L6:
        if (r101 == null) goto L9;
        r101.f263485b = (int) 4291282888L;
    L9:
        if (r101 == null) goto L12;
        r101.f263486c = true;
    L12:
        i r102 = r100.f263500e;
        if (r102 == null) goto L16;
        r102.f263511e = -1;
    L16:
        if (r102 == null) goto L19;
        r102.f263507a = com.bytedance.locallife.dito.utils.e.b(8);
    L19:
        i r103 = r100.f263500e;
        if (r103 == null) goto L23;
        r103.f263508b = com.bytedance.locallife.dito.utils.e.b(16);
    L23:
        i r104 = r100.f263500e;
        if (r104 == null) goto L27;
        r104.f263509c = com.bytedance.locallife.dito.utils.e.b(4);
    L27:
        f r105 = r100.f263498c;
        if (r105 == null) goto L31;
        r105.f263490a = 204;
    L31:
        if (r105 == null) goto L34;
        r105.f263491b = -1;
    L34:
        r100.f263502g = f263474c + com.bytedance.locallife.dito.utils.e.b(10);
        return r100;
    }

    public static void a(h r100) {
        b r101 = r100.f263497b;
        if (r101.f263484a >= 0) goto L5;
        r101.f263484a = Color.alpha(r101.f263485b);
    L5:
        f r102 = r100.f263498c;
        if (r102.f263490a >= 0) goto L8;
        r102.f263490a = Color.alpha(r102.f263491b);
    L8:
        g r103 = r100.f263499d;
        if (r103.f263493a >= 0) goto L11;
        r103.f263493a = Color.alpha(r103.f263494b);
    L11:
        i r104 = r100.f263500e;
        if (r104.f263510d >= 0) goto L15;
        r104.f263510d = Color.alpha(r104.f263511e);
        return;
    }
}
