package com.ss.android.lark.officesdk.chameleon.assembly.doubao.common.deps;

import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class o implements ntb.n {

    public static final class a {
    }

    static {
    }

    public o() {
    }

    @Override // ntb.n
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        Log.d("OfficeSdk-" + r100, r101);
    }

    @Override // ntb.n
    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        Log.i("OfficeSdk-" + r100, r101);
    }

    @Override // ntb.n
    public final void w(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        if (r102 == null) goto L5;
        Log.w("OfficeSdk-" + r100, r101, r102);
        return;
    L5:
        Log.w("OfficeSdk-" + r100, r101);
    }

    @Override // ntb.n
    public final void g(String r100, String r101, Throwable r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        if (r102 == null) goto L5;
        Log.e("OfficeSdk-" + r100, r101, r102, r103);
        return;
    L5:
        Log.e("OfficeSdk-" + r100, r101);
    }
}
