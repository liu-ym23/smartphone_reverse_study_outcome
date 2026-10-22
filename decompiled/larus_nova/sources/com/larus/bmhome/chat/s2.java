package com.larus.bmhome.chat;

import android.net.Uri;
import com.larus.im.bean.conversation.IconImage;
import com.larus.im.bean.message.ImageObj;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class s2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f308566a = 0;

    static {
    }

    public static boolean a(IconImage r100, IconImage r101) {
        if (r100 != null) goto L6;
        if (r101 != null) goto L6;
        return true;
    L6:
        if (r100 == null) goto L58;
        if (r101 == null) goto L60;
        ImageObj r102 = r100.imageThumb;
        String r103 = null;
        if (r102 == null) goto L12;
        String r104 = r102.url;
    L13:
        ImageObj r105 = r101.imageThumb;
        if (r105 == null) goto L16;
        String r106 = r105.url;
    L18:
        if (com.larus.utils.o0.d(r106) == false) goto L20;
    L47:
        if (r106 == null) goto L51;
        Uri r107 = com.larus.utils.y0.j(r106);
        if (r107 == null) goto L51;
        String r108 = r107.getPath();
    L52:
        if (r104 == null) goto L57;
        Uri r109 = com.larus.utils.y0.j(r104);
        if (r109 == null) goto L57;
        r103 = r109.getPath();
    L57:
        return Intrinsics.areEqual(r108, r103);
    L51:
        r108 = null;
        goto L52
    L20:
        if (com.larus.utils.o0.d(r104) == true) goto L47;
        ImageObj r110 = r101.imageOri;
        if (r110 == null) goto L25;
        String r111 = r110.url;
    L26:
        ImageObj r112 = r100.imageOri;
        if (r112 == null) goto L29;
        String r113 = r112.url;
    L31:
        if (com.larus.utils.o0.d(r111) == false) goto L33;
    L36:
        if (r111 == null) goto L40;
        Uri r114 = com.larus.utils.y0.j(r111);
        if (r114 == null) goto L40;
        String r115 = r114.getPath();
    L41:
        if (r113 == null) goto L46;
        Uri r116 = com.larus.utils.y0.j(r113);
        if (r116 == null) goto L46;
        r103 = r116.getPath();
    L46:
        return Intrinsics.areEqual(r115, r103);
    L40:
        r115 = null;
        goto L41
    L33:
        if (com.larus.utils.o0.d(r113) == true) goto L36;
        return true;
    L29:
        r113 = null;
        goto L31
    L25:
        r111 = null;
        goto L26
    L16:
        r106 = null;
        goto L18
    L12:
        r104 = null;
        goto L13
    L60:
        return false;
    L58:
        return false;
    }
}
