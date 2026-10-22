package com.larus.bmhome.chat.bubble.floating.runtime;

import com.larus.bmhome.chat.bubble.floating.BubbleBannerDismissReason;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f297555a = 0;

    /* JADX INFO: loaded from: classes4.dex */
    public interface a {
        void E(String r100);
    }

    static {
    }

    public static IBubbleBannerRuntimeService c() {
        return (IBubbleBannerRuntimeService) ServiceManager.get().getService(IBubbleBannerRuntimeService.class);
    }

    public static pc8.e b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "promptId");
        IBubbleBannerRuntimeService r101 = c();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get(r100);
    }

    public static boolean a(String r100, BubbleBannerDismissReason r101) {
        Intrinsics.checkNotNullParameter(r100, "promptId");
        Intrinsics.checkNotNullParameter(r101, "reason");
        IBubbleBannerRuntimeService r102 = c();
        if (r102 != null) goto L5;
    L7:
        return false;
    L5:
        if (r102.h(r100, r101) != true) goto L7;
        return true;
    }

    public static void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "promptId");
        IBubbleBannerRuntimeService r102 = c();
        if (r102 == null) goto L6;
        r102.g(r100, r101);
        return;
    }
}
