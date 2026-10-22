package com.ss.android.lark.officesdk.minutes.ui.record.endwindow;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.larksuite.framework.utils.NetworkUtils;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.officesdk.api.init.IDeviceInfoProvider;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.j;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.l;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.request.http.MmUploadLocationResponse;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmRecordingNetHelper;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.MmEndWindowAvatar;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.MmEndWindowMetaInfo;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.StatusBarUtil;
import iub.x;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u00013B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0013\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\f\u0010\u0017\u001a\u00020\n*\u00020\u0016H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0004H\u0016J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\nH\u0002J\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0!2\u0006\u0010\"\u001a\u00020\nH\u0086@¢\u0006\u0004\b#\u0010$J\u000e\u0010%\u001a\u00020&2\u0006\u0010\u0015\u001a\u00020\u0016J&\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\nJ\u000e\u0010-\u001a\u0004\u0018\u00010.*\u00020\u0016H\u0002J\u0018\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\u0011H\u0002J\u0006\u00102\u001a\u00020\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR*\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00110\u0010j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/MmEndWindowViewModel;", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/mvi/vm/MviViewModel;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/MmEndWindowVMState;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/MmEndWindowVMEvent;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/MmEndWindowUIEvent;", "mmUccApi", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/userscope/IMinutesUCC;", "<init>", "(Lcom/ss/android/lark/officesdk/minutes/service/foundation/userscope/IMinutesUCC;)V", "logDetail", "", "getLogDetail", "()Ljava/lang/String;", "logDetail$delegate", "Lkotlin/Lazy;", "markedSpeakerMapCache", "Ljava/util/LinkedHashMap;", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/speaker/MmMarkedSpeaker;", "Lkotlin/collections/LinkedHashMap;", "defaultState", "buildEndWindowUrl", "entity", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmRecordingEndWindowEntity;", "getTailRecordId", "dispatchEvent", "", "event", "fetchData", "metaInfo", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmEndWindowMetaInfo;", "fetchTitle", "meetingId", "updateTitle", "Lkotlin/Result;", "newTitle", "updateTitle-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveUploadLocationIdentity", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/location/MmLocationIdentity;", "uploadLocation", "locationIdentity", "latitude", "", "longitude", "locationName", "getRecordingSource", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingSource;", "updateMarkedSpeaker", "clusterId", MmEndWindowAvatar.TYPE_SPEAKER, "getLatestEntity", "Factory", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmEndWindowViewModel extends MviViewModel<d, Object, c> {
    private final Lazy logDetail$delegate;
    private volatile LinkedHashMap<String, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c> markedSpeakerMapCache;
    private final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a mmUccApi;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\u0006\u001a\u0002H\u0007\"\b\b\u0000\u0010\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\nH\u0016¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/MmEndWindowViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "mmUccApi", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/userscope/IMinutesUCC;", "<init>", "(Lcom/ss/android/lark/officesdk/minutes/service/foundation/userscope/IMinutesUCC;)V", "create", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Factory extends ViewModelProvider.NewInstanceFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f435862a;

        public Factory(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r100) {
            Intrinsics.checkNotNullParameter(r100, "mmUccApi");
            this.f435862a = r100;
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        public final <T extends ViewModel> T create(Class<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "modelClass");
            if (r100.isAssignableFrom(MmEndWindowViewModel.class) == false) goto L7;
            return new MmEndWindowViewModel(this.f435862a);
        L7:
            return (T) super.create(r100);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.endwindow.MmEndWindowViewModel$fetchTitle$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.endwindow.MmEndWindowViewModel$fetchTitle$1", f = "MmEndWindowViewModel.kt", i = {}, l = {168}, m = "invokeSuspend", n = {}, s = {})
    public static final class C119391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $meetingId;
        int label;
        final /* synthetic */ MmEndWindowViewModel this$0;

        public C119391(MmEndWindowViewModel r100, String r101, Continuation<? super C119391> r102) {
            this.this$0 = r100;
            this.$meetingId = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C119391(this.this$0, this.$meetingId, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C119391) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
            Object r103 = ((Result) r100).m9458unboximpl();
        L11:
            MmEndWindowViewModel r104 = this.this$0;
            if (Result.m9456isSuccessimpl(r103) == false) goto L17;
            final String r105 = (String) r103;
            int r106 = bwb.b.f21271a;
            bwb.b.f(MmUiLogScene.END_WINDOW, "fetchTitle", "success, title=" + r105, MmEndWindowViewModel.access$getLogDetail(r104));
            if (StringsKt.isBlank(r105) == true) goto L17;
            final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r107 = r104.getState().f435870a;
            final MmEndWindowMetaInfo r108 = r107.f434946d;
            r104.setState(new MmEndWindowViewModel$fetchTitle$1$1$1(r107, r108, r105));
        L17:
            MmEndWindowViewModel r109 = this.this$0;
            Throwable r110 = Result.m9452exceptionOrNullimpl(r103);
            if (r110 == null) goto L21;
            int r111 = bwb.b.f21271a;
            bwb.b.d(MmUiLogScene.END_WINDOW, "fetchTitle", "fail, " + r110, MmEndWindowViewModel.access$getLogDetail(r109));
        L21:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            MmRecordingNetHelper r112 = MmEndWindowViewModel.access$getMmUccApi$p(this.this$0).G();
            String r113 = this.$meetingId;
            this.label = 1;
            r103 = r112.p(r113, this);
            if (r103 != r101) goto L11;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.endwindow.MmEndWindowViewModel$uploadLocation$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.endwindow.MmEndWindowViewModel$uploadLocation$1", f = "MmEndWindowViewModel.kt", i = {}, l = {221}, m = "invokeSuspend", n = {}, s = {})
    public static final class C119411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ double $latitude;
        final /* synthetic */ String $locationIdentity;
        final /* synthetic */ String $locationName;
        final /* synthetic */ double $longitude;
        int label;
        final /* synthetic */ MmEndWindowViewModel this$0;

        public C119411(MmEndWindowViewModel r100, String r101, double r102, double r103, String r104, Continuation<? super C119411> r105) {
            this.this$0 = r100;
            this.$locationIdentity = r101;
            this.$latitude = r102;
            this.$longitude = r103;
            this.$locationName = r104;
            super(2, r105);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r110, Continuation<?> r111) {
            return new C119411(this.this$0, this.$locationIdentity, this.$latitude, this.$longitude, this.$locationName, r111);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C119411) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            ResultKt.throwOnFailure(r110);
            Object r111 = ((Result) r110).m9458unboximpl();
        L11:
            MmEndWindowViewModel r102 = this.this$0;
            final double r103 = this.$longitude;
            final double r104 = this.$latitude;
            final String r105 = this.$locationName;
            if (Result.m9456isSuccessimpl(r111) == false) goto L14;
            MmUploadLocationResponse r106 = (MmUploadLocationResponse) r111;
            int r107 = bwb.b.f21271a;
            bwb.b.f(MmUiLogScene.END_WINDOW, "uploadLocation", "onSuccess", MmEndWindowViewModel.access$getLogDetail(r102));
            final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r108 = r102.getState().f435870a;
            r102.setState(new MmEndWindowViewModel$uploadLocation$1$1$1(r108, r103, r104, r105));
        L14:
            MmEndWindowViewModel r109 = this.this$0;
            Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
            if (r112 == null) goto L18;
            int r113 = bwb.b.f21271a;
            bwb.b.d(MmUiLogScene.END_WINDOW, "uploadLocation", "onError: " + r112, MmEndWindowViewModel.access$getLogDetail(r109));
        L18:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            MmEndWindowViewModel r114 = this.this$0;
            MmRecordingSource r115 = MmEndWindowViewModel.access$getRecordingSource(r114, r114.getState().f435870a);
            MmRecordingNetHelper r116 = MmEndWindowViewModel.access$getMmUccApi$p(this.this$0).G();
            String r117 = this.$locationIdentity;
            double r118 = this.$latitude;
            double r119 = this.$longitude;
            String r120 = this.$locationName;
            boolean r121 = this.this$0.getState().f435870a.f434944b;
            this.label = 1;
            r111 = r116.z(r117, r118, r119, r120, r115, r121, this);
            if (r111 != r100) goto L11;
            return r100;
        }
    }

    private final String getLogDetail() {
        return (String) this.logDetail$delegate.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel
    public d defaultState() {
        return new d(0);
    }

    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c getLatestEntity() {
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r100 = getState().f435870a;
        if ((!this.markedSpeakerMapCache.isEmpty()) == false) goto L6;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.b r101 = r100.f434949g;
        LinkedHashMap<String, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c> r102 = this.markedSpeakerMapCache;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "markedSpeakerMap");
        return com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c.a(r100, null, null, new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.b(r102), 959);
    L6:
        return r100;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel
    public /* bridge */ /* synthetic */ l defaultState() {
        return defaultState();
    }

    public MmEndWindowViewModel(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r100) {
        Intrinsics.checkNotNullParameter(r100, "mmUccApi");
        this.mmUccApi = r100;
        this.logDetail$delegate = LazyKt.lazy(new MmEndWindowViewModel$logDetail$2(this));
        this.markedSpeakerMapCache = new LinkedHashMap();
    }

    public static final /* synthetic */ String access$getLogDetail(MmEndWindowViewModel r100) {
        return r100.getLogDetail();
    }

    public static final /* synthetic */ com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a access$getMmUccApi$p(MmEndWindowViewModel r100) {
        return r100.mmUccApi;
    }

    private final String buildEndWindowUrl(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r100) {
        LarkAppContext.Companion.getClass();
        Application r101 = LarkAppContext.access$getInstance$cp().getContext();
        String r102 = this.mmUccApi.J().d();
        MmRecordingSource r103 = getRecordingSource(r100);
        if (r103 != null) goto L5;
        r103 = MmRecordingSource.DOUBAO_PERSONAL;
    L5:
        x r104 = r103.getEndWindowWebConfig();
        StringBuilder r105 = new StringBuilder(r102 + "/webview/preload-service-page");
        StringBuilder r106 = new StringBuilder("?aid=");
        r106.append(OfficeSDKManager.getAppId());
        r105.append(r106.toString());
        if (r100.f434951i == false) goto L8;
        r105.append("&scene=hardware");
    L9:
        r105.append("&user_id=" + this.mmUccApi.getCurrentUserId());
        StringBuilder r107 = new StringBuilder("&device_id=");
        IDeviceInfoProvider r108 = OfficeSDKManager.getDeviceInfoProvider();
        if (r108 == null) goto L12;
        String r109 = r108.getDeviceId();
    L13:
        r107.append(r109);
        r105.append(r107.toString());
        r105.append("&app_version=" + r104.f495897c);
        r105.append("&app_name=" + OfficeSDKManager.getAppName());
        r105.append("&meetingId=" + r100.f434946d.getMeetingId());
        r105.append("&recordId=" + getTailRecordId(r100));
        r105.append("&hardwareRecordUniqueId=" + r100.f434946d.getHardwareRecordId());
        r105.append("&hasNotes=" + r100.f434946d.getHasNotes());
        Integer r110 = r100.f434946d.getSaveNotes();
        if (r110 == null) goto L16;
        r105.append("&saveNotes=" + r110.intValue());
    L16:
        StringBuilder r111 = new StringBuilder("&status_bar_height=");
        int r112 = xvb.a.f565209a;
        yub.d r113 = yub.d.f569261a;
        Activity r114 = com.ss.android.lark.appcontext.applifecycle2.api.a.a();
        if (r114 == null) goto L19;
        int r115 = StatusBarUtil.getStatusBarHeight(r114);
    L20:
        r111.append(r115);
        r105.append(r111.toString());
        r105.append("&app_brand=" + r104.f495896b);
        if (r103 != MmRecordingSource.FEISHU_DOUBAO) goto L23;
        r105.append("&isDoubaoInLark=1");
    L23:
        int r116 = this.mmUccApi.y().envType();
        if (r116 != 2) goto L26;
    L29:
        String r117 = this.mmUccApi.getSettingsService().f434080k.getAiSummaryMobileExtraQuery();
        if (TextUtils.isEmpty(r117) == true) goto L32;
        r105.append("&" + r117);
    L32:
        r105.append("&webviewEntry=" + StringsKt.removePrefix(r104.f495895a, "/webview/"));
        if (NetworkUtils.e(r101) == true) goto L35;
        r105.append("&disableUpdate=1");
    L35:
        String r118 = r105.toString();
        int r119 = bwb.b.f21271a;
        bwb.b.f(MmUiLogScene.END_WINDOW, "buildEndWindowUrl", "url=" + r118, getLogDetail());
        return r118;
    L26:
        if (r116 == 3) goto L29;
        if (Intrinsics.areEqual(OfficeSDKManager.isDebug(), Boolean.TRUE) == false) goto L32;
    L19:
        r115 = StatusBarUtil.getStatusBarHeight(LarkContext.getApplication());
        goto L20
    L12:
        r109 = null;
        goto L13
    L8:
        r105.append("&scene=summaryShare");
        goto L9
    }

    private final void fetchData(MmEndWindowMetaInfo r100) {
        String r101 = r100.getMeetingId();
        if (StringsKt.isBlank(r101) == false) goto L6;
        int r102 = bwb.b.f21271a;
        bwb.b.d(MmUiLogScene.END_WINDOW, "fetchData", "meetingId is blank", getLogDetail());
        return;
    L6:
        fetchTitle(r101);
    }

    private final void fetchTitle(String r100) {
        BuildersKt.launch$default(getViewModelScope(), null, null, new C119391(this, r100, null), 3, null);
    }

    private final MmRecordingSource getRecordingSource(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r100) {
        Iterator<MmRecordingSource> r101 = MmRecordingSource.getEntries().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        MmRecordingSource r102 = r101.next();
        if (Intrinsics.areEqual(r102.getValue(), r100.f434950h.getSource()) == false) goto L4;
    L10:
        return r102;
    L8:
        r102 = null;
        goto L10
    }

    private final String getTailRecordId(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r100) {
        if (r100.f434951i == false) goto L5;
    L8:
        String r101 = r100.f434946d.getHardwareRecordId();
        if (StringsKt.isBlank(r101) == false) goto L12;
        return r100.f434946d.getMeetingId();
    L12:
        return r101;
    L5:
        if (r100.f434946d.isHardwareRecord() == true) goto L8;
        return r100.f434946d.getMeetingId();
    }

    public void dispatchEvent(final c r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = bwb.b.f21271a;
        bwb.b.f(MmUiLogScene.END_WINDOW, "dispatchEvent", String.valueOf(r100), getLogDetail());
        if ((r100 instanceof c.a) == false) goto L6;
        c.a r102 = (c.a) r100;
        this.markedSpeakerMapCache = new LinkedHashMap(r102.f435866a.f434949g.f435067a);
        setState(new AnonymousClass1(r100, this));
        fetchData(r102.f435866a.f434946d);
        return;
    L6:
        if ((r100 instanceof c.C5198c) == false) goto L9;
        setState(AnonymousClass2.INSTANCE);
        return;
    L9:
        if ((r100 instanceof c.b) == false) goto L13;
        c.b r103 = (c.b) r100;
        updateMarkedSpeaker(r103.f435867a, r103.f435868b);
        return;
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.b resolveUploadLocationIdentity(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r100) {
        Intrinsics.checkNotNullParameter(r100, "entity");
        getRecordingSource(r100);
        return com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.c.a(r100.f434944b, r100.f434943a, r100.f434946d.getToken(), r100.f434943a, "");
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel
    public /* bridge */ /* synthetic */ void dispatchEvent(j r100) {
        dispatchEvent((c) r100);
    }

    public static final /* synthetic */ String access$buildEndWindowUrl(MmEndWindowViewModel r100, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r101) {
        return r100.buildEndWindowUrl(r101);
    }

    public static final /* synthetic */ MmRecordingSource access$getRecordingSource(MmEndWindowViewModel r100, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r101) {
        return r100.getRecordingSource(r101);
    }

    private final void updateMarkedSpeaker(String r100, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c r101) {
        if (Intrinsics.areEqual(this.markedSpeakerMapCache.put(r100, r101), r101) == true) goto L6;
        final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r102 = getState().f435870a;
        final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.b r103 = r102.f434949g;
        final LinkedHashMap r104 = new LinkedHashMap(r103.f435067a);
        r104.put(r100, r101);
        setState(new C119401(r102, r103, r104));
        return;
    }

    /* JADX INFO: renamed from: updateTitle-gIAlu-s, reason: not valid java name */
    public final Object m8651updateTitlegIAlus(final String r100, Continuation<? super Result<String>> r101) {
        if ((r101 instanceof MmEndWindowViewModel$updateTitle$1) == false) goto L7;
        MmEndWindowViewModel$updateTitle$1 r102 = (MmEndWindowViewModel$updateTitle$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r100 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);
        Object r107 = ((Result) r104).m9458unboximpl();
    L22:
        if (Result.m9456isSuccessimpl(r107) == false) goto L24;
        String r108 = (String) r107;
        final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r109 = getState().f435870a;
        setState(new MmEndWindowViewModel$updateTitle$2$1(r109, r100));
    L24:
        return r107;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        String r110 = getState().f435870a.f434946d.getMeetingId();
        if (StringsKt.isBlank(r110) == false) goto L18;
        Result.Companion r111 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new Exception("meetingId is blank")));
    L18:
        MmRecordingNetHelper r112 = this.mmUccApi.G();
        r102.L$0 = r100;
        r102.label = 1;
        r107 = r112.y(r110, r100, r102);
        if (r107 != r105) goto L22;
        return r105;
    L7:
        r102 = new MmEndWindowViewModel$updateTitle$1(this, r101);
        goto L8
    }

    public final void uploadLocation(String r110, double r111, double r112, String r113) {
        Intrinsics.checkNotNullParameter(r110, "locationIdentity");
        Intrinsics.checkNotNullParameter(r113, "locationName");
        int r100 = bwb.b.f21271a;
        bwb.b.f(MmUiLogScene.END_WINDOW, "uploadLocation", "name=" + r113, getLogDetail());
        BuildersKt.launch$default(getViewModelScope(), null, null, new C119411(this, r110, r111, r112, r113, null), 3, null);
    }
}
