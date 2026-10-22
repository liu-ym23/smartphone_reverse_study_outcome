package com.bytedance.android.livesdk.ktvimpl.base.component.midi;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.ktv.common.model.api.g0;
import com.bytedance.android.live.ktv.common.music.download.KtvMusicManager;
import com.bytedance.android.live.ktv.common.music.download.z;
import com.bytedance.android.live.ktv.common.util.KtvCommonConfigParams;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.config.cm0;
import com.bytedance.android.livesdk.config.of1;
import com.bytedance.android.livesdk.config.p40;
import com.bytedance.android.livesdk.config.z8;
import com.bytedance.android.livesdk.ktvimpl.base.api.KtvRoomApi;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0013\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t*\u0002or\u0018\u0000 |2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001}B\u000f\u0012\u0006\u0010v\u001a\u00020u¢\u0006\u0004\bz\u0010{J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J6\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0015\u001a\u00020\fH\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J \u0010$\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\"H\u0002J\b\u0010%\u001a\u00020\u0006H\u0002J\b\u0010&\u001a\u00020\u0006H\u0007J\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010'\u001a\u00020\u000fH\u0016J \u0010.\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010-2\u0006\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u000fH\u0016J&\u00100\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0-\u0018\u00010/2\u0006\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u000fH\u0016J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u00102\u001a\u000201H\u0016J\u0017\u00103\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b3\u00104J\u000e\u00105\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u000fJ\u000e\u00106\u001a\u00020\u00062\u0006\u00102\u001a\u000201J(\u00109\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\u0006\u00108\u001a\u000207J\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"0:J\b\u0010<\u001a\u00020\u0006H\u0014J\u0010\u0010?\u001a\u00020\u00062\u0006\u0010>\u001a\u00020=H\u0016J\b\u0010@\u001a\u00020\u0006H\u0016J\b\u0010A\u001a\u00020\u0006H\u0016J\b\u0010B\u001a\u00020\u0006H\u0016J\u0010\u0010C\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u000fH\u0016R\u0016\u0010D\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010F\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010H\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\"\u0010J\u001a\u00020\"8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010 \u001a\u00020\"8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b \u0010K\u001a\u0004\bP\u0010M\"\u0004\bQ\u0010OR\"\u0010R\u001a\u00020\f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bR\u0010E\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u0014\u0010X\u001a\u00020W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010Z\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010\\\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010[R\u0016\u0010]\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010_\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010GR\u0016\u0010`\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010IR\u0016\u0010a\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010KR\u0016\u0010c\u001a\u00020b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR%\u0010f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020)\u0018\u00010-0e8\u0006¢\u0006\f\n\u0004\bf\u0010g\u001a\u0004\bh\u0010iR*\u0010k\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010j0e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bk\u0010g\u001a\u0004\bl\u0010i\"\u0004\bm\u0010nR+\u00102\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u001e0:0e8\u0006¢\u0006\f\n\u0004\b2\u0010g\u001a\u0004\b\u001f\u0010iR\u0014\u0010p\u001a\u00020o8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010qR\u0014\u0010s\u001a\u00020r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010tR\u0017\u0010v\u001a\u00020u8\u0006¢\u0006\f\n\u0004\bv\u0010w\u001a\u0004\bx\u0010y¨\u0006~"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/component/midi/KaraokeMidiViewModel;", "Landroidx/lifecycle/ViewModel;", "Ldb0/a;", "", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "musicPanel", "", "tryInitMidiRes", "fillMidiAndLyricPath", "fetchMidiConfig", "Lio/reactivex/disposables/Disposable;", "disposable", "", "isDisposed", "cancelDispose", "", "musicId", "", "midiPath", "lyricsPath", "vocalPath", "isLrcLyric", "initMidiRes", "resetMidiData", "disposeMidiDisposable", "progress", "seekMidiScoreProgress", "", "calTotalScore", "calSentenceScore", "Lcom/bytedance/android/live/ktv/common/midi/k;", "getScoreInfo", "totalScore", "sentenceScore", "", "index", "calScore", "clearData", "onCreate", "curPlayTime", "Lio/reactivex/Observable;", "Lcb0/c;", "findMidiSegment", "startTime", "endTime", "", "findMidiSegmentsNew", "Lio/reactivex/Single;", "findMidiSegments", "", "scoreInfo", "tryStartGetScoreInfoTimer", "(Ljava/lang/Long;)V", "seekLyricPos", "getMidiScoreInfo", "", "startMs", "setScoringSources", "Lkotlin/Pair;", "calcToneRange", "onCleared", "Lcom/bytedance/android/livesdk/ktvimpl/base/a;", "param", "startMusic", "stopMusic", "playMusic", "pauseMusic", "seekMusic", "isInitMidiRes", "Z", "calFactorSetting", "F", "scoreTimeSetting", "J", "curTotalScore", "I", "getCurTotalScore", "()I", "setCurTotalScore", "(I)V", "getTotalScore", "setTotalScore", "userOpenScore", "getUserOpenScore", "()Z", "setUserOpenScore", "(Z)V", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDispose", "Lio/reactivex/disposables/CompositeDisposable;", "midiDisposable", "Lio/reactivex/disposables/Disposable;", "scoreDisposable", "scoreInfoArr", "[D", "curScore", "curMidiProgress", "lastMidiIndex", "Lcom/bytedance/android/live/ktv/common/midi/b;", "hitComboCalculator", "Lcom/bytedance/android/live/ktv/common/midi/b;", "Landroidx/lifecycle/MutableLiveData;", "midiData", "Landroidx/lifecycle/MutableLiveData;", "getMidiData", "()Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/live/ktv/common/model/api/g0;", "midiConfig", "getMidiConfig", "setMidiConfig", "(Landroidx/lifecycle/MutableLiveData;)V", "com/bytedance/android/livesdk/ktvimpl/base/component/midi/KaraokeMidiViewModel$midiDataObserver$1", "midiDataObserver", "Lcom/bytedance/android/livesdk/ktvimpl/base/component/midi/KaraokeMidiViewModel$midiDataObserver$1;", "com/bytedance/android/livesdk/ktvimpl/base/component/midi/KaraokeMidiViewModel$n", "musicDownloadCallback", "Lcom/bytedance/android/livesdk/ktvimpl/base/component/midi/KaraokeMidiViewModel$n;", "Lmd2/a;", "midiRunContext", "Lmd2/a;", "getMidiRunContext", "()Lmd2/a;", "<init>", "(Lmd2/a;)V", "Companion", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KaraokeMidiViewModel extends ViewModel implements db0.a {
    public static final a Companion = null;
    private static final long SHAKE_RANGE = 0;
    public static final String TAG = "KaraokeMidiViewModel";
    private final float calFactorSetting;
    private final CompositeDisposable compositeDispose;
    private long curMidiProgress;
    private float curScore;
    private int curTotalScore;
    private com.bytedance.android.live.ktv.common.midi.b hitComboCalculator;
    private boolean isInitMidiRes;
    private int lastMidiIndex;
    private MutableLiveData<g0> midiConfig;
    private final MutableLiveData<List<cb0.c>> midiData;
    private final KaraokeMidiViewModel$midiDataObserver$1 midiDataObserver;
    private Disposable midiDisposable;
    private final md2.a midiRunContext;
    private final n musicDownloadCallback;
    private Disposable scoreDisposable;
    private final MutableLiveData<Pair<Long, com.bytedance.android.live.ktv.common.midi.k>> scoreInfo;
    private double[] scoreInfoArr;
    private final long scoreTimeSetting;
    private int totalScore;
    private boolean userOpenScore;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ KaraokeMidiViewModel a;

        public b(KaraokeMidiViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            MutableLiveData<g0> r0 = this.a.getMidiConfig();
            com.bytedance.android.live.ktv.common.model.api.g r3 = (com.bytedance.android.live.ktv.common.model.api.g) ((BaseResponse) ((Response) r2)).data;
            if (r3 == null) goto L5;
            g0 r4 = r3.a();
        L6:
            r0.setValue(r4);
            return;
        L5:
            r4 = null;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {
        public c(KaraokeMidiViewModel r1) {
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            ALogger.i(bb0.b.b(), "fetchMidiConfig fail, invoke class :KaraokeMidiViewModel");
        }
    }

    public static final class d<T> implements Predicate {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final boolean test(Object r2) {
            List r3 = (List) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return !r3.isEmpty();
        }
    }

    public static final class e<T, R> implements Function {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final Object apply(Object r2) {
            List r3 = (List) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return Observable.fromIterable(r3);
        }
    }

    public static final class f<T> implements Predicate {
        public final /* synthetic */ long a;

        public f(long r1) {
            this.a = r1;
        }

        public final boolean test(Object r6) {
            cb0.c r7 = (cb0.c) r6;
            Intrinsics.checkNotNullParameter(r7, "it");
            cb0.a r8 = r7.a;
            long r0 = r8.a;
            long r2 = this.a;
            if (r0 < r2) goto L5;
        L7:
            return false;
        L5:
            if (r8.b < r2) goto L7;
            return true;
        }
    }

    public static final class g<T> implements Predicate {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final boolean test(Object r2) {
            List r3 = (List) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return !r3.isEmpty();
        }
    }

    public static final class h<T, R> implements Function {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
        }

        public final Object apply(Object r2) {
            List r3 = (List) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return Observable.fromIterable(r3);
        }
    }

    public static final class i<T> implements Predicate {
        public final /* synthetic */ long a;
        public final /* synthetic */ long b;

        public i(long r1, long r3) {
            this.a = r1;
            this.b = r3;
        }

        public final boolean test(Object r6) {
            cb0.c r7 = (cb0.c) r6;
            Intrinsics.checkNotNullParameter(r7, "it");
            cb0.a r8 = r7.a;
            if (r8.a < this.a) goto L5;
        L7:
            return false;
        L5:
            if (r8.b <= this.b) goto L7;
            return true;
        }
    }

    public static final class j<T> implements SingleOnSubscribe {
        public final /* synthetic */ KaraokeMidiViewModel a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public j(KaraokeMidiViewModel r1, String r2, String r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void subscribe(SingleEmitter<Integer> r8) {
            Intrinsics.checkNotNullParameter(r8, "emitter");
            String r3 = this.b;
            if (r3 == null) goto L5;
            int r0 = this.a.setScoringSources(this.c, r3, this.d, 0.0d);
        L7:
            if (r8.isDisposed() == false) goto L10;
            KaraokeMidiViewModel.access$setInitMidiRes$p(this.a, false);
            return;
        L10:
            if (r0 == 0) goto L12;
            md2.e.a(KaraokeMidiViewModel.TAG, "initMidiRes fail result " + r0);
            r8.tryOnError(new Exception("init midi error: " + r0));
            return;
        L12:
            r8.onSuccess(Integer.valueOf(r0));
            return;
        L5:
            r0 = -1;
            goto L7
        }
    }

    public static final class k<T, R> implements Function {
        public final /* synthetic */ KaraokeMidiViewModel a;

        public k(KaraokeMidiViewModel r1, String r2) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter((Integer) r2, "result");
            if (vm2.h.d() == false) goto L13;
            com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r3 = this.a.getMidiRunContext().c();
            if (r3 == null) goto L7;
            com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b r4 = r3.k();
        L8:
            if (r4 == null) goto L10;
            r4.j();
        L16:
            return null;
        L10:
            ILiveWrappedLivePusher.Companion.getClass();
            ILiveWrappedLivePusher r5 = ILiveWrappedLivePusher.a.b();
            if (r5 == null) goto L16;
            r5.getLiveCoreKaraokFilter();
            goto L16
        L7:
            r4 = null;
            goto L8
        L13:
            ILiveWrappedLivePusher.Companion.getClass();
            ILiveWrappedLivePusher r6 = ILiveWrappedLivePusher.a.b();
            if (r6 == null) goto L16;
            r6.getLiveCoreKaraokFilter();
            goto L16
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ KaraokeMidiViewModel a;

        public l(KaraokeMidiViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            List r5 = (List) r4;
            StringBuilder r0 = new StringBuilder("initMidiRes success, segments count: ");
            if (r5 == null) goto L5;
            int r2 = r5.size();
        L6:
            r0.append(r2);
            md2.e.a(KaraokeMidiViewModel.TAG, r0.toString());
            this.a.getMidiData().setValue(r5);
            KaraokeMidiViewModel.access$setInitMidiRes$p(this.a, false);
            return;
        L5:
            r2 = 0;
            goto L6
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ KaraokeMidiViewModel a;
        public final /* synthetic */ long b;

        public m(KaraokeMidiViewModel r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            md2.e.a(KaraokeMidiViewModel.TAG, "initMidiRes error: " + ((Throwable) r3).getMessage());
            pd2.d.n.F(this.b);
            KaraokeMidiViewModel.access$setInitMidiRes$p(this.a, false);
        }
    }

    public static final class n implements com.bytedance.android.live.ktv.common.music.download.p.a {
        public final /* synthetic */ KaraokeMidiViewModel a;

        public final void c(MusicPanel r1, int r2) {
        }

        public n(KaraokeMidiViewModel r1) {
            this.a = r1;
        }

        public final void a(MusicPanel r8, String r9, String r10) {
            md2.e.a(KaraokeMidiViewModel.TAG, "musicDownloadCallback onSuccess");
            if (r8 != null) goto L5;
            return;
        L5:
            KaraokeMidiViewModel r0 = this.a;
            long r1 = r8.a.getMId();
            String r3 = r8.q;
            String r4 = r8.l;
            String r5 = r8.p;
            if (r8.a.getMLyricType() != 2) goto L8;
            boolean r6 = true;
        L9:
            KaraokeMidiViewModel.access$initMidiRes(r0, r1, r3, r4, r5, r6);
            return;
        L8:
            r6 = false;
            goto L9
        }

        public final void b(MusicPanel r1, int r2, String r3) {
            md2.e.a(KaraokeMidiViewModel.TAG, "midiDownloadCallback onFailed");
        }
    }

    public static final class o<T> implements SingleOnSubscribe {
        public static final o a = null;

        static {
            a = new o();
        }

        public o() {
        }

        public final void subscribe(SingleEmitter<Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            ke2.c.b(null);
        }
    }

    public static final class p<T> implements Consumer {
        public static final p a = null;

        static {
            a = new p();
        }

        public p() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Unit r2 = (Unit) r1;
        }
    }

    public static final class q<T> implements Consumer {
        public static final q a = null;

        static {
            a = new q();
        }

        public q() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class r<T> implements Consumer {
        public final /* synthetic */ KaraokeMidiViewModel a;

        public r(KaraokeMidiViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            this.a.m20getScoreInfo().setValue(new Pair(Long.valueOf(KaraokeMidiViewModel.access$getCurMidiProgress$p(this.a)), KaraokeMidiViewModel.access$getScoreInfo(this.a)));
            KaraokeMidiViewModel r7 = this.a;
            KaraokeMidiViewModel.access$setCurMidiProgress$p(r7, KaraokeMidiViewModel.access$getCurMidiProgress$p(r7) + KaraokeMidiViewModel.access$getScoreTimeSetting$p(this.a));
        }
    }

    private final float calScore(float r1, float r2, int r3) {
        return r2;
    }

    public cb0.c findMidiSegmentOpt(long r1) {
        return null;
    }

    public List<cb0.c> findMidiSegmentsOpt(long r1, long r3) {
        return null;
    }

    public void getScoreInfo(double[] r2) {
        Intrinsics.checkNotNullParameter(r2, "scoreInfo");
    }

    public void release() {
    }

    static {
        Companion = new a();
        SHAKE_RANGE = KtvSettingHelper.j();
    }

    private final void clearData() {
        cancelDispose(this.scoreDisposable);
        cancelDispose(this.midiDisposable);
        this.midiData.setValue(null);
        this.curMidiProgress = 0;
        this.lastMidiIndex = -1;
        this.hitComboCalculator.a();
    }

    private final void disposeMidiDisposable() {
        cancelDispose(this.midiDisposable);
        this.isInitMidiRes = false;
    }

    private final com.bytedance.android.live.ktv.common.midi.k getScoreInfo() {
        getMidiScoreInfo(this.scoreInfoArr);
        double[] r0 = this.scoreInfoArr;
        float r2 = (float) r0[3];
        float r7 = (float) r0[7];
        int r10 = (int) r0[11];
        float r1 = calSentenceScore() * this.calFactorSetting;
        if (r1 <= 100.0f) goto L5;
        r1 = 100.0f;
    L5:
        cm0 r3 = cm0.a;
        if (((of1) r3.getValue()).a() == false) goto L8;
        float r8 = ((of1) r3.getValue()).b();
        float r6 = r7;
    L9:
        this.curScore = calScore(calTotalScore(), r8, r10);
        setTotalScore((int) calTotalScore());
        if (r10 > this.lastMidiIndex) goto L16;
        if (r10 == 0) goto L13;
    L15:
        boolean r4 = false;
    L17:
        Map r5 = null;
        if (r4 == false) goto L20;
        com.bytedance.android.live.ktv.common.midi.b r9 = this.hitComboCalculator;
        int r11 = com.bytedance.android.live.ktv.common.midi.b.e;
        int r12 = r9.b(r8, r10, null);
    L21:
        int r13 = -1;
        if (r4 == false) goto L50;
        this.lastMidiIndex = r10;
        g0 r14 = (g0) this.midiConfig.getValue();
        if (r14 == null) goto L26;
        Map r15 = r14.b();
    L27:
        int r16 = com.bytedance.android.live.ktv.common.util.p.a(r15, r8);
        if (r16 != 1) goto L30;
        com.bytedance.android.livesdk.ktvimpl.base.logger.a.a.b++;
        goto L50
    L30:
        if (r16 == 2) goto L48;
        if (r16 != 3) goto L50;
        if (r12 != 1) goto L35;
        com.bytedance.android.livesdk.ktvimpl.base.logger.a.b(1);
        goto L50
    L35:
        p40 r17 = p40.a;
        int r18 = ((Integer) r17.getValue()).intValue();
        if (2 > r12) goto L43;
        if (r18 <= r12) goto L43;
        if (r12 != 2) goto L41;
        com.bytedance.android.livesdk.ktvimpl.base.logger.a.b(-1);
        com.bytedance.android.livesdk.ktvimpl.base.logger.a.a();
    L41:
        com.bytedance.android.livesdk.ktvimpl.base.logger.a.a();
    L43:
        if (((Number) r17.getValue()).intValue() > r12) goto L50;
        if (Integer.MAX_VALUE < r12) goto L50;
        com.bytedance.android.livesdk.ktvimpl.base.logger.a.a.d++;
        goto L50
    L48:
        com.bytedance.android.livesdk.ktvimpl.base.logger.a.a.c++;
        goto L50
    L26:
        r15 = null;
    L50:
        float r19 = this.curScore;
        if (r10 < 0) goto L58;
        if (r4 == false) goto L58;
        g0 r20 = (g0) this.midiConfig.getValue();
        if (r20 == null) goto L56;
        r5 = r20.b();
    L56:
        r13 = com.bytedance.android.live.ktv.common.util.p.a(r5, r8);
    L58:
        return new com.bytedance.android.live.ktv.common.midi.k(r6, r7, r8, r19, r10, Integer.valueOf(r13), r12, false, DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE);
    L20:
        r12 = 0;
        goto L21
    L13:
        if (r8 <= 0) goto L15;
    L16:
        r4 = true;
        goto L17
    L8:
        r8 = r1;
        r6 = r2;
        goto L9
    }

    private final void resetMidiData() {
        cancelDispose(this.midiDisposable);
        this.midiData.setValue(null);
    }

    public final Pair<Integer, Integer> calcToneRange() {
        List r0 = (List) this.midiData.getValue();
        int r1 = 0;
        int r2 = 100;
        if (r0 == null) goto L9;
        Iterator r3 = r0.iterator();
    L6:
        if (r3.hasNext() == false) goto L9;
        cb0.c r4 = (cb0.c) r3.next();
        r2 = Math.min(r2, r4.b);
        r1 = Math.max(r1, r4.b);
    L9:
        return TuplesKt.to(Integer.valueOf(r2), Integer.valueOf(r1));
    }

    public final void onCreate() {
        Single.create(o.a).compose(RxUtil.rxSchedulerHelper()).subscribe(p.a, q.a);
        fetchMidiConfig();
        this.midiData.observeForever(this.midiDataObserver);
    }

    public void pauseMusic() {
        cancelDispose(this.scoreDisposable);
    }

    public void playMusic() {
        tryStartGetScoreInfoTimer(Long.valueOf(this.curMidiProgress));
    }

    private final float calSentenceScore() {
        Double r0 = (Double) ArraysKt.getOrNull(vm2.h.Z(), 0);
        if (r0 == null) goto L5;
        float r1 = (float) r0.doubleValue();
    L6:
        Double r2 = (Double) ArraysKt.getOrNull(vm2.h.Z(), 1);
        float r3 = 0.1f;
        if (r2 == null) goto L9;
        float r4 = (float) r2.doubleValue();
    L10:
        Double r5 = (Double) ArraysKt.getOrNull(vm2.h.Z(), 2);
        if (r5 == null) goto L13;
        r3 = (float) r5.doubleValue();
    L13:
        double[] r6 = this.scoreInfoArr;
        return ((((float) r6[0]) * r1) + (((float) r6[13]) * r4)) + (((float) r6[15]) * r3);
    L9:
        r4 = 0.1f;
        goto L10
    L5:
        r1 = 0.8f;
        goto L6
    }

    private final float calTotalScore() {
        Double r0 = (Double) ArraysKt.getOrNull(vm2.h.Z(), 0);
        if (r0 == null) goto L5;
        float r1 = (float) r0.doubleValue();
    L6:
        Double r2 = (Double) ArraysKt.getOrNull(vm2.h.Z(), 1);
        float r3 = 0.1f;
        if (r2 == null) goto L9;
        float r4 = (float) r2.doubleValue();
    L10:
        Double r5 = (Double) ArraysKt.getOrNull(vm2.h.Z(), 2);
        if (r5 == null) goto L13;
        r3 = (float) r5.doubleValue();
    L13:
        double[] r6 = this.scoreInfoArr;
        return ((((float) r6[1]) * r1) + (((float) r6[14]) * r4)) + (((float) r6[16]) * r3);
    L9:
        r4 = 0.1f;
        goto L10
    L5:
        r1 = 0.8f;
        goto L6
    }

    private final void fetchMidiConfig() {
        Disposable r0 = ((KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class)).getMidiConfig(d5.c(this.midiRunContext.getRoomId())).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this), new c(this));
        if (r0 == null) goto L6;
        RxUtilKt.c(r0, this.compositeDispose);
        return;
    }

    public void onCleared() {
        super.onCleared();
        this.compositeDispose.clear();
        this.midiData.removeObserver(this.midiDataObserver);
        clearData();
    }

    public int getCurTotalScore() {
        return this.curTotalScore;
    }

    public final MutableLiveData<g0> getMidiConfig() {
        return this.midiConfig;
    }

    public final MutableLiveData<List<cb0.c>> getMidiData() {
        return this.midiData;
    }

    public final md2.a getMidiRunContext() {
        return this.midiRunContext;
    }

    public int getTotalScore() {
        return this.totalScore;
    }

    public boolean getUserOpenScore() {
        return this.userOpenScore;
    }

    public void stopMusic() {
        clearData();
    }

    /* JADX INFO: renamed from: getScoreInfo, reason: collision with other method in class */
    public final MutableLiveData<Pair<Long, com.bytedance.android.live.ktv.common.midi.k>> m20getScoreInfo() {
        return this.scoreInfo;
    }

    /* JADX WARN: Type inference failed for: r3v14, types: [com.bytedance.android.livesdk.ktvimpl.base.component.midi.KaraokeMidiViewModel$midiDataObserver$1] */
    public KaraokeMidiViewModel(md2.a r3) {
        Intrinsics.checkNotNullParameter(r3, "midiRunContext");
        this.midiRunContext = r3;
        this.calFactorSetting = ((z8) KtvSettingHelper.z0.getValue()).a();
        this.scoreTimeSetting = KtvSettingHelper.s();
        this.userOpenScore = true;
        this.compositeDispose = new CompositeDisposable();
        this.scoreInfoArr = new double[21];
        this.lastMidiIndex = -1;
        this.hitComboCalculator = new com.bytedance.android.live.ktv.common.midi.b();
        this.midiData = new MutableLiveData();
        this.midiConfig = new MutableLiveData();
        this.scoreInfo = new MutableLiveData();
        this.midiDataObserver = new KaraokeMidiViewModel$midiDataObserver$1(this);
        this.musicDownloadCallback = new n(this);
    }

    public static final /* synthetic */ long access$getCurMidiProgress$p(KaraokeMidiViewModel r2) {
        return r2.curMidiProgress;
    }

    public static final /* synthetic */ com.bytedance.android.live.ktv.common.midi.k access$getScoreInfo(KaraokeMidiViewModel r0) {
        return r0.getScoreInfo();
    }

    public static final /* synthetic */ long access$getScoreTimeSetting$p(KaraokeMidiViewModel r2) {
        return r2.scoreTimeSetting;
    }

    public static final /* synthetic */ boolean access$isInitMidiRes$p(KaraokeMidiViewModel r0) {
        return r0.isInitMidiRes;
    }

    private final void cancelDispose(Disposable r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.isDisposed() == true) goto L8;
        r2.dispose();
        return;
    }

    private final void fillMidiAndLyricPath(MusicPanel r12) {
        if (KtvUtilsKt.C(r12) == false) goto L8;
        if (KtvUtilsKt.B(r12) == true) goto L8;
        com.bytedance.android.live.ktv.common.music.download.h r0 = com.bytedance.android.live.ktv.common.music.download.h.a;
        r12.j(com.bytedance.android.live.ktv.common.music.download.h.e(r12.a.getMidiUrl(), r12.a.getMId()));
    L8:
        if (KtvUtilsKt.A(r12) == false) goto L13;
        Intrinsics.checkNotNullParameter(r12, "$this$isSupportLyricWithPath");
        if ((!TextUtils.isEmpty(r12.l)) == true) goto L13;
        com.bytedance.android.live.ktv.common.music.download.h r1 = com.bytedance.android.live.ktv.common.music.download.h.a;
        List r2 = r12.a.getMLyricUrlList();
        Intrinsics.checkNotNull(r2);
        r12.i(com.bytedance.android.live.ktv.common.music.download.h.d((String) ListProtector.get(r2, 0), r12.a.getMId()));
    L13:
        if (KtvUtilsKt.H(r12) == false) goto L39;
        Intrinsics.checkNotNullParameter(r12, "$this$isSupportVocalWithPath");
        if ((!TextUtils.isEmpty(r12.p)) == true) goto L40;
        com.bytedance.android.live.ktv.common.music.download.h r3 = com.bytedance.android.live.ktv.common.music.download.h.a;
        String r4 = r12.a.getVocalUrl();
        long r5 = r12.a.getMId();
        int r6 = z.b;
        StringBuilder r7 = new StringBuilder(KtvCommonConfigParams.a());
        String r8 = File.separator;
        r7.append(r8);
        r7.append("musicPack");
        r7.append(r8);
        r7.append(r5);
        r7.append(r8);
        r7.append("vocal");
        r7.append(r8);
        String r9 = r7.toString();
        PolarisFileWrapper r10 = new PolarisFileWrapper(r9);
        if (r10.exists() == false) goto L19;
    L22:
        StringBuilder r11 = new StringBuilder();
        r11.append(r9);
        String r13 = "";
        if (r4 != null) goto L37;
        r4 = "";
    L37:
        int r14 = StringsKt.lastIndexOf$default(r4, '/', 0, false, 6, null);     // Catch: Exception -> L36
        if (r14 == (-1)) goto L34;
        int r15 = StringsKt.lastIndexOf$default(r4, '/', r14 - 1, false, 4, null);     // Catch: Exception -> L36
        if (r15 == (-1)) goto L34;
        if (r15 >= r14) goto L34;
        r13 = r4.substring(r15 + 1, r14);     // Catch: Exception -> L36
    L34:
        r11.append(r13);
        String r16 = r11.toString();
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r12.p = r16;
        return;
    L19:
        if (r10.mkdirs() == false) goto L21;
        com.bytedance.android.live.ktv.common.music.download.h.a();
        goto L22
    L21:
        ALogger.e("KtvFileUtil", "mkdirs return false, dir=" + r10);
        goto L22
    L40:
        return;
    }

    private final boolean isDisposed(Disposable r1) {
        if (r1 != null) goto L4;
    L7:
        return true;
    L4:
        if (r1.isDisposed() == true) goto L7;
        return false;
    }

    private final void seekMidiScoreProgress(long r1) {
        seekLyricPos(r1);
    }

    private final void tryInitMidiRes(MusicPanel r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        if (KtvUtilsKt.C(r9) == true) goto L6;
        return;
    L6:
        if (this.midiData.getValue() != null) goto L29;
        fillMidiAndLyricPath(r9);
        if (KtvUtilsKt.l(r9.q) == true) goto L15;
        KtvMusicManager r1 = KtvMusicManager.m;
        if (KtvMusicManager.h(r9) == false) goto L13;
        return;
    L13:
        KtvMusicManager.e(r1, r9, this.musicDownloadCallback, false, null, false, 28);
        return;
    L15:
        if (this.midiData.getValue() == null) goto L17;
        return;
    L17:
        if (KtvUtilsKt.B(r9) == false) goto L28;
        long r2 = r9.a.getMId();
        String r4 = r9.q;
        String r5 = r9.l;
        String r6 = r9.p;
        if (r9.a.getMLyricType() != 2) goto L21;
        boolean r7 = true;
    L22:
        initMidiRes(r2, r4, r5, r6, r7);
        return;
    L21:
        r7 = false;
        goto L22
    L28:
        return;
    }

    public Observable<cb0.c> findMidiSegment(long r3) {
        Collection r0 = (Collection) this.midiData.getValue();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        md2.e.a(TAG, "findMidiSegment midiData is null");
        return Observable.empty();
    L13:
        return Observable.just(this.midiData.getValue()).filter(d.a).flatMap(e.a).filter(new f(r3));
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final void getMidiScoreInfo(double[] r2) {
        Intrinsics.checkNotNullParameter(r2, "scoreInfo");
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r0 = this.midiRunContext.c();
        if (r0 == null) goto L8;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b r1 = r0.k();
        if (r1 == null) goto L9;
        r1.g(r2);
        return;
    L9:
        return;
    }

    public final void seekLyricPos(long r1) {
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r2 = this.midiRunContext.c();
        if (r2 == null) goto L8;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b r3 = r2.k();
        if (r3 == null) goto L9;
        r3.n();
        return;
    L9:
        return;
    }

    public void seekMusic(long r6) {
        long r0 = Math.abs(this.curMidiProgress - r6);
        if (r6 >= this.curMidiProgress) goto L5;
        return;
    L5:
        if (r0 < SHAKE_RANGE) goto L10;
        this.curMidiProgress = r6;
        seekMidiScoreProgress(r6);
        return;
    }

    public void setCurTotalScore(int r1) {
        this.curTotalScore = r1;
    }

    public final void setMidiConfig(MutableLiveData<g0> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.midiConfig = r2;
    }

    public void setTotalScore(int r1) {
        this.totalScore = r1;
    }

    public void setUserOpenScore(boolean r1) {
        this.userOpenScore = r1;
    }

    public void startMusic(com.bytedance.android.livesdk.ktvimpl.base.a r2) {
        Intrinsics.checkNotNullParameter(r2, "param");
        if (this.midiData.getValue() == null) goto L5;
        return;
    L5:
        resetMidiData();
        tryInitMidiRes(this.midiRunContext.a());
    }

    public final void tryStartGetScoreInfoTimer(Long r6) {
        Collection r0 = (Collection) this.midiData.getValue();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        tryInitMidiRes(this.midiRunContext.a());
        return;
    L12:
        if (r6 == null) goto L15;
        this.curMidiProgress = r6.longValue();
    L15:
        if (isDisposed(this.scoreDisposable) == false) goto L22;
        if (r6 == null) goto L23;
        md2.e.a(TAG, "tryStartGetScoreInfoTimer, progress = " + r6);
        if (r6.longValue() <= SHAKE_RANGE) goto L20;
        seekMidiScoreProgress(r6.longValue());
    L20:
        this.scoreDisposable = du2.a.d(this.scoreTimeSetting, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new r(this));
        return;
    L23:
        return;
    L22:
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public static final /* synthetic */ void access$setCurMidiProgress$p(KaraokeMidiViewModel r0, long r1) {
        r0.curMidiProgress = r1;
    }

    public static final /* synthetic */ void access$setInitMidiRes$p(KaraokeMidiViewModel r0, boolean r1) {
        r0.isInitMidiRes = r1;
    }

    public Single<List<cb0.c>> findMidiSegments(long r3, long r5) {
        Collection r0 = (Collection) this.midiData.getValue();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        md2.e.a(TAG, "findMidiSegments midiData is null");
        return null;
    L13:
        return Observable.just(this.midiData.getValue()).filter(g.a).flatMap(h.a).filter(new i(r5, r3)).toList();
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public List<cb0.c> findMidiSegmentsNew(long r10, long r12) {
        Collection r0 = (Collection) this.midiData.getValue();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        ArrayList r3 = null;
        if (r1 == false) goto L13;
        md2.e.a(TAG, "findMidiSegmentsNew midiData is null");
        return null;
    L13:
        List r2 = (List) this.midiData.getValue();
        if (r2 == null) goto L26;
        r3 = new ArrayList();
        Iterator r4 = r2.iterator();
    L17:
        if (r4.hasNext() == false) goto L26;
        Object r5 = r4.next();
        cb0.a r6 = ((cb0.c) r5).a;
        if (r6.a < r12) goto L21;
    L23:
        boolean r7 = false;
    L24:
        if (r7 == false) goto L17;
        r3.add(r5);
        goto L17
    L21:
        if (r6.b <= r10) goto L23;
        r7 = true;
    L26:
        return r3;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final int setScoringSources(String r1, String r2, String r3, double r4) {
        Intrinsics.checkNotNullParameter(r1, "midiPath");
        Intrinsics.checkNotNullParameter(r2, "lyricsPath");
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r5 = this.midiRunContext.c();
        if (r5 == null) goto L9;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b r6 = r5.k();
        if (r6 == null) goto L10;
        r6.p(r1, r2);
        return -1;
    L10:
        return -1;
    L9:
        return -1;
    }

    private final void initMidiRes(long r3, String r5, String r6, String r7, boolean r8) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
    L25:
        md2.e.a(TAG, "initMidiRes fail, invalid parameters");
        return;
    L5:
        if (TextUtils.isEmpty(r6) == true) goto L25;
        if (r8 == true) goto L25;
        if (this.midiData.getValue() == null) goto L13;
        md2.e.a(TAG, "initMidiRes skip, midiData already exists");
        return;
    L13:
        if (isDisposed(this.midiDisposable) == false) goto L16;
        this.isInitMidiRes = false;
    L16:
        if (this.isInitMidiRes == false) goto L19;
        md2.e.a(TAG, "initMidiRes skip, isInitMidiRes is true");
        return;
    L19:
        disposeMidiDisposable();
        this.isInitMidiRes = true;
        this.midiDisposable = Single.create(new j(this, r6, r5, r7)).map(new k(this, r5)).compose(RxUtil.rxSchedulerHelper()).subscribe(new l(this), new m(this, r3));     // Catch: Exception -> L22
        return;
    L22:
        e = move-exception;
        md2.e.a(TAG, "initMidiRes fail, exception: " + e.getMessage());
        pd2.d.n.F(r3);
        this.isInitMidiRes = false;
    }

    public static final /* synthetic */ void access$initMidiRes(KaraokeMidiViewModel r0, long r1, String r3, String r4, String r5, boolean r6) {
        r0.initMidiRes(r1, r3, r4, r5, r6);
    }

    public static /* synthetic */ void initMidiRes$default(KaraokeMidiViewModel r7, long r8, String r10, String r11, String r12, boolean r13, int r14, Object r15) {
        if ((r14 & 16) == 0) goto L5;
        boolean r6 = false;
    L6:
        r7.initMidiRes(r8, r10, r11, r12, r6);
        return;
    L5:
        r6 = r13;
        goto L6
    }
}
