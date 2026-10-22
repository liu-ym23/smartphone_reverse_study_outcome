package com.bytedance.upc.bridge.impl;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import com.bytedance.bpea.entry.common.DataType;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "copyToClipboard", owner = "wanglijie.skin")
public final class b extends gp7.a {
    public b() {
    }

    @Skip({"com.bytedance.timonbase.clipboard.ClipboardMonitorManager", "com.bytedance.timon.clipboard.suite.TimonClipboardSuite", "com.bytedance.timon.clipboard.suite.TimonClipboardSuiteKt"})
    public static void a(ClipboardManager r100, ClipData r101) {
        Intrinsics.checkNotNullParameter(r101, "clip");
        FLogger.f375446a.i("ClipboardManagerLancet", "hook setPrimaryClip");     // Catch: Exception -> L5
        b(r100, r101);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e, "setPrimaryClip Exception:");
        FLogger.f375446a.e("ClipboardManagerLancet", "setPrimaryClip Exception: " + e.getMessage());
    }

    public static void b(ClipboardManager r110, ClipData r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(101807);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(101807, "android/content/ClipboardManager", "setPrimaryClip", r110, r101, "void", r112);     // Catch: Exception -> L21
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L21
    L17:
        if (r107.f474982a == false) goto L19;
        return;
    L19:
        r110.setPrimaryClip(r111);
        return;
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        gp7.a.b r103 = (gp7.a.b) r101;
        View r104 = r100.getEngineView();     // Catch: Throwable -> L14
        if (r104 == null) goto L12;
        Context r105 = r104.getContext();     // Catch: Throwable -> L14
        if (r105 == null) goto L12;
        Object r106 = r105.getSystemService(DataType.CLIPBOARD);     // Catch: Throwable -> L14
        if (r106 == null) goto L11;
        a((ClipboardManager) r106, ClipData.newPlainText("upc_webview_clip", r103.getContent()));     // Catch: Throwable -> L14
        CompletionBlock.DefaultImpls.onSuccess$default(r102, new a(), null, 2, null);     // Catch: Throwable -> L14
        return;
    L11:
        throw new TypeCastException("null cannot be cast to non-null type android.content.ClipboardManager");     // Catch: Throwable -> L14
    L12:
        CompletionBlock.DefaultImpls.onFailure$default(r102, -1, "context is null", null, 4, null);     // Catch: Throwable -> L14
        return;
    }
}
