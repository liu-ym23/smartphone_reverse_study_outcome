package com.ss.ugc.live.sdk.platform;

import com.ss.ugc.live.sdk.msg.dispatch.f;
import com.ss.ugc.live.sdk.platform.imbroadcast.IMBroadcast;
import gm2.o;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<f> f458519a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<ylc.a> f458520b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<omc.b> f458521c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<Object> f458522d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final IMBroadcast f458523e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static com.ss.ugc.live.sdk.platform.bytelink.f f458524f;

    static {
        f458519a = new CopyOnWriteArrayList();
        f458520b = new CopyOnWriteArrayList();
        f458521c = new CopyOnWriteArrayList();
        f458522d = new CopyOnWriteArrayList();
        f458523e = new IMBroadcast();
        f458524f = new com.ss.ugc.live.sdk.platform.bytelink.f();
    }

    public static void a() {
        Intrinsics.throwUninitializedPropertyAccessException("depend");
    }

    @JvmStatic
    public static final void b(final o r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        List<omc.b> r101 = f458521c;
        CollectionsKt.removeAll(r101, new MessagePlatform$injectSupportPBDecoderWithCheck$1(r100));
        ((CopyOnWriteArrayList) r101).add(r100);
    }
}
