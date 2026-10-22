package l7a;

import com.lynx.tasm.core.resource.LynxResourceLoader;
import com.lynx.tasm.provider.LynxResourceCallback;
import com.lynx.tasm.provider.LynxResourceResponse;

/* JADX INFO: loaded from: classes32.dex */
public final class h extends LynxResourceCallback<byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f507892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f507893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f507894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ LynxResourceLoader f507895d;

    @Override // com.lynx.tasm.provider.LynxResourceCallback
    public final void onResponse(LynxResourceResponse<byte[]> r100) {
        boolean r101 = r100.success();
        Throwable r102 = r100.getError();
        a r103 = this.f507892a;
        byte[] r104 = r100.getData();
        if (r102 == null) goto L5;
        String r105 = r102.getMessage();
    L6:
        r103.b(r101, r104, r105);
        return;
    L5:
        r105 = null;
        goto L6
    }

    public h(LynxResourceLoader r100, String r101, long r102) {
        this.f507895d = r100;
        this.f507893b = r101;
        this.f507894c = r102;
        this.f507892a = new a(this.f507895d, this.f507893b, this.f507894c);
    }
}
