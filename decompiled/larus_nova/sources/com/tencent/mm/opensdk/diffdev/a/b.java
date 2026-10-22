package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.util.Base64;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.ee.plugin.common.ttreader.ITTReaderViewWrapper;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadAsyncTask;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class b extends PthreadAsyncTask<Void, Void, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f461606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f461607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f461608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f461609d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f461610e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private OAuthListener f461611f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private c f461612g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OAuthErrCode f461613a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f461614b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f461615c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f461616d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte[] f461617e;

        private a() {
        }

        public static a a(byte[] r100) {
            a r101 = new a();
            if (r100 != null) goto L5;
        L39:
            Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, buf is null");
            OAuthErrCode r102 = OAuthErrCode.WechatAuth_Err_NetworkErr;
        L35:
            r101.f461613a = r102;
            return r101;
        L5:
            if (r100.length == 0) goto L39;
            JSONObject r103 = new JSONObject(new String(r100, XML.CHARSET_UTF8));     // Catch: Exception -> L32
            int r104 = JSONObjectProtectorUtils.getInt(r103, "errcode");     // Catch: Exception -> L32
            if (r104 != 0) goto L12;
            String r105 = JSONObjectProtectorUtils.getString(JSONObjectProtectorUtils.getJSONObject(r103, "qrcode"), "qrcodebase64");     // Catch: Exception -> L32
            if (r105 != null) goto L17;
        L30:
            Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBase64 is null");     // Catch: Exception -> L32
            r101.f461613a = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;     // Catch: Exception -> L32
            return r101;
        L17:
            if (r105.length() == 0) goto L30;
            byte[] r106 = Base64.decode(r105, 0);     // Catch: Exception -> L32
            if (r106 != null) goto L22;
        L28:
            Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBuf is null");     // Catch: Exception -> L32
            r101.f461613a = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;     // Catch: Exception -> L32
            return r101;
        L22:
            if (r106.length == 0) goto L28;
            r101.f461613a = OAuthErrCode.WechatAuth_Err_OK;     // Catch: Exception -> L32
            r101.f461617e = r106;     // Catch: Exception -> L32
            r101.f461614b = JSONObjectProtectorUtils.getString(r103, ST.UUID_DEVICE);     // Catch: Exception -> L32
            String r107 = JSONObjectProtectorUtils.getString(r103, "appname");     // Catch: Exception -> L32
            r101.f461615c = r107;     // Catch: Exception -> L32
            Log.d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", new Object[]{r101.f461614b, r107, Integer.valueOf(r101.f461617e.length)}));     // Catch: Exception -> L32
            return r101;
        L12:
            Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("resp errcode = %d", new Object[]{Integer.valueOf(r104)}));     // Catch: Exception -> L32
            r101.f461613a = OAuthErrCode.WechatAuth_Err_NormalErr;     // Catch: Exception -> L32
            r103.optString(ITTReaderViewWrapper.ERROR_MSG_KEY);     // Catch: Exception -> L32
            return r101;
        L32:
            e = move-exception;
            String r108 = String.format("parse json fail, ex = %s", new Object[]{e.getMessage()});
        L34:
            Log.e("MicroMsg.SDK.GetQRCodeResult", r108);
            r102 = OAuthErrCode.WechatAuth_Err_NormalErr;
        L37:
            e = move-exception;
            r108 = String.format("parse fail, build String fail, ex = %s", new Object[]{e.getMessage()});
            goto L34
        }
    }

    public b(String r100, String r101, String r102, String r103, String r104, OAuthListener r105) {
        this.f461606a = r100;
        this.f461607b = r101;
        this.f461608c = r102;
        this.f461609d = r103;
        this.f461610e = r104;
        this.f461611f = r105;
    }

    public boolean a() {
        Log.i("MicroMsg.SDK.GetQRCodeTask", "cancelTask");
        c r100 = this.f461612g;
        if (r100 != null) goto L7;
        return cancel(true);
    L7:
        return r100.cancel(true);
    }

    @Override // android.os.AsyncTask
    public Object doInBackground(Object[] r110) {
        Void[] r111 = (Void[]) r110;
        ThreadMethodProxy.setName(ThreadMethodProxy.currentThread(), "OpenSdkGetQRCodeTask");
        Log.i("MicroMsg.SDK.GetQRCodeTask", "doInBackground");
        String r112 = String.format("https://open.weixin.qq.com/connect/sdk/qrconnect?appid=%s&noncestr=%s&timestamp=%s&scope=%s&signature=%s", new Object[]{this.f461606a, this.f461608c, this.f461609d, this.f461607b, this.f461610e});
        long r100 = System.currentTimeMillis();
        byte[] r101 = com.tencent.mm.opensdk.channel.a.a.a(r112, 60000);
        Log.d("MicroMsg.SDK.GetQRCodeTask", String.format("doInBackground, url = %s, time consumed = %d(ms)", new Object[]{r112, Long.valueOf(System.currentTimeMillis() - r100)}));
        return a.a(r101);
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Object r100) {
        a r101 = (a) r100;
        OAuthErrCode r102 = r101.f461613a;
        if (r102 != OAuthErrCode.WechatAuth_Err_OK) goto L5;
        Log.d("MicroMsg.SDK.GetQRCodeTask", "onPostExecute, get qrcode success imgBufSize = " + r101.f461617e.length);
        this.f461611f.onAuthGotQrcode(r101.f461616d, r101.f461617e);
        c r103 = new c(r101.f461614b, this.f461611f);
        this.f461612g = r103;
        r103.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return;
    L5:
        Log.e("MicroMsg.SDK.GetQRCodeTask", String.format("onPostExecute, get qrcode fail, OAuthErrCode = %s", new Object[]{r102}));
        this.f461611f.onAuthFinish(r101.f461613a, null);
    }
}
