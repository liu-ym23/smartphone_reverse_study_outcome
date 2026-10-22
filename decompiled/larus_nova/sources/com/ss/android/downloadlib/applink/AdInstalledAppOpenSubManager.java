package com.ss.android.downloadlib.applink;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.downloadlib.addownload.DownloadInsideHelper;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import com.ss.android.downloadlib.addownload.model.OpenAppResult;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.exception.TTDownloaderMonitor;
import com.ss.android.downloadlib.utils.TTDownloaderLogger;
import com.ss.android.downloadlib.utils.ToolUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class AdInstalledAppOpenSubManager {
    private static final String TAG = null;

    /* JADX INFO: renamed from: com.ss.android.downloadlib.applink.AdInstalledAppOpenSubManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class SingleTonHolder {
        private static AdInstalledAppOpenSubManager INSTANCE;

        private SingleTonHolder() {
        }

        static {
            INSTANCE = new AdInstalledAppOpenSubManager(null);
        }

        public static /* synthetic */ AdInstalledAppOpenSubManager access$100() {
            return INSTANCE;
        }
    }

    static {
        TAG = "AdInstalledAppOpenSubManager";
    }

    public static AdInstalledAppOpenSubManager getInstance() {
        return SingleTonHolder.access$100();
    }

    private AdInstalledAppOpenSubManager() {
    }

    public /* synthetic */ AdInstalledAppOpenSubManager(AnonymousClass1 r100) {
        this();
    }

    public boolean tryAppLink(NativeDownloadModel r110, Context r111) {
        DeepLink r100 = r110.getModel().getDeepLink();
        if (r100 != null) goto L5;
        String r101 = null;
    L6:
        String r102 = r101;
        JSONObject r103 = new JSONObject();
        AdInstalledAppOpenProcessor r104 = new AdInstalledAppOpenProcessor();
        r104.beforeHandleAppLink(r103, r110, EventConstants.AppLinkSource.CLICK_BY_SDK);
        if (TextUtils.isEmpty(r102) == true) goto L11;
        return handleAppLinkByUrl(r104, r110, r102, r103, r111, 1);
    L11:
        return handleAppLinkByPackage(r104, r110, r110.getPackageName(), r103, r111, 1);
    L5:
        r101 = r100.getOpenUrl();
        goto L6
    }

    public OpenAppResult tryOpenByPackage(Context r100, String r101) {
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "tryOpenByPackage", "执行外部接口的包名调起逻辑");
        AdInstalledAppOpenProcessor r102 = new AdInstalledAppOpenProcessor();
        if (TextUtils.isEmpty(r101) == true) goto L5;
        if (r100 != null) goto L8;
        r100 = GlobalInfo.getContext();
    L8:
        JSONObject r103 = new JSONObject();
        ToolUtils.safePut(r103, EventConstants.ExtraJson.TTDOWNLOADER, 1);
        ToolUtils.safePut(r103, "applink_source", EventConstants.AppLinkSource.BY_PACKAGE_OUTSIDE);
        return r102.tryOpenByPackage(r101, r100, r103);
    L5:
        return new OpenAppResult(4, 11);
    }

    public OpenAppResult tryOpenByUrl(Context r100, String r101) {
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "tryOpenByPackage", "执行外部接口的url调起逻辑");
        AdInstalledAppOpenProcessor r102 = new AdInstalledAppOpenProcessor();
        if (TextUtils.isEmpty(r101) == true) goto L5;
        if (r100 != null) goto L8;
        r100 = GlobalInfo.getContext();
    L8:
        Uri r103 = UriProtector.parse(r101);
        if (MarketUriUtils.isMarketUri(r103) == false) goto L11;
        r103 = ToolUtils.jointIgnoreInterceptInMarketScheme(UriProtector.parse(r101));
    L11:
        JSONObject r104 = new JSONObject();
        ToolUtils.safePut(r104, EventConstants.ExtraJson.TTDOWNLOADER, 1);
        ToolUtils.safePut(r104, "applink_source", EventConstants.AppLinkSource.BY_URL_OUTSIDE);
        if (r102.checkOpenUrlValid(r103, r101, r100) == false) goto L16;
        return r102.tryOpenByUrl(r101, r100, r104);
    L16:
        return new OpenAppResult(2, 20);
    L5:
        return new OpenAppResult(2, 21);
    }

    public boolean tryAppLink(NativeDownloadModel r110, int r111, String r112, Context r113) {
        String r100 = r110.getOpenUrl();
        JSONObject r101 = new JSONObject();
        AdInstalledAppOpenProcessor r102 = new AdInstalledAppOpenProcessor();
        if (r111 == 2) goto L19;
        if (r111 != 3) goto L7;
        String r103 = EventConstants.AppLinkSource.DIALOG_CLICK;
    L26:
        r102.beforeHandleAppLink(r101, r110, r103);
        if (TextUtils.isEmpty(r100) == true) goto L31;
        return handleAppLinkByUrl(r102, r110, r100, r101, r113, r111);
    L31:
        return handleAppLinkByPackage(r102, r110, r112, r101, r113, r111);
    L7:
        if (r111 != 4) goto L9;
        r103 = EventConstants.AppLinkSource.AUTO_CLICK;
        goto L26
    L9:
        if (r111 != 5) goto L11;
        r103 = EventConstants.AppLinkSource.AD_COMPLIANCE_CLICK;
        goto L26
    L11:
        if (r111 == 6) goto L14;
        TTDownloaderMonitor.inst().monitorDataError(false, "tryAppLink:appLinkScene的值不符合预期,不执行调起操作");
        return false;
    L14:
        r103 = EventConstants.AppLinkSource.AD_OUT_WEB_CLICK;
        goto L26
    L19:
        if (DownloadInsideHelper.isAllowDeepLink(r110) == true) goto L21;
    L32:
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "tryAppLink", "不符合策略生效的前置条件,不执行自动调起");
        return false;
    L21:
        if (TextUtils.isEmpty(r110.getOpenUrl()) == true) goto L23;
    L25:
        r103 = EventConstants.AppLinkSource.NOTIFY_CLICK;
        goto L26
    L23:
        if (TextUtils.isEmpty(r112) == false) goto L25;
        goto L25
    }

    private boolean handleAppLinkByPackage(AdInstalledAppOpenProcessor r100, NativeDownloadModel r101, String r102, JSONObject r110, Context r111, int r112) {
        OpenAppResult r103 = r100.tryOpenByPackage(r102, r101, r110, r112, r111);
        TTDownloaderLogger r113 = TTDownloaderLogger.INSTANCE;
        String r114 = TAG;
        r113.innerLogD(r114, "handleAppLinkByPackage", "尝试在包名调起场景中发送click埋点");
        boolean r115 = r100.checkSendClickEvent(r101, r112);
        int r104 = r103.getType();
        if (r104 == 3) goto L8;
        boolean r105 = false;
        if (r104 == 4) goto L7;
        TTDownloaderMonitor.inst().monitorDataError(false, "handleAppLinkByPackage:返回的调起结果值存在异常,不拦截点击操作");
    L9:
        if (r105 == false) goto L12;
        if (r115 == true) goto L12;
        r100.backUpSendClickEvent(r101);
    L12:
        return r105;
    L7:
        r113.innerLogD(r114, "handleAppLinkByPackage", "最终调起的结果是失败了,不对点击进行拦截");
        goto L9
    L8:
        r113.innerLogD(r114, "handleAppLinkByPackage", "确实执行了包名调起操作且成功,需要拦截原有的点击行为");
        r105 = true;
        goto L9
    }

    private boolean handleAppLinkByUrl(AdInstalledAppOpenProcessor r100, NativeDownloadModel r101, String r102, JSONObject r110, Context r111, int r112) {
        OpenAppResult r103 = r100.tryOpenByUrl(r102, r101, r110, r112, r111);
        TTDownloaderLogger r113 = TTDownloaderLogger.INSTANCE;
        String r114 = TAG;
        r113.innerLogD(r114, "handleAppLinkByUrl", "尝试在url调起场景中发送click埋点");
        boolean r115 = r100.checkSendClickEvent(r101, r112);
        int r104 = r103.getType();
        boolean r105 = true;
        if (r104 != 1) goto L5;
        r113.innerLogD(r114, "handleAppLinkByUrl", "确实执行了url调起操作且成功,需要拦截原有的点击行为");
    L12:
        if (r105 == false) goto L15;
        if (r115 == true) goto L15;
        r100.backUpSendClickEvent(r101);
    L15:
        return r105;
    L5:
        if (r104 != 2) goto L7;
    L9:
        r113.innerLogD(r114, "handleAppLinkByUrl", "最终调起的结果是失败了,不对点击进行拦截");
    L10:
        r105 = false;
        goto L12
    L7:
        if (r104 == 4) goto L9;
        TTDownloaderMonitor.inst().monitorDataError(false, "handleAppLinkByUrl:返回的调起结果值存在异常,不拦截点击操作");
        goto L10
    }
}
