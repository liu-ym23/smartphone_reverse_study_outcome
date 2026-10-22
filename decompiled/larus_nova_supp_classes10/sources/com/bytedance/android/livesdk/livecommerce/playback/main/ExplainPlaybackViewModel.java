package com.bytedance.android.livesdk.livecommerce.playback.main;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import cf.l;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.arch.viewmodel.QStateViewModel;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.p0;
import com.bytedance.android.ec.model.playback.ECReplayVideo;
import com.bytedance.android.ec.model.playback.ExplainPlaybackExtraData;
import com.bytedance.android.ec.model.playback.ExplainPlaybackRequest;
import com.bytedance.android.ec.model.playback.ExplainPlaybackVideoInfo;
import com.bytedance.android.ec.model.playback.ExplainReplaySubTitle;
import com.bytedance.android.ec.model.playback.LogExtraData;
import com.bytedance.android.ec.model.playback.PlaybackEventExtraData;
import com.bytedance.android.ec.model.playback.ReplayCard;
import com.bytedance.android.ec.model.playback.ReplayCards;
import com.bytedance.android.ec.model.playback.SearchExplainReplayParams;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.playback.applog.ExplainPlayBackPDPEntryLogExtra;
import com.bytedance.android.livesdk.livecommerce.playback.interaction.ExplainPlaybackInteractionRequest;
import com.bytedance.android.livesdk.livecommerce.playback.model.EnterRoomInfo;
import com.bytedance.android.livesdk.livecommerce.playback.model.ExplainPlaybackFinalParams;
import com.bytedance.android.livesdk.livecommerce.playback.utils.ExplainPlaybackUtils;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\u0006\u0010o\u001a\u00020n\u0012\b\u0010r\u001a\u0004\u0018\u00010q\u0012\u0006\u0010v\u001a\u00020\u0002¢\u0006\u0004\bw\u0010xJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J.\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0002J\u0012\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u001c\u0010#\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$H\u0002J\u0012\u0010'\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010!H\u0002J\u001c\u0010+\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010!2\b\u0010*\u001a\u0004\u0018\u00010)H\u0002J.\u0010.\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015J\u001a\u00100\u001a\u00020\u00052\b\u0010/\u001a\u0004\u0018\u00010\u00192\b\u0010,\u001a\u0004\u0018\u00010\u0011J\u0010\u00102\u001a\u0002012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0006\u00103\u001a\u00020\u0005J\u0018\u00106\u001a\u00020\u00052\u0006\u00105\u001a\u0002042\b\u0010/\u001a\u0004\u0018\u00010\u0019J\u0006\u00107\u001a\u00020\u0005J\u0006\u00108\u001a\u00020\u0005J\u0006\u00109\u001a\u000201R\"\u0010:\u001a\u0002018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0014\u0010@\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010;R(\u0010C\u001a\u0004\u0018\u00010A2\b\u0010B\u001a\u0004\u0018\u00010A8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR(\u0010H\u001a\u0004\u0018\u00010G2\b\u0010B\u001a\u0004\u0018\u00010G8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR$\u0010M\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR$\u0010S\u001a\u0002012\u0006\u0010B\u001a\u0002018F@BX\u0086\u000e¢\u0006\f\n\u0004\bS\u0010;\u001a\u0004\bS\u0010=R$\u0010T\u001a\u0002012\u0006\u0010B\u001a\u0002018F@BX\u0086\u000e¢\u0006\f\n\u0004\bT\u0010;\u001a\u0004\bT\u0010=R$\u0010U\u001a\u0002012\u0006\u0010B\u001a\u0002018\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bU\u0010;\u001a\u0004\bU\u0010=R$\u0010V\u001a\u00020L2\u0006\u0010B\u001a\u00020L8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bV\u0010N\u001a\u0004\bW\u0010PR!\u0010]\u001a\b\u0012\u0004\u0012\u00020L0X8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R'\u0010c\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020_0^8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b`\u0010Z\u001a\u0004\ba\u0010bR\u0016\u0010d\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u001b\u0010j\u001a\u00020f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bg\u0010Z\u001a\u0004\bh\u0010iR\u0018\u0010l\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u0014\u0010o\u001a\u00020n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010pR\u0016\u0010r\u001a\u0004\u0018\u00010q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\br\u0010sR\u0011\u0010u\u001a\u00020L8F¢\u0006\u0006\u001a\u0004\bt\u0010P¨\u0006y"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/main/ExplainPlaybackViewModel;", "Lcom/bytedance/android/ec/core/arch/viewmodel/QStateViewModel;", "Lcom/bytedance/android/livesdk/livecommerce/playback/main/f;", "Lcom/bytedance/android/livesdk/livecommerce/playback/main/a$o;", "event", "", "tryMute", "Lcom/bytedance/android/livesdk/livecommerce/playback/main/a$c;", "hasShowedAnchorEvent", "Lcom/bytedance/android/livesdk/livecommerce/playback/main/a$d;", "hideBackgroundEvent", "Lcom/bytedance/android/livesdk/livecommerce/playback/main/a$n;", "showLoading", "Lcom/bytedance/android/livesdk/livecommerce/playback/main/a$f;", "onPlaySuccess", "initData", "initNormalData", "Lcom/bytedance/android/ec/model/playback/ExplainPlaybackVideoInfo;", "videoInfo", "Lcom/bytedance/android/ec/model/playback/ECReplayVideo;", "videoMdrInfo", "", "Lcom/bytedance/android/ec/model/playback/ExplainReplaySubTitle;", "videoSubTitle", "tryPreloadVideo", "Lcom/bytedance/android/ec/model/promotion/ECUIPromotion;", "promotion", "Lcom/bytedance/android/livesdk/livecommerce/playback/interaction/ExplainPlaybackInteractionRequest;", "buildInteractionRequestParams", "Lol/a;", "response", "Ldj2/a;", "getAuthorInfoEntity", "Lorg/json/JSONObject;", "json", "appendReplayType", "Lcom/bytedance/android/ec/model/playback/SearchExplainReplayParams;", "playbackParams", "initSearchData", "appendEcomSceneIds", "jsonObject", "Lcom/bytedance/android/ec/model/playback/ExplainPlaybackRequest;", "playbackReqParams", "replacePromotionIdAndRoomId", "explainVideo", "subTitle", "updateVideo", "uiPromotion", "initExplainTracker", "", "isVideoPreload", "reloadVideo", "", "position", "onProductCardShow", "resetPreloadVideoStatus", "onUnBind", "canEnableSubTitle", "closePageByUser", "Z", "getClosePageByUser", "()Z", "setClosePageByUser", "(Z)V", "isLiveEntranceEnable", "Lcom/bytedance/android/livesdk/livecommerce/playback/main/b;", "<set-?>", "explainPlaybackOriginParams", "Lcom/bytedance/android/livesdk/livecommerce/playback/main/b;", "getExplainPlaybackOriginParams", "()Lcom/bytedance/android/livesdk/livecommerce/playback/main/b;", "Lcom/bytedance/android/livesdk/livecommerce/playback/model/ExplainPlaybackFinalParams;", "explainPlaybackFinalFinalParams", "Lcom/bytedance/android/livesdk/livecommerce/playback/model/ExplainPlaybackFinalParams;", "getExplainPlaybackFinalFinalParams", "()Lcom/bytedance/android/livesdk/livecommerce/playback/model/ExplainPlaybackFinalParams;", "", "targetEntranceInfo", "Ljava/lang/String;", "getTargetEntranceInfo", "()Ljava/lang/String;", "setTargetEntranceInfo", "(Ljava/lang/String;)V", "isFromProductDetail", "isFromLive", "isFromSearch", "ecomSceneId", "getEcomSceneId", "", "tryPreloadVideoIds$delegate", "Lkotlin/Lazy;", "getTryPreloadVideoIds", "()Ljava/util/Set;", "tryPreloadVideoIds", "", "Lcom/bytedance/android/livesdk/livecommerce/playback/interaction/a;", "interactionContents$delegate", "getInteractionContents", "()Ljava/util/Map;", "interactionContents", "currentCardPosition", "I", "Landroid/os/Handler;", "handler$delegate", "getHandler", "()Landroid/os/Handler;", "handler", "Ljava/lang/Runnable;", "reloadVideoRunnable", "Ljava/lang/Runnable;", "Lcom/bytedance/android/livesdk/livecommerce/playback/main/h;", "repository", "Lcom/bytedance/android/livesdk/livecommerce/playback/main/h;", "Landroid/os/Bundle;", "bundle", "Landroid/os/Bundle;", "getNewSourceType", "newSourceType", "explainPlaybackState", "<init>", "(Lcom/bytedance/android/livesdk/livecommerce/playback/main/h;Landroid/os/Bundle;Lcom/bytedance/android/livesdk/livecommerce/playback/main/f;)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExplainPlaybackViewModel extends QStateViewModel<f> {
    private final Bundle bundle;
    private volatile boolean closePageByUser;
    private int currentCardPosition;
    private String ecomSceneId;
    private ExplainPlaybackFinalParams explainPlaybackFinalFinalParams;
    private b explainPlaybackOriginParams;
    private final Lazy handler$delegate;
    private final Lazy interactionContents$delegate;
    private boolean isFromLive;
    private boolean isFromProductDetail;
    private boolean isFromSearch;
    private final boolean isLiveEntranceEnable;
    private Runnable reloadVideoRunnable;
    private final h repository;
    private String targetEntranceInfo;
    private final Lazy tryPreloadVideoIds$delegate;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackViewModel$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/main/a$o;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/livecommerce/playback/main/a$o;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.livecommerce.playback.main.a.o, Unit> {
        public AnonymousClass1(ExplainPlaybackViewModel r8) {
            super(1, r8, ExplainPlaybackViewModel.class, "tryMute", "tryMute(Lcom/bytedance/android/livesdk/livecommerce/playback/main/ExplainPlaybackEvent$TryMuteEvent;)V", 0);
        }

        public final void invoke(com.bytedance.android.livesdk.livecommerce.playback.main.a.o r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            ExplainPlaybackViewModel.access$tryMute((ExplainPlaybackViewModel) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((com.bytedance.android.livesdk.livecommerce.playback.main.a.o) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackViewModel$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/main/a$n;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/livecommerce/playback/main/a$n;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.livecommerce.playback.main.a.n, Unit> {
        public AnonymousClass2(ExplainPlaybackViewModel r8) {
            super(1, r8, ExplainPlaybackViewModel.class, "showLoading", "showLoading(Lcom/bytedance/android/livesdk/livecommerce/playback/main/ExplainPlaybackEvent$ToShowLoading;)V", 0);
        }

        public final void invoke(com.bytedance.android.livesdk.livecommerce.playback.main.a.n r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            ExplainPlaybackViewModel.access$showLoading((ExplainPlaybackViewModel) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((com.bytedance.android.livesdk.livecommerce.playback.main.a.n) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackViewModel$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/main/a$d;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/livecommerce/playback/main/a$d;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.livecommerce.playback.main.a.d, Unit> {
        public AnonymousClass3(ExplainPlaybackViewModel r8) {
            super(1, r8, ExplainPlaybackViewModel.class, "hideBackgroundEvent", "hideBackgroundEvent(Lcom/bytedance/android/livesdk/livecommerce/playback/main/ExplainPlaybackEvent$HideBackgroundEvent;)V", 0);
        }

        public final void invoke(com.bytedance.android.livesdk.livecommerce.playback.main.a.d r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            ExplainPlaybackViewModel.access$hideBackgroundEvent((ExplainPlaybackViewModel) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((com.bytedance.android.livesdk.livecommerce.playback.main.a.d) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackViewModel$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/main/a$c;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/livecommerce/playback/main/a$c;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.livecommerce.playback.main.a.c, Unit> {
        public AnonymousClass4(ExplainPlaybackViewModel r8) {
            super(1, r8, ExplainPlaybackViewModel.class, "hasShowedAnchorEvent", "hasShowedAnchorEvent(Lcom/bytedance/android/livesdk/livecommerce/playback/main/ExplainPlaybackEvent$HasShowedAnchorEvent;)V", 0);
        }

        public final void invoke(com.bytedance.android.livesdk.livecommerce.playback.main.a.c r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            ExplainPlaybackViewModel.access$hasShowedAnchorEvent((ExplainPlaybackViewModel) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((com.bytedance.android.livesdk.livecommerce.playback.main.a.c) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackViewModel$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/main/a$f;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/livecommerce/playback/main/a$f;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.livecommerce.playback.main.a.f, Unit> {
        public AnonymousClass5(ExplainPlaybackViewModel r8) {
            super(1, r8, ExplainPlaybackViewModel.class, "onPlaySuccess", "onPlaySuccess(Lcom/bytedance/android/livesdk/livecommerce/playback/main/ExplainPlaybackEvent$PlaySuccessEvent;)V", 0);
        }

        public final void invoke(com.bytedance.android.livesdk.livecommerce.playback.main.a.f r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            ExplainPlaybackViewModel.access$onPlaySuccess((ExplainPlaybackViewModel) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((com.bytedance.android.livesdk.livecommerce.playback.main.a.f) r1);
            return Unit.INSTANCE;
        }
    }

    public static final class a implements Runnable {
        public final /* synthetic */ ExplainPlaybackViewModel a;
        public final /* synthetic */ ExplainPlaybackVideoInfo b;

        public a(ExplainPlaybackViewModel r1, ExplainPlaybackVideoInfo r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (this.a.isVideoPreload(this.b) == false) goto L9;
            WeakReference<com.bytedance.android.livesdk.livecommerce.playback.video.e> r0 = com.bytedance.android.livesdk.livecommerce.playback.video.d.a;     // Catch: Throwable -> L6
            com.bytedance.android.livesdk.livecommerce.playback.video.d.a(this.b.getVideoId());     // Catch: Throwable -> L6
            this.a.reloadVideo();     // Catch: Throwable -> L6
            cj2.b.b(LocationMonitorConst.TIMEOUT, null, null);     // Catch: Throwable -> L6
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackViewModel$initNormalData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackViewModel$initNormalData$1", f = "ExplainPlaybackViewModel.kt", i = {0}, l = {261}, m = "invokeSuspend", n = {"tempExplainPlaybackOriginData"}, s = {"L$1"})
    public static final class C02811 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ ExplainPlaybackViewModel this$0;

        public C02811(ExplainPlaybackViewModel r1, Continuation r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "completion");
            return new C02811(this.this$0, r3);
        }

        public final Object invoke(Object r1, Object r2) {
            return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r36) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            String r9 = "";
            Map r11 = null;
            if (r2 == 0) goto L10;
            if (r2 != 1) goto L9;
            b r3 = (b) this.L$1;
            String r4 = (String) this.L$0;
            ResultKt.throwOnFailure(r36);     // Catch: Exception -> L256
            Object r5 = r36;
            b r12 = r3;
        L37:
            final ol.a r13 = (ol.a) r5;     // Catch: Exception -> L256
            if (r13 != null) goto L40;
        L241:
            int r6 = bj2.a.a;     // Catch: Exception -> L256
            StringBuilder r7 = new StringBuilder("initNormalData fail response.statusCode:");     // Catch: Exception -> L256
            if (r13 == null) goto L244;
            Integer r8 = Boxing.boxInt(((com.bytedance.android.ec.model.g) r13).statusCode);     // Catch: Exception -> L256
        L245:
            r7.append(r8);     // Catch: Exception -> L256
            bj2.a.b("ExplainPlaybackViewModel", r7.toString());     // Catch: Exception -> L256
            Context r10 = ExplainPlaybackUtils.b();     // Catch: Exception -> L256
            if (r10 == null) goto L250;
            String r14 = r10.getString(2131896466);     // Catch: Exception -> L256
            if (r14 == null) goto L250;
            com.bytedance.android.ec.core.arch.event.c.d(this.this$0, new com.bytedance.android.livesdk.livecommerce.playback.main.a.C0082a(r14));     // Catch: Exception -> L256
        L250:
            StringBuilder r15 = new StringBuilder("initNormalData fail response.statusCode:");     // Catch: Exception -> L256
            if (r13 == null) goto L253;
            Integer r16 = Boxing.boxInt(((com.bytedance.android.ec.model.g) r13).statusCode);     // Catch: Exception -> L256
        L254:
            r15.append(r16);     // Catch: Exception -> L256
            ECExceptionMonitor.c(r15.toString());     // Catch: Exception -> L256
        L268:
            return Unit.INSTANCE;
        L253:
            r16 = null;
            goto L254
        L244:
            r8 = null;
            goto L245
        L40:
            if (((com.bytedance.android.ec.model.g) r13).statusCode != 0) goto L241;
            bj2.a.b("ExplainPlaybackViewModel", "initNormalData success");     // Catch: Exception -> L256
            i r0 = i.a;     // Catch: Exception -> L256
            ExplainPlaybackFragment.j.getClass();     // Catch: Exception -> L256
            com.bytedance.android.ec.monitor.duration.d r17 = r0.get(ExplainPlaybackFragment.i);     // Catch: Exception -> L256
            if (r17 == null) goto L44;
            r17.a("request_end");     // Catch: Exception -> L256
            Unit r18 = Unit.INSTANCE;     // Catch: Exception -> L256
        L44:
            String r19 = cj2.b.a;     // Catch: Exception -> L256
            ExplainPlaybackVideoInfo r20 = r13.s();     // Catch: Exception -> L256
            if (r20 == null) goto L47;
            String r21 = r20.getPlayUrl();     // Catch: Exception -> L256
        L48:
            ExplainPlaybackVideoInfo r22 = r13.s();     // Catch: Exception -> L256
            if (r22 == null) goto L51;
            String r23 = r22.getVideoId();     // Catch: Exception -> L256
        L52:
            cj2.b.d(r21, r23);     // Catch: Exception -> L256
            com.bytedance.android.ec.monitor.duration.d r24 = r0.get(cj2.b.a);     // Catch: Exception -> L256
            if (r24 == null) goto L55;
            r24.a("render_start");     // Catch: Exception -> L256
        L55:
            cj2.b.f = true;     // Catch: Exception -> L256
            int r25 = ECSdk.a;     // Catch: Exception -> L256
            l r26 = (l) ECSdk.a(l.class);     // Catch: Exception -> L256
            if (r26 == null) goto L58;
            final ECUIPromotion r27 = r26.Ha(r13.i(), ExplainPlaybackUtils.b(), r13.getServerTime(), Boxing.boxBoolean(this.this$0.isFromLive()));     // Catch: Exception -> L256
        L59:
            ExplainPlaybackVideoInfo r28 = r13.s();     // Catch: Exception -> L256
            if (r28 == null) goto L62;
            String r29 = r28.getFragmentId();     // Catch: Exception -> L256
        L63:
            b r30 = this.this$0.getExplainPlaybackOriginParams();     // Catch: Exception -> L256
            if (r30 == null) goto L69;
            LogExtraData r31 = r30.d;     // Catch: Exception -> L256
            if (r31 == null) goto L69;
            String r32 = r31.getEnterScene();     // Catch: Exception -> L256
            if (r32 == null) goto L69;
        L70:
            b r33 = this.this$0.getExplainPlaybackOriginParams();     // Catch: Exception -> L256
            if (r33 == null) goto L75;
            LogExtraData r34 = r33.d;     // Catch: Exception -> L256
            if (r34 == null) goto L75;
            r34.setFragmentId(r29);     // Catch: Exception -> L256
        L75:
            b r35 = this.this$0.getExplainPlaybackOriginParams();     // Catch: Exception -> L256
            if (r35 == null) goto L80;
            LogExtraData r37 = r35.d;     // Catch: Exception -> L256
            if (r37 == null) goto L80;
            String r38 = r37.getEntranceInfo();     // Catch: Exception -> L256
        L81:
            JSONObject r39 = c.c(r38);     // Catch: Exception -> L256
            if (r39 != null) goto L84;
            r39 = new JSONObject();     // Catch: Exception -> L256
        L84:
            r39.put("source_method", "replay_popup_card");     // Catch: Exception -> L256
            b r40 = this.this$0.getExplainPlaybackOriginParams();     // Catch: Exception -> L256
            if (r40 == null) goto L90;
            LogExtraData r41 = r40.d;     // Catch: Exception -> L256
            if (r41 == null) goto L90;
            String r42 = r41.getCarrierSource();     // Catch: Exception -> L256
            if (r42 == null) goto L90;
        L91:
            r39.put("carrier_source", r42);     // Catch: Exception -> L256
            r39.put("fragment_id", r29);     // Catch: Exception -> L256
            r39.put("enter_scene", r32);     // Catch: Exception -> L256
            ExplainPlaybackViewModel.access$appendEcomSceneIds(this.this$0, r39);     // Catch: Exception -> L256
            ExplainPlaybackViewModel.access$appendReplayType(this.this$0, r39, r13);     // Catch: Exception -> L256
            ExplainPlaybackViewModel r43 = this.this$0;     // Catch: Exception -> L256
            b r44 = r43.getExplainPlaybackOriginParams();     // Catch: Exception -> L256
            if (r44 == null) goto L94;
            ExplainPlaybackRequest r45 = r44.a;     // Catch: Exception -> L256
        L95:
            ExplainPlaybackViewModel.access$replacePromotionIdAndRoomId(r43, r39, r45);     // Catch: Exception -> L256
            this.this$0.setTargetEntranceInfo(r39.toString());     // Catch: Exception -> L256
            if (r27 == null) goto L104;
            JSONObject r46 = c.c(this.this$0.getTargetEntranceInfo());     // Catch: Exception -> L256
            if (r46 == null) goto L101;
            String r47 = r46.optString("ecom_group_type");     // Catch: Exception -> L256
            if (r47 == null) goto L101;
        L102:
            r27.setEcomGroupType(r47);     // Catch: Exception -> L256
        L101:
            r47 = "product_card";
        L104:
            if (this.this$0.isFromLive() == false) goto L120;
            JSONObject r48 = new JSONObject();     // Catch: Exception -> L256
            b r49 = this.this$0.getExplainPlaybackOriginParams();     // Catch: Exception -> L256
            if (r49 == null) goto L111;
            ExplainPlaybackRequest r50 = r49.a;     // Catch: Exception -> L256
            if (r50 == null) goto L111;
            String r51 = r50.getAuthorId();     // Catch: Exception -> L256
            if (r51 == null) goto L111;
        L112:
            r48.put("anchor_id", r51);     // Catch: Exception -> L256
            b r52 = this.this$0.getExplainPlaybackOriginParams();     // Catch: Exception -> L256
            if (r52 == null) goto L118;
            ExplainPlaybackRequest r53 = r52.a;     // Catch: Exception -> L256
            if (r53 == null) goto L118;
            String r54 = r53.getRoomId();     // Catch: Exception -> L256
            if (r54 == null) goto L118;
        L119:
            r48.put("room_id", r54);     // Catch: Exception -> L256
        L121:
            if (r48 == null) goto L137;
            ExplainPlaybackViewModel r55 = this.this$0;     // Catch: Exception -> L256
            b r56 = r55.getExplainPlaybackOriginParams();     // Catch: Exception -> L256
            if (r56 == null) goto L125;
            ExplainPlaybackRequest r57 = r56.a;     // Catch: Exception -> L256
        L126:
            ExplainPlaybackViewModel.access$replacePromotionIdAndRoomId(r55, r48, r57);     // Catch: Exception -> L256
            if (r27 == null) goto L137;
            if (r27.getExtraTransmissibleLogParams() != null) goto L131;
            r27.setExtraTransmissibleLogParams(new JSONObject());     // Catch: Exception -> L256
        L131:
            JSONObject r58 = r27.getExtraTransmissibleLogParams();     // Catch: Exception -> L256
            if (r58 == null) goto L137;
            Iterator<String> r59 = r48.keys();     // Catch: Exception -> L256
        L135:
            if (r59.hasNext() == false) goto L137;
            String r60 = r59.next();     // Catch: Exception -> L256
            r58.put(r60, r48.get(r60));     // Catch: Exception -> L256
            goto L135
        L125:
            r57 = null;
        L137:
            int r61 = com.bytedance.android.livesdk.livecommerce.playback.utils.a.a;     // Catch: Exception -> L256
            List r62 = r13.c();     // Catch: Exception -> L256
            Long r63 = Boxing.boxLong(r13.getServerTime());     // Catch: Exception -> L256
            boolean r110 = false;
            long r111 = 0;
            if (r63.longValue() <= 0) goto L140;
            boolean r64 = true;
        L141:
            if (r64 == true) goto L144;
            r63 = null;
        L144:
            if (r63 != null) goto L149;
            ExplainPlaybackExtraData r65 = r13.f();     // Catch: Exception -> L256
            if (r65 == null) goto L148;
            r63 = Boxing.boxLong(r65.getServerTime());     // Catch: Exception -> L256
            goto L149
        L148:
            r63 = null;
        L149:
            if (r63 == null) goto L151;
            long r66 = r63.longValue();     // Catch: Exception -> L256
        L152:
            com.bytedance.android.livesdk.livecommerce.playback.utils.a.a(r62, r27, r66);     // Catch: Exception -> L256
            b r67 = this.this$0.getExplainPlaybackOriginParams();     // Catch: Exception -> L256
            if (r67 == null) goto L167;
            PlaybackEventExtraData r68 = r67.e;     // Catch: Exception -> L256
            if (r68 == null) goto L167;
            if (r27 != null) goto L158;
        L161:
            String r69 = "1";
        L162:
            r68.setWithSku(r69);     // Catch: Exception -> L256
            if (r27 == null) goto L165;
            String r70 = r27.getEventItemType();     // Catch: Exception -> L256
        L166:
            r68.setCommodityType(r70);     // Catch: Exception -> L256
            goto L167
        L165:
            r70 = null;
            goto L166
        L158:
            if (r27.getSingleSku() != true) goto L161;
            r69 = BDLocationException.ERROR_TIMEOUT;
        L167:
            cj2.c r71 = cj2.a.a;     // Catch: Exception -> L256
            int r72 = cj2.c.d;     // Catch: Exception -> L256
            b r73 = this.this$0.getExplainPlaybackOriginParams();     // Catch: Exception -> L256
            if (r73 == null) goto L170;
            LogExtraData r74 = r73.d;     // Catch: Exception -> L256
        L171:
            b r75 = this.this$0.getExplainPlaybackOriginParams();     // Catch: Exception -> L256
            if (r75 == null) goto L174;
            PlaybackEventExtraData r76 = r75.e;     // Catch: Exception -> L256
        L176:
            if (r27 == null) goto L178;
            String r77 = r27.getPromotionId();     // Catch: Exception -> L256
        L179:
            if (r27 == null) goto L181;
            String r78 = r27.getProductId();     // Catch: Exception -> L256
        L182:
            if (r27 == null) goto L184;
            r11 = r27.getEventParams();     // Catch: Exception -> L256
        L184:
            dj2.f r79 = new dj2.f(r77, r78, r11);     // Catch: Exception -> L256
            b r80 = this.this$0.getExplainPlaybackOriginParams();     // Catch: Exception -> L256
            if (r80 == null) goto L187;
            ExplainPlayBackPDPEntryLogExtra r81 = r80.f;     // Catch: Exception -> L256
        L188:
            cj2.c r82 = cj2.c.a.a(new dj2.e(r79, r74, r76, r81));     // Catch: Exception -> L256
            Intrinsics.checkNotNullParameter(r82, "replayTracker");     // Catch: Exception -> L256
            cj2.a.a = r82;     // Catch: Exception -> L256
            if (ECSettingKeys.I0() == false) goto L193;
            ECReplayVideo r83 = r13.u();     // Catch: Exception -> L256
            if (r83 != null) goto L194;
            r83 = r13.t();     // Catch: Exception -> L256
        L194:
            final ECReplayVideo r85 = r83;
            ExplainPlaybackViewModel r86 = this.this$0;     // Catch: Exception -> L256
            ExplainPlaybackVideoInfo r112 = r13.s();     // Catch: Exception -> L256
            ECPromotion r210 = r13.i();     // Catch: Exception -> L256
            List r211 = r13.d();     // Catch: Exception -> L256
            List r212 = r13.c();     // Catch: Exception -> L256
            Long r87 = Boxing.boxLong(r13.getServerTime());     // Catch: Exception -> L256
            if (r87.longValue() <= 0) goto L197;
            boolean r88 = true;
        L198:
            if (r88 == true) goto L201;
            r87 = null;
        L201:
            if (r87 != null) goto L206;
            ExplainPlaybackExtraData r89 = r13.f();     // Catch: Exception -> L256
            if (r89 == null) goto L205;
            r87 = Boxing.boxLong(r89.getServerTime());     // Catch: Exception -> L256
            goto L206
        L205:
            r87 = null;
        L206:
            if (r87 == null) goto L208;
            r111 = r87.longValue();     // Catch: Exception -> L256
        L208:
            ExplainPlaybackViewModel.access$setExplainPlaybackFinalFinalParams$p(r86, new ExplainPlaybackFinalParams(r112, r85, null, r210, r211, r212, r111, r13.n(), r13.a(), null, r13.j(), r13.k(), Boxing.boxLong(r13.l()), 516, null));     // Catch: Exception -> L256
            ReplayCards r90 = r13.j();     // Catch: Exception -> L256
            if (r90 == null) goto L215;
            List r91 = r90.getProductReplayCards();     // Catch: Exception -> L256
            if (r91 == null) goto L215;
            ReplayCard r92 = (ReplayCard) CollectionsKt.firstOrNull(r91);     // Catch: Exception -> L256
            if (r92 == null) goto L215;
            final List r93 = r92.getSubTitle();     // Catch: Exception -> L256
        L217:
            if (this.this$0.isVideoPreload(r12.h) == false) goto L219;
            ExplainPlaybackViewModel.access$setState(this.this$0, new ExplainPlaybackViewModel$initNormalData$1$invokeSuspend$$inlined$also$lambda$3(r27, r13, r85, this));     // Catch: Exception -> L256
        L221:
            if (r13.s() == null) goto L228;
            ExplainPlaybackVideoInfo r94 = r13.s();     // Catch: Exception -> L256
            if (r94 == null) goto L225;
            String r113 = r94.getPlayUrl();     // Catch: Exception -> L256
        L227:
            if (TextUtils.isEmpty(r113) == false) goto L268;
        L225:
            r113 = null;
        L228:
            ExplainPlaybackVideoInfo r95 = r12.h;     // Catch: Exception -> L256
            if (r95 == null) goto L268;
            String r96 = r95.getPlayUrl();     // Catch: Exception -> L256
            if (r96 == null) goto L268;
            if (r96.length() != 0) goto L235;
            r110 = true;
        L235:
            if (r110 != true) goto L268;
            Context r97 = ExplainPlaybackUtils.b();     // Catch: Exception -> L256
            if (r97 == null) goto L268;
            String r98 = r97.getString(2131896482);     // Catch: Exception -> L256
            if (r98 == null) goto L268;
            com.bytedance.android.ec.core.arch.event.c.d(this.this$0, new com.bytedance.android.livesdk.livecommerce.playback.main.a.C0082a(r98));     // Catch: Exception -> L256
            goto L268
        L219:
            ExplainPlaybackViewModel.access$setState(this.this$0, new ExplainPlaybackViewModel$initNormalData$1$invokeSuspend$$inlined$also$lambda$4(r13, r85, r93, r27, this));     // Catch: Exception -> L256
        L215:
            r93 = null;
            goto L217
        L197:
            r88 = false;
            goto L198
        L193:
            r83 = r13.t();     // Catch: Exception -> L256
            goto L194
        L187:
            r81 = null;
            goto L188
        L181:
            r78 = null;
            goto L182
        L178:
            r77 = null;
            goto L179
        L174:
            r76 = null;
            goto L176
        L170:
            r74 = null;
            goto L171
        L151:
            r66 = 0;
            goto L152
        L140:
            r64 = false;
        L118:
            r54 = "";
        L111:
            r51 = "";
            goto L112
        L120:
            r48 = c.c(this.this$0.getTargetEntranceInfo());     // Catch: Exception -> L256
            goto L121
        L94:
            r45 = null;
        L90:
            r42 = "";
        L80:
            r38 = null;
        L69:
            r32 = "";
            goto L70
        L62:
            r29 = null;
            goto L63
        L58:
            r27 = null;
            goto L59
        L51:
            r23 = null;
            goto L52
        L47:
            r21 = null;
            goto L48
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r36);
            Bundle r99 = ExplainPlaybackViewModel.access$getBundle$p(this.this$0);     // Catch: Exception -> L256
            if (r99 == null) goto L268;
            String r100 = r99.getString("key_explain_play_back_schema");     // Catch: Exception -> L256
            if (r100 == null) goto L268;
            String r101 = cj2.b.a;     // Catch: Exception -> L256
            i r102 = i.a;     // Catch: Exception -> L256
            com.bytedance.android.ec.monitor.duration.d r103 = r102.get(cj2.b.a);     // Catch: Exception -> L256
            if (r103 == null) goto L18;
            r103.a("schema_parse_start");     // Catch: Exception -> L256
        L18:
            int r104 = b.k;     // Catch: Exception -> L256
            b r105 = b.a.a(r100);     // Catch: Exception -> L256
            ExplainPlaybackViewModel.access$setExplainPlaybackOriginParams$p(this.this$0, r105);     // Catch: Exception -> L256
            LogExtraData r106 = r105.d;     // Catch: Exception -> L256
            if (r106 == null) goto L21;
            String r107 = r106.getEnterScene();     // Catch: Exception -> L256
        L22:
            com.bytedance.android.ec.monitor.duration.d r108 = r102.get(cj2.b.a);     // Catch: Exception -> L256
            if (r108 == null) goto L25;
            r108.a("schema_parse_end");     // Catch: Exception -> L256
        L25:
            com.bytedance.android.ec.monitor.duration.d r109 = r102.get(cj2.b.a);     // Catch: Exception -> L256
            if (r109 == null) goto L30;
            if (r107 != null) goto L29;
            r107 = "";
        L29:
            r109.b("enter_from", r107);     // Catch: Exception -> L256
        L30:
            ExplainPlaybackViewModel.access$setState(this.this$0, new ExplainPlaybackViewModel$initNormalData$1$invokeSuspend$$inlined$also$lambda$1(this));     // Catch: Exception -> L256
            ExplainPlaybackVideoInfo r114 = r105.h;     // Catch: Exception -> L256
            if (r114 == null) goto L33;
            ExplainPlaybackViewModel.access$tryPreloadVideo(this.this$0, r114, r105.i, r105.j);     // Catch: Exception -> L256
            Unit r115 = Unit.INSTANCE;     // Catch: Exception -> L256
        L33:
            CoroutineDispatcher r116 = Dispatchers.getIO();     // Catch: Exception -> L256
            ExplainPlaybackViewModel$initNormalData$1$invokeSuspend$$inlined$also$lambda$2 r117 = new ExplainPlaybackViewModel$initNormalData$1$invokeSuspend$$inlined$also$lambda$2(r105, null, this);     // Catch: Exception -> L256
            this.L$0 = r100;     // Catch: Exception -> L256
            this.L$1 = r105;     // Catch: Exception -> L256
            this.label = 1;     // Catch: Exception -> L256
            r5 = BuildersKt.withContext(r116, r117, this);     // Catch: Exception -> L256
            if (r5 != r1) goto L36;
            return r1;
        L36:
            r12 = r105;
            goto L37
        L21:
            r107 = null;
        L256:
            e = move-exception;
            int r118 = bj2.a.a;
            bj2.a.b("ExplainPlaybackViewModel", "initNormalData fail error:" + e.getMessage());
            Context r119 = ExplainPlaybackUtils.b();
            if (r119 == null) goto L262;
            String r120 = r119.getString(2131896458);
            if (r120 == null) goto L262;
            com.bytedance.android.ec.core.arch.event.c.d(this.this$0, new com.bytedance.android.livesdk.livecommerce.playback.main.a.C0082a(r120));
        L262:
            String r121 = e.getMessage();
            if (r121 == null) goto L266;
            r9 = r121;
        L266:
            ECExceptionMonitor.c(r9);
            goto L268
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackViewModel$onProductCardShow$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackViewModel$onProductCardShow$1", f = "ExplainPlaybackViewModel.kt", i = {}, l = {611}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02821 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $position;
        final /* synthetic */ ECUIPromotion $uiPromotion;
        int label;
        final /* synthetic */ ExplainPlaybackViewModel this$0;

        public C02821(ExplainPlaybackViewModel r1, int r2, ECUIPromotion r3, Continuation r4) {
            this.this$0 = r1;
            this.$position = r2;
            this.$uiPromotion = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Intrinsics.checkNotNullParameter(r5, "completion");
            return new C02821(this.this$0, this.$position, this.$uiPromotion, r5);
        }

        public final Object invoke(Object r1, Object r2) {
            return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            ResultKt.throwOnFailure(r5);     // Catch: Exception -> L25
        L16:
            final com.bytedance.android.livesdk.livecommerce.playback.interaction.a r6 = (com.bytedance.android.livesdk.livecommerce.playback.interaction.a) r5;     // Catch: Exception -> L25
            if (r6 == null) goto L22;
            if (((com.bytedance.android.ec.model.g) r6).statusCode != 0) goto L22;
            ExplainPlaybackViewModel.access$getInteractionContents$p(this.this$0).put(Boxing.boxInt(this.$position), r6);     // Catch: Exception -> L25
        L22:
            if (this.$position != ExplainPlaybackViewModel.access$getCurrentCardPosition$p(this.this$0)) goto L28;
            ExplainPlaybackViewModel.access$setState(this.this$0, new C00811(this, r6));     // Catch: Exception -> L25
        L28:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r5);
            if (ExplainPlaybackViewModel.access$getInteractionContents$p(this.this$0).containsKey(Boxing.boxInt(this.$position)) == false) goto L13;
            r6 = (com.bytedance.android.livesdk.livecommerce.playback.interaction.a) ExplainPlaybackViewModel.access$getInteractionContents$p(this.this$0).get(Boxing.boxInt(this.$position));     // Catch: Exception -> L25
            goto L22
        L13:
            CoroutineDispatcher r7 = Dispatchers.getIO();     // Catch: Exception -> L25
            ExplainPlaybackViewModel$onProductCardShow$1$response$response$1 r2 = new ExplainPlaybackViewModel$onProductCardShow$1$response$response$1(this, null);     // Catch: Exception -> L25
            this.label = 1;     // Catch: Exception -> L25
            r5 = BuildersKt.withContext(r7, r2, this);     // Catch: Exception -> L25
            if (r5 != r0) goto L16;
            return r0;
        L25:
            e = move-exception;
            int r3 = bj2.a.a;
            bj2.a.b("ExplainPlaybackViewModel", "interaction initNormalData fail error:" + e.getMessage());
            ECExceptionMonitor.e(e);
            goto L28
        }
    }

    private final Handler getHandler() {
        return (Handler) this.handler$delegate.getValue();
    }

    private final Map<Integer, com.bytedance.android.livesdk.livecommerce.playback.interaction.a> getInteractionContents() {
        return (Map) this.interactionContents$delegate.getValue();
    }

    private final Set<String> getTryPreloadVideoIds() {
        return (Set) this.tryPreloadVideoIds$delegate.getValue();
    }

    private final void initData() {
        bj2.a.b("ExplainPlaybackViewModel", "initData");
        Bundle r0 = this.bundle;
        Serializable r1 = null;
        if (r0 == null) goto L5;
        Serializable r2 = r0.getSerializable("playback_data_string");
    L7:
        if ((r2 instanceof SearchExplainReplayParams) == false) goto L10;
        r1 = r2;
    L10:
        SearchExplainReplayParams r3 = (SearchExplainReplayParams) r1;
        if (r3 == null) goto L13;
        this.isFromSearch = true;
        initSearchData(r3);
        return;
    L13:
        this.isFromSearch = false;
        initNormalData();
        return;
    L5:
        r2 = null;
        goto L7
    }

    private final void initNormalData() {
        bj2.a.b("ExplainPlaybackViewModel", "initNormalData");
        BuildersKt.launch$default(mg.b.a(this), null, null, new C02811(this, null), 3, null);
    }

    public final boolean canEnableSubTitle() {
        ECLiveABUtils r0 = ECLiveABUtils.INSTANCE;
        if (r0.getECOM_ENABLE_REPLAY_SUBTITLE() == true) goto L5;
    L7:
        return false;
    L5:
        if (r0.getECOM_ENABLE_REPLAY_INTERACTION() == true) goto L7;
        return true;
    }

    public final boolean isFromLive() {
        b r0 = this.explainPlaybackOriginParams;
        if (r0 == null) goto L11;
        PlaybackEventExtraData r1 = r0.e;
        if (r1 == null) goto L11;
        String r2 = r1.getFromLive();
        if (r2 == null) goto L11;
        if (r2.equals("1") != true) goto L11;
        return true;
    L11:
        return false;
    }

    public final boolean isFromProductDetail() {
        b r0 = this.explainPlaybackOriginParams;
        if (r0 == null) goto L7;
        LogExtraData r1 = r0.d;
        if (r1 == null) goto L7;
        Intrinsics.checkNotNullParameter(r1, "$this$isFromProductDetail");
        return Intrinsics.areEqual(r1.getSourcePage(), "product_detail");
    L7:
        return false;
    }

    public final String getNewSourceType() {
        if (isFromLive() == false) goto L5;
        return "live_button";
    L5:
        return "";
    }

    public final void onUnBind() {
        getTryPreloadVideoIds().clear();
        Runnable r0 = this.reloadVideoRunnable;
        if (r0 == null) goto L5;
        getHandler().removeCallbacks(r0);
    L5:
        this.reloadVideoRunnable = null;
    }

    public final void reloadVideo() {
        getTryPreloadVideoIds().clear();
        ExplainPlaybackFinalParams r0 = this.explainPlaybackFinalFinalParams;
        String r1 = null;
        if (r0 == null) goto L20;
        ExplainPlaybackVideoInfo r2 = r0.getVideoInfo();
        if (r2 == null) goto L20;
        String r3 = r2.getPlayUrl();
        if (r3 == null) goto L20;
        if (r3.length() != 0) goto L11;
        boolean r4 = true;
    L12:
        if (r4 != true) goto L20;
        ExplainPlaybackFinalParams r5 = this.explainPlaybackFinalFinalParams;
        if (r5 == null) goto L16;
        ECReplayVideo r6 = r5.getVideoInfoV2();
    L17:
        if (r6 != null) goto L20;
        bj2.a.b("ExplainPlaybackViewModel", "reloadVideo failed, videoInfo is null");
        return;
    L16:
        r6 = null;
        goto L17
    L11:
        r4 = false;
    L20:
        com.bytedance.android.ec.core.arch.event.c.d(this, new com.bytedance.android.livesdk.livecommerce.playback.main.a.h());
        if (ExplainPlaybackUtils.d() == true) goto L31;
        b r7 = this.explainPlaybackOriginParams;
        if (r7 == null) goto L28;
        LogExtraData r8 = r7.d;
        if (r8 == null) goto L28;
        r1 = r8.getEnterScene();
    L28:
        if (ExplainPlaybackUtils.e(r1) == true) goto L31;
        setState(new C02842(this));
        return;
    L31:
        setState(new C02831(this));
    }

    public final void resetPreloadVideoStatus() {
        getTryPreloadVideoIds().clear();
    }

    public final boolean getClosePageByUser() {
        return this.closePageByUser;
    }

    public final String getEcomSceneId() {
        return this.ecomSceneId;
    }

    public final ExplainPlaybackFinalParams getExplainPlaybackFinalFinalParams() {
        return this.explainPlaybackFinalFinalParams;
    }

    public final b getExplainPlaybackOriginParams() {
        return this.explainPlaybackOriginParams;
    }

    public final String getTargetEntranceInfo() {
        return this.targetEntranceInfo;
    }

    public final boolean isFromSearch() {
        return this.isFromSearch;
    }

    public static final /* synthetic */ Bundle access$getBundle$p(ExplainPlaybackViewModel r0) {
        return r0.bundle;
    }

    public static final /* synthetic */ int access$getCurrentCardPosition$p(ExplainPlaybackViewModel r0) {
        return r0.currentCardPosition;
    }

    public static final /* synthetic */ ExplainPlaybackFinalParams access$getExplainPlaybackFinalFinalParams$p(ExplainPlaybackViewModel r0) {
        return r0.explainPlaybackFinalFinalParams;
    }

    public static final /* synthetic */ b access$getExplainPlaybackOriginParams$p(ExplainPlaybackViewModel r0) {
        return r0.explainPlaybackOriginParams;
    }

    public static final /* synthetic */ Map access$getInteractionContents$p(ExplainPlaybackViewModel r0) {
        return r0.getInteractionContents();
    }

    public static final /* synthetic */ h access$getRepository$p(ExplainPlaybackViewModel r0) {
        return r0.repository;
    }

    public static final /* synthetic */ boolean access$isFromLive$p(ExplainPlaybackViewModel r0) {
        return r0.isFromLive();
    }

    public static final /* synthetic */ boolean access$isLiveEntranceEnable$p(ExplainPlaybackViewModel r0) {
        return r0.isLiveEntranceEnable;
    }

    private final void appendEcomSceneIds(JSONObject r14) {
        if (r14 != null) goto L4;
        return;
    L4:
        String r1 = r14.optString("ecom_scene_id");
        Intrinsics.checkNotNullParameter(r1, "$this$ecomSceneIdsToList");
        boolean r7 = false;
        if (r1.length() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L10;
        List r3 = CollectionsKt.toMutableList(StringsKt.split$default(r1, new String[]{","}, false, 0, 6, null));
    L12:
        if (EComABUtils.isUseOriginEcomSceneId() == false) goto L20;
        List r4 = r3;
        if (r4 != null) goto L16;
    L17:
        r7 = true;
    L18:
        if (r7 == false) goto L21;
        r3.add("1076");
    L21:
        Intrinsics.checkNotNullParameter(r3, "$this$listToEcomSceneIds");
        this.ecomSceneId = CollectionsKt.joinToString$default(r3, ",", null, null, 0, null, null, 62, null);
        Intrinsics.checkNotNullParameter(r3, "$this$listToEcomSceneIds");
        r14.put("ecom_scene_id", CollectionsKt.joinToString$default(r3, ",", null, null, 0, null, null, 62, null));
        return;
    L16:
        if (r4.isEmpty() == false) goto L18;
    L20:
        r3.add("1076");
        goto L21
    L10:
        r3 = new ArrayList();
        goto L12
    L7:
        r2 = false;
        goto L8
    }

    private final ExplainPlaybackInteractionRequest buildInteractionRequestParams(ECUIPromotion r10) {
        b r0 = this.explainPlaybackOriginParams;
        if (r0 == null) goto L5;
        ExplainPlaybackRequest r1 = r0.a;
    L7:
        if (r10 == null) goto L10;
        String r2 = r10.getPromotionId();
        if (r2 == null) goto L10;
    L11:
        if (r10 == null) goto L14;
        String r3 = r10.getProductId();
        if (r3 == null) goto L14;
    L15:
        if (r1 == null) goto L18;
        String r4 = r1.getRoomId();
        if (r4 == null) goto L18;
    L19:
        if (r1 == null) goto L22;
        String r5 = r1.getAuthorId();
        if (r5 == null) goto L22;
    L23:
        if (r10 == null) goto L28;
        String r11 = r10.getShopId();
        if (r11 == null) goto L28;
        String r6 = r11;
    L29:
        if (r1 == null) goto L34;
        String r12 = r1.getSourcePage();
        if (r12 == null) goto L34;
        String r7 = r12;
    L36:
        return new ExplainPlaybackInteractionRequest(r2, r3, r4, r5, r6, r7);
    L34:
        r7 = "";
    L28:
        r6 = "";
    L22:
        r5 = "";
    L18:
        r4 = "";
    L14:
        r3 = "";
    L10:
        r2 = "";
        goto L11
    L5:
        r1 = null;
        goto L7
    }

    private final dj2.a getAuthorInfoEntity(ol.a r3) {
        if (ExplainPlaybackUtils.d() == false) goto L7;
        return new dj2.a(false, null);
    L7:
        return new dj2.a(true, r3.a());
    }

    private final void hasShowedAnchorEvent(com.bytedance.android.livesdk.livecommerce.playback.main.a.c r2) {
        b r3 = this.explainPlaybackOriginParams;
        if (r3 == null) goto L7;
        LogExtraData r4 = r3.d;
        if (r4 == null) goto L7;
        r4.setNeedShowAnchorPage(Boolean.FALSE);
    L7:
        setState(C02791.INSTANCE);
    }

    private final void hideBackgroundEvent(com.bytedance.android.livesdk.livecommerce.playback.main.a.d r1) {
        setState(C02801.INSTANCE);
    }

    private final void initSearchData(SearchExplainReplayParams r56) {
        bj2.a.b("ExplainPlaybackViewModel", "initSearchData");
        String r4 = r56.getCommentaryInfo();
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.length() <= 0) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == true) goto L11;
        r4 = null;
    L11:
        if (r4 == null) goto L214;
        final ol.a r10 = (ol.a) new Gson().fromJson(r4, ol.a.class);     // Catch: Exception -> L194
        final Serializable r6 = r56.getUserInfo();     // Catch: Exception -> L194
        ECPromotion r7 = r10.i();     // Catch: Exception -> L194
        Long r9 = Long.valueOf(r10.getServerTime());     // Catch: Exception -> L194
        long r13 = 0;
        if (r9.longValue() <= 0) goto L15;
        boolean r11 = true;
    L16:
        if (r11 == true) goto L19;
        r9 = null;
    L19:
        if (r9 != null) goto L24;
        ExplainPlaybackExtraData r12 = r10.f();     // Catch: Exception -> L194
        if (r12 == null) goto L23;
        r9 = Long.valueOf(r12.getServerTime());     // Catch: Exception -> L194
        goto L24
    L23:
        r9 = null;
    L24:
        if (r9 == null) goto L26;
        r13 = r9.longValue();     // Catch: Exception -> L194
    L26:
        String r14 = r56.getTracker();     // Catch: Exception -> L194
        LogExtraData r15 = r56.getLogExtraData();     // Catch: Exception -> L194
        if (r15 == null) goto L29;
        r15.setRoomId(r10.m());     // Catch: Exception -> L194
        LogExtraData r16 = r15;
    L30:
        ExplainPlaybackVideoInfo r28 = r10.s();     // Catch: Exception -> L194
        if (ECSettingKeys.I0() == false) goto L35;
        ECReplayVideo r17 = r10.u();     // Catch: Exception -> L194
        if (r17 != null) goto L36;
        r17 = r10.t();     // Catch: Exception -> L194
    L36:
        final ECReplayVideo r29 = r17;
        Integer r18 = r56.getReplayVideoStartTime();     // Catch: Exception -> L194
        if (r18 == null) goto L39;
        int r30 = r18.intValue();     // Catch: Exception -> L194
    L40:
        ExplainPlaybackVideoInfo r19 = r10.s();     // Catch: Exception -> L194
        if (r19 == null) goto L46;
        String r110 = r19.getAwemeId();     // Catch: Exception -> L194
        if (r110 == null) goto L46;
        String r111 = r110;
    L47:
        if (r16 == null) goto L50;
        r16.setFragmentId(r111);     // Catch: Exception -> L194
    L50:
        if (r16 == null) goto L52;
        r16.setEnterScene("search");     // Catch: Exception -> L194
    L52:
        int r112 = ECSdk.a;     // Catch: Exception -> L194
        l r113 = (l) ECSdk.a(l.class);     // Catch: Exception -> L194
        if (r113 == null) goto L56;
        long r32 = r13;
        ECUIPromotion r114 = r113.Ha(r7, ExplainPlaybackUtils.b(), r32, Boolean.valueOf(isFromLive()));     // Catch: Exception -> L194
    L58:
        if (r114 == null) goto L60;
        r114.setEcomGroupType("product_card");     // Catch: Exception -> L194
    L60:
        if (r114 == null) goto L115;
        String r115 = r114.getScheme();     // Catch: Exception -> L194
        if (r115 == null) goto L115;
        Uri r116 = UriProtector.parse(r115);     // Catch: Exception -> L194
        String r117 = UriProtector.getQueryParameter(r116, "meta_params");     // Catch: Exception -> L194
        String r34 = "";
        if (r117 != null) goto L211;
    L72:
        JSONObject r118 = new JSONObject();     // Catch: Exception -> L192
    L74:
        if (r16 == 0) goto L76;
        Object r8 = r16.getSearchParam();     // Catch: Exception -> L192
    L77:
        r118.put("search_params", r8);     // Catch: Exception -> L192
        if (r16 == 0) goto L80;
        Object r20 = r16.getEnterMethod();     // Catch: Exception -> L192
    L81:
        r118.put("enter_method", r20);     // Catch: Exception -> L192
        if (r16 == 0) goto L84;
        Object r21 = r16.getEComEntranceForm();     // Catch: Exception -> L192
    L85:
        r118.put("ecom_entrance_form", r21);     // Catch: Exception -> L192
        if (r16 == 0) goto L88;
        Object r22 = r16.getSourcePage();     // Catch: Exception -> L192
    L89:
        r118.put("enter_from_merge", r22);     // Catch: Exception -> L192
        r118.put("ecom_group_type", "product_card");     // Catch: Exception -> L192
        r118.put("source_method", "replay_popup_card");     // Catch: Exception -> L192
        if (r16 == 0) goto L93;
        Object r119 = r16.getSourcePage();     // Catch: Exception -> L192
        if (r119 == null) goto L93;
    L94:
        r118.put("carrier_source", r119);     // Catch: Exception -> L192
        r118.put("fragment_id", r111);     // Catch: Exception -> L192
        r118.put("enter_scene", "search");     // Catch: Exception -> L192
    L104:
        e = move-exception;
        String r0 = e.getMessage();     // Catch: Exception -> L192
        if (r0 != null) goto L108;
        r0 = r34;
    L108:
        ECExceptionMonitor.c(r0);     // Catch: Exception -> L192
    L109:
        appendEcomSceneIds(r118);     // Catch: Exception -> L192
        String r1 = r118.toString();     // Catch: Exception -> L192
        this.targetEntranceInfo = r1;     // Catch: Exception -> L192
        String r23 = UriProtector.getQueryParameter(r116, "meta_params");     // Catch: Exception -> L192
        if (r23 == null) goto L113;
        JSONObject r24 = c.c(r23);     // Catch: Exception -> L192
        if (r24 == null) goto L113;
    L114:
        int r25 = p0.a;     // Catch: Exception -> L192
        r24.put("entrance_info", r1);     // Catch: Exception -> L192
        Unit r2 = Unit.INSTANCE;     // Catch: Exception -> L192
        r114.setScheme(p0.d(r115, "meta_params", r24.toString()));     // Catch: Exception -> L192
    L116:
        int r3 = com.bytedance.android.livesdk.livecommerce.playback.utils.a.a;     // Catch: Exception -> L192
        long r26 = r32;
        com.bytedance.android.livesdk.livecommerce.playback.utils.a.a(r10.c(), r114, r26);     // Catch: Exception -> L192
        if (r7 == null) goto L122;
        ECPromotion r27 = r7;
        String r31 = r27.promotionId;     // Catch: Exception -> L192
        if (r31 == null) goto L123;
        String r38 = r31;
    L124:
        String r33 = r10.m();     // Catch: Exception -> L192
        if (r33 != null) goto L127;
        String r39 = r34;
    L128:
        String r35 = r56.getUid();     // Catch: Exception -> L192
        if (r35 != null) goto L131;
        String r40 = r34;
    L132:
        String r36 = r56.getSecAuthorId();     // Catch: Exception -> L192
        if (r36 != null) goto L135;
        String r41 = r34;
    L136:
        ExplainPlaybackRequest r120 = new ExplainPlaybackRequest(r38, r39, r40, r41, null, this.targetEntranceInfo, aj2.a.a(), null, null, null, null, null, null, null, null, 32656, null);     // Catch: Exception -> L192
        String r37 = r10.m();     // Catch: Exception -> L192
        String r42 = r10.e();     // Catch: Exception -> L192
        String r43 = r10.g();     // Catch: Exception -> L192
        Boolean r121 = r10.h();     // Catch: Exception -> L192
        if (r121 == null) goto L139;
        boolean r122 = r121.booleanValue();     // Catch: Exception -> L192
    L140:
        final EnterRoomInfo r44 = new EnterRoomInfo(r37, r42, r43, r122);     // Catch: Exception -> L192
        PlaybackEventExtraData r45 = r56.getPlaybackExtraData();     // Catch: Exception -> L192
        if (r45 == null) goto L157;
        String r46 = r56.getUid();     // Catch: Exception -> L192
        if (r46 != null) goto L145;
        r46 = r34;
    L145:
        r45.setUserId(r46);     // Catch: Exception -> L192
        r45.setFollowStatus(r56.getFollowStatus());     // Catch: Exception -> L192
        if (r114 == null) goto L148;
        String r47 = r114.getEventItemType();     // Catch: Exception -> L192
    L149:
        r45.setCommodityType(r47);     // Catch: Exception -> L192
        if (r114 != null) goto L152;
    L155:
        String r48 = "1";
    L156:
        r45.setWithSku(r48);     // Catch: Exception -> L192
    L158:
        if (r16 == 0) goto L163;
        String r123 = r16.getSourcePage();     // Catch: Exception -> L192
        if (r123 != null) goto L162;
        r123 = r11;
    L162:
        r16.setCarrierSource(r123);     // Catch: Exception -> L192
    L163:
        cj2.c r49 = cj2.a.a;     // Catch: Exception -> L192
        int r50 = cj2.c.d;     // Catch: Exception -> L192
        if (r114 == null) goto L166;
        String r51 = r114.getPromotionId();     // Catch: Exception -> L192
    L167:
        if (r114 == null) goto L169;
        String r124 = r114.getProductId();     // Catch: Exception -> L192
    L170:
        if (r114 == null) goto L172;
        Map r125 = r114.getEventParams();     // Catch: Exception -> L192
    L173:
        cj2.c r52 = cj2.c.a.a(new dj2.e(new dj2.f(r51, r124, r125), r16, r45, null));     // Catch: Exception -> L192
        Intrinsics.checkNotNullParameter(r52, "replayTracker");     // Catch: Exception -> L192
        cj2.a.a = r52;     // Catch: Exception -> L192
        this.explainPlaybackOriginParams = new b(r120, null, this.targetEntranceInfo, r16, r45, null, r56.getTracker(), null, null, null, 898);     // Catch: Exception -> L192
        final ECUIPromotion r310 = r114;
        this.explainPlaybackFinalFinalParams = new ExplainPlaybackFinalParams(r28, r29, null, r27, null, null, r26, r10.n(), r6, null, null, null, null, 7684, null);     // Catch: Exception -> L192
        Integer r53 = r10.q();     // Catch: Exception -> L192
        if (r53 != null) goto L177;
    L189:
        final boolean r126 = false;
    L190:
        final int r127 = r30;
        setState(new ExplainPlaybackViewModel$initSearchData$2$2(r10, r29, r127, r310, r126, r44, r6));     // Catch: Exception -> L192
        return;
    L177:
        if (r53.intValue() != 1) goto L189;
        if (r16 == 0) goto L180;
        String r54 = r16.getEnterMethod();     // Catch: Exception -> L192
    L182:
        if (Intrinsics.areEqual(r54, "live_replay_goods") == true) goto L188;
        if (r16 == 0) goto L185;
        Boolean r55 = r16.getNeedShowAnchorPage();     // Catch: Exception -> L192
    L187:
        if (Intrinsics.areEqual(r55, Boolean.TRUE) == false) goto L189;
    L185:
        r55 = null;
    L188:
        r126 = true;
        goto L190
    L180:
        r54 = null;
        goto L182
    L172:
        r125 = null;
        goto L173
    L169:
        r124 = null;
        goto L170
    L166:
        r51 = null;
        goto L167
    L152:
        if (r114.getSingleSku() != true) goto L155;
        r48 = BDLocationException.ERROR_TIMEOUT;
        goto L156
    L148:
        r47 = null;
        goto L149
    L157:
        r45 = null;
        goto L158
    L139:
        r122 = false;
        goto L140
    L135:
        r41 = r36;
        goto L136
    L131:
        r40 = r35;
        goto L132
    L127:
        r39 = r33;
    L123:
        r38 = r34;
        goto L124
    L122:
        r27 = r7;
    L113:
        r24 = new JSONObject();     // Catch: Exception -> L192
    L192:
        e = e;
    L196:
        Context r57 = ExplainPlaybackUtils.b();
        if (r57 == null) goto L201;
        String r58 = r57.getString(2131896458);
        if (r58 == null) goto L201;
        com.bytedance.android.ec.core.arch.event.c.d(this, new com.bytedance.android.livesdk.livecommerce.playback.main.a.C0082a(r58));
    L201:
        String r59 = e.getMessage();
        if (r59 != null) goto L204;
        String r60 = r34;
    L205:
        ECExceptionMonitor.c(r60);
        return;
    L204:
        r60 = r59;
        goto L205
    L96:
        if (TextUtils.isEmpty(r14) == true) goto L109;
        if (r16 == 0) goto L99;
        String r61 = r16.getEComEntranceForm();     // Catch: Exception -> L104
    L101:
        if (TextUtils.equals(r61, "search_order_center_ecom_live_channel") == false) goto L109;
        r118.put("ecom_scene_id", new JSONObject(r14).optString("ecom_scene_id"));     // Catch: Exception -> L104
    L99:
        r61 = null;
    L93:
        r119 = r11;
        goto L94
    L88:
        r22 = null;
        goto L89
    L84:
        r21 = null;
        goto L85
    L80:
        r20 = null;
        goto L81
    L76:
        r8 = null;
        goto L77
    L211:
        JSONObject r128 = c.c(r117);     // Catch: Exception -> L192
        if (r128 == null) goto L72;
        String r129 = r128.optString("entrance_info");     // Catch: Exception -> L192
        if (r129 == null) goto L72;
        r118 = c.c(r129);     // Catch: Exception -> L192
        if (r118 != null) goto L74;
    L115:
        r34 = "";
        r7 = r7;
        goto L116
    L56:
        r32 = r13;
        r114 = null;
    L46:
        r111 = "";
        goto L47
    L39:
        r30 = 0;
        goto L40
    L35:
        r17 = r10.t();     // Catch: Exception -> L194
        goto L36
    L29:
        r16 = null;
        goto L30
    L15:
        r11 = false;
    L194:
        e = e;
        r34 = "";
        goto L196
    L214:
        return;
    L7:
        r5 = false;
        goto L8
    }

    private final void onPlaySuccess(com.bytedance.android.livesdk.livecommerce.playback.main.a.f r2) {
        Runnable r3 = this.reloadVideoRunnable;
        if (r3 == null) goto L5;
        getHandler().removeCallbacks(r3);
    L5:
        this.reloadVideoRunnable = null;
    }

    private final void showLoading(final com.bytedance.android.livesdk.livecommerce.playback.main.a.n r2) {
        setState(new C02851(r2));
    }

    private final void tryMute(com.bytedance.android.livesdk.livecommerce.playback.main.a.o r4) {
        Integer r1 = null;
        if (r4.a == false) goto L29;
        AudioManager r5 = ng.b.a;
        Context r6 = ExplainPlaybackUtils.b();
        if (r6 != null) goto L48;
        Object r7 = null;
    L11:
        if ((r7 instanceof AudioManager) == true) goto L13;
        r7 = null;
    L13:
        ng.b.a = (AudioManager) r7;     // Catch: Exception -> L7
        if (Build.VERSION.SDK_INT < 26) goto L18;
        AudioFocusRequest r8 = new AudioFocusRequest.Builder(1).setAudioAttributes(new AudioAttributes.Builder().setUsage(14).setContentType(2).build()).setAcceptsDelayedFocusGain(true).setOnAudioFocusChangeListener(ng.b.d).build();     // Catch: Exception -> L7
        ng.b.b = r8;     // Catch: Exception -> L7
        AudioManager r0 = ng.b.a;     // Catch: Exception -> L7
        if (r0 == null) goto L50;
        r0.requestAudioFocus(r8);     // Catch: Exception -> L7
        return;
    L50:
        return;
    L18:
        AudioManager r9 = ng.b.a;     // Catch: Exception -> L7
        if (r9 == null) goto L21;
        r1 = Integer.valueOf(r9.requestAudioFocus(ng.b.d, 3, 1));     // Catch: Exception -> L7
    L21:
        if (r1 == null) goto L52;
        r1.intValue();     // Catch: Exception -> L7
        return;
    L52:
        return;
    L48:
        r7 = r6.getSystemService("audio");     // Catch: Exception -> L7
    L7:
        e = move-exception;
        String r10 = e.getMessage();
        if (r10 != null) goto L28;
        r10 = "";
    L28:
        ECExceptionMonitor.c(r10);
        return;
    L29:
        AudioManager r11 = ng.b.a;
    L42:
        th = move-exception;
        ng.b.a = null;
        ((ArrayList) ng.b.c).clear();
        throw th;
    L31:
        if (Build.VERSION.SDK_INT < 26) goto L38;
        AudioFocusRequest r12 = ng.b.b;     // Catch: Throwable -> L42 Exception -> L47
        if (r12 == null) goto L37;
        AudioManager r2 = ng.b.a;     // Catch: Throwable -> L42 Exception -> L47
        if (r2 == null) goto L37;
        r2.abandonAudioFocusRequest(r12);     // Catch: Throwable -> L42 Exception -> L47
    L37:
        ng.b.b = null;     // Catch: Throwable -> L42 Exception -> L47
        goto L45
    L38:
        AudioManager.OnAudioFocusChangeListener r13 = ng.b.d;     // Catch: Throwable -> L42 Exception -> L47
        AudioManager r3 = ng.b.a;     // Catch: Throwable -> L42 Exception -> L47
        if (r3 == null) goto L45;
        r3.abandonAudioFocus(r13);     // Catch: Throwable -> L42 Exception -> L47
    L45:
        ng.b.a = null;
        ((ArrayList) ng.b.c).clear();
    }

    public final boolean isVideoPreload(ExplainPlaybackVideoInfo r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.getVideoId().length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L10;
        return false;
    L10:
        return getTryPreloadVideoIds().contains(r3.getVideoId());
    L7:
        r1 = false;
        goto L8
    }

    public final void setClosePageByUser(boolean r1) {
        this.closePageByUser = r1;
    }

    public final void setTargetEntranceInfo(String r1) {
        this.targetEntranceInfo = r1;
    }

    public static final /* synthetic */ void access$appendEcomSceneIds(ExplainPlaybackViewModel r0, JSONObject r1) {
        r0.appendEcomSceneIds(r1);
    }

    public static final /* synthetic */ ExplainPlaybackInteractionRequest access$buildInteractionRequestParams(ExplainPlaybackViewModel r0, ECUIPromotion r1) {
        return r0.buildInteractionRequestParams(r1);
    }

    public static final /* synthetic */ dj2.a access$getAuthorInfoEntity(ExplainPlaybackViewModel r0, ol.a r1) {
        return r0.getAuthorInfoEntity(r1);
    }

    public static final /* synthetic */ void access$hasShowedAnchorEvent(ExplainPlaybackViewModel r0, com.bytedance.android.livesdk.livecommerce.playback.main.a.c r1) {
        r0.hasShowedAnchorEvent(r1);
    }

    public static final /* synthetic */ void access$hideBackgroundEvent(ExplainPlaybackViewModel r0, com.bytedance.android.livesdk.livecommerce.playback.main.a.d r1) {
        r0.hideBackgroundEvent(r1);
    }

    public static final /* synthetic */ void access$onPlaySuccess(ExplainPlaybackViewModel r0, com.bytedance.android.livesdk.livecommerce.playback.main.a.f r1) {
        r0.onPlaySuccess(r1);
    }

    public static final /* synthetic */ void access$setCurrentCardPosition$p(ExplainPlaybackViewModel r0, int r1) {
        r0.currentCardPosition = r1;
    }

    public static final /* synthetic */ void access$setExplainPlaybackFinalFinalParams$p(ExplainPlaybackViewModel r0, ExplainPlaybackFinalParams r1) {
        r0.explainPlaybackFinalFinalParams = r1;
    }

    public static final /* synthetic */ void access$setExplainPlaybackOriginParams$p(ExplainPlaybackViewModel r0, b r1) {
        r0.explainPlaybackOriginParams = r1;
    }

    public static final /* synthetic */ void access$setFromLive$p(ExplainPlaybackViewModel r0, boolean r1) {
        r0.isFromLive = r1;
    }

    public static final /* synthetic */ void access$setState(ExplainPlaybackViewModel r0, Function1 r1) {
        r0.setState(r1);
    }

    public static final /* synthetic */ void access$showLoading(ExplainPlaybackViewModel r0, com.bytedance.android.livesdk.livecommerce.playback.main.a.n r1) {
        r0.showLoading(r1);
    }

    public static final /* synthetic */ void access$tryMute(ExplainPlaybackViewModel r0, com.bytedance.android.livesdk.livecommerce.playback.main.a.o r1) {
        r0.tryMute(r1);
    }

    private final void appendReplayType(JSONObject r2, ol.a r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        cj2.c r0 = cj2.a.a;
        if (r3 == null) goto L9;
        ReplayCards r4 = r3.j();
        if (r4 == null) goto L9;
        int r5 = r4.getProductReplayCnt();
    L11:
        if (r5 != 1) goto L13;
        String r6 = "product";
    L16:
        if (r6 == null) goto L19;
        r2.put("replay_type", r6);
        return;
    L19:
        return;
    L13:
        if (r5 <= 1) goto L15;
        r6 = "scroll";
        goto L16
    L15:
        r6 = null;
    L9:
        r5 = 0;
        goto L11
    }

    private final void replacePromotionIdAndRoomId(JSONObject r7, ExplainPlaybackRequest r8) {
        if (r7 != null) goto L4;
        return;
    L4:
        bj2.a.b("ExplainPlaybackViewModel", "replacePromotionIdAndRoomId");
        String r1 = r7.optString("room_id");
        String r2 = null;
        if (r8 == null) goto L7;
        String r3 = r8.getRoomId();
    L8:
        boolean r4 = false;
        if ((!Intrinsics.areEqual(r1, r3)) == false) goto L19;
        if (r8 == null) goto L19;
        String r5 = r8.getRoomId();
        if (r5 == null) goto L19;
        if (r5.length() <= 0) goto L16;
        boolean r6 = true;
    L17:
        if (r6 != true) goto L19;
        r7.put("room_id", r8.getRoomId());
        goto L19
    L16:
        r6 = false;
    L19:
        String r9 = r7.optString("promotion_id");
        if (r8 == null) goto L22;
        String r10 = r8.getPromotionId();
    L24:
        if ((!Intrinsics.areEqual(r9, r10)) == false) goto L34;
        if (r8 == null) goto L34;
        String r11 = r8.getPromotionId();
        if (r11 == null) goto L34;
        if (r11.length() <= 0) goto L31;
        boolean r12 = true;
    L32:
        if (r12 != true) goto L34;
        r7.put("promotion_id", r8.getPromotionId());
        goto L34
    L31:
        r12 = false;
    L34:
        String r13 = r7.optString("anchor_id");
        if (r8 == null) goto L38;
        r2 = r8.getAuthorId();
    L38:
        if ((!Intrinsics.areEqual(r13, r2)) == false) goto L48;
        if (r8 == null) goto L49;
        String r14 = r8.getAuthorId();
        if (r14 != null) goto L43;
        return;
    L43:
        if (r14.length() <= 0) goto L45;
        r4 = true;
    L45:
        if (r4 != true) goto L51;
        r7.put("anchor_id", r8.getAuthorId());
        return;
    L51:
        return;
    L49:
        return;
    L48:
        return;
    L22:
        r10 = null;
        goto L24
    L7:
        r3 = null;
        goto L8
    }

    public final void initExplainTracker(ECUIPromotion r8, ExplainPlaybackVideoInfo r9) {
        b r1 = this.explainPlaybackOriginParams;
        String r2 = null;
        if (r1 == null) goto L5;
        LogExtraData r3 = r1.d;
    L6:
        if (r1 == null) goto L8;
        PlaybackEventExtraData r4 = r1.e;
    L10:
        if (r8 == null) goto L12;
        String r5 = r8.getPromotionId();
    L13:
        if (r8 == null) goto L15;
        String r6 = r8.getProductId();
    L16:
        if (r8 == null) goto L18;
        Map r10 = r8.getEventParams();
    L19:
        dj2.f r7 = new dj2.f(r5, r6, r10);
        b r11 = this.explainPlaybackOriginParams;
        if (r11 == null) goto L22;
        ExplainPlayBackPDPEntryLogExtra r12 = r11.f;
    L23:
        dj2.e r0 = new dj2.e(r7, r3, r4, r12);
        if (r9 == null) goto L26;
        String r13 = r9.getFragmentId();
    L28:
        if (TextUtils.isEmpty(r13) == true) goto L33;
        if (r3 == null) goto L33;
        if (r9 == null) goto L32;
        r2 = r9.getFragmentId();
    L32:
        r3.setFragmentId(r2);
    L33:
        cj2.c r14 = cj2.a.a;
        int r15 = cj2.c.d;
        cj2.c r16 = cj2.c.a.a(r0);
        Intrinsics.checkNotNullParameter(r16, "replayTracker");
        cj2.a.a = r16;
        return;
    L26:
        r13 = null;
        goto L28
    L22:
        r12 = null;
        goto L23
    L18:
        r10 = null;
        goto L19
    L15:
        r6 = null;
        goto L16
    L12:
        r5 = null;
        goto L13
    L8:
        r4 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final void onProductCardShow(int r8, ECUIPromotion r9) {
        this.currentCardPosition = r8;
        if (ECLiveABUtils.INSTANCE.getECOM_ENABLE_REPLAY_INTERACTION() == false) goto L6;
        BuildersKt.launch$default(mg.b.a(this), null, null, new C02821(this, r8, r9, null), 3, null);
        return;
    }

    public ExplainPlaybackViewModel(h r2, Bundle r3, f r4) {
        Intrinsics.checkNotNullParameter(r2, "repository");
        Intrinsics.checkNotNullParameter(r4, "explainPlaybackState");
        super(r4);
        this.repository = r2;
        this.bundle = r3;
        if (ECSettingKeys.t0() != 2) goto L5;
    L13:
        boolean r5 = true;
    L14:
        this.isLiveEntranceEnable = r5;
        this.isFromLive = true;
        this.ecomSceneId = "1076";
        this.tryPreloadVideoIds$delegate = LazyKt.lazy(ExplainPlaybackViewModel$tryPreloadVideoIds$2.INSTANCE);
        this.interactionContents$delegate = LazyKt.lazy(ExplainPlaybackViewModel$interactionContents$2.INSTANCE);
        this.handler$delegate = LazyKt.lazy(ExplainPlaybackViewModel$handler$2.INSTANCE);
        initData();
        com.bytedance.android.ec.core.arch.event.c.b(this, Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.playback.main.a.o.class), new AnonymousClass1(this));
        com.bytedance.android.ec.core.arch.event.c.b(this, Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.playback.main.a.n.class), new AnonymousClass2(this));
        com.bytedance.android.ec.core.arch.event.c.b(this, Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.playback.main.a.d.class), new AnonymousClass3(this));
        com.bytedance.android.ec.core.arch.event.c.b(this, Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.playback.main.a.c.class), new AnonymousClass4(this));
        com.bytedance.android.ec.core.arch.event.c.b(this, Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.playback.main.a.f.class), new AnonymousClass5(this));
        return;
    L5:
        if (ECSettingKeys.t0() == 3) goto L13;
        hh2.g r6 = hh2.f.a.a;
        r5 = false;
        if (r6 == null) goto L11;
        Boolean r7 = r6.g();
        if (r7 == null) goto L11;
        boolean r8 = r7.booleanValue();
    L12:
        if (r8 == false) goto L14;
    L11:
        r8 = false;
        goto L12
    }

    public static final /* synthetic */ void access$appendReplayType(ExplainPlaybackViewModel r0, JSONObject r1, ol.a r2) {
        r0.appendReplayType(r1, r2);
    }

    public static final /* synthetic */ void access$replacePromotionIdAndRoomId(ExplainPlaybackViewModel r0, JSONObject r1, ExplainPlaybackRequest r2) {
        r0.replacePromotionIdAndRoomId(r1, r2);
    }

    private final void tryPreloadVideo(final ExplainPlaybackVideoInfo r6, ECReplayVideo r7, List<ExplainReplaySubTitle> r8) {
        boolean r1 = false;
        if (r6.getVideoId().length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L47;
        String r2 = r6.getPlayUrl();
        if (r2 != null) goto L11;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == true) goto L47;
        WeakReference<com.bytedance.android.livesdk.livecommerce.playback.video.e> r4 = com.bytedance.android.livesdk.livecommerce.playback.video.d.a;
        String r5 = r6.getVideoId();
        Intrinsics.checkNotNullParameter(r5, "videoId");
        Set<String> r9 = com.bytedance.android.livesdk.livecommerce.playback.video.d.b;
        if (r9 != null) goto L20;
    L22:
        boolean r10 = false;
    L23:
        if (r10 == false) goto L26;
        bj2.a.b("ExplainPlaybackViewModel", "has preload failed records");
        return;
    L26:
        updateVideo(r6, r7, r8);
        if (EComABUtils.replayPreloadVideoCover() == false) goto L30;
        setState(new C02861(r6));
    L30:
        if (r6.getVideoId().length() <= 0) goto L32;
        r1 = true;
    L32:
        if (r1 == false) goto L34;
        getTryPreloadVideoIds().add(r6.getVideoId());
    L34:
        long r11 = EComABUtils.replayPreloadTimeout();
        if (r11 > 0) goto L37;
    L42:
        String r12 = cj2.b.a;
        cj2.b.a("preload_video_id", r6.getVideoId());
        String r13 = r6.getPlayUrl();
        if (r13 != null) goto L45;
        r13 = "";
    L45:
        cj2.b.a("preload_video_url", r13);
        cj2.b.f("4");
        return;
    L37:
        if (this.reloadVideoRunnable != null) goto L39;
        this.reloadVideoRunnable = new a(this, r6);
    L39:
        Runnable r14 = this.reloadVideoRunnable;
        if (r14 == null) goto L42;
        getHandler().removeCallbacks(r14);
        getHandler().postDelayed(r14, r11);
        goto L42
    L20:
        if (r9.contains(r5) != true) goto L22;
        r10 = true;
        goto L23
    L11:
        if (r2.length() == 0) goto L14;
        r3 = false;
    L47:
        bj2.a.b("ExplainPlaybackViewModel", "videoInfo error");
        return;
    L5:
        r0 = false;
        goto L7
    }

    public final void updateVideo(final ExplainPlaybackVideoInfo r2, final ECReplayVideo r3, final List<ExplainReplaySubTitle> r4) {
        if (ExplainPlaybackUtils.d() == true) goto L14;
        b r0 = this.explainPlaybackOriginParams;
        if (r0 == null) goto L9;
        LogExtraData r1 = r0.d;
        if (r1 == null) goto L9;
        String r5 = r1.getEnterScene();
    L11:
        if (ExplainPlaybackUtils.e(r5) == true) goto L14;
        setState(new C02882(r2, r3, r4));
        return;
    L9:
        r5 = null;
    L14:
        setState(new C02871(r2, r3, r4));
    }

    public static final /* synthetic */ void access$tryPreloadVideo(ExplainPlaybackViewModel r0, ExplainPlaybackVideoInfo r1, ECReplayVideo r2, List r3) {
        r0.tryPreloadVideo(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void tryPreloadVideo$default(ExplainPlaybackViewModel r1, ExplainPlaybackVideoInfo r2, ECReplayVideo r3, List r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        r1.tryPreloadVideo(r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateVideo$default(ExplainPlaybackViewModel r1, ExplainPlaybackVideoInfo r2, ECReplayVideo r3, List r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        r1.updateVideo(r2, r3, r4);
    }
}
