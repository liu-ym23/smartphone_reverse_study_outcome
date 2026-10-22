package com.vivo.push.h;

import com.vivo.push.model.UnvarnishedMessage;

/* JADX INFO: loaded from: classes41.dex */
final class t extends ab {
    public t(com.vivo.push.v r100) {
        super(r100);
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v r100) {
        com.vivo.push.b.o r101 = (com.vivo.push.b.o) r100;
        UnvarnishedMessage r102 = r101.f();
        if (r102 == null) goto L8;
        if (r102.isTransMsgArrive() == false) goto L8;
        com.vivo.push.m.a().a(new com.vivo.push.b.h(String.valueOf(r101.h())));
    L8:
        if (com.vivo.push.m.a().g() == false) goto L14;
        if (a(com.vivo.push.util.ah.c(this.f462510a), r101.e(), r101.k()) == true) goto L14;
        super.a(1021);
        return;
    L14:
        if (r102 != null) goto L16;
        super.a(2807);
        com.vivo.push.util.t.a("OnMessageTask", " message is null");
        return;
    L16:
        if (r102.isTransMsgExpired() == false) goto L19;
        com.vivo.push.util.t.d("OnMessageTask", "tragetType is Expired msg =" + r102.getMsgId());
        this.f462339b.onTransmissionMessageExpired(r102);
        super.a(0);
        return;
    L19:
        com.vivo.push.util.t.d("OnMessageTask", "tragetType is " + r102.getTargetType() + " ; messageId is " + r102.getMsgId());
        this.f462339b.onTransmissionMessage(this.f462510a, r102);
        super.a(0);
    }
}
