package com.bytedance.push;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.service.manager.alliance.IAllianceService;
import com.bytedance.android.service.manager.push.notification.NotificationBody;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.support.PushCommonSupport;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.socialbase.downloader.segment.Segment;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public class PushBody implements Parcelable {
    public static final Parcelable.Creator<PushBody> CREATOR = null;
    public final int A;
    public final boolean B;
    public final long C;
    public final int D;
    public final int E;
    public final int F;
    public final int G;
    public final boolean H;
    public final boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final boolean f266711J;
    public final String K;
    public final int L;
    public final int M;
    public final boolean N;
    public final long O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f266712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f266713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f266714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f266715d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f266716e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f266717f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f266718g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f266719h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f266720i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f266721j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final JSONObject f266722k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f266723l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f266724m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f266725n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f266726o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f266727p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f266728q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f266729r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f266730s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f266731t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f266732u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final JSONObject f266733v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f266734w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f266735x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f266736y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f266737z;

    public @interface ImageType {
    }

    public static class a implements Parcelable.Creator<PushBody> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PushBody createFromParcel(Parcel r100) {
            return new PushBody(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final PushBody[] newArray(int r100) {
            return new PushBody[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public final NotificationBody a() {
        return new NotificationBody.Builder().msgData(this.f266722k).id(this.f266713b).showWhen(this.f266716e).title(this.f266724m).content(this.f266723l).groupId(this.f266715d).channelId(this.f266720i).redBadgeNum(this.f266735x).imageUrl(this.f266725n).imageType(this.f266726o).useLED(this.f266728q).useSound(this.f266729r).useVibrator(this.f266730s).androidGroup(this.f266737z).groupFoldNum(this.A).setBdPushStr(this.f266732u).setOpenUrl(this.f266727p).setEventExtra(this.f266733v).setChannelImportance(this.L).setNotificationCategory(this.K).setAvatarDisplayMode(this.M).setForceSameWithIos(this.N).build();
    }

    public final int b() {
        JSONObject r100 = this.f266722k;
        if (r100 != null) goto L5;
        return -1;
    L5:
        JSONObject r101 = r100.optJSONObject("proxy_notification_info");
        if (r101 != null) goto L9;
        return -1;
    L9:
        return r101.optInt("sender", -1);
    }

    public final String toString() {
        return "PushBody{groupId='" + this.f266715d + "', extra='" + this.f266719h + "', mNotificationChannelId='" + this.f266720i + "', mIsPassThough=" + this.f266721j + ", msgData=" + this.f266722k + ", text='" + this.f266723l + "', title='" + this.f266724m + "', imageUrl='" + this.f266725n + "', imageType=" + this.f266726o + ", id=" + this.f266713b + ", open_url='" + this.f266727p + "', useLED=" + this.f266728q + ", useSound=" + this.f266729r + ", useVibrator=" + this.f266730s + ", messageType=" + this.f266731t + ", androidGroup=" + this.f266737z + '}';
    }

    public PushBody(JSONObject r110) {
        this.f266722k = r110;
        this.f266727p = r110.optString("open_url");
        this.f266723l = r110.optString("text");
        this.f266724m = r110.optString("title");
        this.f266725n = r110.optString("image_url");
        this.f266713b = r110.optLong("id", 0);
        this.f266714c = r110.optLong("rid64", 0);
        this.f266728q = c(r110, "use_led");
        this.f266729r = c(r110, RemoteMessageConst.Notification.SOUND);
        this.f266730s = c(r110, "use_vibrator");
        this.f266726o = r110.optInt("image_type", 0);
        this.M = r110.optInt("avatar_display_mode", 0);
        this.N = r110.optBoolean("force_same_with_ios");
        if (r110.optInt("pass_through", 1) <= 0) goto L5;
        boolean r100 = true;
    L6:
        this.f266721j = r100;
        this.f266720i = r110.optString("notify_channel");
        this.f266731t = r110.optInt(AppConstants.MSG_FROM);
        this.f266715d = r110.optString("group_id_str");
        if (r110.optInt(Segment.JsonKey.START, 1) <= 0) goto L9;
        boolean r101 = true;
    L10:
        this.f266716e = r101;
        this.f266717f = r110.optString("ttpush_sec_target_uid");
        if (r110.optInt("ttpush_need_filter_uid", 0) <= 0) goto L13;
        boolean r102 = true;
    L14:
        this.f266718g = r102;
        this.f266734w = r110.optLong("revoke_id");
        String r103 = r110.optString("extra_str");
        this.f266719h = r103;
        this.f266732u = r110.optString("bdpush_str");
        this.f266712a = r110.optString("sign");
        this.f266733v = r110.optJSONObject("ttpush_event_extra");
        this.f266736y = r110.optInt("push_show_type", 0);
        r110.optString("business_type", "");
        this.f266735x = r110.optInt(IAllianceService.CONTENT_TYPE_BADGE);
        this.f266736y = r110.optInt("push_show_type", 0);
        r110.optString("business_type", "");
        r110.optString("voip_params", "");
        String r111 = r110.optString("android_group", "");
        this.f266737z = r111;
        this.A = r110.optInt("group_fold_num", 3);
        this.B = r110.optBoolean("client_intelligent");
        long r104 = r110.optLong("message_expire_time", -1);
        this.C = r104;
        if (r104 != (-1)) goto L17;
        this.C = r110.optLong("expire_time", -1);
    L17:
        this.D = r110.optInt("client_intelligence_push_show_mode", 1);
        this.E = r110.optInt("client_intelligence_push_show_sub_mode", 0);
        this.H = r110.optBoolean("allow_intercept_in_black_time_window", true);
        this.K = r110.optString("category", "");
        this.L = r110.optInt("importance", -1);
        long r112 = this.C;
        if (r112 != (-1)) goto L20;
        com.bytedance.push.utils.f.i("PushBody", "expiredTime is None so force set useClientIntelligenceShow and allowInterceptInBlackTimeWindow to false");
        this.B = false;
        this.H = false;
    L22:
        if (PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mIsDebugMode == true) goto L24;
    L49:
        this.F = r110.optInt("min_display_interval_from_last_msg", -1);
        this.G = r110.optInt("min_display_interval_from_foreground", -1);
        this.I = r110.optBoolean("additional_arrive_callback", false);
        this.f266711J = r110.optBoolean("additional_click_callback", false);
        this.O = r110.optLong("delay_show_interval_in_second", 0);
        return;
    L24:
        if (TextUtils.isEmpty(r103) == true) goto L49;
        JSONObject r105 = new JSONObject(r103);     // Catch: JSONException -> L47
        if (TextUtils.isEmpty(r111) == false) goto L28;
        this.f266737z = r105.optString("android_group");     // Catch: JSONException -> L47
    L28:
        int r106 = r105.optInt("image_type", -1);     // Catch: JSONException -> L47
        if (r106 <= 0) goto L32;
        this.f266726o = r106;     // Catch: JSONException -> L47
    L32:
        if (r105.optBoolean("force_same_with_ios", false) == false) goto L34;
        this.N = true;     // Catch: JSONException -> L47
    L34:
        int r107 = r105.optInt("avatar_display_mode", -1);     // Catch: JSONException -> L47
        if (r107 <= 0) goto L38;
        this.M = r107;     // Catch: JSONException -> L47
    L38:
        if (r105.optBoolean("client_intelligent", false) == false) goto L40;
        this.B = true;     // Catch: JSONException -> L47
        this.C = System.currentTimeMillis() + LocationInfoConst.defaultsOverseasCacheValidity;     // Catch: JSONException -> L47
    L40:
        int r108 = r105.optInt("client_intelligence_push_show_mode", -1);     // Catch: JSONException -> L47
        if (r108 <= (-1)) goto L43;
        this.D = r108;     // Catch: JSONException -> L47
    L43:
        int r109 = r105.optInt("client_intelligence_push_show_sub_mode", -1);     // Catch: JSONException -> L47
        if (r109 <= (-1)) goto L49;
        this.E = r109;     // Catch: JSONException -> L47
    L47:
        e = move-exception;
        e.printStackTrace();
        goto L49
    L20:
        this.C = r112 * 1000;
        goto L22
    L13:
        r102 = false;
        goto L14
    L9:
        r101 = false;
        goto L10
    L5:
        r100 = false;
        goto L6
    }

    public PushBody(Parcel r100) {
        this.f266713b = r100.readLong();
        this.f266714c = r100.readLong();
        this.f266715d = r100.readString();
        boolean r101 = true;
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.f266716e = r102;
        this.f266717f = r100.readString();
        if (r100.readByte() == 0) goto L9;
        boolean r103 = true;
    L10:
        this.f266718g = r103;
        this.f266719h = r100.readString();
        this.f266732u = r100.readString();
        this.f266720i = r100.readString();
        if (r100.readByte() == 0) goto L13;
        boolean r104 = true;
    L14:
        this.f266721j = r104;
        this.f266722k = new JSONObject(r100.readString());     // Catch: Throwable -> L17
    L19:
        this.f266723l = r100.readString();
        this.f266724m = r100.readString();
        this.f266725n = r100.readString();
        this.f266726o = r100.readInt();
        this.f266727p = r100.readString();
        if (r100.readByte() == 0) goto L22;
        boolean r105 = true;
    L23:
        this.f266728q = r105;
        if (r100.readByte() == 0) goto L26;
        boolean r106 = true;
    L27:
        this.f266729r = r106;
        if (r100.readByte() == 0) goto L30;
        boolean r107 = true;
    L31:
        this.f266730s = r107;
        this.f266731t = r100.readInt();
        this.f266734w = r100.readLong();
        this.f266712a = r100.readString();
        if (r100.readByte() != 0) goto L35;
        r101 = false;
    L35:
        this.N = r101;
        this.f266733v = new JSONObject(r100.readString());     // Catch: Throwable -> L38
        return;
    L38:
        th = move-exception;
        th.printStackTrace();
        return;
    L30:
        r107 = false;
        goto L31
    L26:
        r106 = false;
        goto L27
    L22:
        r105 = false;
    L17:
        th = move-exception;
        th.printStackTrace();
        goto L19
    L13:
        r104 = false;
        goto L14
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    public static boolean c(JSONObject r100, String r101) {
        if (r100 != null) goto L5;
    L14:
        return false;
    L5:
        if (r100.isNull(r101) == true) goto L14;
        int r102 = r100.optInt(r101, -1);
        if (r102 < 1) goto L10;
        return true;
    L10:
        if (r102 != 0) goto L13;
        return false;
    L13:
        return r100.optBoolean(r101, false);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeLong(this.f266713b);
        r100.writeLong(this.f266714c);
        r100.writeString(this.f266715d);
        r100.writeByte(this.f266716e ? 1 : 0);
        r100.writeString(this.f266717f);
        r100.writeByte(this.f266718g ? 1 : 0);
        r100.writeString(this.f266719h);
        r100.writeString(this.f266732u);
        r100.writeString(this.f266720i);
        r100.writeByte(this.f266721j ? 1 : 0);
        r100.writeString(this.f266722k.toString());
        r100.writeString(this.f266723l);
        r100.writeString(this.f266724m);
        r100.writeString(this.f266725n);
        r100.writeInt(this.f266726o);
        r100.writeString(this.f266727p);
        r100.writeByte(this.f266728q ? 1 : 0);
        r100.writeByte(this.f266729r ? 1 : 0);
        r100.writeByte(this.f266730s ? 1 : 0);
        r100.writeInt(this.f266731t);
        r100.writeLong(this.f266734w);
        r100.writeString(this.f266712a);
        r100.writeByte(this.N ? 1 : 0);
        JSONObject r102 = this.f266733v;
        if (r102 != null) goto L5;
        String r103 = "";
    L6:
        r100.writeString(r103);
        return;
    L5:
        r103 = r102.toString();
        goto L6
    }
}
