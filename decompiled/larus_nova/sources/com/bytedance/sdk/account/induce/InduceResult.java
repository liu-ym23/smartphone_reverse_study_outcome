package com.bytedance.sdk.account.induce;

import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class InduceResult implements Serializable {
    public JSONObject extraInfo;
    public String loginWay;
    public String notShowLoginReason;
    public JSONObject sceneStrategy;
    public ArrayList<String> scenes;
    public boolean showLogin;
    public String showScene;

    public InduceResult() {
    }
}
