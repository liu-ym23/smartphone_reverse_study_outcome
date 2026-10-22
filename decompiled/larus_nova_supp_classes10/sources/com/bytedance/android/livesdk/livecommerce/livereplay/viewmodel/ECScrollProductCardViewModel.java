package com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;
import com.bytedance.android.ec.sdk.helper.l;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.livecommerce.livereplay.repository.NetState;
import com.bytedance.android.livesdk.livecommerce.livereplay.utils.ECLiveReplayEventUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010H\u001a\u00020G\u0012\u0006\u0010J\u001a\u00020I\u0012\u0006\u0010K\u001a\u00020-\u0012\u0006\u0010L\u001a\u00020\u0018\u0012\u0006\u0010M\u001a\u00020\u0018\u0012\u0006\u0010O\u001a\u00020N\u0012\u0006\u0010Q\u001a\u00020P\u0012\u0006\u0010R\u001a\u00020N\u0012\u0006\u0010S\u001a\u00020\u000f¢\u0006\u0004\bT\u0010UJ\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002Jh\u0010 \u001a\u00020\u00182\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00152\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182>\u0010\u001f\u001a:\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00180\u001bH\u0002J\b\u0010!\u001a\u00020\u0004H\u0016J\u0016\u0010\"\u001a\u00020\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015H\u0016J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0018H\u0016J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%H\u0016J\b\u0010(\u001a\u00020\u0004H\u0016J\b\u0010)\u001a\u00020\u0004H\u0014J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*H\u0016J\b\u0010.\u001a\u00020-H\u0016RD\u0010/\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00040\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00103\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00102R\u0016\u00104\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b6\u00107R\u001b\u0010=\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R)\u0010C\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160?0>8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b@\u0010:\u001a\u0004\bA\u0010BR\u0014\u0010E\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010F¨\u0006V"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/ECScrollProductCardViewModel;", "Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/AbsECScrollProductCardBaseVideModel;", "Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$b;", "fold", "", "Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$c;", "foldAnim", "changeFoldAnimState", "Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$i;", "showSimpleCard", "Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$a;", "clickSimpleCard", "Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$f;", "stateChanged", "onScrollStateChanged", "", "progress", "", "isFromUser", "onProgressListener", "clearDisposable", "", "Lni2/a;", "list", "", "from", "to", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "index", "predicate", "binarySearchTimeIndex", "clickProductCard", "setPageTimestamp", "count", "setTotalCount", "Lcom/bytedance/android/livesdk/livecommerce/livereplay/repository/NetState;", BaseCoreViewModel.CORE_TAG_STATE, "setNetworkState", "onInvalidated", "onCleared", "Landroid/content/Context;", "context", "reportPageInfoForDebug", "Lorg/json/JSONObject;", "getEntranceInfos", "progressListener", "Lkotlin/jvm/functions/Function2;", "canAutoScrollProductCard", "Z", "isFoldAnim", "totalCount", "I", "pageTimestamp", "Ljava/util/List;", "Loi2/b;", "requestParams$delegate", "Lkotlin/Lazy;", "getRequestParams", "()Loi2/b;", "requestParams", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagedList;", "pagedList$delegate", "getPagedList", "()Landroidx/lifecycle/LiveData;", "pagedList", "Lcom/bytedance/android/livesdk/livecommerce/livereplay/utils/ECLiveReplayEventUtils;", "eventUtils", "Lcom/bytedance/android/livesdk/livecommerce/livereplay/utils/ECLiveReplayEventUtils;", "Lml/b;", "roomInfo", "Lml/a;", "btmInfo", "entranceInfo", "pageSize", "funType", "", "ecomSceneId", "Lxk/a;", "params", "replayId", "replayStartTime", "<init>", "(Lml/b;Lml/a;Lorg/json/JSONObject;IILjava/lang/String;Lxk/a;Ljava/lang/String;J)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECScrollProductCardViewModel extends AbsECScrollProductCardBaseVideModel {
    private boolean canAutoScrollProductCard;
    private final ECLiveReplayEventUtils eventUtils;
    private boolean isFoldAnim;
    private List<Long> pageTimestamp;
    private final Lazy pagedList$delegate;
    private final Function2<Long, Boolean, Unit> progressListener;
    private final Lazy requestParams$delegate;
    private volatile int totalCount;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.ECScrollProductCardViewModel$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$b;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<a.b, Unit> {
        public AnonymousClass1(ECScrollProductCardViewModel r8) {
            super(1, r8, ECScrollProductCardViewModel.class, "fold", "fold(Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/ECScrollProductCardEvent$Fold;)V", 0);
        }

        public final void invoke(a.b r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            ECScrollProductCardViewModel.access$fold((ECScrollProductCardViewModel) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((a.b) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.ECScrollProductCardViewModel$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$c;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$c;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<a.c, Unit> {
        public AnonymousClass2(ECScrollProductCardViewModel r8) {
            super(1, r8, ECScrollProductCardViewModel.class, "changeFoldAnimState", "changeFoldAnimState(Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/ECScrollProductCardEvent$FoldAnim;)V", 0);
        }

        public final void invoke(a.c r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            ECScrollProductCardViewModel.access$changeFoldAnimState((ECScrollProductCardViewModel) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((a.c) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.ECScrollProductCardViewModel$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$a;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<a.C0077a, Unit> {
        public AnonymousClass3(ECScrollProductCardViewModel r8) {
            super(1, r8, ECScrollProductCardViewModel.class, "clickSimpleCard", "clickSimpleCard(Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/ECScrollProductCardEvent$ClickSimpleCard;)V", 0);
        }

        public final void invoke(a.C0077a r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            ECScrollProductCardViewModel.access$clickSimpleCard((ECScrollProductCardViewModel) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((a.C0077a) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.ECScrollProductCardViewModel$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$i;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$i;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<a.i, Unit> {
        public AnonymousClass4(ECScrollProductCardViewModel r8) {
            super(1, r8, ECScrollProductCardViewModel.class, "showSimpleCard", "showSimpleCard(Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/ECScrollProductCardEvent$ShowSimpleCard;)V", 0);
        }

        public final void invoke(a.i r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            ECScrollProductCardViewModel.access$showSimpleCard((ECScrollProductCardViewModel) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((a.i) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.ECScrollProductCardViewModel$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$f;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$f;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<a.f, Unit> {
        public AnonymousClass5(ECScrollProductCardViewModel r8) {
            super(1, r8, ECScrollProductCardViewModel.class, "onScrollStateChanged", "onScrollStateChanged(Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/ECScrollProductCardEvent$OnScrollStateChanged;)V", 0);
        }

        public final void invoke(a.f r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            ECScrollProductCardViewModel.access$onScrollStateChanged((ECScrollProductCardViewModel) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((a.f) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.ECScrollProductCardViewModel$onProgressListener$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class C02751 extends MutablePropertyReference0Impl {
        public C02751(ECScrollProductCardViewModel r7) {
            super(r7, ECScrollProductCardViewModel.class, "pageTimestamp", "getPageTimestamp()Ljava/util/List;", 0);
        }

        public Object get() {
            return ECScrollProductCardViewModel.access$getPageTimestamp$p((ECScrollProductCardViewModel) ((CallableReference) this).receiver);
        }

        public void set(Object r2) {
            ECScrollProductCardViewModel.access$setPageTimestamp$p((ECScrollProductCardViewModel) ((CallableReference) this).receiver, (List) r2);
        }
    }

    private final oi2.b getRequestParams() {
        return (oi2.b) this.requestParams$delegate.getValue();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.AbsECScrollProductCardBaseVideModel
    public void clickProductCard() {
        this.canAutoScrollProductCard = false;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.AbsECScrollProductCardBaseVideModel
    public LiveData<PagedList<ni2.a>> getPagedList() {
        return (LiveData) this.pagedList$delegate.getValue();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.AbsECScrollProductCardBaseVideModel
    public JSONObject getEntranceInfos() {
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L14
        JSONObject r5 = new JSONObject(getParams().reportParams());     // Catch: Throwable -> L14
        r5.put("ecom_scene_id", getEcomSceneId());     // Catch: Throwable -> L14
        r5.put("episode_id", getReplayId());     // Catch: Throwable -> L14
        r5.put("ecom_entrance_form", "replay_live_card");     // Catch: Throwable -> L14
        r5.put("carrier_type", "replay_live_card");     // Catch: Throwable -> L14
        r5.put("room_id", getRoomInfo().roomId());     // Catch: Throwable -> L14
        r5.put("anchor_id", getRoomInfo().c());     // Catch: Throwable -> L14
        Map r3 = getParams().reportParams();     // Catch: Throwable -> L14
        String r6 = (String) r3.get("enter_from_merge");     // Catch: Throwable -> L14
        if (r6 == null) goto L6;
        r5.put("enter_from_merge", r6);     // Catch: Throwable -> L14
    L6:
        String r2 = (String) r3.get("enter_method");     // Catch: Throwable -> L14
        if (r2 == null) goto L9;
        r5.put("enter_method", r2);     // Catch: Throwable -> L14
    L9:
        String r1 = (String) r3.get("action_type");     // Catch: Throwable -> L14
        if (r1 == null) goto L12;
        r5.put("action_type", r1);     // Catch: Throwable -> L14
    L12:
        Object r0 = Result.constructor-impl(r5);     // Catch: Throwable -> L14
    L16:
        JSONObject r7 = new JSONObject();
        if (Result.isFailure-impl(r0) == false) goto L20;
        r0 = r7;
    L20:
        return (JSONObject) r0;
    L14:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }

    public void onCleared() {
        super/*com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModel*/.onCleared();
        clearDisposable();
        il.a.a(getHistoryMap());
        getParams().removeReplayProgressListener(this.progressListener);
    }

    private final void clearDisposable() {
        doClear();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.AbsECScrollProductCardBaseVideModel, com.bytedance.android.livesdk.livecommerce.livereplay.repository.b, com.bytedance.android.livesdk.livecommerce.livereplay.replayrepository.a
    public void onInvalidated() {
        clearDisposable();
    }

    public static final /* synthetic */ ECLiveReplayEventUtils access$getEventUtils$p(ECScrollProductCardViewModel r0) {
        return r0.eventUtils;
    }

    public static final /* synthetic */ List access$getPageTimestamp$p(ECScrollProductCardViewModel r1) {
        List<Long> r2 = r1.pageTimestamp;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pageTimestamp");
    L5:
        return r2;
    }

    public static final /* synthetic */ oi2.b access$getRequestParams$p(ECScrollProductCardViewModel r0) {
        return r0.getRequestParams();
    }

    public static final /* synthetic */ int access$getTotalCount$p(ECScrollProductCardViewModel r0) {
        return r0.totalCount;
    }

    private final void changeFoldAnimState(a.c r1) {
        this.isFoldAnim = r1.a;
    }

    private final void clickSimpleCard(final a.C0077a r11) {
        this.eventUtils.c(getRoomInfo(), r11.a, getReplayId(), getParams().getEcomLiveParams(), getParams().reportParams(), null, null, null);
        long r2 = 1000;
        long r0 = getParams().getReplayProgress() / r2;
        long r4 = r11.a.k - getReplayStartTime();
        long r6 = r11.a.l - getReplayStartTime();
        setState(new C02731(r11));
        if (r4 > r0) goto L9;
        if (r6 < r0) goto L9;
        return;
    L9:
        if (r4 > 0) goto L11;
    L16:
        com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.c().b("[ECScrollProductCardViewModel clickSimpleCard] replayStartTime: " + getReplayStartTime() + " progress: " + r0 + " startTime: " + r4 + " endTime: " + r6 + " is error", null);
        return;
    L11:
        if (r6 <= 0) goto L16;
        if (r4 >= r6) goto L16;
        getParams().seekReplayProgress(r4 * r2);
    }

    private final void fold(a.b r1) {
        if (this.isFoldAnim == false) goto L5;
        return;
    L5:
        setState(new C02741(this));
    }

    private final void onScrollStateChanged(a.f r2) {
        if (r2.a != 1) goto L6;
        this.canAutoScrollProductCard = false;
        return;
    }

    private final void showSimpleCard(a.i r10) {
        this.eventUtils.d(getRoomInfo(), r10.a, getReplayId(), getParams().getEcomLiveParams(), getParams().reportParams(), null, null, null);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.AbsECScrollProductCardBaseVideModel
    public void reportPageInfoForDebug(final Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        l.a(new C02781(this, r2));
    }

    @Override // com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.AbsECScrollProductCardBaseVideModel, com.bytedance.android.livesdk.livecommerce.livereplay.repository.b, com.bytedance.android.livesdk.livecommerce.livereplay.replayrepository.a
    public void setNetworkState(NetState r2) {
        Intrinsics.checkNotNullParameter(r2, BaseCoreViewModel.CORE_TAG_STATE);
        if (r2 == NetState.SUCCESS) goto L5;
        com.bytedance.android.ec.core.arch.event.c.d(this, a.d.a);
        return;
    L5:
        com.bytedance.android.ec.core.arch.event.c.d(this, a.h.a);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.AbsECScrollProductCardBaseVideModel, com.bytedance.android.livesdk.livecommerce.livereplay.repository.b
    public void setPageTimestamp(List<Long> r2) {
        Intrinsics.checkNotNullParameter(r2, "list");
        this.pageTimestamp = r2;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.AbsECScrollProductCardBaseVideModel, com.bytedance.android.livesdk.livecommerce.livereplay.repository.b
    public void setTotalCount(int r1) {
        this.totalCount = r1;
    }

    public static final /* synthetic */ void access$changeFoldAnimState(ECScrollProductCardViewModel r0, a.c r1) {
        r0.changeFoldAnimState(r1);
    }

    public static final /* synthetic */ void access$clickSimpleCard(ECScrollProductCardViewModel r0, a.C0077a r1) {
        r0.clickSimpleCard(r1);
    }

    public static final /* synthetic */ void access$fold(ECScrollProductCardViewModel r0, a.b r1) {
        r0.fold(r1);
    }

    public static final /* synthetic */ void access$onScrollStateChanged(ECScrollProductCardViewModel r0, a.f r1) {
        r0.onScrollStateChanged(r1);
    }

    public static final /* synthetic */ void access$setPageTimestamp$p(ECScrollProductCardViewModel r0, List r1) {
        r0.pageTimestamp = r1;
    }

    public static final /* synthetic */ void access$setState(ECScrollProductCardViewModel r0, Function1 r1) {
        r0.setState(r1);
    }

    public static final /* synthetic */ void access$setTotalCount$p(ECScrollProductCardViewModel r0, int r1) {
        r0.totalCount = r1;
    }

    public static final /* synthetic */ void access$showSimpleCard(ECScrollProductCardViewModel r0, a.i r1) {
        r0.showSimpleCard(r1);
    }

    private final void onProgressListener(long r15, boolean r17) {
        if (this.pageTimestamp == null) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L8;
        return;
    L8:
        if (r17 == false) goto L11;
        this.canAutoScrollProductCard = true;
        return;
    L11:
        final long r7 = (r15 / ((long) 1000)) + getReplayStartTime();
        if (this.canAutoScrollProductCard == true) goto L14;
        return;
    L14:
        List<Long> r3 = this.pageTimestamp;
        if (r3 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("pageTimestamp");
    L18:
        if (r7 >= ((Number) CollectionsKt.first(r3)).longValue()) goto L21;
        withState(new C02762(this));
        return;
    L21:
        List<Long> r4 = this.pageTimestamp;
        if (r4 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("pageTimestamp");
    L24:
        long r9 = ((Number) CollectionsKt.last(r4)).longValue();
        int r5 = -1;
        if (r7 < r9) goto L30;
        List<Long> r10 = this.pageTimestamp;
        if (r10 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("pageTimestamp");
    L29:
        int r11 = r10.size();
    L44:
        ni2.a r12 = null;
        if (r11 > 0) goto L51;
        dm.a.b r6 = com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.c();
        StringBuilder r8 = new StringBuilder("[ECScrollProductCardViewModel onProgressListener]获取页码不正确 page: ");
        r8.append(r11);
        r8.append(" progress: ");
        r8.append(r15);
        r8.append(" replayStartTime: ");
        r8.append(getReplayStartTime());
        r8.append(" pageTimestamp: ");
        List<Long> r0 = this.pageTimestamp;
        if (r0 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("pageTimestamp");
    L49:
        r8.append(r0);
        r6.b(r8.toString(), null);
        return;
    L51:
        final int r13 = (r11 - 1) * getPageSize();
        PagedList r1 = (PagedList) getPagedList().getValue();
        if (r1 == null) goto L54;
        List<ni2.a> r14 = r1.snapshot();
    L55:
        if (r13 < 0) goto L67;
        if (r14 == null) goto L58;
        r5 = r14.size();
    L58:
        if (r13 >= r5) goto L67;
        if (r14 == null) goto L62;
        r12 = (ni2.a) ListProtector.get(r14, r13);
    L62:
        if (r12 != null) goto L65;
        com.bytedance.android.ec.core.arch.event.c.d(this, new a.e(r13));
        return;
    L65:
        final int r16 = binarySearchTimeIndex(r14, r13, RangesKt.coerceAtMost(r14.size(), getPageSize() + r13), new ECScrollProductCardViewModel$onProgressListener$$inlined$let$lambda$1(this, r13, r7));
        final List<ni2.a> r18 = r14;
        withState(new C02773(this, r18, r16, r7));
        return;
    L67:
        com.bytedance.android.ec.core.arch.event.c.d(this, new a.g(r13, false));
        return;
    L54:
        r14 = null;
        goto L55
    L30:
        List<Long> r19 = this.pageTimestamp;
        if (r19 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("pageTimestamp");
    L33:
        Iterator<Long> r20 = r19.iterator();
        int r110 = 0;
    L35:
        if (r20.hasNext() == false) goto L43;
        if (r20.next().longValue() <= r7) goto L39;
        boolean r111 = true;
    L40:
        if (r111 == true) goto L41;
        r110 = r110 + 1;
        goto L35
    L41:
        r11 = r110;
        goto L44
    L39:
        r111 = false;
        goto L40
    L43:
        r11 = -1;
        goto L44
    L5:
        r2 = false;
        goto L6
    }

    public static final /* synthetic */ void access$onProgressListener(ECScrollProductCardViewModel r0, long r1, boolean r3) {
        r0.onProgressListener(r1, r3);
    }

    private final int binarySearchTimeIndex(List<ni2.a> r3, int r4, int r5, Function2<? super List<ni2.a>, ? super Integer, Integer> r6) {
        int r7 = r5 - 1;
    L3:
        if (r4 > r7) goto L10;
        int r0 = ((r7 - r4) / 2) + r4;
        int r1 = ((Number) r6.invoke(r3, Integer.valueOf(r0))).intValue();
        if (r1 == 0) goto L6;
        if (r1 > 0) goto L8;
        r7 = r0 - 1;
        goto L3
    L8:
        r4 = r0 + 1;
        goto L3
    L6:
        return r0;
    L10:
        return -1;
    }

    public ECScrollProductCardViewModel(final ml.b r11, ml.a r12, JSONObject r13, final int r14, int r15, String r16, final xk.a r17, final String r18, long r19) {
        Intrinsics.checkNotNullParameter(r11, "roomInfo");
        Intrinsics.checkNotNullParameter(r12, "btmInfo");
        Intrinsics.checkNotNullParameter(r13, "entranceInfo");
        Intrinsics.checkNotNullParameter(r16, "ecomSceneId");
        Intrinsics.checkNotNullParameter(r17, "params");
        Intrinsics.checkNotNullParameter(r18, "replayId");
        super(r11, r12, r13, r14, r15, r16, r17, r18, r19);
        ECScrollProductCardViewModel$progressListener$1 r0 = new ECScrollProductCardViewModel$progressListener$1(this);
        this.progressListener = r0;
        com.bytedance.android.ec.core.arch.event.c.b(this, Reflection.getOrCreateKotlinClass(a.b.class), new AnonymousClass1(this));
        com.bytedance.android.ec.core.arch.event.c.a(this, Reflection.getOrCreateKotlinClass(a.c.class), Dispatchers.getMain(), new AnonymousClass2(this));
        com.bytedance.android.ec.core.arch.event.c.b(this, Reflection.getOrCreateKotlinClass(a.C0077a.class), new AnonymousClass3(this));
        com.bytedance.android.ec.core.arch.event.c.b(this, Reflection.getOrCreateKotlinClass(a.i.class), new AnonymousClass4(this));
        com.bytedance.android.ec.core.arch.event.c.a(this, Reflection.getOrCreateKotlinClass(a.f.class), Dispatchers.getMain(), new AnonymousClass5(this));
        r17.addReplayProgressListener(r0);
        this.canAutoScrollProductCard = true;
        this.requestParams$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new ECScrollProductCardViewModel$requestParams$2(this, r11, r17, r14, r18));
        this.pagedList$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new ECScrollProductCardViewModel$pagedList$2(this));
        this.eventUtils = new ECLiveReplayEventUtils(getHistoryMap());
    }
}
