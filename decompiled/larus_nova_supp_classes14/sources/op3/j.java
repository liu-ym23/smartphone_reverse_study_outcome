package op3;

import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j {
    public static final Set<String> a = null;

    static {
        a = SetsKt.setOf(new String[]{"window_sellpoint_inventory", "window_sellpoint_rank", "window_sellpoint_author_say", "window_limit_time_special", "window_equal_live", "window_hot_live"});
    }

    public static final boolean a(WindowV2ProductItemVO r4) {
        ECRitTag r5 = r4.c(new List[]{r4.e(), r4.d()}, false);
        if (r5 == null) goto L5;
        String r6 = r5.getLabelName();
    L7:
        return CollectionsKt.contains(a, r6);
    L5:
        r6 = null;
        goto L7
    }

    public static final boolean b(WindowV2ProductItemVO r5, String r6) {
        Object r1 = null;
        if ((r5 instanceof tq3.c) == true) goto L5;
        WindowV2ProductItemVO r0 = null;
    L6:
        tq3.c r2 = (tq3.c) r0;
        if (r2 == null) goto L39;
        to.d r3 = r2.Q;
        if (r3 == null) goto L39;
        Map r4 = r3.a;
        if (r4 == null) goto L39;
        Iterator r7 = r4.entrySet().iterator();
    L15:
        if (r7.hasNext() == false) goto L26;
        Object r8 = r7.next();
        to.e.a r9 = (to.e) ((Map.Entry) r8).getKey();
        if ((r9 instanceof to.e.a) == false) goto L20;
        boolean r10 = Intrinsics.areEqual(r9.b, r6);
    L22:
        if (r10 == false) goto L15;
        r1 = r8;
        goto L26
    L20:
        if ((r9 instanceof to.e.c) == false) goto L25;
        r10 = Intrinsics.areEqual((String) CollectionsKt.lastOrNull(((to.e.c) r9).b), r6);
        goto L22
    L25:
        throw new NoWhenBranchMatchedException();
    L26:
        Map.Entry r11 = (Map.Entry) r1;
        if (r11 == null) goto L39;
        String r12 = (String) r11.getValue();
        if (r12 == null) goto L39;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L33
        tq3.c r14 = (tq3.c) r5;     // Catch: Throwable -> L33
        Object r15 = Result.constructor-impl(Boolean.valueOf(!Intrinsics.areEqual(new JSONObject(r12).optString("visibility", "visible"), "gone")));     // Catch: Throwable -> L33
    L35:
        Boolean r16 = Boolean.FALSE;
        if (Result.isFailure-impl(r15) == false) goto L49;
        r15 = r16;
    L49:
        return ((Boolean) r15).booleanValue();
    L33:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
    L39:
        return false;
    L5:
        r0 = r5;
        goto L6
    }
}
