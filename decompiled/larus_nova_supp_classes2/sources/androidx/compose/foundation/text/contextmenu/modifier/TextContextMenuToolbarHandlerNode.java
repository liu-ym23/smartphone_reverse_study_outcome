package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.foundation.text.contextmenu.data.TextContextMenuData;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProviderKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003Be\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001e\u0010\u0006\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0007\u0012\u001e\u0010\u000b\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0007\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010'\u001a\u00020\tH\u0016J\b\u0010(\u001a\u00020\tH\u0016J\u0006\u0010)\u001a\u00020\tJ\u0006\u0010*\u001a\u00020\tJ\u0017\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\rH\u0016¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\rH\u0016J\b\u00101\u001a\u00020!H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R4\u0010\u0006\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R4\u0010\u000b\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0016\"\u0004\b\u001d\u0010\u0018R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u000e\u0010&\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Landroidx/compose/foundation/text/contextmenu/modifier/TextContextMenuToolbarHandlerNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuDataProvider;", "requester", "Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", "onShow", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "onHide", "computeContentBounds", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/geometry/Rect;", "<init>", "(Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getRequester", "()Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", "setRequester", "(Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;)V", "getOnShow", "()Lkotlin/jvm/functions/Function1;", "setOnShow", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function1;", "getOnHide", "setOnHide", "getComputeContentBounds", "setComputeContentBounds", "textToolbarJob", "Lkotlinx/coroutines/Job;", "derivedData", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuData;", "getDerivedData", "()Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuData;", "derivedData$delegate", "Landroidx/compose/runtime/State;", "previousContentBounds", "onAttach", "onDetach", "show", "hide", "position", "Landroidx/compose/ui/geometry/Offset;", "destinationCoordinates", "position-tuRUvjQ", "(Landroidx/compose/ui/layout/LayoutCoordinates;)J", "contentBounds", "data", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextContextMenuToolbarHandlerNode extends DelegatingNode implements CompositionLocalConsumerModifierNode, TextContextMenuDataProvider {
    public static final int $stable = 8;
    private Function1<? super LayoutCoordinates, Rect> computeContentBounds;
    private final State derivedData$delegate;
    private Function1<? super Continuation<? super Unit>, ? extends Object> onHide;
    private Function1<? super Continuation<? super Unit>, ? extends Object> onShow;
    private Rect previousContentBounds;
    private ToolbarRequester requester;
    private Job textToolbarJob;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuToolbarHandlerNode$show$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuToolbarHandlerNode$show$1", f = "TextContextMenuToolbarHandlerModifier.kt", i = {}, l = {182, 183, 185, 185}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TextContextMenuProvider $provider;
        Object L$0;
        int label;
        final /* synthetic */ TextContextMenuToolbarHandlerNode this$0;

        public AnonymousClass1(TextContextMenuToolbarHandlerNode r1, TextContextMenuProvider r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$provider = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$provider, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L17;
            if (r1 == 1) goto L13;
            if (r1 == 2) goto L12;
            if (r1 == 3) goto L11;
            if (r1 != 4) goto L9;
            Throwable r2 = (Throwable) this.L$0;
            ResultKt.throwOnFailure(r7);
        L40:
            throw r2;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r7);
        L32:
            return Unit.INSTANCE;
        L12:
            ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L15
        L26:
            Function1<Continuation<? super Unit>, Object> r8 = this.this$0.getOnHide();
            if (r8 == null) goto L32;
            this.label = 3;
            if (r8.invoke(this) != r0) goto L32;
            return r0;
        L13:
            ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L15
        L23:
            TextContextMenuProvider r9 = this.$provider;     // Catch: Throwable -> L15
            TextContextMenuToolbarHandlerNode r3 = this.this$0;     // Catch: Throwable -> L15
            this.label = 2;     // Catch: Throwable -> L15
            if (r9.showTextContextMenu(r3, this) != r0) goto L26;
            return r0;
        L17:
            ResultKt.throwOnFailure(r7);
            Function1<Continuation<? super Unit>, Object> r10 = this.this$0.getOnShow();     // Catch: Throwable -> L15
            if (r10 == null) goto L23;
            this.label = 1;     // Catch: Throwable -> L15
            if (r10.invoke(this) != r0) goto L23;
            return r0;
        L15:
            th = move-exception;
            Function1<Continuation<? super Unit>, Object> r4 = this.this$0.getOnHide();
            if (r4 == null) goto L42;
            this.L$0 = th;
            this.label = 4;
            if (r4.invoke(this) != r0) goto L38;
            return r0;
        L38:
            r2 = th;
            goto L40
        L42:
            throw th;
        }
    }

    public static /* synthetic */ TextContextMenuData a(TextContextMenuToolbarHandlerNode r0) {
        return derivedData_delegate$lambda$0(r0);
    }

    private final TextContextMenuData getDerivedData() {
        return (TextContextMenuData) this.derivedData$delegate.getValue();
    }

    public final void hide() {
        Job r0 = this.textToolbarJob;
        if (r0 != null) goto L5;
        return;
    L5:
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
        this.textToolbarJob = null;
    }

    public void onDetach() {
        this.requester.setToolbarHandlerNode$foundation_release(null);
        super/*androidx.compose.ui.Modifier.Node*/.onDetach();
    }

    @Override // androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider
    public TextContextMenuData data() {
        return getDerivedData();
    }

    public void onAttach() {
        super/*androidx.compose.ui.Modifier.Node*/.onAttach();
        this.requester.setToolbarHandlerNode$foundation_release(this);
    }

    public final void show() {
        if (isAttached() == false) goto L16;
        Job r0 = this.textToolbarJob;
        boolean r1 = false;
        if (r0 != null) goto L7;
    L9:
        if (r1 == true) goto L17;
        TextContextMenuProvider r2 = (TextContextMenuProvider) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, TextContextMenuProviderKt.getLocalTextContextMenuToolbarProvider());
        if (r2 != null) goto L14;
        return;
    L14:
        this.textToolbarJob = BuildersKt.launch$default(getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(this, r2, null), 1, null);
        return;
    L17:
        return;
    L7:
        if (r0.isActive() != true) goto L9;
        r1 = true;
        goto L9
    }

    public final Function1<LayoutCoordinates, Rect> getComputeContentBounds() {
        return this.computeContentBounds;
    }

    public final Function1<Continuation<? super Unit>, Object> getOnHide() {
        return this.onHide;
    }

    public final Function1<Continuation<? super Unit>, Object> getOnShow() {
        return this.onShow;
    }

    public final ToolbarRequester getRequester() {
        return this.requester;
    }

    private static final TextContextMenuData derivedData_delegate$lambda$0(TextContextMenuToolbarHandlerNode r1) {
        if (r1.isAttached() == false) goto L6;
        return TextContextMenuModifierKt.collectTextContextMenuData(r1);
    L6:
        return TextContextMenuData.Companion.getEmpty();
    }

    @Override // androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider
    public Rect contentBounds(LayoutCoordinates r2) {
        if (isAttached() == false) goto L5;
        Rect r3 = (Rect) this.computeContentBounds.invoke(r2);
        if (r3 == null) goto L9;
        this.previousContentBounds = r3;
        return r3;
    L9:
        return this.previousContentBounds;
    L5:
        return this.previousContentBounds;
    }

    @Override // androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider
    /* JADX INFO: renamed from: position-tuRUvjQ */
    public long mo1513positiontuRUvjQ(LayoutCoordinates r3) {
        return contentBounds(r3).getTopLeft-F1C5BW0();
    }

    public final void setComputeContentBounds(Function1<? super LayoutCoordinates, Rect> r1) {
        this.computeContentBounds = r1;
    }

    public final void setOnHide(Function1<? super Continuation<? super Unit>, ? extends Object> r1) {
        this.onHide = r1;
    }

    public final void setOnShow(Function1<? super Continuation<? super Unit>, ? extends Object> r1) {
        this.onShow = r1;
    }

    public final void setRequester(ToolbarRequester r1) {
        this.requester = r1;
    }

    public TextContextMenuToolbarHandlerNode(ToolbarRequester r1, Function1<? super Continuation<? super Unit>, ? extends Object> r2, Function1<? super Continuation<? super Unit>, ? extends Object> r3, Function1<? super LayoutCoordinates, Rect> r4) {
        this.requester = r1;
        this.onShow = r2;
        this.onHide = r3;
        this.computeContentBounds = r4;
        this.derivedData$delegate = SnapshotStateKt.derivedStateOf(new d(this));
        this.previousContentBounds = Rect.Companion.getZero();
    }
}
