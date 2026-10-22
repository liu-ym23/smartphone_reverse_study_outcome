package com.obric.assistant.card.layout.viewholder.memory;

import android.view.ViewGroup;
import com.larus.nova.R;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemTitleContentStyle;
import com.obric.capabilitykit.entity.memory.CollectStoreMemoryEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lca.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/memory/CollectStoreMemoryViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleContentStyle;", "Lcom/obric/capabilitykit/entity/memory/CollectStoreMemoryEntity;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleContentStyle$StyleData;", "entity", "position", "", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CollectStoreMemoryViewHolder extends AbsCardItemTitleContentStyle<CollectStoreMemoryEntity> {
    public CollectStoreMemoryViewHolder(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        super(r100);
    }

    @Override // com.obric.assistant.card.layout.viewholder.style.AbsCardItemTitleContentStyle
    public final AbsCardItemTitleContentStyle.a a4(Object r100) {
        CollectStoreMemoryEntity r101 = (CollectStoreMemoryEntity) r100;
        Intrinsics.checkNotNullParameter(r101, "entity");
        a r102 = new a(Integer.valueOf(R.drawable.obric_ic_card_collect_store), null, 6);
        String r103 = r101.getStoreName();
        String r104 = r101.getAddress();
        if (r104 != null) goto L6;
        r104 = "";
    L6:
        if (r104.length() != 0) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r104 = getContext().getString(R.string.obric_memory_collect_store);
    L12:
        return new AbsCardItemTitleContentStyle.a(r102, r103, r104, 18);
    L8:
        r105 = false;
        goto L9
    }
}
