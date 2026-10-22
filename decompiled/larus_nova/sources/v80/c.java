package v80;

import com.bytedance.android.livehostapi.business.depend.ILiveFaceCertCallback;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class c extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ILiveFaceCertCallback f553606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, String> f553607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f553608d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<String, String> f553609e;

    public c() {
        this.f553607c = new HashMap();
        new JSONObject();
        this.f553609e = new HashMap();
    }

    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f553609e.put(r100, r101);
    }
}
