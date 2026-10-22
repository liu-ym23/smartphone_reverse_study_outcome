package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.MmRecordFileHelper;
import com.ss.android.lark.vfs.h;
import jvb.n;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class MmRecordingUploadTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f434499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f434500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f434501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f434502d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f434503e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MmRecordingSource f434504f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f434505g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f434506h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MmRecordingUploadTask) == true) goto L8;
        return false;
    L8:
        MmRecordingUploadTask r101 = (MmRecordingUploadTask) r100;
        if (Intrinsics.areEqual(this.f434499a, r101.f434499a) == true) goto L12;
        return false;
    L12:
        if (this.f434500b == r101.f434500b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f434501c, r101.f434501c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f434502d, r101.f434502d) == true) goto L21;
        return false;
    L21:
        if (this.f434503e == r101.f434503e) goto L24;
        return false;
    L24:
        if (this.f434504f == r101.f434504f) goto L27;
        return false;
    L27:
        if (this.f434505g == r101.f434505g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f434499a.hashCode() * 31) + this.f434500b) * 31) + this.f434501c.hashCode()) * 31) + this.f434502d.hashCode()) * 31) + this.f434503e) * 31;
        MmRecordingSource r101 = this.f434504f;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f434505g == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 + r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmRecordingUploadTask(audioSegmentFilePath=" + this.f434499a + ", segIndex=" + this.f434500b + ", uploadIdentity=" + this.f434501c + ", startMs=" + this.f434502d + ", duration=" + this.f434503e + ", source=" + this.f434504f + ", useRecordingApi=" + this.f434505g + ')';
    }

    public final Object b(com.ss.android.lark.officesdk.minutes.service.foundation.network.b r110, Continuation<? super Result<String>> r111) {
        if ((r111 instanceof MmRecordingUploadTask$sendAudioSegmentRequest$1) == false) goto L7;
        MmRecordingUploadTask$sendAudioSegmentRequest$1 r100 = (MmRecordingUploadTask$sendAudioSegmentRequest$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r112);
        return ((Result) r112).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        n r104 = new n(this.f434501c, this.f434502d, this.f434503e, this.f434500b, this.f434499a, this.f434504f, this.f434505g);
        r100.label = 1;
        Object r113 = r110.c(String.class, r104, r100);
        if (r113 != r102) goto L18;
        return r102;
    L18:
        return r113;
    L7:
        r100 = new MmRecordingUploadTask$sendAudioSegmentRequest$1(this, r111);
        goto L8
    }

    public static final Object a(MmRecordingUploadTask r110, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r111, Continuation r112) {
        r110.getClass();
        if ((r112 instanceof MmRecordingUploadTask$postAudioSegment$1) == false) goto L7;
        MmRecordingUploadTask$postAudioSegment$1 r100 = (MmRecordingUploadTask$postAudioSegment$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        ResultKt.throwOnFailure(r113);
        Object r114 = ((Result) r113).m9458unboximpl();
    L29:
        if (Result.m9456isSuccessimpl(r114) == false) goto L32;
        lvb.a.e(r110.f434506h, "onSuccess: index:" + r110.f434500b + ", httpCode:200, statusCode: 0");
        MmRecordingUploadResponse.a r115 = MmRecordingUploadResponse.Companion;
        Integer r116 = Boxing.boxInt(200);
        Integer r117 = Boxing.boxInt(0);
        r115.getClass();
        return MmRecordingUploadResponse.a.a(r116, r117);
    L32:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r114);
        if ((r118 instanceof ErrorResult) == false) goto L35;
        ErrorResult r119 = (ErrorResult) r118;
    L36:
        if (r119 != null) goto L43;
        Exception r120 = new Exception(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        ErrorResult r121 = new ErrorResult(0);
        ErrorResult.access$002(r121, -1);
        ErrorResult.access$102(r121, -9999);
        ErrorResult.access$202(r121, -1);
        ErrorResult.access$302(r121, r120);
        ErrorResult.access$402(r121, "");
        ErrorResult.access$502(r121, "");
        ErrorResult.access$602(r121, "");
        ErrorResult.access$702(r121, "");
        ErrorResult.access$802(r121, 0);
        ErrorResult.access$902(r121, null);
        ErrorResult.access$1002(r121, null);
        ErrorResult.access$1102(r121, null);
        throw r121;
    L43:
        throw r119;
    L35:
        r119 = null;
        goto L36
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r113);
    L24:
        MmRecordingUploadResponse.a r122 = MmRecordingUploadResponse.Companion;
        Integer r123 = Boxing.boxInt(200);
        Integer r124 = Boxing.boxInt(0);
        r122.getClass();
        return MmRecordingUploadResponse.a.a(r123, r124);
    L16:
        ResultKt.throwOnFailure(r113);
        lvb.a.e(r110.f434506h, " [UploadTask]  task:" + r110);
        h r125 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.f434038a;
        if (com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.c(r110.f434499a).exists() == true) goto L20;
        lvb.a.h(r110.f434506h, "not exist " + r110.f434499a);
        MmRecordingUploadResponse.a r126 = MmRecordingUploadResponse.Companion;
        Integer r127 = Boxing.boxInt(200);
        Integer r128 = Boxing.boxInt(0);
        r126.getClass();
        return MmRecordingUploadResponse.a.a(r127, r128);
    L20:
        if (com.suite.lark.component.storage.ext.a.a(com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.c(r110.f434499a), false) > 0) goto L25;
        lvb.a.h(r110.f434506h, "empty file, path: " + r110.f434499a);
        MmRecordFileHelper r129 = MmRecordFileHelper.f434037a;
        String r130 = r110.f434499a;
        r100.label = 1;
        r129.getClass();
        if (MmRecordFileHelper.b(r130, r100) != r102) goto L24;
        return r102;
    L25:
        com.ss.android.lark.officesdk.minutes.service.foundation.network.b r131 = r111.M();
        r100.label = 2;
        r114 = r110.b(r131, r100);
        if (r114 != r102) goto L29;
        return r102;
    L7:
        r100 = new MmRecordingUploadTask$postAudioSegment$1(r110, r112);
        goto L8
    }

    public MmRecordingUploadTask(String r100, int r101, String r102, String r103, int r104, MmRecordingSource r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "audioSegmentFilePath");
        Intrinsics.checkNotNullParameter(r102, "uploadIdentity");
        Intrinsics.checkNotNullParameter(r103, "startMs");
        this.f434499a = r100;
        this.f434500b = r101;
        this.f434501c = r102;
        this.f434502d = r103;
        this.f434503e = r104;
        this.f434504f = r105;
        this.f434505g = r106;
        this.f434506h = "MmRecordingUploadTask_" + hashCode();
    }
}
