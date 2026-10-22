package qx6;

import com.bytedance.locallife.pdp.entity.GoodsBizCodeInfo;
import com.bytedance.locallife.pdp.entity.GoodsBizCodeRealInfo;
import com.ss.android.ugc.aweme.poi.bean.PoiRouterExtra;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes21.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f535126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f535127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f535128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f535129d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f535130e;

    public b(e r100, String r101, String r102, String r103, String r104) {
        this.f535126a = r100;
        this.f535127b = r101;
        this.f535128c = r102;
        this.f535129d = r103;
        this.f535130e = r104;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        GoodsBizCodeInfo r101 = (GoodsBizCodeInfo) r100;
        e r102 = this.f535126a;
        String r103 = null;
        if (r101 == null) goto L7;
        GoodsBizCodeRealInfo r104 = r101.getData();
        if (r104 == null) goto L7;
        String r105 = r104.getBizCode();
    L8:
        r102.f535137a = r105;
        this.f535126a.f535138b = PoiRouterExtra.BIZ_CODE_REQ.routerMode;
        int r106 = d.f535136a;
        String r107 = this.f535127b;
        String r108 = this.f535128c;
        String r109 = this.f535129d;
        String r110 = this.f535130e;
        if (r101 == null) goto L13;
        GoodsBizCodeRealInfo r111 = r101.getData();
        if (r111 == null) goto L13;
        r103 = r111.getBizCode();
    L13:
        d.a(r107, r108, r109, r110, "0", r103);
        return;
    L7:
        r105 = null;
        goto L8
    }
}
