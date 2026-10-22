package mlc;

import android.content.Context;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f514403a = 0;

    static {
    }

    public static a a(String r100, Object r101) {
        if ((r101 instanceof Context) == false) goto L7;
        return new a((Context) r101, r100);
    L7:
        throw new IllegalArgumentException("must parse context arguement in Settings!");
    }
}
