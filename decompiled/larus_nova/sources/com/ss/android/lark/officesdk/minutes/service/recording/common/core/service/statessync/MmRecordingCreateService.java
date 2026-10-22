package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.utils.NetworkUtils;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoBizInfo;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.thread.MMCoroutines;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.request.http.MmCreateAudioRequest;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmCreateAudioResponse;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmNetworkUtils;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.exception.MmCreateRecordingException;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final class MmRecordingCreateService {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Companion f434414j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f434415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f434416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f434417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f434418d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CoroutineScope f434419e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Job f434420f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f434421g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Deferred f434422h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final StateFlowImpl f434423i;

    public static final class Companion {
        public Companion() {
        }

        public final Object a(com.ss.android.lark.officesdk.minutes.service.foundation.network.b r110, String r111, String r112, int r113, MmCreateAudioRequest.CreateMinutesStatus r210, DoubaoBizInfo r211, MmRecordingSource r212, String r213, boolean r214, Continuation<? super Result<MmCreateAudioResponse>> r215) {
            if ((r215 instanceof MmRecordingCreateService$Companion$sendCreateRecordingObjectRequest$1) == false) goto L7;
            MmRecordingCreateService$Companion$sendCreateRecordingObjectRequest$1 r100 = (MmRecordingCreateService$Companion$sendCreateRecordingObjectRequest$1) r215;
            int r101 = r100.label;
            if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
            r100.label = r101 - Integer.MIN_VALUE;
        L8:
            Object r102 = r100.result;
            Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r104 = r100.label;
            if (r104 == 0) goto L14;
            if (r104 != 1) goto L13;
            ResultKt.throwOnFailure(r102);
            return ((Result) r102).m9458unboximpl();
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r102);
            MmCreateAudioRequest r105 = new MmCreateAudioRequest(r111, r112, r113, r210, r211, r212, r213, r214);
            r100.label = 1;
            Object r106 = r110.c(MmCreateAudioResponse.class, r105, r100);
            if (r106 != r103) goto L18;
            return r103;
        L18:
            return r106;
        L7:
            r100 = new MmRecordingCreateService$Companion$sendCreateRecordingObjectRequest$1(this, r215);
            goto L8
        }
    }

    public interface a {
        void a(Object r100);

        void b(Object r100);
    }

    static {
        f434414j = new Companion();
    }

    public MmRecordingCreateService(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r100) {
        Intrinsics.checkNotNullParameter(r100, "userComponentContext");
        Intrinsics.checkNotNullParameter(r100, "userComponentContext");
        this.f434415a = r100;
        this.f434416b = 5000;
        String r101 = "MmRecordingCreateService_" + hashCode();
        this.f434418d = r101;
        CoroutineScope r102 = CoroutineScopeKt.CoroutineScope(MMCoroutines.a().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.f434419e = r102;
        this.f434423i = j1.a(Boolean.TRUE);
        Object r103 = MmNetworkUtils.f434041a;
        this.f434420f = MmNetworkUtils.c("createAudio", r102, 500, new AnonymousClass1(this));
        lvb.a.e(r101, "Network state listener registered");
    }

    public static final void b(MmRecordingCreateService r110, String r111, Throwable r210) {
        r110.getClass();
        String r100 = null;
        if ((r210 instanceof MmCreateRecordingException.MmRecordingOtherException) == false) goto L5;
        MmCreateRecordingException.MmRecordingOtherException r101 = (MmCreateRecordingException.MmRecordingOtherException) r210;
    L6:
        if (r101 == null) goto L8;
        Integer r102 = Integer.valueOf(r101.getErrorCode());
    L9:
        qvb.a r103 = qvb.a.f534934a;
        if (r210 == null) goto L12;
        String r104 = r210.getMessage();
    L13:
        if (r104 != null) goto L15;
    L18:
        boolean r105 = true;
    L19:
        if (r105 == false) goto L21;
        String r106 = r111;
    L26:
        if (r210 == null) goto L28;
        r100 = r210.getClass().getSimpleName();
    L28:
        if (r100 != null) goto L30;
        String r107 = "";
    L31:
        Intrinsics.checkNotNullParameter(r106, "errorMsg");
        Intrinsics.checkNotNullParameter(r107, "responseName");
        Intrinsics.checkNotNullParameter("error", "severity");
        qvb.a.c(r103, "creation", "error", r102, r106, r107, null, null, null, null, null, null, Boolean.valueOf(NetworkUtils.d(LarkContext.getApplication())), null, 6112);
        return;
    L30:
        r107 = r100;
        goto L31
    L21:
        StringBuilder r108 = new StringBuilder();
        r108.append(r111);
        r108.append(':');
        if (r210 == null) goto L24;
        String r109 = r210.getMessage();
    L25:
        r108.append(r109);
        r106 = r108.toString();
        goto L26
    L24:
        r109 = null;
        goto L25
    L15:
        if (StringsKt.isBlank(r104) == true) goto L18;
        r105 = false;
        goto L19
    L12:
        r104 = null;
        goto L13
    L8:
        r102 = null;
        goto L9
    L5:
        r101 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object c(String r210, int r211, Function0<? extends MmCreateAudioRequest.CreateMinutesStatus> r212, DoubaoBizInfo r213, MmRecordingSource r214, String r215, boolean r216, Continuation<? super String> r217) {
        if ((r217 instanceof MmRecordingCreateService$createRecordObjectWithAdvancedRetry$1) == false) goto L7;
        MmRecordingCreateService$createRecordObjectWithAdvancedRetry$1 r100 = (MmRecordingCreateService$createRecordObjectWithAdvancedRetry$1) r217;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        MmRecordingCreateService$createRecordObjectWithAdvancedRetry$1 r110 = r100;
        Object r102 = r110.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r110.label;
        if (r103 == 0) goto L18;
        if (r103 != 1) goto L17;
        Deferred r104 = (Deferred) r110.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L14
        r103 = r104;
    L36:
        String r105 = (String) r102;     // Catch: Throwable -> L14
        if (this.f434422h != r103) goto L40;
        this.f434422h = null;
    L40:
        return r105;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r102);
        if (r210.length() != 0) goto L21;
        boolean r106 = true;
    L22:
        if (r106 == false) goto L25;
        lvb.a.b(this.f434418d, "createMinutesTokenWithAdvancedRetry failed: meetingId is empty");
        qvb.a.g("meeting_id_empty", "create_minutes_token", null, 9);
        return null;
    L25:
        String r107 = this.f434418d;
        StringBuilder r108 = new StringBuilder("createMinutesTokenWithAdvancedRetry meetingId:");
        r108.append(r210);
        r108.append(", createAudioStatus: ");
        if (r212 == null) goto L28;
        MmCreateAudioRequest.CreateMinutesStatus r109 = r212.invoke();
    L29:
        r108.append(r109);
        lvb.a.e(r107, r108.toString());
        Deferred r112 = this.f434422h;
        if (r112 == null) goto L32;
        Job.DefaultImpls.cancel$default(r112, null, 1, null);
    L32:
        this.f434422h = null;
        this.f434421g = r210;
        Deferred r113 = BuildersKt.async$default(this.f434419e, null, CoroutineStart.LAZY, new MmRecordingCreateService$createRecordObjectWithAdvancedRetry$result$1(this, r211, r210, r212, r213, r214, r215, r216, null), 1, null);
        this.f434422h = r113;
        r113.start();
        r110.L$0 = r113;     // Catch: Throwable -> L14
        r110.label = 1;     // Catch: Throwable -> L14
        r102 = r113.await(r110);     // Catch: Throwable -> L14
        r103 = r113;
        if (r102 != r111) goto L36;
        return r111;
    L28:
        r109 = null;
        goto L29
    L21:
        r106 = false;
    L14:
        th = move-exception;
        if (this.f434422h != r103) goto L44;
        this.f434422h = null;
    L44:
        throw th;
    L7:
        r100 = new MmRecordingCreateService$createRecordObjectWithAdvancedRetry$1(this, r217);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17, types: [com.larksuite.framework.callback.Entity.ErrorResult, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v48 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [com.larksuite.framework.callback.Entity.ErrorResult] */
    /* JADX WARN: Type inference failed for: r5v6 */
    public static final Object a(MmRecordingCreateService r110, com.ss.android.lark.officesdk.minutes.service.foundation.network.b r111, String r112, MmCreateAudioRequest.CreateMinutesStatus r210, DoubaoBizInfo r211, MmRecordingSource r212, String r213, boolean r214, Continuation r215) {
        r110.getClass();
        if ((r215 instanceof MmRecordingCreateService$createMinutesTokenOnce$1) == false) goto L7;
        MmRecordingCreateService$createMinutesTokenOnce$1 r100 = (MmRecordingCreateService$createMinutesTokenOnce$1) r215;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        MmRecordingCreateService$createMinutesTokenOnce$1 r113 = r100;
        Object r102 = r113.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r113.label;
        boolean r114 = false;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        boolean r105 = r113.Z$0;
        String r106 = (String) r113.L$2;
        MmRecordingSource r107 = (MmRecordingSource) r113.L$1;
        DoubaoBizInfo r108 = (DoubaoBizInfo) r113.L$0;
        ResultKt.throwOnFailure(r102);
        Object r109 = ((Result) r102).m9458unboximpl();
        DoubaoBizInfo r115 = r108;
    L27:
        String r116 = null;
        Object r117 = null;
        Object r118 = null;
        Integer r119 = null;
        if (Result.m9455isFailureimpl(r109) == false) goto L30;
        Object r120 = null;
    L31:
        MmCreateAudioResponse r121 = (MmCreateAudioResponse) r120;
        if (r121 == null) goto L35;
        r121.normalizeObjectToken();
    L35:
        if (Result.m9455isFailureimpl(r109) == false) goto L37;
        Object r122 = null;
    L38:
        MmCreateAudioResponse r123 = (MmCreateAudioResponse) r122;
        if (r123 == null) goto L41;
        boolean r124 = r123.getCanAudioCreateRetry();
    L43:
        if (Result.m9455isFailureimpl(r109) == false) goto L45;
        Object r125 = null;
    L46:
        MmCreateAudioResponse r126 = (MmCreateAudioResponse) r125;
        String r127 = "";
        if (r126 == null) goto L50;
        String r128 = r126.getObjectToken();
        if (r128 == null) goto L50;
    L52:
        if (Result.m9455isFailureimpl(r109) == false) goto L54;
        Object r129 = null;
    L55:
        MmCreateAudioResponse r130 = (MmCreateAudioResponse) r129;
        if (r130 == null) goto L65;
        String r131 = r130.getRecordingId();
        if (r131 == null) goto L65;
        if ((!StringsKt.isBlank(r131)) == true) goto L63;
        r131 = null;
    L63:
        if (r131 == null) goto L65;
    L75:
        if (r105 == false) goto L89;
        if (r131.length() <= 0) goto L79;
        boolean r132 = true;
    L80:
        if (r132 == false) goto L89;
        if (Result.m9455isFailureimpl(r109) == true) goto L85;
        r117 = r109;
    L85:
        MmCreateAudioResponse r133 = (MmCreateAudioResponse) r117;
        if (r133 == null) goto L211;
        r133.setRecordingId(r131);
    L211:
        return r109;
    L79:
        r132 = false;
    L89:
        if (r128.length() <= 0) goto L91;
        boolean r134 = true;
    L92:
        if (r134 == true) goto L211;
        Intrinsics.areEqual(OfficeSDKManager.isDebug(), Boxing.boxBoolean(true));
        Throwable r135 = Result.m9452exceptionOrNullimpl(r109);
        if ((r135 instanceof ErrorResult) == false) goto L97;
        ?? r136 = (ErrorResult) r135;
    L98:
        lvb.a.b(r110.f434418d, "errorResult:" + r136);
        if (Result.m9456isSuccessimpl(r109) == false) goto L108;
        if (r124 == true) goto L108;
        qvb.a r137 = qvb.a.f534934a;
        if (r107 == null) goto L104;
        String r138 = r107.name();
    L105:
        if (r138 != null) goto L107;
        r138 = "";
    L107:
        qvb.a.g("create_minutes_token_empty_result", r138, null, 9);
        goto L108
    L104:
        r138 = null;
    L108:
        c r139 = c.f434459a;
        if (r128.length() != 0) goto L111;
        boolean r140 = true;
    L112:
        r139.getClass();
        boolean r141 = c.b(r136);
        if (r136 != 0) goto L115;
    L117:
        boolean r142 = false;
    L118:
        if (r142 == true) goto L127;
        if (r136 != 0) goto L121;
    L123:
        boolean r143 = false;
    L124:
        if (r143 == true) goto L127;
        boolean r144 = false;
    L128:
        if (r144 == false) goto L158;
        MmCreateRecordingException.MmRecordingNoQuotaException r145 = new MmCreateRecordingException.MmRecordingNoQuotaException();
        if (r136 == 0) goto L132;
        String r146 = r136.getDebugMsg();
    L133:
        String r147 = c.a(r146);
        if (r147 != null) goto L209;
    L152:
        if (r119 == null) goto L154;
        b r148 = new b.d(r119.intValue());
    L155:
        if (r141 == false) goto L157;
        r148 = b.c.f434456a;
    L157:
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.a r149 = new com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.a(r145, r148);
    L208:
        return Result.m9449constructorimpl(ResultKt.createFailure(r149.f434452a));
    L154:
        r148 = b.a.f434454a;
        goto L155
    L209:
        JSONObject r150 = new JSONObject(r147);     // Catch: Throwable -> L145
        if (r150.has("deny_type") == false) goto L140;
        Integer r151 = Integer.valueOf(r150.optInt("deny_type"));     // Catch: Throwable -> L145
    L143:
        Object r152 = Result.m9449constructorimpl(r151);     // Catch: Throwable -> L145
    L148:
        if (Result.m9455isFailureimpl(r152) == true) goto L151;
        r118 = r152;
    L151:
        r119 = (Integer) r118;
        goto L152
    L140:
        if (r150.has("denyType") == false) goto L142;
        r151 = Integer.valueOf(r150.optInt("denyType"));     // Catch: Throwable -> L145
        goto L143
    L142:
        r151 = null;
    L145:
        th = move-exception;
        Result.Companion r153 = Result.Companion;
        r152 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L148
    L132:
        r146 = null;
        goto L133
    L158:
        if (r136 != 0) goto L160;
    L162:
        boolean r154 = false;
    L163:
        if (r154 == false) goto L168;
        MmCreateRecordingException.MmRecordingCreateFailedException r155 = new MmCreateRecordingException.MmRecordingCreateFailedException();
        b r156 = b.C5171b.f434455a;
        if (r141 == false) goto L167;
        r156 = b.c.f434456a;
    L167:
        r149 = new com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.a(r155, r156);
        goto L208
    L168:
        if (r136 != 0) goto L170;
    L172:
        if (r114 == false) goto L174;
        r149 = new com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.a(new MmCreateRecordingException.MmRecordingOccupiedException(), b.c.f434456a);
        goto L208
    L174:
        if (r140 == false) goto L198;
        if (r124 == true) goto L198;
        MmCreateRecordingException.MmRecordingCreateFailedException r157 = new MmCreateRecordingException.MmRecordingCreateFailedException();
        boolean r158 = r136 instanceof ErrorResult;
        if (r158 == false) goto L179;
        ?? r159 = r136;
    L181:
        if (c.b(r159) == false) goto L183;
        b r160 = b.c.f434456a;
    L194:
        if (r141 == false) goto L196;
        r160 = b.c.f434456a;
    L196:
        r149 = new com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.a(r157, r160);
        goto L208
    L183:
        if (r158 == false) goto L186;
        r116 = r136.getDebugMsg();
    L190:
        String r161 = c.a(r116);
        if (r161 == null) goto L193;
        r160 = new b.e(r161);
        goto L194
    L193:
        r160 = b.a.f434454a;
        goto L194
    L186:
        if ((r136 instanceof MmCreateRecordingException.MmRecordingOtherException) == false) goto L188;
        r116 = ((MmCreateRecordingException.MmRecordingOtherException) r136).getErrorMsg();
        goto L190
    L188:
        if (r136 == 0) goto L190;
        r116 = r136.getMessage();
        goto L190
    L179:
        r159 = 0;
    L198:
        if (r136 == 0) goto L200;
        int r162 = r136.getCode();
    L201:
        if (r136 == 0) goto L206;
        String r163 = r136.getDebugMsg();
        if (r163 == null) goto L206;
        r127 = r163;
    L206:
        r149 = new com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.a(new MmCreateRecordingException.MmRecordingOtherException(r162, r127), b.c.f434456a);
        goto L208
    L200:
        r162 = -1;
        goto L201
    L170:
        if (r136.getCode() != 409) goto L172;
        r114 = true;
        goto L172
    L160:
        if (r136.getCode() != 220204) goto L162;
        r154 = true;
        goto L163
    L121:
        if (r136.getStatus() != 1007) goto L123;
        r143 = true;
    L127:
        r144 = true;
        goto L128
    L115:
        if (r136.getCode() != 220202) goto L117;
        r142 = true;
        goto L118
    L111:
        r140 = false;
        goto L112
    L97:
        r136 = 0;
        goto L98
    L91:
        r134 = false;
    L65:
        if ((!StringsKt.isBlank(r106)) == true) goto L68;
        r106 = null;
    L68:
        if (r106 != null) goto L74;
        if (r115 == null) goto L71;
        r131 = r115.getRecordingId();
    L72:
        if (r131 != null) goto L75;
        r131 = "";
        goto L75
    L71:
        r131 = null;
        goto L72
    L74:
        r131 = r106;
        goto L75
    L54:
        r129 = r109;
    L50:
        r128 = "";
        goto L52
    L45:
        r125 = r109;
        goto L46
    L41:
        r124 = true;
        goto L43
    L37:
        r122 = r109;
        goto L38
    L30:
        r120 = r109;
        goto L31
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        int r164 = r110.f434415a.getSettingsService().f434077h.getSliceDurationInSec();
        if (1 <= r164) goto L17;
    L19:
        boolean r165 = false;
    L20:
        if (r165 == false) goto L22;
        int r166 = r164;
    L23:
        Companion r167 = f434414j;
        String r168 = UIHelper.getString(R.string.MMWeb_G_UntitledRecording);
        r115 = r211;
        r113.L$0 = r115;
        r113.L$1 = r212;
        r113.L$2 = r213;
        r113.Z$0 = r214;
        r113.label = 1;
        Object r169 = r167.a(r111, r112, r168, r166, r210, r211, r212, r213, r214, r113);
        if (r169 == r103) goto L212;
        r107 = r212;
        r105 = r214;
        r109 = r169;
        r106 = r213;
        goto L27
    L212:
        return r103;
    L22:
        r166 = 3;
        goto L23
    L17:
        if (r164 >= 61) goto L19;
        r165 = true;
    L7:
        r100 = new MmRecordingCreateService$createMinutesTokenOnce$1(r110, r215);
        goto L8
    }
}
