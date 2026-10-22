package com.vivo.push;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.vivo.push.listener.IPushQueryActionListener;
import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.VivoPushException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public class PushClient extends a implements com.vivo.push.e.a {
    public static final String DEFAULT_REQUEST_ID = "1";
    private static volatile PushClient sPushClient;
    private Context mContext;
    private boolean mIsInitSdk;
    private com.vivo.push.e.a mSyncProfileInfo;

    private boolean checkAgreePrivacyStatementAndInitSdk() {
        if (com.vivo.push.restructure.a.a().e().m().isAgreePrivacyStatement() == true) goto L6;
        return false;
    L6:
        inidSdk(this.mContext);
        return true;
    }

    private void initialize() throws VivoPushException {
        if (checkAgreePrivacyStatementAndInitSdk() == true) goto L5;
        return;
    L5:
        checkManifest();
        m r100 = m.a();
        com.vivo.push.b.f r101 = new com.vivo.push.b.f();
        r101.a(com.vivo.push.restructure.a.a().e().l());
        r100.a(r101);
        com.vivo.push.util.t.d("PushClientManager", "startWork");
    }

    public void checkManifest() throws VivoPushException {
        if (checkAgreePrivacyStatementAndInitSdk() == true) goto L5;
        return;
    L5:
        m.a().b();
    }

    public String getAlias() {
        if (checkAgreePrivacyStatementAndInitSdk() == true) goto L7;
        return null;
    L7:
        return m.a().i();
    }

    public List<String> getTopics() {
        if (checkAgreePrivacyStatementAndInitSdk() == false) goto L5;
        m.a();
        return m.c();
    L5:
        return new ArrayList();
    }

    public String getVersion() {
        if (checkAgreePrivacyStatementAndInitSdk() == true) goto L6;
        return null;
    L6:
        return "506";
    }

    public boolean isSupport() {
        if (checkAgreePrivacyStatementAndInitSdk() == true) goto L7;
        return false;
    L7:
        return m.a().d();
    }

    public int isSupportNewControlStrategies() {
        if (checkAgreePrivacyStatementAndInitSdk() == true) goto L7;
        return -1;
    L7:
        return com.vivo.push.restructure.a.a().g().a();
    }

    public int isSupportSyncProfileInfo() {
        if (checkAgreePrivacyStatementAndInitSdk() == true) goto L7;
        return -1;
    L7:
        return com.vivo.push.restructure.a.a().g().b();
    }

    private PushClient(Context r100) {
        this.mContext = ContextDelegate.getContext(r100);
        com.vivo.push.restructure.a.a().a(r100);
        m.a().a(r100);
        this.mSyncProfileInfo = new com.vivo.push.e.d();
    }

    private void checkParam(String r100) {
        if (r100 == null) goto L5;
        return;
    L5:
        throw new IllegalArgumentException("PushManager String param should not be ".concat(String.valueOf(r100)));
    }

    private String getAppId(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        return r100;
    L6:
        return com.vivo.push.restructure.a.a().e().a();
    }

    private String getAppKey(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        return r100;
    L6:
        return com.vivo.push.restructure.a.a().e().c();
    }

    public static synchronized PushClient getInstance(Context r100) {
        monitor-enter(PushClient.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sPushClient != null) goto L7;
        sPushClient = new PushClient(r100.getApplicationContext());     // Catch: Throwable -> L10
    L7:
        PushClient r101 = sPushClient;     // Catch: Throwable -> L10
        monitor-exit(PushClient.class);
        return r101;
    }

    private void inidSdk(Context r100) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsInitSdk == true) goto L6;
        m.a().a(r100);     // Catch: Throwable -> L8
        this.mIsInitSdk = true;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
    }

    @Override // com.vivo.push.e.a
    public void deleteAllProfileId(IPushRequestCallback<Integer> r100) {
        if (checkAgreePrivacyStatementAndInitSdk() == true) goto L7;
        if (r100 == null) goto L11;
        r100.onError(104);
        return;
    L11:
        return;
    L7:
        com.vivo.push.e.a r101 = this.mSyncProfileInfo;
        if (r101 == null) goto L12;
        r101.deleteAllProfileId(r100);
        return;
    }

    public void deleteRegid(IPushActionListener r100) {
        if (checkAgreePrivacyStatementAndInitSdk() == true) goto L7;
        if (r100 == null) goto L9;
        r100.onStateChanged(104);
        return;
    L9:
        return;
    L7:
        super.deleteRegid(r100, getAppId(""), getAppKey(""));
    }

    @Override // com.vivo.push.a
    public void getRegId(IPushQueryActionListener r100) {
        if (checkAgreePrivacyStatementAndInitSdk() == true) goto L7;
        if (r100 == null) goto L9;
        r100.onFail(104);
        return;
    L9:
        return;
    L7:
        super.getRegId(r100);
    }

    public void initialize(PushConfig r100) throws VivoPushException {
        if (r100 == null) goto L6;
        com.vivo.push.restructure.a.a().e().a(r100);
        initialize();
        return;
    L6:
        throw new VivoPushException("initialize error config is null");
    }

    public boolean isPushSupport(int r100) {
        if (checkAgreePrivacyStatementAndInitSdk() == true) goto L7;
        return false;
    L7:
        return com.vivo.push.restructure.a.a().g().a(r100);
    }

    @Override // com.vivo.push.e.a
    public void queryProfileIds(IPushRequestCallback<List<String>> r100) {
        if (checkAgreePrivacyStatementAndInitSdk() == true) goto L7;
        if (r100 == null) goto L11;
        r100.onError(104);
        return;
    L11:
        return;
    L7:
        com.vivo.push.e.a r101 = this.mSyncProfileInfo;
        if (r101 == null) goto L12;
        r101.queryProfileIds(r100);
        return;
    }

    @Override // com.vivo.push.a
    public void querySubscribeState(IPushActionListener r100) {
        if (checkAgreePrivacyStatementAndInitSdk() == true) goto L6;
        if (r100 == null) goto L6;
        r100.onStateChanged(104);
    L6:
        super.querySubscribeState(r100);
    }

    public void setSystemModel(boolean r100) {
        if (checkAgreePrivacyStatementAndInitSdk() == true) goto L5;
        return;
    L5:
        m.a().a(r100);
    }

    public void turnOffPush(IPushActionListener r100) {
        if (checkAgreePrivacyStatementAndInitSdk() == true) goto L7;
        if (r100 == null) goto L9;
        r100.onStateChanged(104);
        return;
    L9:
        return;
    L7:
        m.a().c(r100, getAppId(""), getAppKey(""));
    }

    public void turnOnPush(IPushActionListener r100) {
        if (checkAgreePrivacyStatementAndInitSdk() == true) goto L7;
        if (r100 == null) goto L9;
        r100.onStateChanged(104);
        return;
    L9:
        return;
    L7:
        m.a().a(r100, getAppId(""), getAppKey(""));
    }

    @Override // com.vivo.push.e.a
    public void addProfileId(String r100, IPushRequestCallback<Integer> r101) {
        if (checkAgreePrivacyStatementAndInitSdk() == true) goto L7;
        if (r101 == null) goto L11;
        r101.onError(104);
        return;
    L11:
        return;
    L7:
        com.vivo.push.e.a r102 = this.mSyncProfileInfo;
        if (r102 == null) goto L12;
        r102.addProfileId(r100, r101);
        return;
    }

    public void bindAlias(String r100, IPushActionListener r101) {
        if (checkAgreePrivacyStatementAndInitSdk() == true) goto L7;
        if (r101 == null) goto L9;
        r101.onStateChanged(104);
        return;
    L9:
        return;
    L7:
        checkParam(r100);
        m.a().a(r100, getAppId(""), getAppKey(""), r101);
    }

    public void delTopic(String r100, IPushActionListener r101) {
        if (checkAgreePrivacyStatementAndInitSdk() == true) goto L7;
        if (r101 == null) goto L9;
        r101.onStateChanged(104);
        return;
    L9:
        return;
    L7:
        ArrayList<String> r102 = new ArrayList(1);
        r102.add(r100);
        m.a().b(r102, getAppId(""), getAppKey(""), r101);
    }

    @Override // com.vivo.push.e.a
    public void deleteProfileId(String r100, IPushRequestCallback<Integer> r101) {
        if (checkAgreePrivacyStatementAndInitSdk() == true) goto L7;
        if (r101 == null) goto L11;
        r101.onError(104);
        return;
    L11:
        return;
    L7:
        com.vivo.push.e.a r102 = this.mSyncProfileInfo;
        if (r102 == null) goto L12;
        r102.deleteProfileId(r100, r101);
        return;
    }

    public void isNotifyGuideDialogAllowed(Activity r100, IPushActionListener r101) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (checkAgreePrivacyStatementAndInitSdk() == true) goto L8;
        r101.onStateChanged(104);
        return;
    L8:
        com.vivo.push.d.b.a().a(r100, r101);
    }

    public void setTopic(String r100, IPushActionListener r101) {
        if (checkAgreePrivacyStatementAndInitSdk() == true) goto L7;
        if (r101 == null) goto L9;
        r101.onStateChanged(104);
        return;
    L9:
        return;
    L7:
        ArrayList<String> r102 = new ArrayList(1);
        r102.add(r100);
        m.a().a(r102, getAppId(""), getAppKey(""), r101);
    }

    public void showNotifyGuideDialog(Activity r100, IPushActionListener r101) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (checkAgreePrivacyStatementAndInitSdk() == true) goto L8;
        r101.onStateChanged(104);
        return;
    L8:
        com.vivo.push.d.b.a().a(r100, r101, SystemClock.elapsedRealtime());
    }

    public void unBindAlias(String r100, IPushActionListener r101) {
        if (checkAgreePrivacyStatementAndInitSdk() == true) goto L7;
        if (r101 == null) goto L9;
        r101.onStateChanged(104);
        return;
    L9:
        return;
    L7:
        checkParam(r100);
        m.a().b(r100, getAppId(""), getAppKey(""), r101);
    }
}
