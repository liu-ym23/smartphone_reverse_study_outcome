package xtb;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.chat.entity.message.content.FolderContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.utils.y0;
import com.ss.android.lark.filedetail.FileDetailModule;
import com.ss.android.lark.filedetail.dto.FileDetailLaunchParams;
import com.ss.android.lark.filedetail.dto.FolderManageLaunchParams;
import com.ss.android.lark.filedetail.impl.detail.FileDetailController;
import com.ss.android.lark.officesdk.integrator.im.impl.g;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import vab.b;

/* JADX INFO: loaded from: classes37.dex */
public final class a implements b {
    @Inject
    public a() {
    }

    public static int a(Chat r100) {
        if (r100 == null) goto L4;
        Chat.Type r101 = r100.getType();
    L6:
        return r101.getNumber();
    L4:
        r101 = Chat.Type.UNKNOWN;
        goto L6
    }

    public final void b(Context r100, Message r101, Chat r102) {
        boolean r103 = false;
        if (r102 != null) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r102 != null) goto L10;
    L12:
        boolean r105 = y0.b(r102);
        boolean r106 = y0.c(r102);
        FileDetailLaunchParams.a r107 = new FileDetailLaunchParams.a(r100, r101);
        String r108 = r101.getChatId();
        Intrinsics.checkNotNullParameter(r108, "chatId");
        r107.f421470d = r108;
        r107.f421472f = r104;
        r107.f421473g = r103;
        r107.c(r105);
        r107.b(r106);
        r107.f421491y = null;
        r107.A = null;
        r107.B = a(r102);
        r107.f421476j = 1;
        if (TextUtils.isEmpty(null) == true) goto L18;
        if (r101.getType() != Message.Type.FILE) goto L18;
        r107.f421492z = ((FileContent) r101.getContent()).getKey();
    L18:
        if (TextUtils.isEmpty(r101.getThreadId()) == false) goto L20;
        r107.f421474h = r101.getPosition();
    L22:
        if (TextUtils.isEmpty("") == true) goto L24;
        Intrinsics.checkNotNullParameter("", "originMergeForwardId");
        r107.f421489w = "";
    L24:
        int r109 = g.f433298a;
        FileDetailLaunchParams r110 = r107.a();
        Intrinsics.checkNotNullParameter(r110, "params");
        FileDetailController.d(r110);
        return;
    L20:
        String r111 = r101.getThreadId();
        Intrinsics.checkNotNullParameter(r111, "threadId");
        r107.f421486t = r111;
        r107.f421490x = r101.getThreadPosition();
        goto L22
    L10:
        if (r102.isCrossWithKa() == false) goto L12;
        r103 = true;
        goto L12
    L5:
        if (r102.isSecret() == false) goto L7;
        r104 = true;
        goto L8
    }

    public final void e(Context r110, Message r111, Chat r112) {
        boolean r100 = y0.b(r112);
        boolean r101 = y0.c(r112);
        if (TextUtils.isEmpty(null) == true) goto L10;
        Content r102 = r111.getContent();
        if ((r102 instanceof FileContent) == false) goto L8;
        String r103 = ((FileContent) r102).getKey();
    L11:
        Intrinsics.checkNotNullParameter(r111, "message");
        Chat.Type.UNKNOWN.getNumber();
        String r104 = r111.getId();
        String r105 = ((FolderContent) r111.getContent()).getKey();
        String r106 = ((FolderContent) r111.getContent()).getName();
        long r107 = ((FolderContent) r111.getContent()).getSize();
        String r113 = r111.getChatId();
        Intrinsics.checkNotNullParameter(r113, "chatId");
        int r114 = a(r112);
        int r115 = -1;
        if (r111.isReplyInThreadRootMessage() == false) goto L16;
        int r116 = r111.getPosition();
    L14:
        r115 = r116;
        int r117 = -1;
        String r118 = null;
    L19:
        int r119 = g.f433298a;
        FolderManageLaunchParams r120 = new FolderManageLaunchParams();
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r120.f421494a = r104;
        Intrinsics.checkNotNullParameter(r113, "<set-?>");
        r120.f421495b = r113;
        r120.f421496c = r115;
        r120.f421497d = false;
        r120.f421498e = 0;
        r120.f421499f = 1;
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r120.f421500g = r105;
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r120.f421501h = r106;
        r120.f421502i = null;
        r120.f421503j = null;
        r120.f421504k = r118;
        r120.f421505l = r117;
        r120.f421506m = r111;
        r120.f421507n = r107;
        r120.f421508o = null;
        r120.f421509p = r100;
        r120.f421510q = r101;
        r120.f421511r = 1;
        r120.f421512s = null;
        r120.f421513t = null;
        r120.f421514u = r103;
        r120.f421515v = null;
        r120.f421516w = r114;
        FileDetailModule.a(r110, r120);
        return;
    L16:
        if (r111.isReplyInThreadChildMessage() == false) goto L18;
        r118 = r111.getThreadId();
        r117 = r111.getThreadPosition();
        goto L19
    L18:
        r116 = r111.getPosition();
        goto L14
    L8:
        if ((r102 instanceof FolderContent) == false) goto L10;
        r103 = ((FolderContent) r102).getKey();
    L10:
        r103 = "";
        goto L11
    }

    public final void d(Context r100, FileContent r101, String r102, Chat r103, int r110, boolean r111) {
        boolean r104 = y0.b(r103);
        boolean r105 = y0.c(r103);
        if (r103.isCrossWithKa() == false) goto L5;
        boolean r106 = true;
    L6:
        FileDetailLaunchParams.a r107 = new FileDetailLaunchParams.a(r100, r101, r102);
        r107.f421474h = r110;
        r107.c(r104);
        r107.b(r105);
        r107.f421473g = r106;
        r107.B = a(r103);
        r107.f421477k = false;
        r107.f421488v = false;
        r107.f421492z = r101.getKey();
        long r108 = r107.f421479m | 8;
        r107.f421479m = r108;
        if (r111 == true) goto L9;
        r107.f421479m = r108 ^ 8;
    L9:
        String r109 = r103.getId();
        Intrinsics.checkNotNullParameter(r109, "chatId");
        r107.f421470d = r109;
        FileDetailLaunchParams r112 = r107.a();
        Intrinsics.checkNotNullParameter(r112, "params");
        FileDetailController.d(r112);
        return;
    L5:
        r106 = false;
        goto L6
    }

    public final void f(Context r110, Message r111, FolderContent r112, String r210, Chat r211, int r212, String r213, String r214, boolean r215) {
        if (r215 == true) goto L5;
    L7:
        boolean r100 = false;
    L8:
        boolean r101 = y0.c(r211);
        Intrinsics.checkNotNullParameter(r210, "messageId");
        Chat.Type.UNKNOWN.getNumber();
        String r102 = r112.getKey();
        Intrinsics.checkNotNullParameter(r102, "folderKey");
        String r103 = r112.getName();
        Intrinsics.checkNotNullParameter(r103, "folderName");
        long r104 = r112.getSize();
        int r105 = a(r211);
        String r113 = r112.getKey();
        if (r111 == null) goto L11;
        Message r114 = r111;
    L12:
        String r115 = r211.getId();
        Intrinsics.checkNotNullParameter(r115, "chatId");
        FolderManageLaunchParams r116 = new FolderManageLaunchParams();
        Intrinsics.checkNotNullParameter(r210, "<set-?>");
        r116.f421494a = r210;
        Intrinsics.checkNotNullParameter(r115, "<set-?>");
        r116.f421495b = r115;
        r116.f421496c = r212;
        r116.f421497d = false;
        r116.f421498e = 10;
        r116.f421499f = -99;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r116.f421500g = r102;
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r116.f421501h = r103;
        r116.f421502i = null;
        r116.f421503j = null;
        r116.f421504k = null;
        r116.f421505l = -1;
        r116.f421506m = r114;
        r116.f421507n = r104;
        r116.f421508o = null;
        r116.f421509p = r100;
        r116.f421510q = r101;
        r116.f421511r = 1;
        r116.f421512s = r213;
        r116.f421513t = r214;
        r116.f421514u = r113;
        r116.f421515v = null;
        r116.f421516w = r105;
        FileDetailModule.a(r110, r116);
        return;
    L11:
        r114 = null;
        goto L12
    L5:
        if (y0.b(r211) == false) goto L7;
        r100 = true;
        goto L8
    }

    public final void c(Context r100, Message r101, FileContent r102, String r103, Chat r104, int r110, boolean r111, String r112, String r113, boolean r114) {
        boolean r105 = true;
        if (r114 == true) goto L5;
    L7:
        boolean r115 = false;
    L8:
        boolean r106 = y0.c(r104);
        if (r104.isCrossWithKa() == true) goto L12;
        r105 = false;
    L12:
        FileDetailLaunchParams.a r107 = new FileDetailLaunchParams.a(r100, r102, r103);
        r107.f421474h = r110;
        r107.c(r115);
        r107.b(r106);
        r107.f421473g = r105;
        r107.B = a(r104);
        r107.f421477k = false;
        r107.f421488v = false;
        r107.f421492z = r102.getKey();
        r107.f421491y = r112;
        r107.A = r113;
        long r108 = r107.f421479m | 8;
        r107.f421479m = r108;
        if (r111 == true) goto L15;
        r107.f421479m = r108 ^ 8;
    L15:
        if (r101 == null) goto L17;
        Intrinsics.checkNotNullParameter(r101, "message");
        r107.f421468b = r101;
    L17:
        String r109 = r104.getId();
        Intrinsics.checkNotNullParameter(r109, "chatId");
        r107.f421470d = r109;
        FileDetailLaunchParams r116 = r107.a();
        Intrinsics.checkNotNullParameter(r116, "params");
        FileDetailController.d(r116);
        return;
    L5:
        if (y0.b(r104) == false) goto L7;
        r115 = true;
        goto L8
    }
}
