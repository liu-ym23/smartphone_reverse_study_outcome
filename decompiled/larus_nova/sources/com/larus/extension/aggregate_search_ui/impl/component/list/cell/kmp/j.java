package com.larus.extension.aggregate_search_ui.impl.component.list.cell.kmp;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.bytedance.flow.search.kmp.api.model.payload.DividerPayload;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class j implements ei9.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DividerPayload f342701a;

    public static final class a implements ei9.g<ISearchDataPayload, j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f342702a = null;

        static {
            f342702a = new a();
        }

        public a() {
        }

        @Override // ei9.g
        public final boolean a(ISearchDataPayload r100) {
            ISearchDataPayload r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "sourceData");
            if (r101.getType() != 104) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // ei9.g
        public final ei9.f b(ISearchDataPayload r100) {
            ISearchDataPayload r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "sourceData");
            if ((r101 instanceof DividerPayload) == false) goto L5;
            DividerPayload r102 = (DividerPayload) r101;
        L6:
            if (r102 != null) goto L9;
            r102 = new DividerPayload();
        L9:
            return new j(r102);
        L5:
            r102 = null;
            goto L6
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f342701a, ((j) r100).f342701a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f342701a.hashCode();
    }

    public final String toString() {
        return "KmpDividerCellState(payload=" + this.f342701a + ')';
    }

    public j(DividerPayload r100) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        this.f342701a = r100;
    }
}
