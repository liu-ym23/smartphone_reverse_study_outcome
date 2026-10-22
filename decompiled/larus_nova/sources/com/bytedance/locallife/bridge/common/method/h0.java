package com.bytedance.locallife.bridge.common.method;

import android.text.TextUtils;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class h0 implements com.bytedance.locallife.host.share.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ko6.z.c f257069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g0 f257070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<ko6.z.c> f257071c;

    @Override // com.bytedance.locallife.host.share.t
    public final void b() {
        Intrinsics.checkNotNullParameter("copy", "actionKey");
        if (TextUtils.equals("copy", "copy") == false) goto L6;
        g0 r100 = this.f257070b;
        ko6.z.c r101 = this.f257069a;
        r100.getClass();
        r101.setCode(1);
        r101.setButton("copy");
        return;
    }

    @Override // com.bytedance.locallife.host.share.t
    public final void c() {
        g0.a(this.f257070b, this.f257069a);
    }

    @Override // com.bytedance.locallife.host.share.t
    public final void onDismiss() {
        this.f257070b.getClass();
        if (Intrinsics.areEqual(this.f257069a.getCode(), -1) == false) goto L5;
        g0.a(this.f257070b, this.f257069a);
    L5:
        this.f257071c.onRawSuccess(this.f257069a);
    }

    public h0(g0 r100, CompletionBlock<ko6.z.c> r101) {
        this.f257070b = r100;
        this.f257071c = r101;
        ko6.z.c r102 = (ko6.z.c) ne7.e.b(ko6.z.c.class);
        r102.setCode(-1);
        r102.setButton("");
        this.f257069a = r102;
    }

    @Override // com.bytedance.locallife.host.share.t
    public final void a(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "channelKey");
        if (r101 == false) goto L8;
        g0 r102 = this.f257070b;
        ko6.z.c r103 = this.f257069a;
        r102.getClass();
        r103.setCode(1);
        if (r100 != null) goto L7;
        r100 = "";
    L7:
        r103.setButton(r100);
        return;
    L8:
        g0 r104 = this.f257070b;
        ko6.z.c r105 = this.f257069a;
        r104.getClass();
        r105.setCode(0);
        if (r100 != null) goto L11;
        r100 = "";
    L11:
        r105.setButton(r100);
        ko6.z.d r106 = (ko6.z.d) ne7.e.b(ko6.z.d.class);
        r106.setMsg("unknown");
        r105.setData(r106);
    }
}
