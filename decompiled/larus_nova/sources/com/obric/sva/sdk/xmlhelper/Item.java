package com.obric.sva.sdk.xmlhelper;

/* JADX INFO: loaded from: classes34.dex */
public class Item {
    private String mName;
    private Type mType;
    private String mValue;

    public String toString() {
        return "ITEM:" + this.mName + ":" + this.mValue;
    }

    public String getName() {
        return this.mName;
    }

    public Type getType() {
        return this.mType;
    }

    public String getValue() {
        return this.mValue;
    }

    public void setValue(String r100) {
        this.mValue = r100;
    }

    public Item(String r100, String r101, String r102) {
        this.mName = r100;
        this.mValue = r101;
        this.mType = Type.convert(r102);
    }

    public Item(String r100, String r101, Type r102) {
        this.mName = r100;
        this.mValue = r101;
        this.mType = r102;
    }
}
