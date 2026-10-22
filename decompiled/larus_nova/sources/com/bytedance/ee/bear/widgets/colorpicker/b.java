package com.bytedance.ee.bear.widgets.colorpicker;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: classes18.dex */
public final class b extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f240187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ CommonColorSchemeView.SelectSpecificColorAdapter f240188d;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        CommonColorSchemeView.SelectSpecificColorAdapter r101 = this.f240188d;
        String[] r102 = r101.f240180a;
        String r103 = this.f240187c;
        r101.f240180a = r102;
        r101.f240181b = r103;
        r101.notifyDataSetChanged();
        CommonColorSchemeView.SelectSpecificColorAdapter.a r104 = this.f240188d.f240182c;
        if (r104 == null) goto L8;
        String r105 = this.f240187c;
        CommonColorSchemeView.a r106 = ((dp5.b) r104).f469605a.f240177d;
        if (r106 == null) goto L9;
        r106.G30(r105);
        return;
    L9:
        return;
    }

    public b(CommonColorSchemeView.SelectSpecificColorAdapter r100, String r101) {
        this.f240188d = r100;
        this.f240187c = r101;
    }
}
