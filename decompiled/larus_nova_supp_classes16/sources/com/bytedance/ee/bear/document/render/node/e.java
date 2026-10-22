package com.bytedance.ee.bear.document.render.node;

import com.bytedance.ee.bear.contract.m0;
import com.bytedance.ee.bear.document.x2;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface e {

    public static final class a {
        public static /* synthetic */ void a(e r1, int r2, Throwable r3) {
            r1.d(r2, r3, MapsKt.emptyMap());
        }
    }

    void S(x2.b r1);

    <T> T a(Class<T> r1);

    f b();

    void c(Function1<? super m0, Unit> r1);

    void d(int r1, Throwable r2, Map<String, String> r3);

    o e();

    String f();

    com.bytedance.ee.bear.document.d getDocumentMetadata();

    ChameleonPluginHost getPluginHost();
}
