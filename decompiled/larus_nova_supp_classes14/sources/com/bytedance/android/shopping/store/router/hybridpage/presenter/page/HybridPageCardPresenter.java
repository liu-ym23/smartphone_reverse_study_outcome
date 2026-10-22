package com.bytedance.android.shopping.store.router.hybridpage.presenter.page;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.hybrid.bridge.LynxStatefulBridgeProxy;
import com.bytedance.android.ec.hybrid.card.api.ECLynxLoadParam;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.shopping.store.router.hybridpage.event.PageCardEventManager;
import com.bytedance.android.shopping.store.router.hybridpage.setting.HybridPageConfigSetting;
import com.bytedance.android.shopping.store.router.hybridpage.viewmodel.HybridPageViewModel;
import com.google.gson.Gson;
import com.lynx.tasm.LynxView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005J\b\u0010\u0004\u001a\u00020\u0003H\u0007¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/store/router/hybridpage/presenter/page/HybridPageCardPresenter;", "Lcom/ss/android/ugc/aweme/kiwi/presenter/QFragmentPresenter;", "Landroidx/lifecycle/LifecycleObserver;", "", "onResume", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class HybridPageCardPresenter extends QFragmentPresenter implements LifecycleObserver {
    public static final /* synthetic */ int m = 0;
    public ECLynxCard f;
    public ViewGroup g;
    public final Gson h;
    public boolean i;
    public final List<Function0<Unit>> j;
    public final Lazy k;
    public final HybridPageCardPresenter$pageCardEventListener$1 l;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ HybridPageCardPresenter a;

        public b(HybridPageCardPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r10) {
            JSONObject r11 = (JSONObject) r10;
            dm.a.b r1 = dm.a.a("HybridPageCardPresenter");
            StringBuilder r2 = new StringBuilder("configJson observed, template=");
            r2.append(this.a.i0());
            r2.append(", notNull=");
            if (r11 == null) goto L5;
            boolean r12 = true;
        L6:
            r2.append(r12);
            r1.i(r2.toString());
            final HybridPageCardPresenter r13 = this.a;
            String r3 = r13.j0().getPageCardUrl();
            if (r3 == null) goto L43;
            dm.a.b r0 = dm.a.a("HybridPageCardPresenter");
            StringBuilder r4 = new StringBuilder("initLynxCard, schema=");
            r4.append(r3);
            r4.append(", template=");
            r4.append(r13.i0());
            r4.append(", configJsonNotNull=");
            if (r13.j0().getConfigJson().getValue() == null) goto L12;
            boolean r5 = true;
        L13:
            r4.append(r5);
            r4.append(", routerQueryKeys=");
            Map<String, Object> r6 = r13.j0().getRouterQuery();
            View r7 = null;
            if (r6 == null) goto L16;
            Set<String> r8 = r6.keySet();
        L17:
            r4.append(r8);
            r4.append(", abParams=");
            r4.append(r13.h0());
            r0.i(r4.toString());
            View r9 = r13.a0();
            if (r9 == null) goto L46;
            r13.g = (ViewGroup) r9;
            FrameLayout r14 = new FrameLayout(r13.a0().getContext());
            r14.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            ViewGroup r15 = r13.g;
            if (r15 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("lynxContainer");
        L22:
            r15.addView(r14);
            r13.f = new ECLynxCard();
            ECLynxLoadParam.a r16 = new ECLynxLoadParam.a(r13.a0().getContext(), r3, r14);
            r16.j(2000);
            c r17 = new c(r13, r3);
            Intrinsics.checkNotNullParameter(r17, "lifecycle");
            r16.o = r17;
            r16.h(r13.j0().getSceneId());
            r16.d(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("hybridPage.bindSliceDataSource", new LynxStatefulBridgeProxy(new HybridPageCardPresenter$makeJsBridgeMap$1(r13), "hybridPage.bindSliceDataSource")), TuplesKt.to("hybridPage.getHybridListData", new LynxStatefulBridgeProxy(new HybridPageCardPresenter$makeJsBridgeMap$2(r13), "hybridPage.getHybridListData"))}));
            LinkedHashMap r18 = new LinkedHashMap();
            Map<String, Object> r19 = r13.j0().getRouterQuery();
            if (r19 != null) goto L25;
            r19 = new LinkedHashMap();
        L25:
            r18.put("router_query", r19);
            Object r20 = (JSONObject) r13.j0().getConfigJson().getValue();
            if (r20 != null) goto L28;
            r20 = new LinkedHashMap();
        L28:
            r18.put("page_config", r20);
            r18.put("ab_params", r13.h0());
            Unit r21 = Unit.INSTANCE;
            Intrinsics.checkNotNullParameter(r18, "ecGlobalProps");
            r16.p = r18;
            ECLynxLoadParam r22 = new ECLynxLoadParam(r16);
            ECLynxCard r23 = r13.f;
            if (r23 == null) goto L31;
            View r24 = r23.i();
        L33:
            if ((r24 instanceof LynxView) == false) goto L36;
            r7 = r24;
        L36:
            LynxView r25 = (LynxView) r7;
            if (r25 == null) goto L39;
            r25.addLynxViewClient(new com.bytedance.android.shopping.store.router.hybridpage.presenter.page.b());
        L39:
            ECLynxCard r110 = r13.f;
            if (r110 == null) goto L42;
            r110.j(r22);
        L42:
            r14.setVisibility(8);
            goto L43
        L31:
            r24 = null;
            goto L33
        L46:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        L16:
            r8 = null;
            goto L17
        L12:
            r5 = false;
        L43:
            this.a.k0();
            return;
        L5:
            r12 = false;
            goto L6
        }
    }

    static {
    }

    public abstract String i0();

    public final HybridPageViewModel j0() {
        return (HybridPageViewModel) this.k.getValue();
    }

    public void k0() {
    }

    public final void c0() {
        ReentrantReadWriteLock r0 = PageCardEventManager.a;
        PageCardEventManager.l(j0().getSceneId());
        String r1 = j0().getSceneId();
        HybridPageCardPresenter$pageCardEventListener$1 r2 = this.l;
        Intrinsics.checkNotNullParameter(r1, "sceneId");
        Intrinsics.checkNotNullParameter(r2, "listener");
        ReentrantReadWriteLock r3 = PageCardEventManager.a;
        ReentrantReadWriteLock.ReadLock r4 = r3.readLock();
        int r5 = 0;
        if (r3.getWriteHoldCount() != 0) goto L5;
        int r6 = r3.getReadHoldCount();
    L6:
        int r7 = 0;
    L7:
        if (r7 >= r6) goto L9;
        r4.unlock();
        r7 = r7 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r8 = r3.writeLock();
        r8.lock();
        Lazy r9 = PageCardEventManager.b;     // Catch: Throwable -> L16
        Set r10 = (Set) ((Map) r9.getValue()).get(r1);     // Catch: Throwable -> L16
        if (r10 == null) goto L18;
        r10.remove(r2);     // Catch: Throwable -> L16
        if (r10.isEmpty() == false) goto L18;
        ((Map) r9.getValue()).remove(r1);     // Catch: Throwable -> L16
    L18:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L16
    L19:
        if (r5 >= r6) goto L21;
        r4.lock();
        r5 = r5 + 1;
        goto L19
    L21:
        r8.unlock();
        return;
    L16:
        th = move-exception;
    L23:
        if (r5 >= r6) goto L25;
        r4.lock();
        r5 = r5 + 1;
        goto L23
    L25:
        r8.unlock();
        throw th;
    L5:
        r6 = 0;
        goto L6
    }

    public Map<String, Object> h0() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("ec_shop_search_result_hybrid_refactor", Integer.valueOf(((Number) HybridPageConfigSetting.c.getValue()).intValue()));
        return r0;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        ReentrantReadWriteLock r0 = PageCardEventManager.a;
        PageCardEventManager.k(j0().getSceneId(), false);
    }

    public HybridPageCardPresenter(final Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.h = new Gson();
        this.j = new ArrayList();
        this.k = LazyKt.lazy(new HybridPageCardPresenter$viewModel$2(this, r2));
        this.l = new HybridPageCardPresenter$pageCardEventListener$1(this);
    }

    public final void b0(QModel r8) {
        LifecycleOwner r9 = ((QFragmentPresenter) this).e;
        if (r9 != null) goto L6;
        r9 = ECQuickUtilKt.a(Y());
    L6:
        Lifecycle r10 = r9.getLifecycle();
        if (r10 == null) goto L9;
        r10.addObserver(this);
    L9:
        ReentrantReadWriteLock r11 = PageCardEventManager.a;
        String r12 = j0().getSceneId();
        HybridPageCardPresenter$pageCardEventListener$1 r0 = this.l;
        Intrinsics.checkNotNullParameter(r12, "sceneId");
        Intrinsics.checkNotNullParameter(r0, "listener");
        ReentrantReadWriteLock r1 = PageCardEventManager.a;
        ReentrantReadWriteLock.ReadLock r2 = r1.readLock();
        int r4 = 0;
        if (r1.getWriteHoldCount() != 0) goto L12;
        int r3 = r1.getReadHoldCount();
    L13:
        int r5 = 0;
    L14:
        if (r5 >= r3) goto L16;
        r2.unlock();
        r5 = r5 + 1;
        goto L14
    L16:
        ReentrantReadWriteLock.WriteLock r6 = r1.writeLock();
        r6.lock();
        Map r7 = (Map) PageCardEventManager.b.getValue();     // Catch: Throwable -> L26
        Object r13 = r7.get(r12);     // Catch: Throwable -> L26
        if (r13 != null) goto L20;
        r13 = new LinkedHashSet();     // Catch: Throwable -> L26
        r7.put(r12, r13);     // Catch: Throwable -> L26
    L20:
        ((Set) r13).add(r0);     // Catch: Throwable -> L26
        int r14 = 0;
    L22:
        if (r14 >= r3) goto L24;
        r2.lock();
        r14 = r14 + 1;
        goto L22
    L24:
        r6.unlock();
        j0().getConfigJson().a(((QFragmentPresenter) this).e, new b(this), false);
        ReentrantReadWriteLock r15 = PageCardEventManager.a;
        PageCardEventManager.k(j0().getSceneId(), true);
        return;
    L26:
        th = move-exception;
    L27:
        if (r4 >= r3) goto L29;
        r2.lock();
        r4 = r4 + 1;
        goto L27
    L29:
        r6.unlock();
        throw th;
    L12:
        r3 = 0;
        goto L13
    }

    public static final JSONObject d0(HybridPageCardPresenter r6, ECHybridListItemVO r7) {
        r6.getClass();
        JSONObject r0 = new JSONObject();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L32
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L32
        String r3 = r7.d;     // Catch: Throwable -> L32
        String r4 = "";
        if (r3 != null) goto L7;
        r3 = "";
    L7:
        r2.put("item_id", r3);     // Catch: Throwable -> L32
        Integer r5 = r7.c;     // Catch: Throwable -> L32
        int r8 = 0;
        if (r5 == null) goto L10;
        int r9 = r5.intValue();     // Catch: Throwable -> L32
    L11:
        r2.put("item_type", r9);     // Catch: Throwable -> L32
        String r10 = r7.g();     // Catch: Throwable -> L32
        if (r10 != null) goto L14;
        r10 = "";
    L14:
        r2.put("item_data", r10);     // Catch: Throwable -> L32
        Integer r11 = r7.i();     // Catch: Throwable -> L32
        if (r11 == null) goto L17;
        r8 = r11.intValue();     // Catch: Throwable -> L32
    L17:
        r2.put("span_size", r8);     // Catch: Throwable -> L32
        Gson r12 = r6.h;     // Catch: Throwable -> L32
        Object r13 = r12.fromJson(r12.toJson(r7.c()), Map.class);     // Catch: Throwable -> L32
        if ((r13 instanceof Map) == true) goto L20;
        r13 = null;
    L20:
        Object r14 = (Map) r13;     // Catch: Throwable -> L32
        if (r14 != null) goto L23;
        r14 = new LinkedHashMap();     // Catch: Throwable -> L32
    L23:
        r2.put("extra", r14);     // Catch: Throwable -> L32
        r2.put("item_operation_type", r7.p);     // Catch: Throwable -> L32
        String r15 = r7.r;     // Catch: Throwable -> L32
        if (r15 == null) goto L27;
        r4 = r15;
    L27:
        r2.put("section_id", r4);     // Catch: Throwable -> L32
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L30
        return r2;
    L30:
        th = th;
        r0 = r2;
    L33:
        Result.Companion r16 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return r0;
    L10:
        r9 = 0;
    L32:
        th = th;
        goto L33
    }

    public static final void e0(HybridPageCardPresenter r1, Function0 r2) {
        if (r1.i == false) goto L5;
        r2.invoke();
        return;
    L5:
        ((ArrayList) r1.j).add(r2);
    }
}
