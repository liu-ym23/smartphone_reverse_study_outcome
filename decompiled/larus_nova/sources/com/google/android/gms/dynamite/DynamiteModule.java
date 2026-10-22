package com.google.android.gms.dynamite;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import dalvik.system.DelegateLastClassLoader;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public final class DynamiteModule {
    public static final int LOCAL = -1;
    public static final int NONE = 0;
    public static final int NO_SELECTION = 0;
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = null;
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = null;
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = null;
    public static final VersionPolicy PREFER_LOCAL = null;
    public static final VersionPolicy PREFER_REMOTE = null;
    public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING = null;
    public static final int REMOTE = 1;

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    public static final VersionPolicy f274637zza = null;

    /* JADX INFO: renamed from: zzb, reason: collision with root package name */
    private static Boolean f274638zzb = null;
    private static String zzc = null;
    private static boolean zzd = false;
    private static int zze = -1;
    private static Boolean zzf;
    private static final ThreadLocal zzg = null;
    private static final ThreadLocal zzh = null;
    private static final VersionPolicy.a zzi = null;
    private static zzq zzk;
    private static zzr zzl;
    private final Context zzj;

    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;

        public DynamiteLoaderClassLoader() {
        }
    }

    public static class LoadingException extends Exception {
        public /* synthetic */ LoadingException(String r100, cv7.f r101) {
            super(r100);
        }

        public /* synthetic */ LoadingException(String r100, Throwable r101, cv7.f r102) {
            super(r100, r101);
        }
    }

    public interface VersionPolicy {

        public interface a {
            int a(Context r100, String r101, boolean r102) throws LoadingException;

            int b(Context r100, String r101);
        }

        public static class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f274639a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f274640b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f274641c;

            public b() {
                this.f274639a = 0;
                this.f274640b = 0;
                this.f274641c = 0;
            }
        }

        b selectModule(Context r100, String r101, a r102) throws LoadingException;
    }

    @ResultIgnorabilityUnspecified
    public Context getModuleContext() {
        return this.zzj;
    }

    static {
        zzg = new ThreadLocal();
        zzh = new cv7.d();
        zzi = new a();
        PREFER_REMOTE = new b();
        PREFER_LOCAL = new c();
        PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new d();
        PREFER_HIGHEST_OR_LOCAL_VERSION = new e();
        PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new f();
        PREFER_HIGHEST_OR_REMOTE_VERSION = new g();
        f274637zza = new h();
    }

    private DynamiteModule(Context r100) {
        Preconditions.checkNotNull(r100);
        this.zzj = r100;
    }

    private static void zzd(ClassLoader r100) throws LoadingException {
        cv7.f r101 = null;
        IBinder r102 = (IBinder) INVOKEVIRTUAL_com_google_android_gms_dynamite_DynamiteModule_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r100, "com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: NoSuchMethodException -> L12 Throwable -> L14 InstantiationException -> L16 IllegalAccessException -> L18 ClassNotFoundException -> L20
        if (r102 != null) goto L6;
        zzr r103 = null;
    L10:
        zzl = r103;     // Catch: NoSuchMethodException -> L12 Throwable -> L14 InstantiationException -> L16 IllegalAccessException -> L18 ClassNotFoundException -> L20
        return;
    L6:
        IInterface r104 = r102.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");     // Catch: NoSuchMethodException -> L12 Throwable -> L14 InstantiationException -> L16 IllegalAccessException -> L18 ClassNotFoundException -> L20
        if ((r104 instanceof zzr) == false) goto L9;
        r103 = (zzr) r104;     // Catch: NoSuchMethodException -> L12 Throwable -> L14 InstantiationException -> L16 IllegalAccessException -> L18 ClassNotFoundException -> L20
        goto L10
    L9:
        r103 = new zzr(r102);     // Catch: NoSuchMethodException -> L12 Throwable -> L14 InstantiationException -> L16 IllegalAccessException -> L18 ClassNotFoundException -> L20
    L14:
        e = move-exception;
        throw new LoadingException("Failed to instantiate dynamite loader", e, r101);
    }

    private static boolean zze(Cursor r100) {
        cv7.e r101 = (cv7.e) zzg.get();
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.f465500a != null) goto L10;
        r101.f465500a = r100;
        return true;
    L10:
        return false;
    }

    private static boolean zzf(Context r100) {
        Boolean r101 = Boolean.TRUE;
        if (r101.equals(null) == false) goto L6;
        return true;
    L6:
        if (r101.equals(zzf) == false) goto L8;
        return true;
    L8:
        boolean r102 = false;
        if (zzf != null) goto L23;
        ProviderInfo r103 = r100.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
        if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(r100, 10000000) != 0) goto L16;
        if (r103 == null) goto L16;
        if ("com.google.android.gms".equals(r103.packageName) == false) goto L16;
        r102 = true;
    L16:
        Boolean r104 = Boolean.valueOf(r102);
        zzf = r104;
        r102 = r104.booleanValue();
        if (r102 == false) goto L23;
        ApplicationInfo r105 = r103.applicationInfo;
        if (r105 == null) goto L23;
        if ((r105.flags & 129) != 0) goto L23;
        zzd = true;
    L23:
        return r102;
    }

    private static zzq zzg(Context r100) {
        monitor-enter(DynamiteModule.class);
        zzq r101 = zzk;     // Catch: Throwable -> L24
        if (r101 == null) goto L27;
        monitor-exit(DynamiteModule.class);     // Catch: Throwable -> L24
        return r101;
    L27:
        IBinder r102 = (IBinder) INVOKEVIRTUAL_com_google_android_gms_dynamite_DynamiteModule_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r100.createPackageContext("com.google.android.gms", 3).getClassLoader(), "com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();     // Catch: Exception -> L20 Throwable -> L24
        if (r102 != null) goto L12;
        zzq r103 = null;
    L16:
        if (r103 == null) goto L22;
        zzk = r103;     // Catch: Exception -> L20 Throwable -> L24
        monitor-exit(DynamiteModule.class);     // Catch: Throwable -> L24
        return r103;
    L22:
        monitor-exit(DynamiteModule.class);     // Catch: Throwable -> L24
        return null;
    L12:
        IInterface r104 = r102.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");     // Catch: Exception -> L20 Throwable -> L24
        if ((r104 instanceof zzq) == false) goto L15;
        r103 = (zzq) r104;     // Catch: Exception -> L20 Throwable -> L24
        goto L16
    L15:
        r103 = new zzq(r102);     // Catch: Exception -> L20 Throwable -> L24
    L20:
        e = move-exception;
        e.getMessage();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    public IBinder instantiate(String r100) throws LoadingException {
        return (IBinder) INVOKEVIRTUAL_com_google_android_gms_dynamite_DynamiteModule_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(this.zzj.getClassLoader(), r100).newInstance();
    L4:
        e = move-exception;
        throw new LoadingException("Failed to instantiate module class: ".concat(String.valueOf(r100)), e, null);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_com_google_android_gms_dynamite_DynamiteModule_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r101);
    L12:
        throw th;
    L34:
        Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
    L16:
        return r105;
    L17:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r101);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r101);
    }

    public static int getLocalVersion(Context r100, String r101) {
        Class r102 = INVOKEVIRTUAL_com_google_android_gms_dynamite_DynamiteModule_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r100.getApplicationContext().getClassLoader(), "com.google.android.gms.dynamite.descriptors." + r101 + ".ModuleDescriptor");     // Catch: Exception -> L9 ClassNotFoundException -> L11
        Field r103 = r102.getDeclaredField("MODULE_ID");     // Catch: Exception -> L9 ClassNotFoundException -> L11
        Field r104 = r102.getDeclaredField("MODULE_VERSION");     // Catch: Exception -> L9 ClassNotFoundException -> L11
        if (Objects.equal(r103.get(null), r101) == true) goto L8;
        String.valueOf(r103.get(null));     // Catch: Exception -> L9 ClassNotFoundException -> L11
        return 0;
    L8:
        return r104.getInt(null);
    L9:
        e = move-exception;
        "Failed to load module descriptor class: ".concat(String.valueOf(e.getMessage()));
    L12:
        return 0;
    }

    public static int getRemoteVersion(Context r100, String r101) {
        return zza(r100, r101, false);
    }

    private static DynamiteModule zzc(Context r100, String r101) {
        "Selected local version of ".concat(String.valueOf(r101));
        return new DynamiteModule(r100);
    }

    @ResultIgnorabilityUnspecified
    public static DynamiteModule load(Context r210, VersionPolicy r211, String r212) throws LoadingException {
        Context r100 = r210.getApplicationContext();
        if (r100 == null) goto L133;
        ThreadLocal r101 = zzg;
        cv7.e r102 = (cv7.e) r101.get();
        cv7.e r103 = new cv7.e(0);
        r101.set(r103);
        ThreadLocal r110 = zzh;
        long r111 = ((Long) r110.get()).longValue();
        r110.set(Long.valueOf(SystemClock.elapsedRealtime()));     // Catch: Throwable -> L122
        VersionPolicy.b r112 = r211.selectModule(r210, r212, zzi);     // Catch: Throwable -> L122
        int r113 = r112.f274639a;     // Catch: Throwable -> L122
        int r114 = r112.f274640b;     // Catch: Throwable -> L122
        int r115 = r112.f274641c;     // Catch: Throwable -> L122
        if (r115 == 0) goto L121;
        if (r115 != (-1)) goto L12;
        if (r113 == 0) goto L121;
        r115 = -1;
    L12:
        if (r115 != 1) goto L14;
        if (r114 == 0) goto L121;
    L14:
        if (r115 != (-1)) goto L135;
        DynamiteModule r104 = zzc(r100, r212);     // Catch: Throwable -> L122
    L108:
        if (r111 != 0) goto L110;
        zzh.remove();
    L111:
        Cursor r105 = r103.f465500a;
        if (r105 == null) goto L114;
        r105.close();
    L114:
        zzg.set(r102);
        return r104;
    L110:
        zzh.set(Long.valueOf(r111));
        goto L111
    L135:
        if (r115 != 1) goto L119;
        monitor-enter(DynamiteModule.class);     // Catch: Throwable -> L90 LoadingException -> L97 RemoteException -> L99
    L87:
        th = move-exception;
        throw th;     // Catch: Throwable -> L90 LoadingException -> L97 RemoteException -> L99
    L21:
        if (zzf(r210) == false) goto L86;
        Boolean r106 = f274638zzb;     // Catch: Throwable -> L87
        monitor-exit(DynamiteModule.class);     // Catch: Throwable -> L87
        if (r106 == null) goto L84;
        if (r106.booleanValue() == true) goto L28;
        zzq r107 = zzg(r210);     // Catch: Throwable -> L90 LoadingException -> L97 RemoteException -> L99
        if (r107 == null) goto L82;
        int r116 = r107.zze();     // Catch: Throwable -> L90 LoadingException -> L97 RemoteException -> L99
        if (r116 < 3) goto L72;
        cv7.e r108 = (cv7.e) r101.get();     // Catch: Throwable -> L90 LoadingException -> L97 RemoteException -> L99
        if (r108 == null) goto L71;
        IObjectWrapper r109 = r107.zzi(ObjectWrapper.wrap(r210), r212, r114, ObjectWrapper.wrap(r108.f465500a));     // Catch: Throwable -> L90 LoadingException -> L97 RemoteException -> L99
    L75:
        Object r117 = ObjectWrapper.unwrap(r109);     // Catch: Throwable -> L90 LoadingException -> L97 RemoteException -> L99
        if (r117 == null) goto L80;
        DynamiteModule r118 = new DynamiteModule((Context) r117);     // Catch: Throwable -> L90 LoadingException -> L97 RemoteException -> L99
    L78:
        r104 = r118;
        goto L108
    L80:
        throw new LoadingException("Failed to load remote module.", null);     // Catch: Throwable -> L90 LoadingException -> L97 RemoteException -> L99
    L71:
        throw new LoadingException("No cached result cursor holder", null);     // Catch: Throwable -> L90 LoadingException -> L97 RemoteException -> L99
    L72:
        if (r116 != 2) goto L74;
        r109 = r107.zzj(ObjectWrapper.wrap(r210), r212, r114);     // Catch: Throwable -> L90 LoadingException -> L97 RemoteException -> L99
        goto L75
    L74:
        r109 = r107.zzh(ObjectWrapper.wrap(r210), r212, r114);     // Catch: Throwable -> L90 LoadingException -> L97 RemoteException -> L99
        goto L75
    L82:
        throw new LoadingException("Failed to create IDynamiteLoader.", null);     // Catch: Throwable -> L90 LoadingException -> L97 RemoteException -> L99
    L28:
        monitor-enter(DynamiteModule.class);     // Catch: Throwable -> L90 LoadingException -> L97 RemoteException -> L99
        zzr r119 = zzl;     // Catch: Throwable -> L60
        monitor-exit(DynamiteModule.class);     // Catch: Throwable -> L60
        if (r119 == null) goto L59;
        cv7.e r120 = (cv7.e) r101.get();     // Catch: Throwable -> L90 LoadingException -> L97 RemoteException -> L99
        if (r120 == null) goto L57;
        if (r120.f465500a == null) goto L57;
        Context r121 = r210.getApplicationContext();     // Catch: Throwable -> L90 LoadingException -> L97 RemoteException -> L99
        Cursor r122 = r120.f465500a;     // Catch: Throwable -> L90 LoadingException -> L97 RemoteException -> L99
        ObjectWrapper.wrap(null);     // Catch: Throwable -> L90 LoadingException -> L97 RemoteException -> L99
        monitor-enter(DynamiteModule.class);     // Catch: Throwable -> L90 LoadingException -> L97 RemoteException -> L99
    L53:
        th = move-exception;
        throw th;     // Catch: Throwable -> L90 LoadingException -> L97 RemoteException -> L99
    L39:
        if (zze < 2) goto L41;
        boolean r123 = true;
    L42:
        Boolean r124 = Boolean.valueOf(r123);     // Catch: Throwable -> L53
        monitor-exit(DynamiteModule.class);     // Catch: Throwable -> L53
        if (r124.booleanValue() == false) goto L47;
        IObjectWrapper r125 = r119.zzf(ObjectWrapper.wrap(r121), r212, r114, ObjectWrapper.wrap(r122));     // Catch: Throwable -> L90 LoadingException -> L97 RemoteException -> L99
    L48:
        Context r126 = (Context) ObjectWrapper.unwrap(r125);     // Catch: Throwable -> L90 LoadingException -> L97 RemoteException -> L99
        if (r126 == null) goto L52;
        r118 = new DynamiteModule(r126);     // Catch: Throwable -> L90 LoadingException -> L97 RemoteException -> L99
        goto L78
    L52:
        throw new LoadingException("Failed to get module context", null);     // Catch: Throwable -> L90 LoadingException -> L97 RemoteException -> L99
    L47:
        r125 = r119.zze(ObjectWrapper.wrap(r121), r212, r114, ObjectWrapper.wrap(r122));     // Catch: Throwable -> L90 LoadingException -> L97 RemoteException -> L99
        goto L48
    L41:
        r123 = false;
    L57:
        throw new LoadingException("No result cursor", null);     // Catch: Throwable -> L90 LoadingException -> L97 RemoteException -> L99
    L59:
        throw new LoadingException("DynamiteLoaderV2 was not cached.", null);     // Catch: Throwable -> L90 LoadingException -> L97 RemoteException -> L99
    L60:
        th = move-exception;
        throw th;     // Catch: Throwable -> L90 LoadingException -> L97 RemoteException -> L99
    L84:
        throw new LoadingException("Failed to determine which loading route to use.", null);     // Catch: Throwable -> L90 LoadingException -> L97 RemoteException -> L99
    L86:
        throw new LoadingException("Remote loading disabled", null);     // Catch: Throwable -> L87
    L99:
        e = move-exception;
        throw new LoadingException("Failed to load remote module.", e, null);     // Catch: LoadingException -> L95 Throwable -> L122
    L97:
        e = move-exception;
        throw e;     // Catch: LoadingException -> L95 Throwable -> L122
    L90:
        th = move-exception;
        int r127 = av7.a.f16382a;     // Catch: LoadingException -> L95 Throwable -> L122
        Preconditions.checkNotNull(r210);     // Catch: Exception -> L134 Throwable -> L122
        Preconditions.checkNotNull(th);     // Catch: Exception -> L134 Throwable -> L122
    L94:
        throw new LoadingException("Failed to load remote module.", th, null);     // Catch: LoadingException -> L95 Throwable -> L122
    L119:
        throw new LoadingException("VersionPolicy returned invalid code:" + r115, null);     // Catch: Throwable -> L122
    L95:
        e = move-exception;
        e.getMessage();     // Catch: Throwable -> L122
        int r128 = r112.f274639a;     // Catch: Throwable -> L122
        if (r128 == 0) goto L117;
        if (r211.selectModule(r210, r212, new i(r128)).f274641c != (-1)) goto L117;
        r104 = zzc(r100, r212);     // Catch: Throwable -> L122
    L117:
        throw new LoadingException("Remote load failed. No local fallback found.", e, null);     // Catch: Throwable -> L122
    L121:
        throw new LoadingException("No acceptable module " + r212 + " found. Local version is " + r112.f274639a + " and remote version is " + r112.f274640b + ".", null);     // Catch: Throwable -> L122
    L122:
        th = move-exception;
        if (r111 != 0) goto L126;
        zzh.remove();
    L127:
        Cursor r129 = r103.f465500a;
        if (r129 == null) goto L130;
        r129.close();
    L130:
        zzg.set(r102);
        throw th;
    L126:
        zzh.set(Long.valueOf(r111));
        goto L127
    L133:
        throw new LoadingException("null application Context", null);
    }

    /* JADX INFO: Removed unreachable split cross block B:139:0x0161 */
    public static int zza(Context r110, String r111, boolean r112) {
        monitor-enter(DynamiteModule.class);     // Catch: Throwable -> L119
        Boolean r100 = f274638zzb;     // Catch: Throwable -> L116
        Cursor r101 = null;
        int r102 = 0;
        if (r100 == null) goto L144;
    L60:
        monitor-exit(DynamiteModule.class);     // Catch: Throwable -> L116
        if (r100.booleanValue() == true) goto L137;
        zzq r103 = zzg(r110);     // Catch: Throwable -> L119
        if (r103 != null) goto L140;
    L111:
        return r102;
    L140:
        int r104 = r103.zze();     // Catch: Throwable -> L104 RemoteException -> L106
        if (r104 < 3) goto L100;
        cv7.e r105 = (cv7.e) zzg.get();     // Catch: Throwable -> L104 RemoteException -> L106
        if (r105 == null) goto L78;
        Cursor r106 = r105.f465500a;     // Catch: Throwable -> L104 RemoteException -> L106
        if (r106 == null) goto L78;
        r102 = r106.getInt(0);     // Catch: Throwable -> L104 RemoteException -> L106
    L134:
    L78:
        Cursor r113 = (Cursor) ObjectWrapper.unwrap(r103.zzk(ObjectWrapper.wrap(r110), r111, r112, ((Long) zzh.get()).longValue()));     // Catch: Throwable -> L104 RemoteException -> L106
        if (r113 != null) goto L142;
    L96:
        if (r113 == null) goto L134;
        r113.close();     // Catch: Throwable -> L119
        goto L134
    L142:
    L94:
        RemoteException e100 = e;
        r101 = r113;
    L108:
        e100.getMessage();     // Catch: Throwable -> L104
        if (r101 == null) goto L134;
        r101.close();     // Catch: Throwable -> L119
    L92:
        Throwable th10 = th;
    L113:
        if (r113 == null) goto L146;
        r113.close();     // Catch: Throwable -> L119
        throw th10;     // Catch: Throwable -> L119
    L146:
        throw th10;     // Catch: Throwable -> L119
    L81:
        if (r113.moveToFirst() == false) goto L96;
        int r114 = r113.getInt(0);     // Catch: Throwable -> L92 RemoteException -> L94
        if (r114 <= 0) goto L88;
        if (zze(r113) == false) goto L88;
    L89:
        if (r101 == null) goto L91;
        r101.close();     // Catch: Throwable -> L119
    L91:
        r102 = r114;
        goto L134
    L88:
        r101 = r113;
        goto L89
    L100:
        if (r104 != 2) goto L102;
        r102 = r103.zzg(ObjectWrapper.wrap(r110), r111, r112);     // Catch: Throwable -> L104 RemoteException -> L106
        goto L134
    L102:
        r102 = r103.zzf(ObjectWrapper.wrap(r110), r111, r112);     // Catch: Throwable -> L104 RemoteException -> L106
    L106:
        e = move-exception;
        e100 = e;
    L104:
        th = move-exception;
        th10 = th;
        r113 = r101;
        goto L113
    L137:
        return zzb(r110, r111, r112, false);
    L65:
        e = move-exception;
        e.getMessage();     // Catch: Throwable -> L119
        return 0;
    L144:
        Field r107 = INVOKEVIRTUAL_com_google_android_gms_dynamite_DynamiteModule_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r110.getApplicationContext().getClassLoader(), DynamiteLoaderClassLoader.class.getName()).getDeclaredField("sClassLoader");     // Catch: Throwable -> L53 IllegalAccessException -> L55 ClassNotFoundException -> L57 Throwable -> L116
        Class<?> r108 = r107.getDeclaringClass();     // Catch: Throwable -> L53 IllegalAccessException -> L55 ClassNotFoundException -> L57 Throwable -> L116
        monitor-enter(r108);     // Catch: Throwable -> L53 IllegalAccessException -> L55 ClassNotFoundException -> L57 Throwable -> L116
        ClassLoader r109 = (ClassLoader) r107.get(null);     // Catch: Throwable -> L50
        if (r109 != ClassLoader.getSystemClassLoader()) goto L13;
        r100 = Boolean.FALSE;     // Catch: Throwable -> L50
    L48:
        monitor-exit(r108);     // Catch: Throwable -> L50
    L59:
        f274638zzb = r100;     // Catch: Throwable -> L116
        goto L60
    L13:
        if (r109 == null) goto L17;
        zzd(r109);     // Catch: LoadingException -> L123 Throwable -> L50
    L15:
        r100 = Boolean.TRUE;     // Catch: Throwable -> L50
        goto L48
    L17:
        if (zzf(r110) == true) goto L22;
        monitor-exit(r108);     // Catch: Throwable -> L50
        monitor-exit(DynamiteModule.class);     // Catch: Throwable -> L116
        return 0;
    L22:
        if (zzd == true) goto L47;
        Boolean r115 = Boolean.TRUE;     // Catch: Throwable -> L50
        if (r115.equals(null) == true) goto L47;
        int r116 = zzb(r110, r111, r112, true);     // Catch: LoadingException -> L46 Throwable -> L50
        String r117 = zzc;     // Catch: LoadingException -> L46 Throwable -> L50
        if (r117 != null) goto L30;
    L43:
        monitor-exit(r108);     // Catch: Throwable -> L50
        monitor-exit(DynamiteModule.class);     // Catch: Throwable -> L116
        return r116;
    L30:
        if (r117.isEmpty() == true) goto L43;
        ClassLoader r118 = cv7.b.a();     // Catch: LoadingException -> L46 Throwable -> L50
        if (r118 == null) goto L36;
    L39:
        zzd(r118);     // Catch: LoadingException -> L46 Throwable -> L50
        r107.set(null, r118);     // Catch: LoadingException -> L46 Throwable -> L50
        f274638zzb = r115;     // Catch: LoadingException -> L46 Throwable -> L50
        monitor-exit(r108);     // Catch: Throwable -> L50
        monitor-exit(DynamiteModule.class);     // Catch: Throwable -> L116
        return r116;
    L36:
        if (Build.VERSION.SDK_INT < 29) goto L38;
        String r119 = zzc;     // Catch: LoadingException -> L46 Throwable -> L50
        Preconditions.checkNotNull(r119);     // Catch: LoadingException -> L46 Throwable -> L50
        r118 = new DelegateLastClassLoader(r119, ClassLoader.getSystemClassLoader());     // Catch: LoadingException -> L46 Throwable -> L50
        goto L39
    L38:
        String r120 = zzc;     // Catch: LoadingException -> L46 Throwable -> L50
        Preconditions.checkNotNull(r120);     // Catch: LoadingException -> L46 Throwable -> L50
        r118 = new cv7.c(r120, ClassLoader.getSystemClassLoader());     // Catch: LoadingException -> L46 Throwable -> L50
    L46:
        r107.set(null, ClassLoader.getSystemClassLoader());     // Catch: Throwable -> L50
        r100 = Boolean.FALSE;     // Catch: Throwable -> L50
    L47:
        r107.set(null, ClassLoader.getSystemClassLoader());     // Catch: Throwable -> L50
        r100 = Boolean.FALSE;     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        throw th;     // Catch: Throwable -> L53 IllegalAccessException -> L55 ClassNotFoundException -> L57 Throwable -> L116
    L53:
        e = move-exception;
        e.toString();     // Catch: Throwable -> L116
        r100 = Boolean.FALSE;     // Catch: Throwable -> L116
    L116:
        th = move-exception;
        throw th;     // Catch: Throwable -> L119
    L119:
        th = move-exception;
        int r121 = av7.a.f16382a;
        Preconditions.checkNotNull(r110);     // Catch: Exception -> L124
        Preconditions.checkNotNull(th);     // Catch: Exception -> L124
    L122:
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    private static int zzb(Context r100, String r101, boolean r110, boolean r111) throws LoadingException {
        ?? r102 = 0;
        ?? r103 = 0;
        ?? r104 = 0;
        ?? r105 = 0;
        ContentResolver r106 = r100.getContentResolver();     // Catch: Throwable -> L44 Exception -> L46
        long r107 = ((Long) zzh.get()).longValue();     // Catch: Throwable -> L44 Exception -> L46
        String r108 = "api_force_staging";
        boolean r109 = true;
        if (true == r110) goto L6;
        r108 = "api";
    L6:
        Cursor r112 = com_google_android_gms_dynamite_DynamiteModule_android_content_ContentResolver_query(r106, new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").path(r108).appendPath(r101).appendQueryParameter("requestStartTime", String.valueOf(r107)).build(), null, null, null, null);     // Catch: Throwable -> L44 Exception -> L46
        if (r112 == null) goto L43;
    L37:
        Exception e100 = e;
    L49:
        if ((e100 instanceof LoadingException) == false) goto L52;
        throw e100;     // Catch: Throwable -> L53
    L52:
        throw new LoadingException("V2 version check failed: " + e100.getMessage(), e100, r103 == true ? 1 : 0);     // Catch: Throwable -> L53
    L9:
        if (r112.moveToFirst() == false) goto L43;
        boolean r113 = false;
        int r114 = r112.getInt(0);     // Catch: Exception -> L37 Throwable -> L53
        if (r114 > 0) goto L13;
    L32:
        if (r111 == false) goto L39;
        if (r113 == false) goto L39;
        throw new LoadingException("forcing fallback to container DynamiteLoader impl", r104 == true ? 1 : 0);     // Catch: Exception -> L37 Throwable -> L53
    L39:
        if (r112 == null) goto L41;
        r112.close();
    L41:
        return r114;
    L13:
        monitor-enter(DynamiteModule.class);     // Catch: Exception -> L37 Throwable -> L53
        zzc = r112.getString(2);     // Catch: Throwable -> L29
        int r115 = r112.getColumnIndex("loaderVersion");     // Catch: Throwable -> L29
        if (r115 < 0) goto L18;
        zze = r112.getInt(r115);     // Catch: Throwable -> L29
    L18:
        int r116 = r112.getColumnIndex("disableStandaloneDynamiteLoader2");     // Catch: Throwable -> L29
        if (r116 >= 0) goto L21;
    L25:
        monitor-exit(DynamiteModule.class);     // Catch: Throwable -> L29
        if (zze(r112) == false) goto L32;
        r112 = null;
        goto L32
    L21:
        if (r112.getInt(r116) != 0) goto L24;
        r109 = false;
    L24:
        zzd = r109;     // Catch: Throwable -> L29
        r113 = r109;
    L29:
        th = move-exception;
        throw th;     // Catch: Exception -> L37 Throwable -> L53
    L43:
        throw new LoadingException("Failed to connect to dynamite module ContentResolver.", r105 == true ? 1 : 0);     // Catch: Exception -> L37 Throwable -> L53
    L53:
        Throwable th10 = th;
        r102 = r100;
    L55:
        if (r102 == 0) goto L57;
        r102.close();
    L57:
        throw th10;
    L46:
        e = move-exception;
        e100 = e;
    L44:
        th = move-exception;
        th10 = th;
        goto L55
    }

    private static Cursor com_google_android_gms_dynamite_DynamiteModule_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) throws LoadingException {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, r113, r114, r115};
        f06.b r116 = new f06.b();
        f06.d r117 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r116);
        if (r117.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r116, false);
        return (Cursor) r117.f474983b;
    L6:
        Cursor r118 = r110.query(r111, r112, r113, r114, r115);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r118, r116, true);
        return r118;
    }
}
