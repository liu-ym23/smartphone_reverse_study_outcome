package com.bytedance.ee.bear.net;

import ak5.k;
import ak5.m;
import ak5.p;
import ak5.u;
import android.text.TextUtils;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import java.util.Iterator;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements FlowableOnSubscribe<p> {
    public final /* synthetic */ k a;
    public final /* synthetic */ CloudReqFun b;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.net.a$a, reason: collision with other inner class name */
    public class C0126a implements u {
        public final /* synthetic */ FlowableEmitter a;

        public C0126a(FlowableEmitter r1) {
            this.a = r1;
        }
    }

    public final void subscribe(FlowableEmitter<p> r6) throws Exception {
        m r0 = new m(this.b.a, new C0126a(r6));
        CloudReqFun.a r7 = new CloudReqFun.a(this.a);
        Request.Builder r1 = new Request.Builder();
        r1.url(r7.a());
        if (r7.getRequestType() != 1) goto L6;
        r1.post(m.a(r7.e(), r7.c()));
    L11:
        Iterator<Map.Entry<String, String>> r2 = r7.b().entrySet().iterator();
    L13:
        if (r2.hasNext() == false) goto L16;
        Map.Entry<String, String> r3 = r2.next();
        r1.header(r3.getKey(), r3.getValue());
        goto L13
    L16:
        if (TextUtils.isEmpty(r7.d()) == true) goto L18;
        String r8 = r7.d();
        r1.post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), r8));
    L18:
        Request r9 = r1.build();
        r0.a.b().newCall(r9).enqueue(r0);
        return;
    L6:
        if (r7.getRequestType() != 2) goto L9;
        r1.get();
        goto L11
    L9:
        if (r7.getRequestType() != 3) goto L11;
        r1.put(m.a(r7.e(), r7.c()));
        goto L11
    }

    public a(CloudReqFun r1, k r2) {
        this.b = r1;
        this.a = r2;
    }
}
