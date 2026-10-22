package uq0;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f551170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f551171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, String> f551172c;

    public a(String r100, String r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "path");
        Intrinsics.checkNotNullParameter(r102, "query");
        this.f551170a = r100;
        this.f551171b = r101;
        this.f551172c = r102;
    }
}
