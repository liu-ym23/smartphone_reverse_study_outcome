package com.larus.larkfeed.impl.voice.permission;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.media.MediaResourceManager;
import com.larus.media.MediaScene;
import com.larus.media.v;
import com.larus.platform.api.g1;
import com.larus.platform.service.i2;
import com.larus.platform.service.z2;
import java.util.List;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes30.dex */
public final class VoicePermission implements com.ss.android.lark.voiceinput.impl.service.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f355595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.media.model.a f355596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larus.media.model.a f355597c;

    public static final class a {
    }

    public static final class b implements Function1<Throwable, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoicePermission f355598a;

        public b(VoicePermission r100) {
            this.f355598a = r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable r100) {
            this.f355598a.a();
            return Unit.INSTANCE;
        }
    }

    public static final class c implements Function1<Float, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zh9.a f355599a;

        public c(zh9.a r100) {
            this.f355599a = r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Float r100) {
            r100.floatValue();
            this.f355599a.b(zh9.b.f572204c);
            return Unit.INSTANCE;
        }
    }

    public static final class d implements Function1<String, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zh9.a f355600a;

        public d(zh9.a r100) {
            this.f355600a = r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(String r100) {
            String r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            zh9.a r102 = this.f355600a;
            zh9.b r103 = zh9.b.f572204c;
            Intrinsics.checkNotNullParameter(r101, "failureReason");
            r102.b(new zh9.b(false, r101));
            return Unit.INSTANCE;
        }
    }

    public static final class e implements Function1<Float, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zh9.a f355601a;

        public e(zh9.a r100) {
            this.f355601a = r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Float r100) {
            r100.floatValue();
            this.f355601a.c(zh9.b.f572204c);
            return Unit.INSTANCE;
        }
    }

    public static final class f implements Function1<String, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zh9.a f355602a;

        public f(zh9.a r100) {
            this.f355602a = r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(String r100) {
            String r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            zh9.a r102 = this.f355602a;
            zh9.b r103 = zh9.b.f572204c;
            Intrinsics.checkNotNullParameter(r101, "failureReason");
            r102.c(new zh9.b(false, r101));
            return Unit.INSTANCE;
        }
    }

    public static final class g implements Function1<zh9.b, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i<Result<Unit>> f355603a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VoicePermission f355604b;

        public g(j r100, VoicePermission r101) {
            this.f355603a = r100;
            this.f355604b = r101;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(zh9.b r100) {
            zh9.b r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "result");
            if (r101.f572205a == true) goto L5;
        L6:
            this.f355604b.a();
        L8:
            if (this.f355603a.isActive() == false) goto L21;
            i<Result<Unit>> r102 = this.f355603a;
            Result.Companion r103 = Result.Companion;
            this.f355604b.getClass();
            if (r101.f572205a == false) goto L12;
            Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);
        L19:
            r102.resumeWith(Result.m9449constructorimpl(Result.m9448boximpl(r104)));
            goto L21
        L12:
            String r105 = r101.f572206b;
            if (r105.length() != 0) goto L15;
            boolean r106 = true;
        L16:
            if (r106 == false) goto L18;
            r105 = "Failed to acquire media resource";
        L18:
            r104 = Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException(r105)));
            goto L19
        L15:
            r106 = false;
        L21:
            return Unit.INSTANCE;
        L5:
            if (this.f355603a.isActive() == true) goto L8;
            goto L6
        }
    }

    public static final class h implements g1.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i<Result<Unit>> f355605a;

        @Override // com.larus.platform.api.g1.b
        public final void onGoSettingsDialogDismiss(boolean r100) {
        }

        @Override // com.larus.platform.api.g1.b
        public final void onGoSettingsDialogShow() {
        }

        @Override // com.larus.platform.api.g1.b
        public final void onSettingPageReturn() {
        }

        public h(j r100) {
            this.f355605a = r100;
        }

        @Override // com.larus.platform.api.g1.c
        public final void onResult(boolean r100, List<String> r101, List<String> r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r101, "grantedList");
            Intrinsics.checkNotNullParameter(r102, "deniedList");
            if (this.f355605a.isActive() == true) goto L5;
            return;
        L5:
            i<Result<Unit>> r104 = this.f355605a;
            if (r100 == false) goto L8;
            Result.Companion r105 = Result.Companion;
            Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);
        L9:
            r104.resumeWith(Result.m9449constructorimpl(Result.m9448boximpl(r106)));
            return;
        L8:
            Result.Companion r107 = Result.Companion;
            r106 = Result.m9449constructorimpl(ResultKt.createFailure(new SecurityException("Record permission was denied")));
            goto L9
        }
    }

    static {
    }

    @Override // com.ss.android.lark.voiceinput.impl.service.g
    public final void a() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Lazy r101 = MediaResourceManager.f358950a;     // Catch: Throwable -> L4
        MediaResourceManager.b(this.f355597c, this.f355596b);     // Catch: Throwable -> L4
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Override // com.ss.android.lark.voiceinput.impl.service.g
    public final Object b(Continuation<? super Result<Unit>> r110) {
        if ((r110 instanceof VoicePermission$acquireMediaResource$1) == false) goto L7;
        VoicePermission$acquireMediaResource$1 r100 = (VoicePermission$acquireMediaResource$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r111);
    L33:
        return ((Result) r111).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        r100.label = 1;
        j r112 = new j(IntrinsicsKt.intercepted(r100), 1);
        r112.C();
        zh9.a r104 = new zh9.a(new g(r112, this));
        r112.i(new b(this));
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L17
        Lazy r106 = MediaResourceManager.f358950a;     // Catch: Throwable -> L17
        MediaResourceManager.k(this.f355597c, this.f355596b, new c(r104), new d(r104), new e(r104), new f(r104));     // Catch: Throwable -> L17
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L27;
        a();
        if (r112.isActive() == false) goto L27;
        String r109 = r108.getMessage();
        if (r109 != null) goto L26;
        r109 = "Failed to request media resource";
    L26:
        r112.resumeWith(Result.m9449constructorimpl(Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException(r109, r108))))));
    L27:
        r111 = r112.B();
        if (r111 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L30;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L30:
        if (r111 != r102) goto L33;
        return r102;
    L17:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new VoicePermission$acquireMediaResource$1(this, r110);
        goto L8
    }

    @Override // com.ss.android.lark.voiceinput.impl.service.g
    public final Object c(Continuation<? super Result<Unit>> r110) {
        if ((r110 instanceof VoicePermission$acquireRecordPermission$1) == false) goto L7;
        VoicePermission$acquireRecordPermission$1 r100 = (VoicePermission$acquireRecordPermission$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r111);
    L40:
        return ((Result) r111).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        gd9.i r112 = com.larus.im.b.f346407a;
        Intrinsics.checkNotNull(r112);
        if (ContextCompat.checkSelfPermission(r112.getApplication(), "android.permission.RECORD_AUDIO") != 0) goto L17;
        boolean r113 = true;
    L18:
        if (r113 == false) goto L21;
        Result.Companion r114 = Result.Companion;
        return Result.m9449constructorimpl(Unit.INSTANCE);
    L21:
        r100.label = 1;
        j r115 = new j(IntrinsicsKt.intercepted(r100), 1);
        r115.C();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L24
        i2 r105 = i2.f365748b;     // Catch: Throwable -> L24
        g1.a.a(this.f355595a, CollectionsKt.listOf("android.permission.RECORD_AUDIO"), new h(r115), null, null, 24);     // Catch: Throwable -> L24
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L26:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 != null) goto L29;
    L34:
        r111 = r115.B();
        if (r111 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L37;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L37:
        if (r111 != r102) goto L40;
        return r102;
    L29:
        if (r115.isActive() == false) goto L34;
        String r108 = r107.getMessage();
        if (r108 != null) goto L33;
        r108 = "Failed to request record permission";
    L33:
        r115.resumeWith(Result.m9449constructorimpl(Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException(r108, r107))))));
    L24:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    L17:
        r113 = false;
    L7:
        r100 = new VoicePermission$acquireRecordPermission$1(this, r110);
        goto L8
    }

    public VoicePermission(Fragment r110, v r111) {
        Intrinsics.checkNotNullParameter(r110, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r111, "mediaStateListener");
        this.f355595a = r110;
        this.f355596b = new com.larus.media.model.a(null, MediaScene.VOICE_COMPONENT, false, 0, 1, false, 0, false, false, 2, false, r111, 1133);
        if (z2.f365865a.asrUseGainTransientFocusType() == false) goto L5;
        int r100 = 2;
    L6:
        this.f355597c = new com.larus.media.model.a(null, MediaScene.VOICE_COMPONENT, false, r100, 2, false, 0, false, false, 0, false, r111, 2021);
        return;
    L5:
        r100 = 0;
        goto L6
    }
}
