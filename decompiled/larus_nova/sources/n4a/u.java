package n4a;

import android.content.Context;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class u extends a5 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public JSONObject f517765k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Context f517766l;

    public u() {
        this.f517765k = null;
        this.f517766l = null;
    }

    @Override // com.loc.bo
    public final Map<String, String> h() {
        return null;
    }

    @Override // com.loc.bo
    public final byte[] i() {
        StringBuffer r100 = new StringBuffer();     // Catch: Throwable -> L11
        JSONObject r101 = this.f517765k;     // Catch: Throwable -> L11
        if (r101 == null) goto L9;
        Iterator<String> r102 = r101.keys();     // Catch: Throwable -> L11
    L7:
        if (r102.hasNext() == false) goto L9;
        String r103 = r102.next();     // Catch: Throwable -> L11
        r100.append(r103 + ContainerUtils.KEY_VALUE_DELIMITER + URLEncoder.encode(this.f517765k.get(r103).toString(), XML.CHARSET_UTF8) + "&");     // Catch: Throwable -> L11
    L9:
        r100.append("output=json");     // Catch: Throwable -> L11
        String r104 = v4.g(this.f517766l);     // Catch: Throwable -> L11
        r100.append("&key=".concat(String.valueOf(r104)));     // Catch: Throwable -> L11
        String r105 = w4.a();     // Catch: Throwable -> L11
        r100.append("&ts=".concat(String.valueOf(r105)));     // Catch: Throwable -> L11
        r100.append("&scode=" + w4.b(this.f517766l, r105, "key=".concat(String.valueOf(r104))));     // Catch: Throwable -> L11
        return r100.toString().getBytes(XML.CHARSET_UTF8);
    L11:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    @Override // com.loc.bo
    public final String k() {
        return "core";
    }

    @Override // com.loc.bo
    public final Map<String, String> a() {
        HashMap r100 = new HashMap();
        r100.put("Content-Type", "application/x-www-form-urlencoded");
        r100.put("Accept-Encoding", DownloadHelper.GZIP);
        r100.put("User-Agent", "AMAP SDK Android core 4.3.14");
        String r101 = y4.d(w4.e(w4.d(this.f517766l, false, false)));     // Catch: Throwable -> L5
    L7:
        r100.put("X-INFO", r101);
        r100.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", new Object[]{"4.3.14", "core"}));
        r100.put("logversion", "2.1");
        return r100;
    L5:
        th = move-exception;
        n.a(th, "CI", "gCXi");
        r101 = null;
        goto L7
    }

    @Override // com.loc.bo
    public final String c() {
        if (z4.a.f517980a.b() == false) goto L6;
        return "https://restsdk.amap.com/sdk/compliance/params";
    L6:
        return "http://restsdk.amap.com/sdk/compliance/params";
    }
}
