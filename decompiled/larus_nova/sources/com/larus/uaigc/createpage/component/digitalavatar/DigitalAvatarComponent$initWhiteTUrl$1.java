package com.larus.uaigc.createpage.component.digitalavatar;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common_res.common_ui.databinding.LarusWidgetTitlebarExBinding;
import com.larus.common_ui.view.b0;
import com.larus.nova.R;
import com.larus.uaigc.impl.databinding.LarusLayoutAvatarGeneratingToastBinding;
import com.lynx.lottieadapter.LottieAdapterView;
import com.ss.ttm.player.MediaPlayer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;
import v19.c7;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarComponent$initWhiteTUrl$1", f = "DigitalAvatarComponent.kt", i = {0}, l = {689}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class DigitalAvatarComponent$initWhiteTUrl$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DigitalAvatarComponent this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarComponent$initWhiteTUrl$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarComponent$initWhiteTUrl$1$1", f = "DigitalAvatarComponent.kt", i = {}, l = {671, 686}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DigitalAvatarComponent this$0;

        public AnonymousClass1(DigitalAvatarComponent r100, Continuation<? super AnonymousClass1> r101) {
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
            if (r102 == 0) goto L10;
            if (r102 == 1) goto L9;
            if (r102 != 2) goto L8;
            ResultKt.throwOnFailure(r100);
        L35:
            b0 r103 = (b0) this.this$0.f371535v.getValue();
            if (r103 == null) goto L39;
            r103.a();
        L39:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r100);
        L13:
            NovaTitleBarEx r104 = this.this$0.A;
            if (r104 == null) goto L22;
            LarusWidgetTitlebarExBinding r105 = r104.getBinding();
            if (r105 == null) goto L22;
            r105.f326840f.setVisibility(0);
            r105.f326840f.setImageResource(R.drawable.larus_ic_avatar_generating);
            ImageView r106 = r105.f326840f;
            ViewGroup.LayoutParams r107 = r106.getLayoutParams();
            if (r107 == null) goto L21;
            ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r107;
            int r109 = c7.b(Boxing.boxInt(28));
            r108.width = r109;
            r108.height = r109;
            r108.setMarginEnd(c7.b(Boxing.boxInt(16)));
            r106.setLayoutParams(r108);
            goto L22
        L21:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        L22:
            b0 r110 = (b0) this.this$0.f371535v.getValue();
            if (r110 == null) goto L25;
            LarusLayoutAvatarGeneratingToastBinding r111 = (LarusLayoutAvatarGeneratingToastBinding) r110.b();
        L25:
            b0 r112 = (b0) this.this$0.f371535v.getValue();
            if (r112 == null) goto L32;
            LarusLayoutAvatarGeneratingToastBinding r113 = (LarusLayoutAvatarGeneratingToastBinding) r112.f328321c;
            if (r113 == null) goto L32;
            LottieAdapterView r114 = r113.f373210b;
            if (r114 == null) goto L32;
            r114.playAnimation();
        L32:
            this.label = 2;
            if (DelayKt.delay(2500, this) != r101) goto L35;
            return r101;
        L10:
            ResultKt.throwOnFailure(r100);
            this.label = 1;
            if (DelayKt.delay(200, this) != r101) goto L13;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarComponent$initWhiteTUrl$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarComponent$initWhiteTUrl$1$2", f = "DigitalAvatarComponent.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_LIVE_CONNECT_TIME}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DigitalAvatarComponent this$0;

        /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarComponent$initWhiteTUrl$1$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ DigitalAvatarComponent f371541a;

            public AnonymousClass1(DigitalAvatarComponent r100) {
                this.f371541a = r100;
            }

            public final Object a(String r110, Continuation<? super Unit> r111) {
                if ((r111 instanceof DigitalAvatarComponent$initWhiteTUrl$1$2$1$emit$1) == false) goto L7;
                DigitalAvatarComponent$initWhiteTUrl$1$2$1$emit$1 r100 = (DigitalAvatarComponent$initWhiteTUrl$1$2$1$emit$1) r111;
                int r101 = r100.label;
                if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
                r100.label = r101 - Integer.MIN_VALUE;
            L8:
                Object r112 = r100.result;
                Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r103 = r100.label;
                if (r103 == 0) goto L14;
                if (r103 != 1) goto L13;
                LarusWidgetTitlebarExBinding r113 = (LarusWidgetTitlebarExBinding) r100.L$1;
                LarusWidgetTitlebarExBinding r104 = (LarusWidgetTitlebarExBinding) r100.L$0;
                ResultKt.throwOnFailure(r112);
            L44:
                Bitmap r114 = (Bitmap) r112;
                if (r114 == null) goto L51;
                r113.f326840f.setImageBitmap(r114);
                ImageView r115 = r113.f326840f;
                ViewGroup.LayoutParams r116 = r115.getLayoutParams();
                if (r116 == null) goto L50;
                ViewGroup.MarginLayoutParams r117 = (ViewGroup.MarginLayoutParams) r116;
                int r105 = c7.b(Boxing.boxInt(28));
                r117.width = r105;
                r117.height = r105;
                r117.setMarginEnd(c7.b(Boxing.boxInt(16)));
                r115.setLayoutParams(r117);
            L60:
                return Unit.INSTANCE;
            L50:
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            L51:
                ImageView r118 = r113.f326840f;
                if (r118 == null) goto L54;
                r118.setImageResource(v19.c.b(R.attr.larus_ic_face_swap_v2, r118.getContext(), R.drawable.larus_ic_face_swap_v2));
            L54:
                ImageView r119 = r113.f326840f;
                ViewGroup.LayoutParams r120 = r119.getLayoutParams();
                if (r120 == null) goto L58;
                ViewGroup.MarginLayoutParams r121 = (ViewGroup.MarginLayoutParams) r120;
                int r106 = c7.b(Boxing.boxInt(24));
                r121.width = r106;
                r121.height = r106;
                r121.setMarginEnd(c7.b(Boxing.boxInt(18)));
                r119.setLayoutParams(r121);
                goto L60
            L58:
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r112);
                NovaTitleBarEx r122 = this.f371541a.A;
                if (r122 == null) goto L17;
                LarusWidgetTitlebarExBinding r123 = r122.getBinding();
                DigitalAvatarComponent r107 = this.f371541a;
                ImageView r108 = r123.f326840f;
                boolean r124 = false;
                if (((Boolean) r107.f371527n.getValue()).booleanValue() == false) goto L21;
                int r125 = 0;
            L22:
                r108.setVisibility(r125);
                b0 r109 = (b0) r107.f371535v.getValue();
                if (r109 == null) goto L26;
                r109.a();
            L26:
                if (((Boolean) r107.f371527n.getValue()).booleanValue() == false) goto L60;
                if (r110 != null) goto L29;
            L30:
                r124 = true;
            L31:
                if (r124 == false) goto L40;
                ImageView r126 = r123.f326840f;
                if (r126 == null) goto L35;
                r126.setImageResource(v19.c.b(R.attr.larus_ic_face_swap_v2, r126.getContext(), R.drawable.larus_ic_face_swap_v2));
            L35:
                ImageView r127 = r123.f326840f;
                ViewGroup.LayoutParams r128 = r127.getLayoutParams();
                if (r128 == null) goto L39;
                ViewGroup.MarginLayoutParams r129 = (ViewGroup.MarginLayoutParams) r128;
                int r130 = c7.b(Boxing.boxInt(24));
                r129.width = r130;
                r129.height = r130;
                r129.setMarginEnd(c7.b(Boxing.boxInt(18)));
                r127.setLayoutParams(r129);
                goto L60
            L39:
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            L40:
                CoroutineDispatcher r131 = Dispatchers.getIO();
                DigitalAvatarComponent$initWhiteTUrl$1$2$1$1$bitmap$1 r132 = new DigitalAvatarComponent$initWhiteTUrl$1$2$1$1$bitmap$1(r110, null);
                r100.L$0 = r123;
                r100.L$1 = r123;
                r100.label = 1;
                Object r133 = BuildersKt.withContext(r131, r132, r100);
                if (r133 != r102) goto L43;
                return r102;
            L43:
                r112 = r133;
                r113 = r123;
                goto L44
            L29:
                if (r110.length() != 0) goto L31;
            L21:
                r125 = 8;
                goto L22
            L17:
                return Unit.INSTANCE;
            L7:
                r100 = new DigitalAvatarComponent$initWhiteTUrl$1$2$1$emit$1(this, r111);
                goto L8
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
                return a((String) r100, r101);
            }
        }

        public AnonymousClass2(DigitalAvatarComponent r100, Continuation<? super AnonymousClass2> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(this.this$0, r101);
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
            if (r102 != 1) goto L6;
            ResultKt.throwOnFailure(r100);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            DigitalAvatarComponent r103 = this.this$0;
            StateFlowImpl r104 = r103.f371528o;
            AnonymousClass1 r105 = new AnonymousClass1(r103);
            this.label = 1;
            if (r104.collect(r105, this) != r101) goto L12;
            return r101;
        }
    }

    public DigitalAvatarComponent$initWhiteTUrl$1(DigitalAvatarComponent r100, Continuation<? super DigitalAvatarComponent$initWhiteTUrl$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        DigitalAvatarComponent$initWhiteTUrl$1 r102 = new DigitalAvatarComponent$initWhiteTUrl$1(this.this$0, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DigitalAvatarComponent$initWhiteTUrl$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        CoroutineScope r102 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r110);
    L22:
        Job r111 = this.this$0.f371529p;
        if (r111 == null) goto L25;
        Job.DefaultImpls.cancel$default(r111, null, 1, null);
    L25:
        CoroutineScope r103 = r102;
    L27:
        BuildersKt.launch$default(r103, null, null, new AnonymousClass2(this.this$0, null), 3, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        CoroutineScope r112 = (CoroutineScope) this.L$0;
        CharSequence r104 = (CharSequence) this.this$0.f371528o.getValue();
        if (r104 != null) goto L11;
    L14:
        boolean r105 = true;
    L15:
        if (r105 == true) goto L17;
    L26:
        r103 = r112;
        goto L27
    L17:
        if (((Boolean) this.this$0.f371527n.getValue()).booleanValue() == false) goto L26;
        DigitalAvatarComponent r106 = this.this$0;
        r106.f371529p = BuildersKt.launch$default(r112, null, null, new AnonymousClass1(r106, null), 3, null);
        DigitalAvatarInfoManager r107 = DigitalAvatarInfoManager.f371542a;
        this.L$0 = r112;
        this.label = 1;
        if (DigitalAvatarInfoManager.d(r107, this) != r100) goto L21;
        return r100;
    L21:
        r102 = r112;
        goto L22
    L11:
        if (r104.length() == 0) goto L14;
        r105 = false;
        goto L15
    }
}
