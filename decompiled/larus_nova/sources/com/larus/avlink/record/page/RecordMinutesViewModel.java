package com.larus.avlink.record.page;

import com.baidu.platform.comapi.map.MapController;
import com.larus.avlink.record.util.LarkRecordMinutesManager;
import com.larus.dora.api.offline.record.IDoraOfflineRecordSyncService;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.minutes.api.IMinutesService;
import com.larus.minutes.api.MinutesOfflineRecordingUploadStatus;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\b\n*\u00010\b\u0007\u0018\u0000 82\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fJ \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0082@¢\u0006\u0002\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u0011J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u000fH\u0002J\u000e\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u000fJ\u0018\u0010 \u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u000fH\u0002J\u001c\u0010$\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u000f2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u000fH\u0002J \u0010&\u001a\b\u0012\u0004\u0012\u00020\u001b0'*\b\u0012\u0004\u0012\u00020\u001b0'2\u0006\u0010(\u001a\u00020\u0017H\u0002J \u0010)\u001a\b\u0012\u0004\u0012\u00020\u001b0'*\b\u0012\u0004\u0012\u00020\u001b0'2\u0006\u0010*\u001a\u00020\u0017H\u0002J\u0010\u0010+\u001a\u00020\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010,\u001a\u00020\u0011J\u000e\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u0017J\u0006\u00102\u001a\u00020\u0011J\u0006\u00103\u001a\u00020\u0011J\u0010\u00104\u001a\u00020\u00172\b\u00105\u001a\u0004\u0018\u00010\u000fJ\u000e\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u000fR\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0004\n\u0002\u00101¨\u00069"}, d2 = {"Lcom/larus/avlink/record/page/RecordMinutesViewModel;", "Lcom/larus/ui/arch/vm/ComponentViewModel;", "Lcom/larus/avlink/record/page/RecordMinutesState;", "<init>", "()V", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/avlink/record/page/RecordMinutesModel;", "getModel", "()Lcom/larus/avlink/record/page/RecordMinutesModel;", "model$delegate", "Lkotlin/Lazy;", "uploadProgressJob", "Lkotlinx/coroutines/Job;", "finishedUploadIds", "", "", "fetchRecordMinutesHistoryList", "", "action", "Lcom/larus/avlink/record/page/Action;", "fetchRecordMinutesHistoryListDelayed", "justEndedRecordingId", "doFetch", "", "(Lcom/larus/avlink/record/page/Action;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRecordItem", MapController.ITEM_LAYER_TAG, "Lcom/larus/avlink/record/page/RecordMinutesItemData;", "observeOfflineRecordingUploadProgress", "isOfflineRecordingUploading", "recordingId", "uploadOfflineRecording", "updateOfflineRecordingUploadProgress", "progress", "", "clearOfflineRecordingUploadProgress", "handleOfflineRecordingUploadFailed", "errorMsg", "ensureCurrentRecordingItem", "", "isHardwareRecording", "ensureOfflineRecordingPlaceholder", "isOfflineRecording", "startRecord", "endRecord", "onHardwareOfflineRecordingChanged", "recording", "syncListener", "com/larus/avlink/record/page/RecordMinutesViewModel$syncListener$1", "Lcom/larus/avlink/record/page/RecordMinutesViewModel$syncListener$1;", "registerSyncListener", "unregisterSyncListener", "isExternalOpusItem", "id", "uploadExternalOpusFile", "itemId", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecordMinutesViewModel extends ComponentViewModel<RecordMinutesState> {
    public static final int $stable = 0;
    public static final a Companion = null;
    private static final long FIRST_FETCH_DELAY_MS = 1000;
    private static final int MAX_END_PULL_RETRY = 2;
    private static final long RETRY_FETCH_INTERVAL_MS = 500;
    private static final String TAG = "RecordMinutesViewModel";
    private final Set<String> finishedUploadIds;
    private final Lazy model$delegate;
    private final RecordMinutesViewModel$syncListener$1 syncListener;
    private Job uploadProgressJob;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.record.page.RecordMinutesViewModel$deleteRecordItem$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.avlink.record.page.RecordMinutesViewModel$deleteRecordItem$1", f = "RecordMinutesViewModel.kt", i = {}, l = {160}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Action $action;
        final /* synthetic */ String $id;
        final /* synthetic */ i0 $item;
        int label;
        final /* synthetic */ RecordMinutesViewModel this$0;

        public AnonymousClass1(RecordMinutesViewModel r100, i0 r101, String r102, Action r103, Continuation<? super AnonymousClass1> r104) {
            this.this$0 = r100;
            this.$item = r101;
            this.$id = r102;
            this.$action = r103;
            super(2, r104);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, this.$item, this.$id, this.$action, r101);
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
            boolean r103 = true;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L19:
            com.larus.avlink.record.page.a r104 = (com.larus.avlink.record.page.a) r100;
            if ((r104 instanceof com.larus.avlink.record.page.a.b) == false) goto L23;
            final RecordMinutesViewModel r105 = this.this$0;
            final String r106 = this.$id;
            final Action r107 = this.$action;
            RecordMinutesViewModel.access$withState(r105, new h1(r105, r106, r107));
        L26:
            return Unit.INSTANCE;
        L23:
            if ((r104 instanceof com.larus.avlink.record.page.a.C4006a) == false) goto L28;
            final long r108 = System.currentTimeMillis();
            RecordMinutesViewModel.access$setState(this.this$0, new i1(r108));
            goto L26
        L28:
            throw new NoWhenBranchMatchedException();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            RecordMinutesModel r109 = RecordMinutesViewModel.access$getModel(this.this$0);
            i0 r110 = this.$item;
            this.label = 1;
            r109.getClass();
            String r111 = r110.f294246a;
            if (r111 != null) goto L11;
        L14:
            if (r103 == false) goto L16;
            com.larus.avlink.n1.d("RecordMinutesModel", "delete failed, recording id is null or empty");
            r100 = new com.larus.avlink.record.page.a.C4006a("recording id is null or empty");
        L17:
            if (r100 != r101) goto L19;
            return r101;
        L16:
            r100 = BuildersKt.withContext(Dispatchers.getIO(), new RecordMinutesModel$deleteRecordMinutesItem$2(r109, r111, r110, null), this);
            goto L17
        L11:
            if (r111.length() == 0) goto L14;
            r103 = false;
            goto L14
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.record.page.RecordMinutesViewModel$doFetch$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.avlink.record.page.RecordMinutesViewModel", f = "RecordMinutesViewModel.kt", i = {0}, l = {76}, m = "doFetch", n = {"action"}, s = {"L$0"})
    public static final class C108371 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ RecordMinutesViewModel this$0;

        public C108371(RecordMinutesViewModel r100, Continuation<? super C108371> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return RecordMinutesViewModel.access$doFetch(this.this$0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.record.page.RecordMinutesViewModel$fetchRecordMinutesHistoryList$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.avlink.record.page.RecordMinutesViewModel$fetchRecordMinutesHistoryList$2", f = "RecordMinutesViewModel.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Action $action;
        int label;
        final /* synthetic */ RecordMinutesViewModel this$0;

        public AnonymousClass2(RecordMinutesViewModel r100, Action r101, Continuation<? super AnonymousClass2> r102) {
            this.this$0 = r100;
            this.$action = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(this.this$0, this.$action, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            RecordMinutesViewModel r103 = this.this$0;
            Action r104 = this.$action;
            this.label = 1;
            if (RecordMinutesViewModel.access$doFetch(r103, r104, null, this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.record.page.RecordMinutesViewModel$fetchRecordMinutesHistoryListDelayed$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.avlink.record.page.RecordMinutesViewModel$fetchRecordMinutesHistoryListDelayed$1", f = "RecordMinutesViewModel.kt", i = {2, 3}, l = {56, 57, 62, 63}, m = "invokeSuspend", n = {EventConstant.Value.RETRY, EventConstant.Value.RETRY}, s = {"I$0", "I$0"})
    public static final class C108381 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Action $action;
        final /* synthetic */ String $justEndedRecordingId;
        int I$0;
        int label;
        final /* synthetic */ RecordMinutesViewModel this$0;

        public C108381(RecordMinutesViewModel r100, Action r101, String r102, Continuation<? super C108381> r103) {
            this.this$0 = r100;
            this.$action = r101;
            this.$justEndedRecordingId = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C108381(this.this$0, this.$action, this.$justEndedRecordingId, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C108381) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x009a -> B:32:0x009d). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L14;
            if (r102 == 1) goto L13;
            if (r102 == 2) goto L12;
            if (r102 == 3) goto L11;
            if (r102 != 4) goto L10;
            int r103 = this.I$0;
            ResultKt.throwOnFailure(r100);
            C108381 r104 = this;
        L32:
            boolean r105 = ((Boolean) r100).booleanValue();
        L22:
            if (r105 == true) goto L24;
        L33:
            if (r105 == false) goto L38;
            if (r104.$justEndedRecordingId == null) goto L38;
            com.larus.avlink.n1.d(RecordMinutesViewModel.TAG, "end-pull give up after 2 retries, id=" + r104.$justEndedRecordingId);
        L38:
            return Unit.INSTANCE;
        L24:
            if (r104.$justEndedRecordingId == null) goto L33;
            if (r103 >= 2) goto L33;
            r103 = r103 + 1;
            com.larus.avlink.n1.d(RecordMinutesViewModel.TAG, "end-pull still pending, retry=" + r103 + ", id=" + r104.$justEndedRecordingId);
            r104.I$0 = r103;
            r104.label = 3;
            if (DelayKt.delay(500, r104) != r101) goto L29;
            return r101;
        L29:
            RecordMinutesViewModel r106 = r104.this$0;
            Action r107 = r104.$action;
            String r108 = r104.$justEndedRecordingId;
            r104.I$0 = r103;
            r104.label = 4;
            r100 = RecordMinutesViewModel.access$doFetch(r106, r107, r108, r104);
            if (r100 != r101) goto L32;
            return r101;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            r103 = this.I$0;
            ResultKt.throwOnFailure(r100);
            r104 = this;
            goto L29
        L12:
            ResultKt.throwOnFailure(r100);
        L20:
            r105 = ((Boolean) r100).booleanValue();
            r103 = 0;
            r104 = this;
            goto L22
        L13:
            ResultKt.throwOnFailure(r100);
        L17:
            RecordMinutesViewModel r109 = this.this$0;
            Action r110 = this.$action;
            String r111 = this.$justEndedRecordingId;
            this.label = 2;
            r100 = RecordMinutesViewModel.access$doFetch(r109, r110, r111, this);
            if (r100 != r101) goto L20;
            return r101;
        L14:
            ResultKt.throwOnFailure(r100);
            this.label = 1;
            if (DelayKt.delay(1000, this) != r101) goto L17;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.record.page.RecordMinutesViewModel$observeOfflineRecordingUploadProgress$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.avlink.record.page.RecordMinutesViewModel$observeOfflineRecordingUploadProgress$1", f = "RecordMinutesViewModel.kt", i = {}, l = {204}, m = "invokeSuspend", n = {}, s = {})
    public static final class C108391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ kotlinx.coroutines.flow.i1<yk9.e> $progressFlow;
        int label;
        final /* synthetic */ RecordMinutesViewModel this$0;

        /* JADX INFO: renamed from: com.larus.avlink.record.page.RecordMinutesViewModel$observeOfflineRecordingUploadProgress$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C40051<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ RecordMinutesViewModel f294195a;

            /* JADX INFO: renamed from: com.larus.avlink.record.page.RecordMinutesViewModel$observeOfflineRecordingUploadProgress$1$1$a */
            public /* synthetic */ class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f294196a = null;

                static {
                    int[] r100 = new int[MinutesOfflineRecordingUploadStatus.values().length];
                    r100[MinutesOfflineRecordingUploadStatus.PROGRESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
                L11:
                    r100[MinutesOfflineRecordingUploadStatus.SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
                L15:
                    r100[MinutesOfflineRecordingUploadStatus.FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
                L6:
                    f294196a = r100;
                }
            }

            public C40051(RecordMinutesViewModel r100) {
                this.f294195a = r100;
            }

            public final Object a(yk9.e r100, Continuation<? super Unit> r110) {
                if ((r110 instanceof RecordMinutesViewModel$observeOfflineRecordingUploadProgress$1$1$emit$1) == false) goto L7;
                RecordMinutesViewModel$observeOfflineRecordingUploadProgress$1$1$emit$1 r101 = (RecordMinutesViewModel$observeOfflineRecordingUploadProgress$1$1$emit$1) r110;
                int r102 = r101.label;
                if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
                r101.label = r102 - Integer.MIN_VALUE;
            L8:
                Object r111 = r101.result;
                Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r104 = r101.label;
                boolean r105 = true;
                if (r104 == 0) goto L14;
                if (r104 != 1) goto L13;
                String r106 = (String) r101.L$0;
                ResultKt.throwOnFailure(r111);
            L51:
                r105 = ((Boolean) r111).booleanValue();
                String r112 = r106;
            L52:
                if (r105 == false) goto L54;
                this.f294195a.fetchRecordMinutesHistoryList(Action.UPLOAD_PROGRESS);
            L57:
                return Unit.INSTANCE;
            L54:
                com.larus.avlink.n1.b(RecordMinutesViewModel.TAG, "skip refresh because dora cleanup is incomplete, id=" + r112);
                goto L57
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r111);
                if (r100 == null) goto L17;
                r112 = r100.f568283a;
                boolean r107 = false;
                if (r112 != null) goto L21;
            L24:
                boolean r108 = true;
            L25:
                if (r108 == false) goto L29;
                return Unit.INSTANCE;
            L29:
                if (RecordMinutesViewModel.access$isOfflineRecordingUploading(this.f294195a, r112) == true) goto L32;
                com.larus.avlink.n1.d(RecordMinutesViewModel.TAG, "ignore stale upload event, id=" + r112 + ", status=" + r100.f568285c);
                return Unit.INSTANCE;
            L32:
                int r109 = a.f294196a[r100.f568285c.ordinal()];
                if (r109 != 1) goto L35;
                RecordMinutesViewModel.access$updateOfflineRecordingUploadProgress(this.f294195a, r112, r100.f568284b);
                goto L57
            L35:
                if (r109 != 2) goto L37;
                RecordMinutesViewModel.access$updateOfflineRecordingUploadProgress(this.f294195a, r112, 1.0f);
                RecordMinutesViewModel.access$getModel(this.f294195a).getClass();
                if (r112 != null) goto L44;
            L46:
                if (r107 == false) goto L52;
                RecordMinutesModel r113 = RecordMinutesViewModel.access$getModel(this.f294195a);
                r101.L$0 = r112;
                r101.label = 1;
                Object r114 = r113.m(r112, r101);
                if (r114 != r103) goto L50;
                return r103;
            L50:
                r111 = r114;
                r106 = r112;
                goto L51
            L44:
                if (StringsKt.startsWith$default(r112, "external_opus_", false, 2, null) == false) goto L46;
                r107 = true;
                goto L46
            L37:
                if (r109 != 3) goto L40;
                RecordMinutesModel r115 = RecordMinutesViewModel.access$getModel(this.f294195a);
                r115.getClass();
                Intrinsics.checkNotNullParameter(r112, "itemId");
                r115.f294193f.remove(r112);
                RecordMinutesViewModel.access$handleOfflineRecordingUploadFailed(this.f294195a, r112, r100.f568286d);
                goto L57
            L40:
                throw new NoWhenBranchMatchedException();
            L21:
                if (r112.length() == 0) goto L24;
                r108 = false;
                goto L25
            L17:
                return Unit.INSTANCE;
            L7:
                r101 = new RecordMinutesViewModel$observeOfflineRecordingUploadProgress$1$1$emit$1(this, r110);
                goto L8
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
                return a((yk9.e) r100, r101);
            }
        }

        public C108391(kotlinx.coroutines.flow.i1<yk9.e> r100, RecordMinutesViewModel r101, Continuation<? super C108391> r102) {
            this.$progressFlow = r100;
            this.this$0 = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C108391(this.$progressFlow, this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C108391) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L6;
            ResultKt.throwOnFailure(r100);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            kotlinx.coroutines.flow.i1<yk9.e> r103 = this.$progressFlow;
            C40051 r104 = new C40051(this.this$0);
            this.label = 1;
            if (r103.collect(r104, this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.record.page.RecordMinutesViewModel$uploadExternalOpusFile$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.avlink.record.page.RecordMinutesViewModel$uploadExternalOpusFile$1", f = "RecordMinutesViewModel.kt", i = {}, l = {582}, m = "invokeSuspend", n = {}, s = {})
    public static final class C108401 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $itemId;
        int label;
        final /* synthetic */ RecordMinutesViewModel this$0;

        public C108401(RecordMinutesViewModel r100, String r101, Continuation<? super C108401> r102) {
            this.this$0 = r100;
            this.$itemId = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C108401(this.this$0, this.$itemId, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C108401) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L11:
            com.larus.avlink.record.page.a r103 = (com.larus.avlink.record.page.a) r100;
            if ((r103 instanceof com.larus.avlink.record.page.a.b) == false) goto L15;
            com.larus.avlink.n1.d(RecordMinutesViewModel.TAG, "upload external opus request success, id=" + this.$itemId);
        L18:
            return Unit.INSTANCE;
        L15:
            if ((r103 instanceof com.larus.avlink.record.page.a.C4006a) == false) goto L20;
            String r104 = ((com.larus.avlink.record.page.a.C4006a) r103).f294206a;
            com.larus.avlink.n1.d(RecordMinutesViewModel.TAG, "upload external opus request failed, id=" + this.$itemId + ", msg=" + r104);
            RecordMinutesViewModel.access$handleOfflineRecordingUploadFailed(this.this$0, this.$itemId, r104);
            goto L18
        L20:
            throw new NoWhenBranchMatchedException();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            RecordMinutesModel r105 = RecordMinutesViewModel.access$getModel(this.this$0);
            String r106 = this.$itemId;
            this.label = 1;
            r105.getClass();
            r100 = BuildersKt.withContext(Dispatchers.getIO(), new RecordMinutesModel$uploadExternalOpusFile$2(r105, r106, null), this);
            if (r100 != r101) goto L11;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.record.page.RecordMinutesViewModel$uploadOfflineRecording$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.avlink.record.page.RecordMinutesViewModel$uploadOfflineRecording$1", f = "RecordMinutesViewModel.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_FFMPEG_LOG_LEVEL}, m = "invokeSuspend", n = {}, s = {})
    public static final class C108411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $recordingId;
        int label;
        final /* synthetic */ RecordMinutesViewModel this$0;

        public C108411(RecordMinutesViewModel r100, String r101, Continuation<? super C108411> r102) {
            this.this$0 = r100;
            this.$recordingId = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C108411(this.this$0, this.$recordingId, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C108411) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L11:
            com.larus.avlink.record.page.a r103 = (com.larus.avlink.record.page.a) r100;
            if ((r103 instanceof com.larus.avlink.record.page.a.b) == false) goto L15;
            com.larus.avlink.n1.d(RecordMinutesViewModel.TAG, "upload offline recording request success, id=" + this.$recordingId);
        L18:
            return Unit.INSTANCE;
        L15:
            if ((r103 instanceof com.larus.avlink.record.page.a.C4006a) == false) goto L20;
            String r104 = ((com.larus.avlink.record.page.a.C4006a) r103).f294206a;
            com.larus.avlink.n1.d(RecordMinutesViewModel.TAG, "upload offline recording request failed, id=" + this.$recordingId + ", msg=" + r104);
            RecordMinutesViewModel.access$handleOfflineRecordingUploadFailed(this.this$0, this.$recordingId, r104);
            goto L18
        L20:
            throw new NoWhenBranchMatchedException();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            RecordMinutesModel r105 = RecordMinutesViewModel.access$getModel(this.this$0);
            String r106 = this.$recordingId;
            this.label = 1;
            r105.getClass();
            r100 = BuildersKt.withContext(Dispatchers.getIO(), new RecordMinutesModel$uploadOfflineRecording$2(r106, r105, null), this);
            if (r100 != r101) goto L11;
            return r101;
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    public static /* synthetic */ RecordMinutesState No(long r100, RecordMinutesState r101) {
        return handleOfflineRecordingUploadFailed$lambda$19(r100, r101);
    }

    public static /* synthetic */ RecordMinutesState Oo(List r100, RecordMinutesState r101) {
        return onHardwareOfflineRecordingChanged$lambda$30$lambda$29(r100, r101);
    }

    public static /* synthetic */ RecordMinutesState Po(Action r100, RecordMinutesState r101) {
        return fetchRecordMinutesHistoryList$lambda$1(r100, r101);
    }

    public static /* synthetic */ RecordMinutesState Qo(Action r100, long r101, BottomStatus r102, RecordMinutesState r103) {
        return doFetch$lambda$6(r100, r101, r102, r103);
    }

    public static /* synthetic */ Unit So(RecordMinutesViewModel r100, RecordMinutesState r101) {
        return onHardwareOfflineRecordingChanged$lambda$30(r100, r101);
    }

    public static /* synthetic */ RecordMinutesState To(RecordMinutesState r100) {
        return endRecord$lambda$26(r100);
    }

    public static /* synthetic */ RecordMinutesState Wo(List r100, Action r101, long r102, RecordMinutesState r103) {
        return doFetch$lambda$8$lambda$7(r100, r101, r102, r103);
    }

    public static /* synthetic */ RecordMinutesState Yo(Action r100, List r101, long r102, BottomStatus r103, RecordMinutesState r104) {
        return doFetch$lambda$5(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ RecordMinutesState Zo(RecordMinutesState r100) {
        return startRecord$lambda$22(r100);
    }

    public static /* synthetic */ RecordMinutesModel ap() {
        return model_delegate$lambda$0();
    }

    public static /* synthetic */ Unit bp(String r100, RecordMinutesViewModel r101, RecordMinutesState r102) {
        return startRecord$lambda$25(r100, r101, r102);
    }

    public static /* synthetic */ RecordMinutesState cp(List r100, RecordMinutesState r101) {
        return startRecord$lambda$25$lambda$24(r100, r101);
    }

    public static /* synthetic */ RecordMinutesState dp(Action r100, RecordMinutesState r101) {
        return doFetch$lambda$9(r100, r101);
    }

    public static /* synthetic */ Unit ep(String r100, RecordMinutesViewModel r101, boolean r102, float r103, RecordMinutesState r104) {
        return updateOfflineRecordingUploadProgress$lambda$14(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ Unit hp(RecordMinutesViewModel r100, Action r101, RecordMinutesState r102) {
        return doFetch$lambda$8(r100, r101, r102);
    }

    public static /* synthetic */ RecordMinutesState ip(List r100, RecordMinutesState r101) {
        return clearOfflineRecordingUploadProgress$lambda$18$lambda$17(r100, r101);
    }

    public static /* synthetic */ RecordMinutesState kp(boolean r100, RecordMinutesState r101) {
        return onHardwareOfflineRecordingChanged$lambda$27(r100, r101);
    }

    public static /* synthetic */ Unit lp(RecordMinutesViewModel r100, String r101, RecordMinutesState r102) {
        return clearOfflineRecordingUploadProgress$lambda$18(r100, r101, r102);
    }

    public static /* synthetic */ Unit np(RecordMinutesViewModel r100, RecordMinutesState r101) {
        return onHardwareOfflineRecordingChanged$lambda$33(r100, r101);
    }

    public static /* synthetic */ RecordMinutesState pp(List r100, RecordMinutesState r101) {
        return onHardwareOfflineRecordingChanged$lambda$33$lambda$32(r100, r101);
    }

    public static /* synthetic */ RecordMinutesState rp(List r100, RecordMinutesState r101) {
        return updateOfflineRecordingUploadProgress$lambda$14$lambda$13(r100, r101);
    }

    private final RecordMinutesModel getModel() {
        return (RecordMinutesModel) this.model$delegate.getValue();
    }

    private static final RecordMinutesModel model_delegate$lambda$0() {
        return new RecordMinutesModel();
    }

    public final void endRecord() {
        setState(new m0());
    }

    public final void observeOfflineRecordingUploadProgress() {
        Job r100 = this.uploadProgressJob;
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.isActive() != true) goto L7;
    L8:
        if (r101 == false) goto L10;
        return;
    L10:
        getModel().getClass();
        IMinutesService r102 = (IMinutesService) ServiceManager.get().getService(IMinutesService.class);
        if (r102 != null) goto L29;
        com.larus.avlink.n1.d("RecordMinutesModel", "get upload progress flow failed, minutes service is null");
        kotlinx.coroutines.flow.i1 r103 = null;
    L24:
        if (r103 != null) goto L27;
        com.larus.avlink.n1.d(TAG, "observe upload progress skipped, flow is null");
        return;
    L27:
        this.uploadProgressJob = BuildersKt.launch$default(getViewModelScope(), null, null, new C108391(r103, this, null), 3, null);
        return;
    L29:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L15
        Object r105 = Result.m9449constructorimpl(r102.U0());     // Catch: Throwable -> L15
    L17:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L21;
        com.larus.avlink.n1.d("RecordMinutesModel", "get upload progress flow failed, msg=" + r106.getMessage());
    L21:
        if (Result.m9455isFailureimpl(r105) == false) goto L23;
        r105 = null;
    L23:
        r103 = (kotlinx.coroutines.flow.i1) r105;
    L15:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r101 = false;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.avlink.record.page.RecordMinutesViewModel$syncListener$1] */
    public RecordMinutesViewModel() {
        this.model$delegate = LazyKt.lazy(new v0());
        this.finishedUploadIds = new LinkedHashSet();
        this.syncListener = new RecordMinutesViewModel$syncListener$1(this);
    }

    public final void registerSyncListener() {
        RecordMinutesModel r100 = getModel();
        RecordMinutesViewModel$syncListener$1 r101 = this.syncListener;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "listener");
        IDoraOfflineRecordSyncService r102 = (IDoraOfflineRecordSyncService) ServiceManager.get().getService(IDoraOfflineRecordSyncService.class);
        if (r102 != null) goto L13;
        com.larus.avlink.n1.d("RecordMinutesModel", "register transfer listener skipped, dora record sync service is null");
        return;
    L13:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L7
        r102.d(r101);     // Catch: Throwable -> L7
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L16;
        com.larus.avlink.n1.b("RecordMinutesModel", "register transfer listener failed: " + r105.getMessage());
        return;
    L16:
        return;
    L7:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public final void unregisterSyncListener() {
        RecordMinutesModel r100 = getModel();
        RecordMinutesViewModel$syncListener$1 r101 = this.syncListener;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "listener");
        IDoraOfflineRecordSyncService r102 = (IDoraOfflineRecordSyncService) ServiceManager.get().getService(IDoraOfflineRecordSyncService.class);
        if (r102 == null) goto L16;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L7
        r102.e(r101);     // Catch: Throwable -> L7
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L15;
        com.larus.avlink.n1.b("RecordMinutesModel", "unregister transfer listener failed: " + r105.getMessage());
        return;
    L15:
        return;
    L7:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public static final /* synthetic */ RecordMinutesModel access$getModel(RecordMinutesViewModel r100) {
        return r100.getModel();
    }

    public static final /* synthetic */ CoroutineScope access$getViewModelScope(RecordMinutesViewModel r100) {
        return r100.getViewModelScope();
    }

    private final void clearOfflineRecordingUploadProgress(final String r100) {
        withState(new o0(this, r100));
    }

    private static final RecordMinutesState endRecord$lambda$26(RecordMinutesState r110) {
        Intrinsics.checkNotNullParameter(r110, "$this$setState");
        return RecordMinutesState.copy$default(r110, null, null, null, 0, null, BottomStatus.END_RECORDING, null, 95, null);
    }

    private final boolean isOfflineRecordingUploading(String r100) {
        List<i0> r101 = getState().getHistoryList().getSecond();
        if ((r101 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L25;
        i0 r103 = (i0) r102.next();
        if (Intrinsics.areEqual(r103.f294246a, r100) == true) goto L13;
    L15:
        boolean r104 = false;
    L16:
        if (r104 == false) goto L9;
        return true;
    L13:
        if (r103.f294253h == null) goto L15;
        r104 = true;
        goto L16
    L25:
        return false;
    L5:
        if (r101.isEmpty() == false) goto L7;
        return false;
    }

    private static final RecordMinutesState startRecord$lambda$22(RecordMinutesState r110) {
        Intrinsics.checkNotNullParameter(r110, "$this$setState");
        return RecordMinutesState.copy$default(r110, null, null, null, 0, null, BottomStatus.RECORDING, null, 95, null);
    }

    public final void fetchRecordMinutesHistoryList(final Action r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        com.larus.avlink.n1.d(TAG, "fetchRecordMinutesHistoryList source is " + r100);
        if (r100 != Action.INITIAL_PULL) goto L5;
    L6:
        setState(new f1(r100));
    L7:
        BuildersKt.launch$default(getViewModelScope(), null, null, new AnonymousClass2(this, r100, null), 3, null);
        return;
    L5:
        if (r100 != Action.RETRY_PULL) goto L7;
        goto L6
    }

    public final boolean isExternalOpusItem(String r100) {
        getModel().getClass();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (StringsKt.startsWith$default(r100, "external_opus_", false, 2, null) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final void onHardwareOfflineRecordingChanged(final boolean r100) {
        StringBuilder r101 = new StringBuilder("onHardwareOfflineRecordingChanged recording=");
        r101.append(r100);
        r101.append(", isHardwareRecording=");
        getModel().getClass();
        LarkRecordMinutesManager r102 = LarkRecordMinutesManager.f294325a;
        r102.getClass();
        r101.append(LarkRecordMinutesManager.q());
        com.larus.avlink.n1.d(TAG, r101.toString());
        getModel().getClass();
        r102.getClass();
        if (LarkRecordMinutesManager.q() == false) goto L6;
        com.larus.avlink.n1.d(TAG, "offline recording change ignored, hardware online recording in progress");
        return;
    L6:
        setState(new x0(r100));
        if (r100 == false) goto L9;
        withState(new z0(this));
        return;
    L9:
        withState(new a1(this));
        fetchRecordMinutesHistoryList(Action.REFRESH_PULL);
    }

    public final void startRecord(final String r100) {
        setState(new w0());
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        com.larus.avlink.n1.d(TAG, "startRecord skip insert item, recordingId is null or empty");
        return;
    L12:
        withState(new y0(r100, this));
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final void uploadExternalOpusFile(String r100) {
        Intrinsics.checkNotNullParameter(r100, "itemId");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        com.larus.avlink.n1.d(TAG, "upload external opus skipped, itemId is empty");
        return;
    L9:
        observeOfflineRecordingUploadProgress();
        updateOfflineRecordingUploadProgress(r100, 0.0f);
        BuildersKt.launch$default(getViewModelScope(), null, null, new C108401(this, r100, null), 3, null);
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void uploadOfflineRecording(String r100) {
        Intrinsics.checkNotNullParameter(r100, "recordingId");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        com.larus.avlink.n1.d(TAG, "upload offline recording skipped, recordingId is empty");
        return;
    L9:
        observeOfflineRecordingUploadProgress();
        updateOfflineRecordingUploadProgress(r100, 0.0f);
        BuildersKt.launch$default(getViewModelScope(), null, null, new C108411(this, r100, null), 3, null);
        return;
    L5:
        r101 = false;
        goto L6
    }

    public static final /* synthetic */ boolean access$isOfflineRecordingUploading(RecordMinutesViewModel r100, String r101) {
        return r100.isOfflineRecordingUploading(r101);
    }

    public static final /* synthetic */ void access$setState(RecordMinutesViewModel r100, Function1 r101) {
        r100.setState(r101);
    }

    public static final /* synthetic */ void access$withState(RecordMinutesViewModel r100, Function1 r101) {
        r100.withState(r101);
    }

    private static final RecordMinutesState clearOfflineRecordingUploadProgress$lambda$18$lambda$17(List r110, RecordMinutesState r111) {
        Intrinsics.checkNotNullParameter(r111, "$this$setState");
        return RecordMinutesState.copy$default(r111, new Pair(Action.UPLOAD_PROGRESS, r110), null, null, 0, null, null, null, 126, null);
    }

    private static final RecordMinutesState doFetch$lambda$9(Action r110, RecordMinutesState r111) {
        Intrinsics.checkNotNullParameter(r111, "$this$setState");
        PageStatus r100 = PageStatus.ERROR;
        return RecordMinutesState.copy$default(r111, new Pair(r110, CollectionsKt.emptyList()), null, null, 0, r100, null, null, 110, null);
    }

    private final List<i0> ensureCurrentRecordingItem(List<i0> r100, boolean r101) {
        if (r101 == true) goto L4;
        return r100;
    L4:
        LarkRecordMinutesManager.f294325a.getClass();
        String r102 = LarkRecordMinutesManager.j();
        boolean r103 = false;
        if (r102 != null) goto L7;
    L10:
        boolean r104 = true;
    L11:
        if (r104 == false) goto L14;
        com.larus.avlink.n1.d(TAG, "ensure current recording item skipped, recordingId is null or empty");
        return r100;
    L14:
        List<i0> r105 = r100;
        if ((r105 instanceof Collection) == true) goto L17;
    L19:
        Iterator<T> r106 = r105.iterator();
    L21:
        if (r106.hasNext() == false) goto L25;
        if (Intrinsics.areEqual(((i0) r106.next()).f294246a, r102) == false) goto L21;
        r103 = true;
    L25:
        if (r103 == false) goto L28;
        return r100;
    L28:
        return CollectionsKt.plus(CollectionsKt.listOf(getModel().f(r102)), r105);
    L17:
        if (r105.isEmpty() == false) goto L19;
    L7:
        if (r102.length() == 0) goto L10;
        r104 = false;
        goto L11
    }

    private final List<i0> ensureOfflineRecordingPlaceholder(List<i0> r100, boolean r101) {
        if (r101 == true) goto L4;
        return r100;
    L4:
        List<i0> r102 = r100;
        boolean r103 = false;
        if ((r102 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r104 = r102.iterator();
    L11:
        if (r104.hasNext() == false) goto L15;
        if (Intrinsics.areEqual(((i0) r104.next()).f294246a, "offline_recording_placeholder") == false) goto L11;
        r103 = true;
    L15:
        if (r103 == false) goto L18;
        return r100;
    L18:
        return CollectionsKt.plus(CollectionsKt.listOf(getModel().g()), r102);
    L7:
        if (r102.isEmpty() == false) goto L9;
        goto L9
    }

    private static final RecordMinutesState fetchRecordMinutesHistoryList$lambda$1(Action r110, RecordMinutesState r111) {
        Intrinsics.checkNotNullParameter(r111, "$this$setState");
        PageStatus r100 = PageStatus.LOADING;
        return RecordMinutesState.copy$default(r111, new Pair(r110, CollectionsKt.emptyList()), null, null, 0, r100, null, null, 110, null);
    }

    private final void handleOfflineRecordingUploadFailed(String r100, String r101) {
        StringBuilder r102 = new StringBuilder("offline recording upload failed, id=");
        r102.append(r100);
        r102.append(", msg=");
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r102.append(r101);
        com.larus.avlink.n1.d(TAG, r102.toString());
        clearOfflineRecordingUploadProgress(r100);
        final long r103 = System.currentTimeMillis();
        setState(new q0(r103));
    }

    private static final RecordMinutesState handleOfflineRecordingUploadFailed$lambda$19(long r110, RecordMinutesState r111) {
        Intrinsics.checkNotNullParameter(r111, "$this$setState");
        return RecordMinutesState.copy$default(r111, null, null, new o1(r110), 0, null, null, null, 123, null);
    }

    private static final RecordMinutesState onHardwareOfflineRecordingChanged$lambda$27(boolean r110, RecordMinutesState r111) {
        Intrinsics.checkNotNullParameter(r111, "$this$setState");
        if (r110 == false) goto L5;
        BottomStatus r112 = BottomStatus.OFFLINE_RECORDING;
    L7:
        return RecordMinutesState.copy$default(r111, null, null, null, 0, null, r112, null, 95, null);
    L5:
        r112 = BottomStatus.END_RECORDING;
        goto L7
    }

    private static final Unit onHardwareOfflineRecordingChanged$lambda$30(RecordMinutesViewModel r100, RecordMinutesState r101) {
        Intrinsics.checkNotNullParameter(r101, "state");
        List<i0> r102 = r101.getHistoryList().getSecond();
        boolean r103 = false;
        if ((r102 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r104 = r102.iterator();
    L9:
        if (r104.hasNext() == false) goto L13;
        if (Intrinsics.areEqual(((i0) r104.next()).f294246a, "offline_recording_placeholder") == false) goto L9;
        r103 = true;
    L13:
        if (r103 == true) goto L15;
        final List r105 = CollectionsKt.plus(CollectionsKt.listOf(r100.getModel().g()), r102);
        r100.setState(new c1(r105));
        return Unit.INSTANCE;
    L15:
        return Unit.INSTANCE;
    L5:
        if (r102.isEmpty() == false) goto L7;
        goto L7
    }

    private static final RecordMinutesState onHardwareOfflineRecordingChanged$lambda$30$lambda$29(List r110, RecordMinutesState r111) {
        Intrinsics.checkNotNullParameter(r111, "$this$setState");
        PageStatus r100 = PageStatus.SUCCESS;
        return RecordMinutesState.copy$default(r111, new Pair(Action.START_PULL, r110), null, null, 0, r100, null, null, 110, null);
    }

    private static final Unit onHardwareOfflineRecordingChanged$lambda$33(RecordMinutesViewModel r100, RecordMinutesState r101) {
        Intrinsics.checkNotNullParameter(r101, "state");
        List<i0> r102 = r101.getHistoryList().getSecond();
        final ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        Object r105 = r104.next();
        if (Intrinsics.areEqual(((i0) r105).f294246a, "offline_recording_placeholder") == true) goto L4;
        r103.add(r105);
        goto L4
    L8:
        r100.setState(new d1(r103));
        return Unit.INSTANCE;
    }

    private static final RecordMinutesState onHardwareOfflineRecordingChanged$lambda$33$lambda$32(List r110, RecordMinutesState r111) {
        Intrinsics.checkNotNullParameter(r111, "$this$setState");
        return RecordMinutesState.copy$default(r111, new Pair(Action.END_PULL, r110), null, null, 0, null, null, null, 126, null);
    }

    private static final RecordMinutesState startRecord$lambda$25$lambda$24(List r110, RecordMinutesState r111) {
        Intrinsics.checkNotNullParameter(r111, "$this$setState");
        PageStatus r100 = PageStatus.SUCCESS;
        return RecordMinutesState.copy$default(r111, new Pair(Action.START_PULL, r110), null, null, 0, r100, null, null, 110, null);
    }

    private final void updateOfflineRecordingUploadProgress(final String r100, float r101) {
        final float r102 = RangesKt.coerceIn(r101, 0.0f, 1.0f);
        if (r102 < 1.0f) goto L5;
        final boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        this.finishedUploadIds.add(r100);
    L8:
        withState(new e1(r100, this, r103, r102));
        return;
    L5:
        r103 = false;
        goto L6
    }

    private static final RecordMinutesState updateOfflineRecordingUploadProgress$lambda$14$lambda$13(List r110, RecordMinutesState r111) {
        Intrinsics.checkNotNullParameter(r111, "$this$setState");
        return RecordMinutesState.copy$default(r111, new Pair(Action.UPLOAD_PROGRESS, r110), null, null, 0, null, null, null, 126, null);
    }

    public final void deleteRecordItem(Action r110, i0 r111) {
        Intrinsics.checkNotNullParameter(r110, "action");
        Intrinsics.checkNotNullParameter(r111, MapController.ITEM_LAYER_TAG);
        String r100 = r111.f294246a;
        if (r100 != null) goto L5;
        return;
    L5:
        BuildersKt.launch$default(getViewModelScope(), null, null, new AnonymousClass1(this, r111, r100, r110, null), 3, null);
    }

    public final void fetchRecordMinutesHistoryListDelayed(Action r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        BuildersKt.launch$default(getViewModelScope(), null, null, new C108381(this, r100, r101, null), 3, null);
    }

    public static final /* synthetic */ void access$handleOfflineRecordingUploadFailed(RecordMinutesViewModel r100, String r101, String r102) {
        r100.handleOfflineRecordingUploadFailed(r101, r102);
    }

    public static final /* synthetic */ void access$updateOfflineRecordingUploadProgress(RecordMinutesViewModel r100, String r101, float r102) {
        r100.updateOfflineRecordingUploadProgress(r101, r102);
    }

    private static final Unit clearOfflineRecordingUploadProgress$lambda$18(RecordMinutesViewModel r100, String r101, RecordMinutesState r102) {
        Intrinsics.checkNotNullParameter(r102, "state");
        List<i0> r103 = r102.getHistoryList().getSecond();
        Iterator<i0> r104 = r103.iterator();
        int r105 = 0;
    L4:
        if (r104.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(r104.next().f294246a, r101) == true) goto L10;
        r105 = r105 + 1;
    L10:
        if (r105 < 0) goto L12;
        List<i0> r106 = r103;
        final ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r108 = r106.iterator();
    L15:
        if (r108.hasNext() == false) goto L20;
        i0 r109 = (i0) r108.next();
        if (Intrinsics.areEqual(r109.f294246a, r101) == false) goto L19;
        r109 = i0.a(r109, null, null, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_AVG_COST_TIME);
    L19:
        r107.add(r109);
        goto L15
    L20:
        r100.setState(new n0(r107));
        return Unit.INSTANCE;
    L12:
        return Unit.INSTANCE;
    L9:
        r105 = -1;
        goto L10
    }

    private final Object doFetch(Action r110, String r111, Continuation<? super Boolean> r112) {
        if ((r112 instanceof C108371) == false) goto L7;
        C108371 r100 = (C108371) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        r110 = (Action) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L17:
        final Action r104 = r110;
        m r114 = (m) r113;
        com.larus.avlink.record.page.a<List<i0>> r115 = r114.f294269a;
        if ((r115 instanceof com.larus.avlink.record.page.a.b) == false) goto L69;
        getModel().getClass();
        LarkRecordMinutesManager r116 = LarkRecordMinutesManager.f294325a;
        r116.getClass();
        boolean r105 = LarkRecordMinutesManager.q();
        if (r105 == true) goto L24;
        r116.getClass();
        if (LarkRecordMinutesManager.t() == false) goto L24;
        boolean r117 = true;
    L25:
        if (r105 == false) goto L28;
        BottomStatus r106 = BottomStatus.RECORDING;
    L27:
        final BottomStatus r118 = r106;
        com.larus.avlink.n1.d(TAG, "fetchRecordMinutesHistoryList bottomStatus decided=" + r118 + ", isHardwareRecording=" + r105 + ", isOfflineRecording=" + r117);
        Iterable r119 = (Iterable) ((com.larus.avlink.record.page.a.b) r115).f294208a;
        ArrayList r107 = new ArrayList();
        Iterator r120 = r119.iterator();
    L33:
        if (r120.hasNext() == false) goto L42;
        Object r108 = r120.next();
        i0 r109 = (i0) r108;
        if (com.larus.utils.o0.d(r109.f294246a) == true) goto L37;
    L39:
        boolean r121 = false;
    L40:
        if (r121 == false) goto L33;
        r107.add(r108);
        goto L33
    L37:
        if (com.larus.utils.o0.d(r109.f294247b) == false) goto L39;
        r121 = true;
        goto L40
    L42:
        ArrayList r122 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator r123 = r107.iterator();
    L44:
        if (r123.hasNext() == false) goto L54;
        i0 r124 = (i0) r123.next();
        String r125 = r124.f294246a;
        if (r125 == null) goto L53;
        if (this.finishedUploadIds.contains(r125) == false) goto L53;
        TagType r126 = r124.f294249d;
        if (r126 != TagType.OFFLINE) goto L52;
        r126 = null;
    L52:
        r124 = i0.a(r124, r126, Boxing.boxFloat(1.0f), MediaPlayer.MEDIA_PLAYER_OPTION_RTC_PLUGIN_PACKAGE_NAME);
    L53:
        r122.add(r124);
        goto L44
    L54:
        final List<i0> r127 = ensureOfflineRecordingPlaceholder(ensureCurrentRecordingItem(r122, r105), r117);
        Set<String> r128 = this.finishedUploadIds;
        ArrayList r129 = new ArrayList();
        Iterator<T> r130 = r127.iterator();
    L56:
        if (r130.hasNext() == false) goto L60;
        String r131 = ((i0) r130.next()).f294246a;
        if (r131 == null) goto L56;
        r129.add(r131);
        goto L56
    L60:
        r128.retainAll(CollectionsKt.toSet(r129));
        if (r104 != Action.REFRESH_PULL) goto L63;
        long r132 = System.currentTimeMillis();
    L64:
        final long r133 = r132;
        if ((!r127.isEmpty()) == false) goto L67;
        setState(new r0(r104, r127, r133, r118));
    L75:
        return Boxing.boxBoolean(r114.f294270b);
    L67:
        setState(new s0(r104, r133, r118));
        goto L75
    L63:
        r132 = ((RecordMinutesState) getState()).getRefreshResultTime();
        goto L64
    L28:
        if (r117 == false) goto L30;
        r106 = BottomStatus.OFFLINE_RECORDING;
        goto L27
    L30:
        r106 = BottomStatus.END_RECORDING;
    L24:
        r117 = false;
        goto L25
    L69:
        if ((r115 instanceof com.larus.avlink.record.page.a.C4006a) == false) goto L77;
        if (r104 != Action.REFRESH_PULL) goto L73;
        withState(new t0(this, r104));
        goto L75
    L73:
        setState(new u0(r104));
        goto L75
    L77:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        RecordMinutesModel r134 = getModel();
        r100.L$0 = r110;
        r100.label = 1;
        r134.getClass();
        r113 = BuildersKt.withContext(Dispatchers.getIO(), new RecordMinutesModel$fetchRecordMinutesHistoryList$2(r134, r111, null), r100);
        if (r113 != r102) goto L17;
        return r102;
    L7:
        r100 = new C108371(this, r112);
        goto L8
    }

    private static final Unit doFetch$lambda$8(RecordMinutesViewModel r100, final Action r101, RecordMinutesState r102) {
        Intrinsics.checkNotNullParameter(r102, "state");
        final List<i0> r103 = r102.getHistoryList().getSecond();
        final long r104 = System.currentTimeMillis();
        r100.setState(new b1(r103, r101, r104));
        return Unit.INSTANCE;
    }

    private static final Unit startRecord$lambda$25(String r100, RecordMinutesViewModel r101, RecordMinutesState r102) {
        Intrinsics.checkNotNullParameter(r102, "state");
        List<i0> r103 = r102.getHistoryList().getSecond();
        boolean r104 = false;
        if ((r103 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r105 = r103.iterator();
    L9:
        if (r105.hasNext() == false) goto L13;
        if (Intrinsics.areEqual(((i0) r105.next()).f294246a, r100) == false) goto L9;
        r104 = true;
    L13:
        if (r104 == false) goto L16;
        com.larus.avlink.n1.d(TAG, "startRecord skip insert, item already exists, id=" + r100);
        return Unit.INSTANCE;
    L16:
        final List r106 = CollectionsKt.plus(CollectionsKt.listOf(r101.getModel().f(r100)), r103);
        r101.setState(new p0(r106));
        return Unit.INSTANCE;
    L5:
        if (r103.isEmpty() == false) goto L7;
        goto L7
    }

    public static final /* synthetic */ Object access$doFetch(RecordMinutesViewModel r100, Action r101, String r102, Continuation r103) {
        return r100.doFetch(r101, r102, r103);
    }

    private static final RecordMinutesState doFetch$lambda$6(Action r110, long r111, BottomStatus r112, RecordMinutesState r113) {
        Intrinsics.checkNotNullParameter(r113, "$this$setState");
        PageStatus r100 = PageStatus.ONBOARDING;
        return RecordMinutesState.copy$default(r113, new Pair(r110, CollectionsKt.emptyList()), null, null, r111, r100, r112, null, 70, null);
    }

    private static final RecordMinutesState doFetch$lambda$8$lambda$7(List r110, Action r111, long r112, RecordMinutesState r113) {
        Intrinsics.checkNotNullParameter(r113, "$this$setState");
        if (r110.isEmpty() == false) goto L5;
        PageStatus r100 = PageStatus.ERROR;
    L6:
        Pair r101 = new Pair(r111, r110);
        return RecordMinutesState.copy$default(r113, r101, null, null, r112, r100, null, null, 102, null);
    L5:
        r100 = PageStatus.SUCCESS;
        goto L6
    }

    private static final RecordMinutesState doFetch$lambda$5(Action r110, List r111, long r112, BottomStatus r113, RecordMinutesState r114) {
        Intrinsics.checkNotNullParameter(r114, "$this$setState");
        PageStatus r100 = PageStatus.SUCCESS;
        return RecordMinutesState.copy$default(r114, new Pair(r110, r111), null, null, r112, r100, r113, null, 70, null);
    }

    public static /* synthetic */ void handleOfflineRecordingUploadFailed$default(RecordMinutesViewModel r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.handleOfflineRecordingUploadFailed(r101, r102);
    }

    private static final Unit updateOfflineRecordingUploadProgress$lambda$14(String r100, RecordMinutesViewModel r101, boolean r102, float r103, RecordMinutesState r104) {
        Intrinsics.checkNotNullParameter(r104, "state");
        List<i0> r105 = r104.getHistoryList().getSecond();
        Iterator<i0> r106 = r105.iterator();
        int r107 = 0;
    L4:
        if (r106.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(r106.next().f294246a, r100) == true) goto L10;
        r107 = r107 + 1;
    L10:
        if (r107 >= 0) goto L13;
        com.larus.avlink.n1.d(TAG, "update upload progress skipped, item not found, id=" + r100);
        return Unit.INSTANCE;
    L13:
        List<i0> r108 = r105;
        final ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator<T> r110 = r108.iterator();
    L15:
        if (r110.hasNext() == false) goto L26;
        i0 r111 = (i0) r110.next();
        if (Intrinsics.areEqual(r111.f294246a, r100) == false) goto L25;
        if (r102 == false) goto L20;
        TagType r112 = null;
    L21:
        if (r102 == false) goto L23;
        float r113 = 1.0f;
    L24:
        r111 = i0.a(r111, r112, Float.valueOf(r113), MediaPlayer.MEDIA_PLAYER_OPTION_RTC_PLUGIN_PACKAGE_NAME);
        goto L25
    L23:
        r113 = r103;
        goto L24
    L20:
        r112 = r111.f294249d;
    L25:
        r109.add(r111);
        goto L15
    L26:
        r101.setState(new g1(r109));
        return Unit.INSTANCE;
    L9:
        r107 = -1;
        goto L10
    }
}
