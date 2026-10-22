package tu1;

import com.bytedance.android.livesdk.dynamicstrategy.impl.express.parse.ExpressNodeType;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, ExpressNodeType> f547601a = null;

    static {
        ExpressNodeType r100 = ExpressNodeType.OPERATOR_COMPARE;
        f547601a = MapsKt.mapOf(new Pair[]{TuplesKt.to("(", ExpressNodeType.LEFT_BRACKET), TuplesKt.to(")", ExpressNodeType.RIGHT_BRACKET), TuplesKt.to("&&", ExpressNodeType.OPERATOR_AND), TuplesKt.to("||", ExpressNodeType.OPERATOR_OR), TuplesKt.to("==", r100), TuplesKt.to("!=", r100), TuplesKt.to(">=", r100), TuplesKt.to(">", r100), TuplesKt.to("<=", r100), TuplesKt.to("<", r100)});
    }
}
