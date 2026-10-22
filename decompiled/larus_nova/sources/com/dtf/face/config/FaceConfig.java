package com.dtf.face.config;

import android.content.Context;
import androidx.camera.video.AudioStats;
import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.larus.nova.R;
import hs7.a;
import ws7.c;
import ws7.s;

/* JADX INFO: loaded from: classes22.dex */
public class FaceConfig {
    private String audioOffIconBase64;
    private String audioOffIconPath;
    private String audioOnIconBase64;
    private String audioOnIconPath;
    private String circleTxtBgAlpha;
    private String circleTxtColor;
    private String dialogArchSysFailedConfirmColor;
    private String dialogArchSysFailedMsgColor;
    private String dialogArchSysFailedTitleColor;
    private String dialogBgAlpha;
    private String dialogCamOpenFailedCancelColor;
    private String dialogCamOpenFailedConfirmColor;
    private String dialogCamOpenFailedMsgColor;
    private String dialogCamOpenFailedTitleColor;
    private String dialogCancelBgColor;
    private String dialogConfirmBgColor;
    private String dialogExitCancelColor;
    private String dialogExitConfirmColor;
    private String dialogExitMsgColor;
    private String dialogExitTitleColor;
    private String dialogInterruptCancelColor;
    private String dialogInterruptConfirmColor;
    private String dialogInterruptMsgColor;
    private String dialogInterruptTitleColor;
    private String dialogNetworkFailedConfirmColor;
    private String dialogNetworkFailedMsgColor;
    private String dialogNetworkFailedTitleColor;
    private String dialogSDKErrConfirmColor;
    private String dialogSDKErrMsgColor;
    private String dialogSDKErrTitleColor;
    private String dialogTimeOutConfirmColor;
    private String dialogTimeOutMsgColor;
    private String dialogTimeOutTitleColor;
    private String dialogTooManyRetriesConfirmColor;
    private String dialogTooManyRetriesMsgColor;
    private String dialogTooManyRetriesTitleColor;
    private String exitIconBase64;
    private String exitIconPath;
    private String faceBgColor;
    private String faceProgressEndColor;
    private String faceProgressStartColor;
    private String faceTitleColor;
    private String noticeBgColor;
    private String noticeIconBase64;
    private String noticeIconPath;
    private String noticeTxtColor;
    private String submitLoadingIconBase64;
    private String submitLoadingIconPath;
    private String submitTextColor;
    private String suitableExitBtnColor;
    private String suitableExitTxtColor;

    public double getDialogBgAlpha() {
        double r100 = Double.parseDouble(this.dialogBgAlpha);     // Catch: Throwable -> L10
        if (r100 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L6;
        return 0.25d;
    L6:
        if (r100 >= 1.0d) goto L13;
        return r100;
    L13:
        return 0.25d;
    L14:
        return 0.25d;
    }

    public FaceConfig() {
    }

    public String getAudioOffIconBase64() {
        return this.audioOffIconBase64;
    }

    public String getAudioOffIconPath() {
        return this.audioOffIconPath;
    }

    public String getAudioOnIconBase64() {
        return this.audioOnIconBase64;
    }

    public String getAudioOnIconPath() {
        return this.audioOnIconPath;
    }

    public String getExitIconBase64() {
        return this.exitIconBase64;
    }

    public String getExitIconPath() {
        return this.exitIconPath;
    }

    public String getNoticeIconBase64() {
        return this.noticeIconBase64;
    }

    public String getNoticeIconPath() {
        return this.noticeIconPath;
    }

    public String getSubmitLoadingIconBase64() {
        return this.submitLoadingIconBase64;
    }

    public String getSubmitLoadingIconPath() {
        return this.submitLoadingIconPath;
    }

    public int getCircleTxtBgColor(Context r100) {
        String r101 = this.circleTxtBgAlpha;
        if (r101 == null) goto L5;
        double r102 = CastDoubleProtector.parseDouble(r101);
    L7:
        if (r102 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L9;
    L10:
        r102 = s.c(r100, R.dimen.dtf_face_message_code_alpha) / 100.0f;
        if (a.h().l() == false) goto L13;
        r102 = 0.0d;
    L13:
        String r103 = Integer.toHexString((int) (r102 * 255.0d));
        StringBuilder r104 = new StringBuilder("#");
        if ("0".equals(r103) == false) goto L16;
        r103 = CustomAlbumViewModel.DEFAULT_TAB_ID;
    L16:
        r104.append(r103);
        r104.append("000000");
        return s.d(r100, r104.toString(), R.color.dtf_face_message_code_bg_color);
    L9:
        if (r102 <= 1.0d) goto L13;
    L5:
        r102 = -1.0d;
        goto L7
    }

    public void setAudioIconBase64(String r100) {
        this.audioOnIconBase64 = r100;
    }

    public void setAudioOffIconBase64(String r100) {
        this.audioOffIconBase64 = r100;
    }

    public void setAudioOffIconPath(String r100) {
        this.audioOffIconPath = r100;
    }

    public void setAudioOnIconPath(String r100) {
        this.audioOnIconPath = r100;
    }

    public void setCircleTxtBgAlpha(String r100) {
        this.circleTxtBgAlpha = r100;
    }

    public void setCircleTxtColor(String r100) {
        this.circleTxtColor = r100;
    }

    public void setDialogArchSysFailedConfirmColor(String r100) {
        this.dialogArchSysFailedConfirmColor = r100;
    }

    public void setDialogArchSysFailedMsgColor(String r100) {
        this.dialogArchSysFailedMsgColor = r100;
    }

    public void setDialogArchSysFailedTitleColor(String r100) {
        this.dialogArchSysFailedTitleColor = r100;
    }

    public void setDialogBgAlpha(String r100) {
        this.dialogBgAlpha = r100;
    }

    public void setDialogCamOpenFailedCancelColor(String r100) {
        this.dialogCamOpenFailedCancelColor = r100;
    }

    public void setDialogCamOpenFailedConfirmColor(String r100) {
        this.dialogCamOpenFailedConfirmColor = r100;
    }

    public void setDialogCamOpenFailedMsgColor(String r100) {
        this.dialogCamOpenFailedMsgColor = r100;
    }

    public void setDialogCamOpenFailedTitleColor(String r100) {
        this.dialogCamOpenFailedTitleColor = r100;
    }

    public void setDialogCancelBgColor(String r100) {
        this.dialogCancelBgColor = r100;
    }

    public void setDialogConfirmBgColor(String r100) {
        this.dialogConfirmBgColor = r100;
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

    public void setDialogInterruptCancelColor(String r100) {
        this.dialogInterruptCancelColor = r100;
    }

    public void setDialogInterruptConfirmColor(String r100) {
        this.dialogInterruptConfirmColor = r100;
    }

    public void setDialogInterruptMsgColor(String r100) {
        this.dialogInterruptMsgColor = r100;
    }

    public void setDialogInterruptTitleColor(String r100) {
        this.dialogInterruptTitleColor = r100;
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

    public void setDialogSDKErrConfirmColor(String r100) {
        this.dialogSDKErrConfirmColor = r100;
    }

    public void setDialogSDKErrMsgColor(String r100) {
        this.dialogSDKErrMsgColor = r100;
    }

    public void setDialogSDKErrTitleColor(String r100) {
        this.dialogSDKErrTitleColor = r100;
    }

    public void setDialogTimeOutConfirmColor(String r100) {
        this.dialogTimeOutConfirmColor = r100;
    }

    public void setDialogTimeOutMsgColor(String r100) {
        this.dialogTimeOutMsgColor = r100;
    }

    public void setDialogTimeOutTitleColor(String r100) {
        this.dialogTimeOutTitleColor = r100;
    }

    public void setDialogTooManyRetriesConfirmColor(String r100) {
        this.dialogTooManyRetriesConfirmColor = r100;
    }

    public void setDialogTooManyRetriesMsgColor(String r100) {
        this.dialogTooManyRetriesMsgColor = r100;
    }

    public void setDialogTooManyRetriesTitleColor(String r100) {
        this.dialogTooManyRetriesTitleColor = r100;
    }

    public void setExitIconBase64(String r100) {
        this.exitIconBase64 = r100;
    }

    public void setExitIconPath(String r100) {
        this.exitIconPath = r100;
    }

    public void setFaceBgColor(String r100) {
        this.faceBgColor = r100;
    }

    public void setFaceProgressEndColor(String r100) {
        this.faceProgressEndColor = r100;
    }

    public void setFaceProgressStartColor(String r100) {
        this.faceProgressStartColor = r100;
    }

    public void setFaceTitleColor(String r100) {
        this.faceTitleColor = r100;
    }

    public void setNoticeBgColor(String r100) {
        this.noticeBgColor = r100;
    }

    public void setNoticeIconBase64(String r100) {
        this.noticeIconBase64 = r100;
    }

    public void setNoticeIconPath(String r100) {
        this.noticeIconPath = r100;
    }

    public void setNoticeTxtColor(String r100) {
        this.noticeTxtColor = r100;
    }

    public void setSubmitLoadingIconBase64(String r100) {
        this.submitLoadingIconBase64 = r100;
    }

    public void setSubmitLoadingIconPath(String r100) {
        this.submitLoadingIconPath = r100;
    }

    public void setSubmitTextColor(String r100) {
        this.submitTextColor = r100;
    }

    public void setSuitableExitBtnColor(String r100) {
        this.suitableExitBtnColor = r100;
    }

    public void setSuitableExitTxtColor(String r100) {
        this.suitableExitTxtColor = r100;
    }

    public int getCircleTxtColor(Context r100, int r101) {
        return s.d(r100, this.circleTxtColor, r101);
    }

    public c.a getDialogArchSysFailedConfig(Context r100, int r101) {
        c.a r102 = new c.a();
        r102.f561064a = s.d(r100, this.dialogArchSysFailedTitleColor, R.color.dtf_dialog_title_color);
        r102.f561065b = s.d(r100, this.dialogArchSysFailedMsgColor, R.color.dtf_dialog_msg_color);
        r102.f561066c = s.d(r100, this.dialogArchSysFailedConfirmColor, r101);
        return r102;
    }

    public c.a getDialogCamOpenFailedConfig(Context r100, int r101) {
        c.a r102 = new c.a();
        r102.f561064a = s.d(r100, this.dialogCamOpenFailedTitleColor, R.color.dtf_dialog_title_color);
        r102.f561065b = s.d(r100, this.dialogCamOpenFailedMsgColor, R.color.dtf_dialog_msg_color);
        r102.f561066c = s.d(r100, this.dialogCamOpenFailedConfirmColor, r101);
        return r102;
    }

    public c.a getDialogNetworkFailedConfig(Context r100, int r101) {
        c.a r102 = new c.a();
        r102.f561064a = s.d(r100, this.dialogNetworkFailedTitleColor, R.color.dtf_dialog_title_color);
        r102.f561065b = s.d(r100, this.dialogNetworkFailedMsgColor, R.color.dtf_dialog_msg_color);
        r102.f561066c = s.d(r100, this.dialogNetworkFailedConfirmColor, r101);
        return r102;
    }

    public c.a getDialogSDKErrConfig(Context r100, int r101) {
        c.a r102 = new c.a();
        r102.f561064a = s.d(r100, this.dialogSDKErrTitleColor, R.color.dtf_dialog_title_color);
        r102.f561065b = s.d(r100, this.dialogSDKErrMsgColor, R.color.dtf_dialog_msg_color);
        r102.f561066c = s.d(r100, this.dialogSDKErrConfirmColor, r101);
        return r102;
    }

    public c.a getDialogTimeOutConfig(Context r100, int r101) {
        c.a r102 = new c.a();
        r102.f561064a = s.d(r100, this.dialogTimeOutTitleColor, R.color.dtf_dialog_title_color);
        r102.f561065b = s.d(r100, this.dialogTimeOutMsgColor, R.color.dtf_dialog_msg_color);
        r102.f561066c = s.d(r100, this.dialogTimeOutConfirmColor, r101);
        return r102;
    }

    public c.a getDialogTooManyRetriesConfig(Context r100, int r101) {
        c.a r102 = new c.a();
        r102.f561064a = s.d(r100, this.dialogTooManyRetriesTitleColor, R.color.dtf_dialog_title_color);
        r102.f561065b = s.d(r100, this.dialogTooManyRetriesMsgColor, R.color.dtf_dialog_msg_color);
        r102.f561066c = s.d(r100, this.dialogTooManyRetriesConfirmColor, r101);
        return r102;
    }

    public int getEleDialogCancelBgColor(Context r100, int r101) {
        return s.d(r100, this.dialogCancelBgColor, r101);
    }

    public int getEleDialogConfirmBgColor(Context r100, int r101) {
        return s.d(r100, this.dialogConfirmBgColor, r101);
    }

    public int getFaceBgColor(Context r100, int r101) {
        return s.d(r100, this.faceBgColor, r101);
    }

    public int getFaceProgressEndColor(Context r100, int r101) {
        return s.d(r100, this.faceProgressEndColor, r101);
    }

    public int getFaceProgressStartColor(Context r100, int r101) {
        return s.d(r100, this.faceProgressStartColor, r101);
    }

    public int getFaceTitleColor(Context r100, int r101) {
        return s.d(r100, this.faceTitleColor, r101);
    }

    public int getNoticeBgColor(Context r100, int r101) {
        return s.d(r100, this.noticeBgColor, r101);
    }

    public int getNoticeTxtColor(Context r100, int r101) {
        return s.d(r100, this.noticeTxtColor, r101);
    }

    public int getSubmitTextColor(Context r100, int r101) {
        return s.d(r100, this.submitTextColor, r101);
    }

    public int getSuitableExitBtnColor(Context r100, int r101) {
        return s.d(r100, this.suitableExitBtnColor, r101);
    }

    public int getSuitableExitTxtColor(Context r100, int r101) {
        return s.d(r100, this.suitableExitTxtColor, r101);
    }

    public c.a getDialogExitConfig(Context r100, int r101, int r102) {
        c.a r103 = new c.a();
        r103.f561064a = s.d(r100, this.dialogExitTitleColor, R.color.dtf_dialog_title_color);
        r103.f561065b = s.d(r100, this.dialogExitMsgColor, R.color.dtf_dialog_msg_color);
        r103.f561067d = s.d(r100, this.dialogExitCancelColor, r102);
        r103.f561066c = s.d(r100, this.dialogExitConfirmColor, r101);
        return r103;
    }

    public c.a getDialogInterruptConfig(Context r100, int r101, int r102) {
        c.a r103 = new c.a();
        r103.f561064a = s.d(r100, this.dialogInterruptTitleColor, R.color.dtf_dialog_title_color);
        r103.f561065b = s.d(r100, this.dialogInterruptMsgColor, R.color.dtf_dialog_msg_color);
        r103.f561067d = s.d(r100, this.dialogInterruptCancelColor, r102);
        r103.f561066c = s.d(r100, this.dialogInterruptConfirmColor, r101);
        return r103;
    }
}
