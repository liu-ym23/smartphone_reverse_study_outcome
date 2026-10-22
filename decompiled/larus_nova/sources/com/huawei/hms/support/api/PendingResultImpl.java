package com.huawei.hms.support.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.huawei.hms.adapter.BaseAdapter;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.InnerPendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.huawei.hms.support.gentyref.GenericTypeReflector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.miui.easygo.constant.EasyGoConstant;
import java.lang.ref.WeakReference;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public abstract class PendingResultImpl<R extends Result, T extends IMessageEntity> extends InnerPendingResult<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CountDownLatch f277707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private R f277708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WeakReference<ApiClient> f277709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f277710d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f277711e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f277712f;
    protected DatagramTransport transport;

    public class a implements DatagramTransport.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PendingResultImpl f277713a;

        public a(PendingResultImpl r100) {
            this.f277713a = r100;
        }

        @Override // com.huawei.hms.support.api.transport.DatagramTransport.a
        public void a(int r100, IMessageEntity r101) {
            PendingResultImpl.a(this.f277713a, r100, r101);
            PendingResultImpl.a(this.f277713a).countDown();
        }
    }

    public class b implements DatagramTransport.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f277714a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ PendingResultImpl f277715b;

        public b(PendingResultImpl r100, AtomicBoolean r101) {
            this.f277715b = r100;
            this.f277714a = r101;
        }

        @Override // com.huawei.hms.support.api.transport.DatagramTransport.a
        public void a(int r100, IMessageEntity r101) {
            if (this.f277714a.get() == true) goto L5;
            PendingResultImpl.a(this.f277715b, r100, r101);
        L5:
            PendingResultImpl.a(this.f277715b).countDown();
        }
    }

    public class c implements DatagramTransport.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f277716a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ResultCallback f277717b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ PendingResultImpl f277718c;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.huawei.hms.support.api.transport.DatagramTransport.a
        public void a(int r100, IMessageEntity r101) {
            PendingResultImpl.a(this.f277718c, r100, r101);
            this.f277716a.a(this.f277717b, PendingResultImpl.b(this.f277718c));
        }

        public c(PendingResultImpl r100, d r101, ResultCallback r102) {
            this.f277718c = r100;
            this.f277716a = r101;
            this.f277717b = r102;
        }
    }

    public static class d<R extends Result> extends Handler {
        public d(Looper r100) {
            super(r100);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r100) {
            if (r100.what != 1) goto L7;
            Pair r101 = (Pair) r100.obj;
            b((ResultCallback) r101.first, (Result) r101.second);
            return;
        }

        public void a(ResultCallback<? super R> r100, R r101) {
            sendMessage(obtainMessage(1, new Pair(r100, r101)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void b(ResultCallback<? super R> r100, R r101) {
            r100.onResult(r101);
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public void cancel() {
    }

    public boolean checkApiClient(ApiClient r100) {
        return true;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public boolean isCanceled() {
        return false;
    }

    public abstract R onComplete(T r100);

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final R await() {
        HMSLog.i("PendingResultImpl", "await");
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        HMSLog.e("PendingResultImpl", "await in main thread");
        throw new IllegalStateException("await must not be called on the UI thread");
    L5:
        return (R) awaitOnAnyThread();
    }

    @Override // com.huawei.hms.support.api.client.InnerPendingResult
    public final R awaitOnAnyThread() {
        HMSLog.i("PendingResultImpl", "awaitOnAnyThread");
        WeakReference<ApiClient> r100 = this.f277709c;
        if (r100 != null) goto L6;
        HMSLog.e("PendingResultImpl", "api is null");
        a(CommonCode.ErrorCode.CLIENT_API_INVALID, null);
        return this.f277708b;
    L6:
        ApiClient r101 = r100.get();
        if (checkApiClient(r101) == true) goto L11;
        HMSLog.e("PendingResultImpl", "client invalid");
        a(CommonCode.ErrorCode.CLIENT_API_INVALID, null);
        return this.f277708b;
    L11:
        if (this.f277712f == false) goto L13;
        a(0, 1);
    L13:
        this.transport.send(r101, new a(this));
        this.f277707a.await();     // Catch: InterruptedException -> L16
    L18:
        return this.f277708b;
    L16:
        HMSLog.e("PendingResultImpl", "await in anythread InterruptedException");
        a(CommonCode.ErrorCode.INTERNAL_ERROR, null);
        goto L18
    }

    public Class<T> getResponseType() {
        Type r100 = getClass().getGenericSuperclass();
        if (r100 == null) goto L8;
        Type r101 = ((ParameterizedType) r100).getActualTypeArguments()[1];
        if (r101 != null) goto L7;
        return null;
    L7:
        return (Class) r101;
    L8:
        return null;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_huawei_hms_support_api_PendingResultImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
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

    public static /* synthetic */ CountDownLatch a(PendingResultImpl r100) {
        return r100.f277707a;
    }

    public static /* synthetic */ Result b(PendingResultImpl r100) {
        return r100.f277708b;
    }

    public R onError(int r100) {
        Type r101 = getClass().getGenericSuperclass();
        if (r101 == null) goto L5;
        Type r102 = ((ParameterizedType) r101).getActualTypeArguments()[0];
    L6:
        if (r102 == null) goto L8;
        Class<?> r103 = GenericTypeReflector.getType(r102);
    L9:
        if (r103 == null) goto L16;
        R r104 = (R) r103.newInstance();     // Catch: Exception -> L12
        this.f277708b = r104;     // Catch: Exception -> L12
        r104.setStatus(new Status(r100));     // Catch: Exception -> L12
    L12:
        e = move-exception;
        HMSLog.e("PendingResultImpl", "on Error:" + e.getMessage());
        return null;
    L16:
        return this.f277708b;
    L8:
        r103 = null;
        goto L9
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public void setResultCallback(ResultCallback<R> r100) {
        this.f277712f = !(r100 instanceof BaseAdapter.BaseRequestResultCallback);
        setResultCallback(Looper.getMainLooper(), r100);
    }

    private void a(int r100, int r101) {
        HMSLog.i("PendingResultImpl", "biReportEvent ====== ");
        ApiClient r102 = this.f277709c.get();
        if (r102 != null) goto L5;
    L31:
        HMSLog.e("PendingResultImpl", "<biReportEvent> has some error.");
        return;
    L5:
        if (this.f277710d == null) goto L31;
        if (HiAnalyticsUtil.getInstance().hasError(r102.getContext()) == true) goto L31;
        HashMap r103 = new HashMap();
        r103.put("package", r102.getPackageName());
        r103.put(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, "6.13.0.301");
        if (r101 != 1) goto L12;
        r103.put("direction", HiAnalyticsConstant.Direction.REQUEST);
    L17:
        r103.put("version", "0");
        String r104 = Util.getAppId(r102.getContext());
        if (TextUtils.isEmpty(r104) == false) goto L22;
        SubAppInfo r105 = r102.getSubAppInfo();
        if (r105 == null) goto L22;
        r104 = r105.getSubAppID();
    L22:
        r103.put("appid", r104);
        if (TextUtils.isEmpty(this.f277711e) == false) goto L25;
        String r106 = TransactionIdCreater.getId(r104, this.f277710d);
        this.f277711e = r106;
        r103.put(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, r106);
    L26:
        String[] r107 = this.f277710d.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        if (r107.length < 2) goto L29;
        r103.put("service", r107[0]);
        r103.put("apiName", r107[1]);
    L29:
        r103.put("callTime", String.valueOf(System.currentTimeMillis()));
        r103.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onEvent(r102.getContext(), HiAnalyticsConstant.HMS_SDK_BASE_CALL_AIDL, r103);
        return;
    L25:
        r103.put(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, this.f277711e);
        this.f277711e = null;
        goto L26
    L12:
        r103.put("direction", HiAnalyticsConstant.Direction.RESPONSE);
        r103.put("result", String.valueOf(r100));
        R r108 = this.f277708b;
        if (r108 == null) goto L17;
        if (r108.getStatus() == null) goto L17;
        r103.put("statusCode", String.valueOf(this.f277708b.getStatus().getStatusCode()));
        goto L17
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public R await(long r100, TimeUnit r101) {
        HMSLog.i("PendingResultImpl", "await timeout:" + r100 + " unit:" + r101.toString());
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        HMSLog.i("PendingResultImpl", "await in main thread");
        throw new IllegalStateException("await must not be called on the UI thread");
    L5:
        return (R) awaitOnAnyThread(r100, r101);
    }

    @Override // com.huawei.hms.support.api.client.InnerPendingResult
    public final R awaitOnAnyThread(long r100, TimeUnit r110) {
        HMSLog.i("PendingResultImpl", "awaitOnAnyThread timeout:" + r100 + " unit:" + r110.toString());
        WeakReference<ApiClient> r101 = this.f277709c;
        if (r101 != null) goto L6;
        HMSLog.e("PendingResultImpl", "api is null");
        a(CommonCode.ErrorCode.CLIENT_API_INVALID, null);
        return this.f277708b;
    L6:
        ApiClient r102 = r101.get();
        if (checkApiClient(r102) == true) goto L10;
        HMSLog.e("PendingResultImpl", "client invalid");
        a(CommonCode.ErrorCode.CLIENT_API_INVALID, null);
        return this.f277708b;
    L10:
        AtomicBoolean r103 = new AtomicBoolean();
        if (this.f277712f == false) goto L13;
        a(0, 1);
    L13:
        this.transport.post(r102, new b(this, r103));
    L18:
        HMSLog.e("PendingResultImpl", "awaitOnAnyThread InterruptedException");
        a(CommonCode.ErrorCode.INTERNAL_ERROR, null);
    L20:
        return this.f277708b;
    L15:
        if (this.f277707a.await(r100, r110) == true) goto L20;
        r103.set(true);     // Catch: InterruptedException -> L18
        a(CommonCode.ErrorCode.EXECUTE_TIMEOUT, null);     // Catch: InterruptedException -> L18
        goto L20
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final void setResultCallback(Looper r100, ResultCallback<R> r101) {
        HMSLog.i("PendingResultImpl", "setResultCallback");
        if (r100 != null) goto L5;
        r100 = Looper.myLooper();
    L5:
        d r102 = new d(r100);
        WeakReference<ApiClient> r103 = this.f277709c;
        if (r103 != null) goto L9;
        HMSLog.e("PendingResultImpl", "api is null");
        a(CommonCode.ErrorCode.CLIENT_API_INVALID, null);
        return;
    L9:
        ApiClient r104 = r103.get();
        if (checkApiClient(r104) == true) goto L14;
        HMSLog.e("PendingResultImpl", "client is invalid");
        a(CommonCode.ErrorCode.CLIENT_API_INVALID, null);
        r102.a(r101, this.f277708b);
        return;
    L14:
        if (this.f277712f == false) goto L16;
        a(0, 1);
    L16:
        this.transport.post(r104, new c(this, r102, r101));
    }

    private void a(int r100, IMessageEntity r110) {
        HMSLog.i("PendingResultImpl", "setResult:" + r100);
        if ((r110 instanceof AbstractMessageEntity) == false) goto L5;
        Status r101 = ((AbstractMessageEntity) r110).getCommonStatus();
    L6:
        if (r100 != 0) goto L8;
        this.f277708b = (R) onComplete(r110);
    L10:
        if (this.f277712f == false) goto L12;
        a(r100, 2);
    L12:
        R r102 = this.f277708b;
        if (r102 == null) goto L26;
        Status r103 = r102.getStatus();
        if (r103 == null) goto L27;
        if (r101 == null) goto L28;
        int r111 = r103.getStatusCode();
        String r104 = r103.getStatusMessage();
        int r105 = r101.getStatusCode();
        String r106 = r101.getStatusMessage();
        if (r111 == r105) goto L21;
        HMSLog.e("PendingResultImpl", "rstStatus code (" + r111 + ") is not equal commonStatus code (" + r105 + ")");
        HMSLog.e("PendingResultImpl", "rstStatus msg (" + r104 + ") is not equal commonStatus msg (" + r106 + ")");
        return;
    L21:
        if (TextUtils.isEmpty(r104) == true) goto L23;
        return;
    L23:
        if (TextUtils.isEmpty(r106) == true) goto L31;
        HMSLog.i("PendingResultImpl", "rstStatus msg (" + r104 + ") is not equal commonStatus msg (" + r106 + ")");
        this.f277708b.setStatus(new Status(r111, r106, r103.getResolution()));
        return;
    L31:
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L8:
        this.f277708b = (R) onError(r100);
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    public PendingResultImpl(ApiClient r100, String r101, IMessageEntity r110) {
        this.transport = null;
        this.f277708b = null;
        this.f277710d = null;
        this.f277711e = null;
        this.f277712f = true;
        a(r100, r101, r110, getResponseType(), 0);
    }

    public static /* synthetic */ void a(PendingResultImpl r100, int r101, IMessageEntity r102) {
        r100.a(r101, r102);
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public void setResultCallback(ResultCallback<R> r100, long r101, TimeUnit r102) {
        setResultCallback(r100);
    }

    public PendingResultImpl(ApiClient r100, String r101, IMessageEntity r110, int r111) {
        this.transport = null;
        this.f277708b = null;
        this.f277710d = null;
        this.f277711e = null;
        this.f277712f = true;
        a(r100, r101, r110, getResponseType(), r111);
    }

    public PendingResultImpl(ApiClient r100, String r101, IMessageEntity r110, Class<T> r111) {
        this.transport = null;
        this.f277708b = null;
        this.f277710d = null;
        this.f277711e = null;
        this.f277712f = true;
        a(r100, r101, r110, r111, 0);
    }

    private void a(ApiClient r100, String r110, IMessageEntity r111, Class<T> r112, int r113) {
        HMSLog.i("PendingResultImpl", "init uri:" + r110);
        this.f277710d = r110;
        if (r100 != null) goto L6;
        HMSLog.e("PendingResultImpl", "client is null");
        return;
    L6:
        this.f277709c = new WeakReference(r100);
        this.f277707a = new CountDownLatch(1);
        this.transport = (DatagramTransport) INVOKESTATIC_com_huawei_hms_support_api_PendingResultImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100.getTransportName()).getConstructor(new Class[]{String.class, IMessageEntity.class, Class.class, Integer.TYPE}).newInstance(new Object[]{r110, r111, r112, Integer.valueOf(r113)});     // Catch: ClassNotFoundException -> L9 NoSuchMethodException -> L11 Throwable -> L13 IllegalArgumentException -> L15 IllegalAccessException -> L17 InstantiationException -> L19
        return;
    L13:
        e = move-exception;
        HMSLog.e("PendingResultImpl", "gen transport error:" + e.getMessage());
        throw new IllegalStateException("Instancing transport exception, " + e.getMessage(), e);
    }
}
