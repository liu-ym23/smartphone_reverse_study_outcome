package com.bytedance.ee.bear.middleground.feed.export.bean;

import com.bytedance.ee.bear.middleground.comment.export.bean.TranslateConfig;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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
        this.documentType = sbb.e.g;
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
    public /* bridge */ /* synthetic */ Object m238clone() throws CloneNotSupportedException {
        return clone();
    }

    public void setAuto(boolean r1) {
        this.auto = r1;
    }

    public void setCanCopy(boolean r1) {
        this.canCopy = r1;
    }

    public void setCanReopen(boolean r1) {
        this.canReopen = r1;
    }

    public void setDocumentType(sbb.e r1) {
        this.documentType = r1;
    }

    public void setFilterTimestamp(Long r1) {
        this.filterTimestamp = r1;
    }

    public void setLoadingSuccess(boolean r1) {
        this.loadingSuccess = r1;
    }

    public void setOwner(boolean r1) {
        this.owner = r1;
    }

    public void setSupportMute(boolean r1) {
        this.supportMute = r1;
    }

    public void setSupportReadAll(boolean r1) {
        this.supportReadAll = r1;
    }

    public void setToken(String r1) {
        this.token = r1;
    }

    public void setTranslateConfig(TranslateConfig r1) {
        this.translateConfig = r1;
    }

    public void setWhole(boolean r1) {
        this.whole = r1;
    }
}
