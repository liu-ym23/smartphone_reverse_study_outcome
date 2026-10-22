package com.bytedance.ee.bear.bitable.jsapi.common;

import android.util.Base64;
import com.alibaba.fastjson.JSONObject;
import com.ss.android.lark.audio.recorder.ErrorInfo;
import java.nio.ByteBuffer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements com.ss.android.lark.audio.recorder.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<JSONObject, Unit> f214392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f214393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f214394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f214395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f214396e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<AudioRecordHelper.AudioErrorType> f214397f;

    @Override // com.ss.android.lark.audio.recorder.k
    public final void a1() {
        tt5.a.h("AudioRecordHelper", "onStartRecord");
        this.f214392a.invoke(AudioRecordHelper.b(AudioRecordHelper.f214330a, AudioRecordHelper.AudioRecordState.PREPARE, null, null, 6));
    }

    @Override // com.ss.android.lark.audio.recorder.k
    public final void j() {
        tt5.a.h("AudioRecordHelper", "onAudioRecordSilenced");
    }

    @Override // com.ss.android.lark.audio.recorder.k
    public final void m() {
        tt5.a.h("AudioRecordHelper", "onStopRecord, lastDurationMs=" + this.f214396e.element);
        Ref.BooleanRef r100 = this.f214393b;
        if (r100.element == false) goto L5;
        return;
    L5:
        r100.element = true;
        if (this.f214395d.element == false) goto L13;
        Function1<JSONObject, Unit> r101 = this.f214392a;
        AudioRecordHelper r102 = AudioRecordHelper.f214330a;
        AudioRecordHelper.AudioRecordState r103 = AudioRecordHelper.AudioRecordState.FAILED;
        AudioRecordHelper.AudioErrorType r104 = this.f214397f.element;
        if (r104 != null) goto L10;
        r104 = AudioRecordHelper.AudioErrorType.OTHER;
    L10:
        r101.invoke(AudioRecordHelper.b(r102, r103, null, r104, 2));
        r102.f();
        return;
    L13:
        if (this.f214396e.element >= 1000) goto L15;
        AudioRecordHelper.AudioRecordState r105 = AudioRecordHelper.AudioRecordState.TOO_SHORT;
    L16:
        AudioRecordHelper r106 = AudioRecordHelper.f214330a;
        this.f214392a.invoke(AudioRecordHelper.b(r106, r105, null, null, 6));
        r106.f();
        return;
    L15:
        r105 = AudioRecordHelper.AudioRecordState.SUCCESS;
        goto L16
    }

    @Override // com.ss.android.lark.audio.recorder.k
    public final void n() {
        tt5.a.h("AudioRecordHelper", "onPauseRecord");
    }

    @Override // com.ss.android.lark.audio.recorder.k
    public final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "recordingDevice");
    }

    @Override // com.ss.android.lark.audio.recorder.k
    public final void h(ByteBuffer r100) {
        Intrinsics.checkNotNullParameter(r100, "pcmData");
        tt5.a.h("AudioRecordHelper", "onFrameRecorded ignored");
    }

    /* JADX WARN: Type inference failed for: r6v10, types: [T, com.bytedance.ee.bear.bitable.jsapi.common.AudioRecordHelper$AudioErrorType] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v20 */
    @Override // com.ss.android.lark.audio.recorder.k
    public final void i(ErrorInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "errorInfo");
        tt5.a.h("AudioRecordHelper", "onTerminateRecord: " + r100);
        Ref.BooleanRef r101 = this.f214393b;
        if (r101.element == false) goto L5;
        return;
    L5:
        r101.element = true;
        AudioRecordHelper r102 = AudioRecordHelper.f214330a;
        if (r100 != null) goto L8;
        int r103 = -1;
    L9:
        switch(r103) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L11;
            case 8: goto L11;
            default: goto L10;
        };
    L10:
        ?? r104 = AudioRecordHelper.AudioErrorType.OTHER;
    L17:
        this.f214395d.element = true;
        this.f214397f.element = r104;
        this.f214392a.invoke(AudioRecordHelper.b(r102, AudioRecordHelper.AudioRecordState.FAILED, null, r104, 2));
        r102.f();
        return;
    L11:
        r104 = AudioRecordHelper.AudioErrorType.START_FAILED;
        goto L17
    L12:
        r104 = AudioRecordHelper.AudioErrorType.TRY_LOCK_FAILED;
        goto L17
    L13:
        r104 = AudioRecordHelper.AudioErrorType.DATA_EMPTY;
        goto L17
    L14:
        r104 = AudioRecordHelper.AudioErrorType.IN_MEETING;
        goto L17
    L15:
        r104 = AudioRecordHelper.AudioErrorType.IN_CALLING;
        goto L17
    L16:
        r104 = AudioRecordHelper.AudioErrorType.NO_PERMISSION;
        goto L17
    L8:
        r103 = AudioRecordHelper.b.f214339a[r100.ordinal()];
        goto L9
    }

    @Override // com.ss.android.lark.audio.recorder.k
    public final void l(ByteBuffer r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "buffer");
        tt5.a.h("AudioRecordHelper", "onBeforeEncode, len=" + r101);
    }

    @Override // com.ss.android.lark.audio.recorder.k
    public final void k(int r100, double r101, ByteBuffer r102, ByteBuffer r103) {
        if (this.f214393b.element == false) goto L5;
        return;
    L5:
        if (AudioRecordHelper.f214333d == false) goto L8;
        return;
    L8:
        if (this.f214394c.element == false) goto L10;
    L12:
        this.f214396e.element = r100;
        tt5.a.h("AudioRecordHelper", "onUpdateRecordData, duration=" + r100);
        if (r102 != null) goto L15;
    L37:
        AudioRecordHelper.a(this.f214395d, this.f214397f, this.f214392a, this.f214394c);
        tt5.a.h("AudioRecordHelper", "onUpdateRecordData, pcmData is null or empty");
        return;
    L15:
        if (r102.hasRemaining() == false) goto L37;
        AudioRecordHelper r104 = AudioRecordHelper.f214330a;
        if (r102.hasRemaining() == true) goto L39;
        tt5.a.h("AudioRecordHelper", "encodePcmToBase64, pcmData is null or empty");
    L23:
        String r105 = null;
    L25:
        if (r105 != null) goto L27;
    L30:
        boolean r106 = true;
    L31:
        if (r106 == true) goto L36;
        Ref.BooleanRef r107 = this.f214394c;
        if (r107.element == true) goto L35;
        r107.element = true;
        this.f214392a.invoke(AudioRecordHelper.b(AudioRecordHelper.f214330a, AudioRecordHelper.AudioRecordState.START, null, null, 6));
    L35:
        this.f214392a.invoke(AudioRecordHelper.b(AudioRecordHelper.f214330a, AudioRecordHelper.AudioRecordState.RECORDING, r105, null, 4));
        return;
    L36:
        AudioRecordHelper.a(this.f214395d, this.f214397f, this.f214392a, this.f214394c);
        tt5.a.h("AudioRecordHelper", "onUpdateRecordData, base64 is null or empty");
        return;
    L27:
        if (r105.length() == 0) goto L30;
        r106 = false;
        goto L31
    L39:
        ByteBuffer r108 = r102.duplicate();     // Catch: Throwable -> L21
        byte[] r109 = new byte[r108.remaining()];     // Catch: Throwable -> L21
        r108.get(r109);     // Catch: Throwable -> L21
        r105 = Base64.encodeToString(r109, 2);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        tt5.a.d("AudioRecordHelper", "encodePcmToBase64 error: " + th);
        goto L23
    L10:
        if (this.f214395d.element == false) goto L12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(Function1<? super JSONObject, Unit> r100, Ref.BooleanRef r101, Ref.BooleanRef r102, Ref.BooleanRef r103, Ref.IntRef r104, Ref.ObjectRef<AudioRecordHelper.AudioErrorType> r105) {
        this.f214392a = r100;
        this.f214393b = r101;
        this.f214394c = r102;
        this.f214395d = r103;
        this.f214396e = r104;
        this.f214397f = r105;
    }
}
