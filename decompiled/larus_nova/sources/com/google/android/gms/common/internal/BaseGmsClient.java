package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.byted.cast.common.bean.State;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public abstract class BaseGmsClient<T extends IInterface> {
    public static final int CONNECT_STATE_CONNECTED = 4;
    public static final int CONNECT_STATE_DISCONNECTED = 1;
    public static final int CONNECT_STATE_DISCONNECTING = 5;
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = null;
    public static final String KEY_PENDING_INTENT = "pendingIntent";
    private static final Feature[] zze = null;
    private volatile String zzA;
    private ConnectionResult zzB;
    private boolean zzC;
    private volatile zzk zzD;

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    v f274493zza;

    /* JADX INFO: renamed from: zzb, reason: collision with root package name */
    final Handler f274494zzb;
    protected a zzc;
    protected AtomicInteger zzd;
    private int zzf;
    private long zzg;
    private long zzh;
    private int zzi;
    private long zzj;
    private volatile String zzk;
    private final Context zzl;
    private final Looper zzm;
    private final com.google.android.gms.common.internal.a zzn;
    private final GoogleApiAvailabilityLight zzo;
    private final Object zzp;
    private final Object zzq;
    private IGmsServiceBroker zzr;
    private IInterface zzs;
    private final ArrayList zzt;
    private j zzu;
    private int zzv;
    private final BaseConnectionCallbacks zzw;
    private final BaseOnConnectionFailedListener zzx;
    private final int zzy;
    private final String zzz;

    public interface BaseConnectionCallbacks {
        public static final int CAUSE_DEAD_OBJECT_EXCEPTION = 3;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected(Bundle r100);

        void onConnectionSuspended(int r100);
    }

    public interface BaseOnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult r100);
    }

    public interface a {
    }

    public class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseGmsClient f274495a;

        public b(BaseGmsClient r100) {
            this.f274495a = r100;
        }

        public final void a(ConnectionResult r100) {
            if (r100.isSuccess() == false) goto L7;
            BaseGmsClient r101 = this.f274495a;
            r101.getRemoteService(null, r101.getScopes());
            return;
        L7:
            if (BaseGmsClient.zzc(this.f274495a) == null) goto L10;
            BaseGmsClient.zzc(this.f274495a).onConnectionFailed(r100);
            return;
        }
    }

    public interface c {
        void a();
    }

    static {
        zze = new Feature[0];
        GOOGLE_PLUS_REQUIRED_FEATURES = new String[]{"service_esmobile", "service_googleme"};
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static /* bridge */ /* synthetic */ ConnectionResult zza(BaseGmsClient r100) {
        return r100.zzB;
    }

    public static /* bridge */ /* synthetic */ BaseConnectionCallbacks zzb(BaseGmsClient r100) {
        return r100.zzw;
    }

    public static /* bridge */ /* synthetic */ BaseOnConnectionFailedListener zzc(BaseGmsClient r100) {
        return r100.zzx;
    }

    public static /* bridge */ /* synthetic */ Object zzd(BaseGmsClient r100) {
        return r100.zzq;
    }

    public static /* bridge */ /* synthetic */ ArrayList zzf(BaseGmsClient r100) {
        return r100.zzt;
    }

    public static /* bridge */ /* synthetic */ void zzg(BaseGmsClient r100, ConnectionResult r101) {
        r100.zzB = r101;
    }

    public static /* bridge */ /* synthetic */ void zzh(BaseGmsClient r100, IGmsServiceBroker r101) {
        r100.zzr = r101;
    }

    public static /* bridge */ /* synthetic */ void zzi(BaseGmsClient r100, int r101, IInterface r102) {
        r100.zzp(r101, null);
    }

    public static /* bridge */ /* synthetic */ boolean zzm(BaseGmsClient r100) {
        return r100.zzC;
    }

    public abstract T createServiceInterface(IBinder r100);

    public boolean enableLocalFallback() {
        return false;
    }

    public Account getAccount() {
        return null;
    }

    public Feature[] getApiFeatures() {
        return zze;
    }

    public final Feature[] getAvailableFeatures() {
        zzk r100 = this.zzD;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f274577b;
    }

    public Executor getBindServiceExecutor() {
        return null;
    }

    public Bundle getConnectionHint() {
        return null;
    }

    public final Context getContext() {
        return this.zzl;
    }

    public int getGCoreServiceId() {
        return this.zzy;
    }

    public String getLastDisconnectMessage() {
        return this.zzk;
    }

    public String getLocalStartServiceAction() {
        return null;
    }

    public final Looper getLooper() {
        return this.zzm;
    }

    public abstract String getServiceDescriptor();

    public abstract String getStartServiceAction();

    public String getStartServicePackage() {
        return "com.google.android.gms";
    }

    public ConnectionTelemetryConfiguration getTelemetryConfiguration() {
        zzk r100 = this.zzD;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f274579d;
    }

    public boolean hasConnectionInfo() {
        if (this.zzD == null) goto L6;
        return true;
    L6:
        return false;
    }

    public boolean providesSignIn() {
        return false;
    }

    public boolean requiresAccount() {
        return false;
    }

    public boolean requiresGooglePlayServices() {
        return true;
    }

    public boolean requiresSignIn() {
        return false;
    }

    public void setAttributionTag(String r100) {
        this.zzA = r100;
    }

    public boolean usesClientTelemetry() {
        return false;
    }

    public void checkAvailabilityAndConnect() {
        int r100 = this.zzo.isGooglePlayServicesAvailable(this.zzl, getMinApkVersion());
        if (r100 == 0) goto L6;
        zzp(1, null);
        triggerNotAvailable(new b(this), r100, null);
        return;
    L6:
        connect(new b(this));
    }

    public void disconnect() {
        this.zzd.incrementAndGet();
        ArrayList r100 = this.zzt;
        monitor-enter(r100);
        int r101 = this.zzt.size();     // Catch: Throwable -> L19
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L7;
        ((i) this.zzt.get(r102)).c();     // Catch: Throwable -> L19
        r102 = r102 + 1;     // Catch: Throwable -> L19
        goto L5
    L7:
        this.zzt.clear();     // Catch: Throwable -> L19
        monitor-exit(r100);     // Catch: Throwable -> L19
        Object r103 = this.zzq;
        monitor-enter(r103);
        this.zzr = null;     // Catch: Throwable -> L16
        monitor-exit(r103);     // Catch: Throwable -> L16
        zzp(1, null);
        return;
    L16:
        th = move-exception;
        throw th;
    L19:
        th = move-exception;
        throw th;
    }

    public Bundle getGetServiceRequestExtraArgs() {
        return new Bundle();
    }

    public final T getService() throws DeadObjectException {
        Object r100 = this.zzp;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.zzv == 5) goto L10;
        checkConnected();     // Catch: Throwable -> L11
        T r101 = (T) this.zzs;
        Preconditions.checkNotNull(r101, "Client is connected but service is null");     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        return r101;
    L10:
        throw new DeadObjectException();     // Catch: Throwable -> L11
    }

    public IBinder getServiceBrokerBinder() {
        Object r100 = this.zzq;
        monitor-enter(r100);
        IGmsServiceBroker r101 = this.zzr;     // Catch: Throwable -> L12
        if (r101 != null) goto L9;
        monitor-exit(r100);     // Catch: Throwable -> L12
        return null;
    L9:
        IBinder r102 = r101.asBinder();     // Catch: Throwable -> L12
        monitor-exit(r100);     // Catch: Throwable -> L12
        return r102;
    L12:
        th = move-exception;
        throw th;
    }

    public Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public boolean isConnected() {
        Object r100 = this.zzp;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.zzv != 4) goto L7;
        boolean r101 = true;
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return r101;
    L7:
        r101 = false;
        goto L8
    }

    public boolean isConnecting() {
        Object r100 = this.zzp;
        monitor-enter(r100);
        int r101 = this.zzv;     // Catch: Throwable -> L12
        boolean r102 = true;
        if (r101 != 2) goto L7;
    L10:
        monitor-exit(r100);     // Catch: Throwable -> L12
        return r102;
    L7:
        if (r101 == 3) goto L10;
        r102 = false;
    L12:
        th = move-exception;
        throw th;
    }

    public final String zze() {
        String r100 = this.zzz;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return this.zzl.getClass().getName();
    }

    public final void checkConnected() {
        if (isConnected() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }

    public String getEndpointPackageName() {
        if (isConnected() == false) goto L9;
        v r100 = this.f274493zza;
        if (r100 == null) goto L9;
        return r100.f274570b;
    L9:
        throw new RuntimeException("Failed to connect when checking package");
    }

    public Set<Scope> getScopes() {
        return Collections.emptySet();
    }

    public boolean getUseDynamicLookup() {
        if (getMinApkVersion() < 211700000) goto L6;
        return true;
    L6:
        return false;
    }

    public int getMinApkVersion() {
        return GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_google_android_gms_common_internal_BaseGmsClient_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static /* bridge */ /* synthetic */ boolean zzo(BaseGmsClient r100) {
        if (r100.zzC == false) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(r100.getServiceDescriptor()) == false) goto L9;
        return false;
    L9:
        if (TextUtils.isEmpty(r100.getLocalStartServiceAction()) == true) goto L19;
        INVOKESTATIC_com_google_android_gms_common_internal_BaseGmsClient_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100.getServiceDescriptor());     // Catch: ClassNotFoundException -> L14
        return true;
    L20:
        return false;
    L19:
        return false;
    }

    public void connect(a r100) {
        Preconditions.checkNotNull(r100, "Connection progress callbacks cannot be null.");
        this.zzc = r100;
        zzp(2, null);
    }

    public void disconnect(String r100) {
        this.zzk = r100;
        disconnect();
    }

    public void onConnectedLocked(T r100) {
        this.zzh = System.currentTimeMillis();
    }

    public void onConnectionFailed(ConnectionResult r100) {
        this.zzi = r100.getErrorCode();
        this.zzj = System.currentTimeMillis();
    }

    public void onConnectionSuspended(int r100) {
        this.zzf = r100;
        this.zzg = System.currentTimeMillis();
    }

    public void onUserSignOut(c r100) {
        r100.a();
    }

    public void triggerConnectionSuspended(int r100) {
        int r101 = this.zzd.get();
        Message r102 = this.f274494zzb.obtainMessage(6, r101, r100);
        this.f274494zzb.sendMessage(r102);
    }

    public static void zzj(BaseGmsClient r100, zzk r101) {
        r100.zzD = r101;
        if (r100.usesClientTelemetry() == false) goto L19;
        ConnectionTelemetryConfiguration r102 = r101.f274579d;
        com.google.android.gms.common.internal.b r103 = com.google.android.gms.common.internal.b.f274530b;
        monitor-enter(com.google.android.gms.common.internal.b.class);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (com.google.android.gms.common.internal.b.f274530b != null) goto L9;
        com.google.android.gms.common.internal.b.f274530b = new com.google.android.gms.common.internal.b();     // Catch: Throwable -> L16
    L9:
        com.google.android.gms.common.internal.b r104 = com.google.android.gms.common.internal.b.f274530b;     // Catch: Throwable -> L16
        monitor-exit(com.google.android.gms.common.internal.b.class);
        if (r102 != null) goto L13;
        RootTelemetryConfiguration r105 = null;
    L14:
        r104.a(r105);
        return;
    L13:
        r105 = r102.f274497a;
        goto L14
    }

    public static /* bridge */ /* synthetic */ void zzk(BaseGmsClient r100, int r101) {
        Object r102 = r100.zzp;
        monitor-enter(r102);
        int r103 = r100.zzv;     // Catch: Throwable -> L12
        monitor-exit(r102);     // Catch: Throwable -> L12
        if (r103 != 3) goto L9;
        r100.zzC = true;
        int r104 = 5;
    L10:
        Handler r105 = r100.f274494zzb;
        r105.sendMessage(r105.obtainMessage(r104, r100.zzd.get(), 16));
        return;
    L9:
        r104 = 4;
    L12:
        th = move-exception;
        throw th;
    }

    private final void zzp(int r100, IInterface r110) {
        if (r100 == 4) goto L5;
        boolean r101 = false;
    L6:
        if (r110 != null) goto L8;
        boolean r102 = false;
    L9:
        if (r101 != r102) goto L11;
        boolean r103 = true;
    L12:
        Preconditions.checkArgument(r103);
        Object r104 = this.zzp;
        monitor-enter(r104);
        this.zzv = r100;     // Catch: Throwable -> L27
        this.zzs = r110;     // Catch: Throwable -> L27
        if (r100 != 1) goto L17;
        j r105 = this.zzu;     // Catch: Throwable -> L27
        if (r105 == null) goto L48;
        com.google.android.gms.common.internal.a r111 = this.zzn;     // Catch: Throwable -> L27
        String r106 = this.f274493zza.f274569a;     // Catch: Throwable -> L27
        Preconditions.checkNotNull(r106);     // Catch: Throwable -> L27
        String r107 = this.f274493zza.f274570b;     // Catch: Throwable -> L27
        zze();     // Catch: Throwable -> L27
        boolean r108 = this.f274493zza.f274571c;     // Catch: Throwable -> L27
        r111.getClass();     // Catch: Throwable -> L27
        r111.a(new q(r106, r107, r108), r105);     // Catch: Throwable -> L27
        this.zzu = null;     // Catch: Throwable -> L27
    L48:
        monitor-exit(r104);     // Catch: Throwable -> L27
        return;
    L17:
        if (r100 == 2) goto L22;
        if (r100 == 3) goto L22;
        if (r100 != 4) goto L48;
        Preconditions.checkNotNull(r110);     // Catch: Throwable -> L27
        onConnectedLocked(r110);     // Catch: Throwable -> L27
    L22:
        j r109 = this.zzu;     // Catch: Throwable -> L27
        if (r109 == null) goto L29;
        v r112 = this.f274493zza;     // Catch: Throwable -> L27
        if (r112 == null) goto L29;
        String r113 = r112.f274569a;     // Catch: Throwable -> L27
        com.google.android.gms.common.internal.a r114 = this.zzn;     // Catch: Throwable -> L27
        Preconditions.checkNotNull(r113);     // Catch: Throwable -> L27
        String r115 = this.f274493zza.f274570b;     // Catch: Throwable -> L27
        zze();     // Catch: Throwable -> L27
        boolean r116 = this.f274493zza.f274571c;     // Catch: Throwable -> L27
        r114.getClass();     // Catch: Throwable -> L27
        r114.a(new q(r113, r115, r116), r109);     // Catch: Throwable -> L27
        this.zzd.incrementAndGet();     // Catch: Throwable -> L27
    L29:
        j r117 = new j(this, this.zzd.get());     // Catch: Throwable -> L27
        this.zzu = r117;     // Catch: Throwable -> L27
        if (this.zzv == 3) goto L32;
    L34:
        v r118 = new v(getStartServicePackage(), getStartServiceAction(), getUseDynamicLookup());     // Catch: Throwable -> L27
    L35:
        this.f274493zza = r118;     // Catch: Throwable -> L27
        if (r118.f274571c == true) goto L38;
    L42:
        com.google.android.gms.common.internal.a r119 = this.zzn;     // Catch: Throwable -> L27
        String r120 = this.f274493zza.f274569a;     // Catch: Throwable -> L27
        Preconditions.checkNotNull(r120);     // Catch: Throwable -> L27
        String r121 = this.f274493zza.f274570b;     // Catch: Throwable -> L27
        String r122 = zze();     // Catch: Throwable -> L27
        boolean r123 = this.f274493zza.f274571c;     // Catch: Throwable -> L27
        Executor r124 = getBindServiceExecutor();     // Catch: Throwable -> L27
        if (r119.b(new q(r120, r121, r123), r117, r122, r124) == true) goto L48;
        String r125 = this.f274493zza.f274569a;     // Catch: Throwable -> L27
        zzl(16, null, this.zzd.get());     // Catch: Throwable -> L27
        goto L48
    L38:
        if (getMinApkVersion() >= 17895000) goto L42;
        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.f274493zza.f274569a)));     // Catch: Throwable -> L27
    L32:
        if (getLocalStartServiceAction() == null) goto L34;
        r118 = new v(getContext().getPackageName(), getLocalStartServiceAction(), false);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    L11:
        r103 = false;
        goto L12
    L8:
        r102 = true;
        goto L9
    L5:
        r101 = true;
        goto L6
    }

    public void getRemoteService(IAccountAccessor r210, Set<Scope> r211) {
        Bundle r100 = getGetServiceRequestExtraArgs();
        String r110 = this.zzA;
        int r101 = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        Scope[] r102 = GetServiceRequest.f274503o;
        Bundle r111 = new Bundle();
        int r103 = this.zzy;
        Feature[] r112 = GetServiceRequest.f274504p;
        GetServiceRequest r113 = new GetServiceRequest(6, r103, r101, null, null, r102, r111, null, r112, r112, true, 0, false, r110);
        r113.f274508d = this.zzl.getPackageName();
        r113.f274511g = r100;
        if (r211 == null) goto L6;
        r113.f274510f = (Scope[]) r211.toArray(new Scope[0]);
    L6:
        if (requiresSignIn() == false) goto L14;
        Account r104 = getAccount();
        if (r104 != null) goto L10;
        r104 = new Account("<<default account>>", "com.google");
    L10:
        r113.f274512h = r104;
        if (r210 == null) goto L16;
        r113.f274509e = r210.asBinder();
    L16:
        r113.f274513i = zze;
        r113.f274514j = getApiFeatures();
        if (usesClientTelemetry() == false) goto L37;
        r113.f274517m = true;
    L37:
        Object r105 = this.zzq;     // Catch: Throwable -> L29 SecurityException -> L31 DeadObjectException -> L33
        monitor-enter(r105);     // Catch: Throwable -> L29 SecurityException -> L31 DeadObjectException -> L33
        IGmsServiceBroker r106 = this.zzr;     // Catch: Throwable -> L26
        if (r106 == null) goto L24;
        r106.getService(new zzd(this, this.zzd.get()), r113);     // Catch: Throwable -> L26
    L24:
        monitor-exit(r105);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29 Throwable -> L29 SecurityException -> L31 DeadObjectException -> L33
    L29:
        onPostInitHandler(8, null, null, this.zzd.get());
        return;
    L33:
        triggerConnectionSuspended(3);
        return;
    L31:
        e = move-exception;
        throw e;
    L14:
        if (requiresAccount() == false) goto L16;
        r113.f274512h = getAccount();
        goto L16
    }

    public void triggerNotAvailable(a r100, int r101, PendingIntent r102) {
        Preconditions.checkNotNull(r100, "Connection progress callbacks cannot be null.");
        this.zzc = r100;
        int r103 = this.zzd.get();
        Message r104 = this.f274494zzb.obtainMessage(3, r103, r101, r102);
        this.f274494zzb.sendMessage(r104);
    }

    public final void zzl(int r100, Bundle r101, int r102) {
        l r103 = new l(this, r100);
        Message r104 = this.f274494zzb.obtainMessage(7, r102, -1, r103);
        this.f274494zzb.sendMessage(r104);
    }

    public static /* bridge */ /* synthetic */ boolean zzn(BaseGmsClient r100, int r101, int r102, IInterface r103) {
        Object r104 = r100.zzp;
        monitor-enter(r104);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (r100.zzv == r101) goto L8;
        monitor-exit(r104);     // Catch: Throwable -> L12
        return false;
    L8:
        r100.zzp(r102, r103);     // Catch: Throwable -> L12
        monitor-exit(r104);     // Catch: Throwable -> L12
        return true;
    }

    public void dump(String r110, FileDescriptor r111, PrintWriter r112, String[] r113) {
        Object r114 = this.zzp;
        monitor-enter(r114);
        int r115 = this.zzv;     // Catch: Throwable -> L53
        IInterface r100 = this.zzs;     // Catch: Throwable -> L53
        monitor-exit(r114);     // Catch: Throwable -> L53
        Object r101 = this.zzq;
        monitor-enter(r101);
        IGmsServiceBroker r116 = this.zzr;     // Catch: Throwable -> L50
        monitor-exit(r101);     // Catch: Throwable -> L50
        r112.append(r110).append("mConnectState=");
        if (r115 == 1) goto L23;
        if (r115 == 2) goto L22;
        if (r115 != 3) goto L15;
        r112.print("LOCAL_CONNECTING");
    L24:
        r112.append(" mService=");
        if (r100 != null) goto L27;
        r112.append("null");
    L28:
        r112.append(" mServiceBroker=");
        if (r116 != null) goto L31;
        r112.println("null");
    L32:
        SimpleDateFormat r117 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzh <= 0) goto L36;
        PrintWriter r118 = r112.append(r110).append("lastConnectedTime=");
        long r102 = this.zzh;
        r118.println(r102 + " " + r117.format(new Date(r102)));
    L36:
        if (this.zzg <= 0) goto L47;
        r112.append(r110).append("lastSuspendedCause=");
        int r119 = this.zzf;
        if (r119 == 1) goto L44;
        if (r119 == 2) goto L43;
        if (r119 == 3) goto L42;
        r112.append(String.valueOf(r119));
    L45:
        PrintWriter r120 = r112.append(" lastSuspendedTime=");
        long r103 = this.zzg;
        r120.println(r103 + " " + r117.format(new Date(r103)));
        goto L47
    L42:
        r112.append("CAUSE_DEAD_OBJECT_EXCEPTION");
        goto L45
    L43:
        r112.append("CAUSE_NETWORK_LOST");
        goto L45
    L44:
        r112.append("CAUSE_SERVICE_DISCONNECTED");
    L47:
        if (this.zzj <= 0) goto L60;
        r112.append(r110).append("lastFailedStatus=").append(CommonStatusCodes.getStatusCodeString(this.zzi));
        PrintWriter r121 = r112.append(" lastFailedTime=");
        long r122 = this.zzj;
        r121.println(r122 + " " + r117.format(new Date(r122)));
        return;
    L60:
        return;
    L31:
        r112.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(r116.asBinder())));
        goto L32
    L27:
        r112.append(getServiceDescriptor()).append("@").append(Integer.toHexString(System.identityHashCode(r100.asBinder())));
        goto L28
    L15:
        if (r115 != 4) goto L17;
        r112.print("CONNECTED");
        goto L24
    L17:
        if (r115 == 5) goto L19;
        r112.print("UNKNOWN");
        goto L24
    L19:
        r112.print("DISCONNECTING");
        goto L24
    L22:
        r112.print("REMOTE_CONNECTING");
        goto L24
    L23:
        r112.print(State.DISCONNECTED);
    L50:
        th = move-exception;
        throw th;
    L53:
        th = move-exception;
        throw th;
    }

    public void onPostInitHandler(int r100, IBinder r101, Bundle r102, int r103) {
        k r104 = new k(this, r100, r101, r102);
        Message r105 = this.f274494zzb.obtainMessage(1, r103, -1, r104);
        this.f274494zzb.sendMessage(r105);
    }

    public BaseGmsClient(Context r110, Looper r111, int r112, BaseConnectionCallbacks r113, BaseOnConnectionFailedListener r114, String r115) {
        Object r100 = com.google.android.gms.common.internal.a.f274528a;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (com.google.android.gms.common.internal.a.f274529b != null) goto L7;
        com.google.android.gms.common.internal.a.f274529b = new t(r110.getApplicationContext(), r110.getMainLooper());     // Catch: Throwable -> L10
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L10
        t r101 = com.google.android.gms.common.internal.a.f274529b;
        GoogleApiAvailabilityLight r102 = GoogleApiAvailabilityLight.getInstance();
        Preconditions.checkNotNull(r113);
        Preconditions.checkNotNull(r114);
        this(r110, r111, r101, r102, r112, r113, r114, r115);
    }

    public BaseGmsClient(Context r100, Handler r101, com.google.android.gms.common.internal.a r102, GoogleApiAvailabilityLight r103, int r104, BaseConnectionCallbacks r105, BaseOnConnectionFailedListener r110) {
        this.zzk = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList();
        this.zzv = 1;
        this.zzB = null;
        this.zzC = false;
        this.zzD = null;
        this.zzd = new AtomicInteger(0);
        Preconditions.checkNotNull(r100, "Context must not be null");
        this.zzl = r100;
        Preconditions.checkNotNull(r101, "Handler must not be null");
        this.f274494zzb = r101;
        this.zzm = r101.getLooper();
        Preconditions.checkNotNull(r102, "Supervisor must not be null");
        this.zzn = r102;
        Preconditions.checkNotNull(r103, "API availability must not be null");
        this.zzo = r103;
        this.zzy = r104;
        this.zzw = r105;
        this.zzx = r110;
        this.zzz = null;
    }

    public BaseGmsClient(Context r100, Looper r101, com.google.android.gms.common.internal.a r102, GoogleApiAvailabilityLight r103, int r104, BaseConnectionCallbacks r105, BaseOnConnectionFailedListener r106, String r110) {
        this.zzk = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList();
        this.zzv = 1;
        this.zzB = null;
        this.zzC = false;
        this.zzD = null;
        this.zzd = new AtomicInteger(0);
        Preconditions.checkNotNull(r100, "Context must not be null");
        this.zzl = r100;
        Preconditions.checkNotNull(r101, "Looper must not be null");
        this.zzm = r101;
        Preconditions.checkNotNull(r102, "Supervisor must not be null");
        this.zzn = r102;
        Preconditions.checkNotNull(r103, "API availability must not be null");
        this.zzo = r103;
        this.f274494zzb = new h(this, r101);
        this.zzy = r104;
        this.zzw = r105;
        this.zzx = r106;
        this.zzz = r110;
    }
}
