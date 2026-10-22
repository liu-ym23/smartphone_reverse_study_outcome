package com.bytedance.badger.y;

import com.bytedance.badger.data.EventReportEnum;
import z64.i;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements z64.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EventReportEnum f199438a;

    public d(EventReportEnum r100) {
        this.f199438a = r100;
    }

    @Override // z64.g
    public final void a(i r100) {
        if ((r100 instanceof i.b) == false) goto L16;
        if (EventReportEnum.LOGIN_BUTTON.getValue().equals(this.f199438a.getValue()) == false) goto L14;
        Object r101 = g.f199443b;
        monitor-enter(r101);
        a74.e.c();     // Catch: Throwable -> L11
        monitor-exit(r101);
    L11:
        th = move-exception;
        throw th;
    L14:
        StringBuilder r102 = new StringBuilder("event report success: event=");
        r102.append(this.f199438a);
        r102.append(" scene=");
        i.b r103 = (i.b) r100;
        r102.append(r103.f570479b);
        r102.append(" full=");
        r102.append(r103.f570480c);
        com.bytedance.badger.e.f("event_behavior# ", r102.toString());
        return;
    L16:
        if ((r100 instanceof i.a) == false) goto L22;
        StringBuilder r104 = new StringBuilder("event report failed: event=");
        r104.append(this.f199438a);
        r104.append(" generated=");
        i.a r105 = (i.a) r100;
        r104.append(r105.f570476b);
        r104.append(" err=");
        r104.append(r105.f570475a.getMessage());
        com.bytedance.badger.e.g("event_behavior# ", r104.toString());
        return;
    }
}
