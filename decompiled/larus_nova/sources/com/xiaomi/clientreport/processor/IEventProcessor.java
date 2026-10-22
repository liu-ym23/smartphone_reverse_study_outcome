package com.xiaomi.clientreport.processor;

import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes41.dex */
public interface IEventProcessor extends c, d {
    String bytesToString(byte[] r100);

    void setEventMap(HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> r100);

    byte[] stringToBytes(String r100);
}
