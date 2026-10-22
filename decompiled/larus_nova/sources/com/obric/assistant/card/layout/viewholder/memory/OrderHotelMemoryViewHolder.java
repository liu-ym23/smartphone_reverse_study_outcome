package com.obric.assistant.card.layout.viewholder.memory;

import android.view.ViewGroup;
import com.larus.nova.R;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemScheduleStyle;
import com.obric.assistant.card.utils.j;
import com.obric.capabilitykit.entity.memory.OrderHotelMemoryEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/memory/OrderHotelMemoryViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemScheduleStyle;", "Lcom/obric/capabilitykit/entity/memory/OrderHotelMemoryEntity;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemScheduleStyle$StyleData;", "entity", "position", "", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OrderHotelMemoryViewHolder extends AbsCardItemScheduleStyle<OrderHotelMemoryEntity> {

    public static final class a {
    }

    static {
    }

    public OrderHotelMemoryViewHolder(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        super(r100);
    }

    @Override // com.obric.assistant.card.layout.viewholder.style.AbsCardItemScheduleStyle
    public final AbsCardItemScheduleStyle.a a4(Object r100) {
        OrderHotelMemoryEntity r101 = (OrderHotelMemoryEntity) r100;
        Intrinsics.checkNotNullParameter(r101, "entity");
        int r102 = lca.a.f508616d;
        lca.a r103 = lca.a.C6676a.a(Integer.valueOf(R.drawable.obric_ic_card_hotel));
        String r104 = r101.getHotelName();
        int r105 = j.f386555a;
        String r106 = r101.getCheckInDate();
        String r107 = r101.getCheckInTime();
        String r108 = "";
        if (r107 != null) goto L5;
        r107 = "";
    L5:
        String r109 = r101.getCheckOutDate();
        if (r109 != null) goto L8;
        r109 = "";
    L8:
        String r110 = r101.getCheckOutTime();
        if (r110 != null) goto L11;
        r110 = "";
    L11:
        String r111 = j.a(r106, r107, r109, r110);
        String r112 = r101.getHotelAddress();
        if (r112 == null) goto L16;
        r108 = r112;
    L16:
        return new AbsCardItemScheduleStyle.a(r103, r104, r111, r108, 2);
    }
}
