package com.larus.dora.impl.bridge;

import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
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

/* JADX INFO: loaded from: classes27.dex */
@XBridgeMethod(name = "dora.health.openCalendar")
public final class q extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "dora.health.openCalendar")
    public final String f332108a;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "date", required = true)
        String getDate();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
    }

    public q() {
        this.f332108a = "dora.health.openCalendar";
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f332108a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        b r103 = (b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r104 = r103.getDate();
        if (r104 == null) goto L5;
        String r105 = StringsKt.trim(r104).toString();
    L6:
        if (r105 != null) goto L9;
        r105 = "";
    L9:
        if (r105.length() != 0) goto L11;
        boolean r106 = true;
    L12:
        if (r106 == false) goto L14;
        r102.onFailure(-3, "date is required", (XBaseResultModel) ne7.e.b(c.class));
        return;
    L14:
        Intent r107 = new Intent("com.larus.dora.health.OPEN_CALENDAR");
        r107.putExtra("date", r105);
        gd9.i r108 = com.larus.im.b.f346407a;
        Intrinsics.checkNotNull(r108);
        LocalBroadcastManager.getInstance(r108.getApplication()).sendBroadcast(r107);
        FLogger.f375446a.i("DoraHealthOpenCalendarMethod", "dora.health.openCalendar date=".concat(r105));
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) ne7.e.b(c.class), null, 2, null);
        return;
    L11:
        r106 = false;
        goto L12
    L5:
        r105 = null;
        goto L6
    }
}
