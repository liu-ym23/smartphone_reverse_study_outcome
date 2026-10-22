package o2b;

import jdb.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f521820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f521821b;

    static {
    }

    public static boolean a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "fgService");
        if (f521821b == true) goto L6;
        f521820a = r100.isEnable("im.messenger.new_recall");
        f521821b = true;
    L6:
        return f521820a;
    }
}
