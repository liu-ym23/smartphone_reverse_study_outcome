package com.bytedance.ee.bear.bitable.card.view.stage;

import android.view.View;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements com.larksuite.component.universe_design.menu.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<com.larksuite.component.universe_design.menu.c> f208715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f208716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.bitable.card.model.stmodel.field.d f208717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ StageDataViewHolder f208718d;

    @Override // com.larksuite.component.universe_design.menu.g
    public final /* synthetic */ int b() {
        return 0;
    }

    @Override // com.larksuite.component.universe_design.menu.g
    public final /* synthetic */ int c() {
        return R.color.ud_menu_icon_color;
    }

    @Override // com.larksuite.component.universe_design.menu.g
    public final void getDescription() {
    }

    @Override // com.larksuite.component.universe_design.menu.g
    public final int getIcon() {
        return R.drawable.ud_icon_reset_outlined;
    }

    @Override // com.larksuite.component.universe_design.menu.g
    public final /* synthetic */ int getTextColor() {
        return 0;
    }

    @Override // com.larksuite.component.universe_design.menu.g
    public final boolean isEnabled() {
        return true;
    }

    @Override // com.larksuite.component.universe_design.menu.g
    public final void a() {
        com.larksuite.component.universe_design.menu.c r100 = this.f208715a.element;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        com.bytedance.ee.bear.widgets.a r101 = new com.bytedance.ee.bear.widgets.a(this.f208716b.getContext());
        r101.k(UIHelper.mustacheFormat(R.string.Bitable_Flow_RecordCard_Mobile_ConfirmBackToStep_Desc, "name", this.f208717c.f207142b));
        r101.h(R.string.Bitable_Flow_RecordCard_Mobile_ConfirmBackToStep_ConfirmButton, new c(this.f208718d));
        r101.a();
        LKUIDialog r102 = r101.l();
        if (DialogLancet.shouldBlockDialogShow(r102) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(r102);
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L9:
        DialogLancet.beforeDialogShow(r102);
        r102.show();
        DialogLancet.afterDialogShow(r102);
    }

    @Override // com.larksuite.component.universe_design.menu.g
    public final String getName() {
        return UIHelper.getString(R.string.Bitable_Flow_RecordCard_StatusBack_Button);
    }

    public d(Ref.ObjectRef<com.larksuite.component.universe_design.menu.c> r100, View r101, com.bytedance.ee.bear.bitable.card.model.stmodel.field.d r102, StageDataViewHolder r103) {
        this.f208715a = r100;
        this.f208716b = r101;
        this.f208717c = r102;
        this.f208718d = r103;
    }
}
