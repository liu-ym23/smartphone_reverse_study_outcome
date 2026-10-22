package com.bytedance.ee.bear.bitable.utils;

import androidx.recyclerview.widget.RecyclerView;
import java.util.EnumSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0018B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0007H\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\"\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J \u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/bitable/utils/AdapterOpsObserver;", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "ops", "Ljava/util/EnumSet;", "Lcom/bytedance/ee/bear/bitable/utils/AdapterOpsObserver$Op;", "onChangedAction", "Lkotlin/Function0;", "", "<init>", "(Ljava/util/EnumSet;Lkotlin/jvm/functions/Function0;)V", "invokeIfNeeded", "actualOp", "onChanged", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeRemoved", "onItemRangeMoved", "fromPosition", "toPosition", "Op", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AdapterOpsObserver extends RecyclerView.AdapterDataObserver {
    public final EnumSet<Op> a;
    public final Function0<Unit> b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/utils/AdapterOpsObserver$Op;", "", "<init>", "(Ljava/lang/String;I)V", "CHANGED", "RANGE_CHANGED", "RANGE_CHANGED_WITH_PAYLOAD", "RANGE_INSERTED", "RANGE_REMOVED", "RANGE_MOVED", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Op extends Enum<Op> {
        public static final Op CHANGED = null;
        public static final a Companion = null;
        public static final Op RANGE_CHANGED = null;
        public static final Op RANGE_CHANGED_WITH_PAYLOAD = null;
        public static final Op RANGE_INSERTED = null;
        public static final Op RANGE_MOVED = null;
        public static final Op RANGE_REMOVED = null;
        public static final EnumSet<Op> a = null;
        public static final /* synthetic */ Op[] b = null;
        public static final /* synthetic */ EnumEntries c = null;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<Op> getEntries() {
            return c;
        }

        static {
            Op r0 = new Op("CHANGED", 0);
            CHANGED = r0;
            Op r1 = new Op("RANGE_CHANGED", 1);
            RANGE_CHANGED = r1;
            Op r3 = new Op("RANGE_CHANGED_WITH_PAYLOAD", 2);
            RANGE_CHANGED_WITH_PAYLOAD = r3;
            Op r5 = new Op("RANGE_INSERTED", 3);
            RANGE_INSERTED = r5;
            Op r7 = new Op("RANGE_REMOVED", 4);
            RANGE_REMOVED = r7;
            Op r9 = new Op("RANGE_MOVED", 5);
            RANGE_MOVED = r9;
            Op[] r11 = {r0, r1, r3, r5, r7, r9};
            b = r11;
            c = EnumEntriesKt.enumEntries(r11);
            Companion = new a();
            a = EnumSet.of(r0, r5, r7, r9);
        }

        public static Op[] values() {
            return (Op[]) b.clone();
        }

        public static final /* synthetic */ EnumSet access$getIndexChangedOps$cp() {
            return a;
        }

        public static Op valueOf(String r1) {
            return (Op) r27.a.a(Op.class, r1);
        }

        public Op(String r1, int r2) {
            super(r1, r2);
        }
    }

    public final void onChanged() {
        super.onChanged();
        b(Op.CHANGED);
    }

    public final void b(Op r2) {
        if (this.a.contains(r2) == false) goto L6;
        this.b.invoke();
        return;
    }

    public AdapterOpsObserver(EnumSet<Op> r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "ops");
        Intrinsics.checkNotNullParameter(r3, "onChangedAction");
        this.a = r2;
        this.b = r3;
    }

    public final void onItemRangeChanged(int r1, int r2) {
        super.onItemRangeChanged(r1, r2);
        b(Op.RANGE_CHANGED);
    }

    public final void onItemRangeInserted(int r1, int r2) {
        super.onItemRangeInserted(r1, r2);
        b(Op.RANGE_INSERTED);
    }

    public final void onItemRangeRemoved(int r1, int r2) {
        super.onItemRangeRemoved(r1, r2);
        b(Op.RANGE_REMOVED);
    }

    public final void onItemRangeChanged(int r1, int r2, Object r3) {
        super.onItemRangeChanged(r1, r2, r3);
        b(Op.RANGE_CHANGED_WITH_PAYLOAD);
    }

    public final void onItemRangeMoved(int r1, int r2, int r3) {
        super.onItemRangeMoved(r1, r2, r3);
        b(Op.RANGE_MOVED);
    }
}
