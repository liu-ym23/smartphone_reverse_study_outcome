package lw9;

import com.bytedance.common.utility.NetworkClient;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class i implements jn7.i {
    @Override // jn7.i
    public final void checkResponseException(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
    }

    @Override // jn7.i
    public final void getHost() {
    }

    public i() {
        if ((NetworkClient.getDefault() instanceof px3.a) == true) goto L6;
        NetworkClient.setDefault(new px3.a());
        return;
    }

    @Override // jn7.i
    public final String executeGet(String r100) throws Exception {
        Intrinsics.checkNotNullParameter(r100, "strUrl");
        return NetworkClient.getDefault().get(r100);
    }

    @Override // jn7.i
    public final String a(String r100, JSONObject r101) throws Exception {
        Intrinsics.checkNotNullParameter(r100, "strUrl");
        Intrinsics.checkNotNullParameter(r101, "json");
        return NetworkClient.getDefault().post(r100, r101.toString().getBytes(Charsets.UTF_8), false, "application/json", true);
    }
}
