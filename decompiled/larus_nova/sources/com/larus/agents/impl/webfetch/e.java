package com.larus.agents.impl.webfetch;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedInput;
import java.io.InputStream;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
public final class e implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SsResponse<TypedInput> f286850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InputStream f286851b;

    @Override // com.larus.agents.impl.webfetch.v
    public final InputStream C4() {
        TypedInput r100 = this.f286850a.body();
        if (r100 != null) goto L5;
        r100 = this.f286850a.errorBody();
    L5:
        if (r100 == null) goto L9;
        InputStream r101 = r100.in();
        if (r101 == null) goto L9;
        this.f286851b = r101;
        return r101;
    L9:
        return null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        InputStream r100 = this.f286851b;
        if (r100 == null) goto L6;
        r100.close();
        return;
    }

    @Override // com.larus.agents.impl.webfetch.v
    public final int getStatus() {
        return this.f286850a.code();
    }

    public e(SsResponse<TypedInput> r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        this.f286850a = r100;
    }

    @Override // com.larus.agents.impl.webfetch.v
    public final String header(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Iterator<T> r101 = this.f286850a.headers().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (StringsKt.equals(((Header) r102).getName(), r100, true) == false) goto L4;
    L9:
        Header r103 = (Header) r102;
        if (r103 != null) goto L12;
        return null;
    L12:
        return r103.getValue();
    L8:
        r102 = null;
        goto L9
    }
}
