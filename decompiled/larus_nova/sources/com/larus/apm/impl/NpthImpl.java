package com.larus.apm.impl;

import ai4.n;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm.d;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICommonParams;
import com.bytedance.crash.ICrashCallback;
import com.bytedance.crash.Npth;
import com.bytedance.crash.a0;
import com.bytedance.crash.r;
import com.bytedance.crash.runtime.ConfigManager;
import com.bytedance.keva.Keva;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.larus.apm.api.IApmConfigs;
import com.larus.apm.api.IExtraParams;
import com.larus.apm.api.INpth;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.common.spi.alog.ObricAlogServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import ec9.d0;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import q48.o;
import q48.p;
import q48.q;
import q48.s;
import v48.e;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/apm/impl/NpthImpl;", "Lcom/larus/apm/api/INpth;", "<init>", "()V", "init", "", "baseCtx", "Landroid/content/Context;", "deviceIdKV", "Lcom/bytedance/keva/Keva;", "trySaveDeviceIdToKeva", "getDeviceIdFromKeva", "", "getDeviceIdForNpth", "registerExitReasonCallback", "addAttachUserData", "registerCrashCallbackOnResNotFound", "registerCrashCallback", "getCurrentDateString", "crashCallback", "Lcom/larus/apm/api/ICrashCallback;", "getProcessNameFromCmd", "stopUpload", "stop", "", "goUpload", "startNpthLifecycleRecorder", "app", "Landroid/app/Application;", "maxLifeCycleCount", "", "enableGwpAsan", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NpthImpl implements INpth {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f286962c = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Keva f286963b;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static final class b implements ICommonParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NpthImpl f286964a;

        @Override // com.bytedance.crash.ICommonParams
        public final List<String> getPatchInfo() {
            return null;
        }

        @Override // com.bytedance.crash.ICommonParams
        public final Map<String, Integer> getPluginInfo() {
            return null;
        }

        @Override // com.bytedance.crash.ICommonParams
        public final Map<String, Object> getCommonParams() {
            HashMap r100 = new HashMap();
            AppHost.Companion r101 = AppHost.f326268a;
            r100.put("aid", Integer.valueOf(r101.getAppId()));
            r100.put("channel", r101.getBuildChannel());
            r100.put("app_version", r101.getVersionName());
            r100.put("version_code", Integer.valueOf(r101.getVersionCode()));
            r100.put("update_version_code", Integer.valueOf(r101.getUpdateVersionCode()));
            String r102 = Locale.getDefault().getCountry();
            if (TextUtils.isEmpty(r102) == true) goto L5;
            Npth.addTag(EffectConfiguration.KEY_REGION, r102);
            r100.put(EffectConfiguration.KEY_REGION, r102);
        L5:
            r100.put("flow_app_variant", IExtraParams.f286942a.b());
            return r100;
        }

        @Override // com.bytedance.crash.ICommonParams
        public final String getDeviceId() {
            NpthImpl r100 = this.f286964a;
            int r101 = NpthImpl.f286962c;
            r100.getClass();
            String r102 = IApplog.f287053a.getDeviceId();
            if (TextUtils.isEmpty(r102) == true) goto L8;
            if (Intrinsics.areEqual("0", r102) == true) goto L8;
            FLogger.f375446a.i("NpthImpl", "getDeviceIdForNpth: GetDeviceId from AppLog success");
            return r102;
        L8:
            return r100.e();
        }

        @Override // com.bytedance.crash.ICommonParams
        public final String getSessionId() {
            return IApplog.f287053a.getSessionId();
        }

        @Override // com.bytedance.crash.ICommonParams
        public final long getUserId() {
            Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L9
            Long r101 = StringsKt.toLongOrNull(IApplog.f287053a.getUserID());     // Catch: Throwable -> L9
            if (r101 == null) goto L6;
            long r102 = r101.longValue();     // Catch: Throwable -> L9
        L7:
            Object r103 = Result.m9449constructorimpl(Long.valueOf(r102));     // Catch: Throwable -> L9
        L12:
            if (Result.m9455isFailureimpl(r103) == false) goto L15;
            r103 = 0L;
        L15:
            return ((Number) r103).longValue();
        L6:
            r102 = 0;
        L9:
            th = move-exception;
            Result.Companion r104 = Result.Companion;
            r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L12
        }

        public b(NpthImpl r100) {
            this.f286964a = r100;
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static final class c implements e {
        public c() {
        }

        @Override // v48.e
        public final void onGetId(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_DID);
            Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_INSTALL_ID);
            Intrinsics.checkNotNullParameter(r102, "ssid");
            wh4.e r103 = a0.a();
            if (TextUtils.isEmpty(r103.f559656a) == false) goto L5;
        L7:
            boolean r104 = false;
        L8:
            if (r104 == false) goto L10;
            return;
        L10:
            if (TextUtils.isEmpty(r100) == false) goto L12;
            return;
        L12:
            if (Intrinsics.areEqual("0", r100) == true) goto L17;
            a0.a().f559656a = r100;
            return;
        L17:
            return;
        L5:
            if ("0".equals(r103.f559656a) == true) goto L7;
            r104 = true;
            goto L8
        }
    }

    static {
    }

    @Override // com.larus.apm.api.INpth
    public final void d() {
        Npth.enableGwpAsan(true);
    }

    public static String f() {
        BufferedReader r100 = new BufferedReader(new PolarisFileReaderWrapper("/proc/" + Process.myPid() + "/cmdline"));     // Catch: Throwable -> L26
        String r101 = r100.readLine();     // Catch: Throwable -> L25
        if (TextUtils.isEmpty(r101) == true) goto L32;
        Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L25
        int r102 = r101.length() - 1;     // Catch: Throwable -> L25
        int r103 = 0;
        boolean r104 = false;
    L7:
        if (r103 > r102) goto L22;
        if (r104 == true) goto L10;
        int r105 = r103;
    L12:
        if (Intrinsics.compare(r101.charAt(r105), 32) > 0) goto L14;
        boolean r106 = true;
    L15:
        if (r104 == false) goto L16;
        if (r106 == false) goto L22;
        r102 = r102 - 1;     // Catch: Throwable -> L25
        goto L7
    L16:
        if (r106 == false) goto L17;
        r103 = r103 + 1;     // Catch: Throwable -> L25
        goto L7
    L17:
        r104 = true;
        goto L7
    L14:
        r106 = false;
        goto L15
    L10:
        r105 = r102;
    L22:
        r101 = r101.subSequence(r103, r102 + 1).toString();     // Catch: Throwable -> L25
    L32:
        r100.close();     // Catch: IOException -> L30
    L24:
        return r101;
    L27:
        if (r100 != null) goto L34;
    L29:
        return null;
    L34:
        r100.close();     // Catch: IOException -> L31
    L26:
        r100 = null;
        goto L27
    }

    public final String e() {
        String r100 = this.f286963b.getString("latest_did", "");
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L7:
        FLogger.f375446a.i("NpthImpl", "getDeviceIdFromKeva latest_did empty");
    L8:
        Intrinsics.checkNotNull(r100);
        return r100;
    L5:
        if (Intrinsics.areEqual("0", r100) == true) goto L7;
        FLogger.f375446a.i("NpthImpl", "getDeviceIdFromKeva latest_did success");
        goto L8
    }

    public NpthImpl() {
        this.f286963b = Keva.getRepo("device_id_repo", 1);
    }

    @Override // com.larus.apm.api.INpth
    public final void b(final d0 r100) {
        Intrinsics.checkNotNullParameter(r100, "crashCallback");
        Npth.registerCrashCallback(new o(r100), CrashType.ALL);
    }

    @Override // com.larus.apm.api.INpth
    public final void c(boolean r100) {
        if (r100 == false) goto L5;
        Npth.stopUpload();
        return;
    }

    @Override // com.larus.apm.api.INpth
    public final void init(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "baseCtx");
        IApmConfigs r101 = (IApmConfigs) ServiceManager.get().getService(IApmConfigs.class);
        if (r101 == null) goto L11;
        ConfigManager r102 = Npth.getConfigManager();
        r102.setJavaCrashUploadUrl(r101.f());
        r102.setLaunchCrashUrl(r101.c());
        r102.setNativeCrashUrl(r101.d());
        r102.setAlogUploadUrl(r101.i());
        AppHost.Companion r103 = AppHost.f326268a;
        r102.setDebugMode(r103.isDebug());
        r102.setConfigGetUrl(r101.h());
        Npth.setApplication(r103.getApplication());
        com.bytedance.crash.util.b.f203406a = f();
        ObricAlogServiceDelegate.f387841b.d();
        Npth.init(r100, new b(this), true, true, true);
        IApplog.f287053a.j(new c());
        ICrashCallback r104 = new q(this);
        CrashType r105 = CrashType.ALL;
        Npth.registerCrashCallback(r104, r105);
        if (Build.VERSION.SDK_INT < 30) goto L8;
        r r106 = new p();
        n.f3779g.add(r106);
    L8:
        ICrashCallback r107 = new s();
        Npth.registerCrashCallback(r107, CrashType.JAVA);
        Npth.registerCrashCallback(r107, CrashType.LAUNCH);
        Npth.addAttachUserData(new q48.n(), r105);
        FLogger.f375446a.i("NpthImpl", "trySaveDeviceIdToKeva start delay 2s");
        t0.b(new q48.r(this), 2000);
        return;
    L11:
        throw new IllegalStateException();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.larus.apm.api.INpth
    public final void a(Application r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "app");
        NpthLifecycleRecoder r102 = NpthLifecycleRecoder.f286965a;
        AppHost.Companion r103 = AppHost.f326268a;
        Application r104 = r103.getApplication();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r104, "app");
        NpthLifecycleRecoder.f286971g = r104;
        NpthLifecycleRecoder.f286973i = r101;
        r102.a(r104, "onAppCreate, process:" + d.c() + ", " + r103.getAppId() + ' ' + r103.getBuildChannel() + ' ' + r103.getVersionName() + ' ' + r103.getVersionCode() + ' ' + r103.isDebug());
        r102.b(r104, "onAppCreate");
        r104.registerActivityLifecycleCallbacks(r102);
    }
}
