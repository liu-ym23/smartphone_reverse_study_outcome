package com.larus.search.impl.global.view.aggregate.kmp;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.bytedance.flow.search.kmp.api.model.payload.BotPayload;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b implements ei9.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BotPayload f367773a;

    public static final class a implements ei9.g<ISearchDataPayload, b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f367774a = null;

        static {
            f367774a = new a();
        }

        public a() {
        }

        @Override // ei9.g
        public final boolean a(ISearchDataPayload r100) {
            ISearchDataPayload r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "sourceData");
            if (r101.getType() == 3) goto L5;
        L7:
            return false;
        L5:
            if ((r101 instanceof BotPayload) == false) goto L7;
            return true;
        }

        @Override // ei9.g
        public final ei9.f b(ISearchDataPayload r100) {
            ISearchDataPayload r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "sourceData");
            return new b((BotPayload) r101);
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f367773a, ((b) r100).f367773a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f367773a.hashCode();
    }

    public final String toString() {
        return "KmpBotSearchCellState(payload=" + this.f367773a + ')';
    }

    public b(BotPayload r100) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        this.f367773a = r100;
    }
}
