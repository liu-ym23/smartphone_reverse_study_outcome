package com.bytedance.pia.core.plugins;

import com.bytedance.vmsdk.jsbridge.utils.Callback;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class a<T> implements l47.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BridgeDowngradePlugin.a f266280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BridgeDowngradePlugin f266281b;

    public a(BridgeDowngradePlugin.a r100, BridgeDowngradePlugin r101) {
        this.f266280a = r100;
        this.f266281b = r101;
    }

    @Override // l47.a
    public final void accept(Object r100) {
        JSONObject r101 = (JSONObject) r100;
        Callback r102 = this.f266280a.f266248c;
        if (r102 == null) goto L6;
        BridgeDowngradePlugin r103 = this.f266281b;
        int r104 = BridgeDowngradePlugin.f266244d;
        r103.getClass();
        r102.invoke(new Object[]{BridgeDowngradePlugin.i(r101)});
        return;
    }
}
