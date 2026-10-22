package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a\u008c\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0080\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\u001f\u001a\u008c\u0001\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0004\b%\u0010&\u001a\u0080\u0001\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0004\b'\u0010(\u001a%\u0010)\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010*\u001aÐ\u0001\u0010+\u001a\u00020\u0001\"\u0004\b\u0000\u0010,*\u00020\u00172\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H,0-2%\b\n\u0010.\u001a\u001f\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u000202\u0018\u00010\u00162%\b\u0006\u00103\u001a\u001f\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0006\u0012\u0004\u0018\u0001020\u00162%\b\n\u00104\u001a\u001f\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u000205\u0018\u00010\u001623\b\u0004\u00106\u001a-\u0012\u0004\u0012\u000208\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\u000107¢\u0006\u0002\b9¢\u0006\u0002\b\u0018H\u0086\b¢\u0006\u0002\u0010:\u001a¤\u0002\u0010;\u001a\u00020\u0001\"\u0004\b\u0000\u0010,*\u00020\u00172\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H,0-2:\b\n\u0010.\u001a4\u0012\u0013\u0012\u00110<¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u000202\u0018\u0001072:\b\u0006\u00103\u001a4\u0012\u0013\u0012\u00110<¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0006\u0012\u0004\u0018\u000102072:\b\n\u00104\u001a4\u0012\u0013\u0012\u00110<¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u000205\u0018\u0001072H\b\u0004\u00106\u001aB\u0012\u0004\u0012\u000208\u0012\u0013\u0012\u00110<¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\u00010>¢\u0006\u0002\b9¢\u0006\u0002\b\u0018H\u0086\b¢\u0006\u0002\u0010?\u001aÐ\u0001\u0010+\u001a\u00020\u0001\"\u0004\b\u0000\u0010,*\u00020\u00172\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H,0@2%\b\n\u0010.\u001a\u001f\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u000202\u0018\u00010\u00162%\b\u0006\u00103\u001a\u001f\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0006\u0012\u0004\u0018\u0001020\u00162%\b\n\u00104\u001a\u001f\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u000205\u0018\u00010\u001623\b\u0004\u00106\u001a-\u0012\u0004\u0012\u000208\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\u000107¢\u0006\u0002\b9¢\u0006\u0002\b\u0018H\u0086\b¢\u0006\u0002\u0010A\u001a¤\u0002\u0010;\u001a\u00020\u0001\"\u0004\b\u0000\u0010,*\u00020\u00172\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H,0@2:\b\n\u0010.\u001a4\u0012\u0013\u0012\u00110<¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u000202\u0018\u0001072:\b\u0006\u00103\u001a4\u0012\u0013\u0012\u00110<¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0006\u0012\u0004\u0018\u000102072:\b\n\u00104\u001a4\u0012\u0013\u0012\u00110<¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u000205\u0018\u0001072H\b\u0004\u00106\u001aB\u0012\u0004\u0012\u000208\u0012\u0013\u0012\u00110<¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\u00010>¢\u0006\u0002\b9¢\u0006\u0002\b\u0018H\u0086\b¢\u0006\u0002\u0010B¨\u0006C"}, d2 = {"LazyVerticalStaggeredGrid", "", "columns", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "verticalItemSpacing", "Landroidx/compose/ui/unit/Dp;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "Lkotlin/ExtensionFunctionType;", "LazyVerticalStaggeredGrid-6qCrX9Q", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/layout/PaddingValues;ZFLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "LazyVerticalStaggeredGrid-zadm560", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/layout/PaddingValues;ZFLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberColumnSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "LazyHorizontalStaggeredGrid", "rows", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalItemSpacing", "LazyHorizontalStaggeredGrid-121YqSk", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "LazyHorizontalStaggeredGrid-cJHQLPU", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberRowSlots", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "items", "T", "", "key", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "item", "", "contentType", "span", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan;", "itemContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyStaggeredGridDslKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$items$10, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class AnonymousClass10 implements Function4<LazyStaggeredGridItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function4<LazyStaggeredGridItemScope, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass10(Function4<? super LazyStaggeredGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> r1, T[] r2) {
            this.$itemContent = r1;
            this.$items = r2;
        }

        public final void invoke(LazyStaggeredGridItemScope r4, int r5, Composer r6, int r7) {
            if ((r7 & 6) == 0) goto L5;
            int r0 = r7;
        L11:
            if ((r7 & 48) != 0) goto L18;
            if (r6.changed(r5) == false) goto L15;
            int r8 = 32;
        L16:
            r0 = r0 | r8;
            goto L18
        L15:
            r8 = 16;
        L18:
            if ((r0 & 147) == 146) goto L20;
            boolean r9 = true;
        L22:
            if (r6.shouldExecute(r9, r0 & 1) == true) goto L24;
            r6.skipToGroupEnd();
            return;
        L24:
            if (ComposerKt.isTraceInProgress() == false) goto L26;
            ComposerKt.traceEventStart(-1775984467, r0, -1, "androidx.compose.foundation.lazy.staggeredgrid.items.<anonymous> (LazyStaggeredGridDsl.kt:472)");
        L26:
            this.$itemContent.invoke(r4, this.$items[r5], r6, Integer.valueOf(r0 & 14));
            if (ComposerKt.isTraceInProgress() == false) goto L31;
            ComposerKt.traceEventEnd();
            return;
        L31:
            return;
        L20:
            r9 = false;
            goto L22
        L5:
            if (r6.changed(r4) == false) goto L7;
            int r1 = 4;
        L8:
            r0 = r1 | r7;
            goto L11
        L7:
            r1 = 2;
            goto L8
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
            invoke((LazyStaggeredGridItemScope) r1, ((Number) r2).intValue(), (Composer) r3, ((Number) r4).intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$items$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class AnonymousClass3 implements Function1<Integer, Object> {
        final /* synthetic */ Function1<T, Object> $contentType;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(Function1<? super T, ? extends Object> r1, List<? extends T> r2) {
            this.$contentType = r1;
            this.$items = r2;
        }

        public final Object invoke(int r3) {
            return this.$contentType.invoke(ListProtector.get(this.$items, r3));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke(((Number) r1).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$items$5, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class AnonymousClass5 implements Function4<LazyStaggeredGridItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function4<LazyStaggeredGridItemScope, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass5(Function4<? super LazyStaggeredGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> r1, List<? extends T> r2) {
            this.$itemContent = r1;
            this.$items = r2;
        }

        public final void invoke(LazyStaggeredGridItemScope r4, int r5, Composer r6, int r7) {
            if ((r7 & 6) == 0) goto L5;
            int r0 = r7;
        L11:
            if ((r7 & 48) != 0) goto L18;
            if (r6.changed(r5) == false) goto L15;
            int r8 = 32;
        L16:
            r0 = r0 | r8;
            goto L18
        L15:
            r8 = 16;
        L18:
            if ((r0 & 147) == 146) goto L20;
            boolean r9 = true;
        L22:
            if (r6.shouldExecute(r9, r0 & 1) == true) goto L24;
            r6.skipToGroupEnd();
            return;
        L24:
            if (ComposerKt.isTraceInProgress() == false) goto L26;
            ComposerKt.traceEventStart(-334987442, r0, -1, "androidx.compose.foundation.lazy.staggeredgrid.items.<anonymous> (LazyStaggeredGridDsl.kt:400)");
        L26:
            this.$itemContent.invoke(r4, ListProtector.get(this.$items, r5), r6, Integer.valueOf(r0 & 14));
            if (ComposerKt.isTraceInProgress() == false) goto L31;
            ComposerKt.traceEventEnd();
            return;
        L31:
            return;
        L20:
            r9 = false;
            goto L22
        L5:
            if (r6.changed(r4) == false) goto L7;
            int r1 = 4;
        L8:
            r0 = r1 | r7;
            goto L11
        L7:
            r1 = 2;
            goto L8
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
            invoke((LazyStaggeredGridItemScope) r1, ((Number) r2).intValue(), (Composer) r3, ((Number) r4).intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$items$8, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class AnonymousClass8 implements Function1<Integer, Object> {
        final /* synthetic */ Function1<T, Object> $contentType;
        final /* synthetic */ T[] $items;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass8(Function1<? super T, ? extends Object> r1, T[] r2) {
            this.$contentType = r1;
            this.$items = r2;
        }

        public final Object invoke(int r3) {
            return this.$contentType.invoke(this.$items[r3]);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke(((Number) r1).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$itemsIndexed$10, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class C020010 implements Function4<LazyStaggeredGridItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function5<LazyStaggeredGridItemScope, Integer, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: Multi-variable type inference failed */
        public C020010(Function5<? super LazyStaggeredGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> r1, T[] r2) {
            this.$itemContent = r1;
            this.$items = r2;
        }

        public final void invoke(LazyStaggeredGridItemScope r10, int r11, Composer r12, int r13) {
            if ((r13 & 6) == 0) goto L5;
            int r0 = r13;
        L11:
            if ((r13 & 48) != 0) goto L18;
            if (r12.changed(r11) == false) goto L15;
            int r14 = 32;
        L16:
            r0 = r0 | r14;
            goto L18
        L15:
            r14 = 16;
        L18:
            if ((r0 & 147) == 146) goto L20;
            boolean r15 = true;
        L22:
            if (r12.shouldExecute(r15, r0 & 1) == true) goto L24;
            r12.skipToGroupEnd();
            return;
        L24:
            if (ComposerKt.isTraceInProgress() == false) goto L26;
            ComposerKt.traceEventStart(425846862, r0, -1, "androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed.<anonymous> (LazyStaggeredGridDsl.kt:508)");
        L26:
            this.$itemContent.invoke(r10, Integer.valueOf(r11), this.$items[r11], r12, Integer.valueOf((r0 & 14) | (r0 & 112)));
            if (ComposerKt.isTraceInProgress() == false) goto L31;
            ComposerKt.traceEventEnd();
            return;
        L31:
            return;
        L20:
            r15 = false;
            goto L22
        L5:
            if (r12.changed(r10) == false) goto L7;
            int r1 = 4;
        L8:
            r0 = r1 | r13;
            goto L11
        L7:
            r1 = 2;
            goto L8
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
            invoke((LazyStaggeredGridItemScope) r1, ((Number) r2).intValue(), (Composer) r3, ((Number) r4).intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$itemsIndexed$3, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class C02013 implements Function1<Integer, Object> {
        final /* synthetic */ Function2<Integer, T, Object> $contentType;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: Multi-variable type inference failed */
        public C02013(Function2<? super Integer, ? super T, ? extends Object> r1, List<? extends T> r2) {
            this.$contentType = r1;
            this.$items = r2;
        }

        public final Object invoke(int r4) {
            return this.$contentType.invoke(Integer.valueOf(r4), ListProtector.get(this.$items, r4));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke(((Number) r1).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$itemsIndexed$5, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class C02025 implements Function4<LazyStaggeredGridItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function5<LazyStaggeredGridItemScope, Integer, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: Multi-variable type inference failed */
        public C02025(Function5<? super LazyStaggeredGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> r1, List<? extends T> r2) {
            this.$itemContent = r1;
            this.$items = r2;
        }

        public final void invoke(LazyStaggeredGridItemScope r10, int r11, Composer r12, int r13) {
            if ((r13 & 6) == 0) goto L5;
            int r0 = r13;
        L11:
            if ((r13 & 48) != 0) goto L18;
            if (r12.changed(r11) == false) goto L15;
            int r14 = 32;
        L16:
            r0 = r0 | r14;
            goto L18
        L15:
            r14 = 16;
        L18:
            if ((r0 & 147) == 146) goto L20;
            boolean r15 = true;
        L22:
            if (r12.shouldExecute(r15, r0 & 1) == true) goto L24;
            r12.skipToGroupEnd();
            return;
        L24:
            if (ComposerKt.isTraceInProgress() == false) goto L26;
            ComposerKt.traceEventStart(-1466459515, r0, -1, "androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed.<anonymous> (LazyStaggeredGridDsl.kt:436)");
        L26:
            this.$itemContent.invoke(r10, Integer.valueOf(r11), ListProtector.get(this.$items, r11), r12, Integer.valueOf((r0 & 14) | (r0 & 112)));
            if (ComposerKt.isTraceInProgress() == false) goto L31;
            ComposerKt.traceEventEnd();
            return;
        L31:
            return;
        L20:
            r15 = false;
            goto L22
        L5:
            if (r12.changed(r10) == false) goto L7;
            int r1 = 4;
        L8:
            r0 = r1 | r13;
            goto L11
        L7:
            r1 = 2;
            goto L8
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
            invoke((LazyStaggeredGridItemScope) r1, ((Number) r2).intValue(), (Composer) r3, ((Number) r4).intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$itemsIndexed$8, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class C02048 implements Function1<Integer, Object> {
        final /* synthetic */ Function2<Integer, T, Object> $contentType;
        final /* synthetic */ T[] $items;

        /* JADX WARN: Multi-variable type inference failed */
        public C02048(Function2<? super Integer, ? super T, ? extends Object> r1, T[] r2) {
            this.$contentType = r1;
            this.$items = r2;
        }

        public final Object invoke(int r4) {
            return this.$contentType.invoke(Integer.valueOf(r4), this.$items[r4]);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke(((Number) r1).intValue());
        }
    }

    private static final Unit LazyHorizontalStaggeredGrid_121YqSk$lambda$8(StaggeredGridCells r16, Modifier r17, LazyStaggeredGridState r18, PaddingValues r19, boolean r20, Arrangement.Vertical r21, float r22, FlingBehavior r23, boolean r24, OverscrollEffect r25, Function1 r26, int r27, int r28, int r29, Composer r30, int r31) {
        m1207LazyHorizontalStaggeredGrid121YqSk(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r30, RecomposeScopeImplKt.updateChangedFlags(r27 | 1), RecomposeScopeImplKt.updateChangedFlags(r28), r29);
        return Unit.INSTANCE;
    }

    private static final Unit LazyHorizontalStaggeredGrid_cJHQLPU$lambda$9(StaggeredGridCells r14, Modifier r15, LazyStaggeredGridState r16, PaddingValues r17, boolean r18, Arrangement.Vertical r19, float r20, FlingBehavior r21, boolean r22, Function1 r23, int r24, int r25, Composer r26, int r27) {
        m1208LazyHorizontalStaggeredGridcJHQLPU(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    private static final Unit LazyVerticalStaggeredGrid_6qCrX9Q$lambda$0(StaggeredGridCells r16, Modifier r17, LazyStaggeredGridState r18, PaddingValues r19, boolean r20, float r21, Arrangement.Horizontal r22, FlingBehavior r23, boolean r24, OverscrollEffect r25, Function1 r26, int r27, int r28, int r29, Composer r30, int r31) {
        m1209LazyVerticalStaggeredGrid6qCrX9Q(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r30, RecomposeScopeImplKt.updateChangedFlags(r27 | 1), RecomposeScopeImplKt.updateChangedFlags(r28), r29);
        return Unit.INSTANCE;
    }

    private static final Unit LazyVerticalStaggeredGrid_zadm560$lambda$1(StaggeredGridCells r14, Modifier r15, LazyStaggeredGridState r16, PaddingValues r17, boolean r18, float r19, Arrangement.Horizontal r20, FlingBehavior r21, boolean r22, Function1 r23, int r24, int r25, Composer r26, int r27) {
        m1210LazyVerticalStaggeredGridzadm560(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(StaggeredGridCells r0, Modifier r1, LazyStaggeredGridState r2, PaddingValues r3, boolean r4, float r5, Arrangement.Horizontal r6, FlingBehavior r7, boolean r8, OverscrollEffect r9, Function1 r10, int r11, int r12, int r13, Composer r14, int r15) {
        return LazyVerticalStaggeredGrid_6qCrX9Q$lambda$0(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ LazyStaggeredGridSlots b(PaddingValues r0, StaggeredGridCells r1, Arrangement.Vertical r2, Density r3, Constraints r4) {
        return rememberRowSlots$lambda$15$lambda$14(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ LazyStaggeredGridSlots c(PaddingValues r0, StaggeredGridCells r1, Arrangement.Horizontal r2, Density r3, Constraints r4) {
        return rememberColumnSlots$lambda$7$lambda$6(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit d(StaggeredGridCells r0, Modifier r1, LazyStaggeredGridState r2, PaddingValues r3, boolean r4, Arrangement.Vertical r5, float r6, FlingBehavior r7, boolean r8, OverscrollEffect r9, Function1 r10, int r11, int r12, int r13, Composer r14, int r15) {
        return LazyHorizontalStaggeredGrid_121YqSk$lambda$8(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ Unit e(StaggeredGridCells r0, Modifier r1, LazyStaggeredGridState r2, PaddingValues r3, boolean r4, float r5, Arrangement.Horizontal r6, FlingBehavior r7, boolean r8, Function1 r9, int r10, int r11, Composer r12, int r13) {
        return LazyVerticalStaggeredGrid_zadm560$lambda$1(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit f(StaggeredGridCells r0, Modifier r1, LazyStaggeredGridState r2, PaddingValues r3, boolean r4, Arrangement.Vertical r5, float r6, FlingBehavior r7, boolean r8, Function1 r9, int r10, int r11, Composer r12, int r13) {
        return LazyHorizontalStaggeredGrid_cJHQLPU$lambda$9(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    private static final LazyGridStaggeredGridSlotsProvider rememberColumnSlots(final StaggeredGridCells r5, final Arrangement.Horizontal r6, final PaddingValues r7, Composer r8, int r9) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1267076841, r9, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberColumnSlots (LazyStaggeredGridDsl.kt:134)");
    L5:
        boolean r2 = false;
        if (((r9 & 14) ^ 6) <= 4) goto L10;
        if (r8.changed(r5) == false) goto L10;
    L11:
        boolean r0 = true;
    L14:
        if (((r9 & 112) ^ 48) <= 32) goto L18;
        if (r8.changed(r6) == false) goto L18;
    L19:
        boolean r1 = true;
    L21:
        boolean r3 = r0 | r1;
        if (((r9 & 896) ^ 384) <= 256) goto L26;
        if (r8.changed(r7) == false) goto L26;
    L27:
        r2 = true;
    L28:
        boolean r10 = r3 | r2;
        Object r4 = r8.rememberedValue();
        if (r10 == false) goto L31;
    L32:
        r4 = new LazyStaggeredGridSlotCache(new b(r7, r5, r6));
        r8.updateRememberedValue(r4);
    L33:
        LazyGridStaggeredGridSlotsProvider r11 = (LazyGridStaggeredGridSlotsProvider) r4;
        if (ComposerKt.isTraceInProgress() == false) goto L36;
        ComposerKt.traceEventEnd();
    L36:
        return r11;
    L31:
        if (r4 != Composer.Companion.getEmpty()) goto L33;
    L26:
        if ((r9 & 384) != 256) goto L28;
    L18:
        if ((r9 & 48) == 32) goto L19;
        r1 = false;
    L10:
        if ((r9 & 6) == 4) goto L11;
        r0 = false;
        goto L14
    }

    private static final LazyStaggeredGridSlots rememberColumnSlots$lambda$7$lambda$6(PaddingValues r7, StaggeredGridCells r8, Arrangement.Horizontal r9, Density r10, Constraints r11) {
        if (Constraints.getMaxWidth-impl(r11.unbox-impl()) == Integer.MAX_VALUE) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("LazyVerticalStaggeredGrid's width should be bound by parent.");
    L8:
        LayoutDirection r5 = LayoutDirection.Ltr;
        float r12 = Dp.constructor-impl(PaddingKt.calculateStartPadding(r7, r5) + PaddingKt.calculateEndPadding(r7, r5));
        int r3 = Constraints.getMaxWidth-impl(r11.unbox-impl()) - r10.roundToPx-0680j_4(r12);
        int[] r13 = r8.calculateCrossAxisCellSizes(r10, r3, r10.roundToPx-0680j_4(r9.mo812getSpacingD9Ej5fM()));
        int[] r14 = new int[r13.length];
        r9.arrange(r10, r3, r13, r5, r14);
        return new LazyStaggeredGridSlots(r14, r13);
    L5:
        r0 = false;
        goto L6
    }

    private static final LazyGridStaggeredGridSlotsProvider rememberRowSlots(final StaggeredGridCells r5, final Arrangement.Vertical r6, final PaddingValues r7, Composer r8, int r9) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1532383053, r9, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberRowSlots (LazyStaggeredGridDsl.kt:255)");
    L5:
        boolean r2 = false;
        if (((r9 & 14) ^ 6) <= 4) goto L10;
        if (r8.changed(r5) == false) goto L10;
    L11:
        boolean r0 = true;
    L14:
        if (((r9 & 112) ^ 48) <= 32) goto L18;
        if (r8.changed(r6) == false) goto L18;
    L19:
        boolean r1 = true;
    L21:
        boolean r3 = r0 | r1;
        if (((r9 & 896) ^ 384) <= 256) goto L26;
        if (r8.changed(r7) == false) goto L26;
    L27:
        r2 = true;
    L28:
        boolean r10 = r3 | r2;
        Object r4 = r8.rememberedValue();
        if (r10 == false) goto L31;
    L32:
        r4 = new LazyStaggeredGridSlotCache(new c(r7, r5, r6));
        r8.updateRememberedValue(r4);
    L33:
        LazyGridStaggeredGridSlotsProvider r11 = (LazyGridStaggeredGridSlotsProvider) r4;
        if (ComposerKt.isTraceInProgress() == false) goto L36;
        ComposerKt.traceEventEnd();
    L36:
        return r11;
    L31:
        if (r4 != Composer.Companion.getEmpty()) goto L33;
    L26:
        if ((r9 & 384) != 256) goto L28;
    L18:
        if ((r9 & 48) == 32) goto L19;
        r1 = false;
    L10:
        if ((r9 & 6) == 4) goto L11;
        r0 = false;
        goto L14
    }

    private static final LazyStaggeredGridSlots rememberRowSlots$lambda$15$lambda$14(PaddingValues r2, StaggeredGridCells r3, Arrangement.Vertical r4, Density r5, Constraints r6) {
        if (Constraints.getMaxHeight-impl(r6.unbox-impl()) == Integer.MAX_VALUE) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("LazyHorizontalStaggeredGrid's height should be bound by parent.");
    L8:
        float r7 = Dp.constructor-impl(r2.mo901calculateTopPaddingD9Ej5fM() + r2.mo898calculateBottomPaddingD9Ej5fM());
        int r8 = Constraints.getMaxHeight-impl(r6.unbox-impl()) - r5.roundToPx-0680j_4(r7);
        int[] r9 = r3.calculateCrossAxisCellSizes(r5, r8, r5.roundToPx-0680j_4(r4.mo812getSpacingD9Ej5fM()));
        int[] r10 = new int[r9.length];
        r4.arrange(r5, r8, r9, r10);
        return new LazyStaggeredGridSlots(r10, r9);
    L5:
        r0 = false;
        goto L6
    }

    public static final <T> void items(LazyStaggeredGridScope r3, List<? extends T> r4, Function1<? super T, ? extends Object> r5, Function1<? super T, ? extends Object> r6, Function1<? super T, StaggeredGridItemSpan> r7, Function4<? super LazyStaggeredGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> r8) {
        int r0 = r4.size();
        if (r5 == null) goto L5;
        LazyStaggeredGridDslKt$items$2$1 r9 = new LazyStaggeredGridDslKt$items$2$1(r5, r4);
    L6:
        AnonymousClass3 r2 = new AnonymousClass3(r6, r4);
        if (r7 == null) goto L9;
        LazyStaggeredGridDslKt$items$4$1 r10 = new LazyStaggeredGridDslKt$items$4$1(r7, r4);
    L10:
        r3.items(r0, r9, r2, r10, ComposableLambdaKt.composableLambdaInstance(-334987442, true, new AnonymousClass5(r8, r4)));
        return;
    L9:
        r10 = null;
        goto L10
    L5:
        r9 = null;
        goto L6
    }

    public static final <T> void itemsIndexed(LazyStaggeredGridScope r3, List<? extends T> r4, Function2<? super Integer, ? super T, ? extends Object> r5, Function2<? super Integer, ? super T, ? extends Object> r6, Function2<? super Integer, ? super T, StaggeredGridItemSpan> r7, Function5<? super LazyStaggeredGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> r8) {
        int r0 = r4.size();
        if (r5 == null) goto L5;
        LazyStaggeredGridDslKt$itemsIndexed$2$1 r9 = new LazyStaggeredGridDslKt$itemsIndexed$2$1(r5, r4);
    L6:
        C02013 r2 = new C02013(r6, r4);
        if (r7 == null) goto L9;
        LazyStaggeredGridDslKt$itemsIndexed$4$1 r10 = new LazyStaggeredGridDslKt$itemsIndexed$4$1(r7, r4);
    L10:
        r3.items(r0, r9, r2, r10, ComposableLambdaKt.composableLambdaInstance(-1466459515, true, new C02025(r8, r4)));
        return;
    L9:
        r10 = null;
        goto L10
    L5:
        r9 = null;
        goto L6
    }

    public static final <T> void items(LazyStaggeredGridScope r3, T[] r4, Function1<? super T, ? extends Object> r5, Function1<? super T, ? extends Object> r6, Function1<? super T, StaggeredGridItemSpan> r7, Function4<? super LazyStaggeredGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> r8) {
        int r0 = r4.length;
        if (r5 == null) goto L5;
        LazyStaggeredGridDslKt$items$7$1 r9 = new LazyStaggeredGridDslKt$items$7$1(r5, r4);
    L6:
        AnonymousClass8 r2 = new AnonymousClass8(r6, r4);
        if (r7 == null) goto L9;
        LazyStaggeredGridDslKt$items$9$1 r10 = new LazyStaggeredGridDslKt$items$9$1(r7, r4);
    L10:
        r3.items(r0, r9, r2, r10, ComposableLambdaKt.composableLambdaInstance(-1775984467, true, new AnonymousClass10(r8, r4)));
        return;
    L9:
        r10 = null;
        goto L10
    L5:
        r9 = null;
        goto L6
    }

    public static final <T> void itemsIndexed(LazyStaggeredGridScope r3, T[] r4, Function2<? super Integer, ? super T, ? extends Object> r5, Function2<? super Integer, ? super T, ? extends Object> r6, Function2<? super Integer, ? super T, StaggeredGridItemSpan> r7, Function5<? super LazyStaggeredGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> r8) {
        int r0 = r4.length;
        if (r5 == null) goto L5;
        LazyStaggeredGridDslKt$itemsIndexed$7$1 r9 = new LazyStaggeredGridDslKt$itemsIndexed$7$1(r5, r4);
    L6:
        C02048 r2 = new C02048(r6, r4);
        if (r7 == null) goto L9;
        LazyStaggeredGridDslKt$itemsIndexed$9$1 r10 = new LazyStaggeredGridDslKt$itemsIndexed$9$1(r7, r4);
    L10:
        r3.items(r0, r9, r2, r10, ComposableLambdaKt.composableLambdaInstance(425846862, true, new C020010(r8, r4)));
        return;
    L9:
        r10 = null;
        goto L10
    L5:
        r9 = null;
        goto L6
    }

    public static /* synthetic */ void items$default(LazyStaggeredGridScope r7, List r8, Function1 r9, Function1 r10, Function1 r11, Function4 r12, int r13, Object r14) {
        LazyStaggeredGridDslKt$items$4$1 r0 = null;
        if ((r13 & 2) == 0) goto L6;
        r9 = null;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r10 = AnonymousClass1.INSTANCE;
    L9:
        if ((r13 & 8) == 0) goto L11;
        r11 = null;
    L11:
        int r2 = r8.size();
        if (r9 == null) goto L14;
        LazyStaggeredGridDslKt$items$2$1 r3 = new LazyStaggeredGridDslKt$items$2$1(r9, r8);
    L15:
        AnonymousClass3 r4 = new AnonymousClass3(r10, r8);
        if (r11 == null) goto L18;
        r0 = new LazyStaggeredGridDslKt$items$4$1(r11, r8);
    L18:
        r7.items(r2, r3, r4, r0, ComposableLambdaKt.composableLambdaInstance(-334987442, true, new AnonymousClass5(r12, r8)));
        return;
    L14:
        r3 = null;
        goto L15
    }

    public static /* synthetic */ void itemsIndexed$default(LazyStaggeredGridScope r7, List r8, Function2 r9, Function2 r10, Function2 r11, Function5 r12, int r13, Object r14) {
        LazyStaggeredGridDslKt$itemsIndexed$4$1 r0 = null;
        if ((r13 & 2) == 0) goto L6;
        r9 = null;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r10 = C01991.INSTANCE;
    L9:
        if ((r13 & 8) == 0) goto L11;
        r11 = null;
    L11:
        int r2 = r8.size();
        if (r9 == null) goto L14;
        LazyStaggeredGridDslKt$itemsIndexed$2$1 r3 = new LazyStaggeredGridDslKt$itemsIndexed$2$1(r9, r8);
    L15:
        C02013 r4 = new C02013(r10, r8);
        if (r11 == null) goto L18;
        r0 = new LazyStaggeredGridDslKt$itemsIndexed$4$1(r11, r8);
    L18:
        r7.items(r2, r3, r4, r0, ComposableLambdaKt.composableLambdaInstance(-1466459515, true, new C02025(r12, r8)));
        return;
    L14:
        r3 = null;
        goto L15
    }

    public static /* synthetic */ void items$default(LazyStaggeredGridScope r7, Object[] r8, Function1 r9, Function1 r10, Function1 r11, Function4 r12, int r13, Object r14) {
        LazyStaggeredGridDslKt$items$9$1 r0 = null;
        if ((r13 & 2) == 0) goto L6;
        r9 = null;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r10 = AnonymousClass6.INSTANCE;
    L9:
        if ((r13 & 8) == 0) goto L11;
        r11 = null;
    L11:
        int r2 = r8.length;
        if (r9 == null) goto L14;
        LazyStaggeredGridDslKt$items$7$1 r3 = new LazyStaggeredGridDslKt$items$7$1(r9, r8);
    L15:
        AnonymousClass8 r4 = new AnonymousClass8(r10, r8);
        if (r11 == null) goto L18;
        r0 = new LazyStaggeredGridDslKt$items$9$1(r11, r8);
    L18:
        r7.items(r2, r3, r4, r0, ComposableLambdaKt.composableLambdaInstance(-1775984467, true, new AnonymousClass10(r12, r8)));
        return;
    L14:
        r3 = null;
        goto L15
    }

    public static /* synthetic */ void itemsIndexed$default(LazyStaggeredGridScope r7, Object[] r8, Function2 r9, Function2 r10, Function2 r11, Function5 r12, int r13, Object r14) {
        LazyStaggeredGridDslKt$itemsIndexed$9$1 r0 = null;
        if ((r13 & 2) == 0) goto L6;
        r9 = null;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r10 = C02036.INSTANCE;
    L9:
        if ((r13 & 8) == 0) goto L11;
        r11 = null;
    L11:
        int r2 = r8.length;
        if (r9 == null) goto L14;
        LazyStaggeredGridDslKt$itemsIndexed$7$1 r3 = new LazyStaggeredGridDslKt$itemsIndexed$7$1(r9, r8);
    L15:
        C02048 r4 = new C02048(r10, r8);
        if (r11 == null) goto L18;
        r0 = new LazyStaggeredGridDslKt$itemsIndexed$9$1(r11, r8);
    L18:
        r7.items(r2, r3, r4, r0, ComposableLambdaKt.composableLambdaInstance(425846862, true, new C020010(r12, r8)));
        return;
    L14:
        r3 = null;
        goto L15
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /* JADX INFO: renamed from: LazyHorizontalStaggeredGrid-cJHQLPU, reason: not valid java name */
    public static final /* synthetic */ void m1208LazyHorizontalStaggeredGridcJHQLPU(final StaggeredGridCells r29, Modifier r30, LazyStaggeredGridState r31, PaddingValues r32, boolean r33, Arrangement.Vertical r34, float r35, FlingBehavior r36, boolean r37, final Function1 r38, Composer r39, final int r40, final int r41) {
        Composer r1 = r39.startRestartGroup(-8666074);
        if ((r41 & 1) == 0) goto L6;
        int r3 = r40 | 6;
    L13:
        int r4 = r41 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L25:
        if ((r40 & 384) != 0) goto L35;
        if ((r41 & 4) != 0) goto L32;
        if (r1.changed(r31) == false) goto L32;
        int r7 = 256;
    L33:
        r3 = r3 | r7;
    L32:
        r7 = 128;
    L35:
        int r8 = r41 & 8;
        if (r8 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        PaddingValues r9 = r32;
    L46:
        int r10 = r41 & 16;
        if (r10 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        boolean r11 = r33;
    L57:
        int r13 = r41 & 32;
        if (r13 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        Arrangement.Vertical r14 = r34;
    L68:
        int r15 = r41 & 64;
        if (r15 == 0) goto L72;
        r3 = r3 | 1572864;
    L79:
        if ((r40 & 12582912) != 0) goto L89;
        if ((r41 & 128) != 0) goto L86;
        if (r1.changed(r36) == false) goto L86;
        int r17 = 8388608;
    L87:
        r3 = r3 | r17;
    L86:
        r17 = 4194304;
    L89:
        int r0 = r41 & 256;
        if (r0 == 0) goto L93;
        r3 = r3 | 100663296;
    L100:
        if ((r41 & 512) == 0) goto L103;
        r3 = r3 | 805306368;
    L111:
        if ((r3 & 306783379) == 306783378) goto L113;
        boolean r2 = true;
    L115:
        if (r1.shouldExecute(r2, r3 & 1) == false) goto L162;
        r1.startDefaults();
        if ((r40 & 1) != 0) goto L119;
    L129:
        if (r4 == 0) goto L131;
        final Modifier r5 = Modifier.Companion;
    L133:
        if ((r41 & 4) == 0) goto L135;
        LazyStaggeredGridState r6 = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, r1, 0, 3);
        r3 = r3 & (-897);
    L136:
        if (r8 == 0) goto L138;
        PaddingValues r12 = PaddingKt.m953PaddingValues0680j_4(Dp.constructor-impl(0));
    L139:
        if (r10 == 0) goto L141;
        r11 = false;
    L141:
        if (r13 == 0) goto L143;
        Arrangement.Vertical r16 = Arrangement.INSTANCE.m806spacedBy0680j_4(Dp.constructor-impl(0));
    L144:
        if (r15 == 0) goto L146;
        float r18 = Dp.constructor-impl(0);
    L148:
        if ((r41 & 128) == 0) goto L150;
        FlingBehavior r19 = ScrollableDefaults.INSTANCE.flingBehavior(r1, 6);
        r3 = r3 & (-29360129);
    L151:
        int r20 = r3;
        if (r0 == 0) goto L154;
        FlingBehavior r21 = r19;
        boolean r22 = true;
    L155:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L158;
        ComposerKt.traceEventStart(-8666074, r20, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:232)");
    L158:
        m1207LazyHorizontalStaggeredGrid121YqSk(r29, r5, r6, r12, r11, r16, r18, r21, r22, OverscrollKt.rememberOverscrollEffect(r1, 0), r38, r1, ((((((((r20 & 14) | (r20 & 112)) | (r20 & 896)) | (r20 & 7168)) | (57344 & r20)) | (458752 & r20)) | (3670016 & r20)) | (29360128 & r20)) | (234881024 & r20), (r20 >> 27) & 14, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L161;
        ComposerKt.traceEventEnd();
    L161:
        final Arrangement.Vertical r23 = r16;
        final boolean r24 = r11;
        final FlingBehavior r25 = r21;
        float r28 = r18;
        final boolean r26 = r22;
        final LazyStaggeredGridState r27 = r6;
        final PaddingValues r42 = r12;
        final float r43 = r28;
    L163:
        ScopeUpdateScope r110 = r1.endRestartGroup();
        if (r110 == null) goto L167;
        r110.updateScope(new a(r29, r5, r27, r42, r24, r23, r43, r25, r26, r38, r40, r41));
        return;
    L167:
        return;
    L154:
        r21 = r19;
    L128:
        r22 = r37;
        goto L155
    L150:
        r19 = r36;
        goto L151
    L146:
        r18 = r35;
        goto L148
    L143:
        r16 = r14;
        goto L144
    L138:
        r12 = r9;
        goto L139
    L135:
        r6 = r31;
        goto L136
    L131:
        r5 = r30;
        goto L133
    L119:
        if (r1.getDefaultsInvalid() == true) goto L129;
        r1.skipToGroupEnd();
        if ((r41 & 4) == 0) goto L125;
        r3 = r3 & (-897);
    L125:
        if ((r41 & 128) == 0) goto L127;
        r3 = r3 & (-29360129);
    L127:
        r5 = r30;
        r6 = r31;
        r18 = r35;
        r21 = r36;
        r20 = r3;
        r12 = r9;
        r16 = r14;
        goto L128
    L162:
        r1.skipToGroupEnd();
        r5 = r30;
        r27 = r31;
        r43 = r35;
        r26 = r37;
        r42 = r9;
        r24 = r11;
        r23 = r14;
        r25 = r36;
        goto L163
    L113:
        r2 = false;
        goto L115
    L103:
        if ((r40 & 805306368) != 0) goto L111;
        if (r1.changedInstance(r38) == false) goto L107;
        int r111 = 536870912;
    L108:
        r3 = r3 | r111;
        goto L111
    L107:
        r111 = 268435456;
        goto L108
    L93:
        if ((r40 & 100663296) != 0) goto L100;
        if (r1.changed(r37) == false) goto L97;
        int r112 = 67108864;
    L98:
        r3 = r3 | r112;
        goto L100
    L97:
        r112 = 33554432;
        goto L98
    L72:
        if ((r40 & 1572864) != 0) goto L79;
        if (r1.changed(r35) == false) goto L76;
        int r113 = 1048576;
    L77:
        r3 = r3 | r113;
        goto L79
    L76:
        r113 = 524288;
        goto L77
    L61:
        if ((196608 & r40) != 0) goto L67;
        r14 = r34;
        if (r1.changed(r14) == false) goto L65;
        int r114 = 131072;
    L66:
        r3 = r3 | r114;
        goto L68
    L65:
        r114 = 65536;
        goto L66
    L50:
        if ((r40 & 24576) != 0) goto L56;
        r11 = r33;
        if (r1.changed(r11) == false) goto L54;
        int r115 = 16384;
    L55:
        r3 = r3 | r115;
        goto L57
    L54:
        r115 = 8192;
        goto L55
    L39:
        if ((r40 & 3072) != 0) goto L45;
        r9 = r32;
        if (r1.changed(r9) == false) goto L43;
        int r44 = 2048;
    L44:
        r3 = r3 | r44;
        goto L46
    L43:
        r44 = 1024;
        goto L44
    L17:
        if ((r40 & 48) != 0) goto L25;
        if (r1.changed(r30) == false) goto L21;
        int r45 = 32;
    L22:
        r3 = r3 | r45;
        goto L25
    L21:
        r45 = 16;
        goto L22
    L6:
        if ((r40 & 6) == 0) goto L8;
        r3 = r40;
        goto L13
    L8:
        if (r1.changed(r29) == false) goto L10;
        int r46 = 4;
    L11:
        r3 = r46 | r40;
        goto L13
    L10:
        r46 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /* JADX INFO: renamed from: LazyVerticalStaggeredGrid-zadm560, reason: not valid java name */
    public static final /* synthetic */ void m1210LazyVerticalStaggeredGridzadm560(final StaggeredGridCells r29, Modifier r30, LazyStaggeredGridState r31, PaddingValues r32, boolean r33, float r34, Arrangement.Horizontal r35, FlingBehavior r36, boolean r37, final Function1 r38, Composer r39, final int r40, final int r41) {
        Composer r1 = r39.startRestartGroup(1695323794);
        if ((r41 & 1) == 0) goto L6;
        int r3 = r40 | 6;
    L13:
        int r4 = r41 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L25:
        if ((r40 & 384) != 0) goto L35;
        if ((r41 & 4) != 0) goto L32;
        if (r1.changed(r31) == false) goto L32;
        int r7 = 256;
    L33:
        r3 = r3 | r7;
    L32:
        r7 = 128;
    L35:
        int r8 = r41 & 8;
        if (r8 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        PaddingValues r9 = r32;
    L46:
        int r10 = r41 & 16;
        if (r10 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        boolean r11 = r33;
    L57:
        int r13 = r41 & 32;
        if (r13 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        float r14 = r34;
    L68:
        int r15 = r41 & 64;
        if (r15 == 0) goto L72;
        r3 = r3 | 1572864;
    L79:
        if ((r40 & 12582912) != 0) goto L89;
        if ((r41 & 128) != 0) goto L86;
        if (r1.changed(r36) == false) goto L86;
        int r17 = 8388608;
    L87:
        r3 = r3 | r17;
    L86:
        r17 = 4194304;
    L89:
        int r0 = r41 & 256;
        if (r0 == 0) goto L93;
        r3 = r3 | 100663296;
    L100:
        if ((r41 & 512) == 0) goto L103;
        r3 = r3 | 805306368;
    L111:
        if ((r3 & 306783379) == 306783378) goto L113;
        boolean r2 = true;
    L115:
        if (r1.shouldExecute(r2, r3 & 1) == false) goto L162;
        r1.startDefaults();
        if ((r40 & 1) != 0) goto L119;
    L129:
        if (r4 == 0) goto L131;
        final Modifier r5 = Modifier.Companion;
    L133:
        if ((r41 & 4) == 0) goto L135;
        LazyStaggeredGridState r6 = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, r1, 0, 3);
        r3 = r3 & (-897);
    L136:
        if (r8 == 0) goto L138;
        PaddingValues r12 = PaddingKt.m953PaddingValues0680j_4(Dp.constructor-impl(0));
    L139:
        if (r10 == 0) goto L141;
        r11 = false;
    L141:
        if (r13 == 0) goto L143;
        float r16 = Dp.constructor-impl(0);
    L144:
        if (r15 == 0) goto L146;
        Arrangement.Horizontal r18 = Arrangement.INSTANCE.m806spacedBy0680j_4(Dp.constructor-impl(0));
    L148:
        if ((r41 & 128) == 0) goto L150;
        FlingBehavior r19 = ScrollableDefaults.INSTANCE.flingBehavior(r1, 6);
        r3 = r3 & (-29360129);
    L151:
        int r20 = r3;
        if (r0 == 0) goto L154;
        FlingBehavior r21 = r19;
        boolean r22 = true;
    L155:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L158;
        ComposerKt.traceEventStart(1695323794, r20, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:111)");
    L158:
        m1209LazyVerticalStaggeredGrid6qCrX9Q(r29, r5, r6, r12, r11, r16, r18, r21, r22, OverscrollKt.rememberOverscrollEffect(r1, 0), r38, r1, ((((((((r20 & 14) | (r20 & 112)) | (r20 & 896)) | (r20 & 7168)) | (57344 & r20)) | (458752 & r20)) | (3670016 & r20)) | (29360128 & r20)) | (234881024 & r20), (r20 >> 27) & 14, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L161;
        ComposerKt.traceEventEnd();
    L161:
        final float r23 = r16;
        final boolean r24 = r11;
        final FlingBehavior r25 = r21;
        Arrangement.Horizontal r28 = r18;
        final boolean r26 = r22;
        final LazyStaggeredGridState r27 = r6;
        final PaddingValues r42 = r12;
        final Arrangement.Horizontal r43 = r28;
    L163:
        ScopeUpdateScope r110 = r1.endRestartGroup();
        if (r110 == null) goto L167;
        r110.updateScope(new d(r29, r5, r27, r42, r24, r23, r43, r25, r26, r38, r40, r41));
        return;
    L167:
        return;
    L154:
        r21 = r19;
    L128:
        r22 = r37;
        goto L155
    L150:
        r19 = r36;
        goto L151
    L146:
        r18 = r35;
        goto L148
    L143:
        r16 = r14;
        goto L144
    L138:
        r12 = r9;
        goto L139
    L135:
        r6 = r31;
        goto L136
    L131:
        r5 = r30;
        goto L133
    L119:
        if (r1.getDefaultsInvalid() == true) goto L129;
        r1.skipToGroupEnd();
        if ((r41 & 4) == 0) goto L125;
        r3 = r3 & (-897);
    L125:
        if ((r41 & 128) == 0) goto L127;
        r3 = r3 & (-29360129);
    L127:
        r5 = r30;
        r6 = r31;
        r18 = r35;
        r21 = r36;
        r20 = r3;
        r12 = r9;
        r16 = r14;
        goto L128
    L162:
        r1.skipToGroupEnd();
        r5 = r30;
        r27 = r31;
        r43 = r35;
        r26 = r37;
        r42 = r9;
        r24 = r11;
        r23 = r14;
        r25 = r36;
        goto L163
    L113:
        r2 = false;
        goto L115
    L103:
        if ((r40 & 805306368) != 0) goto L111;
        if (r1.changedInstance(r38) == false) goto L107;
        int r111 = 536870912;
    L108:
        r3 = r3 | r111;
        goto L111
    L107:
        r111 = 268435456;
        goto L108
    L93:
        if ((r40 & 100663296) != 0) goto L100;
        if (r1.changed(r37) == false) goto L97;
        int r112 = 67108864;
    L98:
        r3 = r3 | r112;
        goto L100
    L97:
        r112 = 33554432;
        goto L98
    L72:
        if ((r40 & 1572864) != 0) goto L79;
        if (r1.changed(r35) == false) goto L76;
        int r113 = 1048576;
    L77:
        r3 = r3 | r113;
        goto L79
    L76:
        r113 = 524288;
        goto L77
    L61:
        if ((196608 & r40) != 0) goto L67;
        r14 = r34;
        if (r1.changed(r14) == false) goto L65;
        int r114 = 131072;
    L66:
        r3 = r3 | r114;
        goto L68
    L65:
        r114 = 65536;
        goto L66
    L50:
        if ((r40 & 24576) != 0) goto L56;
        r11 = r33;
        if (r1.changed(r11) == false) goto L54;
        int r115 = 16384;
    L55:
        r3 = r3 | r115;
        goto L57
    L54:
        r115 = 8192;
        goto L55
    L39:
        if ((r40 & 3072) != 0) goto L45;
        r9 = r32;
        if (r1.changed(r9) == false) goto L43;
        int r44 = 2048;
    L44:
        r3 = r3 | r44;
        goto L46
    L43:
        r44 = 1024;
        goto L44
    L17:
        if ((r40 & 48) != 0) goto L25;
        if (r1.changed(r30) == false) goto L21;
        int r45 = 32;
    L22:
        r3 = r3 | r45;
        goto L25
    L21:
        r45 = 16;
        goto L22
    L6:
        if ((r40 & 6) == 0) goto L8;
        r3 = r40;
        goto L13
    L8:
        if (r1.changed(r29) == false) goto L10;
        int r46 = 4;
    L11:
        r3 = r46 | r40;
        goto L13
    L10:
        r46 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: LazyHorizontalStaggeredGrid-121YqSk, reason: not valid java name */
    public static final void m1207LazyHorizontalStaggeredGrid121YqSk(final StaggeredGridCells r33, Modifier r34, LazyStaggeredGridState r35, PaddingValues r36, boolean r37, Arrangement.Vertical r38, float r39, FlingBehavior r40, boolean r41, OverscrollEffect r42, final Function1<? super LazyStaggeredGridScope, Unit> r43, Composer r44, final int r45, final int r46, final int r47) {
        Composer r2 = r44.startRestartGroup(-670735644);
        if ((r47 & 1) == 0) goto L6;
        int r3 = r45 | 6;
    L13:
        int r6 = r47 & 2;
        if (r6 == 0) goto L17;
        r3 = r3 | 48;
    L25:
        if ((r45 & 384) != 0) goto L35;
        if ((r47 & 4) != 0) goto L32;
        if (r2.changed(r35) == false) goto L32;
        int r9 = 256;
    L33:
        r3 = r3 | r9;
    L32:
        r9 = 128;
    L35:
        int r10 = r47 & 8;
        if (r10 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        PaddingValues r11 = r36;
    L46:
        int r12 = r47 & 16;
        if (r12 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        boolean r13 = r37;
    L57:
        int r15 = r47 & 32;
        if (r15 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        int r16 = r47 & 64;
        if (r16 == 0) goto L71;
        r3 = r3 | 1572864;
    L78:
        if ((r45 & 12582912) != 0) goto L88;
        if ((r47 & 128) != 0) goto L85;
        if (r2.changed(r40) == false) goto L85;
        int r19 = 8388608;
    L86:
        r3 = r3 | r19;
    L85:
        r19 = 4194304;
    L88:
        int r0 = r47 & 256;
        if (r0 == 0) goto L92;
        r3 = r3 | 100663296;
    L99:
        if ((r45 & 805306368) != 0) goto L110;
        if ((r47 & 512) != 0) goto L106;
        if (r2.changed(r42) == false) goto L106;
        int r110 = 536870912;
    L107:
        r3 = r3 | r110;
    L106:
        r110 = 268435456;
    L110:
        if ((r47 & 1024) == 0) goto L113;
        int r4 = r46 | 6;
    L120:
        boolean r111 = true;
        if ((r3 & 306783379) == 306783378) goto L123;
    L126:
        boolean r5 = true;
    L128:
        if (r2.shouldExecute(r5, r3 & 1) == false) goto L181;
        r2.startDefaults();
        if ((r45 & 1) != 0) goto L132;
    L144:
        if (r6 == 0) goto L146;
        Modifier r7 = Modifier.Companion;
    L148:
        if ((r47 & 4) == 0) goto L150;
        int r8 = 0;
        LazyStaggeredGridState r20 = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, r2, 0, 3);
        r3 = r3 & (-897);
    L151:
        if (r10 == 0) goto L153;
        PaddingValues r14 = PaddingKt.m953PaddingValues0680j_4(Dp.constructor-impl(r8));
    L154:
        if (r12 == 0) goto L156;
        r13 = false;
    L156:
        if (r15 == 0) goto L158;
        Arrangement.Vertical r17 = Arrangement.INSTANCE.m806spacedBy0680j_4(Dp.constructor-impl(r8));
    L159:
        if (r16 == 0) goto L161;
        float r18 = Dp.constructor-impl(r8);
    L163:
        if ((r47 & 128) == 0) goto L165;
        FlingBehavior r112 = ScrollableDefaults.INSTANCE.flingBehavior(r2, 6);
        r3 = r3 & (-29360129);
    L166:
        if (r0 != 0) goto L170;
        r111 = r41;
    L170:
        if ((r47 & 512) == 0) goto L172;
        r3 = r3 & (-1879048193);
        OverscrollEffect r21 = OverscrollKt.rememberOverscrollEffect(r2, 0);
    L173:
        int r113 = r3;
        boolean r22 = r111;
        LazyStaggeredGridState r1 = r20;
    L174:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L177;
        ComposerKt.traceEventStart(-670735644, r113, r4, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:202)");
    L177:
        Orientation r114 = Orientation.Horizontal;
        float r25 = r17.mo812getSpacingD9Ej5fM();
        int r115 = r113 >> 3;
        LazyGridStaggeredGridSlotsProvider r116 = rememberRowSlots(r33, r17, r14, r2, ((r113 & 14) | ((r113 >> 12) & 112)) | (r115 & 896));
        int r23 = (((r113 >> 6) & 14) | 48) | ((r113 << 6) & 7168);
        int r117 = r113 << 3;
        LazyStaggeredGridKt.m1215LazyStaggeredGridw41Enmo(r1, r114, r116, r7, r14, r13, r112, r22, r21, r18, r25, r43, r2, (((((r23 | (r117 & 57344)) | (r117 & 458752)) | (3670016 & r115)) | (29360128 & r115)) | (r115 & 234881024)) | ((r113 << 9) & 1879048192), (r4 << 3) & 112, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L180;
        ComposerKt.traceEventEnd();
    L180:
        final PaddingValues r24 = r14;
        final FlingBehavior r26 = r112;
        final boolean r27 = r22;
        final LazyStaggeredGridState r28 = r1;
        OverscrollEffect r32 = r21;
        final float r29 = r18;
        final Arrangement.Vertical r30 = r17;
        final OverscrollEffect r118 = r32;
    L182:
        ScopeUpdateScope r119 = r2.endRestartGroup();
        if (r119 == null) goto L186;
        final Modifier r31 = r7;
        final boolean r48 = r13;
        r119.updateScope(new f(r33, r31, r28, r24, r48, r30, r29, r26, r27, r118, r43, r45, r46, r47));
        return;
    L186:
        return;
    L172:
        r21 = r42;
        goto L173
    L165:
        r112 = r40;
        goto L166
    L161:
        r18 = r39;
        goto L163
    L158:
        r17 = r38;
        goto L159
    L153:
        r14 = r11;
        goto L154
    L150:
        r8 = 0;
        r20 = r35;
        goto L151
    L146:
        r7 = r34;
        goto L148
    L132:
        if (r2.getDefaultsInvalid() == true) goto L144;
        r2.skipToGroupEnd();
        if ((r47 & 4) == 0) goto L138;
        r3 = r3 & (-897);
    L138:
        if ((r47 & 128) == 0) goto L141;
        r3 = r3 & (-29360129);
    L141:
        if ((r47 & 512) == 0) goto L143;
        r3 = r3 & (-1879048193);
    L143:
        r7 = r34;
        r1 = r35;
        r18 = r39;
        r112 = r40;
        r21 = r42;
        r113 = r3;
        r14 = r11;
        r17 = r38;
        r22 = r41;
        goto L174
    L181:
        r2.skipToGroupEnd();
        r7 = r34;
        r28 = r35;
        r30 = r38;
        r29 = r39;
        r26 = r40;
        r27 = r41;
        r24 = r11;
        r118 = r42;
        goto L182
    L123:
        if ((r4 & 3) != 2) goto L126;
        r5 = false;
        goto L128
    L113:
        if ((r46 & 6) == 0) goto L115;
        r4 = r46;
        goto L120
    L115:
        if (r2.changedInstance(r43) == false) goto L117;
        int r120 = 4;
    L118:
        r4 = r46 | r120;
        goto L120
    L117:
        r120 = 2;
        goto L118
    L92:
        if ((r45 & 100663296) != 0) goto L99;
        if (r2.changed(r41) == false) goto L96;
        int r121 = 67108864;
    L97:
        r3 = r3 | r121;
        goto L99
    L96:
        r121 = 33554432;
        goto L97
    L71:
        if ((r45 & 1572864) != 0) goto L78;
        if (r2.changed(r39) == false) goto L75;
        int r122 = 1048576;
    L76:
        r3 = r3 | r122;
        goto L78
    L75:
        r122 = 524288;
        goto L76
    L61:
        if ((r45 & 196608) != 0) goto L67;
        if (r2.changed(r38) == false) goto L65;
        int r123 = 131072;
    L66:
        r3 = r3 | r123;
        goto L67
    L65:
        r123 = 65536;
        goto L66
    L50:
        if ((r45 & 24576) != 0) goto L56;
        r13 = r37;
        if (r2.changed(r13) == false) goto L54;
        int r124 = 16384;
    L55:
        r3 = r3 | r124;
        goto L57
    L54:
        r124 = 8192;
        goto L55
    L39:
        if ((r45 & 3072) != 0) goto L45;
        r11 = r36;
        if (r2.changed(r11) == false) goto L43;
        int r125 = 2048;
    L44:
        r3 = r3 | r125;
        goto L46
    L43:
        r125 = 1024;
        goto L44
    L17:
        if ((r45 & 48) != 0) goto L25;
        if (r2.changed(r34) == false) goto L21;
        int r49 = 32;
    L22:
        r3 = r3 | r49;
        goto L25
    L21:
        r49 = 16;
        goto L22
    L6:
        if ((r45 & 6) == 0) goto L8;
        r3 = r45;
        goto L13
    L8:
        if (r2.changed(r33) == false) goto L10;
        int r50 = 4;
    L11:
        r3 = r50 | r45;
        goto L13
    L10:
        r50 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: LazyVerticalStaggeredGrid-6qCrX9Q, reason: not valid java name */
    public static final void m1209LazyVerticalStaggeredGrid6qCrX9Q(final StaggeredGridCells r33, Modifier r34, LazyStaggeredGridState r35, PaddingValues r36, boolean r37, float r38, Arrangement.Horizontal r39, FlingBehavior r40, boolean r41, OverscrollEffect r42, final Function1<? super LazyStaggeredGridScope, Unit> r43, Composer r44, final int r45, final int r46, final int r47) {
        Composer r2 = r44.startRestartGroup(-578931208);
        if ((r47 & 1) == 0) goto L6;
        int r3 = r45 | 6;
    L13:
        int r6 = r47 & 2;
        if (r6 == 0) goto L17;
        r3 = r3 | 48;
    L25:
        if ((r45 & 384) != 0) goto L35;
        if ((r47 & 4) != 0) goto L32;
        if (r2.changed(r35) == false) goto L32;
        int r9 = 256;
    L33:
        r3 = r3 | r9;
    L32:
        r9 = 128;
    L35:
        int r10 = r47 & 8;
        if (r10 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        PaddingValues r11 = r36;
    L46:
        int r12 = r47 & 16;
        if (r12 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        boolean r13 = r37;
    L57:
        int r15 = r47 & 32;
        if (r15 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        int r16 = r47 & 64;
        if (r16 == 0) goto L71;
        r3 = r3 | 1572864;
    L78:
        if ((r45 & 12582912) != 0) goto L88;
        if ((r47 & 128) != 0) goto L85;
        if (r2.changed(r40) == false) goto L85;
        int r19 = 8388608;
    L86:
        r3 = r3 | r19;
    L85:
        r19 = 4194304;
    L88:
        int r0 = r47 & 256;
        if (r0 == 0) goto L92;
        r3 = r3 | 100663296;
    L99:
        if ((r45 & 805306368) != 0) goto L110;
        if ((r47 & 512) != 0) goto L106;
        if (r2.changed(r42) == false) goto L106;
        int r110 = 536870912;
    L107:
        r3 = r3 | r110;
    L106:
        r110 = 268435456;
    L110:
        if ((r47 & 1024) == 0) goto L113;
        int r4 = r46 | 6;
    L120:
        boolean r111 = true;
        if ((r3 & 306783379) == 306783378) goto L123;
    L126:
        boolean r5 = true;
    L128:
        if (r2.shouldExecute(r5, r3 & 1) == false) goto L181;
        r2.startDefaults();
        if ((r45 & 1) != 0) goto L132;
    L144:
        if (r6 == 0) goto L146;
        Modifier r7 = Modifier.Companion;
    L148:
        if ((r47 & 4) == 0) goto L150;
        int r8 = 0;
        LazyStaggeredGridState r20 = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, r2, 0, 3);
        r3 = r3 & (-897);
    L151:
        if (r10 == 0) goto L153;
        PaddingValues r14 = PaddingKt.m953PaddingValues0680j_4(Dp.constructor-impl(r8));
    L154:
        if (r12 == 0) goto L156;
        r13 = false;
    L156:
        if (r15 == 0) goto L158;
        float r17 = Dp.constructor-impl(r8);
    L159:
        if (r16 == 0) goto L161;
        Arrangement.Horizontal r18 = Arrangement.INSTANCE.m806spacedBy0680j_4(Dp.constructor-impl(r8));
    L163:
        if ((r47 & 128) == 0) goto L165;
        FlingBehavior r112 = ScrollableDefaults.INSTANCE.flingBehavior(r2, 6);
        r3 = r3 & (-29360129);
    L166:
        if (r0 != 0) goto L170;
        r111 = r41;
    L170:
        if ((r47 & 512) == 0) goto L172;
        r3 = r3 & (-1879048193);
        OverscrollEffect r21 = OverscrollKt.rememberOverscrollEffect(r2, 0);
    L173:
        int r113 = r3;
        boolean r22 = r111;
        LazyStaggeredGridState r1 = r20;
    L174:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L177;
        ComposerKt.traceEventStart(-578931208, r113, r4, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:81)");
    L177:
        Orientation r114 = Orientation.Vertical;
        float r25 = r18.mo812getSpacingD9Ej5fM();
        int r115 = r113 >> 3;
        LazyGridStaggeredGridSlotsProvider r116 = rememberColumnSlots(r33, r18, r14, r2, ((r113 & 14) | ((r113 >> 15) & 112)) | (r115 & 896));
        int r23 = (((r113 >> 6) & 14) | 48) | ((r113 << 6) & 7168);
        int r117 = r113 << 3;
        LazyStaggeredGridKt.m1215LazyStaggeredGridw41Enmo(r1, r114, r116, r7, r14, r13, r112, r22, r21, r17, r25, r43, r2, (((((r23 | (r117 & 57344)) | (r117 & 458752)) | (3670016 & r115)) | (29360128 & r115)) | (r115 & 234881024)) | ((r113 << 12) & 1879048192), (r4 << 3) & 112, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L180;
        ComposerKt.traceEventEnd();
    L180:
        final PaddingValues r24 = r14;
        final FlingBehavior r26 = r112;
        final boolean r27 = r22;
        final LazyStaggeredGridState r28 = r1;
        OverscrollEffect r32 = r21;
        final Arrangement.Horizontal r29 = r18;
        final float r30 = r17;
        final OverscrollEffect r118 = r32;
    L182:
        ScopeUpdateScope r119 = r2.endRestartGroup();
        if (r119 == null) goto L186;
        final Modifier r31 = r7;
        final boolean r48 = r13;
        r119.updateScope(new e(r33, r31, r28, r24, r48, r30, r29, r26, r27, r118, r43, r45, r46, r47));
        return;
    L186:
        return;
    L172:
        r21 = r42;
        goto L173
    L165:
        r112 = r40;
        goto L166
    L161:
        r18 = r39;
        goto L163
    L158:
        r17 = r38;
        goto L159
    L153:
        r14 = r11;
        goto L154
    L150:
        r8 = 0;
        r20 = r35;
        goto L151
    L146:
        r7 = r34;
        goto L148
    L132:
        if (r2.getDefaultsInvalid() == true) goto L144;
        r2.skipToGroupEnd();
        if ((r47 & 4) == 0) goto L138;
        r3 = r3 & (-897);
    L138:
        if ((r47 & 128) == 0) goto L141;
        r3 = r3 & (-29360129);
    L141:
        if ((r47 & 512) == 0) goto L143;
        r3 = r3 & (-1879048193);
    L143:
        r7 = r34;
        r1 = r35;
        r18 = r39;
        r112 = r40;
        r21 = r42;
        r113 = r3;
        r14 = r11;
        r17 = r38;
        r22 = r41;
        goto L174
    L181:
        r2.skipToGroupEnd();
        r7 = r34;
        r28 = r35;
        r30 = r38;
        r29 = r39;
        r26 = r40;
        r27 = r41;
        r24 = r11;
        r118 = r42;
        goto L182
    L123:
        if ((r4 & 3) != 2) goto L126;
        r5 = false;
        goto L128
    L113:
        if ((r46 & 6) == 0) goto L115;
        r4 = r46;
        goto L120
    L115:
        if (r2.changedInstance(r43) == false) goto L117;
        int r120 = 4;
    L118:
        r4 = r46 | r120;
        goto L120
    L117:
        r120 = 2;
        goto L118
    L92:
        if ((r45 & 100663296) != 0) goto L99;
        if (r2.changed(r41) == false) goto L96;
        int r121 = 67108864;
    L97:
        r3 = r3 | r121;
        goto L99
    L96:
        r121 = 33554432;
        goto L97
    L71:
        if ((r45 & 1572864) != 0) goto L78;
        if (r2.changed(r39) == false) goto L75;
        int r122 = 1048576;
    L76:
        r3 = r3 | r122;
        goto L78
    L75:
        r122 = 524288;
        goto L76
    L61:
        if ((r45 & 196608) != 0) goto L67;
        if (r2.changed(r38) == false) goto L65;
        int r123 = 131072;
    L66:
        r3 = r3 | r123;
        goto L67
    L65:
        r123 = 65536;
        goto L66
    L50:
        if ((r45 & 24576) != 0) goto L56;
        r13 = r37;
        if (r2.changed(r13) == false) goto L54;
        int r124 = 16384;
    L55:
        r3 = r3 | r124;
        goto L57
    L54:
        r124 = 8192;
        goto L55
    L39:
        if ((r45 & 3072) != 0) goto L45;
        r11 = r36;
        if (r2.changed(r11) == false) goto L43;
        int r125 = 2048;
    L44:
        r3 = r3 | r125;
        goto L46
    L43:
        r125 = 1024;
        goto L44
    L17:
        if ((r45 & 48) != 0) goto L25;
        if (r2.changed(r34) == false) goto L21;
        int r49 = 32;
    L22:
        r3 = r3 | r49;
        goto L25
    L21:
        r49 = 16;
        goto L22
    L6:
        if ((r45 & 6) == 0) goto L8;
        r3 = r45;
        goto L13
    L8:
        if (r2.changed(r33) == false) goto L10;
        int r50 = 4;
    L11:
        r3 = r50 | r45;
        goto L13
    L10:
        r50 = 2;
        goto L11
    }
}
