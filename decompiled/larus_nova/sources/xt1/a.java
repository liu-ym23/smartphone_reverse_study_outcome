package xt1;

import kotlin.jvm.internal.Intrinsics;
import yt1.o;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f565064e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f565065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f565066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f565067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f565068d;

    /* JADX INFO: renamed from: xt1.a$a, reason: collision with other inner class name */
    public static final class C8271a {
    }

    static {
    }

    public final String getType() {
        return this.f565066b;
    }

    public a(o r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "dslData");
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "data");
        this.f565065a = r100;
        this.f565066b = r101;
        this.f565067c = r102;
        this.f565068d = true;
    }
}
