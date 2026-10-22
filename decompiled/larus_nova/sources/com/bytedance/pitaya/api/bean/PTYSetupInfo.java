package com.bytedance.pitaya.api.bean;

import com.bytedance.pitaya.api.PTYCustomURLHost;
import com.bytedance.pitaya.api.PTYDIDCallback;
import com.bytedance.pitaya.api.PTYPackageFilterCallback;
import com.bytedance.pitaya.api.PTYPyBinderCallback;
import com.bytedance.pitaya.api.PTYSettingsCallback;
import com.bytedance.pitaya.api.PTYUIDCallback;
import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002\u0082\u0001B\u0011\b\u0002\u0012\u0006\u0010|\u001a\u00020{¢\u0006\u0004\b}\u0010~B\t\b\u0017¢\u0006\u0004\b}\u0010\u007fB²\u0001\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010,\u001a\u00020+\u0012\b\b\u0002\u00103\u001a\u000202\u0012\b\b\u0002\u00109\u001a\u000202\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010?\u001a\u00020+\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010B\u0012\b\b\u0002\u0010I\u001a\u000202\u0012\b\b\u0002\u0010L\u001a\u000202\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010N¢\u0006\u0005\b}\u0010\u0080\u0001B¨\u0001\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010,\u001a\u00020+\u0012\b\b\u0002\u00103\u001a\u000202\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010?\u001a\u00020+\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010B\u0012\b\b\u0002\u0010I\u001a\u000202\u0012\b\b\u0002\u0010L\u001a\u000202\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010N¢\u0006\u0005\b}\u0010\u0081\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010,\u001a\u00020+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u00109\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u00104\u001a\u0004\b:\u00106\"\u0004\b;\u00108R$\u0010<\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010\u0004\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR\"\u0010?\u001a\u00020+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010-\u001a\u0004\b@\u0010/\"\u0004\bA\u00101R$\u0010C\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010I\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u00104\u001a\u0004\bJ\u00106\"\u0004\bK\u00108R\"\u0010L\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u00104\u001a\u0004\bL\u00106\"\u0004\bM\u00108R$\u0010O\u001a\u0004\u0018\u00010N8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR*\u0010V\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010U8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\"\u0010]\u001a\u00020\\8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\"\u0010d\u001a\u00020c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\"\u0010k\u001a\u00020j8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\"\u0010r\u001a\u00020q8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\br\u0010s\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\"\u0010x\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bx\u00104\u001a\u0004\by\u00106\"\u0004\bz\u00108¨\u0006\u0083\u0001"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYSetupInfo;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "", "aid", "Ljava/lang/String;", "getAid", "()Ljava/lang/String;", "setAid", "(Ljava/lang/String;)V", "appVersion", "getAppVersion", "setAppVersion", "channel", "getChannel", "setChannel", "Lcom/bytedance/pitaya/api/PTYDIDCallback;", "didCallback", "Lcom/bytedance/pitaya/api/PTYDIDCallback;", "getDidCallback", "()Lcom/bytedance/pitaya/api/PTYDIDCallback;", "setDidCallback", "(Lcom/bytedance/pitaya/api/PTYDIDCallback;)V", "Lcom/bytedance/pitaya/api/PTYUIDCallback;", "uidCallback", "Lcom/bytedance/pitaya/api/PTYUIDCallback;", "getUidCallback", "()Lcom/bytedance/pitaya/api/PTYUIDCallback;", "setUidCallback", "(Lcom/bytedance/pitaya/api/PTYUIDCallback;)V", "Lcom/bytedance/pitaya/api/PTYPackageFilterCallback;", "packageFilterCallback", "Lcom/bytedance/pitaya/api/PTYPackageFilterCallback;", "getPackageFilterCallback", "()Lcom/bytedance/pitaya/api/PTYPackageFilterCallback;", "setPackageFilterCallback", "(Lcom/bytedance/pitaya/api/PTYPackageFilterCallback;)V", "Lcom/bytedance/pitaya/api/PTYSettingsCallback;", "settingsCallback", "Lcom/bytedance/pitaya/api/PTYSettingsCallback;", "getSettingsCallback", "()Lcom/bytedance/pitaya/api/PTYSettingsCallback;", "setSettingsCallback", "(Lcom/bytedance/pitaya/api/PTYSettingsCallback;)V", "", "downloadConcurrency", "I", "getDownloadConcurrency", "()I", "setDownloadConcurrency", "(I)V", "", "autoRequestUpdate", "Z", "getAutoRequestUpdate", "()Z", "setAutoRequestUpdate", "(Z)V", "idleDownloadEnable", "getIdleDownloadEnable", "setIdleDownloadEnable", "pluginVersion", "getPluginVersion", "setPluginVersion", "pyConcurrency", "getPyConcurrency", "setPyConcurrency", "Lcom/bytedance/pitaya/api/PTYPyBinderCallback;", "pyBinder", "Lcom/bytedance/pitaya/api/PTYPyBinderCallback;", "getPyBinder", "()Lcom/bytedance/pitaya/api/PTYPyBinderCallback;", "setPyBinder", "(Lcom/bytedance/pitaya/api/PTYPyBinderCallback;)V", "flEnable", "getFlEnable", "setFlEnable", "isDebugMode", "setDebugMode", "Lcom/bytedance/pitaya/api/PTYCustomURLHost;", "customURLHost", "Lcom/bytedance/pitaya/api/PTYCustomURLHost;", "getCustomURLHost", "()Lcom/bytedance/pitaya/api/PTYCustomURLHost;", "setCustomURLHost", "(Lcom/bytedance/pitaya/api/PTYCustomURLHost;)V", "", "moduleList", "Ljava/util/List;", "getModuleList", "()Ljava/util/List;", "setModuleList", "(Ljava/util/List;)V", "Lcom/bytedance/pitaya/api/bean/PTYSetupMode;", "setupMode", "Lcom/bytedance/pitaya/api/bean/PTYSetupMode;", "getSetupMode", "()Lcom/bytedance/pitaya/api/bean/PTYSetupMode;", "setSetupMode", "(Lcom/bytedance/pitaya/api/bean/PTYSetupMode;)V", "Lcom/bytedance/pitaya/api/bean/PTYCleanStrategy;", "cleanStrategy", "Lcom/bytedance/pitaya/api/bean/PTYCleanStrategy;", "getCleanStrategy", "()Lcom/bytedance/pitaya/api/bean/PTYCleanStrategy;", "setCleanStrategy", "(Lcom/bytedance/pitaya/api/bean/PTYCleanStrategy;)V", "Lcom/bytedance/pitaya/api/bean/PTYCepMode;", "cepMode", "Lcom/bytedance/pitaya/api/bean/PTYCepMode;", "getCepMode", "()Lcom/bytedance/pitaya/api/bean/PTYCepMode;", "setCepMode", "(Lcom/bytedance/pitaya/api/bean/PTYCepMode;)V", "", "appStartTime", "J", "getAppStartTime", "()J", "setAppStartTime", "(J)V", "enableResourcePolicyCheck", "getEnableResourcePolicyCheck", "setEnableResourcePolicyCheck", "Lcom/bytedance/pitaya/api/bean/PTYSetupInfo$a;", "builder", "<init>", "(Lcom/bytedance/pitaya/api/bean/PTYSetupInfo$a;)V", "()V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/pitaya/api/PTYDIDCallback;Lcom/bytedance/pitaya/api/PTYUIDCallback;Lcom/bytedance/pitaya/api/PTYPackageFilterCallback;Lcom/bytedance/pitaya/api/PTYSettingsCallback;IZZLjava/lang/String;ILcom/bytedance/pitaya/api/PTYPyBinderCallback;ZZLcom/bytedance/pitaya/api/PTYCustomURLHost;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/pitaya/api/PTYDIDCallback;Lcom/bytedance/pitaya/api/PTYUIDCallback;Lcom/bytedance/pitaya/api/PTYPackageFilterCallback;Lcom/bytedance/pitaya/api/PTYSettingsCallback;IZLjava/lang/String;ILcom/bytedance/pitaya/api/PTYPyBinderCallback;ZZLcom/bytedance/pitaya/api/PTYCustomURLHost;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "pitayacore_release"}, k = 1, mv = {1, 7, 1})
public final class PTYSetupInfo implements ReflectionCall {
    private String aid;
    private long appStartTime;
    private String appVersion;
    private boolean autoRequestUpdate;
    private PTYCepMode cepMode;
    private String channel;
    private PTYCleanStrategy cleanStrategy;
    private PTYCustomURLHost customURLHost;
    private PTYDIDCallback didCallback;
    private int downloadConcurrency;
    private boolean enableResourcePolicyCheck;
    private boolean flEnable;
    private boolean idleDownloadEnable;
    private boolean isDebugMode;
    private List<String> moduleList;
    private PTYPackageFilterCallback packageFilterCallback;
    private String pluginVersion;
    private PTYPyBinderCallback pyBinder;
    private int pyConcurrency;
    private PTYSettingsCallback settingsCallback;
    private PTYSetupMode setupMode;
    private PTYUIDCallback uidCallback;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f266526a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f266527b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f266528c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public PTYDIDCallback f266529d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public PTYUIDCallback f266530e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public PTYPackageFilterCallback f266531f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public PTYSettingsCallback f266532g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f266533h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f266534i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f266535j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f266536k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public PTYPyBinderCallback f266537l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f266538m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f266539n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public PTYCustomURLHost f266540o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final PTYSetupMode f266541p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final PTYCleanStrategy f266542q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final PTYCepMode f266543r;

        public a() {
            this.f266526a = "";
            this.f266527b = "";
            this.f266528c = "";
            this.f266533h = 2;
            this.f266534i = true;
            this.f266536k = 2;
            this.f266541p = PTYSetupMode.Normal;
            this.f266542q = PTYCleanStrategy.Normal;
            this.f266543r = PTYCepMode.Dependent;
        }
    }

    public /* synthetic */ PTYSetupInfo(a r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    @Deprecated(message = "Use PTYSetupInfo.Builder instead")
    public PTYSetupInfo() {
        this(new a());
    }

    public final String getAid() {
        return this.aid;
    }

    public final long getAppStartTime() {
        return this.appStartTime;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final boolean getAutoRequestUpdate() {
        return this.autoRequestUpdate;
    }

    public final PTYCepMode getCepMode() {
        return this.cepMode;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final PTYCleanStrategy getCleanStrategy() {
        return this.cleanStrategy;
    }

    public final PTYCustomURLHost getCustomURLHost() {
        return this.customURLHost;
    }

    public final PTYDIDCallback getDidCallback() {
        return this.didCallback;
    }

    public final int getDownloadConcurrency() {
        return this.downloadConcurrency;
    }

    public final boolean getEnableResourcePolicyCheck() {
        return this.enableResourcePolicyCheck;
    }

    public final boolean getFlEnable() {
        return this.flEnable;
    }

    public final boolean getIdleDownloadEnable() {
        return this.idleDownloadEnable;
    }

    public final List<String> getModuleList() {
        return this.moduleList;
    }

    public final PTYPackageFilterCallback getPackageFilterCallback() {
        return this.packageFilterCallback;
    }

    public final String getPluginVersion() {
        return this.pluginVersion;
    }

    public final PTYPyBinderCallback getPyBinder() {
        return this.pyBinder;
    }

    public final int getPyConcurrency() {
        return this.pyConcurrency;
    }

    public final PTYSettingsCallback getSettingsCallback() {
        return this.settingsCallback;
    }

    public final PTYSetupMode getSetupMode() {
        return this.setupMode;
    }

    public final PTYUIDCallback getUidCallback() {
        return this.uidCallback;
    }

    public final boolean isDebugMode() {
        return this.isDebugMode;
    }

    private PTYSetupInfo(a r100) {
        this.aid = "";
        this.appVersion = "";
        this.channel = "";
        this.downloadConcurrency = 2;
        this.autoRequestUpdate = true;
        this.pyConcurrency = 2;
        this.setupMode = PTYSetupMode.Normal;
        this.cleanStrategy = PTYCleanStrategy.Normal;
        this.cepMode = PTYCepMode.Dependent;
        this.aid = r100.f266526a;
        this.appVersion = r100.f266527b;
        this.channel = r100.f266528c;
        this.didCallback = r100.f266529d;
        this.uidCallback = r100.f266530e;
        this.packageFilterCallback = r100.f266531f;
        this.settingsCallback = r100.f266532g;
        this.downloadConcurrency = r100.f266533h;
        this.autoRequestUpdate = r100.f266534i;
        this.idleDownloadEnable = false;
        this.pluginVersion = r100.f266535j;
        this.pyConcurrency = r100.f266536k;
        this.pyBinder = r100.f266537l;
        this.flEnable = r100.f266538m;
        this.isDebugMode = r100.f266539n;
        this.customURLHost = r100.f266540o;
        this.moduleList = null;
        this.setupMode = r100.f266541p;
        this.cleanStrategy = r100.f266542q;
        this.cepMode = r100.f266543r;
        this.appStartTime = 0;
        this.enableResourcePolicyCheck = false;
    }

    public final void setAid(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.aid = r100;
    }

    public final void setAppStartTime(long r100) {
        this.appStartTime = r100;
    }

    public final void setAppVersion(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.appVersion = r100;
    }

    public final void setAutoRequestUpdate(boolean r100) {
        this.autoRequestUpdate = r100;
    }

    public final void setCepMode(PTYCepMode r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cepMode = r100;
    }

    public final void setChannel(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.channel = r100;
    }

    public final void setCleanStrategy(PTYCleanStrategy r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cleanStrategy = r100;
    }

    public final void setCustomURLHost(PTYCustomURLHost r100) {
        this.customURLHost = r100;
    }

    public final void setDebugMode(boolean r100) {
        this.isDebugMode = r100;
    }

    public final void setDidCallback(PTYDIDCallback r100) {
        this.didCallback = r100;
    }

    public final void setDownloadConcurrency(int r100) {
        this.downloadConcurrency = r100;
    }

    public final void setEnableResourcePolicyCheck(boolean r100) {
        this.enableResourcePolicyCheck = r100;
    }

    public final void setFlEnable(boolean r100) {
        this.flEnable = r100;
    }

    public final void setIdleDownloadEnable(boolean r100) {
        this.idleDownloadEnable = r100;
    }

    public final void setModuleList(List<String> r100) {
        this.moduleList = r100;
    }

    public final void setPackageFilterCallback(PTYPackageFilterCallback r100) {
        this.packageFilterCallback = r100;
    }

    public final void setPluginVersion(String r100) {
        this.pluginVersion = r100;
    }

    public final void setPyBinder(PTYPyBinderCallback r100) {
        this.pyBinder = r100;
    }

    public final void setPyConcurrency(int r100) {
        this.pyConcurrency = r100;
    }

    public final void setSettingsCallback(PTYSettingsCallback r100) {
        this.settingsCallback = r100;
    }

    public final void setSetupMode(PTYSetupMode r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.setupMode = r100;
    }

    public final void setUidCallback(PTYUIDCallback r100) {
        this.uidCallback = r100;
    }

    @Deprecated(message = "Use PTYSetupInfo.Builder instead")
    public PTYSetupInfo(String r100, String r101, String r102, PTYDIDCallback r103, PTYUIDCallback r110, PTYPackageFilterCallback r111, PTYSettingsCallback r112, int r113, boolean r114, String r115, int r116, PTYPyBinderCallback r117, boolean r118, boolean r119, PTYCustomURLHost r210) {
        Intrinsics.checkNotNullParameter(r100, "aid");
        Intrinsics.checkNotNullParameter(r101, "appVersion");
        Intrinsics.checkNotNullParameter(r102, "channel");
        this(new a());
        this.aid = r100;
        this.appVersion = r101;
        this.channel = r102;
        this.didCallback = r103;
        this.uidCallback = r110;
        this.packageFilterCallback = r111;
        this.settingsCallback = r112;
        this.downloadConcurrency = r113;
        this.autoRequestUpdate = r114;
        this.pluginVersion = r115;
        this.pyConcurrency = r116;
        this.pyBinder = r117;
        this.flEnable = r118;
        this.isDebugMode = r119;
        this.customURLHost = r210;
    }

    @Deprecated(message = "Use PTYSetupInfo.Builder instead")
    public PTYSetupInfo(String r100, String r101, String r102, PTYDIDCallback r103, PTYUIDCallback r110, PTYPackageFilterCallback r111, PTYSettingsCallback r112, int r113, boolean r114, boolean r115, String r116, int r117, PTYPyBinderCallback r118, boolean r119, boolean r210, PTYCustomURLHost r211) {
        Intrinsics.checkNotNullParameter(r100, "aid");
        Intrinsics.checkNotNullParameter(r101, "appVersion");
        Intrinsics.checkNotNullParameter(r102, "channel");
        this(new a());
        this.aid = r100;
        this.appVersion = r101;
        this.channel = r102;
        this.didCallback = r103;
        this.uidCallback = r110;
        this.packageFilterCallback = r111;
        this.settingsCallback = r112;
        this.downloadConcurrency = r113;
        this.autoRequestUpdate = r114;
        this.idleDownloadEnable = r115;
        this.pluginVersion = r116;
        this.pyConcurrency = r117;
        this.pyBinder = r118;
        this.flEnable = r119;
        this.isDebugMode = r210;
        this.customURLHost = r211;
    }

    public /* synthetic */ PTYSetupInfo(String r210, String r211, String r212, PTYDIDCallback r213, PTYUIDCallback r214, PTYPackageFilterCallback r215, PTYSettingsCallback r216, int r217, boolean r218, String r219, int r310, PTYPyBinderCallback r311, boolean r312, boolean r313, PTYCustomURLHost r314, int r315, DefaultConstructorMarker r316) {
        if ((r315 & 8) == 0) goto L5;
        PTYDIDCallback r100 = null;
    L7:
        if ((r315 & 16) == 0) goto L9;
        PTYUIDCallback r101 = null;
    L11:
        if ((r315 & 32) == 0) goto L13;
        PTYPackageFilterCallback r102 = null;
    L15:
        if ((r315 & 64) == 0) goto L17;
        PTYSettingsCallback r110 = null;
    L19:
        if ((r315 & 128) == 0) goto L21;
        int r111 = 2;
    L23:
        if ((r315 & 256) == 0) goto L25;
        boolean r112 = true;
    L27:
        if ((r315 & 512) == 0) goto L29;
        String r113 = null;
    L31:
        if ((r315 & 1024) == 0) goto L33;
        int r114 = 2;
    L35:
        if ((r315 & 2048) == 0) goto L37;
        PTYPyBinderCallback r115 = null;
    L39:
        if ((r315 & 4096) == 0) goto L41;
        boolean r116 = false;
    L43:
        if ((r315 & 8192) == 0) goto L45;
        boolean r117 = false;
    L47:
        if ((r315 & 16384) == 0) goto L49;
        PTYCustomURLHost r118 = null;
    L50:
        this(r210, r211, r212, r100, r101, r102, r110, r111, r112, r113, r114, r115, r116, r117, r118);
        return;
    L49:
        r118 = r314;
        goto L50
    L45:
        r117 = r313;
        goto L47
    L41:
        r116 = r312;
        goto L43
    L37:
        r115 = r311;
        goto L39
    L33:
        r114 = r310;
        goto L35
    L29:
        r113 = r219;
        goto L31
    L25:
        r112 = r218;
        goto L27
    L21:
        r111 = r217;
        goto L23
    L17:
        r110 = r216;
        goto L19
    L13:
        r102 = r215;
        goto L15
    L9:
        r101 = r214;
        goto L11
    L5:
        r100 = r213;
        goto L7
    }

    public /* synthetic */ PTYSetupInfo(String r210, String r211, String r212, PTYDIDCallback r213, PTYUIDCallback r214, PTYPackageFilterCallback r215, PTYSettingsCallback r216, int r217, boolean r218, boolean r310, String r311, int r312, PTYPyBinderCallback r313, boolean r314, boolean r315, PTYCustomURLHost r316, int r317, DefaultConstructorMarker r318) {
        if ((r317 & 8) == 0) goto L5;
        PTYDIDCallback r100 = null;
    L7:
        if ((r317 & 16) == 0) goto L9;
        PTYUIDCallback r101 = null;
    L11:
        if ((r317 & 32) == 0) goto L13;
        PTYPackageFilterCallback r102 = null;
    L15:
        if ((r317 & 64) == 0) goto L17;
        PTYSettingsCallback r110 = null;
    L19:
        if ((r317 & 128) == 0) goto L21;
        int r111 = 2;
    L23:
        if ((r317 & 256) == 0) goto L25;
        boolean r112 = true;
    L27:
        if ((r317 & 512) == 0) goto L29;
        boolean r113 = false;
    L31:
        if ((r317 & 1024) == 0) goto L33;
        String r114 = null;
    L35:
        if ((r317 & 2048) == 0) goto L37;
        int r115 = 2;
    L39:
        if ((r317 & 4096) == 0) goto L41;
        PTYPyBinderCallback r116 = null;
    L43:
        if ((r317 & 8192) == 0) goto L45;
        boolean r117 = false;
    L47:
        if ((r317 & 16384) == 0) goto L49;
        boolean r118 = false;
    L51:
        if ((r317 & 32768) == 0) goto L53;
        PTYCustomURLHost r119 = null;
    L54:
        this(r210, r211, r212, r100, r101, r102, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119);
        return;
    L53:
        r119 = r316;
        goto L54
    L49:
        r118 = r315;
        goto L51
    L45:
        r117 = r314;
        goto L47
    L41:
        r116 = r313;
        goto L43
    L37:
        r115 = r312;
        goto L39
    L33:
        r114 = r311;
        goto L35
    L29:
        r113 = r310;
        goto L31
    L25:
        r112 = r218;
        goto L27
    L21:
        r111 = r217;
        goto L23
    L17:
        r110 = r216;
        goto L19
    L13:
        r102 = r215;
        goto L15
    L9:
        r101 = r214;
        goto L11
    L5:
        r100 = r213;
        goto L7
    }
}
