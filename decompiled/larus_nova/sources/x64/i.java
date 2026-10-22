package x64;

import com.bytedance.badger.monitor.TriggerStage;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f562627a = null;

    static {
        f562627a = MapsKt.mapOf(new Pair[]{TuplesKt.to(TriggerStage.periodic_first, f.f562617a), TuplesKt.to(TriggerStage.periodic, g.f562618a), TuplesKt.to(TriggerStage.login_finished, d.f562615b), TuplesKt.to(TriggerStage.manual, e.f562616a)});
    }
}
