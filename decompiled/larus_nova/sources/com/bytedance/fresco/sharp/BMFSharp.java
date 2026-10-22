package com.bytedance.fresco.sharp;

import android.graphics.Bitmap;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kc4.b;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes19.dex */
public class BMFSharp implements ISharpResolution {
    public static final int HEIGHT_DEFAULT = 4096;
    public static final String INIT_SUCCESS = "success";
    public static final int POOL_SIZE_DEFAULT = 2;
    private static final String TAG = "BMFSharp";
    public static final int WIDTH_DEFAULT = 4096;
    private static int mAlgorithmType = 0;
    private static boolean mOnlyUserInit = true;
    private static int mPoolSize;
    private static String mProgramCacheDir;
    private static int mQueuingTaskNum;
    private static boolean mSharpOptByTasks;
    private static int maxHeight;
    private static int maxWidth;
    private static final byte[] processLock = null;
    private static final ReadWriteLock rwlock = null;
    private static b v1Api;
    private static boolean v1Inited;
    private static b v2Api;
    private static boolean v2Inited;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        rwlock = new ReentrantReadWriteLock();
        processLock = new byte[0];
        maxWidth = 4096;
        maxHeight = 4096;
        mPoolSize = 2;
        mSharpOptByTasks = false;
        mQueuingTaskNum = 4;
    }

    public static int getMaxHeight() {
        return maxHeight;
    }

    public static int getMaxWidth() {
        return maxWidth;
    }

    public static boolean isOnlyUserInit() {
        return mOnlyUserInit;
    }

    public BMFSharp(int r100) {
        mAlgorithmType = r100;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_fresco_sharp_BMFSharp_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static Object getImplByName(String r100) throws Exception {
        Class r101 = INVOKESTATIC_com_bytedance_fresco_sharp_BMFSharp_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.bmf_mods_lite." + r100);
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.newInstance();
    }

    public static String init(int r100) {
        ReadWriteLock r101 = rwlock;
        r101.readLock().lock();
        if (r100 != 3) goto L9;
        if (v1Inited == false) goto L9;
        r101.readLock().unlock();
        return "success";
    L9:
        if (r100 == 4) goto L11;
    L14:
        r101.readLock().unlock();
        r101.writeLock().lock();
        if (r100 != 3) goto L17;
        v1Api = (b) getImplByName("Sharpen");     // Catch: Exception -> L19
    L18:
        String r102 = "";
    L22:
        if (r100 != 3) goto L28;
        if (v1Api != null) goto L31;
        FLog.i(TAG, "SharpenApi is null after initialization");
        String r103 = r102 + "SharpenApi is null after initialization";
        rwlock.writeLock().unlock();
        return r103;
    L31:
        if (r100 != 3) goto L33;
        int r104 = v1Api.b();
    L34:
        if (r104 != 0) goto L36;
        FLog.i(TAG, "SharpenApi initialization success");
    L37:
        boolean r105 = false;
        if (r100 != 3) goto L42;
        if (r104 != 0) goto L41;
        r105 = true;
    L41:
        v1Inited = r105;
    L45:
        rwlock.writeLock().unlock();
        if (r100 != 3) goto L51;
        if (v1Inited == false) goto L54;
        return "success";
    L54:
        return r102;
    L51:
        if (v2Inited == false) goto L54;
        return "success";
    L42:
        if (r104 != 0) goto L44;
        r105 = true;
    L44:
        v2Inited = r105;
        goto L45
    L36:
        FLog.e(TAG, "SharpenApi initialization error, res = " + r104);
        r102 = r102 + "SharpenApi initialization error, res = " + r104;
        goto L37
    L33:
        r104 = v2Api.b();
        goto L34
    L28:
        if (v2Api != null) goto L31;
        FLog.i(TAG, "SharpenApi is null after initialization");
        String r106 = r102 + "SharpenApi is null after initialization";
        rwlock.writeLock().unlock();
        return r106;
    L17:
        v2Api = (b) getImplByName("Sharpen");     // Catch: Exception -> L19
    L19:
        e = move-exception;
        FLog.i(TAG, "Sharpen class not found, " + e.getMessage());
        String r107 = "Sharpen class not found, " + e.getMessage();
        e.printStackTrace();
        r102 = r107;
        goto L22
    L11:
        if (v2Inited == false) goto L14;
        r101.readLock().unlock();
        return "success";
    }

    public static String isInited(int r100) {
        if (r100 != 3) goto L7;
        if (v1Inited == false) goto L7;
        return "success";
    L7:
        if (r100 == 4) goto L9;
        return "The business has not been initialized yet";
    L9:
        if (v2Inited == false) goto L15;
        return "success";
    L15:
        return "The business has not been initialized yet";
    }

    public static void setOnlyUserInit(boolean r100) {
        mOnlyUserInit = r100;
    }

    @Override // com.bytedance.fresco.sharp.ISharpResolution
    public void destroy(int r100) {
        ReadWriteLock r101 = rwlock;
        r101.writeLock().lock();
        if (r100 != 3) goto L10;
        b r102 = v1Api;
        if (r102 != null) goto L7;
    L9:
        v1Inited = false;
    L16:
        r101.writeLock().unlock();
        return;
    L7:
        if (v1Inited == false) goto L9;
        r102.Free();
        goto L9
    L10:
        b r103 = v2Api;
        if (r103 != null) goto L13;
    L15:
        v2Inited = false;
        goto L16
    L13:
        if (v2Inited == false) goto L15;
        r103.Free();
        goto L15
    }

    public BMFSharp(int r100, int r101, String r102) {
        mAlgorithmType = r100;
        mPoolSize = r101;
        mProgramCacheDir = r102;
    }

    public BMFSharp(int r100, int r101, int r102, int r103, String r104) {
        mAlgorithmType = r100;
        maxWidth = r101;
        maxHeight = r102;
        mPoolSize = r103;
        mProgramCacheDir = r104;
    }

    public static String initBMFSharp(int r100, int r101, int r102, int r103, String r104, boolean r105, int r106) {
        mAlgorithmType = r100;
        if (r101 > 0) goto L5;
        r101 = 4096;
    L5:
        maxWidth = r101;
        if (r102 > 0) goto L8;
        r102 = 4096;
    L8:
        maxHeight = r102;
        mPoolSize = r103;
        mProgramCacheDir = r104;
        mSharpOptByTasks = r105;
        mQueuingTaskNum = r106;
        return init(r100);
    }

    @Override // com.bytedance.fresco.sharp.ISharpResolution
    public CloseableReference<Bitmap> process(Bitmap r100, PlatformBitmapFactory r101, int r102, float r103, float r104, float r105, boolean r106, float r107, float r108) throws Exception {
        if (mSharpOptByTasks == false) goto L13;
        if (r102 == 3) goto L6;
    L7:
        if (r102 != 4) goto L13;
        if (v2Api.g() <= mQueuingTaskNum) goto L13;
    L12:
        throw new SharpTaskTooManyException(-200000, "Do not do SharpProcess because the current number of sharp tasks:" + v1Api.g() + ", mQueuingTaskNum:" + mQueuingTaskNum);
    L6:
        if (v1Api.g() > mQueuingTaskNum) goto L12;
    L13:
        if (r102 == 3) goto L15;
    L16:
        if (r102 == 4) goto L18;
    L21:
        byte[] r109 = processLock;
        monitor-enter(r109);
        if (r102 != 3) goto L25;
        Bitmap r110 = v1Api.l();     // Catch: Throwable -> L32
    L26:
        if (r110 == null) goto L31;
        CloseableReference<Bitmap> r111 = r101.createBitmap(r110);     // Catch: Throwable -> L32
        monitor-exit(r109);     // Catch: Throwable -> L32
        return r111;
    L31:
        throw new Exception("ProcessMultiScaleBitmap result is null!");     // Catch: Throwable -> L32
    L25:
        r110 = v2Api.l();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    L18:
        if (v2Api != null) goto L21;
        return null;
    L15:
        if (v1Api != null) goto L16;
        return null;
    }
}
