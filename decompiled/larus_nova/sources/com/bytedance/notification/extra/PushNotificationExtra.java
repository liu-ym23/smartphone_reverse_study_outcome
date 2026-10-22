package com.bytedance.notification.extra;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.android.service.manager.push.notification.PushNotificationButtonInfo;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.push.utils.f;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public class PushNotificationExtra implements Parcelable {
    public static final Parcelable.Creator<PushNotificationExtra> CREATOR = null;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public JSONArray E;
    public List<PushNotificationButtonInfo> F;
    public int G;
    public String H;
    public int I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f266041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f266042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f266043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f266044d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f266045e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Bitmap f266046f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f266047g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Bitmap f266048h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f266049i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f266050j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f266051k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f266052l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f266053m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f266054n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f266055o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f266056p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f266057q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f266058r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f266059s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f266060t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f266061u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public double f266062v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f266063w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f266064x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public JSONObject f266065y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ProxyNotificationExtra f266066z;

    public @interface BannerType {
    }

    public static class a implements Parcelable.Creator<PushNotificationExtra> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PushNotificationExtra createFromParcel(Parcel r100) {
            return new PushNotificationExtra(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final PushNotificationExtra[] newArray(int r100) {
            return new PushNotificationExtra[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public final void a() {
        JSONObject r100 = this.f266042b;
        if (r100 != null) goto L28;
        this.A = true;
        return;
    L28:
        this.f266043c = r100.optBoolean("enable_notification_highlight", false);     // Catch: Throwable -> L26
        this.f266044d = b(this.f266042b, "notification_color", -1);     // Catch: Throwable -> L26
        this.f266045e = this.f266042b.optString("notification_background_image");     // Catch: Throwable -> L26
        this.f266047g = this.f266042b.optString("banner_background_image");     // Catch: Throwable -> L26
        this.f266049i = b(this.f266042b, "notification_header_color", 0);     // Catch: Throwable -> L26
        this.f266050j = b(this.f266042b, "notification_title_color", 0);     // Catch: Throwable -> L26
        this.f266051k = b(this.f266042b, "notification_content_color", 0);     // Catch: Throwable -> L26
        this.f266063w = this.f266042b.optBoolean("reset_all_text_to_black", false);     // Catch: Throwable -> L26
        this.f266055o = this.f266042b.optBoolean("enable_banner_show", false);     // Catch: Throwable -> L26
        this.f266057q = this.f266042b.optBoolean("enable_banner_highlight", false);     // Catch: Throwable -> L26
        this.f266056p = this.f266042b.optInt("banner_type", 0);     // Catch: Throwable -> L26
        this.f266058r = b(this.f266042b, "banner_color", -1);     // Catch: Throwable -> L26
        this.f266059s = b(this.f266042b, "banner_header_color", 0);     // Catch: Throwable -> L26
        this.f266060t = b(this.f266042b, "banner_title_color", 0);     // Catch: Throwable -> L26
        this.f266061u = b(this.f266042b, "banner_content_color", 0);     // Catch: Throwable -> L26
        this.f266062v = this.f266042b.optDouble("banner_show_duration", 1.0d);     // Catch: Throwable -> L26
        this.f266052l = this.f266042b.optBoolean("enable_sticky", false);     // Catch: Throwable -> L26
        this.f266053m = this.f266042b.optBoolean("enable_on_top", false);     // Catch: Throwable -> L26
        this.f266054n = this.f266042b.optInt("on_top_time", 2);     // Catch: Throwable -> L26
        this.f266064x = this.f266042b.optBoolean("handle_by_sdk", true);     // Catch: Throwable -> L26
        if (this.f266042b.optBoolean("handle_by_business", false) == false) goto L9;
        this.f266064x = false;     // Catch: Throwable -> L26
    L9:
        JSONObject r101 = this.f266042b.optJSONObject("proxy_notification_info");     // Catch: Throwable -> L26
        if (r101 == null) goto L12;
        this.f266066z = new ProxyNotificationExtra(r101);     // Catch: Throwable -> L26
    L12:
        this.E = this.f266042b.optJSONArray("notification_button_info");     // Catch: Throwable -> L26
        this.F = new ArrayList();     // Catch: Throwable -> L26
        if (this.E == null) goto L21;
        int r102 = 0;
    L30:
    L19:
        e = move-exception;
        f.e(getClass().getSimpleName(), e.getMessage());     // Catch: Throwable -> L26
        goto L21
    L16:
        if (r102 >= this.E.length()) goto L21;
        List<PushNotificationButtonInfo> r103 = this.F;     // Catch: Exception -> L19 Throwable -> L26
        ArrayList r104 = (ArrayList) r103;     // Catch: Exception -> L19 Throwable -> L26
        r104.add(new PushNotificationButtonInfo(JSONArrayProtectorUtils.getJSONObject(this.E, r102)));     // Catch: Exception -> L19 Throwable -> L26
        r102 = r102 + 1;
        goto L30
    L21:
        this.G = this.f266042b.optInt("notification_red_badge_number", 0);     // Catch: Throwable -> L26
        this.H = this.f266042b.optString("notification_video_url");     // Catch: Throwable -> L26
        this.I = this.f266042b.optInt("flags", -1);     // Catch: Throwable -> L26
        JSONObject r105 = this.f266042b.optJSONObject("extras");     // Catch: Throwable -> L26
        this.f266065y = r105;     // Catch: Throwable -> L26
        if (r105 != null) goto L24;
        this.f266065y = new JSONObject();     // Catch: Throwable -> L26
    L24:
        this.B = this.f266042b.optBoolean("use_sound", false);     // Catch: Throwable -> L26
        this.C = this.f266042b.optBoolean("use_vibration", false);     // Catch: Throwable -> L26
        this.D = this.f266042b.optBoolean("bright_screen", false);     // Catch: Throwable -> L26
        return;
    L26:
        this.A = true;
    }

    public final boolean c() {
        if (this.B == false) goto L5;
    L10:
        return true;
    L5:
        if (this.C == true) goto L10;
        if (this.D == true) goto L10;
        return false;
    }

    public PushNotificationExtra(Parcel r100) {
        boolean r101 = false;
        this.f266043c = false;
        this.f266044d = -1;
        this.f266049i = 0;
        this.f266050j = 0;
        this.f266051k = 0;
        this.f266052l = false;
        this.f266053m = false;
        this.f266054n = 2;
        this.f266055o = false;
        this.f266056p = 0;
        this.f266057q = false;
        this.f266058r = -1;
        this.f266059s = 0;
        this.f266060t = 0;
        this.f266061u = 0;
        this.f266062v = 1.0d;
        this.A = false;
        this.I = -1;
        this.f266041a = r100.readString();
        this.f266042b = new JSONObject(r100.readString());     // Catch: JSONException -> L5
    L8:
        if (r100.readByte() == 0) goto L10;
        boolean r102 = true;
    L11:
        this.f266043c = r102;
        this.f266044d = r100.readInt();
        if (r100.readByte() == 0) goto L14;
        boolean r103 = true;
    L15:
        this.f266052l = r103;
        if (r100.readByte() == 0) goto L18;
        boolean r104 = true;
    L19:
        this.f266053m = r104;
        this.f266054n = r100.readInt();
        if (r100.readByte() == 0) goto L22;
        boolean r105 = true;
    L23:
        this.f266055o = r105;
        if (r100.readByte() == 0) goto L26;
        boolean r106 = true;
    L27:
        this.f266057q = r106;
        this.f266058r = r100.readInt();
        this.f266062v = r100.readDouble();
        this.f266065y = new JSONObject(r100.readString());     // Catch: Throwable -> L30
    L33:
        if (r100.readByte() == 0) goto L35;
        boolean r107 = true;
    L36:
        this.B = r107;
        if (r100.readByte() == 0) goto L39;
        boolean r108 = true;
    L40:
        this.C = r108;
        if (r100.readByte() == 0) goto L43;
        r101 = true;
    L43:
        this.D = r101;
        return;
    L39:
        r108 = false;
        goto L40
    L35:
        r107 = false;
    L30:
        th = move-exception;
        th.printStackTrace();
        goto L33
    L26:
        r106 = false;
        goto L27
    L22:
        r105 = false;
        goto L23
    L18:
        r104 = false;
        goto L19
    L14:
        r103 = false;
        goto L15
    L10:
        r102 = false;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public PushNotificationExtra(String r100) {
        this.f266043c = false;
        this.f266044d = -1;
        this.f266049i = 0;
        this.f266050j = 0;
        this.f266051k = 0;
        this.f266052l = false;
        this.f266053m = false;
        this.f266054n = 2;
        this.f266055o = false;
        this.f266056p = 0;
        this.f266057q = false;
        this.f266058r = -1;
        this.f266059s = 0;
        this.f266060t = 0;
        this.f266061u = 0;
        this.f266062v = 1.0d;
        this.A = false;
        this.I = -1;
        if (TextUtils.isEmpty(r100) == false) goto L6;
        this.A = true;
        return;
    L6:
        this.f266041a = r100;
        this.f266042b = new JSONObject(r100);     // Catch: Throwable -> L9
        a();     // Catch: Throwable -> L9
        return;
    L9:
        this.A = true;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f266041a);
        JSONObject r102 = this.f266042b;
        String r103 = "";
        if (r102 == null) goto L5;
        String r104 = r102.toString();
    L6:
        r100.writeString(r104);
        r100.writeByte(this.f266043c ? 1 : 0);
        r100.writeInt(this.f266044d);
        r100.writeByte(this.f266052l ? 1 : 0);
        r100.writeByte(this.f266053m ? 1 : 0);
        r100.writeInt(this.f266054n);
        r100.writeByte(this.f266055o ? 1 : 0);
        r100.writeByte(this.f266057q ? 1 : 0);
        r100.writeInt(this.f266058r);
        r100.writeDouble(this.f266062v);
        JSONObject r105 = this.f266065y;
        if (r105 == null) goto L9;
        r103 = r105.toString();
    L9:
        r100.writeString(r103);
        r100.writeByte(this.B ? 1 : 0);
        r100.writeByte(this.C ? 1 : 0);
        r100.writeByte(this.D ? 1 : 0);
        return;
    L5:
        r104 = "";
        goto L6
    }

    public static int b(JSONObject r100, String r101, int r102) {
        String r103 = r100.optString(r101);     // Catch: Throwable -> L6
        if (TextUtils.isEmpty(r103) == true) goto L9;
        return Color.parseColor(r103);
    L9:
        return r102;
    L10:
        return r102;
    }
}
