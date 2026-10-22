package com.bytedance.livesdk.ktvcommon.download.model;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes20.dex */
public final class i extends MusicCacheFactory {
    @Override // com.bytedance.livesdk.ktvcommon.download.model.MusicCacheFactory
    public MusicType getType() {
        return MusicType.LYRIC;
    }

    public final String c(m r110) {
        Intrinsics.checkNotNullParameter(r110, "music");
        Intrinsics.checkNotNullParameter(r110, "music");
        String r100 = a(r110.f255991a, "lyrics");
        Intrinsics.checkNotNullParameter(r110, "music");
        String r101 = r110.f255994d;
        String r111 = r110.f255991a;
        boolean r102 = false;
        if (r101 == null) goto L21;
        if ((!StringsKt.isBlank(r101)) == false) goto L7;
        String r103 = r101;
    L8:
        if (r103 == null) goto L21;
        String r104 = StringsKt.trimEnd(r101, new char[]{'/'});
        if (r104.length() != 0) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == true) goto L21;
        int r112 = StringsKt.lastIndexOf$default(r104, '/', 0, false, 6, null);
        if (r112 == (-1)) goto L19;
        r111 = r104.substring(r112 + 1);
        goto L21
    L19:
        r111 = r104;
        goto L21
    L13:
        r105 = false;
        goto L14
    L7:
        r103 = null;
    L21:
        if (r111.length() <= 0) goto L23;
        r102 = true;
    L23:
        if (r102 == false) goto L25;
        String r113 = r100 + r111;
    L26:
        b(r100);
        return r113;
    L25:
        r113 = r100;
        goto L26
    }

    public i(p r100, yk6.d r101, yk6.c r102) {
        Intrinsics.checkNotNullParameter(r100, "storageConfig");
        Intrinsics.checkNotNullParameter(r101, "fileOperator");
        Intrinsics.checkNotNullParameter(r102, "fileExecutor");
        super(r100, r101, r102);
    }
}
