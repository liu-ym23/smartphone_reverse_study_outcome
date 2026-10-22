package com.bytedance.ee.drive.render;

import android.text.TextUtils;
import com.bytedance.ee.bear.domain.BearUrl;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public final boolean b(BearUrl r2, bk5.e r3, bk5.a r4) {
        Intrinsics.checkNotNullParameter(r2, "bearUrl");
        Intrinsics.checkNotNullParameter(r3, "loaderTypeBefore");
        Intrinsics.checkNotNullParameter(r4, "container");
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals(r2.a, sbb.e.l.getType()) == false) goto L7;
        return true;
    }

    public final Object a(BearUrl r1, bk5.e r2, bk5.a r3, Continuation<? super bk5.e> r4) {
        return bk5.e.c.b;
    }
}
