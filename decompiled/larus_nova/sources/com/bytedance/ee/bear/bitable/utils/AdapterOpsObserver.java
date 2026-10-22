package com.bytedance.ee.bear.bitable.utils;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.wschannel.WsConstants;
import java.util.EnumSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0018B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0007H\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\"\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J \u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/bitable/utils/AdapterOpsObserver;", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "ops", "Ljava/util/EnumSet;", "Lcom/bytedance/ee/bear/bitable/utils/AdapterOpsObserver$Op;", "onChangedAction", "Lkotlin/Function0;", "", "<init>", "(Ljava/util/EnumSet;Lkotlin/jvm/functions/Function0;)V", "invokeIfNeeded", "actualOp", "onChanged", "onItemRangeChanged", "positionStart", "", "itemCount", WsConstants.KEY_PAYLOAD, "", "onItemRangeInserted", "onItemRangeRemoved", "onItemRangeMoved", "fromPosition", "toPosition", "Op", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AdapterOpsObserver extends RecyclerView.AdapterDataObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumSet<Op> f216258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f216259b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/utils/AdapterOpsObserver$Op;", "", "<init>", "(Ljava/lang/String;I)V", "CHANGED", "RANGE_CHANGED", "RANGE_CHANGED_WITH_PAYLOAD", "RANGE_INSERTED", "RANGE_REMOVED", "RANGE_MOVED", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Op extends Enum<Op> {
        public static final Op CHANGED = null;
        public static final a Companion = null;
        public static final Op RANGE_CHANGED = null;
        public static final Op RANGE_CHANGED_WITH_PAYLOAD = null;
        public static final Op RANGE_INSERTED = null;
        public static final Op RANGE_MOVED = null;
        public static final Op RANGE_REMOVED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumSet<Op> f216260a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Op[] f216261b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f216262c = null;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<Op> getEntries() {
            return f216262c;
        }

        static {
            Op r100 = new Op("CHANGED", 0);
            CHANGED = r100;
            Op r101 = new Op("RANGE_CHANGED", 1);
            RANGE_CHANGED = r101;
            Op r102 = new Op("RANGE_CHANGED_WITH_PAYLOAD", 2);
            RANGE_CHANGED_WITH_PAYLOAD = r102;
            Op r103 = new Op("RANGE_INSERTED", 3);
            RANGE_INSERTED = r103;
            Op r104 = new Op("RANGE_REMOVED", 4);
            RANGE_REMOVED = r104;
            Op r105 = new Op("RANGE_MOVED", 5);
            RANGE_MOVED = r105;
            Op[] r110 = {r100, r101, r102, r103, r104, r105};
            f216261b = r110;
            f216262c = EnumEntriesKt.enumEntries(r110);
            Companion = new a();
            f216260a = EnumSet.of(r100, r103, r104, r105);
        }

        public static Op[] values() {
            return (Op[]) f216261b.clone();
        }

        public static final /* synthetic */ EnumSet access$getIndexChangedOps$cp() {
            return f216260a;
        }

        public static Op valueOf(String r100) {
            return (Op) r27.a.a(Op.class, r100);
        }

        public Op(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onChanged() {
        super.onChanged();
        b(Op.CHANGED);
    }

    public final void b(Op r100) {
        if (this.f216258a.contains(r100) == false) goto L6;
        this.f216259b.invoke();
        return;
    }

    public AdapterOpsObserver(EnumSet<Op> r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "ops");
        Intrinsics.checkNotNullParameter(r101, "onChangedAction");
        this.f216258a = r100;
        this.f216259b = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeChanged(int r100, int r101) {
        super.onItemRangeChanged(r100, r101);
        b(Op.RANGE_CHANGED);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeInserted(int r100, int r101) {
        super.onItemRangeInserted(r100, r101);
        b(Op.RANGE_INSERTED);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeRemoved(int r100, int r101) {
        super.onItemRangeRemoved(r100, r101);
        b(Op.RANGE_REMOVED);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeChanged(int r100, int r101, Object r102) {
        super.onItemRangeChanged(r100, r101, r102);
        b(Op.RANGE_CHANGED_WITH_PAYLOAD);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeMoved(int r100, int r101, int r102) {
        super.onItemRangeMoved(r100, r101, r102);
        b(Op.RANGE_MOVED);
    }
}
