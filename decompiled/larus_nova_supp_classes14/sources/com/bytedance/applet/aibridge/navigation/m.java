package com.bytedance.applet.aibridge.navigation;

import com.bytedance.applet.aibridge.navi.NavigationPageFrom;
import com.bytedance.applet.aibridge.permission.PermissionEnum;
import com.bytedance.applet.task.NavigationCardSessionState;
import com.bytedance.applet.task.NavigationMultitaskCard;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m implements com.larus.navigation.api.p {
    public final /* synthetic */ Function0<NavigationCardSessionState.a> a;
    public final /* synthetic */ String b;

    public final void a() {
        NavigationCardSessionState.a r0 = (NavigationCardSessionState.a) this.a.invoke();
        if (r0 != null) goto L5;
        return;
    L5:
        NavigationMultitaskCard.a.getClass();
        NavigationMultitaskCard.j("notification_removed", r0);
    }

    public final void c() {
        NavigationCardSessionState.a r0 = (NavigationCardSessionState.a) this.a.invoke();
        if (r0 != null) goto L5;
        return;
    L5:
        NavigationMultitaskCard r1 = NavigationMultitaskCard.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, "owner");
        if (NavigationMultitaskCard.e.a(r0) == true) goto L8;
        return;
    L8:
        int r2 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d("nav_jsb_helper", "onNotificationClick: from=" + this.b + ", delegating to NavigationMultitaskCard.openNavigationDetail(\"notification\", NOTIFICATION)");
        NavigationPageFrom r3 = NavigationPageFrom.NOTIFICATION;
        r1.getClass();
        NavigationMultitaskCard.e(PermissionEnum.NOTIFICATION, r3);
    }

    public m(Function0 r1) {
        this.a = r1;
        this.b = "realtime_active";
    }

    public final void b(String r2, String r3, Integer r4, String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r2, "title");
        if (r6 != null) goto L11;
        if (r4 == null) goto L6;
        String r8 = "res:///" + r4.intValue();
    L7:
        if (r8 != null) goto L10;
        if (r5 != null) goto L12;
        r5 = "";
    L12:
        NavigationMultitaskCard r9 = NavigationMultitaskCard.a;
        NavigationCardSessionState.a r10 = (NavigationCardSessionState.a) this.a.invoke();
        if (r10 != null) goto L15;
        return;
    L15:
        NavigationMultitaskCard.b r0 = new NavigationMultitaskCard.b(r2, r3, r5, r7);
        r9.getClass();
        NavigationMultitaskCard.o(r10, r0, false);
        return;
    L10:
        r5 = r8;
        goto L12
    L6:
        r8 = null;
        goto L7
    L11:
        r5 = r6;
        goto L12
    }
}
