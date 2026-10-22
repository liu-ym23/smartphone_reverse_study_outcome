package com.bytedance.android.livesdk.ktvimpl.concert_stage.biz;

import com.bytedance.android.livesdk.ktvapi.concert_stage.enums.ChorusUserType;
import com.bytedance.android.livesdk.ktvapi.concert_stage.models.JoinChorusConcertStatus;
import com.bytedance.bdlocation.exception.BDLocationException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class x {
    public String a;
    public int b;
    public JoinChorusConcertStatus c;

    public x() {
        this(0);
    }

    public final String toString() {
        return "JoinChorusConcertState(chorusId='" + this.a + "', userType=" + this.b + ", joinStatus=" + this.c + ')';
    }

    public x(int r4) {
        int r5 = ChorusUserType.ChorusUserType_Unknow.getType();
        JoinChorusConcertStatus r0 = JoinChorusConcertStatus.NOT_JOINED;
        Intrinsics.checkNotNullParameter(BDLocationException.ERROR_TIMEOUT, "chorusId");
        Intrinsics.checkNotNullParameter(r0, "joinStatus");
        this.a = BDLocationException.ERROR_TIMEOUT;
        this.b = r5;
        this.c = r0;
    }
}
