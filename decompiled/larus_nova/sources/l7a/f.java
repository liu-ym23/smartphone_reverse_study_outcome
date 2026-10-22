package l7a;

import com.lynx.tasm.core.resource.LynxResourceLoader;
import com.lynx.tasm.provider.LynxResourceCallback;
import com.lynx.tasm.provider.LynxResourceResponse;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;

/* JADX INFO: loaded from: classes32.dex */
public final class f extends LynxResourceCallback<byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f507887a;

    @Override // com.lynx.tasm.provider.LynxResourceCallback
    public final void onResponse(LynxResourceResponse<byte[]> r100) {
        super.onResponse(r100);
        k r101 = this.f507887a;
        boolean r102 = r100.success();
        byte[] r103 = r100.getData();
        if (r100.getError() == null) goto L5;
        String r104 = r100.getError().getMessage();
    L6:
        r101.b(r102, r103, null, r104);
        return;
    L5:
        r104 = null;
        goto L6
    }

    public f(LynxResourceLoader r100, String r101, long r110, LynxResourceRequest.LynxResourceType r111) {
        this.f507887a = new k(r101, r110, r100.f383310f, r111);
    }
}
