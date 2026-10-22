package uf5;

import android.text.TextUtils;
import androidx.core.util.Pair;
import com.bytedance.ee.bear.contract.AccountService;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class v implements Function {
    public final /* synthetic */ l0 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public /* synthetic */ v(l0 r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object apply(Object r7) {
        l0 r0 = this.a;
        String r1 = this.b;
        String r2 = this.c;
        String r8 = (String) r7;
        r0.getClass();
        AccountService.Account r9 = ((com.bytedance.ee.bear.contract.h0) org.koin.java.a.a(com.bytedance.ee.bear.contract.h0.class)).U5();
        String r10 = r9.tenantId + "_" + r9.uid + "_/api/message/get_message.v3/native";
        com.bytedance.ee.bear.middleground.feed.export.bean.k r3 = r0.c;
        if (r3 == null) goto L16;
        Pair<Integer, String> r4 = r3.c(r10, r1);
        if (r4 != null) goto L8;
    L13:
        tt5.a.h("FeedMessageManager", "insert result:" + r0.c.a(r10, r1, r2));
    L15:
        return Boolean.TRUE;
    L8:
        if (TextUtils.isEmpty((CharSequence) r4.second) == true) goto L13;
        Object r5 = r4.first;
        if (r5 == null) goto L15;
        tt5.a.h("FeedMessageManager", "update result:" + r0.c.b(((Integer) r5).intValue(), r10, r1, r2));
        goto L15
    L16:
        return Boolean.FALSE;
    }
}
