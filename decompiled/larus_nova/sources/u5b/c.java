package u5b;

import android.graphics.drawable.Drawable;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f548903e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f548904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f548905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable f548906c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f548907d;

    public static final class a {
        @JvmStatic
        public static c a(int r100, int r101, Drawable r102, int[] r103) {
            c r104 = c.f548903e;
            r104.f548907d = new int[]{0, 0, 0, 0};
            r104.f548904a = r100;
            r104.f548905b = r101;
            r104.f548906c = r102;
            if (r103 != null) goto L5;
            r103 = new int[]{0, 0, 0, 0};
        L5:
            Intrinsics.checkNotNullParameter(r103, "<set-?>");
            r104.f548907d = r103;
            return r104;
        }
    }

    static {
        f548903e = new c();
    }

    public c() {
        this.f548907d = new int[]{0, 0, 0, 0};
    }
}
