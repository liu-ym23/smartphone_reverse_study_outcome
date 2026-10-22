package com.lynx.component.svg;

import android.text.TextUtils;
import com.lynx.component.svg.parser.SVG;
import com.lynx.component.svg.parser.SVGParseException;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.utils.l;
import d8a.i;

/* JADX INFO: loaded from: classes32.dex */
public final class f implements d8a.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d.InterfaceC4557d f381017a;

    public f(d.c r100) {
        this.f381017a = r100;
    }

    @Override // d8a.g
    public final void onFailed(i r100) {
        this.f381017a.onError(r100.f467442b);
    }

    @Override // d8a.g
    public final void onSuccess(i r100) {
        byte[] r101 = l.a(r100.f467444d);     // Catch: SVGParseException -> L15
        if (r101 != null) goto L6;
        String r102 = null;
    L8:
        if (TextUtils.isEmpty(r102) == false) goto L10;
        r100.f467442b = "data is empty!";     // Catch: SVGParseException -> L15
    L17:
        this.f381017a.onError(r100.f467442b);
        return;
    L10:
        SVG r103 = SVG.c(r102);     // Catch: SVGParseException -> L15
        d.InterfaceC4557d r104 = this.f381017a;     // Catch: SVGParseException -> L15
        if ((r104 instanceof d.c) == false) goto L13;
        ((d.c) r104).a(r102, r103);     // Catch: SVGParseException -> L15
        return;
    L13:
        r104.onSuccess();     // Catch: SVGParseException -> L15
        return;
    L6:
        r102 = new String(r101);     // Catch: SVGParseException -> L15
    L15:
        e = move-exception;
        r100.f467442b = e.toString();
        LLog.DTHROW(new RuntimeException(e));
        goto L17
    }
}
