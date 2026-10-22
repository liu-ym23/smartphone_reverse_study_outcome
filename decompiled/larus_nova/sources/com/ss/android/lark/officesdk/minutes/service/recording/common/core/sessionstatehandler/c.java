package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import android.telephony.TelephonyCallback;

/* JADX INFO: loaded from: classes37.dex */
public final class c extends TelephonyCallback implements TelephonyCallback.CallStateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f434587a;

    public c(a r100) {
        this.f434587a = r100;
    }

    @Override // android.telephony.TelephonyCallback.CallStateListener
    public final void onCallStateChanged(int r100) {
        a.a(this.f434587a, r100);
    }
}
