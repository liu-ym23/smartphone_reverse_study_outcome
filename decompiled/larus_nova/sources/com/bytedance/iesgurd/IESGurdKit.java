package com.bytedance.iesgurd;

import com.bytedance.iesgurd.meta.ChannelMeta;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes3.dex */
public final class IESGurdKit {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, c> f250623a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f250624b = null;

    static {
        f250623a = new ConcurrentHashMap();
        f250624b = LazyKt.lazy(IESGurdKit$debuggable$2.INSTANCE);
    }

    @JvmStatic
    public static final long a(String r100, String r101) {
        boolean r102 = false;
        if (r100.length() != 0) goto L5;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L9;
        return 0;
    L9:
        if (r101.length() != 0) goto L11;
        r102 = true;
    L11:
        if (r102 == true) goto L25;
        ChannelMeta r104 = com.bytedance.iesgurd.meta.a.c(r100, r101);
        if (r104 != null) goto L16;
        return 0;
    L16:
        if (r104.getForbidden() == false) goto L18;
        return 0;
    L18:
        Long r105 = com.bytedance.iesgurd.meta.a.a(r100, r101, r104, "");
        if (r105 != null) goto L21;
        return 0;
    L21:
        return r105.longValue();
    L25:
        return 0;
    L5:
        r103 = false;
        goto L7
    }
}
