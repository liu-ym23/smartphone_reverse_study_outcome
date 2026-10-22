package androidx.compose.foundation.text.contextmenu.internal;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuComponent;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuData;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuItem;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSeparator;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuTextClassificationItem;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProvider;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0001\u0018\u00002\u00020\u0001:\u0002-.B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u0012J\u0006\u0010\u001d\u001a\u00020\u0012J\u0018\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010%\u001a\u00020$2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002JK\u0010&\u001a\u0002H'\"\b\b\u0000\u0010'*\u00020\u0011\"\b\b\u0001\u0010(*\u00020\u00112\u0006\u0010)\u001a\u0002H(2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u00020\u00120\u00052\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H'0\bH\u0002¢\u0006\u0002\u0010,R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Landroidx/compose/foundation/text/contextmenu/internal/AndroidTextContextMenuToolbarProvider;", "Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuProvider;", "view", "Landroid/view/View;", "callbackInjector", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/contextmenu/internal/TextActionModeCallback;", "coordinatesProvider", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "snapshotStateObserver", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "onDataChange", "", "", "onPositionChange", "actionMode", "Landroid/view/ActionMode;", "startActionModeRunnable", "Ljava/lang/Runnable;", "showTextContextMenu", "dataProvider", "Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuDataProvider;", "(Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuDataProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "start", "dispose", "createActionModeCallback", "session", "Landroidx/compose/foundation/text/contextmenu/internal/AndroidTextContextMenuToolbarProvider$TextContextMenuSessionImpl;", "observeAndGetData", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuData;", "observeAndGetBounds", "Landroidx/compose/ui/geometry/Rect;", "calculateBoundsInRoot", "observeReadsAndGet", "T", "S", "scope", "onValueChanged", "block", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "TextActionModeCallbackImpl", "TextContextMenuSessionImpl", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidTextContextMenuToolbarProvider implements TextContextMenuProvider {
    public static final int $stable = 8;
    private ActionMode actionMode;
    private final Function1<TextActionModeCallback, TextActionModeCallback> callbackInjector;
    private final Function0<LayoutCoordinates> coordinatesProvider;
    private final MutatorMutex mutatorMutex;
    private final Function1<Object, Unit> onDataChange;
    private final Function1<Object, Unit> onPositionChange;
    private final SnapshotStateObserver snapshotStateObserver;
    private Runnable startActionModeRunnable;
    private final View view;

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/text/contextmenu/internal/AndroidTextContextMenuToolbarProvider$TextActionModeCallbackImpl;", "Landroidx/compose/foundation/text/contextmenu/internal/TextActionModeCallback;", "session", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuSession;", "dataBuilder", "Lkotlin/Function0;", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuData;", "positioner", "Landroidx/compose/ui/geometry/Rect;", "view", "Landroid/view/View;", "<init>", "(Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuSession;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroid/view/View;)V", "previousData", "onGetContentRect", "mode", "Landroid/view/ActionMode;", "onCreateActionMode", "", "menu", "Landroid/view/Menu;", "onPrepareActionMode", "onActionItemClicked", "item", "Landroid/view/MenuItem;", "onDestroyActionMode", "", "updateMenuItems", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class TextActionModeCallbackImpl implements TextActionModeCallback {
        private final Function0<TextContextMenuData> dataBuilder;
        private Function0<Rect> positioner;
        private TextContextMenuData previousData;
        private final TextContextMenuSession session;
        private final View view;

        public static /* synthetic */ boolean a(TextContextMenuComponent r0, TextActionModeCallbackImpl r1, MenuItem r2) {
            return updateMenuItems$lambda$2$lambda$1(r0, r1, r2);
        }

        @Override // androidx.compose.foundation.text.contextmenu.internal.TextActionModeCallback
        public boolean onActionItemClicked(ActionMode r1, MenuItem r2) {
            return false;
        }

        private final boolean updateMenuItems(Menu r13) {
            TextContextMenuData r0 = (TextContextMenuData) this.dataBuilder.invoke();
            int r2 = 0;
            if (Intrinsics.areEqual(r0, this.previousData) == false) goto L5;
            return false;
        L5:
            r13.clear();
            List<TextContextMenuComponent> r1 = r0.getComponents();
            int r3 = r1.size();
            int r6 = 1;
            int r10 = 1;
        L6:
            if (r2 >= r3) goto L19;
            final TextContextMenuComponent r4 = (TextContextMenuComponent) ListProtector.get(r1, r2);
            if ((r4 instanceof TextContextMenuItem) == false) goto L11;
            int r5 = r6 + 1;
            MenuItem r7 = r13.add(r10, r6, r6, ((TextContextMenuItem) r4).getLabel());
            r7.setShowAsAction(2);
            r7.setOnMenuItemClickListener(new j(r4, this));
            r6 = r5;
        L18:
            r2 = r2 + 1;
            goto L6
        L11:
            if ((r4 instanceof TextContextMenuTextClassificationItem) == false) goto L16;
            if (Build.VERSION.SDK_INT < 28) goto L18;
            TextContextMenuTextClassificationItem r8 = (TextContextMenuTextClassificationItem) r4;
            TextToolbarHelperApi28.INSTANCE.addMenuItem(r13, r6, this.view.getContext(), r8.getTextClassification(), r8.getIndex());
            r6 = r6 + 1;
            goto L18
        L16:
            if ((r4 instanceof TextContextMenuSeparator) == false) goto L18;
            r10 = r10 + 1;
            goto L18
        L19:
            return true;
        }

        @Override // androidx.compose.foundation.text.contextmenu.internal.TextActionModeCallback
        public void onDestroyActionMode(ActionMode r1) {
            this.session.close();
        }

        @Override // androidx.compose.foundation.text.contextmenu.internal.TextActionModeCallback
        public boolean onCreateActionMode(ActionMode r1, Menu r2) {
            updateMenuItems(r2);
            if (r2.size() <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.compose.foundation.text.contextmenu.internal.TextActionModeCallback
        public Rect onGetContentRect(ActionMode r1, View r2) {
            return (Rect) this.positioner.invoke();
        }

        @Override // androidx.compose.foundation.text.contextmenu.internal.TextActionModeCallback
        public boolean onPrepareActionMode(ActionMode r1, Menu r2) {
            return updateMenuItems(r2);
        }

        private static final boolean updateMenuItems$lambda$2$lambda$1(TextContextMenuComponent r0, TextActionModeCallbackImpl r1, MenuItem r2) {
            ((TextContextMenuItem) r0).getOnClick().invoke(r1.session);
            return true;
        }

        public TextActionModeCallbackImpl(TextContextMenuSession r1, Function0<TextContextMenuData> r2, Function0<Rect> r3, View r4) {
            this.session = r1;
            this.dataBuilder = r2;
            this.positioner = r3;
            this.view = r4;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u000e\u0010\b\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010\tR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/compose/foundation/text/contextmenu/internal/AndroidTextContextMenuToolbarProvider$TextContextMenuSessionImpl;", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuSession;", "<init>", "()V", "channel", "Lkotlinx/coroutines/channels/Channel;", "", "close", "awaitClose", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class TextContextMenuSessionImpl implements TextContextMenuSession {
        private final Channel<Unit> channel;

        @Override // androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession
        public void close() {
            this.channel.trySend-JP2dKIU(Unit.INSTANCE);
        }

        public TextContextMenuSessionImpl() {
            this.channel = ChannelKt.Channel$default(0, null, null, 7, null);
        }

        public final Object awaitClose(Continuation<? super Unit> r2) {
            Object r3 = this.channel.receive(r2);
            if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r3;
        L6:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider$showTextContextMenu$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider$showTextContextMenu$2", f = "AndroidTextContextMenuToolbarProvider.android.kt", i = {}, l = {180}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ TextContextMenuDataProvider $dataProvider;
        int label;
        final /* synthetic */ AndroidTextContextMenuToolbarProvider this$0;

        public AnonymousClass2(AndroidTextContextMenuToolbarProvider r1, TextContextMenuDataProvider r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$dataProvider = r2;
            super(1, r3);
        }

        public static /* synthetic */ void a(AndroidTextContextMenuToolbarProvider r0, TextActionModeCallback r1, TextContextMenuSessionImpl r2) {
            invokeSuspend$lambda$1(r0, r1, r2);
        }

        public final Continuation<Unit> create(Continuation<?> r4) {
            return new AnonymousClass2(this.this$0, this.$dataProvider, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super Unit> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L7
        L28:
            AndroidTextContextMenuToolbarProvider.access$getSnapshotStateObserver$p(this.this$0).clear();
            ActionMode r9 = AndroidTextContextMenuToolbarProvider.access$getActionMode$p(this.this$0);
            if (r9 == null) goto L31;
            r9.finish();
        L31:
            Runnable r10 = AndroidTextContextMenuToolbarProvider.access$getStartActionModeRunnable$p(this.this$0);
            if (r10 == null) goto L34;
            Boxing.boxBoolean(AndroidTextContextMenuToolbarProvider.access$getView$p(this.this$0).removeCallbacks(r10));
        L34:
            AndroidTextContextMenuToolbarProvider.access$setActionMode$p(this.this$0, null);
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r8);
            final TextContextMenuSessionImpl r11 = new TextContextMenuSessionImpl();
            final TextActionModeCallback r2 = AndroidTextContextMenuToolbarProvider.access$createActionModeCallback(this.this$0, r11, this.$dataProvider);
            Looper r4 = Looper.myLooper();
            Handler r5 = AndroidTextContextMenuToolbarProvider.access$getView$p(this.this$0).getHandler();
            if (r5 == null) goto L14;
            Looper r6 = r5.getLooper();
        L15:
            if (r4 == r6) goto L20;
            Runnable r7 = AndroidTextContextMenuToolbarProvider.access$getStartActionModeRunnable$p(this.this$0);
            if (r7 != null) goto L19;
            final AndroidTextContextMenuToolbarProvider r12 = this.this$0;
            Runnable r13 = new k(r12, r2, r11);
            AndroidTextContextMenuToolbarProvider.access$setStartActionModeRunnable$p(r12, r13);
            r7 = r13;
        L19:
            Boxing.boxBoolean(AndroidTextContextMenuToolbarProvider.access$getView$p(this.this$0).post(r7));
        L25:
            this.label = 1;     // Catch: Throwable -> L7
            if (r11.awaitClose(this) != r0) goto L28;
            return r0;
        L20:
            AndroidTextContextMenuToolbarProvider r14 = this.this$0;
            ActionMode r3 = TextToolbarHelper.INSTANCE.startActionMode(AndroidTextContextMenuToolbarProvider.access$getView$p(r14), r2);
            if (r3 == null) goto L23;
            AndroidTextContextMenuToolbarProvider.access$setActionMode$p(r14, r3);
            goto L25
        L23:
            return Unit.INSTANCE;
        L14:
            r6 = null;
        L7:
            th = move-exception;
            AndroidTextContextMenuToolbarProvider.access$getSnapshotStateObserver$p(this.this$0).clear();
            ActionMode r15 = AndroidTextContextMenuToolbarProvider.access$getActionMode$p(this.this$0);
            if (r15 == null) goto L39;
            r15.finish();
        L39:
            Runnable r16 = AndroidTextContextMenuToolbarProvider.access$getStartActionModeRunnable$p(this.this$0);
            if (r16 == null) goto L42;
            Boxing.boxBoolean(AndroidTextContextMenuToolbarProvider.access$getView$p(this.this$0).removeCallbacks(r16));
        L42:
            AndroidTextContextMenuToolbarProvider.access$setActionMode$p(this.this$0, null);
            throw th;
        }

        private static final void invokeSuspend$lambda$1(AndroidTextContextMenuToolbarProvider r2, TextActionModeCallback r3, TextContextMenuSessionImpl r4) {
            ActionMode r5 = TextToolbarHelper.INSTANCE.startActionMode(AndroidTextContextMenuToolbarProvider.access$getView$p(r2), r3);
            Intrinsics.areEqual(AndroidTextContextMenuToolbarProvider.access$getActionMode$p(r2), r5);
            if (r5 != null) goto L6;
            r4.close();
            return;
        }
    }

    public static /* synthetic */ Unit a(AndroidTextContextMenuToolbarProvider r0, Function0 r1) {
        return snapshotStateObserver$lambda$1(r0, r1);
    }

    public static /* synthetic */ TextContextMenuData b(AndroidTextContextMenuToolbarProvider r0, TextContextMenuDataProvider r1) {
        return createActionModeCallback$lambda$4(r0, r1);
    }

    public static /* synthetic */ Unit c(AndroidTextContextMenuToolbarProvider r0, Object r1) {
        return onDataChange$lambda$2(r0, r1);
    }

    public static /* synthetic */ void d(Function0 r0) {
        snapshotStateObserver$lambda$1$lambda$0(r0);
    }

    public static /* synthetic */ Unit e(AndroidTextContextMenuToolbarProvider r0, Object r1) {
        return onPositionChange$lambda$3(r0, r1);
    }

    public static /* synthetic */ TextContextMenuData f(TextContextMenuDataProvider r0) {
        return observeAndGetData$lambda$6(r0);
    }

    public static /* synthetic */ Rect g(AndroidTextContextMenuToolbarProvider r0, TextContextMenuDataProvider r1) {
        return observeAndGetBounds$lambda$7(r0, r1);
    }

    public static /* synthetic */ Unit h(Ref.ObjectRef r0, Function0 r1) {
        return observeReadsAndGet$lambda$8(r0, r1);
    }

    public static /* synthetic */ Rect i(AndroidTextContextMenuToolbarProvider r0, TextContextMenuDataProvider r1) {
        return createActionModeCallback$lambda$5(r0, r1);
    }

    public final void dispose() {
        this.snapshotStateObserver.stop();
        this.snapshotStateObserver.clear();
        ActionMode r0 = this.actionMode;
        if (r0 == null) goto L5;
        r0.finish();
    L5:
        this.actionMode = null;
    }

    public final void start() {
        this.snapshotStateObserver.start();
    }

    public static final /* synthetic */ ActionMode access$getActionMode$p(AndroidTextContextMenuToolbarProvider r0) {
        return r0.actionMode;
    }

    public static final /* synthetic */ SnapshotStateObserver access$getSnapshotStateObserver$p(AndroidTextContextMenuToolbarProvider r0) {
        return r0.snapshotStateObserver;
    }

    public static final /* synthetic */ Runnable access$getStartActionModeRunnable$p(AndroidTextContextMenuToolbarProvider r0) {
        return r0.startActionModeRunnable;
    }

    public static final /* synthetic */ View access$getView$p(AndroidTextContextMenuToolbarProvider r0) {
        return r0.view;
    }

    private final Rect calculateBoundsInRoot(TextContextMenuDataProvider r3) {
        LayoutCoordinates r0 = (LayoutCoordinates) this.coordinatesProvider.invoke();
        return r3.contentBounds(r0).translate-k-4lQ0M(LayoutCoordinatesKt.positionInRoot(r0));
    }

    private final Rect observeAndGetBounds(final TextContextMenuDataProvider r3) {
        return (Rect) observeReadsAndGet("positioner", this.onPositionChange, new b(this, r3));
    }

    private final TextContextMenuData observeAndGetData(final TextContextMenuDataProvider r3) {
        return (TextContextMenuData) observeReadsAndGet("dataBuilder", this.onDataChange, new h(r3));
    }

    private static final TextContextMenuData observeAndGetData$lambda$6(TextContextMenuDataProvider r0) {
        return r0.data();
    }

    private static final void snapshotStateObserver$lambda$1$lambda$0(Function0 r0) {
        r0.invoke();
    }

    public static final /* synthetic */ void access$setActionMode$p(AndroidTextContextMenuToolbarProvider r0, ActionMode r1) {
        r0.actionMode = r1;
    }

    public static final /* synthetic */ void access$setStartActionModeRunnable$p(AndroidTextContextMenuToolbarProvider r0, Runnable r1) {
        r0.startActionModeRunnable = r1;
    }

    private final TextActionModeCallback createActionModeCallback(TextContextMenuSessionImpl r4, final TextContextMenuDataProvider r5) {
        TextActionModeCallbackImpl r0 = new TextActionModeCallbackImpl(r4, new c(this, r5), new d(this, r5), this.view);
        Function1<TextActionModeCallback, TextActionModeCallback> r6 = this.callbackInjector;
        if (r6 == null) goto L9;
        TextActionModeCallback r7 = (TextActionModeCallback) r6.invoke(r0);
        if (r7 != null) goto L8;
        return r0;
    L8:
        return r7;
    L9:
        return r0;
    }

    private static final TextContextMenuData createActionModeCallback$lambda$4(AndroidTextContextMenuToolbarProvider r0, TextContextMenuDataProvider r1) {
        return r0.observeAndGetData(r1);
    }

    private static final Rect createActionModeCallback$lambda$5(AndroidTextContextMenuToolbarProvider r0, TextContextMenuDataProvider r1) {
        return r0.observeAndGetBounds(r1);
    }

    private static final Rect observeAndGetBounds$lambda$7(AndroidTextContextMenuToolbarProvider r0, TextContextMenuDataProvider r1) {
        return r0.calculateBoundsInRoot(r1);
    }

    private static final Unit observeReadsAndGet$lambda$8(Ref.ObjectRef r0, Function0 r1) {
        r0.element = r1.invoke();
        return Unit.INSTANCE;
    }

    private static final Unit onDataChange$lambda$2(AndroidTextContextMenuToolbarProvider r0, Object r1) {
        ActionMode r2 = r0.actionMode;
        if (r2 == null) goto L6;
        r2.invalidate();
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit onPositionChange$lambda$3(AndroidTextContextMenuToolbarProvider r0, Object r1) {
        ActionMode r2 = r0.actionMode;
        if (r2 == null) goto L6;
        TextToolbarHelper.INSTANCE.invalidateContentRect(r2);
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit snapshotStateObserver$lambda$1(AndroidTextContextMenuToolbarProvider r2, final Function0 r3) {
        Handler r0 = r2.view.getHandler();
        if (r0 == null) goto L5;
        Looper r1 = r0.getLooper();
    L7:
        if (r1 != Looper.myLooper()) goto L9;
        r3.invoke();
    L13:
        return Unit.INSTANCE;
    L9:
        Handler r4 = r2.view.getHandler();
        if (r4 == null) goto L13;
        r4.post(new i(r3));
        goto L13
    L5:
        r1 = null;
        goto L7
    }

    @Override // androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProvider
    public Object showTextContextMenu(TextContextMenuDataProvider r7, Continuation<? super Unit> r8) {
        Object r9 = MutatorMutex.mutate$default(this.mutatorMutex, null, new AnonymousClass2(this, r7, null), r8, 1, null);
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r9;
    L6:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AndroidTextContextMenuToolbarProvider(View r1, Function1<? super TextActionModeCallback, ? extends TextActionModeCallback> r2, Function0<? extends LayoutCoordinates> r3) {
        this.view = r1;
        this.callbackInjector = r2;
        this.coordinatesProvider = r3;
        this.mutatorMutex = new MutatorMutex();
        this.snapshotStateObserver = new SnapshotStateObserver(new e(this));
        this.onDataChange = new f(this);
        this.onPositionChange = new g(this);
    }

    public static final /* synthetic */ TextActionModeCallback access$createActionModeCallback(AndroidTextContextMenuToolbarProvider r0, TextContextMenuSessionImpl r1, TextContextMenuDataProvider r2) {
        return r0.createActionModeCallback(r1, r2);
    }

    private final <T, S> T observeReadsAndGet(S r4, Function1<? super S, Unit> r5, final Function0<? extends T> r6) {
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        this.snapshotStateObserver.observeReads(r4, r5, new a(r0, r6));
        T r7 = (T) r0.element;
        if (r7 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("result");
        return (T) Unit.INSTANCE;
    L6:
        return r7;
    }
}
