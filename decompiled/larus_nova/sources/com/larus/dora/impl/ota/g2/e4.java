package com.larus.dora.impl.ota.g2;

import com.larus.dora.api.device.ota.model.OTAUpdateMeta;
import com.larus.dora.api.device.ota.model.OTAUpdatePackage;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class e4 {
    public static final e49.a a(e5 r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        return new e49.a(new z39.a(CollectionsKt.listOf(new OTAUpdatePackage(Integer.valueOf((int) r110.h().c()), r110.h().d(), r110.g(), Integer.valueOf((int) r110.h().e()), r110.h().getType(), r110.i(), r110.h().f(), r110.b(), Long.valueOf(r110.c()))), new OTAUpdateMeta(r110.e(), r110.f(), r110.d()), r110.l(), r110.k()), r110.j(), false, 4);
    }
}
