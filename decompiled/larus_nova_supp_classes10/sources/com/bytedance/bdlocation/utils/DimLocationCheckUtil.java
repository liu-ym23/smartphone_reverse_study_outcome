package com.bytedance.bdlocation.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.sensor.SensorBatchGpsCollector;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import f06.b;
import f06.c;
import f06.d;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class DimLocationCheckUtil {
    public static final int STATE_INIT = -5;
    public static final int STATE_NOT_ALLOWED_NETWORK = -3;
    public static final int STATE_OFF = 0;
    public static final int STATE_ON = 1;
    public static final int STATE_TYPE_FAILED = -1;
    public static final int STATE_TYPE_NO_NETWORK = -2;
    public static final int STATE_UNSUPPORTED = -4;
    public static final String VIVO = "vivo";
    public static final String XIAOMI = "xiaomi";
    private static volatile int sDimLocationState = -5;

    public interface IMessenger extends IInterface {

        public static abstract class Stub extends Binder implements IMessenger {
            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this;
            }

            public Stub() {
                attachInterface(this, "com.android.internal.app.IMessenger");
            }

            @Override // android.os.Binder
            public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
                if (r4 != 1) goto L11;
                r5.enforceInterface("com.android.internal.app.IMessenger");     // Catch: Exception -> L14
                if (r5.readInt() == 0) goto L7;
                Message r8 = (Message) Message.CREATOR.createFromParcel(r5);     // Catch: Exception -> L14
            L8:
                handleMessage(r8);     // Catch: Exception -> L14
                return true;
            L7:
                r8 = null;
                goto L8
            L11:
                if (r4 != 1598968902) goto L13;
                r6.writeString("com.android.internal.app.IMessenger");     // Catch: Exception -> L14
            L19:
                return true;
            L13:
                return super.onTransact(r4, r5, r6, r7);
            L14:
                e = move-exception;
                Logger.e("onTransact error:" + e.toString());
                goto L19
            }
        }

        void handleMessage(Message r1);
    }

    public DimLocationCheckUtil() {
    }

    public static /* synthetic */ Class access$001(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public static /* synthetic */ int access$000() {
        return sDimLocationState;
    }

    public static int getDimLocationState() {
        return sDimLocationState;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_bdlocation_utils_DimLocationCheckUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r2 = access$001(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$001(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static void setDimLocationState(int r0) {
        sDimLocationState = r0;
    }

    public static void startGetVivoDimLocation(Context r12) {
        if (r12 != null) goto L6;
        Logger.i("startGetVivoDimLocation context = null");
        return;
    L6:
        if (LocationUtil.isTargetBrand(VIVO) == true) goto L9;
        Logger.i("startGetVivoDimLocation isTargetBrand:false");
        return;
    L9:
        long r1 = System.currentTimeMillis();
        Cursor r13 = com_bytedance_bdlocation_utils_DimLocationCheckUtil_android_content_ContentResolver_query(r12.getContentResolver(), UriProtector.parse("content://com.vivo.permissionmanager.provider.permission/fuzzy_location_apps"), new String[]{"package_name", "selected_fuzzy"}, "package_name=?", new String[]{r12.getPackageName()}, null);     // Catch: Exception -> L24
        if (r13 != null) goto L15;
        Logger.i("startGetVivoDimLocation cursor = null");     // Catch: Exception -> L24
        setDimLocationState(-1);     // Catch: Exception -> L24
        dimLocationCheckMonitorUpload(VIVO, -1, r1, null);     // Catch: Exception -> L24
        return;
    L15:
        if (r13.moveToNext() == false) goto L22;
        if (r13.getString(0) == null) goto L15;
        if (r13.getInt(1) != 1) goto L15;
        Logger.i("startGetVivoDimLocation true");     // Catch: Exception -> L24
        setDimLocationState(1);     // Catch: Exception -> L24
        dimLocationCheckMonitorUpload(VIVO, 1, r1, null);     // Catch: Exception -> L24
        return;
    L22:
        Logger.i("startGetVivoDimLocation false");
        setDimLocationState(0);
        dimLocationCheckMonitorUpload(VIVO, 0, r1, null);
        return;
    L24:
        e = move-exception;
        Logger.e("startGetVivoDimLocation error:" + e.toString());
        setDimLocationState(-1);
        dimLocationCheckMonitorUpload(VIVO, -1, r1, e);
    }

    public static void startGetXiaomiDimLocation(Context r12) {
        if (r12 != null) goto L7;
        Logger.i("startGetXiaomiDimLocation context = null");
        return;
    L7:
        if (LocationUtil.isTargetBrand(XIAOMI) == true) goto L10;
        Logger.i("startGetXiaomiDimLocation isTargetBrand:false");
        return;
    L10:
        final long r2 = System.currentTimeMillis();
        Class r5 = INVOKESTATIC_com_bytedance_bdlocation_utils_DimLocationCheckUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties");     // Catch: Exception -> L21
        if (((Integer) r5.getDeclaredMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke(r5, new Object[]{"ro.miui.ui.version.code", 0})).intValue() >= 11) goto L15;
        setDimLocationState(-4);     // Catch: Exception -> L21
        dimLocationCheckMonitorUpload(XIAOMI, -4, r2, null);     // Catch: Exception -> L21
        return;
    L15:
        ContentResolver r13 = r12.getContentResolver();     // Catch: Exception -> L21
        Uri r6 = UriProtector.parse("content://com.lbe.security.miui.autostartmgr");     // Catch: Exception -> L21
        Bundle r7 = new Bundle();     // Catch: Exception -> L21
        final CountDownLatch r8 = new CountDownLatch(1);     // Catch: Exception -> L21
        r7.putBinder("callback", new AnonymousClass1(r8, r2).asBinder());     // Catch: Exception -> L21
        r13.call(r6, "queryLocationState", null, r7);     // Catch: Exception -> L21
        r8.await(SensorBatchGpsCollector.DEFAULT_NETWORK_FALLBACK_TIMEOUT_MS, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L18 Exception -> L21
    L27:
        return;
    L18:
        e = move-exception;
        Logger.e("startGetXiaomiDimLocation InterruptedException:" + e.toString());     // Catch: Exception -> L21
        setDimLocationState(-1);     // Catch: Exception -> L21
        dimLocationCheckMonitorUpload(XIAOMI, -1, r2, e);     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        Logger.e("startGetXiaomiDimLocation Exception:" + e.toString());
        setDimLocationState(-1);
        dimLocationCheckMonitorUpload(XIAOMI, -1, r2, e);
    }

    public static void dimLocationCheckMonitorUpload(String r2, int r3, long r4, Throwable r6) {
        LocationMonitor.dimLocationCheckMonitor(r2, r3, System.currentTimeMillis() - r4, r6);
    }

    private static Cursor com_bytedance_bdlocation_utils_DimLocationCheckUtil_android_content_ContentResolver_query(ContentResolver r13, Uri r14, String[] r15, String r16, String[] r17, String r18) {
        c r8 = new c();
        Object[] r9 = {r14, r15, r16, r17, r18};
        b r10 = new b();
        d r11 = r8.b(240004, "android/content/ContentResolver", "query", r13, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r12 = r13.query(r14, r15, r16, r17, r18);
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, r12, r10, true);
        return r12;
    }
}
