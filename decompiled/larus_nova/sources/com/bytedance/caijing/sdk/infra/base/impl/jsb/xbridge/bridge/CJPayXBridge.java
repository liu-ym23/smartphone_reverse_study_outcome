package com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.bridge;

import android.content.Context;
import android.content.Intent;
import com.bytedance.caijing.sdk.infra.base.api.plugin.container.PlugInContainerService;
import com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.annotation.CJPayXBridgeMethod;
import com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.IXPayBaseMethod;
import com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.utils.ContainerUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import java.lang.reflect.Method;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public class CJPayXBridge {

    public class a implements IXPayBaseMethod.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ cd4.k f202625a;

        public a(cd4.k r100) {
            this.f202625a = r100;
        }

        @Override // com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.IXPayBaseMethod.b
        public final void success(Map<String, Object> r100) {
            cd4.k r101 = this.f202625a;
            if (r101 == null) goto L6;
            r101.onSuccess(new JSONObject(r100));
            return;
        }

        @Override // com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.IXPayBaseMethod.b
        public final void a(Map<String, Object> r100, String r101) {
            cd4.k r102 = this.f202625a;
            if (r102 == null) goto L6;
            r102.onFailed("", new JSONObject(r100));
            return;
        }
    }

    public CJPayXBridge() {
    }

    private cd4.m getJSBMethod(String r100) {
        ve4.a.f554342a.getClass();
        PlugInContainerService r101 = (PlugInContainerService) ve4.a.a(PlugInContainerService.class);
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r101.getJSBHelper() != null) goto L7;
        return null;
    L7:
        return r101.getJSBHelper().getXJSB(r100);
    }

    @CJPayXBridgeMethod("ttcjpay.authAlipay")
    public void authAlipay(Context r100, JSONObject r101, IXPayBaseMethod.b r102) {
        cd4.m r103 = getJSBMethod("ttcjpay.authAlipay");
        if (r103 == null) goto L6;
        ContainerUtils r104 = ContainerUtils.f202693a;
        r103.handle(r100, r101, ContainerUtils.a(r102));
        return;
    }

    @CJPayXBridgeMethod("ttcjpay.bioPaymentShowState")
    public void bioShowState(Context r100, JSONObject r101, IXPayBaseMethod.b r102) {
        cd4.m r103 = getJSBMethod("ttcjpay.bioPaymentShowState");
        if (r103 == null) goto L6;
        ContainerUtils r104 = ContainerUtils.f202693a;
        r103.handle(r100, r101, ContainerUtils.a(r102));
        return;
    }

    @CJPayXBridgeMethod("ttcjpay.switchBioPaymentState")
    public void bioSwitchState(Context r100, JSONObject r101, IXPayBaseMethod.b r102) {
        cd4.m r103 = getJSBMethod("ttcjpay.switchBioPaymentState");
        if (r103 == null) goto L6;
        ContainerUtils r104 = ContainerUtils.f202693a;
        r103.handle(r100, r101, ContainerUtils.a(r102));
        return;
    }

    @CJPayXBridgeMethod("ttcjpay.isAppInstalled")
    public void checkAppInstall(Context r100, JSONObject r101, IXPayBaseMethod.b r102) {
        cd4.m r103 = getJSBMethod("ttcjpay.isAppInstalled");
        if (r103 == null) goto L6;
        ContainerUtils r104 = ContainerUtils.f202693a;
        r103.handle(r100, r101, ContainerUtils.a(r102));
        return;
    }

    @CJPayXBridgeMethod("ttcjpay.faceVerification")
    public void checkFaceByAILab(Context r100, JSONObject r101, IXPayBaseMethod.b r102) {
        cd4.m r103 = getJSBMethod("ttcjpay.faceVerification");
        if (r103 == null) goto L6;
        ContainerUtils r104 = ContainerUtils.f202693a;
        r103.handle(r100, r101, ContainerUtils.a(r102));
        return;
    }

    @CJPayXBridgeMethod("ttcjpay.facepp")
    public void checkFaceByFacePP(Context r100, JSONObject r101, IXPayBaseMethod.b r102) {
        cd4.m r103 = getJSBMethod("ttcjpay.facepp");
        if (r103 == null) goto L6;
        ContainerUtils r104 = ContainerUtils.f202693a;
        r103.handle(r100, r101, ContainerUtils.a(r102));
        return;
    }

    @CJPayXBridgeMethod("ttcjpay.deviceInfo")
    public void deviceInfo(Context r100, JSONObject r101, IXPayBaseMethod.b r102) {
        cd4.m r103 = getJSBMethod("ttcjpay.deviceInfo");
        if (r103 == null) goto L6;
        ContainerUtils r104 = ContainerUtils.f202693a;
        r103.handle(r100, r101, ContainerUtils.a(r102));
        return;
    }

    @CJPayXBridgeMethod("ttcjpay.encrypt")
    public void encrypt(Context r100, JSONObject r101, IXPayBaseMethod.b r102) {
        cd4.m r103 = getJSBMethod("ttcjpay.encrypt");
        if (r103 == null) goto L6;
        ContainerUtils r104 = ContainerUtils.f202693a;
        r103.handle(r100, r101, ContainerUtils.a(r102));
        return;
    }

    @CJPayXBridgeMethod("ttcjpay.closeCallback")
    public void executeCloseAndCallback(Context r100, JSONObject r101, IXPayBaseMethod.b r102) {
        cd4.m r103 = getJSBMethod("ttcjpay.closeCallback");
        if (r103 == null) goto L6;
        ContainerUtils r104 = ContainerUtils.f202693a;
        r103.handle(r100, r101, ContainerUtils.a(r102));
        return;
    }

    @CJPayXBridgeMethod("ttcjpay.abTest")
    public void getABTest(Context r100, JSONObject r101, IXPayBaseMethod.b r102) {
        cd4.m r103 = getJSBMethod("ttcjpay.abTest");
        if (r103 == null) goto L6;
        ContainerUtils r104 = ContainerUtils.f202693a;
        r103.handle(r100, r101, ContainerUtils.a(r102));
        return;
    }

    @CJPayXBridgeMethod("ttcjpay.goSettings")
    public void goSettings(Context r100, JSONObject r101, IXPayBaseMethod.b r102) {
        cd4.m r103 = getJSBMethod("ttcjpay.goSettings");
        if (r103 == null) goto L6;
        ContainerUtils r104 = ContainerUtils.f202693a;
        r103.handle(r100, r101, ContainerUtils.a(r102));
        return;
    }

    @CJPayXBridgeMethod("ttcjpay.ocr")
    public void ocrService(Context r100, JSONObject r101, IXPayBaseMethod.b r102) {
        cd4.m r103 = getJSBMethod("ttcjpay.ocr");
        if (r103 == null) goto L6;
        ContainerUtils r104 = ContainerUtils.f202693a;
        r103.handle(r100, r101, ContainerUtils.a(r102));
        return;
    }

    @CJPayXBridgeMethod("ttcjpay.openAppByScheme")
    public void openAppBySchema(Context r100, JSONObject r101, IXPayBaseMethod.b r102) {
        String r103 = r101.optString("app_scheme");     // Catch: Exception -> L4
        Intent r104 = new Intent();     // Catch: Exception -> L4
        r104.setData(UriProtector.parse(r103));     // Catch: Exception -> L4
        r104.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);     // Catch: Exception -> L4
        r100.startActivity(r104);     // Catch: Exception -> L4
        return;
    }

    @CJPayXBridgeMethod("ttcjpay.sendDeviceInfo")
    public void sendDeviceInfo(Context r100, JSONObject r101, IXPayBaseMethod.b r102) {
        cd4.m r103 = getJSBMethod("ttcjpay.sendDeviceInfo");
        if (r103 == null) goto L6;
        ContainerUtils r104 = ContainerUtils.f202693a;
        r103.handle(r100, r101, ContainerUtils.a(r102));
        return;
    }

    @CJPayXBridgeMethod("ttcjpay.ttpay")
    public void ttpay(Context r100, JSONObject r101, IXPayBaseMethod.b r102) {
        cd4.m r103 = getJSBMethod("ttcjpay.ttpay");
        if (r103 == null) goto L6;
        ContainerUtils r104 = ContainerUtils.f202693a;
        r103.handle(r100, r101, ContainerUtils.a(r102));
        return;
    }

    public static void invokeCJPayXBridge(Context r100, String r101, JSONObject r102, cd4.k r103) {
        CJPayXBridge r104 = new CJPayXBridge();     // Catch: Exception -> L14
        Method[] r105 = CJPayXBridge.class.getDeclaredMethods();     // Catch: Exception -> L14
        int r106 = 0;
    L4:
        if (r106 >= r105.length) goto L22;
        Method r107 = r105[r106];     // Catch: Exception -> L14
        CJPayXBridgeMethod r108 = (CJPayXBridgeMethod) r107.getAnnotation(CJPayXBridgeMethod.class);     // Catch: Exception -> L14
        if (r108 != null) goto L9;
    L12:
        r106 = r106 + 1;
        goto L4
    L9:
        if (r101.equals(r108.value()) == false) goto L12;
        r107.invoke(r104, new Object[]{r100, r102, new a(r103)});     // Catch: Exception -> L14
        return;
    L22:
        return;
    }
}
