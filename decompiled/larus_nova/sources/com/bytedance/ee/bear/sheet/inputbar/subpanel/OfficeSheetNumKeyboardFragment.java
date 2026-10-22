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
import com.huawei.hms.framework.common.ContainerUtils;
import com.larus.nova.R;
import java.util.HashMap;

/* JADX INFO: loaded from: classes18.dex */
public class OfficeSheetNumKeyboardFragment extends OfficeBaseSheetKeyboardFragment implements a.b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f238050k = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SheetNumKeyboardView f238051f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f238052g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public on5.a f238053h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f238054i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public h f238055j;

    @Override // com.bytedance.ee.bear.sheet.inputbar.subpanel.a.b
    public final void KE() {
        this.f238054i = true;
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.subpanel.OfficeBaseSheetKeyboardFragment
    public final int W90() {
        return R.layout.sheet_num_keyboard_fragment;
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.subpanel.a.b
    public final void Pl() {
        on5.a r100 = this.f238053h;
        r100.getClass();
        HashMap r101 = new HashMap();
        r101.put("op_item", "number");
        r100.c("click_keyboard_ratio", r101);
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.subpanel.a.b
    public final void UH() {
        on5.a r100 = this.f238053h;
        r100.getClass();
        HashMap r101 = new HashMap();
        r101.put("op_item", "number");
        r100.c("click_keyboard_slash", r101);
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.subpanel.a.b
    public final void cY() {
        on5.a r100 = this.f238053h;
        r100.getClass();
        HashMap r101 = new HashMap();
        r101.put("op_item", "number");
        r100.c("click_keyboard_plus_minus", r101);
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.subpanel.a.b
    public final void fE() {
        on5.a r100 = this.f238053h;
        r100.getClass();
        HashMap r101 = new HashMap();
        r101.put("op_item", "number");
        r100.c("click_keyboard_money", r101);
    }

    public OfficeSheetNumKeyboardFragment() {
        this.f238054i = false;
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.subpanel.a.b
    public final void Iw() {
        final Editable r100 = U90().getValue();
        if (V90() == true) goto L7;
        if (r100 == null) goto L8;
        X90(r100).subscribe(new l(this, r100));
        return;
    L8:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        if (this.f238054i == false) goto L5;
        this.f238053h.e("number", V90());
    L5:
        U90().removeObserver(this.f238055j);
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.subpanel.a.b
    public final void s90() {
        final Editable r100 = U90().getValue();
        if (V90() == true) goto L7;
        if (r100 == null) goto L8;
        X90(r100).subscribe(new k(this, r100));
        return;
    L8:
        return;
    }

    public final String Z90(Editable r100) {
        String r101 = r100.toString();
        if (r101 == null) goto L9;
        if (r101.trim().startsWith(ContainerUtils.KEY_VALUE_DELIMITER) == false) goto L9;
        return "text";
    L9:
        return this.f238035e.getFormat().getValue();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        tt5.a.h("SheetNumKeyboardFragment", "onConfigurationChanged");
        this.f238051f.d();
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.subpanel.OfficeBaseSheetKeyboardFragment, com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f238053h = new on5.a();
        DocViewModel r101 = (DocViewModel) q.a(this, DocViewModel.class);
        on5.a r102 = this.f238053h;
        r102.f524353a = r101.getBearUrl();
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [cn5.h] */
    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        SheetNumKeyboardView r102 = (SheetNumKeyboardView) getView().findViewById(R.id.keyboard_view);
        this.f238051f = r102;
        r102.setGray(V90());
        this.f238055j = new h(this);
        U90().observe(this, this.f238055j);
        this.f238035e.isExpand().observe(this, new i(this));
        this.f238035e.getFormat().observe(this, new j(this));
    }
}
