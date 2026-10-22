package qb3;

import com.bytedance.android.shopping.collect.repo.model.CollectParams;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public final String a;
    public final CollectParams b;

    /* JADX INFO: renamed from: qb3.a$a, reason: collision with other inner class name */
    public static final class C0227a {
    }

    static {
    }

    public final Map<String, Object> a() {
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("guest_uid", this.b.getGuestUid()), TuplesKt.to("query_scene", this.a), TuplesKt.to("ecom_scene_id", this.b.getEcomSceneId()), TuplesKt.to("previous_page", this.b.getPreviousPage()), TuplesKt.to("is_from_personal", Boolean.valueOf(this.b.isFromPersonal())), TuplesKt.to("collect_experiment_value", Integer.valueOf(this.b.getCollectExperimentValue()))});
    }

    public a(String r2, CollectParams r3) {
        Intrinsics.checkNotNullParameter(r2, "queryScene");
        Intrinsics.checkNotNullParameter(r3, "collectParams");
        this.a = r2;
        this.b = r3;
    }
}
