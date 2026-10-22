package com.ss.android.lark.integrator.security.compliance;

import android.content.Context;
import android.content.Intent;
import com.larksuite.component.openplatform.plugins.config.LKPluginConfig;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.security.compliance.api.DefaultSecurityComplianceApiMock;
import com.ss.android.lark.security.compliance.api.ISecurityComplianceApi;
import com.ss.android.lark.security.compliance.api.params.ScreenshotProtectionUser;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Single;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Singleton
public final class e implements ISecurityComplianceApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DefaultSecurityComplianceApiMock f428062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.screenprotect.userscope.b f428063b;

    @Override // com.ss.android.lark.security.compliance.api.ISecurityComplianceApi
    public final boolean enableUrlSlashOpt() {
        return this.f428062a.enableUrlSlashOpt();
    }

    @Override // com.ss.android.lark.security.compliance.api.ISecurityComplianceApi
    public final List<LKPluginConfig> getAllPluginConfigs() {
        return this.f428062a.getAllPluginConfigs();
    }

    @Override // com.ss.android.lark.security.compliance.api.ISecurityComplianceApi
    public final p4c.a getAppLockApi() {
        return this.f428062a.getAppLockApi();
    }

    @Override // com.ss.android.lark.security.compliance.api.ISecurityComplianceApi
    public final p4c.b getConditionalAccessModuleApi() {
        return this.f428062a.getConditionalAccessModuleApi();
    }

    @Override // com.ss.android.lark.security.compliance.api.ISecurityComplianceApi
    public final p4c.c getDeviceSecurityDetectionApi() {
        return this.f428062a.getDeviceSecurityDetectionApi();
    }

    @Override // com.ss.android.lark.security.compliance.api.ISecurityComplianceApi
    public final Single<String> getMdmDeviceAuthToken(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f428062a.getMdmDeviceAuthToken(r100, r101);
    }

    @Override // com.ss.android.lark.security.compliance.api.ISecurityComplianceApi
    public final void gotoEncryptionUpgrade(Context r100, Intent r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f428062a.gotoEncryptionUpgrade(r100, r101);
    }

    @Override // com.ss.android.lark.security.compliance.api.ISecurityComplianceApi
    public final void gotoProxySettingPage(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f428062a.gotoProxySettingPage(r100);
    }

    @Override // com.ss.android.lark.security.compliance.api.ISecurityComplianceApi
    public final void handleRemoteEraseBySessionInvalid(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "remoteEraseSidList");
        this.f428062a.handleRemoteEraseBySessionInvalid(r100);
    }

    @Override // com.ss.android.lark.security.compliance.api.ISecurityComplianceApi
    public final boolean isGpsSupported(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f428062a.isGpsSupported(r100);
    }

    @Override // com.ss.android.lark.security.compliance.api.ISecurityComplianceApi
    public final boolean isLocating(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f428062a.isLocating(r100);
    }

    @Override // com.ss.android.lark.security.compliance.api.ISecurityComplianceApi
    public final boolean isPSDATokenDisable() {
        return this.f428062a.isPSDATokenDisable();
    }

    @Override // com.ss.android.lark.security.compliance.api.ISecurityComplianceApi
    public final boolean isProxyOpen() {
        return this.f428062a.isProxyOpen();
    }

    @Override // com.ss.android.lark.security.compliance.api.ISecurityComplianceApi
    public final boolean needEncryptionUpgrade() {
        return this.f428062a.needEncryptionUpgrade();
    }

    @Override // com.ss.android.lark.security.compliance.api.ISecurityComplianceApi
    public final boolean needEncryptionUpgradeColdBoot() {
        return this.f428062a.needEncryptionUpgradeColdBoot();
    }

    @Override // com.ss.android.lark.security.compliance.api.ISecurityComplianceApi
    public final void openFileSecurityCheckPage(Context r100, String r110, long r111, int r112, String r113) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "objToken");
        Intrinsics.checkNotNullParameter(r113, "locale");
        this.f428062a.openFileSecurityCheckPage(r100, r110, r111, r112, r113);
    }

    @Override // com.ss.android.lark.security.compliance.api.ISecurityComplianceApi
    public final void setPSDATokenDisable(boolean r100) {
        this.f428062a.setPSDATokenDisable(r100);
    }

    @Override // com.ss.android.lark.security.compliance.api.ISecurityComplianceApi
    public final void setSwitchToGlobal(ScreenshotProtectionUser r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "user");
        this.f428062a.setSwitchToGlobal(r100, r101);
    }

    @Override // com.ss.android.lark.security.compliance.api.ISecurityComplianceApi
    public final boolean shouldUseMdmDeviceAuth() {
        return this.f428062a.shouldUseMdmDeviceAuth();
    }

    @Override // com.ss.android.lark.security.compliance.api.ISecurityComplianceApi
    public final Object startLocationDetection(Context r100, int r101, Continuation<? super Boolean> r102) {
        return this.f428062a.startLocationDetection(r100, r101, r102);
    }

    @Override // com.ss.android.lark.security.compliance.api.ISecurityComplianceApi
    public final void stopLocationDetection(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f428062a.stopLocationDetection(r100);
    }

    @Override // com.ss.android.lark.security.compliance.api.ISecurityComplianceApi
    public final void verifySecureURL(String r100, Map<String, ? extends Object> r101, IGetDataCallback<o4c.c> r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.f428062a.verifySecureURL(r100, r101, r102);
    }

    @Override // com.ss.android.lark.security.compliance.api.ISecurityComplianceApi
    public final boolean getSwitchStatusFromAdmin() {
        return this.f428063b.getSwitchStatusFromAdmin();
    }

    @Override // com.ss.android.lark.security.compliance.api.ISecurityComplianceApi
    public final boolean getSwitchStatusFromCurrentApp() {
        return this.f428063b.getSwitchStatusFromCurrentApp();
    }

    @Inject
    public e(com.ss.android.lark.screenprotect.userscope.b r100) {
        Intrinsics.checkNotNullParameter(r100, "screenProtectService");
        this.f428062a = new DefaultSecurityComplianceApiMock();
        this.f428063b = r100;
    }
}
