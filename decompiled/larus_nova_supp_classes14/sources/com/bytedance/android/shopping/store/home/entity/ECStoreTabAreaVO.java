package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECStoreTabAreaVO {
    public static final /* synthetic */ int f = 0;
    public ECStoreHomeTabResponseTabkit a;
    public List<uj3.j> b;
    public Integer c;
    public String d;
    public Map<String, String> e;

    public static final class a {
        public static ECStoreTabAreaVO a(ECStoreHomeTabResponseTabkit r9) {
            Intrinsics.checkNotNullParameter(r9, "response");
            ECStoreTabAreaVO r0 = new ECStoreTabAreaVO();
            r0.a = r9;
            if (r9 == null) goto L23;
            com.bytedance.android.shopping.store.tabkit.model.z r2 = r9.getTabkitResponse();
            if (r2 == null) goto L23;
            List<com.bytedance.android.shopping.store.tabkit.model.k> r3 = r2.j();
            if (r3 == null) goto L23;
            Iterator<T> r4 = r3.iterator();
        L10:
            if (r4.hasNext() == false) goto L23;
            com.bytedance.android.shopping.store.tabkit.model.k r5 = (com.bytedance.android.shopping.store.tabkit.model.k) r4.next();
            ECShopABSettings.k.getClass();
            if (ECShopABSettings.f() == true) goto L13;
            String r6 = r5.b();
            if (r6 == null) goto L10;
            Object r7 = new Gson().fromJson(r6, b.class);     // Catch: Exception -> L21
        L22:
            b r8 = (b) r7;
        L21:
            r7 = null;
            goto L22
        L13:
            if (r5 == null) goto L16;
            a0 r10 = (a0) r5;
            goto L10
        L16:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.store.home.entity.StoreTab");
        L23:
            com.bytedance.android.shopping.store.tabkit.model.z r11 = r9.getTabkitResponse();
            if (r11 == null) goto L26;
            Integer r12 = r11.a();
        L27:
            r0.c = r12;
            com.bytedance.android.shopping.store.tabkit.model.z r13 = r9.getTabkitResponse();
            if (r13 == null) goto L39;
            List<com.bytedance.android.shopping.store.tabkit.model.k> r14 = r13.j();
            if (r14 == null) goto L39;
            List<com.bytedance.android.shopping.store.tabkit.model.k> r15 = r14;
            ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
            Iterator<T> r17 = r15.iterator();
        L33:
            if (r17.hasNext() == false) goto L40;
            com.bytedance.android.shopping.store.tabkit.model.k r18 = (com.bytedance.android.shopping.store.tabkit.model.k) r17.next();
            int r19 = r.a;
            com.bytedance.android.shopping.store.tabkit.model.z r20 = r9.getTabkitResponse();
            if (r20 == null) goto L37;
            Integer r21 = r20.a();
        L38:
            r16.add(r.a(r18, r21));
            goto L33
        L37:
            r21 = null;
        L40:
            r0.b = r16;
            Map<String, String> r22 = r9.getLogExtra();
            if (r22 == null) goto L43;
            String r23 = r22.get("temp_id");
        L44:
            r0.d = r23;
            r0.e = r9.getPerfLogExtra();
            List<uj3.j> r24 = r0.b;
            if (r24 != null) goto L47;
        L50:
            boolean r25 = true;
        L51:
            if (r25 == true) goto L68;
            List<uj3.j> r26 = r0.b;
            if (r26 == null) goto L68;
            Iterator<T> r27 = r26.iterator();
        L57:
            if (r27.hasNext() == false) goto L68;
            uj3.j r28 = (uj3.j) r27.next();
            r28.A = null;
            List<uj3.j> r29 = r28.b;
            if (r29 == null) goto L57;
            Iterator<T> r30 = r29.iterator();
        L62:
            if (r30.hasNext() == false) goto L57;
            uj3.j r31 = (uj3.j) r30.next();
            r31.a = r28;
            r31.A = null;
            String r32 = r28.b();
            String r33 = r31.b();
            if ((!StringsKt.isBlank(r32)) == false) goto L62;
            if ((!StringsKt.isBlank(r33)) == false) goto L62;
            r31.A = r32 + '_' + r33;
        L68:
            return r0;
        L47:
            if (r24.isEmpty() == true) goto L50;
            r25 = false;
            goto L51
        L43:
            r23 = null;
        L39:
            r16 = null;
            goto L40
        L26:
            r12 = null;
            goto L27
        }
    }

    static {
    }

    public ECStoreTabAreaVO() {
    }

    public final boolean b() {
        List<uj3.j> r0 = this.b;
        if (r0 != null) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        uj3.j r1 = a(r0, ECStoreTabAreaVO$hasProductMarquee$productTab$1.INSTANCE);
        if (r1 == null) goto L51;
        com.bytedance.android.ec.hybrid.list.entity.k r2 = r1.I;
        Object r3 = null;
        if (r2 == null) goto L19;
        ArrayList r4 = r2.c;
        if (r4 == null) goto L19;
        Iterator r5 = r4.iterator();
    L13:
        if (r5.hasNext() == false) goto L17;
        Object r6 = r5.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.i) r6).a, "__PRODUCTS_SECTION__") == false) goto L13;
    L18:
        com.bytedance.android.ec.hybrid.list.entity.i r7 = (com.bytedance.android.ec.hybrid.list.entity.i) r6;
    L21:
        if (r7 == null) goto L44;
        ArrayList r8 = r7.i;
        if (r8 == null) goto L44;
        ECHybridListItemVO r9 = (ECHybridListItemVO) CollectionsKt.getOrNull(r8, 0);
        if (r9 == null) goto L44;
        Map r10 = r9.V;
        if (r10 == null) goto L29;
        Object r11 = r10.get("slice_item_states");
    L31:
        if ((r11 instanceof Map) == true) goto L33;
        r11 = null;
    L33:
        Map r12 = (Map) r11;
        if (r12 == null) goto L36;
        Object r13 = r12.get("product_undertake");
    L38:
        if ((r13 instanceof Boolean) == false) goto L42;
        r3 = r13;
    L42:
        if (Intrinsics.areEqual((Boolean) r3, Boolean.TRUE) != true) goto L44;
        boolean r14 = true;
    L45:
        if (r14 != true) goto L52;
        return true;
    L52:
        return false;
    L36:
        r13 = null;
        goto L38
    L29:
        r11 = null;
    L44:
        r14 = false;
        goto L45
    L17:
        r6 = null;
    L19:
        r7 = null;
        goto L21
    L51:
        return false;
    }

    public static uj3.j a(List r2, Function1 r3) {
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L14;
        uj3.j r0 = (uj3.j) r4.next();
        if (((Boolean) r3.invoke(r0)).booleanValue() == true) goto L7;
        List<uj3.j> r1 = r0.b;
        if (r1 != null) goto L11;
        r1 = CollectionsKt.emptyList();
    L11:
        uj3.j r5 = a(r1, r3);
        if (r5 == null) goto L4;
        return r5;
    L7:
        return r0;
    L14:
        return null;
    }
}
