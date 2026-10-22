package androidx.compose.foundation.lazy;

import androidx.autofill.HintConstants;
import androidx.collection.IntList;
import androidx.collection.IntListKt;
import androidx.collection.MutableIntList;
import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import androidx.compose.foundation.lazy.layout.MutableIntervalList;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B \u0012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007¢\u0006\u0004\b\b\u0010\tJ\u0092\u0001\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162#\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00052#\u0010\u001c\u001a\u001f\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u000521\u0010\u001d\u001a-\u0012\u0004\u0012\u00020\u001f\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00060\u001e¢\u0006\u0002\b ¢\u0006\u0002\b\u0007H\u0016¢\u0006\u0002\u0010!J?\u0010\"\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u001c\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b ¢\u0006\u0002\b\u0007H\u0016¢\u0006\u0002\u0010#JE\u0010$\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00060\u001e¢\u0006\u0002\b ¢\u0006\u0002\b\u0007H\u0016¢\u0006\u0002\u0010%R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006&"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListIntervalContent;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "Landroidx/compose/foundation/lazy/LazyListInterval;", "Landroidx/compose/foundation/lazy/LazyListScope;", "content", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "intervals", "Landroidx/compose/foundation/lazy/layout/MutableIntervalList;", "getIntervals", "()Landroidx/compose/foundation/lazy/layout/MutableIntervalList;", "_headerIndexes", "Landroidx/collection/MutableIntList;", "headerIndexes", "Landroidx/collection/IntList;", "getHeaderIndexes", "()Landroidx/collection/IntList;", "items", "count", "", "key", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "index", "", "contentType", "itemContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "Landroidx/compose/runtime/Composable;", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "item", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "stickyHeader", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function4;)V", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LazyListIntervalContent extends LazyLayoutIntervalContent<LazyListInterval> implements LazyListScope {
    public static final int $stable = 8;
    private MutableIntList _headerIndexes;
    private final MutableIntervalList<LazyListInterval> intervals;

    public static /* synthetic */ Object a(Object r0, int r1) {
        return item$lambda$1(r0, r1);
    }

    public static /* synthetic */ Object b(Object r0, int r1) {
        return item$lambda$0(r0, r1);
    }

    private static final Object item$lambda$0(Object r0, int r1) {
        return r0;
    }

    private static final Object item$lambda$1(Object r0, int r1) {
        return r0;
    }

    @Override // androidx.compose.foundation.lazy.LazyListScope
    public final /* synthetic */ void item(Object r1, Function3 r2) {
        LazyListScope.CC.$default$item(this, r1, r2);
    }

    @Override // androidx.compose.foundation.lazy.LazyListScope
    public final /* synthetic */ void items(int r1, Function1 r2, Function4 r3) {
        LazyListScope.CC.$default$items(this, r1, r2, r3);
    }

    @Override // androidx.compose.foundation.lazy.LazyListScope
    public final /* synthetic */ void stickyHeader(Object r1, Object r2, Function3 r3) {
        LazyListScope.CC.$default$stickyHeader(this, r1, r2, r3);
    }

    public final IntList getHeaderIndexes() {
        MutableIntList r0 = this._headerIndexes;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return IntListKt.emptyIntList();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent
    public /* bridge */ /* synthetic */ IntervalList getIntervals() {
        return getIntervals();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent
    public MutableIntervalList<LazyListInterval> getIntervals() {
        return this.intervals;
    }

    public LazyListIntervalContent(Function1<? super LazyListScope, Unit> r2) {
        this.intervals = new MutableIntervalList();
        r2.invoke(this);
    }

    @Override // androidx.compose.foundation.lazy.LazyListScope
    public void item(final Object r5, final Object r6, final Function3<? super LazyItemScope, ? super Composer, ? super Integer, Unit> r7) {
        MutableIntervalList<LazyListInterval> r0 = getIntervals();
        if (r5 == null) goto L5;
        Function1 r2 = new h(r5);
    L6:
        r0.addInterval(1, new LazyListInterval(r2, new i(r6), ComposableLambdaKt.composableLambdaInstance(-857469575, true, new AnonymousClass3(r7))));
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // androidx.compose.foundation.lazy.LazyListScope
    public void stickyHeader(Object r5, Object r6, final Function4<? super LazyItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> r7) {
        MutableIntList r0 = this._headerIndexes;
        if (r0 != null) goto L5;
        r0 = new MutableIntList(0, 1, null);
        this._headerIndexes = r0;
    L5:
        r0.add(getIntervals().getSize());
        final int r1 = getIntervals().getSize();
        item(r5, r6, ComposableLambdaKt.composableLambdaInstance(-1588696110, true, new AnonymousClass1(r7, r1)));
    }

    @Override // androidx.compose.foundation.lazy.LazyListScope
    public void items(int r3, Function1<? super Integer, ? extends Object> r4, Function1<? super Integer, ? extends Object> r5, Function4<? super LazyItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> r6) {
        getIntervals().addInterval(r3, new LazyListInterval(r4, r5, r6));
    }
}
