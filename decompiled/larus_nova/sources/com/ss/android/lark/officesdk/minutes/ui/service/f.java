package com.ss.android.lark.officesdk.minutes.ui.service;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.ui.style.contract.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f436814a = 0;

    static {
    }

    public static h b(MmRecordingUILaunchMode r100) {
        if (r100.shouldHandleUI() == false) goto L5;
        com.ss.android.lark.officesdk.minutes.ui.style.e.f436896a.getClass();
        return com.ss.android.lark.officesdk.minutes.ui.style.e.c(r100);
    L5:
        return null;
    }

    public static d a(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r100, MmRecordingUILaunchMode r101) {
        Intrinsics.checkNotNullParameter(r101, "uiLaunchMode");
        if (r100 == null) goto L5;
        qub.e r102 = (qub.e) r100.u(qub.e.class);
    L6:
        h r103 = b(r101);
        if (r103 == null) goto L10;
        qub.e r104 = r103.getPanel();
        if (r104 == null) goto L10;
    L12:
        return new d(r102, r104);
    L10:
        r104 = qub.e.a.f534855a;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    public static e c(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r100, MmRecordingUILaunchMode r101) {
        Intrinsics.checkNotNullParameter(r101, "uiLaunchMode");
        if (r100 == null) goto L5;
        qub.h r102 = (qub.h) r100.u(qub.h.class);
    L6:
        h r103 = b(r101);
        if (r103 == null) goto L10;
        qub.h r104 = r103.getToast();
        if (r104 == null) goto L10;
    L12:
        return new e(r102, r104);
    L10:
        r104 = qub.h.a.f534856a;
        goto L12
    L5:
        r102 = null;
        goto L6
    }
}
