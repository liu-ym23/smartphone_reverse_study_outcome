package com.bytedance.notification.extra;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.sdk.m.k.b;
import com.huawei.hms.push.HmsMessageService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public class ProxyNotificationExtra implements Parcelable {
    public static final Parcelable.Creator<ProxyNotificationExtra> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f266028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f266029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f266030c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f266031d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f266032e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f266033f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public JSONObject f266034g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f266035h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f266036i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f266037j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f266038k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f266039l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public JSONObject f266040m;

    public static class a implements Parcelable.Creator<ProxyNotificationExtra> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ProxyNotificationExtra createFromParcel(Parcel r100) {
            return new ProxyNotificationExtra(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ProxyNotificationExtra[] newArray(int r100) {
            return new ProxyNotificationExtra[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public ProxyNotificationExtra(JSONObject r100) {
        this.f266028a = r100.toString();
        this.f266032e = r100.optBoolean("force_update_icon");
        this.f266029b = r100.optInt("origin_app", -1);
        this.f266030c = r100.optInt("target_app", -1);
        this.f266031d = r100.optInt("sender", -1);
        this.f266033f = r100.optString("icon_url");
        JSONObject r101 = r100.optJSONObject("extras");
        this.f266034g = r101;
        if (r101 != null) goto L5;
        this.f266034g = new JSONObject();
    L5:
        this.f266035h = r100.optString("target_pkg");
        this.f266036i = r100.optString("target_app_name");
        this.f266037j = r100.optString("pkg");
        this.f266038k = r100.optString("op_pkg");
        this.f266039l = r100.optInt(HmsMessageService.PROXY_TYPE, 0);
        this.f266040m = r100.optJSONObject(b.f25437z0);
    }

    public ProxyNotificationExtra(Parcel r100) {
        this.f266028a = r100.readString();
        boolean r101 = true;
        if (r100.readInt() == 1) goto L6;
        r101 = false;
    L6:
        this.f266032e = r101;
        this.f266033f = r100.readString();
        this.f266034g = new JSONObject(r100.readString());     // Catch: Throwable -> L9
    L11:
        this.f266035h = r100.readString();
        this.f266036i = r100.readString();
        this.f266037j = r100.readString();
        this.f266038k = r100.readString();
        this.f266029b = r100.readInt();
        this.f266030c = r100.readInt();
        this.f266031d = r100.readInt();
        return;
    L9:
        th = move-exception;
        th.printStackTrace();
        goto L11
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f266028a);
        r100.writeInt(this.f266032e ? 1 : 0);
        r100.writeString(this.f266033f);
        r100.writeString(this.f266034g.toString());
        r100.writeString(this.f266035h);
        r100.writeString(this.f266036i);
        r100.writeString(this.f266037j);
        r100.writeString(this.f266038k);
        r100.writeInt(this.f266029b);
        r100.writeInt(this.f266030c);
        r100.writeInt(this.f266031d);
    }
}
