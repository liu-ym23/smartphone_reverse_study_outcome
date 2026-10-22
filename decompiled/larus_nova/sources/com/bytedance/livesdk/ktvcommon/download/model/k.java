package com.bytedance.livesdk.ktvcommon.download.model;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes20.dex */
public final class k extends MusicCacheFactory {
    @Override // com.bytedance.livesdk.ktvcommon.download.model.MusicCacheFactory
    public MusicType getType() {
        return MusicType.MIDI;
    }

    public final String c(m r100) {
        Intrinsics.checkNotNullParameter(r100, "music");
        Intrinsics.checkNotNullParameter(r100, "music");
        String r101 = a(r100.f255991a, KtvSubElement.MIDI);
        Intrinsics.checkNotNullParameter(r100, "music");
        String r102 = r100.f255992b;
        boolean r103 = true;
        if (r102 == null) goto L10;
        int r104 = StringsKt.lastIndexOf$default(r102, HTTP.URL_DEFAULT, 0, false, 6, null);
        int r105 = r102.length() - 1;
        if (r104 < 0) goto L10;
        if (r105 <= r104) goto L10;
        String r106 = r102.substring(r104 + 1);
    L12:
        if (r106.length() > 0) goto L15;
        r103 = false;
    L15:
        if (r103 == false) goto L17;
        String r107 = r101 + r106;
    L18:
        b(r101);
        return r107;
    L17:
        r107 = r101;
    L10:
        r106 = "";
        goto L12
    }

    public k(p r100, yk6.d r101, yk6.c r102) {
        Intrinsics.checkNotNullParameter(r100, "storageConfig");
        Intrinsics.checkNotNullParameter(r101, "fileOperator");
        Intrinsics.checkNotNullParameter(r102, "fileExecutor");
        super(r100, r101, r102);
    }
}
