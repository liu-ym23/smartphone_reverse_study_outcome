package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "rtcService", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/rtc/IOfficeSDKRtcService;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class MmRtcWrapper$setBandWidthJson$1 extends Lambda implements Function1<nub.b, Unit> {
    final /* synthetic */ JSONObject $input;

    public MmRtcWrapper$setBandWidthJson$1(JSONObject r100) {
        this.$input = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(nub.b r100) {
        Intrinsics.checkNotNullParameter(r100, "rtcService");
        r100.x(this.$input);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(nub.b r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
