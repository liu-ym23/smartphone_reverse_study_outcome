package q38;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a {
    public final boolean a;
    public final String b;
    public final String c;
    public final String d;
    public final int e;
    public final String f;
    public final boolean g;

    public a(boolean r2, String r3, String r4, String r5, int r6, String r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r3, "loginPlatform");
        Intrinsics.checkNotNullParameter(r4, "userId");
        Intrinsics.checkNotNullParameter(r5, "secUserId");
        Intrinsics.checkNotNullParameter(r7, "userMobile");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
