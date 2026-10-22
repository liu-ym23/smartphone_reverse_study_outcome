package com.larus.extension.aggregate_search_ui.impl.component.list.cell.kmp;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.bytedance.flow.search.kmp.api.model.payload.SingleLinePayload;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class c1 implements ei9.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SingleLinePayload f342686a;

    public static final class a implements ei9.g<ISearchDataPayload, c1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f342687a = null;

        static {
            f342687a = new a();
        }

        public a() {
        }

        @Override // ei9.g
        public final boolean a(ISearchDataPayload r100) {
            ISearchDataPayload r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "sourceData");
            if (r101.getType() != 103) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // ei9.g
        public final ei9.f b(ISearchDataPayload r110) {
            ISearchDataPayload r111 = r110;
            Intrinsics.checkNotNullParameter(r111, "sourceData");
            if ((r111 instanceof SingleLinePayload) == false) goto L5;
            SingleLinePayload r112 = (SingleLinePayload) r111;
        L6:
            if (r112 != null) goto L9;
            r112 = new SingleLinePayload("", "", 0, null, null, null, 120);
        L9:
            return new c1(r112);
        L5:
            r112 = null;
            goto L6
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c1) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f342686a, ((c1) r100).f342686a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f342686a.hashCode();
    }

    public final String toString() {
        return "KmpSingleLineCellState(payload=" + this.f342686a + ')';
    }

    public c1(SingleLinePayload r100) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        this.f342686a = r100;
    }
}
