package com.ss.android.lark.todo.impl.features.center.v3;

import com.bytedance.lark.pb.todo.v1.Commit;
import com.ss.android.lark.todo.impl.features.center.v3.data.TaskSectionData;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class k<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<TaskSectionData> f441625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f441626b;

    public k(List<TaskSectionData> r100, boolean r101) {
        this.f441625a = r100;
        this.f441626b = r101;
    }

    @Override // java.util.Comparator
    public final int compare(Object r110, Object r111) {
        com.ss.android.lark.todo.impl.features.center.v3.data.f r100 = (com.ss.android.lark.todo.impl.features.center.v3.data.f) r110;
        com.ss.android.lark.todo.impl.features.center.v3.data.f r101 = (com.ss.android.lark.todo.impl.features.center.v3.data.f) r111;
        Iterator<TaskSectionData> r102 = this.f441625a.iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(r102.next().f441515c, r100.f441562b) == true) goto L10;
        r103 = r103 + 1;
    L10:
        Iterator<TaskSectionData> r104 = this.f441625a.iterator();
        int r105 = 0;
    L12:
        if (r104.hasNext() == false) goto L17;
        if (Intrinsics.areEqual(r104.next().f441515c, r101.f441562b) == true) goto L18;
        r105 = r105 + 1;
    L18:
        int r106 = r103 - r105;
        if (r106 != 0) goto L104;
        Commit.DataTypeDueTime r107 = r100.f441567g;
        if (r107 != null) goto L24;
        return 1;
    L24:
        Commit.DataTypeDueTime r108 = r101.f441567g;
        if (r108 == null) goto L107;
        int r109 = i.f441621a;
        boolean r112 = this.f441626b;
        Long r113 = r107.due_time;
        long r114 = 0;
        if (r113 != null) goto L31;
    L38:
        Long r115 = r107.due_time;
        if (r115 != null) goto L42;
    L44:
        Long r116 = r108.due_time;
        if (r116 == null) goto L51;
        if (r116.longValue() != 0) goto L51;
        int r117 = -1;
    L96:
        if (r117 != 0) goto L106;
        Intrinsics.checkNotNull(r100);
        Intrinsics.checkNotNull(r101);
        return i.a(r100, r101);
    L106:
        return r117;
    L51:
        if (Intrinsics.areEqual(r107.is_all_day, r108.is_all_day) == false) goto L66;
        Long r118 = r107.due_time;
        if (r118 == null) goto L55;
        long r119 = r118.longValue();
    L56:
        Long r120 = r108.due_time;
        if (r120 == null) goto L59;
        long r121 = r120.longValue();
    L60:
        long r122 = r119 - r121;
        if (r122 <= 0) goto L63;
    L62:
        r117 = 1;
    L94:
        if (r112 == true) goto L96;
        r117 = r117 * (-1);
        goto L96
    L63:
        if (r122 != 0) goto L65;
    L64:
        r117 = 0;
    L65:
        r117 = -1;
        goto L94
    L59:
        r121 = 0;
        goto L60
    L55:
        r119 = 0;
        goto L56
    L66:
        Long r123 = r107.due_time;
        if (r123 == null) goto L69;
        long r124 = r123.longValue();
    L70:
        Long r125 = r108.due_time;
        if (r125 == null) goto L73;
        r114 = r125.longValue();
    L73:
        String r126 = r107.due_timezone;
        String r127 = "";
        if (r126 != null) goto L76;
        r126 = "";
    L76:
        TimeZone r128 = TimeZone.getTimeZone(r126);
        String r129 = r108.due_timezone;
        if (r129 == null) goto L80;
        r127 = r129;
    L80:
        TimeZone r130 = TimeZone.getTimeZone(r127);
        int r131 = com.ss.android.lark.todo.impl.utils.c.f444278a;
        long r132 = 1000;
        Intrinsics.checkNotNull(r128);
        int r133 = com.ss.android.lark.todo.impl.utils.c.c(r124 * r132, r128);
        Intrinsics.checkNotNull(r130);
        int r134 = r133 - com.ss.android.lark.todo.impl.utils.c.c(r114 * r132, r130);
        if (r134 > 0) goto L62;
        if (r134 != 0) goto L65;
        if (r107.is_all_day.booleanValue() == false) goto L90;
        if (r108.is_all_day.booleanValue() == false) goto L62;
    L90:
        if (r107.is_all_day.booleanValue() == true) goto L64;
        if (r108.is_all_day.booleanValue() == false) goto L64;
    L69:
        r124 = 0;
        goto L70
    L42:
        if (r115.longValue() != 0) goto L44;
        r117 = 1;
        goto L96
    L31:
        if (r113.longValue() != 0) goto L38;
        Long r135 = r108.due_time;
        if (r135 == null) goto L38;
        if (r135.longValue() != 0) goto L38;
        r117 = 0;
        goto L96
    L107:
        return -1;
    L104:
        return r106;
    L17:
        r105 = -1;
        goto L18
    L9:
        r103 = -1;
        goto L10
    }
}
