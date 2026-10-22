package com.ss.android.lark.thirdshare.base.export.util;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import com.larksuite.framework.utils.m;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.thirdshare.base.export.ShareActionType;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import java.io.File;

/* JADX INFO: loaded from: classes38.dex */
public final class c {
    public static ComponentName a(ShareActionType r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ShareActionType r101 = ShareActionType.WX;
        if (r101.equals(r100) == false) goto L10;
        return new ComponentName(r101.getPkgName(), "com.tencent.mm.ui.tools.ShareImgUI");
    L10:
        if (ShareActionType.WX_TIMELINE.equals(r100) == true) goto L12;
        ShareActionType r102 = ShareActionType.QQ;
        if (r102.equals(r100) == true) goto L16;
        ShareActionType r103 = ShareActionType.WB;
        if (r103.equals(r100) == true) goto L20;
        return null;
    L20:
        return new ComponentName(r103.getPkgName(), "com.sina.weibo.composerinde.ComposerDispatchActivity");
    L16:
        return new ComponentName(r102.getPkgName(), "com.tencent.mobileqq.activity.JumpActivity");
    L12:
        return new ComponentName(r101.getPkgName(), "com.tencent.mm.ui.tools.ShareToTimeLineUI");
    }

    public static void b(File r100, String r101, ApiUtils.a<Boolean> r102) {
        Uri r103 = m.a(LarkContext.getApplication(), r100);
        if (r103 != null) goto L6;
        Log.e("ThirdShare", "getUriForFile failed.");
        r102.consume(Boolean.FALSE);
        return;
    L6:
        Intent r104 = new Intent("android.intent.action.SEND");
        r104.putExtra("android.intent.extra.STREAM", r103);
        r104.setType(r101);
        Intent r105 = Intent.createChooser(r104, UIHelper.getString(R.string.Lark_UserGrowth_InvitePeopleContactsShareTo));
        r105.setFlags(268435456);
        LarkContext.getApplication().startActivity(r105);
        r102.consume(Boolean.TRUE);
    }
}
