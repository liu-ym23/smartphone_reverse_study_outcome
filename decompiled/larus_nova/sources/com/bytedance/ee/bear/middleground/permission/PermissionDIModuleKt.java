package com.bytedance.ee.bear.middleground.permission;

import android.app.Application;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class PermissionDIModuleKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kwc.a f232829a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static og5.a f232830b;

    static {
        f232829a = owc.b.a(PermissionDIModuleKt$PermissionDIModule$1.INSTANCE);
    }

    public static final Object a(Class r100) {
        Application r101 = LarkContext.getApplication();
        Intrinsics.checkNotNull(r101);
        UserSession r102 = ((com.ss.android.lark.passportc.convention.a) k.a(r101, com.ss.android.lark.passportc.convention.a.class)).b();
        return k.b(((v) k.a(r101, v.class)).c(r102), r100);
    }
}
