package com.bytedance.android.shopping.store.home;

import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0002H\u0007J\b\u0010\u0006\u001a\u00020\u0002H\u0007J\b\u0010\u0007\u001a\u00020\u0002H\u0007J\b\u0010\b\u001a\u00020\u0002H\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/store/home/StoreLifeCycleObserver;", "Landroidx/lifecycle/LifecycleObserver;", "", "onCreate", "onStart", "onResume", "onPause", "onStop", "onDestroy", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StoreLifeCycleObserver implements LifecycleObserver {
    public final DialogFragment a;
    public final FrameLayout b;
    public final ECStoreViewModel c;

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        if (com.bytedance.android.ec.store.utils.c.b.size() <= 0) goto L5;
        List r0 = com.bytedance.android.ec.store.utils.c.a;
        ArrayList r1 = (ArrayList) r0;
        r1.add(com.bytedance.android.ec.store.utils.c.b);
    L5:
        com.bytedance.android.ec.store.utils.c.b = new ArrayList();
        Lazy r2 = ECAppInfoService.a;
        if (we.a.a == true) goto L9;
        int r3 = im.k.a;
        im.a.a(null);
        im.k.a();
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        DialogFragment r0 = this.a;
        if (r0 == null) goto L10;
        int r1 = ECSdk.a;
        IAdapterService r2 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r2 == null) goto L10;
        com.bytedance.android.ec.adapter.api.e r3 = r2.getFragmentDispatcher();
        if (r3 == null) goto L10;
        r3.onDestroy(r0);
    L10:
        if (com.bytedance.android.ec.store.utils.c.b.size() <= 0) goto L12;
        ((ArrayList) com.bytedance.android.ec.store.utils.c.a).add(com.bytedance.android.ec.store.utils.c.b);
    L12:
        List r4 = com.bytedance.android.ec.store.utils.c.a;
        ArrayList r5 = (ArrayList) r4;
        if (r5.size() <= 0) goto L18;
        if (com.bytedance.android.ec.store.utils.c.b.size() <= 0) goto L18;
        ListProtector.remove(r4, r5.size() - 1);
    L18:
        if (r5.size() <= 0) goto L21;
        com.bytedance.android.ec.store.utils.c.b = (List) ListProtector.get(r4, r5.size() - 1);
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        DialogFragment r0 = this.a;
        if (r0 == null) goto L9;
        int r1 = ECSdk.a;
        IAdapterService r2 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r2 == null) goto L9;
        com.bytedance.android.ec.adapter.api.e r3 = r2.getFragmentDispatcher();
        if (r3 == null) goto L9;
        r3.onPause(r0, this.b);
    L9:
        int r4 = mh.a.a;
        if (com.bytedance.android.ec.core.opt.ab.c.a() != 3) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == false) goto L15;
        mh.a.a();
    L15:
        String r6 = this.c.getStoreParam().getEntranceInfo();
        Disposable r7 = com.bytedance.android.shopping.store.utils.b.a;
        if (r6 != null) goto L36;
        return;
    L36:
        JSONObject r8 = new JSONObject(r6).optJSONObject("light_mission_detail");     // Catch: JSONException -> L21
    L23:
        if (r8 == null) goto L39;
        g33.b r9 = g33.b.b;
        s83.c r10 = r9.D();
        if (r10 == null) goto L28;
        r10.c();
    L28:
        s83.c r11 = r9.D();
        if (r11 == null) goto L31;
        r11.d();
    L31:
        Disposable r12 = com.bytedance.android.shopping.store.utils.b.a;
        if (r12 == null) goto L34;
        r12.dispose();
    L34:
        com.bytedance.android.shopping.store.utils.b.a = null;
        return;
    L39:
        return;
    L21:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r8 = null;
        goto L23
    L12:
        r5 = false;
        goto L13
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        DialogFragment r0 = this.a;
        if (r0 == null) goto L9;
        int r1 = ECSdk.a;
        IAdapterService r2 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r2 == null) goto L9;
        com.bytedance.android.ec.adapter.api.e r3 = r2.getFragmentDispatcher();
        if (r3 == null) goto L9;
        r3.onResume(r0, this.b);
    L9:
        int r4 = mh.a.a;
        int r5 = 0;
        if (com.bytedance.android.ec.core.opt.ab.c.a() != 3) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == false) goto L15;
        mh.a.b();
    L15:
        String r7 = this.c.getStoreParam().getEntranceInfo();
        String r8 = this.c.getStoreParam().getSecShopId();
        Disposable r9 = com.bytedance.android.shopping.store.utils.b.a;
        if (r7 == null) goto L54;
        if (r8 == null) goto L55;
        JSONObject r10 = new JSONObject(r7).optJSONObject("light_mission_detail");     // Catch: JSONException -> L22
    L24:
        JSONObject r11 = r10;
        if (r11 == null) goto L56;
        g33.b r12 = g33.b.b;
        s83.c r13 = r12.D();
        if (r13 == null) goto L30;
        r13.c();
    L30:
        s83.c r14 = r12.D();
        if (r14 == null) goto L33;
        r14.a();
    L33:
        JSONArray r15 = r11.optJSONArray("requirements");
        Ref.LongRef r16 = new Ref.LongRef();
        r16.element = 0;
        Ref.IntRef r17 = new Ref.IntRef();
        r17.element = 0;
        Ref.IntRef r18 = new Ref.IntRef();
        r18.element = 0;
        if (r15 == null) goto L42;
        int r19 = r15.length();
    L36:
        if (r5 >= r19) goto L42;
        JSONObject r110 = JSONArrayProtectorUtils.getJSONObject(r15, r5);
        if (Intrinsics.areEqual(r110.opt("type"), 508) == false) goto L40;
        r16.element = r110.optLong("id");
        r17.element = r110.optInt("update_type");
        r18.element = r110.optInt("duration", 15000);
    L40:
        r5 = r5 + 1;
    L42:
        if (r16.element != 0) goto L45;
        return;
    L45:
        if (com.bytedance.android.shopping.store.utils.b.a != null) goto L53;
        com.bytedance.android.shopping.store.utils.b.a = Observable.timer(r18.element, TimeUnit.MILLISECONDS).observeOn(Schedulers.io()).subscribe(new com.bytedance.android.shopping.store.utils.a(r16, r17, r18, r11, r8));
        return;
    L53:
        return;
    L56:
        return;
    L22:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r10 = null;
        goto L24
    L55:
        return;
    L54:
        return;
    L12:
        r6 = false;
        goto L13
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onStart() {
        DialogFragment r0 = this.a;
        if (r0 == null) goto L10;
        int r1 = ECSdk.a;
        IAdapterService r2 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r2 == null) goto L11;
        com.bytedance.android.ec.adapter.api.e r3 = r2.getFragmentDispatcher();
        if (r3 == null) goto L12;
        r3.onStart(r0, this.b);
        return;
    L12:
        return;
    L11:
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        DialogFragment r0 = this.a;
        if (r0 == null) goto L10;
        int r1 = ECSdk.a;
        IAdapterService r2 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r2 == null) goto L11;
        com.bytedance.android.ec.adapter.api.e r3 = r2.getFragmentDispatcher();
        if (r3 == null) goto L12;
        r3.onStop(r0, this.b);
        return;
    L12:
        return;
    L11:
        return;
    }

    public StoreLifeCycleObserver(DialogFragment r2, FrameLayout r3, ECStoreViewModel r4) {
        Intrinsics.checkNotNullParameter(r3, "rootView");
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
