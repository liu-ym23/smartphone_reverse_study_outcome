package fi3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class w {
    public static final /* synthetic */ int e = 0;
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public static final class a {
    }

    static {
    }

    public w() {
        this("", "", "", "");
    }

    public final String getIdentifier() {
        return this.b;
    }

    public w(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "videoId");
        Intrinsics.checkNotNullParameter(r3, "identifier");
        Intrinsics.checkNotNullParameter(r4, "scene");
        Intrinsics.checkNotNullParameter(r5, "command");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
