package rs8;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.view.BaseTextAnswerActionButton;
import com.larus.bmhome.view.f2;
import com.larus.bmhome.view.h4;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class x {
    public static final g b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r101 = r100.getTag(R.id.set_priority_view_actions);
        if ((r101 instanceof g) == true) goto L7;
        return null;
    L7:
        return (g) r101;
    }

    public static final int c(String r100, Map<String, Integer> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "actionbarPriorityIndex");
        int r102 = r100.hashCode();
        if (r102 == (-1772571018)) goto L17;
        if (r102 == (-1287261771)) goto L13;
        if (r102 != (-1287190283)) goto L21;
        if (r100.equals("regen_prev") == false) goto L21;
    L15:
        r100 = "switch-regenerate";
    L21:
        if (r100.length() != 0) goto L23;
        boolean r103 = true;
    L25:
        if (r103 == false) goto L27;
        return Integer.MAX_VALUE;
    L27:
        LinkedHashMap r104 = (LinkedHashMap) r101;
        Integer r105 = (Integer) r104.get(r100);
        if (r105 != null) goto L33;
        r105 = (Integer) r104.get("others");
        if (r105 != null) goto L33;
        return Integer.MAX_VALUE;
    L33:
        return r105.intValue();
    L23:
        r103 = false;
        goto L25
    L13:
        if (r100.equals("regen_next") == true) goto L15;
    L17:
        if (r100.equals("switch_group_msg") == false) goto L21;
        r100 = "crowd-test-switch";
        goto L21
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(boolean r210, Context r211, List r212, List r213, ViewGroup r214, boolean r310, boolean r311) {
        Intrinsics.checkNotNullParameter(r211, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r212, "newActions");
        Intrinsics.checkNotNullParameter(r213, "oldActions");
        Intrinsics.checkNotNullParameter(r214, "viewContainer");
        FLogger r110 = FLogger.f375446a;
        StringBuilder r111 = new StringBuilder();
        r111.append("oldActions: " + CollectionsKt.joinToString$default(r213, null, "[", "]", 0, null, new v(), 25, null));
        r111.append('\n');
        r111.append("newActions: " + CollectionsKt.joinToString$default(r212, null, "[", "]", 0, null, new w(), 25, null));
        r111.append('\n');
        Unit r100 = Unit.INSTANCE;
        r110.i("MessageActionBar_DIFF", r111.toString());
        ArrayList r101 = (ArrayList) r213;
        int r102 = Math.min(r101.size(), r212.size());
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L23;
        g r104 = (g) ListProtector.get(r101, r103);
        g r105 = (g) ListProtector.get(r212, r103);
        if (r104.getId() == r105.getId()) goto L8;
    L18:
        BaseTextAnswerActionButton r106 = h4.a(r105, r211);
        r106.a(r105, r310, r311);
        r214.removeViewAt(r103);
        ViewGroup r107 = r106.getRoot();
        r214.addView(r107, r103);
        if (r210 == false) goto L21;
        r107.setTag(R.id.set_priority_view_actions, r105);
    L21:
        r103 = r103 + 1;
        goto L4
    L8:
        if (r104.getClass() != r105.getClass()) goto L18;
        View r108 = r214.getChildAt(r103);
        if ((r108 instanceof f2) == false) goto L12;
        f2 r109 = (f2) r108;
    L13:
        if (r109 == null) goto L15;
        r109.a(r105, r310, r311);
    L15:
        if (r210 == false) goto L21;
        r108.setTag(R.id.set_priority_view_actions, r105);
        goto L21
    L12:
        r109 = null;
        goto L13
    L23:
        if (r101.size() <= r212.size()) goto L30;
        int r112 = r101.size() - 1;
        int r113 = r212.size();
        if (r113 > r112) goto L37;
    L26:
        r214.removeViewAt(r112);
        if (r112 == r113) goto L47;
        r112 = r112 - 1;
        goto L26
    L47:
        return;
    L37:
        return;
    L30:
        if (r101.size() >= r212.size()) goto L46;
        int r114 = r101.size();
        int r115 = r212.size();
    L32:
        if (r114 >= r115) goto L48;
        g r116 = (g) ListProtector.get(r212, r114);
        BaseTextAnswerActionButton r117 = h4.a(r116, r211);
        r117.a(r116, r310, r311);
        ViewGroup r118 = r117.getRoot();
        r214.addView(r118);
        if (r210 == false) goto L36;
        r118.setTag(R.id.set_priority_view_actions, r116);
    L36:
        r114 = r114 + 1;
        goto L32
    L48:
        return;
    }
}
