package com.ss.android.lark.active.user.bridge;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.Unit;

/* JADX INFO: loaded from: classes34.dex */
@UserScope
public final class h implements e<Unit, Unit> {
    @Inject
    public h() {
    }

    @Override // com.ss.android.lark.active.user.bridge.e
    public final Object a() {
        Log.e("UserScopeBridgeModules", "PlaceHolderHandler called which is not expected");
        return Unit.INSTANCE;
    }
}
