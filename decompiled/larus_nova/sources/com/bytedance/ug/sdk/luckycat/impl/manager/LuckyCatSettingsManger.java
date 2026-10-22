package com.bytedance.ug.sdk.luckycat.impl.manager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class LuckyCatSettingsManger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f271282a;

    /* JADX INFO: loaded from: classes22.dex */
    public @interface RefreshStrategy {
        public static final int CLOSE = 0;
        public static final int FE_PAGE_READY = 1;
        public static final int NATIVE_REFRESH = 2;
    }

    /* JADX INFO: loaded from: classes22.dex */
    public class a extends TypeToken<ArrayList<com.bytedance.ug.sdk.luckycat.impl.settings.c>> {
        public a() {
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final LuckyCatSettingsManger f271283a = null;

        static {
            f271283a = new LuckyCatSettingsManger();
        }
    }

    public final boolean a() {
        Object r100 = c(new String[]{"common", "enable_fallback_only_lucky_schema"});
        if ((r100 instanceof Boolean) == true) goto L5;
        return true;
    L5:
        return ((Boolean) r100).booleanValue();
    }

    public final boolean b() {
        Object r100 = c(new String[]{"common", "enable_pad_adapter"});
        if ((r100 instanceof Boolean) == true) goto L5;
        return true;
    L5:
        return ((Boolean) r100).booleanValue();
    }

    public final List<com.bytedance.ug.sdk.luckycat.impl.settings.c> d() {
        Type r100 = new a().getType();     // Catch: Throwable -> L10
        String r101 = c(new String[]{"page_dependencies"}).toString();     // Catch: Exception -> L5 Throwable -> L10
    L6:
        if (r101 != null) goto L8;
        r101 = "[]";
    L8:
        return (List) new Gson().fromJson(r101, r100);
    L5:
        r101 = null;
    L10:
        th = move-exception;
        th.printStackTrace();
        return new ArrayList();
    }

    public LuckyCatSettingsManger() {
        this.f271282a = new d();
    }

    public final List<String> e() {
        Object r100 = c(new String[]{"router_track_params", "proxy_report_params"});
        if ((r100 instanceof JSONArray) == false) goto L15;
        JSONArray r101 = (JSONArray) r100;
        ArrayList r102 = new ArrayList();
        int r103 = 0;
    L16:
    L11:
        e = move-exception;
        e.printStackTrace();
    L13:
        return r102;
    L6:
        if (r103 >= r101.length()) goto L13;
        if (r101.optString(r103) == null) goto L10;
        r102.add(r101.optString(r103));     // Catch: Exception -> L11
    L10:
        r103 = r103 + 1;
        goto L16
    L15:
        return new ArrayList();
    }

    public final List<String> f() {
        Object r100 = c(new String[]{"router_track_params", "route_report_params"});
        if ((r100 instanceof JSONArray) == false) goto L15;
        JSONArray r101 = (JSONArray) r100;
        ArrayList r102 = new ArrayList();
        int r103 = 0;
    L16:
    L11:
        e = move-exception;
        e.printStackTrace();
    L13:
        return r102;
    L6:
        if (r103 >= r101.length()) goto L13;
        if (r101.optString(r103) == null) goto L10;
        r102.add(r101.optString(r103));     // Catch: Exception -> L11
    L10:
        r103 = r103 + 1;
        goto L16
    L15:
        return new ArrayList();
    }

    public final Object c(String... r100) {
        d r101 = this.f271282a;
        if (r100 != null) goto L5;
        r101.getClass();
        return null;
    L5:
        r101.m();
        JSONObject r102 = r101.f271315c;
        int r103 = r100.length;
        int r104 = 0;
        Object r105 = null;
    L6:
        if (r104 >= r103) goto L18;
        String r106 = r100[r104];
        if (r102 == null) goto L25;
        r105 = r102.opt(r106);
        if (r105 == null) goto L26;
        if ((r105 instanceof JSONObject) == false) goto L16;
        r102 = (JSONObject) r105;
    L16:
        r104 = r104 + 1;
        goto L6
    L26:
        return null;
    L25:
        return null;
    L18:
        return r105;
    }
}
