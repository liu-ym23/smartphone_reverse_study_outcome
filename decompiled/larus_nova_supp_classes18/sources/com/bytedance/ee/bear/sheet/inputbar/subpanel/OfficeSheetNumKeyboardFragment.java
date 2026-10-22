package com.bytedance.ee.bear.sheet.inputbar.subpanel;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import cn5.h;
import cn5.i;
import cn5.j;
import cn5.k;
import cn5.l;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class OfficeSheetNumKeyboardFragment extends OfficeBaseSheetKeyboardFragment implements a.b {
    public static final /* synthetic */ int k = 0;
    public SheetNumKeyboardView f;
    public a g;
    public on5.a h;
    public boolean i;
    public h j;

    @Override // com.bytedance.ee.bear.sheet.inputbar.subpanel.a.b
    public final void KE() {
        this.i = true;
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.subpanel.OfficeBaseSheetKeyboardFragment
    public final int W90() {
        return 2131564569;
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.subpanel.a.b
    public final void Pl() {
        on5.a r0 = this.h;
        r0.getClass();
        HashMap r1 = new HashMap();
        r1.put("op_item", SheetInputData.InputData.FormatType.NUMBER);
        r0.c("click_keyboard_ratio", r1);
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.subpanel.a.b
    public final void UH() {
        on5.a r0 = this.h;
        r0.getClass();
        HashMap r1 = new HashMap();
        r1.put("op_item", SheetInputData.InputData.FormatType.NUMBER);
        r0.c("click_keyboard_slash", r1);
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.subpanel.a.b
    public final void cY() {
        on5.a r0 = this.h;
        r0.getClass();
        HashMap r1 = new HashMap();
        r1.put("op_item", SheetInputData.InputData.FormatType.NUMBER);
        r0.c("click_keyboard_plus_minus", r1);
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.subpanel.a.b
    public final void fE() {
        on5.a r0 = this.h;
        r0.getClass();
        HashMap r1 = new HashMap();
        r1.put("op_item", SheetInputData.InputData.FormatType.NUMBER);
        r0.c("click_keyboard_money", r1);
    }

    public OfficeSheetNumKeyboardFragment() {
        this.i = false;
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.subpanel.a.b
    public final void Iw() {
        final Editable r0 = (Editable) U90().getValue();
        if (V90() == true) goto L7;
        if (r0 == null) goto L8;
        X90(r0).subscribe(new l(this, r0));
        return;
    L8:
        return;
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        if (this.i == false) goto L5;
        this.h.e(SheetInputData.InputData.FormatType.NUMBER, V90());
    L5:
        U90().removeObserver(this.j);
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.subpanel.a.b
    public final void s90() {
        final Editable r0 = (Editable) U90().getValue();
        if (V90() == true) goto L7;
        if (r0 == null) goto L8;
        X90(r0).subscribe(new k(this, r0));
        return;
    L8:
        return;
    }

    public final String Z90(Editable r2) {
        String r3 = r2.toString();
        if (r3 == null) goto L9;
        if (r3.trim().startsWith("=") == false) goto L9;
        return "text";
    L9:
        return (String) this.e.getFormat().getValue();
    }

    public final void onConfigurationChanged(Configuration r2) {
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        tt5.a.h("SheetNumKeyboardFragment", "onConfigurationChanged");
        this.f.d();
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.subpanel.OfficeBaseSheetKeyboardFragment
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        this.h = new on5.a();
        DocViewModel r3 = q.a(this, DocViewModel.class);
        on5.a r0 = this.h;
        r0.a = r3.getBearUrl();
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [cn5.h] */
    public final void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        SheetNumKeyboardView r3 = (SheetNumKeyboardView) getView().findViewById(2131376845);
        this.f = r3;
        r3.setGray(V90());
        this.j = new h(this);
        U90().observe(this, this.j);
        this.e.isExpand().observe(this, new i(this));
        this.e.getFormat().observe(this, new j(this));
    }
}
