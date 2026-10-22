package com.ss.android.lark.keyboard.edittext2.mdeditor.link;

import android.content.Context;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkLinkExtend;
import com.ss.android.lark.keyboard.dtocompat.UrlInlinePreviewEntity;
import com.ss.android.lark.keyboard.edittext2.utils.d;
import com.ss.android.lark.utils.statistics.PerfLog;
import dab.c;
import kotlin.jvm.internal.Intrinsics;
import v7b.n;

/* JADX INFO: loaded from: classes36.dex */
public final class PreviewEntityLinkParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f429190a = 0;

    static {
    }

    public static n a(Context r110, final UrlInlinePreviewEntity r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "entity");
        final n r100 = new n();
        int r101 = UIUtils.getColor(r110, R.color.text_link_normal);
        String r112 = r111.f428714g;
        boolean r102 = true;
        if (r112 != null) goto L5;
    L8:
        boolean r113 = true;
    L10:
        if (r113 == false) goto L12;
    L14:
        String r103 = "";
        if (r111.f428715h != 0) goto L17;
    L23:
        String r114 = r111.f428717j;
        if (r114 != null) goto L26;
    L29:
        boolean r115 = true;
    L30:
        if (r115 == false) goto L32;
    L34:
        String r116 = r111.f428718k;
        if (r116 != null) goto L37;
    L40:
        boolean r117 = true;
    L41:
        if (r117 == false) goto L43;
    L45:
        String r118 = r111.f428713f;
        if (r118 != null) goto L48;
    L51:
        if (r102 == true) goto L57;
        String r104 = r111.f428713f;
        if (r104 == null) goto L56;
        r103 = r104;
    L56:
        final dab.a r119 = new c(R.drawable.ud_icon_link_copy_filled, r101, r103, false);
    L65:
        LarkLinkExtend.f420024f.b(new PreviewEntityLinkParser$parse$1(r100, r111, r119));
        return r100;
    L57:
        int r120 = r111.f428711d;
        if (r120 == 0) goto L64;
        int r105 = r111.f428712e;
        if (r105 == 0) goto L63;
        r101 = r105;
    L63:
        r119 = new c(r120, r101, "", false);
        goto L65
    L64:
        r119 = new dab.b(r111.f428710c, R.drawable.ud_icon_link_copy_filled, true, r101, false, "");
        goto L65
    L48:
        if (r118.length() == 0) goto L51;
        r102 = false;
        goto L51
    L43:
        if (r111.f428720m == false) goto L45;
        r119 = new dab.b("", R.drawable.ud_icon_link_copy_filled, true, r111.f428719l, true, r111.f428718k);
        goto L65
    L37:
        if (r116.length() == 0) goto L40;
        r117 = false;
        goto L41
    L32:
        if (r111.f428720m == false) goto L34;
        r119 = new dab.b(r111.f428717j, R.drawable.ud_icon_link_copy_filled, true, r111.f428719l, true, "");
        goto L65
    L26:
        if (r114.length() == 0) goto L29;
        r115 = false;
        goto L30
    L17:
        if (r111.f428720m == false) goto L23;
        if ((!d.a("messenger.im.disable_doubao_url_inline_icon_fix")) == false) goto L21;
        int r106 = r111.f428715h;
    L22:
        r119 = new c(r106, r111.f428716i, "", true);
        goto L65
    L21:
        r106 = r111.f428711d;
        goto L22
    L12:
        if (r111.f428720m == false) goto L14;
        r119 = new c(R.drawable.ud_icon_link_copy_filled, r101, r111.f428714g, true);
        goto L65
    L5:
        if (r112.length() == 0) goto L8;
        r113 = false;
        goto L10
    }
}
