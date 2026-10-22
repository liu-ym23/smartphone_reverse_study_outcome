package com.larus.extension.aggregate_search_ui.impl.component.list.cell.kmp;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.bytedance.flow.search.kmp.api.model.payload.ChatSectionPayload;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class h implements ei9.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChatSectionPayload f342697a;

    public static final class a implements ei9.g<ISearchDataPayload, h> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f342698a = null;

        static {
            f342698a = new a();
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
            if (r102.f243341m != 1) goto L13;
            return true;
        L5:
            r102 = null;
            goto L6
        }

        @Override // ei9.g
        public final ei9.f b(ISearchDataPayload r100) {
            ISearchDataPayload r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "sourceData");
            return new h((ChatSectionPayload) r101);
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f342697a, ((h) r100).f342697a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f342697a.hashCode();
    }

    public final String toString() {
        return "KmpChatSectionTimeCellState(payload=" + this.f342697a + ')';
    }

    public h(ChatSectionPayload r100) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        this.f342697a = r100;
    }
}
