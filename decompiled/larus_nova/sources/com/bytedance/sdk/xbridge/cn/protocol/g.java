package com.bytedance.sdk.xbridge.cn.protocol;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public interface g<INPUT, OUTPUT> {
    OUTPUT a(Map<String, ? extends Object> r100, Class<? extends IDLXBridgeMethod> r101, le7.a<INPUT> r102);

    Map<String, Object> b(INPUT r100, Class<? extends IDLXBridgeMethod> r101);

    Map<String, Object> c(INPUT r100, Class<? extends IDLXBridgeMethod> r101, String r102);

    Map<String, Object> d(INPUT r100);
}
