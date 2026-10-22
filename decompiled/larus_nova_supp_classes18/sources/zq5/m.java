package zq5;

import com.bytedance.ee.bear.wikiv2.wikitreev2.notification.WikiTreeNotificationServiceImpl;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.IOperationUpdate$TreeNodeUpdateTitleAndIconParams;
import com.ss.android.lark.maintab.export.TabAppInfo;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ IOperationUpdate$TreeNodeUpdateTitleAndIconParams a;

    public m(IOperationUpdate$TreeNodeUpdateTitleAndIconParams r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        String r5 = (String) r4;
        Lazy<WikiTreeNotificationServiceImpl> r6 = WikiTreeNotificationServiceImpl.b;
        WikiTreeNotificationServiceImpl.a.a().h(this.a);
        com.bytedance.ee.bear.route.h r7 = (com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6);
        IOperationUpdate$TreeNodeUpdateTitleAndIconParams r0 = this.a;
        r7.Xc(r0.wikiToken, r0.newIconInfo, TabAppInfo.CustomNavigationAppLogoType.APP_LOGO_TYPE_CCM_ICON);
    }
}
