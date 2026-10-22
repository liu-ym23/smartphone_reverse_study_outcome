package oo;

import com.bytedance.android.ec.window.base.dynamicview.virtualview.ConstraintOp;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Loo/a;", "", "", "targetId", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "constraintOp", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, ConstraintOp> f524503a = null;

    @SerializedName("constraint_option")
    private final String constraintOp;

    @SerializedName("target_id")
    private final String targetId;

    /* JADX INFO: renamed from: oo.a$a, reason: collision with other inner class name */
    public static final class C7078a {
    }

    static {
        ConstraintOp[] r100 = ConstraintOp.values();
        LinkedHashMap r101 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r100.length), 16));
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        ConstraintOp r104 = r100[r103];
        r101.put(r104.getId(), r104);
        r103 = r103 + 1;
        goto L3
    L5:
        f524503a = r101;
    }

    public final String a() {
        return this.constraintOp;
    }

    public final String b() {
        return this.targetId;
    }
}
