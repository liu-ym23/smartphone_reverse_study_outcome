package com.ss.android.lark.keyboard.event;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.keyboard.plugin.input.base.InputSupportType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputSupportType f429297a;

    @Override // com.ss.android.lark.keyboard.event.c
    public final String getTag() {
        return c.a.a(this);
    }

    public b(InputSupportType r100) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.INPUT_TYPE);
        this.f429297a = r100;
    }
}
