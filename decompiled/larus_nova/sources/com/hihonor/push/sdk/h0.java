package com.hihonor.push.sdk;

import android.os.Bundle;
import android.os.Handler;
import com.hihonor.push.framework.aidl.DataBuffer;
import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.IPushCallback;
import com.hihonor.push.framework.aidl.MessageCodec;
import com.hihonor.push.framework.aidl.entity.ResponseHeader;
import com.hihonor.push.sdk.common.data.ApiException;
import ww7.s;
import ww7.x;
import ww7.y0;

/* JADX INFO: loaded from: classes23.dex */
public class h0 extends IPushCallback.Stub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f276682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x f276683b;

    @Override // com.hihonor.push.framework.aidl.IPushCallback
    public void onResult(DataBuffer r100) {
        Bundle r101 = r100.getHeader();
        Bundle r102 = r100.getBody();
        ResponseHeader r103 = new ResponseHeader();
        MessageCodec.parseMessageEntity(r101, r103);
        Object r104 = this.f276682a;
        if ((r104 instanceof IMessageEntity) == false) goto L5;
        MessageCodec.parseMessageEntity(r102, (IMessageEntity) r104);
    L5:
        x r105 = this.f276683b;
        ApiException r106 = new ApiException(r103.getStatusCode(), r103.getStatusMessage());
        Object r107 = this.f276682a;
        y0.b r108 = (y0.b) r105;
        r108.getClass();
        y0 r109 = y0.f561725c;
        s<?> r110 = r108.f561734a;
        r109.getClass();
        Handler r111 = r109.f561726a;
        r111.sendMessage(r111.obtainMessage(2, r110));
        s<?> r112 = r108.f561734a;
        if (r112.f561702a == null) goto L9;
        r112.a(r106, r107);
        return;
    }

    public h0(Object r100, x r101) {
        this.f276682a = r100;
        this.f276683b = r101;
    }
}
