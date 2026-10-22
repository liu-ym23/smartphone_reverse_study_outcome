package com.ss.android.downloadlib.utils;

import android.text.TextUtils;
import com.ss.android.download.api.model.AppInfo;
import com.ss.android.download.api.runtime.IAdLogProvider;
import com.ss.android.download.api.runtime.IAdUserInfoProvider;
import com.ss.android.downloadlib.DownloadAdRuntimeInitializer;
import com.ss.android.downloadlib.addownload.DownloadAdRuntimeProvider;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import com.vivo.push.PushClientConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J>\u0010\u0018\u001a\u00020\u00042\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001d\u001a\u00020\u0016H\u0002J\u001e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004J\u001e\u0010 \u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004J&\u0010!\u001a\u00020\u001f2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001c\u001a\u00020\u0004J(\u0010\"\u001a\u00020\u001f2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004J\u000e\u0010#\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u0004J\u000e\u0010$\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u0004J\b\u0010%\u001a\u00020\u001fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006&"}, d2 = {"Lcom/ss/android/downloadlib/utils/TTDownloaderLogger;", "", "()V", "CHANNEL_LOCAL_TEST", "", "MSG_HEADER_TTDOWNLOADER_LOGGER_FROM_APP", "MSG_HEADER_TTDOWNLOADER_LOGGER_WITH_CLASS", "MSG_HEADER_TTDOWNLOADER_LOGGER_WITH_CLASS_AND_METHOD", "TAG", "adLogProvider", "Lcom/ss/android/download/api/runtime/IAdLogProvider;", "getAdLogProvider", "()Lcom/ss/android/download/api/runtime/IAdLogProvider;", "setAdLogProvider", "(Lcom/ss/android/download/api/runtime/IAdLogProvider;)V", "appInfo", "Lcom/ss/android/download/api/model/AppInfo;", "getAppInfo", "()Lcom/ss/android/download/api/model/AppInfo;", "setAppInfo", "(Lcom/ss/android/download/api/model/AppInfo;)V", "enableSendAlog", "", "enableSendLog", "generateInnerLog", PushClientConstants.TAG_CLASS_NAME, "functionName", "appName", "msg", "inSDK", "innerAlogD", "", "innerAlogE", "innerLogD", "innerLogE", "logD", "logE", "setBasicProvider", "download-impl_release"}, k = 1, mv = {1, 1, 16})
public final class TTDownloaderLogger {
    public static final String CHANNEL_LOCAL_TEST = "local_test";
    public static final TTDownloaderLogger INSTANCE = null;
    public static final String MSG_HEADER_TTDOWNLOADER_LOGGER_FROM_APP = "app:%s";
    public static final String MSG_HEADER_TTDOWNLOADER_LOGGER_WITH_CLASS = "sdk:%s:";
    public static final String MSG_HEADER_TTDOWNLOADER_LOGGER_WITH_CLASS_AND_METHOD = "sdk:%s.%s:";
    public static final String TAG = "[TTDownloaderLogger]";
    private static IAdLogProvider adLogProvider;
    private static AppInfo appInfo;

    private TTDownloaderLogger() {
    }

    static {
        INSTANCE = new TTDownloaderLogger();
    }

    private final boolean enableSendAlog() {
        if (adLogProvider == null) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean enableSendLog() {
        String r100 = null;
        if (DownloadAdRuntimeInitializer.INSTANCE.getInitialized().get() == false) goto L8;
        AppInfo r101 = appInfo;
        if (r101 == null) goto L13;
        r100 = r101.getChannel();
    L13:
        return TextUtils.equals(r100, "local_test");
    L8:
        AppInfo r102 = GlobalInfo.getAppInfo();
        if (r102 == null) goto L12;
        r100 = r102.getChannel();
    L12:
        return TextUtils.equals(r100, "local_test");
    }

    private final void setBasicProvider() {
        AppInfo r100 = null;
        if (adLogProvider != null) goto L6;
        adLogProvider = (IAdLogProvider) DownloadAdRuntimeProvider.getInnerService$default(IAdLogProvider.class, null, 2, null);
    L6:
        if (appInfo != null) goto L12;
        IAdUserInfoProvider r101 = (IAdUserInfoProvider) DownloadAdRuntimeProvider.getInnerService$default(IAdUserInfoProvider.class, null, 2, null);
        if (r101 == null) goto L10;
        r100 = r101.getAppUserInfo();
    L10:
        appInfo = r100;
        return;
    }

    public final IAdLogProvider getAdLogProvider() {
        return adLogProvider;
    }

    public final AppInfo getAppInfo() {
        return appInfo;
    }

    public final void logD(String r110) {
        setBasicProvider();
        if (enableSendLog() == true) goto L5;
        return;
    L5:
        AppInfo r100 = appInfo;
        if (r100 == null) goto L8;
        String r101 = r100.getAppName();
    L9:
        String r111 = generateInnerLog$default(this, null, null, r101, r110, false, 3, null);
        IAdLogProvider r102 = adLogProvider;
        if (r102 == null) goto L13;
        r102.onSendLog(r111, 3);
        return;
    L13:
        return;
    L8:
        r101 = null;
        goto L9
    }

    public final void logE(String r110) {
        setBasicProvider();
        if (enableSendLog() == true) goto L5;
        return;
    L5:
        AppInfo r100 = appInfo;
        if (r100 == null) goto L8;
        String r101 = r100.getAppName();
    L9:
        String r111 = generateInnerLog$default(this, null, null, r101, r110, false, 3, null);
        IAdLogProvider r102 = adLogProvider;
        if (r102 == null) goto L13;
        r102.onSendLog(r111, 6);
        return;
    L13:
        return;
    L8:
        r101 = null;
        goto L9
    }

    public final void setAdLogProvider(IAdLogProvider r100) {
        adLogProvider = r100;
    }

    public final void setAppInfo(AppInfo r100) {
        appInfo = r100;
    }

    public final void innerAlogD(String r110, String r111, String r112) {
        setBasicProvider();
        if (enableSendAlog() == true) goto L5;
        return;
    L5:
        String r113 = generateInnerLog$default(this, r110, r111, null, r112, true, 4, null);
        IAdLogProvider r114 = adLogProvider;
        if (r114 == null) goto L9;
        r114.d(TAG, r113);
        return;
    }

    public final void innerAlogE(String r110, String r111, String r112) {
        setBasicProvider();
        if (enableSendAlog() == true) goto L5;
        return;
    L5:
        String r113 = generateInnerLog$default(this, r110, r111, null, r112, true, 4, null);
        IAdLogProvider r114 = adLogProvider;
        if (r114 == null) goto L9;
        r114.e(TAG, r113, null);
        return;
    }

    public final void innerLogD(String r100, String r101, String r110) {
        setBasicProvider();
        if (enableSendLog() == true) goto L5;
        return;
    L5:
        String r102 = generateInnerLog(r100, r101, null, r110, true);
        IAdLogProvider r103 = adLogProvider;
        if (r103 == null) goto L9;
        r103.onSendLog(r102, 3);
        return;
    }

    public final void innerLogE(String r100, String r101, String r110) {
        setBasicProvider();
        if (enableSendLog() == true) goto L5;
        return;
    L5:
        String r102 = generateInnerLog(r100, r101, null, r110, true);
        IAdLogProvider r103 = adLogProvider;
        if (r103 == null) goto L9;
        r103.onSendLog(r102, 6);
        return;
    }

    private final String generateInnerLog(String r100, String r101, String r102, String r103, boolean r104) {
        String r105 = "";
        if (r104 == false) goto L36;
        if (r100 != null) goto L6;
    L9:
        boolean r106 = true;
    L10:
        if (r106 == true) goto L19;
        if (r101 != null) goto L13;
    L16:
        boolean r107 = true;
    L17:
        if (r107 == true) goto L19;
        StringCompanionObject r108 = StringCompanionObject.INSTANCE;
        r105 = String.format(MSG_HEADER_TTDOWNLOADER_LOGGER_WITH_CLASS_AND_METHOD, Arrays.copyOf(new Object[]{r100, r101}, 2));
    L35:
        return r105 + r103;
    L13:
        if (r101.length() == 0) goto L16;
        r107 = false;
    L19:
        if (r100 != null) goto L21;
    L24:
        boolean r109 = true;
    L25:
        if (r109 == true) goto L35;
        if (r101 != null) goto L28;
    L31:
        boolean r110 = true;
    L32:
        if (r110 == false) goto L35;
        StringCompanionObject r111 = StringCompanionObject.INSTANCE;
        r105 = String.format(MSG_HEADER_TTDOWNLOADER_LOGGER_WITH_CLASS, Arrays.copyOf(new Object[]{r100}, 1));
        goto L35
    L28:
        if (r101.length() == 0) goto L31;
        r110 = false;
        goto L32
    L21:
        if (r100.length() == 0) goto L24;
        r109 = false;
        goto L25
    L6:
        if (r100.length() == 0) goto L9;
        r106 = false;
        goto L10
    L36:
        if (r102 != null) goto L38;
    L41:
        boolean r112 = true;
    L42:
        if (r112 == true) goto L45;
        StringCompanionObject r113 = StringCompanionObject.INSTANCE;
        r105 = String.format(MSG_HEADER_TTDOWNLOADER_LOGGER_FROM_APP, Arrays.copyOf(new Object[]{r102}, 1));
    L45:
        return r105 + r103;
    L38:
        if (r102.length() == 0) goto L41;
        r112 = false;
        goto L42
    }

    public static /* synthetic */ void innerLogD$default(TTDownloaderLogger r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 2) == 0) goto L8;
        r102 = null;
    L8:
        r100.innerLogD(r101, r102, r103);
    }

    public static /* synthetic */ void innerLogE$default(TTDownloaderLogger r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 2) == 0) goto L8;
        r102 = null;
    L8:
        r100.innerLogE(r101, r102, r103);
    }

    public static /* synthetic */ String generateInnerLog$default(TTDownloaderLogger r100, String r101, String r102, String r110, String r111, boolean r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L5;
        String r103 = null;
    L7:
        if ((r113 & 2) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r113 & 4) == 0) goto L13;
        String r105 = null;
    L15:
        return r100.generateInnerLog(r103, r104, r105, r111, r112);
    L13:
        r105 = r110;
        goto L15
    L9:
        r104 = r102;
        goto L11
    L5:
        r103 = r101;
        goto L7
    }
}
