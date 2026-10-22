package com.bytedance.android.livesdk.ktvimpl.mv;

import com.bytedance.android.live.ktv.common.util.KtvCommonConfigParams;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class u {
    public final String a;
    public final String b;
    public final Long c;
    public v d;

    public u(String r5, String r6, Long r7) {
        int r0 = t.d;
        Intrinsics.checkNotNullParameter(r5, "vId");
        int r1 = com.bytedance.android.live.ktv.common.music.download.v.a;
        StringBuilder r2 = new StringBuilder(KtvCommonConfigParams.a());
        String r3 = File.separator;
        r2.append(r3);
        r2.append("musicPack");
        r2.append(r3);
        r2.append(r3);
        r2.append(r5);
        r2.append(r3);
        String r4 = r2.toString();
        Intrinsics.checkNotNullParameter(r5, "vId");
        Intrinsics.checkNotNullParameter(r4, "savePath");
        this.a = r5;
        this.b = r6;
        this.c = r7;
        this.d = null;
    }
}
