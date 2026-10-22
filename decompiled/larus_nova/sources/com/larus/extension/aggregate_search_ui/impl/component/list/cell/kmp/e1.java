package com.larus.extension.aggregate_search_ui.impl.component.list.cell.kmp;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.bytedance.flow.search.kmp.api.model.payload.TitlePayload;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class e1 implements ei9.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TitlePayload f342692a;

    public static final class a implements ei9.g<ISearchDataPayload, e1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f342693a = null;

        static {
            f342693a = new a();
        }

        public a() {
        }

        @Override // ei9.g
        public final boolean a(ISearchDataPayload r100) {
            ISearchDataPayload r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "sourceData");
            if (r101.getType() != 108) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // ei9.g
        public final ei9.f b(ISearchDataPayload r100) {
            ISearchDataPayload r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "sourceData");
            if ((r101 instanceof TitlePayload) == false) goto L5;
            TitlePayload r102 = (TitlePayload) r101;
        L6:
            if (r102 != null) goto L9;
            r102 = new TitlePayload("");
        L9:
            return new e1(r102);
        L5:
            r102 = null;
            goto L6
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e1) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f342692a, ((e1) r100).f342692a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f342692a.hashCode();
    }

    public final String toString() {
        return "KmpTitleCellState(payload=" + this.f342692a + ')';
    }

    public e1(TitlePayload r100) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        this.f342692a = r100;
    }
}
