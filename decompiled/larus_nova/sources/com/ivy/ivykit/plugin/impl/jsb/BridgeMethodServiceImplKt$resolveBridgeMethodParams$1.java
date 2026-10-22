package com.ivy.ivykit.plugin.impl.jsb;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
final /* synthetic */ class BridgeMethodServiceImplKt$resolveBridgeMethodParams$1 extends FunctionReferenceImpl implements Function2<Map<String, ? extends Object>, Class<? extends IDLXBridgeMethod>, Map<String, ? extends Object>> {
    public static final BridgeMethodServiceImplKt$resolveBridgeMethodParams$1 INSTANCE = null;

    static {
        INSTANCE = new BridgeMethodServiceImplKt$resolveBridgeMethodParams$1();
    }

    public BridgeMethodServiceImplKt$resolveBridgeMethodParams$1() {
        super(2, c.class, "transformPlatformParams", "transformPlatformParams(Ljava/util/Map;Ljava/lang/Class;)Ljava/util/Map;", 1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<String, Object> invoke2(Map<String, ? extends Object> r100, Class<? extends IDLXBridgeMethod> r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        Intrinsics.checkNotNullParameter(r101, "p1");
        return c.f278382a.l(new JSONObject(r100), r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Map<String, ? extends Object> invoke(Map<String, ? extends Object> r100, Class<? extends IDLXBridgeMethod> r101) {
        return invoke2(r100, r101);
    }
}
