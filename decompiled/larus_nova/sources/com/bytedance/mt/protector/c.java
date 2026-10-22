package com.bytedance.mt.protector;

import com.bytedance.keva.Keva;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f265669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f265670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f265671c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile int f265672d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile a f265673e;

    static {
        f265673e = new d();
    }

    public static boolean b() {
        if (f265671c == true) goto L6;
        return false;
    L6:
        if (f265672d != 0) goto L17;
        f265669a = Keva.getRepo("safe_protector_config_repo", 1).getBoolean("safe_protector_enable_key", f265669a);
        f265672d = 1;
        if (f265670b == true) goto L15;
        String r100 = Keva.getRepo("safe_protector_config_repo", 1).getString("safe_protector_config_key", "[]");
        f265673e.d(String.format("loadConfImmediately lastConfig %s", new Object[]{r100}));
        c(new JsonParser().parse(r100).getAsJsonArray());     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        HashMap r101 = new HashMap();
        r101.put("Protector/SelfData", SelfDataManager.f265657e.c(th).toString());
        f265673e.c(th, r101);
    L15:
        f265673e.d(String.format("IMMEDIATELY_INIT lastEnable: %b", new Object[]{Boolean.valueOf(f265669a)}));
    L17:
        return f265669a;
    }

    public static void c(JsonArray r110) {
        f265673e.d("setConf");
        ThrowableDisposer r100 = ThrowableDisposer.f265662b;
        if (r110 == null) goto L40;
        r100.getClass();
        if (r110.size() == 0) goto L40;
        ((CopyOnWriteArrayList) r100.f265663a).clear();
        Iterator<JsonElement> r101 = r110.iterator();
    L9:
        if (r101.hasNext() == false) goto L41;
        JsonElement r102 = r101.next();
        if (r102 != null) goto L13;
    L37:
        ThrowableDisposer.a r103 = null;
    L38:
        if (r103 == null) goto L9;
        ((CopyOnWriteArrayList) r100.f265663a).add(r103);
        goto L9
    L13:
        if (r102.getAsJsonObject() == null) goto L37;
        r103 = new ThrowableDisposer.a();
        if (r102.getAsJsonObject().has("stackFeatures") == false) goto L33;
        String r104 = r102.getAsJsonObject().get("stackFeatures").getAsString();     // Catch: Exception -> L35
        if (r104 == null) goto L22;
        String[] r105 = r104.split("\n");     // Catch: Exception -> L35
    L23:
        r103.f265665a = r105;     // Catch: Exception -> L35
        if (r102.getAsJsonObject().has("protectorType") == false) goto L32;
        r103.f265666b = r102.getAsJsonObject().get("protectorType").getAsString();     // Catch: Exception -> L35
        if (r102.getAsJsonObject().has("returnType") == false) goto L31;
        r103.f265667c = r102.getAsJsonObject().get("returnType").getAsString();     // Catch: Exception -> L35
        if (r102.getAsJsonObject().has("returnValue") == false) goto L30;
        r103.f265668d = r102.getAsJsonObject().get("returnValue");     // Catch: Exception -> L35
        f265673e.f("create ConfItem " + r103.toString());     // Catch: Exception -> L35
        goto L38
    L30:
        b.a(String.format("ConfItem can't find key %s in %s", new Object[]{"returnValue", r102.toString()}));     // Catch: Exception -> L35
        goto L37
    L31:
        b.a(String.format("ConfItem can't find key %s in %s", new Object[]{"returnType", r102.toString()}));     // Catch: Exception -> L35
        goto L37
    L32:
        b.a(String.format("ConfItem can't find key %s in %s", new Object[]{"protectorType", r102.toString()}));     // Catch: Exception -> L35
        goto L37
    L22:
        r105 = new String[0];     // Catch: Exception -> L35
        goto L23
    L33:
        b.a(String.format("ConfItem can't find key %s in %s", new Object[]{"stackFeatures", r102.toString()}));     // Catch: Exception -> L35
    L35:
        e = move-exception;
        e.printStackTrace();
        f265673e.f("create ConfItem has exception " + e.toString());
    L41:
        f265670b = true;
        Keva r106 = Keva.getRepo("safe_protector_config_repo", 1);
        if (r110 == null) goto L44;
        String r111 = r110.toString();
    L45:
        r106.storeString("safe_protector_config_key", r111);
        return;
    L44:
        r111 = "[]";
    L40:
        ((CopyOnWriteArrayList) r100.f265663a).clear();
        goto L41
    }

    public static f a(ProtectorType r100, Throwable r101) {
        a r102 = f265673e;
        if (r102 != null) goto L13;
    L12:
        return null;
    L13:
        f r103 = ThrowableDisposer.f265662b.a(r100, r101);     // Catch: Throwable -> L6
    L8:
        if (r103 == null) goto L11;
        r102.b(r100, r101);
        return r103;
    L11:
        r102.e(r100, r101);
    L6:
        th = move-exception;
        HashMap r104 = new HashMap();
        r104.put("Protector/SelfData", SelfDataManager.f265657e.c(th).toString());
        f265673e.c(th, r104);
        r103 = null;
        goto L8
    }
}
