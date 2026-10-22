package com.obric.assistant.card.layout.viewholder.memory;

import android.view.ViewGroup;
import com.larus.nova.R;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemScheduleStyle;
import com.obric.assistant.card.utils.i;
import com.obric.assistant.card.utils.j;
import com.obric.capabilitykit.entity.memory.OrderFlightMemoryEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/memory/OrderFlightMemoryViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemScheduleStyle;", "Lcom/obric/capabilitykit/entity/memory/OrderFlightMemoryEntity;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemScheduleStyle$StyleData;", "entity", "position", "", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OrderFlightMemoryViewHolder extends AbsCardItemScheduleStyle<OrderFlightMemoryEntity> {

    public static final class a {
    }

    static {
    }

    public OrderFlightMemoryViewHolder(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        super(r100);
    }

    @Override // com.obric.assistant.card.layout.viewholder.style.AbsCardItemScheduleStyle
    public final AbsCardItemScheduleStyle.a a4(Object r100) {
        OrderFlightMemoryEntity r101 = (OrderFlightMemoryEntity) r100;
        Intrinsics.checkNotNullParameter(r101, "entity");
        int r102 = lca.a.f508616d;
        lca.a r103 = lca.a.C6676a.a(Integer.valueOf(R.drawable.obric_ic_card_flight));
        String r104 = i.a(i.a(r101.getFlightNumber(), r101.getDeparturePlace(), ' '), r101.getDestination(), '-');
        int r105 = j.f386555a;
        String r106 = r101.getDepartureDate();
        String r107 = r101.getDepartureTime();
        String r108 = r101.getLandingDate();
        if (r108 != null) goto L6;
        r108 = "";
    L6:
        return new AbsCardItemScheduleStyle.a(r103, r104, j.a(r106, r107, r108, r101.getLandingTime()), null, 18);
    }
}
