package com.tencent.connect;

import android.content.Context;
import android.os.Bundle;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.g;
import com.tencent.tauth.IUiListener;

/* JADX INFO: loaded from: classes40.dex */
public class UserInfo extends BaseApi {
    public static final String GRAPH_OPEN_ID = "oauth2.0/m_me";

    public void getOpenId(IUiListener r100) {
        Bundle r101 = a();
        BaseApi.TempRequestListener r102 = new BaseApi.TempRequestListener(this, r100);
        HttpUtils.requestAsync(this.f461558c, g.a(), GRAPH_OPEN_ID, r101, "GET", r102);
    }

    public void getUserInfo(IUiListener r100) {
        Bundle r101 = a();
        BaseApi.TempRequestListener r102 = new BaseApi.TempRequestListener(this, r100);
        HttpUtils.requestAsync(this.f461558c, g.a(), "user/get_simple_userinfo", r101, "GET", r102);
    }

    public UserInfo(Context r100, QQToken r101) {
        super(r101);
    }

    public UserInfo(Context r100, c r101, QQToken r102) {
        super(r101, r102);
    }
}
