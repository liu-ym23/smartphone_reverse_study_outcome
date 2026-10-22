package com.suite.lark.platform.feature.forward.doubao;

import com.suite.lark.platform.feature.forward.doubao.api.entity.ForwardDoubaoContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f461352a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile ForwardDoubaoContent f461353b;

    static {
        f461352a = new i();
    }

    public i() {
    }

    public final void update(ForwardDoubaoContent r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        f461353b = r100;
    }
}
