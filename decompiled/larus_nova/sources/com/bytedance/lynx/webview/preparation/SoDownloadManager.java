package com.bytedance.lynx.webview.preparation;

import com.bytedance.lynx.webview.internal.r;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class SoDownloadManager {

    public static final enum DownloadError extends Enum<DownloadError> {
        public static final DownloadError APP_DOWNLOAD_HANDLER_EXCEPTION = null;
        public static final DownloadError APP_DOWNLOAD_HANDLER_FAILED = null;
        public static final DownloadError CDN_CONTROL_LIMITED = null;
        public static final DownloadError NO_DOWNLOAD_ENV = null;
        public static final DownloadError SDK_DOWNLOAD_HANDLER_EXCEPTION = null;
        public static final DownloadError SDK_DOWNLOAD_HANDLER_FAILED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DownloadError[] f265405a = null;
        private final String description;

        static {
            DownloadError r100 = new DownloadError("CDN_CONTROL_LIMITED", 0, "CDN control.");
            CDN_CONTROL_LIMITED = r100;
            DownloadError r101 = new DownloadError("NO_DOWNLOAD_ENV", 1, "no download env.");
            NO_DOWNLOAD_ENV = r101;
            DownloadError r102 = new DownloadError("APP_DOWNLOAD_HANDLER_FAILED", 2, "app download failed.");
            APP_DOWNLOAD_HANDLER_FAILED = r102;
            DownloadError r103 = new DownloadError("APP_DOWNLOAD_HANDLER_EXCEPTION", 3, "app download exception.");
            APP_DOWNLOAD_HANDLER_EXCEPTION = r103;
            DownloadError r104 = new DownloadError("SDK_DOWNLOAD_HANDLER_FAILED", 4, "sdk download failed.");
            SDK_DOWNLOAD_HANDLER_FAILED = r104;
            DownloadError r105 = new DownloadError("SDK_DOWNLOAD_HANDLER_EXCEPTION", 5, "sdk download exception.");
            SDK_DOWNLOAD_HANDLER_EXCEPTION = r105;
            f265405a = new DownloadError[]{r100, r101, r102, r103, r104, r105};
        }

        public static DownloadError[] values() {
            return (DownloadError[]) f265405a.clone();
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Download: " + this.description;
        }

        public static DownloadError valueOf(String r100) {
            return (DownloadError) r27.a.a(DownloadError.class, r100);
        }

        public DownloadError(String r100, int r101, String r102) {
            super(r100, r101);
            this.description = r102;
        }
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection a(URL r100) throws IOException {
        String r101 = r100.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r102 = r100.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (com.obric.assistant.network.okhttp.a.c(r101, r102) == false) goto L11;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r101 + " path=" + r102);     // Catch: Throwable -> L8 IOException -> L12
        com.obric.assistant.network.okhttp.a.b(GlobalNetworkGate.a(r101, r102), r101, r102);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r100);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return r100.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.f375446a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }

    public static boolean b(InputStream r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();     // Catch: Exception -> L17
        byte[] r102 = new byte[1024];     // Catch: Exception -> L17
    L4:
        int r103 = r100.read(r102);     // Catch: Exception -> L17
        if (r103 == (-1)) goto L7;
        r101.write(r102, 0, r103);     // Catch: Exception -> L17
        goto L4
    L7:
        JSONObject r104 = new JSONObject(r101.toString("UTF-8"));     // Catch: Exception -> L17
        if (r104.has("BaseResp") == true) goto L11;
        r.b("[Download] isDownloadAllowed: BaseResp field not found in response");     // Catch: Exception -> L17
        return false;
    L11:
        JSONObject r105 = JSONObjectProtectorUtils.getJSONObject(r104, "BaseResp");     // Catch: Exception -> L17
        int r106 = r105.optInt("StatusCode", -1);     // Catch: Exception -> L17
        if (r106 != 0) goto L15;
        return true;
    L15:
        r.b("[Download] Download check permit failed due to: " + r105.optString("StatusMessage", "unknown") + ", statusCode: " + r106);     // Catch: Exception -> L17
        return false;
    L17:
        e = move-exception;
        r.b("[Download] isDownloadAllowed parse response failed: " + e);
        return false;
    }
}
