package uf5;

import android.text.TextUtils;
import androidx.core.util.Pair;
import com.bytedance.ee.bear.contract.AccountService$Account;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: classes18.dex */
public final /* synthetic */ class v implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l0 f549940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f549941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f549942c;

    public /* synthetic */ v(l0 r100, String r101, String r102) {
        this.f549940a = r100;
        this.f549941b = r101;
        this.f549942c = r102;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        l0 r101 = this.f549940a;
        String r102 = this.f549941b;
        String r103 = this.f549942c;
        String r104 = (String) r100;
        r101.getClass();
        AccountService$Account r105 = ((com.bytedance.ee.bear.contract.h0) org.koin.java.a.a(com.bytedance.ee.bear.contract.h0.class)).U5();
        String r106 = r105.tenantId + "_" + r105.uid + "_/api/message/get_message.v3/native";
        com.bytedance.ee.bear.middleground.feed.export.bean.k r107 = r101.f549915c;
        if (r107 == null) goto L16;
        Pair<Integer, String> r108 = r107.c(r106, r102);
        if (r108 != null) goto L8;
    L13:
        tt5.a.h("FeedMessageManager", "insert result:" + r101.f549915c.a(r106, r102, r103));
    L15:
        return Boolean.TRUE;
    L8:
        if (TextUtils.isEmpty(r108.second) == true) goto L13;
        Integer r109 = r108.first;
        if (r109 == null) goto L15;
        tt5.a.h("FeedMessageManager", "update result:" + r101.f549915c.b(r109.intValue(), r106, r102, r103));
        goto L15
    L16:
        return Boolean.FALSE;
    }
}
