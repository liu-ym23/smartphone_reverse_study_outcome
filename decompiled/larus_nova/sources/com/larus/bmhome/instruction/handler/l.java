package com.larus.bmhome.instruction.handler;

import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.bmhome.instruction.p f312106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, m> f312107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f312108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f312109d;

    public static final class a {
    }

    static {
    }

    public l(final Fragment r100, com.larus.bmhome.instruction.p r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "instructionCoreAbility");
        this.f312106a = r101;
        this.f312107b = new LinkedHashMap();
        this.f312108c = LazyKt.lazy(new j(r100));
        this.f312109d = LazyKt.lazy(new k(r100));
    }
}
