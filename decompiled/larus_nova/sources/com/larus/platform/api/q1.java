package com.larus.platform.api;

import android.os.Bundle;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface q1 {
    void a(String r100, Object r101);

    void b(String r100, Bundle r101);

    void c(String r100, Function0<? extends Object> r101);

    void d(boolean r100);

    void e(y r100);

    String getClientDid();

    String getDeviceId();

    String getInstallId();

    String getUserID();

    String getUserUniqueID();

    void putCommonParams(Map<String, String> r100);

    void reportEvent(String r100, JSONObject r101);
}
