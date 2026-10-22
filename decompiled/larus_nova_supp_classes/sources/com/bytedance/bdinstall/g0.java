package com.bytedance.bdinstall;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface g0 {
    String get(String r1, Map<String, String> r2) throws Exception;

    String post(String r1, byte[] r2, Map<String, String> r3) throws Exception;

    byte[] postStream(String r1, byte[] r2, Map<String, String> r3) throws RangersHttpException;
}
