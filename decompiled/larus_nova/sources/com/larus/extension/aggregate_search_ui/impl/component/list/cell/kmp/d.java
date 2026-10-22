package com.larus.extension.aggregate_search_ui.impl.component.list.cell.kmp;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.bytedance.flow.search.kmp.api.model.payload.ChatSectionPayload;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class d implements ei9.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChatSectionPayload f342688a;

    public static final class a implements ei9.g<ISearchDataPayload, d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f342689a = null;

        static {
            f342689a = new a();
        }

        public a() {
        }

        @Override // ei9.g
        public final boolean a(ISearchDataPayload r100) {
            ISearchDataPayload r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "sourceData");
            if ((r101 instanceof ChatSectionPayload) == false) goto L5;
            ChatSectionPayload r102 = (ChatSectionPayload) r101;
        L6:
            if (r102 != null) goto L9;
        L13:
            return false;
        L9:
            if (((ChatSectionPayload) r101).getType() != 120) goto L13;
            if (r102.f243341m != 0) goto L13;
            return true;
        L5:
            r102 = null;
            goto L6
        }

        @Override // ei9.g
        public final ei9.f b(ISearchDataPayload r100) {
            ISearchDataPayload r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "sourceData");
            return new d((ChatSectionPayload) r101);
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f342688a, ((d) r100).f342688a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f342688a.hashCode();
    }

    public final String toString() {
        return "KmpChatSectionCellState(payload=" + this.f342688a + ')';
    }

    public d(ChatSectionPayload r100) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        this.f342688a = r100;
    }
}
