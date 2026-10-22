package oo0;

import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.openplatform.impl.base.bootconfig.BootConfigContextService;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes46.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BootConfigContextService f524510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f524511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1 f524512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function0 f524513d;

    public c(BootConfigContextService r100, String r101, Function1 r102, Function0 r103) {
        this.f524510a = r100;
        this.f524511b = r101;
        this.f524512c = r102;
        this.f524513d = r103;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        qo0.a.b("BootConfigContextService", "requestBootConfig error", (Throwable) r100);
        BootConfigContextService r101 = this.f524510a;
        String r102 = this.f524511b;
        int r103 = BootConfigContextService.f84009b;
        r101.getClass();
        HashMap<String, String> r104 = com.bytedance.android.livesdk.sharedpref.b.f158245z2.getValue();
        if (r104.containsKey(r102) == false) goto L5;
        com.bytedance.android.live.openplatform.impl.base.api.response.a r105 = (com.bytedance.android.live.openplatform.impl.base.api.response.a) JsonUtil.parse(r104.get(r102), new a().getType());
    L6:
        if (r105 == null) goto L8;
        this.f524510a.f84010a.put(this.f524511b, r105);
        this.f524512c.invoke(r105);
        return;
    L8:
        Function0 r106 = this.f524513d;
        if (r106 == null) goto L13;
        Unit r107 = (Unit) r106.invoke();
        return;
    L13:
        return;
    L5:
        r105 = null;
        goto L6
    }
}
