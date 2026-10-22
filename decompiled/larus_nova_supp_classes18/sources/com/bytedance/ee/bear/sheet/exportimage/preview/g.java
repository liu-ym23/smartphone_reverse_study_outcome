package com.bytedance.ee.bear.sheet.exportimage.preview;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.bizwidget.shareview.ExternalShareView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g<T> implements Observer {
    public final /* synthetic */ SheetImagePreviewFragment a;

    public g(SheetImagePreviewFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        ShareOperationTypeModel r6 = (ShareOperationTypeModel) r5;
        if (r6 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r6.toString()) == true) goto L40;
        SheetImagePreviewFragment r0 = this.a;
        String r1 = r6.getType();
        if (r1 == null) goto L13;
        boolean r3 = true;
        if (r1.equals("text") != true) goto L13;
    L14:
        r0.o = r3;
        SheetImagePreviewFragment r2 = this.a;
        if (r2.o == false) goto L28;
        String r7 = r6.getData();
        if (r7 != null) goto L19;
        r7 = "";
    L19:
        r2.p = r7;
        SheetImagePreviewFragment r8 = this.a;
        View r4 = r8.l;
        if (r4 == null) goto L22;
        r4.setVisibility(0);
    L22:
        TextView r9 = r8.m;
        if (r9 == null) goto L25;
        r9.setText(r8.p);
    L25:
        SheetImagePreviewFragment r10 = this.a;
        View r11 = r10.l;
        if (r11 == null) goto L31;
        r11.post(new f(r10));
    L31:
        SheetImagePreviewFragment r12 = this.a;
        ExternalShareView r13 = r12.h;
        if (r13 == null) goto L34;
        r13.b(((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).getProvider().a(r12.U90()));
    L34:
        ExternalShareView r14 = r12.h;
        if (r14 == null) goto L38;
        r14.setOnShareItemClickListener(new j(r12));
        return;
    L38:
        return;
    L28:
        View r15 = r2.l;
        if (r15 == null) goto L31;
        r15.setVisibility(8);
    L13:
        r3 = false;
        goto L14
    }
}
