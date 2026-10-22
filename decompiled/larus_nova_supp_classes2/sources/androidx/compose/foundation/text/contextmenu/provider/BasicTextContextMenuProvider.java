package androidx.compose.foundation.text.contextmenu.provider;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u00002\u00020\u0001:\u0001!B_\u0012V\u0010\u0002\u001aR\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0003¢\u0006\u0002\b\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u001c\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u001dJ\u001b\u0010\u001e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007¢\u0006\u0002\u0010\u001fJ\u0006\u0010 \u001a\u00020\rR`\u0010\u0002\u001aR\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0003¢\u0006\u0002\b\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\u0007\u001a\b\u0018\u00010\u0015R\u00020\u00002\f\u0010\u0014\u001a\b\u0018\u00010\u0015R\u00020\u00008B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\""}, d2 = {"Landroidx/compose/foundation/text/contextmenu/provider/BasicTextContextMenuProvider;", "Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuProvider;", "contextMenuBlock", "Lkotlin/Function3;", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuSession;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "session", "Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuDataProvider;", "dataProvider", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "anchorLayoutCoordinates", "", "Landroidx/compose/runtime/Composable;", "<init>", "(Lkotlin/jvm/functions/Function5;)V", "Lkotlin/jvm/functions/Function5;", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "<set-?>", "Landroidx/compose/foundation/text/contextmenu/provider/BasicTextContextMenuProvider$SessionImpl;", "getSession", "()Landroidx/compose/foundation/text/contextmenu/provider/BasicTextContextMenuProvider$SessionImpl;", "setSession", "(Landroidx/compose/foundation/text/contextmenu/provider/BasicTextContextMenuProvider$SessionImpl;)V", "session$delegate", "Landroidx/compose/runtime/MutableState;", "showTextContextMenu", "(Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuDataProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ContextMenu", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "cancel", "SessionImpl", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BasicTextContextMenuProvider implements TextContextMenuProvider {
    public static final int $stable = 0;
    private final Function5<TextContextMenuSession, TextContextMenuDataProvider, Function0<? extends LayoutCoordinates>, Composer, Integer, Unit> contextMenuBlock;
    private final MutatorMutex mutatorMutex;
    private final MutableState session$delegate;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\nH\u0016J\u000e\u0010\f\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/compose/foundation/text/contextmenu/provider/BasicTextContextMenuProvider$SessionImpl;", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuSession;", "dataProvider", "Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuDataProvider;", "<init>", "(Landroidx/compose/foundation/text/contextmenu/provider/BasicTextContextMenuProvider;Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuDataProvider;)V", "getDataProvider", "()Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuDataProvider;", "channel", "Lkotlinx/coroutines/channels/Channel;", "", "close", "awaitClose", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class SessionImpl implements TextContextMenuSession {
        private final Channel<Unit> channel;
        private final TextContextMenuDataProvider dataProvider;
        final /* synthetic */ BasicTextContextMenuProvider this$0;

        @Override // androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession
        public void close() {
            this.channel.trySend-JP2dKIU(Unit.INSTANCE);
        }

        public final TextContextMenuDataProvider getDataProvider() {
            return this.dataProvider;
        }

        public final Object awaitClose(Continuation<? super Unit> r2) {
            Object r3 = this.channel.receive(r2);
            if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r3;
        L6:
            return Unit.INSTANCE;
        }

        public SessionImpl(BasicTextContextMenuProvider r2, TextContextMenuDataProvider r3) {
            this.this$0 = r2;
            this.dataProvider = r3;
            this.channel = ChannelKt.Channel$default(0, null, null, 7, null);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProvider$showTextContextMenu$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProvider$showTextContextMenu$2", f = "BasicTextContextMenuProvider.kt", i = {}, l = {130}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ SessionImpl $localSession;
        int label;
        final /* synthetic */ BasicTextContextMenuProvider this$0;

        public AnonymousClass2(BasicTextContextMenuProvider r1, SessionImpl r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$localSession = r2;
            super(1, r3);
        }

        public final Continuation<Unit> create(Continuation<?> r4) {
            return new AnonymousClass2(this.this$0, this.$localSession, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super Unit> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L7
        L15:
            BasicTextContextMenuProvider.access$setSession(this.this$0, null);
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r5);
            BasicTextContextMenuProvider.access$setSession(this.this$0, this.$localSession);     // Catch: Throwable -> L7
            SessionImpl r6 = this.$localSession;     // Catch: Throwable -> L7
            this.label = 1;     // Catch: Throwable -> L7
            if (r6.awaitClose(this) != r0) goto L15;
            return r0;
        L7:
            th = move-exception;
            BasicTextContextMenuProvider.access$setSession(this.this$0, null);
            throw th;
        }
    }

    private static final Unit ContextMenu$lambda$0(BasicTextContextMenuProvider r0, Function0 r1, int r2, Composer r3, int r4) {
        r0.ContextMenu(r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit ContextMenu$lambda$1(BasicTextContextMenuProvider r0, Function0 r1, int r2, Composer r3, int r4) {
        r0.ContextMenu(r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(BasicTextContextMenuProvider r0, Function0 r1, int r2, Composer r3, int r4) {
        return ContextMenu$lambda$0(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit b(BasicTextContextMenuProvider r0, Function0 r1, int r2, Composer r3, int r4) {
        return ContextMenu$lambda$1(r0, r1, r2, r3, r4);
    }

    private final SessionImpl getSession() {
        return (SessionImpl) this.session$delegate.getValue();
    }

    public final void cancel() {
        SessionImpl r0 = getSession();
        if (r0 == null) goto L6;
        r0.close();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BasicTextContextMenuProvider(Function5<? super TextContextMenuSession, ? super TextContextMenuDataProvider, ? super Function0<? extends LayoutCoordinates>, ? super Composer, ? super Integer, Unit> r2) {
        this.contextMenuBlock = r2;
        this.mutatorMutex = new MutatorMutex();
        this.session$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    }

    private final void setSession(SessionImpl r2) {
        this.session$delegate.setValue(r2);
    }

    public static final /* synthetic */ void access$setSession(BasicTextContextMenuProvider r0, SessionImpl r1) {
        r0.setSession(r1);
    }

    @Override // androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProvider
    public Object showTextContextMenu(TextContextMenuDataProvider r8, Continuation<? super Unit> r9) {
        SessionImpl r0 = new SessionImpl(this, r8);
        Object r10 = MutatorMutex.mutate$default(this.mutatorMutex, null, new AnonymousClass2(this, r0, null), r9, 1, null);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r10;
    L6:
        return Unit.INSTANCE;
    }

    public final void ContextMenu(final Function0<? extends LayoutCoordinates> r8, Composer r9, final int r10) {
        Composer r11 = r9.startRestartGroup(723898654);
        if ((r10 & 6) == 0) goto L5;
        int r1 = r10;
    L11:
        if ((r10 & 48) != 0) goto L18;
        if (r11.changed(this) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r1 & 19) == 18) goto L20;
        boolean r3 = true;
    L22:
        if (r11.shouldExecute(r3, r1 & 1) == true) goto L24;
        r11.skipToGroupEnd();
    L39:
        ScopeUpdateScope r12 = r11.endRestartGroup();
        if (r12 == null) goto L44;
        r12.updateScope(new b(this, r8, r10));
        return;
    L44:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(723898654, r1, -1, "androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProvider.ContextMenu (BasicTextContextMenuProvider.kt:137)");
    L26:
        SessionImpl r4 = getSession();
        if (r4 == null) goto L29;
        this.contextMenuBlock.invoke(r4, r4.getDataProvider(), r8, r11, Integer.valueOf((r1 << 6) & 896));
        if (ComposerKt.isTraceInProgress() == false) goto L39;
        ComposerKt.traceEventEnd();
        goto L39
    L29:
        if (ComposerKt.isTraceInProgress() == false) goto L31;
        ComposerKt.traceEventEnd();
    L31:
        ScopeUpdateScope r13 = r11.endRestartGroup();
        if (r13 == null) goto L43;
        r13.updateScope(new a(this, r8, r10));
        return;
    L43:
        return;
    L20:
        r3 = false;
        goto L22
    L5:
        if (r11.changedInstance(r8) == false) goto L7;
        int r5 = 4;
    L8:
        r1 = r5 | r10;
        goto L11
    L7:
        r5 = 2;
        goto L8
    }
}
