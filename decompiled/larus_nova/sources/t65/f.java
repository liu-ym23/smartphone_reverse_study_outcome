package t65;

import io.reactivex.functions.Consumer;
import java.util.HashMap;

/* JADX INFO: loaded from: classes16.dex */
public final /* synthetic */ class f implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f544665a;

    public /* synthetic */ f(String r100) {
        this.f544665a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = this.f544665a;
        String r102 = (String) r100;
        com.bytedance.ee.bear.contract.d r103 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        HashMap r104 = new HashMap();
        r104.put("action", r101);
        r104.put("trigger_action", "drive");
        r103.v("client_commerce", r104);
    }
}
