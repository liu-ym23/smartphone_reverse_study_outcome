package nt7;

import com.alipay.sdk.m.p.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f520517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f520518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Pair<String, String>> f520519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f520520d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f520521e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f520522f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f520523g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f520524h;

    public a() {
        this("", "", new ArrayList(), null, -1, 15000, 15000, 15000);
    }

    public a(String r100, String r101, List<Pair<String, String>> r102, b r103, int r104, int r105, int r106, int r107) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, e.f25671s);
        Intrinsics.checkNotNullParameter(r102, "headers");
        this.f520517a = r100;
        this.f520518b = r101;
        this.f520519c = r102;
        this.f520520d = r103;
        this.f520521e = r104;
        this.f520522f = r105;
        this.f520523g = r106;
        this.f520524h = r107;
    }
}
