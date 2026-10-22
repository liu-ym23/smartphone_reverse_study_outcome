package com.bytedance.ee.bear.middleground.feed.export.bean;

import com.bytedance.ee.bear.middleground.comment.export.bean.TranslateConfig;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public class MessageConfig implements NonProguard, Cloneable {
    private static final String TAG = "MessageConfig";
    private boolean auto;
    private boolean canCopy;
    private boolean canReopen;
    private sbb.e documentType;
    private Long filterTimestamp;
    private boolean loadingSuccess;
    private boolean owner;
    private boolean supportMute;
    private boolean supportReadAll;
    private String token;
    private TranslateConfig translateConfig;
    private boolean whole;

    public MessageConfig() {
        this.documentType = sbb.e.f541296g;
        this.owner = false;
        this.loadingSuccess = true;
        this.canCopy = false;
        this.canReopen = false;
        this.auto = false;
        this.whole = false;
        this.supportMute = false;
        this.supportReadAll = false;
        this.translateConfig = new TranslateConfig();
        this.filterTimestamp = null;
    }

    public MessageConfig clone() {
        return (MessageConfig) super.clone();
    L4:
        e = move-exception;
        tt5.a.f(TAG, e, false);
        return null;
    }

    public sbb.e getDocumentType() {
        return this.documentType;
    }

    public Long getFilterTimestamp() {
        return this.filterTimestamp;
    }

    public String getToken() {
        return this.token;
    }

    public TranslateConfig getTranslateConfig() {
        return this.translateConfig;
    }

    public boolean isAuto() {
        return this.auto;
    }

    public boolean isCanCopy() {
        return this.canCopy;
    }

    public boolean isCanReopen() {
        return this.canReopen;
    }

    public boolean isLoadingSuccess() {
        return this.loadingSuccess;
    }

    public boolean isOwner() {
        return this.owner;
    }

    public boolean isSupportMute() {
        return this.supportMute;
    }

    public boolean isSupportReadAll() {
        return this.supportReadAll;
    }

    public boolean isWhole() {
        return this.whole;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8327clone() throws CloneNotSupportedException {
        return clone();
    }

    public void setAuto(boolean r100) {
        this.auto = r100;
    }

    public void setCanCopy(boolean r100) {
        this.canCopy = r100;
    }

    public void setCanReopen(boolean r100) {
        this.canReopen = r100;
    }

    public void setDocumentType(sbb.e r100) {
        this.documentType = r100;
    }

    public void setFilterTimestamp(Long r100) {
        this.filterTimestamp = r100;
    }

    public void setLoadingSuccess(boolean r100) {
        this.loadingSuccess = r100;
    }

    public void setOwner(boolean r100) {
        this.owner = r100;
    }

    public void setSupportMute(boolean r100) {
        this.supportMute = r100;
    }

    public void setSupportReadAll(boolean r100) {
        this.supportReadAll = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }

    public void setTranslateConfig(TranslateConfig r100) {
        this.translateConfig = r100;
    }

    public void setWhole(boolean r100) {
        this.whole = r100;
    }
}
