package com.larus.im.internal.jni.service;

import com.larus.im.internal.jni.bean.OMNIAVMMTInitConfig;
import com.larus.im.internal.jni.bean.OMNIAVSessionConfig;
import com.larus.im.internal.jni.session.NativeMediaSession;
import juc.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wt7.a;
import wt7.c;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\b\u001a\u0012\u0010\t\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\b¨\u0006\n"}, d2 = {"preGetMmtAccess", "", "Lcom/larus/im/internal/jni/service/OmniMediaService;", "config", "Lcom/larus/im/internal/jni/bean/OMNIAVMMTInitConfig;", "preloadMmtTransport", "createSession", "Lcom/larus/im/internal/jni/session/NativeMediaSession;", "Lcom/larus/im/internal/jni/bean/OMNIAVSessionConfig;", "createRealtimeSession", "omnisdk-av_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class OmniMediaServiceKt {
    public static final NativeMediaSession createRealtimeSession(OmniMediaService r100, OMNIAVSessionConfig r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "config");
        c r102 = a.f561230a;
        d<OMNIAVSessionConfig> r103 = OMNIAVSessionConfig.Companion.serializer();
        r102.getClass();
        String r104 = c.b(r101, r103);
        if (r104 != null) goto L6;
        r104 = "";
    L6:
        return r100.createRealtimeSession(r104);
    }

    public static final NativeMediaSession createSession(OmniMediaService r100, OMNIAVSessionConfig r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "config");
        c r102 = a.f561230a;
        d<OMNIAVSessionConfig> r103 = OMNIAVSessionConfig.Companion.serializer();
        r102.getClass();
        String r104 = c.b(r101, r103);
        if (r104 != null) goto L6;
        r104 = "";
    L6:
        return r100.createSession(r104);
    }

    public static final int preGetMmtAccess(OmniMediaService r100, OMNIAVMMTInitConfig r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "config");
        c r102 = a.f561230a;
        d<OMNIAVMMTInitConfig> r103 = OMNIAVMMTInitConfig.Companion.serializer();
        r102.getClass();
        String r104 = c.b(r101, r103);
        if (r104 != null) goto L6;
        r104 = "";
    L6:
        return r100.preGetMmtAccess(r104);
    }

    public static final int preloadMmtTransport(OmniMediaService r100, OMNIAVMMTInitConfig r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "config");
        c r102 = a.f561230a;
        d<OMNIAVMMTInitConfig> r103 = OMNIAVMMTInitConfig.Companion.serializer();
        r102.getClass();
        String r104 = c.b(r101, r103);
        if (r104 != null) goto L6;
        r104 = "";
    L6:
        return r100.preloadMmtTransport(r104);
    }
}
