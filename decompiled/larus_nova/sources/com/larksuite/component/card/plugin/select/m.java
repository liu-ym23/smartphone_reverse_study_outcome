package com.larksuite.component.card.plugin.select;

import android.content.DialogInterface;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.card.plugin.model.UniversalCardShowSelectMenuPluginModel$OptionsItemModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes24.dex */
public final class m implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<UniversalCardShowSelectMenuPluginModel$OptionsItemModel, Unit> f283849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SelectMenuAdapter f283850b;

    public m(com.larksuite.component.card.plugin.e r100, SelectMenuAdapter r101) {
        this.f283849a = r100;
        this.f283850b = r101;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f283849a.invoke((UniversalCardShowSelectMenuPluginModel$OptionsItemModel) ListProtector.get(this.f283850b.f283821l, r101));
    }
}
