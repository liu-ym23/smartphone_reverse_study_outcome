package com.huawei.hms.push;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.utils.DateUtil;
import com.huawei.hms.push.utils.JsonUtil;
import com.huawei.hms.support.api.push.PushException;
import com.huawei.hms.support.log.HMSLog;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class RemoteMessage implements Parcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR = null;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 2;
    public static final int PRIORITY_UNKNOWN = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f277571c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f277572d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long[] f277573e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final HashMap<String, Object> f277574f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final HashMap<String, Object> f277575g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final HashMap<String, Object> f277576h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final HashMap<String, Object> f277577i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final HashMap<String, Object> f277578j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Bundle f277579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Notification f277580b;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Bundle f277581a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<String, String> f277582b;

        public RemoteMessage build() {
            Bundle r100 = new Bundle();
            JSONObject r101 = new JSONObject();
            Iterator<Map.Entry<String, String>> r102 = this.f277582b.entrySet().iterator();     // Catch: JSONException -> L16
        L5:
            if (r102.hasNext() == false) goto L18;
            Map.Entry<String, String> r110 = r102.next();     // Catch: JSONException -> L16
            r101.put(r110.getKey(), r110.getValue());     // Catch: JSONException -> L16
            goto L5
        L18:
            String r103 = r101.toString();     // Catch: JSONException -> L14
            JSONObject r111 = new JSONObject();     // Catch: JSONException -> L14
            r111.put(RemoteMessageConst.COLLAPSE_KEY, this.f277581a.getString(RemoteMessageConst.COLLAPSE_KEY));     // Catch: JSONException -> L14
            r111.put(RemoteMessageConst.TTL, this.f277581a.getInt(RemoteMessageConst.TTL));     // Catch: JSONException -> L14
            r111.put(RemoteMessageConst.SEND_MODE, this.f277581a.getInt(RemoteMessageConst.SEND_MODE));     // Catch: JSONException -> L14
            r111.put(RemoteMessageConst.RECEIPT_MODE, this.f277581a.getInt(RemoteMessageConst.RECEIPT_MODE));     // Catch: JSONException -> L14
            JSONObject r104 = new JSONObject();     // Catch: JSONException -> L14
            if (r101.length() == 0) goto L11;
            r104.put("data", r103);     // Catch: JSONException -> L14
        L11:
            r104.put(RemoteMessageConst.MSGID, this.f277581a.getString(RemoteMessageConst.MSGID));     // Catch: JSONException -> L14
            r111.put(RemoteMessageConst.MessageBody.MSG_CONTENT, r104);     // Catch: JSONException -> L14
            r100.putByteArray(RemoteMessageConst.MSGBODY, r111.toString().getBytes(m.f277621a));     // Catch: JSONException -> L14
            r100.putString(RemoteMessageConst.TO, this.f277581a.getString(RemoteMessageConst.TO));
            r100.putString("message_type", this.f277581a.getString("message_type"));
            return new RemoteMessage(r100);
        L14:
            HMSLog.w("RemoteMessage", "JSONException: parse message body failed.");
            throw new PushException(PushException.EXCEPTION_SEND_FAILED);
        L16:
            HMSLog.w("RemoteMessage", "JSONException: parse data to json failed.");
            throw new PushException(PushException.EXCEPTION_SEND_FAILED);
        }

        public Builder clearData() {
            this.f277582b.clear();
            return this;
        }

        public Builder(String r100) {
            Bundle r101 = new Bundle();
            this.f277581a = r101;
            this.f277582b = new HashMap();
            r101.putString(RemoteMessageConst.TO, r100);
        }

        public Builder setCollapseKey(String r100) {
            this.f277581a.putString(RemoteMessageConst.COLLAPSE_KEY, r100);
            return this;
        }

        public Builder setData(Map<String, String> r100) {
            this.f277582b.clear();
            Iterator<Map.Entry<String, String>> r101 = r100.entrySet().iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            Map.Entry<String, String> r102 = r101.next();
            this.f277582b.put(r102.getKey(), r102.getValue());
            goto L4
        L6:
            return this;
        }

        public Builder setMessageId(String r100) {
            this.f277581a.putString(RemoteMessageConst.MSGID, r100);
            return this;
        }

        public Builder setMessageType(String r100) {
            this.f277581a.putString("message_type", r100);
            return this;
        }

        public Builder setReceiptMode(int r100) {
            if (r100 == 1) goto L8;
            if (r100 == 0) goto L8;
            throw new IllegalArgumentException("receipt mode can only be 0 or 1.");
        L8:
            this.f277581a.putInt(RemoteMessageConst.RECEIPT_MODE, r100);
            return this;
        }

        public Builder setSendMode(int r100) {
            if (r100 != 0) goto L4;
        L8:
            this.f277581a.putInt(RemoteMessageConst.SEND_MODE, r100);
            return this;
        L4:
            if (r100 == 1) goto L8;
            throw new IllegalArgumentException("send mode can only be 0 or 1.");
        }

        public Builder setTtl(int r100) {
            if (r100 < 1) goto L9;
            if (r100 > 1296000) goto L9;
            this.f277581a.putInt(RemoteMessageConst.TTL, r100);
            return this;
        L9:
            throw new IllegalArgumentException("ttl must be greater than or equal to 1 and less than or equal to 1296000");
        }

        public Builder addData(String r100, String r101) {
            if (r100 == null) goto L6;
            this.f277582b.put(r100, r101);
            return this;
        L6:
            throw new IllegalArgumentException("add data failed, key is null.");
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MessagePriority {
    }

    public static class Notification implements Serializable {
        private final long[] A;
        private final String B;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f277583a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f277584b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String[] f277585c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f277586d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f277587e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String[] f277588f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final String f277589g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final String f277590h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final String f277591i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final String f277592j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final String f277593k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final String f277594l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final String f277595m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final Uri f277596n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private final int f277597o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final String f277598p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private final int f277599q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private final int f277600r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final int f277601s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final int[] f277602t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private final String f277603u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private final int f277604v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private final String f277605w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private final int f277606x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private final String f277607y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private final String f277608z;

        public Integer getBadgeNumber() {
            return a(this.f277605w);
        }

        public String[] getBodyLocalizationArgs() {
            String[] r100 = this.f277588f;
            if (r100 != null) goto L6;
            return new String[0];
        L6:
            return (String[]) r100.clone();
        }

        public Uri getImageUrl() {
            String r100 = this.f277598p;
            if (r100 != null) goto L6;
            return null;
        L6:
            return UriProtector.parse(r100);
        }

        public Integer getImportance() {
            return a(this.f277607y);
        }

        public int[] getLightSettings() {
            int[] r100 = this.f277602t;
            if (r100 != null) goto L6;
            return new int[0];
        L6:
            return (int[]) r100.clone();
        }

        public String[] getTitleLocalizationArgs() {
            String[] r100 = this.f277585c;
            if (r100 != null) goto L6;
            return new String[0];
        L6:
            return (String[]) r100.clone();
        }

        public long[] getVibrateConfig() {
            long[] r100 = this.A;
            if (r100 != null) goto L6;
            return new long[0];
        L6:
            return (long[]) r100.clone();
        }

        public Integer getVisibility() {
            return a(this.B);
        }

        public Long getWhen() {
            if (TextUtils.isEmpty(this.f277603u) == false) goto L10;
        L8:
            return null;
        L10:
        L12:
            return Long.valueOf(DateUtil.parseUtcToMillisecond(this.f277603u));
        L6:
            HMSLog.w("RemoteMessage", "StringIndexOutOfBoundsException: parse when failed.");
        L7:
            HMSLog.w("RemoteMessage", "ParseException: parse when failed.");
            goto L8
        }

        public boolean isAutoCancel() {
            if (this.f277606x == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean isDefaultLight() {
            if (this.f277599q == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean isDefaultSound() {
            if (this.f277600r == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean isDefaultVibrate() {
            if (this.f277601s == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean isLocalOnly() {
            if (this.f277604v == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public String getBody() {
            return this.f277586d;
        }

        public String getBodyLocalizationKey() {
            return this.f277587e;
        }

        public String getChannelId() {
            return this.f277595m;
        }

        public String getClickAction() {
            return this.f277593k;
        }

        public String getColor() {
            return this.f277592j;
        }

        public String getIcon() {
            return this.f277589g;
        }

        public String getIntentUri() {
            return this.f277594l;
        }

        public Uri getLink() {
            return this.f277596n;
        }

        public int getNotifyId() {
            return this.f277597o;
        }

        public String getSound() {
            return this.f277590h;
        }

        public String getTag() {
            return this.f277591i;
        }

        public String getTicker() {
            return this.f277608z;
        }

        public String getTitle() {
            return this.f277583a;
        }

        public String getTitleLocalizationKey() {
            return this.f277584b;
        }

        private Notification(Bundle r100) {
            this.f277583a = r100.getString(RemoteMessageConst.Notification.NOTIFY_TITLE);
            this.f277586d = r100.getString("content");
            this.f277584b = r100.getString(RemoteMessageConst.Notification.TITLE_LOC_KEY);
            this.f277587e = r100.getString(RemoteMessageConst.Notification.BODY_LOC_KEY);
            this.f277585c = r100.getStringArray(RemoteMessageConst.Notification.TITLE_LOC_ARGS);
            this.f277588f = r100.getStringArray(RemoteMessageConst.Notification.BODY_LOC_ARGS);
            this.f277589g = r100.getString("icon");
            this.f277592j = r100.getString("color");
            this.f277590h = r100.getString(RemoteMessageConst.Notification.SOUND);
            this.f277591i = r100.getString("tag");
            this.f277595m = r100.getString(RemoteMessageConst.Notification.CHANNEL_ID);
            this.f277593k = r100.getString(RemoteMessageConst.Notification.CLICK_ACTION);
            this.f277594l = r100.getString(RemoteMessageConst.Notification.INTENT_URI);
            this.f277597o = r100.getInt(RemoteMessageConst.Notification.NOTIFY_ID);
            String r101 = r100.getString("url");
            if (TextUtils.isEmpty(r101) == true) goto L5;
            Uri r102 = UriProtector.parse(r101);
        L6:
            this.f277596n = r102;
            this.f277598p = r100.getString(RemoteMessageConst.Notification.NOTIFY_ICON);
            this.f277599q = r100.getInt(RemoteMessageConst.Notification.DEFAULT_LIGHT_SETTINGS);
            this.f277600r = r100.getInt(RemoteMessageConst.Notification.DEFAULT_SOUND);
            this.f277601s = r100.getInt(RemoteMessageConst.Notification.DEFAULT_VIBRATE_TIMINGS);
            this.f277602t = r100.getIntArray(RemoteMessageConst.Notification.LIGHT_SETTINGS);
            this.f277603u = r100.getString(RemoteMessageConst.Notification.WHEN);
            this.f277604v = r100.getInt(RemoteMessageConst.Notification.LOCAL_ONLY);
            this.f277605w = r100.getString(RemoteMessageConst.Notification.BADGE_SET_NUM, null);
            this.f277606x = r100.getInt(RemoteMessageConst.Notification.AUTO_CANCEL);
            this.f277607y = r100.getString("priority", null);
            this.f277608z = r100.getString(RemoteMessageConst.Notification.TICKER);
            this.A = r100.getLongArray(RemoteMessageConst.Notification.VIBRATE_TIMINGS);
            this.B = r100.getString(RemoteMessageConst.Notification.VISIBILITY, null);
            return;
        L5:
            r102 = null;
            goto L6
        }

        private Integer a(String r100) {
            if (r100 != null) goto L8;
        L6:
            return null;
        L8:
            return CastIntegerProtector.valueOf(r100);
        L5:
            HMSLog.w("RemoteMessage", "NumberFormatException: get " + r100 + " failed.");
            goto L6
        }

        public /* synthetic */ Notification(Bundle r100, a r101) {
            this(r100);
        }
    }

    public class a implements Parcelable.Creator<RemoteMessage> {
        public a() {
        }

        public RemoteMessage a(Parcel r100) {
            return new RemoteMessage(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RemoteMessage createFromParcel(Parcel r100) {
            return a(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RemoteMessage[] newArray(int r100) {
            return a(r100);
        }

        public RemoteMessage[] a(int r100) {
            return new RemoteMessage[r100];
        }
    }

    static {
        String[] r100 = new String[0];
        f277571c = r100;
        int[] r101 = new int[0];
        f277572d = r101;
        long[] r102 = new long[0];
        f277573e = r102;
        HashMap<String, Object> r103 = new HashMap(8);
        f277574f = r103;
        r103.put("from", "");
        r103.put(RemoteMessageConst.COLLAPSE_KEY, "");
        r103.put(RemoteMessageConst.SEND_TIME, "");
        r103.put(RemoteMessageConst.TTL, 86400);
        r103.put(RemoteMessageConst.URGENCY, 2);
        r103.put(RemoteMessageConst.ORI_URGENCY, 2);
        r103.put(RemoteMessageConst.SEND_MODE, 0);
        r103.put(RemoteMessageConst.RECEIPT_MODE, 0);
        HashMap<String, Object> r104 = new HashMap(8);
        f277575g = r104;
        r104.put(RemoteMessageConst.Notification.TITLE_LOC_KEY, "");
        r104.put(RemoteMessageConst.Notification.BODY_LOC_KEY, "");
        r104.put(RemoteMessageConst.Notification.NOTIFY_ICON, "");
        r104.put(RemoteMessageConst.Notification.TITLE_LOC_ARGS, r100);
        r104.put(RemoteMessageConst.Notification.BODY_LOC_ARGS, r100);
        r104.put(RemoteMessageConst.Notification.TICKER, "");
        r104.put(RemoteMessageConst.Notification.NOTIFY_TITLE, "");
        r104.put("content", "");
        HashMap<String, Object> r105 = new HashMap(8);
        f277576h = r105;
        r105.put("icon", "");
        r105.put("color", "");
        r105.put(RemoteMessageConst.Notification.SOUND, "");
        r105.put(RemoteMessageConst.Notification.DEFAULT_LIGHT_SETTINGS, 1);
        r105.put(RemoteMessageConst.Notification.LIGHT_SETTINGS, r101);
        r105.put(RemoteMessageConst.Notification.DEFAULT_SOUND, 1);
        r105.put(RemoteMessageConst.Notification.DEFAULT_VIBRATE_TIMINGS, 1);
        r105.put(RemoteMessageConst.Notification.VIBRATE_TIMINGS, r102);
        HashMap<String, Object> r106 = new HashMap(8);
        f277577i = r106;
        r106.put("tag", "");
        r106.put(RemoteMessageConst.Notification.WHEN, "");
        r106.put(RemoteMessageConst.Notification.LOCAL_ONLY, 1);
        r106.put(RemoteMessageConst.Notification.BADGE_SET_NUM, "");
        r106.put("priority", "");
        r106.put(RemoteMessageConst.Notification.AUTO_CANCEL, 1);
        r106.put(RemoteMessageConst.Notification.VISIBILITY, "");
        r106.put(RemoteMessageConst.Notification.CHANNEL_ID, "");
        HashMap<String, Object> r107 = new HashMap(3);
        f277578j = r107;
        r107.put(RemoteMessageConst.Notification.CLICK_ACTION, "");
        r107.put(RemoteMessageConst.Notification.INTENT_URI, "");
        r107.put("url", "");
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public String getAnalyticInfo() {
        return this.f277579a.getString(RemoteMessageConst.ANALYTIC_INFO);
    }

    public Map<String, String> getAnalyticInfoMap() {
        HashMap r100 = new HashMap();
        String r101 = this.f277579a.getString(RemoteMessageConst.ANALYTIC_INFO);
        if (r101 != null) goto L5;
    L12:
        return r100;
    L5:
        if (r101.trim().isEmpty() == true) goto L12;
        JSONObject r102 = new JSONObject(r101);     // Catch: JSONException -> L11
        Iterator<String> r103 = r102.keys();     // Catch: JSONException -> L11
    L8:
        if (r103.hasNext() == false) goto L12;
        String r104 = String.valueOf(r103.next());     // Catch: JSONException -> L11
        r100.put(r104, String.valueOf(r102.get(r104)));     // Catch: JSONException -> L11
    L11:
        HMSLog.w("RemoteMessage", "JSONException: get analyticInfo from map failed.");
        goto L12
    }

    public String getCollapseKey() {
        return this.f277579a.getString(RemoteMessageConst.COLLAPSE_KEY);
    }

    public String getData() {
        return this.f277579a.getString("data");
    }

    public Map<String, String> getDataOfMap() {
        HashMap r100 = new HashMap();
        String r101 = this.f277579a.getString("data");
        if (r101 != null) goto L5;
    L12:
        return r100;
    L5:
        if (r101.trim().isEmpty() == true) goto L12;
        JSONObject r102 = new JSONObject(r101);     // Catch: JSONException -> L11
        Iterator<String> r103 = r102.keys();     // Catch: JSONException -> L11
    L8:
        if (r103.hasNext() == false) goto L12;
        String r104 = String.valueOf(r103.next());     // Catch: JSONException -> L11
        r100.put(r104, String.valueOf(r102.get(r104)));     // Catch: JSONException -> L11
    L11:
        HMSLog.w("RemoteMessage", "JSONException: get data from map failed");
        goto L12
    }

    public String getFrom() {
        return this.f277579a.getString("from");
    }

    public String getMessageId() {
        return this.f277579a.getString(RemoteMessageConst.MSGID);
    }

    public String getMessageType() {
        return this.f277579a.getString("message_type");
    }

    public Notification getNotification() {
        Bundle r100 = this.f277579a.getBundle("notification");
        a r101 = null;
        if (this.f277580b != null) goto L7;
        if (r100 == null) goto L7;
        this.f277580b = new Notification(r100, r101);
    L7:
        if (this.f277580b != null) goto L10;
        this.f277580b = new Notification(new Bundle(), r101);
    L10:
        return this.f277580b;
    }

    public int getOriginalUrgency() {
        int r100 = this.f277579a.getInt(RemoteMessageConst.ORI_URGENCY);
        if (r100 != 1) goto L5;
        return r100;
    L5:
        if (r100 == 2) goto L9;
        return 0;
    L9:
        return r100;
    }

    public int getReceiptMode() {
        return this.f277579a.getInt(RemoteMessageConst.RECEIPT_MODE);
    }

    public int getSendMode() {
        return this.f277579a.getInt(RemoteMessageConst.SEND_MODE);
    }

    public long getSentTime() {
        String r100 = this.f277579a.getString(RemoteMessageConst.SEND_TIME);     // Catch: NumberFormatException -> L7
        if (TextUtils.isEmpty(r100) == true) goto L11;
        return CastLongProtector.parseLong(r100);
    L11:
        return 0;
    L7:
        HMSLog.w("RemoteMessage", "NumberFormatException: get sendTime error.");
        return 0;
    }

    public String getTo() {
        return this.f277579a.getString(RemoteMessageConst.TO);
    }

    public String getToken() {
        return this.f277579a.getString(RemoteMessageConst.DEVICE_TOKEN);
    }

    public int getTtl() {
        return this.f277579a.getInt(RemoteMessageConst.TTL);
    }

    public int getUrgency() {
        int r100 = this.f277579a.getInt(RemoteMessageConst.URGENCY);
        if (r100 != 1) goto L5;
        return r100;
    L5:
        if (r100 == 2) goto L9;
        return 0;
    L9:
        return r100;
    }

    public RemoteMessage(Parcel r100) {
        this.f277579a = r100.readBundle();
        this.f277580b = (Notification) r100.readSerializable();
    }

    private Bundle a(Bundle r110) {
        Bundle r100 = new Bundle();
        JSONObject r101 = b(r110);
        JSONObject r102 = a(r101);
        String r103 = JsonUtil.getString(r102, "data", null);
        r100.putString(RemoteMessageConst.ANALYTIC_INFO, JsonUtil.getString(r102, RemoteMessageConst.ANALYTIC_INFO, null));
        r100.putString(RemoteMessageConst.DEVICE_TOKEN, r110.getString(RemoteMessageConst.DEVICE_TOKEN));
        JSONObject r104 = d(r102);
        JSONObject r105 = b(r104);
        JSONObject r106 = c(r104);
        if (r110.getInt(RemoteMessageConst.INPUT_TYPE) == 1) goto L5;
    L8:
        String r111 = r110.getString(RemoteMessageConst.TO);
        String r112 = r110.getString("message_type");
        String r107 = JsonUtil.getString(r102, RemoteMessageConst.MSGID, null);
        r100.putString(RemoteMessageConst.TO, r111);
        r100.putString("data", r103);
        r100.putString(RemoteMessageConst.MSGID, r107);
        r100.putString("message_type", r112);
        JsonUtil.transferJsonObjectToBundle(r101, r100, f277574f);
        r100.putBundle("notification", a(r101, r102, r104, r105, r106));
        return r100;
    L5:
        if (d.a(r102, r104, r103) == false) goto L8;
        r100.putString("data", com.huawei.hms.push.a.a(r110.getByteArray(RemoteMessageConst.MSGBODY)));
        return r100;
    }

    private static JSONObject b(Bundle r100) {
        return new JSONObject(com.huawei.hms.push.a.a(r100.getByteArray(RemoteMessageConst.MSGBODY)));
    L4:
        HMSLog.w("RemoteMessage", "JSONException:parse message body failed.");
        return null;
    }

    private static JSONObject c(JSONObject r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        return r100.optJSONObject("param");
    }

    private static JSONObject d(JSONObject r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        return r100.optJSONObject(RemoteMessageConst.MessageBody.PS_CONTENT);
    }

    public RemoteMessage(Bundle r100) {
        this.f277579a = a(r100);
    }

    private static JSONObject a(JSONObject r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        return r100.optJSONObject(RemoteMessageConst.MessageBody.MSG_CONTENT);
    }

    private static JSONObject b(JSONObject r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        return r100.optJSONObject(RemoteMessageConst.MessageBody.NOTIFY_DETAIL);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeBundle(this.f277579a);
        r100.writeSerializable(this.f277580b);
    }

    private Bundle a(JSONObject r100, JSONObject r101, JSONObject r102, JSONObject r103, JSONObject r104) {
        Bundle r105 = new Bundle();
        JsonUtil.transferJsonObjectToBundle(r102, r105, f277575g);
        JsonUtil.transferJsonObjectToBundle(r103, r105, f277576h);
        JsonUtil.transferJsonObjectToBundle(r100, r105, f277577i);
        JsonUtil.transferJsonObjectToBundle(r104, r105, f277578j);
        r105.putInt(RemoteMessageConst.Notification.NOTIFY_ID, JsonUtil.getInt(r101, RemoteMessageConst.Notification.NOTIFY_ID, 0));
        return r105;
    }
}
