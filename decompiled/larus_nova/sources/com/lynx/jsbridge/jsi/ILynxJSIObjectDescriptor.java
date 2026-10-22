package com.lynx.jsbridge.jsi;

/* JADX INFO: loaded from: classes32.dex */
public interface ILynxJSIObjectDescriptor {
    String getClassName();

    String[] getFields();

    String[] getLynxObjectDescriptorInfo(String r100);

    void warmUp();
}
