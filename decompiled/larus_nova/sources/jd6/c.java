package jd6;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f498624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f498625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f498626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f498627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f498628e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.kmp.network.d f498629f;

    public c(String r100, String r101, Map<String, String> r102, d r103, f r104, com.bytedance.kmp.network.d r105) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r102, "headers");
        Intrinsics.checkNotNullParameter(r104, "reqContext");
        Intrinsics.checkNotNullParameter(r105, "kmpRequestMetrics");
        this.f498624a = r100;
        this.f498625b = r101;
        this.f498626c = r102;
        this.f498627d = r103;
        this.f498628e = r104;
        this.f498629f = r105;
    }
}
