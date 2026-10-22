package com.obric.assistant.card.layout.viewholder.memory;

import android.view.ViewGroup;
import com.larus.nova.R;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemScheduleStyle;
import com.obric.assistant.card.utils.i;
import com.obric.assistant.card.utils.j;
import com.obric.capabilitykit.entity.memory.EventTodoMemoryEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lca.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/memory/EventTodoMemoryViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemScheduleStyle;", "Lcom/obric/capabilitykit/entity/memory/EventTodoMemoryEntity;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemScheduleStyle$StyleData;", "entity", "position", "", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EventTodoMemoryViewHolder extends AbsCardItemScheduleStyle<EventTodoMemoryEntity> {
    public EventTodoMemoryViewHolder(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        super(r100);
    }

    @Override // com.obric.assistant.card.layout.viewholder.style.AbsCardItemScheduleStyle
    public final AbsCardItemScheduleStyle.a a4(Object r100) {
        EventTodoMemoryEntity r101 = (EventTodoMemoryEntity) r100;
        Intrinsics.checkNotNullParameter(r101, "entity");
        int r102 = a.f508616d;
        a r103 = a.C6676a.a(Integer.valueOf(R.drawable.obric_ic_card_todo));
        String r104 = r101.getContent();
        String r105 = r101.getEndDate();
        if (r105 == null) goto L5;
        String r106 = j.f(r105);
    L6:
        String r107 = i.a(r106, r101.getEndTime(), ' ');
        if (r107.length() <= 0) goto L9;
        boolean r108 = true;
    L10:
        if (r108 == false) goto L12;
        String r109 = getContext().getString(R.string.obric_deadline_time, new Object[]{r107});
    L14:
        return new AbsCardItemScheduleStyle.a(r103, r104, r109, null, 18);
    L12:
        r109 = "";
        goto L14
    L9:
        r108 = false;
        goto L10
    L5:
        r106 = null;
        goto L6
    }
}
