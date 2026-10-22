package com.bytedance.ee.bear.document.icon;

import com.bytedance.ee.bear.contract.NetService;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class IconListFetcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetService f219962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super List<? extends DocIconNetResult.Icon>, Unit> f219963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f219964c;

    public static final class a {
    }

    static {
    }

    public IconListFetcher(NetService r100) {
        Intrinsics.checkNotNullParameter(r100, "netService");
        this.f219962a = r100;
        IconListFetcher$defaultErrorHandler$1 r101 = IconListFetcher$defaultErrorHandler$1.INSTANCE;
    }
}
