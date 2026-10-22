package com.ss.android.lark.thirdshare.panel;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.thirdshare.base.export.ShareActionType;
import com.ss.android.lark.thirdshare.lark.export.bean.LarkChatShareActionType;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class f {
    public static final void a(ShareActionType r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, SlcCommonAction.KEY_ACTIONS);
        Iterator r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(((b) r103).f441240a, r100) == false) goto L4;
    L10:
        if (((b) r103) == null) goto L13;
        return;
    L13:
        if (Intrinsics.areEqual(r100, LarkChatShareActionType.a.f441234a.f441233a) == false) goto L16;
        int r104 = b.a.f441242c;
        return;
    L16:
        if (Intrinsics.areEqual(r100, ShareActionType.WX) == false) goto L19;
        int r105 = b.h.f441249c;
        return;
    L19:
        if (Intrinsics.areEqual(r100, ShareActionType.WB) == false) goto L22;
        int r106 = b.g.f441248c;
        return;
    L22:
        if (Intrinsics.areEqual(r100, ShareActionType.QQ) == false) goto L25;
        int r107 = b.c.f441244c;
        return;
    L25:
        if (Intrinsics.areEqual(r100, ShareActionType.COPY) == false) goto L28;
        int r108 = b.C5312b.f441243c;
        return;
    L28:
        if (Intrinsics.areEqual(r100, ShareActionType.SYS) == false) goto L31;
        int r109 = b.e.f441246c;
        return;
    L31:
        if (Intrinsics.areEqual(r100, ShareActionType.WX_TIMELINE) == false) goto L34;
        int r110 = b.i.f441250c;
        return;
    L34:
        if (Intrinsics.areEqual(r100, ShareActionType.SAVE) == false) goto L37;
        int r111 = b.d.f441245c;
        return;
    L37:
        if (Intrinsics.areEqual(r100, ShareActionType.UNKNOWN) == false) goto L39;
        int r112 = b.f.f441247c;
        return;
    L39:
        Log.e("SharePanel", "find action type " + r100.name() + " in config, bug no action impl in share panel param.", new IllegalArgumentException(), true);
        return;
    L8:
        r103 = null;
        goto L10
    }
}
