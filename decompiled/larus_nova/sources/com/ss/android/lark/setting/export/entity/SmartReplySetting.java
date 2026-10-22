package com.ss.android.lark.setting.export.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes38.dex */
public class SmartReplySetting implements Serializable, Comparable<SmartReplySetting> {
    private boolean isSmartActionEnable;
    private boolean isSmartReplyEnable;
    private Long updateTime;

    public SmartReplySetting() {
    }

    public Long getUpdateTime() {
        return this.updateTime;
    }

    public boolean isSmartActionEnable() {
        return this.isSmartActionEnable;
    }

    public boolean isSmartReplyEnable() {
        return this.isSmartReplyEnable;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(SmartReplySetting r100) {
        return Long.compare(this.updateTime.longValue(), r100.updateTime.longValue());
    }

    public void setSmartActionEnable(boolean r100) {
        this.isSmartActionEnable = r100;
    }

    public void setSmartReplyEnable(boolean r100) {
        this.isSmartReplyEnable = r100;
    }

    public void setUpdateTime(Long r100) {
        this.updateTime = r100;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(SmartReplySetting r100) {
        return compareTo2(r100);
    }

    public SmartReplySetting(boolean r100, boolean r101, Long r102) {
        this.isSmartReplyEnable = r100;
        this.isSmartActionEnable = r101;
        this.updateTime = r102;
    }
}
