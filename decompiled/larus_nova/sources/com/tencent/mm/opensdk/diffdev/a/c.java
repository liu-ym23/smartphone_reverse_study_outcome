package com.tencent.mm.opensdk.diffdev.a;

import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadAsyncTask;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
class c extends PthreadAsyncTask<Void, Void, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f461618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f461619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private OAuthListener f461620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f461621d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OAuthErrCode f461622a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f461623b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f461624c;

        public a() {
        }
    }

    public c(String r100, OAuthListener r101) {
        this.f461618a = r100;
        this.f461620c = r101;
        this.f461619b = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", new Object[]{r100});
    }

    @Override // android.os.AsyncTask
    public Object doInBackground(Object[] r110) {
        Void[] r111 = (Void[]) r110;
        ThreadMethodProxy.setName(ThreadMethodProxy.currentThread(), "OpenSdkNoopingTask");
        String r112 = this.f461618a;
        if (r112 != null) goto L5;
    L59:
        Log.e("MicroMsg.SDK.NoopingTask", "run fail, uuid is null");
        a r100 = new a();
    L60:
        OAuthErrCode r113 = OAuthErrCode.WechatAuth_Err_NormalErr;
    L61:
        r100.f461622a = r113;
    L62:
        return r100;
    L5:
        if (r112.length() == 0) goto L59;
        Log.i("MicroMsg.SDK.NoopingTask", "doInBackground start " + isCancelled());
    L9:
        if (isCancelled() == true) goto L58;
        StringBuilder r114 = new StringBuilder();
        r114.append(this.f461619b);
        if (this.f461621d != 0) goto L13;
        String r101 = "";
    L14:
        r114.append(r101);
        String r115 = r114.toString();
        long r102 = System.currentTimeMillis();
        byte[] r103 = com.tencent.mm.opensdk.channel.a.a.a(r115, 60000);
        long r104 = System.currentTimeMillis();
        r100 = new a();
        Log.d("MicroMsg.SDK.NoopingResult", "star parse NoopingResult");
        if (r103 != null) goto L17;
    L40:
        Log.e("MicroMsg.SDK.NoopingResult", "parse fail, buf is null");
        OAuthErrCode r105 = OAuthErrCode.WechatAuth_Err_NetworkErr;
    L41:
        r100.f461622a = r105;
    L42:
        Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", new Object[]{r115, r100.f461622a.toString(), Integer.valueOf(r100.f461624c), Long.valueOf(r104 - r102)}));
        OAuthErrCode r116 = r100.f461622a;
        if (r116 != OAuthErrCode.WechatAuth_Err_OK) goto L57;
        int r117 = r100.f461624c;
        this.f461621d = r117;
        if (r117 == d.f461627d.a()) goto L46;
        if (r100.f461624c == d.f461629f.a()) goto L9;
        if (r100.f461624c != d.f461628e.a()) goto L9;
        String r118 = r100.f461623b;
        if (r118 != null) goto L55;
    L56:
        Log.e("MicroMsg.SDK.NoopingTask", "nooping fail, confirm with an empty code!!!");
        goto L60
    L55:
        if (r118.length() != 0) goto L62;
    L46:
        this.f461620c.onQrcodeScanned();
        goto L9
    L57:
        Log.e("MicroMsg.SDK.NoopingTask", String.format("nooping fail, errCode = %s, uuidStatusCode = %d", new Object[]{r116.toString(), Integer.valueOf(r100.f461624c)}));
        goto L62
    L17:
        if (r103.length == 0) goto L40;
        JSONObject r106 = new JSONObject(new String(r103, XML.CHARSET_UTF8));     // Catch: Exception -> L35
        int r119 = JSONObjectProtectorUtils.getInt(r106, "wx_errcode");     // Catch: Exception -> L35
        r100.f461624c = r119;     // Catch: Exception -> L35
        Log.d("MicroMsg.SDK.NoopingResult", String.format("nooping uuidStatusCode = %d", new Object[]{Integer.valueOf(r119)}));     // Catch: Exception -> L35
        int r120 = r100.f461624c;     // Catch: Exception -> L35
        if (r120 != 408) goto L25;
    L32:
        OAuthErrCode r107 = OAuthErrCode.WechatAuth_Err_OK;     // Catch: Exception -> L35
    L33:
        r100.f461622a = r107;     // Catch: Exception -> L35
        goto L42
    L25:
        if (r120 == 500) goto L31;
        switch(r120) {
            case 402: goto L30;
            case 403: goto L29;
            case 404: goto L32;
            case 405: goto L28;
            default: goto L31;
        };     // Catch: Exception -> L35
    L28:
        r100.f461622a = OAuthErrCode.WechatAuth_Err_OK;     // Catch: Exception -> L35
        r100.f461623b = JSONObjectProtectorUtils.getString(r106, "wx_code");     // Catch: Exception -> L35
        goto L42
    L29:
        r107 = OAuthErrCode.WechatAuth_Err_Cancel;     // Catch: Exception -> L35
        goto L33
    L30:
        r107 = OAuthErrCode.WechatAuth_Err_Timeout;     // Catch: Exception -> L35
    L31:
        r107 = OAuthErrCode.WechatAuth_Err_NormalErr;     // Catch: Exception -> L35
    L35:
        e = move-exception;
        String r108 = String.format("parse json fail, ex = %s", new Object[]{e.getMessage()});
    L39:
        Log.e("MicroMsg.SDK.NoopingResult", r108);
        r105 = OAuthErrCode.WechatAuth_Err_NormalErr;
    L37:
        e = move-exception;
        r108 = String.format("parse fail, build String fail, ex = %s", new Object[]{e.getMessage()});
        goto L39
    L13:
        r101 = "&last=" + this.f461621d;
        goto L14
    L58:
        Log.i("MicroMsg.SDK.NoopingTask", "IDiffDevOAuth.stopAuth / detach invoked");
        r100 = new a();
        r113 = OAuthErrCode.WechatAuth_Err_Auth_Stopped;
        goto L61
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Object r100) {
        a r101 = (a) r100;
        this.f461620c.onAuthFinish(r101.f461622a, r101.f461623b);
    }
}
