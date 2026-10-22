package rj2;

import com.bytedance.android.ec.model.promotion.ECUIPromotionV2;
import com.bytedance.android.shopping.ligo.container.event.LiveLigoListJumpToOtherPageEventData;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mj2.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements b {
    public static final /* synthetic */ int d = 0;
    public final Map<String, com.bytedance.android.livesdk.livecommerce.promotionlist.utils.instant.a> a;
    public final Function0<List<ql.a>> b;
    public final Function1<z83.b, Unit> c;

    /* JADX INFO: renamed from: rj2.a$a, reason: collision with other inner class name */
    public static final class C0169a {
        public C0169a() {
        }

        public static String a(ql.a r5) {
            int r0 = a.d;
            Intrinsics.checkNotNullParameter(r5, "$this$generateCacheDataUniqueKey");
            StringBuilder r1 = new StringBuilder();
            r1.append(r5.getProductId());
            r1.append('_');
            if (r5.isOnTopExplaining() == true) goto L5;
            r1.append('0');
        L6:
            r1.append('_');
            if (r5.isRelatedInfo() == false) goto L9;
            r1.append('1');
        L11:
            return r1.toString();
        L9:
            r1.append('0');
            goto L11
        L5:
            r1.append('1');
            goto L6
        }
    }

    static {
        new C0169a();
    }

    @Override // rj2.b
    public final void b() {
    }

    @Override // rj2.b
    public final void a(ECUIPromotionV2 r13) {
        Intrinsics.checkNotNullParameter(r13, "topPromotion");
        String r14 = r13.getProductId();
        List r0 = CollectionsKt.take((Iterable) this.b.invoke(), 5);
        Iterator r1 = r0.iterator();
        int r3 = 0;
    L4:
        if (r1.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(((ql.a) r1.next()).getProductId(), r14) == true) goto L10;
        r3 = r3 + 1;
    L10:
        Integer r2 = Integer.valueOf(r3);
        if (r2.intValue() <= 0) goto L13;
        boolean r4 = true;
    L15:
        if (r4 == true) goto L18;
        r2 = null;
    L18:
        if (r2 == null) goto L56;
        ql.a r5 = (ql.a) CollectionsKt.getOrNull(r0, r2.intValue());
        if (r5 == null) goto L24;
        ql.b r6 = r5.getClientData();
        if (r6 == null) goto L24;
        ll.a r7 = r6.h;
    L25:
        if (r7 == null) goto L27;
        boolean r8 = true;
    L28:
        if (r8 == true) goto L31;
        r2 = null;
    L31:
        if (r2 == null) goto L57;
        ql.a r9 = (ql.a) CollectionsKt.getOrNull(r0, r2.intValue());
        if (r9 == null) goto L37;
        ql.b r10 = r9.getClientData();
        if (r10 == null) goto L37;
        r10.h = null;
    L37:
        Iterator r11 = ((LinkedHashMap) this.a).entrySet().iterator();
    L39:
        if (r11.hasNext() == false) goto L47;
        String r12 = (String) ((Map.Entry) r11.next()).getKey();
        Intrinsics.checkNotNullParameter(r12, "uniqueKey");
        List r15 = StringsKt.split$default(r12, new char[]{'_'}, false, 0, 6, null);
        if (r15.size() == 3) goto L43;
        String r16 = null;
    L45:
        if (Intrinsics.areEqual(r16, r14) == false) goto L39;
        r11.remove();
        goto L39
    L43:
        r16 = (String) CollectionsKt.getOrNull(r15, 0);
        goto L45
    L47:
        this.c.invoke(new we3.a.c(new LiveLigoListJumpToOtherPageEventData("change_explain", r14)));
        return;
    L57:
        return;
    L27:
        r8 = false;
    L24:
        r7 = null;
        goto L25
    L56:
        return;
    L13:
        r4 = false;
        goto L15
    L9:
        r3 = -1;
        goto L10
    }

    @Override // rj2.b
    public final void c(List<? extends ql.a> r7) {
        Intrinsics.checkNotNullParameter(r7, "promotions");
        Iterator r0 = ((LinkedHashMap) this.a).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L17;
        Map.Entry r1 = (Map.Entry) r0.next();
        String r2 = (String) r1.getKey();
        ll.a r3 = ((com.bytedance.android.livesdk.livecommerce.promotionlist.utils.instant.a) r1.getValue()).a;
        Iterator<T> r4 = r7.iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        Object r5 = r4.next();
        if (Intrinsics.areEqual(C0169a.a((ql.a) r5), r2) == false) goto L7;
    L12:
        ql.a r6 = (ql.a) r5;
        if (r6 == null) goto L4;
        ql.b r8 = r6.getClientData();
        if (r8 == null) goto L4;
        r8.h = r3;
        goto L4
    L11:
        r5 = null;
        goto L12
    }

    @Override // rj2.b
    public final void e(List<? extends ql.a> r6) {
        Intrinsics.checkNotNullParameter(r6, "oldCategoryPromotions");
        Iterator<T> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L8;
        ql.a r0 = (ql.a) r7.next();
        if (r0.getClientData().h == null) goto L4;
        r0.getClientData().h = null;
        goto L4
    L8:
        ((LinkedHashMap) this.a).clear();
        this.c.invoke(new we3.a.c(new LiveLigoListJumpToOtherPageEventData("live_tab", null, 2, null)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function0<? extends List<? extends ql.a>> r2, Function1<? super z83.b, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "getTotalPromotions");
        Intrinsics.checkNotNullParameter(r3, "sendLigoEvent");
        this.b = r2;
        this.c = r3;
        this.a = new LinkedHashMap();
    }

    @Override // rj2.b
    public final void d(List<? extends ql.a> r8, List<j> r9) {
        Intrinsics.checkNotNullParameter(r8, "promotions");
        Intrinsics.checkNotNullParameter(r9, "removedPromotions");
        Iterator r0 = ((LinkedHashMap) this.a).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L30;
        Map.Entry r1 = (Map.Entry) r0.next();
        String r2 = (String) r1.getKey();
        ll.a r3 = ((com.bytedance.android.livesdk.livecommerce.promotionlist.utils.instant.a) r1.getValue()).a;
        Iterator<T> r4 = r8.iterator();
    L6:
        Object r5 = null;
        if (r4.hasNext() == false) goto L11;
        Object r6 = r4.next();
        if (Intrinsics.areEqual(C0169a.a((ql.a) r6), r2) == false) goto L6;
    L12:
        ql.a r7 = (ql.a) r6;
        if (r7 == null) goto L17;
        ql.b r10 = r7.getClientData();
        if (r10 == null) goto L17;
        r10.h = r3;
    L17:
        Iterator<T> r11 = r9.iterator();
    L19:
        if (r11.hasNext() == false) goto L23;
        Object r12 = r11.next();
        if (Intrinsics.areEqual(C0169a.a(((j) r12).b), r2) == false) goto L19;
        r5 = r12;
    L23:
        j r13 = (j) r5;
        if (r13 == null) goto L4;
        ql.a r14 = r13.b;
        if (r14 == null) goto L4;
        ql.b r15 = r14.getClientData();
        if (r15 == null) goto L4;
        r15.h = r3;
        goto L4
    L11:
        r6 = null;
        goto L12
    }
}
