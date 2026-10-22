package com.larus.search.impl.global.view.aggregate.kmp;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.bytedance.flow.search.kmp.api.model.payload.SearchAccountPayload;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class p implements ei9.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SearchAccountPayload f367784a;

    public static final class a implements ei9.g<ISearchDataPayload, p> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f367785a = null;

        static {
            f367785a = new a();
        }

        public a() {
        }

        @Override // ei9.g
        public final boolean a(ISearchDataPayload r100) {
            ISearchDataPayload r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "sourceData");
            if (r101.getType() != 118) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // ei9.g
        public final ei9.f b(ISearchDataPayload r100) {
            ISearchDataPayload r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "sourceData");
            if ((r101 instanceof SearchAccountPayload) == false) goto L5;
            SearchAccountPayload r102 = (SearchAccountPayload) r101;
        L6:
            if (r102 != null) goto L9;
            r102 = new SearchAccountPayload("");
        L9:
            return new p(r102);
        L5:
            r102 = null;
            goto L6
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f367784a, ((p) r100).f367784a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f367784a.hashCode();
    }

    public final String toString() {
        return "KmpSearchAccountCellState(payload=" + this.f367784a + ')';
    }

    public p(SearchAccountPayload r100) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        this.f367784a = r100;
    }
}
