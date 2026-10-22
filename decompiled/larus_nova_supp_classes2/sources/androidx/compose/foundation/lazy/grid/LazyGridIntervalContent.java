package androidx.compose.foundation.lazy.grid;

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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 32\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00013B \u0012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007¢\u0006\u0004\b\b\u0010\tJZ\u0010\u001e\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0019\u0010!\u001a\u0015\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#\u0018\u00010\u0005¢\u0006\u0002\b\u00072\b\u0010$\u001a\u0004\u0018\u00010 2\u001c\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b&¢\u0006\u0002\b\u0007H\u0016¢\u0006\u0002\u0010'J³\u0001\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*2#\u0010\u001f\u001a\u001f\u0012\u0013\u0012\u00110*¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020 \u0018\u00010\u00052\u001f\u0010!\u001a\u001b\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020#\u0018\u00010.¢\u0006\u0002\b\u00072#\u0010$\u001a\u001f\u0012\u0013\u0012\u00110*¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0006\u0012\u0004\u0018\u00010 0\u000521\u0010/\u001a-\u0012\u0004\u0012\u00020%\u0012\u0013\u0012\u00110*¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00060.¢\u0006\u0002\b&¢\u0006\u0002\b\u0007H\u0016¢\u0006\u0002\u00100JE\u00101\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010$\u001a\u0004\u0018\u00010 2\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00060.¢\u0006\u0002\b&¢\u0006\u0002\b\u0007H\u0016¢\u0006\u0002\u00102R\u0014\u0010\n\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001a\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u00064"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "Landroidx/compose/foundation/lazy/grid/LazyGridInterval;", "content", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "spanLayoutProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "getSpanLayoutProvider$foundation_release", "()Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "intervals", "Landroidx/compose/foundation/lazy/layout/MutableIntervalList;", "getIntervals", "()Landroidx/compose/foundation/lazy/layout/MutableIntervalList;", "hasCustomSpans", "", "getHasCustomSpans$foundation_release", "()Z", "setHasCustomSpans$foundation_release", "(Z)V", "_headerIndexes", "Landroidx/collection/MutableIntList;", "headerIndexes", "Landroidx/collection/IntList;", "getHeaderIndexes", "()Landroidx/collection/IntList;", "item", "key", "", "span", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "contentType", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "items", "count", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "index", "Lkotlin/Function2;", "itemContent", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "stickyHeader", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function4;)V", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LazyGridIntervalContent extends LazyLayoutIntervalContent<LazyGridInterval> implements LazyGridScope {
    public static final int $stable = 0;
    private static final Companion Companion = null;
    private static final Function2<LazyGridItemSpanScope, Integer, GridItemSpan> DefaultSpan = null;
    private MutableIntList _headerIndexes;
    private boolean hasCustomSpans;
    private final MutableIntervalList<LazyGridInterval> intervals;
    private final LazyGridSpanLayoutProvider spanLayoutProvider;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R(\u0010\u0004\u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent$Companion;", "", "<init>", "()V", "DefaultSpan", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "Lkotlin/ExtensionFunctionType;", "getDefaultSpan", "()Lkotlin/jvm/functions/Function2;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final Function2<LazyGridItemSpanScope, Integer, GridItemSpan> getDefaultSpan() {
            return LazyGridIntervalContent.access$getDefaultSpan$cp();
        }
    }

    public static /* synthetic */ Object a(Object r0, int r1) {
        return item$lambda$1$lambda$0(r0, r1);
    }

    public static /* synthetic */ GridItemSpan b(Function1 r0, LazyGridItemSpanScope r1, int r2) {
        return item$lambda$3$lambda$2(r0, r1, r2);
    }

    public static /* synthetic */ GridItemSpan c(LazyGridItemSpanScope r0, int r1) {
        return DefaultSpan$lambda$7(r0, r1);
    }

    public static /* synthetic */ GridItemSpan d(LazyGridItemSpanScope r0) {
        return stickyHeader$lambda$6(r0);
    }

    public static /* synthetic */ Object e(Object r0, int r1) {
        return item$lambda$4(r0, r1);
    }

    private static final Object item$lambda$1$lambda$0(Object r0, int r1) {
        return r0;
    }

    private static final Object item$lambda$4(Object r0, int r1) {
        return r0;
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
        DefaultSpan = new h();
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

    public static final /* synthetic */ Function2 access$getDefaultSpan$cp() {
        return DefaultSpan;
    }

    public final boolean getHasCustomSpans$foundation_release() {
        return this.hasCustomSpans;
    }

    public final LazyGridSpanLayoutProvider getSpanLayoutProvider$foundation_release() {
        return this.spanLayoutProvider;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent
    public MutableIntervalList<LazyGridInterval> getIntervals() {
        return this.intervals;
    }

    public LazyGridIntervalContent(Function1<? super LazyGridScope, Unit> r2) {
        this.spanLayoutProvider = new LazyGridSpanLayoutProvider(this);
        this.intervals = new MutableIntervalList();
        r2.invoke(this);
    }

    private static final GridItemSpan stickyHeader$lambda$6(LazyGridItemSpanScope r2) {
        return GridItemSpan.m1102boximpl(LazyGridSpanKt.GridItemSpan(r2.getMaxLineSpan()));
    }

    public final void setHasCustomSpans$foundation_release(boolean r1) {
        this.hasCustomSpans = r1;
    }

    private static final GridItemSpan DefaultSpan$lambda$7(LazyGridItemSpanScope r0, int r1) {
        return GridItemSpan.m1102boximpl(LazyGridSpanKt.GridItemSpan(1));
    }

    private static final GridItemSpan item$lambda$3$lambda$2(Function1 r0, LazyGridItemSpanScope r1, int r2) {
        return (GridItemSpan) r0.invoke(r1);
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridScope
    public void stickyHeader(Object r5, Object r6, final Function4<? super LazyGridItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> r7) {
        MutableIntList r0 = this._headerIndexes;
        if (r0 != null) goto L5;
        r0 = new MutableIntList(0, 1, null);
        this._headerIndexes = r0;
    L5:
        final int r2 = getIntervals().getSize();
        r0.add(r2);
        item(r5, new i(), r6, ComposableLambdaKt.composableLambdaInstance(46791243, true, new AnonymousClass2(r7, r2)));
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridScope
    public void item(final Object r5, final Function1<? super LazyGridItemSpanScope, GridItemSpan> r6, final Object r7, final Function3<? super LazyGridItemScope, ? super Composer, ? super Integer, Unit> r8) {
        MutableIntervalList<LazyGridInterval> r0 = getIntervals();
        if (r5 == null) goto L5;
        Function1 r1 = new j(r5);
    L6:
        if (r6 == null) goto L8;
        Function2<LazyGridItemSpanScope, Integer, GridItemSpan> r9 = new k(r6);
    L9:
        r0.addInterval(1, new LazyGridInterval(r1, r9, new l(r7), ComposableLambdaKt.composableLambdaInstance(-291643851, true, new AnonymousClass4(r8))));
        if (r6 == null) goto L13;
        this.hasCustomSpans = true;
        return;
    L13:
        return;
    L8:
        r9 = DefaultSpan;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridScope
    public void items(int r4, Function1<? super Integer, ? extends Object> r5, Function2<? super LazyGridItemSpanScope, ? super Integer, GridItemSpan> r6, Function1<? super Integer, ? extends Object> r7, Function4<? super LazyGridItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> r8) {
        MutableIntervalList<LazyGridInterval> r0 = getIntervals();
        if (r6 != null) goto L5;
        Function2<? super LazyGridItemSpanScope, ? super Integer, GridItemSpan> r2 = DefaultSpan;
    L6:
        r0.addInterval(r4, new LazyGridInterval(r5, r2, r7, r8));
        if (r6 == null) goto L10;
        this.hasCustomSpans = true;
        return;
    L10:
        return;
    L5:
        r2 = r6;
        goto L6
    }
}
