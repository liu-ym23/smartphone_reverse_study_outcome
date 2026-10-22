package com.ss.android.ttve.nativePort;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Build;
import android.util.Pair;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ttve.model.VEAudioDeviceType;
import com.ss.android.vesdk.runtime.VERuntime;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes38.dex */
public class TESystemUtils {
    public TESystemUtils() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static int getOutputAudioDeviceType() {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        new ngc.a();
        return ngc.a.a().ordinal();
    L7:
        return VEAudioDeviceType.DEFAULT.ordinal();
    }

    public static Pair<Integer, Integer> getSuggestedOutputProperty() {
        Context r100 = VERuntime.getInstance().getContext();
        if (r100 != null) goto L5;
        return null;
    L5:
        AudioManager r101 = (AudioManager) r100.getSystemService("audio");
        String r102 = r101.getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
        String r103 = r101.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER");
        int r104 = CastIntegerProtector.parseInt(r102);     // Catch: Exception -> L8
        int r105 = CastIntegerProtector.parseInt(r103);     // Catch: Exception -> L8
        return new Pair(Integer.valueOf(r104), Integer.valueOf(r105));
    L8:
        return null;
    }

    public static boolean hasLowLatencyFeature() {
        Context r100 = VERuntime.getInstance().getContext();
        if (r100 != null) goto L5;
        return false;
    L5:
        PackageManager r101 = r100.getPackageManager();
        if (r101 != null) goto L9;
        return false;
    L9:
        return r101.hasSystemFeature("android.hardware.audio.low_latency");
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_ttve_nativePort_TESystemUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static int getAudioTrackBufferSize(int r100) {
        return AudioTrack.getMinBufferSize(r100, 12, 2);
    }

    public static int getOutputLatency(int r100) {
        Class r101 = INVOKESTATIC_com_ss_android_ttve_nativePort_TESystemUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.media.AudioSystem");     // Catch: InvocationTargetException -> L11 IllegalAccessException -> L13 NoSuchMethodException -> L15 ClassNotFoundException -> L17
        if (r101 != null) goto L6;
        return 0;
    L6:
        Method r102 = r101.getDeclaredMethod("getOutputLatency", new Class[]{Integer.TYPE});     // Catch: InvocationTargetException -> L11 IllegalAccessException -> L13 NoSuchMethodException -> L15 ClassNotFoundException -> L17
        if (r102 != null) goto L9;
        return 0;
    L9:
        r102.setAccessible(true);     // Catch: InvocationTargetException -> L11 IllegalAccessException -> L13 NoSuchMethodException -> L15 ClassNotFoundException -> L17
        return ((Integer) r102.invoke(r101, new Object[]{Integer.valueOf(r100)})).intValue();
    L17:
        e = move-exception;
        e.printStackTrace();
    L19:
        return 0;
    L13:
        e = move-exception;
        e.printStackTrace();
    L15:
        e = move-exception;
        e.printStackTrace();
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }
}
