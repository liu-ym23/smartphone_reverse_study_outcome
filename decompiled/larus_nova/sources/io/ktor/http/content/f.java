package io.ktor.http.content;

import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes41.dex */
public final class f extends c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f491839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final io.ktor.http.b f491840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f491841c;

    @Override // io.ktor.http.content.c
    public final Long a() {
        return Long.valueOf(this.f491841c.length);
    }

    public final String toString() {
        return "TextContent[" + this.f491840b + "] \"" + StringsKt.take(this.f491839a, 30) + Typography.quote;
    }

    @Override // io.ktor.http.content.c
    public final io.ktor.http.b b() {
        return this.f491840b;
    }

    @Override // io.ktor.http.content.c.a
    public final byte[] d() {
        return this.f491841c;
    }

    public f(String r100, io.ktor.http.b r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "contentType");
        this.f491839a = r100;
        this.f491840b = r101;
        Charset r102 = io.ktor.http.c.a(r101);
        if (r102 != null) goto L6;
        r102 = Charsets.UTF_8;
    L6:
        if (Intrinsics.areEqual(r102, Charsets.UTF_8) == false) goto L8;
        byte[] r103 = StringsKt.encodeToByteArray(r100);
    L9:
        this.f491841c = r103;
        return;
    L8:
        r103 = ksc.a.c(r102.newEncoder(), r100, r100.length());
        goto L9
    }
}
