package es;

import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashSet<String> f473675a = null;

    static {
        f473675a = new HashSet();
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "gameId");
        f473675a.add(com.bytedance.android.gamecp.host_api.a.b().getUserService().user().getCurrentUserId() + "#" + r100);
    }
}
