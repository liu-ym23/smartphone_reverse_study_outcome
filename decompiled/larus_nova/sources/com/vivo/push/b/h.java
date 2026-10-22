package com.vivo.push.b;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes41.dex */
public final class h extends com.vivo.push.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f462232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f462233b;

    public h() {
        super(2013);
    }

    public h(String r100) {
        this();
        this.f462232a = r100;
    }

    @Override // com.vivo.push.v
    public final void c(com.vivo.push.d r100) {
        r100.a("MsgArriveCommand.MSG_TAG", this.f462232a);
        if (TextUtils.isEmpty(this.f462233b) == true) goto L6;
        r100.a("MsgArriveCommand.NODE_INFO", this.f462233b);
        return;
    }

    @Override // com.vivo.push.v
    public final void d(com.vivo.push.d r100) {
        this.f462232a = r100.a("MsgArriveCommand.MSG_TAG");
        this.f462233b = r100.a("MsgArriveCommand.NODE_INFO");
    }

    public h(String r100, String r101) {
        this(r100);
        this.f462233b = r101;
    }
}
