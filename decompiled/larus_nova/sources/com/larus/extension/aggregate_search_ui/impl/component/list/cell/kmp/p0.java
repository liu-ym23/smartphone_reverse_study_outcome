package com.larus.extension.aggregate_search_ui.impl.component.list.cell.kmp;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.bytedance.flow.search.kmp.api.model.payload.LoadingSkeletonPayload;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class p0 implements ei9.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LoadingSkeletonPayload f342714a;

    public static final class a implements ei9.g<ISearchDataPayload, p0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f342715a = null;

        static {
            f342715a = new a();
        }

        public a() {
        }

        @Override // ei9.g
        public final boolean a(ISearchDataPayload r100) {
            ISearchDataPayload r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "sourceData");
            if (r101.getType() != 116) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // ei9.g
        public final ei9.f b(ISearchDataPayload r100) {
            ISearchDataPayload r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "sourceData");
            if ((r101 instanceof LoadingSkeletonPayload) == false) goto L5;
            LoadingSkeletonPayload r102 = (LoadingSkeletonPayload) r101;
        L6:
            if (r102 != null) goto L9;
            r102 = new LoadingSkeletonPayload(true);
        L9:
            return new p0(r102);
        L5:
            r102 = null;
            goto L6
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f342714a, ((p0) r100).f342714a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f342714a.hashCode();
    }

    public final String toString() {
        return "KmpLoadingSkeletonCellState(payload=" + this.f342714a + ')';
    }

    public p0(LoadingSkeletonPayload r100) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        this.f342714a = r100;
    }
}
