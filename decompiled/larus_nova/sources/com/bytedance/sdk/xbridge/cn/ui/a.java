package com.bytedance.sdk.xbridge.cn.ui;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeStringEnum;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes22.dex */
public abstract class a extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f270245c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.configureStatusBar", params = {"style", "visible", "backgroundColor"})
    public final String f270246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PROTECT)
    public final IDLXBridgeMethod.Access f270247b;

    /* JADX INFO: renamed from: com.bytedance.sdk.xbridge.cn.ui.a$a, reason: collision with other inner class name */
    public static final class C3778a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "backgroundColor", required = false)
        String getBackgroundColor();

        @XBridgeStringEnum(option = {"dark", "light"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "style", required = false)
        String getStyle();

        @XBridgeParamField(isGetter = true, keyPath = "visible", required = false)
        Boolean getVisible();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
        f270245c = MapsKt.mapOf(new Pair[]{TuplesKt.to("IDLVersion", "1000"), TuplesKt.to("UID", "61b6b82bf5e2ab0030b35296"), TuplesKt.to("TicketID", "16446")});
    }

    public a() {
        this.f270246a = "x.configureStatusBar";
        this.f270247b = IDLXBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f270247b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f270246a;
    }
}
