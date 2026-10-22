package fi3;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lfi3/n;", "", "", "sceneType", "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", "actionType", "b", "Lfi3/m;", "extra", "Lfi3/m;", "d", "()Lfi3/m;", "Lcom/bytedance/android/ec/core/btm/a;", "btmFields", "Lcom/bytedance/android/ec/core/btm/a;", "c", "()Lcom/bytedance/android/ec/core/btm/a;", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n {
    public static final a a = null;

    @SerializedName("action_type")
    private final Integer actionType;

    @SerializedName("btm_fields")
    private final com.bytedance.android.ec.core.btm.a btmFields;

    @SerializedName("extra")
    private final m extra;

    @SerializedName("scene_type")
    private final Integer sceneType;

    public static final class a {
        public a() {
        }

        public static n a(Map r19) {
            com.bytedance.android.ec.core.btm.a r1 = null;
            if (r19 != null) goto L5;
            return null;
        L5:
            Integer r3 = Integer.valueOf(mq.b.b(r19.get("scene_type"), 0));
            Integer r5 = Integer.valueOf(mq.b.b(r19.get("action_type"), 0));
            Object r6 = r19.get("extra");
            if ((r6 instanceof Map) == true) goto L8;
            r6 = null;
        L8:
            Map r7 = (Map) r6;
            if (r7 != null) goto L11;
            m r4 = null;
        L34:
            Object r0 = r19.get("btm_fields");
            if ((r0 instanceof Map) == true) goto L37;
            r0 = null;
        L37:
            Map r2 = (Map) r0;
            if (r2 == null) goto L41;
            r1 = com.bytedance.android.ec.core.btm.c.h(r2);
        L41:
            return new n(r3, r5, r4, r1);
        L11:
            String r8 = String.valueOf(r7.get("sku_from"));
            Boolean r9 = Boolean.valueOf(mq.b.a(r7.get("is_groupbuying")));
            Boolean r10 = Boolean.valueOf(mq.b.a(r7.get("is_custombuying")));
            Boolean r11 = Boolean.valueOf(mq.b.a(r7.get("scroll_to_installment")));
            Integer r12 = Integer.valueOf(mq.b.b(r7.get("term_count"), 0));
            Object r13 = r7.get("default_spec_ids");
            if ((r13 instanceof List) == true) goto L14;
            ArrayList r14 = null;
        L18:
            Object r15 = r7.get("ultimate_buy_ab");
            if (r15 == null) goto L21;
            Integer r16 = Integer.valueOf(mq.b.b(r15, 0));
        L22:
            Object r17 = r7.get("force_yata_sku");
            if (r17 == null) goto L25;
            Integer r18 = Integer.valueOf(mq.b.b(r17, 0));
        L26:
            Object r20 = r7.get("biz_identifier");
            if (r20 == null) goto L29;
            String r110 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r20);
        L30:
            Object r21 = r7.get("track_extra");
            if ((r21 instanceof Map) == true) goto L33;
            r21 = null;
        L33:
            r4 = new m(r8, r9, r10, r11, r12, r14, r16, r18, r110, (Map) r21);
            goto L34
        L29:
            r110 = null;
            goto L30
        L25:
            r18 = null;
            goto L26
        L21:
            r16 = null;
            goto L22
        L14:
            Iterable r22 = (Iterable) r13;
            r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10));
            Iterator r23 = r22.iterator();
        L16:
            if (r23.hasNext() == false) goto L18;
            r14.add(com.bytedance.android.ecom.arch.slice.render.util.b.r(r23.next()));
            goto L16
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n() {
        Object[] r0 = 0 == true ? 1 : 0;
        Object[] r1 = 0 == true ? 1 : 0;
        this(null, r0, r1, 15);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof n) == false) goto L14;
        n r4 = (n) r3;
        if (Intrinsics.areEqual(this.sceneType, r4.sceneType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.actionType, r4.actionType) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.extra, r4.extra) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.btmFields, r4.btmFields) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Integer r0 = this.sceneType;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.actionType;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        m r7 = this.extra;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        com.bytedance.android.ec.core.btm.a r10 = this.btmFields;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "OpenSkuParams(sceneType=" + this.sceneType + ", actionType=" + this.actionType + ", extra=" + this.extra + ", btmFields=" + this.btmFields + ")";
    }

    static {
        a = new a();
    }

    public final Integer b() {
        return this.actionType;
    }

    public final com.bytedance.android.ec.core.btm.a c() {
        return this.btmFields;
    }

    public final m d() {
        return this.extra;
    }

    public final Integer e() {
        return this.sceneType;
    }

    public static n a(n r2, Integer r3, com.bytedance.android.ec.core.btm.a r4) {
        Integer r0 = r2.sceneType;
        m r1 = r2.extra;
        r2.getClass();
        return new n(r0, r3, r1, r4);
    }

    public /* synthetic */ n(Integer r3, Integer r4, m r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 4) == 0) goto L11;
        r5 = null;
    L11:
        this(r3, r4, r5, null);
    }

    public n(Integer r1, Integer r2, m r3, com.bytedance.android.ec.core.btm.a r4) {
        this.sceneType = r1;
        this.actionType = r2;
        this.extra = r3;
        this.btmFields = r4;
    }
}
