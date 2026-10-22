package androidx.compose.foundation.text.selection;

import android.app.RemoteAction;
import android.content.Context;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextClassifier;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope_androidKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.intl.LocaleList;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\"\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001eH\u0096@¢\u0006\u0004\b\"\u0010#J \u0010$\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001eH\u0096@¢\u0006\u0004\b&\u0010#J(\u0010'\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u000fH\u0082@¢\u0006\u0004\b)\u0010*J<\u0010-\u001a\u00020%*\u00020.2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001e2\u0017\u0010/\u001a\u0013\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020%00¢\u0006\u0002\b1H\u0000¢\u0006\u0004\b2\u00103J\u001f\u00104\u001a\u0004\u0018\u0001052\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b6\u00107J?\u00108\u001a\u0004\u0018\u0001H9\"\u0004\b\u0000\u001092'\u0010:\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H90<\u0012\u0006\u0012\u0004\u0018\u00010,0;¢\u0006\u0002\b1H\u0082@¢\u0006\u0002\u0010=R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R/\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u00118B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviorsImpl;", "Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "context", "Landroid/content/Context;", "selectedTextType", "Landroidx/compose/foundation/text/selection/SelectedTextType;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "<init>", "(Lkotlin/coroutines/CoroutineContext;Landroid/content/Context;Landroidx/compose/foundation/text/selection/SelectedTextType;Landroidx/compose/ui/text/intl/LocaleList;)V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "textClassificationSession", "Landroid/view/textclassifier/TextClassifier;", "<set-?>", "Landroidx/compose/foundation/text/selection/TextClassificationResult;", "textClassificationResult", "getTextClassificationResult", "()Landroidx/compose/foundation/text/selection/TextClassificationResult;", "setTextClassificationResult", "(Landroidx/compose/foundation/text/selection/TextClassificationResult;)V", "textClassificationResult$delegate", "Landroidx/compose/runtime/MutableState;", "androidLocalList", "Landroid/os/LocaleList;", "getAndroidLocalList", "()Landroid/os/LocaleList;", "suggestSelectionForLongPressOrDoubleClick", "Landroidx/compose/ui/text/TextRange;", "text", "", "selection", "suggestSelectionForLongPressOrDoubleClick-pYaCw-w", "(Ljava/lang/CharSequence;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onShowContextMenu", "", "onShowContextMenu-Sb-Bc2M", "classifyText", "textClassifier", "classifyText-M8tDOmk", "(Ljava/lang/CharSequence;JLandroid/view/textclassifier/TextClassifier;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AssistantItemKey", "", "addSmartSelectionTextContextMenuItems", "Landroidx/compose/foundation/text/contextmenu/builder/TextContextMenuBuilderScope;", "child", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "addSmartSelectionTextContextMenuItems-YmzfRxQ$foundation_release", "(Landroidx/compose/foundation/text/contextmenu/builder/TextContextMenuBuilderScope;Ljava/lang/CharSequence;JLkotlin/jvm/functions/Function1;)V", "tryGetTextClassification", "Landroid/view/textclassifier/TextClassification;", "tryGetTextClassification-FDrldGo", "(Ljava/lang/CharSequence;J)Landroid/view/textclassifier/TextClassification;", "requireTextClassificationSession", "T", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PlatformSelectionBehaviorsImpl implements PlatformSelectionBehaviors {
    public static final int $stable = 8;
    private final Object AssistantItemKey;
    private final Context context;
    private final CoroutineContext coroutineContext;
    private final LocaleList localeList;
    private final kotlinx.coroutines.sync.a mutex;
    private final SelectedTextType selectedTextType;
    private final MutableState textClassificationResult$delegate;
    private TextClassifier textClassificationSession;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2", f = "PlatformSelectionBehaviors.android.kt", i = {0, 1}, l = {351, 256, 265}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
    public static final class AnonymousClass2<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        final /* synthetic */ Function2<TextClassifier, Continuation<? super T>, Object> $block;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ PlatformSelectionBehaviorsImpl this$0;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2$1", f = "PlatformSelectionBehaviors.android.kt", i = {}, l = {266}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
            final /* synthetic */ Function2<TextClassifier, Continuation<? super T>, Object> $block;
            final /* synthetic */ TextClassifier $textClassificationSession;
            int label;

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(TextClassifier r1, Function2<? super TextClassifier, ? super Continuation<? super T>, ? extends Object> r2, Continuation<? super AnonymousClass1> r3) {
                this.$textClassificationSession = r1;
                this.$block = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new AnonymousClass1(this.$textClassificationSession, this.$block, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super T> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r4) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r4);
                return r4;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r4);
                TextClassifier r5 = this.$textClassificationSession;
                if (r5 == null) goto L13;
                Function2<TextClassifier, Continuation<? super T>, Object> r2 = this.$block;
                this.label = 1;
                Object r6 = r2.invoke(r5, this);
                if (r6 != r0) goto L16;
                return r0;
            L16:
                return r6;
            L13:
                return null;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(PlatformSelectionBehaviorsImpl r1, Function2<? super TextClassifier, ? super Continuation<? super T>, ? extends Object> r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$block = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.this$0, this.$block, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super T> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L16;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            ResultKt.throwOnFailure(r10);
        L32:
            return r10;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            kotlinx.coroutines.sync.a r2 = (kotlinx.coroutines.sync.a) this.L$0;
            ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L13
        L27:
            TextClassifier r4 = (TextClassifier) r10;     // Catch: Throwable -> L13
            kotlinx.coroutines.sync.a r11 = r2;
        L29:
            r11.unlock(null);
            AnonymousClass1 r12 = new AnonymousClass1(r4, this.$block, null);
            this.L$0 = null;
            this.L$1 = null;
            this.label = 3;
            r10 = TimeoutKt.c(200, r12, this);
            if (r10 != r0) goto L32;
            return r0;
        L13:
            Throwable th = th;
        L35:
            r2.unlock(null);
            throw th;
        L15:
            PlatformSelectionBehaviorsImpl r3 = (PlatformSelectionBehaviorsImpl) this.L$1;
            kotlinx.coroutines.sync.a r5 = (kotlinx.coroutines.sync.a) this.L$0;
            ResultKt.throwOnFailure(r10);
            r11 = r5;
        L37:
            r4 = PlatformSelectionBehaviorsImpl.access$getTextClassificationSession$p(r3);     // Catch: Throwable -> L33
            if (r4 != null) goto L22;
        L23:
            PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2$textClassificationSession$1$1 r6 = new PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2$textClassificationSession$1$1(r3, null);     // Catch: Throwable -> L33
            this.L$0 = r11;     // Catch: Throwable -> L33
            this.L$1 = null;     // Catch: Throwable -> L33
            this.label = 2;     // Catch: Throwable -> L33
            Object r7 = TimeoutKt.c(300, r6, this);     // Catch: Throwable -> L33
            if (r7 != r0) goto L26;
            return r0;
        L26:
            r2 = r11;
            r10 = r7;
            goto L27
        L22:
            if (r4.isDestroyed() == false) goto L29;
        L33:
            th = move-exception;
            r2 = r11;
            th = th;
            goto L35
        L16:
            ResultKt.throwOnFailure(r10);
            r11 = PlatformSelectionBehaviorsImpl.access$getMutex$p(this.this$0);
            r3 = this.this$0;
            this.L$0 = r11;
            this.L$1 = r3;
            this.label = 1;
            if (r11.a(null, this) != r0) goto L37;
            return r0;
        }
    }

    private final android.os.LocaleList getAndroidLocalList() {
        LocaleList r0 = this.localeList;
        if (r0 == null) goto L7;
        android.os.LocaleList r1 = TextClassifierHelperMethods.INSTANCE.toAndroidLocaleList(r0);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new android.os.LocaleList(new Locale[]{androidx.compose.ui.text.intl.Locale.Companion.getCurrent().getPlatformLocale()});
    }

    private final TextClassificationResult getTextClassificationResult() {
        return (TextClassificationResult) this.textClassificationResult$delegate.getValue();
    }

    public static final /* synthetic */ android.os.LocaleList access$getAndroidLocalList(PlatformSelectionBehaviorsImpl r0) {
        return r0.getAndroidLocalList();
    }

    public static final /* synthetic */ Context access$getContext$p(PlatformSelectionBehaviorsImpl r0) {
        return r0.context;
    }

    public static final /* synthetic */ kotlinx.coroutines.sync.a access$getMutex$p(PlatformSelectionBehaviorsImpl r0) {
        return r0.mutex;
    }

    public static final /* synthetic */ SelectedTextType access$getSelectedTextType$p(PlatformSelectionBehaviorsImpl r0) {
        return r0.selectedTextType;
    }

    public static final /* synthetic */ TextClassifier access$getTextClassificationSession$p(PlatformSelectionBehaviorsImpl r0) {
        return r0.textClassificationSession;
    }

    private final void setTextClassificationResult(TextClassificationResult r2) {
        this.textClassificationResult$delegate.setValue(r2);
    }

    public static final /* synthetic */ void access$setTextClassificationResult(PlatformSelectionBehaviorsImpl r0, TextClassificationResult r1) {
        r0.setTextClassificationResult(r1);
    }

    public static final /* synthetic */ void access$setTextClassificationSession$p(PlatformSelectionBehaviorsImpl r0, TextClassifier r1) {
        r0.textClassificationSession = r1;
    }

    private final <T> Object requireTextClassificationSession(Function2<? super TextClassifier, ? super Continuation<? super T>, ? extends Object> r4, Continuation<? super T> r5) {
        return BuildersKt.withContext(this.coroutineContext, new AnonymousClass2(this, r4, null), r5);
    }

    /* JADX INFO: renamed from: tryGetTextClassification-FDrldGo, reason: not valid java name */
    public final TextClassification m1841tryGetTextClassificationFDrldGo(CharSequence r3, long r4) {
        if (this.mutex.b(null) == true) goto L5;
        return null;
    L5:
        TextClassificationResult r0 = getTextClassificationResult();
        if (r0 == null) goto L10;
        boolean r5 = PlatformSelectionBehaviors_androidKt.m1842access$canReuseh5sm0ck(r0, r3, r4);
        boolean r6 = true;
        if (r5 != true) goto L10;
    L11:
        if (r6 == false) goto L13;
        TextClassification r7 = r0.getTextClassification();
    L14:
        this.mutex.unlock(null);
        return r7;
    L13:
        r7 = null;
    L10:
        r6 = false;
        goto L11
    }

    public static final /* synthetic */ Object access$requireTextClassificationSession(PlatformSelectionBehaviorsImpl r0, Function2 r1, Continuation r2) {
        return r0.requireTextClassificationSession(r1, r2);
    }

    @Override // androidx.compose.foundation.text.selection.PlatformSelectionBehaviors
    /* JADX INFO: renamed from: onShowContextMenu-Sb-Bc2M */
    public Object mo1836onShowContextMenuSbBc2M(CharSequence r8, long r9, Continuation<? super Unit> r11) {
        if (r8.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L13;
        if (TextRange.getCollapsed-impl(r9) == true) goto L13;
        return requireTextClassificationSession(new PlatformSelectionBehaviorsImpl$onShowContextMenu$2(this, r8, r9, null), r11);
    L13:
        return Unit.INSTANCE;
    L5:
        r0 = false;
        goto L6
    }

    @Override // androidx.compose.foundation.text.selection.PlatformSelectionBehaviors
    /* JADX INFO: renamed from: suggestSelectionForLongPressOrDoubleClick-pYaCw-w */
    public Object mo1837suggestSelectionForLongPressOrDoubleClickpYaCww(CharSequence r8, long r9, Continuation<? super TextRange> r11) {
        if (r8.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return null;
    L8:
        if (TextRange.getCollapsed-impl(r9) == false) goto L11;
        return null;
    L11:
        return requireTextClassificationSession(new PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2(r8, r9, this, null), r11);
    L5:
        r0 = false;
        goto L6
    }

    public PlatformSelectionBehaviorsImpl(CoroutineContext r1, Context r2, SelectedTextType r3, LocaleList r4) {
        this.coroutineContext = r1;
        this.context = r2;
        this.selectedTextType = r3;
        this.localeList = r4;
        this.mutex = kotlinx.coroutines.sync.b.a();
        this.textClassificationResult$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.AssistantItemKey = new Object();
    }

    /* JADX INFO: renamed from: classifyText-M8tDOmk, reason: not valid java name */
    private final Object m1839classifyTextM8tDOmk(CharSequence r21, long r22, TextClassifier r24, Continuation<? super Unit> r25) {
        if ((r25 instanceof PlatformSelectionBehaviorsImpl$classifyText$1) == false) goto L7;
        PlatformSelectionBehaviorsImpl$classifyText$1 r2 = (PlatformSelectionBehaviorsImpl$classifyText$1) r25;
        int r3 = r2.label;
        if ((r3 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r2.label = r3 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r0 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        boolean r7 = true;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        long r6 = r2.J$0;
        kotlinx.coroutines.sync.a r8 = (kotlinx.coroutines.sync.a) r2.L$2;
        TextClassification r9 = (TextClassification) r2.L$1;
        CharSequence r10 = (CharSequence) r2.L$0;
        ResultKt.throwOnFailure(r0);
        CharSequence r13 = r10;
        long r14 = r6;
        TextClassification r16 = r9;
    L44:
        setTextClassificationResult(new TextClassificationResult(r13, r14, r16, null));     // Catch: Throwable -> L38
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L38
        r8.unlock(null);
        return Unit.INSTANCE;
    L38:
        th = move-exception;
        r8.unlock(null);
        throw th;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r11 = r2.J$0;
        kotlinx.coroutines.sync.a r12 = (kotlinx.coroutines.sync.a) r2.L$2;
        TextClassifier r15 = (TextClassifier) r2.L$1;
        CharSequence r17 = (CharSequence) r2.L$0;
        ResultKt.throwOnFailure(r0);
    L46:
        TextClassificationResult r18 = getTextClassificationResult();     // Catch: Throwable -> L41
        if (r18 != null) goto L23;
    L25:
        r7 = false;
    L26:
        if (r7 == false) goto L30;
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L41
        r12.unlock(null);
        return r19;
    L30:
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L41
        r12.unlock(null);
        TextClassification r23 = r15.classifyText(new TextClassification.Request.Builder(r17, TextRange.getMin-impl(r11), TextRange.getMax-impl(r11)).setDefaultLocales(getAndroidLocalList()).build());
        kotlinx.coroutines.sync.a r26 = this.mutex;
        r2.L$0 = r17;
        r2.L$1 = r23;
        r2.L$2 = r26;
        r2.J$0 = r11;
        r2.label = 2;
        if (r26.a(null, r2) != r4) goto L34;
        return r4;
    L34:
        r8 = r26;
        r16 = r23;
        r14 = r11;
        r13 = r17;
        goto L44
    L23:
        if (PlatformSelectionBehaviors_androidKt.m1842access$canReuseh5sm0ck(r18, r17, r11) != true) goto L25;
    L41:
        th = move-exception;
        r12.unlock(null);
        throw th;
    L16:
        ResultKt.throwOnFailure(r0);
        r12 = this.mutex;
        r2.L$0 = r21;
        r2.L$1 = r24;
        r2.L$2 = r12;
        r2.J$0 = r22;
        r2.label = 1;
        if (r12.a(null, r2) != r4) goto L19;
        return r4;
    L19:
        r17 = r21;
        r15 = r24;
        r11 = r22;
    L7:
        r2 = new PlatformSelectionBehaviorsImpl$classifyText$1(this, r25);
        goto L8
    }

    /* JADX INFO: renamed from: addSmartSelectionTextContextMenuItems-YmzfRxQ$foundation_release, reason: not valid java name */
    public final void m1840addSmartSelectionTextContextMenuItemsYmzfRxQ$foundation_release(TextContextMenuBuilderScope r2, CharSequence r3, long r4, Function1<? super TextContextMenuBuilderScope, Unit> r6) {
        TextClassification r5 = m1841tryGetTextClassificationFDrldGo(r3, r4);
        if (r5 != null) goto L6;
        r6.invoke(r2);
        return;
    L6:
        int r7 = 0;
        if ((!r5.getActions().isEmpty()) == false) goto L10;
        TextContextMenuBuilderScope_androidKt.textClassificationItem(r2, this.AssistantItemKey, r5, 0);
    L12:
        r6.invoke(r2);
        List<RemoteAction> r8 = r5.getActions();
        int r9 = r8.size();
    L13:
        if (r7 >= r9) goto L18;
        RemoteAction r0 = (RemoteAction) ListProtector.get(r8, r7);
        if (r7 <= 0) goto L17;
        TextContextMenuBuilderScope_androidKt.textClassificationItem(r2, this.AssistantItemKey, r5, r7);
    L17:
        r7 = r7 + 1;
        goto L13
    L18:
        return;
    L10:
        if (TextClassifierHelperMethods.INSTANCE.hasLegacyAssistItem$foundation_release(r5) == false) goto L12;
        TextContextMenuBuilderScope_androidKt.textClassificationItem(r2, this.AssistantItemKey, r5, -1);
        goto L12
    }

    /* JADX INFO: renamed from: access$classifyText-M8tDOmk, reason: not valid java name */
    public static final /* synthetic */ Object m1838access$classifyTextM8tDOmk(PlatformSelectionBehaviorsImpl r0, CharSequence r1, long r2, TextClassifier r4, Continuation r5) {
        return r0.m1839classifyTextM8tDOmk(r1, r2, r4, r5);
    }
}
