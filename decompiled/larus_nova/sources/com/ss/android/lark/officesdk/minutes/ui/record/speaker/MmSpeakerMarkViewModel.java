package com.ss.android.lark.officesdk.minutes.ui.record.speaker;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmMarkedSpeakerType;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmRecordingNetHelper;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.d;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.MmEndWindowAvatar;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.MmRecordingSpeakerCandidateType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.e;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.g;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.pb.videochat.CreateSpeakerInfoResponse;
import com.ss.android.lark.pb.videochat.GetSpeakerInfoListResponse;
import com.ss.android.lark.pb.videochat.Image;
import com.ss.android.lark.pb.videochat.LarkSpeakerInfo;
import com.ss.android.lark.pb.videochat.SetSpeakerInfoResponse;
import com.ss.android.lark.pb.videochat.SpeakerInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 72\u00020\u0001:\u00017B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJN\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0018\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f\u0012\u0004\u0012\u00020\u00180\u001e2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00180\u001eJ0\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020 2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00180%2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00180\u001eJ\u001e\u0010&\u001a\b\u0012\u0004\u0012\u00020 0'2\u0006\u0010(\u001a\u00020\u0005H\u0082@¢\u0006\u0004\b)\u0010*J6\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001c0'2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\bH\u0082@¢\u0006\u0004\b/\u00100J\b\u00101\u001a\u00020\u0018H\u0014J\u0012\u00102\u001a\u00020\u00052\b\u00103\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u00104\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020\nH\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/speaker/MmSpeakerMarkViewModel;", "Landroidx/lifecycle/ViewModel;", "mmUccApi", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/userscope/IMinutesUCC;", "meetingId", "", "clusterId", "segId", "", "oldSpeaker", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/speaker/MmMarkedSpeaker;", "callback", "Lcom/ss/android/lark/officesdk/minutes/ui/record/speaker/IMmSpeakerMarkListener;", "<init>", "(Lcom/ss/android/lark/officesdk/minutes/service/foundation/userscope/IMinutesUCC;Ljava/lang/String;Ljava/lang/String;JLcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/speaker/MmMarkedSpeaker;Lcom/ss/android/lark/officesdk/minutes/ui/record/speaker/IMmSpeakerMarkListener;)V", "getMmUccApi$officesdk_minutes_base_ui_release", "()Lcom/ss/android/lark/officesdk/minutes/service/foundation/userscope/IMinutesUCC;", "getMeetingId$officesdk_minutes_base_ui_release", "()Ljava/lang/String;", "searchJob", "Lkotlinx/coroutines/Job;", "submitJob", "currentQuery", "searchSpeakerCandidates", "", "query", "from", "force", "", "onResult", "Lkotlin/Function1;", "", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/speaker/MmRecordingSpeakerCandidate;", LynxVideoManagerLite.EVENT_ON_ERROR, "handleSpeakerClick", "candidate", "onSuccess", "Lkotlin/Function0;", "createSpeaker", "Lkotlin/Result;", "name", "createSpeaker-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markSpeaker", MmEndWindowAvatar.TYPE_SPEAKER, "normalizedClusterId", "actualSegId", "markSpeaker-yxL6bBk", "(Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/speaker/MmMarkedSpeaker;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/speaker/MmMarkedSpeaker;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCleared", "normalizeSpeakerError", "errorMessage", "isSameSpeaker", "old", "new", "Companion", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmSpeakerMarkViewModel extends ViewModel {
    public static final a Companion = null;
    public static final String ERROR_CODE_SET_SPEAKER_INFO_FAILED = "set_speaker_info_failed";
    public static final String ERROR_CODE_SPEAKER_NAME_DUPLICATED_OR_INVALID = "speaker_name_duplicated_or_invalid";
    private static final long SEARCH_TIMEOUT_MS = 10000;
    private final com.ss.android.lark.officesdk.minutes.ui.record.speaker.a callback;
    private final String clusterId;
    private String currentQuery;
    private final String meetingId;
    private final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a mmUccApi;
    private final c oldSpeaker;
    private Job searchJob;
    private final long segId;
    private Job submitJob;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.speaker.MmSpeakerMarkViewModel$handleSpeakerClick$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.speaker.MmSpeakerMarkViewModel$handleSpeakerClick$1", f = "MmSpeakerMarkViewModel.kt", i = {1, 1}, l = {125, 140}, m = "invokeSuspend", n = {"normalizedClusterId", "newSpeaker"}, s = {"L$0", "L$1"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ e $candidate;
        final /* synthetic */ Function1<String, Unit> $onError;
        final /* synthetic */ Function0<Unit> $onSuccess;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ MmSpeakerMarkViewModel this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(e r100, MmSpeakerMarkViewModel r101, Function1<? super String, Unit> r102, Function0<Unit> r103, Continuation<? super AnonymousClass1> r104) {
            this.$candidate = r100;
            this.this$0 = r101;
            this.$onError = r102;
            this.$onSuccess = r103;
            super(2, r104);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.$candidate, this.this$0, this.$onError, this.$onSuccess, r101);
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
        public final Object invokeSuspend(Object r210) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L10;
            if (r101 == 1) goto L9;
            if (r101 != 2) goto L8;
            c r102 = (c) this.L$1;
            String r103 = (String) this.L$0;
            ResultKt.throwOnFailure(r210);
            Object r104 = ((Result) r210).m9458unboximpl();
        L41:
            Function0<Unit> r105 = this.$onSuccess;
            MmSpeakerMarkViewModel r106 = this.this$0;
            Function1<String, Unit> r107 = this.$onError;
            if (Result.m9456isSuccessimpl(r104) == true) goto L44;
        L51:
            Function1<String, Unit> r108 = this.$onError;
            MmSpeakerMarkViewModel r109 = this.this$0;
            Throwable r110 = Result.m9452exceptionOrNullimpl(r104);
            if (r110 == null) goto L57;
            int r111 = bwb.b.f21271a;
            bwb.b.d(MmUiLogScene.SPEAKER, "markSpeaker", "error=" + r110, null);
            r108.invoke(MmSpeakerMarkViewModel.access$normalizeSpeakerError(r109, r110.getMessage()));
            com.ss.android.lark.officesdk.minutes.ui.record.speaker.a r112 = MmSpeakerMarkViewModel.access$getCallback$p(r109);
            if (r112 == null) goto L57;
            r112.h(new g(r103, MmSpeakerMarkViewModel.access$getOldSpeaker$p(r109)));
        L57:
            return Unit.INSTANCE;
        L44:
            if (((Boolean) r104).booleanValue() == false) goto L48;
            int r113 = bwb.b.f21271a;
            bwb.b.g(MmUiLogScene.SPEAKER, "handleSpeakerClick", "markSpeaker success", null, 8);
            r105.invoke();
            com.ss.android.lark.officesdk.minutes.ui.record.speaker.a r114 = MmSpeakerMarkViewModel.access$getCallback$p(r106);
            if (r114 == null) goto L51;
            r114.h(new g(true, r103, MmSpeakerMarkViewModel.access$getOldSpeaker$p(r106), r102));
            goto L51
        L48:
            int r115 = bwb.b.f21271a;
            bwb.b.d(MmUiLogScene.SPEAKER, "markSpeaker", "mis_set_success is false", null);
            r107.invoke(MmSpeakerMarkViewModel.ERROR_CODE_SET_SPEAKER_INFO_FAILED);
            com.ss.android.lark.officesdk.minutes.ui.record.speaker.a r116 = MmSpeakerMarkViewModel.access$getCallback$p(r106);
            if (r116 == null) goto L51;
            r116.h(new g(r103, MmSpeakerMarkViewModel.access$getOldSpeaker$p(r106)));
            goto L51
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r210);
            Object r117 = ((Result) r210).m9458unboximpl();
        L15:
            Function1<String, Unit> r118 = this.$onError;
            MmSpeakerMarkViewModel r119 = this.this$0;
            Throwable r120 = Result.m9452exceptionOrNullimpl(r117);
            if (r120 != null) goto L18;
            e r121 = (e) r117;
        L21:
            Long r122 = Boxing.boxLong(MmSpeakerMarkViewModel.access$getSegId$p(this.this$0));
            if (r122.longValue() <= 0) goto L24;
            boolean r123 = true;
        L25:
            if (r123 == true) goto L28;
            r122 = null;
        L28:
            if (r122 == null) goto L30;
            long r124 = r122.longValue();
        L31:
            long r125 = r124;
            String r126 = MmSpeakerMarkViewModel.access$getClusterId$p(this.this$0);
            if (StringsKt.isBlank(r126) == false) goto L34;
            r126 = "-" + r125;
        L34:
            String r127 = r126;
            int r128 = c.f435068g;
            Intrinsics.checkNotNullParameter(r121, "candidate");
            c r129 = new c(r121.f435080b, r121.f435081c, r121.f435082d, r121.f435083e, r121.f435084f, r121.f435085g);
            com.ss.android.lark.officesdk.minutes.ui.record.speaker.a r130 = MmSpeakerMarkViewModel.access$getCallback$p(this.this$0);
            if (r130 == null) goto L37;
            r130.a(r127, MmSpeakerMarkViewModel.access$getOldSpeaker$p(this.this$0), r129);
        L37:
            MmSpeakerMarkViewModel r131 = this.this$0;
            c r132 = MmSpeakerMarkViewModel.access$getOldSpeaker$p(r131);
            this.L$0 = r127;
            this.L$1 = r129;
            this.label = 2;
            r104 = MmSpeakerMarkViewModel.m8653access$markSpeakeryxL6bBk(r131, r132, r129, r127, r125, this);
            if (r104 != r100) goto L40;
            return r100;
        L40:
            r102 = r129;
            r103 = r127;
            goto L41
        L30:
            r124 = System.currentTimeMillis();
            goto L31
        L24:
            r123 = false;
            goto L25
        L18:
            int r133 = bwb.b.f21271a;
            bwb.b.d(MmUiLogScene.SPEAKER, "createSpeaker", "error=" + r120, null);
            r118.invoke(MmSpeakerMarkViewModel.access$normalizeSpeakerError(r119, r120.getMessage()));
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r210);
            if (this.$candidate.getType() != MmRecordingSpeakerCandidateType.ADD_NEW) goto L20;
            int r134 = bwb.b.f21271a;
            bwb.b.g(MmUiLogScene.SPEAKER, "handleSpeakerClick", "creating new speaker: " + this.$candidate.f435081c, null, 8);
            MmSpeakerMarkViewModel r135 = this.this$0;
            String r136 = this.$candidate.f435081c;
            this.label = 1;
            r117 = MmSpeakerMarkViewModel.m8652access$createSpeakergIAlus(r135, r136, this);
            if (r117 != r100) goto L15;
            return r100;
        L20:
            r121 = this.$candidate;
            goto L21
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.speaker.MmSpeakerMarkViewModel$searchSpeakerCandidates$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.speaker.MmSpeakerMarkViewModel$searchSpeakerCandidates$1", f = "MmSpeakerMarkViewModel.kt", i = {}, l = {53, 58}, m = "invokeSuspend", n = {}, s = {})
    public static final class C120071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $force;
        final /* synthetic */ String $from;
        final /* synthetic */ Function1<String, Unit> $onError;
        final /* synthetic */ Function1<List<e>, Unit> $onResult;
        final /* synthetic */ String $query;
        int label;
        final /* synthetic */ MmSpeakerMarkViewModel this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public C120071(MmSpeakerMarkViewModel r100, String r101, boolean r102, String r103, Function1<? super String, Unit> r104, Function1<? super List<e>, Unit> r105, Continuation<? super C120071> r106) {
            this.this$0 = r100;
            this.$from = r101;
            this.$force = r102;
            this.$query = r103;
            this.$onError = r104;
            this.$onResult = r105;
            super(2, r106);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r110) {
            return new C120071(this.this$0, this.$from, this.$force, this.$query, this.$onError, this.$onResult, r110);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C120071) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r210) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            String r102 = "";
            if (r101 == 0) goto L12;
            if (r101 == 1) goto L10;
            if (r101 != 2) goto L9;
            ResultKt.throwOnFailure(r210);     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            Object r103 = r210;
        L19:
            Object r104 = ((Result) r103).m9458unboximpl();     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            if (Intrinsics.areEqual(this.$query, MmSpeakerMarkViewModel.access$getCurrentQuery$p(this.this$0)) == true) goto L23;
            int r105 = bwb.b.f21271a;     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            bwb.b.g(MmUiLogScene.SPEAKER, "searchSpeakerCandidates", "ignore stale result, query=" + this.$query + ", currentQuery=" + MmSpeakerMarkViewModel.access$getCurrentQuery$p(this.this$0), null, 8);     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            return Unit.INSTANCE;
        L23:
            String r110 = this.$query;     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            Function1<List<e>, Unit> r106 = this.$onResult;     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            if (Result.m9456isSuccessimpl(r104) == false) goto L57;
            GetSpeakerInfoListResponse r107 = (GetSpeakerInfoListResponse) r104;     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            int r108 = r107.mspeaker_info_list.size() + r107.mlark_speaker_info_list.size();     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            List<SpeakerInfo> r109 = r107.mspeaker_info_list;     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            Iterator<T> r112 = r109.iterator();     // Catch: Exception -> L64 TimeoutCancellationException -> L66
        L27:
            if (r112.hasNext() == false) goto L29;
            SpeakerInfo r113 = (SpeakerInfo) r112.next();     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            int r114 = e.f435078h;     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            r111.add(e.a.b(r113));     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            goto L27
        L29:
            List r115 = CollectionsKt.toMutableList(r111);     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            List<LarkSpeakerInfo> r116 = r107.mlark_speaker_info_list;     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            ArrayList r117 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r116, 10));     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            Iterator<T> r118 = r116.iterator();     // Catch: Exception -> L64 TimeoutCancellationException -> L66
        L31:
            if (r118.hasNext() == false) goto L33;
            LarkSpeakerInfo r119 = (LarkSpeakerInfo) r118.next();     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            int r120 = e.f435078h;     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            r117.add(e.a.a(r119));     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            goto L31
        L33:
            r115.addAll(r117);     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            List r121 = r115;     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            if ((r121 instanceof Collection) == true) goto L36;
        L38:
            Iterator r122 = r121.iterator();     // Catch: Exception -> L64 TimeoutCancellationException -> L66
        L40:
            if (r122.hasNext() == false) goto L51;
            e r123 = (e) r122.next();     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            if (r123.getType() == MmRecordingSpeakerCandidateType.NORMAL) goto L44;
        L48:
            boolean r124 = false;
        L49:
            if (r124 == false) goto L40;
            boolean r125 = true;
        L53:
            if ((true ^ StringsKt.isBlank(r110)) == false) goto L56;
            if (r125 == true) goto L56;
            int r126 = e.f435078h;     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            Intrinsics.checkNotNullParameter(r110, "name");     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            ListProtector.add(r115, 0, new e(MmRecordingSpeakerCandidateType.ADD_NEW, null, r110, null, null, null, MmMarkedSpeakerType.TEMPORARY, 58));     // Catch: Exception -> L64 TimeoutCancellationException -> L66
        L56:
            int r127 = bwb.b.f21271a;     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            bwb.b.g(MmUiLogScene.SPEAKER, "searchSpeakerCandidates", "size=" + r108 + ", result=" + r115, null, 8);     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            r106.invoke((List<e>) r115);     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            goto L57
        L44:
            if (r123.f435085g.isLarkUser() == true) goto L48;
            if (Intrinsics.areEqual(r123.f435081c, r110) == false) goto L48;
            r124 = true;
        L51:
            r125 = false;
            goto L53
        L36:
            if (r121.isEmpty() == false) goto L38;
        L57:
            Function1<String, Unit> r128 = this.$onError;     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            Throwable r129 = Result.m9452exceptionOrNullimpl(r104);     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            if (r129 == null) goto L86;
            int r130 = bwb.b.f21271a;     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            bwb.b.d(MmUiLogScene.SPEAKER, "searchSpeakerCandidates", "error=" + r129, null);     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            String r131 = r129.getMessage();     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            if (r131 != null) goto L62;
            r131 = "";
        L62:
            r128.invoke(r131);     // Catch: Exception -> L64 TimeoutCancellationException -> L66
        L86:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r210);     // Catch: Exception -> L64 TimeoutCancellationException -> L66
        L16:
            String r132 = this.this$0.getMmUccApi$officesdk_minutes_base_ui_release().getCurrentUserId();     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            String r133 = this.this$0.getMmUccApi$officesdk_minutes_base_ui_release().getTenantId();     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            int r134 = bwb.b.f21271a;     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            bwb.b.g(MmUiLogScene.SPEAKER, "searchSpeakerCandidates", "from=" + this.$from + ", force=" + this.$force + ", query=" + this.$query + ", , operatorId=" + r132 + ", tenantId=" + r133, null, 8);     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            MmSpeakerMarkViewModel$searchSpeakerCandidates$1$result$1 r135 = new MmSpeakerMarkViewModel$searchSpeakerCandidates$1$result$1(this.this$0, r132, r133, this.$query, null);     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            this.label = 2;     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            r103 = TimeoutKt.b(10000, r135, this);     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            if (r103 != r100) goto L19;
            return r100;
        L12:
            ResultKt.throwOnFailure(r210);
            this.label = 1;     // Catch: Exception -> L64 TimeoutCancellationException -> L66
            if (DelayKt.delay(180, this) != r100) goto L16;
            return r100;
        L66:
            e = move-exception;
            int r136 = bwb.b.f21271a;
            bwb.b.d(MmUiLogScene.SPEAKER, "searchSpeakerCandidates", "timeout=" + e, null);
            if (Intrinsics.areEqual(this.$query, MmSpeakerMarkViewModel.access$getCurrentQuery$p(this.this$0)) == false) goto L86;
            Function1<String, Unit> r137 = this.$onError;
            String r138 = e.getMessage();
            if (r138 == null) goto L84;
            r102 = r138;
        L84:
            r137.invoke(r102);
        L64:
            e = move-exception;
            if ((e instanceof CancellationException) == true) goto L77;
            int r139 = bwb.b.f21271a;
            bwb.b.d(MmUiLogScene.SPEAKER, "searchSpeakerCandidates", "exception=" + e, null);
            if (Intrinsics.areEqual(this.$query, MmSpeakerMarkViewModel.access$getCurrentQuery$p(this.this$0)) == false) goto L86;
            Function1<String, Unit> r140 = this.$onError;
            String r141 = e.getMessage();
            if (r141 == null) goto L76;
            r102 = r141;
        L76:
            r140.invoke(r102);
            goto L86
        L77:
            throw e;
        }
    }

    static {
        Companion = new a();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Job r100 = this.searchJob;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        Job r101 = this.submitJob;
        if (r101 == null) goto L9;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
        return;
    }

    public final String getMeetingId$officesdk_minutes_base_ui_release() {
        return this.meetingId;
    }

    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a getMmUccApi$officesdk_minutes_base_ui_release() {
        return this.mmUccApi;
    }

    public static final /* synthetic */ com.ss.android.lark.officesdk.minutes.ui.record.speaker.a access$getCallback$p(MmSpeakerMarkViewModel r100) {
        return r100.callback;
    }

    public static final /* synthetic */ String access$getClusterId$p(MmSpeakerMarkViewModel r100) {
        return r100.clusterId;
    }

    public static final /* synthetic */ String access$getCurrentQuery$p(MmSpeakerMarkViewModel r100) {
        return r100.currentQuery;
    }

    public static final /* synthetic */ c access$getOldSpeaker$p(MmSpeakerMarkViewModel r100) {
        return r100.oldSpeaker;
    }

    public static final /* synthetic */ long access$getSegId$p(MmSpeakerMarkViewModel r100) {
        return r100.segId;
    }

    private final String normalizeSpeakerError(String r100) {
        if (Intrinsics.areEqual(r100, ERROR_CODE_SPEAKER_NAME_DUPLICATED_OR_INVALID) == true) goto L7;
        return ERROR_CODE_SET_SPEAKER_INFO_FAILED;
    L7:
        return ERROR_CODE_SPEAKER_NAME_DUPLICATED_OR_INVALID;
    }

    public static final /* synthetic */ String access$normalizeSpeakerError(MmSpeakerMarkViewModel r100, String r101) {
        return r100.normalizeSpeakerError(r101);
    }

    /* JADX INFO: renamed from: createSpeaker-gIAlu-s, reason: not valid java name */
    private final Object m8654createSpeakergIAlus(String r100, Continuation<? super Result<e>> r101) {
        if ((r101 instanceof MmSpeakerMarkViewModel$createSpeaker$1) == false) goto L7;
        MmSpeakerMarkViewModel$createSpeaker$1 r102 = (MmSpeakerMarkViewModel$createSpeaker$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
        Object r107 = ((Result) r104).m9458unboximpl();
    L18:
        if (Result.m9456isSuccessimpl(r107) == false) goto L27;
        CreateSpeakerInfoResponse r108 = (CreateSpeakerInfoResponse) r107;     // Catch: Throwable -> L24
        if (Intrinsics.areEqual(r108.mis_speaker_name_duplicated, Boxing.boxBoolean(true)) == true) goto L23;
        int r109 = e.f435078h;     // Catch: Throwable -> L24
        return Result.m9449constructorimpl(e.a.b(r108.mspeaker_info));
    L23:
        throw new IllegalStateException(ERROR_CODE_SPEAKER_NAME_DUPLICATED_OR_INVALID);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r107 = ResultKt.createFailure(th);
    L27:
        return Result.m9449constructorimpl(r107);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        String r111 = this.mmUccApi.getCurrentUserId();
        MmRecordingNetHelper r112 = this.mmUccApi.G();
        String r113 = this.meetingId;
        r102.label = 1;
        r107 = r112.k(r113, r111, r100, r102);
        if (r107 != r105) goto L18;
        return r105;
    L7:
        r102 = new MmSpeakerMarkViewModel$createSpeaker$1(this, r101);
        goto L8
    }

    private final boolean isSameSpeaker(c r100, c r101) {
        if (r100.f435069a.length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
    L12:
        return false;
    L8:
        if (Intrinsics.areEqual(r100.f435069a, r101.f435069a) == false) goto L12;
        if (r100.f435074f != r101.f435074f) goto L12;
        return true;
    L5:
        r102 = false;
        goto L6
    }

    /* JADX INFO: renamed from: access$createSpeaker-gIAlu-s, reason: not valid java name */
    public static final /* synthetic */ Object m8652access$createSpeakergIAlus(MmSpeakerMarkViewModel r100, String r101, Continuation r102) {
        return r100.m8654createSpeakergIAlus(r101, r102);
    }

    public final void handleSpeakerClick(e r110, Function0<Unit> r111, Function1<? super String, Unit> r112) {
        Intrinsics.checkNotNullParameter(r110, "candidate");
        Intrinsics.checkNotNullParameter(r111, "onSuccess");
        Intrinsics.checkNotNullParameter(r112, LynxVideoManagerLite.EVENT_ON_ERROR);
        int r100 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.SPEAKER, "handleSpeakerClick", "clusterId=" + this.clusterId + ", segId=" + this.segId + ", oldSpeaker=" + this.oldSpeaker + ", candidate=" + r110, null, 8);
        Job r101 = this.searchJob;
        if (r101 == null) goto L5;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L5:
        Job r102 = this.submitJob;
        if (r102 == null) goto L8;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L8:
        this.submitJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(r110, this, r112, r111, null), 3, null);
    }

    /* JADX INFO: renamed from: markSpeaker-yxL6bBk, reason: not valid java name */
    private final Object m8655markSpeakeryxL6bBk(c r210, c r211, String r212, long r213, Continuation<? super Result<Boolean>> r214) {
        if ((r214 instanceof MmSpeakerMarkViewModel$markSpeaker$1) == false) goto L7;
        MmSpeakerMarkViewModel$markSpeaker$1 r100 = (MmSpeakerMarkViewModel$markSpeaker$1) r214;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        MmSpeakerMarkViewModel$markSpeaker$1 r110 = r100;
        Object r102 = r110.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r110.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
        Object r105 = ((Result) r102).m9458unboximpl();
    L38:
        if (Result.m9456isSuccessimpl(r105) == false) goto L44;
        return Result.m9449constructorimpl(Boxing.boxBoolean(Intrinsics.areEqual(((SetSpeakerInfoResponse) r105).mis_set_success, Boxing.boxBoolean(true))));
    L41:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = ResultKt.createFailure(th);
    L44:
        return Result.m9449constructorimpl(r105);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        Image r107 = null;
        if (isSameSpeaker(r210, r211) == false) goto L19;
        int r108 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.SPEAKER, "markSpeaker", "same speaker, skip network request", null, 8);
        Result.Companion r109 = Result.Companion;
        return Result.m9449constructorimpl(Boxing.boxBoolean(true));
    L19:
        if (StringsKt.startsWith$default(r212, "-", false, 2, null) == false) goto L22;
        int r111 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.SPEAKER, "markSpeaker", "clusterId starts with '-', treating as segId, skipping network request", null, 8);
        Result.Companion r112 = Result.Companion;
        return Result.m9449constructorimpl(Boxing.boxBoolean(true));
    L22:
        String r113 = this.mmUccApi.getCurrentUserId();
        MmRecordingNetHelper r114 = this.mmUccApi.G();
        String r115 = this.meetingId;
        d.f434054a.getClass();
        Intrinsics.checkNotNullParameter(r211, MmEndWindowAvatar.TYPE_SPEAKER);
        if (r211.f435074f.isLarkUser() == false) goto L33;
        String r116 = r211.f435069a;
        String r117 = r211.f435070b;
        String r118 = r211.f435071c;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.d r119 = r211.f435073e;
        if (r119 == null) goto L28;
        String r120 = r119.f435076a;
        if (r120 == null) goto L28;
    L29:
        String r121 = r120;
        if (r119 == null) goto L32;
        r107 = new Image(r119.f435076a, r119.f435077b);
    L32:
        d r122 = new d.b(r116, r117, r118, r121, r107);
    L34:
        r110.label = 1;
        r105 = r114.x(r115, r113, r212, r213, r122, r110);
        if (r105 != r103) goto L38;
        return r103;
    L28:
        r120 = "";
        goto L29
    L33:
        r122 = new d.c(r211.f435069a, r211.f435070b, r211.f435072d);
    L7:
        r100 = new MmSpeakerMarkViewModel$markSpeaker$1(this, r214);
        goto L8
    }

    public final void searchSpeakerCandidates(String r110, String r111, boolean r112, Function1<? super List<e>, Unit> r113, Function1<? super String, Unit> r210) {
        Intrinsics.checkNotNullParameter(r110, "query");
        Intrinsics.checkNotNullParameter(r111, "from");
        Intrinsics.checkNotNullParameter(r113, "onResult");
        Intrinsics.checkNotNullParameter(r210, LynxVideoManagerLite.EVENT_ON_ERROR);
        if (r112 == false) goto L5;
    L7:
        this.currentQuery = r110;
        Job r100 = this.searchJob;
        if (r100 == null) goto L10;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L10:
        this.searchJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C120071(this, r111, r112, r110, r210, r113, null), 3, null);
        return;
    L5:
        if (Intrinsics.areEqual(r110, this.currentQuery) == false) goto L7;
    }

    public MmSpeakerMarkViewModel(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r100, String r101, String r102, long r103, c r104, com.ss.android.lark.officesdk.minutes.ui.record.speaker.a r105) {
        Intrinsics.checkNotNullParameter(r100, "mmUccApi");
        Intrinsics.checkNotNullParameter(r101, "meetingId");
        Intrinsics.checkNotNullParameter(r102, "clusterId");
        Intrinsics.checkNotNullParameter(r104, "oldSpeaker");
        this.mmUccApi = r100;
        this.meetingId = r101;
        this.clusterId = r102;
        this.segId = r103;
        this.oldSpeaker = r104;
        this.callback = r105;
    }

    /* JADX INFO: renamed from: access$markSpeaker-yxL6bBk, reason: not valid java name */
    public static final /* synthetic */ Object m8653access$markSpeakeryxL6bBk(MmSpeakerMarkViewModel r100, c r101, c r102, String r103, long r104, Continuation r105) {
        return r100.m8655markSpeakeryxL6bBk(r101, r102, r103, r104, r105);
    }

    public static /* synthetic */ void searchSpeakerCandidates$default(MmSpeakerMarkViewModel r100, String r101, String r102, boolean r103, Function1 r110, Function1 r111, int r112, Object r113) {
        if ((r112 & 4) == 0) goto L5;
        boolean r104 = false;
    L6:
        r100.searchSpeakerCandidates(r101, r102, r104, r110, r111);
        return;
    L5:
        r104 = r103;
        goto L6
    }
}
