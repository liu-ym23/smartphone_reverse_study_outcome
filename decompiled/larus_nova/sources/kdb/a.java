package kdb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f502991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final odb.a f502992b;

    public a() {
        odb.a r100 = new odb.a();
        Intrinsics.checkNotNullParameter(r100, "metrics");
        this.f502991a = false;
        this.f502992b = r100;
    }

    public final void setResult(boolean r100) {
        this.f502991a = r100;
    }
}
