package com.bytedance.android.shopping.deepfeed.data.repo;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.imagex.s0;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.api.mall.IECMallAddressService;
import com.bytedance.android.shopping.deepfeed.data.DeepFeedQueryParam;
import com.bytedance.android.shopping.deepfeed.weights.DeepFeedProductHeaderView;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackData;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackDataElements;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductResponse;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.bytedance.android.shopping.infeed.data.idl.ad.AdBaseInfo;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import he3.a1;
import he3.e1;
import he3.k2;
import he3.n0;
import he3.p0;
import he3.r0;
import he3.u;
import he3.u0;
import he3.v;
import he3.x0;
import he3.y0;
import he3.z0;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class AbsDeepFeedRequest implements o, fa3.d {
    public final DeepFeedQueryParam A;
    public final tf3.b B;
    public final List<InFeedProductV2> C;
    public final /* synthetic */ fa3.b D;
    public boolean a;
    public final Handler b;
    public MutableLiveData<he3.l> c;
    public int d;
    public final int e;
    public String f;
    public Consumer<m> g;
    public final Lazy h;
    public final j i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public final d n;
    public final c o;
    public final Lazy p;
    public int q;
    public final Lazy r;
    public final Lazy s;
    public com.bytedance.android.shopping.deepfeed.data.repo.a t;
    public final Set<String> u;
    public final Map<String, Function2<Integer, Boolean, Unit>> v;
    public final com.bytedance.android.shopping.deepfeed.event.c w;
    public final Map<PendingRequestType, a> x;
    public int y;
    public final boolean z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0084\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/data/repo/AbsDeepFeedRequest$PendingRequestType;", "", "PACK", "FEED", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum PendingRequestType extends Enum<PendingRequestType> {
        public static final PendingRequestType FEED = null;
        public static final PendingRequestType PACK = null;
        public static final /* synthetic */ PendingRequestType[] a = null;

        static {
            PendingRequestType r1 = new PendingRequestType("PACK", 0);
            PACK = r1;
            PendingRequestType r2 = new PendingRequestType("FEED", 1);
            FEED = r2;
            a = new PendingRequestType[]{r1, r2};
        }

        public static PendingRequestType valueOf(String r1) {
            return (PendingRequestType) r27.a.a(PendingRequestType.class, r1);
        }

        public static PendingRequestType[] values() {
            return (PendingRequestType[]) a.clone();
        }

        public PendingRequestType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final String a;
        public final String b;
        public final Map<String, String> c;
        public boolean d;

        public a() {
            throw null;
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L12;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L10;
            return false;
        L10:
            if (this.d == r4.d) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public final int hashCode() {
            String r0 = this.b;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Map<String, String> r4 = this.c;
            if (r4 == null) goto L9;
            r1 = r4.hashCode();
        L9:
            int r5 = (r3 + r1) * 31;
            boolean r6 = this.d;
            ?? r7 = r6;
            if (r6 == false) goto L13;
            r7 = 1;
        L13:
            return r5 + r7;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "PendingRequestState(path=" + this.b + ", params=" + this.c + ", consumed=" + this.d + ")";
        }

        public a(String r4, Map r5) {
            Intrinsics.checkNotNullParameter(r4, "path");
            Intrinsics.checkNotNullParameter(r5, "params");
            this.b = r4;
            this.c = r5;
            this.d = false;
            StringBuilder r0 = new StringBuilder();
            r0.append(r4);
            Iterator r6 = MapsKt.toSortedMap(r5).entrySet().iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            Map.Entry r7 = (Map.Entry) r6.next();
            String r1 = (String) r7.getKey();
            String r8 = (String) r7.getValue();
            r0.append('|');
            r0.append(r1);
            r0.append('=');
            r0.append(r8);
            goto L4
        L6:
            Unit r9 = Unit.INSTANCE;
            this.a = r0.toString();
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ AbsDeepFeedRequest a;
        public final /* synthetic */ Function2 b;

        public b(AbsDeepFeedRequest r1, Function2 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ AbsDeepFeedRequest a;

        public c(AbsDeepFeedRequest r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.m = false;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ AbsDeepFeedRequest a;

        public d(AbsDeepFeedRequest r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.l = false;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // fa3.d
    public final Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.D.add(r2);
        return r2;
    }

    @Override // com.bytedance.android.shopping.deepfeed.data.repo.o
    public Map<String, String> b() {
        return null;
    }

    public void f(InFeedProductResponse r2, com.bytedance.android.shopping.deepfeed.data.a r3) {
        Intrinsics.checkNotNullParameter(r2, "resp");
        Intrinsics.checkNotNullParameter(r3, "cardUpdateState");
    }

    public void h(InFeedProductResponse r2) {
        Intrinsics.checkNotNullParameter(r2, "resp");
    }

    public void A() {
        me3.b r0 = (me3.b) this.h.getValue();
        List<InFeedProductV2> r1 = this.C;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "list");
        Iterator<T> r2 = r1.iterator();
    L4:
        if (r2.hasNext() == false) goto L24;
        InFeedProductV2 r3 = (InFeedProductV2) r2.next();
        Set<String> r4 = DeepFeedProductHeaderView.H0;
        Iterator r5 = ((ArrayList) DeepFeedProductHeaderView.a.c(r3, true)).iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        x0 r6 = (x0) r5.next();
        int r7 = s0.f;
        s0.b(new s0(r6.b, new r("ec_na_deepfeed", "mall_infeed_product_image")));
        goto L7
    L9:
        InFeedProductPackData r8 = r3.getPackData();
        if (r8 == null) goto L4;
        InFeedProductPackDataElements r9 = r8.getElements();
        if (r9 == null) goto L4;
        List<p0> r10 = r9.getProducts();
        if (r10 == null) goto L4;
        p0 r11 = (p0) CollectionsKt.firstOrNull(r10);
        if (r11 == null) goto L4;
        r0 r12 = r11.p();
        if (r12 == null) goto L4;
        k2 r13 = r12.a();
        if (r13 == null) goto L4;
        ECUrlModel r14 = r13.b();
        if (r14 == null) goto L4;
        int r15 = s0.f;
        s0.b(new s0(r14, new r("ec_na_deepfeed", "mall_infeed_product_image")));
        goto L4
    }

    public final void B() {
        this.b.removeCallbacks(this.o);
        this.m = false;
    }

    public final void C() {
        this.b.removeCallbacks(this.n);
        this.l = false;
    }

    public final void k() {
        this.b.removeCallbacksAndMessages(null);
        this.l = false;
        this.m = false;
        ((LinkedHashMap) this.x).clear();
        this.t = null;
        this.u.clear();
        ((LinkedHashMap) this.v).clear();
        this.g = null;
        this.c = null;
        this.D.a();
    }

    public final Map<String, String> l() {
        Map<String, Object> r0 = this.A.getRequestAddition();
        if (r0 == null) goto L26;
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator<Map.Entry<String, Object>> r2 = r0.entrySet().iterator();
    L6:
        if (r2.hasNext() == false) goto L21;
        Map.Entry<String, Object> r3 = r2.next();
        Object r4 = r3.getValue();
        boolean r5 = false;
        if ((r4 instanceof String) == false) goto L15;
        if (((CharSequence) r4).length() <= 0) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == false) goto L15;
    L18:
        r5 = true;
    L19:
        if (r5 == false) goto L6;
        r1.put(r3.getKey(), r3.getValue());
        goto L6
    L12:
        r6 = false;
    L15:
        if ((r4 instanceof Number) == true) goto L18;
        if ((r4 instanceof Boolean) == false) goto L19;
    L21:
        LinkedHashMap r7 = new LinkedHashMap(MapsKt.mapCapacity(r1.size()));
        Iterator r8 = r1.entrySet().iterator();
    L23:
        if (r8.hasNext() == false) goto L33;
        Map.Entry r9 = (Map.Entry) r8.next();
        r7.put(r9.getKey(), r9.getValue().toString());
        goto L23
    L33:
        return r7;
    L26:
        return new LinkedHashMap();
    }

    public final Map<String, String> o() {
        Map<String, String> r0 = l();
        IECMallAddressService r1 = (IECMallAddressService) ServiceManager.get().getService(IECMallAddressService.class);
        String r2 = null;
        if (r1 == null) goto L6;
        r2 = r1.getAddress(null, "a1.b811296.c0.d0");
    L6:
        return MapsKt.plus(r0, MapsKt.mapOf(new Pair[]{TuplesKt.to("biz_code", this.A.getBizCode()), TuplesKt.to("scene_code", this.A.getSceneCode()), TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, this.A.getPageName()), TuplesKt.to(SimilarProductParam.ENTER_FROM, this.A.getEnterFrom()), TuplesKt.to("ecom_scene_id", this.A.getESceneId()), TuplesKt.to("card_param", this.A.getCardParam()), TuplesKt.to("pass_through_params", this.A.getPassThroughParams()), TuplesKt.to("ec_address_data", r2)}));
    }

    public final void w() {
        B();
        Consumer<m> r0 = this.g;     // Catch: Exception -> L7
        if (r0 == null) goto L12;
        r0.accept(new m(Boolean.FALSE, this.C, true, false, null, 48));     // Catch: Exception -> L7
    L12:
        com.bytedance.android.shopping.deepfeed.event.c r1 = this.w;
        r1.a = 0;
        r1.post(null, null);
        com.bytedance.android.shopping.deepfeed.data.repo.a r2 = this.t;
        if (r2 == null) goto L18;
        this.t = null;
        r2.run();
        return;
    L18:
        return;
    L7:
        e = move-exception;
        String r3 = e.getMessage();
        if (r3 != null) goto L11;
        r3 = "";
    L11:
        ECExceptionMonitor.c(r3);
        goto L12
    }

    public static List i(InFeedProductResponse r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$cards");
        List<InFeedProductV2> r0 = r1.getCardsV2();
        if (r0 != null) goto L9;
        u r2 = r1.getBffData();
        if (r2 != null) goto L10;
        return null;
    L10:
        return r2.a();
    L9:
        return r0;
    }

    public static List j(y0 r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$cards");
        List<InFeedProductV2> r0 = r1.b();
        if (r0 != null) goto L9;
        u r2 = r1.a();
        if (r2 != null) goto L10;
        return null;
    L10:
        return r2.a();
    L9:
        return r0;
    }

    public static boolean p(List r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$isCacheOrSkeleton");
        List r5 = r4;
        if ((r5 instanceof Collection) == true) goto L5;
    L7:
        Iterator r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L26;
        InFeedProductV2 r0 = (InFeedProductV2) r6.next();
        if (r0.isCacheData() == false) goto L13;
    L16:
        boolean r1 = true;
    L17:
        if (r1 == false) goto L9;
        return true;
    L13:
        if (r0.isSkeletonData() == true) goto L16;
        r1 = false;
        goto L17
    L26:
        return false;
    L5:
        if (r5.isEmpty() == false) goto L7;
        return false;
    }

    public final int D(int r2) {
        int r0 = this.C.size();
        if (r2 < 0) goto L15;
        if (r0 <= r2) goto L15;
        InFeedProductV2 r3 = (InFeedProductV2) CollectionsKt.getOrNull(this.C, r2);
        if (r3 == null) goto L11;
        v r4 = r3.getDynamicData();
        if (r4 == null) goto L11;
        int r5 = r4.c;
    L12:
        if (r5 < 0) goto L15;
        return r5;
    L11:
        r5 = -1;
    L15:
        return this.y + 1;
    }

    public final void I(MutableLiveData<he3.l> r2) {
        Intrinsics.checkNotNullParameter(r2, "liveData");
        this.c = r2;
    }

    public final void J(Consumer<m> r9) {
        this.g = r9;
        if (this.a == true) goto L5;
        return;
    L5:
        if ((!this.C.isEmpty()) == false) goto L19;
        Consumer<m> r10 = this.g;     // Catch: Exception -> L10
        if (r10 == null) goto L20;
        r10.accept(new m(Boolean.TRUE, this.C, true, false, null, 48));     // Catch: Exception -> L10
        return;
    L20:
        return;
    L10:
        e = move-exception;
        String r11 = e.getMessage();
        if (r11 != null) goto L14;
        r11 = "";
    L14:
        ECExceptionMonitor.c(r11);
        return;
    }

    public final Map<String, String> n(n r10) {
        Map<String, String> r0 = l();
        String r1 = this.A.getPassThroughParams();
        String r2 = null;
        if (r10 == null) goto L5;
        List<String> r3 = r10.b;
    L6:
        List<String> r4 = r3;
        if (r4 != null) goto L9;
    L12:
        boolean r5 = true;
    L13:
        if (r5 == false) goto L44;
    L33:
        IECMallAddressService r6 = (IECMallAddressService) ServiceManager.get().getService(IECMallAddressService.class);
        if (r6 == null) goto L36;
        r2 = r6.getAddress(null, "a1.b811296.c0.d0");
    L36:
        String r7 = this.A.getTriggers();
        if (Intrinsics.areEqual(tc3.a.a().a(), Boolean.TRUE) == false) goto L43;
        if (r10 == null) goto L43;
        String r11 = r10.h;
        if (r11 == null) goto L43;
        r7 = "2_".concat(r11);
    L43:
        return MapsKt.plus(r0, MapsKt.mapOf(new Pair[]{TuplesKt.to("biz_code", this.A.getBizCode()), TuplesKt.to("scene_code", this.A.getSceneCode()), TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, this.A.getPageName()), TuplesKt.to(SimilarProductParam.ENTER_FROM, this.A.getEnterFrom()), TuplesKt.to("ecom_scene_id", this.A.getESceneId()), TuplesKt.to("ec_address_data", r2), TuplesKt.to("triggers", r7), TuplesKt.to("filters", this.A.allFilters()), TuplesKt.to("last_actions", this.A.getLastAction()), TuplesKt.to("count", String.valueOf(this.e)), TuplesKt.to("post_back", this.f), TuplesKt.to("pass_through_params", r1)}));
    L44:
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L31
        JSONObject r9 = com.bytedance.android.shopping.extensions.k.w(this.A.getPassThroughParams());     // Catch: Throwable -> L31
        if (r9 != null) goto L17;
        r9 = new JSONObject();     // Catch: Throwable -> L31
    L17:
        JSONArray r12 = new JSONArray();     // Catch: Throwable -> L31
        if (r10 == null) goto L25;
        List<String> r13 = r10.b;     // Catch: Throwable -> L31
        if (r13 == null) goto L25;
        Iterator<T> r14 = r13.iterator();     // Catch: Throwable -> L31
    L23:
        if (r14.hasNext() == false) goto L25;
        r12.put((String) r14.next());     // Catch: Throwable -> L31
    L25:
        r9.putOpt("feature_info_list", r12);     // Catch: Throwable -> L31
        if (r10 == null) goto L28;
        String r15 = r10.h;     // Catch: Throwable -> L31
    L29:
        r9.putOpt("ai_rec_source_id", r15);     // Catch: Throwable -> L31
        r1 = r9.toString();     // Catch: Throwable -> L31
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L31
        goto L33
    L28:
        r15 = null;
    L31:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L33
    L9:
        if (r4.isEmpty() == true) goto L12;
        r5 = false;
        goto L13
    L5:
        r3 = null;
        goto L6
    }

    public final void u(n r9) {
        if (r9 == null) goto L4;
        List<String> r10 = r9.b;
    L5:
        if (r10 == null) goto L7;
        boolean r11 = true;
    L8:
        if (r11 == false) goto L20;
        return;
    L20:
        Consumer<m> r12 = this.g;     // Catch: Exception -> L14
        if (r12 == null) goto L22;
        r12.accept(new m(null, null, true, true, null, 48));     // Catch: Exception -> L14
        return;
    L22:
        return;
    L14:
        e = move-exception;
        String r13 = e.getMessage();
        if (r13 != null) goto L18;
        r13 = "";
    L18:
        ECExceptionMonitor.c(r13);
        return;
    L7:
        r11 = false;
        goto L8
    L4:
        r10 = null;
        goto L5
    }

    public final void v(boolean r1) {
        this.k = r1;
    }

    public final void E(int r4, int r5) {
        if (r5 > 0) goto L4;
        return;
    L4:
        Iterator<T> r0 = this.C.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        InFeedProductV2 r1 = (InFeedProductV2) r0.next();
        int r2 = r1.getDynamicData().c;
        if (r2 < r4) goto L6;
        int r3 = r2 + r5;
        r1.getDynamicData().c = r3;
        goto L6
    L10:
        Iterator<T> r6 = this.C.iterator();
        if (r6.hasNext() == true) goto L13;
        Integer r7 = null;
    L20:
        if (r7 == null) goto L22;
        int r8 = r7.intValue();
    L24:
        if (r8 <= this.y) goto L37;
        this.y = r8;
        return;
    L37:
        return;
    L22:
        r8 = -1;
        goto L24
    L13:
        Integer r9 = Integer.valueOf(((InFeedProductV2) r6.next()).getDynamicData().c);
    L15:
        if (r6.hasNext() == false) goto L19;
        Integer r10 = Integer.valueOf(((InFeedProductV2) r6.next()).getDynamicData().c);
        if (r9.compareTo(r10) >= 0) goto L15;
        r9 = r10;
        goto L15
    L19:
        r7 = r9;
        goto L20
    }

    public final boolean G(PendingRequestType r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "type");
        Intrinsics.checkNotNullParameter(r5, "requestKey");
        a r6 = (a) ((LinkedHashMap) this.x).get(r4);
        if (r6 != null) goto L5;
        boolean r1 = false;
    L7:
        if (r1 == true) goto L9;
        return true;
    L9:
        if (r6 != null) goto L12;
        return false;
    L12:
        if ((!Intrinsics.areEqual(r6.a, r5)) == false) goto L14;
        return false;
    L14:
        if (r6.d == true) goto L20;
        r6.d = true;
        return true;
    L20:
        return false;
    L5:
        l.a r2 = l.s;
        String r3 = r6.b;
        r2.getClass();
        r1 = l.a.a(r3);
        goto L7
    }

    public final boolean H(PendingRequestType r4, Uri r5) {
        Intrinsics.checkNotNullParameter(r4, "type");
        Intrinsics.checkNotNullParameter(r5, "uri");
        String r0 = r5.getPath();
        if (r0 != null) goto L5;
        return false;
    L5:
        l.s.getClass();
        if (l.a.a(r0) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ((LinkedHashMap) this.x).get(r4);
        if (r6 != null) goto L12;
        return false;
    L12:
        if (t(r6, r5, r0) == true) goto L14;
        return false;
    L14:
        if (r6.d == true) goto L20;
        r6.d = true;
        return true;
    L20:
        return false;
    }

    public final void g(List<InFeedProductV2> r5, int r6) {
        Iterator<T> r0 = r5.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        Object r2 = r0.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        ((InFeedProductV2) r2).getDynamicData().c = r1 + r6;
        r1 = r3;
        goto L4
    L9:
        int r7 = (r6 + r5.size()) - 1;
        if (r7 <= this.y) goto L16;
        this.y = r7;
        return;
    }

    public final boolean q(PendingRequestType r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r4, "requestKey");
        a r5 = (a) ((LinkedHashMap) this.x).get(r3);
        if (r5 != null) goto L5;
        boolean r0 = false;
    L6:
        if (r0 == true) goto L9;
        return true;
    L9:
        if (r5 == null) goto L11;
        String r6 = r5.a;
    L13:
        return Intrinsics.areEqual(r6, r4);
    L11:
        r6 = null;
        goto L13
    L5:
        l.a r1 = l.s;
        String r2 = r5.b;
        r1.getClass();
        r0 = l.a.a(r2);
        goto L6
    }

    public final boolean r(PendingRequestType r4, Uri r5) {
        Intrinsics.checkNotNullParameter(r4, "type");
        Intrinsics.checkNotNullParameter(r5, "uri");
        String r0 = r5.getPath();
        if (r0 != null) goto L5;
        return false;
    L5:
        l.s.getClass();
        if (l.a.a(r0) == true) goto L9;
        return false;
    L9:
        return t((a) ((LinkedHashMap) this.x).get(r4), r5, r0);
    }

    public final boolean s(PendingRequestType r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "type");
        Intrinsics.checkNotNullParameter(r5, "requestKey");
        a r6 = (a) ((LinkedHashMap) this.x).get(r4);
        if (r6 != null) goto L5;
        boolean r1 = false;
    L6:
        if (r1 == true) goto L8;
        return false;
    L8:
        if (r6 != null) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(r6.a, r5) == true) goto L13;
        return false;
    L13:
        if (r6.d == false) goto L17;
        return true;
    L17:
        return false;
    L5:
        l.a r2 = l.s;
        String r3 = r6.b;
        r2.getClass();
        r1 = l.a.a(r3);
        goto L6
    }

    public final void x(final InFeedProductResponse r9, final n r10) {
        Intrinsics.checkNotNullParameter(r9, "resp");
        B();
        if (r10 != null) goto L11;
        a1 r1 = r9.getPage();
        if (r1 == null) goto L7;
        String r2 = r1.b();
    L8:
        if (r2 != null) goto L10;
        r2 = "";
    L10:
        this.f = r2;
        goto L11
    L7:
        r2 = null;
    L11:
        final Function0<Unit> r3 = new AbsDeepFeedRequest$onFeedSuccess$insertMethod$1(this, r10, r9);
        if (r10 == null) goto L16;
        Integer r11 = r10.c;
        if (r11 == null) goto L16;
        int r12 = r11.intValue();
    L17:
        if (r12 > 0) goto L19;
    L35:
        r3.invoke();
    L37:
        if (this.j == false) goto L39;
        this.i.b = System.currentTimeMillis();
        this.j = false;
    L39:
        com.bytedance.android.shopping.deepfeed.data.repo.a r13 = this.t;
        if (r13 == null) goto L43;
        this.t = null;
        r13.run();
        return;
    L43:
        return;
    L19:
        if (((Number) this.r.getValue()).intValue() <= 0) goto L35;
        final Ref.BooleanRef r14 = new Ref.BooleanRef();
        r14.element = false;
        final Function0<Unit> r4 = new AbsDeepFeedRequest$tryDelayExecute$delayRun$1(r14, r3);
        this.b.postDelayed(new com.bytedance.android.shopping.deepfeed.data.repo.b(r4), ((Number) this.r.getValue()).intValue());
        List r15 = i(r9);
        if (r15 == null) goto L23;
        InFeedProductV2 r16 = (InFeedProductV2) CollectionsKt.firstOrNull(r15);
    L25:
        if (r16 == null) goto L27;
        me3.b r17 = (me3.b) this.h.getValue();
        Function0<Unit> r5 = new AbsDeepFeedRequest$tryDelayExecute$2(this, r4);
        r17.getClass();
        Intrinsics.checkNotNullParameter(r16, "card");
        Intrinsics.checkNotNullParameter(r5, "success");
        Set<String> r18 = DeepFeedProductHeaderView.H0;
        List r19 = DeepFeedProductHeaderView.a.c(r16, true);
        if (((ArrayList) r19).isEmpty() == false) goto L32;
        r5.invoke();
        goto L37
    L32:
        x0 r20 = (x0) CollectionsKt.firstOrNull(r19);
        if (r20 == null) goto L37;
        int r110 = s0.f;
        s0 r6 = new s0(r20.b, new r("ec_na_deepfeed", "mall_infeed_product_image"));
        me3.a r21 = new me3.a(r5);
        Intrinsics.checkNotNullParameter(r21, "listener");
        r6.c = r21;
        s0.b(r6);
        goto L37
    L27:
        if (r14.element == true) goto L37;
        r14.element = true;
        r3.invoke();
        goto L37
    L23:
        r16 = null;
    L16:
        r12 = 0;
        goto L17
    }

    public final void y(Throwable r9, Function2<? super Boolean, ? super InFeedProductV2, Unit> r10) {
        Intrinsics.checkNotNullParameter(r9, "error");
        Intrinsics.checkNotNullParameter(r10, "callback");
        C();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L5
        r1.putOpt("error_msg", r9.getMessage());     // Catch: Throwable -> L5
        r1.putOpt("type", "pack");     // Catch: Throwable -> L5
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L5
        AppLogNewUtils.onEventV3("deep_feed_request_error", r1);     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L8:
        if (((Number) this.p.getValue()).intValue() > 0) goto L10;
    L12:
        Consumer<m> r12 = this.g;
        if (r12 == null) goto L15;
        r12.accept(new m(Boolean.FALSE, null, false, false, null, 32));
    L15:
        r10.invoke(Boolean.FALSE, null);
        return;
    L10:
        if (this.q >= ((Number) this.p.getValue()).intValue()) goto L12;
        this.q++;
        this.b.postDelayed(new b(this, r10), 1000);
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public final void z(y0 r13, Function2<? super Boolean, ? super InFeedProductV2, Unit> r14) {
        Intrinsics.checkNotNullParameter(r13, "resp");
        Intrinsics.checkNotNullParameter(r14, "callback");
        List r1 = j(r13);
        int r2 = 0;
        if (r1 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        InFeedProductV2 r4 = null;
        if (r3 == true) goto L166;
        Intrinsics.checkNotNullParameter(r13, "resp");
        l.s.getClass();
        String r5 = "";
        if (l.r == false) goto L85;
        tf3.b r0 = this.B;
        if (r0 == null) goto L85;
        if (r0.b == null) goto L85;
        List r6 = j(r13);
        if (r6 == null) goto L85;
        Iterator r7 = r6.iterator();
    L23:
        if (r7.hasNext() == false) goto L85;
        InFeedProductV2 r8 = (InFeedProductV2) r7.next();
        InFeedProductPackData r9 = r8.getPackData();
        if (r9 == null) goto L29;
        InFeedProductPackDataElements r10 = r9.getElements();
        if (r10 == null) goto L29;
        ie3.a r11 = r10.getAd();
    L30:
        if (r11 != null) goto L23;
        tf3.b r12 = this.B;
        if (r12 == null) goto L35;
        String r15 = r12.a;
    L36:
        if (r15 != null) goto L38;
    L41:
        boolean r16 = true;
    L42:
        if (r16 == true) goto L71;
        InFeedProductPackData r17 = r8.getPackData();
        if (r17 == null) goto L71;
        InFeedProductPackDataElements r18 = r17.getElements();
        if (r18 == null) goto L71;
        List<p0> r19 = r18.getProducts();
        if (r19 == null) goto L71;
        Iterator<T> r20 = r19.iterator();
    L51:
        if (r20.hasNext() == false) goto L71;
        e1 r21 = ((p0) r20.next()).b();
        if (r21 == null) goto L51;
        String r22 = r21.a();
        if (r22 == null) goto L51;
        tf3.b r23 = this.B;
        if (r23 == null) goto L59;
        String r24 = r23.a;
    L61:
        if ((!Intrinsics.areEqual(r22, r24)) == false) goto L51;
        JSONObject r25 = new JSONObject();
        z0 r26 = r13.c();
        if (r26 == null) goto L65;
        String r27 = r26.c();
    L66:
        r25.putOpt("log_id", r27);
        tf3.b r28 = this.B;
        if (r28 == null) goto L69;
        String r29 = r28.a;
    L70:
        r25.putOpt("schema_product_id", r29);
        r25.putOpt(PdpOpenThirdParam.KEY_PRODUCT_ID, r22);
        Unit r30 = Unit.INSTANCE;
        AppLogNewUtils.onEventV3("mall_deep_feed_ad_error", r25);
        goto L51
    L69:
        r29 = null;
        goto L70
    L65:
        r27 = null;
        goto L66
    L59:
        r24 = null;
    L71:
        tf3.b r31 = this.B;
        if (r31 == null) goto L23;
        JSONObject r32 = r31.b;
        if (r32 == null) goto L23;
        AdBaseInfo r33 = new AdBaseInfo();
        Object r34 = r32.opt("id");
        if (r34 == null) goto L79;
        String r35 = r34.toString();
        if (r35 == null) goto L79;
    L80:
        r33.setId(r35);
        r33.setShowAdTag(r32.optBoolean("show_ad_tag", false));
        r33.setFromOuter(true);
        r33.setSameRit(true);
        String r36 = r32.optString("raw_data", "");
        JSONObject r37 = new JSONObject();
        r37.putOpt("raw_data", r36);
        r33.setAdPackCell(r37.toString());
        InFeedProductPackData r38 = r8.getPackData();
        if (r38 == null) goto L23;
        InFeedProductPackDataElements r39 = r38.getElements();
        if (r39 == null) goto L23;
        ie3.a r40 = new ie3.a();
        r40.b(r33);
        Unit r41 = Unit.INSTANCE;
        r39.setAd(r40);
    L79:
        r35 = "";
        goto L80
    L38:
        if (r15.length() == 0) goto L41;
        r16 = false;
        goto L42
    L35:
        r15 = null;
    L29:
        r11 = null;
    L85:
        DeepFeedQueryParam r42 = this.A;
        List r43 = j(r13);
        if (r43 == null) goto L92;
        InFeedProductV2 r44 = (InFeedProductV2) CollectionsKt.firstOrNull(r43);
        if (r44 == null) goto L92;
        e1 r45 = com.bytedance.android.shopping.deepfeed.utlis.a.a(r44);
        if (r45 == null) goto L92;
        String r46 = r45.a();
    L93:
        r42.setFirstCardProductId(r46);
        List<InFeedProductV2> r47 = j(r13);
        if (r47 != null) goto L96;
        r47 = CollectionsKt.emptyList();
    L96:
        m(r47, r13.c(), true, null);
        if (this.C.size() <= 1) goto L102;
        if (p(this.C) == true) goto L102;
        this.C.clear();
    L102:
        if (this.C.size() != 1) goto L104;
    L105:
        List r48 = j(r13);
        if (r48 != null) goto L108;
    L146:
        List<InFeedProductV2> r49 = this.C;
        List r50 = j(r13);
        if (r50 != null) goto L150;
        r50 = CollectionsKt.emptyList();
    L150:
        r49.addAll(0, r50);
    L151:
        this.a = true;
        Consumer<m> r51 = this.g;     // Catch: Exception -> L156
        if (r51 == null) goto L162;
        r51.accept(new m(Boolean.TRUE, this.C, true, false, null, 32));     // Catch: Exception -> L156
    L162:
        Boolean r52 = Boolean.TRUE;
        List r110 = j(r13);
        if (r110 == null) goto L165;
        r4 = (InFeedProductV2) CollectionsKt.firstOrNull(r110);
    L165:
        r14.invoke(r52, r4);
        return;
    L156:
        e = move-exception;
        String r53 = e.getMessage();
        if (r53 == null) goto L161;
        r5 = r53;
    L161:
        ECExceptionMonitor.c(r5);
        goto L162
    L108:
        if (r48.size() != 1) goto L146;
        List r54 = j(r13);
        if (r54 == null) goto L112;
        InFeedProductV2 r55 = (InFeedProductV2) CollectionsKt.firstOrNull(r54);
    L113:
        if (r55 == null) goto L117;
        v r56 = r55.getDynamicData();
        if (r56 == null) goto L117;
        r56.e = true;
    L117:
        if (r55 == null) goto L123;
        InFeedProductPackData r57 = r55.getPackData();
        if (r57 == null) goto L123;
        InFeedProductPackDataElements r58 = r57.getElements();
        if (r58 == null) goto L123;
        List<p0> r59 = r58.getProducts();
    L124:
        if (r59 != null) goto L133;
        if (r55 == null) goto L131;
        InFeedProductPackData r60 = r55.getPackData();
        if (r60 == null) goto L131;
        InFeedProductPackDataElements r61 = r60.getElements();
        if (r61 == null) goto L131;
        n0 r62 = r61.getSliceCard();
    L132:
        if (r62 == null) goto L151;
    L131:
        r62 = null;
    L133:
        this.C.clear();
        List<InFeedProductV2> r63 = this.C;
        List r64 = j(r13);
        if (r64 != null) goto L137;
        r64 = CollectionsKt.emptyList();
    L137:
        r63.addAll(0, r64);
        if (this.z == false) goto L151;
        if (DeepFeedRepHelpKt.b() == 2) goto L144;
        if (DeepFeedRepHelpKt.b() != 3) goto L151;
    L144:
        if (r2 >= 10) goto L151;
        List<InFeedProductV2> r65 = this.C;
        InFeedProductV2 r66 = new InFeedProductV2();
        r66.setSkeletonData(true);
        Unit r67 = Unit.INSTANCE;
        r65.add(r66);
        r2 = r2 + 1;
    L123:
        r59 = null;
        goto L124
    L112:
        r55 = null;
        goto L113
    L104:
        if (p(this.C) == false) goto L146;
    L92:
        r46 = null;
        goto L93
    L166:
        Consumer<m> r111 = this.g;
        if (r111 == null) goto L169;
        r111.accept(new m(Boolean.FALSE, null, false, false, null, 32));
    L169:
        r14.invoke(Boolean.FALSE, null);
        return;
    L5:
        if (r1.isEmpty() == true) goto L8;
        r3 = false;
        goto L9
    }

    public static final void e(AbsDeepFeedRequest r16, InFeedProductResponse r17, n r18) {
        r16.getClass();
        com.bytedance.android.shopping.deepfeed.data.a r2 = new com.bytedance.android.shopping.deepfeed.data.a(false, 0, false, 7);
        List<InFeedProductV2> r5 = i(r17);
        List<InFeedProductV2> r6 = r5;
        if (r6 != null) goto L5;
    L8:
        boolean r7 = true;
    L10:
        if (r7 == true) goto L98;
        r16.h(r17);
        z0 r3 = r17.getExtra();
        if (r18 == null) goto L14;
        Integer r8 = r18.f;
    L15:
        r16.m(r5, r3, false, r8);
        if (r18 == null) goto L18;
        List<String> r4 = r18.b;
    L19:
        if (r4 == null) goto L21;
        boolean r9 = true;
    L22:
        if (r9 == true) goto L24;
        r16.d++;
    L24:
        Iterator<InFeedProductV2> r10 = r16.C.iterator();
    L26:
        if (r10.hasNext() == false) goto L31;
        if (r10.next().isSkeletonData() == false) goto L26;
        r10.remove();
        goto L26
    L31:
        if (r18 == null) goto L55;
        Integer r11 = r18.c;
        if (r11 == null) goto L55;
        int r12 = r11.intValue();
        int r13 = r16.D(r12);
        r16.E(r13, r5.size());
        r16.g(r5, r13);
        Iterator<T> r14 = r5.iterator();
        int r15 = 0;
    L36:
        if (r14.hasNext() == false) goto L52;
        Object r19 = r14.next();
        int r110 = r15 + 1;
        if (r15 >= 0) goto L40;
        CollectionsKt.throwIndexOverflow();
    L40:
        InFeedProductV2 r111 = (InFeedProductV2) r19;
        r111.getDynamicData().k = r18.a;
        if (r15 != 0) goto L45;
        r111.getDynamicData().h = 2;
        if (r5.size() <= 1) goto L50;
        r111.getDynamicData().i = true;
    L50:
        r15 = r110;
        goto L36
    L45:
        if (r15 != 1) goto L48;
        r111.getDynamicData().h = 3;
        goto L50
    L48:
        if (r18.d == true) goto L50;
        r111.getDynamicData().h = 6;
        goto L50
    L52:
        if (r12 > r16.C.size()) goto L54;
        r16.C.addAll(r12, r5);
    L54:
        com.bytedance.android.shopping.deepfeed.data.a r1 = new com.bytedance.android.shopping.deepfeed.data.a(true, r12, false, 4);
    L97:
        r2 = r1;
        r16.f(r17, r2);
        com.bytedance.android.shopping.deepfeed.event.c r20 = r16.w;
        r20.a = 1;
        r20.post(null, null);
    L99:
        com.bytedance.android.shopping.deepfeed.data.a r112 = r2;
    L115:
        e = move-exception;
        String r0 = e.getMessage();
        if (r0 != null) goto L119;
        r0 = "";
    L119:
        ECExceptionMonitor.c(r0);
        return;
    L101:
        if (r16.a == false) goto L103;
    L106:
        Consumer<m> r21 = r16.g;     // Catch: Exception -> L115
        if (r21 == null) goto L113;
        Boolean r113 = Boolean.TRUE;     // Catch: Exception -> L115
        List<InFeedProductV2> r114 = r16.C;     // Catch: Exception -> L115
        a1 r22 = r17.getPage();     // Catch: Exception -> L115
        if (r22 == null) goto L111;
        boolean r115 = r22.a();     // Catch: Exception -> L115
    L112:
        r21.accept(new m(r113, r114, r115, false, r112, 16));     // Catch: Exception -> L115
        goto L113
    L111:
        r115 = true;
    L113:
        r16.A();     // Catch: Exception -> L115
        return;
    L103:
        if (r16.k == true) goto L105;
        return;
    L105:
        if (((Boolean) DeepFeedRepHelpKt.b.getValue()).booleanValue() == true) goto L106;
        return;
    L55:
        if (r18 == null) goto L96;
        Integer r23 = r18.e;
        if (r23 == null) goto L96;
        int r24 = r23.intValue();
        Iterator<T> r25 = r16.C.iterator();
    L60:
        if (r25.hasNext() == false) goto L69;
        Object r116 = r25.next();
        InFeedProductV2 r117 = (InFeedProductV2) r116;
        if (r117.getDynamicData().h == 4) goto L64;
    L66:
        boolean r118 = false;
    L67:
        if (r118 == false) goto L60;
    L70:
        InFeedProductV2 r119 = (InFeedProductV2) r116;
        if (r119 == null) goto L75;
        v r26 = r119.getDynamicData();
        if (r26 == null) goto L75;
        int r27 = r26.c;
    L76:
        r16.g(r5, r27);
        r16.E(r27 + 1, r5.size() - 1);
        Iterator<T> r28 = r5.iterator();
        int r29 = 0;
    L78:
        if (r28.hasNext() == false) goto L90;
        Object r120 = r28.next();
        int r121 = r29 + 1;
        if (r29 >= 0) goto L82;
        CollectionsKt.throwIndexOverflow();
    L82:
        InFeedProductV2 r122 = (InFeedProductV2) r120;
        if (r29 != 0) goto L87;
        r122.getDynamicData().h = 5;
        if (r119 == null) goto L87;
        r119.getDynamicData().h = 5;
        r119.getDynamicData().c = r27;
        r119.setPackData(r122.getPackData());
        r119.setCustom(r122.getCustom());
        r119.setRespExtra(r122.getRespExtra());
    L87:
        if (r29 != 1) goto L89;
        r122.getDynamicData().h = 3;
    L89:
        r29 = r121;
        goto L78
    L90:
        int r30 = r24 + 1;
        if (r30 <= r16.C.size()) goto L93;
    L95:
        r1 = new com.bytedance.android.shopping.deepfeed.data.a(false, 0, true, 3);
        goto L97
    L93:
        if (r5.size() <= 1) goto L95;
        r16.C.addAll(r30, r5.subList(1, r5.size()));
    L75:
        r27 = r16.D(r24);
        goto L76
    L64:
        if (Intrinsics.areEqual(r117.getDynamicData().l, r18.g) == false) goto L66;
        r118 = true;
        goto L67
    L69:
        r116 = null;
    L96:
        r16.g(r5, r16.y + 1);
        r16.C.addAll(r5);
        r1 = new com.bytedance.android.shopping.deepfeed.data.a(false, 0, false, 7);
        goto L97
    L21:
        r9 = false;
        goto L22
    L18:
        r4 = null;
        goto L19
    L14:
        r8 = null;
        goto L15
    L98:
        com.bytedance.android.shopping.deepfeed.event.c r31 = r16.w;
        r31.a = 0;
        r31.post(null, null);
        goto L99
    L5:
        if (r6.isEmpty() == true) goto L8;
        r7 = false;
        goto L10
    }

    public static boolean t(a r3, Uri r4, String r5) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if ((!Intrinsics.areEqual(r5, r3.b)) == false) goto L8;
        return false;
    L8:
        Set<String> r6 = r3.c.keySet();
        ArrayList r0 = new ArrayList();
        Iterator<T> r7 = r6.iterator();
    L10:
        if (r7.hasNext() == false) goto L18;
        String r1 = (String) r7.next();
        String r2 = UriProtector.getQueryParameter(r4, r1);
        if (r2 == null) goto L14;
        Pair r8 = TuplesKt.to(r1, r2);
    L15:
        if (r8 == null) goto L10;
        r0.add(r8);
        goto L10
    L14:
        r8 = null;
        goto L15
    L18:
        return Intrinsics.areEqual(MapsKt.toMap(r0), r3.c);
    }

    public final String F(PendingRequestType r5, String r6, Map<String, String> r7) {
        Intrinsics.checkNotNullParameter(r5, "type");
        Intrinsics.checkNotNullParameter(r6, "path");
        Intrinsics.checkNotNullParameter(r7, "params");
        l.s.getClass();
        if (l.a.a(r6) == true) goto L6;
        return "";
    L6:
        ArrayList r1 = new ArrayList();
        Iterator<Map.Entry<String, String>> r8 = r7.entrySet().iterator();
    L8:
        if (r8.hasNext() == false) goto L15;
        Map.Entry<String, String> r2 = r8.next();
        String r3 = r2.getKey();
        String r4 = r2.getValue();
        if (r4 == null) goto L12;
        Pair r9 = TuplesKt.to(r3, r4);
    L13:
        if (r9 == null) goto L8;
        r1.add(r9);
        goto L8
    L12:
        r9 = null;
        goto L13
    L15:
        a r0 = new a(r6, MapsKt.toMap(r1));
        this.x.put(r5, r0);
        return r0.a;
    }

    public AbsDeepFeedRequest(boolean r2, DeepFeedQueryParam r3, tf3.b r4, List<InFeedProductV2> r5) {
        Intrinsics.checkNotNullParameter(r3, "deepFeedParam");
        Intrinsics.checkNotNullParameter(r5, "inFeedProductList");
        this.D = new fa3.b();
        this.z = r2;
        this.A = r3;
        this.B = r4;
        this.C = r5;
        this.b = new Handler(Looper.getMainLooper());
        this.d = 1;
        this.e = 4;
        this.f = "";
        this.h = LazyKt.lazy(AbsDeepFeedRequest$preloader$2.INSTANCE);
        this.i = new j();
        this.j = true;
        this.n = new d(this);
        this.o = new c(this);
        this.p = LazyKt.lazy(AbsDeepFeedRequest$packRetry$2.INSTANCE);
        this.r = LazyKt.lazy(AbsDeepFeedRequest$delayInsertTime$2.INSTANCE);
        this.s = LazyKt.lazy(AbsDeepFeedRequest$delayInsertAfterImageSuccess$2.INSTANCE);
        this.u = new LinkedHashSet();
        this.v = new LinkedHashMap();
        this.w = new com.bytedance.android.shopping.deepfeed.event.c();
        this.x = new LinkedHashMap();
        this.y = -1;
    }

    @Override // com.bytedance.android.shopping.deepfeed.data.repo.o
    public final void d(int r12, String r13, String r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r13, "text");
        Intrinsics.checkNotNullParameter(r14, "uuid");
        if (r12 >= 0) goto L5;
        return;
    L5:
        if (r12 > this.C.size()) goto L20;
        int r0 = D(r12);
        E(r0, 1);
        InFeedProductV2 r1 = new InFeedProductV2();
        r1.getDynamicData().h = 4;
        r1.getDynamicData().k = r13;
        r1.getDynamicData().getClass();
        r1.getDynamicData().l = r14;
        r1.getDynamicData().c = r0;
        ListProtector.add(this.C, r12, r1);
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L14
        Consumer<m> r17 = this.g;     // Catch: Throwable -> L14
        if (r17 == null) goto L11;
        r17.accept(new m(Boolean.TRUE, this.C, true, false, new com.bytedance.android.shopping.deepfeed.data.a(r15, r12, false, 4), 16));     // Catch: Throwable -> L14
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L14
    L12:
        Result.constructor-impl(r18);     // Catch: Throwable -> L14
        return;
    L11:
        r18 = null;
    L14:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    }

    public final void m(List<InFeedProductV2> r7, z0 r8, boolean r9, Integer r10) {
        Intrinsics.checkNotNullParameter(r7, "list");
        if (r10 == null) goto L5;
        int r11 = r10.intValue() + 1;
    L6:
        Iterator<T> r1 = r7.iterator();
    L8:
        if (r1.hasNext() == false) goto L45;
        InFeedProductV2 r2 = (InFeedProductV2) r1.next();
        if (r8 != null) goto L12;
        z0 r4 = new z0();
    L13:
        r2.setRespExtra(r4);
        if (r9 == false) goto L32;
        u0 r5 = r2.getCustom();
        if (r5 == null) goto L18;
        String r6 = r5.a();
    L19:
        if (r6 != null) goto L21;
    L24:
        boolean r12 = true;
    L25:
        if (r12 == false) goto L32;
        if (r2.getCustom() != null) goto L29;
        r2.setCustom(new u0());
    L29:
        u0 r13 = r2.getCustom();
        if (r13 == null) goto L32;
        r13.c(this.A.getRecommendInfo());
        goto L32
    L21:
        if (r6.length() == 0) goto L24;
        r12 = false;
        goto L25
    L18:
        r6 = null;
    L32:
        if (r9 == false) goto L39;
        z0 r14 = r2.getRespExtra();
        if (r14 == null) goto L36;
        r14.a = true;
    L36:
        z0 r15 = r2.getRespExtra();
        if (r15 == null) goto L42;
        r15.d(0);
    L42:
        String r3 = DeepFeedRepHelpKt.a(r2);
        if (r3 == null) goto L8;
        this.A.filtersToAll(r3);
        goto L8
    L39:
        z0 r16 = r2.getRespExtra();
        if (r16 == null) goto L42;
        r16.d(Integer.valueOf(r11 - 1));
        goto L42
    L12:
        r4 = r8;
        goto L13
    L45:
        if (r9 == false) goto L53;
        g(r7, 0);
        return;
    L53:
        return;
    L5:
        r11 = this.d;
        goto L6
    }
}
