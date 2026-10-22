package op3;

import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.huawei.hms.push.constant.RemoteMessageConst;
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

/* JADX INFO: loaded from: classes14.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f524717a = null;

    static {
        f524717a = SetsKt.setOf(new String[]{"window_sellpoint_inventory", "window_sellpoint_rank", "window_sellpoint_author_say", "window_limit_time_special", "window_equal_live", "window_hot_live"});
    }

    public static final boolean a(WindowV2ProductItemVO r100) {
        ECRitTag r101 = r100.c(new List[]{r100.e(), r100.d()}, false);
        if (r101 == null) goto L5;
        String r102 = r101.getLabelName();
    L7:
        return CollectionsKt.contains(f524717a, r102);
    L5:
        r102 = null;
        goto L7
    }

    public static final boolean b(WindowV2ProductItemVO r100, String r101) {
        Object r102 = null;
        if ((r100 instanceof tq3.c) == true) goto L5;
        WindowV2ProductItemVO r103 = null;
    L6:
        tq3.c r104 = (tq3.c) r103;
        if (r104 == null) goto L39;
        to.d r105 = r104.Q;
        if (r105 == null) goto L39;
        Map<to.e, String> r106 = r105.f546888a;
        if (r106 == null) goto L39;
        Iterator<T> r107 = r106.entrySet().iterator();
    L15:
        if (r107.hasNext() == false) goto L26;
        Object r108 = r107.next();
        to.e r109 = (to.e) ((Map.Entry) r108).getKey();
        if ((r109 instanceof to.e.a) == false) goto L20;
        boolean r110 = Intrinsics.areEqual(((to.e.a) r109).f546891b, r101);
    L22:
        if (r110 == false) goto L15;
        r102 = r108;
        goto L26
    L20:
        if ((r109 instanceof to.e.c) == false) goto L25;
        r110 = Intrinsics.areEqual((String) CollectionsKt.lastOrNull(((to.e.c) r109).f546892b), r101);
        goto L22
    L25:
        throw new NoWhenBranchMatchedException();
    L26:
        Map.Entry r111 = (Map.Entry) r102;
        if (r111 == null) goto L39;
        String r112 = (String) r111.getValue();
        if (r112 == null) goto L39;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L33
        tq3.c r114 = (tq3.c) r100;     // Catch: Throwable -> L33
        Object r115 = Result.m9449constructorimpl(Boolean.valueOf(!Intrinsics.areEqual(new JSONObject(r112).optString(RemoteMessageConst.Notification.VISIBILITY, "visible"), "gone")));     // Catch: Throwable -> L33
    L35:
        Boolean r116 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r115) == false) goto L49;
        r115 = r116;
    L49:
        return ((Boolean) r115).booleanValue();
    L33:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L39:
        return false;
    L5:
        r103 = r100;
        goto L6
    }
}
