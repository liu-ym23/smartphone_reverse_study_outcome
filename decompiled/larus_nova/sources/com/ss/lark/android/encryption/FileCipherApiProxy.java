package com.ss.lark.android.encryption;

import android.content.Context;
import android.net.Uri;
import android.util.Pair;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import jkc.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class FileCipherApiProxy implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FileCipherApiProxy f456789a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f456790b = null;

    public FileCipherApiProxy() {
    }

    static {
        f456789a = new FileCipherApiProxy();
        f456790b = LazyKt.lazy(FileCipherApiProxy$manager$2.INSTANCE);
    }

    public static c a() {
        return (c) f456790b.getValue();
    }

    @Override // jkc.c
    public final int o1() {
        return a().o1();
    }

    @Override // jkc.c
    public final InputStream D5(File r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "file");
        return a().D5(r100);
    }

    @Override // jkc.c
    public final Pair<Integer, String> Ec(String r100) {
        Intrinsics.checkNotNullParameter(r100, "decryptedPath");
        return a().Ec(r100);
    }

    @Override // jkc.c
    public final int Q9(File r100) {
        Intrinsics.checkNotNullParameter(r100, "file");
        return a().Q9(r100);
    }

    @Override // jkc.c
    public final Pair<Integer, String> m3(File r100) {
        Intrinsics.checkNotNullParameter(r100, "file");
        return a().m3(r100);
    }

    @Override // jkc.c
    public final Pair<Integer, String> Gd(Context r100, Uri r101) {
        Intrinsics.checkNotNullParameter(r101, "uri");
        return a().Gd(r100, r101);
    }

    @Override // jkc.c
    public final OutputStream p3(File r100, boolean r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "file");
        return a().p3(r100, r101);
    }

    @Override // jkc.c
    public final void f5(String r100, long r101, String r102) {
        a().f5(r100, r101, r102);
    }
}
