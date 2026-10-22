package com.bytedance.praisedialoglib.manager;

import android.app.Activity;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.praisedialoglib.googleplay.IGooglePlayDepend;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes21.dex */
public final class h {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static h f266659i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f266660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f266661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f266662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f266663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f266664e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList<String> f266665f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList<String> f266666g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList<String> f266667h;

    public class a implements x57.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f266668a;

        @Override // x57.c
        public final void a() {
            b67.a.a("evaluate_pop_show", this.f266668a);
        }

        @Override // x57.c
        public final void b() {
            b67.a.a("evaluate_pop_good", this.f266668a);
            h.c().f(false);
        }

        @Override // x57.c
        public final void c() {
            b67.a.a("evaluate_pop_bad", this.f266668a);
            h.c().getClass();
            h.e();
        }

        @Override // x57.c
        public final void onDialogDismiss() {
            b67.a.a("evaluate_pop_close", this.f266668a);
        }

        public a(String r100) {
            this.f266668a = r100;
        }
    }

    public static Uri b() {
        return UriProtector.parse(BaseConstants.MARKET_PREFIX + com.bytedance.praisedialoglib.manager.a.C3729a.f266645a.c());
    }

    public static h c() {
        h r100 = f266659i;
        if (r100 == null) goto L6;
        return r100;
    L6:
        monitor-enter(h.class);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (f266659i != null) goto L10;
        f266659i = new h();     // Catch: Throwable -> L13
    L10:
        monitor-exit(h.class);     // Catch: Throwable -> L13
        return f266659i;
    }

    public static void e() {
        com.bytedance.praisedialoglib.manager.a r100 = com.bytedance.praisedialoglib.manager.a.C3729a.f266645a;
        Application r101 = i.a.f266670a.f266669a;
        y57.a r102 = r100.f266636b;
        if (r102 == null) goto L6;
        r102.c(r101);
        return;
    }

    public h() {
        this.f266664e = "";
        this.f266660a = new Handler(Looper.getMainLooper());
        ArrayList<String> r100 = new ArrayList();
        this.f266665f = r100;
        r100.add("com.oppo.market");
        this.f266665f.add(RomUtils.MARKET_PKG_NAME_MEIZU);
        this.f266665f.add("com.tencent.android.qqdownloader");
        this.f266665f.add("com.qihoo.appstore");
        this.f266665f.add("com.baidu.appsearch");
        this.f266665f.add("com.sogou.androidtool");
        ArrayList<String> r101 = new ArrayList();
        this.f266666g = r101;
        r101.add(RomUtils.MARKET_PKG_NAME_EMUI);
        ArrayList<String> r102 = new ArrayList();
        this.f266667h = r102;
        r102.add("com.wandoujia.phoenix2");
    }

    public static void g(Activity r100) {
        Intent r101 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        r101.setData(b());
        r101.setPackage("com.android.vending");
        r101.addFlags(268435456);
        com.bytedance.praisedialoglib.manager.a.C3729a.f266645a.startActivity(r100, r101);
        b67.a.b("com.android.vending");
    }

    public final void f(boolean r110) {
        if (z57.b.f570113b == false) goto L5;
        return;
    L5:
        Application r100 = i.a.f266670a.f266669a;
        if (TextUtils.isEmpty(this.f266662c) == false) goto L10;
        y57.a r101 = com.bytedance.praisedialoglib.manager.a.C3729a.f266645a.f266636b;
        if (r101 == null) goto L10;
        r101.b();
    L10:
        boolean r102 = false;
        if (TextUtils.isEmpty(this.f266662c) == false) goto L13;
    L19:
        boolean r103 = false;
    L20:
        if (r103 == false) goto L24;
        b67.a.b(this.f266662c);
        return;
    L24:
        if (TextUtils.isEmpty(this.f266662c) == false) goto L26;
    L49:
        boolean r104 = false;
    L50:
        if (r104 == false) goto L54;
        b67.a.b(this.f266662c);
        return;
    L54:
        if (TextUtils.isEmpty(this.f266662c) == false) goto L56;
    L62:
        boolean r105 = false;
    L63:
        if (r105 == false) goto L66;
        b67.a.b(this.f266662c);
        return;
    L66:
        if (r110 == false) goto L68;
    L79:
        com.bytedance.praisedialoglib.manager.a r106 = com.bytedance.praisedialoglib.manager.a.C3729a.f266645a;
        Activity r107 = r106.d();
        if (TextUtils.isEmpty(this.f266662c) == false) goto L82;
    L102:
        boolean r108 = false;
    L103:
        if (r108 == false) goto L106;
        b67.a.b(this.f266662c);
        return;
    L106:
        com.bytedance.praisedialoglib.manager.a r109 = com.bytedance.praisedialoglib.manager.a.C3729a.f266645a;
        Activity r111 = r109.d();
        if (TextUtils.isEmpty(this.f266662c) == false) goto L109;
    L119:
        boolean r112 = false;
    L120:
        if (r112 == false) goto L123;
        b67.a.b(this.f266662c);
        return;
    L123:
        Activity r113 = r109.d();
        if (TextUtils.isEmpty(this.f266662c) == false) goto L126;
    L142:
        if (r102 == true) goto L144;
        Intent r114 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        r114.setData(b());
        if (TextUtils.isEmpty(this.f266662c) == true) goto L153;
        r114.setPackage(this.f266662c);
    L153:
        boolean r115 = a(r114, r100);
        if (r115 == false) goto L156;
    L159:
        if (r115 == true) goto L165;
        r114.setPackage(null);
        if (a(r114, r100) == true) goto L165;
        e();
        return;
    L165:
        if (this.f266663d == 1) goto L167;
    L169:
        r114.addFlags(268435456);
        com.bytedance.praisedialoglib.manager.a.C3729a.f266645a.startActivity(r100, r114);
        b67.a.b(this.f266662c);
        return;
    L167:
        if (TextUtils.isEmpty(this.f266664e) == true) goto L169;
        Toast.makeText(r100, this.f266664e, 1).show();
        goto L169
    L156:
        if (TextUtils.isEmpty(this.f266662c) == false) goto L159;
        e();
        return;
    L144:
        if (this.f266663d == 1) goto L146;
    L148:
        b67.a.b(this.f266662c);
        return;
    L146:
        if (TextUtils.isEmpty(this.f266664e) == true) goto L148;
        Toast.makeText(r100, this.f266664e, 1).show();
        goto L148
    L126:
        if (this.f266662c.equalsIgnoreCase(RomUtils.MARKET_PKG_NAME_EMUI) == false) goto L142;
        y57.a r116 = r109.f266636b;
        String r117 = "C109089785";
        if (r116 == null) goto L130;
        r116.d();
        CharSequence r118 = "C109089785";
    L132:
        if (TextUtils.isEmpty(r118) == true) goto L142;
        StringBuilder r119 = new StringBuilder("hiapplink://com.huawei.appmarket?appId=");
        y57.a r120 = r109.f266636b;
        if (r120 == null) goto L136;
        r120.d();
    L137:
        r119.append(r117);
        r119.append("&channelId=share&callType=SHARE");
        Intent r121 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(r119.toString()));
        r121.setFlags(268435456);
        r121.addCategory("android.intent.category.BROWSABLE");
        r121.setPackage(RomUtils.MARKET_PKG_NAME_EMUI);
        r109.startActivity(r113, r121);     // Catch: ActivityNotFoundException -> L140
        r102 = true;
    L140:
        e = move-exception;
        e.getLocalizedMessage();
        goto L142
    L136:
        r117 = null;
        goto L137
    L130:
        r118 = null;
        goto L132
    L109:
        if (this.f266662c.equalsIgnoreCase("com.android.vending") == false) goto L119;
        if (b67.b.a(r111, "com.android.vending") == false) goto L119;
        if (b67.b.a(r111, "com.google.android.gms") == false) goto L119;
        IGooglePlayDepend r122 = DependManager.getGooglePlayDepend();
        if (r122 == null) goto L117;
        r122.showInAppPraiseDialogForGp(r111, new e(this, r111));
    L118:
        r112 = true;
        goto L120
    L117:
        g(r111);
        goto L118
    L82:
        if (this.f266662c.equalsIgnoreCase("com.oppo.market") == false) goto L84;
    L85:
        Activity r123 = r106.d();
        if (r123 == null) goto L94;
        String r124 = "oaps://mk/developer/comment?pkg=" + r106.c();
        if (d(r123, RomUtils.MARKET_PKG_NAME_OPPO1) <= 84000) goto L92;
        boolean r125 = h(r123, UriProtector.parse(r124), RomUtils.MARKET_PKG_NAME_OPPO1);
    L95:
        if (r125 == true) goto L99;
        Intent r126 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, b());
        r126.addCategory("android.intent.category.DEFAULT");
        r126.setPackage(this.f266662c);
        r106.startActivityForResult(r107, r126);     // Catch: ActivityNotFoundException -> L100
    L100:
        e = move-exception;
        e.toString();
        e.printStackTrace();
    L99:
        r108 = true;
        goto L103
    L92:
        if (d(r123, "com.oppo.market") <= 84000) goto L94;
        r125 = h(r123, UriProtector.parse(r124), "com.oppo.market");
    L94:
        r125 = false;
        goto L95
    L84:
        if (this.f266662c.equalsIgnoreCase(RomUtils.MARKET_PKG_NAME_OPPO1) == false) goto L102;
    L68:
        if (TextUtils.isEmpty(this.f266662c) == false) goto L70;
    L76:
        boolean r127 = false;
    L77:
        if (r127 == false) goto L79;
        return;
    L70:
        if (this.f266662c.equalsIgnoreCase(RomUtils.MARKET_PKG_NAME_MIUI) == false) goto L76;
        z57.b.f570113b = true;
        com.bytedance.praisedialoglib.manager.a r128 = com.bytedance.praisedialoglib.manager.a.C3729a.f266645a;
        z57.b r129 = new z57.b(new d(this, r100));
        y57.b r130 = r128.f266639e;
        if (r130 == null) goto L74;
        r130.execute(r129);
    L75:
        r127 = true;
        goto L77
    L74:
        w57.c.f558353a.submit(r129);
        goto L75
    L56:
        if (this.f266662c.equalsIgnoreCase(RomUtils.MARKET_PKG_NAME_MAGICUI) == false) goto L62;
        StringBuilder r131 = new StringBuilder("honormarket://details?id=");
        com.bytedance.praisedialoglib.manager.a r132 = com.bytedance.praisedialoglib.manager.a.C3729a.f266645a;
        r131.append(r132.c());
        Intent r133 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(r131.toString()));
        r133.setFlags(268435456);
        r133.setPackage(RomUtils.MARKET_PKG_NAME_MAGICUI);
        r132.startActivity(r100, r133);     // Catch: ActivityNotFoundException -> L60
        r105 = true;
    L60:
        e = move-exception;
        e.printStackTrace();
        goto L62
    L26:
        if (this.f266662c.equalsIgnoreCase(RomUtils.MARKET_PKG_NAME_VIVO) == false) goto L49;
        Uri r134 = b();
        if (r100 != null) goto L175;
    L41:
        boolean r135 = false;
    L42:
        if (r135 == false) goto L44;
        r134 = UriProtector.parse(BaseConstants.MARKET_PREFIX + com.bytedance.praisedialoglib.manager.a.C3729a.f266645a.c() + "&th_name=need_comment");
    L44:
        Intent r136 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, r134);
        r136.setFlags(268435456);
        r136.setPackage(RomUtils.MARKET_PKG_NAME_VIVO);
        com.bytedance.praisedialoglib.manager.a.C3729a.f266645a.startActivity(r100, r136);     // Catch: ActivityNotFoundException -> L47
        r104 = true;
    L47:
        e = move-exception;
        e.printStackTrace();
        goto L49
    L175:
        PackageInfo r137 = r100.getPackageManager().getPackageInfo(RomUtils.MARKET_PKG_NAME_VIVO, 0);     // Catch: Exception -> L40
        int r138 = r137.versionCode;     // Catch: Exception -> L40
        if (Build.VERSION.SDK_INT < 28) goto L34;
        long r139 = r137.getLongVersionCode();     // Catch: Exception -> L40
        r137.getLongVersionCode();     // Catch: Exception -> L40
    L36:
        if (r138 < 5020) goto L38;
    L39:
        r135 = true;
        goto L42
    L38:
        if (((int) r139) < 5020) goto L41;
    L34:
        r139 = 0;
        goto L36
    L13:
        if (this.f266662c.equalsIgnoreCase(RomUtils.MARKET_PKG_NAME_SAMSUNG) == false) goto L19;
        StringBuilder r140 = new StringBuilder("samsungapps://ProductDetail/");
        com.bytedance.praisedialoglib.manager.a r141 = com.bytedance.praisedialoglib.manager.a.C3729a.f266645a;
        r140.append(r141.c());
        Intent r142 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(r140.toString()));
        r142.setPackage(RomUtils.MARKET_PKG_NAME_SAMSUNG);
        r142.addFlags(268435456);
        r141.startActivity(r100, r142);     // Catch: ActivityNotFoundException -> L17
        r103 = true;
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    public static boolean a(Intent r100, Context r101) {
        List<ResolveInfo> r102 = r101.getPackageManager().queryIntentActivities(r100, 65536);     // Catch: Throwable -> L9
        if (r102 == null) goto L14;
        if (r102.size() <= 0) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    L9:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public static long d(Activity r100, String r101) {
        PackageInfo r102 = r100.getPackageManager().getPackageInfo(r101, 128);     // Catch: PackageManager.NameNotFoundException -> L9
        if (r102 == null) goto L11;
        long r103 = -1;
    L13:
        return r103;
    L5:
        if (Build.VERSION.SDK_INT < 28) goto L8;
        r103 = r102.getLongVersionCode();     // Catch: PackageManager.NameNotFoundException -> L9
        goto L13
    L8:
        r103 = r102.versionCode;     // Catch: PackageManager.NameNotFoundException -> L9
    L9:
        e = move-exception;
        e.toString();
    L11:
        r103 = -1;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i(Context r100, String r101) {
        this.f266662c = "";
        String r102 = com.bytedance.praisedialoglib.manager.a.C3729a.f266645a.f266640f;
        this.f266661b = r102;
        if (TextUtils.isEmpty(r102) == true) goto L29;
        String[] r103 = this.f266661b.split("\\|");
        int r104 = r103.length;
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L11;
        String r106 = r103[r105];
        if (b67.b.a(r100, r106) == true) goto L9;
        r105 = r105 + 1;
        goto L6
    L9:
        this.f266662c = r106;
    L11:
        this.f266663d = 0;
        com.bytedance.praisedialoglib.manager.a r107 = com.bytedance.praisedialoglib.manager.a.C3729a.f266645a;
        if (r107.b() == null) goto L17;
        if (r107.b().contains(this.f266662c) == false) goto L17;
        this.f266663d = 2;
    L17:
        if (r107.a() == null) goto L29;
        if (r107.a().contains(this.f266662c) == false) goto L29;
        this.f266663d = 1;
        if (this.f266665f.contains(this.f266662c) == false) goto L24;
        this.f266664e = "点击进入「评论」页后发表好评";
        goto L29
    L24:
        if (this.f266666g.contains(this.f266662c) == false) goto L27;
        this.f266664e = "点击页面右下角按钮发表好评";
        goto L29
    L27:
        if (this.f266667h.contains(this.f266662c) == false) goto L29;
        this.f266664e = "点击进入「评价」页后发表好评";
    L29:
        com.bytedance.praisedialoglib.manager.a r108 = com.bytedance.praisedialoglib.manager.a.C3729a.f266645a;
        y57.a r109 = r108.f266636b;
        if (r109 == null) goto L33;
        r109.a();
    L33:
        if ((r100 instanceof x57.a) == false) goto L35;
        ((x57.a) r100).a();
        return;
    L35:
        x57.b r110 = r108.f266644j;
        if (r110 == null) goto L42;
        r110.a(new a(r101));
        return;
    }

    public static boolean h(Activity r100, Uri r101, String r102) {
        Intent r103 = new Intent();     // Catch: Throwable -> L5
        r103.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);     // Catch: Throwable -> L5
        r103.addCategory("android.intent.category.DEFAULT");     // Catch: Throwable -> L5
        r103.setPackage(r102);     // Catch: Throwable -> L5
        r103.setData(r101);     // Catch: Throwable -> L5
        com.bytedance.praisedialoglib.manager.a.C3729a.f266645a.startActivityForResult(r100, r103);     // Catch: Throwable -> L5
        Objects.toString(r101);     // Catch: Throwable -> L5
        return true;
    L5:
        th = move-exception;
        th.toString();
        return false;
    }
}
