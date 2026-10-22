package com.bytedance.android.shopping.mall.opt;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R.\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR(\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/mall/opt/h;", "", "", "disperseDuration", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "pageName", "Ljava/util/ArrayList;", "getPageName", "()Ljava/util/ArrayList;", "", "", "preCreateType", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "a", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h {
    public static final h a = null;

    @SerializedName("disperse_duration")
    private final Long disperseDuration;

    @SerializedName(PdpOpenThirdParam.KEY_PAGE_NAME)
    private final ArrayList<String> pageName;

    @SerializedName("pre_create_type")
    private final Map<String, Integer> preCreateType;

    public static final class a {
    }

    public h() {
        this(null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof h) == false) goto L12;
        h r4 = (h) r3;
        if (Intrinsics.areEqual(this.disperseDuration, r4.disperseDuration) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.pageName, r4.pageName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.preCreateType, r4.preCreateType) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Long r0 = this.disperseDuration;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ArrayList<String> r4 = this.pageName;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Map<String, Integer> r7 = this.preCreateType;
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
        return "MallPreCreateHolderConfig(disperseDuration=" + this.disperseDuration + ", pageName=" + this.pageName + ", preCreateType=" + this.preCreateType + ")";
    }

    static {
        int r0 = s93.c.a;
        Object r1 = new h(null);
        IHybridHostService r2 = com.bytedance.android.ec.hybrid.a.h();
        if (r2 == null) goto L10;
        yj.g r3 = r2.getHostAB();
        if (r3 == null) goto L10;
        Object r4 = r3.a("mall_pre_create_holder", r1);
        if (r4 == null) goto L10;
        r1 = r4;
    L10:
        Lazy r5 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.b, "Key : mall_pre_create_holder, Value: " + r1);
        a = (h) r1;
    }

    public final Long b() {
        return this.disperseDuration;
    }

    public final Map<String, Integer> c() {
        return this.preCreateType;
    }

    public h(Object r1) {
        this.disperseDuration = null;
        this.pageName = null;
        this.preCreateType = null;
    }

    public final boolean a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "page");
        ArrayList<String> r0 = this.pageName;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.contains(r2);
    }
}
