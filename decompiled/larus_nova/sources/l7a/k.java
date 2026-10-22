package l7a;

import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.core.resource.LynxResourceLoader;
import com.lynx.tasm.q0;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import com.lynx.tasm.service.security.ILynxSecurityService;
import i8a.n;

/* JADX INFO: loaded from: classes32.dex */
public final class k extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f507898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q0 f507899d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LynxResourceRequest.LynxResourceType f507900e;

    public k(String r100, long r101, q0 r102, LynxResourceRequest.LynxResourceType r103) {
        super(r100);
        this.f507898c = r101;
        this.f507899d = r102;
        this.f507900e = r103;
    }

    public final void b(boolean r110, byte[] r111, TemplateBundle r112, String r113) {
        if (a() == true) goto L5;
        return;
    L5:
        int r100 = 0;
        if (r111 != null) goto L8;
    L10:
        boolean r101 = false;
    L11:
        if (r112 != null) goto L13;
    L15:
        boolean r114 = false;
    L16:
        if (r110 == false) goto L22;
        if (r101 == true) goto L19;
        if (r114 == false) goto L22;
    L19:
        q0 r102 = this.f507899d;
        if (r102 == null) goto L22;
        r102.a("last_lynx_async_component_url", this.f507879b);
    L22:
        if (r110 == false) goto L34;
        if (r114 == true) goto L34;
        if (r101 == false) goto L34;
        ILynxSecurityService r103 = (ILynxSecurityService) n.c().a(ILynxSecurityService.class);
        if (r103 == null) goto L34;
        if (this.f507900e != LynxResourceRequest.LynxResourceType.LynxResourceTypeTemplate) goto L30;
        ILynxSecurityService.LynxTasmType r104 = ILynxSecurityService.LynxTasmType.TYPE_TEMPLATE;
    L32:
        if (r103.verifyTASM(null, r111, null, this.f507879b, r104).f497736a == true) goto L34;
        String r115 = "tasm verify failed, url: " + this.f507879b;
        boolean r105 = false;
    L35:
        long r106 = this.f507898c;
        if (r114 == false) goto L38;
        long r107 = r112.f381768a;
    L39:
        if (r105 == true) goto L42;
        r100 = -1;
    L42:
        LynxResourceLoader.nativeInvokeCallback(r106, r111, r107, null, r100, r115);
        return;
    L38:
        r107 = 0;
        goto L39
    L30:
        r104 = ILynxSecurityService.LynxTasmType.TYPE_DYNAMIC_COMPONENT;
    L34:
        r105 = r110;
        r115 = r113;
        goto L35
    L13:
        if (r112.i() == false) goto L15;
        r114 = true;
        goto L16
    L8:
        if (r111.length <= 0) goto L10;
        r101 = true;
        goto L11
    }
}
