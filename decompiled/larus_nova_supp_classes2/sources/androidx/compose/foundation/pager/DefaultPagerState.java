package androidx.compose.foundation.pager;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\b\u0010\tR&\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00070\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/pager/DefaultPagerState;", "Landroidx/compose/foundation/pager/PagerState;", "currentPage", "", "currentPageOffsetFraction", "", "updatedPageCount", "Lkotlin/Function0;", "<init>", "(IFLkotlin/jvm/functions/Function0;)V", "pageCountState", "Landroidx/compose/runtime/MutableState;", "getPageCountState", "()Landroidx/compose/runtime/MutableState;", "setPageCountState", "(Landroidx/compose/runtime/MutableState;)V", "pageCount", "getPageCount", "()I", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DefaultPagerState extends PagerState {
    public static final Companion Companion = null;
    private static final Saver<DefaultPagerState, ?> Saver = null;
    private MutableState<Function0<Integer>> pageCountState;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/pager/DefaultPagerState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/pager/DefaultPagerState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final Saver<DefaultPagerState, ?> getSaver() {
            return DefaultPagerState.access$getSaver$cp();
        }
    }

    public static /* synthetic */ DefaultPagerState e(List r0) {
        return Saver$lambda$2(r0);
    }

    public static /* synthetic */ int f(List r0) {
        return Saver$lambda$2$lambda$1(r0);
    }

    public static /* synthetic */ List g(SaverScope r0, DefaultPagerState r1) {
        return Saver$lambda$0(r0, r1);
    }

    static {
        Companion = new Companion(null);
        Saver = ListSaverKt.listSaver(new a(), new b());
    }

    @Override // androidx.compose.foundation.pager.PagerState
    public int getPageCount() {
        return ((Number) ((Function0) this.pageCountState.getValue()).invoke()).intValue();
    }

    public static final /* synthetic */ Saver access$getSaver$cp() {
        return Saver;
    }

    public final MutableState<Function0<Integer>> getPageCountState() {
        return this.pageCountState;
    }

    private static final DefaultPagerState Saver$lambda$2(final List r4) {
        Object r1 = ListProtector.get(r4, 0);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Int");
        int r2 = ((Integer) r1).intValue();
        Object r3 = ListProtector.get(r4, 1);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Float");
        return new DefaultPagerState(r2, ((Float) r3).floatValue(), new c(r4));
    }

    private static final int Saver$lambda$2$lambda$1(List r1) {
        Object r2 = ListProtector.get(r1, 2);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) r2).intValue();
    }

    public final void setPageCountState(MutableState<Function0<Integer>> r1) {
        this.pageCountState = r1;
    }

    private static final List Saver$lambda$0(SaverScope r3, DefaultPagerState r4) {
        return CollectionsKt.listOf(new Object[]{Integer.valueOf(r4.getCurrentPage()), Float.valueOf(RangesKt.coerceIn(r4.getCurrentPageOffsetFraction(), -0.5f, 0.5f)), Integer.valueOf(r4.getPageCount())});
    }

    public DefaultPagerState(int r1, float r2, Function0<Integer> r3) {
        super(r1, r2);
        this.pageCountState = SnapshotStateKt.mutableStateOf$default(r3, null, 2, null);
    }
}
