package com.larus.office.minutes.impl;

import com.larus.minutes.api.MinutesOfflineRecordingUploadStatus;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.officesdk.minutes.api.fileupload.MmMinutesFileUploadTaskState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes29.dex */
public final class MinutesServiceImpl$observeOfflineUploadTask$2<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f362259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f362260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MinutesServiceImpl f362261c;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f362262a = null;

        static {
            int[] r100 = new int[MmMinutesFileUploadTaskState.values().length];
            r100[MmMinutesFileUploadTaskState.UploadCompleted.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[MmMinutesFileUploadTaskState.Interrupted.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f362262a = r100;
        }
    }

    public MinutesServiceImpl$observeOfflineUploadTask$2(String r100, String r101, MinutesServiceImpl r102) {
        this.f362259a = r100;
        this.f362260b = r101;
        this.f362261c = r102;
    }

    public final Object a(eub.g r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof MinutesServiceImpl$observeOfflineUploadTask$2$emit$1) == false) goto L7;
        MinutesServiceImpl$observeOfflineUploadTask$2$emit$1 r100 = (MinutesServiceImpl$observeOfflineUploadTask$2$emit$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        ResultKt.throwOnFailure(r112);
    L38:
        this.f362261c.f362240r.remove(this.f362259a);
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r112);
    L33:
        hub.a r113 = this.f362261c.f362223a;
        if (r113 == null) goto L38;
        String r114 = this.f362259a;
        r100.label = 2;
        if (r113.s2(r114, r100) != r102) goto L38;
        return r102;
    L16:
        ResultKt.throwOnFailure(r112);
        FLogger r115 = FLogger.f375446a;
        r115.i("MinutesServiceImpl", "Offline upload task status, recordingId=" + this.f362259a + ", taskId=" + this.f362260b + ", state=" + r110.f474162a + ", progress=" + r110.f474163b + ", error=" + r110.f474168g);
        float r104 = RangesKt.coerceIn(((float) r110.f474163b) / 100.0f, 0.0f, 1.0f);
        int r116 = a.f362262a[r110.f474162a.ordinal()];
        String r117 = null;
        if (r116 == 1) goto L26;
        if (r116 == 2) goto L21;
        this.f362261c.f362241s.put(this.f362259a, Boxing.boxFloat(r104));
        this.f362261c.f362239q.setValue(new yk9.e(this.f362259a, RangesKt.coerceIn(r104, 0.0f, 1.0f), MinutesOfflineRecordingUploadStatus.PROGRESS, null));
        return Unit.INSTANCE;
    L21:
        r115.e("MinutesServiceImpl", "Offline upload interrupted, recordingId=" + this.f362259a + ", taskId=" + this.f362260b + ", error=" + r110.f474168g);
        MinutesServiceImpl r118 = this.f362261c;
        String r105 = this.f362259a;
        eub.b r119 = r110.f474168g;
        if (r119 == null) goto L24;
        r117 = r119.toString();
    L24:
        int r120 = MinutesServiceImpl.f362222x;
        r118.i(r105, r117);
        this.f362261c.f362240r.remove(this.f362259a);
        return Unit.INSTANCE;
    L26:
        r115.i("MinutesServiceImpl", "Offline upload completed, recordingId=" + this.f362259a + ", taskId=" + this.f362260b);
        this.f362261c.f362241s.remove(this.f362259a);
        this.f362261c.f362239q.setValue(new yk9.e(this.f362259a, RangesKt.coerceIn(1.0f, 0.0f, 1.0f), MinutesOfflineRecordingUploadStatus.SUCCESS, null));
        MinutesServiceImpl r121 = this.f362261c;
        String r122 = this.f362259a;
        r121.getClass();
        if (StringsKt.isBlank(r122) == true) goto L30;
        r121.f362243u.erase("doubao_biz_info_" + r122);
    L30:
        MinutesServiceImpl r123 = this.f362261c;
        String r124 = this.f362259a;
        r100.label = 1;
        if (MinutesServiceImpl.c(r123, r124, r100) != r102) goto L33;
        return r102;
    L7:
        r100 = new MinutesServiceImpl$observeOfflineUploadTask$2$emit$1(this, r111);
        goto L8
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
        return a((eub.g) r100, r101);
    }
}
