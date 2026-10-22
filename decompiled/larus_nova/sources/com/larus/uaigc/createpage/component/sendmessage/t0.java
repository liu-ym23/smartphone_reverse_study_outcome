package com.larus.uaigc.createpage.component.sendmessage;

import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f372425a = 0;

    static {
    }

    public static boolean a(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (StringsKt.startsWith$default(r100, "content://", false, 2, null) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean b(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (StringsKt.startsWith$default(r100, MSkiaImageRegionDecoder.FILE_PREFIX, false, 2, null) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public static s0 d(String r100, String r101) {
        if (a(r100) == false) goto L9;
        CreationPendingResourceInputType r102 = CreationPendingResourceInputType.CONTENT_URI;
        if (r100 != null) goto L37;
        r100 = "";
    L37:
        return new s0(r102, r100);
    L9:
        if (b(r100) == false) goto L14;
        CreationPendingResourceInputType r103 = CreationPendingResourceInputType.FILE_URI;
        if (r100 != null) goto L38;
        r100 = "";
    L38:
        return new s0(r103, r100);
    L14:
        if (r100 != null) goto L16;
    L19:
        boolean r104 = true;
    L20:
        if (r104 == true) goto L23;
        return new s0(CreationPendingResourceInputType.LOCAL_PATH, r100);
    L23:
        if (a(r101) == false) goto L30;
        CreationPendingResourceInputType r105 = CreationPendingResourceInputType.CONTENT_URI;
        if (r101 != null) goto L27;
        r101 = "";
    L27:
        s0 r106 = new s0(r105, r101);
    L40:
        return r106;
    L30:
        if (b(r101) == false) goto L36;
        CreationPendingResourceInputType r107 = CreationPendingResourceInputType.FILE_URI;
        if (r101 != null) goto L34;
        r101 = "";
    L34:
        r106 = new s0(r107, r101);
        goto L40
    L36:
        return s0.f372420c;
    L16:
        if (StringsKt.isBlank(r100) == true) goto L19;
        r104 = false;
        goto L20
    }

    public static s0 c(String r100, String r101, String r102, String r103) {
        boolean r104 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L53;
        if (r101 != null) goto L13;
    L16:
        boolean r106 = true;
    L17:
        if (r106 == true) goto L21;
        s0 r107 = new s0(CreationPendingResourceInputType.REMOTE_URL, r101);
    L54:
        return r107;
    L21:
        if (a(r102) == false) goto L27;
        CreationPendingResourceInputType r108 = CreationPendingResourceInputType.CONTENT_URI;
        if (r102 != null) goto L25;
        r102 = "";
    L25:
        r107 = new s0(r108, r102);
        goto L54
    L27:
        if (b(r102) == false) goto L32;
        CreationPendingResourceInputType r109 = CreationPendingResourceInputType.FILE_URI;
        if (r102 != null) goto L31;
        r102 = "";
    L31:
        r107 = new s0(r109, r102);
        goto L54
    L32:
        if (r102 != null) goto L34;
    L37:
        if (r104 == true) goto L40;
        return new s0(CreationPendingResourceInputType.LOCAL_PATH, r102);
    L40:
        if (a(r103) == false) goto L46;
        CreationPendingResourceInputType r110 = CreationPendingResourceInputType.CONTENT_URI;
        if (r103 != null) goto L44;
        r103 = "";
    L44:
        r107 = new s0(r110, r103);
        goto L54
    L46:
        if (b(r103) == false) goto L52;
        CreationPendingResourceInputType r111 = CreationPendingResourceInputType.FILE_URI;
        if (r103 != null) goto L50;
        r103 = "";
    L50:
        r107 = new s0(r111, r103);
        goto L54
    L52:
        return s0.f372420c;
    L34:
        if (StringsKt.isBlank(r102) == true) goto L37;
        r104 = false;
        goto L37
    L13:
        if (StringsKt.isBlank(r101) == true) goto L16;
        r106 = false;
        goto L17
    L53:
        return new s0(CreationPendingResourceInputType.TOS_KEY, r100);
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r105 = false;
        goto L9
    }
}
