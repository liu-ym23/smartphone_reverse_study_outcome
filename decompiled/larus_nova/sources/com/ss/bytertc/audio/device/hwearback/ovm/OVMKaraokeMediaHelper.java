package com.ss.bytertc.audio.device.hwearback.ovm;

import android.content.Context;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.realx.base.RXLogging;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public class OVMKaraokeMediaHelper {
    private static final String TAG = "OVMKaraokeMediaHelper";
    private Object helper;
    private Map<String, Method> methodCache;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public int getListenRecordSame() {
        Method r100 = getMethod("getListenRecordSame", new Class[0]);     // Catch: Throwable -> L7
        if (r100 == null) goto L9;
        return ((Integer) r100.invoke(this.helper, new Object[0])).intValue();
    L9:
        return 0;
    L7:
        th = move-exception;
        RXLogging.e(TAG, "getListenRecordSame operate not allowed", th);
        goto L9
    }

    public int getMicVolParam() {
        Method r100 = getMethod("getMicVolParam", new Class[0]);     // Catch: Throwable -> L7
        if (r100 == null) goto L9;
        return ((Integer) r100.invoke(this.helper, new Object[0])).intValue();
    L9:
        return 0;
    L7:
        th = move-exception;
        RXLogging.e(TAG, "getMicVolParam operate not allowed", th);
        goto L9
    }

    public int getPlayFeedbackParam() {
        Method r100 = getMethod("getPlayFeedbackParam", new Class[0]);     // Catch: Throwable -> L7
        if (r100 == null) goto L9;
        return ((Integer) r100.invoke(this.helper, new Object[0])).intValue();
    L9:
        return 0;
    L7:
        th = move-exception;
        RXLogging.e(TAG, "getPlayFeedbackParam operate not allowed", th);
        goto L9
    }

    public boolean isDeviceSupportKaraoke() {
        Method r100 = getMethod("isDeviceSupportKaraoke", new Class[0]);     // Catch: Throwable -> L7
        if (r100 == null) goto L9;
        return ((Boolean) r100.invoke(this.helper, new Object[0])).booleanValue();
    L9:
        return false;
    L7:
        th = move-exception;
        RXLogging.e(TAG, "isDeviceSupportKaraoke operate not allowed", th);
        goto L9
    }

    public void closeKTVDevice() {
        Method r100 = getMethod("closeKTVDevice", new Class[0]);     // Catch: Throwable -> L6
        if (r100 == null) goto L11;
        r100.invoke(this.helper, new Object[0]);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        RXLogging.e(TAG, "closeKTVDevice operate not allowed", th);
    }

    public String getKaraokeSupportParameters() {
        Method r100 = getMethod("getKaraokeSupportParameters", new Class[0]);     // Catch: Throwable -> L6
        if (r100 == null) goto L12;
        return (String) r100.invoke(this.helper, new Object[0]);
    L12:
        return "";
    L6:
        th = move-exception;
        RXLogging.e(TAG, "getKaraokeSupportParameters operate not allowed", th);
        return "";
    }

    public int getVersion() {
        Method r100 = getMethod("getVersion", new Class[0]);     // Catch: Throwable -> L6
        if (r100 == null) goto L12;
        return ((Integer) r100.invoke(this.helper, new Object[0])).intValue();
    L12:
        return -1;
    L6:
        th = move-exception;
        RXLogging.e(TAG, "getPlayFeedbackParam operate not allowed", th);
        return -1;
    }

    public void openKTVDevice() {
        Method r100 = getMethod("openKTVDevice", new Class[0]);     // Catch: Throwable -> L6
        if (r100 == null) goto L11;
        r100.invoke(this.helper, new Object[0]);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        RXLogging.e(TAG, "openKTVDevice operate not allowed", th);
    }

    private OVMKaraokeMediaHelper(Object r100) {
        this.methodCache = new ConcurrentHashMap();
        this.helper = r100;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_bytertc_audio_device_hwearback_ovm_OVMKaraokeMediaHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static OVMKaraokeMediaHelper create(Context r100) {
        return new OVMKaraokeMediaHelper(INVOKESTATIC_com_ss_bytertc_audio_device_hwearback_ovm_OVMKaraokeMediaHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.itgsa.opensdk.mediaunit.KaraokeMediaHelper").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{r100}));
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public boolean isAppSupportKaraoke(String r100) {
        Method r101 = getMethod("isAppSupportKaraoke", new Class[]{String.class});     // Catch: Throwable -> L7
        if (r101 == null) goto L9;
        return ((Boolean) r101.invoke(this.helper, new Object[]{r100})).booleanValue();
    L9:
        return false;
    L7:
        th = move-exception;
        RXLogging.e(TAG, "isAppSupportKaraoke operate not allowed", th);
        goto L9
    }

    public void setEqualizerType(int r100) {
        Method r101 = getMethod("setEqualizerType", new Class[]{Integer.TYPE});     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.invoke(this.helper, new Object[]{Integer.valueOf(r100)});     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
        RXLogging.e(TAG, "setEqualizerType operate not allowed", th);
    }

    public void setListenRecordSame(int r100) {
        Method r101 = getMethod("setListenRecordSame", new Class[]{Integer.TYPE});     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.invoke(this.helper, new Object[]{Integer.valueOf(r100)});     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        RXLogging.e(TAG, "setListenRecordSame operate not allowed", th);
    }

    public void setMicVolParam(int r100) {
        Method r101 = getMethod("setMicVolParam", new Class[]{Integer.TYPE});     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.invoke(this.helper, new Object[]{Integer.valueOf(r100)});     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        RXLogging.e(TAG, "setMicVolParam operate not allowed", th);
    }

    public void setMixerSoundType(int r100) {
        Method r101 = getMethod("setMixerSoundType", new Class[]{Integer.TYPE});     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.invoke(this.helper, new Object[]{Integer.valueOf(r100)});     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        RXLogging.e(TAG, "setMixerSoundType operate not allowed", th);
    }

    public void setPlayFeedbackParam(int r100) {
        Method r101 = getMethod("setPlayFeedbackParam", new Class[]{Integer.TYPE});     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.invoke(this.helper, new Object[]{Integer.valueOf(r100)});     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        RXLogging.e(TAG, "setPlayFeedbackParam operate not allowed", th);
    }

    private Method getMethod(String r100, Class<?>... r101) {
        Method r102 = this.methodCache.get(r100);
        if (r102 == null) goto L10;
        return r102;
    L10:
        Method r103 = this.helper.getClass().getMethod(r100, r101);     // Catch: Throwable -> L7
        this.methodCache.put(r100, r103);     // Catch: Throwable -> L7
        return r103;
    L7:
        th = move-exception;
        RXLogging.e(TAG, "Can not get method: " + r100, th);
        return null;
    }
}
