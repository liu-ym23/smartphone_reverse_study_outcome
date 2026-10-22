package com.bytedance.ee.bear.document.comment.bean;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
public class CommentJsRequestBean implements NonProguard {
    public static final String ACTION_ADD_TRANSLATE_COMMENTS = "addTranslateComments";
    public static final String ACTION_BEGIN_SNYC = "beginSync";
    public static final String ACTION_END_SYNC = "endSync";
    public static final String ACTION_FETCH_COMMENT = "fetchComment";
    public static final String ACTION_MENTION_USER_PERMISION_CHANGE = "mentionUserPermisionChange";
    public static final String ACTION_SET_TRANSLATE_ENABLE_LANG = "setTranslateEnableLang";
    public static final String ACTION_TRANSLATE = "translate";
    private String action;
    private String options;
    private boolean owner;
    private String token;
    private int type;

    public CommentJsRequestBean() {
        this.owner = false;
    }

    public String getAction() {
        return this.action;
    }

    public String getOptions() {
        return this.options;
    }

    public String getToken() {
        return this.token;
    }

    public int getType() {
        return this.type;
    }

    public boolean isOwner() {
        return this.owner;
    }

    public void setAction(String r100) {
        this.action = r100;
    }

    public void setOptions(String r100) {
        this.options = r100;
    }

    public void setOwner(boolean r100) {
        this.owner = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }

    public void setType(int r100) {
        this.type = r100;
    }
}
