package com.ss.android.lark.coremdbiz.facade.link.parser;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import androidx.appcompat.content.res.AppCompatResources;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.coremd.base.parse.r;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkLinkThemeData;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import sz7.q;
import v7b.n;

/* JADX INFO: loaded from: classes35.dex */
public class BaseKeyIconStrategy implements b.a<dab.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<dab.b> f420081a;

    public BaseKeyIconStrategy() {
        this.f420081a = dab.b.class;
    }

    @Override // com.ss.android.lark.coremdbiz.facade.link.parser.b.a
    public Class<dab.b> getType() {
        return this.f420081a;
    }

    public static int b(final r r100, dab.b r101) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Intrinsics.checkNotNullParameter(r101, "info");
        LarkLinkThemeData r102 = (LarkLinkThemeData) LarkThemeExtend.f419998m.b(new BaseKeyIconStrategy$defaultGetColor$themeData$1(r100));
        int r103 = r102.j();
        if (r101.f467762e == true) goto L9;
        if (r103 == 0) goto L8;
        return r103;
    L8:
        return UIUtils.getColor(r100.getContext(), r102.h());
    L9:
        return r101.f467761d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.coremdbiz.facade.link.parser.b.a
    public final Spanned a(final r r110, dab.a r210) {
        dab.b r100 = (dab.b) r210;
        Intrinsics.checkNotNullParameter(r110, "visitContext");
        Intrinsics.checkNotNullParameter(r100, "info");
        LarkThemeExtend.a r101 = LarkThemeExtend.f419998m;
        final LarkLinkThemeData r102 = (LarkLinkThemeData) r101.b(new BaseKeyIconStrategy$onParse$1$themeData$1(r110));
        int r103 = ((Number) r101.b(new BaseKeyIconStrategy$onParse$1$iconSize$1(r110, r102))).intValue();
        if (r100.f467759b == 0) goto L5;
        Drawable r104 = AppCompatResources.getDrawable(r110.getContext(), r100.f467759b);
    L6:
        Drawable r105 = r104;
        q r111 = new q(r110.getContext(), false);
        int r106 = c(r110, r100);
        if (r105 == null) goto L10;
        r105.setTint(r106);
    L10:
        if (r100.f467758a.length() != 0) goto L12;
        boolean r107 = true;
    L13:
        if (r107 == false) goto L15;
        r111.b(r100.f467763f, r103, r103, r105, !r100.f467760c, Integer.valueOf(r106));
    L16:
        Context r108 = r110.getContext();
        com.ss.android.lark.coremd.ext.c r109 = r102.f420059j;
        KProperty<Object>[] r112 = LarkLinkThemeData.f420055n;
        int r113 = UIUtils.dp2px(r108, ((Number) r109.getValue(r102, r112[3])).floatValue());
        int r114 = UIUtils.dp2px(r110.getContext(), ((Number) r102.f420060k.getValue(r102, r112[4])).floatValue());
        Context r115 = r110.getContext();
        String r116 = ((n) r110.getNode()).f553561j;
        ncc.e.a r117 = new ncc.e.a(r116);
        r116.getClass();
        UIUtils.dp2px(r115, 3.0f);
        UIUtils.dp2px(r115, 3.0f);
        final ncc.e r118 = new ncc.e(r115, r117, "", null, r111, r103, r100.f467762e, r100.f467761d, r115.getResources().getColor(R.color.text_link_hover), r115.getResources().getColor(R.color.text_link_hover), r113, r114);
        SpannableStringBuilder r119 = new SpannableStringBuilder();
        r119.append("$");
        r119.setSpan(r118, 0, r119.length(), 33);
        r118.a(new cab.a(new BaseKeyIconStrategy$onParse$1$1(r110, r118)));
        return r119;
    L15:
        q.d(r111, r100.f467758a, null, r103, r103, r105, !r100.f467760c, Integer.valueOf(r106));
        goto L16
    L12:
        r107 = false;
        goto L13
    L5:
        r104 = null;
        goto L6
    }

    public int c(r<n> r100, dab.b r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "info");
        return b(r100, r101);
    }
}
