package com.bytedance.caijing.sdk.infra.base.api.gecko;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.android.ttcjpaysdk.base.service.IUpdateConfig;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Metadata;
import wd4.b;
import wd4.c;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J&\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H&J0\u0010\n\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004H&J$\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H&J\"\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH&JN\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u0004H&J\u0018\u0010\"\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH&J \u0010$\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H&JR\u0010-\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020)0&2\u0006\u0010,\u001a\u00020+H&J(\u00102\u001a\u0004\u0018\u00010\u00112\b\u0010.\u001a\u0004\u0018\u00010\u001b2\b\u00100\u001a\u0004\u0018\u00010/2\b\u00101\u001a\u0004\u0018\u00010\u0004H&J\"\u00104\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u00103\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\"\u00105\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u00103\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J4\u00106\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u00103\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004H&J\u001c\u00109\u001a\u00020!2\u0006\u00107\u001a\u00020\u00042\n\b\u0002\u0010 \u001a\u0004\u0018\u000108H&J\u0018\u0010:\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&¨\u0006;"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/gecko/GeckoService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "Ljava/io/File;", "file", "", "accessKey", "channel", "", "checkExist", "fileName", "checkExistFile", "", "getLatestChannelVersion", DBDefinition.MIME_TYPE, "encode", "Ljava/io/InputStream;", "inputStream", "Landroid/webkit/WebResourceResponse;", "getWebResourceResponse", "appId", a.KEY_DID, "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "host", "version", "resRootDir", "group", "", "initGeckoClient", "Lcom/android/ttcjpaysdk/base/service/IUpdateConfig;", "updateConfig", "Lwd4/c;", "listener", "", "forceUpdateChannel", "path", "initGeckoRegister", "deviceId", "", "Ljava/util/regex/Pattern;", "cachePrefix", "Landroid/net/Uri;", "cacheDir", "Lwd4/b;", "intercept", "initFalcon", "falconWebOffline", "Landroid/webkit/WebView;", "webView", "url", "shouldInterceptRequest", "rootDir", "getChannelVersion", "checkChannelUseful", "getFileFromGecko", "tag", "Lwd4/a;", "updateGeckoByConfig", "cleanCache", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface GeckoService extends ICJService {
    boolean checkChannelUseful(String r100, File r101, String r102);

    boolean checkExist(File r100, String r101, String r102);

    boolean checkExistFile(File r100, String r101, String r102, String r103);

    void cleanCache(String r100, String r101);

    void forceUpdateChannel(IUpdateConfig r100, c r101);

    String getChannelVersion(String r100, File r101, String r102);

    InputStream getFileFromGecko(Context r100, File r101, String r102, String r103, String r104);

    long getLatestChannelVersion(File r100, String r101, String r102);

    WebResourceResponse getWebResourceResponse(String r100, String r101, InputStream r102);

    Object initFalcon(Context r100, String r101, String r102, String r103, List<Pattern> r104, List<? extends Uri> r105, b r106);

    Object initGeckoClient(long r100, String r101, Context r102, String r103, String r104, String r105, File r106, String r107);

    void initGeckoRegister(String r100, String r101, String r102);

    WebResourceResponse shouldInterceptRequest(Object r100, WebView r101, String r102);

    void updateGeckoByConfig(String r100, wd4.a r101);
}
