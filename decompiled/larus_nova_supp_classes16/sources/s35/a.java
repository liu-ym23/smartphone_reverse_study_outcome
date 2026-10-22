package s35;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.document.more.MoreModel;
import com.bytedance.ee.bear.document.share.ShareItem;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import java.util.List;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class a implements i<ShareItem> {
    public m a;

    public a() {
    }

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r4, m r5) {
        ShareItem r6 = (ShareItem) r4;
        this.a = r5;
        com.bytedance.ee.bear.document.share.a r7 = (com.bytedance.ee.bear.document.share.a) this;
        tt5.a.h("ShareHandler", "share is called.");
        if (j.a.a.getNetworkState().a() == true) goto L5;
        tt5.a.h("ShareHandler", "WebViewFragment.share: 468 no network");
        FragmentActivity r8 = r7.b.getActivity();
        Toast.showFailureText(r8, r8.getResources().getText(2131887789), 0);
        return;
    L5:
        if (r6 != null) goto L8;
        tt5.a.h("ShareHandler", "share content is empty");
        r7.c(null);
        return;
    L8:
        if (TextUtils.isEmpty(r6.getUrl()) == false) goto L11;
        tt5.a.d("ShareHandler", "share data.getUrl == null");
        FragmentActivity r9 = r7.b.getActivity();
        Toast.showFailureText(r9, r9.getString(2131887674), 0);
        return;
    L11:
        if (r6.isEnable() == false) goto L37;
        b r0 = new b();
        r0.a = r6.getTitle();
        r0.b = r6.getUrl();
        r0.c = r6.getContent();
        r0.d = r6.getTopic();
        r0.l = r7;
        List<Integer> r1 = r6.getDisabledShareTypes();
        if (r1 != null) goto L15;
    L17:
        List<Integer> r2 = r6.getBadgeShareTypes();
        if (r2 == null) goto L23;
        if (r2.size() <= 0) goto L23;
        r0.f.addAll(r2);
    L23:
        if (r7.f == false) goto L30;
        ShareItem.BizInfo r3 = r6.getBizInfo();
        if (r3 == null) goto L30;
        MoreModel.Bitable r10 = r3.getBitableProInfo();
        if (r10 == null) goto L30;
        r0.g = r10.isPro();
        r0.h = r10.getTables();
        r0.i = r10.getBlocks();
    L30:
        if (r7.g == false) goto L36;
        ShareItem.BizInfo r11 = r6.getBizInfo();
        if (r11 == null) goto L36;
        MoreModel.Bitable r12 = r11.getBitableProInfo();
        if (r12 == null) goto L36;
        r0.g = r12.isPro();
        r0.j = r12.isProAccessConfigBindRole();
        r0.k = r12.getMembers();
    L36:
        r7.c(r0);
        return;
    L15:
        if (r1.size() <= 0) goto L17;
        r0.e.addAll(r1);
        goto L17
    L37:
        tt5.a.b("ShareHandler", "ShareHandler.handleShareData: disable share. do nothing ");
    }
}
