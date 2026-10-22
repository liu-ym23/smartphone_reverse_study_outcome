package lr3;

import com.alipay.sdk.m.p.e;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f510391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f510392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f510393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f510394d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f510395e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f510396f;

    public c(String r100, String r101, Map r102, Object r103, int r104) {
        if ((r104 & 16) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 32) == 0) goto L8;
        r103 = null;
    L8:
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, e.f25671s);
        this.f510391a = r100;
        this.f510392b = r101;
        this.f510393c = null;
        this.f510394d = null;
        this.f510395e = r102;
        this.f510396f = r103;
    }
}
