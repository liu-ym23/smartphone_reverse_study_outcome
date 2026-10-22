package com.tencent.connect.emotion;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.Toast;
import com.alipay.sdk.m.u.i;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.connect.a;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes40.dex */
public class QQEmotion extends BaseApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IUiListener f461567a;

    public QQEmotion(QQToken r100) {
        super(r100);
    }

    private boolean a(Context r110, ArrayList<Uri> r111) {
        if (r111 != null) goto L5;
    L25:
        return false;
    L5:
        if (r111.size() == 0) goto L25;
        if (r111.size() <= 9) goto L11;
        SLog.i("QQEMOTION", "isLegality -->illegal, file count > 9, count = " + r111.size());
        return false;
    L11:
        long r100 = 0;
        int r101 = 0;
    L13:
        if (r101 >= r111.size()) goto L20;
        long r102 = m.a(r110, (Uri) ListProtector.get(r111, r101));
        if (r102 > 1048576) goto L16;
        r100 = r100 + r102;
        r101 = r101 + 1;
        goto L13
    L16:
        SLog.i("QQEMOTION", "isLegality -->illegal, fileSize: " + r102);
        return false;
    L20:
        if (r100 <= 3145728) goto L23;
        SLog.i("QQEMOTION", "isLegality -->illegal, totalSize: " + r100);
        return false;
    L23:
        SLog.i("QQEMOTION", "isLegality -->legal, totalSize: " + r100);
        return true;
    }

    private String a(Activity r100, ArrayList<Uri> r101) {
        StringBuilder r102 = new StringBuilder();
        Iterator<Uri> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        Uri r104 = m.a(r100, this.f461558c.getAppId(), m.b(r100, r103.next()));
        if (r104 == null) goto L7;
        r102.append(r104);
        r102.append(i.f25853b);
        goto L4
    L7:
        SLog.e("QQEmotion", "getFilePathListJson: grantedUri = null");
        goto L4
    L9:
        String r105 = r102.toString();
        SLog.i("QQEmotion", "-->getFilePathListJson listStr : " + r105);
        return r105;
    }

    public void setEmotions(Activity r100, ArrayList<Uri> r110, IUiListener r111) {
        if (a.a("QQEmotion", r111) == false) goto L5;
        return;
    L5:
        IUiListener r101 = this.f461567a;
        if (r101 == null) goto L8;
        r101.onCancel();
    L8:
        this.f461567a = r111;
        if (k.b(r100) == true) goto L13;
        Toast.makeText(r100.getApplicationContext(), "当前手机未安装QQ，请安装最新版QQ后再试。", 1).show();
        return;
    L13:
        if (k.c(r100, "8.0.0") >= 0) goto L17;
        Toast.makeText(r100.getApplicationContext(), "当前手机QQ版本过低，不支持设置表情功能。", 1).show();
        return;
    L17:
        if (a(r100.getApplicationContext(), r110) == true) goto L20;
        Toast.makeText(r100.getApplicationContext(), "图片不符合要求，不支持设置表情功能。", 1).show();
        return;
    L20:
        String r102 = m.a(r100);
        StringBuffer r103 = new StringBuffer("mqqapi://profile/sdk_face_collection?");
        StringBuilder r104 = new StringBuilder();
        if (TextUtils.isEmpty(r102) == false) goto L23;
    L26:
        String r105 = this.f461558c.getAppId();
        String r106 = this.f461558c.getOpenId();
        if (TextUtils.isEmpty(r105) == true) goto L30;
        r103.append("&share_id=" + r105);
        r104.append(r105);
    L30:
        if (TextUtils.isEmpty(r106) == true) goto L32;
        r104.append(r106);
        r103.append("&open_id=" + Base64.encodeToString(m.j(r106), 2));
    L32:
        r103.append("&sdk_version=" + Base64.encodeToString(m.j(Constants.SDK_VERSION), 2));
        r104.append(Constants.SDK_VERSION);
        String r107 = a(r100, r110);
        if (TextUtils.isEmpty(r107) == true) goto L38;
        r104.append(r107);
        r103.append("&set_uri_list=" + Base64.encodeToString(m.j(r107), 2));
        r103.append("&ppsts=");
        r103.append(k.a(r100, r104.toString()));
        SLog.v("QQEMOTION", "-->set avatar, url: " + r103.toString());
        Intent r108 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        r108.setData(UriProtector.parse(r103.toString()));
        r108.setPackage("com.tencent.mobileqq");
        r108.putParcelableArrayListExtra("android.intent.extra.STREAM", r110);
        if (a(r108) == false) goto L40;
        UIListenerManager.getInstance().setListenerWithRequestcode(10109, r111);
        a(r100, 10109, r108, false);
        return;
    L40:
        return;
    L38:
        r111.onError(new UiError(-6, Constants.MSG_UNKNOWN_ERROR, "picPathList is null"));
        return;
    L23:
        if (r102.length() <= 20) goto L25;
        r102 = r102.substring(0, 20) + "...";
    L25:
        r104.append(r102);
        r103.append("&app_name=" + Base64.encodeToString(m.j(r102), 2));
        goto L26
    }
}
