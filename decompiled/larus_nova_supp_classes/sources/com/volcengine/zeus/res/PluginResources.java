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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class PluginResources extends Resources {
    public String pluginPkg;

    public static DisplayMetrics INVOKEVIRTUAL_com_volcengine_zeus_res_PluginResources_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static AssetManager appendHostRes(Resources r9) {
        Application r0 = Zeus.getAppApplication();
        if (i.a != null) goto L7;
        File r1 = r0.getCacheDir().getParentFile();
        if (r1 == null) goto L7;
        i.a = r1.getAbsolutePath();
    L7:
        String r2 = i.a;
        Application r3 = Zeus.getAppApplication();
        if (i.b != null) goto L15;
        File r4 = r3.getCacheDir().getParentFile();
        if (r4 == null) goto L15;
        i.b = r4.getCanonicalPath();     // Catch: IOException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
    L15:
        String r5 = i.b;
        if (GlobalParam.getInstance().isIgnoreWebViewRes() == false) goto L18;
        List<String> r6 = Collections.emptyList();
    L19:
        a r7 = new a();
        AssetManager r10 = r9.getAssets();
        AssetManager r8 = Zeus.getAppApplication().getAssets();
        HashSet r11 = new HashSet(o.c(r10));
        List<String> r12 = o.c(r8);
        Iterator<String> r13 = r6.iterator();
    L21:
        if (r13.hasNext() == false) goto L25;
        String r14 = r13.next();
        if (r11.contains(r14) == true) goto L21;
        r7.c(r10, r14, true);
        goto L21
    L25:
        Iterator r15 = ((ArrayList) r12).iterator();
    L27:
        if (r15.hasNext() == false) goto L35;
        String r16 = (String) r15.next();
        if (isOtherPlugin(r16, r2, r5) == true) goto L27;
        if (r11.contains(r16) == true) goto L27;
        if (r6.contains(r16) == true) goto L27;
        r7.c(r10, r16, false);
        goto L27
    L35:
        ZeusLogger.i(ZeusLogger.TAG_RESOURCES, "pluginAssets = " + o.d(r10));
        return r10;
    L18:
        r6 = o.e();
        goto L19
    }

    private Resources.NotFoundException handleException(Resources.NotFoundException r4) {
        return new Resources.NotFoundException(("Resources#Assets: " + o.d(getAssets())) + "," + r4.getMessage());
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int r1) throws Resources.NotFoundException {
        return super.getAnimation(r1);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int r1) throws Resources.NotFoundException {
        return super.getBoolean(r1);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public int getColor(int r1) throws Resources.NotFoundException {
        return super.getColor(r1);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int r1) throws Resources.NotFoundException {
        return super.getColorStateList(r1);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public float getDimension(int r1) throws Resources.NotFoundException {
        return super.getDimension(r1);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int r1) throws Resources.NotFoundException {
        return super.getDimensionPixelOffset(r1);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int r1) throws Resources.NotFoundException {
        return super.getDimensionPixelSize(r1);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int r1) throws Resources.NotFoundException {
        return super.getDrawable(r1);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public float getFloat(int r1) {
        return super.getFloat(r1);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public Typeface getFont(int r1) throws Resources.NotFoundException {
        return super.getFont(r1);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int r1) throws Resources.NotFoundException {
        return super.getIntArray(r1);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public int getInteger(int r1) throws Resources.NotFoundException {
        return super.getInteger(r1);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int r1) throws Resources.NotFoundException {
        return super.getLayout(r1);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int r1) throws Resources.NotFoundException {
        return super.getMovie(r1);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int r1) throws Resources.NotFoundException {
        return super.getResourceEntryName(r1);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int r1) throws Resources.NotFoundException {
        return super.getResourceName(r1);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int r1) throws Resources.NotFoundException {
        return super.getResourcePackageName(r1);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int r1) throws Resources.NotFoundException {
        return super.getResourceTypeName(r1);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public String getString(int r1) throws Resources.NotFoundException {
        return super.getString(r1);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int r1) throws Resources.NotFoundException {
        return super.getStringArray(r1);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int r1) throws Resources.NotFoundException {
        return super.getText(r1);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int r1) throws Resources.NotFoundException {
        return super.getTextArray(r1);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int r1) throws Resources.NotFoundException {
        return super.getXml(r1);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int r1) throws Resources.NotFoundException {
        return super.obtainTypedArray(r1);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int r1) throws Resources.NotFoundException {
        return super.openRawResource(r1);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int r1) throws Resources.NotFoundException {
        return super.openRawResourceFd(r1);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    public PluginResources(Resources r3, String r4) {
        super(appendHostRes(r3), INVOKEVIRTUAL_com_volcengine_zeus_res_PluginResources_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r3), Zeus.getAppApplication().getResources().getConfiguration());
        this.pluginPkg = r4;
    }

    @Override // android.content.res.Resources
    public int getColor(int r1, Resources.Theme r2) throws Resources.NotFoundException {
        return super.getColor(r1, r2);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int r1, Resources.Theme r2) throws Resources.NotFoundException {
        return super.getColorStateList(r1, r2);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int r1, Resources.Theme r2) throws Resources.NotFoundException {
        return super.getDrawable(r1, r2);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int r1, int r2) throws Resources.NotFoundException {
        return super.getDrawableForDensity(r1, r2);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int r1, int r2) throws Resources.NotFoundException {
        return super.getQuantityString(r1, r2);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int r1, int r2) throws Resources.NotFoundException {
        return super.getQuantityText(r1, r2);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public String getString(int r1, Object... r2) throws Resources.NotFoundException {
        return super.getString(r1, r2);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int r1, CharSequence r2) {
        return super.getText(r1, r2);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int r1, TypedValue r2) throws Resources.NotFoundException {
        return super.openRawResource(r1, r2);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    private static boolean isOtherPlugin(String r3, String r4, String r5) {
        String r0 = Zeus.getAppApplication().getPackageResourcePath();
        if (TextUtils.isEmpty(r5) == true) goto L5;
        r0 = r0.replaceFirst(r4, r5);
        r3 = r3.replaceFirst(r4, r5);
    L5:
        ZeusLogger.d(ZeusLogger.TAG_RESOURCES, r3 + " " + r0 + " " + r4 + " " + r5);
        if (TextUtils.equals(r3, r0) == false) goto L9;
        return false;
    L9:
        if (r3.contains("/tinker/patch-") == false) goto L12;
        return false;
    L12:
        if (TextUtils.isEmpty(r4) == true) goto L16;
        if (r3.contains(r4) == false) goto L16;
    L19:
        return true;
    L16:
        if (TextUtils.isEmpty(r5) == false) goto L18;
        return false;
    L18:
        if (r3.contains(r5) == true) goto L19;
        return false;
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int r1, int r2, Resources.Theme r3) {
        return super.getDrawableForDensity(r1, r2, r3);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public float getFraction(int r1, int r2, int r3) {
        return super.getFraction(r1, r2, r3);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int r1, int r2, Object... r3) throws Resources.NotFoundException {
        return super.getQuantityString(r1, r2, r3);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public void getValue(int r1, TypedValue r2, boolean r3) throws Resources.NotFoundException {
        super.getValue(r1, r2, r3);     // Catch: Resources.NotFoundException -> L4
        return;
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public void getValue(String r1, TypedValue r2, boolean r3) throws Resources.NotFoundException {
        super.getValue(r1, r2, r3);     // Catch: Resources.NotFoundException -> L4
        return;
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int r1, int r2, TypedValue r3, boolean r4) throws Resources.NotFoundException {
        super.getValueForDensity(r1, r2, r3, r4);     // Catch: Resources.NotFoundException -> L4
        return;
    L4:
        e = move-exception;
        throw handleException(e);
    }
}
