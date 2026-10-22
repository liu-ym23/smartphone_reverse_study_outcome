package com.ss.android.lark.keyboard.event;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.keyboard.event.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class t<T extends m> implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f429317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f429318b;

    @Override // com.ss.android.lark.keyboard.event.c
    public final String getTag() {
        return "Transform: form " + this.f429317a.getTag() + " to " + this.f429318b.getTag();
    }

    public t(T r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.TO);
        this.f429317a = r100;
        this.f429318b = r101;
    }
}
