package com.larus.extension.aggregate_search_ui.impl.component.list.cell.kmp;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.flow.search.kmp.api.model.FlowSearchData;
import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.bytedance.flow.search.kmp.api.model.payload.SearchHistoryList;
import com.bytedance.flow.search.kmp.api.model.payload.SearchHistoryPayload;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class c0 implements ei9.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SearchHistoryPayload f342683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FlowSearchData f342684b;

    public static final class a implements ei9.g<ISearchDataPayload, c0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f342685a = null;

        static {
            f342685a = new a();
        }

        public a() {
        }

        @Override // ei9.g
        public final boolean a(ISearchDataPayload r100) {
            ISearchDataPayload r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "sourceData");
            if (r101.getType() != 101) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // ei9.g
        public final ei9.f b(ISearchDataPayload r100) {
            ISearchDataPayload r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "sourceData");
            if ((r101 instanceof SearchHistoryPayload) == false) goto L5;
            SearchHistoryPayload r102 = (SearchHistoryPayload) r101;
        L6:
            if (r102 != null) goto L9;
            r102 = new SearchHistoryPayload(new SearchHistoryList(CollectionsKt.emptyList()), false, false);
        L9:
            return new c0(r102);
        L5:
            r102 = null;
            goto L6
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r101 = (c0) r100;
        if (Intrinsics.areEqual(this.f342683a, r101.f342683a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f342684b, r101.f342684b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f342683a.hashCode() * 31;
        FlowSearchData r101 = this.f342684b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "KmpHistoryPayloadState(payload=" + this.f342683a + ", source=" + this.f342684b + ')';
    }

    public c0(SearchHistoryPayload r100) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        this.f342683a = r100;
        this.f342684b = null;
    }
}
