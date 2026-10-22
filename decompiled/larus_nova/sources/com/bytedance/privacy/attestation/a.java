package com.bytedance.privacy.attestation;

import android.text.TextUtils;
import com.bytedance.security.eventproto.monitor.ErrorEvent;
import com.bytedance.security.eventproto.monitor.NormalEvent;
import com.bytedance.security.eventproto.monitor.wrapper.AttestationConfigInfoWrapper;

/* JADX INFO: loaded from: classes6.dex */
public final class a {
    public static void a(int r100, String r101, String r102, long r103, AttestationConfig r110) {
        if (r100 != 0) goto L5;
        NormalEvent.eventReport(1, 0, r101, r102, r103);
        return;
    L5:
        ErrorEvent.eventReport(1, 0, r101, r102, r100, AttestationConfigInfoWrapper.newBuilder().setReqUdid(r110.isIdRequested(AttestationConfig.IdType.UDID)).setReqRpdid(r110.isIdRequested(AttestationConfig.IdType.RPDID)).setReqRpuid(r110.isIdRequested(AttestationConfig.IdType.RPUID)).setAddCustomInfo(!TextUtils.isEmpty(r110.getCustomInfo())).setDevHealthStatusRequired(r110.isDevHealthStatusRequired()).build());
    }
}
