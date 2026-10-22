package com.bytedance.mt.protector;

import com.bytedance.keva.Keva;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class c {
    public static volatile boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static volatile int d;
    public static volatile a e;

    static {
        e = new d();
    }

    public static boolean b() {
        if (c == true) goto L6;
        return false;
    L6:
        if (d != 0) goto L17;
        a = Keva.getRepo("safe_protector_config_repo", 1).getBoolean("safe_protector_enable_key", a);
        d = 1;
        if (b == true) goto L15;
        String r0 = Keva.getRepo("safe_protector_config_repo", 1).getString("safe_protector_config_key", "[]");
        e.d(String.format("loadConfImmediately lastConfig %s", new Object[]{r0}));
        c(new JsonParser().parse(r0).getAsJsonArray());     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        HashMap r3 = new HashMap();
        r3.put("Protector/SelfData", SelfDataManager.e.c(th).toString());
        e.c(th, r3);
    L15:
        e.d(String.format("IMMEDIATELY_INIT lastEnable: %b", new Object[]{Boolean.valueOf(a)}));
    L17:
        return a;
    }

    public static void c(JsonArray r14) {
        e.d("setConf");
        ThrowableDisposer r0 = ThrowableDisposer.b;
        if (r14 == null) goto L40;
        r0.getClass();
        if (r14.size() == 0) goto L40;
        ((CopyOnWriteArrayList) r0.a).clear();
        Iterator<JsonElement> r2 = r14.iterator();
    L9:
        if (r2.hasNext() == false) goto L41;
        JsonElement r3 = r2.next();
        if (r3 != null) goto L13;
    L37:
        ThrowableDisposer.a r9 = null;
    L38:
        if (r9 == null) goto L9;
        ((CopyOnWriteArrayList) r0.a).add(r9);
        goto L9
    L13:
        if (r3.getAsJsonObject() == null) goto L37;
        r9 = new ThrowableDisposer.a();
        if (r3.getAsJsonObject().has("stackFeatures") == false) goto L33;
        String r7 = r3.getAsJsonObject().get("stackFeatures").getAsString();     // Catch: Exception -> L35
        if (r7 == null) goto L22;
        String[] r8 = r7.split("\n");     // Catch: Exception -> L35
    L23:
        r9.a = r8;     // Catch: Exception -> L35
        if (r3.getAsJsonObject().has("protectorType") == false) goto L32;
        r9.b = r3.getAsJsonObject().get("protectorType").getAsString();     // Catch: Exception -> L35
        if (r3.getAsJsonObject().has("returnType") == false) goto L31;
        r9.c = r3.getAsJsonObject().get("returnType").getAsString();     // Catch: Exception -> L35
        if (r3.getAsJsonObject().has("returnValue") == false) goto L30;
        r9.d = r3.getAsJsonObject().get("returnValue");     // Catch: Exception -> L35
        e.f("create ConfItem " + r9.toString());     // Catch: Exception -> L35
        goto L38
    L30:
        b.a(String.format("ConfItem can't find key %s in %s", new Object[]{"returnValue", r3.toString()}));     // Catch: Exception -> L35
        goto L37
    L31:
        b.a(String.format("ConfItem can't find key %s in %s", new Object[]{"returnType", r3.toString()}));     // Catch: Exception -> L35
        goto L37
    L32:
        b.a(String.format("ConfItem can't find key %s in %s", new Object[]{"protectorType", r3.toString()}));     // Catch: Exception -> L35
        goto L37
    L22:
        r8 = new String[0];     // Catch: Exception -> L35
        goto L23
    L33:
        b.a(String.format("ConfItem can't find key %s in %s", new Object[]{"stackFeatures", r3.toString()}));     // Catch: Exception -> L35
    L35:
        e = move-exception;
        e.printStackTrace();
        e.f("create ConfItem has exception " + e.toString());
    L41:
        b = true;
        Keva r1 = Keva.getRepo("safe_protector_config_repo", 1);
        if (r14 == null) goto L44;
        String r15 = r14.toString();
    L45:
        r1.storeString("safe_protector_config_key", r15);
        return;
    L44:
        r15 = "[]";
    L40:
        ((CopyOnWriteArrayList) r0.a).clear();
        goto L41
    }

    public static f a(ProtectorType r6, Throwable r7) {
        a r0 = e;
        if (r0 != null) goto L13;
    L12:
        return null;
    L13:
        f r2 = ThrowableDisposer.b.a(r6, r7);     // Catch: Throwable -> L6
    L8:
        if (r2 == null) goto L11;
        r0.b(r6, r7);
        return r2;
    L11:
        r0.e(r6, r7);
    L6:
        th = move-exception;
        HashMap r3 = new HashMap();
        r3.put("Protector/SelfData", SelfDataManager.e.c(th).toString());
        e.c(th, r3);
        r2 = null;
        goto L8
    }
}
