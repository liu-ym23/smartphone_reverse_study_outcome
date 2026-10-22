package io.ktor.http;

import io.ktor.util.StringValuesBuilderImpl;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes41.dex */
public final class o extends StringValuesBuilderImpl {
    public o() {
        this(0);
    }

    public final p l() {
        return new p(this.f491945b);
    }

    public o(int r100) {
        super(8);
    }

    @Override // io.ktor.util.StringValuesBuilderImpl
    public final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r100, "name");
        List<String> r101 = r.f491904a;
        Intrinsics.checkNotNullParameter(r100, "name");
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r102 >= r100.length()) goto L12;
        char r104 = r100.charAt(r102);
        int r105 = r103 + 1;
        if (Intrinsics.compare(r104, 32) <= 0) goto L11;
        if (StringsKt.contains$default("\"(),/:;<=>?@[\\]{}", r104, false, 2, null) == true) goto L11;
        r102 = r102 + 1;
        r103 = r105;
    L11:
        throw new IllegalHeaderNameException(r100, r103);
    }

    @Override // io.ktor.util.StringValuesBuilderImpl
    public final void k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Intrinsics.checkNotNullParameter(r100, "value");
        List<String> r101 = r.f491904a;
        Intrinsics.checkNotNullParameter(r100, "value");
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r102 >= r100.length()) goto L13;
        char r104 = r100.charAt(r102);
        int r105 = r103 + 1;
        if (Intrinsics.compare(r104, 32) >= 0) goto L12;
        if (r104 == '\t') goto L12;
        throw new IllegalHeaderValueException(r100, r103);
    L12:
        r102 = r102 + 1;
        r103 = r105;
        goto L4
    }
}
