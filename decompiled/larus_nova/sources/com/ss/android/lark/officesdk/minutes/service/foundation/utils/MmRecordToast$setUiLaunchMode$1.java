package com.ss.android.lark.officesdk.minutes.service.foundation.utils;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class MmRecordToast$setUiLaunchMode$1 extends Lambda implements Function1 {
    public static final MmRecordToast$setUiLaunchMode$1 INSTANCE = null;

    static {
        INSTANCE = new MmRecordToast$setUiLaunchMode$1();
    }

    public MmRecordToast$setUiLaunchMode$1() {
        super(1);
    }

    public final Void invoke(MmRecordingUILaunchMode r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object r100) {
        return invoke((MmRecordingUILaunchMode) r100);
    }
}
