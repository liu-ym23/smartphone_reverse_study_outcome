package com.obric.miniapp.view;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ai.bridge.method.floatinginput.InputMode;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.view.input.FloatingSpeakerView;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import com.larus.utils.logger.FLogger;
import com.obric.miniapp.databinding.MiniAppFragmentBinding;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes33.dex */
public final class MiniAppFragment$floatingSpeakerController$1 implements k2.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f398617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f398618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f398619c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f398620d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f398621e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public KeyBoardLayoutListener f398622f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function1<? super Integer, Unit> f398623g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ MiniAppFragment f398624h;

    public final class KeyBoardLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Job f398625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final StateFlowImpl f398626b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MiniAppFragment$floatingSpeakerController$1 f398627c;

        /* JADX INFO: renamed from: com.obric.miniapp.view.MiniAppFragment$floatingSpeakerController$1$KeyBoardLayoutListener$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.miniapp.view.MiniAppFragment$floatingSpeakerController$1$KeyBoardLayoutListener$1", f = "MiniAppFragment.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MAX_JITTER_BUFFER_DELAY}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ KeyBoardLayoutListener this$0;
            final /* synthetic */ MiniAppFragment this$1;
            final /* synthetic */ MiniAppFragment$floatingSpeakerController$1 this$2;

            /* JADX INFO: renamed from: com.obric.miniapp.view.MiniAppFragment$floatingSpeakerController$1$KeyBoardLayoutListener$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "layoutBottom", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
            @DebugMetadata(c = "com.obric.miniapp.view.MiniAppFragment$floatingSpeakerController$1$KeyBoardLayoutListener$1$1", f = "MiniAppFragment.kt", i = {0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ENABLE_PLUGIN_LOAD, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_STALL_DURATION_REASON3}, m = "invokeSuspend", n = {"floatingSpeaker", "layoutBottom"}, s = {"L$0", "I$0"})
            public static final class C46621 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
                /* synthetic */ int I$0;
                Object L$0;
                int label;
                final /* synthetic */ MiniAppFragment this$0;
                final /* synthetic */ MiniAppFragment$floatingSpeakerController$1 this$1;

                /* JADX INFO: renamed from: com.obric.miniapp.view.MiniAppFragment$floatingSpeakerController$1$KeyBoardLayoutListener$1$1$1, reason: invalid class name and collision with other inner class name */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
                @DebugMetadata(c = "com.obric.miniapp.view.MiniAppFragment$floatingSpeakerController$1$KeyBoardLayoutListener$1$1$1", f = "MiniAppFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                public static final class C46631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ FloatingSpeakerView $floatingSpeaker;
                    final /* synthetic */ int $layoutBottom;
                    int label;
                    final /* synthetic */ MiniAppFragment$floatingSpeakerController$1 this$0;
                    final /* synthetic */ MiniAppFragment this$1;

                    public C46631(FloatingSpeakerView r100, MiniAppFragment$floatingSpeakerController$1 r101, int r102, MiniAppFragment r103, Continuation<? super C46631> r104) {
                        this.$floatingSpeaker = r100;
                        this.this$0 = r101;
                        this.$layoutBottom = r102;
                        this.this$1 = r103;
                        super(2, r104);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                        return new C46631(this.$floatingSpeaker, this.this$0, this.$layoutBottom, this.this$1, r101);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                        return invoke2(r100, r101);
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                        return ((C46631) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object r110) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) goto L35;
                        ResultKt.throwOnFailure(r110);
                        int r111 = this.$floatingSpeaker.getBottom() - this.$floatingSpeaker.getMarginBottom();
                        int r100 = this.$floatingSpeaker.getMarginBottom();
                        MiniAppFragment$floatingSpeakerController$1 r101 = this.this$0;
                        r101.f398620d += r101.f398618b - this.$layoutBottom;
                        ViewGroup.LayoutParams r102 = this.$floatingSpeaker.getLayoutParams();
                        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
                        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
                    L8:
                        boolean r104 = true;
                        if (r103 == null) goto L25;
                        MiniAppFragment$floatingSpeakerController$1 r105 = this.this$0;
                        int r106 = this.$layoutBottom;
                        FloatingSpeakerView r107 = this.$floatingSpeaker;
                        int r108 = r105.f398618b - r106;
                        int r109 = r105.f398620d;
                        if (r109 > 0) goto L13;
                    L15:
                        if (r109 == 0) goto L17;
                    L19:
                        int r112 = r108 + (r111 - r105.f398619c);
                        r103.bottomMargin += r112;
                        r105.f398619c = (r107.getBottom() - r112) - r107.getMarginBottom();
                        FLogger.f375446a.d("FloatingSpeaker", "floatingSpeaker.bottomMargin =  " + r103.bottomMargin);
                        if (r103.bottomMargin != 0) goto L24;
                        Function1<? super Integer, Unit> r113 = r105.f398623g;
                        if (r113 == null) goto L24;
                        r113.invoke(Boxing.boxInt(r107.getMarginBottom()));
                    L24:
                        r107.requestLayout();
                        goto L25
                    L17:
                        if (r105.f398621e == false) goto L19;
                        r105.f398621e = false;
                        r108 = r108 + r100;
                        goto L19
                    L13:
                        if (r105.f398621e == true) goto L15;
                        r105.f398621e = true;
                        r108 = r108 - r100;
                    L25:
                        p r114 = this.this$1.E;
                        if (r114 != null) goto L28;
                    L32:
                        this.this$0.f398618b = this.$layoutBottom;
                        return Unit.INSTANCE;
                    L28:
                        if (this.this$0.f398620d > 0) goto L31;
                        r104 = false;
                    L31:
                        r114.invoke(Boxing.boxBoolean(r104), Boxing.boxInt(this.this$0.f398620d));
                        goto L32
                    L7:
                        r103 = null;
                        goto L8
                    L35:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }

                public C46621(MiniAppFragment r100, MiniAppFragment$floatingSpeakerController$1 r101, Continuation<? super C46621> r102) {
                    this.this$0 = r100;
                    this.this$1 = r101;
                    super(2, r102);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                    C46621 r102 = new C46621(this.this$0, this.this$1, r101);
                    r102.I$0 = ((Number) r100).intValue();
                    return r102;
                }

                public final Object invoke(int r100, Continuation<? super Unit> r101) {
                    return ((C46621) create(Integer.valueOf(r100), r101)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Integer r100, Continuation<? super Unit> r101) {
                    return invoke(r100.intValue(), r101);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object r110) {
                    Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int r101 = this.label;
                    if (r101 == 0) goto L10;
                    if (r101 == 1) goto L9;
                    if (r101 != 2) goto L8;
                    ResultKt.throwOnFailure(r110);
                L34:
                    return Unit.INSTANCE;
                L8:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L9:
                    int r102 = this.I$0;
                    FloatingSpeakerView r103 = (FloatingSpeakerView) this.L$0;
                    ResultKt.throwOnFailure(r110);
                L25:
                    FLogger.f375446a.i("FloatingSpeaker", "init GlobalLayout, layoutBottom =  " + r102);
                    MiniAppFragment$floatingSpeakerController$1 r111 = this.this$1;
                    r111.f398618b = r102;
                    r111.f398619c = r103.getBottom() - r103.getMarginBottom();
                    r103.setEnable(true);
                    return Unit.INSTANCE;
                L10:
                    ResultKt.throwOnFailure(r110);
                    int r104 = this.I$0;
                    if (r104 == 0) goto L13;
                    MiniAppFragmentBinding r112 = this.this$0.f398593f;
                    if (r112 == null) goto L36;
                    FloatingSpeakerView r105 = r112.f397623c;
                    if (r105 == null) goto L36;
                    int r113 = this.this$1.f398618b;
                    if (r113 != 0) goto L27;
                    this.L$0 = r105;
                    this.I$0 = r104;
                    this.label = 1;
                    if (DelayKt.delay(500, this) != r100) goto L24;
                    return r100;
                L24:
                    r103 = r105;
                    r102 = r104;
                    goto L25
                L27:
                    if (r113 == r104) goto L29;
                    FLogger.f375446a.i("FloatingSpeaker", "onGlobalLayoutChanged, layoutBottom =  " + r104);
                    MainCoroutineDispatcher r114 = Dispatchers.getMain();
                    C46631 r106 = new C46631(r105, this.this$1, r104, this.this$0, null);
                    this.label = 2;
                    if (BuildersKt.withContext(r114, r106, this) != r100) goto L34;
                    return r100;
                L29:
                    return Unit.INSTANCE;
                L36:
                    return Unit.INSTANCE;
                L13:
                    return Unit.INSTANCE;
                }
            }

            public AnonymousClass1(KeyBoardLayoutListener r100, MiniAppFragment r101, MiniAppFragment$floatingSpeakerController$1 r102, Continuation<? super AnonymousClass1> r103) {
                this.this$0 = r100;
                this.this$1 = r101;
                this.this$2 = r102;
                super(2, r103);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                return new AnonymousClass1(this.this$0, this.this$1, this.this$2, r101);
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
                StateFlowImpl r103 = this.this$0.f398626b;
                C46621 r104 = new C46621(this.this$1, this.this$2, null);
                this.label = 1;
                if (kotlinx.coroutines.flow.e.i(r103, r104, this) != r101) goto L12;
                return r101;
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            Rect r100 = new Rect();
            Window r101 = (Window) this.f398627c.f398624h.Q.invoke();
            if (r101 == null) goto L12;
            View r102 = r101.getDecorView();
            if (com.larus.home.impl.utils.c.f346345e == false) goto L9;
            FLogger.f375446a.i("DecorViewLancet", "getDecorView");
            Thread r103 = ThreadMethodProxy.currentThread();
            if (r103 == com.larus.home.impl.utils.c.f346341a) goto L9;
            com.larus.home.impl.utils.c.a(r103, "getDecorView");
        L9:
            if (r102 == null) goto L12;
            r102.getWindowVisibleDisplayFrame(r100);
        L12:
            if (r100.bottom <= 0) goto L14;
            boolean r104 = true;
        L15:
            if (r104 == true) goto L18;
            r100 = null;
        L18:
            if (r100 == null) goto L21;
            int r105 = r100.bottom;
            this.f398626b.setValue(Integer.valueOf(r105));
            return;
        L21:
            return;
        L14:
            r104 = false;
            goto L15
        }

        public KeyBoardLayoutListener(MiniAppFragment$floatingSpeakerController$1 r100) {
            this.f398627c = r100;
            this.f398626b = j1.a(0);
            this.f398625a = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r100.f398624h), Dispatchers.getIO(), null, new AnonymousClass1(this, r100.f398624h, r100, null), 2, null);
        }
    }

    @Override // k2.t
    public final void b() {
        MiniAppFragment r100 = this.f398624h;
        int r101 = MiniAppFragment.R;
        if (r100.X90() == true) goto L5;
        return;
    L5:
        FLogger.f375446a.i("FloatingSpeaker", "cancelTTS");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.f398624h), zh8.a.a(), null, new MiniAppFragment$floatingSpeakerController$1$cancelTTS$1(this.f398624h, null), 2, null);
    }

    @Override // k2.t
    public final void f() {
        MiniAppFragment r100 = this.f398624h;
        int r101 = MiniAppFragment.R;
        if (r100.X90() == true) goto L5;
        return;
    L5:
        FLogger.f375446a.i("FloatingSpeaker", "clearAppendQuery");
        MiniAppFragmentBinding r102 = this.f398624h.f398593f;
        if (r102 == null) goto L11;
        FloatingSpeakerView r103 = r102.f397623c;
        if (r103 == null) goto L12;
        r103.f37727f = null;
        return;
    L12:
        return;
    }

    @Override // k2.t
    public final String getBotId() {
        return this.f398624h.f398595h;
    }

    @Override // k2.t
    public final InputMode j() {
        MiniAppFragmentBinding r100 = this.f398624h.f398593f;
        if (r100 == null) goto L9;
        FloatingSpeakerView r101 = r100.f397623c;
        if (r101 == null) goto L9;
        i1<InputMode> r102 = r101.getInputModeFlow();
        if (r102 == null) goto L9;
        return r102.getValue();
    L9:
        return null;
    }

    public MiniAppFragment$floatingSpeakerController$1(MiniAppFragment r100) {
        this.f398624h = r100;
    }

    @Override // k2.t
    public final void a(boolean r100) {
        this.f398624h.B = r100;
    }

    @Override // k2.t
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        MiniAppFragment r101 = this.f398624h;
        int r102 = MiniAppFragment.R;
        if (r101.X90() == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.f398624h), null, null, new MiniAppFragment$floatingSpeakerController$1$updateInputPlaceHolder$1(r100, this.f398624h, null), 3, null);
    }

    @Override // k2.t
    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "appendQuery");
        MiniAppFragment r101 = this.f398624h;
        int r102 = MiniAppFragment.R;
        if (r101.X90() == true) goto L5;
        return;
    L5:
        FLogger.f375446a.i("FloatingSpeaker", "setAppendQuery " + r100);
        MiniAppFragmentBinding r103 = this.f398624h.f398593f;
        if (r103 == null) goto L11;
        FloatingSpeakerView r104 = r103.f397623c;
        if (r104 == null) goto L12;
        r104.setAppendQuery(r100);
        return;
    L12:
        return;
    }

    @Override // k2.t
    public final Object h(Continuation<? super Boolean> r110) {
        if ((r110 instanceof MiniAppFragment$floatingSpeakerController$1$clearContext$1) == false) goto L7;
        MiniAppFragment$floatingSpeakerController$1$clearContext$1 r100 = (MiniAppFragment$floatingSpeakerController$1$clearContext$1) r110;
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
    L25:
        boolean r104 = ub8.d.a((ub8.b) r111);
    L26:
        if (r104 == false) goto L34;
        com.bytedance.ai.model.widgets.c r112 = this.f398624h.f398598k;
        if (r112 == null) goto L32;
        AppletRuntime r113 = r112.getAppletRuntime();
        if (r113 == null) goto L32;
        r113.E(null, this.f398624h.f398595h);
    L32:
        AppletRuntimeManager r114 = AppletRuntimeManager.INSTANCE;
        String r105 = this.f398624h.f398595h;
        r114.getClass();
        AppletRuntimeManager.b(r105);
    L34:
        return Boxing.boxBoolean(r104);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        MiniAppFragment r115 = this.f398624h;
        int r106 = MiniAppFragment.R;
        r104 = false;
        if (r115.X90() == false) goto L17;
        FLogger.f375446a.i("FloatingSpeaker", "clearContext " + this.f398624h.f398596i);
        if (NetworkUtils.isNetworkAvailable(this.f398624h.getContext()) == false) goto L26;
        String r116 = this.f398624h.f398596i;
        if (r116 == null) goto L26;
        IConversationRepoService r107 = zh8.a.f572197b;
        IConversationRepoService.a.f(r107, r116, false, false, OmniBreakReason.OmniBreakReason_CLEAR_CONTEXT, 6);
        r100.label = 1;
        r111 = r107.n(r116, 3, "applet_fragment", r100);
        if (r111 != r102) goto L25;
        return r102;
    L17:
        return Boxing.boxBoolean(false);
    L7:
        r100 = new MiniAppFragment$floatingSpeakerController$1$clearContext$1(this, r110);
        goto L8
    }

    @Override // k2.t
    public final void i(int r100) {
        MiniAppFragment r101 = this.f398624h;
        int r102 = MiniAppFragment.R;
        if (r101.X90() == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.f398624h), null, null, new MiniAppFragment$floatingSpeakerController$1$updateInputOffset$1(r100, this, this.f398624h, null), 3, null);
    }

    @Override // k2.t
    public final void m(boolean r100) {
        this.f398624h.M = r100;
    }

    @Override // k2.t
    public final void o(InputMode r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        if (j() == r100) goto L10;
        MiniAppFragmentBinding r101 = this.f398624h.f398593f;
        if (r101 == null) goto L11;
        FloatingSpeakerView r102 = r101.f397623c;
        if (r102 == null) goto L12;
        r102.R5(r100);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // k2.t
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "mode");
        FLogger.f375446a.d("FloatingSpeaker", "updateInputText " + r100 + ' ' + r101);
        MiniAppFragmentBinding r102 = this.f398624h.f398593f;
        if (r102 == null) goto L8;
        FloatingSpeakerView r103 = r102.f397623c;
        if (r103 == null) goto L9;
        r103.S5(r100, r101);
        return;
    L9:
        return;
    }

    @Override // k2.t
    public final Object g(String r100, Continuation<? super Unit> r101) {
        MiniAppFragment r102 = this.f398624h;
        int r103 = MiniAppFragment.R;
        if (r102.X90() == false) goto L5;
        FLogger.f375446a.i("FloatingSpeaker", "updateBotId " + r100);
        Object r104 = MiniAppFragment.U90(this.f398624h, r100, r101);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r104;
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    @Override // k2.t
    public final Unit k(String r100, boolean r101) {
        MiniAppFragment r102 = this.f398624h;
        int r103 = MiniAppFragment.R;
        if (r102.X90() == false) goto L5;
        FLogger.f375446a.i("FloatingSpeaker", "setTTSSwitch " + r100 + ' ' + r101);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.f398624h), Dispatchers.getIO(), null, new MiniAppFragment$floatingSpeakerController$1$setTTSSwitch$2(r100, r101, this.f398624h, null), 2, null);
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    @Override // k2.t
    public final Object l(String r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof MiniAppFragment$floatingSpeakerController$1$startTTS$1) == false) goto L7;
        MiniAppFragment$floatingSpeakerController$1$startTTS$1 r102 = (MiniAppFragment$floatingSpeakerController$1$startTTS$1) r101;
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
    L25:
        Message r107 = (Message) r104;
        if (r107 == null) goto L29;
        MiniAppFragment r108 = this.f398624h;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r108), zh8.a.a(), null, new MiniAppFragment$floatingSpeakerController$1$startTTS$2$1(r108, r107, null), 2, null);
    L29:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        MiniAppFragment r109 = this.f398624h;
        int r110 = MiniAppFragment.R;
        if (r109.X90() == false) goto L17;
        FLogger.f375446a.i("FloatingSpeaker", "startTTS " + r100);
        if (StringsKt.isBlank(r100) == true) goto L21;
        IChatRepoService r111 = zh8.a.f572196a;
        r102.label = 1;
        r104 = r111.E1(r100, r102);
        if (r104 != r105) goto L25;
        return r105;
    L21:
        return Unit.INSTANCE;
    L17:
        return Unit.INSTANCE;
    L7:
        r102 = new MiniAppFragment$floatingSpeakerController$1$startTTS$1(this, r101);
        goto L8
    }

    @Override // k2.t
    public final void n(boolean r110, boolean r111) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.f398624h), null, null, new MiniAppFragment$floatingSpeakerController$1$setChatInputVisible$1(r110, r111, this.f398624h, this, null), 3, null);
    }
}
