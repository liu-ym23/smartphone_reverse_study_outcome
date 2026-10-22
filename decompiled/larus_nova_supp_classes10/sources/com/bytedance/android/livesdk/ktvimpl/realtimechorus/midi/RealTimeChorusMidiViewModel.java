package com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi;

import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.ktv.common.model.api.g0;
import com.bytedance.android.live.ktv.common.music.download.KtvMusicManager;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.config.of1;
import com.bytedance.android.livesdk.config.z8;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.api.KtvRoomApi;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusBusinessContext;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.w;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import fd2.y;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000ó\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0013\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t*\u0003\u007f\u0092\u0001\u0018\u0000 \u009c\u00012\u00020\u00012\u00020\u0002:\u0002\u009d\u0001B\u0013\u0012\b\u0010\u0096\u0001\u001a\u00030\u0095\u0001¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0002J*\u0010\u000b\u001a\u00020\u00032 \u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005j\u0004\u0018\u0001`\tH\u0002J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0003H\u0002J6\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001aH\u0002J\u0012\u0010\u001f\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0014H\u0002J\b\u0010#\u001a\u00020\"H\u0002J\b\u0010%\u001a\u00020$H\u0002J\b\u0010&\u001a\u00020$H\u0002J \u0010+\u001a\u00020$2\u0006\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020$2\u0006\u0010*\u001a\u00020)H\u0002J\b\u0010,\u001a\u00020\u0003H\u0002J\u0017\u0010-\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b-\u0010.J*\u0010/\u001a\u00020\u00032 \u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005j\u0004\u0018\u0001`\tH\u0014J\u000e\u00101\u001a\u00020\u00032\u0006\u00100\u001a\u00020\rJ\u000e\u00102\u001a\u00020\u00032\u0006\u00100\u001a\u00020\rJ\u0006\u00103\u001a\u00020\u0003J\u000e\u00106\u001a\u00020\u00032\u0006\u00105\u001a\u000204J\u0016\u0010:\u001a\b\u0012\u0004\u0012\u000209082\u0006\u00107\u001a\u00020\u0014H\u0016J \u0010>\u001a\n\u0012\u0004\u0012\u000209\u0018\u00010=2\u0006\u0010;\u001a\u00020\u00142\u0006\u0010<\u001a\u00020\u0014H\u0016J&\u0010@\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002090=\u0018\u00010?2\u0006\u0010;\u001a\u00020\u00142\u0006\u0010<\u001a\u00020\u0014H\u0016J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010B\u001a\u00020AH\u0016J\u0017\u0010C\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\bC\u0010.J\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)0DJ\u0018\u0010G\u001a\u00020\u00032\u0006\u0010F\u001a\u00020\u001a2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\b\u0010H\u001a\u00020\u0003H\u0014R\u0019\u0010J\u001a\u0004\u0018\u00010I8\u0006¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\"\u0010N\u001a\u00020)8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010'\u001a\u00020)8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b'\u0010O\u001a\u0004\bT\u0010Q\"\u0004\bU\u0010SR\"\u0010V\u001a\u00020\u001a8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u0014\u0010]\u001a\u00020\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010_\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010a\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010`R\u0016\u0010b\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010d\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010f\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010h\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010gR\u0016\u0010i\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010OR\u0016\u0010j\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010WR\u0016\u0010l\u001a\u00020k8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u0018\u0010n\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010`R#\u0010p\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090=0o8\u0006¢\u0006\f\n\u0004\bp\u0010q\u001a\u0004\br\u0010sR(\u0010u\u001a\b\u0012\u0004\u0012\u00020t0o8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bu\u0010q\u001a\u0004\bv\u0010s\"\u0004\bw\u0010xR(\u0010y\u001a\b\u0012\u0004\u0012\u00020\u001a0o8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\by\u0010q\u001a\u0004\bz\u0010s\"\u0004\b{\u0010xR+\u0010B\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\"0D0o8\u0006¢\u0006\f\n\u0004\bB\u0010q\u001a\u0004\b#\u0010sR\"\u0010}\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020$\u0018\u00010|8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b}\u0010~R\u0017\u0010\u0080\u0001\u001a\u00020\u007f8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0016\u0010\u0082\u0001\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010eR\u0016\u0010\u0083\u0001\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010gR#\u0010\u0085\u0001\u001a\t\u0012\u0004\u0012\u00020\u00140\u0084\u00018\u0006¢\u0006\u0010\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R9\u0010\u0089\u0001\u001a\u001f\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005j\u0002`\t0\u0084\u00018\u0006¢\u0006\u0010\n\u0006\b\u0089\u0001\u0010\u0086\u0001\u001a\u0006\b\u008a\u0001\u0010\u0088\u0001R,\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008b\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b\u008c\u0001\u0010\u008d\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0018\u0010\u0093\u0001\u001a\u00030\u0092\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001d\u0010\u0096\u0001\u001a\u00030\u0095\u00018\u0006¢\u0006\u0010\n\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001¨\u0006\u009e\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/midi/RealTimeChorusMidiViewModel;", "Landroidx/lifecycle/ViewModel;", "Ldb0/a;", "", "observeCoreViewModel", "Lcom/bytedance/android/live/core/utils/StateMachine$c$b;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$d;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$a;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$b;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/ValidLyricsStateTransition;", "valid", "handleState", "curstate", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/d;", "data", "handleStateCoreData", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "musicPanel", "tryInitMidiRes", "fetchMidiConfig", "", "id", "", "midiPath", "lyricsPath", "vocalFilePath", "", "isLrcLyric", "initMidiRes", "Lio/reactivex/disposables/Disposable;", "disposable", "isDisposed", "progress", "seekMidiScoreProgress", "Lcom/bytedance/android/live/ktv/common/midi/k;", "getScoreInfo", "", "calTotalScore", "calSentenceScore", "totalScore", "sentenceScore", "", "index", "calScore", "resetMidiData", "handleSingProgress", "(Ljava/lang/Long;)V", "onIdle", "ktvCoreDataModel", "onPreparing", "onSinging", "onPaused", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "onCreate", "curPlayTime", "Lio/reactivex/Observable;", "Lcb0/c;", "findMidiSegment", "startTime", "endTime", "", "findMidiSegmentsNew", "Lio/reactivex/Single;", "findMidiSegments", "", "scoreInfo", "tryStartGetScoreInfoTimer", "Lkotlin/Pair;", "calcToneRange", "isSinger", "onSingFinish", "onCleared", "Lsb0/b;", "dataEntity", "Lsb0/b;", "getDataEntity", "()Lsb0/b;", "curTotalScore", "I", "getCurTotalScore", "()I", "setCurTotalScore", "(I)V", "getTotalScore", "setTotalScore", "userOpenScore", "Z", "getUserOpenScore", "()Z", "setUserOpenScore", "(Z)V", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDispose", "Lio/reactivex/disposables/CompositeDisposable;", "midiDisposable", "Lio/reactivex/disposables/Disposable;", "scoreDisposable", "scoreInfoArr", "[D", "curScore", "F", "curMusicId", "J", "curMidiProgress", "lastMidiIndex", "lastMidiHitFlag", "Lcom/bytedance/android/live/ktv/common/midi/b;", "mHitComboCalculator", "Lcom/bytedance/android/live/ktv/common/midi/b;", "reportMidiDisposable", "Landroidx/lifecycle/MutableLiveData;", "midiData", "Landroidx/lifecycle/MutableLiveData;", "getMidiData", "()Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/live/ktv/common/model/api/g0;", "midiConfig", "getMidiConfig", "setMidiConfig", "(Landroidx/lifecycle/MutableLiveData;)V", "showNoMidiHint", "getShowNoMidiHint", "setShowNoMidiHint", "", "scoreMap", "Ljava/util/Map;", "com/bytedance/android/livesdk/ktvimpl/realtimechorus/midi/RealTimeChorusMidiViewModel$o", "musicDownloadCallback", "Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/midi/RealTimeChorusMidiViewModel$o;", "calFactorSetting", "scoreTimeSetting", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "lyricProgress", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "getLyricProgress", "()Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "curState", "getCurState", "Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/BaseCoreViewModel;", "coreViewModel", "Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/BaseCoreViewModel;", "getCoreViewModel", "()Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/BaseCoreViewModel;", "setCoreViewModel", "(Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/BaseCoreViewModel;)V", "com/bytedance/android/livesdk/ktvimpl/realtimechorus/midi/RealTimeChorusMidiViewModel$n", "mCoreListener", "Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/midi/RealTimeChorusMidiViewModel$n;", "Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;", "ktvContext", "Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;", "getKtvContext", "()Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;", "<init>", "(Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;)V", "Companion", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RealTimeChorusMidiViewModel extends ViewModel implements db0.a {
    public static final a Companion = null;
    public static final String TAG = "RealTimeChorusMidiViewModel";
    private final float calFactorSetting;
    private final CompositeDisposable compositeDispose;
    private BaseCoreViewModel coreViewModel;
    private long curMidiProgress;
    private long curMusicId;
    private float curScore;
    private final NextLiveData<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> curState;
    private int curTotalScore;
    private final sb0.b dataEntity;
    private final KtvContext ktvContext;
    private boolean lastMidiHitFlag;
    private int lastMidiIndex;
    private final NextLiveData<Long> lyricProgress;
    private final n mCoreListener;
    private com.bytedance.android.live.ktv.common.midi.b mHitComboCalculator;
    private MutableLiveData<g0> midiConfig;
    private final MutableLiveData<List<cb0.c>> midiData;
    private Disposable midiDisposable;
    private final o musicDownloadCallback;
    private Disposable reportMidiDisposable;
    private Disposable scoreDisposable;
    private final MutableLiveData<Pair<Long, com.bytedance.android.live.ktv.common.midi.k>> scoreInfo;
    private double[] scoreInfoArr;
    private final Map<Integer, Float> scoreMap;
    private final long scoreTimeSetting;
    private MutableLiveData<Boolean> showNoMidiHint;
    private int totalScore;
    private boolean userOpenScore;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusMidiViewModel a;

        public b(RealTimeChorusMidiViewModel r1) {
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
        public c(RealTimeChorusMidiViewModel r1) {
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            ALogger.i(bb0.b.b(), "fetchMidiConfig fail, invoke class :RealTimeChorusMidiViewModel");
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
        public final /* synthetic */ RealTimeChorusMidiViewModel a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public j(RealTimeChorusMidiViewModel r1, boolean r2, String r3, String r4, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void subscribe(SingleEmitter<Integer> r6) {
            Intrinsics.checkNotNullParameter(r6, "it");
            com.bytedance.android.livesdk.ktvimpl.base.i r0 = (com.bytedance.android.livesdk.ktvimpl.base.i) this.a.getKtvContext().getKtvCoreController().getValue();
            if (r0 != null) goto L9;
            StringBuilder r1 = new StringBuilder("initMidiRes coreController == null ;; KtvContext.getKtvContext() == ");
            KtvContext.Companion.getClass();
            r1.append(KtvContext.a.g().hashCode());
            r1.append(" ;; ktvContext == ");
            r1.append(this.a.getKtvContext().hashCode());
            w.a(RealTimeChorusMidiViewModel.TAG, r1.toString());
            com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r2 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d) this.a.getKtvContext().getKtvSingerViewModel().getValue();
            if (r2 == null) goto L7;
            r2.lazyInitKtvCoreController();
        L7:
            r0 = (com.bytedance.android.livesdk.ktvimpl.base.i) this.a.getKtvContext().getKtvCoreController().getValue();
        L9:
            if (this.b == false) goto L15;
            String r3 = this.c;
            if (r3 == null) goto L15;
            if (r0 == null) goto L14;
            Intrinsics.checkNotNullParameter(this.d, "midiFilePath");
            Intrinsics.checkNotNullParameter(r3, "lyricFilesPath");
            r0.d();
        L14:
            Integer r4 = null;
        L17:
            if (r6.isDisposed() == false) goto L19;
            return;
        L19:
            if (r4 != null) goto L22;
        L23:
            w.a(RealTimeChorusMidiViewModel.TAG, "initMidiRes fail result " + r4);
            r6.onError(new Exception("init midi error"));
            return;
        L22:
            if (r4.intValue() != 0) goto L23;
            r6.onSuccess(r4);
            return;
        L15:
            r4 = -2;
            goto L17
        }
    }

    public static final class k<T, R> implements Function {
        public final /* synthetic */ RealTimeChorusMidiViewModel a;
        public final /* synthetic */ boolean b;

        public k(RealTimeChorusMidiViewModel r1, boolean r2, String r3) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter((Integer) r2, "it");
            if (vm2.h.d() == true) goto L5;
            ILiveWrappedLivePusher.Companion.getClass();
            ILiveWrappedLivePusher r3 = ILiveWrappedLivePusher.a.b();
            if (r3 == null) goto L21;
            r3.getLiveCoreKaraokFilter();
            return null;
        L21:
            return null;
        L5:
            if (this.b == false) goto L9;
            com.bytedance.android.livesdk.ktvimpl.base.i r4 = (com.bytedance.android.livesdk.ktvimpl.base.i) this.a.getKtvContext().getKtvCoreController().getValue();
            if (r4 == null) goto L17;
            r4.d();
            return null;
        L17:
            return null;
        L9:
            ILiveWrappedLivePusher.Companion.getClass();
            ILiveWrappedLivePusher r5 = ILiveWrappedLivePusher.a.b();
            if (r5 == null) goto L19;
            r5.getLiveCoreKaraokFilter();
            return null;
        L19:
            return null;
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusMidiViewModel a;

        public l(RealTimeChorusMidiViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            w.a(RealTimeChorusMidiViewModel.TAG, "initMidiRes success");
            MutableLiveData<List<cb0.c>> r0 = this.a.getMidiData();
            r0.setValue((List) r3);
            this.a.getShowNoMidiHint().setValue(Boolean.FALSE);
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusMidiViewModel a;
        public final /* synthetic */ long b;

        public m(RealTimeChorusMidiViewModel r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            w.a(RealTimeChorusMidiViewModel.TAG, "initMidiRes fail " + r4.getMessage());
            r4.printStackTrace();
            pd2.d.n.F(this.b);
            this.a.getShowNoMidiHint().setValue(Boolean.TRUE);
        }
    }

    public static final class n extends com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b {
        public final /* synthetic */ RealTimeChorusMidiViewModel a;

        public n(RealTimeChorusMidiViewModel r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
        public final void a(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r2) {
            Intrinsics.checkNotNullParameter(r2, "valid");
            RealTimeChorusMidiViewModel.access$handleState(this.a, r2);
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
        public final void e(long r2) {
            BaseCoreViewModel r0 = this.a.getCoreViewModel();
            if (r0 == null) goto L6;
            KtvMusic r1 = r0.getCurrentMusicFromState();
            if (r1 == null) goto L6;
        L7:
            if (r1 != null) goto L9;
            return;
        L9:
            this.a.handleSingProgress(Long.valueOf(r2));
            return;
        L6:
            r1 = ((y) this.a.getKtvContext().getKtvRoomInfo().getValue()).b();
            goto L7
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
        public final void d(KtvRoomLyricsStateMachineConfig.d r2, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.d r3) {
            Intrinsics.checkNotNullParameter(r2, "curstate");
            Intrinsics.checkNotNullParameter(r3, "ktvCoreDataModel");
            RealTimeChorusMidiViewModel.access$handleStateCoreData(this.a, r2, r3);
        }
    }

    public static final class o implements com.bytedance.android.live.ktv.common.music.download.p.a {
        public final /* synthetic */ RealTimeChorusMidiViewModel a;

        public final void c(MusicPanel r1, int r2) {
        }

        public o(RealTimeChorusMidiViewModel r1) {
            this.a = r1;
        }

        public final void a(MusicPanel r8, String r9, String r10) {
            w.a(RealTimeChorusMidiViewModel.TAG, "musicDownloadCallback onSuccess");
            if (r8 != null) goto L5;
            return;
        L5:
            RealTimeChorusMidiViewModel r0 = this.a;
            long r1 = r8.a.getMId();
            String r3 = r8.q;
            String r4 = r8.l;
            String r5 = r8.p;
            if (r8.a.getMLyricType() != 2) goto L8;
            boolean r6 = true;
        L9:
            RealTimeChorusMidiViewModel.access$initMidiRes(r0, r1, r3, r4, r5, r6);
            return;
        L8:
            r6 = false;
            goto L9
        }

        public final void b(MusicPanel r1, int r2, String r3) {
            w.a(RealTimeChorusMidiViewModel.TAG, "midiDownloadCallback onFailed");
        }
    }

    public static final class p<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusMidiViewModel a;
        public final /* synthetic */ LifecycleOwner b;

        public p(RealTimeChorusMidiViewModel r1, LifecycleOwner r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            this.a.setCoreViewModel((BaseCoreViewModel) sh6.c.b((sh6.b) r2));
            RealTimeChorusMidiViewModel.access$observeCoreViewModel(this.a);
        }
    }

    public static final class q<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusMidiViewModel a;

        public q(RealTimeChorusMidiViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            this.a.m493getScoreInfo().setValue(new Pair(Long.valueOf(RealTimeChorusMidiViewModel.access$getCurMidiProgress$p(this.a)), RealTimeChorusMidiViewModel.access$getScoreInfo(this.a)));
            RealTimeChorusMidiViewModel r7 = this.a;
            RealTimeChorusMidiViewModel.access$setCurMidiProgress$p(r7, RealTimeChorusMidiViewModel.access$getCurMidiProgress$p(r7) + RealTimeChorusMidiViewModel.access$getScoreTimeSetting$p(this.a));
        }
    }

    static {
        Companion = new a();
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

    private final void fetchMidiConfig() {
        sb0.b r0 = this.dataEntity;
        if (r0 == null) goto L7;
        sb0.e r1 = r0.b();
        if (r1 == null) goto L7;
        long r2 = r1.getRoomId();
    L8:
        Disposable r3 = ((KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class)).getMidiConfig(r2).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this), new c(this));
        if (r3 == null) goto L12;
        RxUtilKt.c(r3, this.compositeDispose);
        return;
    L12:
        return;
    L7:
        r2 = 0;
        goto L8
    }

    private final com.bytedance.android.live.ktv.common.midi.k getScoreInfo() {
        com.bytedance.android.livesdk.ktvimpl.base.i r0 = (com.bytedance.android.livesdk.ktvimpl.base.i) this.ktvContext.getKtvCoreController().getValue();
        if (r0 == null) goto L5;
        r0.g(this.scoreInfoArr);
    L5:
        double[] r1 = this.scoreInfoArr;
        float r2 = (float) r1[3];
        float r7 = (float) r1[7];
        int r10 = (int) r1[11];
        float r3 = calSentenceScore() * this.calFactorSetting;
        if (r3 <= 100.0f) goto L8;
        r3 = 100.0f;
    L8:
        ReadOnlyProperty r4 = vm2.h.s4;
        KProperty[] r5 = vm2.h.a;
        Map r8 = null;
        if (((of1) r4.getValue(null, r5[277(0x115, float:3.88E-43)])).a() == false) goto L11;
        r3 = ((of1) r4.getValue(null, r5[277(0x115, float:3.88E-43)])).b();
        float r6 = r7;
    L12:
        this.curScore = calScore(calTotalScore(), r3, r10);
        setTotalScore((int) calTotalScore());
        if (r10 > this.lastMidiIndex) goto L19;
        if (r10 == 0) goto L16;
    L18:
        boolean r9 = false;
    L20:
        if (r9 == false) goto L22;
        com.bytedance.android.live.ktv.common.midi.b r11 = this.mHitComboCalculator;
        int r12 = com.bytedance.android.live.ktv.common.midi.b.e;
        int r13 = r11.b(r3, r10, null);
    L23:
        int r14 = -1;
        if (r9 == false) goto L52;
        this.lastMidiIndex = r10;
        g0 r15 = (g0) this.midiConfig.getValue();
        if (r15 == null) goto L28;
        Map r16 = r15.b();
    L29:
        int r17 = com.bytedance.android.live.ktv.common.util.p.a(r16, r3);
        if (r17 != 1) goto L32;
        com.bytedance.android.livesdk.ktvimpl.base.logger.a.a.b++;
        goto L52
    L32:
        if (r17 == 2) goto L50;
        if (r17 != 3) goto L52;
        if (r13 != 1) goto L37;
        com.bytedance.android.livesdk.ktvimpl.base.logger.a.b(1);
        goto L52
    L37:
        int r18 = vm2.h.x();
        if (2 > r13) goto L45;
        if (r18 <= r13) goto L45;
        if (r13 != 2) goto L43;
        com.bytedance.android.livesdk.ktvimpl.base.logger.a.b(-1);
        com.bytedance.android.livesdk.ktvimpl.base.logger.a.a();
    L43:
        com.bytedance.android.livesdk.ktvimpl.base.logger.a.a();
    L45:
        if (vm2.h.x() > r13) goto L52;
        if (Integer.MAX_VALUE < r13) goto L52;
        com.bytedance.android.livesdk.ktvimpl.base.logger.a.a.d++;
        goto L52
    L50:
        com.bytedance.android.livesdk.ktvimpl.base.logger.a.a.c++;
        goto L52
    L28:
        r16 = null;
    L52:
        float r19 = this.curScore;
        if (r10 < 0) goto L60;
        if (r9 == false) goto L60;
        g0 r20 = (g0) this.midiConfig.getValue();
        if (r20 == null) goto L58;
        r8 = r20.b();
    L58:
        r14 = com.bytedance.android.live.ktv.common.util.p.a(r8, r3);
    L60:
        return new com.bytedance.android.live.ktv.common.midi.k(r6, r7, r3, r19, r10, Integer.valueOf(r14), r13, false, DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE);
    L22:
        r13 = 0;
        goto L23
    L16:
        if (r3 <= 0) goto L18;
    L19:
        r9 = true;
        goto L20
    L11:
        r6 = r2;
        goto L12
    }

    private final void observeCoreViewModel() {
        BaseCoreViewModel r0 = this.coreViewModel;
        if (r0 == null) goto L6;
        r0.registerKtvCoreListener(CollectionsKt.arrayListOf(new String[]{BaseCoreViewModel.CORE_TAG_STATE, BaseCoreViewModel.CORE_TAG_DATA_MODEL, BaseCoreViewModel.CORE_TAG_PROGRESS}), this.mCoreListener, false);
    L6:
        if (KtvSettingHelper.w() == false) goto L13;
        NextLiveData<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> r1 = this.curState;
        BaseCoreViewModel r2 = this.coreViewModel;
        if (r2 == null) goto L10;
        StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> r3 = r2.getCurrentTransition();
    L11:
        r1.setValue(r3);
        return;
    L10:
        r3 = null;
        goto L11
    }

    private final void resetMidiData() {
        Disposable r0 = this.midiDisposable;
        if (r0 != null) goto L5;
    L8:
        this.midiData.setValue(null);
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        r0.dispose();
    L7:
        this.midiDisposable = null;
        goto L8
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

    public final void onPaused() {
        Disposable r0 = this.scoreDisposable;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
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

    public void onCleared() {
        super.onCleared();
        com.bytedance.android.live.ktv.common.midi.e.b(TAG, "reportScore: onCleared, compositeDispose.dispose()");
        this.compositeDispose.dispose();
        Disposable r0 = this.reportMidiDisposable;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Disposable r1 = this.scoreDisposable;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        resetMidiData();
        this.curMusicId = 0;
        this.curMidiProgress = 0;
        this.lastMidiIndex = -1;
        this.mHitComboCalculator.a();
        this.lastMidiHitFlag = false;
        this.midiData.setValue(null);
        BaseCoreViewModel r2 = this.coreViewModel;
        if (r2 == null) goto L12;
        r2.unregisterKtvCoreListener(this.mCoreListener);
        return;
    }

    public final BaseCoreViewModel getCoreViewModel() {
        return this.coreViewModel;
    }

    public final NextLiveData<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> getCurState() {
        return this.curState;
    }

    public int getCurTotalScore() {
        return this.curTotalScore;
    }

    public final sb0.b getDataEntity() {
        return this.dataEntity;
    }

    public final KtvContext getKtvContext() {
        return this.ktvContext;
    }

    public final NextLiveData<Long> getLyricProgress() {
        return this.lyricProgress;
    }

    public final MutableLiveData<g0> getMidiConfig() {
        return this.midiConfig;
    }

    public final MutableLiveData<List<cb0.c>> getMidiData() {
        return this.midiData;
    }

    public final MutableLiveData<Boolean> getShowNoMidiHint() {
        return this.showNoMidiHint;
    }

    public int getTotalScore() {
        return this.totalScore;
    }

    public boolean getUserOpenScore() {
        return this.userOpenScore;
    }

    /* JADX INFO: renamed from: getScoreInfo, reason: collision with other method in class */
    public final MutableLiveData<Pair<Long, com.bytedance.android.live.ktv.common.midi.k>> m493getScoreInfo() {
        return this.scoreInfo;
    }

    public RealTimeChorusMidiViewModel(KtvContext r3) {
        Intrinsics.checkNotNullParameter(r3, "ktvContext");
        this.ktvContext = r3;
        this.dataEntity = (sb0.b) r3.getDataEntity().getValue();
        this.userOpenScore = true;
        this.compositeDispose = new CompositeDisposable();
        this.scoreInfoArr = new double[21];
        this.lastMidiIndex = -1;
        this.mHitComboCalculator = new com.bytedance.android.live.ktv.common.midi.b();
        this.midiData = new MutableLiveData();
        this.midiConfig = new MutableLiveData();
        this.showNoMidiHint = new MutableLiveData();
        this.scoreInfo = new MutableLiveData();
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r4 = KtvRoomContext.a.a();
        if (r4 == null) goto L7;
        com.bytedance.live.datacontext.m<Map<Integer, Float>> r5 = r4.getScoreMap();
        if (r5 == null) goto L7;
        Map<Integer, Float> r6 = (Map) r5.getValue();
    L8:
        this.scoreMap = r6;
        this.musicDownloadCallback = new o(this);
        this.calFactorSetting = ((z8) KtvSettingHelper.z0.getValue()).a();
        this.scoreTimeSetting = KtvSettingHelper.s();
        this.lyricProgress = new NextLiveData();
        this.curState = new NextLiveData();
        this.mCoreListener = new n(this);
        return;
    L7:
        r6 = null;
        goto L8
    }

    public static final /* synthetic */ long access$getCurMidiProgress$p(RealTimeChorusMidiViewModel r2) {
        return r2.curMidiProgress;
    }

    public static final /* synthetic */ com.bytedance.android.live.ktv.common.midi.k access$getScoreInfo(RealTimeChorusMidiViewModel r0) {
        return r0.getScoreInfo();
    }

    public static final /* synthetic */ long access$getScoreTimeSetting$p(RealTimeChorusMidiViewModel r2) {
        return r2.scoreTimeSetting;
    }

    public static final /* synthetic */ void access$observeCoreViewModel(RealTimeChorusMidiViewModel r0) {
        r0.observeCoreViewModel();
    }

    private final void handleState(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        KtvRoomLyricsStateMachineConfig.d r0 = (KtvRoomLyricsStateMachineConfig.d) r4.c;
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L8;
        this.curState.setValue(r4);
        onIdle(r4);
        return;
    L8:
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L11;
        this.curState.setValue(r4);
        return;
    L11:
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == false) goto L14;
        this.curState.setValue(r4);
        onPaused();
        return;
    L14:
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L36;
        Object r1 = r4.a;
        if ((r1 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L34;
        if (r1 == null) goto L33;
        OrderInfo r2 = ((KtvRoomLyricsStateMachineConfig.d.f) r1).b.a.getOrderInfo();
        String r3 = null;
        if (r2 == null) goto L23;
        InteractiveSongUserInfo r5 = r2.getTopUser();
        if (r5 == null) goto L23;
        String r6 = r5.getIdString();
    L24:
        OrderInfo r7 = ((KtvRoomLyricsStateMachineConfig.d.f) r0).b.a.getOrderInfo();
        if (r7 == null) goto L30;
        InteractiveSongUserInfo r8 = r7.getTopUser();
        if (r8 == null) goto L30;
        r3 = r8.getIdString();
    L30:
        if ((!Intrinsics.areEqual(r6, r3)) == true) goto L34;
        return;
    L23:
        r6 = null;
        goto L24
    L33:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig.State.Singing");
    L34:
        this.curState.setValue(r4);
        return;
    L36:
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.a) == false) goto L44;
        this.curState.setValue(r4);
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

    private final void seekMidiScoreProgress(long r2) {
        com.bytedance.android.livesdk.ktvimpl.base.i r0 = (com.bytedance.android.livesdk.ktvimpl.base.i) this.ktvContext.getKtvCoreController().getValue();
        if (r0 == null) goto L6;
        r0.n(r2);
        return;
    }

    private final void tryInitMidiRes(MusicPanel r11) {
        if (r11 == null) goto L54;
        String r0 = r11.a.getMidiUrl();
        if (r0 != null) goto L6;
    L9:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        return;
    L12:
        if (this.midiData.getValue() == null) goto L15;
        return;
    L15:
        if (KtvUtilsKt.C(r11) == true) goto L17;
    L19:
        String r2 = r11.l;
        if (r2 != null) goto L22;
    L25:
        boolean r3 = true;
    L27:
        if (r3 == true) goto L29;
    L31:
        w.a(TAG, "tryInitMidiRes");
        if (new PolarisFileWrapper(r11.q).exists() == true) goto L38;
        KtvMusicManager r4 = KtvMusicManager.m;
        if (KtvMusicManager.h(r11) == false) goto L36;
        return;
    L36:
        KtvMusicManager.e(r4, r11, this.musicDownloadCallback, false, null, false, 28);
        return;
    L38:
        if (KtvUtilsKt.w(r11.a) == true) goto L42;
        if (RealTimeChorusBusinessContext.Companion.j() == true) goto L42;
    L50:
        Disposable r12 = this.scoreDisposable;
        if (r12 == null) goto L58;
        r12.dispose();
        return;
    L58:
        return;
    L42:
        if (this.midiData.getValue() != null) goto L50;
        if (KtvUtilsKt.B(r11) == false) goto L50;
        long r5 = r11.a.getMId();
        String r6 = r11.q;
        String r7 = r11.l;
        String r8 = r11.p;
        if (r11.a.getMLyricType() != 2) goto L48;
        boolean r9 = true;
    L49:
        initMidiRes(r5, r6, r7, r8, r9);
        return;
    L48:
        r9 = false;
        goto L49
    L29:
        if (KtvUtilsKt.A(r11) == false) goto L31;
        w.a(TAG, "tryInitMidiRes lyricPath fix");
        com.bytedance.android.live.ktv.common.music.download.h r10 = com.bytedance.android.live.ktv.common.music.download.h.a;
        List r13 = r11.a.getMLyricUrlList();
        Intrinsics.checkNotNull(r13);
        r11.i(com.bytedance.android.live.ktv.common.music.download.h.d((String) ListProtector.get(r13, 0), r11.a.getMId()));
        goto L31
    L22:
        if (r2.length() == 0) goto L25;
        r3 = false;
        goto L27
    L17:
        if (KtvUtilsKt.B(r11) == true) goto L19;
        com.bytedance.android.live.ktv.common.music.download.h r14 = com.bytedance.android.live.ktv.common.music.download.h.a;
        r11.j(com.bytedance.android.live.ktv.common.music.download.h.e(r11.a.getMidiUrl(), r11.a.getMId()));
        goto L19
    L6:
        if (r0.length() == 0) goto L9;
        r1 = false;
        goto L10
    }

    public Observable<cb0.c> findMidiSegment(long r3) {
        Collection r0 = (Collection) this.midiData.getValue();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        com.bytedance.android.live.ktv.common.midi.e.b(TAG, "findMidiSegment midiData is null");
        return Observable.empty();
    L13:
        return Observable.just(this.midiData.getValue()).filter(d.a).flatMap(e.a).filter(new f(r3));
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final void handleSingProgress(final Long r7) {
        if (r7 == null) goto L5;
        r7.longValue();
        UtilityKotlinExtentionsKt.s(0, false, false, new AnonymousClass1(this, r7), 7);
        return;
    }

    public final void onCreate(LifecycleOwner r3) {
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        ILiveWrappedLivePusher.Companion.getClass();     // Catch: Throwable -> L7
        ILiveWrappedLivePusher r0 = ILiveWrappedLivePusher.a.b();     // Catch: Throwable -> L7
        if (r0 == null) goto L9;
        r0.getMediaEngineFactory();     // Catch: Throwable -> L7
    L9:
        if (KtvSettingHelper.w() == false) goto L11;
        KtvContext r1 = this.ktvContext;
    L12:
        if (r1 == null) goto L16;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r2 = r1.getKtvCoreViewModel();
        if (r2 == null) goto L16;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r4 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r2.getValue();
    L17:
        this.coreViewModel = (BaseCoreViewModel) r4;
        ((ObservableSubscribeProxy) r1.getKtvCoreViewModel().a().as(AutoDispose.bind(r3))).subscribe(new p(this, r3));
        observeCoreViewModel();
        fetchMidiConfig();
        return;
    L16:
        r4 = null;
        goto L17
    L11:
        KtvContext.Companion.getClass();
        r1 = KtvContext.a.g();
    L7:
        ALogger.i(bb0.b.b(), "MediaEngineFactory.loadLibrary fail, invoke class :RealTimeChorusMidiViewModel");
        goto L9
    }

    public void onIdle(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r7) {
        String r0 = null;
        if (r7 == null) goto L5;
        KtvRoomLyricsStateMachineConfig.d r8 = (KtvRoomLyricsStateMachineConfig.d) r7.a;
    L6:
        StringBuilder r1 = new StringBuilder("onIdle: from is singing? : ");
        boolean r2 = r8 instanceof KtvRoomLyricsStateMachineConfig.d.f;
        r1.append(r2);
        String r3 = r1.toString();
        ALogger.i(bb0.b.b(), "KtvStageViewModel :" + r3 + ", invoke class :RealTimeChorusMidiViewModel");
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L13;
        pd2.d r4 = pd2.d.n;
        if (r8 == null) goto L11;
        MusicPanel r5 = r8.b();
    L12:
        r4.getClass();
        pd2.d.I(r5, "Ktv  onIdle: from is singing? : " + r2);
        goto L13
    L11:
        r5 = null;
    L13:
        if (r2 == false) goto L36;
        MusicPanel r6 = com.bytedance.android.livesdk.ktvimpl.base.util.o.c((KtvRoomLyricsStateMachineConfig.d.f) r8);
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L34;
        pd2.d r9 = pd2.d.n;
        StringBuilder r10 = new StringBuilder("Ktv  onIdle: cur musicPanel singerId: ");
        MusicPanel r11 = r8.b();
        if (r11 == null) goto L23;
        OrderInfo r12 = r11.d();
        if (r12 == null) goto L23;
        InteractiveSongUserInfo r13 = r12.getTopUser();
        if (r13 == null) goto L23;
        String r14 = r13.getIdString();
    L24:
        r10.append(r14);
        r10.append("   sei senderId: ");
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r15 = ((KtvRoomLyricsStateMachineConfig.d.f) r8).c;
        if (r15 == null) goto L27;
        String r16 = r15.A();
    L28:
        r10.append(r16);
        r10.append("    getMidiScoreSeiRealMusicPanel musicSingerid: ");
        OrderInfo r17 = r6.d();
        if (r17 == null) goto L33;
        InteractiveSongUserInfo r18 = r17.getTopUser();
        if (r18 == null) goto L33;
        r0 = r18.getIdString();
    L33:
        r10.append(r0);
        String r19 = r10.toString();
        r9.getClass();
        pd2.d.I(r6, r19);
        goto L34
    L27:
        r16 = null;
    L23:
        r14 = null;
    L34:
        onSingFinish(KtvUtilsKt.w(r6.a), r6);
        return;
    L36:
        return;
    L5:
        r8 = null;
        goto L6
    }

    public final void onPreparing(com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.d r2) {
        Intrinsics.checkNotNullParameter(r2, "ktvCoreDataModel");
        MusicPanel r3 = r2.a;
        if (r3 != null) goto L5;
        return;
    L5:
        resetMidiData();
        tryInitMidiRes(r3);
    }

    public final void onSinging(com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.d r2) {
        Intrinsics.checkNotNullParameter(r2, "ktvCoreDataModel");
        MusicPanel r3 = r2.a;
        if (r3 != null) goto L5;
        return;
    L5:
        tryInitMidiRes(r3);
    }

    public final void setCoreViewModel(BaseCoreViewModel r1) {
        this.coreViewModel = r1;
    }

    public void setCurTotalScore(int r1) {
        this.curTotalScore = r1;
    }

    public final void setMidiConfig(MutableLiveData<g0> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.midiConfig = r2;
    }

    public final void setShowNoMidiHint(MutableLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.showNoMidiHint = r2;
    }

    public void setTotalScore(int r1) {
        this.totalScore = r1;
    }

    public void setUserOpenScore(boolean r1) {
        this.userOpenScore = r1;
    }

    public final void tryStartGetScoreInfoTimer(Long r11) {
        Collection r0 = (Collection) this.midiData.getValue();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        KtvRoomLyricsStateMachineConfig.d r4 = null;
        String r5 = null;
        if (r1 == false) goto L80;
        StateMachine.c.b r12 = (StateMachine.c.b) this.curState.getValue();
        if (r12 == null) goto L19;
        KtvRoomLyricsStateMachineConfig.d r13 = (KtvRoomLyricsStateMachineConfig.d) r12.c;
        if (r13 == null) goto L19;
        MusicPanel r14 = r13.b();
        if (r14 == null) goto L19;
        if (KtvUtilsKt.z(r14) != true) goto L19;
    L28:
        StateMachine.c.b r15 = (StateMachine.c.b) this.curState.getValue();
        if (r15 == null) goto L33;
        KtvRoomLyricsStateMachineConfig.d r16 = (KtvRoomLyricsStateMachineConfig.d) r15.c;
        if (r16 == null) goto L33;
        MusicPanel r17 = r16.b();
    L35:
        if (r17 == null) goto L45;
        String r2 = r17.q;
        if (r2 != null) goto L39;
    L42:
        boolean r3 = true;
    L43:
        if (r3 == false) goto L45;
        com.bytedance.android.live.ktv.common.music.download.h r6 = com.bytedance.android.live.ktv.common.music.download.h.a;
        r17.j(com.bytedance.android.live.ktv.common.music.download.h.e(r17.a.getMidiUrl(), r17.a.getMId()));
        goto L45
    L39:
        if (r2.length() == 0) goto L42;
        r3 = false;
    L45:
        if (r17 == null) goto L60;
        String r7 = r17.l;
        if (r7 != null) goto L49;
    L52:
        boolean r8 = true;
    L53:
        if (r8 == false) goto L60;
        com.bytedance.android.live.ktv.common.music.download.h r9 = com.bytedance.android.live.ktv.common.music.download.h.a;
        List r10 = r17.a.getMLyricUrlList();
        if (r10 == null) goto L58;
        String r18 = (String) CollectionsKt.firstOrNull(r10);
        if (r18 == null) goto L58;
    L59:
        r17.i(com.bytedance.android.live.ktv.common.music.download.h.d(r18, r17.a.getMId()));
    L58:
        r18 = "";
        goto L59
    L49:
        if (r7.length() == 0) goto L52;
        r8 = false;
    L60:
        StringBuilder r19 = new StringBuilder("tryStartGetScoreInfoTimer midiData is null midiLocalPath ");
        if (r17 == null) goto L63;
        r5 = r17.q;
    L63:
        r19.append(r5);
        com.bytedance.android.live.ktv.common.midi.e.b(TAG, r19.toString());
        if (r17 != null) goto L66;
        return;
    L66:
        if (KtvUtilsKt.w(r17.a) == true) goto L70;
        if (RealTimeChorusBusinessContext.Companion.j() == true) goto L70;
        return;
    L70:
        if (this.midiData.getValue() == null) goto L72;
        return;
    L72:
        if (KtvUtilsKt.B(r17) == false) goto L102;
        long r20 = r17.a.getMId();
        String r21 = r17.q;
        String r22 = r17.l;
        String r23 = r17.p;
        if (r17.a.getMLyricType() != 2) goto L76;
        boolean r24 = true;
    L77:
        initMidiRes(r20, r21, r22, r23, r24);
        return;
    L76:
        r24 = false;
        goto L77
    L102:
        return;
    L33:
        r17 = null;
    L19:
        StateMachine.c.b r110 = (StateMachine.c.b) this.curState.getValue();
        if (r110 == null) goto L34;
        KtvRoomLyricsStateMachineConfig.d r111 = (KtvRoomLyricsStateMachineConfig.d) r110.c;
        if (r111 == null) goto L34;
        MusicPanel r112 = r111.b();
        if (r112 == null) goto L34;
        if (KtvUtilsKt.G(r112) == true) goto L28;
    L34:
        r17 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(this.ktvContext);
        goto L35
    L80:
        if (isDisposed(this.scoreDisposable) == true) goto L87;
        if (r11 != null) goto L83;
        return;
    L83:
        if (Math.abs(this.curMidiProgress - r11.longValue()) <= 1000) goto L104;
        this.curMidiProgress = r11.longValue();
        seekMidiScoreProgress(r11.longValue());
        return;
    L104:
        return;
    L87:
        if (isDisposed(this.scoreDisposable) == false) goto L105;
        if (r11 == null) goto L106;
        BaseCoreViewModel r25 = this.coreViewModel;
        if (r25 == null) goto L93;
        r4 = r25.getCurState();
    L93:
        if ((r4 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L107;
        com.bytedance.android.live.ktv.common.midi.e.b(TAG, "tryStartGetScoreInfoTimer, progress = " + r11);
        if (r11.longValue() <= 1000) goto L97;
        seekMidiScoreProgress(r11.longValue());
    L97:
        this.scoreDisposable = du2.a.d(this.scoreTimeSetting, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new q(this));
        return;
    L107:
        return;
    L106:
        return;
    L105:
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public static final /* synthetic */ void access$handleState(RealTimeChorusMidiViewModel r0, StateMachine.c.b r1) {
        r0.handleState(r1);
    }

    public static final /* synthetic */ void access$setCurMidiProgress$p(RealTimeChorusMidiViewModel r0, long r1) {
        r0.curMidiProgress = r1;
    }

    private final void handleStateCoreData(KtvRoomLyricsStateMachineConfig.d r2, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.d r3) {
        if ((r2 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L6;
        onPreparing(r3);
        return;
    L6:
        if ((r2 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L10;
        onSinging(r3);
        return;
    }

    public Single<List<cb0.c>> findMidiSegments(long r3, long r5) {
        Collection r0 = (Collection) this.midiData.getValue();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        com.bytedance.android.live.ktv.common.midi.e.b(TAG, "findMidiSegments midiData is null");
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
        ALogger.i(bb0.b.b(), "findMidiSegmentsNew midiData is null, invoke class :RealTimeChorusMidiViewModel");
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

    public final void onSingFinish(boolean r3, MusicPanel r4) {
        com.bytedance.android.live.ktv.common.midi.e.b(TAG, "onSingFinish: musicPanel：" + r4);
        if (r4 == null) goto L9;
        if (r3 == false) goto L9;
        Disposable r5 = this.scoreDisposable;
        if (r5 == null) goto L8;
        r5.dispose();
    L8:
        resetMidiData();
        this.curMidiProgress = 0;
    L9:
        this.midiData.setValue(null);
        this.lastMidiHitFlag = false;
        this.lastMidiIndex = -1;
        this.mHitComboCalculator.a();
        this.curMusicId = 0;
    }

    public static final /* synthetic */ void access$handleStateCoreData(RealTimeChorusMidiViewModel r0, KtvRoomLyricsStateMachineConfig.d r1, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.d r2) {
        r0.handleStateCoreData(r1, r2);
    }

    private final float calScore(float r2, float r3, int r4) {
        if (r4 >= 0) goto L4;
        return r3;
    L4:
        Map<Integer, Float> r5 = this.scoreMap;
        if (r5 == null) goto L7;
        r5.put(Integer.valueOf(r4), Float.valueOf(r3));
    L7:
        return r3;
    }

    private final void initMidiRes(long r10, String r12, String r13, String r14, boolean r15) {
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.X0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b r0 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.a.a();
        boolean r1 = false;
        if (r0 == null) goto L5;
        boolean r2 = r0.isEngineOn();
    L7:
        if (r2 == false) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
    L18:
        boolean r4 = true;
    L20:
        if (TextUtils.isEmpty(r12) == true) goto L33;
        if (r15 == true) goto L33;
        if (isDisposed(this.midiDisposable) == false) goto L35;
        Collection r16 = (Collection) this.midiData.getValue();
        if (r16 != null) goto L28;
    L29:
        r1 = true;
    L30:
        if (r1 == false) goto L36;
        this.midiDisposable = Single.create(new j(this, r4, r13, r12, r14)).map(new k(this, r4, r12)).compose(RxUtil.rxSchedulerHelper()).subscribe(new l(this), new m(this, r10));
        return;
    L36:
        return;
    L28:
        if (r16.isEmpty() == false) goto L30;
    L35:
        return;
    L33:
        w.a(TAG, "initMidiRes fail, midiPath == null || isLrcLyric");
        this.showNoMidiHint.setValue(Boolean.TRUE);
        return;
    L15:
        if (RealTimeChorusBusinessContext.Companion.f() == true) goto L18;
        r4 = false;
        goto L20
    L9:
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L12;
        r3 = false;
        goto L13
    L5:
        r2 = false;
        goto L7
    }

    public static final /* synthetic */ void access$initMidiRes(RealTimeChorusMidiViewModel r0, long r1, String r3, String r4, String r5, boolean r6) {
        r0.initMidiRes(r1, r3, r4, r5, r6);
    }

    public static /* synthetic */ void initMidiRes$default(RealTimeChorusMidiViewModel r7, long r8, String r10, String r11, String r12, boolean r13, int r14, Object r15) {
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
