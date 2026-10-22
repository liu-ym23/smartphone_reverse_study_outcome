package com.bytedance.mira.core.opt.res;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mira.Mira;
import com.bytedance.mira.MiraManager;
import com.bytedance.mira.MiraParam;
import com.bytedance.mira.core.MiraResourcesManager;
import com.bytedance.mira.core.opt.res.ext.AndroidLoadedApkExtApi21Impl;
import com.bytedance.mira.core.opt.res.ext.AndroidLoadedApkExtApi31Impl;
import com.bytedance.mira.core.opt.res.ext.AssetManagerExtApi21Impl;
import com.bytedance.mira.core.opt.res.ext.AssetManagerExtApi26Impl;
import com.bytedance.mira.core.opt.res.ext.IAndroidLoadedApkExt;
import com.bytedance.mira.core.opt.res.ext.IAssetManagerExt;
import com.bytedance.mira.core.opt.res.ext.IResourcesExt;
import com.bytedance.mira.core.opt.res.ext.IResourcesKeyExt;
import com.bytedance.mira.core.opt.res.ext.IResourcesManagerExt;
import com.bytedance.mira.core.opt.res.ext.ISystemSupportExt;
import com.bytedance.mira.core.opt.res.ext.IWebViewExt;
import com.bytedance.mira.core.opt.res.ext.ResourcesExtApi21Impl;
import com.bytedance.mira.core.opt.res.ext.ResourcesExtApi24Impl;
import com.bytedance.mira.core.opt.res.ext.ResourcesKeyExtApi21Impl;
import com.bytedance.mira.core.opt.res.ext.ResourcesKeyExtApi24Impl;
import com.bytedance.mira.core.opt.res.ext.ResourcesKeyExtApi28Impl;
import com.bytedance.mira.core.opt.res.ext.ResourcesManagerExtApi21Impl;
import com.bytedance.mira.core.opt.res.ext.ResourcesManagerExtApi24Impl;
import com.bytedance.mira.core.opt.res.ext.ResourcesManagerExtApi26Impl;
import com.bytedance.mira.core.opt.res.ext.SystemSupportExtApi21Impl;
import com.bytedance.mira.core.opt.res.ext.WebViewExtApi21Impl;
import com.bytedance.mira.core.opt.res.ext.WebViewExtApi24Impl;
import com.bytedance.mira.core.opt.res.ext.WebViewExtApi29Impl;
import com.bytedance.mira.core.res.AssetManagerProcessor;
import com.bytedance.mira.helper.ActivityThreadHelper;
import com.bytedance.mira.helper.FakeArscApkHelperV2;
import com.bytedance.mira.helper.FastPluginDirHelperV3;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.plugin.Plugin;
import com.bytedance.mira.plugin.PluginManager;
import com.bytedance.mira.plugin.trip.natvierutime.utils.UtilsExt;
import com.bytedance.mira.util.FastFileUtils;
import com.bytedance.mira.util.OSUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class NewMiraResourcesManager {
    private static final String TAG = "NewMiraResourcesManager";
    private static final Object mLock = null;
    private static volatile NewMiraResourcesManager sInstance;
    private Context mApplication;
    private IAssetManagerExt mAssetManagerExt;
    private boolean mInit;
    private IAndroidLoadedApkExt mLoadedApkExt;
    private IResourcesExt mResourcesExt;
    private IResourcesKeyExt mResourcesKeyExt;
    private IResourcesManagerExt mResourcesManagerExt;
    private final Map<String, String> mSplitPathMaps;
    private final Map<String, Object> mStrongRefMaps;
    private ISystemSupportExt mSystemSupportExt;
    private boolean mUsedFakePath;
    private IWebViewExt mWebViewExt;

    static {
        mLock = new Object();
    }

    private void addAssetPathCompatForApplication() {
        install(this.mApplication, true);
    }

    public static NewMiraResourcesManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(NewMiraResourcesManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new NewMiraResourcesManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(NewMiraResourcesManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public Map<String, String> getSplitPathMaps() {
        Object r100 = mLock;
        monitor-enter(r100);
        Map<String, String> r101 = this.mSplitPathMaps;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    private NewMiraResourcesManager() {
        this.mSplitPathMaps = new LinkedHashMap();
        this.mStrongRefMaps = new HashMap();
        int r100 = 0;
        this.mInit = false;
        Context r101 = Mira.getAppContext();
        if (r101 != null) goto L5;
        return;
    L5:
        String r102 = r101.getPackageName();
        this.mApplication = r101;
        SystemSupportExtApi21Impl r103 = new SystemSupportExtApi21Impl();
        this.mSystemSupportExt = r103;
        r103.init();
        if (OSUtil.isAndroidSHigher() == false) goto L8;
        this.mLoadedApkExt = new AndroidLoadedApkExtApi31Impl();
    L9:
        this.mLoadedApkExt.init();
        int r104 = Build.VERSION.SDK_INT;
        if (r104 < 26) goto L12;
        this.mAssetManagerExt = new AssetManagerExtApi26Impl();
    L13:
        this.mAssetManagerExt.init();
        if (r104 < 29) goto L16;
        this.mWebViewExt = new WebViewExtApi29Impl();
    L19:
        this.mWebViewExt.init(r101);
        if (r104 < 28) goto L22;
        this.mResourcesKeyExt = new ResourcesKeyExtApi28Impl();
    L25:
        this.mResourcesKeyExt.init();
        if (r104 < 24) goto L28;
        this.mResourcesExt = new ResourcesExtApi24Impl();
    L29:
        this.mResourcesExt.init(this.mWebViewExt, this.mAssetManagerExt, this.mResourcesKeyExt, r101);
        if (r104 < 26) goto L32;
        this.mResourcesManagerExt = new ResourcesManagerExtApi26Impl();
    L35:
        this.mResourcesManagerExt.init(this.mWebViewExt, this.mAssetManagerExt, this.mResourcesExt, this.mResourcesKeyExt, r101);
        String[] r105 = this.mLoadedApkExt.getSplitDirsByLoadedApk(ActivityThreadHelper.getCachedLoadedApk(r102));
        if (r105 == null) goto L41;
        int r106 = 0;
    L39:
        if (r106 >= r105.length) goto L41;
        this.mSplitPathMaps.put(r102 + "_split_" + r106, r105[r106]);
        r106 = r106 + 1;
    L41:
        List<Plugin> r107 = PluginManager.getInstance().listPluginConfigs();
        if (Build.VERSION.SDK_INT < 24) goto L44;
        boolean r108 = true;
    L45:
        this.mUsedFakePath = r108;
        if (r108 == false) goto L48;
        UtilsExt.init();
        FastPluginDirHelperV3.init();
        FakeArscApkHelperV2.init();
    L48:
        String r109 = null;
    L50:
        if (r100 >= r107.size()) goto L57;
        String r110 = ((Plugin) ListProtector.get(r107, r100)).mPackageName;
        if (this.mUsedFakePath == false) goto L56;
        r109 = FastPluginDirHelperV3.getFakeSourceFile(r110);
        if (FastFileUtils.isSymLinkExist(r109) == true) goto L56;
        generateFakeApk(r109);
    L56:
        this.mSplitPathMaps.put(r110, r109);
        r100 = r100 + 1;
        goto L50
    L57:
        this.mInit = true;
        return;
    L44:
        r108 = false;
        goto L45
    L32:
        if (r104 < 24) goto L34;
        this.mResourcesManagerExt = new ResourcesManagerExtApi24Impl();
        goto L35
    L34:
        this.mResourcesManagerExt = new ResourcesManagerExtApi21Impl();
        goto L35
    L28:
        this.mResourcesExt = new ResourcesExtApi21Impl();
        goto L29
    L22:
        if (r104 < 24) goto L24;
        this.mResourcesKeyExt = new ResourcesKeyExtApi24Impl();
        goto L25
    L24:
        this.mResourcesKeyExt = new ResourcesKeyExtApi21Impl();
        goto L25
    L16:
        if (r104 < 24) goto L18;
        this.mWebViewExt = new WebViewExtApi24Impl();
        goto L19
    L18:
        this.mWebViewExt = new WebViewExtApi21Impl();
        goto L19
    L12:
        this.mAssetManagerExt = new AssetManagerExtApi21Impl();
        goto L13
    L8:
        this.mLoadedApkExt = new AndroidLoadedApkExtApi21Impl();
        goto L9
    }

    private void addAssetPathCompatForActivity() {
        Iterator<Activity> r100 = ActivityThreadHelper.getActivities().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        installActivity(r100.next(), true);
        goto L4
    }

    private Collection<String> filterPath(Collection<String> r100) {
        if (this.mUsedFakePath == false) goto L5;
        return r100;
    L5:
        if (r100 != null) goto L7;
    L18:
        return r100;
    L7:
        if (r100.isEmpty() == true) goto L18;
        ArrayList r101 = new ArrayList(r100.size());
        Iterator<String> r102 = r100.iterator();
    L11:
        if (r102.hasNext() == false) goto L17;
        String r103 = r102.next();
        if (r103 == null) goto L11;
        if (r103.isEmpty() == true) goto L11;
        r101.add(r103);
        goto L11
    L17:
        return r101;
    }

    private boolean generateFakeApk(String r100) {
        return FakeArscApkHelperV2.buildFakeApk(r100);
    }

    public boolean install(Context r100) {
        return install(r100, false);
    }

    public boolean installActivity(Context r100) {
        return installActivity(r100, false);
    }

    public boolean installLoadedApk(Object r100) {
        if (this.mInit == true) goto L6;
        MiraLogger.e(MiraLogger.TAG_RES, "NewMiraResourcesManager installLoadedApk method, NewMiraResourcesManager not init success!");
        return false;
    L6:
        if (r100 != null) goto L8;
    L32:
        MiraLogger.e(MiraLogger.TAG_RES, "NewMiraResourcesManager installLoadedApk method, loadedApk or mResourcesExt or mLoadedApkExt is null, loadedApk=" + r100 + ", mResourcesExt=" + this.mResourcesExt + " ,mLoadedApkExt=" + this.mLoadedApkExt);
        return false;
    L8:
        if (this.mResourcesExt == null) goto L32;
        if (this.mLoadedApkExt == null) goto L32;
        MiraParam r101 = MiraManager.getInstance().getParam();
        if (r101 == null) goto L19;
        if (r101.enableOptResourcesArch() == true) goto L19;
        MiraLogger.e(MiraLogger.TAG_RES, "NewMiraResourcesManager enableOptResourcesArch is not open, loadedApk=" + r100);
        return false;
    L19:
        if (this.mLoadedApkExt.injectLoadedApk(ActivityThreadHelper.getCachedLoadedApk(Mira.getAppContext().getPackageName()), r100) == true) goto L22;
        MiraLogger.e(MiraLogger.TAG_RES, "NewMiraResourcesManager injectLoadedApk is failed, loadedApk=" + r100);
        return false;
    L22:
        Resources r102 = this.mLoadedApkExt.buildResources(r100, ActivityThreadHelper.currentActivityThread());
        if (r102 != null) goto L27;
        MiraLogger.e(MiraLogger.TAG_RES, "NewMiraResourcesManager buildResources is failed, loadedApk=" + r100);
        return false;
    L27:
        if (installResources(null, r102, false) == true) goto L30;
        MiraLogger.e(MiraLogger.TAG_RES, "NewMiraResourcesManager installAssetManager is failed, loadedApk=" + r100);
        return false;
    L30:
        return true;
    }

    private void addAssetPathInternal(String r100, String r101) {
        Object r102 = mLock;
        monitor-enter(r102);
        addAssetPathWithLock(r100, r101);     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void addAssetPathWithLock(String r100, String r101) {
        if (this.mInit == true) goto L7;
        MiraLogger.e(MiraLogger.TAG_RES, "NewMiraResourcesManager addPluginPath, NewMiraResourcesManager not init success!");
        return;
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L9;
        return;
    L9:
        if (this.mResourcesManagerExt == null) goto L27;
        MiraLogger.i(MiraLogger.TAG_LOAD, "NewMiraResourcesManager addPluginPath, sourceDir = " + r101);
        if (this.mSplitPathMaps.containsKey(r100) == true) goto L15;
        MiraLogger.i(MiraLogger.TAG_LOAD, "NewMiraResourcesManager addPluginPath, skip not have key, packageName = " + r100 + ", sourceDir=" + r101);
        return;
    L15:
        String r102 = this.mSplitPathMaps.get(r100);
        if (r102 != null) goto L18;
    L21:
        this.mSplitPathMaps.put(r100, r101);
        AssetManagerProcessor r103 = MiraResourcesManager.getInstance().getAssetManagerProcessor();
        if (r103 == null) goto L24;
        r103.updateAssetManagerCachePath(r101);
    L24:
        this.mResourcesManagerExt.appendSplitAsset(filterPath(this.mSplitPathMaps.values()));
        return;
    L18:
        if (r102.equals(r101) == false) goto L21;
        MiraLogger.i(MiraLogger.TAG_LOAD, "NewMiraResourcesManager addPluginPath, skip has already, packageName = " + r100 + ", sourceDir=" + r101);
        return;
    }

    private boolean install(Context r100, boolean r101) {
        if (this.mInit == true) goto L6;
        MiraLogger.e(MiraLogger.TAG_RES, "NewMiraResourcesManager install method, NewMiraResourcesManager not init success!");
        return false;
    L6:
        if (r100 != null) goto L8;
    L22:
        MiraLogger.e(MiraLogger.TAG_RES, "NewMiraResourcesManager install method, context or mResourcesExt is null, context=" + r100 + ", mResourcesExt=" + this.mResourcesExt);
        return false;
    L8:
        if (this.mResourcesExt == null) goto L22;
        MiraParam r102 = MiraManager.getInstance().getParam();
        if (r102 == null) goto L17;
        if (r102.enableOptResourcesArch() == true) goto L17;
        MiraLogger.e(MiraLogger.TAG_RES, "NewMiraResourcesManager install method, enableOptResourcesArch is not open, context=" + r100);
        return false;
    L17:
        if (installResources(r100, r100.getResources(), r101) == true) goto L20;
        MiraLogger.e(MiraLogger.TAG_RES, "NewMiraResourcesManager install method, installResources is failed, context=" + r100);
        return false;
    L20:
        return true;
    }

    private boolean installActivity(Context r100, boolean r101) {
        if (this.mInit == true) goto L6;
        MiraLogger.e(MiraLogger.TAG_RES, "NewMiraResourcesManager installActivity method, NewMiraResourcesManager not init success!");
        return false;
    L6:
        if (r100 != null) goto L8;
    L22:
        MiraLogger.e(MiraLogger.TAG_RES, "NewMiraResourcesManager installActivity method, context or mResourcesExt is null, context=" + r100 + " ,mResourcesExt=" + this.mResourcesExt);
        return false;
    L8:
        if (this.mResourcesExt == null) goto L22;
        MiraParam r102 = MiraManager.getInstance().getParam();
        if (r102 == null) goto L17;
        if (r102.enableOptResourcesArch() == true) goto L17;
        MiraLogger.e(MiraLogger.TAG_RES, "NewMiraResourcesManager enableOptResourcesArch is not open, context=" + r100);
        return false;
    L17:
        if (installResources(r100, r100.getResources(), r101) == true) goto L20;
        MiraLogger.e(MiraLogger.TAG_RES, "NewMiraResourcesManager installActivity method, installResources is failed, context=" + r100);
        return false;
    L20:
        return true;
    }

    public void addAssetPath(String r100, String r101) {
        addAssetPathInternal(r100, r101);
        addAssetPathCompatForApplication();
        addAssetPathCompatForActivity();
    }

    public void addStrongRef(String r100, Object r101) {
        this.mStrongRefMaps.put(r100, r101);
    }

    private boolean installResources(Context r100, Resources r101, boolean r102) {
        Object r103 = mLock;
        monitor-enter(r103);
        boolean r104 = this.mResourcesExt.addAssetPaths(r100, r101, filterPath(this.mSplitPathMaps.values()), r102);     // Catch: Throwable -> L7
        monitor-exit(r103);     // Catch: Throwable -> L7
        return r104;
    L7:
        th = move-exception;
        throw th;
    }
}
