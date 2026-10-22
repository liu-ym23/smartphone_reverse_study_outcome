package com.obric.assistant.card.layout.viewholder;

import android.view.ViewGroup;
import com.larus.nova.R;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemTitleSubTitleStyle;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/RecordingViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleSubTitleStyle;", "Lcom/obric/capabilitykit/entity/app/RecordingEntity;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleSubTitleStyle$StyleData;", "entity", "position", "", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecordingViewHolder extends AbsCardItemTitleSubTitleStyle<RecordingEntity> {
    public RecordingViewHolder(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        super(r100);
    }

    @Override // com.obric.assistant.card.layout.viewholder.style.AbsCardItemTitleSubTitleStyle
    public final AbsCardItemTitleSubTitleStyle.a a4(Object r110) {
        RecordingEntity r111 = (RecordingEntity) r110;
        Intrinsics.checkNotNullParameter(r111, "entity");
        Long r100 = Long.valueOf(r111.getLastModifiedTime());
        if (r100.longValue() <= 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L10;
        r100 = null;
    L10:
        if (r100 == null) goto L12;
        long r102 = r100.longValue();
    L13:
        lca.a r103 = new lca.a(Integer.valueOf(R.drawable.obric_ic_card_recorder), null, 6);
        String r104 = r111.getName();
        int r112 = com.obric.assistant.card.utils.j.f386555a;
        return new AbsCardItemTitleSubTitleStyle.a(r103, r104, false, com.obric.assistant.card.utils.j.c(getContext(), r102), null, 52);
    L12:
        r102 = r111.getCreateTime();
        goto L13
    L5:
        r101 = false;
        goto L7
    }
}
