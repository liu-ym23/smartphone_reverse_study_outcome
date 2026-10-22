package zm2;

import com.bytedance.android.live.network.impl.interceptor.c;
import com.bytedance.android.livesdkapi.network.ILiveNetConfigService;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements ILiveNetConfigService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f572858a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f572859b = null;

    public a() {
    }

    static {
        f572859b = new a();
        f572858a = new c();
    }

    @Override // com.bytedance.android.livesdkapi.network.ILiveNetConfigService
    public final Map<String, String> generateCommonParams() {
        c r100 = f572858a;
        r100.getClass();
        LinkedHashMap r101 = new LinkedHashMap();
        r100.b(r101);
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator r103 = r101.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L10;
        Map.Entry r104 = (Map.Entry) r103.next();
        String r105 = com.bytedance.android.live.network.a.a((String) r104.getKey());
        String r106 = (String) r104.getValue();
        if (r106 == null) goto L8;
        String r107 = com.bytedance.android.live.network.a.a(r106);
    L9:
        r102.put(r105, r107);
        goto L4
    L8:
        r107 = "";
        goto L9
    L10:
        return r102;
    }
}
