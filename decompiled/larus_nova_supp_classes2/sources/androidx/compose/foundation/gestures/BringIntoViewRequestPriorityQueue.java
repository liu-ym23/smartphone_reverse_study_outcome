package androidx.compose.foundation.gestures;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Rect;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006J9\u0010\u000f\u001a\u00020\u00102#\u0010\u0011\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00100\u0012H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0006\u0010\u0017\u001a\u00020\u0010J9\u0010\u0018\u001a\u00020\u00102#\u0010\u0011\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\f0\u0012H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0010\u0010\u0019\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/gestures/BringIntoViewRequestPriorityQueue;", "", "<init>", "()V", "requests", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/gestures/ContentInViewNode$Request;", "size", "", "getSize", "()I", "isEmpty", "", "enqueue", "request", "forEachFromSmallest", "", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Rect;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "bounds", "resumeAndRemoveAll", "resumeAndRemoveWhile", "cancelAndRemoveAll", "cause", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BringIntoViewRequestPriorityQueue {
    public static final int $stable = 0;
    private final MutableVector<ContentInViewNode.Request> requests;

    static {
        $stable = MutableVector.$stable;
    }

    public static /* synthetic */ Unit a(BringIntoViewRequestPriorityQueue r0, ContentInViewNode.Request r1, Throwable r2) {
        return enqueue$lambda$1(r0, r1, r2);
    }

    public final int getSize() {
        return this.requests.getSize();
    }

    public final boolean isEmpty() {
        if (this.requests.getSize() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void resumeAndRemoveAll() {
        IntRange r0 = RangesKt.until(0, this.requests.getSize());
        int r1 = r0.getFirst();
        int r2 = r0.getLast();
        if (r1 > r2) goto L7;
    L4:
        ((ContentInViewNode.Request) this.requests.content[r1]).getContinuation().resumeWith(Result.constructor-impl(Unit.INSTANCE));
        if (r1 == r2) goto L7;
        r1 = r1 + 1;
    L7:
        this.requests.clear();
    }

    public BringIntoViewRequestPriorityQueue() {
        this.requests = new MutableVector(new ContentInViewNode.Request[16], 0);
    }

    public static final /* synthetic */ MutableVector access$getRequests$p(BringIntoViewRequestPriorityQueue r0) {
        return r0.requests;
    }

    public final void cancelAndRemoveAll(Throwable r7) {
        MutableVector<ContentInViewNode.Request> r0 = this.requests;
        int r1 = r0.getSize();
        kotlinx.coroutines.i[] r2 = new kotlinx.coroutines.i[r1];
        boolean r3 = false;
        int r4 = 0;
    L3:
        if (r4 >= r1) goto L5;
        r2[r4] = ((ContentInViewNode.Request) r0.content[r4]).getContinuation();
        r4 = r4 + 1;
        goto L3
    L5:
        int r5 = 0;
    L6:
        if (r5 >= r1) goto L9;
        r2[r5].cancel(r7);
        r5 = r5 + 1;
        goto L6
    L9:
        if (this.requests.getSize() != 0) goto L11;
        r3 = true;
    L11:
        if (r3 == true) goto L16;
        InlineClassHelperKt.throwIllegalStateException("uncancelled requests present");
        return;
    }

    public final boolean enqueue(final ContentInViewNode.Request r9) {
        Rect r0 = (Rect) r9.getCurrentBounds().invoke();
        if (r0 != null) goto L6;
        kotlinx.coroutines.i<Unit> r10 = r9.getContinuation();
        Result.Companion r1 = Result.Companion;
        r10.resumeWith(Result.constructor-impl(Unit.INSTANCE));
        return false;
    L6:
        r9.getContinuation().i(new b0(this, r9));
        IntRange r2 = RangesKt.until(0, this.requests.getSize());
        int r3 = r2.getFirst();
        int r4 = r2.getLast();
        if (r3 > r4) goto L24;
    L8:
        Rect r5 = (Rect) ((ContentInViewNode.Request) this.requests.content[r4]).getCurrentBounds().invoke();
        if (r5 == null) goto L22;
        Rect r6 = r0.intersect(r5);
        if (Intrinsics.areEqual(r6, r0) == true) goto L13;
        if (Intrinsics.areEqual(r6, r5) == true) goto L22;
        CancellationException r7 = new CancellationException("bringIntoView call interrupted by a newer, non-overlapping call");
        int r8 = this.requests.getSize() - 1;
        if (r8 > r4) goto L22;
    L19:
        ((ContentInViewNode.Request) this.requests.content[r4]).getContinuation().cancel(r7);
        if (r8 == r4) goto L22;
        r8 = r8 + 1;
        goto L19
    L13:
        this.requests.add(r4 + 1, r9);
        return true;
    L22:
        if (r4 == r3) goto L24;
        r4 = r4 - 1;
    L24:
        this.requests.add(0, r9);
        return true;
    }

    public final void forEachFromSmallest(Function1<? super Rect, Unit> r4) {
        MutableVector r0 = access$getRequests$p(this);
        int r1 = r0.getSize() - 1;
        Object[] r2 = r0.content;
        if (r1 >= r2.length) goto L6;
    L4:
        if (r1 < 0) goto L8;
        r4.invoke(((ContentInViewNode.Request) r2[r1]).getCurrentBounds().invoke());
        r1 = r1 - 1;
        goto L4
    L8:
        return;
    }

    public final void resumeAndRemoveWhile(Function1<? super Rect, Boolean> r4) {
    L3:
        if (access$getRequests$p(this).getSize() == 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        if (((Boolean) r4.invoke(((ContentInViewNode.Request) access$getRequests$p(this).last()).getCurrentBounds().invoke())).booleanValue() == false) goto L13;
        ((ContentInViewNode.Request) access$getRequests$p(this).removeAt(access$getRequests$p(this).getSize() - 1)).getContinuation().resumeWith(Result.constructor-impl(Unit.INSTANCE));
        goto L3
    L13:
        return;
    L10:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private static final Unit enqueue$lambda$1(BringIntoViewRequestPriorityQueue r0, ContentInViewNode.Request r1, Throwable r2) {
        r0.requests.remove(r1);
        return Unit.INSTANCE;
    }
}
