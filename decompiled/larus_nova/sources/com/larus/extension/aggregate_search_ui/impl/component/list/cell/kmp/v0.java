package com.larus.extension.aggregate_search_ui.impl.component.list.cell.kmp;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.bytedance.flow.search.kmp.api.model.payload.MessagePayload;
import com.bytedance.flow.search.kmp.api.model.payload.model.MessageSearchResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class v0 implements ei9.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MessagePayload f342726a;

    public static final class a implements ei9.g<ISearchDataPayload, v0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f342727a = null;

        static {
            f342727a = new a();
        }

        public a() {
        }

        @Override // ei9.g
        public final boolean a(ISearchDataPayload r100) {
            ISearchDataPayload r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "sourceData");
            if (r101.getType() == 1) goto L7;
            return false;
        L7:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ei9.g
        public final ei9.f b(ISearchDataPayload r100) {
            ISearchDataPayload r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "sourceData");
            MessageSearchResult r102 = null;
            Object[] r103 = 0;
            if ((r101 instanceof MessagePayload) == false) goto L5;
            MessagePayload r104 = (MessagePayload) r101;
        L6:
            if (r104 != null) goto L9;
            r104 = new MessagePayload("", r102, r103 == true ? 1 : 0, 14);
        L9:
            return new v0(r104);
        L5:
            r104 = null;
            goto L6
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f342726a, ((v0) r100).f342726a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f342726a.hashCode();
    }

    public final String toString() {
        return "KmpMessageSearchCellState(payload=" + this.f342726a + ')';
    }

    public v0(MessagePayload r100) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        this.f342726a = r100;
    }
}
