package lp7;

import com.bytedance.flow_audio.api.service.common.IKMPLoggerService;
import com.ss.ttvideoengine.model.SubInfo;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final IKMPLoggerService f510233a = null;

    static {
        pd6.b r100 = pd6.c.f528682a;
        f510233a = (IKMPLoggerService) pd6.c.a(Reflection.getOrCreateKotlinClass(IKMPLoggerService.class));
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        IKMPLoggerService r102 = f510233a;
        if (r102 == null) goto L6;
        r102.logDebug(r101, r100);
        return;
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        IKMPLoggerService r102 = f510233a;
        if (r102 == null) goto L6;
        r102.logError(r101, r100);
        return;
    }

    public static void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        IKMPLoggerService r102 = f510233a;
        if (r102 == null) goto L6;
        r102.m1(r101, r100);
        return;
    }

    public static void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        IKMPLoggerService r102 = f510233a;
        if (r102 == null) goto L6;
        r102.logWarn(r101, r100);
        return;
    }
}
