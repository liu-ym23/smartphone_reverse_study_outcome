package com.bytedance.android.shopping.store.tabkit;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.ec.common.api.feedback.IECFeedbackService;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.store.tabkit.brandmall.HybridTabKitFragment;
import com.bytedance.android.shopping.store.tabkit.brandmall.TabKitApi;
import com.bytedance.android.shopping.store.tabkit.model.z;
import com.bytedance.android.shopping.store.tabkit.router.TabKitRouterParams;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/DefaultTabKitFragment;", "Lcom/bytedance/android/shopping/store/tabkit/brandmall/HybridTabKitFragment;", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DefaultTabKitFragment extends HybridTabKitFragment {
    public static final /* synthetic */ int n = 0;
    public final Handler l;
    public final b m;

    public static final class a {
        public static HashMap a(TabKitRouterParams r15) {
            Lazy r0 = ECSettingKeys.a;
            int r1 = p.a;
            Object r2 = "[\"anchor_tab_id\"]";
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
            jj4.b r4 = jj4.b.b;     // Catch: Throwable -> L7
            Object r5 = jj4.a.a("ec_tabkit_api_param_keys", String.class, "[\"anchor_tab_id\"]", false);     // Catch: Throwable -> L7
            if (r5 != null) goto L13;
            Intrinsics.throwNpe();     // Catch: Throwable -> L7
        L13:
            List r6 = CollectionsKt.toMutableList(StringsKt.split$default(StringsKt.replace$default(StringsKt.removeSurrounding((String) r5, "[", "]"), "\"", "", false, 4, null), new String[]{","}, false, 0, 6, null));
            if (r15 == null) goto L18;
            List<String> r7 = r15.getApiParamsKeyList();
            if (r7 == null) goto L18;
            r6.addAll(r7);
        L18:
            HashMap r8 = new HashMap();
            if (r15 == null) goto L23;
            HashMap<String, String> r9 = r15.getParamsMap();
            if (r9 == null) goto L23;
            r8.putAll(r9);
        L23:
            Iterator r10 = r8.entrySet().iterator();
        L25:
            if (r10.hasNext() == false) goto L29;
            if (r6.contains(((Map.Entry) r10.next()).getKey()) == true) goto L25;
            r10.remove();
            goto L25
        L29:
            if (r15 == null) goto L33;
            Map<String, Object> r16 = r15.getApiParams();
            if (r16 == null) goto L33;
            r8.putAll(r16);
        L33:
            return r8;
        L7:
            th = move-exception;
            Result.Companion r11 = Result.Companion;
            Object r12 = Result.constructor-impl(ResultKt.createFailure(th));
            if (Result.isFailure-impl(r12) == true) goto L12;
            r2 = r12;
        L12:
            r5 = r2;
            goto L13
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ DefaultTabKitFragment a;

        public b(DefaultTabKitFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r0 = ECSdk.a;     // Catch: Throwable -> L6
            IECFeedbackService r1 = (IECFeedbackService) ECSdk.a(IECFeedbackService.class);     // Catch: Throwable -> L6
            if (r1 == null) goto L9;
            r1.registerScreenCapture(this.a.getContext(), this.a);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.store.tabkit.brandmall.HybridTabKitFragment
    public final Observable<z> U90() {
        TabKitViewModel r0 = this.d;
        TabKitRouterParams r1 = null;
        if (r0 == null) goto L16;
        TabKitRouterParams r2 = r0.getRouterParams();
        if (r2 == null) goto L17;
        String r3 = r2.getApiUrl();
        if (r3 == null) goto L19;
        TabKitApi.a.getClass();
        TabKitApi r4 = TabKitApi.a.a;
        if (r4 == null) goto L18;
        TabKitViewModel r5 = this.d;
        if (r5 == null) goto L15;
        r1 = r5.getRouterParams();
    L15:
        return r4.fetchCustomTab(r3, a.a(r1));
    L18:
        return null;
    L19:
        return null;
    L17:
        return null;
    L16:
        return null;
    }

    public DefaultTabKitFragment() {
        this.l = new Handler(Looper.getMainLooper());
        this.m = new b(this);
    }

    @Override // com.bytedance.android.shopping.store.tabkit.brandmall.HybridTabKitFragment, com.bytedance.android.shopping.store.tabkit.TabKitFragment
    public final void onDestroy() {
        super.onDestroy();
        this.l.removeCallbacks(this.m);
    }

    @Override // com.bytedance.android.shopping.store.tabkit.brandmall.HybridTabKitFragment
    public final void onDestroyView() {
        super.onDestroyView();
        cl.d.a.getClass();
        cl.d r0 = cl.d.a.b();
        if (r0 == null) goto L6;
        r0.n();
        return;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.TabKitFragment
    public final void onAttach(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super.onAttach(r5);
        Bundle r6 = getArguments();
        if (r6 == null) goto L5;
        Serializable r7 = r6.getSerializable(TabKitRouterParams.KEY_ROUTER_PARAMS);
    L7:
        if ((r7 instanceof TabKitRouterParams) == true) goto L9;
        r7 = null;
    L9:
        TabKitRouterParams r8 = (TabKitRouterParams) r7;
        if (r8 != null) goto L13;
        r8 = new TabKitRouterParams();
    L13:
        if (new TabKitAbilityConfig(r8).b("btm_custom_page_v2") == true) goto L16;
        BtmHostDependManager r9 = BtmSDK.INSTANCE.getDepend();
        com.bytedance.android.btm.api.i r1 = new com.bytedance.android.btm.api.i(DefaultTabKitFragment.class, null, 2);
        r9.getClass();
        BtmHostDependManager.h(r1);
        return;
    L16:
        return;
    L5:
        r7 = null;
        goto L7
    }

    @Override // com.bytedance.android.shopping.store.tabkit.TabKitFragment
    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        this.l.postDelayed(this.m, 2000);
    }

    @Override // com.bytedance.android.shopping.store.tabkit.brandmall.HybridTabKitFragment, com.bytedance.android.shopping.store.tabkit.TabKitFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        TabKitViewModel r4 = this.d;
        String r5 = null;
        if (r4 == null) goto L7;
        TabKitRouterParams r6 = r4.getRouterParams();
        if (r6 == null) goto L7;
        String r7 = r6.getAnchorUrl();
    L8:
        if (r7 != null) goto L20;
        TabKitViewModel r8 = this.d;
        if (r8 == null) goto L14;
        TabKitRouterParams r9 = r8.getRouterParams();
        if (r9 == null) goto L14;
        r5 = r9.getApiUrl();
    L14:
        if (r5 != null) goto L20;
        TabKitViewModel r10 = this.d;
        if (r10 == null) goto L20;
        MutableLiveData<Integer> r11 = r10.getLoadStatus();
        if (r11 == null) goto L20;
        r11.setValue(0);
    L20:
        cl.d.a.getClass();
        cl.d r12 = cl.d.a.b();
        if (r12 == null) goto L24;
        r12.n();
        return;
    L24:
        return;
    L7:
        r7 = null;
        goto L8
    }
}
