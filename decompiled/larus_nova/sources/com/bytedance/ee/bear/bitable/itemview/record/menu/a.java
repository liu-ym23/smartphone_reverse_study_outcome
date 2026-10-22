package com.bytedance.ee.bear.bitable.itemview.record.menu;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.bear.bitable.uikit.ReportActionPayload;
import com.larus.nova.R;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.maintab.export.TabAppType;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f214154a;

    public a(b r100) {
        this.f214154a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        final b r111 = this.f214154a;
        if (r111.f214160e == false) goto L9;
        String r100 = r111.a();
        if (r100 == null) goto L18;
        vqb.a r101 = vqb.b.a();
        if (r101 == null) goto L18;
        r101.deleteFavoriteTab(r100, TabAppInfo.BizType.CCM, new Navigation$removeFromNavigation$1$1(r111));
    L18:
        gv4.a r112 = this.f214154a.f214159d;
        if (r112 == null) goto L26;
        ReportActionPayload r102 = new ReportActionPayload("ItemViewClickAddToMainNav");
        if (this.f214154a.f214160e == false) goto L23;
        String r103 = "remove";
    L24:
        r102.put("type", r103);
        r112.a(r102);
        return;
    L23:
        r103 = "add";
        goto L24
    L26:
        return;
    L9:
        String r113 = r111.a();
        if (r113 == null) goto L18;
        if (TextUtils.isEmpty(r111.f214158c) == true) goto L14;
        String r104 = r111.f214158c;
    L15:
        String r105 = UIHelper.mustacheFormat(R.string.Bitable_QuickAdd_AddRecordToTable_Desc, "baseName", r104);
        TabAppInfo.BizType r106 = TabAppInfo.BizType.CCM;
        TabAppType r107 = TabAppType.APP_TYPE_URL;
        Intrinsics.checkNotNull(r105);
        com.ss.android.lark.maintab.export.a r108 = new com.ss.android.lark.maintab.export.a(r113, r106, r107, r105, TabAppInfo.CustomNavigationAppLogoType.APP_LOGO_TYPE_UD_TOKEN, "icon_bitable-add_colorful", r113, "");
        vqb.a r109 = vqb.b.a();
        if (r109 == null) goto L18;
        r109.addFavoriteTab(r108, new Navigation$addToNavigation$1$1(r111), false);
        goto L18
    L14:
        r104 = r111.f214156a.getString(R.string.Doc_Facade_UntitledBitable);
        goto L15
    }
}
