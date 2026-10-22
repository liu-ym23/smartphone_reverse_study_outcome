package com.larksuite.component.card.plugin.select;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.card.plugin.model.UniversalCardShowSelectMenuPluginModel$OptionsItemModel;
import com.larksuite.component.card.plugin.model.UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel;
import com.larksuite.component.universe_design.dialog.UDListDialogController;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes24.dex */
public final class n implements UDListDialogController.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<UniversalCardShowSelectMenuPluginModel$OptionsItemModel, Unit> f283851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel f283852b;

    @Override // com.larksuite.component.universe_design.dialog.UDListDialogController.OnItemClickListener
    public final void onItemClick(int r100) {
        this.f283851a.invoke((UniversalCardShowSelectMenuPluginModel$OptionsItemModel) ListProtector.get(this.f283852b.options, r100));
    }

    public n(com.larksuite.component.card.plugin.e r100, UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel r101) {
        this.f283851a = r100;
        this.f283852b = r101;
    }
}
