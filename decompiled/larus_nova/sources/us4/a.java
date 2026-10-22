package us4;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.bitable.common.BTJson;
import com.bytedance.ee.bear.bitable.homepage.preview.BoostViewData;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f551480c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<BoostViewData> f551481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f551482b;

    /* JADX INFO: renamed from: us4.a$a, reason: collision with other inner class name */
    public static final class C7927a {
    }

    static {
    }

    public a() {
        MutableLiveData<BoostViewData> r100 = new MutableLiveData();
        this.f551481a = r100;
        int r101 = com.bytedance.ee.bear.bitable.c.f207079a;
        int r102 = com.bytedance.ee.bear.bitable.n.f214744a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.mobile_homepage.enable") == true) goto L5;
        return;
    L5:
        if (r100.getValue() != null) goto L20;
        BoostViewData r103 = null;
        String r104 = ay4.b.d(DocumentType.BITABLE_NAME, 6).getString("homepage_native_view_preview", null);     // Catch: Exception -> L17
        if (r104 == null) goto L11;
        BoostViewData r105 = (BoostViewData) BTJson.f209798c.f209799a.fromJson(r104, BoostViewData.class);     // Catch: Exception -> L17
        if (r105 == null) goto L11;
    L12:
        if (r105 != null) goto L14;
    L18:
        if (r103 == null) goto L20;
        this.f551481a.setValue(r103);
        goto L20
    L14:
        if (r105.isValid() == false) goto L18;
        r105.setFromCache(true);     // Catch: Exception -> L17
        j.a(r105.getNativeViewData());     // Catch: Exception -> L17
        r103 = r105;
    L11:
        r105 = null;
    L17:
        j.b(null);
    L20:
        tt5.a.h("BitableBoostDataSource", "loadBoostData>> start getBoostData");
        this.f551482b = ((NetService) e0c.k.a(LarkContext.getApplication(), NetService.class)).Vc(f.f551487a).a(new NetService.f("/space/api/bitable/mobile/homepage/boost_status")).map(g.f551488a).concatMap(c.f551484a).subscribeOn(Schedulers.computation()).observeOn(Schedulers.computation()).subscribe(new d(this), new e(this));
    }
}
