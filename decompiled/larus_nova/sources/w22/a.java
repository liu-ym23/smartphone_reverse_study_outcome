package w22;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f557987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f557988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f557989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f557990d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f557991e;

    public a(String r100, String r101, String r102, String r103, Map r104, int r105) {
        if ((r105 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r105 & 8) == 0) goto L9;
        r103 = null;
    L9:
        if ((r105 & 16) == 0) goto L11;
        r104 = null;
    L11:
        Intrinsics.checkNotNullParameter(r100, "itemId");
        Intrinsics.checkNotNullParameter(r101, "itemType");
        this.f557987a = r100;
        this.f557988b = r101;
        this.f557989c = r102;
        this.f557990d = r103;
        this.f557991e = r104;
    }
}
