package com.ss.bytertc.engine;

import com.ss.bytertc.engine.data.ForwardStreamInfo;

/* JADX INFO: loaded from: classes40.dex */
public class InternalForwardStreamInfo {
    public String roomId;
    public String token;

    public String getRoomId() {
        String r100 = this.roomId;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public String getToken() {
        String r100 = this.token;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public InternalForwardStreamInfo(ForwardStreamInfo r100) {
        this.roomId = r100.roomId;
        this.token = r100.token;
    }

    public InternalForwardStreamInfo(String r100, String r101) {
        this.roomId = r100;
        this.token = r101;
    }
}
