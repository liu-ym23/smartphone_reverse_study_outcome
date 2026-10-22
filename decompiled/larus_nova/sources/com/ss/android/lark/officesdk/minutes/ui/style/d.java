package com.ss.android.lark.officesdk.minutes.ui.style;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.style.contract.h;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.function.BiFunction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d<T, U, R> implements BiFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f436895a;

    public d(h r100) {
        this.f436895a = r100;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object r100, Object r101) {
        h r102 = (h) r101;
        Intrinsics.checkNotNullParameter((MmRecordingUILaunchMode) r100, "<unused var>");
        if (r102 != null) goto L6;
        return this.f436895a;
    L6:
        if (Intrinsics.areEqual(r102.getClass().getName(), this.f436895a.getClass().getName()) == true) goto L10;
        int r103 = bwb.b.f21271a;
        bwb.b.d(MmUiLogScene.STYLE, MiPushClient.COMMAND_REGISTER, "duplicate provider, mode=" + this.f436895a.getUiLaunchMode() + ", old=" + r102.getClass().getName() + ", new=" + this.f436895a.getClass().getName(), null);
        return r102;
    L10:
        return r102;
    }
}
