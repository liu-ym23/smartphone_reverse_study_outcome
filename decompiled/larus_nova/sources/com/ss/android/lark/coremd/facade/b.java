package com.ss.android.lark.coremd.facade;

import com.ss.android.lark.coremd.base.parse.j;
import com.ss.android.lark.coremd.ext.g;
import com.ss.android.lark.coremd.facade.bizext.IMThemeExtend;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import t9b.e;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Float> f419622a = null;

    static {
        Float r100 = Float.valueOf(1.0f);
        f419622a = CollectionsKt.listOf(new Float[]{Float.valueOf(1.06f), r100, r100, r100, r100, r100});
    }

    public static final j a(Function2 r100) {
        e r101 = e.f545146a;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Intrinsics.checkNotNullParameter(r100, "action");
        j r102 = com.ss.android.lark.coremdbiz.facade.a.b();
        IMThemeExtend.a r103 = IMThemeExtend.f419630s;
        g.a(r102, r103, r100);
        Intrinsics.checkNotNullParameter(r102, "<this>");
        g.a(r102, r103, IMMarkdownConfigKt$applyChatMessageHeadingStyle$1.INSTANCE);
        return r102;
    }
}
