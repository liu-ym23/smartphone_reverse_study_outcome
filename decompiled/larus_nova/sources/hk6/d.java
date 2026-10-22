package hk6;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f485571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ek6.b f485572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b.a f485573c;

    @Override // hk6.b.a
    public final void b(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        this.f485571a.f485575b.d(this.f485572b);
        this.f485573c.b(r100);
    }

    @Override // hk6.b.a
    public final void a(String r100, Throwable r101) {
        this.f485571a.f485575b.b(this.f485572b, r100, r101);
        b.a.C6158a.a(this.f485573c, null, null, 3);
    }

    public d(e r100, ek6.b r101, mk6.c r102) {
        this.f485571a = r100;
        this.f485572b = r101;
        this.f485573c = r102;
    }
}
