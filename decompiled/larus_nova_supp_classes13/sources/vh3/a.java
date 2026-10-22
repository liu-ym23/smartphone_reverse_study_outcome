package vh3;

import com.bytedance.android.ec.core.hybrid.utils.k;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uh3.b;
import uh3.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R$\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lvh3/a;", "", "", "skuSessionId", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "comboNum", "a", "", "selectedIds", "Ljava/util/List;", "c", "()Ljava/util/List;", "Luh3/c;", "specDescs", "f", "selectedCover", "b", "Luh3/b;", "skuItem", "Luh3/b;", "d", "()Luh3/b;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {
    public static final /* synthetic */ int a = 0;

    @SerializedName("combo_num")
    private final String comboNum;

    @SerializedName("selected_cover")
    private final String selectedCover;

    @SerializedName("selected_ids")
    private final List<String> selectedIds;

    @SerializedName("sku_item")
    private final b skuItem;

    @SerializedName("sku_session_id")
    private final String skuSessionId;

    @SerializedName("spec_descs")
    private final List<c> specDescs;

    /* JADX INFO: renamed from: vh3.a$a, reason: collision with other inner class name */
    public static final class C0237a {
        public static a a(Map r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            int r0 = t0.a;
            return (a) GsonProtectorUtils.fromJson(t0.a.a, k.b(r2).toString(), a.class);
        }
    }

    static {
    }

    public a() {
        this.skuSessionId = null;
        this.comboNum = null;
        this.selectedIds = null;
        this.specDescs = null;
        this.selectedCover = null;
        this.skuItem = null;
    }

    public final String a() {
        return this.comboNum;
    }

    public final String b() {
        return this.selectedCover;
    }

    public final List<String> c() {
        return this.selectedIds;
    }

    public final b d() {
        return this.skuItem;
    }

    public final String e() {
        return this.skuSessionId;
    }

    public final List<c> f() {
        return this.specDescs;
    }
}
