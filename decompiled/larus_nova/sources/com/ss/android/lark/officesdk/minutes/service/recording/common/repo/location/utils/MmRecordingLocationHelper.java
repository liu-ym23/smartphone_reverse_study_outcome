package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils;

import com.ss.android.lark.location.dto.LarkLocation;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.request.http.MmUploadLocationResponse;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmRecordingNetHelper;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class MmRecordingLocationHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f435004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f435005b;

    public static final class a {
    }

    public interface b {
        void a(LarkLocation r100);
    }

    static {
    }

    public MmRecordingLocationHelper(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r100) {
        Intrinsics.checkNotNullParameter(r100, "mmUccApi");
        this.f435004a = r100;
        this.f435005b = "MmRecordingLocationHelper";
    }

    public final Object a(String r110, double r111, double r112, String r113, MmRecordingSource r210, boolean r211, Continuation<? super Result<MmUploadLocationResponse>> r212) {
        if ((r212 instanceof MmRecordingLocationHelper$uploadMMLocation$1) == false) goto L7;
        MmRecordingLocationHelper$uploadMMLocation$1 r100 = (MmRecordingLocationHelper$uploadMMLocation$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        MmRecordingLocationHelper$uploadMMLocation$1 r114 = r100;
        Object r102 = r114.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r114.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
        return ((Result) r102).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        MmRecordingNetHelper r105 = this.f435004a.G();
        r114.label = 1;
        Object r106 = r105.z(r110, r111, r112, r113, r210, r211, r114);
        if (r106 != r103) goto L18;
        return r103;
    L18:
        return r106;
    L7:
        r100 = new MmRecordingLocationHelper$uploadMMLocation$1(this, r212);
        goto L8
    }
}
