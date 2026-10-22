package com.bytedance.android.shopping.mall;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.host.api.core.api.IECBulletService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.api.mall.p;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.tasm.LynxView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qf3.g;
import qf3.h;
import qf3.i;
import qf3.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/mall/LynxMallFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LynxMallFragment extends Fragment {
    public final String d;
    public FrameLayout e;
    public final String f;
    public final Map<String, Object> g;
    public final String h;
    public final Lazy i;
    public final Lazy j;
    public ti.d k;
    public final com.bytedance.android.shopping.mall.b l;
    public final List<p> m;
    public final h n;
    public LynxView o;

    public static final class a extends com.bytedance.android.shopping.mall.a {
        public final /* synthetic */ LynxMallFragment b;

        public a(LynxMallFragment r1) {
            this.b = r1;
        }

        @Override // com.bytedance.android.shopping.mall.a
        public final void onLoadSuccess(View r4) {
            int r0 = e.a;
            e.a(this.b.d, "on template load success");
            this.b.getClass();
            if ((r4 instanceof LynxView) == false) goto L5;
            this.b.o = (LynxView) r4;
        L5:
            LynxMallFragment r5 = this.b;
            r5.getClass();
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L18
            LynxView r6 = r5.o;     // Catch: Throwable -> L18
            Unit r2 = null;
            if (r6 == null) goto L9;
            View r7 = r6.findViewByName("list");     // Catch: Throwable -> L18
        L11:
            if ((r7 instanceof RecyclerView) == true) goto L14;
            r7 = null;
        L14:
            if (((RecyclerView) r7) == null) goto L16;
            r2 = Unit.INSTANCE;     // Catch: Throwable -> L18
        L16:
            Result.constructor-impl(r2);     // Catch: Throwable -> L18
        L20:
            this.b.S90(true, "");
            ti.d r8 = this.b.k;
            if (r8 == null) goto L32;
            int r3 = rf3.a.a;
            JSONObject r9 = new JSONObject();     // Catch: JSONException -> L25
            r9.put("visible", false);     // Catch: JSONException -> L25
            r8.a(r9);     // Catch: JSONException -> L25
            return;
        L25:
            e = move-exception;
            e.toString();
            return;
        L32:
            return;
        L9:
            r7 = null;
        L18:
            th = move-exception;
            Result.Companion r10 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L20
        }

        @Override // com.bytedance.android.shopping.mall.a
        public final void onFallback(int r5, String r6) {
            Intrinsics.checkNotNullParameter(r6, "errorMessage");
            int r0 = e.a;
            e.a(this.b.d, "onFallback errorCode=" + r5 + " errorMessage=" + r6);
            this.b.S90(false, "onFallback errorCode=" + r5 + " errorMessage=" + r6);
        }

        @Override // com.bytedance.android.shopping.mall.a
        public final void onLoadStart(View r2, final boolean r3) {
            int r4 = e.a;
            e.a(this.b.d, "on template load start");
            final d r5 = (d) this.b.j.getValue();
            r5.getClass();
            Function1<pi.b, Unit> r0 = new ECMallMonitor$reportTemplateLoadEvent$1(r5, r3);
            if (r5.a != null) goto L5;
            int r6 = ECSdk.a;
            r5.a = (pi.b) ECSdk.a(pi.b.class);
        L5:
            pi.b r7 = r5.a;
            if (r7 == null) goto L9;
            r0.invoke(r7);
            return;
        }

        @Override // com.bytedance.android.shopping.mall.a
        public final void onContainerError(View r3, int r4, String r5) {
            Intrinsics.checkNotNullParameter(r5, "errorMessage");
            int r6 = e.a;
            e.a(this.b.d, "onContainerError: msg" + r5);
            this.b.S90(false, "container error errorCode" + r4 + " msg=" + r5);
        }

        @Override // com.bytedance.android.shopping.mall.a
        public final void onLoadFail(View r4, String r5, String r6) {
            int r7 = e.a;
            String r8 = this.b.d;
            StringBuilder r0 = new StringBuilder("on template load failed url=");
            String r1 = "null";
            if (r5 != null) goto L5;
            r5 = "null";
        L5:
            r0.append(r5);
            r0.append(" reason=");
            if (r6 == null) goto L9;
            r1 = r6;
        L9:
            r0.append(r1);
            e.a(r8, r0.toString());
            this.b.getClass();
            final d r9 = (d) this.b.j.getValue();
            if (r6 != null) goto L12;
            final String r2 = "";
        L13:
            if (r6 != null) goto L15;
            final String r3 = "";
        L16:
            r9.getClass();
            Intrinsics.checkNotNullParameter(r2, "error");
            Intrinsics.checkNotNullParameter(r3, "errorDesc");
            Function1<pi.b, Unit> r10 = new ECMallMonitor$reportLynxErrorEvent$1(r9, r3, r2);
            if (r9.a != null) goto L19;
            int r11 = ECSdk.a;
            r9.a = (pi.b) ECSdk.a(pi.b.class);
        L19:
            pi.b r12 = r9.a;
            if (r12 == null) goto L22;
            r10.invoke(r12);
        L22:
            LynxMallFragment r13 = this.b;
            if (r6 != null) goto L25;
            r6 = "";
        L25:
            r13.S90(false, r6);
            return;
        L15:
            r3 = r6;
            goto L16
        L12:
            r2 = r6;
            goto L13
        }
    }

    public static final class b implements g {
        public final /* synthetic */ LynxMallFragment a;

        public b(LynxMallFragment r1) {
            this.a = r1;
        }

        @Override // qf3.g
        public final void a(j r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            Iterator r3 = ((ArrayList) this.a.m).iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            ((p) r3.next()).b();
            goto L4
        }
    }

    public LynxMallFragment() {
        this.d = kg.a.a("LynxMallFragment");
        this.f = "";
        this.g = new LinkedHashMap();
        this.h = "LynxMall";
        this.i = LazyKt.lazy(LynxMallFragment$fpsMonitor$2.INSTANCE);
        this.j = LazyKt.lazy(new LynxMallFragment$lynxMonitor$2(this));
        this.l = new com.bytedance.android.shopping.mall.b(new a(this));
        this.m = new ArrayList();
        this.n = new h(new b(this));
    }

    public final void onDestroy() {
        super.onDestroy();
        this.l.b = null;
        this.n.a = null;
        ti.d r0 = this.k;
        if (r0 == null) goto L6;
        r0.release();
        return;
    }

    public final void S90(boolean r1, String r2) {
        if (r1 == false) goto L7;
        Iterator r3 = ((ArrayList) this.m).iterator();
    L5:
        if (r3.hasNext() == false) goto L11;
        ((p) r3.next()).c();
        goto L5
    L11:
        return;
    L7:
        Iterator r4 = ((ArrayList) this.m).iterator();
    L9:
        if (r4.hasNext() == false) goto L14;
        ((p) r4.next()).a();
        goto L9
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, FreqActions.ACTION_VIEW);
        super.onViewCreated(r10, r11);
        int r12 = e.a;
        e.a(this.d, "tryLoadLynxTemplate url=" + this.f);
        if (this.f.length() <= 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L81;
        FrameLayout r14 = this.e;
        if (r14 == null) goto L95;
        r14.removeAllViews();
        ti.d r1 = this.k;
        if (r1 == null) goto L12;
        r1.release();
    L12:
        int r2 = ECSdk.a;
        IECBulletService r3 = (IECBulletService) ECSdk.a(IECBulletService.class);
        Unit r4 = null;
        if (r3 == null) goto L15;
        ti.d r5 = r3.createLiveAnnieComponent(r14.getContext(), this.f, this.l);
    L16:
        this.k = r5;
        if (r5 == null) goto L19;
        View r6 = r5.getHybridView();
    L20:
        String r7 = this.d;
        StringBuilder r8 = new StringBuilder("create hybrid card result service=");
        String r9 = "null";
        if (r3 != null) goto L23;
        r3 = "null";
    L23:
        r8.append(r3);
        r8.append(" annie component=");
        String r15 = this.k;
        if (r15 == null) goto L27;
        r9 = r15;
    L27:
        r8.append(r9);
        r8.append(" hybrid card=");
        r8.append(r6);
        e.a(r7, r8.toString());
        if (r6 != null) goto L84;
        S90(false, "cannot find HybridCard");
        return;
    L84:
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L31
        r14.addView(r6, new ViewGroup.LayoutParams(-1, -1));     // Catch: Throwable -> L31
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L31
    L33:
        Uri r17 = UriProtector.parse(this.f);
        String r18 = StringsKt.replace$default(this.f, "?" + r17.getQuery(), "", false, 4, null);
        int r19 = e.a;
        e.a(this.d, "load final url " + r18);
        ti.d r20 = this.k;
        if (r20 == null) goto L77;
        LinkedHashMap r21 = new LinkedHashMap();
        r21.put(SimilarProductParam.ENTER_FROM, this.h);
        r21.putAll(this.g);
        Context r22 = getContext();
        if (r22 == null) goto L38;
        SharedPreferences r23 = r22.getSharedPreferences("js_kv_methods_20191113", 0);
    L39:
        if (r23 == null) goto L76;
        ArrayList r24 = new ArrayList();
        Lazy r25 = ECSettingKeys.a;     // Catch: Throwable -> L65
        int r26 = com.bytedance.android.ec.core.opt.ab.p.a;     // Catch: Throwable -> L65
        Object r27 = "{}";
        jj4.b r28 = jj4.b.b;     // Catch: Throwable -> L46
        Object r110 = jj4.a.a("iesec_saas_mall_config", String.class, "{}", false);     // Catch: Throwable -> L46
        if (r110 != null) goto L52;
        Intrinsics.throwNpe();     // Catch: Throwable -> L46
    L52:
        JSONArray r111 = com.bytedance.commerce.base.json.b.a((String) r110).optJSONArray("tt_storage_keys");     // Catch: Throwable -> L65
        if (r111 == null) goto L63;
        Iterator r112 = ((ArrayList) com.bytedance.android.shopping.hybrid.a.a(r111)).iterator();     // Catch: Throwable -> L65
    L56:
        if (r112.hasNext() == false) goto L62;
        Object r29 = r112.next();     // Catch: Throwable -> L65
        if (r29 == null) goto L61;
        r24.add((String) r29);     // Catch: Throwable -> L65
        goto L56
    L61:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L65
    L62:
        r4 = Unit.INSTANCE;     // Catch: Throwable -> L65
    L63:
        Result.constructor-impl(r4);     // Catch: Throwable -> L65
    L67:
        LinkedHashMap r113 = new LinkedHashMap();
        Iterator r30 = r24.iterator();
    L69:
        if (r30.hasNext() == false) goto L74;
        String r31 = (String) r30.next();
        String r32 = r23.getString(r31, "");
        if (r32 == null) goto L69;
        r113.put(r31, r32);
        goto L69
    L74:
        if ((true ^ r113.isEmpty()) == false) goto L76;
        r21.put("storageInitData", r113);
    L46:
        th = move-exception;
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L65
        Object r114 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L65
        if (Result.isFailure-impl(r114) == true) goto L51;
        r27 = r114;
    L51:
        r110 = r27;
    L65:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L76:
        r20.load(r18, r21);
        goto L77
    L38:
        r23 = null;
    L77:
        ti.d r115 = this.k;
        if (r115 == null) goto L96;
        int r116 = qf3.f.a;
        h r117 = this.n;
        Intrinsics.checkNotNullParameter(r115, "component");
        Intrinsics.checkNotNullParameter(r117, "stateChangedHandler");
        r115.b(new i(r117));
        return;
    L96:
        return;
    L31:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L33
    L19:
        r6 = null;
        goto L20
    L15:
        r5 = null;
        goto L16
    L95:
        return;
    L81:
        S90(false, "lynx template url is null");
        return;
    L5:
        r13 = false;
        goto L6
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        FrameLayout r4 = new FrameLayout(r1.getContext());
        r4.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        Unit r5 = Unit.INSTANCE;
        this.e = r4;
        return r4;
    }
}
