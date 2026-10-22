package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.wikiv2.wikitreev2.move.apply.ApplyMoveSpaceType;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetMoveNodeAuthorizedUserInfoPuller;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u<T> implements Consumer {
    public final /* synthetic */ t a;
    public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j b;

    public u(t r1, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r10) {
        GetMoveNodeAuthorizedUserInfoPuller.Result r2 = (GetMoveNodeAuthorizedUserInfoPuller.Result) r10;
        Toast.cancelLoading();
        tt5.a.h("WikiFolderBlockMoreViewDelegate", "getMoveNodeAuthorizedUserInfo()...success, userInfo = " + r2);
        t r11 = this.a;
        WikiDialogs r7 = r11.h;
        FragmentManager r1 = r11.d.getChildFragmentManager();
        Intrinsics.checkNotNull(r2);
        r7.f(new e(r1, r2, this.b.b, "", true, ApplyMoveSpaceType.APPLY_REMOVE), this.a.d);
    }
}
