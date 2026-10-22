package com.larus.voicecall.impl.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class RealtimeServerErrorDetail {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f379518f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f379519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Presentation f379520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f379521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f379522d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f379523e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/voicecall/impl/utils/RealtimeServerErrorDetail$Presentation;", "", "<init>", "(Ljava/lang/String;I)V", "TOAST", "ALERT", "SILENT", "HANGUP", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Presentation extends Enum<Presentation> {
        public static final Presentation ALERT = null;
        public static final Presentation HANGUP = null;
        public static final Presentation SILENT = null;
        public static final Presentation TOAST = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Presentation[] f379524a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f379525b = null;

        public static EnumEntries<Presentation> getEntries() {
            return f379525b;
        }

        static {
            Presentation r100 = new Presentation("TOAST", 0);
            TOAST = r100;
            Presentation r101 = new Presentation("ALERT", 1);
            ALERT = r101;
            Presentation r102 = new Presentation("SILENT", 2);
            SILENT = r102;
            Presentation r103 = new Presentation("HANGUP", 3);
            HANGUP = r103;
            Presentation[] r104 = {r100, r101, r102, r103};
            f379524a = r104;
            f379525b = EnumEntriesKt.enumEntries(r104);
        }

        public static Presentation[] values() {
            return (Presentation[]) f379524a.clone();
        }

        public static Presentation valueOf(String r100) {
            return (Presentation) r27.a.a(Presentation.class, r100);
        }

        public Presentation(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public a() {
        }

        public static RealtimeServerErrorDetail a(String r110) {
            boolean r100 = false;
            if (r110 != null) goto L5;
        L8:
            boolean r101 = true;
        L9:
            Object r102 = null;
            if (r101 == false) goto L116;
            return null;
        L116:
            Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L104
            JsonElement r111 = new JsonParser().parse(r110);     // Catch: Throwable -> L104
            if (r111.isJsonObject() == true) goto L15;
            return null;
        L15:
            JsonObject r112 = r111.getAsJsonObject();     // Catch: Throwable -> L104
            JsonElement r104 = r112.get("code");     // Catch: Throwable -> L104
            if (r104 != null) goto L18;
        L37:
            int r105 = 0;
        L38:
            JsonElement r106 = r112.get(EventConstant.Value.RETRY);     // Catch: Throwable -> L104
            if (r106 != null) goto L41;
        L51:
            Boolean r107 = null;
        L52:
            JsonElement r108 = r112.get("type");     // Catch: Throwable -> L104
            if (r108 != null) goto L55;
        L65:
            String r109 = null;
        L66:
            if (r109 != null) goto L114;
            r109 = "";
        L114:
            Object r113 = Result.m9449constructorimpl(Presentation.valueOf(r109.toUpperCase(Locale.ROOT)));     // Catch: Throwable -> L70
        L72:
            Presentation r114 = Presentation.SILENT;     // Catch: Throwable -> L104
            if (Result.m9455isFailureimpl(r113) == false) goto L75;
            r113 = r114;
        L75:
            Presentation r115 = (Presentation) r113;     // Catch: Throwable -> L104
            JsonElement r116 = r112.get("toastText");     // Catch: Throwable -> L104
            if (r116 != null) goto L78;
        L88:
            String r117 = null;
        L89:
            JsonElement r118 = r112.get("sceneHint");     // Catch: Throwable -> L104
            if (r118 != null) goto L92;
        L101:
            String r119 = null;
        L102:
            Object r120 = Result.m9449constructorimpl(new RealtimeServerErrorDetail(r105, r115, r117, r107, r119));     // Catch: Throwable -> L104
        L107:
            if (Result.m9455isFailureimpl(r120) == true) goto L111;
            r102 = r120;
        L111:
            return (RealtimeServerErrorDetail) r102;
        L92:
            if (r118.isJsonPrimitive() == true) goto L94;
        L96:
            if (r100 == true) goto L99;
            r118 = null;
        L99:
            if (r118 == null) goto L101;
            r119 = r118.getAsString();     // Catch: Throwable -> L104
            goto L102
        L94:
            if (r118.getAsJsonPrimitive().isString() == false) goto L96;
            r100 = true;
            goto L96
        L78:
            if (r116.isJsonPrimitive() == true) goto L80;
        L82:
            boolean r121 = false;
        L83:
            if (r121 == true) goto L86;
            r116 = null;
        L86:
            if (r116 == null) goto L88;
            r117 = r116.getAsString();     // Catch: Throwable -> L104
            goto L89
        L80:
            if (r116.getAsJsonPrimitive().isString() == false) goto L82;
            r121 = true;
            goto L83
        L70:
            th = move-exception;
            Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L104
            r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L104
            goto L72
        L55:
            if (r108.isJsonPrimitive() == true) goto L57;
        L59:
            boolean r123 = false;
        L60:
            if (r123 == true) goto L63;
            r108 = null;
        L63:
            if (r108 == null) goto L65;
            r109 = r108.getAsString();     // Catch: Throwable -> L104
            goto L66
        L57:
            if (r108.getAsJsonPrimitive().isString() == false) goto L59;
            r123 = true;
            goto L60
        L41:
            if (r106.isJsonPrimitive() == true) goto L43;
        L45:
            boolean r124 = false;
        L46:
            if (r124 == true) goto L49;
            r106 = null;
        L49:
            if (r106 == null) goto L51;
            r107 = Boolean.valueOf(r106.getAsBoolean());     // Catch: Throwable -> L104
            goto L52
        L43:
            if (r106.getAsJsonPrimitive().isBoolean() == false) goto L45;
            r124 = true;
            goto L46
        L18:
            if (r104.isJsonPrimitive() == true) goto L20;
        L22:
            boolean r125 = false;
        L23:
            if (r125 == true) goto L26;
            r104 = null;
        L26:
            if (r104 == null) goto L37;
            Object r126 = Result.m9449constructorimpl(Integer.valueOf(r104.getAsInt()));     // Catch: Throwable -> L29
        L32:
            if (Result.m9455isFailureimpl(r126) == false) goto L34;
            r126 = null;
        L34:
            Integer r127 = (Integer) r126;     // Catch: Throwable -> L104
            if (r127 == null) goto L37;
            r105 = r127.intValue();     // Catch: Throwable -> L104
        L29:
            th = move-exception;
            Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L104
            r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L104
            goto L32
        L20:
            if (r104.getAsJsonPrimitive().isNumber() == false) goto L22;
            r125 = true;
        L104:
            th = move-exception;
            Result.Companion r129 = Result.Companion;
            r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L107
        L5:
            if (StringsKt.isBlank(r110) == true) goto L8;
            r101 = false;
            goto L9
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RealtimeServerErrorDetail) == true) goto L8;
        return false;
    L8:
        RealtimeServerErrorDetail r101 = (RealtimeServerErrorDetail) r100;
        if (this.f379519a == r101.f379519a) goto L12;
        return false;
    L12:
        if (this.f379520b == r101.f379520b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f379521c, r101.f379521c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f379522d, r101.f379522d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f379523e, r101.f379523e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f379519a * 31) + this.f379520b.hashCode()) * 31;
        String r101 = this.f379521c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Boolean r105 = this.f379522d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f379523e;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "RealtimeServerErrorDetail(code=" + this.f379519a + ", presentation=" + this.f379520b + ", displayText=" + this.f379521c + ", retry=" + this.f379522d + ", sceneHint=" + this.f379523e + ')';
    }

    static {
        f379518f = new a();
    }

    public RealtimeServerErrorDetail(int r100, Presentation r101, String r102, Boolean r103, String r104) {
        Intrinsics.checkNotNullParameter(r101, "presentation");
        this.f379519a = r100;
        this.f379520b = r101;
        this.f379521c = r102;
        this.f379522d = r103;
        this.f379523e = r104;
    }
}
