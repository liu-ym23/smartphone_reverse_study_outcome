package com.bytedance.android.shopping.mall.homepage.tools;

import com.bytedance.retrofit2.Converter;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m implements yj.n {
    public static final m b = null;
    public final /* synthetic */ yj.n a;

    public final String a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "apiKey");
        return this.a.a(r2);
    }

    public final Map<String, String> b() {
        return this.a.b();
    }

    public final <T> T c(String r2, Class<T> r3, Converter.Factory r4) {
        return (T) this.a.c(r2, r3, r4);
    }

    public final Map<String, String> commonParams() {
        return this.a.commonParams();
    }

    public final void connect(String r2) {
        Intrinsics.checkNotNullParameter(r2, "url");
        this.a.connect(r2);
    }

    public final <T> T create(String r2, Class<T> r3, Converter.Factory r4, Map<String, ? extends Object> r5) {
        return (T) this.a.create(r2, r3, r4, r5);
    }

    public final com.bytedance.android.chunkstreamprediction.network.h d() {
        return this.a.d();
    }

    static {
        b = new m();
    }

    public m() {
        this.a = com.bytedance.android.shopping.api.mall.common.tools.h.b.getIHybridHostNetService();
    }
}
