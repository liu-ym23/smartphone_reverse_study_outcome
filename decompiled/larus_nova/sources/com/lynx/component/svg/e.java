package com.lynx.component.svg;

import com.lynx.component.svg.parser.SVG;
import com.lynx.component.svg.parser.SVGParseException;
import com.lynx.tasm.resourceprovider.LynxResourceResponse;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes32.dex */
public final class e implements e8a.a<byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d.InterfaceC4557d f381015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f381016b;

    @Override // e8a.a
    public final void onResponse(LynxResourceResponse<byte[]> r100) {
        if (r100.f383708a != LynxResourceResponse.ResponseState.SUCCESS) goto L15;
        byte[] r101 = r100.f383709b;
        if (r101 != null) goto L7;
        this.f381015a.onError("data is empty!");
        return;
    L7:
        String r102 = new String(r101, StandardCharsets.UTF_8);
        SVG r103 = SVG.c(r102);     // Catch: SVGParseException -> L13
        d.InterfaceC4557d r104 = this.f381015a;     // Catch: SVGParseException -> L13
        if ((r104 instanceof d.c) == false) goto L11;
        ((d.c) r104).a(r102, r103);     // Catch: SVGParseException -> L13
    L21:
        return;
    L11:
        r104.onSuccess();     // Catch: SVGParseException -> L13
    L13:
        e = move-exception;
        this.f381015a.onError(e.toString());
        return;
    L15:
        d.InterfaceC4557d r105 = this.f381015a;
        Throwable r106 = r100.f383710c;
        if (r106 == null) goto L18;
        String r107 = r106.toString();
    L19:
        r105.onError(r107);
        return;
    L18:
        r107 = "svg fetch src failed! " + this.f381016b;
        goto L19
    }

    public e(d.c r100, String r101) {
        this.f381015a = r100;
        this.f381016b = r101;
    }
}
