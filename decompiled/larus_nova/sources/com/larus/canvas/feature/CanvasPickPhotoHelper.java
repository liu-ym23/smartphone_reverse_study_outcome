package com.larus.canvas.feature;

import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
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
public final class CanvasPickPhotoHelper implements com.larus.bmhome.instruction.helper.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f323003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super Uri, Unit> f323004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super List<? extends Uri>, Unit> f323005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableSharedFlow<Unit> f323006d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a1 f323007e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ActivityResultLauncher<String> f323008f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ActivityResultLauncher<Intent> f323009g;

    /* JADX INFO: renamed from: com.larus.canvas.feature.CanvasPickPhotoHelper$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.canvas.feature.CanvasPickPhotoHelper$1", f = "CanvasPickPhotoHelper.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CanvasPickPhotoHelper this$0;

        /* JADX INFO: renamed from: com.larus.canvas.feature.CanvasPickPhotoHelper$1$a */
        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CanvasPickPhotoHelper f323010a;

            public a(CanvasPickPhotoHelper r100) {
                this.f323010a = r100;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object r100, Continuation r101) {
                Unit r102 = (Unit) r100;
                k2 r103 = k2.f365755a;
                if (r103.x() == false) goto L5;
                CanvasPickPhotoHelper r104 = this.f323010a;
                FragmentActivity r105 = r104.f323003a;
                ActivityResultLauncher<Intent> r106 = r104.f323009g;
                AlbumSettingConfig.a r107 = new AlbumSettingConfig.a();
                r107.f365539y = true;
                r103.h(r105, r106, r107.a());
            L8:
                FLogger.f375446a.i("CanvasPickPhotoHelper", "PhotoPickerService.singlePick");
                return Unit.INSTANCE;
            L5:
                ActivityResultLauncher<String> r108 = this.f323010a.f323008f;
                if (r108 == null) goto L8;
                r108.launch("image/*");
                goto L8
            }
        }

        public AnonymousClass1(CanvasPickPhotoHelper r100, Continuation<? super AnonymousClass1> r101) {
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
            if (r102 != 1) goto L6;
            ResultKt.throwOnFailure(r100);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            CanvasPickPhotoHelper r103 = this.this$0;
            a1 r104 = r103.f323007e;
            a r105 = new a(r103);
            this.label = 1;
            if (r104.collect(r105, this) != r101) goto L12;
            return r101;
        }
    }

    @Override // com.larus.bmhome.instruction.helper.f
    public final void onDestroy() {
        ActivityResultLauncher<String> r100 = this.f323008f;
        if (r100 == null) goto L5;
        r100.unregister();
    L5:
        ActivityResultLauncher<Intent> r101 = this.f323009g;
        if (r101 == null) goto L9;
        r101.unregister();
        return;
    }

    public CanvasPickPhotoHelper(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f323003a = r100;
        MutableSharedFlow<Unit> r101 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.f323006d = r101;
        this.f323007e = kotlinx.coroutines.flow.e.a(r101);
        this.f323008f = r100.registerForActivityResult(new ActivityResultContracts.GetContent(), new b(this));
        this.f323009g = r100.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new c(this));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r100), null, null, new AnonymousClass1(this, null), 3, null);
    }

    @Override // com.larus.bmhome.instruction.helper.f
    public final void b(Function1<? super Uri, Unit> r100) {
        this.f323004b = r100;
    }

    @Override // com.larus.bmhome.instruction.helper.f
    public final void c(Function1<? super List<? extends Uri>, Unit> r100) {
        this.f323005c = r100;
    }

    @Override // com.larus.bmhome.instruction.helper.f
    public final void a(FragmentActivity r100, boolean r101, int r110) {
        if (r100 != null) goto L4;
        r100 = this.f323003a;
    L4:
        FragmentActivity r102 = r100;
        k2 r103 = k2.f365755a;
        g3.a.a(null, r102, false, null, false, new d(this), 29);
    }
}
