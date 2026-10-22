package com.ss.bytertc.engine.aigc;

import com.ss.bytertc.engine.RTCRoomConfig;
import com.ss.bytertc.engine.UserInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class AIGCSessionConfig {
    public String action;
    public String fgConfig;
    public boolean joinRoomNeedSdp;
    public JSONObject message;
    public RTCRoomConfig roomConfig;
    public int timeout;
    public String token;
    public String type;
    public UserInfo userInfo;

    public AIGCSessionConfig(String r100, UserInfo r101, RTCRoomConfig r102, String r103, String r104, JSONObject r105, int r106) {
        this.fgConfig = "";
        this.token = r100;
        this.userInfo = r101;
        this.roomConfig = r102;
        this.type = r103;
        this.action = r104;
        this.message = r105;
        this.timeout = r106;
        this.joinRoomNeedSdp = false;
    }

    public AIGCSessionConfig(String r100, UserInfo r101, RTCRoomConfig r102, String r103, String r104, JSONObject r105, int r106, boolean r107) {
        this.fgConfig = "";
        this.token = r100;
        this.userInfo = r101;
        this.roomConfig = r102;
        this.type = r103;
        this.action = r104;
        this.message = r105;
        this.timeout = r106;
        this.joinRoomNeedSdp = r107;
    }

    public AIGCSessionConfig(String r100, UserInfo r101, RTCRoomConfig r102, String r103, String r104, JSONObject r105, int r106, boolean r107, String r108) {
        this.token = r100;
        this.userInfo = r101;
        this.roomConfig = r102;
        this.type = r103;
        this.action = r104;
        this.message = r105;
        this.timeout = r106;
        this.joinRoomNeedSdp = r107;
        this.fgConfig = r108;
    }
}
