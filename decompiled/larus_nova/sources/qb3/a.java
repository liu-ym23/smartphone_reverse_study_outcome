package qb3;

import com.bytedance.android.shopping.collect.repo.model.CollectParams;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f532292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CollectParams f532293b;

    /* JADX INFO: renamed from: qb3.a$a, reason: collision with other inner class name */
    public static final class C7304a {
    }

    static {
    }

    public final Map<String, Object> a() {
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("guest_uid", this.f532293b.getGuestUid()), TuplesKt.to("query_scene", this.f532292a), TuplesKt.to("ecom_scene_id", this.f532293b.getEcomSceneId()), TuplesKt.to("previous_page", this.f532293b.getPreviousPage()), TuplesKt.to("is_from_personal", Boolean.valueOf(this.f532293b.isFromPersonal())), TuplesKt.to("collect_experiment_value", Integer.valueOf(this.f532293b.getCollectExperimentValue()))});
    }

    public a(String r100, CollectParams r101) {
        Intrinsics.checkNotNullParameter(r100, "queryScene");
        Intrinsics.checkNotNullParameter(r101, "collectParams");
        this.f532292a = r100;
        this.f532293b = r101;
    }
}
