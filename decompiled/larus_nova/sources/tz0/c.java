package tz0;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class c extends com.bytedance.android.livesdk.revenue.network.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f548040a;

    @Override // com.bytedance.android.livesdk.revenue.network.a
    public final Boolean h() {
        return Boolean.valueOf(this.f548040a);
    }

    public c() {
        this.f548040a = true;
    }

    @Override // com.bytedance.android.livesdk.revenue.network.a
    public final String g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "originPath");
        if (StringsKt.startsWith$default(r100, "/webcast", false, 2, null) == true) goto L5;
        return r100;
    L5:
        if (StringsKt.startsWith$default(r100, "/webcast/openapi", false, 2, null) == false) goto L7;
        return r100;
    L7:
        return "/webcast/openapi/v2" + StringsKt.removePrefix(r100, "/webcast");
    }
}
