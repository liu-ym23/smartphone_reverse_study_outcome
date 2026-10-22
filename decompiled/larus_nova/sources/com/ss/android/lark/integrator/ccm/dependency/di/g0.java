package com.ss.android.lark.integrator.ccm.dependency.di;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.maincore.TabType;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.maintab.export.TabAppType;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import java.util.Iterator;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class g0 implements com.bytedance.ee.bear.lark.dependency.s {
    public g0() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.s
    public final void isEnableWikiTab() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.s
    public final boolean enableFgMainTabContainer() {
        vqb.a r100 = (vqb.a) ApiUtils.getApi(vqb.a.class);
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.enableFgMainTabContainer();
    }

    @Override // com.bytedance.ee.bear.lark.dependency.s
    public final TabType getTabType() {
        return ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).getTabType();
    }

    @Override // com.bytedance.ee.bear.lark.dependency.s
    public final void a(Context r100) {
        ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).P0();
    }

    @Override // com.bytedance.ee.bear.lark.dependency.s
    public final void b(wb5.d r110) {
        if (enableFgMainTabContainer() == true) goto L5;
        return;
    L5:
        vqb.a r100 = (vqb.a) ApiUtils.getApi(vqb.a.class);
        if (r100 == null) goto L20;
        if (r110 == null) goto L21;
        String r101 = c(r110.getType(), r110.f559000f);
        if (r101.equals("icon_file-unknow_colorful") == true) goto L18;
    L16:
        String r102 = r110.f558996b;
        TabAppInfo.BizType r103 = TabAppInfo.BizType.CCM;
        TabAppType r104 = TabAppType.APP_TYPE_URL;
        String r105 = r110.f558997c;
        TabAppInfo.CustomNavigationAppLogoType r106 = TabAppInfo.CustomNavigationAppLogoType.APP_LOGO_TYPE_UD_TOKEN;
        com.ss.android.lark.maintab.export.a r107 = new com.ss.android.lark.maintab.export.a(r102, r103, r104, r105, r106, r101, r110.f558998d, "");
        r107.f431617i = Integer.toString(r110.getType());
        r100.addVisitRecord(r107);
        return;
    L18:
        int r108 = CastIntegerProtector.parseInt(r110.f559000f);     // Catch: Throwable -> L13
    L15:
        r101 = c(r108, r110.f559000f);
    L13:
        th = move-exception;
        Log.e("SafeParseUtils", th.getMessage());
        r108 = -1;
        goto L15
    L21:
        return;
    }

    public static String c(int r100, String r101) {
        int r102 = lmb.a.f509904a;
        Intrinsics.checkNotNullParameter(r101, "subType");
        if (r100 != sbb.e.f541296g.f541317b) goto L6;
        return "icon_file-doc_colorful";
    L6:
        if (r100 != sbb.e.f541297h.f541317b) goto L9;
        return "icon_file-sheet_colorful";
    L9:
        if (r100 != sbb.e.f541298i.f541317b) goto L12;
        return "icon_file-bitable_colorful";
    L12:
        if (r100 != sbb.e.f541300k.f541317b) goto L15;
        return "icon_file-mindnote_colorful";
    L15:
        if (r100 != sbb.e.f541302m.f541317b) goto L18;
        return "icon_wiki-slides_colorful";
    L18:
        if (r100 != sbb.e.f541304o.f541317b) goto L21;
        return "icon_file-docx_colorful";
    L21:
        if (r100 == sbb.e.f541301l.f541317b) goto L23;
    L130:
        return "icon_file-unknow_colorful";
    L23:
        if (TextUtils.isEmpty(r101) == true) goto L130;
        String r103 = r101.toLowerCase();
        Iterator r104 = ArrayIteratorKt.iterator(rbb.e.f537005a);
    L27:
        if (r104.hasNext() == false) goto L31;
        if (TextUtils.equals((String) r104.next(), r103) == false) goto L27;
        return "icon_file-image_colorful";
    L31:
        Iterator r105 = ArrayIteratorKt.iterator(rbb.e.f537006b);
    L33:
        if (r105.hasNext() == false) goto L37;
        if (TextUtils.equals((String) r105.next(), r103) == false) goto L33;
        return "icon_file-video_colorful";
    L37:
        Iterator r106 = ArrayIteratorKt.iterator(rbb.e.f537007c);
    L39:
        if (r106.hasNext() == false) goto L44;
        if (TextUtils.equals((String) r106.next(), r103) == false) goto L39;
        return "icon_file-audio_colorful";
    L44:
        if (TextUtils.equals(ExportFileExtension.PDF, r103) == false) goto L46;
        return "icon_file-pdf_colorful";
    L46:
        Iterator r107 = ArrayIteratorKt.iterator(rbb.e.f537008d);
    L48:
        if (r107.hasNext() == false) goto L52;
        if (TextUtils.equals((String) r107.next(), r103) == false) goto L48;
        return "icon_file-text_colorful";
    L52:
        Iterator r108 = ArrayIteratorKt.iterator(rbb.e.f537009e);
    L54:
        if (r108.hasNext() == false) goto L58;
        if (TextUtils.equals((String) r108.next(), r103) == false) goto L54;
        return "icon_file-code_colorful";
    L58:
        Iterator r109 = ArrayIteratorKt.iterator(rbb.e.f537010f);
    L60:
        if (r109.hasNext() == false) goto L64;
        if (TextUtils.equals((String) r109.next(), r103) == false) goto L60;
        return "icon_file-word_colorful";
    L64:
        Iterator r110 = ArrayIteratorKt.iterator(rbb.e.f537011g);
    L66:
        if (r110.hasNext() == false) goto L70;
        if (TextUtils.equals((String) r110.next(), r103) == false) goto L66;
        return "icon_file-excel_colorful";
    L70:
        Iterator r111 = ArrayIteratorKt.iterator(rbb.e.f537012h);
    L72:
        if (r111.hasNext() == false) goto L77;
        if (TextUtils.equals((String) r111.next(), r103) == false) goto L72;
        return "icon_file-ppt_colorful";
    L77:
        if (TextUtils.equals("pages", r103) == false) goto L80;
        return "icon_file-pages_colorful";
    L80:
        if (TextUtils.equals("numbers", r103) == false) goto L82;
        return "icon_file-numbers_colorful";
    L82:
        Iterator r112 = ArrayIteratorKt.iterator(rbb.e.f537013i);
    L84:
        if (r112.hasNext() == false) goto L88;
        if (TextUtils.equals((String) r112.next(), r103) == false) goto L84;
        return "icon_file-keynote_colorful";
    L88:
        Iterator r113 = ArrayIteratorKt.iterator(rbb.e.f537014j);
    L90:
        if (r113.hasNext() == false) goto L94;
        if (TextUtils.equals((String) r113.next(), r103) == false) goto L90;
        return "icon_file-zip_colorful";
    L94:
        Iterator r114 = ArrayIteratorKt.iterator(rbb.e.f537015k);
    L96:
        if (r114.hasNext() == false) goto L100;
        if (TextUtils.equals((String) r114.next(), r103) == false) goto L96;
        return "icon_file-md_colorful";
    L100:
        Iterator r115 = ArrayIteratorKt.iterator(rbb.e.f537016l);
    L102:
        if (r115.hasNext() == false) goto L107;
        if (TextUtils.equals((String) r115.next(), r103) == false) goto L102;
        return "icon_file-ps_colorful";
    L107:
        if (TextUtils.equals("ipa", r103) == false) goto L110;
        return "icon_file-ios_colorful";
    L110:
        if (TextUtils.equals("apk", r103) == false) goto L113;
        return "icon_file-android_colorful";
    L113:
        if (TextUtils.equals("aep", r103) == false) goto L116;
        return "icon_file-ae_colorful";
    L116:
        if (TextUtils.equals("ai", r103) == false) goto L119;
        return "icon_file-ai_colorful";
    L119:
        if (TextUtils.equals("sketch", r103) == false) goto L122;
        return "icon_file-sketch_colorful";
    L122:
        if (TextUtils.equals("csv", r103) == false) goto L125;
        return "icon_file-csv_colorful";
    L125:
        if (TextUtils.equals("eml", r103) == false) goto L128;
        return "icon_file-eml_colorful";
    L128:
        if (TextUtils.equals("msg", r103) == false) goto L130;
        return "icon_file-msg_colorful";
    }

    @Override // com.bytedance.ee.bear.lark.dependency.s
    public final void launchMainWindow(Context r100, String r101, Bundle r102) {
        ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).T0();
    }
}
