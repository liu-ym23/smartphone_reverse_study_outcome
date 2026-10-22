package vb5;

import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final FragmentActivity a;
    public final String b;
    public final int c;
    public final String d;
    public final String e;
    public final int f;
    public final boolean g;
    public final String h;
    public final String i;
    public final String j;

    /* JADX INFO: renamed from: vb5.a$a, reason: collision with other inner class name */
    public static final class C0312a {
    }

    static {
    }

    public final FragmentActivity getActivity() {
        return this.a;
    }

    public final int getType() {
        return this.c;
    }

    public a(FragmentActivity r2, String r3, int r4, String r5, String r6, int r7, boolean r8, String r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
    }
}
