package com.bytedance.salamander.anniex;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class x0 extends i {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public y0 f268499k;

    public x0(String r110, String r111, String r112, String r113, Map r114, y0 r115, i0 r116, t0 r117) {
        g0 r100 = new g0();
        Intrinsics.checkNotNullParameter(r110, "schema");
        Intrinsics.checkNotNullParameter(r111, "sessionId");
        Intrinsics.checkNotNullParameter(r112, "containerId");
        Intrinsics.checkNotNullParameter(r113, "bid");
        Intrinsics.checkNotNullParameter(r114, "globalProps");
        Intrinsics.checkNotNullParameter(r115, "popupSchema");
        Intrinsics.checkNotNullParameter(r116, "navBarModel");
        Intrinsics.checkNotNullParameter(r117, "platformContext");
        Intrinsics.checkNotNullParameter(r100, "lynxProps");
        super(r110, r111, r112, r113, r114, r115, r116, r117, r100);
        Intrinsics.checkNotNullParameter(r115, "<set-?>");
        this.f268499k = r115;
    }
}
