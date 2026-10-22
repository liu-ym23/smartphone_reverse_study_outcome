package j3b;

import b3b.f;
import i3b.d;
import kotlin.jvm.internal.Intrinsics;
import v4b.c;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m2b.a f497152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f497153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v4b.d f497154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f497155d;

    @Override // i3b.d
    public final m2b.a a() {
        return this.f497152a;
    }

    @Override // i3b.d
    public final c b() {
        return this.f497155d;
    }

    public final Class c() {
        return d.class;
    }

    @Override // i3b.d
    public final f g() {
        return this.f497153b;
    }

    @Override // i3b.d
    public final v4b.d j() {
        return this.f497154c;
    }

    public a(m2b.a r100, f r101, v4b.d r102, c r103) {
        Intrinsics.checkNotNullParameter(r100, "chatContext");
        this.f497152a = r100;
        this.f497153b = r101;
        this.f497154c = r102;
        this.f497155d = r103;
    }
}
