package com.larus.xbridge.custom;

import android.app.Activity;
import android.view.View;
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
import com.larus.platform.spi.IAIChatService;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@XBridgeMethod(name = "flow.longPressServiceBotCard", owner = "huangweijie")
public final class f1 extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "flow.longPressServiceBotCard")
    public final String f379744a;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "content", required = true)
        String getContent();

        @XBridgeParamField(isGetter = true, keyPath = "longPressPositionX", required = true)
        Integer getLongPressPositionX();

        @XBridgeParamField(isGetter = true, keyPath = "longPressPositionY", required = true)
        Integer getLongPressPositionY();

        @XBridgeParamField(isGetter = true, keyPath = "messageId", required = true)
        String getMessageId();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
    }

    public f1() {
        this.f379744a = "flow.longPressServiceBotCard";
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f379744a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r110) {
        b r102 = (b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        Activity r103 = r100.getOwnerActivity();
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("[handle] ");
        r105.append(r102);
        r105.append(", activity=");
        if (r103 == null) goto L5;
        String r106 = r103.getLocalClassName();
    L6:
        r105.append(r106);
        r105.append(' ');
        r105.append(r100.getEngineView());
        r104.i("FlowLongPressServiceBotCardMethod", r105.toString());
        cf8.b r107 = new cf8.b(r102.getMessageId(), r102.getContent(), r102.getLongPressPositionX(), r102.getLongPressPositionY());
        i2 r108 = i2.f379772a;
        View r109 = r100.getEngineView();
        r108.getClass();
        Intrinsics.checkNotNullParameter(r107, "data");
        if (r103 == null) goto L15;
        if (r109 == null) goto L15;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L12
        Result.m9449constructorimpl(Boolean.valueOf(r109.performHapticFeedback(0)));     // Catch: Throwable -> L12
    L14:
        IAIChatService.f365899a.o7().a(r103, r109, r107);
    L16:
        CompletionBlock.DefaultImpls.onSuccess$default(r110, (XBaseResultModel) ne7.e.b(c.class), null, 2, null);
        return;
    L12:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L15:
        r104.w("ServiceBotCardLongPressHandler", "long press ignored because context or anchor view is missing");
        goto L16
    L5:
        r106 = null;
        goto L6
    }
}
