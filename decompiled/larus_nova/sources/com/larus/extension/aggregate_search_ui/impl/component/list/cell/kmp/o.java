package com.larus.extension.aggregate_search_ui.impl.component.list.cell.kmp;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.bytedance.flow.search.kmp.api.model.payload.FooterPayload;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class o implements ei9.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FooterPayload f342712a;

    public static final class a implements ei9.g<ISearchDataPayload, o> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f342713a = null;

        static {
            f342713a = new a();
        }

        public a() {
        }

        @Override // ei9.g
        public final boolean a(ISearchDataPayload r100) {
            ISearchDataPayload r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "sourceData");
            if (r101.getType() != 109) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // ei9.g
        public final ei9.f b(ISearchDataPayload r100) {
            ISearchDataPayload r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "sourceData");
            if ((r101 instanceof FooterPayload) == false) goto L5;
            FooterPayload r102 = (FooterPayload) r101;
        L6:
            if (r102 != null) goto L9;
            r102 = new FooterPayload("", 0, "");
        L9:
            return new o(r102);
        L5:
            r102 = null;
            goto L6
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f342712a, ((o) r100).f342712a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f342712a.hashCode();
    }

    public final String toString() {
        return "KmpFooterCellState(payload=" + this.f342712a + ')';
    }

    public o(FooterPayload r100) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        this.f342712a = r100;
    }
}
