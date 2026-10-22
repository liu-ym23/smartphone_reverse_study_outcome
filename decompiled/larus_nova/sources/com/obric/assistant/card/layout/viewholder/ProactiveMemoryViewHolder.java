package com.obric.assistant.card.layout.viewholder;

import android.content.Context;
import android.view.ViewGroup;
import com.larus.nova.R;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemTitleContentStyle;
import com.obric.capabilitykit.entity.app.ProactiveMemoryEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/ProactiveMemoryViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleContentStyle;", "Lcom/obric/capabilitykit/entity/app/ProactiveMemoryEntity;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleContentStyle$StyleData;", "entity", "position", "", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProactiveMemoryViewHolder extends AbsCardItemTitleContentStyle<ProactiveMemoryEntity> {
    public ProactiveMemoryViewHolder(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        super(r100);
    }

    @Override // com.obric.assistant.card.layout.viewholder.style.AbsCardItemTitleContentStyle
    public final AbsCardItemTitleContentStyle.a a4(Object r100) {
        ProactiveMemoryEntity r101 = (ProactiveMemoryEntity) r100;
        Intrinsics.checkNotNullParameter(r101, "entity");
        lca.a r102 = new lca.a(Integer.valueOf(R.drawable.obric_ic_card_memory_default), null, 6);
        String r103 = r101.getTitle();
        if (r103 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
        r103 = r101.getContent();
    L11:
        Context r105 = getContext();
        Integer r106 = r101.getProductType();
        if (r106 != null) goto L15;
    L17:
        if (r106 != null) goto L20;
    L22:
        int r107 = R.string.obric_card_screen_content;
    L24:
        return new AbsCardItemTitleContentStyle.a(r102, r103, r105.getString(r107), 18);
    L20:
        if (r106.intValue() != 1006) goto L22;
        r107 = R.string.obric_card_ambient_voice;
        goto L24
    L15:
        if (r106.intValue() != 1005) goto L17;
        r107 = R.string.obric_card_smart_glasses;
        goto L24
    L5:
        if (r103.length() == 0) goto L8;
        r104 = false;
        goto L9
    }
}
