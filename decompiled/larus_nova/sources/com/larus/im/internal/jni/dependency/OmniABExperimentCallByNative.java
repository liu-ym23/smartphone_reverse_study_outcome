package com.larus.im.internal.jni.dependency;

import com.larus.im.FlowRuntime;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\t\n\u0002\u0010\u0006\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\u0006\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\u0006\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\u0010\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\u0011"}, d2 = {"Lcom/larus/im/internal/jni/dependency/OmniABExperimentCallByNative;", "", "<init>", "()V", "abExperiment", "Lcom/larus/im/depend/IABExperimentService;", MonitorConstants.CONNECT_TYPE_GET, "", "key", "", "default", "exposure", "", "", "", "getString", "getDictionaryJson", "omnisdk-foundation_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniABExperimentCallByNative {
    public OmniABExperimentCallByNative() {
    }

    private final gd9.g abExperiment() {
        return FlowRuntime.b().g();
    }

    public final double get(String r100, double r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return abExperiment().a(r100, r101, r102);
    }

    public final String getDictionaryJson(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "default");
        return abExperiment().c(r100, r101, r102);
    }

    public final String getString(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "default");
        return abExperiment().f(r100, r101, r102);
    }

    public final int get(String r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return abExperiment().d(r100, r101, r102);
    }

    public final long get(String r100, long r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return abExperiment().b(r100, r101, r102);
    }

    public final boolean get(String r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return abExperiment().e(r100, r101, r102);
    }
}
