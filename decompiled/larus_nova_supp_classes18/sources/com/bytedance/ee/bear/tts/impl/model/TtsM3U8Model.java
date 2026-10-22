package com.bytedance.ee.bear.tts.impl.model;

import android.os.SystemClock;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.tts.TtsLoadScene;
import com.bytedance.ee.bear.tts.TtsResult;
import com.bytedance.ee.bear.tts.m3u8.TtsM3U8Bean;
import com.bytedance.ee.bear.tts.tone.TtsToneBean;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class TtsM3U8Model {
    public final String a;
    public final int b;
    public TtsM3U8Bean c;
    public boolean d;
    public long e;
    public final List<qo5.b> f;
    public Throwable g;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ee/bear/tts/impl/model/TtsM3U8Model$TtsM3U8Result;", "Lcom/bytedance/ee/bear/contract/Result;", "Lcom/bytedance/ee/bear/tts/m3u8/TtsM3U8Bean;", "<init>", "()V", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TtsM3U8Result extends Result<TtsM3U8Bean> {
        public TtsM3U8Result() {
        }
    }

    public static final class a {
    }

    public static final class b implements NetService.c<TtsM3U8Result> {
        public final String a;
        public final int b;
        public final String c;

        public final Result parse(String r11) {
            tt5.a.h("TtsM3U8Model", "TtsM3U8Parser-parse, docToken: " + du5.b.i(this.a) + ", docType: " + this.b + ", requestSegmentId: " + du5.b.i(this.c) + ", json: " + r11);
        L10:
            JSONObject r12 = new JSONObject();
        L11:
            TtsM3U8Result r0 = new TtsM3U8Result();
            TtsM3U8Bean r1 = new TtsM3U8Bean();
            r1.taskId = r12.optString("task_id");
            r1.revisionId = r12.optInt("revision_id", 0);
            r1.downloadLink = r12.optString("play_list");
            r1.mainLanguageCode = r12.optString("content_lang");
            double r6 = r12.optDouble("expire_at", 0.0d);
            double r8 = CCMLynxCardView.ViewType.BANNER;
            r1.expireTimeMS = (long) (r6 * r8);
            r1.isServerComplete = r12.optBoolean("is_all_complete", false);
            r1.serverPredictDurationMs = (long) (r12.optDouble("perdict_duration", 0.0d) * r8);
            r1.serverRealDurationMs = (long) (r12.optDouble("real_duration", 0.0d) * r8);
            r1.segmentFirstOffsetMs = (long) (r12.optDouble("begin_duration", 0.0d) * r8);
            r1.anchorSegmentId = this.c;
            r1.anchorSegmentOffsetMs = (long) (r12.optDouble("block_begin_duration", 0.0d) * r8);
            JSONObject r13 = r12.optJSONObject("speaker");
            if (r13 == null) goto L14;
            TtsToneBean r2 = new TtsToneBean();
            r2.setToneId(r13.optString("speaker_id"));
            r2.setToneName(r13.optString("name"));
            r1.toneBean = r2;
        L14:
            ((Result) r0).data = r1;
            return r0;
        L4:
            if (r11 != null) goto L6;
            r11 = "";
        L6:
            r12 = new JSONObject(r11).optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: Exception -> L10
            if (r12 != null) goto L11;
            r12 = new JSONObject();     // Catch: Exception -> L10
            goto L11
        }

        public b(String r2, int r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "docToken");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ i<Pair<? extends TtsM3U8Bean, ? extends Throwable>> a;

        public c(j r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            TtsM3U8Result r5 = (TtsM3U8Result) r4;
            if (this.a.isActive() == false) goto L6;
            tt5.a.h("TtsM3U8Model", "reload-RX_next, get respond success");
            i<Pair<? extends TtsM3U8Bean, ? extends Throwable>> r0 = this.a;
            kotlin.Result.Companion r1 = kotlin.Result.Companion;
            r0.resumeWith(kotlin.Result.constructor-impl(new Pair(((Result) r5).data, null)));
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ i<Pair<? extends TtsM3U8Bean, ? extends Throwable>> a;

        public d(j r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            if (this.a.isActive() == false) goto L6;
            tt5.a.e("TtsM3U8Model", "reload-RX_error, get respond failed:", r5, false);
            i<Pair<? extends TtsM3U8Bean, ? extends Throwable>> r0 = this.a;
            kotlin.Result.Companion r1 = kotlin.Result.Companion;
            r0.resumeWith(kotlin.Result.constructor-impl(new Pair(null, r5)));
            return;
        }
    }

    public static final class e implements Action {
        public final /* synthetic */ i<Pair<? extends TtsM3U8Bean, ? extends Throwable>> a;

        public e(j r1) {
            this.a = r1;
        }

        public final void run() {
            if (this.a.isActive() == false) goto L6;
            tt5.a.h("TtsM3U8Model", "reload-RX_complete");
            i<Pair<? extends TtsM3U8Bean, ? extends Throwable>> r0 = this.a;
            kotlin.Result.Companion r1 = kotlin.Result.Companion;
            r0.resumeWith(kotlin.Result.constructor-impl(new Pair(null, null)));
            return;
        }
    }

    static {
    }

    public final TtsResult b() {
        Throwable r0 = this.g;
        if (r0 == null) goto L18;
        NetService.ServerErrorException r3 = null;
        if ((r0 instanceof NetService.ServerErrorException) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L18;
        if ((r0 instanceof NetService.ServerErrorException) == false) goto L12;
        r3 = (NetService.ServerErrorException) r0;
    L12:
        if (r3 == null) goto L18;
        if (r3.getCode() != 400003) goto L18;
        tt5.a.k("TtsM3U8Model", "getAccessResult, server error code: 400003, server limit.");
        return new TtsResult(TtsResult.ModelCode.M3U8_SERVER_LIMIT);
    L18:
        if (this.c == null) goto L20;
        tt5.a.h("TtsM3U8Model", "getAccessResult, success");
        return TtsResult.d;
    L20:
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == false) goto L22;
        tt5.a.k("TtsM3U8Model", "getAccessResult, network connected but m3u8Bean is null.");
        return new TtsResult(TtsResult.ModelCode.M3U8_INVALID);
    L22:
        tt5.a.k("TtsM3U8Model", "getAccessResult, network not connected.");
        return new TtsResult(TtsResult.AccessCode.NETWORK_ERROR);
    }

    public final long c() {
        TtsM3U8Bean r0 = this.c;
        if (r0 != null) goto L7;
        tt5.a.k("TtsM3U8Model", "getFixedTotalDurationMs, m3u8Bean is null.");
        return 0;
    L7:
        if (r0.isSegmentComplete == false) goto L13;
        long r3 = r0.segmentSumDurationMs;
        if (r3 <= 0) goto L13;
        return r0.segmentFirstOffsetMs + r3;
    L13:
        if (r0.isServerComplete == false) goto L18;
        long r4 = r0.serverRealDurationMs;
        if (r4 <= 0) goto L18;
        return r4;
    L18:
        return r0.serverPredictDurationMs;
    }

    public final qo5.b a(long r11) {
        List<qo5.b> r0 = this.f;
        qo5.b r2 = null;
        if ((!r0.isEmpty()) == true) goto L7;
        r0 = null;
    L7:
        if (r0 != null) goto L10;
        tt5.a.k("TtsM3U8Model", "findSegmentForTimeMs, segmentList is empty.");
        return null;
    L10:
        TtsM3U8Bean r3 = this.c;
        if (r3 == null) goto L13;
        long r4 = r3.segmentFirstOffsetMs;
    L15:
        if (r4 <= r11) goto L18;
        tt5.a.k("TtsM3U8Model", "findSegmentForTimeMs, segmentFirstOffsetMs(" + r4 + ") > timeMs(" + r11 + "), return.");
        return null;
    L18:
        long r5 = SystemClock.elapsedRealtimeNanos();
        Iterator<qo5.b> r1 = r0.iterator();
    L20:
        if (r1.hasNext() == false) goto L27;
        qo5.b r7 = r1.next();
        if (r7 == null) goto L20;
        r4 = r4 + r7.e;
        if (r4 < r11) goto L20;
        r2 = r7;
    L27:
        tt5.a.b("TtsM3U8Model", "findSegmentForTimeMs, time cost: " + (SystemClock.elapsedRealtimeNanos() - r5));
        return r2;
    L13:
        r4 = 0;
        goto L15
    }

    public final void d(boolean r7) {
        TtsM3U8Bean r0 = this.c;
        if (r0 != null) goto L6;
        tt5.a.k("TtsM3U8Model", "onM3U8Updated, m3u8Bean is null.");
        return;
    L6:
        Iterator<T> r1 = this.f.iterator();
        long r2 = 0;
    L8:
        if (r1.hasNext() == false) goto L10;
        r2 = r2 + ((qo5.b) r1.next()).e;
        goto L8
    L10:
        r0.isSegmentComplete = r7;
        r0.segmentSumDurationMs = r2;
        if (r7 == false) goto L15;
        r0.serverPredictDurationMs = r0.segmentFirstOffsetMs + r2;
        return;
    }

    public TtsM3U8Model(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "docToken");
        this.a = r2;
        this.b = r3;
        this.f = new ArrayList();
    }

    public final Object e(TtsLoadScene r4, qo5.a r5, Continuation<? super Job> r6) {
        return BuildersKt.withContext(Dispatchers.getIO(), new TtsM3U8Model$preload$2(r5, r4, this, null), r6);
    }

    public final Object f(TtsLoadScene r19, qo5.a r20, Continuation<? super TtsM3U8Bean> r21) {
        if ((r21 instanceof TtsM3U8Model$reload$1) == false) goto L7;
        TtsM3U8Model$reload$1 r4 = (TtsM3U8Model$reload$1) r21;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        if (r7 == 0) goto L14;
        if (r7 != 1) goto L13;
        long r1 = r4.J$0;
        Ref.ObjectRef r8 = (Ref.ObjectRef) r4.L$2;
        NetService.f r9 = (NetService.f) r4.L$1;
        String r10 = (String) r4.L$0;
        ResultKt.throwOnFailure(r3);
        Object r11 = r3;
    L66:
        Pair r12 = (Pair) r11;
        Disposable r13 = (Disposable) r8.element;
        if (r13 == null) goto L69;
        r13.dispose();
    L69:
        this.c = (TtsM3U8Bean) r12.getFirst();
        this.g = (Throwable) r12.getSecond();
        this.d = true;
        this.e = SystemClock.elapsedRealtime() - r1;
        return this.c;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r3);
        long r14 = SystemClock.elapsedRealtime();
        if (r20 == null) goto L27;
        Long r15 = Boxing.boxLong(r20.b);
        if (r15.longValue() <= 0) goto L19;
        boolean r16 = true;
    L20:
        if (r16 == true) goto L23;
        r15 = null;
    L23:
        if (r15 == null) goto L27;
        qo5.b r17 = a(r15.longValue());
        if (r17 == null) goto L27;
        String r18 = r17.a;
    L28:
        NetService.f r110 = new NetService.f("/api/aiextension/tts/hls/playlist");
        ((NetService.e) r110).c = 1;
        JSONObject r111 = new JSONObject();
        r111.putOpt(ResourceData.KEY_OBJ_TOKEN, this.a);
        r111.putOpt("obj_type", Boxing.boxInt(this.b));
        r111.putOpt("scene", Boxing.boxInt(r19.getServerScene()));
        if (r20 == null) goto L31;
        String r22 = r20.a;
    L32:
        r111.putOpt("speaker_id", r22);
        if (r20 == null) goto L44;
        Long r23 = Boxing.boxLong(r20.b);
        if (r23.longValue() <= 0) goto L37;
        boolean r24 = true;
    L38:
        if (r24 == true) goto L41;
        r23 = null;
    L41:
        if (r23 == null) goto L44;
        long r25 = r23.longValue();
        r111.putOpt("begin_block_id", r18);
        r111.putOpt("begin_duration", Boxing.boxLong(r25 / ((long) CCMLynxCardView.ViewType.BANNER)));
        goto L44
    L37:
        r24 = false;
    L44:
        if (r19 != TtsLoadScene.SWITCH_TONE) goto L46;
    L47:
        TtsM3U8Bean r26 = this.c;
        if (r26 == null) goto L50;
        Integer r27 = Boxing.boxInt(r26.revisionId);
    L51:
        r111.putOpt("revision_id", r27);
    L52:
        ((NetService.e) r110).j = r111.toString();
        StringBuilder r28 = new StringBuilder("reload, scene: ");
        r28.append(r19);
        r28.append(", serverScene: ");
        r28.append(r19.getServerScene());
        r28.append(", requestSegmentId: ");
        r28.append(du5.b.i(r18));
        r28.append(", fromTimeMs: ");
        if (r20 == null) goto L55;
        Long r2 = Boxing.boxLong(r20.b);
    L56:
        r28.append(r2);
        r28.append(", revisionId: ");
        TtsM3U8Bean r29 = this.c;
        if (r29 == null) goto L59;
        Integer r30 = Boxing.boxInt(r29.revisionId);
    L60:
        r28.append(r30);
        tt5.a.h("TtsM3U8Model", r28.toString());
        final Ref.ObjectRef r31 = new Ref.ObjectRef();
        r4.L$0 = r18;
        r4.L$1 = r110;
        r4.L$2 = r31;
        r4.J$0 = r14;
        r4.label = 1;
        j r32 = new j(IntrinsicsKt.intercepted(r4), 1);
        r32.C();
        r31.element = ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new b(this.a, this.b, r18)).a(r110).subscribe(new c(r32), new d(r32), new e(r32));
        r32.i(new TtsM3U8Model$reload$resultPair$1$4(r31));
        Object r33 = r32.B();
        if (r33 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L63;
        DebugProbesKt.probeCoroutineSuspended(r4);
    L63:
        if (r33 != r6) goto L65;
        return r6;
    L65:
        r8 = r31;
        r11 = r33;
        r1 = r14;
        goto L66
    L59:
        r30 = null;
        goto L60
    L55:
        r2 = null;
        goto L56
    L50:
        r27 = null;
        goto L51
    L46:
        if (r19 != TtsLoadScene.SEEK_BACKWARD) goto L52;
    L31:
        r22 = null;
        goto L32
    L19:
        r16 = false;
    L27:
        r18 = null;
    L7:
        r4 = new TtsM3U8Model$reload$1(this, r21);
        goto L8
    }
}
