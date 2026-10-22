package com.bytedance.android.shopping.mall.homepage.tools;

import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.bst.api.ext.ExtKt;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.shopping.api.mall.IECMallHostService;
import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import com.bytedance.android.shopping.mall.homepage.card.common.ECLynxCardMonitorHolder;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class BstUtilsNewKt {
    public static final Set<String> a = null;

    public static final class a implements com.bytedance.android.bst.api.g {
        public final /* synthetic */ Map a;
        public final /* synthetic */ qf3.d b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Map d;

        public final void a(String r6, Map<Object, ? extends Object> r7) {
            Intrinsics.checkNotNullParameter(r6, "eventName");
            Intrinsics.checkNotNullParameter(r7, "params");
            this.a.put("eventName", r6);
            LinkedHashMap r8 = new LinkedHashMap();
            Object r0 = this.a.get("params");
            if ((r0 instanceof Map) == true) goto L5;
            r0 = null;
        L5:
            Map r1 = (Map) r0;
            if (r1 == null) goto L8;
            r8.putAll(r1);
        L8:
            ArrayList r2 = new ArrayList(r7.size());
            Iterator r9 = ((LinkedHashMap) r7).entrySet().iterator();
        L10:
            if (r9.hasNext() == false) goto L12;
            Map.Entry r3 = (Map.Entry) r9.next();
            r2.add(TuplesKt.to(r3.getKey().toString(), r3.getValue()));
            goto L10
        L12:
            MapsKt.putAll(r8, r2);
            this.a.put("params", r8);
            ECMallFeed.ReportAbility r10 = this.b.b.j0;
            Map r11 = this.a;
            if (this.c == false) goto L15;
            Map r4 = this.d;
        L16:
            k93.g.a.a(r10, r11, r4, null, 12);
            return;
        L15:
            r4 = null;
            goto L16
        }

        public a(Map r1, qf3.d r2, boolean r3, Map r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class b implements com.bytedance.android.bst.api.g {
        public final /* synthetic */ List a;
        public final /* synthetic */ ECMallFeed b;
        public final /* synthetic */ int c;

        public final void a(String r10, Map<Object, ? extends Object> r11) {
            Intrinsics.checkNotNullParameter(r10, "eventName");
            Intrinsics.checkNotNullParameter(r11, "params");
            ArrayList r0 = new ArrayList();
            Iterator r1 = this.a.iterator();
        L4:
            if (r1.hasNext() == false) goto L13;
            com.bytedance.android.ec.hybrid.list.entity.c r2 = (com.bytedance.android.ec.hybrid.list.entity.c) r1.next();
            com.bytedance.android.ec.hybrid.list.entity.c r3 = new com.bytedance.android.ec.hybrid.list.entity.c();
            r3.a = r10;
            Map r4 = r2.b();
            if (r4 == null) goto L12;
            LinkedHashMap r5 = new LinkedHashMap();
            r5.putAll(r4);
            ArrayList r6 = new ArrayList(r11.size());
            Iterator r7 = ((LinkedHashMap) r11).entrySet().iterator();
        L9:
            if (r7.hasNext() == false) goto L11;
            Map.Entry r8 = (Map.Entry) r7.next();
            r6.add(TuplesKt.to(r8.getKey().toString(), r8.getValue()));
            goto L9
        L11:
            MapsKt.putAll(r5, r6);
            Unit r9 = Unit.INSTANCE;
            r3.b = r5;
        L12:
            r3.d = r2.d;
            r3.c = r2.c;
            Unit r12 = Unit.INSTANCE;
            r0.add(r3);
            goto L4
        L13:
            this.b.j0.f(r0, this.c, null);
        }

        public b(List r1, ECMallFeed r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
        a = SetsKt.setOf(new String[]{"show_product", "show_product_bst", "click_product", "click_product_bst"});
    }

    public static final boolean c(View r2) {
        Intrinsics.checkNotNullParameter(r2, "bindView");
        if (Intrinsics.areEqual(r2.getTag(2131386339), "bst_mark") == false) goto L5;
        return true;
    L5:
        Object r3 = r2.getParent();
        if (r3 != null) goto L8;
    L10:
        return false;
    L8:
        if ((r3 instanceof View) == false) goto L10;
        return c((View) r3);
    }

    public static final String d(BaseViewHolder r5) {
        if ((r5 instanceof ECLynxCardMonitorHolder) == false) goto L46;
        ECLynxCardMonitorHolder r6 = (ECLynxCardMonitorHolder) r5;
        ECHybridListItemVO r0 = ((BaseViewHolder) r6).c;
        if (r0 == null) goto L47;
        com.bytedance.android.ec.hybrid.list.entity.n r1 = r0.o;
        if (r1 == null) goto L48;
        List r2 = r1.c;
        if (r2 == null) goto L49;
        Iterator r3 = r2.iterator();
    L12:
        if (r3.hasNext() == false) goto L50;
        com.bytedance.android.ec.hybrid.list.entity.c r4 = (com.bytedance.android.ec.hybrid.list.entity.c) r3.next();
        if (Intrinsics.areEqual(r4.a, "show_product") == false) goto L12;
        String r7 = r6.Z;
        if (r7 == null) goto L18;
        String r8 = UriProtector.getQueryParameter(UriProtector.parse(r7), "bst_group_type");
    L20:
        if (Intrinsics.areEqual(r8, "product") == false) goto L12;
        Map r9 = r4.d;
        if (r9 == null) goto L24;
        Object r10 = r9.get("btm");
    L26:
        if ((r10 instanceof String) == true) goto L28;
        r10 = null;
    L28:
        String r11 = (String) r10;
        if (r11 != null) goto L31;
    L34:
        boolean r12 = true;
    L35:
        if (r12 == true) goto L12;
        return r11;
    L31:
        if (r11.length() == 0) goto L34;
        r12 = false;
        goto L35
    L24:
        r10 = null;
        goto L26
    L18:
        r8 = null;
        goto L20
    L50:
        return null;
    L49:
        return null;
    L48:
        return null;
    L47:
        return null;
    L46:
        return null;
    }

    public static final boolean a(Map<String, Object> r5, View r6, boolean r7, Map<String, ? extends Object> r8, qf3.d r9) {
        Intrinsics.checkNotNullParameter(r5, "finalParams");
        Intrinsics.checkNotNullParameter(r8, "paramsFromGlobal");
        Intrinsics.checkNotNullParameter(r9, "mallJsbContext");
        Object r0 = r5.get("btm");
        boolean r1 = false;
        if (r6 == null) goto L27;
        if (r0 == null) goto L27;
        if ((r0 instanceof String) == false) goto L27;
        if (Intrinsics.areEqual(r5.get("eventName"), "click_product") == true) goto L10;
    L12:
        boolean r2 = false;
    L13:
        if (r2 == false) goto L27;
        LinkedHashMap r3 = new LinkedHashMap();
        r3.putAll(r5);
        a r10 = new a(r3, r9, r7, r8);
        String r4 = (String) r0;
        if (r4.length() != 0) goto L17;
        r1 = true;
    L17:
        if (r1 == false) goto L19;
        ExtKt.b("BstItemCreate", "btm is empty!");
    L19:
        final com.bytedance.android.bst.api.d r11 = new com.bytedance.android.bst.api.d(r6);
        r11.a = r4;
        r11.b = "click_product";
        r11.c = null;
        r11.d = "like_shopping";
        r11.e = -1;
        r11.f = r10;
        kjc.c r12 = new kjc.c();
        if (5 != kjc.a.a()) goto L23;
        kjc.b r13 = r12.a;
        ((IECMallHostService) ServiceManager.get().getService(IECMallHostService.class)).safeRunBstAction(new BstUtilsNewKt$interceptBstClickLogSucess$$inlined$call$lambda$1(r11));
        r13.a = Unit.INSTANCE;
        r12.b = true;
    L23:
        if (r12.b == true) goto L25;
        kjc.b r14 = r12.a;
        com.bytedance.android.bst.api.f.b.getClass();
        com.bytedance.android.bst.api.f.c(r11);
        r14.a = Unit.INSTANCE;
    L25:
        Object r15 = r12.a.a;
        return true;
    L10:
        if (c(r6) == false) goto L12;
        r2 = true;
    L27:
        return false;
    }

    public static final boolean b(BaseViewHolder r4, List<com.bytedance.android.ec.hybrid.list.entity.c> r5, ECMallFeed r6, int r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r4, "card");
        Intrinsics.checkNotNullParameter(r5, "showProductData");
        Intrinsics.checkNotNullParameter(r6, "ecMallFeed");
        Intrinsics.checkNotNullParameter(r8, "ruleKey");
        Intrinsics.checkNotNullParameter(r9, "eventName");
        String r0 = d(r4);
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
    L29:
        return false;
    L11:
        if ((!r5.isEmpty()) == false) goto L29;
        b r10 = new b(r5, r6, r7);
        View r11 = ((RecyclerView.ViewHolder) r4).itemView;
        ECHybridListItemVO r12 = r4.c;
        if (r0.length() != 0) goto L15;
        r1 = true;
    L15:
        if (r1 == false) goto L17;
        ExtKt.b("BstItemCreate", "btm is empty!");
    L17:
        final com.bytedance.android.bst.api.d r13 = new com.bytedance.android.bst.api.d(r11);
        r13.a = r0;
        if (r9 == null) goto L28;
        r13.b = r9;
        r13.c = r12;
        r13.d = r8;
        r13.e = -1;
        r13.f = r10;
        kjc.c r14 = new kjc.c();
        if (5 != kjc.a.a()) goto L23;
        kjc.b r15 = r14.a;
        ((IECMallHostService) ServiceManager.get().getService(IECMallHostService.class)).safeRunBstAction(new BstUtilsNewKt$interceptBstShowLogSuccess$$inlined$call$lambda$1(r13));
        r15.a = Unit.INSTANCE;
        r14.b = true;
    L23:
        if (r14.b == true) goto L25;
        kjc.b r16 = r14.a;
        com.bytedance.android.bst.api.f.b.getClass();
        com.bytedance.android.bst.api.f.a(r13);
        r16.a = Unit.INSTANCE;
    L25:
        Object r17 = r14.a.a;
        return true;
    L28:
        throw new AndroidRuntimeException("event is empty");
    L5:
        if (r0.length() == 0) goto L8;
        r3 = false;
        goto L9
    }
}
