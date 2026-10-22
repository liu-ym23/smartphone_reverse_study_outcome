package com.bytedance.android.shopping.mall.homepage.tools;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.View;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.hybrid.data.ECHybridDataEngine;
import com.bytedance.android.ec.hybrid.data.entity.ECHybridNetworkVO;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.ECHybridListItemType;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.ECSectionOperationType;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListItemAction;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.shopping.api.mall.IECMallHostService;
import com.bytedance.android.shopping.api.mall.model.BffBizInfo;
import com.bytedance.android.shopping.api.mall.model.HomePageBffDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallFavoriteSectionHelper implements zl.b {
    public static final Lazy I = null;
    public static final Lazy J = null;
    public static final a K = null;
    public String A;
    public final h93.a B;
    public List<com.bytedance.android.shopping.api.mall.common.tools.d> C;
    public Boolean D;
    public int E;
    public final int F;
    public final String G;
    public final Long H;
    public final Map<String, s<String>> a;
    public final Map<String, s<String>> b;
    public final WeakHashMap<String, a.C0109a> c;
    public final Map<String, Map<String, s<String>>> d;
    public final Map<String, LimitedCapacityMap<String, Long>> e;
    public final Map<Integer, com.bytedance.android.ec.hybrid.list.entity.i> f;
    public View g;
    public final SparseArray<List<com.bytedance.android.ec.hybrid.list.entity.i>> h;
    public final SparseArray<lf3.a> i;
    public final SparseIntArray j;
    public final SparseBooleanArray k;
    public final SparseBooleanArray l;
    public final Lazy m;
    public final Lazy n;
    public final v<Integer> o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final o<String> s;
    public int t;
    public String u;
    public String v;
    public ECHybridDataEngine w;
    public com.bytedance.android.shopping.mall.homepage.pagecard.d x;
    public int y;
    public String z;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.homepage.tools.ECMallFavoriteSectionHelper$a$a, reason: collision with other inner class name */
        public static final class C0109a {
            public final long a;
            public final int b;
            public final String c;

            public final boolean equals(Object r6) {
                if (this != r6) goto L4;
                return true;
            L4:
                if ((r6 instanceof C0109a) == false) goto L12;
                C0109a r7 = (C0109a) r6;
                if (this.a == r7.a) goto L8;
                return false;
            L8:
                if (this.b == r7.b) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.c, r7.c) == true) goto L19;
                return false;
            L19:
                return true;
            L12:
                return false;
            }

            public final int hashCode() {
                long r0 = this.a;
                int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31;
                String r2 = this.c;
                if (r2 == null) goto L5;
                int r3 = r2.hashCode();
            L7:
                return r1 + r3;
            L5:
                r3 = 0;
                goto L7
            }

            public final String toString() {
                return "FilterMonitorInfo(time=" + this.a + ", pageNum=" + this.b + ", logId1=" + this.c + ")";
            }

            public C0109a(long r2, int r4, String r5) {
                Intrinsics.checkNotNullParameter(r5, "logId1");
                this.a = r2;
                this.b = r4;
                this.c = r5;
            }
        }

        public a() {
        }

        public static aa3.b a() {
            return (aa3.b) ECMallFavoriteSectionHelper.J.getValue();
        }

        public static ECMallFavoriteSectionHelper b(String r2, Long r3) {
            Intrinsics.checkNotNullParameter(r2, "pageName");
            if (((List) ECMallFavoriteSectionHelper.I.getValue()).contains(r2) == false) goto L6;
            return new ECMallFavoriteSectionHelper(200, r2, r3);
        L6:
            return new ECMallFavoriteSectionHelper(50, r2, r3);
        }
    }

    public static final class b {
        public final long a;
        public final long b;

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof b) == false) goto L10;
            b r7 = (b) r6;
            if (this.a == r7.a) goto L8;
            return false;
        L8:
            if (this.b == r7.b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            long r3 = this.b;
            return r1 + ((int) (r3 ^ (r3 >>> 32)));
        }

        public final String toString() {
            return "TabLoadTiming(timing_net_start=" + this.a + ", timing_net_end=" + this.b + ")";
        }

        public b(long r1, long r3) {
            this.a = r1;
            this.b = r3;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ Set a;
        public final /* synthetic */ BffBizInfo b;
        public final /* synthetic */ ECMallFavoriteSectionHelper c;
        public final /* synthetic */ int d;

        public c(Set r1, BffBizInfo r2, ECMallFavoriteSectionHelper r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            ECMallFavoriteSectionHelper r0 = this.c;
            Set r1 = this.a;
            int r2 = this.d;
            String r3 = this.b.getRequestId();
            if (r3 != null) goto L5;
            r3 = "";
        L5:
            s r4 = (s) ((LinkedHashMap) r0.b).get("filters");
            if (r4 == null) goto L22;
            Map<K, Object> r5 = r4.snapshot();
            if (r5 == 0) goto L30;
            Iterator r6 = r1.iterator();
        L11:
            if (r6.hasNext() == false) goto L31;
            String r7 = (String) r6.next();
            if (r5.containsKey(r7) == false) goto L21;
            a.C0109a r8 = r0.c.get(r7);
            if (r8 == null) goto L21;
            long r9 = System.currentTimeMillis() - r8.a;
            int r10 = r2 - r8.b;
            String r11 = r8.c;
            Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L19
            JSONObject r13 = new JSONObject();     // Catch: Throwable -> L19
            r13.putOpt("session_id", r0.A);     // Catch: Throwable -> L19
            r13.putOpt("repeat_timestamp", Long.valueOf(r9));     // Catch: Throwable -> L19
            r13.putOpt("repeat_page_num_delta", Integer.valueOf(r10));     // Catch: Throwable -> L19
            r13.putOpt("res_version", r0.H);     // Catch: Throwable -> L19
            r13.putOpt(PdpOpenThirdParam.KEY_PAGE_NAME, r0.G);     // Catch: Throwable -> L19
            r13.putOpt("log_id1", r11);     // Catch: Throwable -> L19
            r13.putOpt("log_id2", r3);     // Catch: Throwable -> L19
            r13.putOpt("filter_id", r7);     // Catch: Throwable -> L19
            Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L19
            AppLogNewUtils.onEventV3("ies_ecommerce_client_gyl_repeat_error", r13);     // Catch: Throwable -> L19
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            Result.Companion r15 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        L21:
            a.C0109a r16 = new a.C0109a(System.currentTimeMillis(), r2, r3);
            r0.c.put(r7, r16);
            goto L11
        L31:
            return;
        L30:
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

    public final n r() {
        return (n) this.m.getValue();
    }

    public final s93.b t() {
        return (s93.b) this.q.getValue();
    }

    static {
        K = new a();
        I = LazyKt.lazy(ECMallFavoriteSectionHelper$Companion$filterSetting$2.INSTANCE);
        J = LazyKt.lazy(ECMallFavoriteSectionHelper$Companion$impressionConfig$2.INSTANCE);
    }

    public final Map<String, String> h() {
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r1 = ((LinkedHashMap) this.e).entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L43;
        Map.Entry r2 = (Map.Entry) r1.next();
        String r3 = (String) r2.getKey();
        LimitedCapacityMap r4 = (LimitedCapacityMap) r2.getValue();
        int r5 = r3.hashCode();
        Integer r6 = null;
        if (r5 == (-1019654232)) goto L14;
        if (r5 == 1585821867) goto L11;
    L16:
        Integer r7 = null;
    L17:
        if (r7 == null) goto L4;
        if (r7.intValue() <= 0) goto L21;
        boolean r8 = true;
    L22:
        if (r8 == false) goto L24;
        r6 = r7;
    L24:
        if (r6 == null) goto L4;
        int r9 = r6.intValue();
        LinkedHashMap r10 = new LinkedHashMap();
        Iterator r11 = r4.entrySet().iterator();
    L27:
        if (r11.hasNext() == false) goto L34;
        Map.Entry r12 = (Map.Entry) r11.next();
        if ((System.currentTimeMillis() - ((Number) r12.getValue()).longValue()) <= (r9 * 1000)) goto L31;
        boolean r13 = true;
    L32:
        if (r13 == false) goto L27;
        r10.put(r12.getKey(), r12.getValue());
        goto L27
    L31:
        r13 = false;
        goto L32
    L34:
        ArrayList r14 = new ArrayList(r10.size());
        Iterator r15 = r10.entrySet().iterator();
    L36:
        if (r15.hasNext() == false) goto L38;
        r14.add((String) ((Map.Entry) r15.next()).getKey());
        goto L36
    L38:
        Iterator r16 = r14.iterator();
    L40:
        if (r16.hasNext() == false) goto L42;
        r4.remove((String) r16.next());
        goto L40
    L42:
        r0.put(r3, CollectionsKt.joinToString$default(r4.entrySet(), ",", null, null, 0, null, ECMallFavoriteSectionHelper$collectExposureFilters$1$2$2.INSTANCE, 30, null));
        goto L4
    L21:
        r8 = false;
        goto L22
    L11:
        if (r3.equals("product_filters") == false) goto L16;
        K.getClass();
        r7 = a.a().d();
        goto L17
    L14:
        if (r3.equals("live_filters") == false) goto L16;
        K.getClass();
        r7 = a.a().b();
        goto L17
    L43:
        return r0;
    }

    public final Map<String, String> i() {
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r1 = ((LinkedHashMap) this.a).entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) r1.next();
        r0.put((String) r2.getKey(), CollectionsKt.joinToString$default(((s) r2.getValue()).snapshot().keySet(), ",", null, null, 0, null, null, 62, null));
        goto L4
    L6:
        ServiceManager r3 = ServiceManager.get();
        boolean r4 = false;
        if (r3 == null) goto L11;
        IECMallHostService r5 = (IECMallHostService) r3.getService(IECMallHostService.class);
        if (r5 == null) goto L11;
        boolean r6 = r5.hitSplitScreenAndFoldOpen();
    L12:
        if (r6 == false) goto L29;
        ReentrantLock r7 = zl.a.a;
        Integer r8 = (Integer) zl.a.d.peek();
        if (r8 == null) goto L20;
        int r9 = r8.intValue();
        zl.b r10 = (zl.b) zl.a.e.get(Integer.valueOf(r9));
        if (r10 == null) goto L19;
        Map r11 = r10.getFilters();
        if (r11 == null) goto L19;
    L21:
        String r12 = (String) r11.get("filters");
        if (r12 != null) goto L25;
        r12 = "";
    L25:
        if (r12.length() <= 0) goto L27;
        r4 = true;
    L27:
        if (r4 == false) goto L29;
        r0.put("filters", Intrinsics.stringPlus((String) r0.get("filters"), ",".concat(r12)));
    L19:
        r11 = MapsKt.emptyMap();
        goto L21
    L20:
        r11 = MapsKt.emptyMap();
    L29:
        return r0;
    L11:
        r6 = false;
        goto L12
    }

    public final boolean k() {
        Boolean r0 = this.D;
        if (r0 == null) goto L9;
        if (r0 == null) goto L8;
        return r0.booleanValue();
    L8:
        throw new IllegalArgumentException("Required value was null.".toString());
    L9:
        Map.Entry r1 = (Map.Entry) CollectionsKt.firstOrNull(((LinkedHashMap) this.f).entrySet());
        if (r1 == null) goto L27;
        com.bytedance.android.ec.hybrid.list.entity.i r2 = (com.bytedance.android.ec.hybrid.list.entity.i) r1.getValue();
        if (r2 == null) goto L27;
        ArrayList r3 = r2.i;
        if (r3 == null) goto L27;
        ECHybridListItemVO r4 = (ECHybridListItemVO) CollectionsKt.firstOrNull(r3);
        if (r4 == null) goto L27;
        String r5 = r4.g();     // Catch: Exception -> L28
        if (r5 == null) goto L27;
        JSONObject r6 = com.bytedance.android.ec.hybrid.list.util.k.c(r5);     // Catch: Exception -> L28
        if (r6 == null) goto L27;
        Object r7 = r6.opt("support_slide");     // Catch: Exception -> L28
        if ((r7 instanceof Boolean) == true) goto L25;
        r7 = null;
    L25:
        Boolean r8 = (Boolean) r7;     // Catch: Exception -> L28
        this.D = r8;     // Catch: Exception -> L28
        return Intrinsics.areEqual(r8, Boolean.TRUE);
    L27:
        return false;
    }

    public final List<com.bytedance.android.shopping.api.mall.common.tools.d> s() {
        List<com.bytedance.android.shopping.api.mall.common.tools.d> r2 = this.C;
        if (r2 != null) goto L5;
    L8:
        Map.Entry r3 = (Map.Entry) CollectionsKt.firstOrNull(((LinkedHashMap) this.f).entrySet());
        if (r3 == null) goto L58;
        com.bytedance.android.ec.hybrid.list.entity.i r4 = (com.bytedance.android.ec.hybrid.list.entity.i) r3.getValue();
        if (r4 == null) goto L69;
        ArrayList r5 = r4.i;
        if (r5 == null) goto L70;
        ECHybridListItemVO r6 = (ECHybridListItemVO) CollectionsKt.firstOrNull(r5);
        if (r6 == null) goto L71;
        String r7 = r6.g();     // Catch: Exception -> L56
        if (r7 == null) goto L54;
        JSONObject r8 = com.bytedance.android.ec.hybrid.list.util.k.c(r7);     // Catch: Exception -> L56
        if (r8 == null) goto L66;
        Object r9 = r8.opt("mall_belt_tab_list");     // Catch: Exception -> L56
        if ((r9 instanceof JSONArray) == true) goto L24;
        r9 = null;
    L24:
        JSONArray r10 = (JSONArray) r9;     // Catch: Exception -> L56
        this.C = new ArrayList();     // Catch: Exception -> L56
        if (r10 == null) goto L48;
        List r11 = cd.a.d(r10);     // Catch: Exception -> L56
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));     // Catch: Exception -> L56
        Iterator r13 = r11.iterator();     // Catch: Exception -> L56
    L28:
        if (r13.hasNext() == false) goto L30;
        r12.add(com.bytedance.android.ec.hybrid.list.util.k.b(r13.next()));     // Catch: Exception -> L56
        goto L28
    L30:
        Iterator r14 = r12.iterator();     // Catch: Exception -> L56
        int r15 = 0;
    L32:
        if (r14.hasNext() == false) goto L48;
        Object r16 = r14.next();     // Catch: Exception -> L56
        int r17 = r15 + 1;     // Catch: Exception -> L56
        if (r15 >= 0) goto L36;
        CollectionsKt.throwIndexOverflow();     // Catch: Exception -> L56
    L36:
        JSONObject r18 = (JSONObject) r16;     // Catch: Exception -> L56
        List<com.bytedance.android.shopping.api.mall.common.tools.d> r19 = this.C;     // Catch: Exception -> L56
        if (r19 == null) goto L47;
        Integer r20 = StringsKt.toIntOrNull(r18.optString("tab_id", ""));     // Catch: Exception -> L56
        if (r20 == null) goto L41;
        int r21 = r20.intValue();     // Catch: Exception -> L56
    L42:
        String r22 = r18.optString("name", "");     // Catch: Exception -> L56
        Integer r110 = Integer.valueOf(r18.optInt("tab_type"));     // Catch: Exception -> L56
        Boolean r111 = Boolean.valueOf(r18.optBoolean("is_hybrid"));     // Catch: Exception -> L56
        String r112 = r18.optString("hybrid_meta");     // Catch: Exception -> L56
        JSONObject r23 = r18.optJSONObject("style");     // Catch: Exception -> L56
        if (r23 == null) goto L45;
        String r24 = r23.optString("title_text");     // Catch: Exception -> L56
    L46:
        r19.add(new com.bytedance.android.shopping.api.mall.common.tools.d(r21, r22, r15, r110, r111, r112, r24));     // Catch: Exception -> L56
        goto L47
    L45:
        r24 = null;
        goto L46
    L41:
        r21 = 0;
    L47:
        r15 = r17;
    L48:
        List<com.bytedance.android.shopping.api.mall.common.tools.d> r1 = this.C;     // Catch: Exception -> L56
        if (r1 != null) goto L51;
        return null;
    L51:
        if ((!r1.isEmpty()) != true) goto L68;
        return this.C;
    L68:
        return null;
    L66:
        return null;
    L54:
        return null;
    L56:
        return null;
    L71:
        return null;
    L70:
        return null;
    L69:
        return null;
    L58:
        return null;
    L5:
        if ((!r2.isEmpty()) != true) goto L8;
        return this.C;
    }

    public final Map<String, String> getFilters() {
        return i();
    }

    public static void D(ECHybridListEngine r3) {
        Integer r0 = null;
        if (r3 == null) goto L5;
        BaseViewHolder r1 = r3.e("category_tab_section", "category_tab_section");
    L6:
        if (r1 == null) goto L16;
        Integer r2 = Integer.valueOf(r1.getLayoutPosition());
        if (r2.intValue() <= 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L13;
        r0 = r2;
    L13:
        if (r0 == null) goto L17;
        r3.b.scrollToPosition(r0.intValue());
        return;
    L17:
        return;
    L10:
        r4 = false;
        goto L11
    L16:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static String l(List r5) {
        Intrinsics.checkNotNullParameter(r5, "list");
        StringBuilder r0 = new StringBuilder();
        Iterator r6 = r5.iterator();
    L3:
        boolean r3 = true;
        if (r6.hasNext() == false) goto L18;
        List r1 = ((ECHybridListItemVO) r6.next()).X;
        if (r1 == null) goto L3;
        ECHybridListItemAction r2 = (ECHybridListItemAction) CollectionsKt.firstOrNull(r1);
        if (r2 == null) goto L3;
        String r4 = r2.getBase();
        if (r4 == null) goto L3;
        if (r4.length() > 0) goto L15;
        r3 = false;
    L15:
        if (r3 == false) goto L3;
        r0.append(r4.concat(","));
        goto L3
    L18:
        if (r0.length() > 1) goto L20;
        return null;
    L20:
        return StringsKt.removeSuffix(r0, ",").toString();
    }

    public final void J(HomePageDTO r3) {
        if (r3 == null) goto L11;
        HomePageBffDTO r0 = r3.getBff();
        if (r0 == null) goto L11;
        Map<String, Object> r1 = r0.getDynamicParams();
        if (r1 == null) goto L11;
        Object r2 = r1.get("post_back");
        if ((r2 instanceof String) == true) goto L10;
        r2 = null;
    L10:
        this.u = (String) r2;
    L11:
        if (r3 == null) goto L22;
        HomePageBffDTO r4 = r3.getBff();
        if (r4 == null) goto L23;
        ECHybridListDTO r5 = r4.getFeed();
        if (r5 == null) goto L24;
        Map r6 = r5.getExtra();
        if (r6 == null) goto L25;
        String r7 = (String) r6.get("session_id");
        if (r7 == null) goto L26;
        this.A = r7;
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    }

    public final void c(String r3) {
        Intrinsics.checkNotNullParameter("filters", "key");
        Intrinsics.checkNotNullParameter(r3, "filter");
        j("filters");
        if (r3.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L14;
        s r1 = (s) ((LinkedHashMap) this.a).get("filters");
        if (r1 == null) goto L10;
        r1.a(r3);
    L10:
        s r2 = (s) ((LinkedHashMap) this.b).get("filters");
        if (r2 == null) goto L15;
        r2.a(r3);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void g(boolean r3) {
        this.k.clear();
        this.l.clear();
        this.i.clear();
        this.h.clear();
        v<Integer> r0 = this.o;
        r0.b = Boolean.TRUE;
        r0.evictAll();
        r0.b = Boolean.FALSE;
        ((LinkedHashMap) this.f).clear();
        this.C = null;
        this.g = null;
        this.D = null;
        this.j.clear();
        this.E = 0;
        if (r3 == true) goto L6;
        this.y = 0;
        return;
    }

    public final void j(String r4) {
        if (this.a.containsKey(r4) == true) goto L6;
        this.a.put(r4, new s(this.F));
        this.b.put(r4, new s(this.F));
        return;
    }

    public final int m(int r2) {
        lf3.a r3 = this.i.get(r2);
        if (r3 != null) goto L7;
        return 0;
    L7:
        return r3.b;
    }

    public final String n(int r3) {
        return this.G + "_favorite_section_" + r3;
    }

    public final boolean p(int r2) {
        lf3.a r3 = this.i.get(r2);
        if (r3 != null) goto L5;
    L8:
        return true;
    L5:
        if (r3.c == true) goto L8;
        return false;
    }

    public final int q(int r2) {
        lf3.a r3 = this.i.get(r2);
        if (r3 != null) goto L7;
        return 0;
    L7:
        return r3.a;
    }

    public final void y(int r2) {
        this.k.delete(r2);
        this.l.delete(r2);
        this.i.delete(r2);
        this.h.remove(r2);
        this.f.remove(Integer.valueOf(r2));
        if (this.f.isEmpty() == false) goto L6;
        this.g = null;
        return;
    }

    public final void z(String r3) {
        Intrinsics.checkNotNullParameter("filters", "key");
        Intrinsics.checkNotNullParameter(r3, "filter");
        s r0 = (s) ((LinkedHashMap) this.a).get("filters");
        if (r0 == null) goto L5;
        r0.remove(r3);
    L5:
        s r1 = (s) ((LinkedHashMap) this.b).get("filters");
        if (r1 == null) goto L9;
        r1.remove(r3);
        return;
    }

    public static void A(int r3, String r4) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L4
        r1.put("tab_id", r3);     // Catch: Throwable -> L4
        r1.putOpt("address", r4);     // Catch: Throwable -> L4
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L4
        AppLogNewUtils.onEventV3("gyl_no_card_show", r1);     // Catch: Throwable -> L4
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final void H(HomePageDTO r4, int r5) {
        J(r4);
        if (r4 == null) goto L21;
        HomePageBffDTO r6 = r4.getBff();
        if (r6 == null) goto L22;
        BffBizInfo r7 = r6.getBizInfo();
        if (r7 == null) goto L23;
        List<String> r0 = r7.getFilters();
        if (r0 == null) goto L15;
        Set<String> r1 = CollectionsKt.toMutableSet(r0);
        if (r1 == null) goto L15;
        f("filters", r1);
        e(String.valueOf(this.y), "filters", r1);
        if (((Boolean) this.n.getValue()).booleanValue() == false) goto L15;
        com.bytedance.android.ec.hybrid.a.d().submit(new c(r1, r7, this, r5));
    L15:
        Integer r8 = r7.getOffset();
        if (r8 == null) goto L18;
        int r9 = r8.intValue();
    L19:
        this.t = r9;
        this.v = r7.getRequestId();
        return;
    L18:
        r9 = 0;
        goto L19
    L23:
        return;
    L22:
        return;
    }

    public final void I(int r5, com.bytedance.android.ec.hybrid.list.entity.i r6) {
        if (r5 == 308) goto L5;
        return;
    L5:
        boolean r0 = false;
        if (r6 == null) goto L39;
        ArrayList r2 = r6.i;
        if (r2 != null) goto L10;
    L13:
        boolean r3 = true;
    L14:
        if (r3 == true) goto L39;
        ArrayList r7 = r6.i;
        if (r7 != null) goto L19;
    L36:
        if (r0 == false) goto L54;
        this.j.put(r5, 1);
        return;
    L54:
        return;
    L19:
        if (r7.isEmpty() == true) goto L33;
        Iterator r8 = r7.iterator();
    L23:
        if (r8.hasNext() == false) goto L33;
        Integer r4 = ((ECHybridListItemVO) r8.next()).c;
        int r9 = ECHybridListItemType.SHOP_VIEW_HOLDER_NATIVE_DELIVERY_CARD.getType();
        if (r4 != null) goto L28;
    L30:
        boolean r10 = false;
    L31:
        if (r10 == false) goto L23;
        boolean r11 = true;
    L34:
        if (r11 != true) goto L36;
        r0 = true;
        goto L36
    L28:
        if (r4.intValue() != r9) goto L30;
        r10 = true;
    L33:
        r11 = false;
        goto L34
    L10:
        if (r2.isEmpty() == true) goto L13;
        r3 = false;
    L39:
        int r12 = this.j.get(r5, 0);
        if (r12 == 0) goto L45;
        if (r12 != 1) goto L56;
        this.j.put(r5, 2);
        return;
    L56:
        return;
    L45:
        if (this.E == 0) goto L47;
        this.j.put(r5, 1);
    L47:
        this.E++;
    }

    public final void b(String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "key");
        Intrinsics.checkNotNullParameter(r7, "filter");
        boolean r1 = false;
        if (this.e.containsKey(r6) == true) goto L25;
        int r0 = r6.hashCode();
        Integer r4 = null;
        if (r0 == (-1019654232)) goto L13;
        if (r0 == 1585821867) goto L10;
    L15:
        Integer r2 = null;
    L16:
        if (r2 == null) goto L25;
        if (r2.intValue() <= 0) goto L20;
        boolean r3 = true;
    L21:
        if (r3 == false) goto L23;
        r4 = r2;
    L23:
        if (r4 == null) goto L25;
        this.e.put(r6, new LimitedCapacityMap(r4.intValue()));
        goto L25
    L20:
        r3 = false;
        goto L21
    L10:
        if (r6.equals("product_filters") == false) goto L15;
        K.getClass();
        r2 = a.a().e();
        goto L16
    L13:
        if (r6.equals("live_filters") == false) goto L15;
        K.getClass();
        r2 = a.a().c();
    L25:
        LimitedCapacityMap r8 = (LimitedCapacityMap) ((LinkedHashMap) this.e).get(r6);
        if (r8 != null) goto L28;
        return;
    L28:
        if (r7.length() <= 0) goto L30;
        r1 = true;
    L30:
        if (r1 == false) goto L34;
        r8.put(r7, Long.valueOf(System.currentTimeMillis()));
        return;
    }

    public final void d(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tabId");
        Intrinsics.checkNotNullParameter("filters", "key");
        Intrinsics.checkNotNullParameter(r4, "filter");
        s<String> r5 = o(r3, "filters");
        if (r4.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        r5.a(r4);
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void f(String r3, Set<String> r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "filters");
        j(r3);
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L16;
        String r0 = (String) r5.next();
        if (r0.length() <= 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L4;
        s r2 = (s) ((LinkedHashMap) this.a).get(r3);
        if (r2 == null) goto L13;
        r2.a(r0);
    L13:
        s r6 = (s) ((LinkedHashMap) this.b).get(r3);
        if (r6 == null) goto L4;
        r6.a(r0);
        goto L4
    L8:
        r1 = false;
        goto L9
    }

    public final s<String> o(String r4, String r5) {
        if (this.d.containsKey(r4) == true) goto L5;
        this.d.put(r4, new LinkedHashMap());
    L5:
        Map r0 = (Map) ((LinkedHashMap) this.d).get(r4);
        if (r0 != null) goto L8;
    L9:
        Map r1 = (Map) ((LinkedHashMap) this.d).get(r4);
        if (r1 == null) goto L12;
        s r2 = (s) r1.put(r5, new s(this.F));
    L12:
        Map r6 = (Map) ((LinkedHashMap) this.d).get(r4);
        if (r6 == null) goto L15;
        s<String> r7 = (s) r6.get(r5);
    L16:
        if (r7 == null) goto L19;
        return r7;
    L19:
        throw new IllegalArgumentException("Required value was null.".toString());
    L15:
        r7 = null;
        goto L16
    L8:
        if (r0.containsKey(r5) == true) goto L12;
        goto L9
    }

    public final void x(Context r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        List<com.bytedance.android.shopping.api.mall.common.tools.d> r9 = s();
        if (r9 != null) goto L5;
        return;
    L5:
        Iterator<com.bytedance.android.shopping.api.mall.common.tools.d> r0 = r9.iterator();
        boolean r1 = false;
        int r2 = 0;
    L6:
        int r4 = -1;
        if (r0.hasNext() == false) goto L15;
        if (r0.next().a != r8) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == true) goto L16;
        r2 = r2 + 1;
    L16:
        if (r2 == 0) goto L18;
    L20:
        if (r2 < 0) goto L40;
        int r5 = r2 + 1;
        if (r9.size() <= r5) goto L41;
        com.bytedance.android.shopping.api.mall.common.tools.d r10 = (com.bytedance.android.shopping.api.mall.common.tools.d) CollectionsKt.getOrNull(r9, r5);
        Boolean r11 = ((s93.a) this.r.getValue()).a();
        Boolean r6 = Boolean.TRUE;
        if (Intrinsics.areEqual(r11, r6) == false) goto L31;
        List<Integer> r12 = ((s93.a) this.r.getValue()).c();
        if (r12 == null) goto L32;
        if (r10 == null) goto L30;
        r4 = r10.a;
    L30:
        if (r12.contains(Integer.valueOf(r4)) == true) goto L31;
    L32:
        if (r1 == false) goto L42;
        if (r10 != null) goto L35;
        return;
    L35:
        if ((!Intrinsics.areEqual(r10.e, r6)) == false) goto L44;
        w(r10.a, true, null, new ECMallFavoriteSectionHelper$prefetchNextTab$1(this));
        return;
    L44:
        return;
    L42:
        return;
    L31:
        r1 = true;
        goto L32
    L41:
        return;
    L40:
        return;
    L18:
        if (((s93.a) this.r.getValue()).b() == false) goto L20;
        return;
    L11:
        r3 = false;
        goto L12
    L15:
        r2 = -1;
        goto L16
    }

    public ECMallFavoriteSectionHelper(int r1, String r2, Long r3) {
        this.F = r1;
        this.G = r2;
        this.H = r3;
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        this.c = new WeakHashMap();
        this.d = new LinkedHashMap();
        this.e = new LinkedHashMap();
        this.f = new LinkedHashMap();
        this.h = new SparseArray();
        this.i = new SparseArray();
        this.j = new SparseIntArray();
        this.k = new SparseBooleanArray();
        this.l = new SparseBooleanArray();
        this.m = LazyKt.lazy(ECMallFavoriteSectionHelper$requestManager$2.INSTANCE);
        this.n = LazyKt.lazy(ECMallFavoriteSectionHelper$gylRepeatMonitor$2.INSTANCE);
        this.o = new v(100);
        this.p = LazyKt.lazy(ECMallFavoriteSectionHelper$loadingTransfer$2.INSTANCE);
        this.q = LazyKt.lazy(ECMallFavoriteSectionHelper$tabStraightOut$2.INSTANCE);
        this.r = LazyKt.lazy(ECMallFavoriteSectionHelper$tabPreload$2.INSTANCE);
        this.s = new o();
        this.B = new h93.a();
    }

    public static void F(ECHybridListEngine r7, int r8, int r9) {
        D(r7);
        if (r7 == null) goto L38;
        com.bytedance.android.ec.hybrid.list.entity.k r0 = r7.c.g;
        if (r0 == null) goto L16;
        ArrayList r1 = r0.c;
        if (r1 == null) goto L16;
        Iterator r2 = r1.iterator();
    L10:
        if (r2.hasNext() == false) goto L14;
        Object r3 = r2.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.i) r3).a, "favorite_section") == false) goto L10;
    L15:
        com.bytedance.android.ec.hybrid.list.entity.i r4 = (com.bytedance.android.ec.hybrid.list.entity.i) r3;
    L17:
        if (r4 == null) goto L27;
        Integer r5 = Integer.valueOf(r4.f);
        if (r5.intValue() <= 0) goto L21;
        boolean r6 = true;
    L22:
        if (r6 == true) goto L25;
        r5 = null;
    L25:
        if (r5 == null) goto L27;
        int r10 = r5.intValue();
    L28:
        com.bytedance.android.ec.hybrid.list.entity.i r11 = new com.bytedance.android.ec.hybrid.list.entity.i();
        r11.f = r10;
        r11.a = "favorite_section";
        r11.c(ECSectionOperationType.INSERT_SECTION);
        ArrayList r12 = new ArrayList();
        ECHybridListItemVO r13 = new ECHybridListItemVO();
        r13.c = Integer.valueOf(ECHybridListItemType.HYBRID_TYPE_FAV_LOADING_CARD.getType());
        r13.a = Integer.valueOf(r10);
        JSONObject r14 = new JSONObject();
        r14.put("loading_status", r8);
        r14.put("loading_view_type", r9);
        Unit r15 = Unit.INSTANCE;
        r13.o(r14);
        r12.add(r13);
        r11.i = r12;
        if (r4 == null) goto L33;
        com.bytedance.android.ec.hybrid.list.entity.j r16 = r4.h;
        if (r16 == null) goto L33;
        com.bytedance.android.ec.hybrid.list.entity.j r17 = new com.bytedance.android.ec.hybrid.list.entity.j();
        r17.i = r16.i;
        r17.k = r16.k;
        r11.h = r17;
    L33:
        ECHybridListEngine.s(r7, r11, null, 6);
        return;
    L21:
        r6 = false;
    L27:
        r10 = 2;
        goto L28
    L14:
        r3 = null;
    L16:
        r4 = null;
        goto L17
    }

    public static final void a(ECMallFavoriteSectionHelper r1, int r2, String[] r3) {
        r1.getClass();
        Single.fromCallable(new h(r1, r3, r2)).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe();
    }

    public final void e(String r2, String r3, Set<String> r4) {
        Intrinsics.checkNotNullParameter(r2, "tabId");
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "filters");
        s<String> r5 = o(r2, r3);
        Iterator<T> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L11;
        String r7 = (String) r6.next();
        if (r7.length() <= 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L4;
        r5.a(r7);
        goto L4
    L8:
        r0 = false;
        goto L9
    }

    public final void v(ECHybridListEngine r6, int r7, List<com.bytedance.android.ec.hybrid.list.entity.i> r8) {
        Intrinsics.checkNotNullParameter(r8, "sections");
        Iterator<T> r0 = r8.iterator();
    L3:
        Object r2 = null;
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.i) r1).a, "category_tab_section") == false) goto L3;
    L9:
        com.bytedance.android.ec.hybrid.list.entity.i r3 = (com.bytedance.android.ec.hybrid.list.entity.i) r1;
        if (r3 == null) goto L12;
        this.f.put(Integer.valueOf(r7), r3);
    L12:
        Iterator<T> r4 = r8.iterator();
    L14:
        if (r4.hasNext() == false) goto L18;
        Object r5 = r4.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.i) r5).a, "favorite_section") == false) goto L14;
        r2 = r5;
    L18:
        com.bytedance.android.ec.hybrid.list.entity.i r9 = (com.bytedance.android.ec.hybrid.list.entity.i) r2;
        if (r9 == null) goto L23;
        ArrayList r10 = r9.i;
        if (r10 == null) goto L23;
        int r11 = r10.size();
    L24:
        if (r11 <= 0) goto L26;
        boolean r12 = true;
    L28:
        if (this.h.get(r7) != null) goto L31;
        if (r12 == false) goto L31;
        SparseArray<List<com.bytedance.android.ec.hybrid.list.entity.i>> r13 = this.h;
        ArrayList r14 = new ArrayList();
        r14.addAll(r8);
        Unit r15 = Unit.INSTANCE;
        r13.put(r7, r14);
        this.o.put(Integer.valueOf(r7), v.c);
    L31:
        if (r12 == false) goto L33;
        return;
    L33:
        if (this.h.get(r7) != null) goto L43;
        F(r6, 2, 0);
        return;
    L43:
        return;
    L26:
        r12 = false;
    L23:
        r11 = 0;
        goto L24
    L8:
        r1 = null;
        goto L9
    }

    public final void E(int r3, int r4, int r5, boolean r6) {
        lf3.a r0 = this.i.get(r3);
        if (r0 == null) goto L5;
        r0.a = r4;
        r0.b = r5;
        r0.c = r6;
        return;
    L5:
        lf3.a r1 = new lf3.a(0);
        r1.a = r4;
        r1.b = r5;
        r1.c = r6;
        this.i.put(r3, r1);
    }

    public final void u(int r9, ECHybridListEngine r10, String r11, boolean r12) {
        HomePageDTO r13 = (HomePageDTO) GsonProtectorUtils.fromJson(new Gson(), r11, HomePageDTO.class);
        if (r12 == false) goto L5;
        J(r13);
    L5:
        if (r13 == null) goto L12;
        HomePageBffDTO r14 = r13.getBff();
        if (r14 == null) goto L12;
        BffBizInfo r15 = r14.getBizInfo();
        if (r15 == null) goto L12;
        String r16 = r15.getRequestId();
        if (r16 == null) goto L12;
    L14:
        if (r13 == null) goto L18;
        HomePageBffDTO r1 = r13.getBff();
        if (r1 == null) goto L18;
        ECHybridListDTO r2 = r1.getFeed();
    L20:
        if (r2 != null) goto L22;
        int r3 = com.bytedance.android.shopping.api.mall.common.tools.j.a;
        com.bytedance.android.shopping.api.mall.common.tools.j.a("favorite_feed", "favorite_feed->feed data is null", r16, this.H);
    L22:
        if (r13 == null) goto L28;
        HomePageBffDTO r4 = r13.getBff();
        if (r4 == null) goto L28;
        ECHybridListDTO r5 = r4.getFeed();
        if (r5 == null) goto L28;
        List r6 = r5.getSections();
    L30:
        if (r6 == null) goto L40;
        if (r13 == null) goto L41;
        HomePageBffDTO r7 = r13.getBff();
        if (r7 == null) goto L41;
        ECHybridListDTO r8 = r7.getFeed();
        if (r8 == null) goto L41;
        List r17 = r8.getSections();
        if (r17 == null) goto L41;
        if (r17.isEmpty() == true) goto L40;
    L41:
        int r18 = 0;
        if (r13 == null) goto L99;
        HomePageBffDTO r19 = r13.getBff();
        if (r19 == null) goto L99;
        ECHybridListDTO r20 = r19.getFeed();
        if (r20 == null) goto L99;
        Map r21 = r20.getExtra();
        if (r21 == null) goto L50;
        String r22 = (String) r21.get("address_info");
    L51:
        this.z = r22;
        ECHybridListDTO.a r23 = ECHybridListDTO.Companion;
        HomePageBffDTO r24 = r13.getBff();
        if (r24 == null) goto L56;
        BffBizInfo r25 = r24.getBizInfo();
        if (r25 == null) goto L56;
        String r26 = r25.getEcSceneId();
    L57:
        com.bytedance.android.ec.hybrid.list.entity.dto.a r27 = new com.bytedance.android.ec.hybrid.list.entity.dto.a(-1, r26, 190);
        r23.getClass();
        ArrayList r28 = ECHybridListDTO.a.d(r20, false, r27).c;
        if (r28 != null) goto L60;
    L94:
        I(r9, null);
        if (this.y != 308) goto L97;
        new Handler(Looper.getMainLooper()).post(new i(r10));
    L97:
        if (r9 == 308) goto L99;
        F(r10, 2, 0);
        goto L99
    L60:
        if (r28.size() <= 0) goto L69;
        com.bytedance.android.ec.hybrid.list.entity.i r29 = (com.bytedance.android.ec.hybrid.list.entity.i) CollectionsKt.firstOrNull(r28);
        if (r29 == null) goto L66;
        ArrayList r30 = r29.i;
        if (r30 == null) goto L66;
        int r31 = r30.size();
    L67:
        if (r31 <= 0) goto L69;
        boolean r32 = true;
    L70:
        if (r32 == true) goto L73;
        r28 = null;
    L73:
        if (r28 == null) goto L94;
        Iterator r33 = r28.iterator();
    L76:
        if (r33.hasNext() == false) goto L80;
        Object r34 = r33.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.i) r34).a, "favorite_section") == false) goto L76;
    L81:
        I(r9, (com.bytedance.android.ec.hybrid.list.entity.i) r34);
        Iterator r35 = r28.iterator();
    L83:
        if (r35.hasNext() == false) goto L89;
        com.bytedance.android.ec.hybrid.list.entity.i r36 = (com.bytedance.android.ec.hybrid.list.entity.i) r35.next();
        r36.c(ECSectionOperationType.INSERT_SECTION);
        if (this.y != r9) goto L83;
        if (r10 == null) goto L88;
        ECHybridListEngine.s(r10, r36, null, 6);
    L88:
        D(r10);
        this.B.l = 5;
        goto L83
    L89:
        v(r10, r9, r28);
        lf3.a r110 = this.i.get(r9);
        if (r110 == null) goto L92;
        int r111 = r110.a;
    L93:
        E(r9, r111 + 1, r20.getCursor(), r20.getHasMore());
        goto L99
    L92:
        r111 = 0;
        goto L93
    L80:
        r34 = null;
    L66:
        r31 = 0;
    L69:
        r32 = false;
    L56:
        r26 = null;
        goto L57
    L50:
        r22 = null;
    L99:
        lf3.a r37 = this.i.get(r9);
        if (r37 == null) goto L102;
        r18 = r37.a;
    L102:
        H(r13, r18 + 1);
        return;
    L40:
        this.B.l = 4;
        int r38 = com.bytedance.android.shopping.api.mall.common.tools.j.a;
        com.bytedance.android.shopping.api.mall.common.tools.j.a("favorite_feed", "favorite_feed->feed->sections data is null", r16, this.H);
    L28:
        r6 = null;
    L18:
        r2 = null;
    L12:
        r16 = "";
        goto L14
    }

    public final void w(int r20, boolean r21, Map<String, Object> r22, final Function1<? super com.bytedance.android.shopping.api.mall.c, Unit> r23) {
        int r1 = n.c;
        String[] r2 = {"favorite_feed", String.valueOf(r20), String.valueOf(r21), ECMallFavoriteSectionHelper.class.getSimpleName()};
        Intrinsics.checkNotNullParameter(r2, "keys");
        final String r3 = ArraysKt.joinToString$default(r2, "_", null, null, 0, null, null, 62, null);
        n r4 = r();
        ECMallFavoriteSectionHelper$innerRequestFavoriteFeed$executeJob$1 r5 = new ECMallFavoriteSectionHelper$innerRequestFavoriteFeed$executeJob$1(this, r20, r21, r22, r3, null);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r3, "requestKey");
        Intrinsics.checkNotNullParameter(r5, "request");
        CompletableDeferred<Object> r6 = r4.a.get(r3);
        if (r6 != null) goto L5;
    L6:
        CompletableDeferred<Object> r7 = r4.a.get(r3);
        if (r7 != null) goto L9;
    L15:
        CompletableDeferred<Object> r8 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        Job r9 = BuildersKt.launch$default(r4.b, null, null, new ECRequestManager$executeRequest$job$1(r5, r8, null), 3, null);
        r4.a.put(r3, r8);
        final Job r10 = r9;
    L17:
        if (r10.isActive() == true) goto L23;
        com.bytedance.android.shopping.api.mall.c r11 = (com.bytedance.android.shopping.api.mall.c) r().a(r3);
        if (r11 == null) goto L25;
        if (r23 == null) goto L25;
        boolean r12 = r11.a;
        String r13 = r11.b;
        ECHybridNetworkVO r14 = r11.c;
        String r15 = r11.d;
        String r16 = r11.f;
        Throwable r17 = r11.g;
        long r18 = r11.h;
        Intrinsics.checkNotNullParameter(r13, "apiKey");
        Intrinsics.checkNotNullParameter(r15, "requestKey");
        Unit r0 = (Unit) r23.invoke(new com.bytedance.android.shopping.api.mall.c(r12, r13, r14, r15, true, r16, r17, r18));
    L25:
        return;
    L23:
        r10.invokeOnCompletion(new ECMallFavoriteSectionHelper$innerRequestFavoriteFeed$2(this, r10, r3, r23));
        return;
    L9:
        if (r7.isCompleted() != true) goto L15;
    L10:
        CompletableDeferred<Object> r19 = r4.a.get(r3);
        if (r19 == null) goto L14;
        r10 = r19.get(Job.Key);
        if (r10 != null) goto L17;
    L14:
        r10 = JobKt.Job$default(null, 1, null);
        goto L17
    L5:
        if (r6.isActive() == true) goto L10;
        goto L6
    }

    public final void B(Context r4, int r5, boolean r6, Map<String, ? extends Object> r7, final Function1<? super com.bytedance.android.shopping.api.mall.c, Unit> r8) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Map<String, Object> r9 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("cursor", 0), TuplesKt.to("page_num", 0)});
        if (r7 == null) goto L5;
        r9.putAll(r7);
    L5:
        w(r5, r6, r9, new ECMallFavoriteSectionHelper$requestRefreshFavoriteFeed$1(this, r8));
    }

    public final void C(int r4, ECHybridListEngine r5, com.bytedance.android.shopping.api.mall.c r6, boolean r7, Function0<Unit> r8) {
        Intrinsics.checkNotNullParameter(r8, "callback");
        if (r5 == null) goto L17;
        if (r6 == null) goto L6;
        String r0 = r6.f;
    L7:
        if (r0 != null) goto L9;
        return;
    L9:
        if (this.l.get(r4) == true) goto L19;
        this.l.put(r4, true);
        this.k.put(r4, true);
        this.h.clear();
        v<Integer> r1 = this.o;
        r1.b = Boolean.TRUE;
        r1.evictAll();
        r1.b = Boolean.FALSE;
        this.i.put(r4, new lf3.a(0));
        r().a.clear();
        String r9 = r6.f;
        if (r9 == null) goto L16;
        u(r4, r5, r9, r7);
        r8.invoke();
        this.l.put(r4, false);
        this.k.put(r4, false);
        return;
    L16:
        throw new IllegalArgumentException("Required value was null.".toString());
    L19:
        return;
    L6:
        r0 = null;
        goto L7
    }

    public final void G(int r21, boolean r22, int r23, final ECHybridListEngine r24, boolean r25, com.bytedance.android.shopping.api.mall.common.tools.c r26, final Function4<? super Boolean, ? super Boolean, ? super Boolean, ? super b, Unit> r27) {
        this.k.put(r21, true);
        if (this.y != r21) goto L11;
        if (r26 == null) goto L11;
        if (r26.c != true) goto L11;
        if (r24 == null) goto L11;
        ECHybridRecyclerView r2 = r24.b;
        if (r2 == null) goto L11;
        r2.S(CollectionsKt.listOf("favorite_section"));
    L11:
        this.y = r21;
        Boolean r3 = Boolean.FALSE;
        Unit r4 = (Unit) r27.invoke(null, r3, r3, null);
        List<com.bytedance.android.ec.hybrid.list.entity.i> r5 = this.h.get(r21);
        if (r26 == null) goto L16;
        Map<String, Object> r6 = r26.a;
        if (r6 == null) goto L16;
        Object r7 = r6.get("is_hybrid");
    L18:
        if (Intrinsics.areEqual(r7, Boolean.TRUE) == false) goto L85;
        if (r26 == null) goto L23;
        Map<String, Object> r8 = r26.a;
        if (r8 == null) goto L23;
        Object r9 = r8.get("hybrid_meta");
    L25:
        if ((r9 instanceof String) == true) goto L27;
        r9 = null;
    L27:
        String r10 = (String) r9;
        if (r10 != null) goto L30;
    L33:
        boolean r13 = true;
    L34:
        if (r13 == false) goto L181;
    L40:
        ArrayList r1 = null;
    L82:
        if (r1 == null) goto L85;
        this.h.put(r21, r1);
        r5 = r1;
        goto L85
    L181:
        ECHybridListDTO r11 = (ECHybridListDTO) new Gson().fromJson(r10, ECHybridListDTO.class);     // Catch: Exception -> L38
    L39:
        if (r11 == null) goto L40;
        ECHybridListDTO.Companion.getClass();
        com.bytedance.android.ec.hybrid.list.entity.k r12 = ECHybridListDTO.a.d(r11, false, null);
        if (r26.b == false) goto L81;
        Map<String, Object> r14 = r26.a;
        if (r14 == null) goto L46;
        Object r15 = r14.get("guide_icon");
    L48:
        if ((r15 instanceof Map) == true) goto L50;
        r15 = null;
    L50:
        Map r16 = (Map) r15;
        if (r16 == null) goto L53;
        Object r17 = r16.get("wysiwyg_items");
    L55:
        if ((r17 instanceof String) == true) goto L57;
        r17 = null;
    L57:
        String r18 = (String) r17;
        if (r18 == null) goto L70;
        ArrayList r19 = r12.c;
        if (r19 == null) goto L70;
        com.bytedance.android.ec.hybrid.list.entity.i r110 = (com.bytedance.android.ec.hybrid.list.entity.i) CollectionsKt.firstOrNull(r19);
        if (r110 == null) goto L70;
        ArrayList r111 = r110.i;
        if (r111 == null) goto L70;
        ECHybridListItemVO r112 = (ECHybridListItemVO) CollectionsKt.firstOrNull(r111);
        if (r112 == null) goto L70;
        HashMap r113 = r112.E;
        if (r113 == null) goto L70;
        r113.put("wysiwyg_items", r18);
    L70:
        ArrayList r20 = r12.c;
        if (r20 == null) goto L81;
        com.bytedance.android.ec.hybrid.list.entity.i r28 = (com.bytedance.android.ec.hybrid.list.entity.i) CollectionsKt.firstOrNull(r20);
        if (r28 == null) goto L81;
        ArrayList r29 = r28.i;
        if (r29 == null) goto L81;
        ECHybridListItemVO r30 = (ECHybridListItemVO) CollectionsKt.firstOrNull(r29);
        if (r30 == null) goto L81;
        HashMap r31 = r30.E;
        if (r31 == null) goto L81;
        r31.put("is_guide_icon_showing", Boolean.TRUE);
        goto L81
    L53:
        r17 = null;
        goto L55
    L46:
        r15 = null;
    L81:
        r1 = r12.c;
    L38:
        r11 = null;
        goto L39
    L30:
        if (r10.length() == 0) goto L33;
        r13 = false;
    L23:
        r9 = null;
    L85:
        if (r5 == null) goto L101;
        Iterator<T> r32 = r5.iterator();
    L88:
        if (r32.hasNext() == false) goto L92;
        Object r33 = r32.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.i) r33).a, "favorite_section") == false) goto L88;
    L93:
        com.bytedance.android.ec.hybrid.list.entity.i r34 = (com.bytedance.android.ec.hybrid.list.entity.i) r33;
        if (r34 == null) goto L101;
        D(r24);
        this.k.put(r21, false);
        r34.c(ECSectionOperationType.INSERT_SECTION);
        if (r24 == null) goto L98;
        ECHybridListEngine.s(r24, r34, null, 6);
    L98:
        this.o.put(Integer.valueOf(r21), v.c);
        Boolean r35 = Boolean.TRUE;
        if (((Unit) r27.invoke(r35, r35, Boolean.FALSE, null)) == null) goto L101;
        return;
    L92:
        r33 = null;
    L101:
        if (Intrinsics.areEqual(t().a(), Boolean.TRUE) == false) goto L165;
        List<Integer> r36 = t().c();
        if (r36 != null) goto L105;
    L106:
        int r37 = this.y;
        Long r38 = t().b();
        if (r38 == null) goto L109;
        long r114 = r38.longValue();
    L110:
        Keva r39 = com.bytedance.android.shopping.api.mall.common.tools.s.a;
        String r40 = n(r37);
        Intrinsics.checkNotNullParameter(r40, "key");
        Keva r41 = com.bytedance.android.shopping.api.mall.common.tools.s.a;
        if (r41 == null) goto L113;
        String[] r42 = r41.getStringArray(r40, null);
    L114:
        if (r42 == null) goto L165;
        Long r115 = ECHybridExtensionsKt.j(r42[1]);     // Catch: Exception -> L164
        if (r115 != null) goto L118;
    L125:
        HomePageDTO r43 = (HomePageDTO) new Gson().fromJson(r42[0], HomePageDTO.class);     // Catch: Exception -> L164
        if (r43 == null) goto L165;
        HomePageBffDTO r44 = r43.getBff();     // Catch: Exception -> L164
        if (r44 == null) goto L165;
        ECHybridListDTO r45 = r44.getFeed();     // Catch: Exception -> L164
        if (r45 == null) goto L165;
        ECHybridListDTO.a r46 = ECHybridListDTO.Companion;     // Catch: Exception -> L164
        HomePageBffDTO r47 = r43.getBff();     // Catch: Exception -> L164
        if (r47 == null) goto L136;
        BffBizInfo r48 = r47.getBizInfo();     // Catch: Exception -> L164
        if (r48 == null) goto L136;
        String r49 = r48.getEcSceneId();     // Catch: Exception -> L164
    L137:
        com.bytedance.android.ec.hybrid.list.entity.dto.a r116 = new com.bytedance.android.ec.hybrid.list.entity.dto.a(-1, r49, 190);     // Catch: Exception -> L164
        r46.getClass();     // Catch: Exception -> L164
        ArrayList r50 = ECHybridListDTO.a.d(r45, true, r116).c;     // Catch: Exception -> L164
        if (r50 == null) goto L165;
        if ((!r50.isEmpty()) == false) goto L149;
        com.bytedance.android.ec.hybrid.list.entity.i r51 = (com.bytedance.android.ec.hybrid.list.entity.i) CollectionsKt.firstOrNull(r50);     // Catch: Exception -> L164
        if (r51 == null) goto L146;
        ArrayList r52 = r51.i;     // Catch: Exception -> L164
        if (r52 == null) goto L146;
        int r53 = r52.size();     // Catch: Exception -> L164
    L147:
        if (r53 <= 0) goto L149;
        boolean r54 = true;
    L150:
        if (r54 == true) goto L153;
        r50 = null;
    L153:
        if (r50 == null) goto L165;
        Iterator r55 = r50.iterator();     // Catch: Exception -> L164
    L156:
        if (r55.hasNext() == false) goto L163;
        com.bytedance.android.ec.hybrid.list.entity.i r56 = (com.bytedance.android.ec.hybrid.list.entity.i) r55.next();     // Catch: Exception -> L164
        r56.c(ECSectionOperationType.INSERT_SECTION);     // Catch: Exception -> L164
        if (r24 == null) goto L161;
        ECHybridListEngine.s(r24, r56, null, 6);     // Catch: Exception -> L164
    L161:
        D(r24);     // Catch: Exception -> L164
        this.B.l = 2;     // Catch: Exception -> L164
        goto L156
    L163:
        boolean r117 = true;
    L166:
        this.l.put(r21, false);
        this.i.put(r21, new lf3.a(0));
        if (this.l.get(r21) == true) goto L178;
        if (r22 == false) goto L178;
        this.l.put(r21, true);
        if (((Boolean) this.p.getValue()).booleanValue() == true) goto L174;
        if (r117 == true) goto L174;
        F(r24, 1, r23);
        this.B.l = 1;
    L174:
        final long r57 = System.currentTimeMillis();
        w(this.y, r25, null, new ECMallFavoriteSectionHelper$requestFavoriteSectionByTabId$1(this, r24, r27, r57));
        if (((Boolean) this.p.getValue()).booleanValue() == false) goto L178;
        if (r117 == true) goto L178;
        F(r24, 1, r23);
        this.B.l = 1;
    L178:
        Unit r0 = Unit.INSTANCE;
        return;
    L146:
        r53 = 0;
    L149:
        r54 = false;
    L136:
        r49 = null;
        goto L137
    L118:
        if ((System.currentTimeMillis() - r115.longValue()) <= r114) goto L120;
        boolean r118 = true;
    L121:
        if (r118 != true) goto L125;
        String r58 = n(r37);     // Catch: Exception -> L164
        Intrinsics.checkNotNullParameter(r58, "key");     // Catch: Exception -> L164
        if (r41 == null) goto L165;
        r41.erase(r58);     // Catch: Exception -> L164
        Unit r59 = Unit.INSTANCE;     // Catch: Exception -> L164
        goto L165
    L120:
        r118 = false;
    L164:
        int r60 = com.bytedance.android.shopping.api.mall.common.tools.j.a;
        com.bytedance.android.shopping.api.mall.common.tools.j.a("favorite_section", "favorite_section->feed->tabStraightOut is fail", "", this.H);
        goto L165
    L113:
        r42 = null;
        goto L114
    L109:
        r114 = 432000000;
        goto L110
    L105:
        if (r36.contains(Integer.valueOf(this.y)) != true) goto L106;
    L165:
        r117 = false;
    L16:
        r7 = null;
        goto L18
    }
}
