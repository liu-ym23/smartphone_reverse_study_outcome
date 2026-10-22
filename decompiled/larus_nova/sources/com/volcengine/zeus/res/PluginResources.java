package com.volcengine.zeus.res;

import android.app.Application;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.volcengine.zeus.GlobalParam;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.log.ZeusLogger;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import jqc.a;
import mqc.i;
import mqc.o;

/* JADX INFO: loaded from: classes.dex */
public class PluginResources extends Resources {
    public String pluginPkg;

    public static DisplayMetrics INVOKEVIRTUAL_com_volcengine_zeus_res_PluginResources_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static AssetManager appendHostRes(Resources r100) {
        Application r101 = Zeus.getAppApplication();
        if (i.f514950a != null) goto L7;
        File r102 = r101.getCacheDir().getParentFile();
        if (r102 == null) goto L7;
        i.f514950a = r102.getAbsolutePath();
    L7:
        String r103 = i.f514950a;
        Application r104 = Zeus.getAppApplication();
        if (i.f514951b != null) goto L15;
        File r105 = r104.getCacheDir().getParentFile();
        if (r105 == null) goto L15;
        i.f514951b = r105.getCanonicalPath();     // Catch: IOException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
    L15:
        String r106 = i.f514951b;
        if (GlobalParam.getInstance().isIgnoreWebViewRes() == false) goto L18;
        List<String> r107 = Collections.emptyList();
    L19:
        a r108 = new a();
        AssetManager r109 = r100.getAssets();
        AssetManager r110 = Zeus.getAppApplication().getAssets();
        HashSet r111 = new HashSet(o.c(r109));
        List<String> r112 = o.c(r110);
        Iterator<String> r113 = r107.iterator();
    L21:
        if (r113.hasNext() == false) goto L25;
        String r114 = r113.next();
        if (r111.contains(r114) == true) goto L21;
        r108.c(r109, r114, true);
        goto L21
    L25:
        Iterator r115 = ((ArrayList) r112).iterator();
    L27:
        if (r115.hasNext() == false) goto L35;
        String r116 = (String) r115.next();
        if (isOtherPlugin(r116, r103, r106) == true) goto L27;
        if (r111.contains(r116) == true) goto L27;
        if (r107.contains(r116) == true) goto L27;
        r108.c(r109, r116, false);
        goto L27
    L35:
        ZeusLogger.i(ZeusLogger.TAG_RESOURCES, "pluginAssets = " + o.d(r109));
        return r109;
    L18:
        r107 = o.e();
        goto L19
    }

    private Resources.NotFoundException handleException(Resources.NotFoundException r100) {
        return new Resources.NotFoundException(("Resources#Assets: " + o.d(getAssets())) + "," + r100.getMessage());
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int r100) throws Resources.NotFoundException {
        return super.getAnimation(r100);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int r100) throws Resources.NotFoundException {
        return super.getBoolean(r100);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public int getColor(int r100) throws Resources.NotFoundException {
        return super.getColor(r100);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int r100) throws Resources.NotFoundException {
        return super.getColorStateList(r100);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public float getDimension(int r100) throws Resources.NotFoundException {
        return super.getDimension(r100);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int r100) throws Resources.NotFoundException {
        return super.getDimensionPixelOffset(r100);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int r100) throws Resources.NotFoundException {
        return super.getDimensionPixelSize(r100);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int r100) throws Resources.NotFoundException {
        return super.getDrawable(r100);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public float getFloat(int r100) {
        return super.getFloat(r100);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public Typeface getFont(int r100) throws Resources.NotFoundException {
        return super.getFont(r100);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int r100) throws Resources.NotFoundException {
        return super.getIntArray(r100);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public int getInteger(int r100) throws Resources.NotFoundException {
        return super.getInteger(r100);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int r100) throws Resources.NotFoundException {
        return super.getLayout(r100);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int r100) throws Resources.NotFoundException {
        return super.getMovie(r100);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int r100) throws Resources.NotFoundException {
        return super.getResourceEntryName(r100);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int r100) throws Resources.NotFoundException {
        return super.getResourceName(r100);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int r100) throws Resources.NotFoundException {
        return super.getResourcePackageName(r100);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int r100) throws Resources.NotFoundException {
        return super.getResourceTypeName(r100);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public String getString(int r100) throws Resources.NotFoundException {
        return super.getString(r100);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int r100) throws Resources.NotFoundException {
        return super.getStringArray(r100);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int r100) throws Resources.NotFoundException {
        return super.getText(r100);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int r100) throws Resources.NotFoundException {
        return super.getTextArray(r100);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int r100) throws Resources.NotFoundException {
        return super.getXml(r100);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int r100) throws Resources.NotFoundException {
        return super.obtainTypedArray(r100);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int r100) throws Resources.NotFoundException {
        return super.openRawResource(r100);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int r100) throws Resources.NotFoundException {
        return super.openRawResourceFd(r100);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    public PluginResources(Resources r100, String r101) {
        super(appendHostRes(r100), INVOKEVIRTUAL_com_volcengine_zeus_res_PluginResources_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100), Zeus.getAppApplication().getResources().getConfiguration());
        this.pluginPkg = r101;
    }

    @Override // android.content.res.Resources
    public int getColor(int r100, Resources.Theme r101) throws Resources.NotFoundException {
        return super.getColor(r100, r101);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int r100, Resources.Theme r101) throws Resources.NotFoundException {
        return super.getColorStateList(r100, r101);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int r100, Resources.Theme r101) throws Resources.NotFoundException {
        return super.getDrawable(r100, r101);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int r100, int r101) throws Resources.NotFoundException {
        return super.getDrawableForDensity(r100, r101);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int r100, int r101) throws Resources.NotFoundException {
        return super.getQuantityString(r100, r101);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int r100, int r101) throws Resources.NotFoundException {
        return super.getQuantityText(r100, r101);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public String getString(int r100, Object... r101) throws Resources.NotFoundException {
        return super.getString(r100, r101);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int r100, CharSequence r101) {
        return super.getText(r100, r101);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int r100, TypedValue r101) throws Resources.NotFoundException {
        return super.openRawResource(r100, r101);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    private static boolean isOtherPlugin(String r100, String r101, String r102) {
        String r103 = Zeus.getAppApplication().getPackageResourcePath();
        if (TextUtils.isEmpty(r102) == true) goto L5;
        r103 = r103.replaceFirst(r101, r102);
        r100 = r100.replaceFirst(r101, r102);
    L5:
        ZeusLogger.d(ZeusLogger.TAG_RESOURCES, r100 + " " + r103 + " " + r101 + " " + r102);
        if (TextUtils.equals(r100, r103) == false) goto L9;
        return false;
    L9:
        if (r100.contains("/tinker/patch-") == false) goto L12;
        return false;
    L12:
        if (TextUtils.isEmpty(r101) == true) goto L16;
        if (r100.contains(r101) == false) goto L16;
    L19:
        return true;
    L16:
        if (TextUtils.isEmpty(r102) == false) goto L18;
        return false;
    L18:
        if (r100.contains(r102) == true) goto L19;
        return false;
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int r100, int r101, Resources.Theme r102) {
        return super.getDrawableForDensity(r100, r101, r102);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public float getFraction(int r100, int r101, int r102) {
        return super.getFraction(r100, r101, r102);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int r100, int r101, Object... r102) throws Resources.NotFoundException {
        return super.getQuantityString(r100, r101, r102);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public void getValue(int r100, TypedValue r101, boolean r102) throws Resources.NotFoundException {
        super.getValue(r100, r101, r102);     // Catch: Resources.NotFoundException -> L4
        return;
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public void getValue(String r100, TypedValue r101, boolean r102) throws Resources.NotFoundException {
        super.getValue(r100, r101, r102);     // Catch: Resources.NotFoundException -> L4
        return;
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int r100, int r101, TypedValue r102, boolean r103) throws Resources.NotFoundException {
        super.getValueForDensity(r100, r101, r102, r103);     // Catch: Resources.NotFoundException -> L4
        return;
    L4:
        e = move-exception;
        throw handleException(e);
    }
}
