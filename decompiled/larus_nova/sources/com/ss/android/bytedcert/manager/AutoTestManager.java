package com.ss.android.bytedcert.manager;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public class AutoTestManager {
    public static final String TAG = "AutoTest";
    private String backImagePath;
    public b callback;
    private String frontImagePath;
    private byte[] mAutoTestFace;
    private volatile int mImageH;
    private volatile int mImageW;
    private boolean mIsAutoTest;
    private String motionStr;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AutoTestManager f407552a = null;

        static {
            f407552a = new AutoTestManager();
        }
    }

    public interface b {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public void initHook() throws Exception {
        Class r100 = INVOKESTATIC_com_ss_android_bytedcert_manager_AutoTestManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.ss.android.bytedcert.certTest.SHook");
        if (((Boolean) r100.getMethod("isgHook", new Class[0]).invoke(null, new Object[0])).booleanValue() == true) goto L6;
        r100.getMethod("init", new Class[0]).invoke(null, new Object[0]);
        return;
    }

    public AutoTestManager() {
        this.mAutoTestFace = null;
    }

    public static AutoTestManager getInstance() {
        return a.f407552a;
    }

    public byte[] getAutoTestFace() {
        return this.mAutoTestFace;
    }

    public String getBackImagePath() {
        return this.backImagePath;
    }

    public String getFrontImagePath() {
        return this.frontImagePath;
    }

    public int getImageH() {
        return this.mImageH;
    }

    public int getImageW() {
        return this.mImageW;
    }

    public String getMotionStr() {
        return this.motionStr;
    }

    public boolean isAutoTest() {
        return this.mIsAutoTest;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_bytedcert_manager_AutoTestManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static void outputLog(String r100) {
        if (getInstance().isAutoTest() == false) goto L6;
        getInstance().getClass();
        return;
    }

    public void setAutoTest(boolean r100) {
        this.mIsAutoTest = r100;
    }

    public void setAutoTestFace(byte[] r100) {
        monitor-enter(this);
        this.mAutoTestFace = r100;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void setBackImagePath(String r100) {
        this.backImagePath = r100;
    }

    public void setFrontImagePath(String r100) {
        this.frontImagePath = r100;
    }

    public void setImageH(int r100) {
        this.mImageH = r100;
    }

    public void setImageW(int r100) {
        this.mImageW = r100;
    }

    public void setMotionStr(String r100) {
        this.motionStr = r100;
    }
}
