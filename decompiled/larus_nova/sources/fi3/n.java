package fi3;

import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lfi3/n;", "", "", SignCounterLaunchArgs.EXTRA_SCENE_TYPE, "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", ReportConstant.COMMON_ACTION_TYPE, "b", "Lfi3/m;", "extra", "Lfi3/m;", "d", "()Lfi3/m;", "Lcom/bytedance/android/ec/core/btm/a;", "btmFields", "Lcom/bytedance/android/ec/core/btm/a;", "c", "()Lcom/bytedance/android/ec/core/btm/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f477292a = null;

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

        public static n a(Map r110) {
            com.bytedance.android.ec.core.btm.a r100 = null;
            if (r110 != null) goto L5;
            return null;
        L5:
            Integer r101 = Integer.valueOf(mq.b.b(r110.get("scene_type"), 0));
            Integer r102 = Integer.valueOf(mq.b.b(r110.get("action_type"), 0));
            Object r103 = r110.get("extra");
            if ((r103 instanceof Map) == true) goto L8;
            r103 = null;
        L8:
            Map r104 = (Map) r103;
            if (r104 != null) goto L11;
            m r105 = null;
        L34:
            Object r106 = r110.get("btm_fields");
            if ((r106 instanceof Map) == true) goto L37;
            r106 = null;
        L37:
            Map r107 = (Map) r106;
            if (r107 == null) goto L41;
            r100 = com.bytedance.android.ec.core.btm.c.h(r107);
        L41:
            return new n(r101, r102, r105, r100);
        L11:
            String r108 = String.valueOf(r104.get("sku_from"));
            Boolean r109 = Boolean.valueOf(mq.b.a(r104.get(com.bytedance.android.ec.core.event.a.KEY_IS_GROUP_BUYING)));
            Boolean r111 = Boolean.valueOf(mq.b.a(r104.get("is_custombuying")));
            Boolean r112 = Boolean.valueOf(mq.b.a(r104.get("scroll_to_installment")));
            Integer r113 = Integer.valueOf(mq.b.b(r104.get("term_count"), 0));
            Object r114 = r104.get("default_spec_ids");
            if ((r114 instanceof List) == true) goto L14;
            ArrayList r115 = null;
        L18:
            Object r116 = r104.get("ultimate_buy_ab");
            if (r116 == null) goto L21;
            Integer r117 = Integer.valueOf(mq.b.b(r116, 0));
        L22:
            Object r118 = r104.get("force_yata_sku");
            if (r118 == null) goto L25;
            Integer r119 = Integer.valueOf(mq.b.b(r118, 0));
        L26:
            Object r120 = r104.get("biz_identifier");
            if (r120 == null) goto L29;
            String r121 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r120);
        L30:
            Object r122 = r104.get("track_extra");
            if ((r122 instanceof Map) == true) goto L33;
            r122 = null;
        L33:
            r105 = new m(r108, r109, r111, r112, r113, r115, r117, r119, r121, (Map) r122);
            goto L34
        L29:
            r121 = null;
            goto L30
        L25:
            r119 = null;
            goto L26
        L21:
            r117 = null;
            goto L22
        L14:
            Iterable r123 = (Iterable) r114;
            r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r123, 10));
            Iterator r124 = r123.iterator();
        L16:
            if (r124.hasNext() == false) goto L18;
            r115.add(com.bytedance.android.ecom.arch.slice.render.util.b.r(r124.next()));
            goto L16
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n() {
        Object[] r100 = 0 == true ? 1 : 0;
        Object[] r101 = 0 == true ? 1 : 0;
        this(null, r100, r101, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == false) goto L14;
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.sceneType, r101.sceneType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.actionType, r101.actionType) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.btmFields, r101.btmFields) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.sceneType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.actionType;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        m r107 = this.extra;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        com.bytedance.android.ec.core.btm.a r110 = this.btmFields;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "OpenSkuParams(sceneType=" + this.sceneType + ", actionType=" + this.actionType + ", extra=" + this.extra + ", btmFields=" + this.btmFields + ")";
    }

    static {
        f477292a = new a();
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

    public static n a(n r100, Integer r101, com.bytedance.android.ec.core.btm.a r102) {
        Integer r103 = r100.sceneType;
        m r104 = r100.extra;
        r100.getClass();
        return new n(r103, r101, r104, r102);
    }

    public /* synthetic */ n(Integer r100, Integer r101, m r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102, null);
    }

    public n(Integer r100, Integer r101, m r102, com.bytedance.android.ec.core.btm.a r103) {
        this.sceneType = r100;
        this.actionType = r101;
        this.extra = r102;
        this.btmFields = r103;
    }
}
