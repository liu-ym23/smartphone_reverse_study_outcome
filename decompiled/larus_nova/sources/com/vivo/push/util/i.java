package com.vivo.push.util;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public final class i extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f462579e;

    public i() {
        this.f462579e = 0;
    }

    @Override // com.vivo.push.util.b
    public final int a() {
        return this.f462579e;
    }

    private int a(Intent r100) {
        if (r100.resolveActivityInfo(this.f462565c.getPackageManager(), 65536) != null) goto L6;
        t.a("AndroidTwelveNotifyClickIntentParam", "activity is null  ");
        t.c(this.f462565c, " 跳转参数对应的Activity找不到 通知不展示   2162");
        return 2162;
    L6:
        return 0;
    }

    private static Intent a(Intent r100, Map<String, String> r101) {
        if (r101 != null) goto L4;
    L14:
        return r100;
    L4:
        if (r101.entrySet() == null) goto L14;
        Iterator<Map.Entry<String, String>> r102 = r101.entrySet().iterator();
    L8:
        if (r102.hasNext() == false) goto L14;
        Map.Entry<String, String> r103 = r102.next();
        if (r103 == null) goto L8;
        if (r103.getKey() == null) goto L8;
        r100.putExtra(r103.getKey(), r103.getValue());
        goto L8
    }

    private int b(Intent r100, String r101) {
        if (r100 != null) goto L5;
    L23:
        StringBuilder r102 = new StringBuilder("checkSkipContentPackageFit intent = : ");
        Object r103 = r100;
        if (r100 != null) goto L26;
        r103 = "";
    L26:
        r102.append(r103);
        r102.append(" mPkgName = ");
        r102.append(r101);
        t.a("AndroidTwelveNotifyClickIntentParam", r102.toString());
        return 2158;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L23;
    L20:
        e = move-exception;
        t.a("AndroidTwelveNotifyClickIntentParam", "checkSkipContentPackage open activity error :  error " + e.getMessage());
        return 2158;
    L8:
        if (r100.getComponent() == null) goto L10;
        String r104 = r100.getComponent().getPackageName();     // Catch: Exception -> L20
    L12:
        if (TextUtils.isEmpty(r104) == false) goto L14;
        return 0;
    L14:
        if (TextUtils.equals(r101, r104) == true) goto L30;
        t.d("AndroidTwelveNotifyClickIntentParam", "activity component error : local pkgName is " + r101 + "; but remote pkgName is " + r104);     // Catch: Exception -> L20
        t.a(this.f462565c, " 跳转参数对应的包名不是当前应用包名    local pkgName is " + r101 + "; but remote pkgName is " + r104 + " code =2813");     // Catch: Exception -> L20
        return 2813;
    L30:
        return 0;
    L10:
        r104 = r100.getPackage();     // Catch: Exception -> L20
        goto L12
    }

    private int a(Intent r100, String r101) {
        int r102 = a(r100);
        t.d("AndroidTwelveNotifyClickIntentParam", "checkSkipContentParameterLegal canfindactivity code : ".concat(String.valueOf(r102)));
        if (r102 == 0) goto L5;
        return r102;
    L5:
        int r103 = b(r100, r101);
        t.d("AndroidTwelveNotifyClickIntentParam", "checkSkipContentParameterLegal packagefit code : ".concat(String.valueOf(r103)));
        if (r103 == 0) goto L8;
        return r103;
    L8:
        return 0;
    }

    @Override // com.vivo.push.util.b
    public final PendingIntent a(Context r100, Intent r101) {
        return PendingIntent.getActivity(r100, (int) SystemClock.uptimeMillis(), r101, 201326592);
    }

    private Intent a(Map<String, String> r100, String r101, Context r102) {
        Intent r103 = new Intent();
        r103.setPackage(r101);
        r103 = r102.getPackageManager().getLaunchIntentForPackage(r101);     // Catch: Exception -> L8
        if (r103 == null) goto L6;
        r103.setFlags(335544320);     // Catch: Exception -> L8
        a(r103, r100);     // Catch: Exception -> L8
    L11:
    L10:
        return r103;
    L6:
        this.f462579e = 2162;     // Catch: Exception -> L8
        t.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient LaunchIntent is null");     // Catch: Exception -> L8
    L8:
        e = move-exception;
        t.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient LaunchIntent Exception" + e.getMessage());
        goto L10
    }

    private Intent b(Context r110, InsideNotificationItem r111, NotifyArriveCallbackByUser r112) {
        String r100 = r110.getPackageName();     // Catch: Exception -> L63
        if (r111 != null) goto L6;
    L61:
        t.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient notify == null");     // Catch: Exception -> L63
        this.f462579e = 2159;     // Catch: Exception -> L63
        return null;
    L6:
        if (TextUtils.isEmpty(r100) == true) goto L61;
        t.d("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient getSkipType ：：" + r111.getSkipType());     // Catch: Exception -> L63
        int r101 = r111.getSkipType();     // Catch: Exception -> L63
        boolean r102 = true;
        if (r101 != 1) goto L12;
        Intent r113 = a(r111.getParams(), r100, r110);     // Catch: Exception -> L63
    L57:
        if (r113 == null) goto L60;
        r113.putExtra("vivo_push_messageId", b());     // Catch: Exception -> L63
        r113.putExtra("command_type", "reflect_receiver");     // Catch: Exception -> L63
        b.a(r113, r110);     // Catch: Exception -> L63
        this.f462579e = 0;     // Catch: Exception -> L63
        return r113;
    L60:
        t.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient skip type error : " + r111.getSkipType());     // Catch: Exception -> L63
    L65:
        return null;
    L12:
        if (r101 != 2) goto L14;
        String r114 = r111.getSkipContent();     // Catch: Exception -> L63
        if (TextUtils.isEmpty(r114) == true) goto L52;
        String r103 = r114.toLowerCase();     // Catch: Exception -> L63
        if (r103.startsWith("http://") == false) goto L50;
    L53:
        if (r102 == false) goto L55;
        Intent r104 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(r114));     // Catch: Exception -> L63
        r104.setFlags(268435456);     // Catch: Exception -> L63
        a(r104, r111.getParams());     // Catch: Exception -> L63
        t.d("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient url urlAddr ::".concat(String.valueOf(r114)));     // Catch: Exception -> L63
        r113 = r104;
        goto L57
    L55:
        t.c(r110, " 跳转参数不合法，打开网页地址不符合要求 通知未展示 2157");     // Catch: Exception -> L63
        t.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient url not legal");     // Catch: Exception -> L63
        this.f462579e = 2157;     // Catch: Exception -> L63
    L18:
        r113 = null;
        goto L57
    L50:
        if (r103.startsWith("https://") == true) goto L53;
    L52:
        r102 = false;
        goto L53
    L14:
        if (r101 != 3) goto L16;
        String r105 = r111.getSkipContent();     // Catch: Exception -> L63
        t.d("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient ：：" + r111.getSkipContent());     // Catch: Exception -> L63
        if (r112.getIntent() == null) goto L44;
        t.d("AndroidTwelveNotifyClickIntentParam", "notifyArriveCallbackByUser.getIntent()   not null  ");     // Catch: Exception -> L63
        r113 = r112.getIntent();     // Catch: Exception -> L42
        r113.setSelector(null);     // Catch: Exception -> L42
        r113.setFlags(335544320);     // Catch: Exception -> L42
        Map<String, String> r106 = r111.getParams();     // Catch: Exception -> L42
        if (r106 != null) goto L26;
    L38:
        int r107 = a(r113, r100);     // Catch: Exception -> L42
        if (r107 <= 0) goto L57;
        this.f462579e = r107;     // Catch: Exception -> L42
    L26:
        if (r106.entrySet() == null) goto L38;
        Iterator<Map.Entry<String, String>> r108 = r106.entrySet().iterator();     // Catch: Exception -> L42
    L30:
        if (r108.hasNext() == false) goto L38;
        Map.Entry<String, String> r109 = r108.next();     // Catch: Exception -> L42
        if (r109 == null) goto L30;
        if (r109.getKey() == null) goto L30;
        if (r113.hasExtra(r109.getKey()) == true) goto L30;
        r113.putExtra(r109.getKey(), r109.getValue());     // Catch: Exception -> L42
    L42:
        e = move-exception;
        t.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient open activity error : ".concat(String.valueOf(r105)), e);     // Catch: Exception -> L63
        this.f462579e = 2158;     // Catch: Exception -> L63
        goto L18
    L44:
        t.d("AndroidTwelveNotifyClickIntentParam", "notifyArriveCallbackByUser.getIntent()   is null 根据skipcontent生成跳转参数 ");     // Catch: Exception -> L63
        r113 = a(r105, r100, r111, r110);     // Catch: Exception -> L63
        goto L57
    L16:
        if (r101 == 4) goto L19;
        t.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient skip type error : intent null");     // Catch: Exception -> L63
        this.f462579e = 2159;     // Catch: Exception -> L63
        goto L18
    L19:
        String r115 = r111.getSkipContent();     // Catch: Exception -> L63
        t.d("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient ：：" + r111.getSkipContent());     // Catch: Exception -> L63
        r113 = a(r115, r100, r111, r110);     // Catch: Exception -> L63
    L63:
        e = move-exception;
        t.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient parsing error : " + e.getMessage());
        this.f462579e = 2159;
        goto L65
    }

    @Override // com.vivo.push.util.b
    public final Intent a(Context r100, InsideNotificationItem r101, NotifyArriveCallbackByUser r102) {
        return b(r100, r101, r102);
    }

    private Intent a(String r100, String r101, InsideNotificationItem r102, Context r103) {
        Intent r104 = Intent.parseUri(r100, 1);     // Catch: Exception -> L8
        r104.setSelector(null);     // Catch: Exception -> L8
        r104.setPackage(r101);     // Catch: Exception -> L8
        r104.setFlags(335544320);     // Catch: Exception -> L8
        a(r104, r102.getParams());     // Catch: Exception -> L8
        int r105 = a(r104, r101);     // Catch: Exception -> L8
        if (r105 <= 0) goto L7;
        this.f462579e = r105;     // Catch: Exception -> L8
        t.c(r103, " 落地页未找到，通知不展示：  " + this.f462579e);     // Catch: Exception -> L8
        return null;
    L7:
        return r104;
    L8:
        e = move-exception;
        t.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient open activity error : ".concat(String.valueOf(r100)), e);
        this.f462579e = 2158;
        return null;
    }
}
