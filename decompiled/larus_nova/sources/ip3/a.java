package ip3;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f495267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f495268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f495269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f495270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f495271e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f495272f;

    public a(int r100, String r101, Map<String, String> r102, String r103, String r104, int r105) {
        Intrinsics.checkNotNullParameter(r101, "uniqueId");
        Intrinsics.checkNotNullParameter(r102, "dynamicInsertData");
        Intrinsics.checkNotNullParameter(r103, "surroundedProductIds");
        Intrinsics.checkNotNullParameter(r104, "categoryId");
        this.f495267a = r100;
        this.f495268b = r101;
        this.f495269c = r102;
        this.f495270d = r103;
        this.f495271e = r104;
        this.f495272f = r105;
    }
}
