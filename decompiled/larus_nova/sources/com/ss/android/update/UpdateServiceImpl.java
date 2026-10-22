package com.ss.android.update;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bytedance.services.app.common.context.api.AppCommonContext;
import java.io.File;
import yhc.g;
import yhc.h;
import yhc.j0;
import yhc.l;
import yhc.p;
import yhc.u;
import yhc.v;
import yhc.w;
import yhc.y;

/* JADX INFO: loaded from: classes5.dex */
public class UpdateServiceImpl implements UpdateService {
    private d mUpdateHelper;

    @Override // com.ss.android.update.UpdateService
    public void cancelDownload() {
        this.mUpdateHelper.h();
    }

    @Override // com.ss.android.update.UpdateService
    public void cancelNotifyAvai() {
        this.mUpdateHelper.i();
    }

    @Override // com.ss.android.update.UpdateService
    public void cancelNotifyReady() {
        this.mUpdateHelper.j();
    }

    @Override // com.ss.android.update.UpdateService
    public void exitUpdate() {
        this.mUpdateHelper.W();
    }

    @Override // com.ss.android.update.UpdateService
    public boolean formalUpdateEnable() {
        int r100 = this.mUpdateHelper.T;
        if (r100 == 0) goto L8;
        if (r100 == 1) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    @Override // com.ss.android.update.UpdateService
    public String getDownloadingUrl() {
        d r100 = this.mUpdateHelper;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r100.f455272k == true) goto L7;
        r100.U();     // Catch: Throwable -> L10
        r100.f455272k = true;     // Catch: Throwable -> L10
    L7:
        String r101 = r100.f455274l;     // Catch: Throwable -> L10
        monitor-exit(r100);
        return r101;
    }

    @Override // com.ss.android.update.UpdateService
    public Intent getIntentForLocalApp() {
        d r100 = this.mUpdateHelper;
        r100.getClass();
        p.b.f567725a.getClass();
        if (p.d() == false) goto L12;
        Context r101 = r100.f455258d;
        if (r101 == null) goto L13;
        PackageManager r102 = r101.getPackageManager();
        if (r100.f455283p0 != null) goto L9;
        return null;
    L9:
        if (TextUtils.isEmpty(null) == false) goto L11;
        return null;
    L11:
        return r102.getLaunchIntentForPackage(null);
    L13:
        return null;
    L12:
        return null;
    }

    @Override // com.ss.android.update.UpdateService
    public String getLastVersion() {
        return this.mUpdateHelper.z();
    }

    @Override // com.ss.android.update.UpdateService
    public int getLatency() {
        d r100 = this.mUpdateHelper;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r100.f455272k == true) goto L7;
        r100.U();     // Catch: Throwable -> L10
        r100.f455272k = true;     // Catch: Throwable -> L10
    L7:
        int r101 = Math.min(Math.max(r100.F, 0), 60);     // Catch: Throwable -> L10
        monitor-exit(r100);
        return r101;
    }

    @Override // com.ss.android.update.UpdateService
    public int getOfficial() {
        return this.mUpdateHelper.C();
    }

    @Override // com.ss.android.update.UpdateService
    public int getPreDownloadDelayDays() {
        d r100 = this.mUpdateHelper;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r100.f455272k == true) goto L7;
        r100.U();     // Catch: Throwable -> L10
        r100.f455272k = true;     // Catch: Throwable -> L10
    L7:
        int r101 = r100.D;     // Catch: Throwable -> L10
        monitor-exit(r100);
        return r101;
    }

    @Override // com.ss.android.update.UpdateService
    public long getPreDownloadDelaySecond() {
        d r100 = this.mUpdateHelper;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r100.f455272k == true) goto L7;
        r100.U();     // Catch: Throwable -> L10
        r100.f455272k = true;     // Catch: Throwable -> L10
    L7:
        long r101 = r100.E;     // Catch: Throwable -> L10
        monitor-exit(r100);
        return r101;
    }

    @Override // com.ss.android.update.UpdateService
    public int getReleaseRuleId() {
        return this.mUpdateHelper.F();
    }

    @Override // com.ss.android.update.UpdateService
    public String getUpdateButtonText() {
        return this.mUpdateHelper.H();
    }

    @Override // com.ss.android.update.UpdateService
    public File getUpdateReadyApk() {
        return this.mUpdateHelper.I();
    }

    @Override // com.ss.android.update.UpdateService
    public String getUpdateTitle() {
        return this.mUpdateHelper.G();
    }

    @Override // com.ss.android.update.UpdateService
    public String getVerboseAppName() {
        AppCommonContext r100 = this.mUpdateHelper.f455289s0;
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.getStringAppName();
    }

    @Override // com.ss.android.update.UpdateService
    public int getVersionCode() {
        d r100 = this.mUpdateHelper;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r100.f455272k == true) goto L7;
        r100.U();     // Catch: Throwable -> L10
        r100.f455272k = true;     // Catch: Throwable -> L10
    L7:
        int r101 = r100.f455278n;     // Catch: Throwable -> L10
        monitor-exit(r100);
        return r101;
    }

    @Override // com.ss.android.update.UpdateService
    public String getWhatsNew() {
        return this.mUpdateHelper.K();
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isCanUpdate() {
        return this.mUpdateHelper.M(false);
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isClientStrategyEnable() {
        return this.mUpdateHelper.N();
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isCurrentVersionOut() {
        return this.mUpdateHelper.O();
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isForceUpdate() {
        return this.mUpdateHelper.P();
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isInstallAlphaApp() {
        p.b.f567725a.getClass();
        return p.d();
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isLocalApp() {
        d r100 = this.mUpdateHelper;
        if (r100 == null) goto L13;
        v r101 = r100.f455283p0;
        if (r101 != null) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r101.f567744h == false) goto L9;
        r102 = true;
        goto L10
    L13:
        return false;
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isRealCurrentVersionOut() {
        return this.mUpdateHelper.Q();
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isShowUpdateDialog() {
        j0 r100 = j0.a.f567706a;
        if (r100.f567703b == false) goto L14;
        int r101 = r100.f567704c.b("current_Strategy", 1);
        int r102 = r100.f567704c.b("show_update_dialog_version", 0);
        int r103 = r100.f567702a;
        if (r103 != r102) goto L7;
        c.k(UpdateService.REASON_NEW_STRATEGY_VERSION_IS_SAME);
        return false;
    L7:
        if (r101 != 1) goto L9;
        r100.f567704c.c("show_update_dialog_version", r103);
    L12:
        return true;
    L9:
        int r104 = r100.f567704c.b("version_code", 0);
        int r105 = r100.f567702a;
        if ((r105 - r104) < r100.f567705d) goto L13;
        r100.f567704c.c("show_update_dialog_version", r105);
        goto L12
    L13:
        c.k(UpdateService.REASON_NEW_STRATEGY_INTERVAL_VERSION + (r100.f567702a - r104));
        return false;
    L14:
        c.k(UpdateService.REASON_NEW_STRATEGY_NOT_ENABLE);
        return false;
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isShowingUpdateAvailDialog() {
        l r100 = this.mUpdateHelper.f455299x0;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.d();
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isShowingUpdateCheckDialog() {
        h r100 = this.mUpdateHelper.f455269i0;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.b();
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isUpdateApkPreDownloaded() {
        return this.mUpdateHelper.R();
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isUpdating() {
        return this.mUpdateHelper.T();
    }

    @Override // com.ss.android.update.UpdateService
    public boolean needPreDownload() {
        d r100 = this.mUpdateHelper;
        monitor-enter(r100);
        boolean r101 = true;
        if (r100.f455272k == true) goto L8;
        r100.U();     // Catch: Throwable -> L15
        r100.f455272k = true;     // Catch: Throwable -> L15
    L8:
        if (r100.C == false) goto L12;
        if (r100.f455283p0.f567755s == false) goto L12;
    L13:
        monitor-exit(r100);
        return r101;
    L12:
        r101 = false;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.update.UpdateService
    public void startDownload() {
        this.mUpdateHelper.h0(false);
    }

    @Override // com.ss.android.update.UpdateService
    public void startPreDownload() {
        this.mUpdateHelper.i0(false);
    }

    public UpdateServiceImpl() {
        this.mUpdateHelper = d.x();
    }

    @Override // com.ss.android.update.UpdateService
    public void clickCloseAlphaButton(boolean r100) {
        this.mUpdateHelper.m(r100);
    }

    @Override // com.ss.android.update.UpdateService
    public void clickCloseButton(boolean r100) {
        this.mUpdateHelper.n(r100);
    }

    @Override // com.ss.android.update.UpdateService
    public void clickOpenAlphaButton(boolean r100) {
        this.mUpdateHelper.o(r100);
    }

    @Override // com.ss.android.update.UpdateService
    public void clickUpdateButton(boolean r100) {
        this.mUpdateHelper.p(r100);
    }

    @Override // com.ss.android.update.UpdateService
    public void getProgress(yhc.a r100) {
        this.mUpdateHelper.E(r100);
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isCanUpdate(boolean r100) {
        return this.mUpdateHelper.M(r100);
    }

    @Override // com.ss.android.update.UpdateService
    public void noShowDialogEvent(String r100) {
        c.k(r100);
    }

    @Override // com.ss.android.update.UpdateService
    public String parseWhatsNew(String r100) {
        this.mUpdateHelper.getClass();
        return d.X(r100);
    }

    @Override // com.ss.android.update.UpdateService
    public void removeUpdateStatusListener(OnUpdateStatusChangedListener r100) {
        this.mUpdateHelper.Y(r100);
    }

    @Override // com.ss.android.update.UpdateService
    public void setAppExtra(String r100) {
        this.mUpdateHelper.f455303z0 = r100;
    }

    @Override // com.ss.android.update.UpdateService
    public void setCheckSignature(boolean r100) {
        this.mUpdateHelper.f455252a = r100;
    }

    @Override // com.ss.android.update.UpdateService
    public void setCustomUpdateAlphaDialog(g r100) {
        d r101 = this.mUpdateHelper;
        monitor-enter(r101);
        r101.getClass();     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.update.UpdateService
    public void showUpdateAlphaDialogScene(boolean r100) {
        d r101 = this.mUpdateHelper;
        r101.W = true;
        c.l(0);
        r101.Z(1, r100);
    }

    @Override // com.ss.android.update.UpdateService
    public void showUpdateDialogScene(boolean r100) {
        this.mUpdateHelper.e0(r100);
    }

    @Override // com.ss.android.update.UpdateService
    public void checkUpdate(int r100, OnUpdateStatusChangedListener r101) {
        this.mUpdateHelper.g0(r100, 3, r101, true);
    }

    @Override // com.ss.android.update.UpdateService
    public void reportDialogInfo(int r100, boolean r101) {
        this.mUpdateHelper.Z(r100, r101);
    }

    @Override // com.ss.android.update.UpdateService
    public void setCustomUpdateDialog(l r100, h r101) {
        d r102 = this.mUpdateHelper;
        monitor-enter(r102);
        r102.f455267h0 = r100;     // Catch: Throwable -> L7
        r102.f455269i0 = r101;     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.update.UpdateService
    public void checkUpdate(int r100, OnUpdateStatusChangedListener r101, boolean r102) {
        this.mUpdateHelper.g0(r100, 3, r101, r102);
    }

    @Override // com.ss.android.update.UpdateService
    public void showUpdateDialog(int r100, Context r101, boolean r102) {
        if (r100 != 2) goto L5;
    L40:
        d r103 = this.mUpdateHelper;
        if (r103.O() == false) goto L84;
        l r104 = r103.f455267h0;
        if (r104 == null) goto L46;
        r103.f455299x0 = r104;
    L51:
        if (r103.f455299x0.d() == false) goto L53;
        return;
    L53:
        if (r101.getResources().getConfiguration().orientation != 2) goto L56;
        r103.f455279n0.getUpdateConfig().getClass();
        c.k(UpdateService.REASON_NO_ORIENTAL_DIALOG);
        return;
    L56:
        if (r103.W == false) goto L59;
        c.k(UpdateService.REASON_OTHER_DIALOG_SHOWING);
        return;
    L59:
        if (r103.f455283p0.f567744h == true) goto L61;
    L73:
        r103.f455299x0.b(r102);     // Catch: Exception -> L65
        r103.f455299x0.a(r102);     // Catch: Exception -> L65
    L67:
        String r105 = r103.f455274l;
        int r106 = r103.f455280o;
        if (r102 == false) goto L70;
        String r107 = "auto";
    L71:
        c.m("test_invitation_popup_show", r105, r106, r107, -1, r103.f455294v);
        return;
    L70:
        r107 = "trigger";
    L65:
        e = move-exception;
        c.k(e.toString());
        goto L67
    L61:
        if (p.b.f567725a.e() == true) goto L73;
        c.k(UpdateService.REASON_LOCAL_OUT_OF_HOUSE);
        r103.f455299x0 = null;
        return;
    L46:
        if (r103.f455279n0.getUpdateConfig().f567746j == false) goto L48;
        r103.f455299x0 = new y(r101, r102);
        goto L51
    L48:
        r103.f455299x0 = new w(r101, r102);
        goto L51
    L84:
        return;
    L5:
        if (r100 == (-2)) goto L40;
        if (r100 != 1) goto L10;
    L17:
        d r108 = this.mUpdateHelper;
        r108.getClass();
        j0.a.f567706a.a();
        if (r108.Q() == true) goto L20;
        c.k(UpdateService.REASON_CHECK_VERSION_CODE_FAIL);
        return;
    L20:
        r108.g();
        d.X(r108.K());
        if (r108.W == false) goto L23;
        c.k(UpdateService.REASON_OTHER_DIALOG_SHOWING);
        return;
    L23:
        h r109 = r108.f455269i0;
        if (r109 != null) goto L26;
        u r110 = r108.f455295v0;
        if (r110 == null) goto L34;
        if (r110.isShowing() == true) goto L34;
        r108.f455295v0 = null;
    L34:
        if (r108.f455295v0 != null) goto L37;
        r108.f455295v0 = new u(r101);
    L37:
        if (r108.f455295v0.isShowing() == true) goto L39;
        r108.f455295v0.a(1);
    L39:
        c.m("test_invitation_popup_show", r108.f455274l, r108.f455280o, "trigger", -1, r108.f455294v);
        return;
    L26:
        if (r109.b() == true) goto L39;
        r109.a(1);
        goto L39
    L10:
        if (r100 == (-1)) goto L17;
        if (r100 != 3) goto L15;
    L16:
        this.mUpdateHelper.getClass();
        return;
    L15:
        if (r100 == (-3)) goto L16;
    }

    @Override // com.ss.android.update.UpdateService
    public void checkUpdate(int r100, int r101, OnUpdateStatusChangedListener r102, boolean r103) {
        this.mUpdateHelper.g0(r100, r101, r102, r103);
    }
}
