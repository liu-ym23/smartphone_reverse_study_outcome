package com.bytedance.kmp.ec.yata.event.common;

import java.util.List;
import kotlin.Deprecated;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public interface d {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f251658a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<String> f251659b;

        public a(boolean r100, List<String> r101) {
            Intrinsics.checkNotNullParameter(r101, "secondKeyList");
            this.f251658a = r100;
            this.f251659b = r101;
        }
    }

    @Deprecated(message = "SDK内部API,业务不需要实现处理")
    void a(com.bytedance.kmp.ec.yata.event.core.a r100, Function1 r101);

    a b();

    void onDestroy();
}
