package com.larus.extension.aggregate_search_ui.impl.component.list.cell.kmp;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.bytedance.flow.search.kmp.api.model.payload.ItemDividerPayload;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class e0 implements ei9.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ItemDividerPayload f342690a;

    public static final class a implements ei9.g<ISearchDataPayload, e0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f342691a = null;

        static {
            f342691a = new a();
        }

        public a() {
        }

        @Override // ei9.g
        public final boolean a(ISearchDataPayload r100) {
            ISearchDataPayload r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "sourceData");
            if (r101.getType() != 113) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // ei9.g
        public final ei9.f b(ISearchDataPayload r100) {
            ISearchDataPayload r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "sourceData");
            Object r102 = null;
            if ((r101 instanceof ItemDividerPayload) == false) goto L5;
            ItemDividerPayload r103 = (ItemDividerPayload) r101;
        L6:
            if (r103 != null) goto L9;
            r103 = new ItemDividerPayload(r102);
        L9:
            return new e0(r103);
        L5:
            r103 = null;
            goto L6
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f342690a, ((e0) r100).f342690a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final String toString() {
        return "KmpItemDividerCellState(payload=" + this.f342690a + ')';
    }

    public final int hashCode() {
        return this.f342690a.f243400i;
    }

    public e0(ItemDividerPayload r100) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        this.f342690a = r100;
    }
}
