package jn7;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface i {
    String a(String r100, JSONObject r101) throws Exception;

    void checkResponseException(Throwable r100);

    String executeGet(String r100) throws Exception;

    void getHost();
}
