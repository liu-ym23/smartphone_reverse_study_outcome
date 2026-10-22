package com.ss.android.cert.manager.jsb;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeResultModelArguments;
import com.bytedance.sdk.xbridge.cn.utils.ConvertUtils;
import com.ss.android.cert.manager.BytedCertSdk;
import com.ss.android.cert.manager.BytedCertSdkInitParam;
import com.ss.android.cert.manager.CertManager;
import com.ss.android.cert.manager.callback.CertResultCallback;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.jsb.idl.AbsCertOpenByteCertMethodIDL;
import com.ss.android.cert.manager.model.CertResult;
import com.ss.android.cert.manager.utils.event.EventLogUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
@XBridgeMethod(name = "cert.openByteCert")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J.\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002¨\u0006\u0014"}, d2 = {"Lcom/ss/android/cert/manager/jsb/CertOpenByteCertMethod;", "Lcom/ss/android/cert/manager/jsb/idl/AbsCertOpenByteCertMethodIDL;", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/ss/android/cert/manager/jsb/idl/AbsCertOpenByteCertMethodIDL$CertOpenByteCertParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/ss/android/cert/manager/jsb/idl/AbsCertOpenByteCertMethodIDL$CertOpenByteCertResultModel;", "openByteCert", "pluginMessage", "", "parseCertResult", "certResult", "Lcom/ss/android/cert/manager/model/CertResult;", "faceOnly", "", "byted_cert_manager_release"}, k = 1, mv = {1, 1, 16})
public class CertOpenByteCertMethod extends AbsCertOpenByteCertMethodIDL {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[BytedCertSdkInitParam.PluginParams.Status.values().length];
            $EnumSwitchMapping$0 = r100;
            r100[BytedCertSdkInitParam.PluginParams.Status.SUCCESS.ordinal()] = 1;
            r100[BytedCertSdkInitParam.PluginParams.Status.CANCEL.ordinal()] = 2;
        }
    }

    public CertOpenByteCertMethod() {
    }

    private final AbsCertOpenByteCertMethodIDL.CertOpenByteCertResultModel parseCertResult(CertResult r100, boolean r101) {
        AbsCertOpenByteCertMethodIDL.CertOpenByteCertResultModel r102 = (AbsCertOpenByteCertMethodIDL.CertOpenByteCertResultModel) XBridgeResultModelArguments.INSTANCE.createModel(AbsCertOpenByteCertMethodIDL.CertOpenByteCertResultModel.class);
        r102.setErrorCode(Integer.valueOf(r100.getCode()));
        r102.setErrorMsg(r100.getMessage());
        r102.setTicket(r100.getTicket());
        r102.setCertStatus(Integer.valueOf(r100.getCertStatus()));
        r102.setManualStatus(Integer.valueOf(r100.getManualStatus()));
        r102.setAgeRange(Integer.valueOf(r100.getAgeRange()));
        if (r101 == true) goto L5;
        Map<String, Object> r103 = ConvertUtils.INSTANCE.jsonToMap(r100.getExtra());     // Catch: Exception -> L30
        LinkedHashMap r104 = new LinkedHashMap();     // Catch: Exception -> L30
        Iterator<Map.Entry<String, Object>> r105 = r103.entrySet().iterator();     // Catch: Exception -> L30
    L21:
        if (r105.hasNext() == false) goto L28;
        Map.Entry<String, Object> r106 = r105.next();     // Catch: Exception -> L30
        if (r106.getValue() == null) goto L25;
        boolean r107 = true;
    L26:
        if (r107 == false) goto L21;
        r104.put(r106.getKey(), r106.getValue());     // Catch: Exception -> L30
        goto L21
    L25:
        r107 = false;
        goto L26
    L28:
        r102.setExtData(r104);     // Catch: Exception -> L30
    L32:
        return r102;
    L30:
        e = move-exception;
        e.printStackTrace();
        goto L32
    L5:
        if (TextUtils.isEmpty(r100.getSdkData()) == true) goto L32;
        JSONObject r108 = new JSONObject();     // Catch: Exception -> L17
        r108.put("sdk_data", r100.getSdkData());     // Catch: Exception -> L17
        Map<String, Object> r109 = ConvertUtils.INSTANCE.jsonToMap(r108);     // Catch: Exception -> L17
        LinkedHashMap r110 = new LinkedHashMap();     // Catch: Exception -> L17
        Iterator<Map.Entry<String, Object>> r111 = r109.entrySet().iterator();     // Catch: Exception -> L17
    L8:
        if (r111.hasNext() == false) goto L15;
        Map.Entry<String, Object> r112 = r111.next();     // Catch: Exception -> L17
        if (r112.getValue() == null) goto L12;
        boolean r113 = true;
    L13:
        if (r113 == false) goto L8;
        r110.put(r112.getKey(), r112.getValue());     // Catch: Exception -> L17
        goto L8
    L12:
        r113 = false;
        goto L13
    L15:
        r102.setExtData(r110);     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L32
    }

    public static final /* synthetic */ AbsCertOpenByteCertMethodIDL.CertOpenByteCertResultModel access$parseCertResult(CertOpenByteCertMethod r100, CertResult r101, boolean r102) {
        return r100.parseCertResult(r101, r102);
    }

    public void handle(final IBDXBridgeContext r100, final AbsCertOpenByteCertMethodIDL.CertOpenByteCertParamModel r101, final CompletionBlock<AbsCertOpenByteCertMethodIDL.CertOpenByteCertResultModel> r110) {
        final long r102 = System.currentTimeMillis();
        JSONObject r103 = new JSONObject();
        r103.put("face_only", r101.getFaceOnly());
        r103.put("scene", r101.getScene());
        String r104 = r101.getTicket();
        if (r104 == null) goto L5;
        r103.put("ticket", r104);
    L5:
        String r105 = r101.getFlow();
        if (r105 == null) goto L8;
        r103.put(BytedCertConstant.CertKey.FLOW, r105);
    L8:
        EventLogUtils.onEvent("auth_jsb_open_byte_cert_start", r103);
        final CompletionBlock<AbsCertOpenByteCertMethodIDL.CertOpenByteCertResultModel> r106 = new CertOpenByteCertMethod$handle$eventCallback$1(r101, r102, r110);
        HashMap r111 = new HashMap();
        r111.put("scene", r101.getScene());
        r111.put("enter_method", "x-bridge");
        String r107 = r101.getTicket();
        if (r107 == null) goto L11;
        String r108 = (String) r111.put("ticket", r107);
    L11:
        String r109 = r101.getFlow();
        if (r109 == null) goto L14;
        String r112 = (String) r111.put(BytedCertConstant.CertKey.FLOW, r109);
    L14:
        BytedCertSdk.checkPluginReady(r111, new AnonymousClass3(this, r100, r101, r106));
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public /* bridge */ /* synthetic */ void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        handle(r100, (AbsCertOpenByteCertMethodIDL.CertOpenByteCertParamModel) r101, r102);
    }

    private final void openByteCert(IBDXBridgeContext r100, final AbsCertOpenByteCertMethodIDL.CertOpenByteCertParamModel r110, final CompletionBlock<AbsCertOpenByteCertMethodIDL.CertOpenByteCertResultModel> r111, final String r112) {
        Activity r101 = r100.getOwnerActivity();
        if (r101 == null) goto L44;
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("scene", r110.getScene());
        String r103 = r110.getFlow();
        if (r103 == null) goto L7;
        String r104 = (String) r102.put(BytedCertConstant.CertKey.FLOW, r103);
    L7:
        String r105 = r110.getTicket();
        if (r105 == null) goto L10;
        String r106 = (String) r102.put("ticket", r105);
    L10:
        String r107 = r110.getCertAppId();
        if (r107 == null) goto L13;
        String r108 = (String) r102.put("cert_app_id", r107);
    L13:
        Map<String, Object> r109 = r110.getExtraParams();
        if (r109 == null) goto L23;
        Iterator<String> r113 = r109.keySet().iterator();
    L17:
        if (r113.hasNext() == false) goto L23;
        String r114 = r113.next();
        if (TextUtils.isEmpty(r114) == true) goto L17;
        if (r109.get(r114) == null) goto L17;
        r102.put(r114, String.valueOf(r109.get(r114)));
    L23:
        Map<String, Object> r115 = r110.getH5QueryParams();
        if (r115 == null) goto L33;
        Iterator<String> r116 = r115.keySet().iterator();
    L27:
        if (r116.hasNext() == false) goto L33;
        String r117 = r116.next();
        if (TextUtils.isEmpty(r117) == true) goto L27;
        if (r115.get(r117) == null) goto L27;
        r102.put("h5-params-" + r117, String.valueOf(r115.get(r117)));
    L33:
        String r118 = r110.getIdentityName();
        if (r118 == null) goto L36;
        String r119 = (String) r102.put(BytedCertConstant.CertKey.IDENTITY_NAME, r118);
    L36:
        String r120 = r110.getIdentityCode();
        if (r120 == null) goto L39;
        String r121 = (String) r102.put(BytedCertConstant.CertKey.IDENTITY_CODE, r120);
    L39:
        r102.put("enter_method", "x-bridge");
        CertResultCallback r122 = new CertOpenByteCertMethod$openByteCert$certCallback$1(this, r111, r112, r110);
        if (Intrinsics.areEqual(r110.getFaceOnly(), Boolean.TRUE) == false) goto L42;
        CertManager.getInstance().startFaceLiveness(r101, r102, r122);
        return;
    L42:
        CertManager.getInstance().startCertFlow(r101, r102, r122);
        return;
    L44:
        CompletionBlock.DefaultImpls.onFailure$default(r111, 0, "plugin result:" + r112 + "; bridgeContext.getOwnerActivity() return null", null, 4, null);
    }

    public static final /* synthetic */ void access$openByteCert(CertOpenByteCertMethod r100, IBDXBridgeContext r101, AbsCertOpenByteCertMethodIDL.CertOpenByteCertParamModel r102, CompletionBlock r103, String r104) {
        r100.openByteCert(r101, r102, r103, r104);
    }
}
