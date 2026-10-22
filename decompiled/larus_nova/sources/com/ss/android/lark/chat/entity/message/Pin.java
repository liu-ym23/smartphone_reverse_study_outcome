package com.ss.android.lark.chat.entity.message;

import java.io.Serializable;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
public class Pin implements Serializable, b<Pin> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient boolean f415301a;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f415302id;
    private String operatorDefaultName;
    private volatile String operatorDisplayName;
    private String operatorId;
    private long timeStamp;

    public String toString() {
        return "[timestamp = " + this.timeStamp + " , id = " + this.f415302id + " ]";
    }

    public String getId() {
        return this.f415302id;
    }

    public String getOperatorDefaultName() {
        return this.operatorDefaultName;
    }

    public String getOperatorDisplayName() {
        return this.operatorDisplayName;
    }

    public String getOperatorId() {
        return this.operatorId;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public boolean isHasRead() {
        return this.f415301a;
    }

    public boolean isContentSame(Pin r100) {
        if (this.timeStamp == r100.getTimeStamp()) goto L6;
        return false;
    L6:
        if (this.operatorId.equals(r100.getOperatorId()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    public boolean isItemSame(Pin r100) {
        return this.f415302id.equals(r100.getId());
    }

    public void setHasRead(boolean r100) {
        this.f415301a = r100;
    }

    public void setId(String r100) {
        this.f415302id = r100;
    }

    public void setOperatorDefaultName(String r100) {
        this.operatorDefaultName = r100;
    }

    public void setOperatorDisplayName(String r100) {
        this.operatorDisplayName = r100;
    }

    public void setTimeStamp(int r100) {
        this.timeStamp = r100;
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((Pin) r100);
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(b r100) {
        return isItemSame((Pin) r100);
    }

    public Pin(String r100, String r101, String r102, String r103, long r104) {
        this.f415301a = false;
        this.f415302id = r100;
        this.operatorId = r101;
        this.operatorDisplayName = r102;
        this.operatorDefaultName = r103;
        this.timeStamp = r104;
    }
}
