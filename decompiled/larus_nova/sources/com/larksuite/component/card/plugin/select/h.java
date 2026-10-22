package com.larksuite.component.card.plugin.select;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.card.plugin.model.UniversalCardShowSelectMenuPluginModel$OptionsItemModel;
import com.larksuite.component.card.plugin.model.UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel;
import com.larksuite.component.universe_design.dialog.UDListDialogController;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class h implements UDListDialogController.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel f283836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List<UniversalCardShowSelectMenuPluginModel$OptionsItemModel> f283837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MultiSelectMenuAdapter f283838c;

    @Override // com.larksuite.component.universe_design.dialog.UDListDialogController.OnItemClickListener
    public final void onItemClick(int r100) {
        UniversalCardShowSelectMenuPluginModel$OptionsItemModel r101 = (UniversalCardShowSelectMenuPluginModel$OptionsItemModel) ListProtector.get(this.f283836a.options, r100);
        boolean r102 = !r101.isSelected;
        r101.isSelected = r102;
        if (r102 == false) goto L5;
    L7:
        List<UniversalCardShowSelectMenuPluginModel$OptionsItemModel> r103 = this.f283837b;
        int r104 = r103.size();
        Intrinsics.checkNotNull(r101);
        ListProtector.add(r103, r104, r101);
    L8:
        this.f283838c.notifyItemChanged(r100);
        return;
    L5:
        if (this.f283837b.contains(r101) == false) goto L7;
        this.f283837b.remove(r101);
        goto L8
    }

    public h(UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel r100, List<UniversalCardShowSelectMenuPluginModel$OptionsItemModel> r101, MultiSelectMenuAdapter r102) {
        this.f283836a = r100;
        this.f283837b = r101;
        this.f283838c = r102;
    }
}
