package com.bytedance.ug.sdk.luckydog.api.log;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f271581a = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/ug/sdk/luckydog/api/log/c$a;", "", "", "", "stages", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "<init>", "()V", "luckydog-api_release"}, k = 1, mv = {1, 4, 0})
    public static final class a {

        @SerializedName("stages")
        private final Map<String, String> stages;

        public a() {
            this.stages = new LinkedHashMap();
        }

        public final Map<String, String> a() {
            return this.stages;
        }

        public final void b(String r100, String r101) {
            if (r101 != null) goto L5;
            com.bytedance.ug.sdk.luckydog.api.log.a.c("LuckyDogDyLogger", "pushStage error: name: " + r100 + " sessionId: " + r101);
            return;
        L5:
            this.stages.put(r100, r101);
        }
    }

    public c() {
    }

    static {
        f271581a = new Gson();
    }

    public static String a(String r100, Map r101, a r102) {
        boolean r103 = true;
        if (r101 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L36;
        if (r102 != null) goto L36;
        return r100;
    L36:
        StringBuilder r105 = new StringBuilder(r100);     // Catch: Exception -> L33
        if (r101 != null) goto L15;
    L18:
        boolean r106 = true;
    L19:
        if (r106 == true) goto L21;
        r105.append("|xParam:");     // Catch: Exception -> L33
        r105.append(new JSONObject(r101).toString());     // Catch: Exception -> L33
    L21:
        if (r102 == null) goto L23;
        Map<String, String> r107 = r102.a();     // Catch: Exception -> L33
    L24:
        if (r107 != null) goto L26;
    L29:
        if (r103 == true) goto L31;
        r105.append("|xContext:");     // Catch: Exception -> L33
        r105.append(f271581a.toJson(r102));     // Catch: Exception -> L33
    L31:
        return r105.toString();
    L26:
        if (r107.isEmpty() == true) goto L29;
        r103 = false;
        goto L29
    L23:
        r107 = null;
        goto L24
    L15:
        if (r101.isEmpty() == true) goto L18;
        r106 = false;
    L33:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.a.a("LuckyDogDyLogger", "formatMessage error : " + e.getMessage());
        return r100;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r104 = false;
        goto L9
    }

    public static void b(String r100, String r101, Map r102, a r103) {
        String r104 = a(r101, r102, r103);
        LuckyDogALogHelper.f271580c.getClass();
        LuckyDogALogHelper.a(4, r100, r104, null);
    }
}
