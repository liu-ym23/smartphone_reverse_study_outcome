package com.bytedance.dux.window.listener;

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
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.android.ttcjpaysdk.base.utils.CJPayGestureUtils;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.dux.common.live_data.NextLiveData;
import com.bytedance.dux.window.inner_split.SplitHelper;
import com.bytedance.dux.window.model.AdaptedWindowSize;
import com.ss.android.lark.utils.statistics.PerfLog;
import hm4.c;
import hm4.d;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/bytedance/dux/window/listener/WindowConfigChangeListener;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/dux/common/live_data/NextLiveData;", "Lhm4/d;", "mData", "Lcom/bytedance/dux/common/live_data/NextLiveData;", "<init>", "()V", "Companion", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class WindowConfigChangeListener extends ViewModel {
    private static final long CONFIG_REFRESH_DELAY_TIME = 100;
    public static final Companion Companion = null;
    private static final String TAG = "Window";
    private static ConcurrentHashMap<Integer, Triple<Configuration, Integer, Integer>> mConfigDiffMap;
    private static ConcurrentHashMap<Integer, ConcurrentLinkedQueue<WeakReference<Fragment>>> mFragmentMap;
    private static Configuration mLastConfig;
    private NextLiveData<d> mData;

    public static final class Companion {

        public static final class a<T> implements Observer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<T> f205941a = null;

            static {
                f205941a = new a();
            }

            public a() {
            }

            @Override // androidx.lifecycle.Observer
            public final /* bridge */ /* synthetic */ void onChanged(Object r100) {
                d r101 = (d) r100;
            }
        }

        public Companion() {
        }

        @JvmStatic
        public static NextLiveData b(LifecycleOwner r100) {
            Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
            if ((r100 instanceof Fragment) == false) goto L10;
            FragmentActivity r101 = ((Fragment) r100).getActivity();
            if (r101 == null) goto L14;
            Application r102 = r101.getApplication();
            if (r102 == null) goto L14;
            return WindowConfigChangeListener.access$getMData$p((WindowConfigChangeListener) new ViewModelProvider((ViewModelStoreOwner) r100, ViewModelProvider.AndroidViewModelFactory.getInstance(r102)).get(WindowConfigChangeListener.class));
        L14:
            return null;
        L10:
            if ((r100 instanceof FragmentActivity) == false) goto L14;
            Application r103 = ((FragmentActivity) r100).getApplication();
            if (r103 == null) goto L14;
            return WindowConfigChangeListener.access$getMData$p((WindowConfigChangeListener) new ViewModelProvider((ViewModelStoreOwner) r100, ViewModelProvider.AndroidViewModelFactory.getInstance(r103)).get(WindowConfigChangeListener.class));
        }

        @JvmStatic
        public static void c(Observer r100) {
            if ((r100 instanceof WindowConfigChangeObserver) == false) goto L5;
            WindowConfigChangeObserver r101 = (WindowConfigChangeObserver) r100;
        L6:
            if (r101 == null) goto L10;
            c r102 = r101.f205946a;
            if (r102 == null) goto L10;
            FragmentActivity r103 = r102.b();
        L11:
            if (r103 != null) goto L14;
            return;
        L14:
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L18;
            NextLiveData r104 = b(r103);
            if (r104 == null) goto L22;
            r104.removeObserver(r100);
            return;
        L22:
            return;
        L18:
            LifecycleCoroutineScope r105 = b.a(r103.getLifecycle());
            if (r105 == null) goto L24;
            BuildersKt.launch$default(r105, Dispatchers.getMain(), null, new WindowConfigChangeListener$Companion$removeObserverOnMainThread$1(r103, r100, null), 2, null);
            return;
        L24:
            return;
        L10:
            r103 = null;
            goto L11
        L5:
            r101 = null;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        @JvmStatic
        public static Observer a(c r100, jm4.b r101) {
            Intrinsics.checkNotNullParameter(r100, "config");
            final FragmentActivity r102 = r100.b();
            if (r102 == 0) goto L37;
            if (r101 == null) goto L37;
            if ((r102 instanceof Fragment) == false) goto L23;
            Fragment r103 = (Fragment) r102;
            FragmentActivity r104 = r103.getActivity();
            if (r104 == null) goto L11;
            final int r105 = r104.hashCode();
        L13:
            if (WindowConfigChangeListener.access$getMFragmentMap$cp().get(Integer.valueOf(r105)) != null) goto L19;
            Integer r106 = Integer.valueOf(r105);
            WindowConfigChangeListener.access$getMFragmentMap$cp().put(r106, new ConcurrentLinkedQueue());
            FragmentActivity r107 = r103.getActivity();
            if (r107 == null) goto L19;
            Lifecycle r108 = r107.getLifecycle();
            if (r108 == null) goto L19;
            r108.addObserver(new WindowConfigChangeListener$Companion$addListener$2(r105));
        L19:
            ConcurrentLinkedQueue r109 = (ConcurrentLinkedQueue) WindowConfigChangeListener.access$getMFragmentMap$cp().get(Integer.valueOf(r105));
            if (r109 == null) goto L22;
            r109.add(new WeakReference(r102));
        L22:
            r103.getLifecycle().addObserver(new WindowConfigChangeListener$Companion$addListener$3(r105, r102));
            goto L23
        L11:
            r105 = 0;
        L23:
            FragmentActivity r110 = r100.b();
            if (r110 == null) goto L38;
            WindowConfigChangeObserver r111 = new WindowConfigChangeObserver(r100, r101);
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L31;
            NextLiveData r112 = b(r110);
            if (r112 == null) goto L35;
            r112.observe(r110, r111);
        L35:
            return r111;
        L31:
            LifecycleCoroutineScope r113 = b.a(r110.getLifecycle());
            if (r113 == null) goto L35;
            BuildersKt.launch$default(r113, Dispatchers.getMain(), null, new WindowConfigChangeListener$Companion$observeByObserverOnMainThread$1(r110, r111, null), 2, null);
            goto L35
        L38:
            return com.bytedance.dux.window.listener.a.f205948a;
        L37:
            return a.f205941a;
        }

        public static void d(final FragmentActivity r100, Configuration r101, int r102, int r110) {
            int r103 = r100.hashCode();     // Catch: Exception -> L7
            if (WindowConfigChangeListener.access$getMConfigDiffMap$cp().containsKey(Integer.valueOf(r103)) == true) goto L5;
            r100.getLifecycle().addObserver(new WindowConfigChangeListener$Companion$setConfigInternal$1(r100));     // Catch: Exception -> L7
        L5:
            WindowConfigChangeListener.access$getMConfigDiffMap$cp().put(Integer.valueOf(r103), new Triple(r101, Integer.valueOf(r102), Integer.valueOf(r110)));     // Catch: Exception -> L7
        L9:
            jm4.a.f499636a.getClass();
            int r104 = im4.b.f490535a;
            AdaptedWindowSize r105 = AdaptedWindowSize.f205949b;
            r105.b(r100, r102, r110);
            WindowManager r106 = null;
            if ((r100 instanceof Activity) == false) goto L12;
            FragmentActivity r107 = r100;
        L13:
            if (r107 == null) goto L32;
            Intrinsics.checkNotNullParameter(r107, "activity");
            Set<Integer> r108 = AdaptedWindowSize.f205953f;
            if ((!r108.isEmpty()) == false) goto L53;
        L24:
            Intrinsics.checkNotNullParameter(r107, "activity");
            Resources r109 = r107.getResources();
            Pair<Integer, Integer> r111 = new Pair(Integer.valueOf(r109.getDimensionPixelSize(r109.getIdentifier("status_bar_height", "dimen", "android"))), Integer.valueOf(r109.getDimensionPixelSize(r109.getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android"))));
            if (Build.VERSION.SDK_INT < 24) goto L32;
            if (r107.isInMultiWindowMode() == false) goto L32;
            Set<Integer> r112 = AdaptedWindowSize.f205953f;
            if (r105.a(r112, r102, r111) == true) goto L32;
            r105.a(r112, r110, r111);
            goto L32
        L53:
            Object r113 = r107.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Exception -> L23
            if ((r113 instanceof WindowManager) == false) goto L20;
            r106 = (WindowManager) r113;     // Catch: Exception -> L23
        L20:
            if (r106 == null) goto L24;
            Point r114 = new Point();     // Catch: Exception -> L23
            r106.getDefaultDisplay().getRealSize(r114);     // Catch: Exception -> L23
            r108.add(Integer.valueOf(r114.x));     // Catch: Exception -> L23
            r108.add(Integer.valueOf(r114.y));     // Catch: Exception -> L23
        L32:
            Iterator<jm4.b> r115 = AdaptedWindowSize.f205954g.iterator();
        L34:
            if (r115.hasNext() == false) goto L36;
            r115.next().a(new d(AdaptedWindowSize.f205950c, AdaptedWindowSize.f205950c, AdaptedWindowSize.f205952e));
            goto L34
        L36:
            WindowConfigChangeListener.Companion.getClass();
            NextLiveData r116 = b(r100);
            if (r116 == null) goto L39;
            r116.postValue(new d(SplitHelper.c(r100), SplitHelper.c(r100), SplitHelper.b(r100)));
        L39:
            ConcurrentLinkedQueue r117 = (ConcurrentLinkedQueue) WindowConfigChangeListener.access$getMFragmentMap$cp().get(Integer.valueOf(r100.hashCode()));
            if (r117 == null) goto L49;
            Iterator r118 = r117.iterator();
        L43:
            if (r118.hasNext() == false) goto L49;
            Fragment r119 = (Fragment) ((WeakReference) r118.next()).get();
            if (r119 == null) goto L43;
            WindowConfigChangeListener.Companion.getClass();
            NextLiveData r120 = b(r119);
            if (r120 == null) goto L43;
            r120.postValue(new d(SplitHelper.c(r100), SplitHelper.c(r100), SplitHelper.b(r100)));
        L49:
            int r121 = com.bytedance.dux.window.controller.c.f205937a;
            return;
        L12:
            r107 = null;
        L7:
            e = move-exception;
            e.getMessage();
            goto L9
        }
    }

    @JvmStatic
    public static final Observer<d> addListener(c r100, jm4.b r101) {
        Companion.getClass();
        return Companion.a(r100, r101);
    }

    @JvmStatic
    public static final NextLiveData<d> getCurrentConfigLiveData(LifecycleOwner r100) {
        Companion.getClass();
        return Companion.b(r100);
    }

    @JvmStatic
    public static final void removeListenerByObserver(Observer<d> r100) {
        Companion.getClass();
        Companion.c(r100);
    }

    static {
        Companion = new Companion();
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
    public static final void setConfig(Activity r110, Configuration r111, int r112, int r113) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "config");
        if ((r110 instanceof FragmentActivity) == true) goto L5;
        Objects.toString(r110);
        return;
    L5:
        LifecycleCoroutineScope r100 = b.a(((FragmentActivity) r110).getLifecycle());
        if (r100 == null) goto L10;
        BuildersKt.launch$default(r100, Dispatchers.getDefault(), null, new WindowConfigChangeListener$Companion$setConfig$1(r110, r111, r112, r113, null), 2, null);
        return;
    }
}
