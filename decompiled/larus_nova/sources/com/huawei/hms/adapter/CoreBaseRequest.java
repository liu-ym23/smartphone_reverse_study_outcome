package com.huawei.hms.adapter;

import android.os.Parcelable;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* JADX INFO: loaded from: classes23.dex */
class CoreBaseRequest implements IMessageEntity {

    @Packed
    private String jsonHeader;

    @Packed
    private String jsonObject;

    @Packed
    private Parcelable parcelable;

    public CoreBaseRequest() {
    }

    public String getJsonHeader() {
        return this.jsonHeader;
    }

    public String getJsonObject() {
        return this.jsonObject;
    }

    public Parcelable getParcelable() {
        return this.parcelable;
    }

    public void setJsonHeader(String r100) {
        this.jsonHeader = r100;
    }

    public void setJsonObject(String r100) {
        this.jsonObject = r100;
    }

    public void setParcelable(Parcelable r100) {
        this.parcelable = r100;
    }
}
