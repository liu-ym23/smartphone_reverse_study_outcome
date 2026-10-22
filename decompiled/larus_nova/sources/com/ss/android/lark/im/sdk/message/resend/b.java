package com.ss.android.lark.im.sdk.message.resend;

import com.bytedance.lark.pb.media.v1.MGetResourcesResponse;
import com.bytedance.lark.pb.media.v1.Resource;
import com.ss.android.lark.sdk.SdkSender;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements SdkSender.IParser<Resource> {
    public b() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Resource parse(byte[] r100) {
        if (r100 == null) goto L18;
        MGetResourcesResponse r101 = MGetResourcesResponse.ADAPTER.decode(r100);
        if (r101 == null) goto L10;
        Map<String, Resource> r102 = r101.resources;
        if (r102 == null) goto L10;
        List r103 = MapsKt.toList(r102);
    L11:
        if (r103 == null) goto L16;
        Pair r104 = (Pair) CollectionsKt.firstOrNull(r103);
        if (r104 != null) goto L15;
        return null;
    L15:
        return (Resource) r104.getSecond();
    L16:
        return null;
    L10:
        r103 = null;
        goto L11
    L18:
        return null;
    }
}
