package com.bytedance.flow.search.kmp.impl.core;

import com.alipay.sdk.m.u.i;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f243569a = null;

    static {
        f243569a = CollectionsKt.listOf(new String[]{"intermediate_filter", "history", "message", "contact", "drive", "bot"});
    }

    public static String a(aw5.c r110) {
        String r100 = CollectionsKt.joinToString$default(r110.f16542b.entrySet(), i.f25853b, null, null, 0, null, new a(), 30, null);
        String r101 = r110.f16541a.name();
        Throwable r102 = r110.f16549i;
        if (r102 == null) goto L5;
        String r103 = Reflection.getOrCreateKotlinClass(r102.getClass()).getSimpleName() + '(' + r102.getMessage() + ')';
    L7:
        return "modules={" + r100 + "},moduleOrder=" + r110.f16543c + ",loading={" + r101 + "},isHistoryManaging=" + r110.f16545e + ",isHistoryExpanded=" + r110.f16546f + ",isEmpty=" + r110.f16550j + ",error=" + r103;
    L5:
        r103 = null;
        goto L7
    }
}
