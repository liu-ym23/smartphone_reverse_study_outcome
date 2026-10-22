package com.obric.assistant.interaction.impl.window;

import android.os.SystemClock;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.larus.utils.logger.FLogger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B'\u0012\u001e\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0005\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000bH\u0002R&\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0005\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/WindowOperationExecutor;", "", "onPendingOperationsDropped", "Lkotlin/Function2;", "", "", "", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "pendingOperations", "Ljava/util/ArrayDeque;", "Lcom/obric/assistant/interaction/impl/window/WindowOperationExecutor$WindowOperation;", "isOperationRunning", "", "runningOperation", "execute", WikiFolderPushPlugin.OPT, "block", "Lkotlin/Function0;", "executeOperation", "Companion", "WindowOperation", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowOperationExecutor {
    private static final Companion Companion = null;
    public static final String TAG = "WindowOperationExecutor";
    public static final String TRACE_PREFIX = "ObricWindowHost.";
    private boolean isOperationRunning;
    private final Function2<String, List<String>, Unit> onPendingOperationsDropped;
    private final ArrayDeque<WindowOperation> pendingOperations;
    private String runningOperation;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/WindowOperationExecutor$Companion;", "", "<init>", "()V", "TAG", "", "TRACE_PREFIX", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/WindowOperationExecutor$WindowOperation;", "", "name", "", "block", "Lkotlin/Function0;", "", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getName", "()Ljava/lang/String;", "getBlock", "()Lkotlin/jvm/functions/Function0;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class WindowOperation {
        private final Function0<Unit> block;
        private final String name;

        public final Function0<Unit> getBlock() {
            return this.block;
        }

        public final String getName() {
            return this.name;
        }

        public WindowOperation(String r100, Function0<Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            Intrinsics.checkNotNullParameter(r101, "block");
            this.name = r100;
            this.block = r101;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void a(String r100, Function0 r101, WindowOperationExecutor r102) {
        execute$lambda$1(r100, r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WindowOperationExecutor(Function2<? super String, ? super List<String>, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onPendingOperationsDropped");
        this.onPendingOperationsDropped = r100;
        this.pendingOperations = new ArrayDeque();
    }

    private final void executeOperation(WindowOperation r110) {
        this.runningOperation = r110.getName();
        long r100 = SystemClock.elapsedRealtime();
        String r101 = TRACE_PREFIX + StringsKt.substringBefore$default(r110.getName(), '(', null, 2, null);
        FLogger r102 = FLogger.f375446a;
        r102.i(TAG, "operation start, operation=" + r110.getName());
        com.obric.assistant.common.utils.i.a r103 = com.obric.assistant.common.utils.i.a(r101);     // Catch: Throwable -> L13
        r110.getBlock().invoke();     // Catch: Throwable -> L9
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L9
        if (r103 == null) goto L7;
        r103.a();     // Catch: Throwable -> L13
    L7:
        r102.i(TAG, "operation end, operation=" + r110.getName() + ", costMs=" + (SystemClock.elapsedRealtime() - r100) + "ms");
        return;
    L9:
        th = move-exception;
        if (r103 == null) goto L12;
        r103.a();     // Catch: Throwable -> L13
    L12:
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        FLogger.f375446a.i(TAG, "operation end, operation=" + r110.getName() + ", costMs=" + (SystemClock.elapsedRealtime() - r100) + "ms");
        throw th;
    }

    public final void execute(final String r100, final Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.OPT);
        Intrinsics.checkNotNullParameter(r101, "block");
        com.larus.utils.t0.e(new v1(r100, r101, this));
    }

    private static final void execute$lambda$1(String r100, Function0 r110, WindowOperationExecutor r111) {
        WindowOperation r101 = new WindowOperation(r100, r110);
        if (r111.isOperationRunning == false) goto L6;
        r111.pendingOperations.addLast(r101);
        FLogger.f375446a.i(TAG, "operation waiting, operation=" + r100 + ", runningOperation=" + r111.runningOperation + ", pendingCount=" + r111.pendingOperations.size());
        return;
    L6:
        r111.isOperationRunning = true;
        r111.executeOperation(r101);     // Catch: Throwable -> L24
    L9:
        if ((!r111.pendingOperations.isEmpty()) == false) goto L12;
        r111.executeOperation(r111.pendingOperations.removeFirst());     // Catch: Throwable -> L24
        goto L9
    L12:
        String r102 = r111.runningOperation;
        if (r102 == null) goto L16;
        r100 = r102;
    L16:
        ArrayDeque<WindowOperation> r103 = r111.pendingOperations;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L18:
        if (r105.hasNext() == false) goto L20;
        r104.add(((WindowOperation) r105.next()).getName());
        goto L18
    L20:
        r111.pendingOperations.clear();
        r111.isOperationRunning = false;
        r111.runningOperation = null;
        if ((true ^ r104.isEmpty()) == false) goto L43;
        FLogger.f375446a.w(TAG, "operation not executed, interruptedOperation=" + r100 + ", pendingOperations=" + r104);
        r111.onPendingOperationsDropped.invoke(r100, r104);
        return;
    L43:
        return;
    L24:
        th = move-exception;
        String r106 = r111.runningOperation;
        if (r106 == null) goto L29;
        r100 = r106;
    L29:
        ArrayDeque<WindowOperation> r107 = r111.pendingOperations;
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator<T> r109 = r107.iterator();
    L31:
        if (r109.hasNext() == false) goto L33;
        r108.add(((WindowOperation) r109.next()).getName());
        goto L31
    L33:
        r111.pendingOperations.clear();
        r111.isOperationRunning = false;
        r111.runningOperation = null;
        if ((true ^ r108.isEmpty()) == false) goto L36;
        FLogger.f375446a.w(TAG, "operation not executed, interruptedOperation=" + r100 + ", pendingOperations=" + r108);
        r111.onPendingOperationsDropped.invoke(r100, r108);
    L36:
        throw th;
    }
}
