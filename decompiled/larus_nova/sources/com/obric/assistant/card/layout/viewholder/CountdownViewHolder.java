package com.obric.assistant.card.layout.viewholder;

import android.view.ViewGroup;
import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;
import com.larus.nova.R;
import com.obric.assistant.card.layout.bean.MessageExtraForViewHolder;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemClockStyle;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.CountdownEntity;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/CountdownViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemClockStyle;", "Lcom/obric/capabilitykit/entity/app/CountdownEntity;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemClockStyle$StyleData;", "messageExtra", "Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;", "entity", "position", "", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CountdownViewHolder extends AbsCardItemClockStyle<CountdownEntity> {
    public CountdownViewHolder(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        super(r100);
    }

    @Override // com.obric.assistant.card.layout.viewholder.style.AbsCardItemClockStyle
    public final AbsCardItemClockStyle.a a4(MessageExtraForViewHolder r110, AppEntity r111) {
        CountdownEntity r112 = (CountdownEntity) r111;
        Intrinsics.checkNotNullParameter(r110, "messageExtra");
        Intrinsics.checkNotNullParameter(r112, "entity");
        int r113 = lca.a.f508616d;
        lca.a r100 = lca.a.C6676a.a(Integer.valueOf(R.drawable.obric_ic_card_count_down));
        int r114 = com.obric.assistant.card.utils.j.f386555a;
        long r101 = r112.getCountdownSeconds();
        long r102 = AnnouncementViewModel.HOUR_DURATION;
        long r103 = r101 / r102;
        long r104 = 60;
        long r105 = (r101 % r102) / r104;
        long r106 = r101 % r104;
        boolean r115 = true;
        if (r103 <= 0) goto L5;
        StringCompanionObject r107 = StringCompanionObject.INSTANCE;
        String r108 = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r103), Long.valueOf(r105), Long.valueOf(r106)}, 3));
    L6:
        String r116 = r112.getLabel();
        if (r116 != null) goto L10;
        r116 = "";
    L10:
        if (r116.length() == 0) goto L13;
        r115 = false;
    L13:
        if (r115 == false) goto L15;
        String r109 = getContext().getString(R.string.obric_intent_countdown);
    L17:
        return new AbsCardItemClockStyle.a(r100, r108, r109, "", false);
    L15:
        r109 = r116;
        goto L17
    L5:
        StringCompanionObject r117 = StringCompanionObject.INSTANCE;
        r108 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r105), Long.valueOf(r106)}, 2));
        goto L6
    }
}
