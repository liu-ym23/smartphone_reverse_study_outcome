package com.bytedance.ee.bear.bitable.card.view.cell;

import com.larksuite.component.universe_design.menu.g;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECellEditMenuItem f207273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2991a f207274b;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.card.view.cell.a$a, reason: collision with other inner class name */
    public interface InterfaceC2991a {
        void g3(ECellEditMenuItem r100);
    }

    @Override // com.larksuite.component.universe_design.menu.g
    public final /* synthetic */ int b() {
        return 0;
    }

    @Override // com.larksuite.component.universe_design.menu.g
    public final /* synthetic */ int c() {
        return R.color.ud_menu_icon_color;
    }

    @Override // com.larksuite.component.universe_design.menu.g
    public final /* synthetic */ void getDescription() {
    }

    @Override // com.larksuite.component.universe_design.menu.g
    public final /* synthetic */ int getTextColor() {
        return 0;
    }

    @Override // com.larksuite.component.universe_design.menu.g
    public final /* synthetic */ boolean isEnabled() {
        return true;
    }

    @Override // com.larksuite.component.universe_design.menu.g
    public final void a() {
        this.f207274b.g3(this.f207273a);
    }

    @Override // com.larksuite.component.universe_design.menu.g
    public final int getIcon() {
        return this.f207273a.getIcon();
    }

    @Override // com.larksuite.component.universe_design.menu.g
    public final String getName() {
        return this.f207273a.getItemTitle();
    }

    public a(ECellEditMenuItem r100, InterfaceC2991a r101) {
        Intrinsics.checkNotNullParameter(r100, "cellEditMenuItem");
        Intrinsics.checkNotNullParameter(r101, "onCellEditMenuItemListener");
        this.f207273a = r100;
        this.f207274b = r101;
    }
}
