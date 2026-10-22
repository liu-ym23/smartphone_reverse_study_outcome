package com.bytedance.timonbase;

import android.app.Application;
import com.bytedance.timonbase.utils.EnumUtils$Priority;
import com.bytedance.timonbase.utils.EnumUtils$WorkType;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/timonbase/ITMLifecycleService;", "", "timonbase_release"}, k = 1, mv = {1, 4, 0})
public interface ITMLifecycleService {

    public static final class a {
        public static boolean a(ITMLifecycleService r100) {
            boolean r101 = TMEnv.f270767a;
            JsonObject r102 = com.bytedance.timonbase.config.a.f270807a;
            JsonObject r103 = com.bytedance.timonbase.config.a.a(r100.c());
            if (r103 == null) goto L7;
            JsonElement r104 = r103.get("enable");
            if (r104 == null) goto L7;
            return r104.getAsBoolean();
        L7:
            return true;
        }
    }

    EnumUtils$WorkType a();

    void b();

    String c();

    void d(int r100, String r101, Function0<String> r102, Application r103, com.bytedance.timonbase.a r104);

    void e();

    boolean enable();

    void onConfigUpdate();

    EnumUtils$Priority priority();
}
