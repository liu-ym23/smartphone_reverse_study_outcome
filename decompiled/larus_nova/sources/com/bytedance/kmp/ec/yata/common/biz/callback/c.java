package com.bytedance.kmp.ec.yata.common.biz.callback;

import android.view.View;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public interface c {

    public static final class a {
        public static void a(com.bytedance.kmp.ec.yata.store.node.c r100, ga6.c r101, Map r102) {
            Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
            Intrinsics.checkNotNullParameter(r101, "config");
            Intrinsics.checkNotNullParameter(r102, "containerMap");
        }

        public static void b(com.bytedance.kmp.ec.yata.store.node.c r100, ga6.c r101, Map r102) {
            Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
            Intrinsics.checkNotNullParameter(r101, "config");
            Intrinsics.checkNotNullParameter(r102, "containerMap");
        }

        public static void c(com.bytedance.kmp.ec.yata.store.node.c r100, ga6.c r101, Map r102) {
            Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
            Intrinsics.checkNotNullParameter(r101, "config");
            Intrinsics.checkNotNullParameter(r102, "containerMap");
        }

        public static void d(com.bytedance.kmp.ec.yata.store.node.c r100, ga6.c r101, Map r102) {
            Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
            Intrinsics.checkNotNullParameter(r101, "config");
            Intrinsics.checkNotNullParameter(r102, "containerMap");
        }

        public static void e(com.bytedance.kmp.ec.yata.store.node.c r100, ga6.c r101) {
            Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
            Intrinsics.checkNotNullParameter(r101, "config");
        }
    }

    void d(com.bytedance.kmp.ec.yata.store.node.c r100, ga6.c r101, Map<String, ? extends View> r102);

    void g(com.bytedance.kmp.ec.yata.store.node.c r100, ga6.c r101);

    void i(com.bytedance.kmp.ec.yata.store.node.c r100, ga6.c r101, Map<String, ? extends View> r102);

    void k(com.bytedance.kmp.ec.yata.store.node.c r100, ga6.c r101, Map<String, ? extends View> r102);

    void m(com.bytedance.kmp.ec.yata.store.node.c r100, ga6.c r101, Map<String, ? extends View> r102);
}
