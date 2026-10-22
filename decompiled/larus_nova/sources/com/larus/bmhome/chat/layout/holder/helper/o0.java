package com.larus.bmhome.chat.layout.holder.helper;

import android.view.View;
import com.baidu.platform.comapi.map.MapController;
import com.larus.bmhome.chat.layout.holder.menu.item.MenuActionType;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class o0 extends com.larus.bmhome.chat.layout.holder.menu.item.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f303674b;

    public o0(Function0<Unit> r100) {
        this.f303674b = r100;
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean a(int r100) {
        if (r100 != MenuActionType.FULLSCREEN_CODE.getType()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean c(ot8.a r100, View r101, ef8.b r102) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "menuContext");
        Function0<Unit> r103 = this.f303674b;
        if (r103 == null) goto L7;
        r103.invoke();
        return true;
    L7:
        return true;
    }
}
