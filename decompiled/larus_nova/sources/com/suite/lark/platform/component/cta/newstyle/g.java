package com.suite.lark.platform.component.cta.newstyle;

import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.internal.Intrinsics;
import z5c.e4;
import z5c.j3;
import z5c.p2;
import z5c.p3;
import z5c.v1;
import z5c.w0;
import z5c.x0;
import z5c.y0;

/* JADX INFO: loaded from: classes36.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f460566a = 0;

    static {
    }

    public static void a(String r100, String r101, String r102, boolean r103, boolean r104, String r105, String r106, s5c.a r107) {
        Intrinsics.checkNotNullParameter(r100, "functionKey");
        Intrinsics.checkNotNullParameter(r101, "functionScene");
        Intrinsics.checkNotNullParameter(r102, "functionCategory");
        Intrinsics.checkNotNullParameter(r105, "skuKey");
        Intrinsics.checkNotNullParameter(r106, "viewType");
        Intrinsics.checkNotNullParameter(r107, "click");
        s5c.a r108 = p3.f570282c;
        r107.getClass();
        s5c.d r109 = s5c.d.b.b(r107, r108).plus(y0.f570408c.a(r100)).plus(x0.f570400d.a(r101)).plus(w0.f570393c.a(r102)).plus(j3.f570229c.a(r105)).plus(e4.f570195e.a(r106));
        if (r103 == false) goto L5;
        s5c.a r110 = z5c.e.f570186c;
    L6:
        s5c.d r111 = r109.plus(r110);
        if (r104 == false) goto L9;
        s5c.a r112 = v1.f570389d;
    L10:
        Statistics.sendEvent("common_pricing_popup_click", r111.plus(r112).plus(p2.f570281c).toJson());
        return;
    L9:
        r112 = v1.f570388c;
        goto L10
    L5:
        r110 = z5c.e.f570187d;
        goto L6
    }
}
