package com.ss.android.lark.movable.utils;

import android.graphics.fonts.Font;
import com.google.gson.Gson;
import com.ss.android.lark.storage.LarkKVStorage;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f432815a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f432816b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, a> f432817c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, Font> f432818d = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f432819a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f432820b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f432819a, r101.f432819a) == true) goto L12;
            return false;
        L12:
            if (this.f432820b == r101.f432820b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f432819a.hashCode() * 31) + this.f432820b;
        }

        public final String toString() {
            return "ResolvedFontInfo(path=" + this.f432819a + ", ttcIndex=" + this.f432820b + ')';
        }

        public a(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "path");
            this.f432819a = r100;
            this.f432820b = r101;
        }
    }

    public c() {
    }

    static {
        f432815a = new c();
        f432816b = "FontPathRecorder";
        LinkedHashMap r100 = new LinkedHashMap();
        f432817c = r100;
        f432818d = new LinkedHashMap();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L13
        boolean r102 = true;
        String r103 = LarkKVStorage.p(new com.ss.android.lark.storage.a("movable"), "movable::font_path", true).getString("movable::font_map", "");     // Catch: Throwable -> L13
        if (r103 != null) goto L6;
    L9:
        if (r102 == true) goto L11;
        Type r104 = new d().getType();     // Catch: Throwable -> L13
        r100.putAll((Map) new Gson().fromJson(r103, r104));     // Catch: Throwable -> L13
    L11:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
        return;
    L6:
        if (r103.length() == 0) goto L9;
        r102 = false;
    L13:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
