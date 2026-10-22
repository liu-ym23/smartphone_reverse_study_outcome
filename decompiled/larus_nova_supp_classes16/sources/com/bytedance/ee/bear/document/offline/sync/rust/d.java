package com.bytedance.ee.bear.document.offline.sync.rust;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d {
    public static final d a = null;

    public static final class a {
        public final String a;
        public final List<String> b;
        public final String c;
        public final String d;
        public final Integer e;
        public final Integer f;
        public final Integer g;

        public a() {
            this(0);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = ((r2 * 31) + this.b.hashCode()) * 31;
            String r4 = this.c;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.d;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            Integer r10 = this.e;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            Integer r13 = this.f;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r16 = (r12 + r14) * 31;
            Integer r17 = this.g;
            if (r17 == null) goto L27;
            r1 = r17.hashCode();
        L27:
            return r16 + r1;
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "PreloadParams(eventType=" + this.a + ", fetchTypes=" + this.b + ", docToken=" + this.c + ", sheetId=" + this.d + ", openType=" + this.e + ", resourceLimit=" + this.f + ", embedDocLimit=" + this.g + ')';
        }

        public /* synthetic */ a(int r9) {
            this(null, CollectionsKt.emptyList(), null, null, null, null, null);
        }

        public a(String r2, List<String> r3, String r4, String r5, Integer r6, Integer r7, Integer r8) {
            Intrinsics.checkNotNullParameter(r3, "fetchTypes");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
        }
    }

    static {
        a = new d();
    }

    public d() {
    }

    public static JsonObject a(JsonElement r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        if (r2.isJsonObject() == true) goto L8;
        r2 = null;
    L8:
        if (r2 != null) goto L10;
        return null;
    L10:
        return r2.getAsJsonObject();
    }

    public static String b(JsonElement r2) {
        Object r0 = null;
        if (r2 != null) goto L5;
        return null;
    L5:
        if (r2.isJsonPrimitive() == true) goto L8;
        r2 = null;
    L8:
        if (r2 == null) goto L22;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        Object r3 = Result.constructor-impl(r2.getAsString());     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r3) == true) goto L18;
        r0 = r3;
    L18:
        return (String) r0;
    L11:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L22:
        return null;
    }

    public static List e(JsonObject r8) {
        JsonElement r9 = r8.get("fetchType");
        if (r9 != null) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (r9.isJsonArray() == false) goto L10;
        JsonArray r10 = r9.getAsJsonArray();
    L29:
        ArrayList r0 = new ArrayList();
        int r4 = r10.size();
        int r5 = 0;
    L30:
        if (r5 >= r4) goto L44;
        String r6 = b(r10.get(r5));
        if (r6 != null) goto L34;
        r6 = "";
    L34:
        String r7 = StringsKt.trim(r6).toString();
        if (r7.length() <= 0) goto L37;
        boolean r11 = true;
    L38:
        if (r11 == true) goto L41;
        r7 = null;
    L41:
        if (r7 == null) goto L43;
        r0.add(r7);
    L43:
        r5 = r5 + 1;
        goto L30
    L37:
        r11 = false;
        goto L38
    L44:
        return r0;
    L10:
        if (r9.isJsonPrimitive() == false) goto L46;
        String r12 = b(r9);
        if (r12 != null) goto L14;
        r12 = "";
    L14:
        String r13 = StringsKt.trim(r12).toString();
        if (StringsKt.startsWith$default(r13, "[", false, 2, null) == false) goto L28;
        JsonElement r14 = JsonParser.parseString(r13);
        if (r14 != null) goto L19;
    L24:
        r10 = null;
    L25:
        if (r10 != null) goto L29;
        return CollectionsKt.emptyList();
    L19:
        if (r14.isJsonArray() == true) goto L22;
        r14 = null;
    L22:
        if (r14 == null) goto L24;
        r10 = r14.getAsJsonArray();
        goto L25
    L28:
        JsonArray r1 = new JsonArray();
        r1.add(r13);
        r10 = r1;
        goto L29
    L46:
        return CollectionsKt.emptyList();
    }

    public static Integer c(JsonObject r1, String r2) {
        JsonElement r3 = r1.get(r2);
        Object r4 = null;
        if (r3 != null) goto L5;
        return null;
    L5:
        if (r3.isJsonPrimitive() == true) goto L8;
        r3 = null;
    L8:
        if (r3 == null) goto L22;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        Object r5 = Result.constructor-impl(Integer.valueOf(r3.getAsInt()));     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r5) == true) goto L18;
        r4 = r5;
    L18:
        return (Integer) r4;
    L11:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L22:
        return null;
    }

    public static String d(JsonObject r0, String r1) {
        String r2 = b(r0.get(r1));
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        String r3 = StringsKt.trim(r2).toString();
        if (r3.length() <= 0) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == true) goto L13;
        return null;
    L13:
        return r3;
    L8:
        r4 = false;
        goto L9
    }

    public static String f(boolean r3, String r4, String r5, boolean r6, Function0 r7) {
        if (r3 == false) goto L5;
        String r8 = (String) r7.invoke();
    L6:
        boolean r1 = false;
        if (r3 == false) goto L41;
        if (r8 != null) goto L10;
    L31:
        String r9 = null;
    L32:
        if (r9 != null) goto L67;
        if (r4 == null) goto L62;
        r9 = StringsKt.trim(r4).toString();
        if (r9 != null) goto L37;
        return null;
    L37:
        if (r9.length() <= 0) goto L39;
        r1 = true;
    L39:
        if (r1 == true) goto L67;
        return null;
    L62:
        return null;
    L67:
        return r9;
    L10:
        if ((!StringsKt.isBlank(r8)) == true) goto L13;
        r8 = null;
    L13:
        if (r8 == null) goto L31;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L25
        JsonObject r11 = a(JsonParser.parseString(r8));     // Catch: Throwable -> L25
        if (r11 == null) goto L18;
        JsonElement r12 = r11.get("doubao");     // Catch: Throwable -> L25
    L19:
        JsonObject r13 = a(r12);     // Catch: Throwable -> L25
        if (r13 == null) goto L22;
        String r14 = d(r13, "internal_api");     // Catch: Throwable -> L25
    L23:
        Object r16 = Result.constructor-impl(r14);     // Catch: Throwable -> L25
    L28:
        if (Result.isFailure-impl(r16) == false) goto L30;
        r16 = null;
    L30:
        r9 = (String) r16;
        goto L32
    L22:
        r14 = null;
        goto L23
    L18:
        r12 = null;
    L25:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    L41:
        if (r6 == false) goto L54;
        if (r5 == null) goto L54;
        r9 = StringsKt.trim(r5).toString();
        if (r9 == null) goto L54;
        if (r9.length() <= 0) goto L48;
        boolean r18 = true;
    L49:
        if (r18 == true) goto L52;
        r9 = null;
    L52:
        if (r9 == null) goto L54;
    L48:
        r18 = false;
    L54:
        if (r4 == null) goto L68;
        r9 = StringsKt.trim(r4).toString();
        if (r9 != null) goto L58;
        return null;
    L58:
        if (r9.length() <= 0) goto L60;
        r1 = true;
    L60:
        if (r1 == true) goto L67;
        return null;
    L68:
        return null;
    L5:
        r8 = null;
        goto L6
    }
}
