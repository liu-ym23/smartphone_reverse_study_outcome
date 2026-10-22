package androidx.compose.foundation.lazy.grid;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
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
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a\u008a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a~\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u001a\u001a\u008a\u0001\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u001d\u001a~\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u001e\u001a\u001d\u0010\u001f\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010!\u001a\u001d\u0010\"\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0003¢\u0006\u0002\u0010#\u001a&\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020&H\u0002\u001aÛ\u0001\u0010*\u001a\u00020\u0001\"\u0004\b\u0000\u0010+*\u00020\u00172\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H+0%2%\b\n\u0010,\u001a\u001f\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000200\u0018\u00010\u001620\b\n\u00101\u001a*\u0012\u0004\u0012\u000203\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000204\u0018\u000102¢\u0006\u0002\b\u00182%\b\n\u00105\u001a\u001f\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0006\u0012\u0004\u0018\u0001000\u001623\b\u0004\u00106\u001a-\u0012\u0004\u0012\u000207\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u000102¢\u0006\u0002\b8¢\u0006\u0002\b\u0018H\u0086\b¢\u0006\u0002\u00109\u001a¯\u0002\u0010:\u001a\u00020\u0001\"\u0004\b\u0000\u0010+*\u00020\u00172\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H+0%2:\b\n\u0010,\u001a4\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000200\u0018\u0001022E\b\n\u00101\u001a?\u0012\u0004\u0012\u000203\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000204\u0018\u00010<¢\u0006\u0002\b\u00182:\b\u0006\u00105\u001a4\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0006\u0012\u0004\u0018\u000100022H\b\u0004\u00106\u001aB\u0012\u0004\u0012\u000207\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u00010<¢\u0006\u0002\b8¢\u0006\u0002\b\u0018H\u0086\b¢\u0006\u0002\u0010=\u001aÛ\u0001\u0010*\u001a\u00020\u0001\"\u0004\b\u0000\u0010+*\u00020\u00172\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H+0>2%\b\n\u0010,\u001a\u001f\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000200\u0018\u00010\u001620\b\n\u00101\u001a*\u0012\u0004\u0012\u000203\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000204\u0018\u000102¢\u0006\u0002\b\u00182%\b\n\u00105\u001a\u001f\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0006\u0012\u0004\u0018\u0001000\u001623\b\u0004\u00106\u001a-\u0012\u0004\u0012\u000207\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u000102¢\u0006\u0002\b8¢\u0006\u0002\b\u0018H\u0086\b¢\u0006\u0002\u0010?\u001a¯\u0002\u0010:\u001a\u00020\u0001\"\u0004\b\u0000\u0010+*\u00020\u00172\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H+0>2:\b\n\u0010,\u001a4\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000200\u0018\u0001022E\b\n\u00101\u001a?\u0012\u0004\u0012\u000203\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000204\u0018\u00010<¢\u0006\u0002\b\u00182:\b\u0006\u00105\u001a4\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0006\u0012\u0004\u0018\u000100022H\b\u0004\u00106\u001aB\u0012\u0004\u0012\u000207\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u00010<¢\u0006\u0002\b8¢\u0006\u0002\b\u0018H\u0086\b¢\u0006\u0002\u0010@¨\u0006A"}, d2 = {"LazyVerticalGrid", "", "columns", "Landroidx/compose/foundation/lazy/grid/GridCells;", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyHorizontalGrid", "rows", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberColumnWidthSums", "Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "rememberRowHeightSums", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "calculateCellsCrossAxisSizeImpl", "", "", "gridSize", "slotCount", "spacing", "items", "T", "key", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "item", "", "span", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "contentType", "itemContent", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyGridDslKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$10, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class AnonymousClass10 implements Function4<LazyGridItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function4<LazyGridItemScope, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass10(Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> r1, T[] r2) {
            this.$itemContent = r1;
            this.$items = r2;
        }

        public final void invoke(LazyGridItemScope r4, int r5, Composer r6, int r7) {
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
            ComposerKt.traceEventStart(1179065086, r0, -1, "androidx.compose.foundation.lazy.grid.items.<anonymous> (LazyGridDsl.kt:613)");
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
            invoke((LazyGridItemScope) r1, ((Number) r2).intValue(), (Composer) r3, ((Number) r4).intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class AnonymousClass2 implements Function1<Integer, Object> {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ Function1<T, Object> $key;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function1<? super T, ? extends Object> r1, List<? extends T> r2) {
            this.$key = r1;
            this.$items = r2;
        }

        public final Object invoke(int r3) {
            return this.$key.invoke(ListProtector.get(this.$items, r3));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke(((Number) r1).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class AnonymousClass3 implements Function2<LazyGridItemSpanScope, Integer, GridItemSpan> {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ Function2<LazyGridItemSpanScope, T, GridItemSpan> $span;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> r1, List<? extends T> r2) {
            this.$span = r1;
            this.$items = r2;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return GridItemSpan.m1102boximpl(m1112invoke_orMbw((LazyGridItemSpanScope) r1, ((Number) r2).intValue()));
        }

        /* JADX INFO: renamed from: invoke-_-orMbw, reason: not valid java name */
        public final long m1112invoke_orMbw(LazyGridItemSpanScope r3, int r4) {
            return ((GridItemSpan) this.$span.invoke(r3, ListProtector.get(this.$items, r4))).m1109unboximpl();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$4, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class AnonymousClass4 implements Function1<Integer, Object> {
        final /* synthetic */ Function1<T, Object> $contentType;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass4(Function1<? super T, ? extends Object> r1, List<? extends T> r2) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$5, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class AnonymousClass5 implements Function4<LazyGridItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function4<LazyGridItemScope, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass5(Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> r1, List<? extends T> r2) {
            this.$itemContent = r1;
            this.$items = r2;
        }

        public final void invoke(LazyGridItemScope r4, int r5, Composer r6, int r7) {
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
            ComposerKt.traceEventStart(-1117249557, r0, -1, "androidx.compose.foundation.lazy.grid.items.<anonymous> (LazyGridDsl.kt:539)");
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
            invoke((LazyGridItemScope) r1, ((Number) r2).intValue(), (Composer) r3, ((Number) r4).intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$7, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class AnonymousClass7 implements Function1<Integer, Object> {
        final /* synthetic */ T[] $items;
        final /* synthetic */ Function1<T, Object> $key;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass7(Function1<? super T, ? extends Object> r1, T[] r2) {
            this.$key = r1;
            this.$items = r2;
        }

        public final Object invoke(int r3) {
            return this.$key.invoke(this.$items[r3]);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke(((Number) r1).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$8, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class AnonymousClass8 implements Function2<LazyGridItemSpanScope, Integer, GridItemSpan> {
        final /* synthetic */ T[] $items;
        final /* synthetic */ Function2<LazyGridItemSpanScope, T, GridItemSpan> $span;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass8(Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> r1, T[] r2) {
            this.$span = r1;
            this.$items = r2;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return GridItemSpan.m1102boximpl(m1114invoke_orMbw((LazyGridItemSpanScope) r1, ((Number) r2).intValue()));
        }

        /* JADX INFO: renamed from: invoke-_-orMbw, reason: not valid java name */
        public final long m1114invoke_orMbw(LazyGridItemSpanScope r3, int r4) {
            return ((GridItemSpan) this.$span.invoke(r3, this.$items[r4])).m1109unboximpl();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$9, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class AnonymousClass9 implements Function1<Integer, Object> {
        final /* synthetic */ Function1<T, Object> $contentType;
        final /* synthetic */ T[] $items;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass9(Function1<? super T, ? extends Object> r1, T[] r2) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$10, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class C018410 implements Function4<LazyGridItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function5<LazyGridItemScope, Integer, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: Multi-variable type inference failed */
        public C018410(Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> r1, T[] r2) {
            this.$itemContent = r1;
            this.$items = r2;
        }

        public final void invoke(LazyGridItemScope r10, int r11, Composer r12, int r13) {
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
            ComposerKt.traceEventStart(49283819, r0, -1, "androidx.compose.foundation.lazy.grid.itemsIndexed.<anonymous> (LazyGridDsl.kt:650)");
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
            invoke((LazyGridItemScope) r1, ((Number) r2).intValue(), (Composer) r3, ((Number) r4).intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class C01852 implements Function1<Integer, Object> {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ Function2<Integer, T, Object> $key;

        /* JADX WARN: Multi-variable type inference failed */
        public C01852(Function2<? super Integer, ? super T, ? extends Object> r1, List<? extends T> r2) {
            this.$key = r1;
            this.$items = r2;
        }

        public final Object invoke(int r4) {
            return this.$key.invoke(Integer.valueOf(r4), ListProtector.get(this.$items, r4));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke(((Number) r1).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$3, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class C01863 implements Function2<LazyGridItemSpanScope, Integer, GridItemSpan> {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ Function3<LazyGridItemSpanScope, Integer, T, GridItemSpan> $span;

        /* JADX WARN: Multi-variable type inference failed */
        public C01863(Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> r1, List<? extends T> r2) {
            this.$span = r1;
            this.$items = r2;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return GridItemSpan.m1102boximpl(m1115invoke_orMbw((LazyGridItemSpanScope) r1, ((Number) r2).intValue()));
        }

        /* JADX INFO: renamed from: invoke-_-orMbw, reason: not valid java name */
        public final long m1115invoke_orMbw(LazyGridItemSpanScope r4, int r5) {
            return ((GridItemSpan) this.$span.invoke(r4, Integer.valueOf(r5), ListProtector.get(this.$items, r5))).m1109unboximpl();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$4, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class C01874 implements Function1<Integer, Object> {
        final /* synthetic */ Function2<Integer, T, Object> $contentType;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: Multi-variable type inference failed */
        public C01874(Function2<? super Integer, ? super T, ? extends Object> r1, List<? extends T> r2) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$5, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class C01885 implements Function4<LazyGridItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function5<LazyGridItemScope, Integer, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: Multi-variable type inference failed */
        public C01885(Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> r1, List<? extends T> r2) {
            this.$itemContent = r1;
            this.$items = r2;
        }

        public final void invoke(LazyGridItemScope r10, int r11, Composer r12, int r13) {
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
            ComposerKt.traceEventStart(-1942245546, r0, -1, "androidx.compose.foundation.lazy.grid.itemsIndexed.<anonymous> (LazyGridDsl.kt:576)");
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
            invoke((LazyGridItemScope) r1, ((Number) r2).intValue(), (Composer) r3, ((Number) r4).intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$7, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class C01907 implements Function1<Integer, Object> {
        final /* synthetic */ T[] $items;
        final /* synthetic */ Function2<Integer, T, Object> $key;

        /* JADX WARN: Multi-variable type inference failed */
        public C01907(Function2<? super Integer, ? super T, ? extends Object> r1, T[] r2) {
            this.$key = r1;
            this.$items = r2;
        }

        public final Object invoke(int r4) {
            return this.$key.invoke(Integer.valueOf(r4), this.$items[r4]);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke(((Number) r1).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$8, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class C01918 implements Function2<LazyGridItemSpanScope, Integer, GridItemSpan> {
        final /* synthetic */ T[] $items;
        final /* synthetic */ Function3<LazyGridItemSpanScope, Integer, T, GridItemSpan> $span;

        /* JADX WARN: Multi-variable type inference failed */
        public C01918(Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> r1, T[] r2) {
            this.$span = r1;
            this.$items = r2;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return GridItemSpan.m1102boximpl(m1116invoke_orMbw((LazyGridItemSpanScope) r1, ((Number) r2).intValue()));
        }

        /* JADX INFO: renamed from: invoke-_-orMbw, reason: not valid java name */
        public final long m1116invoke_orMbw(LazyGridItemSpanScope r4, int r5) {
            return ((GridItemSpan) this.$span.invoke(r4, Integer.valueOf(r5), this.$items[r5])).m1109unboximpl();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$9, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class C01929 implements Function1<Integer, Object> {
        final /* synthetic */ Function2<Integer, T, Object> $contentType;
        final /* synthetic */ T[] $items;

        /* JADX WARN: Multi-variable type inference failed */
        public C01929(Function2<? super Integer, ? super T, ? extends Object> r1, T[] r2) {
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

    private static final Unit LazyHorizontalGrid$lambda$2(GridCells r16, Modifier r17, LazyGridState r18, PaddingValues r19, boolean r20, Arrangement.Horizontal r21, Arrangement.Vertical r22, FlingBehavior r23, boolean r24, OverscrollEffect r25, Function1 r26, int r27, int r28, int r29, Composer r30, int r31) {
        LazyHorizontalGrid(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r30, RecomposeScopeImplKt.updateChangedFlags(r27 | 1), RecomposeScopeImplKt.updateChangedFlags(r28), r29);
        return Unit.INSTANCE;
    }

    private static final Unit LazyHorizontalGrid$lambda$3(GridCells r14, Modifier r15, LazyGridState r16, PaddingValues r17, boolean r18, Arrangement.Horizontal r19, Arrangement.Vertical r20, FlingBehavior r21, boolean r22, Function1 r23, int r24, int r25, Composer r26, int r27) {
        LazyHorizontalGrid(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    private static final Unit LazyVerticalGrid$lambda$0(GridCells r16, Modifier r17, LazyGridState r18, PaddingValues r19, boolean r20, Arrangement.Vertical r21, Arrangement.Horizontal r22, FlingBehavior r23, boolean r24, OverscrollEffect r25, Function1 r26, int r27, int r28, int r29, Composer r30, int r31) {
        LazyVerticalGrid(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r30, RecomposeScopeImplKt.updateChangedFlags(r27 | 1), RecomposeScopeImplKt.updateChangedFlags(r28), r29);
        return Unit.INSTANCE;
    }

    private static final Unit LazyVerticalGrid$lambda$1(GridCells r14, Modifier r15, LazyGridState r16, PaddingValues r17, boolean r18, Arrangement.Vertical r19, Arrangement.Horizontal r20, FlingBehavior r21, boolean r22, Function1 r23, int r24, int r25, Composer r26, int r27) {
        LazyVerticalGrid(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(GridCells r0, Modifier r1, LazyGridState r2, PaddingValues r3, boolean r4, Arrangement.Horizontal r5, Arrangement.Vertical r6, FlingBehavior r7, boolean r8, OverscrollEffect r9, Function1 r10, int r11, int r12, int r13, Composer r14, int r15) {
        return LazyHorizontalGrid$lambda$2(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ Unit b(GridCells r0, Modifier r1, LazyGridState r2, PaddingValues r3, boolean r4, Arrangement.Horizontal r5, Arrangement.Vertical r6, FlingBehavior r7, boolean r8, Function1 r9, int r10, int r11, Composer r12, int r13) {
        return LazyHorizontalGrid$lambda$3(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ LazyGridSlots c(GridCells r0, Arrangement.Horizontal r1, Density r2, Constraints r3) {
        return rememberColumnWidthSums$lambda$9$lambda$8(r0, r1, r2, r3);
    }

    public static /* synthetic */ LazyGridSlots d(GridCells r0, Arrangement.Vertical r1, Density r2, Constraints r3) {
        return rememberRowHeightSums$lambda$15$lambda$14(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit e(GridCells r0, Modifier r1, LazyGridState r2, PaddingValues r3, boolean r4, Arrangement.Vertical r5, Arrangement.Horizontal r6, FlingBehavior r7, boolean r8, OverscrollEffect r9, Function1 r10, int r11, int r12, int r13, Composer r14, int r15) {
        return LazyVerticalGrid$lambda$0(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ Unit f(GridCells r0, Modifier r1, LazyGridState r2, PaddingValues r3, boolean r4, Arrangement.Vertical r5, Arrangement.Horizontal r6, FlingBehavior r7, boolean r8, Function1 r9, int r10, int r11, Composer r12, int r13) {
        return LazyVerticalGrid$lambda$1(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public static final /* synthetic */ List access$calculateCellsCrossAxisSizeImpl(int r0, int r1, int r2) {
        return calculateCellsCrossAxisSizeImpl(r0, r1, r2);
    }

    private static final List<Integer> calculateCellsCrossAxisSizeImpl(int r4, int r5, int r6) {
        int r7 = r4 - (r6 * (r5 - 1));
        int r8 = r7 / r5;
        int r9 = r7 % r5;
        ArrayList r0 = new ArrayList(r5);
        int r2 = 0;
    L3:
        if (r2 >= r5) goto L8;
        if (r2 >= r9) goto L6;
        int r3 = 1;
    L7:
        r0.add(Integer.valueOf(r3 + r8));
        r2 = r2 + 1;
        goto L3
    L6:
        r3 = 0;
        goto L7
    L8:
        return r0;
    }

    private static final LazyGridSlotsProvider rememberColumnWidthSums(final GridCells r5, final Arrangement.Horizontal r6, Composer r7, int r8) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-76500289, r8, -1, "androidx.compose.foundation.lazy.grid.rememberColumnWidthSums (LazyGridDsl.kt:221)");
    L5:
        boolean r1 = false;
        if (((r8 & 14) ^ 6) <= 4) goto L10;
        if (r7.changed(r5) == false) goto L10;
    L11:
        boolean r0 = true;
    L14:
        if (((r8 & 112) ^ 48) <= 32) goto L18;
        if (r7.changed(r6) == false) goto L18;
    L19:
        r1 = true;
    L20:
        boolean r9 = r0 | r1;
        Object r2 = r7.rememberedValue();
        if (r9 == false) goto L23;
    L24:
        r2 = new GridSlotCache(new e(r5, r6));
        r7.updateRememberedValue(r2);
    L25:
        LazyGridSlotsProvider r3 = (LazyGridSlotsProvider) r2;
        if (ComposerKt.isTraceInProgress() == false) goto L28;
        ComposerKt.traceEventEnd();
    L28:
        return r3;
    L23:
        if (r2 != Composer.Companion.getEmpty()) goto L25;
    L18:
        if ((r8 & 48) != 32) goto L20;
    L10:
        if ((r8 & 6) == 4) goto L11;
        r0 = false;
        goto L14
    }

    private static final LazyGridSlots rememberColumnWidthSums$lambda$9$lambda$8(GridCells r8, Arrangement.Horizontal r9, Density r10, Constraints r11) {
        if (Constraints.getMaxWidth-impl(r11.unbox-impl()) == Integer.MAX_VALUE) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("LazyVerticalGrid's width should be bound by parent.");
    L8:
        int r4 = Constraints.getMaxWidth-impl(r11.unbox-impl());
        int[] r12 = CollectionsKt.toIntArray(r8.calculateCrossAxisCellSizes(r10, r4, r10.roundToPx-0680j_4(r9.mo812getSpacingD9Ej5fM())));
        int[] r13 = new int[r12.length];
        r9.arrange(r10, r4, r12, LayoutDirection.Ltr, r13);
        return new LazyGridSlots(r12, r13);
    L5:
        r0 = false;
        goto L6
    }

    private static final LazyGridSlotsProvider rememberRowHeightSums(final GridCells r5, final Arrangement.Vertical r6, Composer r7, int r8) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-150818144, r8, -1, "androidx.compose.foundation.lazy.grid.rememberRowHeightSums (LazyGridDsl.kt:245)");
    L5:
        boolean r1 = false;
        if (((r8 & 14) ^ 6) <= 4) goto L10;
        if (r7.changed(r5) == false) goto L10;
    L11:
        boolean r0 = true;
    L14:
        if (((r8 & 112) ^ 48) <= 32) goto L18;
        if (r7.changed(r6) == false) goto L18;
    L19:
        r1 = true;
    L20:
        boolean r9 = r0 | r1;
        Object r2 = r7.rememberedValue();
        if (r9 == false) goto L23;
    L24:
        r2 = new GridSlotCache(new f(r5, r6));
        r7.updateRememberedValue(r2);
    L25:
        LazyGridSlotsProvider r3 = (LazyGridSlotsProvider) r2;
        if (ComposerKt.isTraceInProgress() == false) goto L28;
        ComposerKt.traceEventEnd();
    L28:
        return r3;
    L23:
        if (r2 != Composer.Companion.getEmpty()) goto L25;
    L18:
        if ((r8 & 48) != 32) goto L20;
    L10:
        if ((r8 & 6) == 4) goto L11;
        r0 = false;
        goto L14
    }

    private static final LazyGridSlots rememberRowHeightSums$lambda$15$lambda$14(GridCells r2, Arrangement.Vertical r3, Density r4, Constraints r5) {
        if (Constraints.getMaxHeight-impl(r5.unbox-impl()) == Integer.MAX_VALUE) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("LazyHorizontalGrid's height should be bound by parent.");
    L8:
        int r6 = Constraints.getMaxHeight-impl(r5.unbox-impl());
        int[] r7 = CollectionsKt.toIntArray(r2.calculateCrossAxisCellSizes(r4, r6, r4.roundToPx-0680j_4(r3.mo812getSpacingD9Ej5fM())));
        int[] r1 = new int[r7.length];
        r3.arrange(r4, r6, r7, r1);
        return new LazyGridSlots(r7, r1);
    L5:
        r0 = false;
        goto L6
    }

    public static final <T> void items(LazyGridScope r3, List<? extends T> r4, Function1<? super T, ? extends Object> r5, Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> r6, Function1<? super T, ? extends Object> r7, Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> r8) {
        int r0 = r4.size();
        AnonymousClass3 r1 = null;
        if (r5 == null) goto L5;
        AnonymousClass2 r9 = new AnonymousClass2(r5, r4);
    L6:
        if (r6 == null) goto L8;
        r1 = new AnonymousClass3(r6, r4);
    L8:
        r3.items(r0, r9, r1, new AnonymousClass4(r7, r4), ComposableLambdaKt.composableLambdaInstance(-1117249557, true, new AnonymousClass5(r8, r4)));
        return;
    L5:
        r9 = null;
        goto L6
    }

    public static final <T> void itemsIndexed(LazyGridScope r3, List<? extends T> r4, Function2<? super Integer, ? super T, ? extends Object> r5, Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> r6, Function2<? super Integer, ? super T, ? extends Object> r7, Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> r8) {
        int r0 = r4.size();
        C01863 r1 = null;
        if (r5 == null) goto L5;
        C01852 r9 = new C01852(r5, r4);
    L6:
        if (r6 == null) goto L8;
        r1 = new C01863(r6, r4);
    L8:
        r3.items(r0, r9, r1, new C01874(r7, r4), ComposableLambdaKt.composableLambdaInstance(-1942245546, true, new C01885(r8, r4)));
        return;
    L5:
        r9 = null;
        goto L6
    }

    public static final <T> void items(LazyGridScope r3, T[] r4, Function1<? super T, ? extends Object> r5, Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> r6, Function1<? super T, ? extends Object> r7, Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> r8) {
        int r0 = r4.length;
        AnonymousClass8 r1 = null;
        if (r5 == null) goto L5;
        AnonymousClass7 r9 = new AnonymousClass7(r5, r4);
    L6:
        if (r6 == null) goto L8;
        r1 = new AnonymousClass8(r6, r4);
    L8:
        r3.items(r0, r9, r1, new AnonymousClass9(r7, r4), ComposableLambdaKt.composableLambdaInstance(1179065086, true, new AnonymousClass10(r8, r4)));
        return;
    L5:
        r9 = null;
        goto L6
    }

    public static final <T> void itemsIndexed(LazyGridScope r3, T[] r4, Function2<? super Integer, ? super T, ? extends Object> r5, Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> r6, Function2<? super Integer, ? super T, ? extends Object> r7, Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> r8) {
        int r0 = r4.length;
        C01918 r1 = null;
        if (r5 == null) goto L5;
        C01907 r9 = new C01907(r5, r4);
    L6:
        if (r6 == null) goto L8;
        r1 = new C01918(r6, r4);
    L8:
        r3.items(r0, r9, r1, new C01929(r7, r4), ComposableLambdaKt.composableLambdaInstance(49283819, true, new C018410(r8, r4)));
        return;
    L5:
        r9 = null;
        goto L6
    }

    public static /* synthetic */ void items$default(LazyGridScope r7, List r8, Function1 r9, Function2 r10, Function1 r11, Function4 r12, int r13, Object r14) {
        AnonymousClass3 r0 = null;
        if ((r13 & 2) == 0) goto L6;
        r9 = null;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r10 = null;
    L9:
        if ((r13 & 8) == 0) goto L11;
        r11 = AnonymousClass1.INSTANCE;
    L11:
        int r2 = r8.size();
        if (r9 == null) goto L14;
        AnonymousClass2 r3 = new AnonymousClass2(r9, r8);
    L15:
        if (r10 == null) goto L17;
        r0 = new AnonymousClass3(r10, r8);
    L17:
        r7.items(r2, r3, r0, new AnonymousClass4(r11, r8), ComposableLambdaKt.composableLambdaInstance(-1117249557, true, new AnonymousClass5(r12, r8)));
        return;
    L14:
        r3 = null;
        goto L15
    }

    public static /* synthetic */ void itemsIndexed$default(LazyGridScope r7, List r8, Function2 r9, Function3 r10, Function2 r11, Function5 r12, int r13, Object r14) {
        C01863 r0 = null;
        if ((r13 & 2) == 0) goto L6;
        r9 = null;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r10 = null;
    L9:
        if ((r13 & 8) == 0) goto L11;
        r11 = C01831.INSTANCE;
    L11:
        int r2 = r8.size();
        if (r9 == null) goto L14;
        C01852 r3 = new C01852(r9, r8);
    L15:
        if (r10 == null) goto L17;
        r0 = new C01863(r10, r8);
    L17:
        r7.items(r2, r3, r0, new C01874(r11, r8), ComposableLambdaKt.composableLambdaInstance(-1942245546, true, new C01885(r12, r8)));
        return;
    L14:
        r3 = null;
        goto L15
    }

    public static /* synthetic */ void items$default(LazyGridScope r7, Object[] r8, Function1 r9, Function2 r10, Function1 r11, Function4 r12, int r13, Object r14) {
        AnonymousClass8 r0 = null;
        if ((r13 & 2) == 0) goto L6;
        r9 = null;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r10 = null;
    L9:
        if ((r13 & 8) == 0) goto L11;
        r11 = AnonymousClass6.INSTANCE;
    L11:
        int r2 = r8.length;
        if (r9 == null) goto L14;
        AnonymousClass7 r3 = new AnonymousClass7(r9, r8);
    L15:
        if (r10 == null) goto L17;
        r0 = new AnonymousClass8(r10, r8);
    L17:
        r7.items(r2, r3, r0, new AnonymousClass9(r11, r8), ComposableLambdaKt.composableLambdaInstance(1179065086, true, new AnonymousClass10(r12, r8)));
        return;
    L14:
        r3 = null;
        goto L15
    }

    public static /* synthetic */ void itemsIndexed$default(LazyGridScope r7, Object[] r8, Function2 r9, Function3 r10, Function2 r11, Function5 r12, int r13, Object r14) {
        C01918 r0 = null;
        if ((r13 & 2) == 0) goto L6;
        r9 = null;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r10 = null;
    L9:
        if ((r13 & 8) == 0) goto L11;
        r11 = C01896.INSTANCE;
    L11:
        int r2 = r8.length;
        if (r9 == null) goto L14;
        C01907 r3 = new C01907(r9, r8);
    L15:
        if (r10 == null) goto L17;
        r0 = new C01918(r10, r8);
    L17:
        r7.items(r2, r3, r0, new C01929(r11, r8), ComposableLambdaKt.composableLambdaInstance(49283819, true, new C018410(r12, r8)));
        return;
    L14:
        r3 = null;
        goto L15
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final /* synthetic */ void LazyHorizontalGrid(final GridCells r29, Modifier r30, LazyGridState r31, PaddingValues r32, boolean r33, Arrangement.Horizontal r34, Arrangement.Vertical r35, FlingBehavior r36, boolean r37, final Function1 r38, Composer r39, final int r40, final int r41) {
        Composer r1 = r39.startRestartGroup(2123608858);
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
    L58:
        if ((196608 & r40) == 0) goto L60;
        Arrangement.Horizontal r13 = r34;
    L68:
        int r14 = r41 & 64;
        if (r14 == 0) goto L72;
        r3 = r3 | 1572864;
    L78:
        Arrangement.Vertical r15 = r35;
    L80:
        if ((r40 & 12582912) != 0) goto L90;
        if ((r41 & 128) != 0) goto L87;
        if (r1.changed(r36) == false) goto L87;
        int r17 = 8388608;
    L88:
        r3 = r3 | r17;
    L87:
        r17 = 4194304;
    L90:
        int r0 = r41 & 256;
        if (r0 == 0) goto L94;
        r3 = r3 | 100663296;
    L101:
        if ((r41 & 512) == 0) goto L104;
        r3 = r3 | 805306368;
    L112:
        if ((r3 & 306783379) == 306783378) goto L114;
        boolean r2 = true;
    L116:
        if (r1.shouldExecute(r2, r3 & 1) == false) goto L171;
        r1.startDefaults();
        if ((r40 & 1) != 0) goto L120;
    L133:
        if (r4 == 0) goto L135;
        final Modifier r5 = Modifier.Companion;
    L137:
        if ((r41 & 4) == 0) goto L139;
        LazyGridState r6 = LazyGridStateKt.rememberLazyGridState(0, 0, r1, 0, 3);
        r3 = r3 & (-897);
    L140:
        if (r8 == 0) goto L142;
        PaddingValues r12 = PaddingKt.m953PaddingValues0680j_4(Dp.constructor-impl(0));
    L143:
        if (r10 == 0) goto L146;
        r11 = false;
    L146:
        if ((r41 & 32) == 0) goto L152;
        Arrangement r16 = Arrangement.INSTANCE;
        if (r11 == true) goto L150;
        Arrangement.Horizontal r18 = r16.getStart();
    L151:
        r3 = r3 & (-458753);
    L153:
        if (r14 == 0) goto L155;
        Arrangement.Vertical r19 = Arrangement.INSTANCE.getTop();
    L157:
        if ((r41 & 128) == 0) goto L159;
        FlingBehavior r110 = ScrollableDefaults.INSTANCE.flingBehavior(r1, 6);
        r3 = r3 & (-29360129);
    L160:
        int r20 = r3;
        if (r0 == 0) goto L163;
        FlingBehavior r21 = r110;
        boolean r22 = true;
    L164:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L167;
        ComposerKt.traceEventStart(2123608858, r20, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:199)");
    L167:
        LazyHorizontalGrid(r29, r5, r6, r12, r11, r18, r19, r21, r22, OverscrollKt.rememberOverscrollEffect(r1, 0), r38, r1, ((((((((r20 & 14) | (r20 & 112)) | (r20 & 896)) | (r20 & 7168)) | (57344 & r20)) | (458752 & r20)) | (3670016 & r20)) | (29360128 & r20)) | (234881024 & r20), (r20 >> 27) & 14, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L170;
        ComposerKt.traceEventEnd();
    L170:
        final Arrangement.Horizontal r23 = r18;
        final boolean r24 = r11;
        final FlingBehavior r25 = r21;
        Arrangement.Vertical r28 = r19;
        final boolean r26 = r22;
        final LazyGridState r27 = r6;
        final PaddingValues r42 = r12;
        final Arrangement.Vertical r43 = r28;
    L172:
        ScopeUpdateScope r111 = r1.endRestartGroup();
        if (r111 == null) goto L176;
        r111.updateScope(new b(r29, r5, r27, r42, r24, r23, r43, r25, r26, r38, r40, r41));
        return;
    L176:
        return;
    L163:
        r21 = r110;
    L132:
        r22 = r37;
        goto L164
    L159:
        r110 = r36;
        goto L160
    L155:
        r19 = r15;
        goto L157
    L150:
        r18 = r16.getEnd();
        goto L151
    L152:
        r18 = r13;
        goto L153
    L142:
        r12 = r9;
        goto L143
    L139:
        r6 = r31;
        goto L140
    L135:
        r5 = r30;
        goto L137
    L120:
        if (r1.getDefaultsInvalid() == true) goto L133;
        r1.skipToGroupEnd();
        if ((r41 & 4) == 0) goto L126;
        r3 = r3 & (-897);
    L126:
        if ((r41 & 32) == 0) goto L129;
        r3 = r3 & (-458753);
    L129:
        if ((r41 & 128) == 0) goto L131;
        r3 = r3 & (-29360129);
    L131:
        r5 = r30;
        r6 = r31;
        r21 = r36;
        r20 = r3;
        r12 = r9;
        r18 = r13;
        r19 = r15;
        goto L132
    L171:
        r1.skipToGroupEnd();
        r5 = r30;
        r27 = r31;
        r26 = r37;
        r42 = r9;
        r24 = r11;
        r23 = r13;
        r43 = r15;
        r25 = r36;
        goto L172
    L114:
        r2 = false;
        goto L116
    L104:
        if ((r40 & 805306368) != 0) goto L112;
        if (r1.changedInstance(r38) == false) goto L108;
        int r112 = 536870912;
    L109:
        r3 = r3 | r112;
        goto L112
    L108:
        r112 = 268435456;
        goto L109
    L94:
        if ((r40 & 100663296) != 0) goto L101;
        if (r1.changed(r37) == false) goto L98;
        int r113 = 67108864;
    L99:
        r3 = r3 | r113;
        goto L101
    L98:
        r113 = 33554432;
        goto L99
    L72:
        if ((1572864 & r40) != 0) goto L78;
        r15 = r35;
        if (r1.changed(r15) == false) goto L76;
        int r114 = 1048576;
    L77:
        r3 = r3 | r114;
        goto L80
    L76:
        r114 = 524288;
        goto L77
    L60:
        if ((r41 & 32) != 0) goto L64;
        r13 = r34;
        if (r1.changed(r13) == false) goto L65;
        int r115 = 131072;
    L66:
        r3 = r3 | r115;
    L65:
        r115 = 65536;
        goto L66
    L64:
        r13 = r34;
        goto L65
    L50:
        if ((r40 & 24576) != 0) goto L56;
        r11 = r33;
        if (r1.changed(r11) == false) goto L54;
        int r116 = 16384;
    L55:
        r3 = r3 | r116;
        goto L58
    L54:
        r116 = 8192;
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
    public static final /* synthetic */ void LazyVerticalGrid(final GridCells r29, Modifier r30, LazyGridState r31, PaddingValues r32, boolean r33, Arrangement.Vertical r34, Arrangement.Horizontal r35, FlingBehavior r36, boolean r37, final Function1 r38, Composer r39, final int r40, final int r41) {
        Composer r1 = r39.startRestartGroup(1485410512);
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
    L58:
        if ((196608 & r40) == 0) goto L60;
        Arrangement.Vertical r13 = r34;
    L68:
        int r14 = r41 & 64;
        if (r14 == 0) goto L72;
        r3 = r3 | 1572864;
    L78:
        Arrangement.Horizontal r15 = r35;
    L80:
        if ((r40 & 12582912) != 0) goto L90;
        if ((r41 & 128) != 0) goto L87;
        if (r1.changed(r36) == false) goto L87;
        int r17 = 8388608;
    L88:
        r3 = r3 | r17;
    L87:
        r17 = 4194304;
    L90:
        int r0 = r41 & 256;
        if (r0 == 0) goto L94;
        r3 = r3 | 100663296;
    L101:
        if ((r41 & 512) == 0) goto L104;
        r3 = r3 | 805306368;
    L112:
        if ((r3 & 306783379) == 306783378) goto L114;
        boolean r2 = true;
    L116:
        if (r1.shouldExecute(r2, r3 & 1) == false) goto L171;
        r1.startDefaults();
        if ((r40 & 1) != 0) goto L120;
    L133:
        if (r4 == 0) goto L135;
        final Modifier r5 = Modifier.Companion;
    L137:
        if ((r41 & 4) == 0) goto L139;
        LazyGridState r6 = LazyGridStateKt.rememberLazyGridState(0, 0, r1, 0, 3);
        r3 = r3 & (-897);
    L140:
        if (r8 == 0) goto L142;
        PaddingValues r12 = PaddingKt.m953PaddingValues0680j_4(Dp.constructor-impl(0));
    L143:
        if (r10 == 0) goto L146;
        r11 = false;
    L146:
        if ((r41 & 32) == 0) goto L152;
        Arrangement r16 = Arrangement.INSTANCE;
        if (r11 == true) goto L150;
        Arrangement.Vertical r18 = r16.getTop();
    L151:
        r3 = r3 & (-458753);
    L153:
        if (r14 == 0) goto L155;
        Arrangement.Horizontal r19 = Arrangement.INSTANCE.getStart();
    L157:
        if ((r41 & 128) == 0) goto L159;
        FlingBehavior r110 = ScrollableDefaults.INSTANCE.flingBehavior(r1, 6);
        r3 = r3 & (-29360129);
    L160:
        int r20 = r3;
        if (r0 == 0) goto L163;
        FlingBehavior r21 = r110;
        boolean r22 = true;
    L164:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L167;
        ComposerKt.traceEventStart(1485410512, r20, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:110)");
    L167:
        LazyVerticalGrid(r29, r5, r6, r12, r11, r18, r19, r21, r22, OverscrollKt.rememberOverscrollEffect(r1, 0), r38, r1, ((((((((r20 & 14) | (r20 & 112)) | (r20 & 896)) | (r20 & 7168)) | (57344 & r20)) | (458752 & r20)) | (3670016 & r20)) | (29360128 & r20)) | (234881024 & r20), (r20 >> 27) & 14, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L170;
        ComposerKt.traceEventEnd();
    L170:
        final Arrangement.Vertical r23 = r18;
        final boolean r24 = r11;
        final FlingBehavior r25 = r21;
        Arrangement.Horizontal r28 = r19;
        final boolean r26 = r22;
        final LazyGridState r27 = r6;
        final PaddingValues r42 = r12;
        final Arrangement.Horizontal r43 = r28;
    L172:
        ScopeUpdateScope r111 = r1.endRestartGroup();
        if (r111 == null) goto L176;
        r111.updateScope(new g(r29, r5, r27, r42, r24, r23, r43, r25, r26, r38, r40, r41));
        return;
    L176:
        return;
    L163:
        r21 = r110;
    L132:
        r22 = r37;
        goto L164
    L159:
        r110 = r36;
        goto L160
    L155:
        r19 = r15;
        goto L157
    L150:
        r18 = r16.getBottom();
        goto L151
    L152:
        r18 = r13;
        goto L153
    L142:
        r12 = r9;
        goto L143
    L139:
        r6 = r31;
        goto L140
    L135:
        r5 = r30;
        goto L137
    L120:
        if (r1.getDefaultsInvalid() == true) goto L133;
        r1.skipToGroupEnd();
        if ((r41 & 4) == 0) goto L126;
        r3 = r3 & (-897);
    L126:
        if ((r41 & 32) == 0) goto L129;
        r3 = r3 & (-458753);
    L129:
        if ((r41 & 128) == 0) goto L131;
        r3 = r3 & (-29360129);
    L131:
        r5 = r30;
        r6 = r31;
        r21 = r36;
        r20 = r3;
        r12 = r9;
        r18 = r13;
        r19 = r15;
        goto L132
    L171:
        r1.skipToGroupEnd();
        r5 = r30;
        r27 = r31;
        r26 = r37;
        r42 = r9;
        r24 = r11;
        r23 = r13;
        r43 = r15;
        r25 = r36;
        goto L172
    L114:
        r2 = false;
        goto L116
    L104:
        if ((r40 & 805306368) != 0) goto L112;
        if (r1.changedInstance(r38) == false) goto L108;
        int r112 = 536870912;
    L109:
        r3 = r3 | r112;
        goto L112
    L108:
        r112 = 268435456;
        goto L109
    L94:
        if ((r40 & 100663296) != 0) goto L101;
        if (r1.changed(r37) == false) goto L98;
        int r113 = 67108864;
    L99:
        r3 = r3 | r113;
        goto L101
    L98:
        r113 = 33554432;
        goto L99
    L72:
        if ((1572864 & r40) != 0) goto L78;
        r15 = r35;
        if (r1.changed(r15) == false) goto L76;
        int r114 = 1048576;
    L77:
        r3 = r3 | r114;
        goto L80
    L76:
        r114 = 524288;
        goto L77
    L60:
        if ((r41 & 32) != 0) goto L64;
        r13 = r34;
        if (r1.changed(r13) == false) goto L65;
        int r115 = 131072;
    L66:
        r3 = r3 | r115;
    L65:
        r115 = 65536;
        goto L66
    L64:
        r13 = r34;
        goto L65
    L50:
        if ((r40 & 24576) != 0) goto L56;
        r11 = r33;
        if (r1.changed(r11) == false) goto L54;
        int r116 = 16384;
    L55:
        r3 = r3 | r116;
        goto L58
    L54:
        r116 = 8192;
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

    public static final void LazyHorizontalGrid(final GridCells r33, Modifier r34, LazyGridState r35, PaddingValues r36, boolean r37, Arrangement.Horizontal r38, Arrangement.Vertical r39, FlingBehavior r40, boolean r41, OverscrollEffect r42, final Function1<? super LazyGridScope, Unit> r43, Composer r44, final int r45, final int r46, final int r47) {
        Composer r2 = r44.startRestartGroup(635941664);
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
    L58:
        if ((r45 & 196608) != 0) goto L67;
        if ((r47 & 32) == 0) goto L62;
    L64:
        int r16 = 65536;
    L65:
        r3 = r3 | r16;
        goto L67
    L62:
        if (r2.changed(r38) == false) goto L64;
        r16 = 131072;
    L67:
        int r17 = r47 & 64;
        if (r17 == 0) goto L70;
        r3 = r3 | 1572864;
        Arrangement.Vertical r15 = r39;
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
        int r4 = r47 & 256;
        if (r4 == 0) goto L92;
        r3 = r3 | 100663296;
    L99:
        if ((r45 & 805306368) != 0) goto L110;
        if ((r47 & 512) != 0) goto L106;
        if (r2.changed(r42) == false) goto L106;
        int r20 = 536870912;
    L107:
        r3 = r3 | r20;
    L106:
        r20 = 268435456;
    L110:
        if ((r47 & 1024) == 0) goto L113;
        int r0 = r46 | 6;
    L120:
        boolean r21 = true;
        if ((r3 & 306783379) == 306783378) goto L123;
    L126:
        boolean r5 = true;
    L128:
        if (r2.shouldExecute(r5, r3 & 1) == false) goto L189;
        r2.startDefaults();
        if ((r45 & 1) != 0) goto L132;
    L147:
        if (r6 == 0) goto L149;
        Modifier r7 = Modifier.Companion;
    L151:
        if ((r47 & 4) == 0) goto L153;
        LazyGridState r8 = LazyGridStateKt.rememberLazyGridState(0, 0, r2, 0, 3);
        r3 = r3 & (-897);
    L154:
        if (r10 == 0) goto L156;
        PaddingValues r14 = PaddingKt.m953PaddingValues0680j_4(Dp.constructor-impl(0));
    L157:
        if (r12 == 0) goto L160;
        r13 = false;
    L160:
        if ((r47 & 32) == 0) goto L166;
        Arrangement r18 = Arrangement.INSTANCE;
        if (r13 == true) goto L164;
        Arrangement.Horizontal r110 = r18.getStart();
    L165:
        r3 = r3 & (-458753);
    L167:
        if (r17 == 0) goto L169;
        Arrangement.Vertical r111 = Arrangement.INSTANCE.getTop();
    L171:
        if ((r47 & 128) == 0) goto L173;
        FlingBehavior r22 = ScrollableDefaults.INSTANCE.flingBehavior(r2, 6);
        r3 = r3 & (-29360129);
    L174:
        if (r4 != 0) goto L178;
        r21 = r41;
    L178:
        if ((r47 & 512) == 0) goto L180;
        OverscrollEffect r23 = OverscrollKt.rememberOverscrollEffect(r2, 0);
        r3 = r3 & (-1879048193);
    L181:
        int r24 = r3;
        boolean r25 = r21;
    L182:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L185;
        ComposerKt.traceEventStart(635941664, r24, r0, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:168)");
    L185:
        int r112 = r24 >> 15;
        int r113 = r24 >> 3;
        LazyGridKt.LazyGrid(r7, r8, rememberRowHeightSums(r33, r111, r2, (r24 & 14) | (r112 & 112)), r14, r13, false, r22, r25, r23, r111, r110, r43, r2, ((((((((r113 & 14) | 196608) | (r113 & 112)) | (r24 & 7168)) | (r24 & 57344)) | (r113 & 3670016)) | (r113 & 29360128)) | (r113 & 234881024)) | ((r24 << 9) & 1879048192), (r112 & 14) | ((r0 << 3) & 112), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L188;
        ComposerKt.traceEventEnd();
    L188:
        final FlingBehavior r26 = r22;
        final Arrangement.Vertical r27 = r111;
        PaddingValues r32 = r14;
        final boolean r28 = r25;
        final LazyGridState r29 = r8;
        final Arrangement.Horizontal r30 = r110;
        final OverscrollEffect r114 = r23;
        final PaddingValues r31 = r32;
    L190:
        ScopeUpdateScope r115 = r2.endRestartGroup();
        if (r115 == null) goto L194;
        final Modifier r48 = r7;
        final boolean r49 = r13;
        r115.updateScope(new c(r33, r48, r29, r31, r49, r30, r27, r26, r28, r114, r43, r45, r46, r47));
        return;
    L194:
        return;
    L180:
        r23 = r42;
        goto L181
    L173:
        r22 = r40;
        goto L174
    L169:
        r111 = r15;
        goto L171
    L164:
        r110 = r18.getEnd();
        goto L165
    L166:
        r110 = r38;
        goto L167
    L156:
        r14 = r11;
        goto L157
    L153:
        r8 = r35;
        goto L154
    L149:
        r7 = r34;
        goto L151
    L132:
        if (r2.getDefaultsInvalid() == true) goto L147;
        r2.skipToGroupEnd();
        if ((r47 & 4) == 0) goto L138;
        r3 = r3 & (-897);
    L138:
        if ((r47 & 32) == 0) goto L141;
        r3 = r3 & (-458753);
    L141:
        if ((r47 & 128) == 0) goto L144;
        r3 = r3 & (-29360129);
    L144:
        if ((r47 & 512) == 0) goto L146;
        r3 = r3 & (-1879048193);
    L146:
        r7 = r34;
        r8 = r35;
        r22 = r40;
        r23 = r42;
        r24 = r3;
        r14 = r11;
        r111 = r15;
        r110 = r38;
        r25 = r41;
        goto L182
    L189:
        r2.skipToGroupEnd();
        r7 = r34;
        r29 = r35;
        r30 = r38;
        r26 = r40;
        r28 = r41;
        r31 = r11;
        r27 = r15;
        r114 = r42;
        goto L190
    L123:
        if ((r0 & 3) != 2) goto L126;
        r5 = false;
        goto L128
    L113:
        if ((r46 & 6) == 0) goto L115;
        r0 = r46;
        goto L120
    L115:
        if (r2.changedInstance(r43) == false) goto L117;
        int r210 = 4;
    L118:
        r0 = r46 | r210;
        goto L120
    L117:
        r210 = 2;
        goto L118
    L92:
        if ((r45 & 100663296) != 0) goto L99;
        if (r2.changed(r41) == false) goto L96;
        int r211 = 67108864;
    L97:
        r3 = r3 | r211;
        goto L99
    L96:
        r211 = 33554432;
        goto L97
    L70:
        r15 = r39;
        if ((r45 & 1572864) != 0) goto L78;
        if (r2.changed(r15) == false) goto L75;
        int r116 = 1048576;
    L76:
        r3 = r3 | r116;
        goto L78
    L75:
        r116 = 524288;
        goto L76
    L50:
        if ((r45 & 24576) != 0) goto L56;
        r13 = r37;
        if (r2.changed(r13) == false) goto L54;
        int r117 = 16384;
    L55:
        r3 = r3 | r117;
        goto L58
    L54:
        r117 = 8192;
        goto L55
    L39:
        if ((r45 & 3072) != 0) goto L45;
        r11 = r36;
        if (r2.changed(r11) == false) goto L43;
        int r118 = 2048;
    L44:
        r3 = r3 | r118;
        goto L46
    L43:
        r118 = 1024;
        goto L44
    L17:
        if ((r45 & 48) != 0) goto L25;
        if (r2.changed(r34) == false) goto L21;
        int r50 = 32;
    L22:
        r3 = r3 | r50;
        goto L25
    L21:
        r50 = 16;
        goto L22
    L6:
        if ((r45 & 6) == 0) goto L8;
        r3 = r45;
        goto L13
    L8:
        if (r2.changed(r33) == false) goto L10;
        int r51 = 4;
    L11:
        r3 = r51 | r45;
        goto L13
    L10:
        r51 = 2;
        goto L11
    }

    public static final void LazyVerticalGrid(final GridCells r33, Modifier r34, LazyGridState r35, PaddingValues r36, boolean r37, Arrangement.Vertical r38, Arrangement.Horizontal r39, FlingBehavior r40, boolean r41, OverscrollEffect r42, final Function1<? super LazyGridScope, Unit> r43, Composer r44, final int r45, final int r46, final int r47) {
        Composer r2 = r44.startRestartGroup(-2072102870);
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
    L58:
        if ((r45 & 196608) != 0) goto L67;
        if ((r47 & 32) == 0) goto L62;
    L64:
        int r16 = 65536;
    L65:
        r3 = r3 | r16;
        goto L67
    L62:
        if (r2.changed(r38) == false) goto L64;
        r16 = 131072;
    L67:
        int r17 = r47 & 64;
        if (r17 == 0) goto L70;
        r3 = r3 | 1572864;
        Arrangement.Horizontal r15 = r39;
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
        int r4 = r47 & 256;
        if (r4 == 0) goto L92;
        r3 = r3 | 100663296;
    L99:
        if ((r45 & 805306368) != 0) goto L110;
        if ((r47 & 512) != 0) goto L106;
        if (r2.changed(r42) == false) goto L106;
        int r20 = 536870912;
    L107:
        r3 = r3 | r20;
    L106:
        r20 = 268435456;
    L110:
        if ((r47 & 1024) == 0) goto L113;
        int r0 = r46 | 6;
    L120:
        boolean r21 = true;
        if ((r3 & 306783379) == 306783378) goto L123;
    L126:
        boolean r5 = true;
    L128:
        if (r2.shouldExecute(r5, r3 & 1) == false) goto L189;
        r2.startDefaults();
        if ((r45 & 1) != 0) goto L132;
    L147:
        if (r6 == 0) goto L149;
        Modifier r7 = Modifier.Companion;
    L151:
        if ((r47 & 4) == 0) goto L153;
        LazyGridState r8 = LazyGridStateKt.rememberLazyGridState(0, 0, r2, 0, 3);
        r3 = r3 & (-897);
    L154:
        if (r10 == 0) goto L156;
        PaddingValues r14 = PaddingKt.m953PaddingValues0680j_4(Dp.constructor-impl(0));
    L157:
        if (r12 == 0) goto L160;
        r13 = false;
    L160:
        if ((r47 & 32) == 0) goto L166;
        Arrangement r18 = Arrangement.INSTANCE;
        if (r13 == true) goto L164;
        Arrangement.Vertical r110 = r18.getTop();
    L165:
        r3 = r3 & (-458753);
    L167:
        if (r17 == 0) goto L169;
        Arrangement.Horizontal r111 = Arrangement.INSTANCE.getStart();
    L171:
        if ((r47 & 128) == 0) goto L173;
        FlingBehavior r22 = ScrollableDefaults.INSTANCE.flingBehavior(r2, 6);
        r3 = r3 & (-29360129);
    L174:
        if (r4 != 0) goto L178;
        r21 = r41;
    L178:
        if ((r47 & 512) == 0) goto L180;
        OverscrollEffect r23 = OverscrollKt.rememberOverscrollEffect(r2, 0);
        r3 = r3 & (-1879048193);
    L181:
        int r24 = r3;
        boolean r25 = r21;
    L182:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L185;
        ComposerKt.traceEventStart(-2072102870, r24, r0, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:79)");
    L185:
        int r112 = r24 >> 3;
        Modifier r113 = r7;
        LazyGridState r114 = r8;
        LazyGridKt.LazyGrid(r113, r114, rememberColumnWidthSums(r33, r111, r2, (r24 & 14) | ((r24 >> 15) & 112)), r14, r13, true, r22, r25, r23, r110, r111, r43, r2, ((((((((r112 & 14) | 196608) | (r112 & 112)) | (r24 & 7168)) | (r24 & 57344)) | (r112 & 3670016)) | (r112 & 29360128)) | (r112 & 234881024)) | ((r24 << 12) & 1879048192), ((r24 >> 18) & 14) | ((r0 << 3) & 112), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L188;
        ComposerKt.traceEventEnd();
    L188:
        final FlingBehavior r26 = r22;
        final Arrangement.Horizontal r27 = r111;
        PaddingValues r32 = r14;
        final boolean r28 = r25;
        final LazyGridState r29 = r8;
        final Arrangement.Vertical r30 = r110;
        final OverscrollEffect r115 = r23;
        final PaddingValues r31 = r32;
    L190:
        ScopeUpdateScope r116 = r2.endRestartGroup();
        if (r116 == null) goto L194;
        final Modifier r48 = r7;
        final boolean r49 = r13;
        r116.updateScope(new d(r33, r48, r29, r31, r49, r30, r27, r26, r28, r115, r43, r45, r46, r47));
        return;
    L194:
        return;
    L180:
        r23 = r42;
        goto L181
    L173:
        r22 = r40;
        goto L174
    L169:
        r111 = r15;
        goto L171
    L164:
        r110 = r18.getBottom();
        goto L165
    L166:
        r110 = r38;
        goto L167
    L156:
        r14 = r11;
        goto L157
    L153:
        r8 = r35;
        goto L154
    L149:
        r7 = r34;
        goto L151
    L132:
        if (r2.getDefaultsInvalid() == true) goto L147;
        r2.skipToGroupEnd();
        if ((r47 & 4) == 0) goto L138;
        r3 = r3 & (-897);
    L138:
        if ((r47 & 32) == 0) goto L141;
        r3 = r3 & (-458753);
    L141:
        if ((r47 & 128) == 0) goto L144;
        r3 = r3 & (-29360129);
    L144:
        if ((r47 & 512) == 0) goto L146;
        r3 = r3 & (-1879048193);
    L146:
        r7 = r34;
        r8 = r35;
        r22 = r40;
        r23 = r42;
        r24 = r3;
        r14 = r11;
        r111 = r15;
        r110 = r38;
        r25 = r41;
        goto L182
    L189:
        r2.skipToGroupEnd();
        r7 = r34;
        r29 = r35;
        r30 = r38;
        r26 = r40;
        r28 = r41;
        r31 = r11;
        r27 = r15;
        r115 = r42;
        goto L190
    L123:
        if ((r0 & 3) != 2) goto L126;
        r5 = false;
        goto L128
    L113:
        if ((r46 & 6) == 0) goto L115;
        r0 = r46;
        goto L120
    L115:
        if (r2.changedInstance(r43) == false) goto L117;
        int r210 = 4;
    L118:
        r0 = r46 | r210;
        goto L120
    L117:
        r210 = 2;
        goto L118
    L92:
        if ((r45 & 100663296) != 0) goto L99;
        if (r2.changed(r41) == false) goto L96;
        int r211 = 67108864;
    L97:
        r3 = r3 | r211;
        goto L99
    L96:
        r211 = 33554432;
        goto L97
    L70:
        r15 = r39;
        if ((r45 & 1572864) != 0) goto L78;
        if (r2.changed(r15) == false) goto L75;
        int r117 = 1048576;
    L76:
        r3 = r3 | r117;
        goto L78
    L75:
        r117 = 524288;
        goto L76
    L50:
        if ((r45 & 24576) != 0) goto L56;
        r13 = r37;
        if (r2.changed(r13) == false) goto L54;
        int r118 = 16384;
    L55:
        r3 = r3 | r118;
        goto L58
    L54:
        r118 = 8192;
        goto L55
    L39:
        if ((r45 & 3072) != 0) goto L45;
        r11 = r36;
        if (r2.changed(r11) == false) goto L43;
        int r119 = 2048;
    L44:
        r3 = r3 | r119;
        goto L46
    L43:
        r119 = 1024;
        goto L44
    L17:
        if ((r45 & 48) != 0) goto L25;
        if (r2.changed(r34) == false) goto L21;
        int r50 = 32;
    L22:
        r3 = r3 | r50;
        goto L25
    L21:
        r50 = 16;
        goto L22
    L6:
        if ((r45 & 6) == 0) goto L8;
        r3 = r45;
        goto L13
    L8:
        if (r2.changed(r33) == false) goto L10;
        int r51 = 4;
    L11:
        r3 = r51 | r45;
        goto L13
    L10:
        r51 = 2;
        goto L11
    }
}
