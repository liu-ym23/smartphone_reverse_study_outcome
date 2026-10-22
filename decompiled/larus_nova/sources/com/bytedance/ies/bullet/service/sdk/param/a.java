package com.bytedance.ies.bullet.service.sdk.param;

import kotlin.jvm.internal.Intrinsics;
import t36.d;
import y36.i;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends i<StatusFontMode> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // t36.c
    public final String a() {
        StatusFontMode r100 = (StatusFontMode) this.f565862b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getValue();
    }

    public a(StatusFontMode r100) {
        super(r100);
    }

    @Override // y36.i
    public final StatusFontMode c(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if ((r100 instanceof Integer) == false) goto L5;
        Integer r101 = (Integer) r100;
    L6:
        if (r101 == null) goto L10;
        String r102 = String.valueOf(r101.intValue());
        Intrinsics.checkNotNullParameter(r102, "string");
        StatusFontMode.Companion.getClass();
        StatusFontMode r103 = StatusFontMode.a.a(r102);
        if (r103 == null) goto L10;
        return r103;
    L10:
        return (StatusFontMode) super.c(r100);
    L5:
        r101 = null;
        goto L6
    }

    @Override // y36.i
    public final StatusFontMode d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "string");
        StatusFontMode.Companion.getClass();
        return StatusFontMode.a.a(r100);
    }

    public a(d r100, String r101, StatusFontMode r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "key");
        super(null);
        b(r100, r101, r102);
    }
}
