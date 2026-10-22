package com.larus.bmhome.instruction.helper;

import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.bmhome.social.utils.RepeatOnLifecycleKt;
import com.larus.platform.api.g3;
import com.larus.platform.model.album.AlbumSettingConfig;
import com.larus.platform.service.k2;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.a1;

/* JADX INFO: loaded from: classes26.dex */
public final class AiBeautifyPickPhotoHelper implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f312143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super Uri, Unit> f312144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super List<? extends Uri>, Unit> f312145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableSharedFlow<g> f312146d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a1 f312147e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ActivityResultLauncher<String> f312148f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ActivityResultLauncher<Intent> f312149g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ActivityResultLauncher<String> f312150h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ActivityResultLauncher<Intent> f312151i;

    /* JADX INFO: renamed from: com.larus.bmhome.instruction.helper.AiBeautifyPickPhotoHelper$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.instruction.helper.AiBeautifyPickPhotoHelper$1", f = "AiBeautifyPickPhotoHelper.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AiBeautifyPickPhotoHelper this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.instruction.helper.AiBeautifyPickPhotoHelper$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.bmhome.instruction.helper.AiBeautifyPickPhotoHelper$1$1", f = "AiBeautifyPickPhotoHelper.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
        public static final class C40861 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ AiBeautifyPickPhotoHelper this$0;

            /* JADX INFO: renamed from: com.larus.bmhome.instruction.helper.AiBeautifyPickPhotoHelper$1$1$a */
            public static final class a<T> implements FlowCollector {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ AiBeautifyPickPhotoHelper f312152a;

                public a(AiBeautifyPickPhotoHelper r100) {
                    this.f312152a = r100;
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object r100, Continuation r101) {
                    g r102 = (g) r100;
                    k2 r103 = k2.f365755a;
                    if (r103.x() == false) goto L10;
                    AlbumSettingConfig.a r104 = new AlbumSettingConfig.a();
                    r104.f365518d = r102.f312164b;
                    r104.f365517c = r102.f312163a;
                    r104.f365539y = true;
                    AlbumSettingConfig r105 = r104.a();
                    if (r102.f312163a == false) goto L7;
                    ActivityResultLauncher<Intent> r106 = this.f312152a.f312151i;
                L8:
                    r103.h(this.f312152a.f312143a.getContext(), r106, r105);
                L17:
                    FLogger.f375446a.i("AiBeautifyPickPhotoHelper", "PhotoPickerService.singlePick");
                    return Unit.INSTANCE;
                L7:
                    r106 = this.f312152a.f312149g;
                    goto L8
                L10:
                    if (r102.f312163a == false) goto L14;
                    ActivityResultLauncher<String> r107 = this.f312152a.f312150h;
                    if (r107 == null) goto L17;
                    r107.launch("image/*");
                    goto L17
                L14:
                    ActivityResultLauncher<String> r108 = this.f312152a.f312148f;
                    if (r108 == null) goto L17;
                    r108.launch("image/*");
                    goto L17
                }
            }

            public C40861(AiBeautifyPickPhotoHelper r100, Continuation<? super C40861> r101) {
                this.this$0 = r100;
                super(2, r101);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                return new C40861(this.this$0, r101);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                return invoke2(r100, r101);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                return ((C40861) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
                AiBeautifyPickPhotoHelper r103 = this.this$0;
                a1 r104 = r103.f312147e;
                a r105 = new a(r103);
                this.label = 1;
                if (r104.collect(r105, this) != r101) goto L12;
                return r101;
            }
        }

        public AnonymousClass1(AiBeautifyPickPhotoHelper r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
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
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            AiBeautifyPickPhotoHelper r103 = this.this$0;
            Fragment r104 = r103.f312143a;
            Lifecycle.State r105 = Lifecycle.State.STARTED;
            C40861 r106 = new C40861(r103, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.b(r104, r105, r106, this) != r101) goto L12;
            return r101;
        }
    }

    @Override // com.larus.bmhome.instruction.helper.f
    public final void onDestroy() {
        ActivityResultLauncher<String> r100 = this.f312148f;
        if (r100 == null) goto L5;
        r100.unregister();
    L5:
        ActivityResultLauncher<Intent> r101 = this.f312149g;
        if (r101 == null) goto L8;
        r101.unregister();
    L8:
        ActivityResultLauncher<String> r102 = this.f312150h;
        if (r102 == null) goto L11;
        r102.unregister();
    L11:
        ActivityResultLauncher<Intent> r103 = this.f312151i;
        if (r103 == null) goto L15;
        r103.unregister();
        return;
    }

    public AiBeautifyPickPhotoHelper(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f312143a = r100;
        MutableSharedFlow<g> r101 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.f312146d = r101;
        this.f312147e = kotlinx.coroutines.flow.e.a(r101);
        this.f312148f = r100.registerForActivityResult(new ActivityResultContracts.GetContent(), new a(this));
        this.f312149g = r100.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new b(this));
        this.f312150h = r100.registerForActivityResult(new ActivityResultContracts.GetMultipleContents(), new c(this));
        this.f312151i = r100.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new d(this));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r100), null, null, new AnonymousClass1(this, null), 3, null);
    }

    @Override // com.larus.bmhome.instruction.helper.f
    public final void b(Function1<? super Uri, Unit> r100) {
        this.f312144b = r100;
    }

    @Override // com.larus.bmhome.instruction.helper.f
    public final void c(Function1<? super List<? extends Uri>, Unit> r100) {
        this.f312145c = r100;
    }

    @Override // com.larus.bmhome.instruction.helper.f
    public final void a(FragmentActivity r100, final boolean r101, final int r110) {
        if (r100 != null) goto L4;
        r100 = this.f312143a.getActivity();
    L4:
        FragmentActivity r102 = r100;
        if (r102 == null) goto L8;
        k2 r103 = k2.f365755a;
        g3.a.a(null, r102, false, null, false, new e(this, r101, r110), 29);
        return;
    }
}
