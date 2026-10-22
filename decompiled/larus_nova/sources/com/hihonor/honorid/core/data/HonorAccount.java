package com.hihonor.honorid.core.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;
import com.dtf.face.config.IConstValues;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.connect.common.Constants;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes23.dex */
public class HonorAccount implements Parcelable {
    public static final Parcelable.Creator<HonorAccount> CREATOR = null;
    public String A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f276539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f276540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f276541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f276542d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f276543e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f276544f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f276545g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f276546h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f276547i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f276548j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f276549k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f276550l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f276551m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f276552n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f276553o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f276554p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f276555q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f276556r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f276557s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f276558t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f276559u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f276560v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f276561w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f276562x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f276563y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f276564z;

    public class a implements Parcelable.Creator<HonorAccount> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final HonorAccount createFromParcel(Parcel r100) {
            HonorAccount r101 = new HonorAccount();
            r101.f276539a = r100.readString();
            r101.f276540b = r100.readString();
            r101.f276541c = r100.readString();
            r101.f276542d = r100.readString();
            r101.f276543e = r100.readString();
            r101.f276544f = r100.readInt();
            r101.f276545g = r100.readString();
            r101.f276546h = r100.readString();
            r101.f276547i = r100.readString();
            r101.f276548j = r100.readString();
            r101.f276549k = r100.readString();
            r101.f276550l = r100.readString();
            r101.f276551m = r100.readString();
            r101.f276552n = r100.readString();
            r101.f276553o = r100.readString();
            r101.f276554p = r100.readString();
            r101.f276555q = r100.readString();
            r101.f276556r = r100.readString();
            r101.f276557s = r100.readString();
            r101.f276558t = r100.readString();
            r101.f276559u = r100.readString();
            r101.f276560v = r100.readString();
            boolean r102 = true;
            if (r100.readByte() == 1) goto L6;
            r102 = false;
        L6:
            r101.f276563y = r102;
            r101.f276564z = r100.readString();
            r101.A = r100.readString();
            return r101;
        }

        @Override // android.os.Parcelable.Creator
        public final HonorAccount[] newArray(int r100) {
            return new HonorAccount[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "HonorAccount";
    }

    static {
        CREATOR = new a();
    }

    public HonorAccount() {
        this.f276539a = "-1";
        this.f276544f = 0;
        this.f276550l = "";
        this.f276562x = 0;
    }

    public final void a(Bundle r100) {
        this.f276539a = r100.getString("sL");
        this.f276540b = r100.getString("requestTokenType");
        this.f276541c = r100.getString("serviceToken");
        String r101 = r100.getString("accountName");
        if (TextUtils.isEmpty(r101) == false) goto L6;
        r101 = "";
    L11:
        this.f276542d = r101;
        this.f276543e = r100.getString("userId");
        this.f276544f = r100.getInt("siteId");
        this.f276545g = r100.getString("Cookie");
        this.f276546h = r100.getString("deviceId");
        this.f276547i = r100.getString("subDeviceId");
        this.f276548j = r100.getString(IConstValues.DEVICE_TYPE);
        this.f276549k = r100.getString("accountType");
        this.f276550l = r100.getString(UserInfo.LOGIN_USER_NAME);
        this.f276551m = r100.getString("countryIsoCode");
        this.f276552n = r100.getString("STValidStatus");
        this.f276553o = r100.getString(CommonConstant.KEY_SERVICE_COUNTRY_CODE);
        this.f276554p = r100.getString(ST.UUID_DEVICE);
        this.f276555q = r100.getString("as_server_domain");
        this.f276556r = r100.getString("cas_server_domain");
        this.f276561w = r100.getString("siteDomain");
        this.f276562x = r100.getInt(CommonConstant.KEY_HOME_ZONE, 0);
        this.f276557s = r100.getString("lastupdatetime");
        this.f276558t = r100.getString("access_token");
        this.f276559u = r100.getString("code");
        this.f276560v = r100.getString(Constants.JumpUrlConstants.URL_KEY_OPENID);
        this.f276563y = r100.getBoolean("isRealName");
        this.f276564z = r100.getString("union_id");
        this.A = r100.getString("id_token");
        return;
    L6:
        if (r101.contains("+86") == false) goto L9;
        r101 = r101.replace(Marker.ANY_NON_NULL_MARKER, CustomAlbumViewModel.DEFAULT_TAB_ID);
    L9:
        if (r101.startsWith("0086") == false) goto L11;
        r101 = r101.substring(4);
        goto L11
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f276539a);
        r100.writeString(this.f276540b);
        r100.writeString(this.f276541c);
        r100.writeString(this.f276542d);
        r100.writeString(this.f276543e);
        r100.writeInt(this.f276544f);
        r100.writeString(this.f276545g);
        r100.writeString(this.f276546h);
        r100.writeString(this.f276547i);
        r100.writeString(this.f276548j);
        r100.writeString(this.f276549k);
        r100.writeString(this.f276550l);
        r100.writeString(this.f276551m);
        r100.writeString(this.f276552n);
        r100.writeString(this.f276553o);
        r100.writeString(this.f276554p);
        r100.writeString(this.f276555q);
        r100.writeString(this.f276556r);
        r100.writeString(this.f276557s);
        r100.writeString(this.f276558t);
        r100.writeString(this.f276559u);
        r100.writeString(this.f276560v);
        r100.writeByte(this.f276563y ? 1 : 0);
        r100.writeString(this.f276564z);
        r100.writeString(this.A);
    }
}
