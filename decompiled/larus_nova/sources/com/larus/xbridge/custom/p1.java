package com.larus.xbridge.custom;

import android.app.Activity;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes32.dex */
@XBridgeMethod(name = "flow.fileSystemShare", owner = "river.li")
public final class p1 extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "flow.fileSystemShare")
    public final String f379783a;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "fileName", required = true)
        String getFileName();

        @XBridgeParamField(isGetter = true, keyPath = "filePath", required = true)
        String getFilePath();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
    }

    public p1() {
        this.f379783a = "flow.fileSystemShare";
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f379783a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        b r113 = (b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        String r100 = r113.getFilePath();
        String r101 = r113.getFileName();
        Activity r102 = r110.getOwnerActivity();
        FLogger r114 = FLogger.f375446a;
        StringBuilder r115 = new StringBuilder("[handle] activity=");
        if (r102 == null) goto L5;
        String r103 = r102.getLocalClassName();
    L6:
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        r115.append(r103);
        r115.append(" hasFilePath=");
        if (r100 != null) goto L11;
    L14:
        boolean r104 = true;
    L15:
        r115.append(true ^ r104);
        r114.i("FlowSystemShareMethod", r115.toString());
        if (r102 == null) goto L19;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new FlowSystemShareMethod$handle$1$1(r102, r100, r101, r112, null), 3, null);
        return;
    L19:
        return;
    L11:
        if (StringsKt.isBlank(r100) == true) goto L14;
        r104 = false;
        goto L15
    L5:
        r103 = null;
        goto L6
    }
}
