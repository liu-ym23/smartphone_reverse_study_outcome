package com.larus.push.impl;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.push.PushBody;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.common.apphost.AppHost;
import com.larus.deeplink.api.IDeeplinkService;
import com.larus.nova.R;
import com.larus.platform.service.i3;
import com.larus.utils.k0;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements v67.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f367094a;

    public static final class a {
    }

    static {
    }

    public final Bitmap a() {
        AppHost.Companion r100 = AppHost.f326268a;     // Catch: PackageManager.NameNotFoundException -> L4
        ApplicationInfo r101 = r100.getApplication().getApplicationInfo();     // Catch: PackageManager.NameNotFoundException -> L4
        return d(this, r100.getApplication().getPackageManager().getApplicationIcon(r101));
    L4:
        e = move-exception;
        FLogger.f375446a.e("CustomNotificationBuilder", e.getMessage());
        return null;
    }

    public g() {
        this.f367094a = LazyKt.lazy(new f());
    }

    public final void b(NotificationCompat.Builder r100) {
        Bitmap r101 = a();
        if (r101 != null) goto L5;
        r101 = BitmapFactory.decodeResource(AppHost.f326268a.getApplication().getApplicationContext().getResources(), R.drawable.larus_ic_push_large_icon);
    L5:
        r100.setLargeIcon(r101);
    }

    public static Bitmap d(g r100, Drawable r101) {
        int r102 = r101.getIntrinsicWidth();
        int r103 = r101.getIntrinsicHeight();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "<this>");
        boolean r104 = r101 instanceof BitmapDrawable;
        if (r104 == true) goto L5;
    L7:
        Intrinsics.checkNotNullParameter(r101, "<this>");
        if (r104 == false) goto L19;
        BitmapDrawable r105 = (BitmapDrawable) r101;
        if (r105.getBitmap() == null) goto L18;
        if (r102 != r105.getBitmap().getWidth()) goto L23;
        if (r103 != r105.getBitmap().getHeight()) goto L23;
        return r105.getBitmap();
    L23:
        return Bitmap.createScaledBitmap(r105.getBitmap(), r102, r103, true);
    L18:
        throw new IllegalArgumentException("bitmap is null");
    L19:
        int r106 = r101.getBounds().left;
        int r107 = r101.getBounds().top;
        int r108 = r101.getBounds().right;
        int r109 = r101.getBounds().bottom;
        Bitmap r110 = Bitmap.createBitmap(r102, r103, Bitmap.Config.ARGB_8888);
        r101.setBounds(0, 0, r102, r103);
        r101.draw(new Canvas(r110));
        r101.setBounds(r106, r107, r108, r109);
        return r110;
    L5:
        if (((BitmapDrawable) r101).getBitmap() != null) goto L7;
        return null;
    }

    @Override // v67.d
    public final Notification c(int r110, PushBody r111, Bitmap r112) {
        String r100 = null;
        if (r111 == null) goto L7;
        String r101 = r111.f266723l;
        if (r101 == null) goto L7;
        String r102 = StringsKt.replace$default(r101, "\\n", "\n", false, 4, null);
    L8:
        AppHost.Companion r103 = AppHost.f326268a;
        NotificationCompat.Builder r104 = new NotificationCompat.Builder(r103.getApplication(), "push");
        Context r105 = r103.getApplication().getApplicationContext();
        if (r111 == null) goto L11;
        String r106 = r111.f266727p;
    L12:
        Uri r107 = UriProtector.parse(r106).buildUpon().appendQueryParameter("is_from_push", "true").appendQueryParameter("is_from_custom_push", "true").build();
        Intrinsics.checkNotNull(r105);
        Intrinsics.checkNotNull(r107);
        IDeeplinkService r108 = (IDeeplinkService) this.f367094a.getValue();
        if (r108 == null) goto L15;
        Class<? extends Activity> r109 = r108.e();
    L16:
        int r113 = k0.f375428a;
        if (Intrinsics.areEqual(k0.a(r107.toString()), "//flow/fake_push_route") == false) goto L20;
        if (r109 == null) goto L20;
        Intent r114 = new Intent(r105, r109);
        r114.setFlags(268435456);
    L24:
        if (r114 == null) goto L26;
        r114.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
    L26:
        if (r114 == null) goto L33;
        if (r111 == null) goto L31;
        JSONObject r115 = r111.f266722k;
        if (r115 == null) goto L31;
        String r116 = r115.toString();
    L32:
        r114.putExtra("push_body", r116);
    L31:
        r116 = null;
    L33:
        if (r114 == null) goto L35;
        r114.putExtra("flow_push_message_from", r110);
    L35:
        if (r114 == null) goto L37;
        r114.putExtra("is_tourist_mode", i3.f365750a.f());
    L37:
        if (r114 == null) goto L39;
        r114.setPackage(r103.getApplication().getPackageName());
    L39:
        if (r114 == null) goto L41;
        r114.setData(r107);
    L41:
        if (r111 == null) goto L44;
        r110 = (int) r111.f266713b;
    L44:
        if (Build.VERSION.SDK_INT < 23) goto L46;
        int r117 = 201326592;
    L47:
        NotificationCompat.Builder r118 = r104.setContentIntent(PendingIntent.getActivity(r105, r110, r114, r117));
        if (r111 == null) goto L50;
        String r119 = r111.f266715d;
    L51:
        NotificationCompat.Builder r120 = r118.setGroup(r119).setAutoCancel(true).setSmallIcon(R.drawable.larus_ic_push_small_icon_svg);
        if (r111 == null) goto L54;
        r100 = r111.f266724m;
    L54:
        NotificationCompat.Builder r121 = r120.setContentTitle(r100).setContentText(r102);
        if (r111 != null) goto L57;
    L59:
        boolean r122 = false;
    L60:
        NotificationCompat.Builder r123 = r121.setShowWhen(r122);
        if (r112 == null) goto L78;
        if (r111 == null) goto L78;
        int r124 = r111.f266726o;
        if (r124 != 1) goto L67;
    L74:
        Bitmap r125 = a();
        if (r125 != null) goto L77;
        r125 = BitmapFactory.decodeResource(r103.getApplication().getApplicationContext().getResources(), R.drawable.larus_ic_push_large_icon);
    L77:
        r123.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(r112).bigLargeIcon(r125)).setLargeIcon(r112);
    L80:
        return r123.build();
    L67:
        if (r124 != 2) goto L69;
    L73:
        r123.setLargeIcon(r112);
        goto L80
    L69:
        if (r124 == 3) goto L74;
        if (r124 == 4) goto L73;
        b(r123);
    L78:
        b(r123);
        goto L80
    L57:
        if (r111.f266716e != true) goto L59;
        r122 = true;
        goto L60
    L50:
        r119 = null;
        goto L51
    L46:
        r117 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
    L20:
        r114 = r103.getApplication().getPackageManager().getLaunchIntentForPackage(r103.getApplication().getPackageName());
        if (r114 == null) goto L23;
        r114.addFlags(872415232);
        goto L24
    L23:
        r114 = null;
        goto L24
    L15:
        r109 = null;
        goto L16
    L11:
        r106 = null;
    L7:
        r102 = null;
        goto L8
    }
}
