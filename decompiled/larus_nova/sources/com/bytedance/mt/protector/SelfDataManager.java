package com.bytedance.mt.protector;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.annotations.Expose;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class SelfDataManager {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final SelfDataManager f265657e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadLocal<SelfDataItem> f265658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<SelfDataItem> f265659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Gson f265660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f265661d;

    public static class SelfDataItem {

        @Expose
        JsonElement payload;
        Throwable sourceThrowable;

        @Expose
        long timeStamp;

        @Expose
        String type;

        public SelfDataItem() {
        }

        public String toString() {
            return "SelfDataItem{, payload=" + this.payload + ", timeStamp=" + this.timeStamp + ", type=" + this.type + '}';
        }

        public JsonElement toJsonObject(Gson r100) {
            return r100.toJsonTree(this);
        }
    }

    static {
        f265657e = new SelfDataManager();
    }

    public SelfDataManager() {
        this.f265658a = new ThreadLocal();
        this.f265659b = Collections.synchronizedList(new ArrayList());
        this.f265660c = new GsonBuilder().setLenient().excludeFieldsWithoutExposeAnnotation().create();
        this.f265661d = System.currentTimeMillis();
    }

    public static String b(Throwable r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        StringWriter r101 = new StringWriter();
        PrintWriter r102 = new PrintWriter(r101);
        r100.printStackTrace(r102);
        r102.flush();
        r102.close();
        return r101.toString();
    }

    public final JsonObject c(Throwable r110) {
        JsonObject r100 = new JsonObject();
        JsonArray r101 = new JsonArray();
        SelfDataItem r102 = this.f265658a.get();
        if (r102 == null) goto L14;
        Throwable r103 = r102.sourceThrowable;
        if (r103 == null) goto L11;
        if (r110 == null) goto L11;
        if (r103 != r110) goto L10;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L14;
        r101.add(r102.toJsonObject(this.f265660c));
    L35:
        r100.add("initTimeStamp", new JsonPrimitive(Long.valueOf(this.f265661d)));
        r100.add("reportTimeStamp", new JsonPrimitive(Long.valueOf(System.currentTimeMillis())));
        r100.add("data", r101);
        c.f265673e.f(String.format("%s %s", new Object[]{"BusinessTokenManager", "toJsonObject" + r100.toString()}));
        return r100;
    L10:
        r104 = TextUtils.equals(b(r103), b(r110));
    L11:
        r104 = false;
    L14:
        List<SelfDataItem> r105 = this.f265659b;
        monitor-enter(r105);
        Iterator<SelfDataItem> r106 = this.f265659b.iterator();     // Catch: Throwable -> L28
    L18:
        if (r106.hasNext() == false) goto L33;
        SelfDataItem r107 = r106.next();     // Catch: Throwable -> L28
        if (r110 == null) goto L21;
        if (r107 == null) goto L18;
        Throwable r108 = r107.sourceThrowable;     // Catch: Throwable -> L28
        if (r108 == null) goto L30;
        if (r108 != r110) goto L27;
        boolean r109 = true;
    L31:
        if (r109 == false) goto L18;
        r101.add(r107.toJsonObject(this.f265660c));     // Catch: Throwable -> L28
        goto L18
    L27:
        r109 = TextUtils.equals(b(r108), b(r110));     // Catch: Throwable -> L28
        goto L31
    L30:
        r109 = false;
        goto L31
    L21:
        r101.add(r107.toJsonObject(this.f265660c));     // Catch: Throwable -> L28
        goto L18
    L33:
        this.f265659b.size();     // Catch: Throwable -> L28
        monitor-exit(r105);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    }

    public final void a(String r100, JsonObject r101, Throwable r102) {
        SelfDataItem r103 = new SelfDataItem();
        r103.type = r100;
        r103.payload = r101;
        r103.sourceThrowable = r102;
        r103.timeStamp = System.currentTimeMillis();
        if (this.f265659b.size() < 5) goto L5;
        this.f265659b.remove(0);
    L5:
        this.f265659b.add(r103);
        this.f265658a.set(r103);
    }
}
