package com.ss.android.cert.manager;

import android.app.Activity;
import android.content.Context;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.cert.manager.ablity.ICertCompliance;
import com.ss.android.cert.manager.ablity.ICertMonitorConfig;
import com.ss.android.cert.manager.ablity.IEventParamsInterceptor;
import com.ss.android.cert.manager.ablity.IExceptionCallback;
import com.ss.android.cert.manager.ablity.INetWork;
import com.ss.android.cert.manager.ablity.IRequestExtraInterceptor;
import com.ss.android.cert.manager.ablity.RequestPermissionListener;
import com.ss.android.cert.manager.api.IAliyunCert;
import com.ss.android.cert.manager.api.IByteUserIdentity;
import com.ss.android.cert.manager.api.IBytedCert;
import com.ss.android.cert.manager.bpea.DefaultCertCompliance;
import com.ss.android.cert.manager.callback.CertCallback;
import com.ss.android.cert.manager.callback.CertResultCallback;
import com.ss.android.cert.manager.callback.UserIdentityResultCallback;
import com.ss.android.cert.manager.constants.ErrorConstant;
import com.ss.android.cert.manager.model.ByteUserIdentityResult;
import com.ss.android.cert.manager.model.CertResult;
import com.ss.android.cert.manager.utils.event.EventLogUtils;
import com.ss.android.cert.manager.utils.net.CertRequestUtils;
import com.ss.android.cert.manager.utils.net.CertResponse;
import dta.d;
import dta.e;
import el9.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class CertManager {
    private static final String COMPLIANCE_ADAPTER_CLASS = "com.ss.android.bytedcert.adapter.bpea.CertComplianceAdapter";
    private static final String MONITOR_ADAPTER_CLASS = "com.ss.android.bytedcert.adapter.monitor.CertMonitorAdapter";
    private static final String NETWORK_ADAPTER_CLASS = "com.ss.android.bytedcert.adapter.network.NetWorkAdapter";
    private static volatile CertManager instance;
    private IAliyunCert aliyunCert;
    private IByteUserIdentity byteUserIdentity;
    public IBytedCert bytedCert;
    private ICertCompliance certCompliance;
    private final Map<Class<?>, IEventParamsInterceptor> eventParamsInterceptors;
    private ICertMonitorConfig mCertMonitorConfig;
    private IExceptionCallback mExceptionCallback;
    private INetWork mNetWork;
    private RequestPermissionListener mRequestPermissionListener;
    private final Map<Class<?>, IRequestExtraInterceptor> requestExtraInterceptors;

    public static /* synthetic */ void a(CertManager r100, CertCallback r101, CertResponse r102) {
        r100.lambda$authDecision$1(r101, r102);
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static /* synthetic */ void b(CertManager r100, CertCallback r101, CertResponse r102) {
        r100.lambda$greyStrategy$0(r101, r102);
    }

    public static CertManager getInstance() {
        if (instance != null) goto L15;
        monitor-enter(CertManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new CertManager();     // Catch: Throwable -> L11
        EventLogUtils.eventSdkSessionLaunch();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CertManager.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    private void injectAdapter() {
        Object r100 = INVOKESTATIC_com_ss_android_cert_manager_CertManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(MONITOR_ADAPTER_CLASS).newInstance();     // Catch: Exception -> L6
        if ((r100 instanceof ICertMonitorConfig) == false) goto L15;
        this.mCertMonitorConfig = (ICertMonitorConfig) r100;     // Catch: Exception -> L6
    L15:
        Object r101 = INVOKESTATIC_com_ss_android_cert_manager_CertManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(NETWORK_ADAPTER_CLASS).newInstance();     // Catch: Exception -> L12
        if ((r101 instanceof INetWork) == false) goto L19;
        this.mNetWork = (INetWork) r101;     // Catch: Exception -> L12
        return;
    L19:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    private boolean isAliyunReady() {
        if (this.aliyunCert == null) goto L5;
        return true;
    L5:
        return false;
    }

    public Collection<IEventParamsInterceptor> getEventParamsInterceptors() {
        return this.eventParamsInterceptors.values();
    }

    public Collection<IRequestExtraInterceptor> getRequestExtraInterceptors() {
        return this.requestExtraInterceptors.values();
    }

    public boolean isByteUserIdentityReady() {
        if (this.byteUserIdentity == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBytedCertReady() {
        if (this.bytedCert == null) goto L5;
        return true;
    L5:
        return false;
    }

    private CertManager() {
        this.requestExtraInterceptors = new HashMap();
        this.eventParamsInterceptors = new HashMap();
        injectAdapter();
        injectComplianceAdapter(false);
    }

    public ICertCompliance getCertCompliance() {
        return this.certCompliance;
    }

    public IExceptionCallback getExceptionCallback() {
        return this.mExceptionCallback;
    }

    public ICertMonitorConfig getMonitor() {
        return this.mCertMonitorConfig;
    }

    public INetWork getNetWork() {
        return this.mNetWork;
    }

    public RequestPermissionListener getRequestPermissionListener() {
        return this.mRequestPermissionListener;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_cert_manager_CertManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public String getAliyunMetaInfos(Context r100) {
        if (isAliyunReady() == true) goto L5;
        return null;
    L5:
        return this.aliyunCert.getMetaInfos(r100);
    }

    public void injectComplianceAdapter(boolean r100) {
        if (r100 == false) goto L14;
        ICertCompliance r101 = this.certCompliance;
        if (r101 != null) goto L6;
    L17:
        Object r102 = INVOKESTATIC_com_ss_android_cert_manager_CertManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(COMPLIANCE_ADAPTER_CLASS).newInstance();     // Catch: Exception -> L11
        if ((r102 instanceof ICertCompliance) == false) goto L20;
        this.certCompliance = (ICertCompliance) r102;     // Catch: Exception -> L11
        return;
    L20:
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L6:
        if ((r101 instanceof DefaultCertCompliance) == true) goto L17;
        return;
    L14:
        if ((this.certCompliance instanceof DefaultCertCompliance) == true) goto L22;
        this.certCompliance = new DefaultCertCompliance();
        return;
    }

    public void registerAliyunCert(IAliyunCert r100) {
        this.aliyunCert = r100;
    }

    public void registerByteUserIdentity(IByteUserIdentity r100) {
        this.byteUserIdentity = r100;
    }

    public void registerBytedCert(IBytedCert r100) {
        this.bytedCert = r100;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getExtraInterceptor() == null) goto L8;
        this.requestExtraInterceptors.put(IBytedCert.class, r100.getExtraInterceptor());
    L8:
        if (r100.getEventParamsInterceptor() == null) goto L12;
        this.eventParamsInterceptors.put(IBytedCert.class, r100.getEventParamsInterceptor());
        return;
    }

    public void setCompliance(ICertCompliance r100) {
        this.certCompliance = r100;
    }

    public void setExceptionCallback(IExceptionCallback r100) {
        this.mExceptionCallback = r100;
    }

    public void setMonitor(ICertMonitorConfig r100) {
        this.mCertMonitorConfig = r100;
    }

    public void setNetWork(INetWork r100) {
        this.mNetWork = r100;
    }

    public void setRequestPermissionListener(RequestPermissionListener r100) {
        this.mRequestPermissionListener = r100;
    }

    private /* synthetic */ void lambda$authDecision$1(CertCallback r100, CertResponse r101) {
    L11:
        r100.callback(new CertResponse(ErrorConstant.Client.ERROR_GREY_STRATEGY_BLOCK));
        return;
    L3:
        if (r101.success == true) goto L5;
    L9:
        r100.callback(new CertResponse(ErrorConstant.Client.ERROR_GREY_STRATEGY_BLOCK));     // Catch: JSONException -> L11
    L13:
        return;
    L5:
        if (r101.jsonData == null) goto L9;
        if (isBytedCertReady() == false) goto L9;
        r100.callback(new CertResponse(true, new JSONObject(r101.jsonData.optString("decision_result"))));     // Catch: JSONException -> L11
        goto L13
    }

    private /* synthetic */ void lambda$greyStrategy$0(CertCallback r100, CertResponse r101) {
        if (r101.success == false) goto L11;
        JSONObject r102 = r101.jsonData;
        if (r102 == null) goto L11;
        if (r102.optInt(BdpAppEventConstant.PARAMS_STRATEGY_NAME) != 1) goto L11;
        if (isBytedCertReady() == false) goto L11;
        r100.callback(new CertResponse(true, r101.jsonData));
        return;
    L11:
        r100.callback(new CertResponse(ErrorConstant.Client.ERROR_GREY_STRATEGY_BLOCK));
    }

    public void authDecision(Map<String, String> r100, final CertCallback r101) {
        CertRequestUtils.authDecision(r100, new e(this, r101));
    }

    public void greyStrategy(String r100, final CertCallback r101) {
        HashMap r102 = new HashMap();
        r102.put("enter_from", r100);
        CertRequestUtils.getGreyStrategy(r102, new d(this, r101));
    }

    public boolean openAliyunFaceLive(Context r100, Map<String, String> r101, CertCallback r102) {
        if (isAliyunReady() == false) goto L6;
        this.aliyunCert.doFaceLiveness(r100, r101, r102);
        return true;
    L6:
        r102.callback(new CertResponse(ErrorConstant.Client.ERROR_CERT_UNREGISTER));
        return false;
    }

    public void startCertFlow(Activity r100, Map<String, String> r101, CertResultCallback r102) {
        if (isBytedCertReady() == false) goto L5;
        this.bytedCert.startCertFlow(r100, r101, r102);
        return;
    L5:
        r102.onCertResult(new CertResult(ErrorConstant.Client.ERROR_CERT_UNREGISTER));
    }

    public void startFaceLiveness(Activity r100, Map<String, String> r101, CertResultCallback r102) {
        if (isBytedCertReady() == false) goto L5;
        this.bytedCert.startFaceLiveness(r100, r101, r102);
        return;
    L5:
        r102.onCertResult(new CertResult(ErrorConstant.Client.ERROR_CERT_UNREGISTER));
    }

    public void startUserIdentityFlow(Activity r100, Map<String, String> r101, UserIdentityResultCallback r102) {
        if (isByteUserIdentityReady() == false) goto L5;
        this.byteUserIdentity.startFlow(r100, r101, r102);
        return;
    L5:
        r102.onResult(new ByteUserIdentityResult(((Integer) ErrorConstant.Client.ERROR_CERT_UNREGISTER.first).intValue(), (String) ErrorConstant.Client.ERROR_CERT_UNREGISTER.second));
    }
}
