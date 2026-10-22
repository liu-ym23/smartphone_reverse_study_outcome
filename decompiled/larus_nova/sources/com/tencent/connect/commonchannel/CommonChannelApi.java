package com.tencent.connect.commonchannel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.tencent.connect.a;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.utils.m;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;

/* JADX INFO: loaded from: classes40.dex */
public class CommonChannelApi extends BaseApi {
    public static final String SCHEME_HEADER = "mqqapi://open_connect/common_channel";

    public CommonChannelApi(QQToken r100) {
        super(r100);
    }

    private boolean a(Bundle r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.containsKey(Constants.PARAM_SRC_ID) == true) goto L8;
        return false;
    L8:
        if (r100.containsKey(Constants.PARAM_EXT_DATA) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public CommonChannelApi(c r100, QQToken r101) {
        super(r100, r101);
    }

    public int launchQQ(Activity r100, Bundle r101, IUiListener r102) {
        if (r102 != null) goto L6;
        return -5;
    L6:
        if (a.a("UniversalApi", r102) == false) goto L10;
        return -6;
    L10:
        if (a(r101) == true) goto L13;
        r102.onError(new UiError(-5, Constants.MSG_PARAM_ERROR, Constants.MSG_PARAM_ERROR));
        return -5;
    L13:
        StringBuilder r103 = new StringBuilder(SCHEME_HEADER);
        a(r103, r100);
        String r104 = r101.getString(Constants.PARAM_EXT_DATA);
        a(r103, "exsvr_userinfo", m.k(r104));
        a(r103, Constants.PARAM_EXT_DATA, m.k(r104));
        a(r103, Constants.PARAM_SRC_ID, String.valueOf(r101.getInt(Constants.PARAM_SRC_ID, 0)));
        Intent r105 = new Intent();
        r105.setData(UriProtector.parse(r103.toString()));
        r105.setPackage("com.tencent.mobileqq");
        r105.putExtra(Constants.FOR_RESULT, true);
        r105.putExtra("pkg_name", r100.getPackageName());
        r105.setFlags(335544320);
        UIListenerManager.getInstance().setListenerWithRequestcode(10114, r102);
        a(r100, 10114, r105, false);
        return 0;
    }
}
