package io.ktor.http;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes41.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final gsc.b f491929a = null;

    static {
        io.ktor.http.parsing.k r100 = new io.ktor.http.parsing.k();
        Intrinsics.checkNotNullParameter(r100, "grammar");
        io.ktor.http.parsing.l r101 = io.ktor.http.parsing.i.c(new io.ktor.http.parsing.b(r100), ".");
        io.ktor.http.parsing.k r102 = new io.ktor.http.parsing.k();
        Intrinsics.checkNotNullParameter(r102, "grammar");
        io.ktor.http.parsing.l r103 = io.ktor.http.parsing.i.c(io.ktor.http.parsing.i.b(r101, new io.ktor.http.parsing.b(r102)), ".");
        io.ktor.http.parsing.k r104 = new io.ktor.http.parsing.k();
        Intrinsics.checkNotNullParameter(r104, "grammar");
        io.ktor.http.parsing.l r105 = io.ktor.http.parsing.i.c(io.ktor.http.parsing.i.b(r103, new io.ktor.http.parsing.b(r104)), ".");
        io.ktor.http.parsing.k r106 = new io.ktor.http.parsing.k();
        Intrinsics.checkNotNullParameter(r106, "grammar");
        io.ktor.http.parsing.l r107 = io.ktor.http.parsing.i.b(r105, new io.ktor.http.parsing.b(r106));
        io.ktor.http.parsing.h r108 = io.ktor.http.parsing.i.a(io.ktor.http.parsing.i.a(new io.ktor.http.parsing.k(), new io.ktor.http.parsing.j('A', 'F')), new io.ktor.http.parsing.j('a', 'f'));
        Intrinsics.checkNotNullParameter(r108, "<this>");
        Intrinsics.checkNotNullParameter(":", "value");
        io.ktor.http.parsing.h r109 = io.ktor.http.parsing.i.a(r108, new io.ktor.http.parsing.n(":"));
        Intrinsics.checkNotNullParameter(r109, "grammar");
        io.ktor.http.parsing.b r110 = new io.ktor.http.parsing.b(r109);
        Intrinsics.checkNotNullParameter("[", "<this>");
        Intrinsics.checkNotNullParameter(r110, "grammar");
        io.ktor.http.parsing.h r111 = io.ktor.http.parsing.i.a(r107, io.ktor.http.parsing.i.c(io.ktor.http.parsing.i.b(new io.ktor.http.parsing.n("["), r110), "]"));
        Intrinsics.checkNotNullParameter(r111, "<this>");
        LinkedHashMap r112 = new LinkedHashMap();
        f491929a = new gsc.b(new Regex(gsc.c.b(r111, r112, 0, 6).f482483a), r112);
    }
}
