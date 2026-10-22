package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.ui.platform.PlatformTextInputMethodRequest;
import androidx.compose.ui.platform.PlatformTextInputSession;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\u001az\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00122\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00162\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0080@¢\u0006\u0002\u0010\u001b\u001a|\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00122\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0081@¢\u0006\u0002\u0010\u001e\u001a \u0010\"\u001a\u00020\u00142\b\b\u0002\u0010#\u001a\u00020\u00052\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016H\u0002\"\u0016\u0010\u0000\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!¨\u0006%"}, d2 = {"TIA_DEBUG", "", "getTIA_DEBUG$annotations", "()V", "TIA_TAG", "", "platformSpecificTextInputSession", "", "Landroidx/compose/ui/platform/PlatformTextInputSession;", "state", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "layoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "receiveContentConfiguration", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "onImeAction", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/ImeAction;", "", "updateSelectionState", "Lkotlin/Function0;", "stylusHandwritingTrigger", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "(Landroidx/compose/ui/platform/PlatformTextInputSession;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlinx/coroutines/flow/MutableSharedFlow;Landroidx/compose/ui/platform/ViewConfiguration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "composeImm", "Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;", "(Landroidx/compose/ui/platform/PlatformTextInputSession;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;Lkotlinx/coroutines/flow/MutableSharedFlow;Landroidx/compose/ui/platform/ViewConfiguration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ALL_MIME_TYPES", "", "[Ljava/lang/String;", "logDebug", "tag", "content", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidTextInputSession_androidKt {
    private static final String[] ALL_MIME_TYPES = null;
    public static final boolean TIA_DEBUG = false;
    private static final String TIA_TAG = "AndroidTextInputSession";

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt", f = "AndroidTextInputSession.android.kt", i = {}, l = {59}, m = "platformSpecificTextInputSession", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r1) {
            super(r1);
        }

        public final Object invokeSuspend(Object r11) {
            this.result = r11;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return AndroidTextInputSession_androidKt.platformSpecificTextInputSession(null, null, null, null, null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt", f = "AndroidTextInputSession.android.kt", i = {}, l = {84}, m = "platformSpecificTextInputSession", n = {}, s = {})
    public static final class AnonymousClass2 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass2(Continuation<? super AnonymousClass2> r1) {
            super(r1);
        }

        public final Object invokeSuspend(Object r12) {
            this.result = r12;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return AndroidTextInputSession_androidKt.platformSpecificTextInputSession(null, null, null, null, null, null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3", f = "AndroidTextInputSession.android.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        final /* synthetic */ ComposeInputMethodManager $composeImm;
        final /* synthetic */ ImeOptions $imeOptions;
        final /* synthetic */ TextLayoutState $layoutState;
        final /* synthetic */ Function1<ImeAction, Unit> $onImeAction;
        final /* synthetic */ ReceiveContentConfiguration $receiveContentConfiguration;
        final /* synthetic */ TransformedTextFieldState $state;
        final /* synthetic */ MutableSharedFlow<Unit> $stylusHandwritingTrigger;
        final /* synthetic */ PlatformTextInputSession $this_platformSpecificTextInputSession;
        final /* synthetic */ Function0<Unit> $updateSelectionState;
        final /* synthetic */ ViewConfiguration $viewConfiguration;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$1", f = "AndroidTextInputSession.android.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ComposeInputMethodManager $composeImm;
            final /* synthetic */ TransformedTextFieldState $state;
            int label;

            public AnonymousClass1(TransformedTextFieldState r1, ComposeInputMethodManager r2, Continuation<? super AnonymousClass1> r3) {
                this.$state = r1;
                this.$composeImm = r2;
                super(2, r3);
            }

            public static /* synthetic */ void a(ComposeInputMethodManager r0, TextFieldCharSequence r1, TextFieldCharSequence r2, boolean r3) {
                invokeSuspend$lambda$0(r0, r1, r2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new AnonymousClass1(this.$state, this.$composeImm, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r5) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L6;
                ResultKt.throwOnFailure(r5);
            L12:
                throw new KotlinNothingValueException();
            L6:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r5);
                TransformedTextFieldState r6 = this.$state;
                final ComposeInputMethodManager r2 = this.$composeImm;
                TextFieldState.NotifyImeListener r3 = new e(r2);
                this.label = 1;
                if (r6.collectImeNotifications(r3, this) != r0) goto L12;
                return r0;
            }

            private static final void invokeSuspend$lambda$0(ComposeInputMethodManager r4, TextFieldCharSequence r5, TextFieldCharSequence r6, boolean r7) {
                long r0 = r5.m1535getSelectiond9O1mEE();
                TextRange r8 = r5.m1534getCompositionMzsxiRA();
                long r2 = r6.m1535getSelectiond9O1mEE();
                TextRange r9 = r6.m1534getCompositionMzsxiRA();
                if (r7 == false) goto L6;
                r4.restartInput();
                return;
            L6:
                if (TextRange.equals-impl0(r0, r2) == true) goto L8;
            L9:
                int r10 = TextRange.getMin-impl(r2);
                int r11 = TextRange.getMax-impl(r2);
                int r1 = -1;
                if (r9 == null) goto L12;
                int r3 = TextRange.getMin-impl(r9.unbox-impl());
            L13:
                if (r9 == null) goto L15;
                r1 = TextRange.getMax-impl(r9.unbox-impl());
            L15:
                r4.updateSelection(r10, r11, r3, r1);
                return;
            L12:
                r3 = -1;
                goto L13
            L8:
                if (Intrinsics.areEqual(r8, r9) == false) goto L9;
            }
        }

        public AnonymousClass3(MutableSharedFlow<Unit> r1, TransformedTextFieldState r2, TextLayoutState r3, ComposeInputMethodManager r4, PlatformTextInputSession r5, ImeOptions r6, ReceiveContentConfiguration r7, Function1<? super ImeAction, Unit> r8, Function0<Unit> r9, ViewConfiguration r10, Continuation<? super AnonymousClass3> r11) {
            this.$stylusHandwritingTrigger = r1;
            this.$state = r2;
            this.$layoutState = r3;
            this.$composeImm = r4;
            this.$this_platformSpecificTextInputSession = r5;
            this.$imeOptions = r6;
            this.$receiveContentConfiguration = r7;
            this.$onImeAction = r8;
            this.$updateSelectionState = r9;
            this.$viewConfiguration = r10;
            super(2, r11);
        }

        public static /* synthetic */ String a(TransformedTextFieldState r0) {
            return invokeSuspend$lambda$3$lambda$1(r0);
        }

        public static /* synthetic */ InputConnection c(TransformedTextFieldState r0, ImeOptions r1, ReceiveContentConfiguration r2, ComposeInputMethodManager r3, Function1 r4, CursorAnchorInfoController r5, TextLayoutState r6, Function0 r7, ViewConfiguration r8, EditorInfo r9) {
            return invokeSuspend$lambda$3(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
        }

        public final Continuation<Unit> create(Object r14, Continuation<?> r15) {
            AnonymousClass3 r12 = new AnonymousClass3(this.$stylusHandwritingTrigger, this.$state, this.$layoutState, this.$composeImm, this.$this_platformSpecificTextInputSession, this.$imeOptions, this.$receiveContentConfiguration, this.$onImeAction, this.$updateSelectionState, this.$viewConfiguration, r15);
            r12.L$0 = r14;
            return r12;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<?> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        private static final String invokeSuspend$lambda$3$lambda$1(TransformedTextFieldState r2) {
            return "createInputConnection(value=\"" + r2.getVisualText() + "\")";
        }

        public final Object invokeSuspend(Object r22) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L6;
            ResultKt.throwOnFailure(r22);
        L15:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r22);
            CoroutineScope r3 = (CoroutineScope) this.L$0;
            BuildersKt.launch$default(r3, null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(this.$state, this.$composeImm, null), 1, null);
            MutableSharedFlow<Unit> r4 = this.$stylusHandwritingTrigger;
            if (r4 == null) goto L11;
            BuildersKt.launch$default(r3, null, null, new AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$2$1(r4, this.$composeImm, null), 3, null);
        L11:
            final CursorAnchorInfoController r5 = new CursorAnchorInfoController(this.$state, this.$layoutState, this.$composeImm, r3);
            PlatformTextInputSession r6 = this.$this_platformSpecificTextInputSession;
            final TransformedTextFieldState r12 = this.$state;
            final ImeOptions r13 = this.$imeOptions;
            final ReceiveContentConfiguration r14 = this.$receiveContentConfiguration;
            final ComposeInputMethodManager r15 = this.$composeImm;
            final Function1<ImeAction, Unit> r7 = this.$onImeAction;
            final TextLayoutState r8 = this.$layoutState;
            final Function0<Unit> r9 = this.$updateSelectionState;
            final ViewConfiguration r10 = this.$viewConfiguration;
            PlatformTextInputMethodRequest r11 = new d(r12, r13, r14, r15, r7, r5, r8, r9, r10);
            this.label = 1;
            if (r6.startInputMethod(r11, this) != r1) goto L15;
            return r1;
        }

        private static final InputConnection invokeSuspend$lambda$3(final TransformedTextFieldState r13, ImeOptions r14, ReceiveContentConfiguration r15, ComposeInputMethodManager r16, Function1 r17, CursorAnchorInfoController r18, TextLayoutState r19, Function0 r20, ViewConfiguration r21, EditorInfo r22) {
            String[] r11 = null;
            AndroidTextInputSession_androidKt.logDebug$default(null, new c(r13), 1, null);
            AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$3$textInputSession$1 r12 = new AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$3$textInputSession$1(new DefaultImeEditCommandScope(r13), r13, r16, r17, r15, r18, r19, r20, r21);
            TextFieldCharSequence r0 = r13.getVisualText();
            long r1 = r13.getVisualText().m1535getSelectiond9O1mEE();
            if (r15 == null) goto L5;
            r11 = AndroidTextInputSession_androidKt.access$getALL_MIME_TYPES$p();
        L5:
            EditorInfo_androidKt.m1579updatepLxbY9I(r22, r0, r1, r14, r11);
            return new StatelessInputConnection(r12, r22);
        }
    }

    public static /* synthetic */ void getTIA_DEBUG$annotations() {
    }

    private static final void logDebug(String r0, Function0<String> r1) {
    }

    static {
        ALL_MIME_TYPES = new String[]{"*/*", "image/*", "video/*"};
    }

    public static final /* synthetic */ String[] access$getALL_MIME_TYPES$p() {
        return ALL_MIME_TYPES;
    }

    public static /* synthetic */ void logDebug$default(String r0, Function0 r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r0 = TIA_TAG;
    L5:
        logDebug(r0, r1);
    }

    public static final Object platformSpecificTextInputSession(PlatformTextInputSession r13, TransformedTextFieldState r14, TextLayoutState r15, ImeOptions r16, ReceiveContentConfiguration r17, Function1<? super ImeAction, Unit> r18, Function0<Unit> r19, MutableSharedFlow<Unit> r20, ViewConfiguration r21, Continuation<?> r22) {
        if ((r22 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r1 = (AnonymousClass1) r22;
        int r2 = r1.label;
        if ((r2 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r1.label = r2 - RtlSpacingHelper.UNDEFINED;
    L8:
        AnonymousClass1 r12 = r1;
        Object r0 = r12.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r12.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L12;
        ResultKt.throwOnFailure(r0);
    L18:
        throw new KotlinNothingValueException();
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        ComposeInputMethodManager r9 = ComposeInputMethodManager_androidKt.ComposeInputMethodManager(r13.getView());
        r12.label = 1;
        if (platformSpecificTextInputSession(r13, r14, r15, r16, r17, r18, r19, r9, r20, r21, r12) != r3) goto L18;
        return r3;
    L7:
        r1 = new AnonymousClass1(r22);
        goto L8
    }

    public static final Object platformSpecificTextInputSession(PlatformTextInputSession r17, TransformedTextFieldState r18, TextLayoutState r19, ImeOptions r20, ReceiveContentConfiguration r21, Function1<? super ImeAction, Unit> r22, Function0<Unit> r23, ComposeInputMethodManager r24, MutableSharedFlow<Unit> r25, ViewConfiguration r26, Continuation<?> r27) {
        if ((r27 instanceof AnonymousClass2) == false) goto L7;
        AnonymousClass2 r1 = (AnonymousClass2) r27;
        int r2 = r1.label;
        if ((r2 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r1.label = r2 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L12;
        ResultKt.throwOnFailure(r0);
    L18:
        throw new KotlinNothingValueException();
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        AnonymousClass3 r5 = new AnonymousClass3(r25, r18, r19, r24, r17, r20, r21, r22, r23, r26, null);
        r1.label = 1;
        if (CoroutineScopeKt.coroutineScope(r5, r1) != r3) goto L18;
        return r3;
    L7:
        r1 = new AnonymousClass2(r27);
        goto L8
    }

    public static /* synthetic */ Object platformSpecificTextInputSession$default(PlatformTextInputSession r13, TransformedTextFieldState r14, TextLayoutState r15, ImeOptions r16, ReceiveContentConfiguration r17, Function1 r18, Function0 r19, MutableSharedFlow r20, ViewConfiguration r21, Continuation r22, int r23, Object r24) {
        if ((r23 & 32) == 0) goto L5;
        Function0 r9 = null;
    L7:
        if ((r23 & 64) == 0) goto L9;
        MutableSharedFlow r10 = null;
    L11:
        if ((r23 & 128) == 0) goto L13;
        ViewConfiguration r11 = null;
    L15:
        return platformSpecificTextInputSession(r13, r14, r15, r16, r17, r18, r9, r10, r11, r22);
    L13:
        r11 = r21;
        goto L15
    L9:
        r10 = r20;
        goto L11
    L5:
        r9 = r19;
        goto L7
    }
}
