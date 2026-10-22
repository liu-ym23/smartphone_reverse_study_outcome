package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.retry;

import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.b;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmUploadTaskRetryConfig;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingUploadResponse;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes37.dex */
public final class MmRecordingRetryPolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f434508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MmUploadTaskRetryConfig f434509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MmUploadTaskRetryConfig f434510c;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f434511a = null;

        static {
            int[] r100 = new int[MmRecordingUploadResponse.values().length];
            r100[MmRecordingUploadResponse.UNKNOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[MmRecordingUploadResponse.NETWORK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r100[MmRecordingUploadResponse.TOS_UPLOAD_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[MmRecordingUploadResponse.ENCRYPTION_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r100[MmRecordingUploadResponse.GET_TENANT_KEY_FAILED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r100[MmRecordingUploadResponse.ABASE_FAILED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r100[MmRecordingUploadResponse.TRANSCODING_FAILED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[MmRecordingUploadResponse.SERVER_DOWN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            f434511a = r100;
        }
    }

    public MmRecordingRetryPolicy(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r100) {
        Intrinsics.checkNotNullParameter(r100, "userComponentContextImpl");
        b r101 = r100.getSettingsService();
        this.f434508a = r101;
        this.f434509b = r101.f434072c.getLinearRetryConfig();
        this.f434510c = r101.f434072c.getExponentialRetryConfig();
    }

    public final Object a(MmRecordingUploadResponse r110, long r111, Continuation<? super Boolean> r112) {
        long r100 = r111;
        if ((r112 instanceof MmRecordingRetryPolicy$canRetry$1) == false) goto L7;
        MmRecordingRetryPolicy$canRetry$1 r101 = (MmRecordingRetryPolicy$canRetry$1) r112;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L20;
        if (r105 == 1) goto L19;
        if (r105 == 2) goto L18;
        if (r105 == 3) goto L17;
        if (r105 != 4) goto L16;
        r100 = r101.J$0;
        ResultKt.throwOnFailure(r103);
    L27:
        if (r100 < this.f434510c.getMaxCount()) goto L48;
    L49:
        boolean r106 = false;
    L51:
        return Boxing.boxBoolean(r106);
    L48:
        r106 = true;
        goto L51
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r100 = r101.J$0;
        ResultKt.throwOnFailure(r103);
    L41:
        if (r100 >= this.f434510c.getMaxCount()) goto L49;
    L18:
        r100 = r101.J$0;
        ResultKt.throwOnFailure(r103);
    L35:
        if (r100 >= this.f434509b.getMaxCount()) goto L49;
    L19:
        r100 = r101.J$0;
        ResultKt.throwOnFailure(r103);
    L47:
        if (r100 >= this.f434509b.getMaxCount()) goto L49;
    L20:
        ResultKt.throwOnFailure(r103);
        switch(a.f434511a[r110.ordinal()]) {
            case 1: goto L43;
            case 2: goto L43;
            case 3: goto L30;
            case 4: goto L23;
            case 5: goto L23;
            case 6: goto L23;
            case 7: goto L23;
            case 8: goto L23;
            default: goto L49;
        };
    L23:
        long r107 = RangesKt.coerceAtMost(((long) Math.pow(2.0d, ((int) r100) + 1)) + Random.Default.nextLong(0, 2000), 30000);
        r101.J$0 = r100;
        r101.label = 4;
        if (DelayKt.delay(r107, r101) != r104) goto L27;
        return r104;
    L43:
        long r108 = RangesKt.coerceAtMost(((long) (this.f434509b.getInterval() * 1000)) + Random.Default.nextLong(0, 2000), 30000);
        r101.J$0 = r100;
        r101.label = 1;
        if (DelayKt.delay(r108, r101) != r104) goto L47;
        return r104;
    L30:
        if (this.f434508a.f434077h.getTosErrorIntervalRetry() == false) goto L37;
        long r109 = RangesKt.coerceAtMost(((long) (this.f434509b.getInterval() * 1000)) + Random.Default.nextLong(0, 2000), 30000);
        r101.J$0 = r100;
        r101.label = 2;
        if (DelayKt.delay(r109, r101) != r104) goto L35;
        return r104;
    L37:
        long r113 = RangesKt.coerceAtMost(((long) Math.pow(2.0d, ((int) r100) + 1)) + Random.Default.nextLong(0, 2000), 30000);
        r101.J$0 = r100;
        r101.label = 3;
        if (DelayKt.delay(r113, r101) != r104) goto L41;
        return r104;
    L7:
        r101 = new MmRecordingRetryPolicy$canRetry$1(this, r112);
        goto L8
    }
}
