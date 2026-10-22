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

/* JADX INFO: loaded from: classes16.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f220682a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f220683a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<String> f220684b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f220685c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f220686d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Integer f220687e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Integer f220688f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Integer f220689g;

        public a() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f220683a, r101.f220683a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f220684b, r101.f220684b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f220685c, r101.f220685c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f220686d, r101.f220686d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f220687e, r101.f220687e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f220688f, r101.f220688f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f220689g, r101.f220689g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f220683a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = ((r102 * 31) + this.f220684b.hashCode()) * 31;
            String r104 = this.f220685c;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f220686d;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            Integer r110 = this.f220687e;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            Integer r113 = this.f220688f;
            if (r113 != null) goto L21;
            int r114 = 0;
        L22:
            int r115 = (r112 + r114) * 31;
            Integer r116 = this.f220689g;
            if (r116 == null) goto L27;
            r101 = r116.hashCode();
        L27:
            return r115 + r101;
        L21:
            r114 = r113.hashCode();
            goto L22
        L17:
            r111 = r110.hashCode();
            goto L18
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "PreloadParams(eventType=" + this.f220683a + ", fetchTypes=" + this.f220684b + ", docToken=" + this.f220685c + ", sheetId=" + this.f220686d + ", openType=" + this.f220687e + ", resourceLimit=" + this.f220688f + ", embedDocLimit=" + this.f220689g + ')';
        }

        public /* synthetic */ a(int r100) {
            this(null, CollectionsKt.emptyList(), null, null, null, null, null);
        }

        public a(String r100, List<String> r101, String r102, String r103, Integer r104, Integer r105, Integer r106) {
            Intrinsics.checkNotNullParameter(r101, "fetchTypes");
            this.f220683a = r100;
            this.f220684b = r101;
            this.f220685c = r102;
            this.f220686d = r103;
            this.f220687e = r104;
            this.f220688f = r105;
            this.f220689g = r106;
        }
    }

    static {
        f220682a = new d();
    }

    public d() {
    }

    public static JsonObject a(JsonElement r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.isJsonObject() == true) goto L8;
        r100 = null;
    L8:
        if (r100 != null) goto L10;
        return null;
    L10:
        return r100.getAsJsonObject();
    }

    public static String b(JsonElement r100) {
        Object r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.isJsonPrimitive() == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L22;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        Object r103 = Result.m9449constructorimpl(r100.getAsString());     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r103) == true) goto L18;
        r101 = r103;
    L18:
        return (String) r101;
    L11:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L22:
        return null;
    }

    public static List e(JsonObject r100) {
        JsonElement r101 = r100.get("fetchType");
        if (r101 != null) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (r101.isJsonArray() == false) goto L10;
        JsonArray r102 = r101.getAsJsonArray();
    L29:
        ArrayList r103 = new ArrayList();
        int r104 = r102.size();
        int r105 = 0;
    L30:
        if (r105 >= r104) goto L44;
        String r106 = b(r102.get(r105));
        if (r106 != null) goto L34;
        r106 = "";
    L34:
        String r107 = StringsKt.trim(r106).toString();
        if (r107.length() <= 0) goto L37;
        boolean r108 = true;
    L38:
        if (r108 == true) goto L41;
        r107 = null;
    L41:
        if (r107 == null) goto L43;
        r103.add(r107);
    L43:
        r105 = r105 + 1;
        goto L30
    L37:
        r108 = false;
        goto L38
    L44:
        return r103;
    L10:
        if (r101.isJsonPrimitive() == false) goto L46;
        String r109 = b(r101);
        if (r109 != null) goto L14;
        r109 = "";
    L14:
        String r110 = StringsKt.trim(r109).toString();
        if (StringsKt.startsWith$default(r110, "[", false, 2, null) == false) goto L28;
        JsonElement r111 = JsonParser.parseString(r110);
        if (r111 != null) goto L19;
    L24:
        r102 = null;
    L25:
        if (r102 != null) goto L29;
        return CollectionsKt.emptyList();
    L19:
        if (r111.isJsonArray() == true) goto L22;
        r111 = null;
    L22:
        if (r111 == null) goto L24;
        r102 = r111.getAsJsonArray();
        goto L25
    L28:
        JsonArray r112 = new JsonArray();
        r112.add(r110);
        r102 = r112;
        goto L29
    L46:
        return CollectionsKt.emptyList();
    }

    public static Integer c(JsonObject r100, String r101) {
        JsonElement r102 = r100.get(r101);
        Object r103 = null;
        if (r102 != null) goto L5;
        return null;
    L5:
        if (r102.isJsonPrimitive() == true) goto L8;
        r102 = null;
    L8:
        if (r102 == null) goto L22;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L11
        Object r105 = Result.m9449constructorimpl(Integer.valueOf(r102.getAsInt()));     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r105) == true) goto L18;
        r103 = r105;
    L18:
        return (Integer) r103;
    L11:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L22:
        return null;
    }

    public static String d(JsonObject r100, String r101) {
        String r102 = b(r100.get(r101));
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        String r103 = StringsKt.trim(r102).toString();
        if (r103.length() <= 0) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == true) goto L13;
        return null;
    L13:
        return r103;
    L8:
        r104 = false;
        goto L9
    }

    public static String f(boolean r100, String r101, String r102, boolean r103, Function0 r104) {
        if (r100 == false) goto L5;
        String r105 = (String) r104.invoke();
    L6:
        boolean r106 = false;
        if (r100 == false) goto L41;
        if (r105 != null) goto L10;
    L31:
        String r107 = null;
    L32:
        if (r107 != null) goto L67;
        if (r101 == null) goto L62;
        r107 = StringsKt.trim(r101).toString();
        if (r107 != null) goto L37;
        return null;
    L37:
        if (r107.length() <= 0) goto L39;
        r106 = true;
    L39:
        if (r106 == true) goto L67;
        return null;
    L62:
        return null;
    L67:
        return r107;
    L10:
        if ((!StringsKt.isBlank(r105)) == true) goto L13;
        r105 = null;
    L13:
        if (r105 == null) goto L31;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L25
        JsonObject r109 = a(JsonParser.parseString(r105));     // Catch: Throwable -> L25
        if (r109 == null) goto L18;
        JsonElement r110 = r109.get("doubao");     // Catch: Throwable -> L25
    L19:
        JsonObject r111 = a(r110);     // Catch: Throwable -> L25
        if (r111 == null) goto L22;
        String r112 = d(r111, "internal_api");     // Catch: Throwable -> L25
    L23:
        Object r113 = Result.m9449constructorimpl(r112);     // Catch: Throwable -> L25
    L28:
        if (Result.m9455isFailureimpl(r113) == false) goto L30;
        r113 = null;
    L30:
        r107 = (String) r113;
        goto L32
    L22:
        r112 = null;
        goto L23
    L18:
        r110 = null;
    L25:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L28
    L41:
        if (r103 == false) goto L54;
        if (r102 == null) goto L54;
        r107 = StringsKt.trim(r102).toString();
        if (r107 == null) goto L54;
        if (r107.length() <= 0) goto L48;
        boolean r115 = true;
    L49:
        if (r115 == true) goto L52;
        r107 = null;
    L52:
        if (r107 == null) goto L54;
    L48:
        r115 = false;
    L54:
        if (r101 == null) goto L68;
        r107 = StringsKt.trim(r101).toString();
        if (r107 != null) goto L58;
        return null;
    L58:
        if (r107.length() <= 0) goto L60;
        r106 = true;
    L60:
        if (r106 == true) goto L67;
        return null;
    L68:
        return null;
    L5:
        r105 = null;
        goto L6
    }
}
