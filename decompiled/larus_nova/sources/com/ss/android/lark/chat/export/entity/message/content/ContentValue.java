package com.ss.android.lark.chat.export.entity.message.content;

import java.io.Serializable;

/* JADX INFO: loaded from: classes35.dex */
public class ContentValue implements Serializable {
    private SystemMessageAction action;
    private int actionId;
    private ContentValueType contentValueType;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f415396id;
    private Boolean isAnonymous;
    private boolean isClickable;
    private String link;
    private String value;

    public ContentValue() {
    }

    public SystemMessageAction getAction() {
        return this.action;
    }

    public int getActionId() {
        return this.actionId;
    }

    public ContentValueType getContentValueType() {
        return this.contentValueType;
    }

    public String getId() {
        return this.f415396id;
    }

    public String getLink() {
        return this.link;
    }

    public String getValue() {
        return this.value;
    }

    public Boolean isAnonymous() {
        return this.isAnonymous;
    }

    public boolean isClickable() {
        return this.isClickable;
    }

    public void setAction(SystemMessageAction r100) {
        this.action = r100;
    }

    public void setActionId(int r100) {
        this.actionId = r100;
    }

    public void setAnonymous(Boolean r100) {
        this.isAnonymous = r100;
    }

    public void setClickable(boolean r100) {
        this.isClickable = r100;
    }

    public void setContentValueType(ContentValueType r100) {
        this.contentValueType = r100;
    }

    public void setId(String r100) {
        this.f415396id = r100;
    }

    public void setLink(String r100) {
        this.link = r100;
    }

    public void setValue(String r100) {
        this.value = r100;
    }
}
