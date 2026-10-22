package com.dtf.face.config;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.dtf.face.log.RecordService;
import com.larus.nova.R;
import java.util.Map;
import ws7.c;
import ws7.s;

/* JADX INFO: loaded from: classes22.dex */
public class GuideConfig {
    private String dialogExitCancelColor;
    private String dialogExitConfirmColor;
    private String dialogExitMsgColor;
    private String dialogExitTitleColor;
    private String dialogNetworkFailedConfirmColor;
    private String dialogNetworkFailedMsgColor;
    private String dialogNetworkFailedTitleColor;
    private String dialogPermissionFailedConfirmColor;
    private String dialogPermissionFailedMsgColor;
    private String dialogPermissionFailedTitleColor;
    private String dialogSupportFailedConfirmColor;
    private String dialogSupportFailedMsgColor;
    private String dialogSupportFailedTitleColor;
    private String loadingPageColor;
    private String permissionToastBgColor;
    private String permissionToastMsgColor;
    private String permissionToastTitleColor;
    private String statusBarLightTxt;
    private String titleBackBase64;
    private String titleBackPath;
    private String titleCloseBase64;
    private String titleClosePath;

    public boolean isLightStatusBar() {
        return true ^ String.valueOf(true).equalsIgnoreCase(this.statusBarLightTxt);
    }

    public boolean hasLoadingPageColor() {
        String r100 = this.loadingPageColor;
        Map<String, Integer> r101 = s.f561104a;
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        return PatternProtector.compile("^#([0-9A-Fa-f]{6}|[0-9A-Fa-f]{8})$").matcher(r100).matches();
    }

    public GuideConfig() {
    }

    public String getTitleBackBase64() {
        return this.titleBackBase64;
    }

    public String getTitleBackPath() {
        return this.titleBackPath;
    }

    public String getTitleCloseBase64() {
        return this.titleCloseBase64;
    }

    public String getTitleClosePath() {
        return this.titleClosePath;
    }

    public boolean needTransparentLoading(Context r100) {
        if (Color.alpha(getLoadingPageColor(r100, R.color.dtf_guide_loading_page_default)) != 0) goto L12;
        return true;
    L12:
        return false;
    L7:
        th = move-exception;
        RecordService.getInstance().recordException(th);
        return false;
    }

    public void setDialogExitCancelColor(String r100) {
        this.dialogExitCancelColor = r100;
    }

    public void setDialogExitConfirmColor(String r100) {
        this.dialogExitConfirmColor = r100;
    }

    public void setDialogExitMsgColor(String r100) {
        this.dialogExitMsgColor = r100;
    }

    public void setDialogExitTitleColor(String r100) {
        this.dialogExitTitleColor = r100;
    }

    public void setDialogNetworkFailedConfirmColor(String r100) {
        this.dialogNetworkFailedConfirmColor = r100;
    }

    public void setDialogNetworkFailedMsgColor(String r100) {
        this.dialogNetworkFailedMsgColor = r100;
    }

    public void setDialogNetworkFailedTitleColor(String r100) {
        this.dialogNetworkFailedTitleColor = r100;
    }

    public void setDialogPermissionFailedConfirmColor(String r100) {
        this.dialogPermissionFailedConfirmColor = r100;
    }

    public void setDialogPermissionFailedMsgColor(String r100) {
        this.dialogPermissionFailedMsgColor = r100;
    }

    public void setDialogPermissionFailedTitleColor(String r100) {
        this.dialogPermissionFailedTitleColor = r100;
    }

    public void setDialogSupportFailedConfirmColor(String r100) {
        this.dialogSupportFailedConfirmColor = r100;
    }

    public void setDialogSupportFailedMsgColor(String r100) {
        this.dialogSupportFailedMsgColor = r100;
    }

    public void setDialogSupportFailedTitleColor(String r100) {
        this.dialogSupportFailedTitleColor = r100;
    }

    public void setLoadingPageColor(String r100) {
        this.loadingPageColor = r100;
    }

    public void setPermissionToastBgColor(String r100) {
        this.permissionToastBgColor = r100;
    }

    public void setPermissionToastMsgColor(String r100) {
        this.permissionToastMsgColor = r100;
    }

    public void setPermissionToastTitleColor(String r100) {
        this.permissionToastTitleColor = r100;
    }

    public void setStatusBarLightTxt(String r100) {
        this.statusBarLightTxt = r100;
    }

    public void setTitleBackBase64(String r100) {
        this.titleBackBase64 = r100;
    }

    public void setTitleBackPath(String r100) {
        this.titleBackPath = r100;
    }

    public void setTitleCloseBase64(String r100) {
        this.titleCloseBase64 = r100;
    }

    public void setTitleClosePath(String r100) {
        this.titleClosePath = r100;
    }

    public c.a getDialogNetworkFailedConfig(Context r100, int r101) {
        c.a r102 = new c.a();
        r102.f561064a = s.d(r100, this.dialogNetworkFailedTitleColor, R.color.dtf_dialog_title_color);
        r102.f561065b = s.d(r100, this.dialogNetworkFailedMsgColor, R.color.dtf_dialog_msg_color);
        r102.f561066c = s.d(r100, this.dialogNetworkFailedConfirmColor, r101);
        return r102;
    }

    public c.a getDialogPermissionFailedConfig(Context r100, int r101) {
        c.a r102 = new c.a();
        r102.f561064a = s.d(r100, this.dialogPermissionFailedTitleColor, R.color.dtf_dialog_title_color);
        r102.f561065b = s.d(r100, this.dialogPermissionFailedMsgColor, R.color.dtf_dialog_msg_color);
        r102.f561066c = s.d(r100, this.dialogPermissionFailedConfirmColor, r101);
        return r102;
    }

    public c.a getDialogSupportFailedConfig(Context r100, int r101) {
        c.a r102 = new c.a();
        r102.f561064a = s.d(r100, this.dialogSupportFailedTitleColor, R.color.dtf_dialog_title_color);
        r102.f561065b = s.d(r100, this.dialogSupportFailedMsgColor, R.color.dtf_dialog_msg_color);
        r102.f561066c = s.d(r100, this.dialogSupportFailedConfirmColor, r101);
        return r102;
    }

    public int getLoadingPageColor(Context r100, int r101) {
        return s.d(r100, this.loadingPageColor, r101);
    }

    public int getPermissionToastBgColor(Context r100, int r101) {
        return s.d(r100, this.permissionToastBgColor, r101);
    }

    public int getPermissionToastMsgColor(Context r100, int r101) {
        return s.d(r100, this.permissionToastMsgColor, r101);
    }

    public int getPermissionToastTitleColor(Context r100, int r101) {
        return s.d(r100, this.permissionToastTitleColor, r101);
    }

    public c.a getDialogExitConfig(Context r100, int r101, int r102) {
        c.a r103 = new c.a();
        r103.f561064a = s.d(r100, this.dialogExitTitleColor, R.color.dtf_dialog_title_color);
        r103.f561065b = s.d(r100, this.dialogExitMsgColor, R.color.dtf_dialog_msg_color);
        r103.f561066c = s.d(r100, this.dialogExitConfirmColor, r101);
        r103.f561067d = s.d(r100, this.dialogExitCancelColor, r102);
        return r103;
    }
}
