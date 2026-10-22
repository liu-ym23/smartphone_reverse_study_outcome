package com.bytedance.flow_audio.impl.business.asr;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f243963f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f243964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zw5.a f243965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StringBuilder f243966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public iw5.c f243967d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public iw5.c f243968e;

    public static final class a {
    }

    static {
        f243963f = zw5.b.a("FlowAsrAudioDownlinkController");
    }

    public static iw5.e a(cx5.f r100) {
        String r101 = r100.f465727a;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        Boolean r102 = r100.f465728b;
        Boolean r103 = Boolean.TRUE;
        return new iw5.e(r101, Intrinsics.areEqual(r102, r103), Intrinsics.areEqual(r100.f465729c, r103), Intrinsics.areEqual(r100.f465730d, r103));
    }

    public d(String r100, zw5.a r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "logContext");
        this.f243964a = r100;
        this.f243965b = r101;
        this.f243966c = new StringBuilder();
    }
}
