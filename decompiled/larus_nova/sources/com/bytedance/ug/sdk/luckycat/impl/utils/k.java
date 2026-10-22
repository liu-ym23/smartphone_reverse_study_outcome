package com.bytedance.ug.sdk.luckycat.impl.utils;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f271520a = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/ug/sdk/luckycat/impl/utils/k$a;", "", "", "", "stages", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "<init>", "()V", "luckycat_container_release"}, k = 1, mv = {1, 4, 0})
    public static final class a {

        @SerializedName("stages")
        private final Map<String, String> stages;

        public a() {
            this.stages = new LinkedHashMap();
        }

        public final Map<String, String> a() {
            return this.stages;
        }

        public final void b(String r100) {
            if (r100 != null) goto L5;
            com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatDyLogger", "pushStage error: name: schema sessionId: " + r100);
            return;
        L5:
            this.stages.put("schema", r100);
        }
    }

    static {
        f271520a = new Gson();
    }

    public static void a(String r100, Map r101, a r102) {
        boolean r103 = false;
        if (((HashMap) r101).isEmpty() == true) goto L25;
    L25:
        StringBuilder r104 = new StringBuilder(r100);     // Catch: Exception -> L21
        if (((HashMap) r101).isEmpty() == false) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == true) goto L12;
        r104.append("|xParam:");     // Catch: Exception -> L21
        r104.append(new JSONObject(r101).toString());     // Catch: Exception -> L21
    L12:
        Map<String, String> r106 = r102.a();     // Catch: Exception -> L21
        if (r106 != null) goto L15;
    L16:
        r103 = true;
    L17:
        if (r103 == true) goto L19;
        r104.append("|xContext:");     // Catch: Exception -> L21
        r104.append(f271520a.toJson(r102));     // Catch: Exception -> L21
    L19:
        r100 = r104.toString();     // Catch: Exception -> L21
    L23:
        LuckyCatALogHelper.f271505e.getClass();
        LuckyCatALogHelper.a(4, "RouteALog", r100);
        return;
    L15:
        if (r106.isEmpty() == false) goto L17;
    L9:
        r105 = false;
    L21:
        e = move-exception;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.b("LuckyCatDyLogger", "formatMessage error : " + e.getMessage());
        goto L23
    }
}
