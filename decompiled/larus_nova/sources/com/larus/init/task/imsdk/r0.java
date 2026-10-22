package com.larus.init.task.imsdk;

import com.bytedance.common.wschannel.WsChannel;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class r0 implements xf9.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WsChannel f351399a;

    @Override // xf9.d
    public final void close() {
        this.f351399a.unregister();
    }

    @Override // xf9.d
    public final int getChannelId() {
        return this.f351399a.getChannelId();
    }

    public r0(WsChannel r100) {
        Intrinsics.checkNotNullParameter(r100, "wsChannel");
        this.f351399a = r100;
    }

    @Override // xf9.d
    public final void a(final xf9.a r100, final Function2<? super xf9.a, ? super Boolean, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        WsChannelMsg.Builder r102 = WsChannelMsg.Builder.create(this.f351399a.getChannelId()).setService(r100.f563529b).setMethod(r100.f563530c).setPayload(r100.f563531d).setSeqId(r100.f563532e);
        Iterator<T> r103 = r100.f563534g.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        xf9.b r104 = (xf9.b) r103.next();
        r102.addMsgHeader(r104.f563535a, r104.f563536b);
        goto L4
    L6:
        WsChannelMsg r105 = r102.build();
        String r106 = r100.f563533f;
        if (r106 == null) goto L9;
        r105.setUUID(r106);
    L9:
        this.f351399a.sendMsg(r105, new q0(r101, r100));
    }
}
