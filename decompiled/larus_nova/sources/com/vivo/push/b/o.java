package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.UnvarnishedMessage;

/* JADX INFO: loaded from: classes41.dex */
public final class o extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected UnvarnishedMessage f462246a;

    public o() {
        super(3);
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final String toString() {
        return "OnMessageCommand";
    }

    public final String e() {
        UnvarnishedMessage r100 = this.f462246a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.unpackToJson();
    }

    public final UnvarnishedMessage f() {
        return this.f462246a;
    }

    @Override // com.vivo.push.b.w, com.vivo.push.b.t, com.vivo.push.v
    public final void c(com.vivo.push.d r100) {
        super.c(r100);
        r100.a("msg_v1", this.f462246a.unpackToJson());
    }

    @Override // com.vivo.push.b.w, com.vivo.push.b.t, com.vivo.push.v
    public final void d(com.vivo.push.d r100) {
        super.d(r100);
        String r101 = r100.a("msg_v1");
        if (TextUtils.isEmpty(r101) == true) goto L6;
        UnvarnishedMessage r102 = new UnvarnishedMessage(r101);
        this.f462246a = r102;
        r102.setMsgId(h());
        int r103 = r100.b("transmission_message_event_type", 0);
        this.f462246a.setTransmissionMessageEventType(r103);
        return;
    }
}
