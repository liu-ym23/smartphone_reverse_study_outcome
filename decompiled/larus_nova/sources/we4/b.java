package we4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f559394d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f559395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f559396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T f559397c;

    public static final class a {
        public static b b(Object r100) {
            return new b(1, "", r100);
        }

        public static b a(int r100, String r101, Object r102) {
            Intrinsics.checkNotNullParameter(r101, "errMsg");
            return new b(r100, r101, r102);
        }
    }

    static {
    }

    public final boolean a() {
        int r100 = this.f559395a;
        if (r100 == 0) goto L8;
        if (r100 == 1) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    public final String toString() {
        return "CJResult(code=" + this.f559395a + ", msg='" + this.f559396b + "', data=" + this.f559397c + ')';
    }

    public b(int r100, String r101, T r102) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        this.f559395a = r100;
        this.f559396b = r101;
        this.f559397c = r102;
    }
}
