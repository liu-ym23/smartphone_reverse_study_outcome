package com.larus.bmhome.chat.manager;

import com.larus.bmhome.view.screenmenu.ScreenMenuLayout;
import com.larus.bmhome.view.screenmenu.x0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes25.dex */
public final class z implements Function0<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x0 f306876a;

    public z(x0 r100) {
        this.f306876a = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        ScreenMenuLayout r100 = this.f306876a.f317401a;
        if (r100 == null) goto L6;
        r100.setMenuMask(false);
    L6:
        return Unit.INSTANCE;
    }
}
