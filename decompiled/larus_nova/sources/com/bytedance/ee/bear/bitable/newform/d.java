package com.bytedance.ee.bear.bitable.newform;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.card.view.cell.select.t;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements t.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f214767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NewLarkFormPlugin.ColorPanelRequest f214768b;

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.t.a
    public final /* synthetic */ void a(String r100) {
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.t.a
    public final com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "optionContent");
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.t.a
    public final void d(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "optionContent");
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.t.a
    public final void c(int r100) {
        m r101 = this.f214767a;
        JSONObject r102 = new JSONObject();
        NewLarkFormPlugin.ColorPanelRequest r103 = this.f214768b;
        r102.put2("optionID", r103.getOptionID());
        r102.put2("color", r103.getColors()[r100]);
        r101.b(r102);
    }

    public d(m r100, NewLarkFormPlugin.ColorPanelRequest r101) {
        this.f214767a = r100;
        this.f214768b = r101;
    }
}
