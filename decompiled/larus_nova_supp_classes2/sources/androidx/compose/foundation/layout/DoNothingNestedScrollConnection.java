package androidx.compose.foundation.layout;

import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/foundation/layout/DoNothingNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "<init>", "()V", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DoNothingNestedScrollConnection implements NestedScrollConnection {
    public static final DoNothingNestedScrollConnection INSTANCE = null;

    static {
        INSTANCE = new DoNothingNestedScrollConnection();
    }

    private DoNothingNestedScrollConnection() {
    }

    /* JADX INFO: renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
    public final /* synthetic */ Object m856onPostFlingRZ2iAVY(long r1, long r3, Continuation r5) {
        return NestedScrollConnection.-CC.$default$onPostFling-RZ2iAVY(this, r1, r3, r5);
    }

    /* JADX INFO: renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
    public final /* synthetic */ long m857onPostScrollDzOQY0M(long r1, long r3, int r5) {
        return NestedScrollConnection.-CC.$default$onPostScroll-DzOQY0M(this, r1, r3, r5);
    }

    /* JADX INFO: renamed from: onPreFling-QWom1Mo, reason: not valid java name */
    public final /* synthetic */ Object m858onPreFlingQWom1Mo(long r1, Continuation r3) {
        return NestedScrollConnection.-CC.$default$onPreFling-QWom1Mo(this, r1, r3);
    }

    /* JADX INFO: renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
    public final /* synthetic */ long m859onPreScrollOzD1aCk(long r1, int r3) {
        return NestedScrollConnection.-CC.$default$onPreScroll-OzD1aCk(this, r1, r3);
    }
}
