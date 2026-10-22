package com.larus.bmhome.view.actionbar.edit.kmp;

import com.larus.bmhome.view.actionbar.edit.component.i2;
import cq8.z0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b implements com.larus.bmhome.view.actionbar.edit.component.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f316565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ dq8.a f316566b;

    @Override // com.larus.bmhome.view.actionbar.edit.component.d
    public final void a(i2 r410) {
        Intrinsics.checkNotNullParameter(r410, "selectedItem");
        a r100 = this.f316565a;
        dq8.a r101 = this.f316566b;
        r100.getClass();
        String r110 = r410.f316380b;
        String r111 = r410.f316379a;
        if (r111 != null) goto L5;
    L14:
        dq8.a r102 = this.f316566b;
        r102.f469689e.a(new cq8.d(r102.f469685a, r410.f316379a, r410.f316380b, r410.f316381c, r410.f316382d));
        return;
    L5:
        if (r110 != null) goto L7;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == true) goto L14;
        z0 r112 = r101.f469688d;
        com.larus.bmhome.actionbar.model.a r104 = r101.f469686b;
        String r105 = r112.f465007a;
        String r106 = r112.f465009c;
        String r107 = r112.f465010d;
        Integer r113 = r410.f316381c;
        String r108 = r112.f465012f;
        String r109 = r112.f465013g;
        String r114 = r112.f465016j;
        String r115 = r104.f294947b;
        Boolean r116 = r112.f465015i;
        String r117 = r112.f465014h;
        String r210 = r100.b();
        tx9.b.e(r105, r106, r107, r108, r109, r114, r115, r110, r111, 0, 0, r113, "select", null, null, null, r100.a(), "original", "chat", null, null, null, r210, r117, r116, null, null, null, null, null, null, null, null, null, null, null, null, -59580416, 127);
        goto L14
    L7:
        if (r110.length() == 0) goto L10;
        r103 = false;
        goto L11
    }

    public b(a r100, dq8.a r101) {
        this.f316565a = r100;
        this.f316566b = r101;
    }
}
