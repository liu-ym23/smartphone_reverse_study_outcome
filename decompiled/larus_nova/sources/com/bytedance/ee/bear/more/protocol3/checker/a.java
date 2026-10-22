package com.bytedance.ee.bear.more.protocol3.checker;

import com.bytedance.ee.bear.more.protocol3.j;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f234788e;

    @Override // com.bytedance.ee.bear.more.protocol3.j
    public final boolean e() {
        return true;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.j, com.bytedance.ee.bear.more.protocol3.m
    public final boolean isVisible() {
        oj5.c r100 = d();
        if (r100 == null) goto L7;
        Map<String, Boolean> r101 = r100.K();
        if (r101 == null) goto L7;
        boolean r102 = Intrinsics.areEqual(r101.get(this.f234788e), Boolean.FALSE);
    L9:
        return !r102;
    L7:
        r102 = false;
        goto L9
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f234788e = r100;
    }
}
