package eo7;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import java.util.LinkedList;
import jn7.c;
import jn7.d;
import jn7.e;
import jn7.f;
import jn7.g;
import jn7.h;
import jn7.i;
import jn7.j;
import jn7.k;
import jn7.l;
import jn7.m;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f473327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f473328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f473329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i f473330d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public jn7.b f473331e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public jn7.a f473332f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public h f473333g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f473334h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f473335i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public l f473336j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public JSONObject f473337k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public JSONObject f473338l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f473339m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f473340n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f473341o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f473342p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f473343q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f473344r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f473345s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f473346t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f473347u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f473348v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f473349w;

    /* JADX INFO: renamed from: eo7.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes22.dex */
    public class C5797a implements in7.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ in7.a f473350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f473351b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f473352c;

        @Override // in7.a
        public final void onFailed() {
            in7.a r100 = this.f473350a;
            if (r100 == null) goto L5;
            r100.onFailed();
        L5:
            go7.a.e(1, this.f473351b, System.currentTimeMillis() - this.f473352c);
        }

        @Override // in7.a
        public final void onSuccess(Bitmap r100) {
            if (r100 != null) goto L4;
        L11:
            in7.a r101 = this.f473350a;
            if (r101 == null) goto L14;
            r101.onFailed();
        L14:
            go7.a.e(1, this.f473351b, System.currentTimeMillis() - this.f473352c);
            return;
        L4:
            if (r100.isRecycled() == true) goto L11;
            in7.a r102 = this.f473350a;
            if (r102 == null) goto L9;
            r102.onSuccess(r100);
        L9:
            go7.a.e(0, this.f473351b, System.currentTimeMillis() - this.f473352c);
        }

        public C5797a(in7.a r100, String r101, long r102) {
            this.f473350a = r100;
            this.f473351b = r101;
            this.f473352c = r102;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f473353a = null;

        static {
            f473353a = new a();
        }
    }

    public static f e() {
        if (com.bytedance.ug.sdk.share.impl.manager.b.f272319e == true) goto L5;
        f r100 = null;
    L12:
        if (r100 == null) goto L14;
        return r100;
    L14:
        return null;
    L5:
        r100 = com.bytedance.ug.sdk.share.impl.manager.b.f272320f;
        if (r100 != null) goto L12;
        com.bytedance.ug.sdk.share.impl.manager.b.f272320f = (f) com.bytedance.ug.sdk.share.impl.manager.b.a("com.bytedance.ug.sdk.share.keep.impl.ImageTokenConfigImpl").newInstance();     // Catch: Throwable -> L10
    L11:
        r100 = com.bytedance.ug.sdk.share.impl.manager.b.f272320f;
    L10:
        com.bytedance.ug.sdk.share.impl.manager.b.f272319e = false;
        goto L11
    }

    public static k g() {
        if (com.bytedance.ug.sdk.share.impl.manager.b.f272317c == true) goto L5;
        k r100 = null;
    L12:
        if (r100 == null) goto L14;
        return r100;
    L14:
        return null;
    L5:
        r100 = com.bytedance.ug.sdk.share.impl.manager.b.f272316b;
        if (r100 != null) goto L12;
        com.bytedance.ug.sdk.share.impl.manager.b.f272316b = (k) com.bytedance.ug.sdk.share.impl.manager.b.a("com.bytedance.ug.sdk.share.keep.impl.QrScanConfigImpl").newInstance();     // Catch: Throwable -> L10
    L11:
        r100 = com.bytedance.ug.sdk.share.impl.manager.b.f272316b;
    L10:
        com.bytedance.ug.sdk.share.impl.manager.b.f272317c = false;
        goto L11
    }

    public static m i() {
        m r100 = com.bytedance.ug.sdk.share.impl.manager.b.f272318d;
        if (r100 == null) goto L14;
    L10:
        if (r100 == null) goto L12;
        return r100;
    L12:
        return null;
    L14:
        com.bytedance.ug.sdk.share.impl.manager.b.f272318d = (m) com.bytedance.ug.sdk.share.impl.manager.b.a("com.bytedance.ug.sdk.share.keep.impl.VideoWatermarkConfigImpl").newInstance();     // Catch: Throwable -> L7
    L9:
        r100 = com.bytedance.ug.sdk.share.impl.manager.b.f272318d;
    L7:
        th = move-exception;
        th.printStackTrace();
        goto L9
    }

    public final Activity h() {
        LinkedList<Activity> r100 = oo7.b.f524618a;
        if (r100.isEmpty() == false) goto L5;
        Activity r101 = null;
    L6:
        if (r101 != null) goto L11;
        h r102 = this.f473333g;
        if (r102 != null) goto L10;
        return r101;
    L10:
        return r102.getTopActivity();
    L11:
        return r101;
    L5:
        r101 = r100.getLast();
        goto L6
    }

    public a() {
        this.f473342p = true;
        this.f473343q = true;
        this.f473344r = true;
        this.f473345s = true;
        this.f473346t = true;
        this.f473347u = true;
        this.f473348v = false;
        this.f473349w = false;
    }

    public final mn7.a b(Activity r100) {
        l r101 = this.f473336j;
        if (r101 == null) goto L7;
        lw9.l r102 = r101.k(r100);
        if (r102 == null) goto L7;
        return r102;
    L7:
        l r103 = com.bytedance.ug.sdk.share.impl.manager.b.c();
        if (r103 != null) goto L10;
        return null;
    L10:
        return r103.k(r100);
    }

    public final String f(String r100) {
    L12:
        th = move-exception;
        th.printStackTrace();
        return null;
    L3:
        if (this.f473338l != null) goto L7;
        g r101 = this.f473329c;     // Catch: Throwable -> L12
        if (r101 == null) goto L7;
        this.f473338l = r101.getKeys();     // Catch: Throwable -> L12
    L7:
        JSONObject r102 = this.f473338l;     // Catch: Throwable -> L12
        if (r102 == null) goto L18;
        String r103 = r102.optString(r100);     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r103) == true) goto L19;
        return r103;
    L19:
        return null;
    L18:
        return null;
    }

    public final boolean j(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        JSONArray r101 = (JSONArray) c("disable_token_activities", null);
        if (r101 != null) goto L8;
    L20:
        return false;
    L8:
        if (r101.length() == 0) goto L20;
        int r102 = 0;
    L12:
        if (r102 >= r101.length()) goto L20;
        if (r100.equals(JSONArrayProtectorUtils.getString(r101, r102)) == false) goto L19;
        return true;
    L19:
        r102 = r102 + 1;
    L17:
        e = move-exception;
        oo7.k.b(e.toString());
        goto L19
    }

    public final Object c(String r100, Object r101) {
    L13:
        th = move-exception;
        th.printStackTrace();
    L15:
        return r101;
    L3:
        if (this.f473337k != null) goto L7;
        jn7.a r102 = this.f473332f;     // Catch: Throwable -> L13
        if (r102 == null) goto L7;
        this.f473337k = r102.a();     // Catch: Throwable -> L13
    L7:
        JSONObject r103 = this.f473337k;     // Catch: Throwable -> L13
        if (r103 == null) goto L15;
        if (r103.has(r100) == false) goto L15;
        return this.f473337k.opt(r100);
    }

    public final void d(String r100, in7.a r101) {
        if (this.f473327a == null) goto L6;
        long r102 = System.currentTimeMillis();
        this.f473327a.a(r100, new C5797a(r101, r100, r102));
        return;
    }

    public void requestPermissions(Activity r100, String[] r101, ShareContent r102, in7.g r103) {
        j r104 = this.f473328b;
        if (r104 == null) goto L6;
        r104.requestPermissions(r100, r101, r102, r103);
        return;
    }

    public final void a(ShareContent r100, String r101, String r102, String r110, in7.d r111) {
        c r103 = this.f473334h;
        if (r103 == null) goto L6;
        r103.a(r100, r101, r102, r110, r111);
        return;
    }
}
