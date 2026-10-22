package n61;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f518099d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f518100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f518101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f518102c;

    /* JADX INFO: renamed from: n61.a$a, reason: collision with other inner class name */
    public static final class C6896a {
        public static a a(b r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "category");
            a r102 = new a(r100);
            r102.f518100a = Integer.valueOf(r101);
            return r102;
        }
    }

    static {
    }

    public final String toString() {
        return "BasicPerfSource(perfType=" + this.f518102c + ", level=" + this.f518100a + ')';
    }

    public a(b r100) {
        this.f518102c = r100;
    }
}
