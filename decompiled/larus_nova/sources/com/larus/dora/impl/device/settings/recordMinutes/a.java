package com.larus.dora.impl.device.settings.recordMinutes;

import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f334873a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (this.f334873a == ((a) r100).f334873a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f334873a;
    }

    public final String toString() {
        return "SetRecordingDuringCallFailed(toastResId=" + this.f334873a + ')';
    }

    public a() {
        this.f334873a = R.string.larus_dora_toast_update_failed_cn;
    }
}
