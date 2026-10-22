package com.ss.android.lark.filedetail.impl.open;

import android.content.Context;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.filedetail.impl.detail.FileDetailController;
import com.ss.android.lark.filedetail.impl.detail.z;
import com.ss.android.lark.filedetailapi.container.IFileDetailPlugin;

/* JADX INFO: loaded from: classes35.dex */
public final class c {
    public static boolean a(OpenFileParams r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        String r101 = FileUtils.k(r100.getFileContent().getFilePath());
        IFileDetailPlugin r102 = FileDetailController.f421566c;
        if (r102 != null) goto L9;
        return false;
    L9:
        if ((r102 instanceof gfb.a) == false) goto L17;
        gfb.a r103 = (gfb.a) r102;
        if (r103.canPreview() == false) goto L14;
        return true;
    L14:
        if (r103.a() == false) goto L19;
        return true;
    L19:
        return false;
    L17:
        if (r102.canPreview(r101) == false) goto L19;
        return true;
    }

    public static boolean b(final z r110, final Context r111, final FileContent r112, final OpenFileParams r113) {
        if (r112 == null) goto L22;
        String r100 = r112.getFilePath();
        r112.getName();
        if (sfb.c.c(r100) == false) goto L22;
        final IFileDetailPlugin r101 = FileDetailController.f421566c;
        if (r101 != null) goto L10;
        return false;
    L10:
        final String r102 = r112.getFilePath();
        String r103 = FileUtils.k(r102);
        if ((r101 instanceof gfb.a) == false) goto L19;
        gfb.a r104 = (gfb.a) r101;
        if (r104.canPreview() == false) goto L16;
        UICallbackExecutor.post(new a(r101, r111, r112, r113, r110, r102));
        return true;
    L16:
        r104.open();
        r110.y();
        return true;
    L19:
        if (r101.canPreview(r103) == false) goto L21;
        UICallbackExecutor.post(new b(r101, r111, r112, r102, r110));
    L21:
        return true;
    L22:
        return false;
    }
}
