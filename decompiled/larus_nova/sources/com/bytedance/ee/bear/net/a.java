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

/* JADX INFO: loaded from: classes18.dex */
public final class a implements FlowableOnSubscribe<p> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f235100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CloudReqFun f235101b;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.net.a$a, reason: collision with other inner class name */
    public class C3373a implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowableEmitter f235102a;

        public C3373a(FlowableEmitter r100) {
            this.f235102a = r100;
        }
    }

    @Override // io.reactivex.FlowableOnSubscribe
    public final void subscribe(FlowableEmitter<p> r100) throws Exception {
        m r101 = new m(this.f235101b.f235097a, new C3373a(r100));
        CloudReqFun.a r102 = new CloudReqFun.a(this.f235100a);
        Request.Builder r103 = new Request.Builder();
        r103.url(r102.a());
        if (r102.getRequestType() != 1) goto L6;
        r103.post(m.a(r102.e(), r102.c()));
    L11:
        Iterator<Map.Entry<String, String>> r104 = r102.b().entrySet().iterator();
    L13:
        if (r104.hasNext() == false) goto L16;
        Map.Entry<String, String> r105 = r104.next();
        r103.header(r105.getKey(), r105.getValue());
        goto L13
    L16:
        if (TextUtils.isEmpty(r102.d()) == true) goto L18;
        String r106 = r102.d();
        r103.post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), r106));
    L18:
        Request r107 = r103.build();
        r101.f4037a.b().newCall(r107).enqueue(r101);
        return;
    L6:
        if (r102.getRequestType() != 2) goto L9;
        r103.get();
        goto L11
    L9:
        if (r102.getRequestType() != 3) goto L11;
        r103.put(m.a(r102.e(), r102.c()));
        goto L11
    }

    public a(CloudReqFun r100, k r101) {
        this.f235101b = r100;
        this.f235100a = r101;
    }
}
