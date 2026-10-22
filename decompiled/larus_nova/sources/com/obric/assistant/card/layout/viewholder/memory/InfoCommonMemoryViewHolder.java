package com.obric.assistant.card.layout.viewholder.memory;

import android.view.ViewGroup;
import com.larus.nova.R;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemTitleContentStyle;
import com.obric.capabilitykit.entity.memory.InfoCommonMemoryEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lca.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/memory/InfoCommonMemoryViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleContentStyle;", "Lcom/obric/capabilitykit/entity/memory/InfoCommonMemoryEntity;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleContentStyle$StyleData;", "entity", "position", "", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InfoCommonMemoryViewHolder extends AbsCardItemTitleContentStyle<InfoCommonMemoryEntity> {
    public InfoCommonMemoryViewHolder(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        super(r100);
    }

    @Override // com.obric.assistant.card.layout.viewholder.style.AbsCardItemTitleContentStyle
    public final AbsCardItemTitleContentStyle.a a4(Object r100) {
        InfoCommonMemoryEntity r101 = (InfoCommonMemoryEntity) r100;
        Intrinsics.checkNotNullParameter(r101, "entity");
        String r102 = r101.getInfoKey();
        switch(r102.hashCode()) {
            case 678376: goto L18;
            case 714256: goto L14;
            case 1129301: goto L10;
            case 31948986: goto L6;
            default: goto L21;
        };
    L21:
        int r103 = R.drawable.obric_ic_card_memory_default;
    L23:
        return new AbsCardItemTitleContentStyle.a(new a(Integer.valueOf(r103), null, 6), r101.getInfoValue(), r101.getInfoKey(), 18);
    L6:
        if (r102.equals(InfoCommonMemoryEntity.InfoKeyType.ANNIVERSARY) == false) goto L21;
        r103 = R.drawable.obric_ic_card_anniversary;
        goto L23
    L10:
        if (r102.equals(InfoCommonMemoryEntity.InfoKeyType.IDENTIFICATION) == false) goto L21;
        r103 = R.drawable.obric_ic_card_id_card;
        goto L23
    L14:
        if (r102.equals(InfoCommonMemoryEntity.InfoKeyType.ADDRESS) == false) goto L21;
        r103 = R.drawable.obric_ic_card_address;
        goto L23
    L18:
        if (r102.equals(InfoCommonMemoryEntity.InfoKeyType.RELATIONSHIP) == false) goto L21;
        r103 = R.drawable.obric_ic_card_relationship;
        goto L23
    }
}
