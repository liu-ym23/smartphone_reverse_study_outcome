package com.ss.android.socialbase.appdownloader.util.parser.manifest;

/* JADX INFO: loaded from: classes38.dex */
public interface AttributeSet {
    boolean getAttributeBooleanValue(int r100, boolean r101);

    boolean getAttributeBooleanValue(String r100, String r101, boolean r102);

    int getAttributeCount();

    float getAttributeFloatValue(int r100, float r101);

    float getAttributeFloatValue(String r100, String r101, float r102);

    int getAttributeIntValue(int r100, int r101);

    int getAttributeIntValue(String r100, String r101, int r102);

    int getAttributeListValue(int r100, String[] r101, int r102);

    int getAttributeListValue(String r100, String r101, String[] r102, int r103);

    String getAttributeName(int r100);

    int getAttributeNameResource(int r100);

    int getAttributeResourceValue(int r100, int r101);

    int getAttributeResourceValue(String r100, String r101, int r102);

    int getAttributeUnsignedIntValue(int r100, int r101);

    int getAttributeUnsignedIntValue(String r100, String r101, int r102);

    String getAttributeValue(int r100);

    String getAttributeValue(String r100, String r101);

    int getAttributeValueData(int r100);

    int getAttributeValueType(int r100);

    String getClassAttribute();

    String getIdAttribute();

    int getIdAttributeResourceValue(int r100);

    String getPositionDescription();

    int getStyleAttribute();
}
