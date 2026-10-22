package e73;

import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Le73/b;", "", "", "", "Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "list", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("action_list")
    private final Map<String, IAction> list;

    public b() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.list, ((b) r100).list) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Map<String, IAction> r100 = this.list;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "ActionList(list=" + this.list + ")";
    }

    public final Map<String, IAction> a() {
        return this.list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Map<String, ? extends IAction> r100) {
        this.list = r100;
    }
}
