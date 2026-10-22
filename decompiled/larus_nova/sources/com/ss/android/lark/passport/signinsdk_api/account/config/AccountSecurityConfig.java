package com.ss.android.lark.passport.signinsdk_api.account.config;

import com.alibaba.fastjson.annotation.JSONField;
import com.ss.android.downloadlib.constants.EventConstants;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes37.dex */
public class AccountSecurityConfig implements Serializable {

    @JSONField(name = ModuleConfigEnum.MODULE_ACCOUNT_MANAGEMENT)
    public ModuleConfig moduleAccountManagement;

    @JSONField(name = ModuleConfigEnum.MODULE_DEVICE_MANAGEMENT)
    public ModuleConfig moduleDeviceManagement;

    @JSONField(name = ModuleConfigEnum.MODULE_FACE_LOGIN)
    public ModuleConfig moduleFaceLogIn;

    @JSONField(name = ModuleConfigEnum.MODULE_FACE_RECOGNITION)
    public ModuleConfig moduleFaceRecognition;

    @JSONField(name = ModuleConfigEnum.MODULE_MODIFY_PWD)
    public ModuleConfig moduleModifyPwd;

    @JSONField(name = ModuleConfigEnum.MODULE_SECURITY_VERIFICATION)
    public ModuleConfig moduleSecurityVerification;

    @JSONField(name = ModuleConfigEnum.MODULE_TWO_FA)
    public ModuleConfig moduleTwoFa;

    public static class ModuleConfig implements Serializable {

        @JSONField(name = "module_info")
        public ModuleInfo moduleInfo;

        @JSONField(name = EventConstants.ExtraJson.SWITCH_STATUS)
        public int switchStatus;

        public ModuleConfig() {
        }
    }

    public static class ModuleInfo implements Serializable {
        public ModuleInfo() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SwitchStatusEnum {
        public static final int STATUS_HIDE = 0;
        public static final int STATUS_SHOW = 1;
    }

    public AccountSecurityConfig() {
    }

    public boolean showModule(String r100) {
        if (ModuleConfigEnum.MODULE_MODIFY_PWD.equals(r100) == false) goto L6;
        ModuleConfig r101 = this.moduleModifyPwd;
    L25:
        if (r101 != null) goto L27;
        return true;
    L27:
        if (r101.switchStatus == 1) goto L32;
        return false;
    L32:
        return true;
    L6:
        if (ModuleConfigEnum.MODULE_ACCOUNT_MANAGEMENT.equals(r100) == false) goto L9;
        r101 = this.moduleAccountManagement;
        goto L25
    L9:
        if (ModuleConfigEnum.MODULE_SECURITY_VERIFICATION.equals(r100) == false) goto L12;
        r101 = this.moduleSecurityVerification;
        goto L25
    L12:
        if (ModuleConfigEnum.MODULE_DEVICE_MANAGEMENT.equals(r100) == false) goto L15;
        r101 = this.moduleDeviceManagement;
        goto L25
    L15:
        if (ModuleConfigEnum.MODULE_TWO_FA.equals(r100) == false) goto L18;
        r101 = this.moduleTwoFa;
        goto L25
    L18:
        if (ModuleConfigEnum.MODULE_FACE_RECOGNITION.equals(r100) == false) goto L21;
        r101 = this.moduleFaceRecognition;
        goto L25
    L21:
        if (ModuleConfigEnum.MODULE_FACE_LOGIN.equals(r100) == false) goto L23;
        r101 = this.moduleFaceLogIn;
        goto L25
    L23:
        r101 = null;
        goto L25
    }
}
