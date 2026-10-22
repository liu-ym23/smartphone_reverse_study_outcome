package com.larksuite.component.card.plugin.select;

import android.content.DialogInterface;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.card.plugin.model.UniversalCardShowSelectMenuPluginModel$OptionsItemModel;
import java.util.List;

/* JADX INFO: loaded from: classes24.dex */
public final class d implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MultiSelectMenuAdapter f283830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List<UniversalCardShowSelectMenuPluginModel$OptionsItemModel> f283831b;

    public d(MultiSelectMenuAdapter r100, List<UniversalCardShowSelectMenuPluginModel$OptionsItemModel> r101) {
        this.f283830a = r100;
        this.f283831b = r101;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        UniversalCardShowSelectMenuPluginModel$OptionsItemModel r102 = (UniversalCardShowSelectMenuPluginModel$OptionsItemModel) ListProtector.get(this.f283830a.f283821l, r101);
        boolean r103 = !r102.isSelected;
        r102.isSelected = r103;
        if (r103 == false) goto L5;
    L7:
        List<UniversalCardShowSelectMenuPluginModel$OptionsItemModel> r104 = this.f283831b;
        ListProtector.add(r104, r104.size(), r102);
    L8:
        this.f283830a.notifyItemChanged(r101);
        return;
    L5:
        if (this.f283831b.contains(r102) == false) goto L7;
        this.f283831b.remove(r102);
        goto L8
    }
}
