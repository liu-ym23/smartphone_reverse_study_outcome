package com.bytedance.android.shopping.mall.homepage.tools;

import android.content.Context;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.shopping.api.mall.IECMallAddressService;
import com.bytedance.android.shopping.api.mall.common.tools.StorageItemDataProvider;
import com.bytedance.android.shopping.mall.homepage.ECMallFragment;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class MallNetApplier implements com.bytedance.android.ec.hybrid.data.g {
    public static final Lazy b = null;
    public final a.d a;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.homepage.tools.MallNetApplier$a$a, reason: collision with other inner class name */
        public static final class C0110a {
            public final Map<String, Object> a;
            public final Object b;
            public final String c;

            public final boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof C0110a) == false) goto L12;
                C0110a r4 = (C0110a) r3;
                if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
                return false;
            L19:
                return true;
            L12:
                return false;
            }

            public final int hashCode() {
                Map<String, Object> r0 = this.a;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                Object r4 = this.b;
                if (r4 == null) goto L9;
                int r5 = r4.hashCode();
            L10:
                int r6 = (r3 + r5) * 31;
                String r7 = this.c;
                if (r7 == null) goto L14;
                r1 = r7.hashCode();
            L14:
                return r6 + r1;
            L9:
                r5 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            public final String toString() {
                return "MallNetApplierDealParams(queryMap=" + this.a + ", btmNode=" + this.b + ", btm=" + this.c + ")";
            }

            public C0110a(ECMallFragment r2) {
                this.a = null;
                this.b = r2;
                this.c = null;
            }
        }

        public static final class b {
            public final com.bytedance.android.shopping.mall.homepage.pagecard.d a;

            public final boolean equals(Object r2) {
                if (this != r2) goto L4;
                return true;
            L4:
                if ((r2 instanceof b) == true) goto L6;
                return false;
            L6:
                if (Intrinsics.areEqual(this.a, ((b) r2).a) == true) goto L13;
                return false;
            L13:
                return true;
            }

            public final int hashCode() {
                com.bytedance.android.shopping.mall.homepage.pagecard.d r0 = this.a;
                if (r0 != null) goto L7;
                return 0;
            L7:
                return r0.hashCode();
            }

            public final String toString() {
                return "MallNetApplierDynamicParams(pageCardManager=" + this.a + ")";
            }

            public b(com.bytedance.android.shopping.mall.homepage.pagecard.d r1) {
                this.a = r1;
            }
        }

        public static final class c {
            public final int a;
            public final int b;
            public final Map<String, Object> c;
            public final Integer d;
            public final Map<String, String> e;
            public final int f;
            public final HashMap<String, String> g;

            public final boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof c) == false) goto L20;
                c r4 = (c) r3;
                if (this.a == r4.a) goto L8;
                return false;
            L8:
                if (this.b == r4.b) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
                return false;
            L14:
                if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
                return false;
            L16:
                if (this.f == r4.f) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.g, r4.g) == true) goto L31;
                return false;
            L31:
                return true;
            L20:
                return false;
            }

            public final int hashCode() {
                int r0 = ((this.a * 31) + this.b) * 31;
                Map<String, Object> r1 = this.c;
                int r2 = 0;
                if (r1 == null) goto L5;
                int r3 = r1.hashCode();
            L6:
                int r4 = (r0 + r3) * 31;
                Integer r5 = this.d;
                if (r5 == null) goto L9;
                int r6 = r5.hashCode();
            L10:
                int r7 = (r4 + r6) * 31;
                Map<String, String> r8 = this.e;
                if (r8 == null) goto L13;
                int r9 = r8.hashCode();
            L14:
                int r10 = (((r7 + r9) * 31) + this.f) * 31;
                HashMap<String, String> r11 = this.g;
                if (r11 == null) goto L18;
                r2 = r11.hashCode();
            L18:
                return r10 + r2;
            L13:
                r9 = 0;
                goto L14
            L9:
                r6 = 0;
                goto L10
            L5:
                r3 = 0;
                goto L6
            }

            public final String toString() {
                return "MallNetApplierExtraParams(pageNum=" + this.a + ", cursor=" + this.b + ", queryMap=" + this.c + ", initialTabId=" + this.d + ", grassParams=" + this.e + ", backUpOffset=" + this.f + ", refreshHomepageReqParams=" + this.g + ")";
            }

            public c(int r1, Integer r2, Map r3, int r4, HashMap r5) {
                this.a = r1;
                this.b = 0;
                this.c = null;
                this.d = r2;
                this.e = r3;
                this.f = r4;
                this.g = r5;
            }
        }

        public interface d {
            c a();

            e b();

            DataEngineWrapper c();

            C0110a d();

            b e();
        }

        public static final class e {
            public final Context a;

            public final boolean equals(Object r2) {
                if (this != r2) goto L4;
                return true;
            L4:
                if ((r2 instanceof e) == true) goto L6;
                return false;
            L6:
                if (Intrinsics.areEqual(this.a, ((e) r2).a) == true) goto L13;
                return false;
            L13:
                return true;
            }

            public final int hashCode() {
                Context r0 = this.a;
                if (r0 != null) goto L7;
                return 0;
            L7:
                return r0.hashCode();
            }

            public final String toString() {
                return "MallNetApplierStorageParams(context=" + this.a + ")";
            }

            public final Context getContext() {
                return this.a;
            }

            public e(Context r1) {
                this.a = r1;
            }
        }
    }

    static {
        b = LazyKt.lazy(MallNetApplier$Companion$homepageForceNum1$2.INSTANCE);
    }

    public MallNetApplier(com.bytedance.android.shopping.mall.homepage.e r2) {
        Intrinsics.checkNotNullParameter(r2, "paramsProvider");
        this.a = r2;
    }

    public final Map<String, Object> a(String r12) {
        Intrinsics.checkNotNullParameter(r12, "apiKey");
        HashMap r0 = new HashMap();
        a.c r3 = this.a.a();
        LinkedHashMap r4 = new LinkedHashMap();
        boolean r6 = true;
        r4.put("page_num", String.valueOf(r3.a + 1));
        r4.put("cursor", String.valueOf(r3.b));
        r4.put("recommend_back_up_offset", String.valueOf(r3.f));
        Map<String, Object> r5 = r3.c;
        if (r5 == null) goto L10;
        Iterator<Map.Entry<String, Object>> r7 = r5.entrySet().iterator();
    L6:
        if (r7.hasNext() == false) goto L10;
        Map.Entry<String, Object> r8 = r7.next();
        String r9 = r8.getKey();
        Object r10 = r8.getValue();
        if (r4.containsKey(r9) == true) goto L6;
        r4.put(r9, r10.toString());
    L10:
        Integer r11 = r3.d;
        if (r11 == null) goto L13;
        int r13 = r11.intValue();
    L14:
        r4.put("tab_id", Integer.valueOf(r13));
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L28
        JSONObject r15 = new JSONObject();     // Catch: Throwable -> L28
        Integer r16 = r3.d;     // Catch: Throwable -> L28
        if (r16 == null) goto L18;
        r15.put("tab_id", String.valueOf(r16.intValue()));     // Catch: Throwable -> L28
    L18:
        Map<String, String> r17 = r3.e;     // Catch: Throwable -> L28
        if (r17 != null) goto L21;
    L26:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L28
        r4.put("log_extra", r15.toString());     // Catch: Throwable -> L28
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L28
    L30:
        HashMap<String, String> r2 = r3.g;
        if (r2 == null) goto L36;
        Iterator<Map.Entry<String, String>> r18 = r2.entrySet().iterator();
    L34:
        if (r18.hasNext() == false) goto L36;
        Map.Entry<String, String> r19 = r18.next();
        r4.put(r19.getKey(), r19.getValue());
    L36:
        v93.a.c.getClass();
        String r20 = v93.a.b;
        if (r20.length() > 0) goto L40;
        r6 = false;
    L40:
        if (r6 == false) goto L42;
        r4.put("pitaya_info", r20);
    L42:
        ECMallFavoriteSectionHelper.K.getClass();
        if (Intrinsics.areEqual(ECMallFavoriteSectionHelper.a.a().a(), Boolean.TRUE) == false) goto L45;
        r4.put("is_active_refresh", Boolean.FALSE);
    L45:
        Lazy r21 = ECMallLogUtil.a;
        ECMallLogUtil.h(com.bytedance.android.ec.hybrid.log.mall.e.b.b, r4, "request extra params is : ");
        r0.putAll(r4);
        g(r0, r12);
        return r0;
    L21:
        if ((!r17.isEmpty()) == true) goto L24;
        r17 = null;
    L24:
        if (r17 == null) goto L26;
        r15.put("video_guide_mall", r17.get("video_guide_mall"));     // Catch: Throwable -> L28
        r15.put("xtab_toast_info", r17.get("xtab_toast_info"));     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    L13:
        r13 = 0;
        goto L14
    }

    public final Map<String, Object> c(List<String> r3) {
        Intrinsics.checkNotNullParameter(r3, "keys");
        return new StorageItemDataProvider(this.a.b().getContext()).a(r3);
    }

    public final Map<String, String> d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "apiKey");
        return MapsKt.emptyMap();
    }

    public final Map e(String r1, String r2) {
        return new HashMap();
    }

    public final Map<String, Object> f(String r2, Map<String, Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "apiKey");
        Intrinsics.checkNotNullParameter(r3, "paramsContext");
        com.bytedance.android.shopping.mall.homepage.pagecard.d r0 = this.a.e().a;
        if (r0 == null) goto L8;
        com.bytedance.android.shopping.mall.homepage.pagecard.c r1 = r0.a();
        if (r1 == null) goto L8;
        Map<String, Object> r4 = r1.d(r2, r3);
        if (r4 == null) goto L8;
    L10:
        return MapsKt.toMutableMap(r4);
    L8:
        r4 = new HashMap();
        goto L10
    }

    public final void g(Map<String, Object> r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "extraParams");
        Intrinsics.checkNotNullParameter(r8, "apiKey");
        a.C0110a r0 = this.a.d();
        if (Intrinsics.areEqual(r8, "homepage") == true) goto L5;
    L9:
        Lazy r2 = HybridAppInfoService.a;
        if (HybridAppInfoService.i() == false) goto L19;
        if (Intrinsics.areEqual(r8, "homepage") == false) goto L19;
        Map<String, Object> r3 = r0.a;
        if (r3 == null) goto L19;
        Object r4 = r3.get("ecom_scene_id");
        if (r4 == null) goto L19;
        r7.put("ecom_scene_id", r4);
    L19:
        if (r7.containsKey("ec_address_data") == false) goto L21;
        return;
    L21:
        if (Intrinsics.areEqual(r8, "homepage") == false) goto L23;
    L28:
        DataEngineWrapper r9 = this.a.c();
        String r1 = null;
        if (r9 == null) goto L31;
        String r10 = r9.d();
    L32:
        boolean r5 = true;
        if (r10 != null) goto L35;
    L38:
        boolean r6 = true;
    L39:
        if (r6 == false) goto L54;
        IECMallAddressService r11 = (IECMallAddressService) ServiceManager.get().getService(IECMallAddressService.class);
        if (r11 == null) goto L58;
        String r12 = r11.getAddress(r0.b, r0.c);
        if (r12 != null) goto L45;
        return;
    L45:
        if (r12.length() > 0) goto L48;
        r5 = false;
    L48:
        if (r5 == false) goto L50;
        r1 = r12;
    L50:
        if (r1 == null) goto L60;
        r7.put("ec_address_data", r1);
        DataEngineWrapper r13 = this.a.c();
        if (r13 == null) goto L61;
        r13.r = r1;
        return;
    L61:
        return;
    L60:
        return;
    L58:
        return;
    L54:
        r7.put("ec_address_data", r10);
        return;
    L35:
        if (r10.length() == 0) goto L38;
        r6 = false;
        goto L39
    L31:
        r10 = null;
        goto L32
    L23:
        if (Intrinsics.areEqual(r8, "favorite_feed") == true) goto L28;
        if (Intrinsics.areEqual(r8, "popup_get") == true) goto L28;
        if (Intrinsics.areEqual(r8, "homepage_refresh") == true) goto L28;
        return;
    L5:
        if (r7.containsKey("cursor") == false) goto L9;
        r7.put("cursor", "0");
        if (((Boolean) b.getValue()).booleanValue() == false) goto L9;
        r7.put("page_num", "1");
        goto L9
    }

    public final Map b(String r1, String r2, Map r3) {
        return new HashMap();
    }
}
