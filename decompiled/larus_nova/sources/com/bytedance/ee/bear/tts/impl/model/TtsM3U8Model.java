package com.bytedance.ee.bear.tts.impl.model;

import android.os.SystemClock;
import androidx.camera.video.AudioStats;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.tts.TtsLoadScene;
import com.bytedance.ee.bear.tts.TtsResult;
import com.bytedance.ee.bear.tts.m3u8.TtsM3U8Bean;
import com.bytedance.ee.bear.tts.tone.TtsToneBean;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.MmEndWindowAvatar;
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

/* JADX INFO: loaded from: classes18.dex */
public final class TtsM3U8Model {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f239574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f239575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TtsM3U8Bean f239576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f239577d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f239578e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<qo5.b> f239579f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Throwable f239580g;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ee/bear/tts/impl/model/TtsM3U8Model$TtsM3U8Result;", "Lcom/bytedance/ee/bear/contract/Result;", "Lcom/bytedance/ee/bear/tts/m3u8/TtsM3U8Bean;", "<init>", "()V", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TtsM3U8Result extends Result<TtsM3U8Bean> {
        public TtsM3U8Result() {
        }
    }

    public static final class a {
    }

    public static final class b implements NetService.c<TtsM3U8Result> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f239581a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f239582b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f239583c;

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result parse(String r110) {
            tt5.a.h("TtsM3U8Model", "TtsM3U8Parser-parse, docToken: " + du5.b.i(this.f239581a) + ", docType: " + this.f239582b + ", requestSegmentId: " + du5.b.i(this.f239583c) + ", json: " + r110);
        L10:
            JSONObject r111 = new JSONObject();
        L11:
            TtsM3U8Result r100 = new TtsM3U8Result();
            TtsM3U8Bean r101 = new TtsM3U8Bean();
            r101.taskId = r111.optString("task_id");
            r101.revisionId = r111.optInt("revision_id", 0);
            r101.downloadLink = r111.optString("play_list");
            r101.mainLanguageCode = r111.optString("content_lang");
            double r102 = 1000;
            r101.expireTimeMS = (long) (r111.optDouble("expire_at", AudioStats.AUDIO_AMPLITUDE_NONE) * r102);
            r101.isServerComplete = r111.optBoolean("is_all_complete", false);
            r101.serverPredictDurationMs = (long) (r111.optDouble("perdict_duration", AudioStats.AUDIO_AMPLITUDE_NONE) * r102);
            r101.serverRealDurationMs = (long) (r111.optDouble("real_duration", AudioStats.AUDIO_AMPLITUDE_NONE) * r102);
            r101.segmentFirstOffsetMs = (long) (r111.optDouble("begin_duration", AudioStats.AUDIO_AMPLITUDE_NONE) * r102);
            r101.anchorSegmentId = this.f239583c;
            r101.anchorSegmentOffsetMs = (long) (r111.optDouble("block_begin_duration", AudioStats.AUDIO_AMPLITUDE_NONE) * r102);
            JSONObject r112 = r111.optJSONObject(MmEndWindowAvatar.TYPE_SPEAKER);
            if (r112 == null) goto L14;
            TtsToneBean r103 = new TtsToneBean();
            r103.setToneId(r112.optString("speaker_id"));
            r103.setToneName(r112.optString("name"));
            r101.toneBean = r103;
        L14:
            r100.data = r101;
            return r100;
        L4:
            if (r110 != null) goto L6;
            r110 = "";
        L6:
            r111 = new JSONObject(r110).optJSONObject("data");     // Catch: Exception -> L10
            if (r111 != null) goto L11;
            r111 = new JSONObject();     // Catch: Exception -> L10
            goto L11
        }

        public b(String r100, int r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "docToken");
            this.f239581a = r100;
            this.f239582b = r101;
            this.f239583c = r102;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i<Pair<? extends TtsM3U8Bean, ? extends Throwable>> f239584a;

        public c(j r100) {
            this.f239584a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            TtsM3U8Result r101 = (TtsM3U8Result) r100;
            if (this.f239584a.isActive() == false) goto L6;
            tt5.a.h("TtsM3U8Model", "reload-RX_next, get respond success");
            i<Pair<? extends TtsM3U8Bean, ? extends Throwable>> r102 = this.f239584a;
            kotlin.Result.Companion r103 = kotlin.Result.Companion;
            r102.resumeWith(kotlin.Result.m9449constructorimpl(new Pair(r101.data, null)));
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i<Pair<? extends TtsM3U8Bean, ? extends Throwable>> f239585a;

        public d(j r100) {
            this.f239585a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            if (this.f239585a.isActive() == false) goto L6;
            tt5.a.e("TtsM3U8Model", "reload-RX_error, get respond failed:", r101, false);
            i<Pair<? extends TtsM3U8Bean, ? extends Throwable>> r102 = this.f239585a;
            kotlin.Result.Companion r103 = kotlin.Result.Companion;
            r102.resumeWith(kotlin.Result.m9449constructorimpl(new Pair(null, r101)));
            return;
        }
    }

    public static final class e implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i<Pair<? extends TtsM3U8Bean, ? extends Throwable>> f239586a;

        public e(j r100) {
            this.f239586a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            if (this.f239586a.isActive() == false) goto L6;
            tt5.a.h("TtsM3U8Model", "reload-RX_complete");
            i<Pair<? extends TtsM3U8Bean, ? extends Throwable>> r100 = this.f239586a;
            kotlin.Result.Companion r101 = kotlin.Result.Companion;
            r100.resumeWith(kotlin.Result.m9449constructorimpl(new Pair(null, null)));
            return;
        }
    }

    static {
    }

    public final TtsResult b() {
        Throwable r100 = this.f239580g;
        if (r100 == null) goto L18;
        NetService.ServerErrorException r101 = null;
        if ((r100 instanceof NetService.ServerErrorException) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L18;
        if ((r100 instanceof NetService.ServerErrorException) == false) goto L12;
        r101 = (NetService.ServerErrorException) r100;
    L12:
        if (r101 == null) goto L18;
        if (r101.getCode() != 400003) goto L18;
        tt5.a.k("TtsM3U8Model", "getAccessResult, server error code: 400003, server limit.");
        return new TtsResult(TtsResult.ModelCode.M3U8_SERVER_LIMIT);
    L18:
        if (this.f239576c == null) goto L20;
        tt5.a.h("TtsM3U8Model", "getAccessResult, success");
        return TtsResult.f239449d;
    L20:
        if (com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a() == false) goto L22;
        tt5.a.k("TtsM3U8Model", "getAccessResult, network connected but m3u8Bean is null.");
        return new TtsResult(TtsResult.ModelCode.M3U8_INVALID);
    L22:
        tt5.a.k("TtsM3U8Model", "getAccessResult, network not connected.");
        return new TtsResult(TtsResult.AccessCode.NETWORK_ERROR);
    }

    public final long c() {
        TtsM3U8Bean r100 = this.f239576c;
        if (r100 != null) goto L7;
        tt5.a.k("TtsM3U8Model", "getFixedTotalDurationMs, m3u8Bean is null.");
        return 0;
    L7:
        if (r100.isSegmentComplete == false) goto L13;
        long r101 = r100.segmentSumDurationMs;
        if (r101 <= 0) goto L13;
        return r100.segmentFirstOffsetMs + r101;
    L13:
        if (r100.isServerComplete == false) goto L18;
        long r102 = r100.serverRealDurationMs;
        if (r102 <= 0) goto L18;
        return r102;
    L18:
        return r100.serverPredictDurationMs;
    }

    public final qo5.b a(long r110) {
        List<qo5.b> r100 = this.f239579f;
        qo5.b r101 = null;
        if ((!r100.isEmpty()) == true) goto L7;
        r100 = null;
    L7:
        if (r100 != null) goto L10;
        tt5.a.k("TtsM3U8Model", "findSegmentForTimeMs, segmentList is empty.");
        return null;
    L10:
        TtsM3U8Bean r102 = this.f239576c;
        if (r102 == null) goto L13;
        long r103 = r102.segmentFirstOffsetMs;
    L15:
        if (r103 <= r110) goto L18;
        tt5.a.k("TtsM3U8Model", "findSegmentForTimeMs, segmentFirstOffsetMs(" + r103 + ") > timeMs(" + r110 + "), return.");
        return null;
    L18:
        long r104 = SystemClock.elapsedRealtimeNanos();
        Iterator<qo5.b> r105 = r100.iterator();
    L20:
        if (r105.hasNext() == false) goto L27;
        qo5.b r106 = r105.next();
        if (r106 == null) goto L20;
        r103 = r103 + r106.f534181e;
        if (r103 < r110) goto L20;
        r101 = r106;
    L27:
        tt5.a.b("TtsM3U8Model", "findSegmentForTimeMs, time cost: " + (SystemClock.elapsedRealtimeNanos() - r104));
        return r101;
    L13:
        r103 = 0;
        goto L15
    }

    public final void d(boolean r100) {
        TtsM3U8Bean r101 = this.f239576c;
        if (r101 != null) goto L6;
        tt5.a.k("TtsM3U8Model", "onM3U8Updated, m3u8Bean is null.");
        return;
    L6:
        Iterator<T> r102 = this.f239579f.iterator();
        long r103 = 0;
    L8:
        if (r102.hasNext() == false) goto L10;
        r103 = r103 + ((qo5.b) r102.next()).f534181e;
        goto L8
    L10:
        r101.isSegmentComplete = r100;
        r101.segmentSumDurationMs = r103;
        if (r100 == false) goto L15;
        r101.serverPredictDurationMs = r101.segmentFirstOffsetMs + r103;
        return;
    }

    public TtsM3U8Model(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "docToken");
        this.f239574a = r100;
        this.f239575b = r101;
        this.f239579f = new ArrayList();
    }

    public final Object e(TtsLoadScene r100, qo5.a r101, Continuation<? super Job> r102) {
        return BuildersKt.withContext(Dispatchers.getIO(), new TtsM3U8Model$preload$2(r101, r100, this, null), r102);
    }

    /* JADX WARN: Type inference failed for: r2v8, types: [T, io.reactivex.disposables.Disposable] */
    public final Object f(TtsLoadScene r110, qo5.a r210, Continuation<? super TtsM3U8Bean> r211) {
        if ((r211 instanceof TtsM3U8Model$reload$1) == false) goto L7;
        TtsM3U8Model$reload$1 r100 = (TtsM3U8Model$reload$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        long r105 = r100.J$0;
        Ref.ObjectRef r106 = (Ref.ObjectRef) r100.L$2;
        NetService.f r107 = (NetService.f) r100.L$1;
        String r108 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        Object r109 = r102;
    L66:
        Pair r111 = (Pair) r109;
        Disposable r112 = (Disposable) r106.element;
        if (r112 == null) goto L69;
        r112.dispose();
    L69:
        this.f239576c = (TtsM3U8Bean) r111.getFirst();
        this.f239580g = (Throwable) r111.getSecond();
        this.f239577d = true;
        this.f239578e = SystemClock.elapsedRealtime() - r105;
        return this.f239576c;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        long r113 = SystemClock.elapsedRealtime();
        if (r210 == null) goto L27;
        Long r114 = Boxing.boxLong(r210.f534170b);
        if (r114.longValue() <= 0) goto L19;
        boolean r115 = true;
    L20:
        if (r115 == true) goto L23;
        r114 = null;
    L23:
        if (r114 == null) goto L27;
        qo5.b r116 = a(r114.longValue());
        if (r116 == null) goto L27;
        String r117 = r116.f534177a;
    L28:
        NetService.f r118 = new NetService.f("/api/aiextension/tts/hls/playlist");
        r118.f216906c = 1;
        JSONObject r119 = new JSONObject();
        r119.putOpt("obj_token", this.f239574a);
        r119.putOpt("obj_type", Boxing.boxInt(this.f239575b));
        r119.putOpt("scene", Boxing.boxInt(r110.getServerScene()));
        if (r210 == null) goto L31;
        String r120 = r210.f534169a;
    L32:
        r119.putOpt("speaker_id", r120);
        if (r210 == null) goto L44;
        Long r121 = Boxing.boxLong(r210.f534170b);
        if (r121.longValue() <= 0) goto L37;
        boolean r122 = true;
    L38:
        if (r122 == true) goto L41;
        r121 = null;
    L41:
        if (r121 == null) goto L44;
        long r123 = r121.longValue();
        r119.putOpt("begin_block_id", r117);
        r119.putOpt("begin_duration", Boxing.boxLong(r123 / ((long) 1000)));
        goto L44
    L37:
        r122 = false;
    L44:
        if (r110 != TtsLoadScene.SWITCH_TONE) goto L46;
    L47:
        TtsM3U8Bean r124 = this.f239576c;
        if (r124 == null) goto L50;
        Integer r125 = Boxing.boxInt(r124.revisionId);
    L51:
        r119.putOpt("revision_id", r125);
    L52:
        r118.f216913j = r119.toString();
        StringBuilder r126 = new StringBuilder("reload, scene: ");
        r126.append(r110);
        r126.append(", serverScene: ");
        r126.append(r110.getServerScene());
        r126.append(", requestSegmentId: ");
        r126.append(du5.b.i(r117));
        r126.append(", fromTimeMs: ");
        if (r210 == null) goto L55;
        Long r127 = Boxing.boxLong(r210.f534170b);
    L56:
        r126.append(r127);
        r126.append(", revisionId: ");
        TtsM3U8Bean r128 = this.f239576c;
        if (r128 == null) goto L59;
        Integer r129 = Boxing.boxInt(r128.revisionId);
    L60:
        r126.append(r129);
        tt5.a.h("TtsM3U8Model", r126.toString());
        final Ref.ObjectRef r130 = new Ref.ObjectRef();
        r100.L$0 = r117;
        r100.L$1 = r118;
        r100.L$2 = r130;
        r100.J$0 = r113;
        r100.label = 1;
        j r131 = new j(IntrinsicsKt.intercepted(r100), 1);
        r131.C();
        r130.element = ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new b(this.f239574a, this.f239575b, r117)).a(r118).subscribe(new c(r131), new d(r131), new e(r131));
        r131.i(new TtsM3U8Model$reload$resultPair$1$4(r130));
        Object r132 = r131.B();
        if (r132 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L63;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L63:
        if (r132 != r103) goto L65;
        return r103;
    L65:
        r106 = r130;
        r109 = r132;
        r105 = r113;
        goto L66
    L59:
        r129 = null;
        goto L60
    L55:
        r127 = null;
        goto L56
    L50:
        r125 = null;
        goto L51
    L46:
        if (r110 != TtsLoadScene.SEEK_BACKWARD) goto L52;
    L31:
        r120 = null;
        goto L32
    L19:
        r115 = false;
    L27:
        r117 = null;
    L7:
        r100 = new TtsM3U8Model$reload$1(this, r211);
        goto L8
    }
}
