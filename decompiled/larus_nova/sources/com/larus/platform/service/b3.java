package com.larus.platform.service;

import com.larus.im.bean.message.Message;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b3 implements com.larus.platform.api.o3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b3 f365719a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365720b = null;

    public b3() {
    }

    static {
        f365719a = new b3();
        f365720b = LazyKt.lazy(new a3());
    }

    public static com.larus.platform.api.o3 e() {
        return (com.larus.platform.api.o3) f365720b.getValue();
    }

    @Override // com.larus.platform.api.o3
    public final boolean a() {
        com.larus.platform.api.o3 r100 = e();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.a() != true) goto L7;
        return true;
    }

    @Override // com.larus.platform.api.o3
    public final int b(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        com.larus.platform.api.o3 r101 = e();
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.b(r100);
    }

    @Override // com.larus.platform.api.o3
    public final int c(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        com.larus.platform.api.o3 r101 = e();
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.c(r100);
    }

    @Override // com.larus.platform.api.o3
    public final String d(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        com.larus.platform.api.o3 r101 = e();
        if (r101 == null) goto L6;
        String r102 = r101.d(r100);
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }
}
