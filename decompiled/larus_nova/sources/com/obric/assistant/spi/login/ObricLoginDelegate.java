package com.obric.assistant.spi.login;

import android.view.View;
import android.view.ViewStub;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.login.impl.loginfragment.u0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J=\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H\u0096\u0001¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/spi/login/ObricLoginDelegate;", "Lcom/obric/assistant/spi/login/IObricLoginService;", "<init>", "()V", "isNotObricLogin", "", "setupWelcomeContent", "", "welcomeStub", "Landroid/view/ViewStub;", "viewsToHide", "", "Landroid/view/View;", "animatorTitle", "animatorTitleBottomAnchor", "onWelcomePrimaryClick", "Lkotlin/Function0;", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricLoginDelegate implements IObricLoginService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricLoginDelegate f392890b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricLoginService f392891a;

    static {
        f392890b = new ObricLoginDelegate();
    }

    @Override // com.obric.assistant.spi.login.IObricLoginService
    public final void a(ViewStub r100, List r101, SimpleDraweeView r110, View r111, u0 r112) {
        Intrinsics.checkNotNullParameter(r100, "welcomeStub");
        Intrinsics.checkNotNullParameter(r101, "viewsToHide");
        Intrinsics.checkNotNullParameter(r110, "animatorTitle");
        Intrinsics.checkNotNullParameter(r111, "animatorTitleBottomAnchor");
        Intrinsics.checkNotNullParameter(r112, "onWelcomePrimaryClick");
        this.f392891a.a(r100, r101, r110, r111, r112);
    }

    @Override // com.obric.assistant.spi.login.IObricLoginService
    public final boolean b() {
        return this.f392891a.b();
    }

    private ObricLoginDelegate() {
        IObricLoginService r100 = (IObricLoginService) ServiceManager.get().getService(IObricLoginService.class);
        if (r100 != null) goto L5;
        r100 = new DefaultObricLoginServiceImpl();
    L5:
        this.f392891a = r100;
    }
}
