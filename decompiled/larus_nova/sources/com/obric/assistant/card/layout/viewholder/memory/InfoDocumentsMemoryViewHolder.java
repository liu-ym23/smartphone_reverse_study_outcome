package com.obric.assistant.card.layout.viewholder.memory;

import android.view.ViewGroup;
import com.larus.nova.R;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemTitleContentStyle;
import com.obric.assistant.card.utils.i;
import com.obric.capabilitykit.entity.memory.InfoDocumentsMemoryEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lca.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/memory/InfoDocumentsMemoryViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleContentStyle;", "Lcom/obric/capabilitykit/entity/memory/InfoDocumentsMemoryEntity;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleContentStyle$StyleData;", "entity", "position", "", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InfoDocumentsMemoryViewHolder extends AbsCardItemTitleContentStyle<InfoDocumentsMemoryEntity> {
    public InfoDocumentsMemoryViewHolder(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        super(r100);
    }

    @Override // com.obric.assistant.card.layout.viewholder.style.AbsCardItemTitleContentStyle
    public final AbsCardItemTitleContentStyle.a a4(Object r100) {
        InfoDocumentsMemoryEntity r101 = (InfoDocumentsMemoryEntity) r100;
        Intrinsics.checkNotNullParameter(r101, "entity");
        return new AbsCardItemTitleContentStyle.a(new a(Integer.valueOf(R.drawable.obric_ic_card_id_card), null, 6), i.a(r101.getPerson(), r101.getIdType(), ' '), r101.getIdNumber(), 18);
    }
}
