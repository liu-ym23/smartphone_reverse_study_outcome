package com.bytedance.android.shopping.deepfeed.ui.vh;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.shopping.deepfeed.data.DeepFeedQueryParam;
import com.bytedance.android.shopping.deepfeed.data.api.DeepFeedImpressionApi;
import com.bytedance.android.shopping.deepfeed.viewmodel.DeepFeedProductViewModel;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.bytedance.jedi.ext.adapter.JediSimpleViewHolder;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import he3.e1;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/ui/vh/AbsDeepFeedProductVH;", "Lcom/bytedance/jedi/ext/adapter/JediSimpleViewHolder;", "Lcom/bytedance/android/shopping/infeed/data/idl/InFeedProductV2;", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsDeepFeedProductVH extends JediSimpleViewHolder<InFeedProductV2> {
    public String A;
    public String B;
    public String C;
    public String D;
    public JSONArray E;
    public Long F;
    public boolean G;
    public boolean H;
    public boolean I;
    public com.bytedance.android.shopping.deepfeed.ui.vh.d J;
    public final b K;
    public final f L;
    public Function0<Unit> M;
    public final LifecycleOwner N;
    public final View O;
    public final com.bytedance.android.shopping.deepfeed.action.h P;
    public final Lazy l;
    public InFeedProductV2 m;
    public final List<String> n;
    public boolean o;
    public final Handler p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public String z;

    public static final class a {
    }

    public static final class b implements ti.j {
        public final /* synthetic */ AbsDeepFeedProductVH a;

        public b(AbsDeepFeedProductVH r1) {
            this.a = r1;
        }

        public final void a(JSONObject r5) {
            Intrinsics.checkNotNullParameter(r5, "params");
            JSONObject r0 = com.bytedance.android.shopping.extensions.k.w(r5.optString("response", "{}"));
            String r1 = null;
            if (r0 == null) goto L5;
            Integer r2 = Integer.valueOf(r0.optInt("status_code", -1));
        L7:
            if (r0 == null) goto L10;
            r1 = r0.optString("status_msg", "");
        L10:
            if (r2 != null) goto L13;
        L17:
            AbsDeepFeedProductVH r6 = this.a;
            if (r6.o == false) goto L32;
            com.bytedance.android.ec.sdk.helper.i r3 = com.bytedance.android.ec.sdk.helper.i.a;
            Context r7 = ((RecyclerView.ViewHolder) r6).itemView.getContext();
            if (r1 != null) goto L22;
        L25:
            boolean r4 = true;
        L26:
            if (r4 == false) goto L28;
            r1 = "当前商品无法加购";
        L28:
            r3.e(r7, r1, false, false);
            return;
        L22:
            if (r1.length() == 0) goto L25;
            r4 = false;
            goto L26
        L32:
            return;
        L13:
            if (r2.intValue() != 0) goto L17;
            if (Intrinsics.areEqual(r5.optString("sku_session_id", ""), this.a.C) == false) goto L30;
            com.bytedance.android.ec.sdk.helper.i.a.e(((RecyclerView.ViewHolder) this.a).itemView.getContext(), "添加成功，在购物车等你", false, false);
            tc3.f.b();
            return;
        L30:
            return;
        L5:
            r2 = null;
            goto L7
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            CommerceBaseResponse r2 = (CommerceBaseResponse) r1;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ Runnable a;

        public e(Runnable r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements ti.j {
        public final /* synthetic */ AbsDeepFeedProductVH a;

        public f(AbsDeepFeedProductVH r1) {
            this.a = r1;
        }

        public final void a(JSONObject r5) {
            Intrinsics.checkNotNullParameter(r5, "params");
            String r0 = r5.optString("sku_session_id", "");
            if (Intrinsics.areEqual(r0, this.a.C) == false) goto L5;
        L6:
            AbsDeepFeedProductVH r1 = this.a;
            r1.E = r5.optJSONArray("select_spec_ids");
            AbsDeepFeedProductVH r2 = this.a;
            r2.F = Long.valueOf(r5.optLong("combo_num", 1));
            return;
        L5:
            if (Intrinsics.areEqual(r0, this.a.D) == true) goto L6;
        }
    }

    static {
    }

    public abstract void c4(int r1);

    public abstract void d4();

    public abstract void e4();

    public abstract void f4();

    public abstract void g4();

    public abstract boolean l4();

    public boolean m4() {
        return false;
    }

    public void s4(String r2) {
        Intrinsics.checkNotNullParameter(r2, "finishMethod");
    }

    public abstract void u4(boolean r1);

    public abstract void v4();

    @Deprecated(message = "在 slice 场景不需要这个方法了")
    public abstract void w4(int r1);

    public abstract void y4(he3.l r1, com.bytedance.android.shopping.deepfeed.action.h r2);

    public final DeepFeedProductViewModel i4() {
        return (DeepFeedProductViewModel) this.l.getValue();
    L5:
        return new DeepFeedProductViewModel();
    }

    public final void j4() {
        uc3.e r0 = new uc3.e(0);
        InFeedProductV2 r2 = this.m;
        String r3 = null;
        if (r2 == null) goto L7;
        e1 r4 = com.bytedance.android.shopping.deepfeed.utlis.a.a(r2);
        if (r4 == null) goto L7;
        String r5 = r4.a();
    L8:
        r0.a(r5);
        r0.b(2);
        ArrayList r6 = new ArrayList();
        ListProtector.add(r6, 0, r0);
        InFeedProductV2 r1 = this.m;
        if (r1 == null) goto L23;
        e1 r7 = com.bytedance.android.shopping.deepfeed.utlis.a.a(r1);
        if (r7 == null) goto L23;
        String r8 = r7.c();
        if (r8 == null) goto L23;
        if (com.bytedance.android.shopping.extensions.k.c(r8) != true) goto L23;
        uc3.e r9 = new uc3.e(0);
        InFeedProductV2 r10 = this.m;
        if (r10 == null) goto L21;
        e1 r11 = com.bytedance.android.shopping.deepfeed.utlis.a.a(r10);
        if (r11 == null) goto L21;
        String r12 = r11.c();
    L22:
        r9.a(r12);
        r9.b(1);
        ListProtector.add(r6, 0, r9);
    L21:
        r12 = null;
    L23:
        DeepFeedImpressionApi.a.getClass();
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L32
        DeepFeedImpressionApi r14 = (DeepFeedImpressionApi) com.bytedance.android.ec.sdk.helper.n.a.create("https://ecom.snssdk.com", DeepFeedImpressionApi.class);     // Catch: Throwable -> L32
        if (r14 != null) goto L30;
        int r15 = com.bytedance.android.shopping.monitor.b.a;     // Catch: Throwable -> L32
        Intrinsics.checkNotNullParameter("deep_feed_impression_api", "apiName");     // Catch: Throwable -> L32
        int r16 = com.bytedance.android.ec.core.monitor.d.a;     // Catch: Throwable -> L32
        HashMap r17 = new HashMap();     // Catch: Throwable -> L32
        r17.put("api_name", "deep_feed_impression_api");     // Catch: Throwable -> L32
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L32
        Intrinsics.checkNotNullParameter("mall_api_init_failed", "event");     // Catch: Throwable -> L32
        Intrinsics.checkNotNullParameter(r17, "params");     // Catch: Throwable -> L32
        if (com.bytedance.android.ec.core.opt.ab.t.a() != 1) goto L30;
        com.bytedance.android.ec.core.monitor.d.f("mall_api_init_failed");     // Catch: Throwable -> L32
        com.bytedance.android.ec.core.monitor.d.e("mall_api_init_failed", r17);     // Catch: Throwable -> L32
    L30:
        Object r19 = Result.constructor-impl(r14);     // Catch: Throwable -> L32
    L35:
        if (Result.isFailure-impl(r19) == false) goto L37;
        r19 = null;
    L37:
        DeepFeedImpressionApi r20 = (DeepFeedImpressionApi) r19;
        if (r20 == null) goto L54;
        DeepFeedQueryParam r21 = i4().getFeedParam();
        if (r21 == null) goto L42;
        String r22 = r21.getBizCode();
    L43:
        DeepFeedQueryParam r23 = i4().getFeedParam();
        if (r23 == null) goto L46;
        r3 = r23.getSceneCode();
    L46:
        Single<CommerceBaseResponse> r24 = r20.impressionReport(new uc3.d(new uc3.b(r22, r3), r6));
        if (r24 == null) goto L55;
        Single r25 = bg4.b.c(r24);
        if (r25 == null) goto L56;
        r25.subscribe(c.a, d.a);
        return;
    L56:
        return;
    L55:
        return;
    L42:
        r22 = null;
        goto L43
    L54:
        return;
    L32:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r5 = null;
        goto L8
    }

    public final void onPause() {
        if (this.H == false) goto L6;
        this.H = false;
        ECLiveHybridUtil.p("ecom.sku.add.cart", this.K);
    L6:
        if (this.I == false) goto L9;
        this.I = false;
        ECLiveHybridUtil.p("ecom.sku.spec.change", this.L);
        return;
    }

    public void onResume() {
        if (this.H == false) goto L5;
        this.H = false;
        ECLiveHybridUtil.p("ecom.sku.add.cart", this.K);
    L5:
        this.H = true;
        ECLiveHybridUtil.m("ecom.sku.add.cart", this.K);
        if (this.I == false) goto L8;
        this.I = false;
        ECLiveHybridUtil.p("ecom.sku.spec.change", this.L);
    L8:
        this.I = true;
        ECLiveHybridUtil.m("ecom.sku.spec.change", this.L);
    }

    public void q4() {
        if (this.N.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        com.bytedance.android.shopping.deepfeed.ui.vh.d r0 = this.J;
        if (r0 == null) goto L9;
        i4().removeCouponListener(r0);
        return;
    }

    public final boolean k4() {
        if (getAdapterPosition() < i4().curNoFullScreenCount()) goto L5;
        return true;
    L5:
        return false;
    }

    public final void r4() {
        com.bytedance.android.shopping.deepfeed.data.repo.l r0 = i4().getResp();
        if (r0 == null) goto L14;
        uc3.f r1 = r0.g();
        long r2 = System.currentTimeMillis();
        if (getAdapterPosition() != 0) goto L10;
        if (((InFeedProductV2) getItem()).isCacheData() == false) goto L10;
        ((com.bytedance.android.shopping.deepfeed.data.repo.j) r1).l = r2;
        return;
    L10:
        if (getAdapterPosition() != 0) goto L12;
        ((com.bytedance.android.shopping.deepfeed.data.repo.j) r1).m = r2;
        return;
    L12:
        ((com.bytedance.android.shopping.deepfeed.data.repo.j) r1).n = r2;
        return;
    }

    public static String h4(String r5) {
        Intrinsics.checkNotNullParameter(r5, "link");
        JSONObject r0 = com.bytedance.android.shopping.extensions.k.w(UriProtector.getQueryParameter(UriProtector.parse(r5), "client_params"));
        String r1 = "";
        if (r0 == null) goto L5;
        String r2 = r0.optString("sku_session_id", "");
    L6:
        if (r2 == null) goto L10;
        r1 = r2;
    L10:
        if (r1.length() != 0) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == true) goto L15;
    L18:
        return r1;
    L15:
        if (StringsKt.startsWith$default(r5, "sslocal://buy_now", false, 2, null) == false) goto L18;
        return UUID.randomUUID().toString();
    L12:
        r3 = false;
        goto L13
    L5:
        r2 = null;
        goto L6
    }

    public void n4(boolean r2) {
        com.bytedance.android.shopping.deepfeed.utlis.f.b = r2;
        com.bytedance.android.shopping.deepfeed.utlis.f.d = Boolean.valueOf(r2);
        int r3 = tc3.f.a;
        Integer r4 = tc3.a.a().l();
        if (r4 != null) goto L6;
    L8:
        boolean r5 = false;
    L9:
        if (r5 == false) goto L12;
        int r6 = ed3.b.a;
        Intrinsics.checkNotNullParameter("deep_feed_manual_mute_status", "key");
        return;
    L12:
        return;
    L6:
        if (r4.intValue() != 2) goto L8;
        r5 = true;
        goto L9
    }

    public final void t4(Runnable r3) {
        Intrinsics.checkNotNullParameter(r3, "runnable");
        ((RecyclerView.ViewHolder) this).itemView.post(new e(r3));
    }

    public AbsDeepFeedProductVH(LifecycleOwner r2, View r3, com.bytedance.android.shopping.deepfeed.action.h r4) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "vhView");
        Intrinsics.checkNotNullParameter(r4, "deepFeedContext");
        super(r3);
        this.N = r2;
        this.O = r3;
        this.P = r4;
        final KClass r5 = Reflection.getOrCreateKotlinClass(DeepFeedProductViewModel.class);
        this.l = LazyKt.lazy(new AbsDeepFeedProductVH$$special$$inlined$hostViewModel$1(this, r5, r5));
        this.n = new ArrayList();
        this.p = new Handler(Looper.getMainLooper());
        this.C = "";
        this.D = "";
        this.K = new b(this);
        this.L = new f(this);
    }
}
