package com.bytedance.ug.sdk.deeplink;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface CallBackForAppLink {
    boolean dealWithSchema(String r100);

    void dealWithSchemaIsEmpty();

    List<String> getHostList();
}
