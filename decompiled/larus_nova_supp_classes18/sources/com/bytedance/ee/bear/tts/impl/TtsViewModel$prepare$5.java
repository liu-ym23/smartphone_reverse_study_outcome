package com.bytedance.ee.bear.tts.impl;

import android.net.Uri;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.drive.services.w;
import com.bytedance.ee.bear.middleground.drive.export.player.IPlayer;
import com.bytedance.ee.bear.tts.TtsLoadScene;
import com.bytedance.ee.bear.tts.TtsResult;
import com.bytedance.ee.bear.tts.m3u8.TtsM3U8Bean;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.media.Scene;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ee/bear/tts/TtsResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.tts.impl.TtsViewModel$prepare$5", f = "TtsViewModel.kt", i = {}, l = {250}, m = "invokeSuspend", n = {}, s = {})
public final class TtsViewModel$prepare$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super TtsResult>, Object> {
    final /* synthetic */ TtsLoadScene $scene;
    int label;
    final /* synthetic */ TtsViewModel this$0;

    public TtsViewModel$prepare$5(TtsViewModel r1, TtsLoadScene r2, Continuation<? super TtsViewModel$prepare$5> r3) {
        this.this$0 = r1;
        this.$scene = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new TtsViewModel$prepare$5(this.this$0, this.$scene, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super TtsResult> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r25) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r25);
        Object r3 = r25;
    L11:
        TtsResult r4 = (TtsResult) r3;
        if (r4.a() == false) goto L82;
        TtsViewModel r5 = this.this$0;
        if (r5.z == null) goto L17;
        tt5.a.h("TtsViewModel", r5.d + " preparePlayer, player not null.");
        TtsResult r1 = TtsResult.d;
    L16:
        r4 = r1;
        to5.a r6 = this.this$0.t;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r4, "result");
        r6.h = "prepare_player";
        r6.c(new to5.j());
        goto L82
    L17:
        TtsM3U8Bean r7 = r5.u.c;
        if (r7 == null) goto L80;
        String r8 = r7.downloadLink;
        if (r8 == null) goto L80;
        Uri r9 = UriProtector.parse(r8);     // Catch: Exception -> L23
    L25:
        if (r9 == null) goto L80;
        String r10 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2().token;
        if (r10 != null) goto L30;
        r10 = "";
    L30:
        tt5.a.h("TtsViewModel", r5.d + " preparePlayer, m3u8Uri: " + r9 + ", userSession: " + r10);
        IPlayer r11 = ((w) org.koin.java.a.c(w.class, null, null, 6)).l8(LarkContext.getApplication());
        r11.c(MapsKt.mapOf(TuplesKt.to("Cookie", "session=".concat(r10))));
        r11.d();
        r11.g((sf5.b) r5.g.getValue());
        r11.f(Scene.CCM_Audio_Play);
        r11.h().observeForever((Observer) r5.i.getValue());
        r11.b(r9);
        so5.a r12 = r5.x.d;
        if (r12 == null) goto L33;
        long r13 = r12.j;
    L35:
        if (r12 == null) goto L37;
        float r14 = r12.k;
    L38:
        TtsM3U8Bean r15 = r5.u.c;
        if (r15 == null) goto L41;
        long r16 = r15.segmentFirstOffsetMs;
    L42:
        if (r12 == null) goto L44;
        long r17 = r12.i;
    L45:
        tt5.a.h("TtsViewModel", "preparePlayer, m3u8Uri: " + r9 + ", lastProgressMs: " + r13 + ", lastSpeed: " + r14 + ", segmentFirstOffsetMs: " + r16 + ", totalDuration: " + r17);
        Long r18 = Long.valueOf(r13 - r16);
        if (r18.longValue() <= 0) goto L48;
        boolean r19 = true;
    L49:
        if (r19 == true) goto L52;
        r18 = null;
    L52:
        if (r18 != null) goto L54;
    L62:
        long r110 = 0;
    L64:
        if (r110 > 0) goto L66;
        tt5.a.h("TtsViewModel", r5.d + " preparePlayer, start from 0");
    L67:
        long r20 = RangesKt.coerceIn(r110 + r16, 0, r17);
        r5.l.setValue(Long.valueOf(r20));
        r5.m.setValue(r5.u.a(r20));
        IPlayer.State r21 = (IPlayer.State) r5.k.getValue();
        if (r21 == null) goto L70;
        r5.k.setValue(r21);
    L70:
        Float r22 = Float.valueOf(r14);
        if (r22.floatValue() <= 0.0f) goto L73;
        boolean r23 = true;
    L74:
        if (r23 == false) goto L76;
        Float r24 = r22;
    L77:
        if (r24 == null) goto L79;
        r11.setSpeed(r24.floatValue());
    L79:
        r5.z = r11;
        com.bytedance.ee.bear.tts.operation.e r26 = new com.bytedance.ee.bear.tts.operation.e(r5.z);
        tt5.a.h("TtsViewModel", r5.d + " preparePlayer, preload");
        r5.z().b(r26);
        r1 = TtsResult.d;
        goto L16
    L76:
        r24 = null;
        goto L77
    L73:
        r23 = false;
        goto L74
    L66:
        tt5.a.h("TtsViewModel", r5.d + " preparePlayer, set startTime to: " + r110);
        r11.setStartTime((int) r110);
        goto L67
    L54:
        if ((r17 - r18.longValue()) < 5000) goto L56;
        boolean r27 = true;
    L57:
        if (r27 == true) goto L60;
        r18 = null;
    L60:
        if (r18 == null) goto L62;
        r110 = r18.longValue();
        goto L64
    L56:
        r27 = false;
        goto L57
    L48:
        r19 = false;
        goto L49
    L44:
        r17 = 0;
        goto L45
    L41:
        r16 = 0;
        goto L42
    L37:
        r14 = 0.0f;
        goto L38
    L33:
        r13 = 0;
    L23:
        e = move-exception;
        tt5.a.e("TtsViewModel", r5.d + " preparePlayer, parse URI failed, m3u8 downloadLink: " + r8, e, false);
        r9 = null;
    L80:
        tt5.a.d("TtsViewModel", r5.d + " preparePlayer, m3u8 downloadLink unavailable");
        r1 = new TtsResult(TtsResult.ModelCode.M3U8_LINK_INVALID);
    L82:
        return r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r25);
        TtsViewModel r28 = this.this$0;
        int r29 = TtsViewModel.E;
        r28.u.d = false;
        r28.v.d = false;
        r28.w.d = false;
        r28.y.d = false;
        TtsLoadScene r30 = this.$scene;
        this.label = 1;
        r28.getClass();
        r3 = BuildersKt.withContext(Dispatchers.getIO(), new TtsViewModel$prepareModel$2(r28, r30, null), this);
        if (r3 != r0) goto L11;
        return r0;
    }
}
