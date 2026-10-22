package com.larus.extension.aggregate_search_ui.impl.component.list.cell.kmp;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.bytedance.flow.search.kmp.api.model.payload.LoadingRecentSkeletonPayload;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class n0 implements ei9.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LoadingRecentSkeletonPayload f342710a;

    public static final class a implements ei9.g<ISearchDataPayload, n0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f342711a = null;

        static {
            f342711a = new a();
        }

        public a() {
        }

        @Override // ei9.g
        public final boolean a(ISearchDataPayload r100) {
            ISearchDataPayload r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "sourceData");
            if (r101.getType() != 117) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // ei9.g
        public final ei9.f b(ISearchDataPayload r100) {
            ISearchDataPayload r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "sourceData");
            if ((r101 instanceof LoadingRecentSkeletonPayload) == false) goto L5;
            LoadingRecentSkeletonPayload r102 = (LoadingRecentSkeletonPayload) r101;
        L6:
            if (r102 != null) goto L9;
            r102 = new LoadingRecentSkeletonPayload(true);
        L9:
            return new n0(r102);
        L5:
            r102 = null;
            goto L6
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f342710a, ((n0) r100).f342710a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f342710a.hashCode();
    }

    public final String toString() {
        return "KmpLoadingRecentSkeletonCellState(payload=" + this.f342710a + ')';
    }

    public n0(LoadingRecentSkeletonPayload r100) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        this.f342710a = r100;
    }
}
