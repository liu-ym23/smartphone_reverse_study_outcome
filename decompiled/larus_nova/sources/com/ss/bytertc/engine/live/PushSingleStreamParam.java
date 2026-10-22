package com.ss.bytertc.engine.live;

/* JADX INFO: loaded from: classes40.dex */
public class PushSingleStreamParam {
    public boolean isScreen;
    public String roomId;
    public String url;
    public String userId;

    public PushSingleStreamParam() {
        this.isScreen = false;
    }

    public PushSingleStreamParam(String r100, String r101, String r102, boolean r103) {
        this.roomId = r100;
        this.userId = r101;
        this.url = r102;
        this.isScreen = r103;
    }
}
