package com.bytedance.ee.bear.bitable.celleditor.editor;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.celleditor.bean.EditorLocation;
import com.bytedance.ee.bear.bitable.uikit.Action;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public class b extends gv4.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f209378b = 0;

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // gv4.d, gv4.a
    public final void a(Action r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        tt5.a.h("BitableEditorActionHandler", "onProduce: " + r100.getAction());
        super.a(r100);
    }

    public final <T> void c(T r100) {
        ActionPayload r101 = new ActionPayload();
        r101.setAction("EditRecord");
        r101.setEditResult(r100);
        r101.setTransactionId(System.currentTimeMillis() + r101.getRecordId());
        a(r101);
    }

    public final void d(boolean r100) {
        JSONObject r101 = new JSONObject();
        r101.put("action", "EditorCloseAction");
        r101.put("disableSyncData", Boolean.valueOf(r100));
        e(r101);
    }

    public final void e(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        tt5.a.h("BitableEditorActionHandler", "onProduce: " + r100.getString("action"));     // Catch: Exception -> L7
        m r101 = this.f482819a;     // Catch: Exception -> L7
        if (r101 == null) goto L12;
        r101.b(r100);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        tt5.a.e("BitableEditorActionHandler", "onProduce: error", e, false);
    }

    public final void b(EditorLocation r100, Object r101) {
        Intrinsics.checkNotNullParameter("cover", "editType");
        JSONObject r102 = new JSONObject();
        r102.put("action", "EditRecord");
        r102.put("location", r100);
        r102.put("editType", "cover");
        r102.put("editResult", r101);
        e(r102);
    }
}
