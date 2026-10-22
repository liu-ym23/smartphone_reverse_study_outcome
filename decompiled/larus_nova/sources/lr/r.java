package lr;

import android.content.Context;
import com.bytedance.android.ecom.service_annotation.ServiceDefaultImpl;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@ServiceDefaultImpl
public final class r implements xi.a {
    public r() {
    }

    @Override // xi.a
    public final void b(Context r100, String r101, String r102, String r103, long r104, JSONObject r105) {
    }

    @Override // xi.a
    public final void c(long r100, long r101) {
    }

    @Override // xi.a
    public final void e(Exception r100) {
    }

    @Override // xi.a
    public final void logV3(String r100, JSONObject r101) {
    }

    @Override // xi.a
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "abSDKVersion");
    }

    @Override // xi.a
    public final String addCommonParams(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        return null;
    }

    @Override // xi.a
    public final void d(String r100, List<String> r101, Long r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "trackLabel");
    }
}
