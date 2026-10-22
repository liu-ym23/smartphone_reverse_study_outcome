package l7a;

import com.lynx.tasm.core.resource.LynxResourceLoader;
import com.lynx.tasm.resourceprovider.LynxResourceResponse;

/* JADX INFO: loaded from: classes32.dex */
public final class g implements e8a.a<byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f507888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f507889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f507890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ LynxResourceLoader f507891d;

    @Override // e8a.a
    public final void onResponse(LynxResourceResponse<byte[]> r100) {
        if (r100.f383708a != LynxResourceResponse.ResponseState.SUCCESS) goto L5;
        boolean r101 = true;
    L6:
        Throwable r102 = r100.f383710c;
        a r103 = this.f507888a;
        byte[] r104 = r100.f383709b;
        if (r102 == null) goto L9;
        String r105 = r102.getMessage();
    L10:
        r103.b(r101, r104, r105);
        return;
    L9:
        r105 = "";
        goto L10
    L5:
        r101 = false;
        goto L6
    }

    public g(LynxResourceLoader r100, String r101, long r102) {
        this.f507891d = r100;
        this.f507889b = r101;
        this.f507890c = r102;
        this.f507888a = new a(this.f507891d, this.f507889b, this.f507890c);
    }
}
