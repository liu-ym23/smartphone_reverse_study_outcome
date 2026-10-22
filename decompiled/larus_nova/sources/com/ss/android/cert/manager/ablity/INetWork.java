package com.ss.android.cert.manager.ablity;

import android.util.Pair;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public interface INetWork {
    int checkResponseException(Throwable r100);

    String executeGet(String r100, Map<String, String> r101, Map<String, String> r102, Map<String, Object> r103) throws Exception;

    String executePost(String r100, Map<String, String> r101, String r102, Map<String, Object> r103) throws Exception;

    String executePost(String r100, Map<String, String> r101, Map<String, String> r102, Map<String, Object> r103) throws Exception;

    String executePostFile(String r100, Map<String, String> r101, Map<String, String> r102, Map<String, Pair<String, byte[]>> r103) throws Exception;

    int getExceptionStatusCode(Throwable r100);
}
