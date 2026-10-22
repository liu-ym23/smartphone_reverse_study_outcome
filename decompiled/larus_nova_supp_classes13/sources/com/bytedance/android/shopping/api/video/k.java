package com.bytedance.android.shopping.api.video;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k {
    public String a;
    public String b;
    public CodecType c;
    public ArrayList<String> d;
    public long e;
    public long f;
    public final String g;

    public final b b() {
        String r0 = this.a;
        if (r0 == null) goto L22;
        String r1 = this.b;
        if (r1 == null) goto L22;
        List r2 = this.d;
        if (r2 == null) goto L22;
        if (r0 != null) goto L12;
        String r4 = "";
    L13:
        if (r1 != null) goto L15;
        String r5 = "";
    L16:
        CodecType r7 = this.c;
        if (r2 != null) goto L21;
        r2 = CollectionsKt.emptyList();
    L21:
        return new b(r4, r5, 0, r7, r2, this.e, (int) this.f, this.g, 0);
    L15:
        r5 = r1;
        goto L16
    L12:
        r4 = r0;
    L22:
        Objects.toString(this.d);
        return null;
    }

    public k() {
        this.c = CodecType.CODEC_TYPE_264;
        this.g = "";
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "url");
        if (this.d != null) goto L6;
        this.d = new ArrayList();
    L6:
        if (r2.length() <= 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L14;
        ArrayList<String> r1 = this.d;
        if (r1 == null) goto L15;
        r1.add(r2);
        return;
    L15:
        return;
    L14:
        return;
    L8:
        r0 = false;
        goto L9
    }
}
