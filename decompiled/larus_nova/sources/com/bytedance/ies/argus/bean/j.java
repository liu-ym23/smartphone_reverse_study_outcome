package com.bytedance.ies.argus.bean;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f246040a;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.ies.argus.bean.j$a$a, reason: collision with other inner class name */
        public static final class C3517a {
        }

        static {
        }

        public a() {
        }

        public static JSONObject a(JSONObject r110, JSONObject r111, Integer r112) {
            if (r112 != null) goto L5;
        L7:
            JSONObject r100 = new JSONObject(r111.toString());
            if (r112 != null) goto L10;
        L18:
            int r113 = 2;
        L19:
            if (r113 != 1) goto L24;
            Iterator<String> r114 = r110.keys();
        L22:
            if (r114.hasNext() == false) goto L47;
            String r115 = r114.next();
            r100.put(r115, r110.get(r115));
        L47:
            return r100;
        L24:
            Iterator<String> r101 = r110.keys();
        L26:
            if (r101.hasNext() == false) goto L47;
            String r102 = r101.next();
            Object r103 = r110.get(r102);
            if (r111.has(r102) == true) goto L29;
            r100.put(r102, r103);
            goto L26
        L29:
            Object r104 = r111.get(r102);
            if ((r104 instanceof JSONObject) == false) goto L35;
            if ((r103 instanceof JSONObject) == false) goto L35;
            r100.put(r102, a((JSONObject) r103, (JSONObject) r104, Integer.valueOf(r113 - 1)));
        L35:
            if ((r104 instanceof JSONArray) == false) goto L45;
            if ((r103 instanceof JSONArray) == false) goto L45;
            JSONArray r105 = (JSONArray) r104;
            JSONArray r106 = (JSONArray) r103;
            JSONArray r107 = new JSONArray();
            int r108 = r105.length();
            int r109 = 0;
        L39:
            if (r109 >= r108) goto L41;
            r107.put(r105.get(r109));
            r109 = r109 + 1;
            goto L39
        L41:
            int r116 = r106.length();
            int r117 = 0;
        L42:
            if (r117 >= r116) goto L44;
            r107.put(r106.get(r117));
            r117 = r117 + 1;
            goto L42
        L44:
            r100.put(r102, r107);
        L45:
            r100.put(r102, r103);
            goto L26
        L10:
            if (r112.intValue() <= 0) goto L12;
            boolean r118 = true;
        L13:
            if (r118 == true) goto L16;
            r112 = null;
        L16:
            if (r112 == null) goto L18;
            r113 = r112.intValue();
            goto L19
        L12:
            r118 = false;
            goto L13
        L5:
            if (r112.intValue() != 0) goto L7;
            return r110;
        }
    }

    public static final class b {
    }

    static {
    }

    public j() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f246040a, ((j) r100).f246040a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        JSONObject r100 = this.f246040a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "BasicConfigModel(conf=" + this.f246040a + ')';
    }

    public j(JSONObject r100) {
        this.f246040a = r100;
    }
}
