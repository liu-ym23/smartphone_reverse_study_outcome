package fr2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e1 implements g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f478500b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ui6.a f478501a;

    public static final class a {
    }

    static {
    }

    @Override // fr2.g
    public final String getRoomId() {
        return this.f478501a.f550209a;
    }

    @Override // fr2.g
    public final String getRtcExtInfo() {
        return this.f478501a.f550210b;
    }

    @Override // xh6.c
    public final Object getReal() {
        return this.f478501a;
    }

    public e1(ui6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f478501a = r100;
    }
}
