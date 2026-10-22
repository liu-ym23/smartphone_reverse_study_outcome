package lr3;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f510397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, String> f510398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f510399c;

    public d(int r100, Map<String, String> r101, Object r102) {
        Intrinsics.checkNotNullParameter(r101, "header");
        this.f510397a = r100;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f510398b = r101;
        this.f510399c = r102;
    }
}
