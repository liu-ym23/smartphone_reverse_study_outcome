package n33;

import com.bytedance.android.shopping.abscontainer.arch.core.data.ResponseType;
import com.bytedance.ttnet.http.HttpRequestInfo;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class f extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HttpRequestInfo f516919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f516920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f516921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ResponseType f516922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f516923e;

    public f() {
        throw null;
    }

    public final ResponseType getType() {
        return this.f516922d;
    }

    public f(a r100, String r101, ResponseType r102) {
        HashMap r103 = new HashMap();
        Intrinsics.checkNotNullParameter(r100, "yataData");
        Intrinsics.checkNotNullParameter(r102, "type");
        Intrinsics.checkNotNullParameter(r103, "extra");
        this.f516920b = r100;
        this.f516921c = r101;
        this.f516922d = r102;
        this.f516923e = r103;
    }
}
