package com.bytedance.ee.bear.office.list.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ee.bear.more.office.OfficeLongPressLarkAction;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceEventSource;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceItem;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceLongPressAction;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q implements Runnable {
    public final /* synthetic */ oj5.b a;
    public final /* synthetic */ ShareFolderUserPermission b;
    public final /* synthetic */ OfficeLongPressActionContextFactory c;
    public final /* synthetic */ Document d;
    public final /* synthetic */ Fragment e;
    public final /* synthetic */ OfficeSpaceEventSource f;
    public final /* synthetic */ com.bytedance.ee.bear.office.export.space.h g;
    public final /* synthetic */ com.bytedance.ee.bear.office.export.space.j h;
    public final /* synthetic */ com.bytedance.ee.bear.more.office.e i;
    public final /* synthetic */ v j;
    public final /* synthetic */ x k;

    public q(oj5.b r1, ShareFolderUserPermission r2, OfficeLongPressActionContextFactory r3, Document r4, OfficeSpaceItem r5, Fragment r6, OfficeSpaceEventSource r7, com.bytedance.ee.bear.office.export.space.h r8, com.bytedance.ee.bear.office.export.space.j r9, com.bytedance.ee.bear.more.office.e r10, v r11, x r12) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
    }

    public final void a() {
        this.a.t = this.b;
        StringBuilder r1 = new StringBuilder("preload folder permission success. token=");
        OfficeLongPressActionContextFactory r2 = this.c;
        Document r3 = this.d;
        int r4 = OfficeLongPressActionContextFactory.h;
        r2.getClass();
        r1.append(OfficeLongPressActionContextFactory.f(r3));
        String r5 = "OfficeLongPressActionContextFactory";
        tt5.a.h("OfficeLongPressActionContextFactory", r1.toString());
        OfficeLongPressActionContextFactory r6 = this.c;
        Document r15 = this.d;
        oj5.b r14 = this.a;
        Fragment r7 = this.e;
        OfficeSpaceEventSource r13 = this.f;
        com.bytedance.ee.bear.more.office.e r12 = this.i;
        final v r11 = this.j;
        x r10 = this.k;
        r6.getClass();
        if (r7 == null) goto L5;
        FragmentActivity r8 = r7.getActivity();
    L7:
        if ((r8 instanceof FragmentActivity) == false) goto L9;
        FragmentActivity r16 = r8;
    L10:
        if (r7 == null) goto L15;
        Fragment r9 = r7.getParentFragment();
        if (r9 == null) goto L15;
        Fragment r17 = r9;
    L16:
        p r18 = new p(new OfficeLongPressActionContextFactory$refreshFolderPermissionDependentActions$callback$1(r11), r6, r10);
        boolean r19 = t0.u(r15, r6.c);
        Iterator r110 = CollectionsKt.listOf(new Pair[]{TuplesKt.to(OfficeLongPressLarkAction.MOVE_TO, OfficeSpaceLongPressAction.MOVE_TO), TuplesKt.to(OfficeLongPressLarkAction.RENAME, OfficeSpaceLongPressAction.RENAME)}).iterator();
    L18:
        if (r110.hasNext() == false) goto L27;
        Pair r20 = (Pair) r110.next();
        OfficeLongPressLarkAction r21 = (OfficeLongPressLarkAction) r20.component1();
        OfficeSpaceLongPressAction r22 = (OfficeSpaceLongPressAction) r20.component2();
        r11.getClass();
        Intrinsics.checkNotNullParameter(r21, "action");
        String r23 = (String) MapsKt.getValue(r11.c, r21);
        Intrinsics.checkNotNullParameter(r21, "action");
        OfficeLongPressActionContextFactory r24 = r6;
        p r25 = r18;
        x r26 = r10;
        String r27 = r5;
        v r28 = r11;
        com.bytedance.ee.bear.more.office.e r29 = r12;
        OfficeSpaceEventSource r210 = r13;
        oj5.b r211 = r14;
        z r30 = r6.e(r21, r23, r11.b.get(r21), r15, r19, r13, r12, r16, r17, r14, r25);
        Intrinsics.checkNotNullParameter(r21, "action");
        String r31 = (String) MapsKt.getValue(r28.c, r21);
        Intrinsics.checkNotNullParameter(r21, "action");
        if (r28.d(r31, r21, r28.b.get(r21), r30) == true) goto L22;
        String r32 = r27;
        tt5.a.h(r32, "drop folder permission availability refresh. action=" + r21 + ", token=" + OfficeLongPressActionContextFactory.f(r15));
    L24:
        r6 = r24;
        x r33 = r26;
    L26:
        r11 = r28;
        r5 = r32;
        r10 = r33;
        r18 = r25;
        r12 = r29;
        r13 = r210;
        r14 = r211;
        goto L18
    L22:
        r32 = r27;
        OfficeLongPressMenuAction r0 = OfficeLongPressActionContextFactory.h(r21);
        if (r0 == null) goto L24;
        r6 = r24;
        r33 = r26;
        r6.g.post(new t(r33, r0, r30));
        goto L26
    L27:
        return;
    L15:
        r17 = r7;
        goto L16
    L9:
        r16 = null;
        goto L10
    L5:
        r8 = null;
        goto L7
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
