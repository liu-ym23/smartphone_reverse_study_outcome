package com.tencent.open.web.security;

import android.text.TextUtils;
import android.webkit.WebView;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.tencent.open.log.SLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public class b extends com.tencent.open.b {
    public b() {
    }

    @Override // com.tencent.open.b
    public boolean a(WebView r110, String r111) {
        SLog.i("openSDK_LOG.SecureJsBridge", "-->canHandleUrl---url = " + r111);
        if (r111 != null) goto L6;
        return false;
    L6:
        if (UriProtector.parse(r111).getScheme().equals("jsbridge") == true) goto L8;
        return false;
    L8:
        ArrayList r100 = new ArrayList(Arrays.asList(r111.concat("/#").split(HTTP.URL_DEFAULT)));
        if (r100.size() >= 7) goto L11;
        return false;
    L11:
        String r101 = (String) ListProtector.get(r100, 2);
        String r102 = (String) ListProtector.get(r100, 3);
        String r103 = (String) ListProtector.get(r100, 4);
        String r112 = (String) ListProtector.get(r100, 5);
        SLog.i("openSDK_LOG.SecureJsBridge", "-->canHandleUrl, objectName: " + r101 + " | methodName: " + r102 + " | snStr: " + r103);
        if (TextUtils.isEmpty(r101) == false) goto L14;
    L21:
        return false;
    L14:
        if (TextUtils.isEmpty(r102) == true) goto L21;
        if (TextUtils.isEmpty(r103) == true) goto L21;
        a(r101, r102, r100.subList(6, r100.size() - 1), new c(r110, CastLongProtector.parseLong(r103), r111, r112));
        return true;
    }

    @Override // com.tencent.open.b
    public void a(String r100, String r101, List<String> r102, com.tencent.open.b.a r103) {
        SLog.v("openSDK_LOG.SecureJsBridge", "-->getResult, objectName: " + r100 + " | methodName: " + r101);
        int r104 = r102.size();
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L9;
        ListProtector.set(r102, r105, URLDecoder.decode((String) ListProtector.get(r102, r105), "UTF-8"));     // Catch: UnsupportedEncodingException -> L6
    L8:
        r105 = r105 + 1;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    L9:
        com.tencent.open.b.C5542b r106 = this.f461702a.get(r100);
        if (r106 == null) goto L12;
        SLog.d("openSDK_LOG.SecureJsBridge", "-->handler != null");
        r106.call(r101, r102, r103);
        return;
    L12:
        SLog.e("openSDK_LOG.SecureJsBridge", "-->handler == null objName: " + r100);
        if (r103 == null) goto L22;
        r103.a();
        return;
    }
}
