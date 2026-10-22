package l7a;

import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.resourceprovider.LynxResourceResponse;

/* JADX INFO: loaded from: classes32.dex */
public final class i implements e8a.a<h8a.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f507896a;

    public i(k r100) {
        this.f507896a = r100;
    }

    @Override // e8a.a
    public final void onResponse(LynxResourceResponse<h8a.b> r100) {
        h8a.b r101 = r100.f383709b;
        String r102 = null;
        if (r101 == null) goto L5;
        byte[] r103 = r101.f484295a;
        TemplateBundle r104 = r101.f484296b;
    L6:
        Throwable r105 = r100.f383710c;
        if (r105 == null) goto L9;
        r102 = r105.getMessage();
    L9:
        k r106 = this.f507896a;
        if (r100.f383708a != LynxResourceResponse.ResponseState.SUCCESS) goto L12;
        boolean r107 = true;
    L13:
        r106.b(r107, r103, r104, r102);
        return;
    L12:
        r107 = false;
        goto L13
    L5:
        r104 = null;
        r103 = null;
        goto L6
    }
}
