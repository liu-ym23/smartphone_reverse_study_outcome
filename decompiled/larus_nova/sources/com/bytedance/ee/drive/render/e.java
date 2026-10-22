package com.bytedance.ee.drive.render;

import android.text.TextUtils;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.domain.BearUrl;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class e implements bk5.b {

    public static final class a {
    }

    static {
    }

    public e() {
    }

    public final String toString() {
        return "DriveInitNode";
    }

    @Override // bk5.b
    public final boolean b(BearUrl r100, bk5.e r101, bk5.a r102) {
        Intrinsics.checkNotNullParameter(r100, "bearUrl");
        Intrinsics.checkNotNullParameter(r101, "loaderTypeBefore");
        Intrinsics.checkNotNullParameter(r102, KtvSubElement.CONTAINER);
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals(r100.f222560a, sbb.e.f541301l.getType()) == false) goto L7;
        return true;
    }

    @Override // bk5.b
    public final Object a(BearUrl r100, bk5.e r101, bk5.a r102, Continuation<? super bk5.e> r103) {
        return bk5.e.c.f19367b;
    }
}
