package com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline;

import android.webkit.URLUtil;
import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichTextElement;
import hob.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public class a extends fob.a<j> {
    @Override // fob.a
    public final boolean a(RichTextElement.AnchorProperty r100) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        return true;
    }

    public a(eob.a r100) {
        Intrinsics.checkNotNullParameter(r100, "editor");
        super(r100);
    }

    @Override // fob.a
    public /* bridge */ /* synthetic */ hob.b b(RichTextElement.AnchorProperty r100) {
        return c(r100);
    }

    public j c(RichTextElement.AnchorProperty r110) {
        Intrinsics.checkNotNullParameter(r110, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        int r100 = com.ss.android.lark.keyboard.edittext2.utils.a.f429248a;
        Intrinsics.checkNotNullParameter(r110, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        String r101 = r110.getContent();
        String r102 = r110.getHref();
        if (URLUtil.isNetworkUrl(r101) == false) goto L10;
        Intrinsics.checkNotNull(r102);
        if (com.ss.android.lark.keyboard.edittext2.utils.a.a(r102) == true) goto L9;
        r101 = r102;
    L9:
        r102 = r101;
    L10:
        String r103 = "";
        if (r102 != null) goto L13;
        r102 = "";
    L13:
        j r104 = new j(r102);
        String r105 = r110.getDisplayTitle();
        if (r105 != null) goto L16;
        r105 = "";
    L16:
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r104.f486340e = r105;
        String r106 = r110.getIconKey();
        int r107 = r110.getLocalIconRes();
        String r108 = r110.getDisplayTitle();
        String r109 = r110.getUnicode();
        int r111 = r110.getIconColor();
        boolean r112 = r110.isColorIcon();
        String r113 = r110.getFaviconUrl();
        Intrinsics.checkNotNullParameter(r110, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        String r114 = r110.getIconKey();
        int r115 = r110.getLocalIconRes();
        String r116 = r110.getDisplayTitle();
        String r117 = r110.getUnicode();
        String r118 = r110.getFaviconUrl();
        if (r116 != null) goto L19;
    L22:
        boolean r119 = true;
    L23:
        boolean r120 = true;
        boolean r121 = !r119;
        if (r114 != null) goto L26;
    L29:
        boolean r122 = true;
    L30:
        if (r122 == false) goto L48;
        if (r115 != 0) goto L48;
        if (r117 != null) goto L34;
    L37:
        boolean r123 = true;
    L38:
        if (r123 == false) goto L48;
        if (r118 != null) goto L41;
    L44:
        boolean r124 = true;
    L45:
        if (r124 == false) goto L48;
        boolean r125 = false;
    L50:
        if (r121 == false) goto L52;
        if (r125 == false) goto L52;
    L53:
        if (r120 == true) goto L55;
        Log.i("IMAnchorCoordinator", "appendAnchorDataIfNeed: data is not enough to create anchor span , parse from net is true.");
    L62:
        return r104;
    L55:
        if (r107 == 0) goto L57;
        r104.f486341f.f486343a = r107;
    L57:
        j.a r126 = r104.f486341f;
        if (r106 == null) goto L61;
        r103 = r106;
    L61:
        r126.getClass();
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r126.f486344b = r103;
        j.a r127 = r104.f486341f;
        r127.f486345c = r109;
        r127.f486348f = r111;
        r127.f486346d = r113;
        r127.f486347e = r112;
        Intrinsics.checkNotNull(r108);
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r104.f486340e = r108;
        r104.f486339d = false;
    L52:
        Log.i("IMAnchorCoordinator", "appendAnchorDataIfNeed: data is not enough to create anchor span , parse from net is true.");
        r120 = false;
        goto L53
    L41:
        if (r118.length() == 0) goto L44;
        r124 = false;
        goto L45
    L34:
        if (r117.length() == 0) goto L37;
        r123 = false;
    L48:
        r125 = true;
        goto L50
    L26:
        if (r114.length() == 0) goto L29;
        r122 = false;
        goto L30
    L19:
        if (r116.length() == 0) goto L22;
        r119 = false;
        goto L23
    }
}
