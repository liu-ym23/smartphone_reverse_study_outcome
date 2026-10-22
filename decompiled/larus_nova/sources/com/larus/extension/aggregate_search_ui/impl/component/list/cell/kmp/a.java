package com.larus.extension.aggregate_search_ui.impl.component.list.cell.kmp;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.bytedance.flow.search.kmp.api.model.payload.AutoLoadMorePayload;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class a implements ei9.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AutoLoadMorePayload f342673a;

    /* JADX INFO: renamed from: com.larus.extension.aggregate_search_ui.impl.component.list.cell.kmp.a$a, reason: collision with other inner class name */
    public static final class C4307a implements ei9.g<ISearchDataPayload, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C4307a f342674a = null;

        static {
            f342674a = new C4307a();
        }

        public C4307a() {
        }

        @Override // ei9.g
        public final boolean a(ISearchDataPayload r100) {
            ISearchDataPayload r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "sourceData");
            if (r101.getType() != 110) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // ei9.g
        public final ei9.f b(ISearchDataPayload r100) {
            ISearchDataPayload r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "sourceData");
            if ((r101 instanceof AutoLoadMorePayload) == false) goto L5;
            AutoLoadMorePayload r102 = (AutoLoadMorePayload) r101;
        L6:
            if (r102 != null) goto L9;
            r102 = new AutoLoadMorePayload(null, false, 7);
        L9:
            return new a(r102);
        L5:
            r102 = null;
            goto L6
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f342673a, ((a) r100).f342673a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f342673a.hashCode();
    }

    public final String toString() {
        return "KmpAutoLoadMoreCellState(payload=" + this.f342673a + ')';
    }

    public a(AutoLoadMorePayload r100) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        this.f342673a = r100;
    }
}
