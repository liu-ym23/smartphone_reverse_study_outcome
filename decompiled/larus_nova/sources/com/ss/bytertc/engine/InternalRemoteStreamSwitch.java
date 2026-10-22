package com.ss.bytertc.engine;

/* JADX INFO: loaded from: classes40.dex */
public class InternalRemoteStreamSwitch {
    public boolean afterEnable;
    public int afterVideoIndex;
    public boolean beforeEnable;
    public int beforeVideoIndex;
    public boolean isScreen;
    public int reason;
    public String uid;

    public InternalRemoteStreamSwitch() {
    }

    public InternalRemoteStreamSwitch(String r100, boolean r101, int r102, int r103, boolean r104, boolean r105, int r106) {
        this.uid = r100;
        this.isScreen = r101;
        this.beforeVideoIndex = r102;
        this.afterVideoIndex = r103;
        this.beforeEnable = r104;
        this.afterEnable = r105;
        this.reason = r106;
    }

    public static InternalRemoteStreamSwitch create(String r100, boolean r110, int r111, int r112, boolean r113, boolean r114, int r115) {
        return new InternalRemoteStreamSwitch(r100, r110, r111, r112, r113, r114, r115);
    }
}
