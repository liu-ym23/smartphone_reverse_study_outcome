package com.ss.android.lark.passport.signinsdk_api.entity;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.io.Serializable;

/* JADX INFO: loaded from: classes37.dex */
@AppConfig(key = "passport_view_display_enable")
public class PassportViewDisplayConfig implements Serializable {

    @SerializedName("login_enable_bidp_button")
    public boolean loginEnableBIdpButton;

    @SerializedName("login_enable_cidp_button")
    public boolean loginEnableCIdpButton;

    @SerializedName("login_enable_create_entry")
    public boolean loginEnableCreateEntry;

    @SerializedName("login_sso_button_direct_open_idp")
    public boolean loginEnableDirectOpenIdp;

    @SerializedName("login_enable_doubao_button")
    public boolean loginEnableDoubaoButton;

    @SerializedName("login_enable_qr_code_entry")
    public boolean loginEnableQrCodeEntry;

    @SerializedName("login_redirect_to_saas_login")
    public boolean loginEnableRedirectToSaasLogin;

    @SerializedName("login_switch_credential_tab")
    public int loginSwitchCredentialTab;

    public PassportViewDisplayConfig() {
        this.loginEnableCreateEntry = true;
        this.loginEnableCIdpButton = true;
        this.loginEnableBIdpButton = true;
        this.loginEnableRedirectToSaasLogin = false;
        this.loginEnableDirectOpenIdp = false;
        this.loginSwitchCredentialTab = 0;
        this.loginEnableQrCodeEntry = true;
        this.loginEnableDoubaoButton = false;
    }
}
