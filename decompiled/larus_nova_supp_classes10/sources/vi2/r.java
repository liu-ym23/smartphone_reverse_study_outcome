package vi2;

import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.io.File;
import java.util.Map;
import java.util.Observer;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class r implements h.f<xi2.h0> {
    public final /* synthetic */ File a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Observer c;

    @Override // vi2.h.f
    public final wi2.a<xi2.h0> execute() throws Exception {
        File r0 = this.a;
        if (r0 != null) goto L5;
    L17:
        StringBuilder r1 = new StringBuilder("screenshot file don't exists in path ");
        File r2 = this.a;
        if (r2 != null) goto L20;
        String r3 = "empty file path。";
    L21:
        r1.append(r3);
        throw new IllegalArgumentException(r1.toString());
    L20:
        r3 = r2.getAbsolutePath();
        goto L21
    L5:
        if (r0.exists() == false) goto L17;
        Handler r4 = com.bytedance.android.livesdk.livecommerce.utils.k.a;
        long r5 = System.currentTimeMillis() / 1000;
        StringBuilder r6 = new StringBuilder();
        String r7 = h.a;
        r6.append(r7);
        r6.append("data");
        r6.append(this.a.getName());
        r6.append("ts");
        r6.append(r5);
        r6.append(r7);
        String r8 = ie.a.a(r6.toString().getBytes());
        FilterNullArrayList r9 = new FilterNullArrayList();
        String r10 = String.valueOf(r5);
        int r11 = si2.k.c;
        r9.add(si2.k.a.a("ts", r10));
        r9.add(si2.k.a.a("sign", r8));
        Map<String, String> r12 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r9);
        String r13 = this.b;
        File r14 = this.a;
        com.bytedance.android.livesdk.livecommerce.network.hook.b.a(r13, r9);
        int r15 = zj2.a.a;
        Intrinsics.checkNotNullParameter(r13, "url");
        if (TextUtils.isEmpty("data") == true) goto L16;
        if (r14 == null) goto L16;
        RequestBody r16 = RequestBody.create(MediaType.parse("multipart/form-data"), r14);
        String r17 = zj2.a.b(r13, r9, true, okhttp3.k.b.b("data", r14.getName(), r16));
        int r18 = com.bytedance.android.livesdk.livecommerce.utils.m0.a;
        xi2.h0 r19 = (xi2.h0) GsonProtectorUtils.fromJson(com.bytedance.android.livesdk.livecommerce.utils.m0.a.a, r17, xi2.h0.class);
        Observer r20 = this.c;
        if (r20 == null) goto L14;
        r20.update(null, null);
    L14:
        return h.f(r19, r12, null);
    L16:
        throw new IllegalArgumentException("file key or file object is null !!!!");
    }

    public r(File r1, String r2, com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.w r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
