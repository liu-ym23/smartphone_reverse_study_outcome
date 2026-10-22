package androidx.compose.material3;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\n¨\u0006\u0012"}, d2 = {"Landroidx/compose/material3/AppBarOverflowStateImpl;", "Landroidx/compose/material3/AppBarOverflowState;", "<init>", "()V", "<set-?>", "", "totalItemCount", "getTotalItemCount", "()I", "setTotalItemCount", "(I)V", "totalItemCount$delegate", "Landroidx/compose/runtime/MutableIntState;", "visibleItemCount", "getVisibleItemCount", "setVisibleItemCount", "visibleItemCount$delegate", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AppBarOverflowStateImpl implements AppBarOverflowState {
    public static final Companion Companion = null;
    private static final Saver<AppBarOverflowStateImpl, ?> Saver = null;
    private final MutableIntState totalItemCount$delegate;
    private final MutableIntState visibleItemCount$delegate;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/material3/AppBarOverflowStateImpl$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/AppBarOverflowStateImpl;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final Saver<AppBarOverflowStateImpl, ?> getSaver() {
            return AppBarOverflowStateImpl.access$getSaver$cp();
        }
    }

    public static /* synthetic */ List a(SaverScope r0, AppBarOverflowStateImpl r1) {
        return Saver$lambda$0(r0, r1);
    }

    public static /* synthetic */ AppBarOverflowStateImpl b(List r0) {
        return Saver$lambda$2(r0);
    }

    static {
        Companion = new Companion(null);
        Saver = SaverKt.Saver(new d1(), new e1());
    }

    @Override // androidx.compose.material3.AppBarOverflowState
    public int getTotalItemCount() {
        return this.totalItemCount$delegate.getIntValue();
    }

    @Override // androidx.compose.material3.AppBarOverflowState
    public int getVisibleItemCount() {
        return this.visibleItemCount$delegate.getIntValue();
    }

    public AppBarOverflowStateImpl() {
        this.totalItemCount$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.visibleItemCount$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
    }

    public static final /* synthetic */ Saver access$getSaver$cp() {
        return Saver;
    }

    private static final AppBarOverflowStateImpl Saver$lambda$2(List r2) {
        AppBarOverflowStateImpl r0 = new AppBarOverflowStateImpl();
        r0.setTotalItemCount(((Number) ListProtector.get(r2, 0)).intValue());
        r0.setVisibleItemCount(((Number) ListProtector.get(r2, 1)).intValue());
        return r0;
    }

    @Override // androidx.compose.material3.AppBarOverflowState
    public void setTotalItemCount(int r2) {
        this.totalItemCount$delegate.setIntValue(r2);
    }

    @Override // androidx.compose.material3.AppBarOverflowState
    public void setVisibleItemCount(int r2) {
        this.visibleItemCount$delegate.setIntValue(r2);
    }

    private static final List Saver$lambda$0(SaverScope r2, AppBarOverflowStateImpl r3) {
        return CollectionsKt.listOf(new Integer[]{Integer.valueOf(r3.getTotalItemCount()), Integer.valueOf(r3.getVisibleItemCount())});
    }
}
