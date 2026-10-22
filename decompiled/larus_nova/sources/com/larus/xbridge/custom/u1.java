package com.larus.xbridge.custom;

import android.content.Context;
import android.net.Uri;
import com.bytedance.ies.bullet.base.BulletSdk;
import com.bytedance.mt.protector.impl.UriProtector;
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
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes32.dex */
@XBridgeMethod(name = "open")
public final class u1 extends XCoreIDLBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "open", params = {"schema"})
    public final String f379792a;

    @XBridgeParamModel
    public interface a extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "schema", required = true)
        String getSchema();
    }

    @XBridgeResultModel
    public interface b extends XBaseResultModel {
    }

    public u1() {
        this.f379792a = "open";
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f379792a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [T, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Boolean] */
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        a r100 = (a) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Context r101 = e4a.c.getContext(r110);
        if (r101 == null) goto L23;
        Ref.ObjectRef r102 = new Ref.ObjectRef();
        r102.element = Boolean.FALSE;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        Map<Class<?>, com.ivy.ivykit.api.bridge.d<?>> r104 = com.ivy.ivykit.api.bridge.b.f278301a;     // Catch: Throwable -> L11
        hx7.f r105 = (hx7.f) com.ivy.ivykit.api.bridge.b.a(hx7.f.class);     // Catch: Throwable -> L11
        if (r105 == null) goto L8;
        T r106 = Boolean.valueOf(r105.openSchema(r100.getSchema(), MapsKt.emptyMap(), r101));     // Catch: Throwable -> L11
    L9:
        r102.element = r106;     // Catch: Throwable -> L11
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L14:
        if (Result.m9452exceptionOrNullimpl(r107) == null) goto L16;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "Failed to open schema: " + r100 + ".schema", null, 4, null);
        return;
    L16:
        Uri r108 = UriProtector.parse(r100.getSchema()).buildUpon().appendQueryParameter("use_xbridge3", "true").build();
        T r109 = r102.element;
        Boolean r113 = Boolean.TRUE;
        if (Intrinsics.areEqual(r109, r113) == true) goto L20;
        boolean r114 = BulletSdk.f246267a;
        Intrinsics.checkNotNull(r108);
        r102.element = Boolean.valueOf(BulletSdk.h(r101, r108, null, 12));
    L20:
        if (Intrinsics.areEqual(r102.element, r113) == false) goto L22;
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) ne7.e.b(b.class), null, 2, null);
        return;
    L22:
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "Failed to open schema: " + r100 + ".schema", null, 4, null);
        return;
    L8:
        r106 = 0;
    L11:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L23:
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "Failed to open schema: " + r100 + ".schema", null, 4, null);
    }
}
