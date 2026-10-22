package s37;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.android.service.manager.push.notification.NotificationBody;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.common.push.BaseJson;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.notification.extra.PushNotificationExtra;
import com.bytedance.push.utils.i;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public abstract class a extends BaseJson implements t37.a, View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f540480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Intent f540481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PushNotificationExtra f540482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NotificationBody f540483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f540484e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f540485f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f540486g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f540487h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f540488i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f540489j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f540490k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f540491l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final HandlerC7562a f540492m;

    /* JADX INFO: renamed from: s37.a$a, reason: collision with other inner class name */
    public class HandlerC7562a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f540493a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            super.handleMessage(r100);
            this.f540493a.d(r100);
        }

        public HandlerC7562a(a r100, Looper r101) {
            this.f540493a = r100;
            super(r101);
        }
    }

    public abstract void c(boolean r100, int r101);

    public abstract void d(Message r100);

    public abstract void f(String r100, int r101);

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        if (r101.getAction() != 0) goto L6;
        this.f540488i = r101.getX();
        this.f540490k = r101.getY();
    L6:
        if (r101.getAction() != 1) goto L22;
        this.f540489j = r101.getX();
        float r102 = r101.getY();
        if ((this.f540490k - r102) <= 50.0f) goto L10;
        com.bytedance.push.utils.f.b("IBannerNotification", "监听到上划");
        this.f540491l = true;
        String r103 = "up";
        int r104 = R.anim.banner_out_to_top;
    L18:
        if (this.f540491l == false) goto L23;
        com.bytedance.push.utils.f.b("IBannerNotification", "监听到滑动，消除弹窗");
        c(true, r104);
        JSONObject r105 = new JSONObject();
        add(r105, "clear_position", "banner");
        add(r105, "clear_type", "slide");
        add(r105, "slide_direction", r103);
        PushServiceManager.get().getPushExternalService().onNotificationDelete(this.f540483d.f164103id, r105);
        return false;
    L23:
        return false;
    L10:
        float r106 = this.f540488i;
        float r107 = this.f540489j;
        if ((r106 - r107) <= 50.0f) goto L14;
        com.bytedance.push.utils.f.b("IBannerNotification", "监听到左划");
        this.f540491l = true;
        r103 = "left";
        r104 = R.anim.banner_out_to_left;
        goto L18
    L14:
        if ((r107 - r106) <= 50.0f) goto L16;
        com.bytedance.push.utils.f.b("IBannerNotification", "监听到右划");
        this.f540491l = true;
        r103 = "right";
        r104 = R.anim.banner_out_to_right;
        goto L18
    L16:
        r103 = "";
        r104 = -1;
        goto L18
    L22:
        return false;
    }

    public static void b(a r100, boolean r101, String r102) {
        r100.getClass();
        x37.b.a("IBannerNotification", "startTargetActivityWithBannerNotificationResult: startSuccess is " + r101 + " errMsg is " + r102);
        r100.f540482c.getClass();
    }

    public static void e(View r100, int r101, int r102) {
        TextView r103 = (TextView) r100.findViewById(r101);     // Catch: Throwable -> L6
        if (r103 == null) goto L9;
        r103.setTextColor(r102);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public a(Context r110, Notification.Builder r210, Intent r211, PushNotificationExtra r212, NotificationBody r213) {
        this.f540488i = 0.0f;
        this.f540489j = 0.0f;
        this.f540490k = 0.0f;
        this.f540491l = false;
        this.f540492m = new HandlerC7562a(this, Looper.getMainLooper());
        this.f540480a = r110;
        this.f540481b = r211;
        this.f540482c = r212;
        this.f540483d = r213;
        RemoteViews r100 = r210.build().contentView;
        if (r100 == null) goto L6;
    L8:
        View r101 = r100.apply(r110.getApplicationContext(), new FrameLayout(r110.getApplicationContext()));
        LayoutInflater r102 = (LayoutInflater) r110.getSystemService("layout_inflater");
        FrameLayout r103 = (FrameLayout) r102.inflate(R.layout.highlight_banner_parent, null);
        r103.addView(r101);
        ImageView r104 = (ImageView) r101.findViewById(Resources.getSystem().getIdentifier("icon", "id", "android"));
        if (r104 == null) goto L11;
        r104.setImageBitmap(r213.iconBitmap);
    L11:
        i r105 = i.c();
        r105.getClass();
        if (TextUtils.isEmpty(r105.f267076f) == false) goto L17;
        r105.f267076f = r105.b("ro.build.version.opporom");     // Catch: Throwable -> L15
    L17:
        if ((!TextUtils.isEmpty(r105.f267076f)) == false) goto L33;
        if (r105.f267072b == (-1.0d)) goto L22;
    L29:
        if (r105.f267072b < 7.0d) goto L33;
        boolean r106 = true;
    L35:
        if (r106 == false) goto L38;
        View r107 = r101.findViewById(Resources.getSystem().getIdentifier("notification_header", "id", "android"));
        ((ViewGroup) r107.getParent()).removeView(r107);
        View r108 = r101.findViewById(Resources.getSystem().getIdentifier("notification_main_column", "id", "android"));
        FrameLayout.LayoutParams r109 = (FrameLayout.LayoutParams) r108.getLayoutParams();
        r109.topMargin = r109.bottomMargin;
        r108.setLayoutParams(r109);
        LinearLayout r111 = (LinearLayout) r101.findViewById(Resources.getSystem().getIdentifier("right_icon_container", "id", "android"));
        FrameLayout.LayoutParams r112 = (FrameLayout.LayoutParams) r111.getLayoutParams();
        r112.height = -1;
        r111.setVerticalGravity(16);
        r112.topMargin = 0;
        r112.bottomMargin = 0;
        r111.setLayoutParams(r112);
        ImageView r113 = (ImageView) r101.findViewById(Resources.getSystem().getIdentifier("right_icon", "id", "android"));
        LinearLayout.LayoutParams r114 = (LinearLayout.LayoutParams) r113.getLayoutParams();
        r114.gravity = 17;
        r114.topMargin = 0;
        r114.bottomMargin = 0;
        r113.setPadding(0, 0, 0, 0);
        r113.setLayoutParams(r114);
    L94:
        float r115 = 30.0f;
    L96:
        if (this.f540482c.f266059s == 0) goto L104;
        if (i.c().g() == true) goto L100;
        e(r103, Resources.getSystem().getIdentifier("app_name_text", "id", "android"), this.f540482c.f266059s);
        e(r103, Resources.getSystem().getIdentifier("time_divider", "id", "android"), this.f540482c.f266059s);
        e(r103, Resources.getSystem().getIdentifier("time", "id", "android"), this.f540482c.f266059s);
        goto L104
    L100:
        if (i.c().i() == true) goto L104;
        e(r103, Resources.getSystem().getIdentifier("sub_time_divider", "id", DimLocationCheckUtil.VIVO), this.f540482c.f266059s);
        e(r103, Resources.getSystem().getIdentifier("sub_time", "id", DimLocationCheckUtil.VIVO), this.f540482c.f266059s);
    L104:
        if (this.f540482c.f266060t == 0) goto L107;
        e(r103, Resources.getSystem().getIdentifier("title", "id", "android"), this.f540482c.f266060t);
    L107:
        if (this.f540482c.f266061u == 0) goto L109;
        e(r103, Resources.getSystem().getIdentifier("text", "id", "android"), this.f540482c.f266061u);
    L109:
        WindowManager r116 = (WindowManager) this.f540480a.getApplicationContext().getSystemService(LiveEndPageData.TAG_WINDOW);
        r116.getDefaultDisplay().getSize(new Point());
        this.f540487h = ifc.b.a(this.f540480a, 8.0f);
        Resources r117 = this.f540480a.getResources();
        int r118 = WindowDisplayMetricsOverride.apply(r117, r117.getDisplayMetrics()).widthPixels - ifc.b.a(this.f540480a, 10.0f);
        FrameLayout.LayoutParams r119 = (FrameLayout.LayoutParams) r101.getLayoutParams();
        r119.width = r118;
        r119.gravity = 1;
        r101.setLayoutParams(r119);
        r101.setOutlineProvider(new b(r115));
        r101.setClipToOutline(true);
        PushNotificationExtra r120 = this.f540482c;
        if (r120.f266057q == true) goto L112;
    L114:
        boolean r121 = false;
    L115:
        this.f540484e = r103;
        r103.setOnClickListener(new c(this));
        this.f540488i = 0.0f;
        this.f540490k = 0.0f;
        this.f540489j = 0.0f;
        this.f540491l = r121;
        r103.setOnTouchListener(this);
        return;
    L112:
        if (r120.f266048h == null) goto L114;
        FrameLayout r122 = (FrameLayout) r102.inflate(R.layout.highlight_notification_image_back, null);
        ((ImageView) r122.findViewById(R.id.notification_background_img)).setImageBitmap(this.f540482c.f266048h);
        r121 = false;
        ((ViewGroup) r103.findViewById(Resources.getSystem().getIdentifier("status_bar_latest_event_content", "id", "android"))).addView(r122, 0);
        goto L115
    L38:
        if (i.c().g() == false) goto L49;
        if (i.c().i() == false) goto L94;
        View r123 = r103.findViewById(R.id.push_notification_logo_and_name_layout);
        FrameLayout.LayoutParams r124 = (FrameLayout.LayoutParams) r101.findViewById(Resources.getSystem().getIdentifier("notification_main_column", "id", "android")).getLayoutParams();
        ((ImageView) r103.findViewById(R.id.push_notification_small_icon)).setImageBitmap(this.f540483d.iconBitmap);
        TextView r125 = (TextView) r103.findViewById(R.id.push_notification_app_name);
        r125.setText(this.f540483d.appName);
        int r126 = this.f540482c.f266060t;
        if (r126 == 0) goto L44;
        r125.setTextColor(r126);
    L44:
        LinearLayout.LayoutParams r127 = (LinearLayout.LayoutParams) r123.getLayoutParams();
        r127.leftMargin = r124.leftMargin;
        int r128 = r124.topMargin;
        r127.topMargin = r128;
        if (r128 != 0) goto L47;
        r127.topMargin = ifc.b.a(this.f540480a, 10.0f);
    L47:
        r123.setLayoutParams(r127);
        r123.setVisibility(0);
        goto L94
    L49:
        if (i.c().f() == false) goto L79;
        if (i.c().h() == false) goto L57;
        View r129 = r103.findViewById(Resources.getSystem().getIdentifier("notification_header", "id", "android"));
        r129.setPadding(r129.getPaddingLeft(), 0, r129.getPaddingRight(), 0);
        View r130 = r129.findViewById(Resources.getSystem().getIdentifier("icon", "id", "android"));
        if (r130 == null) goto L77;
        ImageView r131 = (ImageView) r130;
        if (Build.VERSION.SDK_INT < 23) goto L77;
        r131.setImageIcon(Icon.createWithResource(this.f540480a, R.drawable.status_icon));
    L77:
        r115 = 15.0f;
        goto L96
    L57:
        i r132 = i.c();
        if (r132.f() == true) goto L119;
    L74:
        boolean r133 = false;
    L75:
        if (r133 == false) goto L77;
        r101.setPadding(ifc.b.a(this.f540480a, 5.0f), 0, 0, 0);
        goto L77
    L119:
        if (r132.f267071a == (-1.0d)) goto L63;
    L69:
        if (r132.f267071a >= 5.0d) goto L74;
        r133 = true;
        goto L75
    L63:
        if (TextUtils.isEmpty(r132.f267078h) == true) goto L74;
        String r134 = r132.f267078h;     // Catch: Throwable -> L73
        String r135 = r134.substring(r134.indexOf("_") + 1);     // Catch: Throwable -> L73
        if (r135.indexOf(".") <= 0) goto L68;
        r135 = r135.substring(0, r135.indexOf("."));     // Catch: Throwable -> L73
    L68:
        r132.f267071a = CastDoubleProtector.parseDouble(r135);     // Catch: Throwable -> L73
        goto L69
    L79:
        if (i.c().j() == false) goto L94;
        ViewGroup r136 = (ViewGroup) r101.findViewById(Resources.getSystem().getIdentifier("notification_header", "id", "android"));
        if (r136 == null) goto L91;
        int r137 = Resources.getSystem().getIdentifier("app_name_text", "id", "android");
        int r138 = Resources.getSystem().getIdentifier("time_divider", "id", "android");
        int r139 = Resources.getSystem().getIdentifier("time", "id", "android");
        View r140 = r136.findViewById(r137);
        if (r140 == null) goto L85;
        r136.removeView(r140);
    L85:
        View r141 = r136.findViewById(r138);
        if (r141 == null) goto L88;
        r136.removeView(r141);
    L88:
        View r142 = r136.findViewById(r139);
        if (r142 == null) goto L91;
        r136.removeView(r142);
    L91:
        r103.setPadding(r101.getPaddingLeft(), ifc.b.a(this.f540480a, 13.0f), r101.getPaddingRight(), ifc.b.a(this.f540480a, 13.0f));
        r101.setBackgroundColor(this.f540482c.f266058r);
        View r143 = r101.findViewById(R.id.push_inner_layout);
        if (r143 == null) goto L94;
        r143.setBackgroundColor(this.f540482c.f266058r);
        goto L94
    L22:
        if (TextUtils.isEmpty(r105.f267076f) == true) goto L29;
        if (r105.f267076f.length() < 2) goto L29;
        String r144 = r105.f267076f.substring(1);     // Catch: Throwable -> L15
        if (r144.indexOf(".") <= 0) goto L28;
        r144 = r144.substring(0, r144.indexOf("."));     // Catch: Throwable -> L15
    L28:
        r105.f267072b = CastDoubleProtector.parseDouble(r144);     // Catch: Throwable -> L15
    L33:
        r106 = false;
        goto L35
    L6:
        if (Build.VERSION.SDK_INT < 24) goto L121;
        r100 = r210.createContentView();
        goto L8
    }
}
