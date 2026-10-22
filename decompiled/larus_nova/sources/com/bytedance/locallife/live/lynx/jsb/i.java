package com.bytedance.locallife.live.lynx.jsb;

import com.bytedance.locallife.live.lynx.LiveLocalLifeLynxView;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, Object> f260574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dv6.b f260575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LiveLocalLifeLynxView f260576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<String, Map<String, Object>> f260577d;

    /* JADX WARN: Multi-variable type inference failed */
    public i(HashMap<String, Object> r100, dv6.b r101, LiveLocalLifeLynxView r102, Function1<? super String, ? extends Map<String, Object>> r103) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "api");
        Intrinsics.checkNotNullParameter(r102, "targetView");
        Intrinsics.checkNotNullParameter(r103, "parseHandler");
        this.f260574a = r100;
        this.f260575b = r101;
        this.f260576c = r102;
        this.f260577d = r103;
    }
}
