package vi2;

import android.os.Handler;
import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class q implements h.f<xi2.h0> {
    public final /* synthetic */ String a;
    public final /* synthetic */ byte[] b;

    @Override // vi2.h.f
    public final wi2.a<xi2.h0> execute() throws Exception {
        Handler r0 = com.bytedance.android.livesdk.livecommerce.utils.k.a;
        long r1 = System.currentTimeMillis() / 1000;
        StringBuilder r2 = new StringBuilder();
        String r3 = h.a;
        r2.append(r3);
        r2.append("datafilets");
        r2.append(r1);
        r2.append(r3);
        String r4 = ie.a.a(r2.toString().getBytes());
        FilterNullArrayList r5 = new FilterNullArrayList();
        String r6 = String.valueOf(r1);
        int r7 = si2.k.c;
        r5.add(si2.k.a.a("ts", r6));
        r5.add(si2.k.a.a("sign", r4));
        Map<String, String> r8 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r5);
        String r9 = this.a;
        byte[] r10 = this.b;
        com.bytedance.android.livesdk.livecommerce.network.hook.b.a(r9, r5);
        int r11 = zj2.a.a;
        Intrinsics.checkNotNullParameter(r9, "url");
        Intrinsics.checkNotNullParameter("data", "fileKey");
        Intrinsics.checkNotNullParameter("file", "fileName");
        Intrinsics.checkNotNullParameter(r10, "content");
        String r12 = zj2.a.b(r9, r5, true, okhttp3.k.b.b("data", "file", RequestBody.create(MediaType.parse("multipart/form-data"), r10)));
        int r13 = com.bytedance.android.livesdk.livecommerce.utils.m0.a;
        return h.f((xi2.h0) GsonProtectorUtils.fromJson(com.bytedance.android.livesdk.livecommerce.utils.m0.a.a, r12, xi2.h0.class), r8, null);
    }

    public q(String r1, byte[] r2) {
        this.a = r1;
        this.b = r2;
    }
}
