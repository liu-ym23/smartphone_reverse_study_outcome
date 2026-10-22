package s26;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public class a implements q26.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f540302a;

    /* JADX INFO: renamed from: s26.a$a, reason: collision with other inner class name */
    public static final class C7559a {
    }

    static {
    }

    @Override // q26.c
    public final void onUnRegister() {
    }

    public a() {
        this.f540302a = "default_bid";
    }

    @Override // q26.c
    public final String getBid() {
        return this.f540302a;
    }

    public final <T extends q26.c> T F0(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        d r101 = d.f540305c;
        return (T) d.f540305c.d(this.f540302a, r100);
    }

    @Override // q26.c
    public final void onRegister(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bid");
        this.f540302a = r100;
    }
}
