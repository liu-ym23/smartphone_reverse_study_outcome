package nt7;

import com.alipay.sdk.m.p.e;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f520528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f520529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Pair<String, String>> f520530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f520531d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f520532e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f520533f;

    public c(String r100, String r101, List r102, byte[] r103, int r104, int r105, int r106, int r107) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, e.f25671s);
        Intrinsics.checkNotNullParameter(r102, "headers");
        Intrinsics.checkNotNullParameter("BYTEARRAY", "bodyType");
        Intrinsics.checkNotNullParameter("", "strBody");
        Intrinsics.checkNotNullParameter(r103, "bytesBody");
        this.f520528a = r100;
        this.f520529b = r101;
        this.f520530c = r102;
        this.f520531d = "BYTEARRAY";
        this.f520532e = "";
        this.f520533f = r103;
    }
}
