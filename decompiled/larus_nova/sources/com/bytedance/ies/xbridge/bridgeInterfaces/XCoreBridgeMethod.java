package com.bytedance.ies.xbridge.bridgeInterfaces;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.model.params.a;
import g66.c;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J%\u0010\t\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ,\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\b\b\u0002\u0010\u0011\u001a\u00020\u000eJ6\u0010\u0015\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rJ\b\u0010\u0017\u001a\u00020\u0016H\u0016R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ies/xbridge/bridgeInterfaces/XCoreBridgeMethod;", "Lcom/bytedance/ies/xbridge/XBridgeMethod;", "Lg66/c;", "contextProviderFactory", "", "setProviderFactory", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "clz", "provideContext", "(Ljava/lang/Class;)Ljava/lang/Object;", "Lcom/bytedance/ies/xbridge/XBridgeMethod$Callback;", "callback", "", "", "", "data", "msg", "onSuccess", "", "code", "onFailure", "", "canRunInBackground", "Lg66/c;", "getContextProviderFactory", "()Lg66/c;", "setContextProviderFactory", "(Lg66/c;)V", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public abstract class XCoreBridgeMethod implements XBridgeMethod {
    private c contextProviderFactory;

    public XCoreBridgeMethod() {
    }

    public boolean canRunInBackground() {
        return false;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public Class<? extends a> provideParamModel() {
        return null;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public Class<? extends i66.a> provideResultModel() {
        return null;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod, com.bytedance.sdk.xbridge.cn.protocol.h
    public void release() {
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public XBridgeMethod.Access getAccess() {
        return XBridgeMethod.Access.PRIVATE;
    }

    public final c getContextProviderFactory() {
        return this.contextProviderFactory;
    }

    public <T> T provideContext(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clz");
        c r101 = this.contextProviderFactory;
        if (r101 != null) goto L7;
        return null;
    L7:
        return (T) r101.c(r100);
    }

    public final void setContextProviderFactory(c r100) {
        this.contextProviderFactory = r100;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public void setProviderFactory(c r100) {
        this.contextProviderFactory = r100;
    }

    public final void onSuccess(XBridgeMethod.Callback r100, Map<String, Object> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r102, "msg");
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("code", 1);
        r103.put("msg", r102);
        r103.put("data", r101);
        r100.invoke(r103);
    }

    public final void onFailure(XBridgeMethod.Callback r100, int r101, String r102, Map<String, Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Intrinsics.checkNotNullParameter(r102, "msg");
        Intrinsics.checkNotNullParameter(r103, "data");
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put("code", Integer.valueOf(r101));
        r104.put("msg", r102);
        r104.put("data", r103);
        r100.invoke(r104);
    }

    public static /* synthetic */ void onSuccess$default(XCoreBridgeMethod r100, XBridgeMethod.Callback r101, Map r102, String r103, int r104, Object r105) {
        if (r105 != null) goto L9;
        if ((r104 & 4) == 0) goto L6;
        r103 = "";
    L6:
        r100.onSuccess(r101, r102, r103);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSuccess");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void onFailure$default(XCoreBridgeMethod r100, XBridgeMethod.Callback r101, int r102, String r103, Map r104, int r105, Object r106) {
        if (r106 != null) goto L12;
        if ((r105 & 4) == 0) goto L7;
        r103 = "";
    L7:
        if ((r105 & 8) == 0) goto L9;
        r104 = new LinkedHashMap();
    L9:
        r100.onFailure(r101, r102, r103, r104);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onFailure");
    }
}
