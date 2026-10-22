package com.bytedance.ee.bear.middleground.permission;

import android.app.Application;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class PermissionDIModuleKt {
    public static final kwc.a a = null;
    public static og5.a b;

    static {
        a = owc.b.a(PermissionDIModuleKt$PermissionDIModule$1.INSTANCE);
    }

    public static final Object a(Class r3) {
        Application r0 = LarkContext.getApplication();
        Intrinsics.checkNotNull(r0);
        UserSession r1 = ((com.ss.android.lark.passportc.convention.a) k.a(r0, com.ss.android.lark.passportc.convention.a.class)).b();
        return k.b(((v) k.a(r0, v.class)).c(r1), r3);
    }
}
