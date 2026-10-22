package com.ss.android.lark.widget.select;

import android.text.Layout;
import com.bytedance.lark.pb.basic.v1.Message;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class i {
    static {
    }

    @JvmStatic
    public static final Message.PartialReplyInfo.PartialContentRelativePosition b(int r100, h r101) {
        Intrinsics.checkNotNullParameter(r101, "mSelectionInfo");
        int r102 = r101.f448433a;
        if (r102 == 0) goto L5;
    L6:
        if (r102 > 0) goto L8;
    L10:
        if (r102 != 0) goto L13;
        return Message.PartialReplyInfo.PartialContentRelativePosition.HEAD;
    L13:
        if (r100 != r101.f448434b) goto L16;
        return Message.PartialReplyInfo.PartialContentRelativePosition.TAIL;
    L16:
        return Message.PartialReplyInfo.PartialContentRelativePosition.UNKNOWN;
    L8:
        if (r101.f448434b >= r100) goto L10;
    L17:
        return Message.PartialReplyInfo.PartialContentRelativePosition.MIDDLE;
    L5:
        if (r101.f448434b == r100) goto L17;
        goto L6
    }

    @JvmStatic
    public static final int a(Layout r100, int r101, int r110, int r111) {
        if (r100 != null) goto L5;
        return -1;
    L5:
        int r102 = r100.getLineForVertical(r110);
        boolean r103 = false;
        if (r111 > 0) goto L8;
    L10:
        boolean r104 = false;
    L11:
        if (r104 == false) goto L15;
        int r105 = r111 - 1;
        int r106 = (int) r100.getPrimaryHorizontal(r105);
        int r107 = (int) r100.getLineRight(r102);
        if (r101 <= (r107 - ((r107 - r106) / 2))) goto L15;
        r111 = r105;
    L15:
        int r112 = r100.getLineForOffset(r111);
        int r108 = r100.getLineTop(r112);
        int r109 = r100.getLineBottom(r112);
        int r113 = (r109 - r108) / 2;
        if (r102 != (r112 + 1)) goto L20;
        if ((r110 - r109) >= r113) goto L20;
    L23:
        r102 = r112;
    L24:
        int r114 = r100.getOffsetForHorizontal(r102, r101);
        if (r114 >= (r100.getText().length() - 1)) goto L36;
        int r115 = r114 + 1;
        if (r115 > 0) goto L29;
    L31:
        if (r103 == false) goto L37;
        int r116 = (int) r100.getPrimaryHorizontal(r114);
        int r117 = (int) r100.getLineRight(r102);
        if (r101 > (r117 - ((r117 - r116) / 2))) goto L35;
        return r114;
    L35:
        return r115;
    L37:
        return r114;
    L29:
        if (r100.getLineForOffset(r115) != (r100.getLineForOffset(r115 - 1) + 1)) goto L31;
        r103 = true;
        goto L31
    L36:
        return r114;
    L20:
        if (r102 != (r112 - 1)) goto L24;
        if ((r108 - r110) >= r113) goto L24;
    L8:
        if (r100.getLineForOffset(r111) != (r100.getLineForOffset(r111 - 1) + 1)) goto L10;
        r104 = true;
        goto L11
    }
}
