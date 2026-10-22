package com.bytedance.bdlocation.entity;

/* JADX INFO: loaded from: classes10.dex */
public class PoiInfoEntity implements Comparable<PoiInfoEntity> {
    public String AmapID;
    public String AwemeID;
    public float Confidence;
    public float Distance;
    public String LocationID;
    public String Name;
    public String Source;
    public String Typecode;

    public PoiInfoEntity() {
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(PoiInfoEntity r100) {
        return Float.compare(r100.Confidence, this.Confidence);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(PoiInfoEntity r100) {
        return compareTo2(r100);
    }
}
