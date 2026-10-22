package com.bytedance.bdinstall;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface g0 {
    String get(String r100, Map<String, String> r101) throws Exception;

    String post(String r100, byte[] r101, Map<String, String> r102) throws Exception;

    byte[] postStream(String r100, byte[] r101, Map<String, String> r102) throws RangersHttpException;
}
