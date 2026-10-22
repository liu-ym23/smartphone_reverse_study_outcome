package io.ktor.client.request.forms;

import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes41.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f491785a = 0;

    static {
        Charset r100 = Charsets.UTF_8;
        if (Intrinsics.areEqual(r100, r100) == false) goto L5;
        StringsKt.encodeToByteArray("\r\n");
        return;
    L5:
        ksc.a.c(r100.newEncoder(), "\r\n", 2);
    }
}
