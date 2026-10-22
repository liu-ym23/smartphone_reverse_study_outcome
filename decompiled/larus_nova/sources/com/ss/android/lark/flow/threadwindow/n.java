package com.ss.android.lark.flow.threadwindow;

import com.ss.android.lark.chat.entity.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class n {
    public static final boolean a(Message r100) {
        String r101 = r100.getRootId();
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L54;
        String r103 = r100.getParentId();
        if (r103 != null) goto L13;
    L16:
        boolean r104 = true;
    L17:
        if (r104 == false) goto L56;
        String r105 = r100.getThreadId();
        if (r105 != null) goto L22;
    L52:
        return true;
    L22:
        if (r105.length() <= 0) goto L24;
        boolean r106 = true;
    L25:
        String r107 = null;
        if (r106 == true) goto L29;
        r105 = null;
    L29:
        if (r105 == null) goto L52;
        String r108 = r100.getId();
        if (r108 != null) goto L34;
    L39:
        r108 = null;
    L40:
        String r109 = r100.getcId();
        if (r109 == null) goto L49;
        if (r109.length() <= 0) goto L45;
        boolean r110 = true;
    L46:
        if (r110 == false) goto L49;
        r107 = r109;
        goto L49
    L45:
        r110 = false;
    L49:
        if (Intrinsics.areEqual(r105, r108) == true) goto L52;
        if (Intrinsics.areEqual(r105, r107) == true) goto L52;
        return false;
    L34:
        if (r108.length() <= 0) goto L36;
        boolean r111 = true;
    L37:
        if (r111 == false) goto L39;
    L36:
        r111 = false;
        goto L37
    L24:
        r106 = false;
        goto L25
    L56:
        return false;
    L13:
        if (r103.length() == 0) goto L16;
        r104 = false;
        goto L17
    L54:
        return false;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public static final String b(String r100) {
        if (r100 == null) goto L13;
        boolean r101 = false;
        if (r100.length() <= 0) goto L6;
        boolean r102 = true;
    L7:
        if (r102 == true) goto L9;
    L11:
        if (r101 == false) goto L13;
        return r100;
    L9:
        if (Intrinsics.areEqual(r100, "null") == true) goto L11;
        r101 = true;
        goto L11
    L6:
        r102 = false;
    L13:
        return null;
    }
}
