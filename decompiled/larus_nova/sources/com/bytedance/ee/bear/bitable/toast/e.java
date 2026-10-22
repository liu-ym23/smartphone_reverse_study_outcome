package com.bytedance.ee.bear.bitable.toast;

import com.alibaba.fastjson.JSONObject;
import tb5.m;

/* JADX INFO: loaded from: classes16.dex */
public final class e implements b.InterfaceC3083b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f215991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ToastModel f215992b;

    @Override // com.bytedance.ee.bear.bitable.toast.b.InterfaceC3083b
    public final void a() {
        JSONObject r100 = new JSONObject();
        r100.put2("id", this.f215992b.getId());
        r100.put2("closeType", Integer.valueOf(ToastModel.CLoseType.Confirm.getValue()));
        m r101 = this.f215991a;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.toast.b.InterfaceC3083b
    public final void onTimeout() {
        JSONObject r100 = new JSONObject();
        r100.put2("id", this.f215992b.getId());
        r100.put2("closeType", Integer.valueOf(ToastModel.CLoseType.Timeout.getValue()));
        m r101 = this.f215991a;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    public e(m r100, ToastModel r101) {
        this.f215991a = r100;
        this.f215992b = r101;
    }
}
