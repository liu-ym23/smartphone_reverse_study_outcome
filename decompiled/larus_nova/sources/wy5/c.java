package wy5;

import android.text.TextUtils;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.downloadlib.constants.EventConstants;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f561876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f561877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f561878c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L12;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f561876a, r101.f561876a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f561877b, r101.f561877b) == true) goto L10;
        return false;
    L10:
        if (this.f561878c == r101.f561878c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f561876a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f561877b;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        long r106 = this.f561878c;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "HttpRequestInfo(url=" + this.f561876a + ", cdnDomain=" + this.f561877b + ", packageSize=" + this.f561878c + ")";
    }

    public final void a() {
        JSONObject r100 = new JSONObject();
        if (TextUtils.isEmpty(null) == true) goto L6;
        r100.put("tt_trace_tag_id", null);
    L6:
        if (TextUtils.isEmpty(null) == true) goto L9;
        r100.put("x_response_cache", null);
    L9:
        if (TextUtils.isEmpty(null) == true) goto L12;
        r100.put("client_ip", null);
    L12:
        if (TextUtils.isEmpty(null) == true) goto L15;
        r100.put("client_ip_version", null);
    L15:
        if (TextUtils.isEmpty(null) == true) goto L17;
        r100.put("server_ip", null);
    L17:
        r100.put(BdpAppEventConstant.HTTP_STATUS, 0);
        r100.put("error_code", 0);
        r100.put("timing_dns", 0);
        r100.put("timing_connect", 0);
        r100.put("timing_send", 0);
        r100.put("timing_ssl", 0);
        r100.put("timing_wait", 0);
        r100.put("timing_proxy", 0);
        r100.put("timing_receive", 0);
        if (TextUtils.isEmpty(null) == true) goto L20;
        r100.put("timing_isSocketReused", null);
    L20:
        r100.put("timing_total", 0);
        if (TextUtils.isEmpty(null) == true) goto L23;
        r100.put("access", null);
    L23:
        r100.put("download_duration", 0);
        r100.put("cdn_domain", this.f561877b);
        r100.put(EventConstants.ExtraJson.PACKAGE_SIZE, this.f561878c);
        r100.put("url", this.f561876a);
        y86.a.c("geckosdk_cdn_stats", r100);
    }

    public c(String r100, String r101, long r102) {
        this.f561876a = r100;
        this.f561877b = r101;
        this.f561878c = r102;
    }
}
