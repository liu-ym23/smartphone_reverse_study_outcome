package com.larus.business.multitask_management.impl.view;

import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapController;
import com.larus.multitask_management.api.data.TaskStatus;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e implements jl9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f321190a = null;

    static {
        f321190a = new e();
    }

    public e() {
    }

    @Override // jl9.a
    public final View a(jl9.b r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        return new OngoingTaskItemDefaultView(r100.getContext(), r101, 6, 0);
    }

    @Override // jl9.a
    public final void b(View r100, jl9.b r101, kl9.u r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "taskBasicInfo");
        Long r102 = null;
        if ((r100 instanceof OngoingTaskItemDefaultView) == false) goto L5;
        OngoingTaskItemDefaultView r103 = (OngoingTaskItemDefaultView) r100;
    L6:
        if (r103 == null) goto L55;
        Intrinsics.checkNotNullParameter(r110, MapController.ITEM_LAYER_TAG);
        r103.f321146e = r110;
        r103.R5();
        TextView r104 = r103.f321142a.f320834f;
        kl9.x r105 = r110.f503987i;
        String r106 = "";
        if (r105 == null) goto L12;
        String r107 = r105.f504011a;
        if (r107 == null) goto L12;
    L13:
        r104.setText(r107);
        kl9.x r108 = r110.f503987i;
        if (r108 == null) goto L19;
        String r109 = r108.f504012b;
        if (r109 == null) goto L19;
        r106 = r109;
    L19:
        r103.f321142a.f320830b.setText(r106);
        TextView r111 = r103.f321142a.f320830b;
        if (r106.length() <= 0) goto L22;
        boolean r112 = true;
    L24:
        if (r112 == false) goto L26;
        int r113 = 0;
    L27:
        r111.setVisibility(r113);
        String r114 = r110.f503979a;
        kl9.c0 r115 = r110.f503991m;
        if (r115 == null) goto L30;
        int r116 = r115.f503874a;
    L31:
        TaskStatus r117 = r110.f503985g;
        if (r117 != TaskStatus.FAILED) goto L38;
        c r118 = r103.f321145d;
        if (r118 == null) goto L36;
        r118.d(r103.f321143b);
    L36:
        r103.f321145d = null;
        r103.f321144c = null;
        Lazy r119 = TaskProgressMockCache.f321164a;
        TaskProgressMockCache.b(r114);
        r103.f321142a.f320831c.setVisibility(8);
        r103.f321142a.f320832d.setImageResource(R.drawable.larus_mtm_ic_task_failed);
        r103.f321142a.f320832d.setVisibility(0);
        return;
    L38:
        if (r117 != TaskStatus.SUCCESS) goto L43;
        c r120 = r103.f321145d;
        if (r120 == null) goto L42;
        r120.d(r103.f321143b);
    L42:
        r103.f321145d = null;
        r103.f321144c = null;
        Lazy r121 = TaskProgressMockCache.f321164a;
        TaskProgressMockCache.b(r114);
        r103.f321142a.f320831c.setVisibility(8);
        r103.f321142a.f320832d.setImageResource(R.drawable.larus_mtm_ic_progress_complete);
        r103.f321142a.f320832d.setVisibility(0);
        return;
    L43:
        if (r116 < 0) goto L50;
        r103.f321142a.f320831c.setVisibility(0);
        r103.f321142a.f320832d.setVisibility(8);
        r103.f321142a.f320832d.setImageResource(R.drawable.larus_mtm_ic_progress_complete);
        r103.S5(r114);
        kl9.c0 r122 = r110.f503991m;
        if (r122 == null) goto L47;
        r102 = Long.valueOf(r122.f503875b);
    L47:
        c r123 = r103.f321145d;
        if (r123 == null) goto L58;
        r123.b(r114, r116, r102);
        return;
    L58:
        return;
    L50:
        c r124 = r103.f321145d;
        if (r124 == null) goto L53;
        r124.d(r103.f321143b);
    L53:
        r103.f321145d = null;
        r103.f321144c = null;
        Lazy r125 = TaskProgressMockCache.f321164a;
        TaskProgressMockCache.b(r114);
        r103.f321142a.f320831c.setVisibility(8);
        r103.f321142a.f320832d.setVisibility(8);
        return;
    L30:
        r116 = -1;
        goto L31
    L26:
        r113 = 8;
        goto L27
    L22:
        r112 = false;
    L12:
        r107 = "";
        goto L13
    L55:
        return;
    L5:
        r103 = null;
        goto L6
    }
}
