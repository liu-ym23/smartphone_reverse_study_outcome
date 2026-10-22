package com.ss.android.lark.mention.base.impl.atselector.bean;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes36.dex */
public class AtSelectInitData implements Serializable {
    private String appId;
    private String channelId;
    private ArrayList<String> chatIds;
    private ArrayList<String> chatterIds;
    private String configJson;
    private boolean enableAIKnowledge;
    private boolean enableDoubaoMention;
    private boolean enableMyAI;
    private boolean isUserCountVisible;
    private boolean mIsInterruptAtAll;

    public String getAppId() {
        return this.appId;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public ArrayList<String> getChatIds() {
        return this.chatIds;
    }

    public ArrayList<String> getChatterIds() {
        return this.chatterIds;
    }

    public String getConfigJson() {
        return this.configJson;
    }

    public boolean getIsInterruptAtAll() {
        return this.mIsInterruptAtAll;
    }

    public boolean isEnableAIKnowledge() {
        return this.enableAIKnowledge;
    }

    public boolean isEnableDoubaoMention() {
        return this.enableDoubaoMention;
    }

    public boolean isEnableMyAI() {
        return this.enableMyAI;
    }

    public boolean isUserCountVisible() {
        return this.isUserCountVisible;
    }

    public AtSelectInitData(String r100) {
        this.mIsInterruptAtAll = false;
        this.enableMyAI = true;
        this.enableDoubaoMention = true;
        this.isUserCountVisible = true;
        this.enableAIKnowledge = false;
        this.appId = "";
        this.channelId = r100;
    }

    public void setAppId(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.appId = r100;
    }

    public void setConfigJson(String r100) {
        this.configJson = r100;
    }

    public void setEnableAIKnowledge(boolean r100) {
        this.enableAIKnowledge = r100;
    }

    public void setEnableDoubaoMention(boolean r100) {
        this.enableDoubaoMention = r100;
    }

    public void setEnableMyAI(boolean r100) {
        this.enableMyAI = r100;
    }

    public void setIsInterruptAtAll(boolean r100) {
        this.mIsInterruptAtAll = r100;
    }

    public void setUserCountVisible(boolean r100) {
        this.isUserCountVisible = r100;
    }

    public AtSelectInitData(ArrayList<String> r100, ArrayList<String> r101) {
        this.mIsInterruptAtAll = false;
        this.enableMyAI = true;
        this.enableDoubaoMention = true;
        this.isUserCountVisible = true;
        this.enableAIKnowledge = false;
        this.appId = "";
        this.chatterIds = r100;
        this.chatIds = r101;
    }
}
