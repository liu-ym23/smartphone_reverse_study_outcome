package com.ss.android.lark.utils.navigation;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.Contexts;
import com.ss.android.lark.utils.y0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes38.dex */
public class Navigation implements com.ss.android.lark.utils.navigation.a {
    private static final long OPEN_PAGE_MIN_DURATION = 500;
    private static final int REQUEST_CODE_DEFAULT = 0;
    private static final int REQUEST_CODE_UNDEFINED = -1;
    private static final String TAG = "Navigation";
    private static Map<String, List<WeakReference<Navigation>>> mNavigationMap;
    private static String sCurrentActivePageName;
    private static boolean sIsLifecycleInit;
    private static boolean sIsNavigationEnable;
    private static long sLastOpenTime;
    private static String sLastPageName;
    private static String sLastSourceKey;
    private static b sNavigationListener;
    private Context mContext;
    Fragment mFragment;
    private String mSourceKey;
    private String mSourceName;
    private long mStartTime;

    public class a implements Application.ActivityLifecycleCallbacks {
        public a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r100) {
            if (y0.a(Navigation.access$000(), r100.getComponentName().getClassName()) == false) goto L6;
            Log.i(Navigation.TAG, "page :" + Navigation.access$000() + " destroyed");
            Navigation.access$002("");
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r100) {
            if (y0.a(Navigation.access$000(), r100.getComponentName().getClassName()) == false) goto L6;
            Log.i(Navigation.TAG, "page :" + Navigation.access$000() + " paused");
            Navigation.access$002("");
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r100) {
            if (y0.a(Navigation.access$000(), r100.getComponentName().getClassName()) == false) goto L6;
            Log.i(Navigation.TAG, "page :" + Navigation.access$000() + " stopped");
            Navigation.access$002("");
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r100, Bundle r101) {
            Navigation.access$002(r100.getComponentName().getClassName());
            Log.i(Navigation.TAG, "page :" + Navigation.access$000() + " created");
        }
    }

    public interface b {
    }

    public interface c {
        void a();
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f444742a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f444743b;

        public d(View r100) {
            this.f444742a = r100.toString();
            String r101 = r100.getContext().getResources().getResourceEntryName(r100.getId());     // Catch: Resources.NotFoundException -> L5
        L7:
            this.f444743b = r100.getClass().getName() + ": " + r101;
            return;
        L5:
            e = move-exception;
            Log.e(e.getMessage());
            r101 = "";
            goto L7
        }

        public d(Object r100) {
            this.f444742a = r100.toString();
            this.f444743b = r100.getClass().getName();
        }
    }

    public static void setNavigationListener(b r100) {
    }

    static {
        mNavigationMap = new ConcurrentHashMap();
        sIsLifecycleInit = false;
        sIsNavigationEnable = false;
    }

    public static /* synthetic */ String access$000() {
        return sCurrentActivePageName;
    }

    private String getSourceKey() {
        return this.mSourceKey;
    }

    private String getSourceName() {
        return this.mSourceName;
    }

    @Override // com.ss.android.lark.utils.navigation.a
    public Context getContext() {
        return this.mContext;
    }

    public Fragment getSourceFragment() {
        return this.mFragment;
    }

    public static /* synthetic */ String access$002(String r100) {
        sCurrentActivePageName = r100;
        return r100;
    }

    private static synchronized void addActivityLifeMonitor(Context r100) {
        monitor-enter(Navigation.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (sIsLifecycleInit == false) goto L8;
        monitor-exit(Navigation.class);
        return;
    L8:
        ((Application) r100.getApplicationContext()).registerActivityLifecycleCallbacks(new a());     // Catch: Throwable -> L11
        sIsLifecycleInit = true;     // Catch: Throwable -> L11
        monitor-exit(Navigation.class);
    }

    private static void addNewNavigation(Navigation r100) {
        if (sIsNavigationEnable == true) goto L5;
        return;
    L5:
        List<WeakReference<Navigation>> r101 = mNavigationMap.get(r100.getSourceKey());
        if (r101 != null) goto L8;
        r101 = new ArrayList();
    L8:
        r101.add(new WeakReference(r100));
        mNavigationMap.put(r100.getSourceKey(), r101);
    }

    public static Navigation from(View r100) {
        Navigation r101 = new Navigation(r100.getContext(), new d(r100));
        addNewNavigation(r101);
        return r101;
    }

    private boolean isDuplicateOpen(String r100) {
        if (TextUtils.equals(r100, sLastPageName) == true) goto L5;
    L7:
        return false;
    L5:
        if ((SystemClock.uptimeMillis() - sLastOpenTime) >= 500) goto L7;
        return true;
    }

    public static void setIsNavigationEnable(boolean r100) {
        sIsNavigationEnable = r100;
    }

    public boolean openActivity(Intent r100) {
        return openActivity(r100, -1, null);
    }

    public static Navigation from(Context r100) {
        Navigation r101 = new Navigation(r100, new d(r100));
        addNewNavigation(r101);
        return r101;
    }

    private Navigation(Context r100, d r101) {
        this(r100, null, r101);
    }

    public static Navigation from(Context r100, Fragment r101) {
        Navigation r102 = new Navigation(r100, r101, new d(r101));
        addNewNavigation(r102);
        return r102;
    }

    private boolean isSameAsCreatedPage(String r100, String r101) {
        if (TextUtils.equals(r100, sCurrentActivePageName) == true) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals(r101, sLastSourceKey) == false) goto L7;
        return true;
    }

    private boolean startActivity(Intent r100, Bundle r101) {
        if (sIsNavigationEnable == true) goto L5;
        Fragment r102 = this.mFragment;
        if (r102 != null) goto L9;
        this.mContext.startActivity(r100, r101);
        return true;
    L9:
        if (r102.isAdded() == false) goto L11;
        this.mFragment.startActivity(r100, r101);
        return true;
    L11:
        Log.e(TAG, this.mFragment.getClass().getName().concat(" is not added, can't start activity"));
        return true;
    L5:
        return openActivityByNavigation(r100, -1, r101);
    }

    public boolean openActivity(String r100, c r101) {
        if (sIsNavigationEnable == true) goto L5;
        r101.a();
        return true;
    L5:
        if (CollectionUtils.isNotEmpty(mNavigationMap.get(this.mSourceKey)) == true) goto L7;
        return false;
    L7:
        if (isDuplicateOpen(r100) == false) goto L10;
        Log.i(TAG, "return by duplicate open page name: " + r100);
        return false;
    L10:
        r101.a();
        sLastOpenTime = SystemClock.uptimeMillis();
        sLastPageName = r100;
        mNavigationMap.clear();
        return true;
    }

    public static Navigation from(Context r100, Object r101) {
        Navigation r102 = new Navigation(r100, new d(r101));
        addNewNavigation(r102);
        return r102;
    }

    public boolean openActivity(Intent r100, int r101) {
        return openActivity(r100, r101, null);
    }

    public boolean openActivity(Intent r100, Bundle r101) {
        return openActivity(r100, -1, r101);
    }

    private Navigation(Context r100, Fragment r101, d r102) {
        this.mContext = r100;
        this.mFragment = r101;
        this.mStartTime = SystemClock.uptimeMillis();
        this.mSourceKey = r102.f444742a;
        this.mSourceName = r102.f444743b;
        if (sIsNavigationEnable == false) goto L6;
        addActivityLifeMonitor(r100);
        return;
    }

    private boolean openActivityByNavigation(Intent r100, int r101, Bundle r102) {
        if (CollectionUtils.isNotEmpty(mNavigationMap.get(this.mSourceKey)) == true) goto L5;
    L45:
        return false;
    L5:
        if (this.mContext == null) goto L45;
        if (r100.getComponent() == null) goto L9;
        String r103 = r100.getComponent().getClassName();
    L11:
        if (isDuplicateOpen(r103) == false) goto L14;
        Log.i(TAG, "return by duplicate open page name: " + r103);
        return false;
    L14:
        Activity r104 = Contexts.findActivity(this.mContext);
        if (r104 != null) goto L17;
    L19:
        boolean r105 = false;
    L21:
        if (isSameAsCreatedPage(r103, this.mSourceKey) == false) goto L26;
        if (r105 == true) goto L26;
        Log.i(TAG, "return by is same as active page: " + r103);
        return false;
    L26:
        if (r101 <= 0) goto L36;
        Fragment r106 = this.mFragment;
        if (r106 != null) goto L30;
        Context r107 = this.mContext;
        if ((r107 instanceof Activity) == false) goto L43;
        ((Activity) r107).startActivityForResult(r100, r101, r102);
    L43:
        Log.i(TAG, "open page: " + r103);
        sLastOpenTime = SystemClock.uptimeMillis();
        sLastPageName = r103;
        sLastSourceKey = this.mSourceKey;
        mNavigationMap.clear();
        return true;
    L30:
        if (r106.isAdded() == false) goto L32;
        this.mFragment.startActivityForResult(r100, r101, r102);
        goto L43
    L32:
        Log.e(TAG, this.mFragment.getClass().getName().concat(" is not added, can't start activity"));
        goto L43
    L36:
        Fragment r108 = this.mFragment;
        if (r108 != null) goto L39;
        this.mContext.startActivity(r100, r102);
        goto L43
    L39:
        if (r108.isAdded() == false) goto L41;
        this.mFragment.startActivity(r100, r102);
        goto L43
    L41:
        Log.e(TAG, this.mFragment.getClass().getName().concat(" is not added, can't start activity"));
        goto L43
    L17:
        if (com.ss.android.lark.base.embedded.b.b(r104) == false) goto L19;
        r105 = true;
        goto L21
    L9:
        r103 = "";
        goto L11
    }

    private boolean startActivityForResult(Intent r100, int r101, Bundle r102) {
        if (sIsNavigationEnable == true) goto L5;
        Fragment r103 = this.mFragment;
        if (r103 != null) goto L9;
        ((Activity) this.mContext).startActivityForResult(r100, r101, r102);
        return true;
    L9:
        if (r103.isAdded() == false) goto L11;
        this.mFragment.startActivityForResult(r100, r101, r102);
        return true;
    L11:
        Log.e(TAG, this.mFragment.getClass().getName().concat(" is not added, can't start activity"));
        return true;
    L5:
        return openActivityByNavigation(r100, r101, r102);
    }

    public boolean openActivity(Intent r100, int r101, Bundle r102) {
        if ((this.mContext instanceof Activity) == false) goto L9;
        if (r101 <= 0) goto L8;
        return startActivityForResult(r100, r101, r102);
    L8:
        return startActivity(r100, r102);
    L9:
        r100.addFlags(268435456);
        return startActivity(r100, r102);
    }
}
