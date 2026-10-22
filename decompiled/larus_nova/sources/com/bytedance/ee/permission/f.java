package com.bytedance.ee.permission;

import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f<T, R> f243044a = null;

    static {
        f243044a = new f();
    }

    public f() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        IDocUserPermission r101 = (IDocUserPermission) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101;
    }
}
