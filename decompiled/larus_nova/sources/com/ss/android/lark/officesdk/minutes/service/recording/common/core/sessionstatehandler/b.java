package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import android.telephony.PhoneStateListener;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes37.dex */
public final class b extends PhoneStateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f434586a;

    public b(a r100) {
        this.f434586a = r100;
    }

    @Override // android.telephony.PhoneStateListener
    @Deprecated(message = "Deprecated in Java")
    public final void onCallStateChanged(int r100, String r101) {
        a.a(this.f434586a, r100);
    }
}
