package com.lynx.tasm.fontface;

import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.provider.LynxResourceCallback;
import com.lynx.tasm.provider.LynxResourceResponse;

/* JADX INFO: loaded from: classes32.dex */
public final class f extends LynxResourceCallback<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String[] f383429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f383430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LynxContext f383431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ FontFaceManager f383432d;

    @Override // com.lynx.tasm.provider.LynxResourceCallback
    public final void onResponse(LynxResourceResponse<String> r100) {
        super.onResponse(r100);
        String r101 = r100.getData();
        if (r100.success() == false) goto L5;
        this.f383429a[0] = r101;
        return;
    L5:
        FontFaceManager r102 = this.f383432d;
        String r103 = r100.getError().getMessage();
        String r104 = this.f383430b;
        LynxContext r105 = this.f383431c;
        r102.getClass();
        FontFaceManager.n(30202, r103, r104, null, r105);
    }

    public f(FontFaceManager r100, String[] r101, String r102, LynxContext r103) {
        this.f383432d = r100;
        this.f383429a = r101;
        this.f383430b = r102;
        this.f383431c = r103;
    }
}
