package com.bytedance.salamander.ability;

import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.lynx.tasm.LynxView;
import kotlin.jvm.internal.Intrinsics;
import me7.c;
import ue7.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends c {
    public final LynxView e;
    public final d f;
    public final PlatformType g;

    public final d getJsEventDelegate() {
        return this.f;
    }

    public final PlatformType getPlatformType() {
        return this.g;
    }

    public a(String r2, AnnieXLynxView r3, RtsBridge r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "containerID");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "jsEventDelegate");
        Intrinsics.checkNotNullParameter(r5, "namespace");
        super(r2, r3, r5);
        this.e = r3;
        this.f = r4;
        this.g = PlatformType.LYNX;
    }
}
