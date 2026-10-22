package qx0;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class a extends com.bytedance.android.livesdk.revenue.network.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f535099a = null;

    static {
        f535099a = new a();
    }

    public a() {
    }

    @Override // com.bytedance.android.livesdk.revenue.network.a
    public final Boolean h() {
        return Boolean.FALSE;
    }

    @Override // com.bytedance.android.livesdk.revenue.network.a
    public final String g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "originPath");
        if (StringsKt.startsWith$default(r101, "/webcast", false, 2, null) == true) goto L5;
        return r101;
    L5:
        if (StringsKt.startsWith$default(r101, "/webcast/openapi", false, 2, null) == false) goto L7;
        return r101;
    L7:
        return "/webcast/openapi" + StringsKt.removePrefix(r101, "/webcast");
    }
}
