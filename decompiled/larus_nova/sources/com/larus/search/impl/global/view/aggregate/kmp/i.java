package com.larus.search.impl.global.view.aggregate.kmp;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.bytedance.flow.search.kmp.api.model.payload.ContactPayload;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class i implements ei9.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ContactPayload f367778a;

    public static final class a implements ei9.g<ISearchDataPayload, i> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f367779a = null;

        static {
            f367779a = new a();
        }

        public a() {
        }

        @Override // ei9.g
        public final boolean a(ISearchDataPayload r100) {
            ISearchDataPayload r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "sourceData");
            if (r101.getType() != 4) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // ei9.g
        public final ei9.f b(ISearchDataPayload r100) {
            ISearchDataPayload r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "sourceData");
            if ((r101 instanceof ContactPayload) == false) goto L5;
            ContactPayload r102 = (ContactPayload) r101;
        L6:
            if (r102 != null) goto L9;
            r102 = new ContactPayload(0);
        L9:
            return new i(r102);
        L5:
            r102 = null;
            goto L6
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f367778a, ((i) r100).f367778a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f367778a.hashCode();
    }

    public final String toString() {
        return "KmpContactSearchCellState(payload=" + this.f367778a + ')';
    }

    public i(ContactPayload r100) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        this.f367778a = r100;
    }
}
