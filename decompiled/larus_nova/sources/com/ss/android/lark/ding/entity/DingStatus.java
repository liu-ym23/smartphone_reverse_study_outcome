package com.ss.android.lark.ding.entity;

import com.larksuite.framework.utils.CollectionUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
public class DingStatus implements Serializable, b<DingStatus> {
    private Map<String, String> chatterNameMap;
    private List<String> confirmedChatterIds;
    private List<String> invisibleChatterIds;
    private String messageId;
    private List<String> unconfirmedChatterIds;

    public String toString() {
        return "DingStatus{confirmedChatterIds=" + this.confirmedChatterIds + ", unconfirmedChatterIds=" + this.unconfirmedChatterIds + '}';
    }

    public DingStatus() {
        this.confirmedChatterIds = new ArrayList();
        this.unconfirmedChatterIds = new ArrayList();
        this.chatterNameMap = new HashMap();
        this.invisibleChatterIds = new ArrayList();
    }

    public Map<String, String> getChatterNameMap() {
        return this.chatterNameMap;
    }

    public List<String> getConfirmedChatterIds() {
        return this.confirmedChatterIds;
    }

    public List<String> getInvisibleChatterIds() {
        return this.invisibleChatterIds;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public List<String> getUnconfirmedChatterIds() {
        return this.unconfirmedChatterIds;
    }

    public boolean isContentSame(DingStatus r100) {
        List<String> r101 = r100.getConfirmedChatterIds();
        if (this.confirmedChatterIds.size() == r101.size()) goto L5;
    L21:
        return false;
    L5:
        if (this.confirmedChatterIds.containsAll(r101) == false) goto L21;
        List<String> r102 = r100.getUnconfirmedChatterIds();
        if (this.unconfirmedChatterIds.size() != r102.size()) goto L21;
        if (this.unconfirmedChatterIds.containsAll(r102) == false) goto L21;
        Map<String, String> r103 = r100.chatterNameMap;
        if (this.chatterNameMap.size() != r103.size()) goto L21;
        if (this.chatterNameMap.keySet().containsAll(r103.keySet()) == false) goto L21;
        if (this.chatterNameMap.values().containsAll(r103.values()) == false) goto L21;
        return true;
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(b r100) {
        return isItemSame((DingStatus) r100);
    }

    public void setChatterNameMap(Map<String, String> r100) {
        this.chatterNameMap = r100;
    }

    public void setConfirmedChatterIds(List<String> r100) {
        this.confirmedChatterIds.clear();
        if (r100 == null) goto L6;
        this.confirmedChatterIds.addAll(r100);
        return;
    }

    public void setInvisibleChatterIds(List<String> r100) {
        if (CollectionUtils.isNotEmpty(r100) == false) goto L6;
        this.invisibleChatterIds.addAll(r100);
        return;
    }

    public void setMessageId(String r100) {
        this.messageId = r100;
    }

    public void setUnconfirmedChatterIds(List<String> r100) {
        this.unconfirmedChatterIds.clear();
        if (r100 == null) goto L6;
        this.unconfirmedChatterIds.addAll(r100);
        return;
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((DingStatus) r100);
    }

    public boolean isItemSame(DingStatus r100) {
        return equals(r100);
    }
}
