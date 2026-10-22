package com.bytedance.ee.bear.document.profile;

import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.ee.bear.lark.dependency.c0;
import org.json.JSONException;
import org.json.JSONObject;
import tb5.m;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements c0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f221230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ShowProfilePlugin.a f221231b;

    @Override // com.bytedance.ee.bear.lark.dependency.c0.a
    public final void onCancel() {
        if (ShowProfilePlugin.access$1000(this.f221231b.f221226a) == false) goto L13;
        m r100 = this.f221230a;
        this.f221231b.getClass();
        JSONObject r101 = new JSONObject();     // Catch: JSONException -> L7
        r101.put("id", "cancel");     // Catch: JSONException -> L7
        String r102 = r101.toString();     // Catch: JSONException -> L7
    L9:
        r100.onCallBack(r102);
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        r102 = SliceInitService.DEFAULT_SWITCH;
        goto L9
    }

    @Override // com.bytedance.ee.bear.lark.dependency.c0.a
    public final void onConfirm() {
        if (ShowProfilePlugin.access$800(this.f221231b.f221226a) == false) goto L13;
        m r100 = this.f221230a;
        this.f221231b.getClass();
        JSONObject r101 = new JSONObject();     // Catch: JSONException -> L7
        r101.put("id", "confirm");     // Catch: JSONException -> L7
        String r102 = r101.toString();     // Catch: JSONException -> L7
    L9:
        r100.onCallBack(r102);
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        r102 = SliceInitService.DEFAULT_SWITCH;
        goto L9
    }

    public b(ShowProfilePlugin.a r100, m r101) {
        this.f221231b = r100;
        this.f221230a = r101;
    }
}
