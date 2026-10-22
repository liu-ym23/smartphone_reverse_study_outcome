package dv0;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f470128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<d> f470129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f470130c;

    public l(String r100, long r101, List r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "miniAppId");
        Intrinsics.checkNotNullParameter(r102, "players");
        this.f470128a = r101;
        this.f470129b = r102;
        this.f470130c = r103;
    }
}
