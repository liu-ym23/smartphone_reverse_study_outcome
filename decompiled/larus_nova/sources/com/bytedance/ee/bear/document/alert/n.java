package com.bytedance.ee.bear.document.alert;

import android.view.View;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class n implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UDCheckBox f218931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AlertModel.RadioOptions f218932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map<String, UDCheckBox> f218933c;

    public n(UDCheckBox r100, AlertModel.RadioOptions r101, Map<String, UDCheckBox> r102) {
        this.f218931a = r100;
        this.f218932b = r101;
        this.f218933c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        UDCheckBox r101 = this.f218931a;
        if (r101 != null) goto L5;
        return;
    L5:
        String r102 = this.f218932b.getId();
        if (r102 != null) goto L8;
        return;
    L8:
        r101.setChecked(true);
        Iterator<Map.Entry<String, UDCheckBox>> r103 = this.f218933c.entrySet().iterator();
    L10:
        if (r103.hasNext() == false) goto L14;
        Map.Entry<String, UDCheckBox> r104 = r103.next();
        String r105 = r104.getKey();
        UDCheckBox r106 = r104.getValue();
        if (Intrinsics.areEqual(r105, r102) == true) goto L10;
        r106.setChecked(false);
        goto L10
    }
}
