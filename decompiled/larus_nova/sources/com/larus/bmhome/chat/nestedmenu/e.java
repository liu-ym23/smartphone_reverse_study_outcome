package com.larus.bmhome.chat.nestedmenu;

import android.view.View;
import com.larus.bmhome.view.screenmenu.MenuItemType;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.nova.R;
import di8.b0;
import di8.d0;
import di8.e0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class e {
    /* JADX WARN: Multi-variable type inference failed */
    public static final l0 a(d0 r410) {
        Intrinsics.checkNotNullParameter(r410, "<this>");
        b0 r100 = r410.getCenter();
        NestedMenuRightModel r101 = r410.getRight();
        String r102 = r100.f468753a;
        if (r102 != null) goto L5;
        r102 = r101.f308220c;
    L5:
        String r103 = r102;
        if (r103 == null) goto L9;
    L11:
        Boolean r104 = r100.f468763k;
        Boolean r105 = Boolean.TRUE;
        if (Intrinsics.areEqual(r104, r105) == false) goto L16;
        String r106 = r100.f468764l;
        if (r106 != null) goto L17;
        r106 = r100.f468761i;
    L17:
        String r210 = r106;
        if (Intrinsics.areEqual(r100.f468763k, r105) == false) goto L20;
        String r107 = r100.f468766n;
    L21:
        String r211 = r107;
        CharSequence r108 = r100.f468754b;
        boolean r110 = r410.a();
        String r109 = r100.f468755c;
        Integer r111 = r100.f468756d;
        Integer r112 = r100.f468767o;
        Integer r113 = r410.getLeft().f468782a;
        String r114 = r410.getLeft().f468783b;
        boolean r115 = r101.f308218a;
        Integer r116 = r101.f308222e;
        if (r116 != null) goto L26;
        if (r115 == false) goto L27;
        r116 = Integer.valueOf(v19.c.b(R.attr.larus_ic_check_mark_black, null, R.drawable.larus_ic_check_mark_black));
        goto L26
    L27:
        Integer r117 = null;
    L28:
        String r118 = r101.f308223f;
        boolean r119 = r410.getEnabled();
        Float r212 = r410.getAlpha();
        String r120 = r100.f468757e;
        String r121 = r100.f468759g;
        if (r410.isHeader() == false) goto L32;
        MenuItemType r213 = MenuItemType.HEADER;
    L36:
        final Function0<View> r122 = r410.getLeft().f468787f;
        if (r122 == null) goto L39;
        e0 r310 = new e0(r122);
    L41:
        return new l0(0, 0, r103, r108, r109, r111, null, r113, r114, r115, r110, null, r117, r118, r119, false, null, null, null, r120, r210, r211, r121, r212, r213, null, null, null, null, r310, r101.f308220c, r101.f308221d, null, r112, r101.f308224g, null, null, false, 537872450, 114);
    L39:
        r310 = 0;
        goto L41
    L32:
        if (r101.f308219b != NestedMenuRightModel.Style.BUTTON) goto L34;
        MenuItemType r123 = MenuItemType.BUTTON;
    L35:
        r213 = r123;
        goto L36
    L34:
        r123 = MenuItemType.DEFAULT;
    L26:
        r117 = r116;
        goto L28
    L20:
        r107 = r100.f468762j;
        goto L21
    L16:
        r106 = r100.f468761i;
        goto L17
    L9:
        if (r100.f468754b != null) goto L11;
        return null;
    }
}
