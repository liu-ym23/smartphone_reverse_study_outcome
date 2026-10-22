package com.bytedance.ee.bear.route;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.util.Map;

/* JADX INFO: loaded from: classes18.dex */
public class RouteBean implements Parcelable {
    public static final Parcelable.Creator<RouteBean> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f236636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f236637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f236638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f236639d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bundle f236640e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f236641f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f236642g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f236643h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f236644i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f236645j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Map<String, String> f236646k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f236647l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f236648m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Bundle f236649n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f236650o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Fragment f236651p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public DestStyle f236652q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f236653r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f236654s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f236655t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f236656u;

    public static final enum DestStyle extends Enum<DestStyle> {
        public static final DestStyle FLOAT = null;
        public static final DestStyle FULL_SCREEN = null;
        public static final DestStyle NORMAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DestStyle[] f236657a = null;

        static {
            DestStyle r100 = new DestStyle(EffectConstants.NORMAL, 0);
            NORMAL = r100;
            DestStyle r101 = new DestStyle("FLOAT", 1);
            FLOAT = r101;
            DestStyle r102 = new DestStyle("FULL_SCREEN", 2);
            FULL_SCREEN = r102;
            f236657a = new DestStyle[]{r100, r101, r102};
        }

        public static DestStyle[] values() {
            return (DestStyle[]) f236657a.clone();
        }

        public static DestStyle valueOf(String r100) {
            return (DestStyle) r27.a.a(DestStyle.class, r100);
        }

        public DestStyle(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class a implements Parcelable.Creator<RouteBean> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final RouteBean createFromParcel(Parcel r100) {
            return new RouteBean(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final RouteBean[] newArray(int r100) {
            return new RouteBean[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public RouteBean() {
        this.f236636a = -1;
        this.f236637b = -1;
        this.f236638c = -1;
        this.f236646k = null;
        this.f236650o = !ExpandDocHelperForKA.a();
        this.f236652q = DestStyle.NORMAL;
        this.f236653r = false;
        this.f236654s = true;
        this.f236655t = false;
        this.f236656u = false;
    }

    public String getType() {
        return this.f236648m;
    }

    public RouteBean(Parcel r100) {
        this.f236636a = -1;
        this.f236637b = -1;
        this.f236638c = -1;
        this.f236646k = null;
        boolean r101 = true;
        this.f236650o = !ExpandDocHelperForKA.a();
        this.f236652q = DestStyle.NORMAL;
        this.f236653r = false;
        this.f236654s = true;
        this.f236655t = false;
        this.f236656u = false;
        this.f236636a = r100.readInt();
        this.f236637b = r100.readInt();
        this.f236638c = r100.readInt();
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.f236639d = r102;
        this.f236640e = r100.readBundle();
        this.f236641f = r100.readString();
        this.f236642g = r100.readString();
        this.f236643h = r100.readString();
        this.f236644i = r100.readString();
        this.f236647l = r100.readString();
        this.f236648m = r100.readString();
        this.f236649n = r100.readBundle();
        if (r100.readByte() != 0) goto L10;
        r101 = false;
    L10:
        this.f236650o = r101;
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void a(Fragment r100) {
        tt5.a.h("RouteBean", "setSourceFragment() called with: sourceFragment = [" + r100 + "]");
        this.f236651p = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.f236636a);
        r100.writeInt(this.f236637b);
        r100.writeInt(this.f236638c);
        r100.writeByte(this.f236639d ? 1 : 0);
        r100.writeBundle(this.f236640e);
        r100.writeString(this.f236641f);
        r100.writeString(this.f236642g);
        r100.writeString(this.f236643h);
        r100.writeString(this.f236644i);
        r100.writeString(this.f236647l);
        r100.writeString(this.f236648m);
        r100.writeBundle(this.f236649n);
        r100.writeByte(this.f236650o ? 1 : 0);
    }
}
