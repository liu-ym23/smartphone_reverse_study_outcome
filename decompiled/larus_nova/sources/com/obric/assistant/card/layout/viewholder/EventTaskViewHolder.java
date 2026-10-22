package com.obric.assistant.card.layout.viewholder;

import android.view.ViewGroup;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemEventTaskStyle;
import com.obric.capabilitykit.entity.app.EventTaskEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/EventTaskViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemEventTaskStyle;", "Lcom/obric/capabilitykit/entity/app/EventTaskEntity;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemEventTaskStyle$StyleData;", "entity", "position", "", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EventTaskViewHolder extends AbsCardItemEventTaskStyle<EventTaskEntity> {

    public static final class a {
    }

    static {
    }

    public EventTaskViewHolder(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        super(r100);
    }

    @Override // com.obric.assistant.card.layout.viewholder.style.AbsCardItemEventTaskStyle
    public final AbsCardItemEventTaskStyle.a a4(Object r100) {
        EventTaskEntity r101 = (EventTaskEntity) r100;
        Intrinsics.checkNotNullParameter(r101, "entity");
        return new AbsCardItemEventTaskStyle.a(r101.getConditionString(), r101.getTaskQuery(), r101.getPeriodString(), AbsCardItemEventTaskStyle.b4(r101, "o_semantic_icon_key"), AbsCardItemEventTaskStyle.b4(r101, "o_semantic_icon_color_key"));
    }
}
