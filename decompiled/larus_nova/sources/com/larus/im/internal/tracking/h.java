package com.larus.im.internal.tracking;

import com.larus.im.internal.delegate.d1;
import ouc.d0;
import ouc.e0;

/* JADX INFO: loaded from: classes30.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f350320a = 0;

    static {
    }

    public static void a(Long r100, Boolean r101, Integer r102, Long r103, Long r104, Long r105, Long r106, Long r110, Integer r111, Integer r112) {
        e0 r107 = new e0();
        if (r100 == null) goto L5;
        ouc.j.b(r107, "fst_duration", Long.valueOf(r100.longValue()));
    L5:
        if (r103 == null) goto L7;
        ouc.j.b(r107, "total_duration", Long.valueOf(r103.longValue()));
    L7:
        if (r104 == null) goto L9;
        ouc.j.b(r107, "avg_duration", Long.valueOf(r104.longValue()));
    L9:
        if (r105 == null) goto L11;
        ouc.j.b(r107, "db_fst_duration", Long.valueOf(r105.longValue()));
    L11:
        if (r106 == null) goto L13;
        ouc.j.b(r107, "db_total_duration", Long.valueOf(r106.longValue()));
    L13:
        if (r110 == null) goto L15;
        ouc.j.b(r107, "db_avg_duration", Long.valueOf(r110.longValue()));
    L15:
        if (r101 == null) goto L17;
        ouc.j.a(r107, "is_paging", Boolean.valueOf(r101.booleanValue()));
    L17:
        if (r102 == null) goto L19;
        ouc.j.b(r107, "page_count", Integer.valueOf(r102.intValue()));
    L19:
        if (r111 == null) goto L21;
        ouc.j.b(r107, "fst_count", Integer.valueOf(r111.intValue()));
    L21:
        if (r112 == null) goto L23;
        ouc.j.b(r107, com.bytedance.android.ec.core.event.a.KEY_TOTAL_COUNT, Integer.valueOf(r112.intValue()));
    L23:
        d0 r108 = r107.a();
        if (r108.isEmpty() == false) goto L26;
        return;
    L26:
        d1.f348206b.a("flow_im_load_conversation_finish", r108);
        if (com.larus.im.internal.delegate.c.f348197a.isDebug() == false) goto L30;
        com.larus.im.internal.delegate.a.f348188b.i("FlowImPerfTracing", "flow_im_load_conversation_finish, params: " + r108);
        return;
    }
}
