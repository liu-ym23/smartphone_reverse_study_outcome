package com.bytedance.ee.bear.document.render.node;

import com.bytedance.ee.bear.contract.m0;
import com.bytedance.ee.bear.document.x2;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes16.dex */
public interface e {

    public static final class a {
        public static /* synthetic */ void a(e r100, int r101, Throwable r102) {
            r100.d(r101, r102, MapsKt.emptyMap());
        }
    }

    void S(x2.b r100);

    <T> T a(Class<T> r100);

    f b();

    void c(Function1<? super m0, Unit> r100);

    void d(int r100, Throwable r101, Map<String, String> r102);

    o e();

    String f();

    com.bytedance.ee.bear.document.d getDocumentMetadata();

    ChameleonPluginHost getPluginHost();
}
