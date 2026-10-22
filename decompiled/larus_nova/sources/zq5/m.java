package zq5;

import com.bytedance.ee.bear.wikiv2.wikitreev2.notification.WikiTreeNotificationServiceImpl;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.IOperationUpdate$TreeNodeUpdateTitleAndIconParams;
import com.ss.android.lark.maintab.export.TabAppInfo;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes18.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IOperationUpdate$TreeNodeUpdateTitleAndIconParams f573347a;

    public m(IOperationUpdate$TreeNodeUpdateTitleAndIconParams r100) {
        this.f573347a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        Lazy<WikiTreeNotificationServiceImpl> r102 = WikiTreeNotificationServiceImpl.f241625b;
        WikiTreeNotificationServiceImpl.a.a().h(this.f573347a);
        com.bytedance.ee.bear.route.h r103 = (com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6);
        IOperationUpdate$TreeNodeUpdateTitleAndIconParams r104 = this.f573347a;
        r103.Xc(r104.wikiToken, r104.newIconInfo, TabAppInfo.CustomNavigationAppLogoType.APP_LOGO_TYPE_CCM_ICON);
    }
}
