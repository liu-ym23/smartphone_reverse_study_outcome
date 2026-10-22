package com.mammon.audiosdk.structures;

import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.enums.SAMICorePropertyId;

/* JADX INFO: loaded from: classes4.dex */
public class SAMICoreProperty {
    public int dataArrayLen;
    public byte[] dataByteArray;
    public Object[] dataObjectArray;
    public String extraInfo;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public SAMICorePropertyId f384359id;
    public SAMICoreDataType type;
    public Object userContext;
    public int writable;

    public int getDataType() {
        return this.type.getValue();
    }

    public int getExtraInfoLen() {
        String r100 = this.extraInfo;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.length();
    }

    public int getPropertyId() {
        return this.f384359id.getValue();
    }

    public SAMICoreProperty() {
        this.type = SAMICoreDataType.SAMICoreDataType_Null;
        this.f384359id = SAMICorePropertyId.SAMICorePropertyID_Base_UNKNOWN;
        this.extraInfo = "";
    }

    public void setDataType(int r100) {
        this.type = SAMICoreDataType.fromInt(r100);
    }

    public void setPropertyId(int r100) {
        this.f384359id = SAMICorePropertyId.fromInt(r100);
    }
}
