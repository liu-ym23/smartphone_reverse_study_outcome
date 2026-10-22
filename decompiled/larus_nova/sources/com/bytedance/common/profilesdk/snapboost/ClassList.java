package com.bytedance.common.profilesdk.snapboost;

import com.bytedance.common.profilesdk.AppContext;
import com.bytedance.common.profilesdk.util.Logger;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import dalvik.system.PathClassLoader;
import el9.a;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes15.dex */
public class ClassList {
    static Class sClzBootClassLoader;
    List<String> mClassNames;
    String mFileName;
    ClassLoader mLoader;

    public static class PreloadResult {
        public static PreloadResult EMPTY;
        private final int loadedCount;
        private final int notFoundCount;

        static {
            EMPTY = new PreloadResult(0, 0);
        }

        public int getLoadedCount() {
            return this.loadedCount;
        }

        public int getNotFoundCount() {
            return this.notFoundCount;
        }

        public PreloadResult(int r100, int r101) {
            this.loadedCount = r100;
            this.notFoundCount = r101;
        }
    }

    public static /* synthetic */ Class access$000(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        return Class.forName(r100, r101, r102);
    }

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        sClzBootClassLoader = INVOKESTATIC_com_bytedance_common_profilesdk_snapboost_ClassList_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("java.lang.BootClassLoader");     // Catch: ClassNotFoundException -> L4
        return;
    }

    private void processWildcard() {
        if (SnapBoost.versionSupport() == true) goto L5;
        return;
    L5:
        if (SnapBoost.hasInited() == false) goto L93;
        long r100 = System.currentTimeMillis();
        ArrayList r101 = new ArrayList();
        BufferedReader r102 = new BufferedReader(new InputStreamReader(AppContext.getContext().getAssets().open(this.mFileName)));     // Catch: IOException -> L23 FileNotFoundException -> L25
    L69:
        String r103 = r102.readLine();     // Catch: Throwable -> L15
        if (r103 == null) goto L12;
        r101.add(r103);     // Catch: Throwable -> L15
        goto L69
    L12:
        Logger.d("ClassList: process " + this.mFileName + " from assets");     // Catch: Throwable -> L15
        r102.close();     // Catch: IOException -> L23 FileNotFoundException -> L25
    L27:
        Iterator r104 = r101.iterator();
        List<String> r105 = null;
        int r106 = 0;
    L29:
        if (r104.hasNext() == false) goto L43;
        String r107 = (String) r104.next();
        if (r107.endsWith("*") == true) goto L32;
        this.mClassNames.add(r107);
        goto L29
    L32:
        if (r105 != null) goto L34;
        r105 = AppContext.getDexClassNames();
    L34:
        String r108 = r107.substring(0, r107.lastIndexOf(42));
        Iterator<String> r110 = r105.iterator();
        int r111 = 0;
    L36:
        if (r110.hasNext() == false) goto L40;
        String r112 = r110.next();
        if (r112.startsWith(r108) == false) goto L36;
        this.mClassNames.add(r112);
        r106 = r106 + 1;
        r111 = r111 + 1;
        goto L36
    L40:
        Logger.d("ClassList: process " + r107 + " match " + r111);
        goto L29
    L43:
        if (this.mClassNames.isEmpty() == false) goto L66;
    L62:
        Logger.d("ClassList: process " + r101.size() + " line, found " + this.mClassNames.size() + "(" + r106 + "), took " + (System.currentTimeMillis() - r100) + "ms, save to " + getFilePath().getAbsolutePath());
        return;
    L66:
        BufferedWriter r109 = new BufferedWriter(new PolarisFileWriterWrapper(getFilePath(), false));     // Catch: IOException -> L60
        Iterator<String> r113 = this.mClassNames.iterator();     // Catch: Throwable -> L52
    L47:
        if (r113.hasNext() == false) goto L50;
        r109.write(r113.next());     // Catch: Throwable -> L52
        r109.newLine();     // Catch: Throwable -> L52
    L50:
        r109.close();     // Catch: IOException -> L60
    L52:
        th = move-exception;
        throw th;     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        r109.close();     // Catch: Throwable -> L57
    L59:
        throw th;     // Catch: IOException -> L60
    L57:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L60
    L60:
        e = move-exception;
        Logger.e("io exception: ", e);
        goto L62
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L20
    L22:
        throw th;     // Catch: IOException -> L23 FileNotFoundException -> L25
    L20:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L23 FileNotFoundException -> L25
    L25:
        e = move-exception;
        Logger.e("FileNotFoundException ", e);
    L23:
        e = move-exception;
        Logger.e("IOException ", e);
        goto L27
    }

    public List<String> getClassNames() {
        if (this.mClassNames.isEmpty() == false) goto L5;
        ArrayList r100 = new ArrayList();
        boolean r101 = false;
        BufferedReader r102 = new BufferedReader(new PolarisFileReaderWrapper(getFilePath()));     // Catch: IOException -> L22 FileNotFoundException -> L24
    L59:
        String r103 = r102.readLine();     // Catch: Throwable -> L14
        if (r103 == null) goto L12;
        r100.add(r103);     // Catch: Throwable -> L14
        goto L59
    L12:
        r102.close();     // Catch: IOException -> L22 FileNotFoundException -> L24
        r101 = true;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L19
    L21:
        throw th;     // Catch: IOException -> L22 FileNotFoundException -> L24
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L22 FileNotFoundException -> L24
    L22:
        e = move-exception;
        Logger.e("io exception", e);
    L25:
        if (r101 == false) goto L62;
    L47:
        this.mClassNames.addAll(r100);
        return this.mClassNames;
    L62:
        BufferedReader r104 = new BufferedReader(new InputStreamReader(AppContext.getContext().getAssets().open(this.mFileName)));     // Catch: IOException -> L43 FileNotFoundException -> L45
    L51:
        String r105 = r104.readLine();     // Catch: Throwable -> L35
        if (r105 == null) goto L33;
        if (r105.endsWith("*") == true) goto L51;
        r100.add(r105);     // Catch: Throwable -> L35
        goto L51
    L33:
        r104.close();     // Catch: IOException -> L43 FileNotFoundException -> L45
    L35:
        th = move-exception;
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        r104.close();     // Catch: Throwable -> L40
    L42:
        throw th;     // Catch: IOException -> L43 FileNotFoundException -> L45
    L40:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L43 FileNotFoundException -> L45
    L45:
        e = move-exception;
        Logger.e("FileNotFoundException ", e);
    L43:
        e = move-exception;
        Logger.e("IOException ", e);
        goto L47
    L5:
        return this.mClassNames;
    }

    public File getFilePath() {
        return new PolarisFileWrapper(AppContext.getProfilesDir(), this.mFileName);
    }

    public boolean isRaw() {
        return !getFilePath().exists();
    }

    public void processWildcardIfNeeded() {
        if (SnapBoost.versionSupport() == true) goto L5;
        return;
    L5:
        if (SnapBoost.hasInited() == true) goto L8;
        return;
    L8:
        if (isRaw() == false) goto L12;
        processWildcard();
        return;
    }

    public PreloadResult tryPreloadClasses() {
        if (SnapBoost.versionSupport() == false) goto L14;
        if (SnapBoost.hasInited() == false) goto L14;
        List<String> r100 = getClassNames();
        if (r100.isEmpty() == true) goto L12;
        return loadClasses((String[]) r100.toArray(new String[0]), this.mLoader);
    L12:
        return PreloadResult.EMPTY;
    L14:
        return PreloadResult.EMPTY;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_common_profilesdk_snapboost_ClassList_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$001(r100);     // Catch: Throwable -> L8
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
        Class r104 = access$001(r100);     // Catch: Throwable -> L17
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

    public ClassList(String r100, ClassLoader r101) {
        this.mClassNames = new ArrayList();
        this.mLoader = null;
        this.mFileName = r100;
        if ((r101 instanceof PathClassLoader) == false) goto L6;
        this.mLoader = r101;
        return;
    }

    public static PreloadResult loadClasses(String[] r110, ClassLoader r111) {
        if (SnapBoost.versionSupport() == false) goto L5;
        if (r111 == null) goto L8;
        long r100 = System.currentTimeMillis();
        int r101 = r110.length;
        int r102 = 0;
        int r103 = 0;
        int r104 = 0;
    L10:
        if (r102 >= r101) goto L37;
        String r105 = r110[r102];
        r103 = r103 + 1;     // Catch: Throwable -> L31
        boolean r106 = true;
        if (INVOKESTATIC_com_bytedance_common_profilesdk_snapboost_ClassList_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r105, false, r111).getClassLoader() != r111) goto L16;
    L24:
        if (r106 == true) goto L36;
        if (Logger.isEnabled() == false) goto L28;
    L29:
        Logger.d("LoadClasses: class load error, " + r105 + " loader: " + r111.getClass().getName() + r111.hashCode());     // Catch: Throwable -> L31
        goto L36
    L28:
        if (Logger.getEnableLoadClass() == true) goto L29;
    L36:
        r102 = r102 + 1;
        goto L10
    L16:
        if ((r111 instanceof PathClassLoader) == true) goto L24;
        Class r107 = sClzBootClassLoader;     // Catch: Throwable -> L31
        if (r107 != null) goto L21;
    L23:
        r106 = false;
        goto L24
    L21:
        if (r107.isInstance(r111) == false) goto L23;
    L31:
        r104 = r104 + 1;
        if (Logger.isEnabled() == false) goto L34;
    L35:
        Logger.d("LoadClasses: class not found " + r105);
        goto L36
    L34:
        if (Logger.getEnableLoadClass() == false) goto L36;
    L37:
        Logger.e("LoadClasses: load " + r103 + ", " + r104 + " not found, took " + (System.currentTimeMillis() - r100));
        return new PreloadResult(r103, r104);
    L8:
        return PreloadResult.EMPTY;
    L5:
        return PreloadResult.EMPTY;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_common_profilesdk_snapboost_ClassList_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r105 = access$000(r100, r101, r102);     // Catch: Throwable -> L8
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r105;
    L8:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r106 = access$000(r100, r101, r102);     // Catch: Throwable -> L17
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r106;
    L17:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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
}
