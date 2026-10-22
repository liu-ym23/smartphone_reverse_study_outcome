package com.bytedance.sdk.xbridge.cn.system;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeIntEnum;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes22.dex */
public abstract class a extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f270171c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.addShortcut", params = {"id", "schema", "icon", "name", "middlePageUrl"}, results = {"code"})
    public final String f270172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PROTECT)
    public final IDLXBridgeMethod.Access f270173b;

    /* JADX INFO: renamed from: com.bytedance.sdk.xbridge.cn.system.a$a, reason: collision with other inner class name */
    public static final class C3775a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "icon", required = false)
        String getIcon();

        @XBridgeParamField(isGetter = true, keyPath = "id", required = true)
        String getId();

        @XBridgeParamField(isGetter = true, keyPath = "middlePageUrl", required = false)
        String getMiddlePageUrl();

        @XBridgeParamField(isGetter = true, keyPath = "name", required = true)
        String getName();

        @XBridgeParamField(isGetter = true, keyPath = "schema", required = true)
        String getSchema();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "code", required = true)
        @XBridgeIntEnum(option = {1, 0, -1, -2})
        Number getCode();

        @XBridgeParamField(isEnum = true, isGetter = false, keyPath = "code", required = true)
        @XBridgeIntEnum(option = {1, 0, -1, -2})
        void setCode(Number r100);
    }

    static {
        f270171c = MapsKt.mapOf(TuplesKt.to("TicketID", "21473"));
    }

    public a() {
        this.f270172a = "x.addShortcut";
        this.f270173b = IDLXBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f270173b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f270172a;
    }
}
