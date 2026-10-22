package com.bytedance.ttnet.mpa;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.cronet.mpa.IMpaService;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public class TTNetMpaService {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String CRONET_MPA_SERVICE_IMPL_CLASS = "org.chromium.mpa.CronetMpaServiceImpl";
    public static final String TAG = "TTNetMpaService";
    private IMpaService mMpsService;

    /* JADX INFO: renamed from: com.bytedance.ttnet.mpa.TTNetMpaService$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$ttnet$mpa$TTNetMpaService$HookMode = null;

        static {
            int[] r100 = new int[HookMode.values().length];
            $SwitchMap$com$bytedance$ttnet$mpa$TTNetMpaService$HookMode = r100;
            r100[HookMode.BYTE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$bytedance$ttnet$mpa$TTNetMpaService$HookMode[HookMode.SHADOW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$bytedance$ttnet$mpa$TTNetMpaService$HookMode[HookMode.SYMBOL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static final enum HookMode extends Enum<HookMode> {
        private static final /* synthetic */ HookMode[] $VALUES = null;
        public static final HookMode BYTE = null;
        public static final HookMode SHADOW = null;
        public static final HookMode SYMBOL = null;

        static {
            HookMode r100 = new HookMode("SYMBOL", 0);
            SYMBOL = r100;
            HookMode r101 = new HookMode("BYTE", 1);
            BYTE = r101;
            HookMode r102 = new HookMode("SHADOW", 2);
            SHADOW = r102;
            $VALUES = new HookMode[]{r100, r101, r102};
        }

        public static HookMode[] values() {
            return (HookMode[]) $VALUES.clone();
        }

        public static HookMode valueOf(String r100) {
            return (HookMode) a.a(HookMode.class, r100);
        }

        private HookMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class SingletonInstance {
        private static final TTNetMpaService INSTANCE = null;

        private SingletonInstance() {
        }

        static {
            INSTANCE = new TTNetMpaService(null);
        }

        public static /* synthetic */ TTNetMpaService access$100() {
            return INSTANCE;
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private boolean tryResolveCronetMpaServiceImpl() {
        if (this.mMpsService == null) goto L14;
        return true;
    L14:
        this.mMpsService = (IMpaService) INVOKESTATIC_com_bytedance_ttnet_mpa_TTNetMpaService_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(CRONET_MPA_SERVICE_IMPL_CLASS).newInstance();     // Catch: Throwable -> L7
    L10:
        if (this.mMpsService != null) goto L16;
        return false;
    L16:
        return true;
    L7:
        th = move-exception;
        th.printStackTrace();
        goto L10
    }

    public static TTNetMpaService getInstance() {
        return SingletonInstance.access$100();
    }

    static {
    }

    private TTNetMpaService() {
    }

    public /* synthetic */ TTNetMpaService(AnonymousClass1 r100) {
        this();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_ttnet_mpa_TTNetMpaService_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public void init(IMpaService.ICallback r100) {
        init(r100, HookMode.SYMBOL);
    }

    public void start(String r100) {
        IMpaService r101 = this.mMpsService;
        if (r101 == null) goto L6;
        r101.start();
        command("begin_user_log", r100);
        return;
    }

    public void stop(String r100) {
        if (this.mMpsService == null) goto L6;
        command("end_user_log", r100);
        this.mMpsService.stop();
        return;
    }

    private void command(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L11:
        Logger.e(TAG, "error command:" + r100 + " extraMessage:" + r101);
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L11;
        IMpaService r102 = this.mMpsService;
        if (r102 == null) goto L13;
        r102.command(r100, r101);
        return;
    }

    public void init(IMpaService.ICallback r100, HookMode r101) {
        if (tryResolveCronetMpaServiceImpl() == true) goto L6;
        r100.onFinish(false, "Load CronetMpaServiceImpl Failed");
        return;
    L6:
        int r102 = AnonymousClass1.$SwitchMap$com$bytedance$ttnet$mpa$TTNetMpaService$HookMode[r101.ordinal()];
        if (r102 != 1) goto L9;
        int r103 = ((Integer) Reflect.on(INVOKESTATIC_com_bytedance_ttnet_mpa_TTNetMpaService_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.android.bytehook.ByteHook").newInstance()).call("init").get()).intValue();     // Catch: Throwable -> L20
    L23:
        if (r103 == 0) goto L26;
        r100.onFinish(false, "Hook Init Error " + r103);
        return;
    L26:
        this.mMpsService.init(r100);
        return;
    L20:
        th = move-exception;
        th.printStackTrace();
    L22:
        r103 = -1;
        goto L23
    L9:
        if (r102 != 2) goto L11;
        r103 = ((Integer) Reflect.on(INVOKESTATIC_com_bytedance_ttnet_mpa_TTNetMpaService_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.shadowhook.ShadowHook").newInstance()).call("init").get()).intValue();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.printStackTrace();
        goto L22
    L11:
        if (r102 != 3) goto L22;
        r103 = 0;
        goto L23
    }

    public void setAccAddress(List<String> r100, IMpaService.ICallback r101) {
        if (r100 != null) goto L5;
    L13:
        if (r101 == null) goto L18;
        r101.onFinish(false, "Address error");
        return;
    L18:
        return;
    L5:
        if (r100.isEmpty() == true) goto L13;
        IMpaService r102 = this.mMpsService;
        if (r102 == null) goto L10;
        r102.setAccAddress(r100, r101);
        return;
    L10:
        if (r101 == null) goto L17;
        r101.onFinish(false, "MpsService is null");
        return;
    }
}
