package com.larus.search.impl.global.view.aggregate.kmp;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.bytedance.flow.search.kmp.api.model.payload.MixedFeedPayload;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class m implements ei9.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MixedFeedPayload f367781a;

    public static final class a implements ei9.g<ISearchDataPayload, m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f367782a = null;

        static {
            f367782a = new a();
        }

        public a() {
        }

        @Override // ei9.g
        public final boolean a(ISearchDataPayload r100) {
            ISearchDataPayload r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "sourceData");
            if (r101.getType() != 119) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // ei9.g
        public final ei9.f b(ISearchDataPayload r100) {
            ISearchDataPayload r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "sourceData");
            if ((r101 instanceof MixedFeedPayload) == false) goto L5;
            MixedFeedPayload r102 = (MixedFeedPayload) r101;
        L6:
            if (r102 != null) goto L9;
            String r103 = "";
            r102 = new MixedFeedPayload(r103, r103, r103, 2097136);
        L9:
            return new m(r102);
        L5:
            r102 = null;
            goto L6
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f367781a, ((m) r100).f367781a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f367781a.hashCode();
    }

    public final String toString() {
        return "KmpMixedFeedCellState(payload=" + this.f367781a + ')';
    }

    public m(MixedFeedPayload r100) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        this.f367781a = r100;
    }
}
