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
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.p;
import kotlin.jvm.internal.Intrinsics;
import v7b.n;

/* JADX INFO: loaded from: classes35.dex */
public class BaseUniversalCardIconStrategy implements b.a<dab.d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<dab.d> f420083a;

    public BaseUniversalCardIconStrategy() {
        this.f420083a = dab.d.class;
    }

    @Override // com.ss.android.lark.coremdbiz.facade.link.parser.b.a
    public Class<dab.d> getType() {
        return this.f420083a;
    }

    public static int b(final r r100, dab.d r101) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Intrinsics.checkNotNullParameter(r101, "info");
        LarkLinkThemeData r102 = (LarkLinkThemeData) LarkThemeExtend.f419998m.b(new BaseUniversalCardIconStrategy$defaultGetColor$themeData$1(r100));
        int r103 = r102.j();
        if (r103 == 0) goto L6;
        return r103;
    L6:
        return UIUtils.getColor(r100.getContext(), r102.h());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.coremdbiz.facade.link.parser.b.a
    public final Spanned a(r r110, dab.a r210) {
        dab.d r100 = (dab.d) r210;
        Intrinsics.checkNotNullParameter(r110, "visitContext");
        Intrinsics.checkNotNullParameter(r100, "info");
        Paint r101 = new Paint();
        int r102 = c(r110, r100);
        r101.setColorFilter(new PorterDuffColorFilter(r102, PorterDuff.Mode.SRC_IN));
        Bitmap r103 = p.c(r110.getContext(), R.drawable.ud_icon_link_copy_outlined);
        r101.setColorFilter(new PorterDuffColorFilter(r102, PorterDuff.Mode.SRC_IN));
        if (r103 == null) goto L5;
        Bitmap r104 = Bitmap.createBitmap(r103.getWidth(), r103.getHeight(), Bitmap.Config.ARGB_8888);
        new Canvas(r104).drawBitmap(r103, 0.0f, 0.0f, r101);
    L6:
        int r111 = (int) UIHelper.sp2px(14.0f);
        Context r105 = r110.getContext();
        String r106 = ((n) r110.getNode()).f553561j;
        ncc.e.a r107 = new ncc.e.a(r106);
        r106.getClass();
        int r112 = UIUtils.dp2px(r105, 3.0f);
        int r113 = UIUtils.dp2px(r105, 3.0f);
        int r114 = r105.getResources().getColor(R.color.text_link_hover);
        int r115 = r105.getResources().getColor(R.color.text_link_hover);
        if (r104 != null) goto L9;
        Bitmap r108 = r103;
    L10:
        ncc.e r109 = new ncc.e(r105, r107, "", r108, null, r111, false, 0, r114, r115, r112, r113);
        SpannableStringBuilder r116 = new SpannableStringBuilder();
        r116.append("$");
        r116.setSpan(r109, 0, r116.length(), 33);
        return r116;
    L9:
        r108 = r104;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    public int c(r<n> r100, dab.d r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "info");
        return b(r100, r101);
    }
}
