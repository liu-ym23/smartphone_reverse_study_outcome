package com.ss.android.lark.chameleon.api;

import com.ss.android.lark.chameleon.bridge.NonProguard;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/chameleon/api/LarkAPIName;", "", "Lcom/ss/android/lark/chameleon/bridge/NonProguard;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "LARKAPI_APP_GETLARKLETCONFIG", "LARKAPI_INTERNAL_APPCONFIG_GETKEYS", "LARKAPI_INTERNAL_LOG_LOGNORETURN", "LARKAPI_PASSPORT_GETCURRENTUSERINFO", "LARKAPI_INTERNAL_SLARDAR_SENDEVENTS", "LARKAPI_INTERNAL_SYSTEM_GETSTATUSBARHEIGHT", "LARKAPI_INTERNAL_TEA_TRACKNORETURN", "LARKAPI_INTERNAL_TRANSPORT_CALLRUSTAPI", "LARKAPI_UI_GETAPPTHEMEINFO", "LARKAPI_WEBVIEW_LOADFINISH", "LARKAPI_INTERNAL_WEBVIEW_CLOSE", "LARKAPI_INTERNAL_WIDGET_SHOWCONFIRMDIALOG", "LARKAPI_BIZ_PROFILE_OPENPROFILE", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum LarkAPIName extends Enum<LarkAPIName> implements NonProguard {
    private static final /* synthetic */ LarkAPIName[] $VALUES = null;
    public static final LarkAPIName LARKAPI_APP_GETLARKLETCONFIG = null;
    public static final LarkAPIName LARKAPI_BIZ_PROFILE_OPENPROFILE = null;
    public static final LarkAPIName LARKAPI_INTERNAL_APPCONFIG_GETKEYS = null;
    public static final LarkAPIName LARKAPI_INTERNAL_LOG_LOGNORETURN = null;
    public static final LarkAPIName LARKAPI_INTERNAL_SLARDAR_SENDEVENTS = null;
    public static final LarkAPIName LARKAPI_INTERNAL_SYSTEM_GETSTATUSBARHEIGHT = null;
    public static final LarkAPIName LARKAPI_INTERNAL_TEA_TRACKNORETURN = null;
    public static final LarkAPIName LARKAPI_INTERNAL_TRANSPORT_CALLRUSTAPI = null;
    public static final LarkAPIName LARKAPI_INTERNAL_WEBVIEW_CLOSE = null;
    public static final LarkAPIName LARKAPI_INTERNAL_WIDGET_SHOWCONFIRMDIALOG = null;
    public static final LarkAPIName LARKAPI_PASSPORT_GETCURRENTUSERINFO = null;
    public static final LarkAPIName LARKAPI_UI_GETAPPTHEMEINFO = null;
    public static final LarkAPIName LARKAPI_WEBVIEW_LOADFINISH = null;
    private final String value;

    private static final /* synthetic */ LarkAPIName[] $values() {
        return new LarkAPIName[]{LARKAPI_APP_GETLARKLETCONFIG, LARKAPI_INTERNAL_APPCONFIG_GETKEYS, LARKAPI_INTERNAL_LOG_LOGNORETURN, LARKAPI_PASSPORT_GETCURRENTUSERINFO, LARKAPI_INTERNAL_SLARDAR_SENDEVENTS, LARKAPI_INTERNAL_SYSTEM_GETSTATUSBARHEIGHT, LARKAPI_INTERNAL_TEA_TRACKNORETURN, LARKAPI_INTERNAL_TRANSPORT_CALLRUSTAPI, LARKAPI_UI_GETAPPTHEMEINFO, LARKAPI_WEBVIEW_LOADFINISH, LARKAPI_INTERNAL_WEBVIEW_CLOSE, LARKAPI_INTERNAL_WIDGET_SHOWCONFIRMDIALOG, LARKAPI_BIZ_PROFILE_OPENPROFILE};
    }

    public static LarkAPIName valueOf(String r100) {
        return (LarkAPIName) a.a(LarkAPIName.class, r100);
    }

    public static LarkAPIName[] values() {
        return (LarkAPIName[]) $VALUES.clone();
    }

    static {
        LARKAPI_APP_GETLARKLETCONFIG = new LarkAPIName("LARKAPI_APP_GETLARKLETCONFIG", 0, "LarkAPI.app.getLarkletConfig");
        LARKAPI_INTERNAL_APPCONFIG_GETKEYS = new LarkAPIName("LARKAPI_INTERNAL_APPCONFIG_GETKEYS", 1, "LarkAPI.internal.appConfig.getKeys");
        LARKAPI_INTERNAL_LOG_LOGNORETURN = new LarkAPIName("LARKAPI_INTERNAL_LOG_LOGNORETURN", 2, "LarkAPI.internal.log.logNoReturn");
        LARKAPI_PASSPORT_GETCURRENTUSERINFO = new LarkAPIName("LARKAPI_PASSPORT_GETCURRENTUSERINFO", 3, "LarkAPI.passport.getCurrentUserInfo");
        LARKAPI_INTERNAL_SLARDAR_SENDEVENTS = new LarkAPIName("LARKAPI_INTERNAL_SLARDAR_SENDEVENTS", 4, "LarkAPI.internal.slardar.sendEvents");
        LARKAPI_INTERNAL_SYSTEM_GETSTATUSBARHEIGHT = new LarkAPIName("LARKAPI_INTERNAL_SYSTEM_GETSTATUSBARHEIGHT", 5, "LarkAPI.internal.system.getStatusBarHeight");
        LARKAPI_INTERNAL_TEA_TRACKNORETURN = new LarkAPIName("LARKAPI_INTERNAL_TEA_TRACKNORETURN", 6, "LarkAPI.internal.tea.trackNoReturn");
        LARKAPI_INTERNAL_TRANSPORT_CALLRUSTAPI = new LarkAPIName("LARKAPI_INTERNAL_TRANSPORT_CALLRUSTAPI", 7, "LarkAPI.internal.transport.callRustApi");
        LARKAPI_UI_GETAPPTHEMEINFO = new LarkAPIName("LARKAPI_UI_GETAPPTHEMEINFO", 8, "LarkAPI.ui.getAppThemeInfo");
        LARKAPI_WEBVIEW_LOADFINISH = new LarkAPIName("LARKAPI_WEBVIEW_LOADFINISH", 9, "LarkAPI.webview.loadFinish");
        LARKAPI_INTERNAL_WEBVIEW_CLOSE = new LarkAPIName("LARKAPI_INTERNAL_WEBVIEW_CLOSE", 10, "LarkAPI.internal.webview.close");
        LARKAPI_INTERNAL_WIDGET_SHOWCONFIRMDIALOG = new LarkAPIName("LARKAPI_INTERNAL_WIDGET_SHOWCONFIRMDIALOG", 11, "LarkAPI.internal.widget.showConfirmDialog");
        LARKAPI_BIZ_PROFILE_OPENPROFILE = new LarkAPIName("LARKAPI_BIZ_PROFILE_OPENPROFILE", 12, "LarkAPI.biz.profile.openProfile");
        $VALUES = $values();
    }

    public final String getValue() {
        return this.value;
    }

    private LarkAPIName(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
