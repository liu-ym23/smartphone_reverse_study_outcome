package com.obric.assistant.spi.login;

import android.view.View;
import android.view.ViewStub;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.login.impl.loginfragment.u0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J<\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H\u0016¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/spi/login/DefaultObricLoginServiceImpl;", "Lcom/obric/assistant/spi/login/IObricLoginService;", "<init>", "()V", "isNotObricLogin", "", "setupWelcomeContent", "", "welcomeStub", "Landroid/view/ViewStub;", "viewsToHide", "", "Landroid/view/View;", "animatorTitle", "animatorTitleBottomAnchor", "onWelcomePrimaryClick", "Lkotlin/Function0;", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricLoginServiceImpl implements IObricLoginService {
    public DefaultObricLoginServiceImpl() {
    }

    @Override // com.obric.assistant.spi.login.IObricLoginService
    public final void a(ViewStub r100, List r101, SimpleDraweeView r102, View r103, u0 r104) {
        Intrinsics.checkNotNullParameter(r100, "welcomeStub");
        Intrinsics.checkNotNullParameter(r101, "viewsToHide");
        Intrinsics.checkNotNullParameter(r102, "animatorTitle");
        Intrinsics.checkNotNullParameter(r103, "animatorTitleBottomAnchor");
        Intrinsics.checkNotNullParameter(r104, "onWelcomePrimaryClick");
    }

    @Override // com.obric.assistant.spi.login.IObricLoginService
    public final boolean b() {
        return true;
    }
}
