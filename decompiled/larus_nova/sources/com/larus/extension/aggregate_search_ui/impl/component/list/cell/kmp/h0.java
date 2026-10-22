package com.larus.extension.aggregate_search_ui.impl.component.list.cell.kmp;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.bytedance.flow.search.kmp.api.model.payload.LoadMoreFailedPayload;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class h0 implements ei9.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LoadMoreFailedPayload f342699a;

    public static final class a implements ei9.g<ISearchDataPayload, h0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f342700a = null;

        static {
            f342700a = new a();
        }

        public a() {
        }

        @Override // ei9.g
        public final boolean a(ISearchDataPayload r100) {
            ISearchDataPayload r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "sourceData");
            if (r101.getType() != 112) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // ei9.g
        public final ei9.f b(ISearchDataPayload r100) {
            ISearchDataPayload r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "sourceData");
            if ((r101 instanceof LoadMoreFailedPayload) == false) goto L5;
            LoadMoreFailedPayload r102 = (LoadMoreFailedPayload) r101;
        L6:
            if (r102 != null) goto L9;
            r102 = new LoadMoreFailedPayload(null, null, 7);
        L9:
            return new h0(r102);
        L5:
            r102 = null;
            goto L6
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f342699a, ((h0) r100).f342699a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f342699a.hashCode();
    }

    public final String toString() {
        return "KmpLoadMoreFailedCellState(payload=" + this.f342699a + ')';
    }

    public h0(LoadMoreFailedPayload r100) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        this.f342699a = r100;
    }
}
