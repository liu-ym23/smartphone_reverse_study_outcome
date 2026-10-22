package com.ss.android.lark.coremdbiz.facade.link.parser;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.coremd.base.parse.r;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkLinkThemeData;
import com.ss.android.lark.utils.p;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import v7b.n;

/* JADX INFO: loaded from: classes35.dex */
public class BaseRichUrlIconStrategy implements b.a<dab.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<dab.c> f420082a;

    public BaseRichUrlIconStrategy() {
        this.f420082a = dab.c.class;
    }

    @Override // com.ss.android.lark.coremdbiz.facade.link.parser.b.a
    public Class<dab.c> getType() {
        return this.f420082a;
    }

    public static int b(final r r100, dab.c r101) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Intrinsics.checkNotNullParameter(r101, "info");
        LarkLinkThemeData r102 = (LarkLinkThemeData) LarkThemeExtend.f419998m.b(new BaseRichUrlIconStrategy$defaultGetColor$themeData$1(r100));
        int r103 = r102.j();
        if (r103 == 0) goto L6;
        return r103;
    L6:
        if (r101.f467767d == true) goto L12;
        if (r101.f467765b != 0) goto L12;
        return UIUtils.getColor(r100.getContext(), r102.h());
    L12:
        return r101.f467765b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.coremdbiz.facade.link.parser.b.a
    public final Spanned a(final r r210, dab.a r211) {
        dab.c r100 = (dab.c) r211;
        Intrinsics.checkNotNullParameter(r210, "visitContext");
        Intrinsics.checkNotNullParameter(r100, "info");
        LarkLinkThemeData r101 = (LarkLinkThemeData) LarkThemeExtend.f419998m.b(new BaseRichUrlIconStrategy$onParse$1$themeData$1(r210));
        boolean r102 = true;
        if (r100.f467766c.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        Bitmap r104 = p.c(r210.getContext(), r100.f467764a);
    L9:
        Paint r105 = new Paint();
        int r106 = c(r210, r100);
        if (r100.f467766c.length() == 0) goto L13;
        r102 = false;
    L13:
        if (r102 == false) goto L16;
        if (r106 == 0) goto L16;
        r105.setColorFilter(new PorterDuffColorFilter(r106, PorterDuff.Mode.SRC_IN));
    L16:
        if (r104 != null) goto L18;
        r104 = p.c(r210.getContext(), R.drawable.ud_icon_link_copy_outlined);
        r105.setColorFilter(new PorterDuffColorFilter(r106, PorterDuff.Mode.SRC_IN));
    L18:
        if (r104 == null) goto L20;
        Bitmap r107 = Bitmap.createBitmap(r104.getWidth(), r104.getHeight(), Bitmap.Config.ARGB_8888);
        new Canvas(r107).drawBitmap(r104, 0.0f, 0.0f, r105);
    L21:
        Context r108 = r210.getContext();
        com.ss.android.lark.coremd.ext.c r109 = r101.f420059j;
        KProperty<Object>[] r110 = LarkLinkThemeData.f420055n;
        int r212 = UIUtils.dp2px(r108, ((Number) r109.getValue(r101, r110[3])).floatValue());
        int r213 = UIUtils.dp2px(r210.getContext(), ((Number) r101.f420060k.getValue(r101, r110[4])).floatValue());
        int r111 = UIUtils.dp2px(r210.getContext(), r101.l());
        Context r112 = r210.getContext();
        String r113 = ((n) r210.getNode()).f553561j;
        ncc.e.a r114 = new ncc.e.a(r113);
        r113.getClass();
        UIUtils.dp2px(r112, 3.0f);
        UIUtils.dp2px(r112, 3.0f);
        int r115 = r112.getResources().getColor(R.color.text_link_hover);
        int r214 = r112.getResources().getColor(R.color.text_link_hover);
        if (r107 != null) goto L24;
        Bitmap r116 = r104;
    L25:
        final ncc.e r117 = new ncc.e(r112, r114, "", r116, null, r111, r100.f467767d, r100.f467765b, r115, r214, r212, r213);
        SpannableStringBuilder r118 = new SpannableStringBuilder();
        r118.append("$");
        r118.setSpan(r117, 0, r118.length(), 33);
        r117.a(new cab.a(new BaseRichUrlIconStrategy$onParse$1$1(r210, r117)));
        return r118;
    L24:
        r116 = r107;
        goto L25
    L20:
        r107 = null;
        goto L21
    L8:
        Integer[] r119 = sbb.d.f541292a;
        r104 = sbb.d.a(r100.f467766c);
        goto L9
    L5:
        r103 = false;
        goto L6
    }

    public int c(r<n> r100, dab.c r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "info");
        return b(r100, r101);
    }
}
