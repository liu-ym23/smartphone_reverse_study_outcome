package androidx.compose.foundation.lazy.staggeredgrid;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan;", "", "value", "", "<init>", "(I)V", "getValue$foundation_release", "()I", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class StaggeredGridItemSpan {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final StaggeredGridItemSpan FullLine = null;
    private static final StaggeredGridItemSpan SingleLane = null;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan$Companion;", "", "<init>", "()V", "FullLine", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan;", "getFullLine", "()Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan;", "SingleLane", "getSingleLane", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final StaggeredGridItemSpan getFullLine() {
            return StaggeredGridItemSpan.access$getFullLine$cp();
        }

        public final StaggeredGridItemSpan getSingleLane() {
            return StaggeredGridItemSpan.access$getSingleLane$cp();
        }
    }

    static {
        Companion = new Companion(null);
        FullLine = new StaggeredGridItemSpan(0);
        SingleLane = new StaggeredGridItemSpan(1);
    }

    public static final /* synthetic */ StaggeredGridItemSpan access$getFullLine$cp() {
        return FullLine;
    }

    public static final /* synthetic */ StaggeredGridItemSpan access$getSingleLane$cp() {
        return SingleLane;
    }

    public final int getValue$foundation_release() {
        return this.value;
    }

    private StaggeredGridItemSpan(int r1) {
        this.value = r1;
    }
}
