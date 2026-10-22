package com.ss.android.lark.todo.impl.features.center.v3;

import com.bytedance.lark.pb.todo.v1.DataTypeStartTime;
import com.ss.android.lark.todo.impl.features.center.v3.data.TaskSectionData;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class n<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<TaskSectionData> f441631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f441632b;

    public n(List<TaskSectionData> r100, boolean r101) {
        this.f441631a = r100;
        this.f441632b = r101;
    }

    @Override // java.util.Comparator
    public final int compare(Object r110, Object r111) {
        com.ss.android.lark.todo.impl.features.center.v3.data.f r112 = (com.ss.android.lark.todo.impl.features.center.v3.data.f) r110;
        com.ss.android.lark.todo.impl.features.center.v3.data.f r113 = (com.ss.android.lark.todo.impl.features.center.v3.data.f) r111;
        Iterator<TaskSectionData> r100 = this.f441631a.iterator();
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r100.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(r100.next().f441515c, r112.f441562b) == true) goto L10;
        r102 = r102 + 1;
    L10:
        Iterator<TaskSectionData> r103 = this.f441631a.iterator();
        int r104 = 0;
    L12:
        if (r103.hasNext() == false) goto L17;
        if (Intrinsics.areEqual(r103.next().f441515c, r113.f441562b) == true) goto L18;
        r104 = r104 + 1;
    L18:
        int r105 = r102 - r104;
        if (r105 != 0) goto L105;
        DataTypeStartTime r106 = r112.f441568h;
        if (r106 != null) goto L24;
        return 1;
    L24:
        DataTypeStartTime r107 = r113.f441568h;
        if (r107 == null) goto L108;
        int r108 = i.f441621a;
        boolean r109 = this.f441632b;
        Long r114 = r106.start_time;
        long r115 = 0;
        if (r114 != null) goto L31;
    L38:
        Long r116 = r106.start_time;
        if (r116 != null) goto L42;
    L44:
        Long r117 = r107.start_time;
        if (r117 == null) goto L51;
        if (r117.longValue() != 0) goto L51;
        r101 = -1;
    L97:
        if (r101 != 0) goto L107;
        Intrinsics.checkNotNull(r112);
        Intrinsics.checkNotNull(r113);
        return i.a(r112, r113);
    L107:
        return r101;
    L51:
        if (Intrinsics.areEqual(r106.is_all_day, r107.is_all_day) == false) goto L66;
        Long r118 = r106.start_time;
        if (r118 == null) goto L55;
        long r119 = r118.longValue();
    L56:
        Long r120 = r107.start_time;
        if (r120 == null) goto L59;
        long r121 = r120.longValue();
    L60:
        long r122 = r119 - r121;
        if (r122 <= 0) goto L63;
    L62:
        r101 = 1;
    L95:
        if (r109 == true) goto L97;
        r101 = r101 * (-1);
        goto L97
    L63:
        if (r122 == 0) goto L95;
    L65:
        r101 = -1;
        goto L95
    L59:
        r121 = 0;
        goto L60
    L55:
        r119 = 0;
        goto L56
    L66:
        Long r123 = r106.start_time;
        if (r123 == null) goto L69;
        long r124 = r123.longValue();
    L70:
        Long r125 = r107.start_time;
        if (r125 == null) goto L74;
        r115 = r125.longValue();
    L74:
        if (r106.is_all_day.booleanValue() == false) goto L76;
        TimeZone r126 = TimeZone.getTimeZone("UTC");
    L78:
        if (r107.is_all_day.booleanValue() == false) goto L80;
        TimeZone r127 = TimeZone.getTimeZone("UTC");
    L81:
        int r128 = com.ss.android.lark.todo.impl.utils.c.f444278a;
        Intrinsics.checkNotNull(r126);
        int r129 = com.ss.android.lark.todo.impl.utils.c.c(r124, r126);
        Intrinsics.checkNotNull(r127);
        int r130 = r129 - com.ss.android.lark.todo.impl.utils.c.c(r115, r127);
        if (r130 > 0) goto L62;
        if (r130 != 0) goto L65;
        if (r106.is_all_day.booleanValue() == false) goto L91;
        if (r107.is_all_day.booleanValue() == false) goto L62;
    L91:
        if (r106.is_all_day.booleanValue() == true) goto L95;
        if (r107.is_all_day.booleanValue() == false) goto L95;
    L80:
        r127 = TimeZone.getDefault();
        goto L81
    L76:
        r126 = TimeZone.getDefault();
        goto L78
    L69:
        r124 = 0;
        goto L70
    L42:
        if (r116.longValue() != 0) goto L44;
        r101 = 1;
        goto L97
    L31:
        if (r114.longValue() != 0) goto L38;
        Long r131 = r107.start_time;
        if (r131 == null) goto L38;
        if (r131.longValue() != 0) goto L38;
    L108:
        return -1;
    L105:
        return r105;
    L17:
        r104 = -1;
        goto L18
    L9:
        r102 = -1;
        goto L10
    }
}
