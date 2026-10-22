package com.larus.avlink.env.diary.detail;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.larus.account.base.api.ILoginService;
import com.larus.avlink.api.DoraGResourceServiceDelegate;
import com.larus.avlink.env.diary.feedback.api.DoraEnvObserveDiaryFeedbackApi;
import com.larus.avlink.env.diary.feedback.model.DiaryFeedbackToastType;
import com.larus.dora.api.config.IDoraPageConfig;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 S2\u00020\u0001:\u0001SB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0005J\u0006\u00102\u001a\u000200J\u0016\u00103\u001a\u0002002\u0006\u00104\u001a\u00020%2\u0006\u00101\u001a\u00020\u0005J\u000e\u00105\u001a\u0002002\u0006\u00104\u001a\u00020%J\u000e\u00106\u001a\u00020%2\u0006\u00107\u001a\u00020%J\u0014\u00108\u001a\u0002002\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00050#J\u000e\u0010:\u001a\u0002002\u0006\u0010;\u001a\u00020\u0005J\u0006\u0010<\u001a\u000200J\u0006\u0010=\u001a\u000200J\u0006\u0010>\u001a\u000200J\u000e\u0010?\u001a\u0002002\u0006\u0010@\u001a\u00020AJ&\u0010B\u001a\u0002002\b\u0010C\u001a\u0004\u0018\u00010D2\u0006\u00101\u001a\u00020\u00052\f\u0010E\u001a\b\u0012\u0004\u0012\u0002000FJ\u0006\u0010G\u001a\u00020\u000fJ\u0006\u0010H\u001a\u00020\u000fJ\b\u0010I\u001a\u000200H\u0002J\u0010\u0010J\u001a\u0002002\u0006\u00101\u001a\u00020\u0005H\u0002J\u0018\u0010K\u001a\u0002002\u0006\u00101\u001a\u00020\u00052\u0006\u00104\u001a\u00020%H\u0002J\u0010\u0010L\u001a\u0002002\u0006\u00101\u001a\u00020\u0005H\u0002J\u0010\u0010M\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u0005H\u0002J\u0010\u0010N\u001a\u0002002\u0006\u00101\u001a\u00020\u0005H\u0002J\b\u0010O\u001a\u000200H\u0002J\b\u0010P\u001a\u000200H\u0002J\u0010\u0010Q\u001a\u0002002\u0006\u00104\u001a\u00020%H\u0002J\b\u0010R\u001a\u000200H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050 X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010!\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010#\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0004\n\u0002\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010)\u001a\u0004\u0018\u00010*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b+\u0010,¨\u0006T"}, d2 = {"Lcom/larus/avlink/env/diary/detail/DoraEnvObserveDiaryDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "TAG", "", "userId", "getUserId", "()Ljava/lang/String;", "diaryDetailLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/avlink/env/diary/detail/model/DiaryDetail;", "getDiaryDetailLiveData", "()Landroidx/lifecycle/MutableLiveData;", "_isLoading", "", "isLoading", "Landroidx/lifecycle/LiveData;", "isLoading$dora_avlink_impl_release", "()Landroidx/lifecycle/LiveData;", "_feedbackSheetState", "Lcom/larus/avlink/env/diary/feedback/model/DiaryFeedbackSheetUiState;", "feedbackSheetState", "getFeedbackSheetState", "_toastEffect", "Lcom/larus/avlink/env/diary/feedback/model/DiaryFeedbackToastEffect;", "toastEffect", "getToastEffect", "feedbackDraftCache", "", "Lcom/larus/avlink/env/diary/feedback/model/DiaryFeedbackDraft;", "feedbackDraftDiaryIds", "Ljava/util/LinkedHashSet;", "feedbackConfigMap", "", "", "pendingFeedbackActionType", "", "Ljava/lang/Integer;", "currentDiaryId", "isFeedbackRequestInFlight", "doraPageConfig", "Lcom/larus/dora/api/config/IDoraPageConfig;", "getDoraPageConfig", "()Lcom/larus/dora/api/config/IDoraPageConfig;", "doraPageConfig$delegate", "Lkotlin/Lazy;", "fetchDiaryDetail", "", "diaryId", "loadFeedbackConfigIfNeeded", "openFeedbackSheet", ReportConstant.COMMON_ACTION_TYPE, "previewFeedbackActionType", "getDisplayedFeedbackActionType", "committedActionType", "updateSelectedReasons", "selectedReasons", "updateInputText", "inputText", "saveDraft", "submitFeedback", "cancelFeedback", "onFeedbackSheetDismissed", "sessionId", "", "deleteDiary", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "onSuccess", "Lkotlin/Function0;", "isEnvObserveEnable", "inEnvObserveScene", "refreshSheetReasonOptions", "clearFeedbackStateForNewDiary", "clearDraft", "syncDraftDiaryState", "hasDraftForDiary", "touchDraftDiary", "trimDraftDiaryCacheIfNeeded", "refreshFeedbackActionTypeDisplay", "updateDiaryFeedbackActionType", "syncDiaryFeedbackActionType", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraEnvObserveDiaryDetailViewModel extends ViewModel {
    public static final int $stable = 0;
    public static final a Companion = null;
    private static final int MAX_CACHED_DRAFT_DIARY_COUNT = 10;
    private final String TAG;
    private final MutableLiveData<j98.f> _feedbackSheetState;
    private final MutableLiveData<Boolean> _isLoading;
    private final MutableLiveData<j98.g> _toastEffect;
    private String currentDiaryId;
    private final MutableLiveData<i98.a> diaryDetailLiveData;
    private final Lazy doraPageConfig$delegate;
    private Map<String, ? extends List<String>> feedbackConfigMap;
    private final Map<String, j98.b> feedbackDraftCache;
    private final LinkedHashSet<String> feedbackDraftDiaryIds;
    private final LiveData<j98.f> feedbackSheetState;
    private boolean isFeedbackRequestInFlight;
    private final LiveData<Boolean> isLoading;
    private Integer pendingFeedbackActionType;
    private final LiveData<j98.g> toastEffect;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.env.diary.detail.DoraEnvObserveDiaryDetailViewModel$cancelFeedback$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.avlink.env.diary.detail.DoraEnvObserveDiaryDetailViewModel$cancelFeedback$1", f = "DoraEnvObserveDiaryDetailViewModel.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $diaryId;
        int label;
        final /* synthetic */ DoraEnvObserveDiaryDetailViewModel this$0;

        public AnonymousClass1(DoraEnvObserveDiaryDetailViewModel r100, String r101, Continuation<? super AnonymousClass1> r102) {
            this.this$0 = r100;
            this.$diaryId = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, this.$diaryId, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L9;
            if (r102 != 1) goto L8;
            ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L21 Exception -> L23
        L13:
            dm9.a r103 = (dm9.a) r100;     // Catch: Throwable -> L21 Exception -> L23
            if ((r103 instanceof dm9.a.b) == false) goto L17;
            DoraEnvObserveDiaryDetailViewModel.access$updateDiaryFeedbackActionType(this.this$0, 0);     // Catch: Throwable -> L21 Exception -> L23
        L25:
            DoraEnvObserveDiaryDetailViewModel.access$setFeedbackRequestInFlight$p(this.this$0, false);
            return Unit.INSTANCE;
        L17:
            if ((r103 instanceof dm9.a.C5690a) == false) goto L20;
            FLogger.f375446a.e(DoraEnvObserveDiaryDetailViewModel.access$getTAG$p(this.this$0), "cancelFeedback error: " + ((dm9.a.C5690a) r103).f469229b);     // Catch: Throwable -> L21 Exception -> L23
            DoraEnvObserveDiaryDetailViewModel.access$syncDiaryFeedbackActionType(this.this$0);     // Catch: Throwable -> L21 Exception -> L23
            DoraEnvObserveDiaryDetailViewModel.access$get_toastEffect$p(this.this$0).setValue(new j98.g(R.string.larus_dora_personal_diary_feedback_fail_toast_cn, DiaryFeedbackToastType.FAILURE));     // Catch: Throwable -> L21 Exception -> L23
            goto L25
        L20:
            throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L21 Exception -> L23
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r100);
            DoraEnvObserveDiaryFeedbackApi.a r104 = DoraEnvObserveDiaryFeedbackApi.f292058a;     // Catch: Throwable -> L21 Exception -> L23
            DoraEnvObserveDiaryDetailViewModel$cancelFeedback$1$result$1 r105 = new DoraEnvObserveDiaryDetailViewModel$cancelFeedback$1$result$1(this.$diaryId, null);     // Catch: Throwable -> L21 Exception -> L23
            this.label = 1;     // Catch: Throwable -> L21 Exception -> L23
            r104.getClass();     // Catch: Throwable -> L21 Exception -> L23
            r100 = DoraEnvObserveDiaryFeedbackApi.a.a(r105, this);     // Catch: Throwable -> L21 Exception -> L23
            if (r100 != r101) goto L13;
            return r101;
        L23:
            e = move-exception;
            FLogger.f375446a.e(DoraEnvObserveDiaryDetailViewModel.access$getTAG$p(this.this$0), "cancelFeedback error", e);     // Catch: Throwable -> L21
            DoraEnvObserveDiaryDetailViewModel.access$syncDiaryFeedbackActionType(this.this$0);     // Catch: Throwable -> L21
            DoraEnvObserveDiaryDetailViewModel.access$get_toastEffect$p(this.this$0).setValue(new j98.g(R.string.larus_dora_personal_diary_feedback_fail_toast_cn, DiaryFeedbackToastType.FAILURE));     // Catch: Throwable -> L21
        L21:
            th = move-exception;
            DoraEnvObserveDiaryDetailViewModel.access$setFeedbackRequestInFlight$p(this.this$0, false);
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.env.diary.detail.DoraEnvObserveDiaryDetailViewModel$deleteDiary$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.avlink.env.diary.detail.DoraEnvObserveDiaryDetailViewModel$deleteDiary$1", f = "DoraEnvObserveDiaryDetailViewModel.kt", i = {}, l = {328}, m = "invokeSuspend", n = {}, s = {})
    public static final class C108131 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $diaryId;
        final /* synthetic */ Function0<Unit> $onSuccess;
        int label;
        final /* synthetic */ DoraEnvObserveDiaryDetailViewModel this$0;

        public C108131(DoraEnvObserveDiaryDetailViewModel r100, String r101, Function0<Unit> r102, Context r103, Continuation<? super C108131> r104) {
            this.this$0 = r100;
            this.$diaryId = r101;
            this.$onSuccess = r102;
            this.$context = r103;
            super(2, r104);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C108131(this.this$0, this.$diaryId, this.$onSuccess, this.$context, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C108131) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L9;
            if (r101 != 1) goto L8;
            ResultKt.throwOnFailure(r110);     // Catch: Exception -> L20
        L13:
            com.larus.network.http.a r111 = (com.larus.network.http.a) r110;     // Catch: Exception -> L20
            if ((r111 instanceof com.larus.network.http.y) == false) goto L17;
            FLogger.f375446a.i(DoraEnvObserveDiaryDetailViewModel.access$getTAG$p(this.this$0), "deleteDiary success");     // Catch: Exception -> L20
            DoraGResourceServiceDelegate.f291642b.f(this.$diaryId);     // Catch: Exception -> L20
            this.$onSuccess.invoke();     // Catch: Exception -> L20
        L23:
            return Unit.INSTANCE;
        L17:
            if ((r111 instanceof com.larus.network.http.f) == false) goto L23;
            t19.s r102 = t19.s.f544207a;     // Catch: Exception -> L20
            Context r103 = this.$context;     // Catch: Exception -> L20
            r102.getClass();     // Catch: Exception -> L20
            t19.s.b(r103, R.string.larus_dora_wifi_toast_delete_failed_cn, false);     // Catch: Exception -> L20
            FLogger.f375446a.e(DoraEnvObserveDiaryDetailViewModel.access$getTAG$p(this.this$0), "Error deleting diary", ((com.larus.network.http.f) r111).f360157d);     // Catch: Exception -> L20
            goto L23
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r110);
            JSONObject r104 = new JSONObject();     // Catch: Exception -> L20
            String r112 = this.$diaryId;     // Catch: Exception -> L20
            r104.put("diary_ids", new JSONArray().put(r112));     // Catch: Exception -> L20
            com.larus.dora.api.network.a r113 = com.larus.dora.api.network.a.f331768a;     // Catch: Exception -> L20
            this.label = 1;     // Catch: Exception -> L20
            r110 = com.larus.dora.api.network.a.c(r113, Object.class, "/alice/wearable/diary/delete_user_diary", r104, null, this, 248);     // Catch: Exception -> L20
            if (r110 != r100) goto L13;
            return r100;
        L20:
            e = move-exception;
            t19.s r105 = t19.s.f544207a;
            Context r106 = this.$context;
            r105.getClass();
            t19.s.b(r106, R.string.larus_dora_wifi_toast_delete_failed_cn, false);
            FLogger.f375446a.e(DoraEnvObserveDiaryDetailViewModel.access$getTAG$p(this.this$0), "Error deleting diary", e);
            goto L23
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.env.diary.detail.DoraEnvObserveDiaryDetailViewModel$fetchDiaryDetail$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.avlink.env.diary.detail.DoraEnvObserveDiaryDetailViewModel$fetchDiaryDetail$1", f = "DoraEnvObserveDiaryDetailViewModel.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
    public static final class C108141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $diaryId;
        int label;
        final /* synthetic */ DoraEnvObserveDiaryDetailViewModel this$0;

        public C108141(DoraEnvObserveDiaryDetailViewModel r100, String r101, Continuation<? super C108141> r102) {
            this.this$0 = r100;
            this.$diaryId = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C108141(this.this$0, this.$diaryId, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C108141) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r210) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L9;
            if (r101 != 1) goto L8;
            ResultKt.throwOnFailure(r210);     // Catch: Throwable -> L33 Exception -> L35
            Object r102 = r210;
        L13:
            com.larus.network.http.a r103 = (com.larus.network.http.a) r102;     // Catch: Throwable -> L33 Exception -> L35
            if ((r103 instanceof com.larus.network.http.y) == false) goto L30;
            i98.b r104 = (i98.b) ((com.larus.network.http.y) r103).f360135b;     // Catch: Throwable -> L33 Exception -> L35
            if (r104 == null) goto L28;
            i98.a r105 = r104.a();     // Catch: Throwable -> L33 Exception -> L35
            if (r105 == null) goto L37;
            DoraEnvObserveDiaryDetailViewModel r106 = this.this$0;     // Catch: Throwable -> L33 Exception -> L35
            FLogger r107 = FLogger.f375446a;     // Catch: Throwable -> L33 Exception -> L35
            String r108 = DoraEnvObserveDiaryDetailViewModel.access$getTAG$p(r106);     // Catch: Throwable -> L33 Exception -> L35
            StringBuilder r109 = new StringBuilder("Received diary detail: id=");     // Catch: Throwable -> L33 Exception -> L35
            r109.append(r105.i());     // Catch: Throwable -> L33 Exception -> L35
            r109.append(", tempField size=");     // Catch: Throwable -> L33 Exception -> L35
            List<String> r110 = r105.d();     // Catch: Throwable -> L33 Exception -> L35
            if (r110 == null) goto L22;
            Integer r111 = Boxing.boxInt(r110.size());     // Catch: Throwable -> L33 Exception -> L35
        L23:
            r109.append(r111);     // Catch: Throwable -> L33 Exception -> L35
            r107.d(r108, r109.toString());     // Catch: Throwable -> L33 Exception -> L35
            String r112 = String.valueOf(r105.i());     // Catch: Throwable -> L33 Exception -> L35
            String r113 = r105.e();     // Catch: Throwable -> L33 Exception -> L35
            String r114 = r105.m();     // Catch: Throwable -> L33 Exception -> L35
            String r115 = r105.k();     // Catch: Throwable -> L33 Exception -> L35
            List<String> r116 = r105.d();     // Catch: Throwable -> L33 Exception -> L35
            l98.b r117 = r105.g();     // Catch: Throwable -> L33 Exception -> L35
            String r118 = r105.l();     // Catch: Throwable -> L33 Exception -> L35
            String r211 = r105.j();     // Catch: Throwable -> L33 Exception -> L35
            Boolean r212 = r105.h();     // Catch: Throwable -> L33 Exception -> L35
            m98.b r213 = r105.f();     // Catch: Throwable -> L33 Exception -> L35
            Integer r119 = r105.b();     // Catch: Throwable -> L33 Exception -> L35
            if (r119 == null) goto L26;
            int r120 = r119.intValue();     // Catch: Throwable -> L33 Exception -> L35
        L27:
            i98.a r121 = new i98.a(r112, r113, r114, r115, r116, r117, r118, r211, r213, r212, Boxing.boxInt(r120), 8);     // Catch: Throwable -> L33 Exception -> L35
            r106.getDiaryDetailLiveData().postValue(r121);     // Catch: Throwable -> L33 Exception -> L35
            goto L37
        L26:
            r120 = 0;
            goto L27
        L22:
            r111 = null;
        L37:
            DoraEnvObserveDiaryDetailViewModel.access$get_isLoading$p(this.this$0).postValue(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        L28:
            FLogger.f375446a.e(DoraEnvObserveDiaryDetailViewModel.access$getTAG$p(this.this$0), "Error loading diary detail: responseBody is null.");     // Catch: Throwable -> L33 Exception -> L35
            goto L37
        L30:
            if ((r103 instanceof com.larus.network.http.f) == false) goto L37;
            FLogger.f375446a.e(DoraEnvObserveDiaryDetailViewModel.access$getTAG$p(this.this$0), "Error loading diary detail", ((com.larus.network.http.f) r103).f360157d);     // Catch: Throwable -> L33 Exception -> L35
            goto L37
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r210);
            DoraEnvObserveDiaryDetailViewModel.access$get_isLoading$p(this.this$0).postValue(Boxing.boxBoolean(true));
            JSONObject r122 = new JSONObject();     // Catch: Throwable -> L33 Exception -> L35
            DoraEnvObserveDiaryDetailViewModel r123 = this.this$0;     // Catch: Throwable -> L33 Exception -> L35
            String r124 = this.$diaryId;     // Catch: Throwable -> L33 Exception -> L35
            r122.put("user_id", DoraEnvObserveDiaryDetailViewModel.access$getUserId(r123));     // Catch: Throwable -> L33 Exception -> L35
            r122.put("diary_id", r124);     // Catch: Throwable -> L33 Exception -> L35
            com.larus.dora.api.network.a r125 = com.larus.dora.api.network.a.f331768a;     // Catch: Throwable -> L33 Exception -> L35
            this.label = 1;     // Catch: Throwable -> L33 Exception -> L35
            r102 = com.larus.dora.api.network.a.c(r125, i98.b.class, "/alice/wearable/diary/get_diary_detail_v2", r122, null, this, 248);     // Catch: Throwable -> L33 Exception -> L35
            if (r102 != r100) goto L13;
            return r100;
        L33:
            th = move-exception;
            DoraEnvObserveDiaryDetailViewModel.access$get_isLoading$p(this.this$0).postValue(Boxing.boxBoolean(false));
            throw th;
        L35:
            e = move-exception;
            FLogger.f375446a.e(DoraEnvObserveDiaryDetailViewModel.access$getTAG$p(this.this$0), "Error loading diary detail", e);     // Catch: Throwable -> L33
            goto L37
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.env.diary.detail.DoraEnvObserveDiaryDetailViewModel$loadFeedbackConfigIfNeeded$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.avlink.env.diary.detail.DoraEnvObserveDiaryDetailViewModel$loadFeedbackConfigIfNeeded$1", f = "DoraEnvObserveDiaryDetailViewModel.kt", i = {}, l = {127}, m = "invokeSuspend", n = {}, s = {})
    public static final class C108151 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraEnvObserveDiaryDetailViewModel this$0;

        public C108151(DoraEnvObserveDiaryDetailViewModel r100, Continuation<? super C108151> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C108151(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C108151) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            Map<String, List<String>> r103 = null;
            if (r102 == 0) goto L9;
            if (r102 != 1) goto L8;
            ResultKt.throwOnFailure(r100);     // Catch: Exception -> L24
        L13:
            dm9.a r104 = (dm9.a) r100;     // Catch: Exception -> L24
            if ((r104 instanceof dm9.a.b) == false) goto L20;
            DoraEnvObserveDiaryDetailViewModel r105 = this.this$0;     // Catch: Exception -> L24
            j98.a r106 = (j98.a) ((dm9.a.b) r104).f469231a.getData();     // Catch: Exception -> L24
            if (r106 == null) goto L18;
            r103 = r106.a();     // Catch: Exception -> L24
        L18:
            DoraEnvObserveDiaryDetailViewModel.access$setFeedbackConfigMap$p(r105, r103);     // Catch: Exception -> L24
            DoraEnvObserveDiaryDetailViewModel.access$refreshSheetReasonOptions(this.this$0);     // Catch: Exception -> L24
        L27:
            return Unit.INSTANCE;
        L20:
            if ((r104 instanceof dm9.a.C5690a) == false) goto L23;
            FLogger.f375446a.e(DoraEnvObserveDiaryDetailViewModel.access$getTAG$p(this.this$0), "loadFeedbackConfigIfNeeded error: " + ((dm9.a.C5690a) r104).f469229b);     // Catch: Exception -> L24
            DoraEnvObserveDiaryDetailViewModel.access$refreshSheetReasonOptions(this.this$0);     // Catch: Exception -> L24
            goto L27
        L23:
            throw new NoWhenBranchMatchedException();     // Catch: Exception -> L24
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r100);
            DoraEnvObserveDiaryFeedbackApi.a r107 = DoraEnvObserveDiaryFeedbackApi.f292058a;     // Catch: Exception -> L24
            DoraEnvObserveDiaryDetailViewModel$loadFeedbackConfigIfNeeded$1$result$1 r108 = new DoraEnvObserveDiaryDetailViewModel$loadFeedbackConfigIfNeeded$1$result$1(null);     // Catch: Exception -> L24
            this.label = 1;     // Catch: Exception -> L24
            r107.getClass();     // Catch: Exception -> L24
            r100 = DoraEnvObserveDiaryFeedbackApi.a.a(r108, this);     // Catch: Exception -> L24
            if (r100 != r101) goto L13;
            return r101;
        L24:
            e = move-exception;
            FLogger.f375446a.e(DoraEnvObserveDiaryDetailViewModel.access$getTAG$p(this.this$0), "loadFeedbackConfigIfNeeded error", e);
            DoraEnvObserveDiaryDetailViewModel.access$refreshSheetReasonOptions(this.this$0);
            goto L27
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.env.diary.detail.DoraEnvObserveDiaryDetailViewModel$submitFeedback$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.avlink.env.diary.detail.DoraEnvObserveDiaryDetailViewModel$submitFeedback$1", f = "DoraEnvObserveDiaryDetailViewModel.kt", i = {}, l = {218}, m = "invokeSuspend", n = {}, s = {})
    public static final class C108161 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $content;
        final /* synthetic */ String $diaryId;
        final /* synthetic */ j98.f $state;
        int label;
        final /* synthetic */ DoraEnvObserveDiaryDetailViewModel this$0;

        public C108161(DoraEnvObserveDiaryDetailViewModel r100, String r101, j98.f r102, String r103, Continuation<? super C108161> r104) {
            this.this$0 = r100;
            this.$diaryId = r101;
            this.$state = r102;
            this.$content = r103;
            super(2, r104);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C108161(this.this$0, this.$diaryId, this.$state, this.$content, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C108161) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L9;
            if (r101 != 1) goto L8;
            ResultKt.throwOnFailure(r110);     // Catch: Throwable -> L21 Exception -> L23
        L13:
            dm9.a r111 = (dm9.a) r110;     // Catch: Throwable -> L21 Exception -> L23
            if ((r111 instanceof dm9.a.b) == false) goto L17;
            DoraEnvObserveDiaryDetailViewModel.access$clearDraft(this.this$0, this.$diaryId, this.$state.f497809b);     // Catch: Throwable -> L21 Exception -> L23
            DoraEnvObserveDiaryDetailViewModel.access$updateDiaryFeedbackActionType(this.this$0, this.$state.f497809b);     // Catch: Throwable -> L21 Exception -> L23
            DoraEnvObserveDiaryDetailViewModel.access$get_feedbackSheetState$p(this.this$0).setValue(null);     // Catch: Throwable -> L21 Exception -> L23
            DoraEnvObserveDiaryDetailViewModel.access$get_toastEffect$p(this.this$0).setValue(new j98.g(R.string.larus_dora_personal_diary_feedback_success_toast_cn, DiaryFeedbackToastType.SUCCESS));     // Catch: Throwable -> L21 Exception -> L23
        L25:
            DoraEnvObserveDiaryDetailViewModel.access$setFeedbackRequestInFlight$p(this.this$0, false);
            return Unit.INSTANCE;
        L17:
            if ((r111 instanceof dm9.a.C5690a) == false) goto L20;
            FLogger.f375446a.e(DoraEnvObserveDiaryDetailViewModel.access$getTAG$p(this.this$0), "submitFeedback error: " + ((dm9.a.C5690a) r111).f469229b);     // Catch: Throwable -> L21 Exception -> L23
            DoraEnvObserveDiaryDetailViewModel.access$get_feedbackSheetState$p(this.this$0).setValue(j98.f.a(this.$state, null, null, null, false, 31));     // Catch: Throwable -> L21 Exception -> L23
            DoraEnvObserveDiaryDetailViewModel.access$syncDiaryFeedbackActionType(this.this$0);     // Catch: Throwable -> L21 Exception -> L23
            DoraEnvObserveDiaryDetailViewModel.access$get_toastEffect$p(this.this$0).setValue(new j98.g(R.string.larus_dora_personal_diary_feedback_fail_toast_cn, DiaryFeedbackToastType.FAILURE));     // Catch: Throwable -> L21 Exception -> L23
            goto L25
        L20:
            throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L21 Exception -> L23
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r110);
            DoraEnvObserveDiaryFeedbackApi.a r112 = DoraEnvObserveDiaryFeedbackApi.f292058a;     // Catch: Throwable -> L21 Exception -> L23
            DoraEnvObserveDiaryDetailViewModel$submitFeedback$1$result$1 r102 = new DoraEnvObserveDiaryDetailViewModel$submitFeedback$1$result$1(this.$diaryId, this.$state, this.$content, null);     // Catch: Throwable -> L21 Exception -> L23
            this.label = 1;     // Catch: Throwable -> L21 Exception -> L23
            r112.getClass();     // Catch: Throwable -> L21 Exception -> L23
            r110 = DoraEnvObserveDiaryFeedbackApi.a.a(r102, this);     // Catch: Throwable -> L21 Exception -> L23
            if (r110 != r100) goto L13;
            return r100;
        L21:
            th = move-exception;
            DoraEnvObserveDiaryDetailViewModel.access$setFeedbackRequestInFlight$p(this.this$0, false);
            throw th;
        L23:
            e = move-exception;
            FLogger.f375446a.e(DoraEnvObserveDiaryDetailViewModel.access$getTAG$p(this.this$0), "submitFeedback error", e);     // Catch: Throwable -> L21
            DoraEnvObserveDiaryDetailViewModel.access$get_feedbackSheetState$p(this.this$0).setValue(j98.f.a(this.$state, null, null, null, false, 31));     // Catch: Throwable -> L21
            DoraEnvObserveDiaryDetailViewModel.access$syncDiaryFeedbackActionType(this.this$0);     // Catch: Throwable -> L21
            DoraEnvObserveDiaryDetailViewModel.access$get_toastEffect$p(this.this$0).setValue(new j98.g(R.string.larus_dora_personal_diary_feedback_fail_toast_cn, DiaryFeedbackToastType.FAILURE));     // Catch: Throwable -> L21
            goto L25
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    public static /* synthetic */ IDoraPageConfig yo() {
        return doraPageConfig_delegate$lambda$0();
    }

    public final boolean inEnvObserveScene() {
        return b98.b.b(2);
    }

    private static final IDoraPageConfig doraPageConfig_delegate$lambda$0() {
        return (IDoraPageConfig) ServiceManager.get().getService(IDoraPageConfig.class);
    }

    private final IDoraPageConfig getDoraPageConfig() {
        return (IDoraPageConfig) this.doraPageConfig$delegate.getValue();
    }

    private final String getUserId() {
        String r100 = ILoginService.f286097a.getAccountInfo().f531531d;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    private final void refreshFeedbackActionTypeDisplay() {
        i98.a r100 = this.diaryDetailLiveData.getValue();
        if (r100 != null) goto L5;
        return;
    L5:
        this.diaryDetailLiveData.setValue(i98.a.a(r100, null, UnixStat.PERM_MASK));
    }

    private final void refreshSheetReasonOptions() {
        j98.f r100 = this._feedbackSheetState.getValue();
        if (r100 != null) goto L5;
        return;
    L5:
        List<String> r101 = j98.d.b(this.feedbackConfigMap, r100.f497809b);
        List<String> r102 = r100.f497811d;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L7:
        if (r104.hasNext() == false) goto L11;
        Object r105 = r104.next();
        if (r101.contains((String) r105) == false) goto L7;
        r103.add(r105);
        goto L7
    L11:
        this._feedbackSheetState.setValue(j98.f.a(r100, r101, r103, null, false, 51));
    }

    private final void syncDiaryFeedbackActionType() {
        i98.a r100 = this.diaryDetailLiveData.getValue();
        if (r100 != null) goto L5;
        return;
    L5:
        this.pendingFeedbackActionType = null;
        MutableLiveData<i98.a> r101 = this.diaryDetailLiveData;
        Integer r102 = r100.b();
        if (r102 == null) goto L8;
        int r103 = r102.intValue();
    L9:
        r101.setValue(i98.a.a(r100, Integer.valueOf(r103), 2047));
        return;
    L8:
        r103 = 0;
        goto L9
    }

    private final void trimDraftDiaryCacheIfNeeded() {
    L3:
        if (this.feedbackDraftDiaryIds.size() <= 10) goto L8;
        String r100 = (String) CollectionsKt.firstOrNull(this.feedbackDraftDiaryIds);
        if (r100 == null) goto L6;
        this.feedbackDraftDiaryIds.remove(r100);
        this.feedbackDraftCache.remove(j98.d.a(getUserId(), r100, 1));
        this.feedbackDraftCache.remove(j98.d.a(getUserId(), r100, 2));
        goto L3
    L6:
        return;
    }

    public final void cancelFeedback() {
        String r100 = this.currentDiaryId;
        if (r100 != null) goto L5;
        return;
    L5:
        i98.a r101 = this.diaryDetailLiveData.getValue();
        if (r101 == null) goto L10;
        Integer r102 = r101.b();
        if (r102 == null) goto L10;
        int r103 = r102.intValue();
    L11:
        if (r103 != 0) goto L13;
        return;
    L13:
        if (this.isFeedbackRequestInFlight == true) goto L18;
        this.isFeedbackRequestInFlight = true;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r100, null), 3, null);
        return;
    L18:
        return;
    L10:
        r103 = 0;
        goto L11
    }

    public final void loadFeedbackConfigIfNeeded() {
        if (this.feedbackConfigMap == null) goto L5;
        return;
    L5:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C108151(this, null), 3, null);
    }

    public final void saveDraft() {
        String r100 = this.currentDiaryId;
        if (r100 != null) goto L5;
        return;
    L5:
        j98.f r101 = this._feedbackSheetState.getValue();
        if (r101 != null) goto L8;
        return;
    L8:
        int r102 = r101.f497809b;
        if (r102 != 1) goto L11;
    L13:
        String r103 = j98.d.a(getUserId(), r100, r101.f497809b);
        if (r101.f497811d.isEmpty() == true) goto L16;
    L18:
        this.feedbackDraftCache.put(r103, new j98.b(r101.f497811d, r101.f497812e));
    L19:
        syncDraftDiaryState(r100);
        return;
    L16:
        if (StringsKt.isBlank(r101.f497812e) == false) goto L18;
        this.feedbackDraftCache.remove(r103);
        goto L19
    L11:
        if (r102 == 2) goto L13;
    }

    public final void submitFeedback() {
        String r100 = this.currentDiaryId;
        if (r100 != null) goto L5;
        return;
    L5:
        j98.f r101 = this._feedbackSheetState.getValue();
        if (r101 != null) goto L9;
        return;
    L9:
        if (r101.b() == true) goto L12;
        return;
    L12:
        if (this.isFeedbackRequestInFlight == false) goto L14;
        return;
    L14:
        String r102 = r101.f497812e;
        List<String> r103 = j98.d.f497806a;
        Intrinsics.checkNotNullParameter(r102, "text");
        String r110 = StringsKt.take(StringsKt.trim(r102).toString(), 1000);
        this._feedbackSheetState.setValue(j98.f.a(r101, null, null, null, true, 31));
        this.isFeedbackRequestInFlight = true;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C108161(this, r100, r101, r110, null), 3, null);
    }

    public DoraEnvObserveDiaryDetailViewModel() {
        this.TAG = "DoraEnvObserveDiary";
        this.diaryDetailLiveData = new MutableLiveData();
        MutableLiveData<Boolean> r100 = new MutableLiveData();
        this._isLoading = r100;
        this.isLoading = r100;
        MutableLiveData<j98.f> r101 = new MutableLiveData(null);
        this._feedbackSheetState = r101;
        this.feedbackSheetState = r101;
        MutableLiveData<j98.g> r102 = new MutableLiveData();
        this._toastEffect = r102;
        this.toastEffect = r102;
        this.feedbackDraftCache = new LinkedHashMap();
        this.feedbackDraftDiaryIds = new LinkedHashSet();
        this.doraPageConfig$delegate = LazyKt.lazy(new l0());
    }

    public final boolean isEnvObserveEnable() {
        IDoraPageConfig r100 = getDoraPageConfig();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.d("dora_g_config_key_env_observe_enable", false) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final MutableLiveData<i98.a> getDiaryDetailLiveData() {
        return this.diaryDetailLiveData;
    }

    public final LiveData<j98.f> getFeedbackSheetState() {
        return this.feedbackSheetState;
    }

    public final LiveData<j98.g> getToastEffect() {
        return this.toastEffect;
    }

    public final LiveData<Boolean> isLoading$dora_avlink_impl_release() {
        return this.isLoading;
    }

    public static final /* synthetic */ String access$getTAG$p(DoraEnvObserveDiaryDetailViewModel r100) {
        return r100.TAG;
    }

    public static final /* synthetic */ String access$getUserId(DoraEnvObserveDiaryDetailViewModel r100) {
        return r100.getUserId();
    }

    public static final /* synthetic */ MutableLiveData access$get_feedbackSheetState$p(DoraEnvObserveDiaryDetailViewModel r100) {
        return r100._feedbackSheetState;
    }

    public static final /* synthetic */ MutableLiveData access$get_isLoading$p(DoraEnvObserveDiaryDetailViewModel r100) {
        return r100._isLoading;
    }

    public static final /* synthetic */ MutableLiveData access$get_toastEffect$p(DoraEnvObserveDiaryDetailViewModel r100) {
        return r100._toastEffect;
    }

    public static final /* synthetic */ void access$refreshSheetReasonOptions(DoraEnvObserveDiaryDetailViewModel r100) {
        r100.refreshSheetReasonOptions();
    }

    public static final /* synthetic */ void access$syncDiaryFeedbackActionType(DoraEnvObserveDiaryDetailViewModel r100) {
        r100.syncDiaryFeedbackActionType();
    }

    private final void clearFeedbackStateForNewDiary(String r100) {
        this.currentDiaryId = r100;
        this.pendingFeedbackActionType = null;
        this._feedbackSheetState.postValue(null);
        this.isFeedbackRequestInFlight = false;
    }

    private final boolean hasDraftForDiary(String r100) {
        if (this.feedbackDraftCache.containsKey(j98.d.a(getUserId(), r100, 1)) == false) goto L5;
        return true;
    L5:
        if (this.feedbackDraftCache.containsKey(j98.d.a(getUserId(), r100, 2)) == true) goto L10;
        return false;
    L10:
        return true;
    }

    private final void syncDraftDiaryState(String r100) {
        if (hasDraftForDiary(r100) == false) goto L5;
        touchDraftDiary(r100);
        return;
    L5:
        this.feedbackDraftDiaryIds.remove(r100);
    }

    private final void touchDraftDiary(String r100) {
        this.feedbackDraftDiaryIds.remove(r100);
        this.feedbackDraftDiaryIds.add(r100);
        trimDraftDiaryCacheIfNeeded();
    }

    private final void updateDiaryFeedbackActionType(int r100) {
        i98.a r101 = this.diaryDetailLiveData.getValue();
        if (r101 != null) goto L5;
        return;
    L5:
        this.pendingFeedbackActionType = null;
        this.diaryDetailLiveData.setValue(i98.a.a(r101, Integer.valueOf(r100), 2047));
    }

    public final void fetchDiaryDetail(String r100) {
        Intrinsics.checkNotNullParameter(r100, "diaryId");
        if (Intrinsics.areEqual(this.currentDiaryId, r100) == true) goto L5;
        clearFeedbackStateForNewDiary(r100);
    L5:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C108141(this, r100, null), 2, null);
    }

    public final int getDisplayedFeedbackActionType(int r100) {
        Integer r101 = this.pendingFeedbackActionType;
        if (r101 != null) goto L5;
        return r100;
    L5:
        return r101.intValue();
    }

    public final void onFeedbackSheetDismissed(long r100) {
        j98.f r101 = this._feedbackSheetState.getValue();
        boolean r102 = true;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L10;
        return;
    L10:
        saveDraft();
        if (r101 != null) goto L13;
    L15:
        r102 = false;
    L16:
        if (r102 == true) goto L19;
        this._feedbackSheetState.setValue(null);
        syncDiaryFeedbackActionType();
        return;
    L19:
        return;
    L13:
        if (r101.f497813f != true) goto L15;
    L5:
        if (r101.f497808a != r100) goto L7;
        r103 = true;
        goto L8
    }

    public final void previewFeedbackActionType(int r100) {
        this.pendingFeedbackActionType = Integer.valueOf(r100);
        refreshFeedbackActionTypeDisplay();
    }

    public final void updateInputText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "inputText");
        j98.f r101 = this._feedbackSheetState.getValue();
        if (r101 != null) goto L5;
        return;
    L5:
        this._feedbackSheetState.setValue(j98.f.a(r101, null, null, r100, false, 47));
    }

    public final void updateSelectedReasons(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "selectedReasons");
        j98.f r101 = this._feedbackSheetState.getValue();
        if (r101 != null) goto L5;
        return;
    L5:
        this._feedbackSheetState.setValue(j98.f.a(r101, null, CollectionsKt.distinct(r100), null, false, 55));
    }

    public static final /* synthetic */ void access$setFeedbackConfigMap$p(DoraEnvObserveDiaryDetailViewModel r100, Map r101) {
        r100.feedbackConfigMap = r101;
    }

    public static final /* synthetic */ void access$setFeedbackRequestInFlight$p(DoraEnvObserveDiaryDetailViewModel r100, boolean r101) {
        r100.isFeedbackRequestInFlight = r101;
    }

    public static final /* synthetic */ void access$updateDiaryFeedbackActionType(DoraEnvObserveDiaryDetailViewModel r100, int r101) {
        r100.updateDiaryFeedbackActionType(r101);
    }

    private final void clearDraft(String r100, int r101) {
        this.feedbackDraftCache.remove(j98.d.a(getUserId(), r100, r101));
        syncDraftDiaryState(r100);
    }

    public final void openFeedbackSheet(int r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "diaryId");
        if (r110 != 1) goto L5;
    L7:
        this.currentDiaryId = r111;
        j98.b r100 = this.feedbackDraftCache.get(j98.d.a(getUserId(), r111, r110));
        if (r100 != null) goto L11;
        r100 = new j98.b(0);
    L11:
        if ((!r100.f497800a.isEmpty()) == false) goto L13;
    L14:
        touchDraftDiary(r111);
    L15:
        this._feedbackSheetState.setValue(new j98.f(System.nanoTime(), r110, j98.d.b(this.feedbackConfigMap, r110), r100.f497800a, r100.f497801b, false));
        loadFeedbackConfigIfNeeded();
        return;
    L13:
        if ((true ^ StringsKt.isBlank(r100.f497801b)) == false) goto L15;
    L5:
        if (r110 == 2) goto L7;
    }

    public static final /* synthetic */ void access$clearDraft(DoraEnvObserveDiaryDetailViewModel r100, String r101, int r102) {
        r100.clearDraft(r101, r102);
    }

    public final void deleteDiary(Context r110, String r111, Function0<Unit> r112) {
        Intrinsics.checkNotNullParameter(r111, "diaryId");
        Intrinsics.checkNotNullParameter(r112, "onSuccess");
        FLogger.f375446a.i(this.TAG, "deleteDiary from detail: " + r111);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C108131(this, r111, r112, r110, null), 2, null);
    }
}
