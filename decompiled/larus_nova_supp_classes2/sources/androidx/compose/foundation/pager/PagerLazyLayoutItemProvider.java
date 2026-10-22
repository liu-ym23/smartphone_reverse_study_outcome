package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItemKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0017¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u001c\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "state", "Landroidx/compose/foundation/pager/PagerState;", "intervalContent", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "Landroidx/compose/foundation/pager/PagerIntervalContent;", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "<init>", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;)V", "pagerScopeImpl", "Landroidx/compose/foundation/pager/PagerScopeImpl;", "itemCount", "", "getItemCount", "()I", "Item", "", "index", "key", "", "(ILjava/lang/Object;Landroidx/compose/runtime/Composer;I)V", "getKey", "getIndex", "equals", "", "other", "hashCode", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PagerLazyLayoutItemProvider implements LazyLayoutItemProvider {
    public static final int $stable = 0;
    private final LazyLayoutIntervalContent<PagerIntervalContent> intervalContent;
    private final LazyLayoutKeyIndexMap keyIndexMap;
    private final PagerScopeImpl pagerScopeImpl;
    private final PagerState state;

    private static final Unit Item$lambda$0(PagerLazyLayoutItemProvider r0, int r1, Object r2, int r3, Composer r4, int r5) {
        r0.Item(r1, r2, r4, RecomposeScopeImplKt.updateChangedFlags(r3 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(PagerLazyLayoutItemProvider r0, int r1, Object r2, int r3, Composer r4, int r5) {
        return Item$lambda$0(r0, r1, r2, r3, r4, r5);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public final /* synthetic */ Object getContentType(int r1) {
        return LazyLayoutItemProvider.CC.$default$getContentType(this, r1);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public int getItemCount() {
        return this.intervalContent.getItemCount();
    }

    public int hashCode() {
        return this.intervalContent.hashCode();
    }

    public static final /* synthetic */ LazyLayoutIntervalContent access$getIntervalContent$p(PagerLazyLayoutItemProvider r0) {
        return r0.intervalContent;
    }

    public static final /* synthetic */ PagerScopeImpl access$getPagerScopeImpl$p(PagerLazyLayoutItemProvider r0) {
        return r0.pagerScopeImpl;
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L6;
        return true;
    L6:
        if ((r2 instanceof PagerLazyLayoutItemProvider) == true) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(this.intervalContent, ((PagerLazyLayoutItemProvider) r2).intervalContent);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public int getIndex(Object r2) {
        return this.keyIndexMap.getIndex(r2);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public Object getKey(int r2) {
        Object r0 = this.keyIndexMap.getKey(r2);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.intervalContent.getKey(r2);
    }

    public PagerLazyLayoutItemProvider(PagerState r1, LazyLayoutIntervalContent<PagerIntervalContent> r2, LazyLayoutKeyIndexMap r3) {
        this.state = r1;
        this.intervalContent = r2;
        this.keyIndexMap = r3;
        this.pagerScopeImpl = PagerScopeImpl.INSTANCE;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public void Item(final int r8, final Object r9, Composer r10, final int r11) {
        Composer r12 = r10.startRestartGroup(-1201380429);
        if ((r11 & 6) == 0) goto L5;
        int r1 = r11;
    L11:
        if ((r11 & 48) != 0) goto L18;
        if (r12.changedInstance(r9) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r11 & 384) != 0) goto L25;
        if (r12.changed(this) == false) goto L22;
        int r3 = 256;
    L23:
        r1 = r1 | r3;
        goto L25
    L22:
        r3 = 128;
    L25:
        if ((r1 & 147) == 146) goto L27;
        boolean r4 = true;
    L29:
        if (r12.shouldExecute(r4, r1 & 1) == true) goto L31;
        r12.skipToGroupEnd();
    L37:
        ScopeUpdateScope r13 = r12.endRestartGroup();
        if (r13 == null) goto L41;
        r13.updateScope(new t(this, r8, r9, r11));
        return;
    L41:
        return;
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventStart(-1201380429, r1, -1, "androidx.compose.foundation.pager.PagerLazyLayoutItemProvider.Item (LazyLayoutPager.kt:209)");
    L33:
        LazyLayoutPinnableItemKt.LazyLayoutPinnableItem(r9, r8, this.state.getPinnedPages$foundation_release(), ComposableLambdaKt.rememberComposableLambda(1142237095, true, new AnonymousClass1(this, r8), r12, 54), r12, (((r1 >> 3) & 14) | 3072) | ((r1 << 3) & 112));
        if (ComposerKt.isTraceInProgress() == false) goto L37;
        ComposerKt.traceEventEnd();
        goto L37
    L27:
        r4 = false;
        goto L29
    L5:
        if (r12.changed(r8) == false) goto L7;
        int r5 = 4;
    L8:
        r1 = r5 | r11;
        goto L11
    L7:
        r5 = 2;
        goto L8
    }
}
