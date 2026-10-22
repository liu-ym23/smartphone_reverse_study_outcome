package com.bytedance.ee.bear.document.alert;

import android.content.DialogInterface;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public final class g0 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map<String, UDCheckBox> f218913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r f218914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AlertModel.ButtonsBean f218915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ tb5.m f218916d;

    public g0(Map<String, UDCheckBox> r100, r r101, AlertModel.ButtonsBean r102, tb5.m r103) {
        this.f218913a = r100;
        this.f218914b = r101;
        this.f218915c = r102;
        this.f218916d = r103;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r110, int r111) {
        Map<String, UDCheckBox> r112 = this.f218913a;
        AlertModel.ButtonsBean r113 = this.f218915c;
        Iterator<Map.Entry<String, UDCheckBox>> r114 = r112.entrySet().iterator();
        String r100 = null;
    L4:
        if (r114.hasNext() == false) goto L8;
        Map.Entry<String, UDCheckBox> r101 = r114.next();
        String r102 = r101.getKey();
        if (r101.getValue().isChecked() == false) goto L4;
        tt5.a.h("OopsPopWindow", "showRadioDialog() ,click btn.id = " + r113.getId() + ",selectedOptionId: " + r102);
        r100 = r102;
        goto L4
    L8:
        r.c(this.f218914b, this.f218915c.getId(), null, this.f218916d, this.f218915c.isAutoDismiss(), null, r100, 16);
    }
}
