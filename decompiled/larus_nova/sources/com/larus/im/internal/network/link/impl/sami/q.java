package com.larus.im.internal.network.link.impl.sami;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.im.internal.network.adapter.abs.ProtocolMode;
import com.larus.im.service.audio.z0;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class q implements he9.d {
    public q() {
    }

    @Override // he9.d
    public final List<z0.a> a(ByteBuffer r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        AtomicLong r101 = se9.c.f541625a;
        int r102 = se9.a.f541622a;
        Intrinsics.checkNotNullParameter(r100, "buffer");
        Long r103 = StringsKt.toLongOrNull(new String(com.flow.kmp.common.util.b.e(r100), Charsets.UTF_8));
        if (r103 == null) goto L5;
        long r104 = r103.longValue();
    L6:
        List<z0.a> r105 = se9.c.f541626b.remove(Long.valueOf(r104));
        if (r105 == null) goto L9;
        return r105;
    L9:
        return CollectionsKt.emptyList();
    L5:
        r104 = 0;
        goto L6
    }

    @Override // he9.d
    public final byte[] b(ProtocolMode r100, xe9.b r101) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        int r102 = se9.a.f541622a;
        AtomicLong r103 = se9.b.f541623a;
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        long r104 = se9.b.f541623a.incrementAndGet();
        Long r105 = Long.valueOf(r104);
        se9.b.f541624b.put(r105, r101);
        return String.valueOf(r104).getBytes(Charsets.UTF_8);
    }
}
