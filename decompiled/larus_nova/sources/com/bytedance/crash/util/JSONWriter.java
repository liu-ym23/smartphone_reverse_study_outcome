package com.bytedance.crash.util;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class JSONWriter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Writer f203402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Scope> f203403b;

    public static final enum Scope extends Enum<Scope> {
        public static final Scope DANGLING_KEY = null;
        public static final Scope EMPTY_ARRAY = null;
        public static final Scope EMPTY_OBJECT = null;
        public static final Scope NONEMPTY_ARRAY = null;
        public static final Scope NONEMPTY_OBJECT = null;
        public static final Scope NULL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Scope[] f203404a = null;

        static {
            Scope r100 = new Scope("EMPTY_ARRAY", 0);
            EMPTY_ARRAY = r100;
            Scope r101 = new Scope("NONEMPTY_ARRAY", 1);
            NONEMPTY_ARRAY = r101;
            Scope r102 = new Scope("EMPTY_OBJECT", 2);
            EMPTY_OBJECT = r102;
            Scope r103 = new Scope("DANGLING_KEY", 3);
            DANGLING_KEY = r103;
            Scope r104 = new Scope("NONEMPTY_OBJECT", 4);
            NONEMPTY_OBJECT = r104;
            Scope r105 = new Scope("NULL", 5);
            NULL = r105;
            f203404a = new Scope[]{r100, r101, r102, r103, r104, r105};
        }

        public static Scope[] values() {
            return (Scope[]) f203404a.clone();
        }

        public static Scope valueOf(String r100) {
            return (Scope) r27.a.a(Scope.class, r100);
        }

        public Scope(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final String toString() {
        return "";
    }

    public final void b() throws JSONException, IOException {
        if (((ArrayList) this.f203403b).isEmpty() == false) goto L5;
        return;
    L5:
        Scope r100 = d();
        if (r100 != Scope.EMPTY_ARRAY) goto L9;
        Scope r101 = Scope.NONEMPTY_ARRAY;
        List<Scope> r102 = this.f203403b;
        ListProtector.set(r102, ((ArrayList) r102).size() - 1, r101);
        return;
    L9:
        if (r100 != Scope.NONEMPTY_ARRAY) goto L12;
        this.f203402a.write(44);
        return;
    L12:
        if (r100 != Scope.DANGLING_KEY) goto L15;
        this.f203402a.write(":");
        Scope r103 = Scope.NONEMPTY_OBJECT;
        List<Scope> r104 = this.f203403b;
        ListProtector.set(r104, ((ArrayList) r104).size() - 1, r103);
        return;
    L15:
        if (r100 != Scope.NULL) goto L18;
        return;
    L18:
        throw new JSONException("Nesting problem");
    }

    public final Scope d() {
        List<Scope> r100 = this.f203403b;
        return (Scope) ListProtector.get(r100, ((ArrayList) r100).size() - 1);
    }

    public JSONWriter(Writer r100) {
        this.f203403b = new ArrayList();
        this.f203402a = r100;
    }

    public final void a(JSONArray r100) throws JSONException, IOException {
        Scope r101 = Scope.EMPTY_ARRAY;
        b();
        ((ArrayList) this.f203403b).add(r101);
        this.f203402a.write("[");
        int r102 = 0;
    L4:
        if (r102 >= r100.length()) goto L6;
        f(r100.get(r102));
        r102 = r102 + 1;
        goto L4
    L6:
        Scope r103 = Scope.EMPTY_ARRAY;
        d();
        List<Scope> r104 = this.f203403b;
        ListProtector.remove(r104, ((ArrayList) r104).size() - 1);
        this.f203402a.write("]");
    }

    public final void c(JSONObject r100) throws JSONException, IOException {
        Scope r101 = Scope.EMPTY_OBJECT;
        b();
        ((ArrayList) this.f203403b).add(r101);
        this.f203402a.write("{");
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L13;
        String r103 = r102.next();
        Object r104 = r100.get(r103);
        Scope r105 = d();
        if (r105 != Scope.NONEMPTY_OBJECT) goto L9;
        this.f203402a.write(44);
    L10:
        Scope r106 = Scope.DANGLING_KEY;
        List<Scope> r107 = this.f203403b;
        ListProtector.set(r107, ((ArrayList) r107).size() - 1, r106);
        e(r103);
        f(r104);
        goto L4
    L9:
        if (r105 == Scope.EMPTY_OBJECT) goto L10;
        throw new JSONException("Nesting problem");
    L13:
        Scope r108 = Scope.EMPTY_ARRAY;
        d();
        List<Scope> r109 = this.f203403b;
        ListProtector.remove(r109, ((ArrayList) r109).size() - 1);
        this.f203402a.write(com.alipay.sdk.m.u.i.f25855d);
    }

    public final void e(String r100) throws IOException {
        this.f203402a.write("\"");
        int r101 = r100.length();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L25;
        char r103 = r100.charAt(r102);
        if (r103 != '\f') goto L7;
        this.f203402a.write("\\f");
    L24:
        r102 = r102 + 1;
        goto L3
    L7:
        if (r103 != '\r') goto L9;
        this.f203402a.write("\\r");
        goto L24
    L9:
        if (r103 != '\"') goto L11;
    L21:
        this.f203402a.write(92);
        this.f203402a.write(r103);
        goto L24
    L11:
        if (r103 == '/') goto L21;
        if (r103 == '\\') goto L21;
        switch(r103) {
            case 8: goto L20;
            case 9: goto L19;
            case 10: goto L18;
            default: goto L15;
        };
    L18:
        this.f203402a.write("\\n");
        goto L24
    L19:
        this.f203402a.write("\\t");
        goto L24
    L20:
        this.f203402a.write("\\b");
        goto L24
    L15:
        if (r103 > 31) goto L17;
        this.f203402a.write(String.format("\\u%04x", new Object[]{Integer.valueOf(r103)}));
        goto L24
    L17:
        this.f203402a.write(r103);
        goto L24
    L25:
        this.f203402a.write("\"");
    }

    public final void f(Object r100) throws JSONException, IOException {
        if ((r100 instanceof JSONArray) == false) goto L7;
        a((JSONArray) r100);
        return;
    L7:
        if ((r100 instanceof JSONObject) == false) goto L10;
        c((JSONObject) r100);
        return;
    L10:
        b();
        if (r100 != null) goto L13;
    L22:
        this.f203402a.write("null");
        return;
    L13:
        if (r100 == JSONObject.NULL) goto L22;
        if ((r100 instanceof Boolean) == false) goto L19;
        this.f203402a.write(String.valueOf(r100));
        return;
    L19:
        if ((r100 instanceof Number) == false) goto L21;
        this.f203402a.write(JSONObject.numberToString((Number) r100));
        return;
    L21:
        e(r100.toString());
    }
}
