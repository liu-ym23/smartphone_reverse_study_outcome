package com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.model.playback.ECReplayVideo;
import com.bytedance.android.ec.model.playback.ExplainPlaybackVideoInfo;
import com.bytedance.android.ec.model.playback.ExplainReplaySubTitle;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.sdk.helper.l;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.livecommerce.livereplay.repository.NetState;
import com.bytedance.android.livesdk.livecommerce.livereplay.utils.ECLiveReplayEventUtils;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010@\u001a\u00020?\u0012\u0006\u0010B\u001a\u00020A\u0012\u0006\u0010C\u001a\u00020)\u0012\u0006\u0010D\u001a\u00020\u0015\u0012\u0006\u0010E\u001a\u00020\u0015\u0012\u0006\u0010G\u001a\u00020F\u0012\u0006\u0010I\u001a\u00020H\u0012\u0006\u0010J\u001a\u00020F\u0012\u0006\u0010K\u001a\u00020\u0012¢\u0006\u0004\bL\u0010MJ\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u0016\u0010\u0014\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J6\u0010#\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u0011H\u0016J\b\u0010$\u001a\u00020\u0004H\u0016J\b\u0010%\u001a\u00020\u0004H\u0014J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&H\u0016J\b\u0010*\u001a\u00020)H\u0016R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010-R\u001b\u00104\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R)\u0010;\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010706058VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b8\u00101\u001a\u0004\b9\u0010:R\u0014\u0010=\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>¨\u0006N"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/ECReplayScrollProductCardViewModel;", "Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/AbsECScrollProductCardBaseVideModel;", "Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$b;", "fold", "", "Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$c;", "foldAnim", "changeFoldAnimState", "Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$i;", "showSimpleCard", "Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$a;", "clickSimpleCard", "Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$f;", "stateChanged", "onScrollStateChanged", "clearDisposable", "clickProductCard", "", "", "list", "setPageTimestamp", "", "count", "setTotalCount", "Lcom/bytedance/android/livesdk/livecommerce/livereplay/repository/NetState;", BaseCoreViewModel.CORE_TAG_STATE, "setNetworkState", "Lcom/bytedance/android/ec/model/promotion/ECUIPromotion;", "uiPromotion", "Lcom/bytedance/android/ec/model/playback/ExplainPlaybackVideoInfo;", "explainVideo", "Lcom/bytedance/android/ec/model/playback/ECReplayVideo;", "videoMdrInfo", "Lcom/bytedance/android/ec/model/playback/ExplainReplaySubTitle;", "subTitle", "selectFirstCard", "onInvalidated", "onCleared", "Landroid/content/Context;", "context", "reportPageInfoForDebug", "Lorg/json/JSONObject;", "getEntranceInfos", "", "canAutoScrollProductCard", "Z", "isFoldAnim", "Loi2/a;", "requestParams$delegate", "Lkotlin/Lazy;", "getRequestParams", "()Loi2/a;", "requestParams", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagedList;", "Lni2/a;", "pagedList$delegate", "getPagedList", "()Landroidx/lifecycle/LiveData;", "pagedList", "Lcom/bytedance/android/livesdk/livecommerce/livereplay/utils/ECLiveReplayEventUtils;", "eventUtils", "Lcom/bytedance/android/livesdk/livecommerce/livereplay/utils/ECLiveReplayEventUtils;", "Lml/b;", "roomInfo", "Lml/a;", "btmInfo", "entranceInfo", "pageSize", "funType", "", "ecomSceneId", "Lxk/a;", "params", "replayId", "replayStartTime", "<init>", "(Lml/b;Lml/a;Lorg/json/JSONObject;IILjava/lang/String;Lxk/a;Ljava/lang/String;J)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECReplayScrollProductCardViewModel extends AbsECScrollProductCardBaseVideModel {
    private boolean canAutoScrollProductCard;
    private final ECLiveReplayEventUtils eventUtils;
    private boolean isFoldAnim;
    private final Lazy pagedList$delegate;
    private final Lazy requestParams$delegate;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.ECReplayScrollProductCardViewModel$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$b;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<a.b, Unit> {
        public AnonymousClass1(ECReplayScrollProductCardViewModel r8) {
            super(1, r8, ECReplayScrollProductCardViewModel.class, "fold", "fold(Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/ECScrollProductCardEvent$Fold;)V", 0);
        }

        public final void invoke(a.b r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            ECReplayScrollProductCardViewModel.access$fold((ECReplayScrollProductCardViewModel) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((a.b) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.ECReplayScrollProductCardViewModel$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$c;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$c;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<a.c, Unit> {
        public AnonymousClass2(ECReplayScrollProductCardViewModel r8) {
            super(1, r8, ECReplayScrollProductCardViewModel.class, "changeFoldAnimState", "changeFoldAnimState(Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/ECScrollProductCardEvent$FoldAnim;)V", 0);
        }

        public final void invoke(a.c r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            ECReplayScrollProductCardViewModel.access$changeFoldAnimState((ECReplayScrollProductCardViewModel) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((a.c) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.ECReplayScrollProductCardViewModel$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$a;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<a.C0077a, Unit> {
        public AnonymousClass3(ECReplayScrollProductCardViewModel r8) {
            super(1, r8, ECReplayScrollProductCardViewModel.class, "clickSimpleCard", "clickSimpleCard(Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/ECScrollProductCardEvent$ClickSimpleCard;)V", 0);
        }

        public final void invoke(a.C0077a r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            ECReplayScrollProductCardViewModel.access$clickSimpleCard((ECReplayScrollProductCardViewModel) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((a.C0077a) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.ECReplayScrollProductCardViewModel$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$i;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$i;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<a.i, Unit> {
        public AnonymousClass4(ECReplayScrollProductCardViewModel r8) {
            super(1, r8, ECReplayScrollProductCardViewModel.class, "showSimpleCard", "showSimpleCard(Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/ECScrollProductCardEvent$ShowSimpleCard;)V", 0);
        }

        public final void invoke(a.i r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            ECReplayScrollProductCardViewModel.access$showSimpleCard((ECReplayScrollProductCardViewModel) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((a.i) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.ECReplayScrollProductCardViewModel$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$f;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$f;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<a.f, Unit> {
        public AnonymousClass5(ECReplayScrollProductCardViewModel r8) {
            super(1, r8, ECReplayScrollProductCardViewModel.class, "onScrollStateChanged", "onScrollStateChanged(Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/ECScrollProductCardEvent$OnScrollStateChanged;)V", 0);
        }

        public final void invoke(a.f r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            ECReplayScrollProductCardViewModel.access$onScrollStateChanged((ECReplayScrollProductCardViewModel) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((a.f) r1);
            return Unit.INSTANCE;
        }
    }

    private final oi2.a getRequestParams() {
        return (oi2.a) this.requestParams$delegate.getValue();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.AbsECScrollProductCardBaseVideModel
    public void clickProductCard() {
        this.canAutoScrollProductCard = false;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.AbsECScrollProductCardBaseVideModel
    public LiveData<PagedList<ni2.a>> getPagedList() {
        return (LiveData) this.pagedList$delegate.getValue();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.AbsECScrollProductCardBaseVideModel, com.bytedance.android.livesdk.livecommerce.livereplay.repository.b
    public void setPageTimestamp(List<Long> r2) {
        Intrinsics.checkNotNullParameter(r2, "list");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.AbsECScrollProductCardBaseVideModel, com.bytedance.android.livesdk.livecommerce.livereplay.repository.b
    public void setTotalCount(int r1) {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.AbsECScrollProductCardBaseVideModel
    public JSONObject getEntranceInfos() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        JSONObject r1 = new JSONObject(getParams().reportParams());     // Catch: Throwable -> L4
        r1.put("is_replay_default_product", 1);     // Catch: Throwable -> L4
        Object r2 = Result.constructor-impl(r1);     // Catch: Throwable -> L4
    L6:
        JSONObject r3 = new JSONObject();
        if (Result.isFailure-impl(r2) == false) goto L10;
        r2 = r3;
    L10:
        return (JSONObject) r2;
    L4:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public void onCleared() {
        super/*com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModel*/.onCleared();
        clearDisposable();
        il.a.a(getHistoryMap());
    }

    private final void clearDisposable() {
        doClear();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.AbsECScrollProductCardBaseVideModel, com.bytedance.android.livesdk.livecommerce.livereplay.repository.b, com.bytedance.android.livesdk.livecommerce.livereplay.replayrepository.a
    public void onInvalidated() {
        clearDisposable();
    }

    public static final /* synthetic */ ECLiveReplayEventUtils access$getEventUtils$p(ECReplayScrollProductCardViewModel r0) {
        return r0.eventUtils;
    }

    public static final /* synthetic */ oi2.a access$getRequestParams$p(ECReplayScrollProductCardViewModel r0) {
        return r0.getRequestParams();
    }

    private final void changeFoldAnimState(a.c r1) {
        this.isFoldAnim = r1.a;
    }

    private final void clickSimpleCard(final a.C0077a r12) {
        View r0 = r12.b;
        Integer r1 = null;
        if (r0 == null) goto L5;
        String r10 = BtmSDK.INSTANCE.getPageId(PageFinder.via(r0));
    L6:
        ECLiveReplayEventUtils r2 = this.eventUtils;
        ml.b r3 = getRoomInfo();
        ni2.a r4 = r12.a;
        String r5 = getReplayId();
        JSONObject r6 = getParams().getEcomLiveParams();
        Map<String, String> r7 = getParams().reportParams();
        StringBuilder r8 = new StringBuilder("a1.b3390.c11834.d45925_i");
        ECUIPromotion r9 = r12.a.j;
        if (r9 == null) goto L9;
        r1 = Integer.valueOf(r9.getIronIndex());
    L9:
        r8.append(r1);
        r2.c(r3, r4, r5, r6, r7, "live_fragment_replay", r8.toString(), r10);
        setState(new C02691(r12));
        xk.a r11 = getParams();
        ni2.a r13 = r12.a;
        r11.j(r13.j, r13.d, r13.e, r13.i);
        xk.a r14 = getParams();
        ni2.a r15 = r12.a;
        r14.c(r15.c, r15.j);
        return;
    L5:
        r10 = null;
        goto L6
    }

    private final void fold(a.b r1) {
        if (this.isFoldAnim == false) goto L5;
        return;
    L5:
        setState(new C02701(this));
    }

    private final void onScrollStateChanged(a.f r2) {
        if (r2.a != 1) goto L6;
        this.canAutoScrollProductCard = false;
        return;
    }

    private final void showSimpleCard(a.i r12) {
        View r0 = r12.b;
        Integer r1 = null;
        if (r0 == null) goto L5;
        String r10 = BtmSDK.INSTANCE.getPageId(PageFinder.via(r0));
    L6:
        ECLiveReplayEventUtils r2 = this.eventUtils;
        ml.b r3 = getRoomInfo();
        ni2.a r4 = r12.a;
        String r5 = getReplayId();
        JSONObject r6 = getParams().getEcomLiveParams();
        Map<String, String> r7 = getParams().reportParams();
        StringBuilder r8 = new StringBuilder("a1.b3390.c11834.d45925_i");
        ECUIPromotion r13 = r12.a.j;
        if (r13 == null) goto L9;
        r1 = Integer.valueOf(r13.getIronIndex());
    L9:
        r8.append(r1);
        r2.d(r3, r4, r5, r6, r7, "live_fragment_replay", r8.toString(), r10);
        return;
    L5:
        r10 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.AbsECScrollProductCardBaseVideModel
    public void reportPageInfoForDebug(final Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        l.a(new C02711(this, r2));
    }

    @Override // com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.AbsECScrollProductCardBaseVideModel, com.bytedance.android.livesdk.livecommerce.livereplay.repository.b, com.bytedance.android.livesdk.livecommerce.livereplay.replayrepository.a
    public void setNetworkState(NetState r2) {
        Intrinsics.checkNotNullParameter(r2, BaseCoreViewModel.CORE_TAG_STATE);
        if (r2 != NetState.SUCCESS) goto L5;
    L8:
        com.bytedance.android.ec.core.arch.event.c.d(this, a.h.a);
        return;
    L5:
        if (r2 == NetState.LOAD_MORE_ERROR) goto L8;
        com.bytedance.android.ec.core.arch.event.c.d(this, a.d.a);
    }

    public static final /* synthetic */ void access$changeFoldAnimState(ECReplayScrollProductCardViewModel r0, a.c r1) {
        r0.changeFoldAnimState(r1);
    }

    public static final /* synthetic */ void access$clickSimpleCard(ECReplayScrollProductCardViewModel r0, a.C0077a r1) {
        r0.clickSimpleCard(r1);
    }

    public static final /* synthetic */ void access$fold(ECReplayScrollProductCardViewModel r0, a.b r1) {
        r0.fold(r1);
    }

    public static final /* synthetic */ void access$onScrollStateChanged(ECReplayScrollProductCardViewModel r0, a.f r1) {
        r0.onScrollStateChanged(r1);
    }

    public static final /* synthetic */ void access$showSimpleCard(ECReplayScrollProductCardViewModel r0, a.i r1) {
        r0.showSimpleCard(r1);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.AbsECScrollProductCardBaseVideModel, com.bytedance.android.livesdk.livecommerce.livereplay.replayrepository.a
    public void selectFirstCard(final ECUIPromotion r2, final ExplainPlaybackVideoInfo r3, ECReplayVideo r4, List<ExplainReplaySubTitle> r5) {
        setState(new C02721(r2, r3));
        getParams().j(r2, r3, r4, r5);
    }

    public ECReplayScrollProductCardViewModel(ml.b r2, ml.a r3, JSONObject r4, final int r5, int r6, String r7, final xk.a r8, String r9, long r10) {
        Intrinsics.checkNotNullParameter(r2, "roomInfo");
        Intrinsics.checkNotNullParameter(r3, "btmInfo");
        Intrinsics.checkNotNullParameter(r4, "entranceInfo");
        Intrinsics.checkNotNullParameter(r7, "ecomSceneId");
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r9, "replayId");
        super(r2, r3, r4, r5, r6, r7, r8, r9, r10);
        com.bytedance.android.ec.core.arch.event.c.b(this, Reflection.getOrCreateKotlinClass(a.b.class), new AnonymousClass1(this));
        com.bytedance.android.ec.core.arch.event.c.a(this, Reflection.getOrCreateKotlinClass(a.c.class), Dispatchers.getMain(), new AnonymousClass2(this));
        com.bytedance.android.ec.core.arch.event.c.b(this, Reflection.getOrCreateKotlinClass(a.C0077a.class), new AnonymousClass3(this));
        com.bytedance.android.ec.core.arch.event.c.b(this, Reflection.getOrCreateKotlinClass(a.i.class), new AnonymousClass4(this));
        com.bytedance.android.ec.core.arch.event.c.a(this, Reflection.getOrCreateKotlinClass(a.f.class), Dispatchers.getMain(), new AnonymousClass5(this));
        this.canAutoScrollProductCard = true;
        this.requestParams$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new ECReplayScrollProductCardViewModel$requestParams$2(r8, r5));
        this.pagedList$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new ECReplayScrollProductCardViewModel$pagedList$2(this));
        this.eventUtils = new ECLiveReplayEventUtils(getHistoryMap());
    }
}
