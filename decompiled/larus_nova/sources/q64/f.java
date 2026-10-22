package q64;

import com.bytedance.awemeopen.servicesapi.network.ByteNetEnvHeaderName;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f531802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f531803b;

    public f(Map r100) {
        Intrinsics.checkNotNullParameter(ByteNetEnvHeaderName.PPE, "byteNetEnvHeaderName");
        Intrinsics.checkNotNullParameter(r100, "ppeConfigs");
        this.f531802a = ByteNetEnvHeaderName.PPE;
        this.f531803b = r100;
    }

    public final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (this.f531803b.keySet().contains(r100) == true) goto L5;
        Iterator<T> r101 = this.f531803b.keySet().iterator();
    L8:
        if (r101.hasNext() == false) goto L13;
        String r102 = (String) r101.next();
        if (StringsKt.startsWith$default(r100, r102, false, 2, null) == false) goto L8;
        return this.f531803b.get(r102);
    L13:
        return null;
    L5:
        return this.f531803b.get(r100);
    }
}
