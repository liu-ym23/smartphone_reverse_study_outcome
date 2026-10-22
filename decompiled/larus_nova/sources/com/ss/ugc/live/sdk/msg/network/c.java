package com.ss.ugc.live.sdk.msg.network;

import com.ss.android.lark.videosend.tools.VideoTools;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements amc.d {
    public c() {
    }

    @Override // amc.d
    public final Map<String, String> a() {
        return MapsKt.hashMapOf(new Pair[]{TuplesKt.to(VideoTools.ERROR_TYPE_COMPRESS, DownloadHelper.GZIP)});
    }

    @Override // amc.d
    public final byte[] b(tlc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "payloadItem");
        byte[] r101 = r100.f546764e;
        if (Intrinsics.areEqual(com.ss.ugc.live.sdk.msg.utils.h.a(r100), DownloadHelper.GZIP) == true) goto L5;
        return r101;
    L5:
        return com.ss.ugc.live.sdk.msg.utils.b.a(r101);
    }
}
