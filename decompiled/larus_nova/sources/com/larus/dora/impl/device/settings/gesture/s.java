package com.larus.dora.impl.device.settings.gesture;

import com.bytedance.dora.annotation.ProductNameType;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<LastSwitchSide> f334491a;

    public s(Integer r100) {
        int r101 = ProductNameType.DORA_G2.f204375id;
        if (r100 != null) goto L6;
    L8:
        List<LastSwitchSide> r102 = CollectionsKt.listOf(new LastSwitchSide[]{LastSwitchSide.LEFT, LastSwitchSide.BUTTON, LastSwitchSide.RIGHT});
    L9:
        this.f334491a = r102;
        return;
    L6:
        if (r100.intValue() != r101) goto L8;
        r102 = CollectionsKt.listOf(new LastSwitchSide[]{LastSwitchSide.BUTTON, LastSwitchSide.RIGHT});
        goto L9
    }

    public final boolean a(LastSwitchSide r100) {
        Intrinsics.checkNotNullParameter(r100, "side");
        return this.f334491a.contains(r100);
    }

    public final LastSwitchSide b(LastSwitchSide r100) {
        Intrinsics.checkNotNullParameter(r100, "side");
        if (a(r100) == false) goto L6;
        return r100;
    L6:
        return LastSwitchSide.BUTTON;
    }
}
