package com.larus.extension.aggregate_search_ui.impl.component.list.cell.kmp;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.bytedance.flow.search.kmp.api.model.payload.LoadMoreLoadingPayload;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class l0 implements ei9.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LoadMoreLoadingPayload f342707a;

    public static final class a implements ei9.g<ISearchDataPayload, l0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f342708a = null;

        static {
            f342708a = new a();
        }

        public a() {
        }

        @Override // ei9.g
        public final boolean a(ISearchDataPayload r100) {
            ISearchDataPayload r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "sourceData");
            if (r101.getType() != 111) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // ei9.g
        public final ei9.f b(ISearchDataPayload r100) {
            ISearchDataPayload r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "sourceData");
            if ((r101 instanceof LoadMoreLoadingPayload) == false) goto L5;
            LoadMoreLoadingPayload r102 = (LoadMoreLoadingPayload) r101;
        L6:
            if (r102 != null) goto L9;
            r102 = new LoadMoreLoadingPayload(0);
        L9:
            return new l0(r102);
        L5:
            r102 = null;
            goto L6
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f342707a, ((l0) r100).f342707a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f342707a.hashCode();
    }

    public final String toString() {
        return "KmpLoadMoreLoadingCellState(payload=" + this.f342707a + ')';
    }

    public l0(LoadMoreLoadingPayload r100) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        this.f342707a = r100;
    }
}
