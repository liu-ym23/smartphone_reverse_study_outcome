package com.obric.assistant.card.layout.viewholder.memory;

import android.view.ViewGroup;
import com.larus.nova.R;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemScheduleStyle;
import com.obric.assistant.card.utils.i;
import com.obric.assistant.card.utils.j;
import com.obric.capabilitykit.entity.memory.EventScheduleMemoryEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lca.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/memory/EventScheduleMemoryViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemScheduleStyle;", "Lcom/obric/capabilitykit/entity/memory/EventScheduleMemoryEntity;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemScheduleStyle$StyleData;", "entity", "position", "", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EventScheduleMemoryViewHolder extends AbsCardItemScheduleStyle<EventScheduleMemoryEntity> {
    public EventScheduleMemoryViewHolder(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        super(r100);
    }

    @Override // com.obric.assistant.card.layout.viewholder.style.AbsCardItemScheduleStyle
    public final AbsCardItemScheduleStyle.a a4(Object r100) {
        EventScheduleMemoryEntity r101 = (EventScheduleMemoryEntity) r100;
        Intrinsics.checkNotNullParameter(r101, "entity");
        String r102 = r101.getEndDate();
        int r103 = a.f508616d;
        a r104 = a.C6676a.a(Integer.valueOf(R.drawable.obric_ic_card_schedule));
        String r105 = r101.getScheduleNme();
        if (r102 != null) goto L5;
    L8:
        boolean r106 = true;
    L10:
        if (r106 == false) goto L12;
    L15:
        int r107 = j.f386555a;
        String r108 = i.a(i.a(j.f(r101.getDate()), r101.getStartTime(), ' '), r101.getEndTime(), '-');
    L16:
        String r109 = r108;
        String r110 = r101.getAddress();
        if (r110 != null) goto L20;
        r110 = "";
    L20:
        return new AbsCardItemScheduleStyle.a(r104, r105, r109, r110, 2);
    L12:
        if (Intrinsics.areEqual(r102, r101.getDate()) == true) goto L15;
        int r111 = j.f386555a;
        r108 = i.a(i.a(j.f(r101.getDate()), r101.getStartTime(), ' '), i.a(j.f(r102), r101.getEndTime(), ' '), '-');
        goto L16
    L5:
        if (r102.length() == 0) goto L8;
        r106 = false;
        goto L10
    }
}
