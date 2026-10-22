package androidx.compose.material3;

import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.SearchBarDefaults$InputField$9$1", f = "SearchBar.kt", i = {}, l = {1442}, m = "invokeSuspend", n = {}, s = {})
public final class SearchBarDefaults$InputField$9$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ State<Boolean> $focused$delegate;
    final /* synthetic */ SearchBarState $searchBarState;
    final /* synthetic */ TextFieldState $textFieldState;
    int label;

    /* JADX INFO: renamed from: androidx.compose.material3.SearchBarDefaults$InputField$9$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.SearchBarDefaults$InputField$9$1$2", f = "SearchBar.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CharSequence, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineScope $coroutineScope;
        final /* synthetic */ State<Boolean> $focused$delegate;
        final /* synthetic */ Ref.IntRef $prevLength;
        final /* synthetic */ SearchBarState $searchBarState;
        /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.material3.SearchBarDefaults$InputField$9$1$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.material3.SearchBarDefaults$InputField$9$1$2$1", f = "SearchBar.kt", i = {}, l = {1438}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ SearchBarState $searchBarState;
            int label;

            public AnonymousClass1(SearchBarState r1, Continuation<? super AnonymousClass1> r2) {
                this.$searchBarState = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new AnonymousClass1(this.$searchBarState, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r4) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r4);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r4);
                SearchBarState r5 = this.$searchBarState;
                this.label = 1;
                if (r5.animateToExpanded(this) != r0) goto L12;
                return r0;
            }
        }

        public AnonymousClass2(Ref.IntRef r1, SearchBarState r2, CoroutineScope r3, State<Boolean> r4, Continuation<? super AnonymousClass2> r5) {
            this.$prevLength = r1;
            this.$searchBarState = r2;
            this.$coroutineScope = r3;
            this.$focused$delegate = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            AnonymousClass2 r6 = new AnonymousClass2(this.$prevLength, this.$searchBarState, this.$coroutineScope, this.$focused$delegate, r9);
            r6.L$0 = r8;
            return r6;
        }

        public final Object invoke(CharSequence r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CharSequence) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r8) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L14;
            ResultKt.throwOnFailure(r8);
            int r9 = ((CharSequence) this.L$0).length();
            if (r9 > this.$prevLength.element) goto L7;
        L11:
            this.$prevLength.element = r9;
            return Unit.INSTANCE;
        L7:
            if (SearchBarDefaults.access$InputField$lambda$5(this.$focused$delegate) == false) goto L11;
            if (SearchBarKt.access$isExpanded(this.$searchBarState) == true) goto L11;
            BuildersKt.launch$default(this.$coroutineScope, null, null, new AnonymousClass1(this.$searchBarState, null), 3, null);
            goto L11
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public SearchBarDefaults$InputField$9$1(SearchBarState r1, TextFieldState r2, CoroutineScope r3, State<Boolean> r4, Continuation<? super SearchBarDefaults$InputField$9$1> r5) {
        this.$searchBarState = r1;
        this.$textFieldState = r2;
        this.$coroutineScope = r3;
        this.$focused$delegate = r4;
        super(2, r5);
    }

    public static /* synthetic */ CharSequence a(TextFieldState r0) {
        return invokeSuspend$lambda$0(r0);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new SearchBarDefaults$InputField$9$1(this.$searchBarState, this.$textFieldState, this.$coroutineScope, this.$focused$delegate, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    private static final CharSequence invokeSuspend$lambda$0(TextFieldState r0) {
        return r0.getText();
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L17:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        if (SearchBarKt.access$isExpanded(this.$searchBarState) == true) goto L17;
        Ref.IntRef r4 = new Ref.IntRef();
        r4.element = this.$textFieldState.getText().length();
        final TextFieldState r11 = this.$textFieldState;
        Flow r12 = SnapshotStateKt.snapshotFlow(new sl(r11));
        AnonymousClass2 r2 = new AnonymousClass2(r4, this.$searchBarState, this.$coroutineScope, this.$focused$delegate, null);
        FlowCollector r3 = AnonymousClass3.INSTANCE;
        this.label = 1;
        Object r13 = r12.collect(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1.2(r3, r2), this);
        if (r13 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        r13 = Unit.INSTANCE;
    L14:
        if (r13 != r0) goto L17;
        return r0;
    }
}
