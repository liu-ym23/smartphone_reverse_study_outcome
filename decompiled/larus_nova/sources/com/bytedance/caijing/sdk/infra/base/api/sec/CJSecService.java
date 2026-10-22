package com.bytedance.caijing.sdk.infra.base.api.sec;

import android.content.Context;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import faceverify.w;
import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import we4.b;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001$J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH&J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u000e\u001a\u00020\bH&J \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H&J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH&J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\bH&J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\u000bH&J)\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040!2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010 \u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/sec/CJSecService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "pin", "Lwe4/b;", "initEnv", "", "pubKey", "msg", "Lcom/bytedance/caijing/sdk/infra/base/api/sec/EncryptVendor;", "cjEncryptVendor", "messageEncrypt", "encryptData", "messageDecrypt", "Lcom/bytedance/caijing/sdk/infra/base/api/sec/SecHashEnum;", "hashType", "plain", "Ljava/io/ByteArrayOutputStream;", Argument.OUT, "", w.BLOB_ELEM_IMAGE_HASHCODE, "privateKey", "input", "sign", "publicKey", "", "verifySign", "Lcom/bytedance/caijing/sdk/infra/base/api/sec/CJSecService$a;", "getCertController", "rawCode", "rawMsg", "", "parseErrMsgForBusiness", "(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface CJSecService extends ICJService {

    /* JADX INFO: loaded from: classes15.dex */
    public interface a {
        b<String> a(Context r100, String r101, String r102, String r103);

        b<String> b(Context r100, String r101);

        b<String> c(Context r100, String r101, String r102);

        b<me4.a> d(Context r100, String r101);

        b<me4.b> e(Context r100, String r101, String r102, String r103, String r104, String r105, String r106);

        b<String> f(Context r100, String r101, String r102);

        String g(String r100, String r101, String r102);

        String[] parseErrMsgForBusiness(String r100, String r101);
    }

    a getCertController(EncryptVendor r100);

    int hash(SecHashEnum r100, byte[] r101, ByteArrayOutputStream r102);

    b<String> initEnv(Context r100, String r101);

    b<String> messageDecrypt(byte[] r100);

    b<byte[]> messageEncrypt(byte[] r100, byte[] r101, EncryptVendor r102);

    String[] parseErrMsgForBusiness(String r100, String r101);

    byte[] sign(byte[] r100, byte[] r101);

    boolean verifySign(byte[] r100, byte[] r101, byte[] r102);
}
