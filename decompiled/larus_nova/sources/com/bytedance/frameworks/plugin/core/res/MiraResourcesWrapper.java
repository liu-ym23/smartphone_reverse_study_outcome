package com.bytedance.frameworks.plugin.core.res;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.bytedance.mira.MiraManager;
import com.bytedance.mira.compat.q.DoubleReflector;
import com.bytedance.mira.core.MiraResourcesManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.resources.TypedArrayWrapperSynchronizedPool;
import com.bytedance.mira.util.FieldUtils;
import com.bytedance.mira.util.MethodUtils;
import com.bytedance.mira.util.OSUtil;
import com.bytedance.mira.util.ResUtil;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import f6.d;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes19.dex */
public class MiraResourcesWrapper extends Resources {
    protected final d mResourceIdVisitor;
    protected final Resources mResources;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static Resources f244846a;

        public static Resources a(Resources r100) {
            Resources r101 = f244846a;
            if (r101 != null) goto L5;
        L15:
            Resources r102 = MiraResourcesManager.getInstance().getAppResources();     // Catch: Exception -> L12
            if ((r102 instanceof MiraResourcesWrapper) == false) goto L9;
            r102 = ((MiraResourcesWrapper) r102).getResources();     // Catch: Exception -> L12
        L9:
            Context r103 = (Context) ((WeakReference) FieldUtils.readField(r100, "mContextRef")).get();     // Catch: Exception -> L12
            f244846a = (Resources) MethodUtils.invokeConstructor(r100.getClass(), new Object[]{r103, r102}, new Class[]{Context.class, Resources.class});     // Catch: Exception -> L12
        L11:
            return f244846a;
        L12:
            e = move-exception;
            throw new RuntimeException("TintResourcesCompat#Construct TintResources failed.", e);
        L5:
            if (r101.getAssets() == MiraResourcesManager.getInstance().getAppResources().getAssets()) goto L11;
            goto L15
        }

        public static Drawable b(Resources r100, int r101) {
            return a(r100).getDrawable(r101);
        L4:
            e = move-exception;
            if (e.toString().contains("android.content.res.Resources") == true) goto L12;
            if (e.toString().contains("Error inflating class") == true) goto L12;
            if (e.toString().contains("java.lang.ArrayIndexOutOfBoundsException") == true) goto L12;
        L22:
            throw e;
        L12:
            if (e.toString().contains("OutOfMemoryError") == true) goto L22;
            String r102 = "BackupTintResources#Assets: ";
            if (f244846a == null) goto L17;
            r102 = "BackupTintResources#Assets: " + ResUtil.getAssetPathsStr(f244846a.getAssets());
        L17:
            if ((e instanceof Resources.NotFoundException) == false) goto L21;
            throw new Resources.NotFoundException(r102 + "," + e.getMessage());
        L21:
            throw new RuntimeException(r102, e);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static Resources f244847a;

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class a() throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r102 = Class.forName("android.support.v7.widget.AppCompatDrawableManager");     // Catch: Throwable -> L8
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a("android.support.v7.widget.AppCompatDrawableManager");     // Catch: Throwable -> L8
        L7:
            return r102;
        L8:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b("android.support.v7.widget.AppCompatDrawableManager");
        L12:
            throw th;
        L34:
            Class<?> r103 = Class.forName("android.support.v7.widget.AppCompatDrawableManager");     // Catch: Throwable -> L17
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a("android.support.v7.widget.AppCompatDrawableManager");     // Catch: Throwable -> L17
        L16:
            return r103;
        L17:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b("android.support.v7.widget.AppCompatDrawableManager");
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName("android.support.v7.widget.AppCompatDrawableManager");
        }

        public static Resources b(Resources r100) {
            Resources r101 = f244847a;
            if (r101 != null) goto L5;
        L12:
            Context r102 = (Context) ((WeakReference) FieldUtils.readField(r100, "mContextRef")).get();     // Catch: Exception -> L9
            f244847a = (Resources) MethodUtils.invokeConstructor(r100.getClass(), new Object[]{r102, MiraResourcesManager.getInstance().getAppResources()}, new Class[]{Context.class, Resources.class});     // Catch: Exception -> L9
        L8:
            return f244847a;
        L9:
            e = move-exception;
            throw new RuntimeException("VectorTintResourcesCompat#Construct VectorEnabledTintResources failed.", e);
        L5:
            if (r101.getAssets() == MiraResourcesManager.getInstance().getAppResources().getAssets()) goto L8;
            goto L12
        }

        public static Drawable c(Resources r100, int r101) {
            Class r102 = a();     // Catch: Exception -> L4
            FieldUtils.writeStaticField(r102, "INSTANCE", null);     // Catch: Exception -> L4
            MethodUtils.invokeStaticMethod(r102, MonitorConstants.CONNECT_TYPE_GET, new Object[0]);     // Catch: Exception -> L4
        L6:
            return b(r100).getDrawable(r101);
        L8:
            e = move-exception;
            if (e.toString().contains("android.content.res.Resources") == true) goto L16;
            if (e.toString().contains("Error inflating class") == true) goto L16;
            if (e.toString().contains("java.lang.ArrayIndexOutOfBoundsException") == true) goto L16;
        L26:
            throw e;
        L16:
            if (e.toString().contains("OutOfMemoryError") == true) goto L26;
            String r103 = "BackupVectorResources#Assets: ";
            if (f244847a == null) goto L21;
            r103 = "BackupVectorResources#Assets: " + ResUtil.getAssetPathsStr(f244847a.getAssets());
        L21:
            if ((e instanceof Resources.NotFoundException) == false) goto L25;
            throw new Resources.NotFoundException(r103 + "," + e.getMessage());
        L25:
            throw new RuntimeException(r103, e);
        L4:
            e = move-exception;
            e.printStackTrace();     // Catch: RuntimeException -> L8
            goto L6
        }
    }

    public static /* synthetic */ DisplayMetrics access$000(Resources r100) {
        return super.getDisplayMetrics();
    }

    private int getHtcBugCompatId(int r100) {
        if (r100 != 67764272) goto L6;
        return 25;
    L6:
        if (r100 != 67764273) goto L10;
        return 3;
    L10:
        if (r100 != 67764274) goto L13;
        return 25;
    L13:
        if (r100 != 67764275) goto L16;
        return 10;
    L16:
        return 0;
    }

    private boolean isHtcBugCompat(int r100) {
        return false;
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        return this.mResources.getConfiguration();
    }

    @Override // android.content.res.Resources
    public DisplayMetrics getDisplayMetrics() {
        return INVOKEVIRTUAL_com_bytedance_frameworks_plugin_core_res_MiraResourcesWrapper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.mResources);
    }

    private Resources getGlobalRealResources() {
        Resources r100 = MiraResourcesManager.getInstance().getAppResources();
        if ((r100 instanceof MiraResourcesWrapper) == true) goto L5;
        return r100;
    L5:
        return ((MiraResourcesWrapper) r100).getResources();
    }

    public DisplayMetrics getSuperDisplayMetrics() {
        return INVOKESPECIAL_com_bytedance_frameworks_plugin_core_res_MiraResourcesWrapper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this);
    }

    public Resources getResources() {
        return this.mResources;
    }

    public MiraResourcesWrapper(Resources r100) {
        super(r100.getAssets(), INVOKEVIRTUAL_com_bytedance_frameworks_plugin_core_res_MiraResourcesWrapper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100), r100.getConfiguration());
        this.mResources = r100;
        if (MiraManager.getInstance().getParam().isEnableDrawableAccessReport() == false) goto L6;
        replaceResourcesSynchronizedPool(this);
        MiraManager.getInstance().getParam().getResourceIdVisitor();
        return;
    }

    public static DisplayMetrics INVOKESPECIAL_com_bytedance_frameworks_plugin_core_res_MiraResourcesWrapper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, access$000(r100));
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_frameworks_plugin_core_res_MiraResourcesWrapper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private void handleException(Resources.NotFoundException r100) {
        if (r100.toString().contains("android.content.res.Resources") == true) goto L9;
        if (r100.toString().contains("Error inflating class") == true) goto L9;
        if (r100.toString().contains("java.lang.ArrayIndexOutOfBoundsException") == true) goto L9;
        throw r100;
    L9:
        if (r100.toString().contains("OutOfMemoryError") == true) goto L17;
        String r101 = (("Resources#Assets: " + ResUtil.getAssetPathsStr(this.mResources.getAssets())) + "  ResMrg#Res#Assets: " + ResUtil.getAssetPathsStr(MiraResourcesManager.getInstance().getAppResources().getAssets())) + "  AssetPathCache#Assets: " + MiraResourcesManager.getInstance().getAssetPathCachesStr();
        if (Build.VERSION.SDK_INT < 24) goto L15;
        throw new Resources.NotFoundException(r101 + "," + r100.getMessage(), (Exception) r100.getCause());
    L15:
        throw new Resources.NotFoundException(r101 + "," + r100.getMessage());
    L17:
        throw r100;
    }

    private boolean isLetvBugCompat(int r100) {
        if (r100 == 0) goto L4;
        return false;
    L4:
        if ("letv".equals(Build.BRAND.toLowerCase()) == false) goto L14;
        int r101 = Build.VERSION.SDK_INT;
        if (r101 != 21) goto L8;
        return true;
    L8:
        if (r101 != 22) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    }

    private void notifyResourceAccess(int r100) {
        MiraManager.getInstance().getParam().isEnableDrawableAccessReport();
    }

    private void replaceResourcesSynchronizedPool(Resources r100) {
        TypedArrayWrapperSynchronizedPool r101 = new TypedArrayWrapperSynchronizedPool(5, r100);     // Catch: IllegalAccessException -> L10
        if (OSUtil.isAndroidQHigher() == false) goto L8;
        Field r102 = DoubleReflector.getFieldAll(Resources.class, "mTypedArrayPool");     // Catch: IllegalAccessException -> L10
        if (r102 == null) goto L13;
        FieldUtils.writeField(r102, r100, r101);     // Catch: IllegalAccessException -> L10
    L13:
        return;
    L8:
        FieldUtils.writeField(r100, "mTypedArrayPool", r101);     // Catch: IllegalAccessException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int r100) throws Resources.NotFoundException {
        XmlResourceParser r101 = this.mResources.getAnimation(r100);     // Catch: Throwable -> L5 Resources.NotFoundException -> L7
        notifyResourceAccess(r100);
        return r101;
    L7:
        XmlResourceParser r102 = getGlobalRealResources().getAnimation(r100);     // Catch: Throwable -> L5 Resources.NotFoundException -> L10
        notifyResourceAccess(r100);
        return r102;
    L10:
        e = move-exception;
        handleException(e);     // Catch: Throwable -> L5
        notifyResourceAccess(r100);
        return null;
    L5:
        th = move-exception;
        notifyResourceAccess(r100);
        throw th;
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int r100) throws Resources.NotFoundException {
        return this.mResources.getBoolean(r100);
    L4:
        return getGlobalRealResources().getBoolean(r100);
    L6:
        e = move-exception;
        handleException(e);
        return false;
    }

    @Override // android.content.res.Resources
    public int getColor(int r100) throws Resources.NotFoundException {
        return this.mResources.getColor(r100);
    L4:
        return getGlobalRealResources().getColor(r100);
    L6:
        e = move-exception;
        handleException(e);
        return 0;
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int r100) throws Resources.NotFoundException {
        return this.mResources.getColorStateList(r100);
    L4:
        return getGlobalRealResources().getColorStateList(r100);
    L6:
        e = move-exception;
        handleException(e);
        return null;
    }

    @Override // android.content.res.Resources
    public float getDimension(int r100) throws Resources.NotFoundException {
        return this.mResources.getDimension(r100);
    L5:
        if (isHtcBugCompat(r100) == true) goto L7;
        return getGlobalRealResources().getDimension(r100);
    L10:
        e = move-exception;
        handleException(e);
        return 0.0f;
    L7:
        return getHtcBugCompatId(r100);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int r100) throws Resources.NotFoundException {
        return this.mResources.getDimensionPixelOffset(r100);
    L5:
        if (isHtcBugCompat(r100) == true) goto L7;
        return getGlobalRealResources().getDimensionPixelOffset(r100);
    L10:
        e = move-exception;
        handleException(e);
        return 0;
    L7:
        return getHtcBugCompatId(r100);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int r100) throws Resources.NotFoundException {
        return this.mResources.getDimensionPixelSize(r100);
    L5:
        if (isHtcBugCompat(r100) == true) goto L7;
        return getGlobalRealResources().getDimensionPixelSize(r100);
    L10:
        e = move-exception;
        handleException(e);
        return 0;
    L7:
        return getHtcBugCompatId(r100);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int r100) throws Resources.NotFoundException {
        Drawable r101 = this.mResources.getDrawable(r100);     // Catch: Throwable -> L5 Resources.NotFoundException -> L7
        notifyResourceAccess(r100);
        return r101;
    L5:
        th = move-exception;
        notifyResourceAccess(r100);
        throw th;
    L9:
        if (isLetvBugCompat(r100) == false) goto L13;
        notifyResourceAccess(r100);
        return null;
    L13:
        if ("android.support.v7.widget.VectorEnabledTintResources".equals(this.mResources.getClass().getName()) == false) goto L18;
        Drawable r102 = b.c(this.mResources, r100);     // Catch: Throwable -> L5
        notifyResourceAccess(r100);
        return r102;
    L18:
        if ("android.support.v7.widget.TintResources".equals(this.mResources.getClass().getName()) == false) goto L33;
        Drawable r103 = a.b(this.mResources, r100);     // Catch: Throwable -> L5
        notifyResourceAccess(r100);
        return r103;
    L33:
        Drawable r104 = getGlobalRealResources().getDrawable(r100);     // Catch: Throwable -> L5 Resources.NotFoundException -> L25
        notifyResourceAccess(r100);
        return r104;
    L25:
        e = move-exception;
        handleException(e);     // Catch: Throwable -> L5
        notifyResourceAccess(r100);
        return null;
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int r100) throws Resources.NotFoundException {
        return this.mResources.getIntArray(r100);
    L4:
        return getGlobalRealResources().getIntArray(r100);
    L6:
        e = move-exception;
        handleException(e);
        return null;
    }

    @Override // android.content.res.Resources
    public int getInteger(int r100) throws Resources.NotFoundException {
        return this.mResources.getInteger(r100);
    L4:
        return getGlobalRealResources().getInteger(r100);
    L6:
        e = move-exception;
        handleException(e);
        return 0;
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int r100) throws Resources.NotFoundException {
        XmlResourceParser r101 = this.mResources.getLayout(r100);     // Catch: Throwable -> L5 Resources.NotFoundException -> L7
        notifyResourceAccess(r100);
        return r101;
    L7:
        XmlResourceParser r102 = getGlobalRealResources().getLayout(r100);     // Catch: Throwable -> L5 Resources.NotFoundException -> L10
        notifyResourceAccess(r100);
        return r102;
    L10:
        e = move-exception;
        handleException(e);     // Catch: Throwable -> L5
        notifyResourceAccess(r100);
        return null;
    L5:
        th = move-exception;
        notifyResourceAccess(r100);
        throw th;
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int r100) throws Resources.NotFoundException {
        return this.mResources.getMovie(r100);
    L4:
        return getGlobalRealResources().getMovie(r100);
    L6:
        e = move-exception;
        handleException(e);
        return null;
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int r100) throws Resources.NotFoundException {
        return this.mResources.getResourceEntryName(r100);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int r100) throws Resources.NotFoundException {
        return this.mResources.getResourceName(r100);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int r100) throws Resources.NotFoundException {
        return this.mResources.getResourcePackageName(r100);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int r100) throws Resources.NotFoundException {
        return this.mResources.getResourceTypeName(r100);
    }

    @Override // android.content.res.Resources
    public String getString(int r100) throws Resources.NotFoundException {
        return this.mResources.getString(r100);
    L4:
        return getGlobalRealResources().getString(r100);
    L6:
        e = move-exception;
        if (r100 == 0) goto L14;
        handleException(e);
        return null;
    L14:
        return null;
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int r100) throws Resources.NotFoundException {
        return this.mResources.getStringArray(r100);
    L4:
        return getGlobalRealResources().getStringArray(r100);
    L6:
        e = move-exception;
        handleException(e);
        return null;
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int r100) throws Resources.NotFoundException {
        return this.mResources.getText(r100);
    L4:
        return getGlobalRealResources().getText(r100);
    L6:
        e = move-exception;
        handleException(e);
        return null;
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int r100) throws Resources.NotFoundException {
        return this.mResources.getTextArray(r100);
    L4:
        return getGlobalRealResources().getTextArray(r100);
    L6:
        e = move-exception;
        handleException(e);
        return null;
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int r100) throws Resources.NotFoundException {
        XmlResourceParser r101 = this.mResources.getXml(r100);     // Catch: Throwable -> L5 Resources.NotFoundException -> L7
        notifyResourceAccess(r100);
        return r101;
    L7:
        XmlResourceParser r102 = getGlobalRealResources().getXml(r100);     // Catch: Throwable -> L5 Resources.NotFoundException -> L10
        notifyResourceAccess(r100);
        return r102;
    L10:
        e = move-exception;
        handleException(e);     // Catch: Throwable -> L5
        notifyResourceAccess(r100);
        return null;
    L5:
        th = move-exception;
        notifyResourceAccess(r100);
        throw th;
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int r100) throws Resources.NotFoundException {
        return this.mResources.obtainTypedArray(r100);
    L4:
        e = move-exception;
        handleException(e);
        return null;
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int r100) throws Resources.NotFoundException {
        return this.mResources.openRawResource(r100);
    L4:
        return getGlobalRealResources().openRawResource(r100);
    L6:
        e = move-exception;
        handleException(e);
        return null;
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int r100) throws Resources.NotFoundException {
        return this.mResources.openRawResourceFd(r100);
    L4:
        return getGlobalRealResources().openRawResourceFd(r100);
    L6:
        e = move-exception;
        handleException(e);
        return null;
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int r100, Resources.Theme r101) throws Resources.NotFoundException {
        Drawable r102 = this.mResources.getDrawable(r100, r101);     // Catch: Throwable -> L5 ArrayIndexOutOfBoundsException -> L7 Resources.NotFoundException -> L16
        notifyResourceAccess(r100);
        return r102;
    L5:
        th = move-exception;
        notifyResourceAccess(r100);
        throw th;
    L7:
        e = move-exception;
        if (MiraManager.getInstance().getParam().isEnableArrayIndexExceptionFix() == true) goto L11;
    L15:
        throw e;     // Catch: Throwable -> L5
    L11:
        if (OSUtil.isAndroidN() == false) goto L15;
        Drawable r103 = getDrawableByReflectWithSync(this.mResources, r100, r101);     // Catch: Throwable -> L5
        notifyResourceAccess(r100);
        return r103;
    L18:
        if (isLetvBugCompat(r100) == false) goto L31;
        notifyResourceAccess(r100);
        return null;
    L31:
        Drawable r104 = getGlobalRealResources().getDrawable(r100, r101);     // Catch: Throwable -> L5 Resources.NotFoundException -> L24
        notifyResourceAccess(r100);
        return r104;
    L24:
        e = move-exception;
        handleException(e);     // Catch: Throwable -> L5
        notifyResourceAccess(r100);
        return null;
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int r100, int r101) throws Resources.NotFoundException {
        Drawable r102 = this.mResources.getDrawableForDensity(r100, r101);     // Catch: Throwable -> L5 Resources.NotFoundException -> L7
        notifyResourceAccess(r100);
        return r102;
    L7:
        Drawable r103 = getGlobalRealResources().getDrawableForDensity(r100, r101);     // Catch: Throwable -> L5 Resources.NotFoundException -> L10
        notifyResourceAccess(r100);
        return r103;
    L10:
        e = move-exception;
        handleException(e);     // Catch: Throwable -> L5
        notifyResourceAccess(r100);
        return null;
    L5:
        th = move-exception;
        notifyResourceAccess(r100);
        throw th;
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int r100, int r101) throws Resources.NotFoundException {
        return this.mResources.getQuantityString(r100, r101);
    L4:
        return getGlobalRealResources().getQuantityString(r100, r101);
    L6:
        e = move-exception;
        handleException(e);
        return null;
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int r100, int r101) throws Resources.NotFoundException {
        return this.mResources.getQuantityText(r100, r101);
    L4:
        return getGlobalRealResources().getQuantityText(r100, r101);
    L6:
        e = move-exception;
        handleException(e);
        return null;
    }

    @Override // android.content.res.Resources
    public String getString(int r100, Object... r101) throws Resources.NotFoundException {
        return this.mResources.getString(r100, r101);
    L4:
        return getGlobalRealResources().getString(r100, r101);
    L6:
        e = move-exception;
        if (r100 == 0) goto L14;
        handleException(e);
        return null;
    L14:
        return null;
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int r100, CharSequence r101) {
        return this.mResources.getText(r100, r101);
    L4:
        return getGlobalRealResources().getText(r100, r101);
    L6:
        e = move-exception;
        handleException(e);
        return null;
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet r100, int[] r101) {
        return this.mResources.obtainAttributes(r100, r101);
    L4:
        e = move-exception;
        handleException(e);
        return null;
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int r100, TypedValue r101) throws Resources.NotFoundException {
        return this.mResources.openRawResource(r100, r101);
    L4:
        return getGlobalRealResources().openRawResource(r100, r101);
    L6:
        e = move-exception;
        handleException(e);
        return null;
    }

    @Override // android.content.res.Resources
    public void parseBundleExtras(XmlResourceParser r100, Bundle r101) throws XmlPullParserException, IOException {
        this.mResources.parseBundleExtras(r100, r101);
    }

    @Override // android.content.res.Resources
    public void updateConfiguration(Configuration r100, DisplayMetrics r101) {
        super.updateConfiguration(r100, r101);
        Resources r102 = this.mResources;
        if (r102 == null) goto L6;
        r102.updateConfiguration(r100, r101);
        return;
    }

    private Drawable getDrawableByReflectWithSync(Resources r110, int r111, Resources.Theme r112) {
        TypedValue r100 = (TypedValue) MethodUtils.invokeMethod(r110, "obtainTempTypedValue", new Object[0]);     // Catch: Throwable -> L18 IllegalAccessException -> L20 NoSuchMethodException -> L22
        Object r101 = FieldUtils.readField(r110, "mResourcesImpl");     // Catch: Throwable -> L15
        AssetManager r102 = r110.getAssets();     // Catch: Throwable -> L15
        monitor-enter(r102);     // Catch: Throwable -> L15
        Boolean r103 = Boolean.TRUE;     // Catch: Throwable -> L12
        Object[] r104 = {Integer.valueOf(r111), r100, r103};     // Catch: Throwable -> L12
        Class r113 = Integer.TYPE;     // Catch: Throwable -> L12
        Class r114 = Boolean.TYPE;     // Catch: Throwable -> L12
        MethodUtils.invokeMethod(r101, "getValue", r104, new Class[]{r113, TypedValue.class, r114});     // Catch: Throwable -> L12
        monitor-exit(r102);     // Catch: Throwable -> L12
        Drawable r105 = (Drawable) MethodUtils.invokeMethod(r101, "loadDrawable", new Object[]{r110, r100, Integer.valueOf(r111), r112, r103}, new Class[]{Resources.class, TypedValue.class, r113, Resources.Theme.class, r114});     // Catch: Throwable -> L15
        MethodUtils.invokeMethod(r110, "releaseTempTypedValue", new Object[]{r100}, new Class[]{TypedValue.class});     // Catch: Throwable -> L18 IllegalAccessException -> L20 NoSuchMethodException -> L22
        return r105;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        MethodUtils.invokeMethod(r110, "releaseTempTypedValue", new Object[]{r100}, new Class[]{TypedValue.class});     // Catch: Throwable -> L18 IllegalAccessException -> L20 NoSuchMethodException -> L22
        throw th;     // Catch: Throwable -> L18 IllegalAccessException -> L20 NoSuchMethodException -> L22
    L18:
        e = move-exception;
        e.printStackTrace();
        r110.getDrawable(r111, r112);     // Catch: Resources.NotFoundException -> L26
        return null;
    L26:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int r100, int r101, Resources.Theme r102) {
        Drawable r103 = this.mResources.getDrawableForDensity(r100, r101, r102);     // Catch: Throwable -> L5 ArrayIndexOutOfBoundsException -> L7 Resources.NotFoundException -> L16
        notifyResourceAccess(r100);
        return r103;
    L5:
        th = move-exception;
        notifyResourceAccess(r100);
        throw th;
    L16:
        Drawable r104 = getGlobalRealResources().getDrawableForDensity(r100, r101, r102);     // Catch: Throwable -> L5 Resources.NotFoundException -> L19
        notifyResourceAccess(r100);
        return r104;
    L7:
        e = move-exception;
        if (MiraManager.getInstance().getParam().isEnableArrayIndexExceptionFix() == true) goto L11;
    L15:
        throw e;     // Catch: Throwable -> L5
    L11:
        if (OSUtil.isAndroidN() == false) goto L15;
        Drawable r105 = getDrawableForDensityByReflectWithSync(this.mResources, r100, r101, r102);     // Catch: Throwable -> L5
        notifyResourceAccess(r100);
        return r105;
    L19:
        e = move-exception;
        handleException(e);     // Catch: Throwable -> L5
        notifyResourceAccess(r100);
        return null;
    }

    @Override // android.content.res.Resources
    public float getFraction(int r100, int r101, int r102) {
        return this.mResources.getFraction(r100, r101, r102);
    L4:
        e = move-exception;
        handleException(e);
        return 0.0f;
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String r100, String r101, String r102) {
        return this.mResources.getIdentifier(r100, r101, r102);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int r100, int r101, Object... r102) throws Resources.NotFoundException {
        return this.mResources.getQuantityString(r100, r101, r102);
    L4:
        return getGlobalRealResources().getQuantityString(r100, r101, r102);
    L6:
        e = move-exception;
        handleException(e);
        return null;
    }

    @Override // android.content.res.Resources
    public void getValue(int r100, TypedValue r101, boolean r102) throws Resources.NotFoundException {
        this.mResources.getValue(r100, r101, r102);     // Catch: ArrayIndexOutOfBoundsException -> L4 Resources.NotFoundException -> L18
    L29:
        return;
    L18:
        getGlobalRealResources().getValue(r100, r101, r102);     // Catch: Resources.NotFoundException -> L20
        return;
    L4:
        e = move-exception;
        if (MiraManager.getInstance().getParam().isEnableDrawableAccessReport() == true) goto L8;
    L17:
        throw e;
    L8:
        if (OSUtil.isAndroidL_N() == false) goto L17;
        monitor-enter(this.mResources.getAssets());
        this.mResources.getValue(r100, r101, r102);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    L20:
        e = move-exception;
        handleException(e);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtra(String r100, AttributeSet r101, Bundle r102) throws XmlPullParserException {
        this.mResources.parseBundleExtra(r100, r101, r102);
    }

    @Override // android.content.res.Resources
    public void getValue(String r100, TypedValue r101, boolean r102) throws Resources.NotFoundException {
        this.mResources.getValue(r100, r101, r102);     // Catch: Resources.NotFoundException -> L4
        return;
    L4:
        getGlobalRealResources().getValue(r100, r101, r102);     // Catch: Resources.NotFoundException -> L6
        return;
    L6:
        e = move-exception;
        handleException(e);
    }

    private Drawable getDrawableForDensityByReflectWithSync(Resources r110, int r111, int r112, Resources.Theme r210) {
        TypedValue r100 = (TypedValue) MethodUtils.invokeMethod(r110, "obtainTempTypedValue", new Object[0]);     // Catch: InvocationTargetException -> L28 IllegalAccessException -> L30 Throwable -> L32
        Object r101 = FieldUtils.readField(r110, "mResourcesImpl");     // Catch: Throwable -> L25
        AssetManager r102 = r110.getAssets();     // Catch: Throwable -> L25
        monitor-enter(r102);     // Catch: Throwable -> L25
        Object[] r103 = {Integer.valueOf(r111), Integer.valueOf(r112), r100, Boolean.TRUE};     // Catch: Throwable -> L22
        Class r113 = Integer.TYPE;     // Catch: Throwable -> L22
        Class r114 = Boolean.TYPE;     // Catch: Throwable -> L22
        MethodUtils.invokeMethod(r101, "getValueForDensity", r103, new Class[]{r113, r113, TypedValue.class, r114});     // Catch: Throwable -> L22
        monitor-exit(r102);     // Catch: Throwable -> L22
        DisplayMetrics r104 = (DisplayMetrics) MethodUtils.invokeMethod(r101, "getDisplayMetrics", new Object[0]);     // Catch: Throwable -> L25
        int r105 = r100.density;     // Catch: Throwable -> L25
        int r106 = r104.densityDpi;     // Catch: Throwable -> L25
        if (r105 != r106) goto L12;
        boolean r107 = true;
    L13:
        if (r105 > 0) goto L15;
    L19:
        Drawable r108 = (Drawable) MethodUtils.invokeMethod(r101, "loadDrawable", new Object[]{r110, r100, Integer.valueOf(r111), r210, Boolean.valueOf(r107)}, new Class[]{Resources.class, TypedValue.class, r113, Resources.Theme.class, r114});     // Catch: Throwable -> L25
        MethodUtils.invokeMethod(r110, "releaseTempTypedValue", new Object[]{r100}, new Class[]{TypedValue.class});     // Catch: InvocationTargetException -> L28 IllegalAccessException -> L30 Throwable -> L32
        return r108;
    L15:
        if (r105 == 65535) goto L19;
        if (r105 != r112) goto L18;
        r100.density = r106;     // Catch: Throwable -> L25
        goto L19
    L18:
        r100.density = (r105 * r106) / r112;     // Catch: Throwable -> L25
        goto L19
    L12:
        r107 = false;
        goto L13
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        MethodUtils.invokeMethod(r110, "releaseTempTypedValue", new Object[]{r100}, new Class[]{TypedValue.class});     // Catch: InvocationTargetException -> L28 IllegalAccessException -> L30 Throwable -> L32
        throw th;     // Catch: InvocationTargetException -> L28 IllegalAccessException -> L30 Throwable -> L32
    L32:
        e = move-exception;
        e.printStackTrace();
        r110.getDrawableForDensity(r111, r112, r210);     // Catch: Resources.NotFoundException -> L36
        return null;
    L36:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int r100, int r101, TypedValue r102, boolean r103) throws Resources.NotFoundException {
        this.mResources.getValueForDensity(r100, r101, r102, r103);     // Catch: ArrayIndexOutOfBoundsException -> L4 Resources.NotFoundException -> L18
    L29:
        return;
    L18:
        getGlobalRealResources().getValueForDensity(r100, r101, r102, r103);     // Catch: Resources.NotFoundException -> L20
        return;
    L4:
        e = move-exception;
        if (MiraManager.getInstance().getParam().isEnableDrawableAccessReport() == true) goto L8;
    L17:
        throw e;
    L8:
        if (OSUtil.isAndroidL_N() == false) goto L17;
        monitor-enter(this.mResources.getAssets());
        this.mResources.getValueForDensity(r100, r101, r102, r103);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    L20:
        e = move-exception;
        handleException(e);
    }
}
