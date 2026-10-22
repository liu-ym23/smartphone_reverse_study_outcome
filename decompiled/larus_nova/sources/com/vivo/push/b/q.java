package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;

/* JADX INFO: loaded from: classes41.dex */
public final class q extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected InsideNotificationItem f462257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f462258b;

    public q() {
        super(4);
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final String toString() {
        return "OnNotifyArrivedCommand";
    }

    public final String f() {
        if (TextUtils.isEmpty(this.f462258b) == false) goto L11;
        InsideNotificationItem r100 = this.f462257a;
        if (r100 != null) goto L9;
        return null;
    L9:
        return com.vivo.push.util.u.b(r100);
    L11:
        return this.f462258b;
    }

    public final boolean g() {
        InsideNotificationItem r100 = this.f462257a;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.isNoShowOnForeground() == false) goto L10;
        return true;
    L10:
        return false;
    }

    public final InsideNotificationItem e() {
        return this.f462257a;
    }

    @Override // com.vivo.push.b.w, com.vivo.push.b.t, com.vivo.push.v
    public final void c(com.vivo.push.d r100) {
        super.c(r100);
        String r101 = com.vivo.push.util.u.b(this.f462257a);
        this.f462258b = r101;
        r100.a("notification_v1", r101);
    }

    @Override // com.vivo.push.b.w, com.vivo.push.b.t, com.vivo.push.v
    public final void d(com.vivo.push.d r100) {
        super.d(r100);
        String r101 = r100.a("notification_v1");
        this.f462258b = r101;
        if (TextUtils.isEmpty(r101) == true) goto L8;
        InsideNotificationItem r102 = com.vivo.push.util.u.a(this.f462258b);
        this.f462257a = r102;
        if (r102 == null) goto L9;
        r102.setMsgId(h());
        return;
    L9:
        return;
    }
}
