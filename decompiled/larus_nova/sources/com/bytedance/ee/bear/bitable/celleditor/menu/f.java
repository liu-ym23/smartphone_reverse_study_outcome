package com.bytedance.ee.bear.bitable.celleditor.menu;

import android.content.Context;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larksuite.component.universe_design.menu.g;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f209582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleItemModel f209583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f209584c;

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
        this.f209584c.invoke();
    }

    @Override // com.larksuite.component.universe_design.menu.g
    public final int getIcon() {
        if (this.f209582a == null) goto L10;
        Icon r100 = this.f209583b.getIcon();
        if (r100 == null) goto L7;
        Integer r101 = r100.getImgRes(this.f209582a);
    L8:
        if (r101 == null) goto L10;
        return r101.intValue();
    L7:
        r101 = null;
    L10:
        return 0;
    }

    @Override // com.larksuite.component.universe_design.menu.g
    public final String getName() {
        String r100 = this.f209583b.getText();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public f(Context r100, SimpleItemModel r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r102, SendEventContainerMethodParamModel.EventKinds.onClick);
        this.f209582a = r100;
        this.f209583b = r101;
        this.f209584c = r102;
    }
}
