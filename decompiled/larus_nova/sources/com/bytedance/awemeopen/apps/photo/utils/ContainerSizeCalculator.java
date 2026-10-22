package com.bytedance.awemeopen.apps.photo.utils;

import android.content.Context;
import android.util.Size;
import com.larus.bmhome.share.panel.ShareChannel;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class ContainerSizeCalculator implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f198037a;

    public ContainerSizeCalculator() {
        this.f198037a = LazyKt.lazy(new ContainerSizeCalculator$strategy$2(this));
    }

    @Override // com.bytedance.awemeopen.apps.photo.utils.c
    public final Size a(r14.c r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, ShareChannel.DOUYIN);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Size r102 = ((c) this.f198037a.getValue()).a(r100, r101);
        Objects.toString(r102);
        return r102;
    }
}
