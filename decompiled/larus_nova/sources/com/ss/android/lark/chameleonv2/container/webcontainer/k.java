package com.ss.android.lark.chameleonv2.container.webcontainer;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.officewebview.bridge.Status;

/* JADX INFO: loaded from: classes35.dex */
public final class k implements tb5.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ xwb.j f411168a;

    public k(xwb.d r100) {
        this.f411168a = r100;
    }

    @Override // tb5.m
    public final void a(NonProguard r100) {
        this.f411168a.a(Status.SUCCESS, r100);
    }

    @Override // tb5.m
    public final void b(JSONObject r100) {
        this.f411168a.a(Status.SUCCESS, r100);
    }

    @Override // tb5.m
    public final void onCallBack(String r100) {
        this.f411168a.a(Status.SUCCESS, r100);
    }
}
