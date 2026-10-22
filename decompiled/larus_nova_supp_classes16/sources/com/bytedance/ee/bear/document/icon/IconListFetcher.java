package com.bytedance.ee.bear.document.icon;

import com.bytedance.ee.bear.contract.NetService;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class IconListFetcher {
    public final NetService a;
    public Function1<? super List<? extends DocIconNetResult.Icon>, Unit> b;
    public String c;

    public static final class a {
    }

    static {
    }

    public IconListFetcher(NetService r2) {
        Intrinsics.checkNotNullParameter(r2, "netService");
        this.a = r2;
        IconListFetcher$defaultErrorHandler$1 r3 = IconListFetcher$defaultErrorHandler$1.INSTANCE;
    }
}
