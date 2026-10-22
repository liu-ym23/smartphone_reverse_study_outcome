package com.larus.asr.session.component;

import com.byted.cast.common.TeaEventTrack;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<p0> f287690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<o0> f287691b;

    /* JADX WARN: Multi-variable type inference failed */
    public d0(List<? extends p0> r100, List<? extends o0> r101) {
        Intrinsics.checkNotNullParameter(r100, TeaEventTrack.ACTION_DRAMA_PRE);
        Intrinsics.checkNotNullParameter(r101, UGCMonitor.TYPE_POST);
        this.f287690a = r100;
        this.f287691b = r101;
    }
}
