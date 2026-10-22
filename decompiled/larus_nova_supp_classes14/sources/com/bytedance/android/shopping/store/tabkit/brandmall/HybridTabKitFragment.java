package com.bytedance.android.shopping.store.tabkit.brandmall;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.monitor.q;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.host.api.ug.IECUGHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.store.api.ITabKitEventListener;
import com.bytedance.android.ec.store.prefetch.PrefetchScene;
import com.bytedance.android.marketing.sdk.api.ECMarketingSDK;
import com.bytedance.android.marketing.sdk.api.IMarketingServiceV2;
import com.bytedance.android.shopping.store.tabkit.TabKitFragment;
import com.bytedance.android.shopping.store.tabkit.TabKitViewModel;
import com.bytedance.android.shopping.store.tabkit.events.TabKitEventCenter;
import com.bytedance.android.shopping.store.tabkit.model.k;
import com.bytedance.android.shopping.store.tabkit.model.s;
import com.bytedance.android.shopping.store.tabkit.model.z;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFirstFramePref;
import com.bytedance.android.shopping.store.tabkit.router.TabKitRouterParams;
import com.bytedance.android.shopping.store.tabkit.view.MixTabLayout;
import com.bytedance.android.ui.base.widget.tablayout.ECTabLayout;
import com.bytedance.apm.ApmAgent;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.Subject;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/brandmall/HybridTabKitFragment;", "Lcom/bytedance/android/shopping/store/tabkit/TabKitFragment;", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class HybridTabKitFragment extends TabKitFragment {
    public static WeakReference<Function2<String, WindowManager, Unit>> j;
    public static WeakReference<Function1<String, Unit>> k;
    public final IECUGHostService i;

    public static final class a {
    }

    public static final class b implements Observer<z> {
        public final /* synthetic */ HybridTabKitFragment a;

        public final void onComplete() {
        }

        public final void onSubscribe(Disposable r2) {
            Intrinsics.checkNotNullParameter(r2, "disposable");
        }

        public b(HybridTabKitFragment r1) {
            this.a = r1;
        }

        public final void onError(Throwable r3) {
            Intrinsics.checkNotNullParameter(r3, "error");
            TabKitViewModel r4 = this.a.d;
            if (r4 == null) goto L7;
            MutableLiveData<Integer> r5 = r4.getLoadStatus();
            if (r5 == null) goto L7;
            r5.setValue(0);
        L7:
            TabKitViewModel r6 = this.a.d;
            if (r6 == null) goto L13;
            ok3.a r7 = r6.getTabKitMonitor();
            if (r7 == null) goto L14;
            Map<Long, TabkitFirstFramePref> r0 = ok3.a.e;
            r7.e(2, null, null);
            return;
        L14:
            return;
        }

        public final void onNext(Object r7) {
            z r8 = (z) r7;
            Intrinsics.checkNotNullParameter(r8, "resp");
            if (r8.j() != null) goto L9;
            TabKitViewModel r9 = this.a.d;
            if (r9 == null) goto L42;
            MutableLiveData<Integer> r10 = r9.getLoadStatus();
            if (r10 == null) goto L52;
            r10.setValue(0);
            return;
        L52:
            return;
        L42:
            return;
        L9:
            this.a.ay(false);
            TabKitViewModel r1 = this.a.d;
            if (r1 == null) goto L12;
            r1.notifyLandingFinished();
        L12:
            TabKitViewModel r2 = this.a.d;
            if (r2 == null) goto L15;
            r2.notifyPageLandingFinished();
        L15:
            TabKitViewModel r3 = this.a.d;
            if (r3 == null) goto L18;
            r3.setTabKitData(r8);
        L18:
            Map<String, Long> r4 = TabkitPrefetch.a;
            Intrinsics.checkNotNullParameter(r8, "resp");
            Integer r0 = r8.a();
            List<k> r11 = r8.j();
            if (r11 == null) goto L54;
            Iterator<T> r12 = r11.iterator();
        L22:
            if (r12.hasNext() == false) goto L55;
            k r5 = (k) r12.next();
            if ((!Intrinsics.areEqual(r5.n(), r0)) == false) goto L30;
            s r6 = r5.f();
            if (r6 == null) goto L28;
            String r13 = r6.b();
        L29:
            ECLiveHybridUtil.l(r13, true);
            goto L30
        L28:
            r13 = null;
        L30:
            List<k> r14 = r5.m();
            if (r14 == null) goto L22;
            Iterator<T> r15 = r14.iterator();
        L34:
            if (r15.hasNext() == false) goto L22;
            if ((!Intrinsics.areEqual(((k) r15.next()).n(), r0)) == false) goto L34;
            s r16 = r5.f();
            if (r16 == null) goto L40;
            String r17 = r16.b();
        L41:
            ECLiveHybridUtil.l(r17, true);
            goto L34
        L40:
            r17 = null;
            goto L41
        L55:
            return;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ HybridTabKitFragment a;

        public c(HybridTabKitFragment r1) {
            this.a = r1;
        }

        public final void a() {
            WeakReference<Function2<String, WindowManager, Unit>> r0 = HybridTabKitFragment.j;
            WeakReference<Function2<String, WindowManager, Unit>> r1 = HybridTabKitFragment.j;
            if (r1 == null) goto L17;
            Function2<String, WindowManager, Unit> r2 = r1.get();
            if (r2 == null) goto L18;
            Bundle r3 = this.a.getArguments();
            if (r3 == null) goto L10;
            String r4 = r3.getString("fraction_listener_id");
            if (r4 == null) goto L10;
        L11:
            FragmentActivity r5 = this.a.getActivity();
            if (r5 == null) goto L14;
            WindowManager r6 = r5.getWindowManager();
        L15:
            Unit r7 = (Unit) r2.invoke(r4, r6);
            return;
        L14:
            r6 = null;
        L10:
            r4 = "topTabMall";
            goto L11
        L18:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ HybridTabKitFragment a;

        public d(HybridTabKitFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            HybridTabKitFragment r3 = this.a;
            WeakReference<Function2<String, WindowManager, Unit>> r0 = HybridTabKitFragment.j;
            r3.V90();
        }
    }

    static {
    }

    public abstract Observable<z> U90();

    public final void V90() {
        TabKitViewModel r0 = this.d;
        Subject r1 = null;
        Object r2 = null;
        if (r0 == null) goto L5;
        TabkitPrefetchJobKey r3 = r0.getTabkitPrefetchJobKey();
    L6:
        ConcurrentHashMap r4 = com.bytedance.android.ec.store.prefetch.a.a;
        PrefetchScene r5 = PrefetchScene.TABKIT;
        Intrinsics.checkNotNullParameter(r5, "scene");
        if (r3 == null) goto L18;
        ConcurrentHashMap r6 = com.bytedance.android.ec.store.prefetch.a.a;
        ConcurrentHashMap r7 = (ConcurrentHashMap) r6.get(r5);
        if (r7 != null) goto L13;
        r7 = new ConcurrentHashMap();
        r6.put(r5, r7);
    L13:
        Object r8 = r7.remove(r3);
        if ((r8 instanceof Subject) == false) goto L17;
        r2 = r8;
    L17:
        r1 = (Subject) r2;
    L18:
        if (r1 != null) goto L21;
        r1 = U90();
    L21:
        if (r1 == null) goto L28;
        Observable r9 = r1.subscribeOn(Schedulers.io());
        if (r9 == null) goto L29;
        Observable r10 = r9.observeOn(AndroidSchedulers.mainThread());
        if (r10 == null) goto L30;
        r10.subscribe(new b(this));
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public HybridTabKitFragment() {
        int r0 = ECSdk.a;
        IECHostService r1 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r1 == null) goto L5;
        IECUGHostService r2 = r1.getECUGHostService();
    L6:
        this.i = r2;
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.store.tabkit.TabKitFragment
    public void onDestroy() {
        super.onDestroy();
        WeakReference<Function1<String, Unit>> r0 = k;
        if (r0 == null) goto L12;
        Function1<String, Unit> r1 = r0.get();
        if (r1 == null) goto L12;
        Bundle r2 = getArguments();
        if (r2 == null) goto L10;
        String r3 = r2.getString("fraction_listener_id");
        if (r3 == null) goto L10;
    L11:
        Unit r4 = (Unit) r1.invoke(r3);
    L10:
        r3 = "topTabMall";
    L12:
        TabKitViewModel r5 = this.d;
        if (r5 == null) goto L22;
        TabKitRouterParams r6 = r5.getRouterParams();
        if (r6 == null) goto L23;
        String r7 = r6.getLifecycleListenerId();
        if (r7 == null) goto L24;
        ITabKitEventListener r8 = TabKitEventCenter.a(r7);
        if (r8 == null) goto L25;
        r8.onDestroy();
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    }

    public void onDestroyView() {
        super.onDestroyView();
        TabKitViewModel r0 = this.d;
        if (r0 == null) goto L8;
        ok3.a r1 = r0.getTabKitMonitor();
        if (r1 == null) goto L9;
        String r2 = r1.c.getRouterParams().getBizTag();
        q r3 = new q(MonitorScenes.EC_TABKIT_FPS_MONITOR, r2, null);
        Map r4 = com.bytedance.android.ec.core.monitor.c.a;
        Intrinsics.checkNotNullParameter(r3, "monitorSceneWrapper");
        ApmAgent.removePerfTag("e_commerce", r3.a);
        com.bytedance.android.ec.core.monitor.c.i(r3);
        return;
    L9:
        return;
    }

    public final void onPause() {
        super.onPause();
        TabKitViewModel r0 = this.d;
        if (r0 == null) goto L16;
        TabKitRouterParams r1 = r0.getRouterParams();
        if (r1 == null) goto L17;
        String r2 = r1.getDeeplinkBackScene();
        if (r2 == null) goto L18;
        View r3 = getView();
        if (r3 == null) goto L11;
        FrameLayout r4 = (FrameLayout) r3.findViewById(2131371218);
    L12:
        IECUGHostService r5 = this.i;
        if (r5 == null) goto L19;
        r5.removeDeeplinkBackView(r4, getActivity(), r2);
        return;
    L19:
        return;
    L11:
        r4 = null;
        goto L12
    L18:
        return;
    L17:
        return;
    }

    public final void onResume() {
        super.onResume();
        TabKitViewModel r0 = this.d;
        if (r0 == null) goto L16;
        TabKitRouterParams r1 = r0.getRouterParams();
        if (r1 == null) goto L17;
        String r2 = r1.getDeeplinkBackScene();
        if (r2 == null) goto L18;
        View r3 = getView();
        if (r3 == null) goto L11;
        FrameLayout r4 = (FrameLayout) r3.findViewById(2131371218);
    L12:
        IECUGHostService r5 = this.i;
        if (r5 == null) goto L19;
        r5.addDeeplinkBackView(r4, getActivity(), r2);
        return;
    L19:
        return;
    L11:
        r4 = null;
        goto L12
    L18:
        return;
    L17:
        return;
    }

    public static final void T90(HybridTabKitFragment r5) {
        TabKitViewModel r0 = r5.d;
        if (r0 == null) goto L8;
        MutableLiveData<Float> r1 = r0.getScreenOffsetFactor();
        if (r1 == null) goto L8;
        Float r2 = (Float) r1.getValue();
        if (r2 == null) goto L8;
    L9:
        float r3 = r2.floatValue();
        TabKitViewModel r4 = r5.d;
        if (r4 == null) goto L14;
        MutableLiveData<Boolean> r6 = r4.isUseNativeTopBar();
        if (r6 == null) goto L14;
        Boolean r7 = (Boolean) r6.getValue();
    L15:
        int r8 = 0;
        if (Intrinsics.areEqual(r7, Boolean.TRUE) == false) goto L23;
        float r9 = UIUtils.getStatusBarHeight(r5.getContext()) * r3;
        TabKitViewModel r10 = r5.d;
        if (r10 != null) goto L20;
    L22:
        r8 = (int) (r9 + (r8 * (1 - r3)));
        goto L23
    L20:
        if (r10.getCanShowSwipeIndicator() != true) goto L22;
        r8 = com.bytedance.android.shopping.extensions.b.b(13);
    L23:
        View r11 = r5.f.m;
        if (r11 == null) goto L26;
        r11.setPadding(r11.getPaddingLeft(), r8, r11.getPaddingRight(), r11.getPaddingBottom());
    L26:
        MixTabLayout r12 = r5.f.h;
        if (r12 == null) goto L29;
        r12.setPadding(r12.getPaddingLeft(), r8, r12.getPaddingRight(), r12.getPaddingBottom());
    L29:
        View r13 = r5.getView();
        if (r13 == null) goto L33;
        r13.requestLayout();
        return;
    L33:
        return;
    L14:
        r7 = null;
    L8:
        r2 = Float.valueOf(0.0f);
        goto L9
    }

    @Override // com.bytedance.android.shopping.store.tabkit.TabKitFragment
    public void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        TabKitViewModel r9 = this.d;
        if (r9 == null) goto L15;
        TabKitRouterParams r10 = r9.getRouterParams();
        if (r10 == null) goto L15;
        String r11 = r10.getLifecycleListenerId();
        if (r11 == null) goto L15;
        ITabKitEventListener r12 = TabKitEventCenter.a(r11);
        if (r12 == null) goto L15;
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L13;
        WindowManager r2 = r1.getWindowManager();
    L14:
        r12.onShow(r2);
        goto L15
    L13:
        r2 = null;
    L15:
        r7.post(new c(this));
        TabKitViewModel r13 = this.d;
        if (r13 == null) goto L32;
        TabKitRouterParams r3 = r13.getRouterParams();
        if (r3 == null) goto L30;
        String r4 = r3.getPassThroughMarketingInfo();
        if (r4 == null) goto L30;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L28
        Map r6 = z1.k(new JSONObject(r4));     // Catch: Throwable -> L28
        FrameLayout r14 = (FrameLayout) r7.findViewById(2131371218);     // Catch: Throwable -> L28
        IMarketingServiceV2 r15 = ECMarketingSDK.c();     // Catch: Throwable -> L28
        if (r15 == null) goto L30;
        com.bytedance.android.marketing.sdk.api.c r16 = new com.bytedance.android.marketing.sdk.api.c(null, this, 1);     // Catch: Throwable -> L28
        Map r17 = MapsKt.toMutableMap(r6);     // Catch: Throwable -> L28
        Intrinsics.checkNotNullParameter(r17, "<set-?>");     // Catch: Throwable -> L28
        r16.l = r17;     // Catch: Throwable -> L28
        if (r14 == null) goto L26;
        Intrinsics.checkNotNullParameter(r14, "container");     // Catch: Throwable -> L28
        r16.b = r14;     // Catch: Throwable -> L28
    L26:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L28
        String r19 = r15.e(r16, null);     // Catch: Throwable -> L28
    L31:
        r13.setMarketingPageId(r19);
    L28:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        Result.box-impl(Result.constructor-impl(ResultKt.createFailure(th)));
    L30:
        r19 = null;
    L32:
        View r21 = r7.findViewById(2131387440);
        if (r21 == null) goto L35;
        r21.setOnClickListener(new d(this));
    L35:
        V90();
        TabKitViewModel r22 = this.d;
        if (r22 == null) goto L40;
        MutableLiveData<Float> r23 = r22.getScreenOffsetFactor();
        if (r23 == null) goto L40;
        r23.observe(getViewLifecycleOwner(), new AnonymousClass4(this));
    L40:
        TabKitViewModel r24 = this.d;
        if (r24 == null) goto L45;
        MutableLiveData<Boolean> r25 = r24.isUseNativeTopBar();
        if (r25 == null) goto L45;
        r25.observe(getViewLifecycleOwner(), new AnonymousClass5(this));
    L45:
        TabKitViewModel r26 = this.d;
        if (r26 == null) goto L50;
        MutableLiveData<Integer> r27 = r26.getScreenState();
        if (r27 == null) goto L50;
        r27.observe(getViewLifecycleOwner(), new AnonymousClass6(this));
    L50:
        MixTabLayout r28 = this.f.h;
        if (r28 == null) goto L55;
        ECTabLayout r29 = r28.getNativeTabLayout();
        if (r29 == null) goto L55;
        r29.setIndicatorBottomMargin(com.bytedance.android.shopping.extensions.b.b(3));
    L55:
        MixTabLayout r30 = this.f.h;
        if (r30 == null) goto L60;
        ECTabLayout r31 = r30.getNativeTabLayout();
        if (r31 == null) goto L60;
        r31.setIndicatorBottomMargin(com.bytedance.android.shopping.extensions.b.b(3));
    L60:
        TabKitViewModel r32 = this.d;
        if (r32 == null) goto L68;
        ok3.a r33 = r32.getTabKitMonitor();
        if (r33 == null) goto L69;
        q r34 = new q(MonitorScenes.EC_TABKIT_FPS_MONITOR, r33.c.getRouterParams().getBizTag(), null);
        Map r35 = com.bytedance.android.ec.core.monitor.c.a;
        Intrinsics.checkNotNullParameter(r34, "monitorSceneWrapper");
        ApmAgent.addPerfTag("e_commerce", r34.a);
        com.bytedance.android.ec.core.monitor.c.g(r34);
        return;
    L69:
        return;
    }
}
