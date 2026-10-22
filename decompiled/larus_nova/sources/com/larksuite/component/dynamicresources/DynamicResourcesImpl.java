package com.larksuite.component.dynamicresources;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.LruCache;
import android.util.TypedValue;
import com.larksuite.framework.utils.Reflect;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes24.dex */
public class DynamicResourcesImpl extends Resources {
    public static final int ID_CACHE_SIZE = 3000;
    private static final String TAG = "DynamicResources";
    private static LruCache<Integer, Integer> sIdCache;
    private final c mCharSequenceResourcesRetriever;
    private final d mColorResourcesRetriever;
    private final e mColorStateListResourcesRetriever;
    private final f mDrawableResourcesRetriever;
    private final Resources mDynamicResources;
    private final String mDynamicResourcesPkgName;
    boolean mInited;
    private final g mStringResourcesRetriever;
    private final Resources mSysResources;

    public abstract class a {
        public int getResources(int r100) {
            com.larksuite.component.dynamicresources.a.f283994a.getClass();
            throw null;     // Catch: Exception -> L4
        L4:
            e = move-exception;
            Log.e(DynamicResourcesImpl.TAG, "null error : " + e);
            int r101 = DynamicResourcesImpl.ID_CACHE_SIZE;
            throw null;
        }

        public int getResources(int r100, Resources.Theme r101) {
            com.larksuite.component.dynamicresources.a.f283994a.getClass();
            throw null;     // Catch: Exception -> L4
        L4:
            e = move-exception;
            Log.e(DynamicResourcesImpl.TAG, "null error : " + e);
            int r102 = DynamicResourcesImpl.ID_CACHE_SIZE;
            throw null;
        }
    }

    public abstract class b<T> {
        public T getResources(int r100) {
            com.larksuite.component.dynamicresources.a.f283994a.getClass();
            throw null;     // Catch: Exception -> L4
        L4:
            e = move-exception;
            Log.w(DynamicResourcesImpl.TAG, "null error, fallback to system resources: " + e);
            int r101 = DynamicResourcesImpl.ID_CACHE_SIZE;     // Catch: Resources.NotFoundException -> L8
            throw null;     // Catch: Resources.NotFoundException -> L8
        L8:
            e = move-exception;
            Log.e(DynamicResourcesImpl.TAG, "null also not found in system resources: " + e);
            com.larksuite.component.dynamicresources.a.f283994a.getClass();
            return null;
        }

        public T getResources(int r100, Resources.Theme r101) {
            com.larksuite.component.dynamicresources.a.f283994a.getClass();
            throw null;     // Catch: Exception -> L4
        L4:
            e = move-exception;
            Log.w(DynamicResourcesImpl.TAG, "null error, fallback to system resources: " + e);
            int r102 = DynamicResourcesImpl.ID_CACHE_SIZE;     // Catch: Resources.NotFoundException -> L8
            throw null;     // Catch: Resources.NotFoundException -> L8
        L8:
            e = move-exception;
            Log.e(DynamicResourcesImpl.TAG, "null also not found in system resources: " + e);
            com.larksuite.component.dynamicresources.a.f283994a.getClass();
            return null;
        }
    }

    public class c extends b<CharSequence> {
    }

    public class d extends a {
    }

    public class e extends b<ColorStateList> {
    }

    public class f extends b<Drawable> {
    }

    public class g extends b<String> {
    }

    @Override // android.content.res.Resources
    public final Configuration getConfiguration() {
        if (this.mInited == true) goto L7;
        return super.getConfiguration();
    L7:
        return this.mSysResources.getConfiguration();
    }

    @Override // android.content.res.Resources
    public final DisplayMetrics getDisplayMetrics() {
        if (this.mInited == false) goto L5;
        Resources r100 = this.mSysResources;
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    L5:
        return WindowDisplayMetricsOverride.apply(this, super.getDisplayMetrics());
    }

    @Override // android.content.res.Resources
    public final XmlResourceParser getAnimation(int r100) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getAnimation(r100);
    L7:
        return this.mSysResources.getAnimation(r100);
    }

    @Override // android.content.res.Resources
    public final boolean getBoolean(int r100) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getBoolean(r100);
    L7:
        return this.mSysResources.getBoolean(r100);
    }

    @Override // android.content.res.Resources
    public final int getColor(int r100) {
        if (this.mInited == true) goto L7;
        return super.getColor(r100);
    L7:
        return this.mColorResourcesRetriever.getResources(r100);
    }

    @Override // android.content.res.Resources
    public final ColorStateList getColorStateList(int r100) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getColorStateList(r100);
    L7:
        return this.mColorStateListResourcesRetriever.getResources(r100);
    }

    @Override // android.content.res.Resources
    public final float getDimension(int r100) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getDimension(r100);
    L7:
        return this.mSysResources.getDimension(r100);
    }

    @Override // android.content.res.Resources
    public final int getDimensionPixelOffset(int r100) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getDimensionPixelOffset(r100);
    L7:
        return this.mSysResources.getDimensionPixelOffset(r100);
    }

    @Override // android.content.res.Resources
    public final int getDimensionPixelSize(int r100) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getDimensionPixelSize(r100);
    L7:
        return this.mSysResources.getDimensionPixelSize(r100);
    }

    @Override // android.content.res.Resources
    public final Drawable getDrawable(int r100) {
        if (this.mInited == true) goto L7;
        return super.getDrawable(r100);
    L7:
        return this.mDrawableResourcesRetriever.getResources(r100);
    }

    @Override // android.content.res.Resources
    public final float getFloat(int r100) {
        if (this.mInited == true) goto L7;
        return super.getFloat(r100);
    L7:
        return this.mSysResources.getFloat(r100);
    }

    @Override // android.content.res.Resources
    public final Typeface getFont(int r100) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getFont(r100);
    L7:
        return this.mSysResources.getFont(r100);
    }

    @Override // android.content.res.Resources
    public final int[] getIntArray(int r100) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getIntArray(r100);
    L7:
        return this.mSysResources.getIntArray(r100);
    }

    @Override // android.content.res.Resources
    public final int getInteger(int r100) throws Resources.NotFoundException {
    L8:
        th = move-exception;
        String r101 = th.getMessage();
        if (r101 != null) goto L12;
    L47:
        throw th;
    L12:
        if (r101.contains("#0x20") == false) goto L47;
        boolean r102 = com.larksuite.component.dynamicresources.b.f283996a;
        if (Build.VERSION.SDK_INT >= 33) goto L18;
    L25:
        boolean r103 = false;
    L27:
        if (r103 == false) goto L46;
        Context r104 = (Context) new Reflect(Reflect.a("android.webkit.WebViewFactory")).call("getWebViewContextAndSetProvider").f285916a;     // Catch: Throwable -> L34
    L35:
        if (r104 == null) goto L46;
        int r105 = r104.getResources().getConfiguration().uiMode;     // Catch: Throwable -> L48
        new Reflect(new Reflect(Reflect.a("android.webkit.WebViewDelegate")).c().f285916a).call("addWebViewAssetPath", new Class[]{Context.class}, new Object[]{LarkContext.getApplication()});     // Catch: Throwable -> L48
        Arrays.toString(LarkContext.getApplication().getApplicationInfo().sharedLibraryFiles);     // Catch: Throwable -> L48
        Configuration r106 = r104.getResources().getConfiguration();     // Catch: Throwable -> L48
        Objects.toString(r106);     // Catch: Throwable -> L48
        if (r105 == r106.uiMode) goto L46;
        r106.uiMode = r105;     // Catch: Throwable -> L48
        Resources r107 = r104.getResources();     // Catch: Throwable -> L48
        Resources r108 = r104.getResources();     // Catch: Throwable -> L48
        r107.updateConfiguration(r106, WindowDisplayMetricsOverride.apply(r108, r108.getDisplayMetrics()));     // Catch: Throwable -> L48
        Objects.toString(r104.getResources().getConfiguration());     // Catch: Throwable -> L48
        goto L46
    L42:
        e = move-exception;
        throw new Reflect.ReflectException(e);     // Catch: Throwable -> L48
    L31:
        e = move-exception;
        throw new Reflect.ReflectException(e);     // Catch: Throwable -> L34
    L34:
        r104 = null;
        goto L35
    L18:
        if (com.larksuite.component.dynamicresources.b.f283996a == false) goto L25;
        ResourceConfig r109 = (ResourceConfig) SettingManager.getInstance().get(ResourceConfig.class);     // Catch: Throwable -> L48
        if (r109 == null) goto L25;
        if (r109.enableFixResource() == false) goto L25;
        r103 = true;
    L46:
        return this.mSysResources.getInteger(r100);
    L3:
        if (this.mInited == true) goto L7;
        return super.getInteger(r100);
    L7:
        return this.mSysResources.getInteger(r100);
    }

    @Override // android.content.res.Resources
    public final XmlResourceParser getLayout(int r100) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getLayout(r100);
    L7:
        return this.mSysResources.getLayout(r100);
    }

    @Override // android.content.res.Resources
    public final Movie getMovie(int r100) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getMovie(r100);
    L7:
        return this.mSysResources.getMovie(r100);
    }

    @Override // android.content.res.Resources
    public final String getResourceEntryName(int r100) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getResourceEntryName(r100);
    L7:
        return this.mSysResources.getResourceEntryName(r100);
    }

    @Override // android.content.res.Resources
    public final String getResourceName(int r100) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getResourceName(r100);
    L7:
        return this.mSysResources.getResourceName(r100);
    }

    @Override // android.content.res.Resources
    public final String getResourcePackageName(int r100) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getResourcePackageName(r100);
    L7:
        return this.mSysResources.getResourcePackageName(r100);
    }

    @Override // android.content.res.Resources
    public final String getResourceTypeName(int r100) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getResourceTypeName(r100);
    L7:
        return this.mSysResources.getResourceTypeName(r100);
    }

    @Override // android.content.res.Resources
    public final String getString(int r100) {
        if (this.mInited == true) goto L7;
        return super.getString(r100);
    L7:
        return this.mStringResourcesRetriever.getResources(r100);
    }

    @Override // android.content.res.Resources
    public final String[] getStringArray(int r100) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getStringArray(r100);
    L7:
        return this.mSysResources.getStringArray(r100);
    }

    @Override // android.content.res.Resources
    public final CharSequence getText(int r100) {
        if (this.mInited == true) goto L7;
        return super.getText(r100);
    L7:
        return this.mCharSequenceResourcesRetriever.getResources(r100);
    }

    @Override // android.content.res.Resources
    public final CharSequence[] getTextArray(int r100) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getTextArray(r100);
    L7:
        return this.mSysResources.getTextArray(r100);
    }

    @Override // android.content.res.Resources
    public final XmlResourceParser getXml(int r100) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getXml(r100);
    L7:
        return this.mSysResources.getXml(r100);
    }

    @Override // android.content.res.Resources
    public final TypedArray obtainTypedArray(int r100) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.obtainTypedArray(r100);
    L7:
        return this.mSysResources.obtainTypedArray(r100);
    }

    @Override // android.content.res.Resources
    public final InputStream openRawResource(int r100) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.openRawResource(r100);
    L7:
        return this.mSysResources.openRawResource(r100);
    }

    @Override // android.content.res.Resources
    public final AssetFileDescriptor openRawResourceFd(int r100) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.openRawResourceFd(r100);
    L7:
        return this.mSysResources.openRawResourceFd(r100);
    }

    @Override // android.content.res.Resources
    public final int getColor(int r100, Resources.Theme r101) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getColor(r100, r101);
    L7:
        return this.mColorResourcesRetriever.getResources(r100, r101);
    }

    @Override // android.content.res.Resources
    public final ColorStateList getColorStateList(int r100, Resources.Theme r101) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getColorStateList(r100, r101);
    L7:
        return this.mColorStateListResourcesRetriever.getResources(r100, r101);
    }

    @Override // android.content.res.Resources
    public final Drawable getDrawable(int r100, Resources.Theme r101) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getDrawable(r100, r101);
    L7:
        return this.mDrawableResourcesRetriever.getResources(r100, r101);
    }

    @Override // android.content.res.Resources
    public final Drawable getDrawableForDensity(int r100, int r101) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getDrawableForDensity(r100, r101);
    L7:
        return this.mSysResources.getDrawableForDensity(r100, r101);
    }

    @Override // android.content.res.Resources
    public final String getQuantityString(int r100, int r101) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getQuantityString(r100, r101);
    L7:
        return this.mSysResources.getQuantityString(r100, r101);
    }

    @Override // android.content.res.Resources
    public final CharSequence getQuantityText(int r100, int r101) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getQuantityText(r100, r101);
    L7:
        return this.mSysResources.getQuantityText(r100, r101);
    }

    @Override // android.content.res.Resources
    public final String getString(int r100, Object... r101) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getString(r100, r101);
    L7:
        return this.mSysResources.getString(r100, r101);
    }

    @Override // android.content.res.Resources
    public final CharSequence getText(int r100, CharSequence r101) {
        if (this.mInited == true) goto L7;
        return super.getText(r100, r101);
    L7:
        return this.mSysResources.getText(r100, r101);
    }

    @Override // android.content.res.Resources
    public final TypedArray obtainAttributes(AttributeSet r100, int[] r101) {
        if (this.mInited == true) goto L7;
        return obtainAttributes(r100, r101);
    L7:
        return this.mSysResources.obtainAttributes(r100, r101);
    }

    @Override // android.content.res.Resources
    public final InputStream openRawResource(int r100, TypedValue r101) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.openRawResource(r100, r101);
    L7:
        return this.mSysResources.openRawResource(r100, r101);
    }

    @Override // android.content.res.Resources
    public final void parseBundleExtras(XmlResourceParser r100, Bundle r101) throws IOException, XmlPullParserException {
        if (this.mInited == true) goto L6;
        super.parseBundleExtras(r100, r101);
        return;
    L6:
        this.mSysResources.parseBundleExtras(r100, r101);
    }

    @Override // android.content.res.Resources
    public final void updateConfiguration(Configuration r100, DisplayMetrics r101) {
        if (this.mInited == true) goto L6;
        super.updateConfiguration(r100, r101);
        return;
    L6:
        this.mSysResources.updateConfiguration(r100, r101);
        this.mDynamicResources.updateConfiguration(r100, r101);
    }

    @Override // android.content.res.Resources
    public final Drawable getDrawableForDensity(int r100, int r101, Resources.Theme r102) {
        if (this.mInited == true) goto L7;
        return super.getDrawableForDensity(r100, r101, r102);
    L7:
        return this.mSysResources.getDrawableForDensity(r100, r101, r102);
    }

    @Override // android.content.res.Resources
    public final float getFraction(int r100, int r101, int r102) {
        if (this.mInited == true) goto L7;
        return super.getFraction(r100, r101, r102);
    L7:
        return this.mSysResources.getFraction(r100, r101, r102);
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String r100, String r101, String r102) {
        if (this.mInited == true) goto L7;
        return super.getIdentifier(r100, r101, r102);
    L7:
        return this.mSysResources.getIdentifier(r100, r101, r102);
    }

    @Override // android.content.res.Resources
    public final String getQuantityString(int r100, int r101, Object... r102) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getQuantityString(r100, r101, r102);
    L7:
        return this.mSysResources.getQuantityString(r100, r101, r102);
    }

    @Override // android.content.res.Resources
    public final void getValue(int r100, TypedValue r101, boolean r102) throws Resources.NotFoundException {
        if (this.mInited == true) goto L6;
        super.getValue(r100, r101, r102);
        return;
    L6:
        this.mSysResources.getValue(r100, r101, r102);
    }

    @Override // android.content.res.Resources
    public final void parseBundleExtra(String r100, AttributeSet r101, Bundle r102) throws XmlPullParserException {
        if (this.mInited == true) goto L6;
        super.parseBundleExtra(r100, r101, r102);
        return;
    L6:
        this.mSysResources.parseBundleExtra(r100, r101, r102);
    }

    @Override // android.content.res.Resources
    public final void getValue(String r100, TypedValue r101, boolean r102) throws Resources.NotFoundException {
        if (this.mInited == true) goto L6;
        super.getValue(r100, r101, r102);
        return;
    L6:
        this.mSysResources.getValue(r100, r101, r102);
    }

    @Override // android.content.res.Resources
    public final void getValueForDensity(int r100, int r101, TypedValue r102, boolean r103) throws Resources.NotFoundException {
        if (this.mInited == true) goto L6;
        super.getValueForDensity(r100, r101, r102, r103);
        return;
    L6:
        this.mSysResources.getValueForDensity(r100, r101, r102, r103);
    }
}
