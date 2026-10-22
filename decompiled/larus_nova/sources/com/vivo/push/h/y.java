package com.vivo.push.h;

import com.vivo.push.sdk.PushMessageCallback;

/* JADX INFO: loaded from: classes41.dex */
public final class y extends ab {
    public y(com.vivo.push.v r100) {
        super(r100);
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v r100) {
        int r101 = ((com.vivo.push.b.r) r100).e();
        PushMessageCallback r102 = this.f462339b;
        if (r102 == null) goto L6;
        r102.onNotifyGuideDialogResult(r101);
        return;
    }
}
