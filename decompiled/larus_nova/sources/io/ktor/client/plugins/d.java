package io.ktor.client.plugins;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.utils.io.ByteReadChannel;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public final class d extends io.ktor.http.content.c.AbstractC6311c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f491712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final io.ktor.http.b f491713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f491714c;

    @Override // io.ktor.http.content.c.AbstractC6311c
    public final ByteReadChannel d() {
        return io.ktor.utils.io.jvm.javaio.e.a((InputStream) this.f491714c);
    }

    @Override // io.ktor.http.content.c
    public final Long a() {
        return this.f491712a;
    }

    @Override // io.ktor.http.content.c
    public final io.ktor.http.b b() {
        return this.f491713b;
    }

    public d(HttpRequestBuilder r100, io.ktor.http.b r101, Object r102) {
        this.f491714c = r102;
        io.ktor.http.o r103 = r100.f491760c;
        List<String> r104 = io.ktor.http.r.f491904a;
        String r105 = r103.i("Content-Length");
        if (r105 == null) goto L5;
        Long r106 = Long.valueOf(CastLongProtector.parseLong(r105));
    L6:
        this.f491712a = r106;
        if (r101 != null) goto L9;
        io.ktor.http.b r107 = io.ktor.http.b.a.f491835a;
        r101 = io.ktor.http.b.a.f491835a;
    L9:
        this.f491713b = r101;
        return;
    L5:
        r106 = null;
        goto L6
    }
}
