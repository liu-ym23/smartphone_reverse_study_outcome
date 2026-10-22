package s35;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.document.more.MoreModel;
import com.bytedance.ee.bear.document.share.ShareItem;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.larus.nova.R;
import java.util.List;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: classes16.dex */
public class a implements i<ShareItem> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m f540466a;

    public a() {
    }

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r100, m r101) {
        ShareItem r102 = (ShareItem) r100;
        this.f540466a = r101;
        com.bytedance.ee.bear.document.share.a r103 = (com.bytedance.ee.bear.document.share.a) this;
        tt5.a.h("ShareHandler", "share is called.");
        if (j.a.f217090a.getNetworkState().a() == true) goto L5;
        tt5.a.h("ShareHandler", "WebViewFragment.share: 468 no network");
        FragmentActivity r104 = r103.f221763b.getActivity();
        Toast.showFailureText(r104, r104.getResources().getText(R.string.Doc_Facade_Offline), 0);
        return;
    L5:
        if (r102 != null) goto L8;
        tt5.a.h("ShareHandler", "share content is empty");
        r103.c(null);
        return;
    L8:
        if (TextUtils.isEmpty(r102.getUrl()) == false) goto L11;
        tt5.a.d("ShareHandler", "share data.getUrl == null");
        FragmentActivity r105 = r103.f221763b.getActivity();
        Toast.showFailureText(r105, r105.getString(R.string.Doc_Doc_NetException), 0);
        return;
    L11:
        if (r102.isEnable() == false) goto L37;
        b r106 = new b();
        r106.f540467a = r102.getTitle();
        r106.f540468b = r102.getUrl();
        r106.f540469c = r102.getContent();
        r106.f540470d = r102.getTopic();
        r106.f540478l = r103;
        List<Integer> r107 = r102.getDisabledShareTypes();
        if (r107 != null) goto L15;
    L17:
        List<Integer> r108 = r102.getBadgeShareTypes();
        if (r108 == null) goto L23;
        if (r108.size() <= 0) goto L23;
        r106.f540472f.addAll(r108);
    L23:
        if (r103.f221767f == false) goto L30;
        ShareItem.BizInfo r109 = r102.getBizInfo();
        if (r109 == null) goto L30;
        MoreModel.Bitable r110 = r109.getBitableProInfo();
        if (r110 == null) goto L30;
        r106.f540473g = r110.isPro();
        r106.f540474h = r110.getTables();
        r106.f540475i = r110.getBlocks();
    L30:
        if (r103.f221768g == false) goto L36;
        ShareItem.BizInfo r111 = r102.getBizInfo();
        if (r111 == null) goto L36;
        MoreModel.Bitable r112 = r111.getBitableProInfo();
        if (r112 == null) goto L36;
        r106.f540473g = r112.isPro();
        r106.f540476j = r112.isProAccessConfigBindRole();
        r106.f540477k = r112.getMembers();
    L36:
        r103.c(r106);
        return;
    L15:
        if (r107.size() <= 0) goto L17;
        r106.f540471e.addAll(r107);
        goto L17
    L37:
        tt5.a.b("ShareHandler", "ShareHandler.handleShareData: disable share. do nothing ");
    }
}
