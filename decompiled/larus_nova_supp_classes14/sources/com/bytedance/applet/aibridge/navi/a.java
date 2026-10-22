package com.bytedance.applet.aibridge.navi;

import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.model.LocationResult;
import com.larus.utils.t0;
import hq9.a3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import rv3.r;
import rv3.s;
import rv3.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements a3 {
    public final /* synthetic */ Function1<sv3.a, Unit> a;
    public final /* synthetic */ AbsOpenNavigationMapIDL.a b;
    public final /* synthetic */ Function1<String, Unit> c;

    public a(r r1, AbsOpenNavigationMapIDL.a r2, s r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a(final LocationResult r9, final Integer r10, final GeoLocationInfo r11) {
        Intrinsics.checkNotNullParameter(r9, "code");
        final Function1<sv3.a, Unit> r4 = this.a;
        final AbsOpenNavigationMapIDL.a r5 = this.b;
        final Function1<String, Unit> r6 = this.c;
        t0.e(new x(r9, r11, r4, r5, r6, r10));
    }
}
