package ux7;

import com.bytedance.sdk.xbridge.cn.protocol.h;
import com.ivy.ivykit.api.bridge.core.IvyBridgeMethod;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes23.dex */
public final class a extends d implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IvyBridgeMethod f552013b;

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
        IvyBridgeMethod r100 = this.f552013b;
        if ((r100 instanceof bx7.c) == false) goto L5;
        bx7.c r101 = (bx7.c) r100;
    L6:
        if (r101 == null) goto L11;
        ex7.d r102 = r101.f21364a;
        if (r102 == null) goto L10;
        ((LinkedHashMap) r102.f474722a).clear();
    L10:
        r101.f21364a = null;
    L11:
        this.f552013b.release();
        return;
    L5:
        r101 = null;
        goto L6
    }

    public a(IvyBridgeMethod r100) {
        this.f552013b = r100;
        super(r100);
    }
}
