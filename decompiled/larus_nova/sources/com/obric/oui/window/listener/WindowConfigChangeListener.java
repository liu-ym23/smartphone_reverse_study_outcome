package com.obric.oui.window.listener;

import ana.f;
import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.os.Looper;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.android.ttcjpaysdk.base.utils.CJPayGestureUtils;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.window.bean.WindowSizeClass;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/obric/oui/window/listener/WindowConfigChangeListener;", "Landroidx/lifecycle/ViewModel;", "Lcom/obric/oui/window/listener/NextLiveData;", "Lana/f;", "mData", "Lcom/obric/oui/window/listener/NextLiveData;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class WindowConfigChangeListener extends ViewModel {
    private static final long CONFIG_REFRESH_DELAY_TIME = 100;
    public static final a Companion = null;
    private static final String TAG = "Window";
    private static ConcurrentHashMap<Integer, Pair<Configuration, Integer>> mConfigDiffMap;
    private static ConcurrentHashMap<Integer, ConcurrentLinkedQueue<WeakReference<Fragment>>> mFragmentMap;
    private static Configuration mLastConfig;
    private NextLiveData<f> mData;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static NextLiveData a(LifecycleOwner r100) {
            Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
            if ((r100 instanceof Fragment) == false) goto L12;
            FragmentActivity r101 = ((Fragment) r100).getActivity();
            if (r101 == null) goto L17;
            Application r102 = r101.getApplication();
            if (r102 == null) goto L17;
            return WindowConfigChangeListener.access$getMData$p((WindowConfigChangeListener) new ViewModelProvider((ViewModelStoreOwner) r100, ViewModelProvider.AndroidViewModelFactory.getInstance(r102)).get(WindowConfigChangeListener.class));
        L17:
            return null;
        L12:
            if ((r100 instanceof FragmentActivity) == false) goto L17;
            Application r103 = ((FragmentActivity) r100).getApplication();
            if (r103 == null) goto L17;
            return WindowConfigChangeListener.access$getMData$p((WindowConfigChangeListener) new ViewModelProvider((ViewModelStoreOwner) r100, ViewModelProvider.AndroidViewModelFactory.getInstance(r103)).get(WindowConfigChangeListener.class));
        }

        public static void b(final FragmentActivity r100, Configuration r101, int r110, int r111) {
            int r102 = r100.hashCode();     // Catch: Exception -> L7
            if (WindowConfigChangeListener.access$getMConfigDiffMap$cp().containsKey(Integer.valueOf(r102)) == true) goto L5;
            r100.getLifecycle().addObserver(new WindowConfigChangeListener$Companion$setConfigInternal$1(r100));     // Catch: Exception -> L7
        L5:
            WindowConfigChangeListener.access$getMConfigDiffMap$cp().put(Integer.valueOf(r102), new Pair(r101, Integer.valueOf(r110)));     // Catch: Exception -> L7
        L9:
            WindowSizeClass r103 = ena.a.f473236a;
            if (r100 == null) goto L69;
            Resources r104 = Resources.getSystem();
            float r105 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).density;
            float r106 = r110 / r105;
            float r107 = r111 / r105;
            ena.a.f473238c = new ana.a(r106, r107);
            WindowSizeClass r108 = WindowSizeClass.FLOATING_WINDOW;
            if (r106 >= r108.getDpSize()) goto L16;
            r108 = WindowSizeClass.MINUS_ERROR_SIZE;
        L52:
            if (ena.a.f473236a == r108) goto L56;
            if (r108 == WindowSizeClass.MINUS_ERROR_SIZE) goto L56;
        L57:
            ena.a.f473236a = r108;
            Resources r109 = r100.getResources();
            if (r109 == null) goto L62;
            Configuration r112 = r109.getConfiguration();
            if (r112 == null) goto L62;
            int r113 = r112.orientation;
        L64:
            ena.a.f473237b = r113;
            StringBuilder r114 = new StringBuilder("当前档位：");
            r114.append(ena.a.f473236a.getBaseGridConfig().f4567a);
            r114.append("\n当前页面可用宽高：");
            r114.append(r106);
            r114.append(',');
            r114.append(r107);
            r114.append("\ndecorViewWidth：");
            r114.append(r110);
            r114.append("，decorVideHeight: ");
            r114.append(r111);
            r114.append("\nmultiWindowMode = ");
            if (Build.VERSION.SDK_INT < 24) goto L67;
            boolean r115 = r100.isInMultiWindowMode();
        L68:
            r114.append(r115);
            r114.append('\n');
            Intrinsics.stringPlus("windowMsg = ", r114.toString());
            goto L69
        L67:
            r115 = false;
        L62:
            r113 = 1;
        L56:
            if (ena.a.f473237b == r100.getResources().getConfiguration().orientation) goto L69;
        L16:
            if (r106 >= r108.getDpSize()) goto L18;
        L20:
            r108 = WindowSizeClass.SMALL_SPLIT_SCREEN;
            if (r106 >= r108.getDpSize()) goto L23;
        L25:
            r108 = WindowSizeClass.SMALLER_ANDROID_SCREEN;
            if (r106 >= r108.getDpSize()) goto L28;
        L30:
            r108 = WindowSizeClass.SMALL;
            if (r106 >= r108.getDpSize()) goto L33;
        L35:
            r108 = WindowSizeClass.STANDARD;
            if (r106 >= r108.getDpSize()) goto L38;
        L40:
            r108 = WindowSizeClass.NORMAL;
            if (r106 >= r108.getDpSize()) goto L43;
        L45:
            r108 = WindowSizeClass.LARGE;
            if (r106 >= r108.getDpSize()) goto L48;
        L50:
            r108 = WindowSizeClass.OVERSIZE;
            goto L52
        L48:
            if (r106 >= WindowSizeClass.OVERSIZE.getDpSize()) goto L50;
        L43:
            if (r106 >= WindowSizeClass.LARGE.getDpSize()) goto L45;
        L38:
            if (r106 >= WindowSizeClass.NORMAL.getDpSize()) goto L40;
        L33:
            if (r106 >= WindowSizeClass.STANDARD.getDpSize()) goto L35;
        L28:
            if (r106 >= WindowSizeClass.SMALL.getDpSize()) goto L30;
        L23:
            if (r106 >= WindowSizeClass.SMALLER_ANDROID_SCREEN.getDpSize()) goto L25;
        L18:
            if (r106 >= WindowSizeClass.SMALL_SPLIT_SCREEN.getDpSize()) goto L20;
        L69:
            WindowManager r116 = null;
            if ((r100 instanceof Activity) == false) goto L72;
            FragmentActivity r117 = r100;
        L73:
            if (r117 == null) goto L92;
            Intrinsics.checkNotNullParameter(r117, "activity");
            Set<Integer> r118 = ena.a.f473239d;
            if ((true ^ r118.isEmpty()) == true) goto L84;
            Object r119 = r117.getSystemService(LiveEndPageData.TAG_WINDOW);
            if ((r119 instanceof WindowManager) == false) goto L81;
            r116 = (WindowManager) r119;
        L81:
            if (r116 == null) goto L84;
            Point r120 = new Point();
            r116.getDefaultDisplay().getRealSize(r120);
            r118.add(Integer.valueOf(r120.x));
            r118.add(Integer.valueOf(r120.y));
        L84:
            Intrinsics.checkNotNullParameter(r117, "activity");
            Resources r121 = r117.getResources();
            Pair r122 = new Pair(Integer.valueOf(r121.getDimensionPixelSize(r121.getIdentifier("status_bar_height", "dimen", "android"))), Integer.valueOf(r121.getDimensionPixelSize(r121.getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android"))));
            if (Build.VERSION.SDK_INT < 24) goto L92;
            if (r117.isInMultiWindowMode() == false) goto L92;
            if (ena.a.a(r118, r110, r122) == true) goto L92;
            ena.a.a(r118, r111, r122);
        L92:
            Iterator<dna.a> r123 = ena.a.f473240e.iterator();
        L94:
            if (r123.hasNext() == false) goto L96;
            dna.a r124 = r123.next();
            WindowSizeClass r125 = ena.a.f473236a;
            ana.a r126 = ena.a.f473238c;
            Intrinsics.checkNotNullParameter(r125, "windowSizeClass");
            Intrinsics.checkNotNullParameter(r126, "pageSize");
            r124.onChange();
            goto L94
        L96:
            WindowConfigChangeListener.Companion.getClass();
            NextLiveData r127 = a(r100);
            if (r127 == null) goto L100;
            r127.postValue(new f(ena.a.f473236a, ena.a.f473238c));
        L100:
            ConcurrentLinkedQueue r128 = (ConcurrentLinkedQueue) WindowConfigChangeListener.access$getMFragmentMap$cp().get(Integer.valueOf(r100.hashCode()));
            if (r128 == null) goto L113;
            Iterator r129 = r128.iterator();
        L105:
            if (r129.hasNext() == false) goto L113;
            Fragment r130 = (Fragment) ((WeakReference) r129.next()).get();
            if (r130 == null) goto L105;
            WindowConfigChangeListener.Companion.getClass();
            NextLiveData r131 = a(r130);
            if (r131 == null) goto L105;
            r131.postValue(new f(ena.a.f473236a, ena.a.f473238c));
        L113:
            zma.a r132 = zma.a.f572881a;
            return;
        L72:
            r117 = null;
        L7:
            e = move-exception;
            Intrinsics.stringPlus("setToConfig error:", e.getMessage());
            goto L9
        }
    }

    @JvmStatic
    public static final NextLiveData<f> getCurrentConfigLiveData(LifecycleOwner r100) {
        Companion.getClass();
        return a.a(r100);
    }

    static {
        Companion = new a();
        mConfigDiffMap = new ConcurrentHashMap();
        mFragmentMap = new ConcurrentHashMap();
    }

    public WindowConfigChangeListener() {
        this.mData = new NextLiveData();
    }

    public static final /* synthetic */ ConcurrentHashMap access$getMConfigDiffMap$cp() {
        return mConfigDiffMap;
    }

    public static final /* synthetic */ ConcurrentHashMap access$getMFragmentMap$cp() {
        return mFragmentMap;
    }

    public static final /* synthetic */ NextLiveData access$getMData$p(WindowConfigChangeListener r100) {
        return r100.mData;
    }

    @JvmStatic
    public static final Observer<f> addListener(final LifecycleOwner r100, final dna.a r101) {
        Companion.getClass();
        if (r100 == null) goto L35;
        if (r101 != null) goto L7;
        return null;
    L7:
        if ((r100 instanceof Fragment) == false) goto L26;
        Fragment r102 = (Fragment) r100;
        FragmentActivity r103 = r102.getActivity();
        if (r103 == null) goto L11;
        final int r104 = r103.hashCode();
    L13:
        if (access$getMFragmentMap$cp().get(Integer.valueOf(r104)) != null) goto L21;
        access$getMFragmentMap$cp().put(Integer.valueOf(r104), new ConcurrentLinkedQueue());
        FragmentActivity r105 = r102.getActivity();
        if (r105 == null) goto L21;
        Lifecycle r106 = r105.getLifecycle();
        if (r106 == null) goto L21;
        r106.addObserver(new WindowConfigChangeListener$Companion$addListener$1(r104));
    L21:
        ConcurrentLinkedQueue r107 = (ConcurrentLinkedQueue) access$getMFragmentMap$cp().get(Integer.valueOf(r104));
        if (r107 == null) goto L25;
        r107.add(new WeakReference(r100));
    L25:
        r102.getLifecycle().addObserver(new WindowConfigChangeListener$Companion$addListener$2(r104, r100));
        goto L26
    L11:
        r104 = 0;
    L26:
        Observer<f> r108 = new com.obric.oui.window.listener.a(r101);
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L32;
        NextLiveData r109 = a.a(r100);
        if (r109 == null) goto L34;
        r109.observe(r100, r108);
    L34:
        return r108;
    L32:
        BuildersKt.launch$default(LifecycleKt.getCoroutineScope(r100.getLifecycle()), Dispatchers.getMain(), null, new WindowConfigChangeListener$Companion$observeByObserverOnMainThread$1(r100, r108, null), 2, null);
        goto L34
    L35:
        return null;
    }

    @JvmStatic
    public static final void removeListenerByObserver(Observer<f> r100, LifecycleOwner r101) {
        Companion.getClass();
        if (r101 == null) goto L14;
        if (r100 != null) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L12;
        NextLiveData r102 = a.a(r101);
        if (r102 == null) goto L17;
        r102.removeObserver(r100);
        return;
    L17:
        return;
    L12:
        BuildersKt.launch$default(LifecycleKt.getCoroutineScope(r101.getLifecycle()), Dispatchers.getMain(), null, new WindowConfigChangeListener$Companion$removeObserverOnMainThread$1(r101, r100, null), 2, null);
        return;
    }

    @JvmStatic
    public static final void setConfig(Activity r110, Configuration r111, int r112, int r113) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "config");
        if ((r110 instanceof FragmentActivity) == true) goto L5;
        Objects.toString(r110);
        return;
    L5:
        BuildersKt.launch$default(LifecycleKt.getCoroutineScope(((FragmentActivity) r110).getLifecycle()), Dispatchers.getDefault(), null, new WindowConfigChangeListener$Companion$setConfig$1(r110, r111, r112, r113, null), 2, null);
    }
}
