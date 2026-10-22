package com.obric.audio.continuous_talk.session.impl;

import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f395293a = null;

    static {
        f395293a = LazyKt.lazy(new o());
    }

    public static ISettingRepoService a() {
        return (ISettingRepoService) f395293a.getValue();
    }

    public static boolean b(Integer r100, Integer r101) {
        if (r100 != null) goto L4;
    L8:
        boolean r102 = false;
    L9:
        FLogger.f375446a.i("ObricContTalkUtils", "isDoraVuiWakeup vuiId=" + r100 + ", wakeupId=" + r101 + ", result=" + r102);
        return r102;
    L4:
        if (r100.intValue() == 0) goto L8;
        if (Intrinsics.areEqual(r100, r101) == true) goto L8;
        r102 = true;
        goto L9
    }
}
