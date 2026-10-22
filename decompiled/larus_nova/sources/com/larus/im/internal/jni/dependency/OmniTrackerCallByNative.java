package com.larus.im.internal.jni.dependency;

import com.bytedance.android.ec.slice.SliceInitService;
import com.larus.im.internal.delegate.d1;
import com.larus.im.internal.delegate.p0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ouc.d0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007¨\u0006\f"}, d2 = {"Lcom/larus/im/internal/jni/dependency/OmniTrackerCallByNative;", "", "<init>", "()V", "trackEvent", "", "event", "", "param", "perfEvent", "scene", "step", "omnisdk-foundation_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniTrackerCallByNative {
    public OmniTrackerCallByNative() {
    }

    public final void perfEvent(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "step");
        p0.f348255a.a(r100, r101);
    }

    public final void trackEvent(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "param");
        SSEPerformanceMetricsCollector r102 = SSEPerformanceMetricsCollector.INSTANCE;
        if (r101.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        r101 = SliceInitService.DEFAULT_SWITCH;
    L8:
        d0 r104 = r102.enrich(r100, com.flow.kmp.common.util.f.e(r101));
        d1.f348206b.a(r100, r104);
        return;
    L5:
        r103 = false;
        goto L6
    }
}
