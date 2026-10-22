package com.larus.extension.aggregate_search_ui.api.kmp;

import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.larus.extension.aggregate_search_ui.api.BaseSearchListCell;
import ei9.f;
import ei9.g;
import hi9.a;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/larus/extension/aggregate_search_ui/api/kmp/KmpISearchCellProvider;", "", "provide", "", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface KmpISearchCellProvider {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JD\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u000e0\r2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\b\u0001\u0012\u00020\u00120\u00102\u0012\b\u0002\u0010\u0013\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0012\u0018\u00010\u0014R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/larus/extension/aggregate_search_ui/api/kmp/KmpISearchCellProvider$Companion;", "", "<init>", "()V", "cellList", "Ljava/util/ArrayList;", "Lcom/larus/extension/aggregate_search_ui/api/kmp/KmpCellPack;", "Lkotlin/collections/ArrayList;", "getCellList", "()Ljava/util/ArrayList;", "addCell", "", "cellType", "Ljava/lang/Class;", "Lcom/larus/extension/aggregate_search_ui/api/BaseSearchListCell;", "transformer", "Lcom/larus/list/arch/IFlowListCellStateTransformer;", "Lcom/bytedance/flow/search/kmp/api/model/ISearchDataPayload;", "Lcom/larus/list/arch/IFlowListCellState;", "matcher", "Lcom/larus/list/arch/multi/IMultipleType;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final ArrayList<KmpCellPack> cellList = null;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
            cellList = new ArrayList();
        }

        public final ArrayList<KmpCellPack> getCellList() {
            return cellList;
        }

        public final void addCell(Class<? extends BaseSearchListCell<?>> r100, g<ISearchDataPayload, ? extends f> r101, a<? extends f> r102) {
            Intrinsics.checkNotNullParameter(r100, "cellType");
            Intrinsics.checkNotNullParameter(r101, "transformer");
            cellList.add(new KmpCellPack(r100, r101, r102));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void addCell$default(Companion r100, Class r101, g r102, a r103, int r104, Object r105) {
            if ((r104 & 4) == 0) goto L5;
            r103 = null;
        L5:
            r100.addCell(r101, r102, r103);
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void provide();
}
