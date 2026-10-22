package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.thread.MMCoroutines;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.RecordingSessionType;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final class MmRecordingMeetingCreateFailureHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f434538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f434539b;

    public static final class a {
    }

    static {
    }

    public MmRecordingMeetingCreateFailureHandler(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "userComponentContext");
        Intrinsics.checkNotNullParameter(r101, "logTag");
        this.f434538a = r100;
        this.f434539b = r101;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00dc -> B:36:0x00e0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00e7 -> B:38:0x00e9). Please report as a decompilation issue!!! */
    public final Object b(int r210, Continuation<? super Unit> r211) {
        if ((r211 instanceof MmRecordingMeetingCreateFailureHandler$showQuotaDialog$1) == false) goto L7;
        MmRecordingMeetingCreateFailureHandler$showQuotaDialog$1 r100 = (MmRecordingMeetingCreateFailureHandler$showQuotaDialog$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        int r105 = r100.I$2;
        int r106 = r100.I$1;
        int r107 = r100.I$0;
        kub.a r108 = (kub.a) r100.L$0;
        ResultKt.throwOnFailure(r102);
        MmRecordingMeetingCreateFailureHandler r110 = this;
    L36:
        int r111 = r106;
        int r109 = r105;
        int r112 = r107;
        int r113 = r111;
    L38:
        int r114 = r109 + 1;
        int r115 = r113;
        kub.a r116 = r108;
        int r117 = r114;
    L21:
        if (r117 >= r115) goto L40;
        Lazy r118 = MMCoroutines.f433826a;
        MainCoroutineDispatcher r119 = Dispatchers.getMain().getImmediate();
        MmRecordingMeetingCreateFailureHandler$showQuotaDialog$2$shown$1 r120 = new MmRecordingMeetingCreateFailureHandler$showQuotaDialog$2$shown$1(r110, r117, r116, r112, null);
        r100.L$0 = r116;
        r100.I$0 = r112;
        r100.I$1 = r115;
        r100.I$2 = r117;
        r100.I$3 = r117;
        r100.label = 1;
        Object r121 = BuildersKt.withContext(r119, r120, r100);
        if (r121 != r103) goto L25;
        return r103;
    L25:
        kub.a r122 = r116;
        int r123 = r112;
        r102 = r121;
        int r124 = r117;
        r113 = r115;
        r109 = r124;
    L27:
        if (((Boolean) r102).booleanValue() == false) goto L31;
        return Unit.INSTANCE;
    L31:
        if (r124 >= 2) goto L37;
        r100.L$0 = r122;
        r100.I$0 = r123;
        r100.I$1 = r113;
        r100.I$2 = r109;
        r100.label = 2;
        if (DelayKt.delay(1000, r100) != r103) goto L35;
        return r103;
    L35:
        r105 = r109;
        r106 = r113;
        r107 = r123;
        r108 = r122;
        goto L36
    L37:
        r112 = r123;
        r108 = r122;
        goto L38
    L40:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r124 = r100.I$3;
        r109 = r100.I$2;
        r113 = r100.I$1;
        r123 = r100.I$0;
        r122 = (kub.a) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r110 = this;
        goto L27
    L16:
        ResultKt.throwOnFailure(r102);
        r116 = (kub.a) this.f434538a.u(kub.a.class);
        if (r116 != null) goto L20;
        lvb.a.b(this.f434539b, "[showQuotaDialog] quota dependency is null, denyType=" + r210);
        return Unit.INSTANCE;
    L20:
        r112 = r210;
        r115 = 3;
        r117 = 0;
        r110 = this;
    L7:
        r100 = new MmRecordingMeetingCreateFailureHandler$showQuotaDialog$1(this, r211);
        goto L8
    }

    public final Object a(Throwable r100, RecordingSessionType r101, Continuation<? super Unit> r102) {
        e r103 = e.f434593a;
        String r104 = null;
        Object r105 = null;
        if ((r100 instanceof ErrorResult) == false) goto L5;
        ErrorResult r106 = (ErrorResult) r100;
    L6:
        r103.getClass();
        if (r106 == null) goto L9;
        Integer r107 = Integer.valueOf(r106.getCode());
    L10:
        if (r107 != null) goto L13;
    L18:
        if (r107 != null) goto L21;
    L23:
        if (r106 == null) goto L25;
        String r108 = r106.getDebugMsg();
    L26:
        boolean r109 = true;
        if (r108 != null) goto L29;
    L32:
        boolean r110 = true;
    L33:
        if (r110 == false) goto L82;
    L51:
        if (r104 == null) goto L53;
        Object r111 = new d.e(r104);
    L55:
        if (Intrinsics.areEqual(r111, d.c.f434590a) == false) goto L57;
    L76:
        Object r112 = Unit.INSTANCE;
    L78:
        if (r112 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L81;
        return r112;
    L81:
        return Unit.INSTANCE;
    L57:
        if (Intrinsics.areEqual(r111, d.b.f434589a) == false) goto L60;
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.d(R.string.MMWeb_NoKeyNoRecord_Toast);
        goto L76
    L60:
        if (Intrinsics.areEqual(r111, d.a.f434588a) == false) goto L66;
        if (r101 != RecordingSessionType.STANDALONE_AI_INTERPRETATION) goto L64;
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.d(R.string.View_AIInterpret_AIInterpretationServiceFailure_Toast);
        goto L76
    L64:
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.d(R.string.MMWeb_AfterMeetWin_FailToRecord_Toast);
        goto L76
    L66:
        if ((r111 instanceof d.e) == false) goto L69;
        MmRecordingUILaunchMode r113 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.f434029a;
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.e(((d.e) r111).f434592a);
        goto L76
    L69:
        if ((r111 instanceof d.C5174d) == false) goto L75;
        r112 = b(((d.C5174d) r111).f434591a, r102);
        if (r112 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L78;
        r112 = Unit.INSTANCE;
        goto L78
    L75:
        throw new NoWhenBranchMatchedException();
    L53:
        r111 = d.a.f434588a;
        goto L55
    L82:
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L44
        String r115 = JSONObjectProtectorUtils.getString(new JSONObject(r108), "message");     // Catch: Throwable -> L44
        Intrinsics.checkNotNull(r115);     // Catch: Throwable -> L44
        if (r115.length() > 0) goto L39;
        r109 = false;
    L39:
        if (r109 == true) goto L42;
        r115 = null;
    L42:
        Object r116 = Result.m9449constructorimpl(r115);     // Catch: Throwable -> L44
    L47:
        if (Result.m9455isFailureimpl(r116) == true) goto L50;
        r105 = r116;
    L50:
        r104 = (String) r105;
    L44:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L47
    L29:
        if (r108.length() == 0) goto L32;
        r110 = false;
        goto L33
    L25:
        r108 = null;
        goto L26
    L21:
        if (r107.intValue() != 220204) goto L23;
        r111 = d.b.f434589a;
        goto L55
    L13:
        if (r107.intValue() != 220202) goto L18;
        Integer r118 = e.b(r106);
        if (r118 == null) goto L17;
        r111 = new d.C5174d(r118.intValue());
        goto L55
    L17:
        r111 = d.c.f434590a;
        goto L55
    L9:
        r107 = null;
        goto L10
    L5:
        r106 = null;
        goto L6
    }
}
