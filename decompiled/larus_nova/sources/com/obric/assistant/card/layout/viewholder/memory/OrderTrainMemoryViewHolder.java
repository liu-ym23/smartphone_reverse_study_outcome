package com.obric.assistant.card.layout.viewholder.memory;

import android.view.ViewGroup;
import com.larus.nova.R;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemScheduleStyle;
import com.obric.assistant.card.utils.i;
import com.obric.assistant.card.utils.j;
import com.obric.capabilitykit.entity.memory.OrderTrainMemoryEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/memory/OrderTrainMemoryViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemScheduleStyle;", "Lcom/obric/capabilitykit/entity/memory/OrderTrainMemoryEntity;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemScheduleStyle$StyleData;", "entity", "position", "", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OrderTrainMemoryViewHolder extends AbsCardItemScheduleStyle<OrderTrainMemoryEntity> {

    public static final class a {
    }

    static {
    }

    public OrderTrainMemoryViewHolder(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        super(r100);
    }

    @Override // com.obric.assistant.card.layout.viewholder.style.AbsCardItemScheduleStyle
    public final AbsCardItemScheduleStyle.a a4(Object r110) {
        OrderTrainMemoryEntity r100 = (OrderTrainMemoryEntity) r110;
        Intrinsics.checkNotNullParameter(r100, "entity");
        int r101 = lca.a.f508616d;
        lca.a r102 = lca.a.C6676a.a(Integer.valueOf(R.drawable.obric_ic_card_train));
        String r103 = i.a(i.a(r100.getTrainNumber(), r100.getDeparturePlace(), ' '), r100.getDestination(), '-');
        int r104 = j.f386555a;
        String r105 = r100.getDepartureDate();
        String r106 = r100.getDepartureTime();
        String r107 = r100.getArrivalDate();
        if (r107 != null) goto L5;
        r107 = "";
    L5:
        String r108 = j.a(r105, r106, r107, r100.getArrivalTime());
        List<String> r109 = r100.getSeatNumber();
        if (r109 == null) goto L8;
        String r111 = CollectionsKt.joinToString$default(r109, " ", null, null, 0, null, null, 62, null);
    L9:
        if (r111 != null) goto L11;
        String r112 = "";
    L13:
        return new AbsCardItemScheduleStyle.a(r102, r103, r108, r112, 2);
    L11:
        r112 = r111;
        goto L13
    L8:
        r111 = null;
        goto L9
    }
}
