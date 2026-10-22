package com.tencent.connect;

import android.content.Context;
import android.os.Bundle;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.SocialOperation;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.g;
import com.tencent.tauth.IUiListener;

/* JADX INFO: loaded from: classes40.dex */
public class UnionInfo extends BaseApi {
    public static final String URL_GET_UNION_ID = "https://openmobile.qq.com/oauth2.0/me";

    public void getUnionId(IUiListener r100) {
        Bundle r101 = a();
        r101.putString(SocialOperation.GAME_UNION_ID, "1");
        BaseApi.TempRequestListener r102 = new BaseApi.TempRequestListener(this, r100);
        HttpUtils.requestAsync(this.f461558c, g.a(), URL_GET_UNION_ID, r101, "GET", r102);
    }

    public UnionInfo(Context r100, QQToken r101) {
        super(r101);
    }
}
