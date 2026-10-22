package com.obric.assistant.card.layout.viewholder;

import android.view.ViewGroup;
import com.larus.nova.R;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemTitleContentStyle;
import com.obric.capabilitykit.entity.app.AuditoryRecordingEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/AuditoryRecordingMemoryViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleContentStyle;", "Lcom/obric/capabilitykit/entity/app/AuditoryRecordingEntity;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleContentStyle$StyleData;", "entity", "position", "", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuditoryRecordingMemoryViewHolder extends AbsCardItemTitleContentStyle<AuditoryRecordingEntity> {
    public AuditoryRecordingMemoryViewHolder(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        super(r100);
    }

    @Override // com.obric.assistant.card.layout.viewholder.style.AbsCardItemTitleContentStyle
    public final AbsCardItemTitleContentStyle.a a4(Object r100) {
        AuditoryRecordingEntity r101 = (AuditoryRecordingEntity) r100;
        Intrinsics.checkNotNullParameter(r101, "entity");
        lca.a r102 = new lca.a(Integer.valueOf(R.drawable.obric_ic_card_memory_default), null, 6);
        String r103 = r101.getName();
        int r104 = com.obric.assistant.card.utils.j.f386555a;
        return new AbsCardItemTitleContentStyle.a(r102, r103, com.obric.assistant.card.utils.j.c(this.itemView.getContext(), r101.getCreateTime()), 18);
    }
}
